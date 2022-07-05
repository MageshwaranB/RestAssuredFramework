package com.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MultiUsers
{
	private int page;
	
	@JsonProperty("per_page")
	private int perPage;
	private int total;
	
	@JsonProperty("total_pages")
	private int totalPages;
	
	private List<Data> data;

	private Support support;
	
	 
}
