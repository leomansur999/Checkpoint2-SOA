package br.com.fiap.winery;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface WineStockService {

    @WebMethod
    String getMenu();

    @WebMethod
    String placeOrder(String name, int quantity);
}
