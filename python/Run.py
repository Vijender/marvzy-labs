
print("Run - Python - Run")

from IPython.display import display

import yfinance as yf
import pandas as pd
from datetime import datetime, timedelta
import matplotlib.pyplot as plt

# Define the list of tickers to analyze
tickers = ['TSLA', 'NVDA', 'ORCL', 'GOOGL', 'AAPL', 'PLTR', 'CMG', 'ADBE', 'INTC', 'COIN', 'AMD', 'QQQ', 'TQQQ', 'SQQQ']

for ticker in tickers:
    print(f"Analyzing ticker: {ticker}")

for ticker in tickers:
    print(f"Analyzing ticker: {ticker}")
    stock_data = yf.download(ticker, period='2y')
    print(f"Downloaded data for {ticker}")

all_signals = []

for ticker in tickers:
    print(f"Analyzing ticker: {ticker}")
    stock_data = yf.download(ticker, period='2y')
    stock_data['MA15'] = stock_data['Close'].rolling(window=15).mean()
    stock_data['MA30'] = stock_data['Close'].rolling(window=30).mean()
    stock_data['MA50'] = stock_data['Close'].rolling(window=50).mean()
    stock_data['MA90'] = stock_data['Close'].rolling(window=90).mean()
    stock_data['MA150'] = stock_data['Close'].rolling(window=150).mean()
    stock_data['MA250'] = stock_data['Close'].rolling(window=250).mean()

    # Generate trading signals
    stock_data['Signal'] = 0
    stock_data.loc[stock_data['MA50'] > stock_data['MA250'], 'Signal'] = 1  # Buy
    stock_data.loc[stock_data['MA50'] < stock_data['MA250'], 'Signal'] = -1 # Sell
    print(f"Downloaded data, calculated moving averages, and generated signals for {ticker}")

    # Get the last 3 days of data for the current ticker
    last_3_days = stock_data[['Close', 'MA50', 'MA250', 'Signal']].tail(2)

    # Add ticker and date to the data and append to the list
    for index, row in last_3_days.iterrows():
        all_signals.append({
            'Ticker': ticker,
            'Date': index.strftime('%Y-%m-%d'), # Format date as string
            'Close': row['Close'].item(), # Extract the scalar value
            'MA50': row['MA50'].item(), # Extract the scalar value
            'MA250': row['MA250'].item(), # Extract the scalar value
            'Signal': row['Signal'].item() # Extract the scalar value
        })

# Create a DataFrame from the collected signals
signals_df = pd.DataFrame(all_signals)

# Display the DataFrame
display(signals_df)

# Specify the path to your Google Drive folder
drive_path = '/content/drive/MyDrive/stock1/results/'

# Create the directory if it doesn't exist
import os
os.makedirs(drive_path, exist_ok=True)

# Save the DataFrame to the specified path
signals_df.to_csv(drive_path + 'stock_signals.csv', index=False)

print(f"DataFrame saved to {drive_path}stock_signals.csv")