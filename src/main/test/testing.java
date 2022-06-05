import Entities.HmsUser;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class testing {

    static HmsUser user;

    @Test
    public void invalidUsernamePassword(){
        Assertions.assertEquals(user.logIn("No User","User"),"none");
    }

    @Test
    public void logInCheck(){
        Assertions.assertEquals(user.logIn("momitariq","1"),"isPatient");
        Assertions.assertEquals(user.logIn("aamnakamran_","123"),"isDoctor");
    }

    @Test
    public void userExists(){
        Assertions.assertEquals(user.retrieveUser("No User","User"),null);
    }

    @Test
    public void checkFirstName(){
        Assertions.assertEquals(user.retrieveUser("momitariq","1").getFirstName(),"Momin");
        Assertions.assertEquals(user.retrieveUser("aamnakamran_","123").getFirstName(),"Aamna");
    }

    @Test
    public void checkNameLength(){
        int length = user.retrieveUser("aamnakamran_","123").getFirstName().length();
        boolean check;
        if(length>0 && length<=20){
            check=true;
        }
        else{
            check=false;
        }
        Assertions.assertEquals(check,true);
    }

    @Test
    public void checkphNumberLength(){
        int length = user.retrieveUser("aamnakamran_","123").getPhoneNumber().length();
        boolean check;
        if(length>0 && length==11){
            check=true;
        }
        else{
            check=false;
        }
        Assertions.assertEquals(check,true);
    }

    @Test
    public void checkLastName(){
        Assertions.assertEquals(user.retrieveUser("momitariq","1").getLastName(),"Tariq");
        Assertions.assertEquals(user.retrieveUser("aamnakamran_","123").getLastName(),"Kamran");
    }


}
