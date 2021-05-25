package com.avito.android.calls_shared;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/calls_shared/InAppCallsConstants;", "", "", "REQUEST_RETRY_COUNT", "I", "", "REQUEST_RETRY_DELAY", "J", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
public final class InAppCallsConstants {
    @NotNull
    public static final InAppCallsConstants INSTANCE = new InAppCallsConstants();
    public static final int REQUEST_RETRY_COUNT = 3;
    public static final long REQUEST_RETRY_DELAY = 250;
}
