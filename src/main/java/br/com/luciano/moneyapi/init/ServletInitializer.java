package br.com.luciano.moneyapi.init;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import br.com.luciano.moneyapi.MoneyapiApplication;

/**
 * 
 * @author Luciano Lima
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MoneyapiApplication.class);
	}

}
