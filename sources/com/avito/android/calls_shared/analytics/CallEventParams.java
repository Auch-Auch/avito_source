package com.avito.android.calls_shared.analytics;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/avito/android/calls_shared/analytics/CallEventParams;", "", "", "CALL_RECEIVER_ID", "Ljava/lang/String;", "CALL_ITEM_ID", "CALL_ID", "CALL_CALLER_ID", "CALL_MIC_ACCESS", "CALL_MIC_ACCESS_SCENARIO", "CALL_SCENARIO", "CALL_SIDE", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
public final class CallEventParams {
    @NotNull
    public static final String CALL_CALLER_ID = "caller_id";
    @NotNull
    public static final String CALL_ID = "appcall_id";
    @NotNull
    public static final String CALL_ITEM_ID = "iid";
    @NotNull
    public static final String CALL_MIC_ACCESS = "mic_access";
    @NotNull
    public static final String CALL_MIC_ACCESS_SCENARIO = "micaccess_scenario";
    @NotNull
    public static final String CALL_RECEIVER_ID = "reciever_id";
    @NotNull
    public static final String CALL_SCENARIO = "appcall_scenario";
    @NotNull
    public static final String CALL_SIDE = "call_side";
    @NotNull
    public static final CallEventParams INSTANCE = new CallEventParams();
}
