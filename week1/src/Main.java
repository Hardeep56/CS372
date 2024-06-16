
public class Main {
    public static void main(String[] args) {
        // Create a new BankAccount object
        BankAccount account = new BankAccount();
        
        // Set the account details
        account.setFirstName("John");
        account.setLastName("Doe");
        account.setAccountID(12345);
        
        // Perform some transactions
        account.deposit(1000.00);
        account.withdrawal(250.00);
        account.deposit(500.00);
        account.withdrawal(300.00);
        
        // Print the account summary
        account.accountSummary();
    }
}
