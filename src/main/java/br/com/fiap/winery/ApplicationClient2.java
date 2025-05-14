package br.com.fiap.winery;

import jakarta.xml.ws.Service;

import javax.xml.namespace.QName;
import java.net.URL;

public class ApplicationClient2 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8085/WineStockService?wsdl");
        QName qName = new QName("http://winery.fiap.com.br/", "WineStockServiceImplementationService");
        Service service = Service.create(url, qName);
        WineStockService wineStockService = service.getPort(WineStockService.class);

        URL url2 = new URL("http://localhost:8086/WineWarningService?wsdl");
        QName qName2 = new QName("http://winery.fiap.com.br/", "WineWarningServiceImplementationService");
        Service service2 = Service.create(url2, qName2);
        WineWarningService wineWarningService = service2.getPort(WineWarningService.class);

        String order = wineStockService.placeOrder("Merlot", 2);
        String warn = wineWarningService.sendWarn();

        System.out.println("Resultado do pedido: " + order);
        System.out.println("Atenção: " + warn);
    }
}
