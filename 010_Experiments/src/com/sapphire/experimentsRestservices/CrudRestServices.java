package com.sapphire.experimentsRestservices;


import java.util.HashMap;
import java.util.List;




import com.sapphire.experimentshibernate.*;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Crud")

public class CrudRestServices {

	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public HashMap<String, Object> list(){
		
			//CustomerDAO customerDAO= new CustomerDAO();
	
			List<Customer> list=CustomerDAO.SelectAll();
			HashMap<String, Object> output=new HashMap<String, Object>();
			output.put("Recordkls", list);
			output.put("Result", "OK");
			output.put("TotalRecordCount", list.size());
			return output;
			
	}
	
	@Path("/Delete")
	@POST
	public String delete(int customerId){
		
		return null;
		
	}
}
