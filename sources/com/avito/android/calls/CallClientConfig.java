package com.avito.android.calls;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/avito/android/calls/CallClientConfig;", "", "", "CONNECTION_TIMEOUT_MILLIS", "J", "", "RETRY_MAX_COUNT", "I", "RETRY_DELAY", "<init>", "()V", "calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallClientConfig {
    public static final long CONNECTION_TIMEOUT_MILLIS = 5000;
    @NotNull
    public static final CallClientConfig INSTANCE = new CallClientConfig();
    public static final long RETRY_DELAY = 500;
    public static final int RETRY_MAX_COUNT = 3;
}
