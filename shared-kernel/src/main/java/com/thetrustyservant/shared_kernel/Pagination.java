package com.thetrustyservant.shared_kernel;

import java.util.ArrayList;
import java.util.List;

public class Pagination<T> 
{
	public List<T> items;
	public int page;
	public int pageSize;
	public int totalCount;
	
	public Pagination(List<T> items, int page, int pageSize, int totalCount)
	{
		List<Result<Void>> results = new ArrayList<Result<Void>>();

		this.items = items;
		results.add(setPage(page));
		results.add(setPageSize(pageSize));
		results.add(setTotalCount(totalCount));
		
		for (Result<Void> result : results) {
			if(result.isFailure) {throw new RuntimeException("1001_PAGINATION_CREATED_ERROR");}
		}
	}
	
	public Result<Void> setPage(int page)
	{
		if((page < 0) || (page > 1000))
		{
			return Result.failure(Error.validation("0002", "PAGINATION_PAGE_ERROR"));		
		}
		else
		{
			this.page = page;
			return Result.success();
		}
	}
	
	public Result<Void> setPageSize(int pageSize)
	{
		if((pageSize < 0) || (pageSize > 1000))
		{
			return Result.failure(Error.validation("0003", "PAGINATION_PAGE_SIZE_ERROR"));
		}
		else
		{
			this.pageSize = pageSize;
			return Result.success();
		}
	}
	
	public Result<Void> setTotalCount(int totalCount)
	{
		if(pageSize < 0)
		{
			return Result.failure(Error.validation("0004", "PAGINATION_TOTAL_COUNT_ERROR"));
		}
		else
		{
			this.totalCount = totalCount;
			return Result.success();
		}
	}
}
