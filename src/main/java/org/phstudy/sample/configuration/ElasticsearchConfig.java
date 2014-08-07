package org.phstudy.sample.configuration;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

import java.io.IOException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "org.phstudy.sample.repository")
public class ElasticsearchConfig {
	@Bean
	ElasticsearchOperations elasticsearchTemplate() throws IOException {

		// transport client
		Settings settings = ImmutableSettings.settingsBuilder()
		        .put("cluster.name", "elasticsearch")
		        .put("username","myname")
		        .put("password","mypassword").build();
		        
		 Client client = new TransportClient(settings)
	        .addTransportAddress(new InetSocketTransportAddress("192.168.73.186", 9300));
		 
		 return new ElasticsearchTemplate(client);

		// node client
		//		return new ElasticsearchTemplate(nodeBuilder()
		//				.local(true)
		//				.settings(
		//						ImmutableSettings.settingsBuilder()
		//								.put("cluster.name", "elasticsearch")
		//								.put("username", "myname")
		//								.put("password", "mypassword").build()).node()
		//				.client());
	}
}