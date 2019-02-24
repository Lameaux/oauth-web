package com.euromoby.oauth;

import com.euromoby.oauth.controllers.IndexController;
import com.euromoby.oauth.controllers.RegisterController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OauthApplicationTests {

	@Autowired
	private IndexController indexController;

	@Autowired
	private RegisterController registerController;

	@Test
	public void contextLoads() {
		assertThat(indexController).isNotNull();
		assertThat(registerController).isNotNull();
	}

}
