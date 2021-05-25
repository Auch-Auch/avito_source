package com.avito.android.basket_legacy.utils;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/basket_legacy/utils/CloseEvent;", "", "", AuthSource.BOOKING_ORDER, "Z", "getEnableAppRater", "()Z", "enableAppRater", AuthSource.SEND_ABUSE, "getPaymentSucceeded", "paymentSucceeded", "<init>", "(ZZ)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class CloseEvent {
    public final boolean a;
    public final boolean b;

    public CloseEvent(boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
    }

    public final boolean getEnableAppRater() {
        return this.b;
    }

    public final boolean getPaymentSucceeded() {
        return this.a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CloseEvent(boolean z, boolean z2, int i, j jVar) {
        this(z, (i & 2) != 0 ? false : z2);
    }
}
