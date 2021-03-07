package br.com.kyouma54;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@EnableEurekaServer
public class EurekaRegistryApplication {
	private static final Logger log = LoggerFactory.getLogger(EurekaRegistryApplication.class);

	private final Environment environment;

	public EurekaRegistryApplication(Environment environment) {
		this.environment = environment;
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(EurekaRegistryApplication.class);
		Environment env = app.run(args).getEnvironment();
		logApplication(env);
	}

	@Configuration
	public static class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().anyRequest().permitAll()
					.and().csrf().disable();
		}
	}

	private static void logApplication(Environment env) {
		log.info(
				"\n----------------------------------------------------------\n\t"
						+ "Application '{}' is running! Access URLs:\n\t"
						+ "Local: \t\t{}://localhost:{}{}\n\t"
						+ "External: \t{}://{}:{}{}\n\t"
						+ "Profile(s): \t{}\n----------------------------------------------------------",
				env.getProperty("spring.application.name"),
				getProtocol(env),
				env.getProperty("server.port"),
				getContextPath(env),
				getProtocol(env),
				getHostAddress(),
				env.getProperty("server.port"),
				getContextPath(env),
				env.getActiveProfiles());
	}

	private static String getHostAddress() {
		String hostAddress = "localhost";

		try {
			hostAddress = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			log.warn("The host name could not be determined, using `localhost` as fallback", e);
		}
		return hostAddress;
	}

	private static String getContextPath(Environment env) {
		String contextPath = env.getProperty("server.servlet.context-path");
		if (StringUtils.isEmpty(contextPath)) {
			contextPath = "/";
		}
		return contextPath;
	}

	private static String getProtocol(Environment env) {
		String protocol = "http";
		if (env.getProperty("server.ssl.key-store") != null) {
			protocol = "https";
		}
		return protocol;
	}

}
