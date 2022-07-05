package com.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SingleUser
{
	private int page;
	
	@JsonProperty("per_page")
	private int perPage;
	private int total;
	
	@JsonProperty("total_pages")
	private int totalPages;
	
	private Data data;
	private Support support;
	
	 
}
