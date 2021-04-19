package br.com.fiap.apimanager.routing;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingHandlerComfig {

	public static final String ESTABELECIMENTO = "http://localhost:8081/";
	public static final String ESTOQUE = "http://localhost:8082/";
	public static final String PEDIDO = "http://localhost:8083/";
	public static final String PAGEMENTO = "http://localhost:8084/";

	@Bean
	public RouteLocator customRouteLocation(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/ms-estabelecimento/**")
						.filters(f -> f.rewritePath("/ms-estabelecimento/(?<remains>.*)", "/${remains}"))
						.uri(ESTABELECIMENTO))
				.route(r -> r.path("/ms-estoque/**")
						.filters(f -> f.rewritePath("/ms-estoque/(?<remains>.*)", "/${remains}")).uri(ESTOQUE))
				.route(r -> r.path("/ms-pedido/**")
						.filters(f -> f.rewritePath("/ms-pedido/(?<remains>.*)", "/${remains}")).uri(PEDIDO))
				.route(r -> r.path("/ms-pagamento/**")
						.filters(f -> f.rewritePath("/ms-pagamento/(?<remains>.*)", "/${remains}")).uri(PAGEMENTO))
				.build();
	}

}
