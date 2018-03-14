package br.com.luciano.moneyapi.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 
 * @author Luciano Lima
 *
 */
@ConfigurationProperties("money")
public class MoneyApiProperty {
	
	private final Seguranca seguranca = new Seguranca();	
	
	public static class Seguranca {
		
		private boolean enableHttps;

		public boolean isEnableHttps() {
			return enableHttps;
		}

		public void setEnableHttps(boolean enableHttps) {
			this.enableHttps = enableHttps;
		}
		
	}

	public Seguranca getSeguranca() {
		return seguranca;
	}

}
