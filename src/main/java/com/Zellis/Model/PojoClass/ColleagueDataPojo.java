package com.Zellis.Model.PojoClass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ColleagueDataPojo {

	private String colleagueUUID;
	private String employeeId;
	private Integer hcmid; // from externalSystems.hcm.id
	private String salaryFrequency; // from workRelationships[0].salaryFrequency

	public String getColleagueUUID() {
		return colleagueUUID;
	}

	public void setColleagueUUID(String colleagueUUID) {
		this.colleagueUUID = colleagueUUID;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getHcmid() {
		return hcmid;
	}

	public void setHcmid(Integer hcmid) {
		this.hcmid = hcmid;
	}

	public String getSalaryFrequency() {
		return salaryFrequency;
	}

	public void setSalaryFrequency(String salaryFrequency) {
		this.salaryFrequency = salaryFrequency;
	}

	@Override
	public String toString() {
		return "Colleague {" + "colleagueUUID='" + colleagueUUID + '\'' + ", employeeId='" + employeeId + '\''
				+ ", hcmid=" + hcmid + ", salaryFrequency='" + salaryFrequency + '\'' + '}';
	}

}
