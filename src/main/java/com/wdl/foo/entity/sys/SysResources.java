package com.wdl.foo.entity.sys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SysResources implements Serializable{
	private static final long serialVersionUID = -2351585029414550159L;
	private String id;
	private String parentId;
	private String name;
	private String url;
	private String resourcesType;
	private String remarks;
	private List<SysResources> resList=new ArrayList<SysResources>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getResourcesType() {
		return resourcesType;
	}
	public void setResourcesType(String resourcesType) {
		this.resourcesType = resourcesType;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public List<SysResources> getResList() {
		return resList;
	}
	public void setResList(List<SysResources> resList) {
		this.resList = resList;
	}
}
