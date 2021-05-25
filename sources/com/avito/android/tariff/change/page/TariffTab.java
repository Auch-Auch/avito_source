package com.avito.android.tariff.change.page;

import com.avito.android.design.widget.tab.Tab;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001f\u0010 R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/tariff/change/page/TariffTab;", "Lcom/avito/android/design/widget/tab/Tab;", "", "d", "Z", "isSelected", "()Z", "setSelected", "(Z)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "e", "getLabel", "label", "Lcom/avito/android/remote/model/Action;", "c", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "action", "", "Lcom/avito/conveyor_item/Item;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getItems", "()Ljava/util/List;", "items", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/Action;ZLjava/lang/String;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffTab implements Tab {
    @NotNull
    public final String a;
    @NotNull
    public final List<Item> b;
    @Nullable
    public final Action c;
    public boolean d;
    @Nullable
    public final String e;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.conveyor_item.Item> */
    /* JADX WARN: Multi-variable type inference failed */
    public TariffTab(@NotNull String str, @NotNull List<? extends Item> list, @Nullable Action action, boolean z, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "items");
        this.a = str;
        this.b = list;
        this.c = action;
        this.d = z;
        this.e = str2;
    }

    @Nullable
    public final Action getAction() {
        return this.c;
    }

    @NotNull
    public final List<Item> getItems() {
        return this.b;
    }

    @Override // com.avito.android.design.widget.tab.Tab
    @Nullable
    public String getLabel() {
        return this.e;
    }

    @Override // com.avito.android.design.widget.tab.Tab
    @NotNull
    public String getTitle() {
        return this.a;
    }

    public final boolean isSelected() {
        return this.d;
    }

    public final void setSelected(boolean z) {
        this.d = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TariffTab(String str, List list, Action action, boolean z, String str2, int i, j jVar) {
        this(str, list, (i & 4) != 0 ? null : action, (i & 8) != 0 ? false : z, (i & 16) != 0 ? null : str2);
    }
}
