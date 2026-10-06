package com.thetrustyservant.shared_kernel;

public class Result<T> {
	public boolean isSucces;
	public boolean isFailure;
	public Error error;
	public T value;
	
	public Result(T value, boolean isSuccess, Error error)
	{
		if((isSuccess && error != Error.none) || (!isSuccess && error == Error.none))
		{
			throw new IllegalArgumentException("0001  logic error");
		}
		this.isSucces = isSuccess;
		this.isFailure = !isSuccess;
	}
	
	public static Result<Void> success()
	{
		
		return new Result<Void>(null, true, Error.none);
	}
	
	public static <T> Result<T> success(T value)
	{
		return new Result<>(value, true, Error.none);
	}
	
	public static Result<Void> failure(Error error)
	{
		return new Result<Void>(null, false, error);
	}
	
	public static <T> Result<T> failure(T value, Error error)
	{
		return new Result<>(value, false, error);
	}
}
