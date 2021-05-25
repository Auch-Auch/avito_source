package com.avito.android.remote.model.payment.status;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0006\"\u0016\u0010\u0001\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0002\"\u0016\u0010\u0004\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0004\u0010\u0002\"\u0016\u0010\u0005\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0002¨\u0006\u0006"}, d2 = {"", "PAYMENT_STATE_DONE", "Ljava/lang/String;", "PAYMENT_STATE_CANCELED", "PAYMENT_STATE_FAILED", "PAYMENT_STATE_ACTIVE", "payment_release"}, k = 2, mv = {1, 4, 2})
public final class PaymentStateKt {
    @NotNull
    public static final String PAYMENT_STATE_ACTIVE = "active";
    @NotNull
    public static final String PAYMENT_STATE_CANCELED = "canceled";
    @NotNull
    public static final String PAYMENT_STATE_DONE = "done";
    @NotNull
    public static final String PAYMENT_STATE_FAILED = "failed";
}
