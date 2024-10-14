import org.example.account.AccountManager;
import org.example.account.AccountManagerImpl;
import org.example.account.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountServiceTest {

    @Test
    public void givenPositiveCustomerBalance_whenDeposit_thenBalanceIncreases() {
        // Arrange
        AccountManager accountManager = new AccountManagerImpl();
        Customer customer = new Customer();
        customer.setBalance(100);
        int depositAmount = 200;

        // Act
        accountManager.deposit(customer, depositAmount);

        // Assert
        assertEquals(300, customer.getBalance());
    }

    @Test
    public void givenPositiveCustomerBalance_whenWithdrawWithinLimit_thenBalanceDecreases() {
        // Arrange
        AccountManager accountManager = new AccountManagerImpl();
        Customer customer = new Customer();
        customer.setBalance(500);
        int withdrawAmount = 300;

        // Act
        accountManager.withdraw(customer, withdrawAmount);

        // Assert
        assertEquals(200, customer.getBalance());
    }

    @Test
    public void givenPositiveCustomerBalanceWithVipAndCreditAllowed_whenWithdrawExceedingBalance_thenWithdrawSuccess() {
        // Arrange
        AccountManager accountManager = new AccountManagerImpl();
        Customer customer = new Customer();
        customer.setBalance(500);
        customer.setVip(true);
        customer.setCreditAllowed(true);
        int withdrawAmount = 1800;

        // Act
        String result = accountManager.withdraw(customer, withdrawAmount);

        // Assert
        assertEquals("success", result);
    }

    @Test
    public void givenPositiveCustomerBalanceWithoutCreditAllowed_whenWithdrawExceedingBalance_thenInsufficientBalance() {
        // Arrange
        AccountManager accountManager = new AccountManagerImpl();
        Customer customer = new Customer();
        customer.setBalance(500);
        customer.setCreditAllowed(false);
        int withdrawAmount = 600;

        // Act
        String result = accountManager.withdraw(customer, withdrawAmount);

        // Assert
        assertEquals("insufficient account balance", result);
    }

    @Test
    public void givenPositiveCustomerBalanceWithoutVipButWithCreditAllowed_whenWithdrawExceedingBalance_thenMaximumCreditExceeded() {
        // Arrange
        AccountManager accountManager = new AccountManagerImpl();
        Customer customer = new Customer();
        customer.setBalance(500);
        customer.setVip(false);
        customer.setCreditAllowed(true);
        int withdrawAmount = 1800;

        // Act
        String result = accountManager.withdraw(customer, withdrawAmount);

        // Assert
        assertEquals("maximum credit exceeded", result);
    }
}
