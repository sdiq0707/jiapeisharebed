package com.woniu.entity;

public class Hospitaladministrative extends HospitaladministrativeKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hospitaladministrative.fk_id
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
	private Hospital hospital;
	
    public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	
	private Administrative administrative;
	
	public Administrative getAdministrative() {
		return administrative;
	}

	public void setAdministrative(Administrative administrative) {
		this.administrative = administrative;
	}

	private String fkId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hospitaladministrative.fk_id
     *
     * @return the value of hospitaladministrative.fk_id
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public String getFkId() {
        return fkId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hospitaladministrative.fk_id
     *
     * @param fkId the value for hospitaladministrative.fk_id
     *
     * @mbggenerated Mon Aug 19 15:25:36 CST 2019
     */
    public void setFkId(String fkId) {
        this.fkId = fkId;
    }
}