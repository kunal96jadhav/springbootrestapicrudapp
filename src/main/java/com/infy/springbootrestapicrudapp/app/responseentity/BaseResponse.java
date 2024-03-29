package com.infy.springbootrestapicrudapp.app.responseentity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {
	private Integer statusCode;
	private String msg;
	private T responceType;
}
