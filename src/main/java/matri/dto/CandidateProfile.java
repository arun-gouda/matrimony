package matri.dto;

import java.sql.Date;

public class CandidateProfile {
	
	private int profileId;
	private int brokerUserId;
	private String firstName;
	private String lastName;
	private String middleName;
	private String gender;
	private Date dob;
	private String fathersName;
	private String state;
	private String district;
	private String tehsil;
	private String village;
	private String mobileNumber;
	private String marritalStatus;
	private String totalChildrens;
	private String motherToung;
	private String religion;
	private String caste;
	private String subcaste;
	private String education;
	private String occupation;
	private String annualIncome;
	private String height;
	private String skinTone;
	private String physicalStatus;
	private String star;
	private String noOfBrothers;
	private String noOfSisters;
	private String motherName;
	private Date registerDate;
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public int getBrokerUserId() {
		return brokerUserId;
	}
	public void setBrokerUserId(int brokerUserId) {
		this.brokerUserId = brokerUserId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getFathersName() {
		return fathersName;
	}
	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getTehsil() {
		return tehsil;
	}
	public void setTehsil(String tehsil) {
		this.tehsil = tehsil;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getMarritalStatus() {
		return marritalStatus;
	}
	public void setMarritalStatus(String marritalStatus) {
		this.marritalStatus = marritalStatus;
	}
	public String getTotalChildrens() {
		return totalChildrens;
	}
	public void setTotalChildrens(String totalChildrens) {
		this.totalChildrens = totalChildrens;
	}
	public String getMotherToung() {
		return motherToung;
	}
	public void setMotherToung(String motherToung) {
		this.motherToung = motherToung;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getCaste() {
		return caste;
	}
	public void setCaste(String caste) {
		this.caste = caste;
	}
	public String getSubcaste() {
		return subcaste;
	}
	public void setSubcaste(String subcaste) {
		this.subcaste = subcaste;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(String annualIncome) {
		this.annualIncome = annualIncome;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getSkinTone() {
		return skinTone;
	}
	public void setSkinTone(String skinTone) {
		this.skinTone = skinTone;
	}
	public String getPhysicalStatus() {
		return physicalStatus;
	}
	public void setPhysicalStatus(String physicalStatus) {
		this.physicalStatus = physicalStatus;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public String getNoOfBrothers() {
		return noOfBrothers;
	}
	public void setNoOfBrothers(String noOfBrothers) {
		this.noOfBrothers = noOfBrothers;
	}
	public String getNoOfSisters() {
		return noOfSisters;
	}
	public void setNoOfSisters(String noOfSisters) {
		this.noOfSisters = noOfSisters;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	@Override
	public String toString() {
		return "CandidateProfile [profileId=" + profileId + ", brokerUserId=" + brokerUserId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", middleName=" + middleName + ", gender=" + gender + ", dob="
				+ dob + ", fathersName=" + fathersName + ", state=" + state + ", district=" + district + ", tehsil="
				+ tehsil + ", village=" + village + ", mobileNumber=" + mobileNumber + ", marritalStatus="
				+ marritalStatus + ", totalChildrens=" + totalChildrens + ", motherToung=" + motherToung + ", religion="
				+ religion + ", caste=" + caste + ", subcaste=" + subcaste + ", education=" + education
				+ ", occupation=" + occupation + ", annualIncome=" + annualIncome + ", height=" + height + ", skinTone="
				+ skinTone + ", physicalStatus=" + physicalStatus + ", star=" + star + ", noOfBrothers=" + noOfBrothers
				+ ", noOfSisters=" + noOfSisters + ", motherName=" + motherName + ", registerDate=" + registerDate
				+ "]";
	}
	
	
}
