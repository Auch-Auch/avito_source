package com.avito.android.advert_stats.item.details;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\f¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJP\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\bR\u001c\u0010\u0010\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0004R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u000bR\u0019\u0010\u0014\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b\u0014\u0010\u000eR\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010#\u001a\u0004\b+\u0010\u0004R\u0019\u0010\u0015\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010)\u001a\u0004\b\u0015\u0010\u000e¨\u0006/"}, d2 = {"Lcom/avito/android/advert_stats/item/details/StatDetailItem;", "Lcom/avito/conveyor_item/Item;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/lang/Integer;", "Lcom/avito/android/remote/model/Image;", "component4", "()Lcom/avito/android/remote/model/Image;", "", "component5", "()Z", "component6", "stringId", "text", "drawableId", "icon", "isStatusItem", "isHidden", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/avito/android/remote/model/Image;ZZ)Lcom/avito/android/advert_stats/item/details/StatDetailItem;", "toString", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/Integer;", "getDrawableId", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "d", "Lcom/avito/android/remote/model/Image;", "getIcon", "e", "Z", AuthSource.BOOKING_ORDER, "getText", "f", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/avito/android/remote/model/Image;ZZ)V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class StatDetailItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final Integer c;
    @Nullable
    public final Image d;
    public final boolean e;
    public final boolean f;

    public StatDetailItem(@NotNull String str, @NotNull String str2, @Nullable Integer num, @Nullable Image image, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "text");
        this.a = str;
        this.b = str2;
        this.c = num;
        this.d = image;
        this.e = z;
        this.f = z2;
    }

    public static /* synthetic */ StatDetailItem copy$default(StatDetailItem statDetailItem, String str, String str2, Integer num, Image image, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = statDetailItem.getStringId();
        }
        if ((i & 2) != 0) {
            str2 = statDetailItem.b;
        }
        if ((i & 4) != 0) {
            num = statDetailItem.c;
        }
        if ((i & 8) != 0) {
            image = statDetailItem.d;
        }
        if ((i & 16) != 0) {
            z = statDetailItem.e;
        }
        if ((i & 32) != 0) {
            z2 = statDetailItem.f;
        }
        return statDetailItem.copy(str, str2, num, image, z, z2);
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
    public final Integer component3() {
        return this.c;
    }

    @Nullable
    public final Image component4() {
        return this.d;
    }

    public final boolean component5() {
        return this.e;
    }

    public final boolean component6() {
        return this.f;
    }

    @NotNull
    public final StatDetailItem copy(@NotNull String str, @NotNull String str2, @Nullable Integer num, @Nullable Image image, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "text");
        return new StatDetailItem(str, str2, num, image, z, z2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StatDetailItem)) {
            return false;
        }
        StatDetailItem statDetailItem = (StatDetailItem) obj;
        return Intrinsics.areEqual(getStringId(), statDetailItem.getStringId()) && Intrinsics.areEqual(this.b, statDetailItem.b) && Intrinsics.areEqual(this.c, statDetailItem.c) && Intrinsics.areEqual(this.d, statDetailItem.d) && this.e == statDetailItem.e && this.f == statDetailItem.f;
    }

    @Nullable
    public final Integer getDrawableId() {
        return this.c;
    }

    @Nullable
    public final Image getIcon() {
        return this.d;
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
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Integer num = this.c;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        Image image = this.d;
        if (image != null) {
            i = image.hashCode();
        }
        int i2 = (hashCode3 + i) * 31;
        boolean z = this.e;
        int i3 = 1;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = (i2 + i4) * 31;
        boolean z2 = this.f;
        if (!z2) {
            i3 = z2 ? 1 : 0;
        }
        return i7 + i3;
    }

    public final boolean isHidden() {
        return this.f;
    }

    public final boolean isStatusItem() {
        return this.e;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("StatDetailItem(stringId=");
        L.append(getStringId());
        L.append(", text=");
        L.append(this.b);
        L.append(", drawableId=");
        L.append(this.c);
        L.append(", icon=");
        L.append(this.d);
        L.append(", isStatusItem=");
        L.append(this.e);
        L.append(", isHidden=");
        return a.B(L, this.f, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StatDetailItem(String str, String str2, Integer num, Image image, boolean z, boolean z2, int i, j jVar) {
        this(str, str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : image, (i & 16) != 0 ? false : z, (i & 32) != 0 ? false : z2);
    }
}
