package com.avito.android;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001:\u0001(B)\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J2\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0007R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0004R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010\u0007¨\u0006)"}, d2 = {"Lcom/avito/android/FilterAnalyticsData;", "Landroid/os/Parcelable;", "Lcom/avito/android/FilterAnalyticsData$Source;", "component1", "()Lcom/avito/android/FilterAnalyticsData$Source;", "", "component2", "()Ljava/lang/String;", "component3", "source", "userKey", "profileType", "copy", "(Lcom/avito/android/FilterAnalyticsData$Source;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/FilterAnalyticsData;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "c", "Ljava/lang/String;", "getProfileType", AuthSource.SEND_ABUSE, "Lcom/avito/android/FilterAnalyticsData$Source;", "getSource", AuthSource.BOOKING_ORDER, "getUserKey", "<init>", "(Lcom/avito/android/FilterAnalyticsData$Source;Ljava/lang/String;Ljava/lang/String;)V", "Source", "core_release"}, k = 1, mv = {1, 4, 2})
public final class FilterAnalyticsData implements Parcelable {
    public static final Parcelable.Creator<FilterAnalyticsData> CREATOR = new Creator();
    @NotNull
    public final Source a;
    @Nullable
    public final String b;
    @Nullable
    public final String c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<FilterAnalyticsData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FilterAnalyticsData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new FilterAnalyticsData((Source) Enum.valueOf(Source.class, parcel.readString()), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FilterAnalyticsData[] newArray(int i) {
            return new FilterAnalyticsData[i];
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/avito/android/FilterAnalyticsData$Source;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "GENERAL", "SHOP_LIST", "SHOP_DETAILED", "core_release"}, k = 1, mv = {1, 4, 2})
    public enum Source {
        GENERAL("general"),
        SHOP_LIST("proprofileList"),
        SHOP_DETAILED("proprofile");
        
        @NotNull
        public final String a;

        /* access modifiers changed from: public */
        Source(String str) {
            this.a = str;
        }

        @NotNull
        public final String getValue() {
            return this.a;
        }
    }

    public FilterAnalyticsData() {
        this(null, null, null, 7, null);
    }

    public FilterAnalyticsData(@NotNull Source source, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.a = source;
        this.b = str;
        this.c = str2;
    }

    public static /* synthetic */ FilterAnalyticsData copy$default(FilterAnalyticsData filterAnalyticsData, Source source, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            source = filterAnalyticsData.a;
        }
        if ((i & 2) != 0) {
            str = filterAnalyticsData.b;
        }
        if ((i & 4) != 0) {
            str2 = filterAnalyticsData.c;
        }
        return filterAnalyticsData.copy(source, str, str2);
    }

    @NotNull
    public final Source component1() {
        return this.a;
    }

    @Nullable
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final FilterAnalyticsData copy(@NotNull Source source, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new FilterAnalyticsData(source, str, str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterAnalyticsData)) {
            return false;
        }
        FilterAnalyticsData filterAnalyticsData = (FilterAnalyticsData) obj;
        return Intrinsics.areEqual(this.a, filterAnalyticsData.a) && Intrinsics.areEqual(this.b, filterAnalyticsData.b) && Intrinsics.areEqual(this.c, filterAnalyticsData.c);
    }

    @Nullable
    public final String getProfileType() {
        return this.c;
    }

    @NotNull
    public final Source getSource() {
        return this.a;
    }

    @Nullable
    public final String getUserKey() {
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Source source = this.a;
        int i = 0;
        int hashCode = (source != null ? source.hashCode() : 0) * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("FilterAnalyticsData(source=");
        L.append(this.a);
        L.append(", userKey=");
        L.append(this.b);
        L.append(", profileType=");
        return a.t(L, this.c, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a.name());
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FilterAnalyticsData(Source source, String str, String str2, int i, j jVar) {
        this((i & 1) != 0 ? Source.GENERAL : source, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
    }
}
