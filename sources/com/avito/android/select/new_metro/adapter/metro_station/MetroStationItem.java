package com.avito.android.select.new_metro.adapter.metro_station;

import a2.b.a.a.a;
import a2.g.r.g;
import android.text.SpannableStringBuilder;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.select.new_metro.adapter.ComparableContent;
import com.avito.conveyor_item.Item;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b0\b\b\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u0018\u001a\u00020\u0010\u0012\u0006\u0010\u0019\u001a\u00020\r\u0012\u0006\u0010\u001a\u001a\u00020\u0003¢\u0006\u0004\b>\u0010?J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0005J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0005JH\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u00032\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u0018\u001a\u00020\u00102\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0014J\u001a\u0010\u001f\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÖ\u0003¢\u0006\u0004\b\u001f\u0010\nR\u0019\u0010\u001a\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0005R\u0019\u0010\u0019\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0014R\"\u0010,\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010.\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b-\u0010'\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R\u0019\u00103\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u0012R\u001c\u0010\u0016\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b4\u0010!\u001a\u0004\b5\u0010\u0005R\"\u00107\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b6\u0010'\u001a\u0004\b7\u0010)\"\u0004\b8\u0010+R\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010\u000fR\u0019\u0010\u0018\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b<\u00101\u001a\u0004\b=\u0010\u0012¨\u0006@"}, d2 = {"Lcom/avito/android/select/new_metro/adapter/metro_station/MetroStationItem;", "Lcom/avito/conveyor_item/Item;", "Lcom/avito/android/select/new_metro/adapter/ComparableContent;", "", "toString", "()Ljava/lang/String;", "", "second", "", "hasSameContentAs", "(Ljava/lang/Object;)Z", "component1", "", "", "component2", "()Ljava/util/List;", "", "component3", "()Ljava/lang/CharSequence;", "component4", "()I", "component5", "stringId", "lineIds", "linesColor", "stationId", "stationName", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/CharSequence;ILjava/lang/String;)Lcom/avito/android/select/new_metro/adapter/metro_station/MetroStationItem;", "hashCode", "other", "equals", "i", "Ljava/lang/String;", "getStationName", "h", "I", "getStationId", AuthSource.BOOKING_ORDER, "Z", "getShowLineColor", "()Z", "setShowLineColor", "(Z)V", "showLineColor", "c", "isSearchItem", "setSearchItem", "d", "Ljava/lang/CharSequence;", "getStationNameWithLineColor", "stationNameWithLineColor", "e", "getStringId", AuthSource.SEND_ABUSE, "isChecked", "setChecked", "f", "Ljava/util/List;", "getLineIds", g.a, "getLinesColor", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/CharSequence;ILjava/lang/String;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class MetroStationItem implements Item, ComparableContent {
    public boolean a;
    public boolean b = true;
    public boolean c;
    @NotNull
    public final CharSequence d;
    @NotNull
    public final String e;
    @NotNull
    public final List<Integer> f;
    @NotNull
    public final CharSequence g;
    public final int h;
    @NotNull
    public final String i;

    public MetroStationItem(@NotNull String str, @NotNull List<Integer> list, @NotNull CharSequence charSequence, int i2, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(list, "lineIds");
        Intrinsics.checkNotNullParameter(charSequence, "linesColor");
        Intrinsics.checkNotNullParameter(str2, "stationName");
        this.e = str;
        this.f = list;
        this.g = charSequence;
        this.h = i2;
        this.i = str2;
        SpannableStringBuilder append = new SpannableStringBuilder(charSequence).append((CharSequence) str2);
        Intrinsics.checkNotNullExpressionValue(append, "SpannableStringBuilder(l…olor).append(stationName)");
        this.d = append;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.select.new_metro.adapter.metro_station.MetroStationItem */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MetroStationItem copy$default(MetroStationItem metroStationItem, String str, List list, CharSequence charSequence, int i2, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = metroStationItem.getStringId();
        }
        if ((i3 & 2) != 0) {
            list = metroStationItem.f;
        }
        if ((i3 & 4) != 0) {
            charSequence = metroStationItem.g;
        }
        if ((i3 & 8) != 0) {
            i2 = metroStationItem.h;
        }
        if ((i3 & 16) != 0) {
            str2 = metroStationItem.i;
        }
        return metroStationItem.copy(str, list, charSequence, i2, str2);
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @NotNull
    public final List<Integer> component2() {
        return this.f;
    }

    @NotNull
    public final CharSequence component3() {
        return this.g;
    }

    public final int component4() {
        return this.h;
    }

    @NotNull
    public final String component5() {
        return this.i;
    }

    @NotNull
    public final MetroStationItem copy(@NotNull String str, @NotNull List<Integer> list, @NotNull CharSequence charSequence, int i2, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(list, "lineIds");
        Intrinsics.checkNotNullParameter(charSequence, "linesColor");
        Intrinsics.checkNotNullParameter(str2, "stationName");
        return new MetroStationItem(str, list, charSequence, i2, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetroStationItem)) {
            return false;
        }
        MetroStationItem metroStationItem = (MetroStationItem) obj;
        return Intrinsics.areEqual(getStringId(), metroStationItem.getStringId()) && Intrinsics.areEqual(this.f, metroStationItem.f) && Intrinsics.areEqual(this.g, metroStationItem.g) && this.h == metroStationItem.h && Intrinsics.areEqual(this.i, metroStationItem.i);
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @NotNull
    public final List<Integer> getLineIds() {
        return this.f;
    }

    @NotNull
    public final CharSequence getLinesColor() {
        return this.g;
    }

    public final boolean getShowLineColor() {
        return this.b;
    }

    public final int getStationId() {
        return this.h;
    }

    @NotNull
    public final String getStationName() {
        return this.i;
    }

    @NotNull
    public final CharSequence getStationNameWithLineColor() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.e;
    }

    @Override // com.avito.android.select.new_metro.adapter.ComparableContent
    public boolean hasSameContentAs(@Nullable Object obj) {
        if (Intrinsics.areEqual(this, obj)) {
            boolean z = this.a;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.avito.android.select.new_metro.adapter.metro_station.MetroStationItem");
            MetroStationItem metroStationItem = (MetroStationItem) obj;
            if (z == metroStationItem.a && this.b == metroStationItem.b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String stringId = getStringId();
        int i2 = 0;
        int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
        List<Integer> list = this.f;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        CharSequence charSequence = this.g;
        int hashCode3 = (((hashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31) + this.h) * 31;
        String str = this.i;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode3 + i2;
    }

    public final boolean isChecked() {
        return this.a;
    }

    public final boolean isSearchItem() {
        return this.c;
    }

    public final void setChecked(boolean z) {
        this.a = z;
    }

    public final void setSearchItem(boolean z) {
        this.c = z;
    }

    public final void setShowLineColor(boolean z) {
        this.b = z;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("MetroStationItem(lineIds=");
        L.append(this.f);
        L.append(", stationId=");
        L.append(this.h);
        L.append(", stationName='");
        L.append(this.i);
        L.append("', isChecked=");
        return a.A(L, this.a, ')');
    }
}
