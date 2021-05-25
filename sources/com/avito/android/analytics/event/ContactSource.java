package com.avito.android.analytics.event;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/analytics/event/ContactSource;", "", "", AuthSource.SEND_ABUSE, "Z", "getFromXl", "()Z", "fromXl", "", AuthSource.BOOKING_ORDER, "I", "getBlock", "()I", "block", "<init>", "(Ljava/lang/String;IZI)V", "CONTACT_REGULAR", "CONTACT_REGULAR_GALLERY", "CONTACT_XL", "CONTACT_XL_GALLERY", "core_release"}, k = 1, mv = {1, 4, 2})
public enum ContactSource {
    CONTACT_REGULAR(false, 0),
    CONTACT_REGULAR_GALLERY(false, 3),
    CONTACT_XL(true, 0),
    CONTACT_XL_GALLERY(true, 3);
    
    public final boolean a;
    public final int b;

    /* access modifiers changed from: public */
    ContactSource(boolean z, int i) {
        this.a = z;
        this.b = i;
    }

    public final int getBlock() {
        return this.b;
    }

    public final boolean getFromXl() {
        return this.a;
    }
}
