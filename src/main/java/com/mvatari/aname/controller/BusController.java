package com.mvatari.aname.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvatari.aname.beans.Bus;

@Scope("request")
@Controller
public class BusController {
	private List<Bus> buses;
	// Constructor temporal para valores de prueba
	public BusController() {
		buses = new ArrayList<Bus>();
		Bus b = new Bus();
		b.setID(1L);
		b.setLineNumber(100);
		b.setName("Línea directa");
		b.setVehicleStops(null);
		
		buses.add(b);

		b = new Bus();
		b.setID(2L);
		b.setLineNumber(200);
		b.setName("Línea indirecta");
		b.setVehicleStops(null);
		
		buses.add(b);
	}
	@RequestMapping(value="/buses/{id}", method=RequestMethod.GET)
	public @ResponseBody List<Bus> getBuses(@PathVariable Long id, HttpServletResponse resp) {
		try {
			ArrayList<Bus> a = new ArrayList<Bus>();
			a.add(buses.get(id.intValue()));
			return a;
		} catch (IndexOutOfBoundsException ioobe) {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}

	@RequestMapping(value="/buses", method=RequestMethod.GET)
	public @ResponseBody List<Bus> getBuses() {
		return buses;
	}
	
	@RequestMapping(value="/hello")
	public @ResponseBody Map<String, Object> hello() {
		Bus b = new Bus();
		Map<String, Object> json = new HashMap<String, Object>();
		json.put("clave", "valor");
		json.put("importe", new BigDecimal(1500000));
		json.put("fecha", new Date(System.currentTimeMillis()));
		json.put("bus", b);
		return json;
	}
	
}
