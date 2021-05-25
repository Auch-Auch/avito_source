package com.avito.android.location_picker.entities;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/location_picker/entities/ChangeAdvertsCountUpdate;", "", "", AuthSource.SEND_ABUSE, "J", "getCount", "()J", "count", "<init>", "(J)V", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public final class ChangeAdvertsCountUpdate {
    public final long a;

    public ChangeAdvertsCountUpdate() {
        this(0, 1, null);
    }

    public ChangeAdvertsCountUpdate(long j) {
        this.a = j;
    }

    public final long getCount() {
        return this.a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChangeAdvertsCountUpdate(long j, int i, j jVar) {
        this((i & 1) != 0 ? 0 : j);
    }
}
