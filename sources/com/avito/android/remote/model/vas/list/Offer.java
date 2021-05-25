package com.avito.android.remote.model.vas.list;

import com.avito.android.remote.model.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/vas/list/Offer;", "Lcom/avito/android/remote/model/vas/list/VasElement;", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "<init>", "(Lcom/avito/android/remote/model/Action;)V", "vas_release"}, k = 1, mv = {1, 4, 2})
public final class Offer implements VasElement {
    @NotNull
    private final Action action;

    public Offer(@NotNull Action action2) {
        Intrinsics.checkNotNullParameter(action2, "action");
        this.action = action2;
    }

    @NotNull
    public final Action getAction() {
        return this.action;
    }
}
