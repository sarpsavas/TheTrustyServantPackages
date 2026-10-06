package com.thetrustyservant.shared_kernel;

public class Error {
	public String code;
	public String description;
	public ErrorType type;
	
	public static final Error none = new Error("", "", ErrorType.FAILURE);
	public static final Error nullValue = new Error("General.Null", "Null value was provided", ErrorType.FAILURE);
	
	public Error(String code, String description, ErrorType type)
	{
		this.code = code;
		this.description = description;
		this.type = type;
	}
	
	public static Error Failure(String code, String description)
	{
		return new Error(code, description, ErrorType.FAILURE);
	}

	public static Error NotFound(String code, String description)
	{
		return new Error(code, description, ErrorType.NOT_FOUND);
	}

	public static Error Problem(String code, String description)
	{
		return new Error(code, description, ErrorType.PROBLEM);
	}

	public static Error Conflict(String code, String description)
	{
		return new Error(code, description, ErrorType.CONFLICT);
	}

	public static Error Forbidden(String code, String description)
	{
		return new Error(code, description, ErrorType.FORBIDDEN);
	}
}
