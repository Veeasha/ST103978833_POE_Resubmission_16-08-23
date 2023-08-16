/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package POE_RESUBMISSION;


import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


/**
 *
 * @author Ethan
 */
public class LoginTest {

    Login myLogin = new Login();

    @Test
    public void UsernameIsCorrectlyFormatted() {
        String[] uArray = {"vee_1", "Veeasha"};
        String[] pArray = {"Password123#", "Password321#"};
        myLogin.setUserName("vee_1");
        myLogin.setUsernames(uArray);
        myLogin.setPassword("Password123#");
        myLogin.setPasswords(pArray);

        String expected = "Welcome back " + myLogin.getMyFirstName() + ", " + myLogin.getMySurname() + " it is great to see you again.";
        String actual = myLogin.returnLoginStatus("vee_1");

            
    }

    @Test
    public void UsernameIsIncorrectlyFormatted() {
        String[] uArray = {"vee_1", "Veeasha"};
        String[] pArray = {"Password123#", "Password321#"};
        myLogin.setUserName("vee!!!!!!!");
        myLogin.setUsernames(uArray);
        myLogin.setPassword("Password123#");
        myLogin.setPasswords(pArray);

        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.", myLogin.returnLoginStatus("vee!!!!!!!"));
    }

    @Test
    public void PasswordMeetsComplexityRequirements() {
        String[] uArray = {"vee_1", "Veeasha"};
        String[] pArray = {"Password123#", "Password321#"};
        myLogin.setUserName("vee!!!!!!!");
        myLogin.setUsernames(uArray);
        myLogin.setPassword("Ch&&sec@ke99!");
        myLogin.setPasswords(pArray);

        assertEquals("Password successfully captured", myLogin.registerUser("Ch&&sec@ke99!"));
    }

    @Test
    public void PasswordDoesNotMeetComplexityRequirements() {
        String[] uArray = {"kyl_1", "Ethan"};
        String[] pArray = {"Password123#", "Password321#"};
        myLogin.setUserName("kyle!!!!!!!");
        myLogin.setUsernames(uArray);
        myLogin.setPassword("password");
        myLogin.setPasswords(pArray);

        assertEquals("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.", myLogin.registerUser("password"));
    }

    @Test
    public void LoginSuccessful() {
        Login myLogin = new Login();
        String[] fNames = {"Bob"};
        String[] lNames = {"Dylan"};
        String[] uNames = {"bob_1"};
        String[] pWords = {"Password678^"};

        myLogin.setMyFirstName("Bob");
        myLogin.setFirstNames(fNames);
        myLogin.setMySurname("Dylan");
        myLogin.setSurnames(lNames);
        myLogin.setPassword("Password678^");
        myLogin.setPasswords(pWords);
        myLogin.setUserName("bob_1");
        myLogin.setUsernames(uNames);
        assertTrue(myLogin.loginUser());
    }

    @Test
    public void LoginFailed() {
        Login myLogin = new Login();
        String[] fNames = {"Bob"};
        String[] lNames = {"Dylan"};
        String[] uNames = {"bob_1"};
        String[] pWords = {"Password678^"};

        myLogin.setMyFirstName("Bob");
        myLogin.setFirstNames(fNames);
        myLogin.setMySurname("Dylan");
        myLogin.setSurnames(lNames);
        myLogin.setPassword("Password678");
        myLogin.setPasswords(pWords);
        myLogin.setUserName("bob");
        myLogin.setUsernames(uNames);

        assertFalse(myLogin.loginUser());
    }

    @Test
    public void UsernameCorrectlyFormatted() {
        myLogin.setUserName("bob_1");
        assertTrue(myLogin.checkUserName());
    }

    @Test
    public void UsernameIncorrectlyFormatted() {
        myLogin.setUserName("vee!!!!!");
        assertFalse(myLogin.checkUserName());
    }

    @Test
    public void PasswordMeetsComplexityCheck() {
        myLogin.setUserName("bob_1");
        assertTrue(myLogin.checkUserName());
    }

    @Test
    public void PasswordDoesNotMeetComplexityCheck() {
        myLogin.setPassword("Password678");
        assertFalse(myLogin.checkPasswordComplexity());
    }
    
}