package net.vo;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

import net.constant.VisitorManagementConstants;

public class DropdownVO  implements SQLData{
	
	
	int dropdownId;
	String description;
	String dropdownName;
	String disabled;
	

	public int getDropdownId() {
		return dropdownId;
	}

	public void setDropdownId(int dropdownId) {
		this.dropdownId = dropdownId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDropdownName() {
		return dropdownName;
	}

	public void setDropdownName(String dropdownName) {
		this.dropdownName = dropdownName;
	}

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	@Override
	public String getSQLTypeName() throws SQLException {
		// TODO Auto-generated method stub
		return VisitorManagementConstants.DROPDOWN_OBJECT;
	}

	@Override
	public void readSQL(SQLInput stream, String typeName) throws SQLException {
		// TODO Auto-generated method stub
		setDropdownId(stream.readInt());
		setDescription(stream.readString());
		setDropdownName(stream.readString());
		setDisabled(stream.readString());
		
	}

	@Override
	public void writeSQL(SQLOutput stream) throws SQLException {
		// TODO Auto-generated method stub
		stream.writeInt(getDropdownId());
		stream.writeString(getDescription());
		stream.writeString(getDropdownName());
		stream.writeString(getDisabled());
		
	}

}
