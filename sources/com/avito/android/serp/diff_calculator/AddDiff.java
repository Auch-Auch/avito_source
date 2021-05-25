package com.avito.android.serp.diff_calculator;

import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/serp/diff_calculator/AddDiff;", "Lcom/avito/android/serp/diff_calculator/Diff;", "", AuthSource.SEND_ABUSE, "I", "getPosition", "()I", VKApiConst.POSITION, AuthSource.BOOKING_ORDER, "getCount", "count", "<init>", "(II)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class AddDiff extends Diff {
    public final int a;
    public final int b;

    public AddDiff(int i, int i2) {
        super(null);
        this.a = i;
        this.b = i2;
    }

    public final int getCount() {
        return this.b;
    }

    public final int getPosition() {
        return this.a;
    }
}
