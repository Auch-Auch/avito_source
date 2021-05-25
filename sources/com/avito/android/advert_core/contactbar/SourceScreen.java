package com.avito.android.advert_core.contactbar;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/advert_core/contactbar/SourceScreen;", "", "", AuthSource.SEND_ABUSE, "I", "getValue", "()I", "value", "<init>", "(Ljava/lang/String;II)V", "ADVERT_DETAILS", "PHOTO_GALLERY", "SAFE_SHOW_DIALOG", "DISCOUNTS_DIALOG", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public enum SourceScreen {
    ADVERT_DETAILS(0),
    PHOTO_GALLERY(3),
    SAFE_SHOW_DIALOG(4),
    DISCOUNTS_DIALOG(5);
    
    public final int a;

    /* access modifiers changed from: public */
    SourceScreen(int i) {
        this.a = i;
    }

    public final int getValue() {
        return this.a;
    }
}
