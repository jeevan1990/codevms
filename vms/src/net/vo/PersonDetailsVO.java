package net.vo;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

import net.constant.VisitorManagementConstants;

public class PersonDetailsVO implements SQLData {
	
	int personId;
	String firstName;
	String middleName;
	String lastName;
	String dateOfBirth;
	String address;
	String vehicleNumber;
	String visitorType;
	String addressProofType;
	String rank;
	String officerId;
	String dependentId;
	String dependentOfficerId;
	String relation;
	String personToMeet;
	String vendorId;
	String vendorName;
	String vendorAddress;
	String contractorId;
	String contractorName;
	String contractorAddress;
	
	
	@Override
	public String getSQLTypeName() throws SQLException {
		// TODO Auto-generated method stub
		return VisitorManagementConstants.PERSON_OBJECT;
	}

	
	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getVehicleNumber() {
		return vehicleNumber;
	}


	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}


	public String getVisitorType() {
		return visitorType;
	}


	public void setVisitorType(String visitorType) {
		this.visitorType = visitorType;
	}


	public String getAddressProofType() {
		return addressProofType;
	}


	public void setAddressProofType(String addressProofType) {
		this.addressProofType = addressProofType;
	}

	
	
	public String getRank() {
		return rank;
	}


	public void setRank(String rank) {
		this.rank = rank;
	}


	public String getOfficerId() {
		return officerId;
	}


	public void setOfficerId(String officerId) {
		this.officerId = officerId;
	}


	public String getDependentId() {
		return dependentId;
	}


	public void setDependentId(String dependentId) {
		this.dependentId = dependentId;
	}


	public String getDependentOfficerId() {
		return dependentOfficerId;
	}


	public void setDependentOfficerId(String dependentOfficerId) {
		this.dependentOfficerId = dependentOfficerId;
	}


	public String getRelation() {
		return relation;
	}


	public void setRelation(String relation) {
		this.relation = relation;
	}


	public String getPersonToMeet() {
		return personToMeet;
	}


	public void setPersonToMeet(String personToMeet) {
		this.personToMeet = personToMeet;
	}


	public String getVendorId() {
		return vendorId;
	}


	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}


	public String getVendorName() {
		return vendorName;
	}


	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}


	public String getVendorAddress() {
		return vendorAddress;
	}


	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}


	public String getContractorId() {
		return contractorId;
	}


	public void setContractorId(String contractorId) {
		this.contractorId = contractorId;
	}


	public String getContractorName() {
		return contractorName;
	}


	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}


	public String getContractorAddress() {
		return contractorAddress;
	}


	public void setContractorAddress(String contractorAddress) {
		this.contractorAddress = contractorAddress;
	}


	@Override
	public void readSQL(SQLInput stream, String typeName) throws SQLException {
		// TODO Auto-generated method stub
		setPersonId(stream.readInt());
		setFirstName(stream.readString());
		setMiddleName(stream.readString());
		setLastName(stream.readString());
		setDateOfBirth(stream.readString());
		setAddress(stream.readString());
		setVehicleNumber(stream.readString());
		setVisitorType(stream.readString());
		setAddressProofType(stream.readString());
		setRank(stream.readString());
		setOfficerId(stream.readString());
		setDependentId(stream.readString());
		setDependentOfficerId(stream.readString());
		setRelation(stream.readString());
		setPersonToMeet(stream.readString());
		setVendorId(stream.readString());
		setVendorName(stream.readString());
		setVendorAddress(stream.readString());
		setContractorId(stream.readString());
		setContractorName(stream.readString());
		setContractorAddress(stream.readString());
		
	}

	@Override
	public void writeSQL(SQLOutput stream) throws SQLException {
		// TODO Auto-generated method stub
		stream.writeInt(getPersonId());
		stream.writeString(getFirstName());
		stream.writeString(getMiddleName());
		stream.writeString(getLastName());
		stream.writeString(getDateOfBirth());
		stream.writeString(getAddress());
		stream.writeString(getVehicleNumber());
		stream.writeString(getVisitorType());
		stream.writeString(getAddressProofType());
		stream.writeString(getRank());
		stream.writeString(getOfficerId());
		stream.writeString(getDependentId());
		stream.writeString(getDependentOfficerId());
		stream.writeString(getRelation());
		stream.writeString(getPersonToMeet());
		stream.writeString(getVendorId());
		stream.writeString(getVendorName());
		stream.writeString(getVendorAddress());
		stream.writeString(getContractorId());
		stream.writeString(getContractorName());
		stream.writeString(getContractorAddress());
	}

}
