package com.spring.testing.init.springconcepts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringconceptsApplication {
//
//	@Bean
//	public CommonsRequestLoggingFilter logFilter() {
//		CommonsRequestLoggingFilter filter
//				= new CommonsRequestLoggingFilter();
//		filter.setIncludeQueryString(true);
//		filter.setIncludePayload(true);
//		filter.setMaxPayloadLength(10000);
//		filter.setIncludeHeaders(true);
//		filter.setAfterMessagePrefix("REQUEST DATA : ");
//		return filter;
//	}

	@Bean
	public RestTemplate restTemplate() {

		RestTemplate restTemplate = new RestTemplate();
//		RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
//		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
//		interceptors.add(new LoggingRequestInterceptor());
//		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}
//
//	@Bean
//	public CommonsRequestLoggingFilter requestLoggingFilter() {
//		CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
//		loggingFilter.setIncludeClientInfo(true);
//		loggingFilter.setIncludeQueryString(true);
//		loggingFilter.setIncludePayload(true);
//		loggingFilter.setMaxPayloadLength(64000);
//		return loggingFilter;
//	}

	@Bean
	public HttpTraceRepository htttpTraceRepository()
	{
		return new InMemoryHttpTraceRepository();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringconceptsApplication.class, args);
	}

}
