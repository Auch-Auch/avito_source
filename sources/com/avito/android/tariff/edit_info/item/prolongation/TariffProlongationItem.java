package com.avito.android.tariff.edit_info.item.prolongation;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u001a\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b4\u00105J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u000e\u0010\tJ\\\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\n2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0004R\"\u0010\u0014\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b\u0014\u0010\f\"\u0004\b%\u0010&R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b'\u0010!\u001a\u0004\b(\u0010\u0004\"\u0004\b)\u0010*R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\tR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010!\u001a\u0004\b/\u0010\u0004R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010,\u001a\u0004\b1\u0010\tR\"\u0010\u0013\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b2\u0010$\u001a\u0004\b\u0013\u0010\f\"\u0004\b3\u0010&¨\u00066"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/prolongation/TariffProlongationItem;", "Lcom/avito/conveyor_item/Item;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Lcom/avito/android/remote/model/text/AttributedText;", "component4", "()Lcom/avito/android/remote/model/text/AttributedText;", "", "component5", "()Z", "component6", "component7", "stringId", "title", "currentText", "description", "isSwitchOn", "isSwitchEnabled", "offDescription", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;ZZLcom/avito/android/remote/model/text/AttributedText;)Lcom/avito/android/tariff/edit_info/item/prolongation/TariffProlongationItem;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "f", "Z", "setSwitchEnabled", "(Z)V", "c", "getCurrentText", "setCurrentText", "(Ljava/lang/String;)V", g.a, "Lcom/avito/android/remote/model/text/AttributedText;", "getOffDescription", AuthSource.BOOKING_ORDER, "getTitle", "d", "getDescription", "e", "setSwitchOn", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;ZZLcom/avito/android/remote/model/text/AttributedText;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffProlongationItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public String c;
    @Nullable
    public final AttributedText d;
    public boolean e;
    public boolean f;
    @Nullable
    public final AttributedText g;

    public TariffProlongationItem(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable AttributedText attributedText, boolean z, boolean z2, @Nullable AttributedText attributedText2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = attributedText;
        this.e = z;
        this.f = z2;
        this.g = attributedText2;
    }

    public static /* synthetic */ TariffProlongationItem copy$default(TariffProlongationItem tariffProlongationItem, String str, String str2, String str3, AttributedText attributedText, boolean z, boolean z2, AttributedText attributedText2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tariffProlongationItem.getStringId();
        }
        if ((i & 2) != 0) {
            str2 = tariffProlongationItem.b;
        }
        if ((i & 4) != 0) {
            str3 = tariffProlongationItem.c;
        }
        if ((i & 8) != 0) {
            attributedText = tariffProlongationItem.d;
        }
        if ((i & 16) != 0) {
            z = tariffProlongationItem.e;
        }
        if ((i & 32) != 0) {
            z2 = tariffProlongationItem.f;
        }
        if ((i & 64) != 0) {
            attributedText2 = tariffProlongationItem.g;
        }
        return tariffProlongationItem.copy(str, str2, str3, attributedText, z, z2, attributedText2);
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    @Nullable
    public final AttributedText component4() {
        return this.d;
    }

    public final boolean component5() {
        return this.e;
    }

    public final boolean component6() {
        return this.f;
    }

    @Nullable
    public final AttributedText component7() {
        return this.g;
    }

    @NotNull
    public final TariffProlongationItem copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable AttributedText attributedText, boolean z, boolean z2, @Nullable AttributedText attributedText2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new TariffProlongationItem(str, str2, str3, attributedText, z, z2, attributedText2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TariffProlongationItem)) {
            return false;
        }
        TariffProlongationItem tariffProlongationItem = (TariffProlongationItem) obj;
        return Intrinsics.areEqual(getStringId(), tariffProlongationItem.getStringId()) && Intrinsics.areEqual(this.b, tariffProlongationItem.b) && Intrinsics.areEqual(this.c, tariffProlongationItem.c) && Intrinsics.areEqual(this.d, tariffProlongationItem.d) && this.e == tariffProlongationItem.e && this.f == tariffProlongationItem.f && Intrinsics.areEqual(this.g, tariffProlongationItem.g);
    }

    @Nullable
    public final String getCurrentText() {
        return this.c;
    }

    @Nullable
    public final AttributedText getDescription() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Nullable
    public final AttributedText getOffDescription() {
        return this.g;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @NotNull
    public final String getTitle() {
        return this.b;
    }

    public int hashCode() {
        String stringId = getStringId();
        int i = 0;
        int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        AttributedText attributedText = this.d;
        int hashCode4 = (hashCode3 + (attributedText != null ? attributedText.hashCode() : 0)) * 31;
        boolean z = this.e;
        int i2 = 1;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (hashCode4 + i3) * 31;
        boolean z2 = this.f;
        if (!z2) {
            i2 = z2 ? 1 : 0;
        }
        int i7 = (i6 + i2) * 31;
        AttributedText attributedText2 = this.g;
        if (attributedText2 != null) {
            i = attributedText2.hashCode();
        }
        return i7 + i;
    }

    public final boolean isSwitchEnabled() {
        return this.f;
    }

    public final boolean isSwitchOn() {
        return this.e;
    }

    public final void setCurrentText(@Nullable String str) {
        this.c = str;
    }

    public final void setSwitchEnabled(boolean z) {
        this.f = z;
    }

    public final void setSwitchOn(boolean z) {
        this.e = z;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("TariffProlongationItem(stringId=");
        L.append(getStringId());
        L.append(", title=");
        L.append(this.b);
        L.append(", currentText=");
        L.append(this.c);
        L.append(", description=");
        L.append(this.d);
        L.append(", isSwitchOn=");
        L.append(this.e);
        L.append(", isSwitchEnabled=");
        L.append(this.f);
        L.append(", offDescription=");
        L.append(this.g);
        L.append(")");
        return L.toString();
    }
}
