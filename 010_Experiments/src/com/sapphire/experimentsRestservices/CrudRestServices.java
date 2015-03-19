package com.sapphire.experimentsRestservices;


import java.util.HashMap;
import java.util.List;








import com.sapphire.experimentshibernate.*;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.Form;

@Path("/Crud")
public class CrudRestServices {

	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public HashMap<String, Object> list(){
		
			//CustomerDAO customerDAO= new CustomerDAO();
	
			List<Customer> list=CustomerDAO.SelectAll();
			HashMap<String, Object> output=new HashMap<String, Object>();
			output.put("Records", list);
			output.put("Result", "OK");
			output.put("TotalRecordCount", list.size());
			return output;
	}
	
	@Path("/delete")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public HashMap<String, Object>  delete(@FormParam("customerId") int customerId){
		
		System.out.println(customerId);
		CustomerDAO.delete(customerId);
		System.out.println("ok");
		return this.list();

	}
	
	@Path("/update")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public HashMap<String, Object> update(@FormParam("customerId")int customerId,@FormParam("customerName")String customerName,@FormParam("customerEmail") String customerEmail){
		CustomerDAO.update(customerId,customerName,customerEmail);
		return this.list();
	}
	
	@Path("/create")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public HashMap<String, Object> create(@FormParam("customerName") String customerName, @FormParam("customerEmail") String customerEmail){
		System.out.println(customerName + customerEmail);
		CustomerDAO.create(customerName,customerEmail);
		return this.list();
	}
}
