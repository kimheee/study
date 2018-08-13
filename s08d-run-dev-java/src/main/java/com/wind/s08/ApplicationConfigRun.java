package com.wind.s08;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("run")
public class ApplicationConfigRun {
	
	@Bean
	public ServerInfo serverInfo() {
		
		ServerInfo info = new ServerInfo();	
		info.setIpNum("");
		info.setPortNum("");
		
		return serverInfo();
	}
	

}
