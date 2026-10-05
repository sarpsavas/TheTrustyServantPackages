package com.thetrustyservant.shared_kernel;

public class Result {
	public boolean isSucces;
	public boolean isFailure;
	public Error error;
	
	public Result(boolean isSuccess, Error error)
	{
		if((isSuccess && error != Error.none) || (!isSuccess && error == Error.none))
		{
			throw new Exception("0001  logic error");
		}
		this.isSucces = isSuccess;
	}
}
