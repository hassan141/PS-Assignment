public class BankAccount {
    private double balance;
    private final String accountNumber;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of EGP" + amount + " successful. New balance: EGP" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of EGP" + amount + " successful. New balance: EGP" + balance);
        } else if (amount > balance) {
            throw new InsufficientFundsException("Withdrawal amount exceeds current balance.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount("123456", 1000.0);
        System.out.println("Account Number: " + myAccount.getAccountNumber());
        System.out.println("Initial Balance: EGP" + myAccount.getBalance());

        myAccount.deposit(500.0);
        try {
            myAccount.withdraw(200.0);
            myAccount.withdraw(1500.0); // This will throw InsufficientFundsException
        } catch (InsufficientFundsException e) {
            System.err.println("Error: " + e.getMessage());
        }

        System.out.println("Final Balance: EGP" + myAccount.getBalance());
    }
}


class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}