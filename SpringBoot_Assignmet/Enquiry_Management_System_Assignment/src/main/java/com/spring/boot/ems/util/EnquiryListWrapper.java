

package com.spring.boot.ems.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.spring.boot.ems.model.Enquiry;

/*
 * Main enquiry list view, helper object
 */

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EnquiryListWrapper {
	
	List<Enquiry> enquiryList;
	String sortBy;
	String sortType;
	
	public EnquiryListWrapper() {
		enquiryList = new ArrayList<>();
		sortBy = "";
		sortType = "";
	}

	public List<Enquiry> getEnquiryList() {
		return enquiryList;
	}

	public void setEnquiryList(List<Enquiry> enquiryList) {
		this.enquiryList = enquiryList;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	
	

}
