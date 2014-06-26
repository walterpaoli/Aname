package com.mvatari.aname.converter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomObjectMapper extends ObjectMapper{
	private static final long serialVersionUID = 7387977441785336744L;

	public CustomObjectMapper() {
//		super.configure(Feature.WRITE_DATES_AS_TIMESTAMPS, false);
//		setDateFormat(new SimpleDateFormat("ddMMyyyy HH:mm:ss"));
	}

}
