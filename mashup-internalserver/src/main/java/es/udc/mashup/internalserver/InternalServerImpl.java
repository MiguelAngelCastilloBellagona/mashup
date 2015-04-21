package es.udc.mashup.internalserver;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name = "StockQuoteProvider", serviceName = "InternalServer", targetNamespace = "http://ws.adoo.udc.es/")
public class InternalServerImpl {
	private String message = new String("Hola, ");

	public void Hello() {
	}

	@WebMethod(operationName="getHola")
	public String sayHello(String name) {
		return message + name + ".";
	}

}
