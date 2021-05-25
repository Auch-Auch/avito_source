package com.avito.android.bundles.vas_union.item.tabs;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\r\u0010\u0007J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/avito/android/bundles/vas_union/item/tabs/Tab;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "title", VKApiConst.POSITION, "copy", "(Ljava/lang/String;I)Lcom/avito/android/bundles/vas_union/item/tabs/Tab;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", AuthSource.BOOKING_ORDER, "I", "getPosition", "<init>", "(Ljava/lang/String;I)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class Tab {
    @NotNull
    public final String a;
    public final int b;

    public Tab(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.a = str;
        this.b = i;
    }

    public static /* synthetic */ Tab copy$default(Tab tab, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = tab.a;
        }
        if ((i2 & 2) != 0) {
            i = tab.b;
        }
        return tab.copy(str, i);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    @NotNull
    public final Tab copy(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "title");
        return new Tab(str, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tab)) {
            return false;
        }
        Tab tab = (Tab) obj;
        return Intrinsics.areEqual(this.a, tab.a) && this.b == tab.b;
    }

    public final int getPosition() {
        return this.b;
    }

    @NotNull
    public final String getTitle() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        return ((str != null ? str.hashCode() : 0) * 31) + this.b;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Tab(title=");
        L.append(this.a);
        L.append(", position=");
        return a.j(L, this.b, ")");
    }
}
