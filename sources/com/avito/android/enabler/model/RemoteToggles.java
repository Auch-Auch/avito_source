package com.avito.android.enabler.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/enabler/model/RemoteToggles;", "", "", "Lcom/avito/android/enabler/model/BooleanToggle;", "toggles", "Ljava/util/List;", "getToggles", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "features-enabler_release"}, k = 1, mv = {1, 4, 2})
public final class RemoteToggles {
    @NotNull
    private final List<BooleanToggle> toggles;

    public RemoteToggles(@NotNull List<BooleanToggle> list) {
        Intrinsics.checkNotNullParameter(list, "toggles");
        this.toggles = list;
    }

    @NotNull
    public final List<BooleanToggle> getToggles() {
        return this.toggles;
    }
}
