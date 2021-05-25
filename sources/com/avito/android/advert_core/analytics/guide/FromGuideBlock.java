package com.avito.android.advert_core.analytics.guide;

import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/advert_core/analytics/guide/FromGuideBlock;", "", "", AuthSource.SEND_ABUSE, "I", "getId", "()I", "id", "<init>", "(Ljava/lang/String;II)V", "SECTION", ShareConstants.CONTENT_URL, "advert-core_release"}, k = 1, mv = {1, 4, 2})
public enum FromGuideBlock {
    SECTION(0),
    LINK(1);
    
    public final int a;

    /* access modifiers changed from: public */
    FromGuideBlock(int i) {
        this.a = i;
    }

    public final int getId() {
        return this.a;
    }
}
