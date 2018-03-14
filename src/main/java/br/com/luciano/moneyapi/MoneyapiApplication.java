package br.com.luciano.moneyapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.luciano.moneyapi.config.property.MoneyApiProperty;
/**
 * 
 * @author Luciano Lima
 * 
 * A partir daqui as demais classes são escaneadas pelo Spring
 *
 */
@SpringBootApplication
@EnableConfigurationProperties(MoneyApiProperty.class)
public class MoneyapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoneyapiApplication.class, args);
	}
}
