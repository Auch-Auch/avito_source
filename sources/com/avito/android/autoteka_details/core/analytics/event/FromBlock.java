package com.avito.android.autoteka_details.core.analytics.event;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/avito/android/autoteka_details/core/analytics/event/FromBlock;", "", "", AuthSource.SEND_ABUSE, "I", "getValue", "()I", "value", "<init>", "(Ljava/lang/String;II)V", "FROM_GALLERY_TEASER_A", "FROM_GALLERY_TEASER_B", "OLD_TEASER", "autoteka-details-core_release"}, k = 1, mv = {1, 4, 2})
public enum FromBlock {
    FROM_GALLERY_TEASER_A(0),
    FROM_GALLERY_TEASER_B(1),
    OLD_TEASER(2);
    
    public final int a;

    /* access modifiers changed from: public */
    FromBlock(int i) {
        this.a = i;
    }

    public final int getValue() {
        return this.a;
    }
}
