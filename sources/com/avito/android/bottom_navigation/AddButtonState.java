package com.avito.android.bottom_navigation;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/bottom_navigation/AddButtonState;", "", "", AuthSource.BOOKING_ORDER, "Z", "isBig", "()Z", AuthSource.SEND_ABUSE, "isActive", "<init>", "(Ljava/lang/String;IZZ)V", "ACTIVE", "ACTIVE_SMALL", "BIG", "SMALL", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
public enum AddButtonState {
    ACTIVE(true, true),
    ACTIVE_SMALL(true, false),
    BIG(false, true),
    SMALL(false, false);
    
    public final boolean a;
    public final boolean b;

    /* access modifiers changed from: public */
    AddButtonState(boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
    }

    public final boolean isActive() {
        return this.a;
    }

    public final boolean isBig() {
        return this.b;
    }
}
