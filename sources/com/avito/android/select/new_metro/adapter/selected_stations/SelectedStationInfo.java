package com.avito.android.select.new_metro.adapter.selected_stations;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0011\u0010\nJ\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\nR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004¨\u0006!"}, d2 = {"Lcom/avito/android/select/new_metro/adapter/selected_stations/SelectedStationInfo;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/CharSequence;", "", "component3", "()I", "id", "name", "stationId", "copy", "(Ljava/lang/String;Ljava/lang/CharSequence;I)Lcom/avito/android/select/new_metro/adapter/selected_stations/SelectedStationInfo;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/CharSequence;", "getName", "c", "I", "getStationId", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", "<init>", "(Ljava/lang/String;Ljava/lang/CharSequence;I)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class SelectedStationInfo {
    @NotNull
    public final String a;
    @NotNull
    public final CharSequence b;
    public final int c;

    public SelectedStationInfo(@NotNull String str, @NotNull CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(charSequence, "name");
        this.a = str;
        this.b = charSequence;
        this.c = i;
    }

    public static /* synthetic */ SelectedStationInfo copy$default(SelectedStationInfo selectedStationInfo, String str, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = selectedStationInfo.a;
        }
        if ((i2 & 2) != 0) {
            charSequence = selectedStationInfo.b;
        }
        if ((i2 & 4) != 0) {
            i = selectedStationInfo.c;
        }
        return selectedStationInfo.copy(str, charSequence, i);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final CharSequence component2() {
        return this.b;
    }

    public final int component3() {
        return this.c;
    }

    @NotNull
    public final SelectedStationInfo copy(@NotNull String str, @NotNull CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(charSequence, "name");
        return new SelectedStationInfo(str, charSequence, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SelectedStationInfo)) {
            return false;
        }
        SelectedStationInfo selectedStationInfo = (SelectedStationInfo) obj;
        return Intrinsics.areEqual(this.a, selectedStationInfo.a) && Intrinsics.areEqual(this.b, selectedStationInfo.b) && this.c == selectedStationInfo.c;
    }

    @NotNull
    public final String getId() {
        return this.a;
    }

    @NotNull
    public final CharSequence getName() {
        return this.b;
    }

    public final int getStationId() {
        return this.c;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        CharSequence charSequence = this.b;
        if (charSequence != null) {
            i = charSequence.hashCode();
        }
        return ((hashCode + i) * 31) + this.c;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SelectedStationInfo(id=");
        L.append(this.a);
        L.append(", name=");
        L.append(this.b);
        L.append(", stationId=");
        return a.j(L, this.c, ")");
    }
}
