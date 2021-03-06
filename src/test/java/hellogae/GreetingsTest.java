/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hellogae;

import com.google.api.server.spi.response.NotFoundException;
import com.google.appengine.api.users.User;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author valik
 */
public class GreetingsTest {
    @Test
    public void getGreeting() throws Exception {
       Greetings greetings = new Greetings();
       HelloGreeting helloGreeting0 = greetings.getGreeting(0);
       assertEquals("hello world!", helloGreeting0.getMessage());
       HelloGreeting helloGreeting1 = greetings.getGreeting(1);
       assertEquals("goodbye world!", helloGreeting1.getMessage());
    }
    
    @Test(expected = NotFoundException.class)
    public void getGreetingException() throws Exception {
       Greetings greetings = new Greetings();
       greetings.getGreeting(2);
    }
    
    @Test
    public void listGreeting() {
       Greetings greetings = new Greetings();
       ArrayList<HelloGreeting> helloGreetings = greetings.listGreeting();
       assertEquals(2, helloGreetings.size());
       assertEquals("hello world!", helloGreetings.get(0).getMessage());
       assertEquals("goodbye world!", helloGreetings.get(1).getMessage());
    }
    
    @Test
    public void insertGreeting() {
       HelloGreeting helloGreeting = new HelloGreeting("Test");
       Greetings greetings = new Greetings();
       HelloGreeting resultHelloGreeting = greetings.insertGreeting(2, helloGreeting);
       assertEquals("TestTest", resultHelloGreeting.getMessage());
    }
    
    @Test
    public void authedGreeting() {
        Greetings greetings = new Greetings();
        User user = new User("email@test.com", "test.com");
        HelloGreeting helloGreeting = greetings.authedGreeting(user);
        assertEquals("hello email@test.com", helloGreeting.getMessage());
    }

}
