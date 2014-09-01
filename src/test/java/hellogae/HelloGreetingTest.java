/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hellogae;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author valik
 */
public class HelloGreetingTest {
    @Test
    public void create() {
       new HelloGreeting("Test"); 
    }
    
    @Test
    public void get() {
       HelloGreeting helloGreeting = new HelloGreeting("Test");
       assertEquals("Test", helloGreeting.getMessage());
    }
    
    @Test
    public void set() {
       HelloGreeting helloGreeting = new HelloGreeting("Test");
       helloGreeting.setMessage("Test2");
       assertEquals("Test2", helloGreeting.getMessage());
    }

}
