

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.springboot.App;
import com.springboot.Sender;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=App.class)
public class HelloApplicationTests {
	
	@Autowired
	private Sender sender;
	
	@Test
	public void hello() throws Exception{
		sender.send();
	}

}
