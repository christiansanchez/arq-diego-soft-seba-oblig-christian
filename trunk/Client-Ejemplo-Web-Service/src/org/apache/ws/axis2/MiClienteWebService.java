package org.apache.ws.axis2;

import org.apache.ws.axis2.MiWebServiceStub.Despedir;
import org.apache.ws.axis2.MiWebServiceStub.DespedirResponse;
import org.apache.ws.axis2.MiWebServiceStub.Saludar;
import org.apache.ws.axis2.MiWebServiceStub.SaludarResponse;

public class MiClienteWebService {

	public static void main(String[] args) throws Exception 
	{
		String url = "http://127.0.0.1:8080/axis2/services/" +
		"MiWebService.MiWebServiceHttpEndpoint/";
		MiWebServiceStub cliente = new MiWebServiceStub(url);
		Saludar reqSaludar = new Saludar();
		reqSaludar.setNombre("Sultano");
		SaludarResponse respSaludar = cliente.saludar(reqSaludar);
		System.out.println(respSaludar.get_return());
		Despedir reqDespedir = new Despedir();
		reqDespedir.setNombre("Sultano");
		DespedirResponse respDespedir = cliente.despedir(reqDespedir);
		System.out.println(respDespedir.get_return());
	}

}
