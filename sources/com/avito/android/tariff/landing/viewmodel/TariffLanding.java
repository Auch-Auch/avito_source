package com.avito.android.tariff.landing.viewmodel;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/tariff/landing/viewmodel/TariffLanding;", "", "", "Lcom/avito/conveyor_item/Item;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getItems", "()Ljava/util/List;", "items", "Lcom/avito/android/remote/model/Action;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "action", "<init>", "(Ljava/util/List;Lcom/avito/android/remote/model/Action;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffLanding {
    @NotNull
    public final List<Item> a;
    @NotNull
    public final Action b;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.conveyor_item.Item> */
    /* JADX WARN: Multi-variable type inference failed */
    public TariffLanding(@NotNull List<? extends Item> list, @NotNull Action action) {
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(action, "action");
        this.a = list;
        this.b = action;
    }

    @NotNull
    public final Action getAction() {
        return this.b;
    }

    @NotNull
    public final List<Item> getItems() {
        return this.a;
    }
}
