package com.employee.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "dept")
public class Department {

	@Id
	private String departmentId;
	private String departmentName;
	private LocalDate createdAt;

	@LastModifiedDate
	private LocalDate updatedAt;
}
