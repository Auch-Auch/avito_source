package com.avito.android.select;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.conveyor_item.Item;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0018\b\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n¢\u0006\u0004\b2\u00103J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000e\u0010\fJ\\\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0013\u001a\u00020\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0015\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0004R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010!\u001a\u0004\b$\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010!\u001a\u0004\b&\u0010\u0004R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010!\u001a\u0004\b(\u0010\u0004R\"\u0010\u0013\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010-R\u0019\u0010\u0015\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010*\u001a\u0004\b\u0015\u0010\fR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\t¨\u00064"}, d2 = {"Lcom/avito/android/select/VariantItem;", "Lcom/avito/conveyor_item/Item;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Lcom/avito/android/remote/model/Image;", "component4", "()Lcom/avito/android/remote/model/Image;", "", "component5", "()Z", "component6", "component7", "stringId", "title", MessengerShareContentUtility.SUBTITLE, "image", "selected", "sectionTitle", "isMultiselect", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;ZLjava/lang/String;Z)Lcom/avito/android/select/VariantItem;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "c", "getSubtitle", AuthSource.BOOKING_ORDER, "getTitle", "f", "getSectionTitle", "e", "Z", "getSelected", "setSelected", "(Z)V", g.a, "d", "Lcom/avito/android/remote/model/Image;", "getImage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;ZLjava/lang/String;Z)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class VariantItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final String c;
    @Nullable
    public final Image d;
    public boolean e;
    @Nullable
    public final String f;
    public final boolean g;

    public VariantItem(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable Image image, boolean z, @Nullable String str4, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = image;
        this.e = z;
        this.f = str4;
        this.g = z2;
    }

    public static /* synthetic */ VariantItem copy$default(VariantItem variantItem, String str, String str2, String str3, Image image, boolean z, String str4, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = variantItem.getStringId();
        }
        if ((i & 2) != 0) {
            str2 = variantItem.b;
        }
        if ((i & 4) != 0) {
            str3 = variantItem.c;
        }
        if ((i & 8) != 0) {
            image = variantItem.d;
        }
        if ((i & 16) != 0) {
            z = variantItem.e;
        }
        if ((i & 32) != 0) {
            str4 = variantItem.f;
        }
        if ((i & 64) != 0) {
            z2 = variantItem.g;
        }
        return variantItem.copy(str, str2, str3, image, z, str4, z2);
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
    public final Image component4() {
        return this.d;
    }

    public final boolean component5() {
        return this.e;
    }

    @Nullable
    public final String component6() {
        return this.f;
    }

    public final boolean component7() {
        return this.g;
    }

    @NotNull
    public final VariantItem copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable Image image, boolean z, @Nullable String str4, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new VariantItem(str, str2, str3, image, z, str4, z2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VariantItem)) {
            return false;
        }
        VariantItem variantItem = (VariantItem) obj;
        return Intrinsics.areEqual(getStringId(), variantItem.getStringId()) && Intrinsics.areEqual(this.b, variantItem.b) && Intrinsics.areEqual(this.c, variantItem.c) && Intrinsics.areEqual(this.d, variantItem.d) && this.e == variantItem.e && Intrinsics.areEqual(this.f, variantItem.f) && this.g == variantItem.g;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Nullable
    public final Image getImage() {
        return this.d;
    }

    @Nullable
    public final String getSectionTitle() {
        return this.f;
    }

    public final boolean getSelected() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Nullable
    public final String getSubtitle() {
        return this.c;
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
        Image image = this.d;
        int hashCode4 = (hashCode3 + (image != null ? image.hashCode() : 0)) * 31;
        boolean z = this.e;
        int i2 = 1;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (hashCode4 + i3) * 31;
        String str3 = this.f;
        if (str3 != null) {
            i = str3.hashCode();
        }
        int i7 = (i6 + i) * 31;
        boolean z2 = this.g;
        if (!z2) {
            i2 = z2 ? 1 : 0;
        }
        return i7 + i2;
    }

    public final boolean isMultiselect() {
        return this.g;
    }

    public final void setSelected(boolean z) {
        this.e = z;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("VariantItem(stringId=");
        L.append(getStringId());
        L.append(", title=");
        L.append(this.b);
        L.append(", subtitle=");
        L.append(this.c);
        L.append(", image=");
        L.append(this.d);
        L.append(", selected=");
        L.append(this.e);
        L.append(", sectionTitle=");
        L.append(this.f);
        L.append(", isMultiselect=");
        return a.B(L, this.g, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VariantItem(String str, String str2, String str3, Image image, boolean z, String str4, boolean z2, int i, j jVar) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : image, z, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? false : z2);
    }
}
