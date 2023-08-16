/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package POE_RESUBMISSION;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


/**
 *
 * @author Ethan
 */
public class LoginTest {

    Login myLogin = new Login();

    @Test
    public void UsernameIsCorrectlyFormatted() {
        String[] uArray = {"vee_1", "Veeasha"};
        String[] pArray = {"Packs82!!", "Packs28!"};
        myLogin.setUser("vee_1");
        myLogin.setUsers(uArray);
        myLogin.setPassword("Packs82!");
        myLogin.setPasswords(pArray);

        String expected = "Welcome back " + myLogin.getMyFirstName() + ", " + myLogin.getMySurname() + " it is great to see you again.";

            
    }

    @Test
    public void UsernameIsIncorrectlyFormatted() {
        String[] uArray = {"vee_1", "Veeasha"};
        String[] pArray = {"Packs82!", "Packs28!"};
        myLogin.setUser("vee!!!!!!!");
        myLogin.setUsers(uArray);
        myLogin.setPassword("Packs82!");
        myLogin.setPasswords(pArray);

        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.", myLogin.returnLoginStatus("vee!!!!!!!"));
    }

    @Test
    public void PasswordMeetsComplexityRequirements() {
         String[] uArray = {"vee_1", "Veeasha"};
        String[] pArray = {"Packs82!", "Packs28!"};
        myLogin.setUser("vee!!!!!!!");
        myLogin.setUsers(uArray);
        myLogin.setPassword("Packs82!");
        myLogin.setPasswords(pArray);

        assertEquals("Password successfully captured", myLogin.registerUser("Packs82!"));
    }

    @Test
    public void PasswordDoesNotMeetComplexityRequirements() {
       String[] uArray = {"vee_1", "Veeasha"};
        String[] pArray = {"Packs82!", "Packs28!"};
        myLogin.setUser("vee!!!!!!!");
        myLogin.setUsers(uArray);
        myLogin.setPassword("password");
        myLogin.setPasswords(pArray);

        assertEquals("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.", myLogin.registerUser("password"));
    }

    @Test
    public void LoginSuccessful() {
        Login myLogin = new Login();
        String[] fNames = {"Bob"};
        String[] lNames = {"Smith"};
        String[] uNames = {"bob_1"};
        String[] pWords = {"Password678^"};

        myLogin.setMyFirstName("Bob");
        myLogin.setFirstNames(fNames);
        myLogin.setMySurname("Smith");
        myLogin.setSurnames(lNames);
        myLogin.setPassword("Password678^");
        myLogin.setPasswords(pWords);
        myLogin.setUser("bob_1");
        myLogin.setUsers(uNames);
        assertTrue(myLogin.loginUser());
    }

    @Test
    public void LoginFailed() {
        Login myLogin = new Login();
        String[] fNames = {"Bob"};
        String[] lNames = {"Smith"};
        String[] uNames = {"bob_1"};
        String[] pWords = {"Password678^"};

        myLogin.setMyFirstName("Bob");
        myLogin.setFirstNames(fNames);
        myLogin.setMySurname("Smith");
        myLogin.setSurnames(lNames);
        myLogin.setPassword("Password678");
        myLogin.setPasswords(pWords);
        myLogin.setUser("bob");
        myLogin.setUsers(uNames);

        assertFalse(myLogin.loginUser());
    }

    @Test
    public void UsernameCorrectlyFormatted() {
        myLogin.setUser("bob_1");
        assertTrue(myLogin.checkUserName());
    }

    @Test
    public void UsernameIncorrectlyFormatted() {
        myLogin.setUser("bob!!!!!");
        assertFalse(myLogin.checkUser());
    }

    @Test
    public void PasswordMeetsComplexityCheck() {
        myLogin.setUser("bob_1");
        assertTrue(myLogin.checkUser());
    }

    @Test
    public void PasswordDoesNotMeetComplexityCheck() {
        myLogin.setPassword("Password678");
        assertFalse(myLogin.checkPasswordComplexity());
    }
    
}