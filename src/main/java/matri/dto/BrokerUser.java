package matri.dto;

import java.util.Date;

public class BrokerUser {

		private int brokerId;
		private String firstName;
		private String lastName;
		private String mobileNumber1;
		private String email;
		private String isActive;
		private String password;
		private Date startDate;
		private Date endDate;
		private int unionId;
		private String unionName;
		private String mobileNumber2;
		public int getBrokerId() {
			return brokerId;
		}
		public void setBrokerId(int brokerId) {
			this.brokerId = brokerId;
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
		public String getMobileNumber1() {
			return mobileNumber1;
		}
		public void setMobileNumber1(String mobileNumber1) {
			this.mobileNumber1 = mobileNumber1;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getIsActive() {
			return isActive;
		}
		public void setIsActive(String isActive) {
			this.isActive = isActive;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Date getStartDate() {
			return startDate;
		}
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}
		public Date getEndDate() {
			return endDate;
		}
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}
		public int getUnionId() {
			return unionId;
		}
		public void setUnionId(int unionId) {
			this.unionId = unionId;
		}
		public String getUnionName() {
			return unionName;
		}
		public void setUnionName(String unionName) {
			this.unionName = unionName;
		}
		public String getMobileNumber2() {
			return mobileNumber2;
		}
		public void setMobileNumber2(String mobileNumber2) {
			this.mobileNumber2 = mobileNumber2;
		}
		@Override
		public String toString() {
			return "BrokerUser [brokerId=" + brokerId + ", firstName=" + firstName + ", lastName=" + lastName
					+ ", mobileNumber1=" + mobileNumber1 + ", email=" + email + ", isActive=" + isActive + ", password="
					+ password + ", startDate=" + startDate + ", endDate=" + endDate + ", unionId=" + unionId
					+ ", unionName=" + unionName + ", mobileNumber2=" + mobileNumber2 + "]";
		}
}
