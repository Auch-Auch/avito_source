package com.avito.android.util;

import com.avito.android.items.ItemWithState;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/util/DateChange;", "", "Lcom/avito/android/items/ItemWithState$State;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/items/ItemWithState$State;", "getState", "()Lcom/avito/android/items/ItemWithState$State;", "state", "", AuthSource.SEND_ABUSE, "Ljava/lang/Long;", "getTimeStamp", "()Ljava/lang/Long;", "timeStamp", "<init>", "(Ljava/lang/Long;Lcom/avito/android/items/ItemWithState$State;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class DateChange {
    @Nullable
    public final Long a;
    @Nullable
    public final ItemWithState.State b;

    public DateChange(@Nullable Long l, @Nullable ItemWithState.State state) {
        this.a = l;
        this.b = state;
    }

    @Nullable
    public final ItemWithState.State getState() {
        return this.b;
    }

    @Nullable
    public final Long getTimeStamp() {
        return this.a;
    }
}
