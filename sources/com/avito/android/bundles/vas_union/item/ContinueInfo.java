package com.avito.android.bundles.vas_union.item;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/bundles/vas_union/item/ContinueInfo;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTabTitle", "()Ljava/lang/String;", "tabTitle", "Lcom/avito/android/remote/model/Action;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/Action;", "getContinueAction", "()Lcom/avito/android/remote/model/Action;", "continueAction", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Action;)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class ContinueInfo {
    @Nullable
    public final String a;
    @Nullable
    public final Action b;

    public ContinueInfo(@Nullable String str, @Nullable Action action) {
        this.a = str;
        this.b = action;
    }

    @Nullable
    public final Action getContinueAction() {
        return this.b;
    }

    @Nullable
    public final String getTabTitle() {
        return this.a;
    }
}
