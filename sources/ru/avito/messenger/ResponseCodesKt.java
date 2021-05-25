package ru.avito.messenger;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\"\u0016\u0010\u0005\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006\"\u0016\u0010\u0007\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006\"\u0016\u0010\b\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0006\"\u0016\u0010\t\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\u0006\"\u0016\u0010\n\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0006\"\u0016\u0010\u000b\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0006\"\u0016\u0010\f\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\u0006\"\u0016\u0010\r\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\u0006\"\u0016\u0010\u000e\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u0006\"\u0016\u0010\u000f\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0006¨\u0006\u0010"}, d2 = {"", "code", "", "needRetryAfterError", "(I)Z", "JSON_RPC_INTERNAL_ERROR", "I", "JSON_RPC_STATE_RESET", "JSON_RPC_CLOSED_BY_USER", "JSON_RPC_REQUEST_TIMEOUT", "JSON_RPC_SERVER_ERROR", "JSON_RPC_FORBIDDEN", "JSON_RPC_REQUEST_LIMIT", "JSON_RPC_FAILED", "JSON_RPC_NOT_FOUND", "JSON_RPC_CLOSED", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class ResponseCodesKt {
    public static final int JSON_RPC_CLOSED = -32300;
    public static final int JSON_RPC_CLOSED_BY_USER = 1000;
    public static final int JSON_RPC_FAILED = -1;
    public static final int JSON_RPC_FORBIDDEN = -32043;
    public static final int JSON_RPC_INTERNAL_ERROR = -32063;
    public static final int JSON_RPC_NOT_FOUND = -32044;
    public static final int JSON_RPC_REQUEST_LIMIT = -32249;
    public static final int JSON_RPC_REQUEST_TIMEOUT = -32054;
    public static final int JSON_RPC_SERVER_ERROR = -32050;
    public static final int JSON_RPC_STATE_RESET = 3410;

    public static final boolean needRetryAfterError(int i) {
        return i == -32249 || i == -32063 || i == -32054 || i == -32050;
    }
}
