package io.v.v23.rpc;

/**
 * StreamServerCall defines the in-flight call state on the server, including methods
 * to stream args and results.
 */
public interface StreamServerCall extends Stream, ServerCall {}