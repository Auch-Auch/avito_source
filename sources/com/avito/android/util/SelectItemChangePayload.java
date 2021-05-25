package com.avito.android.util;

import com.avito.android.items.ItemWithState;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/util/SelectItemChangePayload;", "", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "Lcom/avito/android/items/ItemWithState$State;", AuthSource.SEND_ABUSE, "Lcom/avito/android/items/ItemWithState$State;", "getState", "()Lcom/avito/android/items/ItemWithState$State;", "state", "<init>", "(Lcom/avito/android/items/ItemWithState$State;Ljava/lang/String;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class SelectItemChangePayload {
    @Nullable
    public final ItemWithState.State a;
    @Nullable
    public final String b;

    public SelectItemChangePayload(@Nullable ItemWithState.State state, @Nullable String str) {
        this.a = state;
        this.b = str;
    }

    @Nullable
    public final ItemWithState.State getState() {
        return this.a;
    }

    @Nullable
    public final String getValue() {
        return this.b;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SelectItemChangePayload(ItemWithState.State state, String str, int i, j jVar) {
        this(state, (i & 2) != 0 ? null : str);
    }
}
