package com.HauLuong.HotelBook.Request;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
	   @NotBlank
	    private String email;
	    @NotBlank
	    private String password;
	    
		public LoginRequest() {
			
		}
		
		public String getEmail() {
			return email;
		}
		public String getPassword() {
			return password;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	    
}
