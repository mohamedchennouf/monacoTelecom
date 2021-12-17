package com.monaco.consumer.functions;

import com.monaco.consumer.model.ServiceMonaco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Configuration
@Slf4j
public class Consumers {

	Map<String,ServiceMonaco> monacoServices = new HashMap<>();

	@Bean
	public Consumer<ServiceMonaco> rabbitConsumer() {
		return message -> {
			try {
				log.info("Consume {}", message);
				if(monacoServices.containsKey(message.getTag())){
					updateServiceMonaco(message);
					monacoServices.get(message.getTag()).setAction(message.getAction());
				}else{
					addNewServiceMonaco(message);
					monacoServices.put(message.getTag(),message);
				}
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		};
	}

	private static void updateServiceMonaco(ServiceMonaco serviceMonaco) throws URISyntaxException {
		final String url = "http://localhost:8080/services";
		URI uri = new URI(url);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(uri, serviceMonaco);
	}

	private static void addNewServiceMonaco(ServiceMonaco serviceMonaco) throws URISyntaxException {
		final String url = "http://localhost:8080/services";
		URI uri = new URI(url);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForEntity(uri, serviceMonaco,Boolean.class);
	}

}

