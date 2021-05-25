package com.avito.android.delivery.summary.konveyor.button;

import a2.b.a.a.a;
import com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryItemsConverterKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B+\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\f\u0010\bR\u0019\u0010\r\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001e\u001a\u0004\b\r\u0010\b¨\u0006#"}, d2 = {"Lcom/avito/android/delivery/summary/konveyor/button/ButtonItem;", "Lcom/avito/conveyor_item/Item;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "component4", "stringId", "text", "isLoading", "isEnabled", "copy", "(Ljava/lang/String;Ljava/lang/String;ZZ)Lcom/avito/android/delivery/summary/konveyor/button/ButtonItem;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getText", AuthSource.SEND_ABUSE, "getStringId", "c", "Z", "d", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "Companion", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class ButtonItem implements Item {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final ButtonItem e = new ButtonItem(DeliveryRdsSummaryItemsConverterKt.LOADING_BUTTON_ID, "", true, false);
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    public final boolean c;
    public final boolean d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/delivery/summary/konveyor/button/ButtonItem$Companion;", "", "Lcom/avito/android/delivery/summary/konveyor/button/ButtonItem;", "LOADING", "Lcom/avito/android/delivery/summary/konveyor/button/ButtonItem;", "getLOADING", "()Lcom/avito/android/delivery/summary/konveyor/button/ButtonItem;", "<init>", "()V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final ButtonItem getLOADING() {
            return ButtonItem.e;
        }

        public Companion(j jVar) {
        }
    }

    public ButtonItem(@NotNull String str, @NotNull String str2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "text");
        this.a = str;
        this.b = str2;
        this.c = z;
        this.d = z2;
    }

    public static /* synthetic */ ButtonItem copy$default(ButtonItem buttonItem, String str, String str2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = buttonItem.getStringId();
        }
        if ((i & 2) != 0) {
            str2 = buttonItem.b;
        }
        if ((i & 4) != 0) {
            z = buttonItem.c;
        }
        if ((i & 8) != 0) {
            z2 = buttonItem.d;
        }
        return buttonItem.copy(str, str2, z, z2);
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    public final boolean component3() {
        return this.c;
    }

    public final boolean component4() {
        return this.d;
    }

    @NotNull
    public final ButtonItem copy(@NotNull String str, @NotNull String str2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "text");
        return new ButtonItem(str, str2, z, z2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ButtonItem)) {
            return false;
        }
        ButtonItem buttonItem = (ButtonItem) obj;
        return Intrinsics.areEqual(getStringId(), buttonItem.getStringId()) && Intrinsics.areEqual(this.b, buttonItem.b) && this.c == buttonItem.c && this.d == buttonItem.d;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @NotNull
    public final String getText() {
        return this.b;
    }

    public int hashCode() {
        String stringId = getStringId();
        int i = 0;
        int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
        String str = this.b;
        if (str != null) {
            i = str.hashCode();
        }
        int i2 = (hashCode + i) * 31;
        boolean z = this.c;
        int i3 = 1;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = (i2 + i4) * 31;
        boolean z2 = this.d;
        if (!z2) {
            i3 = z2 ? 1 : 0;
        }
        return i7 + i3;
    }

    public final boolean isEnabled() {
        return this.d;
    }

    public final boolean isLoading() {
        return this.c;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ButtonItem(stringId=");
        L.append(getStringId());
        L.append(", text=");
        L.append(this.b);
        L.append(", isLoading=");
        L.append(this.c);
        L.append(", isEnabled=");
        return a.B(L, this.d, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ButtonItem(String str, String str2, boolean z, boolean z2, int i, j jVar) {
        this(str, str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? true : z2);
    }
}
