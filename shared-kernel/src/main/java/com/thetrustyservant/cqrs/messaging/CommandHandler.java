package com.thetrustyservent.cqrs.messaging;

public interface CommandHandler<Command, Response> {

	<Response> Result<Response> handle(Command command, CancellationToken cancellationToken);
}
