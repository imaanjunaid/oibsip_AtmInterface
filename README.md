# ATM System

A simple command-line ATM system in Java that allows users to register, log in, and perform basic banking operations like withdrawing, depositing, transferring funds, and viewing transaction history.

## Features

- **User Registration**: Users can register by providing their name and a PIN.
- **User Login**: Registered users can log in with their credentials.
- **Withdraw Funds**: Users can withdraw money from their account.
- **Deposit Funds**: Users can deposit money into their account.
- **Transfer Funds**: Users can transfer money to another account by entering the account number.
- **View Transaction History**: Users can view their transaction history.

## Key Methods

- **registerNewUser()**: Registers a new user by prompting for their full name and PIN.
- **loginUser()**: Authenticates the user by verifying their name and PIN against registered credentials.
- **withdrawFunds()**: Allows the user to withdraw a specified amount if sufficient funds are available.
- **depositFunds()**: Allows the user to deposit a specified amount into their account.
- **transferFunds()**: Facilitates transferring a specified amount to another account, verifying the account number and available balance.
- **showTransactionHistory()**: Displays the user's transaction history, listing all deposits and withdrawals.
- **showMenu()**: Displays the ATM menu and handles user selections for available actions.

### User Class Methods
- **getName()**: Returns the username of the user.
- **getPin()**: Returns the PIN of the user.
- **getBalance()**: Returns the current balance of the user.
- **updateBalance()**: Updates the user's balance by adding the specified amount.
