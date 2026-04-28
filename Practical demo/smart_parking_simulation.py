import requests
import time

# --- Configuration ---
WRITE_API_KEY = "1B49XND0GIKL440D"  # Replace with your actual key
BASE_URL = "https://api.thingspeak.com/update"

# The specific sequence of 17 points to match your chart
# 150 = Vacant (0), 30 = Occupied (1)
distance_sequence = [152, 30, 30, 150, 150, 30, 30, 150, 30, 30, 30, 150, 30, 30, 150, 30, 30]

print(f"{'Point':<6} | {'Distance':<10} | {'Status':<12} | {'API Response'}")
print("-" * 50)

for i, dist in enumerate(distance_sequence, 1):
    # Threshold Logic [cite: 51, 66]
    status = 1 if dist < 50 else 0
    status_label = "Occupied" if status == 1 else "Vacant"
    
    # HTTP Parameters [cite: 64]
    params = {
        'api_key': WRITE_API_KEY,
        'field1': dist,
        'field2': status
    }
    
    try:
        # Sending data via HTTP REST [cite: 74, 78]
        response = requests.get(BASE_URL, params=params)
        
        if response.status_code == 200:
            api_result = f"Success (ID: {response.text})"
        else:
            api_result = f"Error ({response.status_code})"
            
    except Exception as e:
        api_result = f"Failed: {e}"

    # Print results to terminal to build your table
    print(f"{i:<6} | {dist:<8} cm | {status_label:<12} | {api_result}")
    
    # Delay to respect ThingSpeak's rate limit (15-20 seconds)
    if i < 17:
        time.sleep(20)

print("-" * 50)
print("Simulation of 17 points complete.")