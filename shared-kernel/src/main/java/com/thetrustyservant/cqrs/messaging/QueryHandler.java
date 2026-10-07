package com.thetrustyservent.cqrs.messaging;

import com.thetrustyservant.cqrs.messaging;
import com.thetrustyservant.shared_kernel;

public interface QueryHandler<Query, Response> {
	<Response> Result<Response> handle(Query query, CancellationToken cancellationToken);
}
