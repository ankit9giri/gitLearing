package com.rptc.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//import com.app.api.audit.DateAudit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User  {
	@Id
	private int id;
	private String username;
	private String email;
	private String password;
	
}
