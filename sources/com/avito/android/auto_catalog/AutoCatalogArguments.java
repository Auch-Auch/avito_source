package com.avito.android.auto_catalog;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J2\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0007R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u001f\u001a\u0004\b\"\u0010\u0007R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0004¨\u0006("}, d2 = {"Lcom/avito/android/auto_catalog/AutoCatalogArguments;", "Landroid/os/Parcelable;", "Lcom/avito/android/auto_catalog/AutoCatalogData;", "component1", "()Lcom/avito/android/auto_catalog/AutoCatalogData;", "", "component2", "()Ljava/lang/String;", "component3", "autoCatalogData", "searchContext", "from", "copy", "(Lcom/avito/android/auto_catalog/AutoCatalogData;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/auto_catalog/AutoCatalogArguments;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "c", "Ljava/lang/String;", "getFrom", AuthSource.BOOKING_ORDER, "getSearchContext", AuthSource.SEND_ABUSE, "Lcom/avito/android/auto_catalog/AutoCatalogData;", "getAutoCatalogData", "<init>", "(Lcom/avito/android/auto_catalog/AutoCatalogData;Ljava/lang/String;Ljava/lang/String;)V", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class AutoCatalogArguments implements Parcelable {
    public static final Parcelable.Creator<AutoCatalogArguments> CREATOR = new Creator();
    @NotNull
    public final AutoCatalogData a;
    @Nullable
    public final String b;
    @Nullable
    public final String c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AutoCatalogArguments> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AutoCatalogArguments createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AutoCatalogArguments(AutoCatalogData.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AutoCatalogArguments[] newArray(int i) {
            return new AutoCatalogArguments[i];
        }
    }

    public AutoCatalogArguments(@NotNull AutoCatalogData autoCatalogData, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(autoCatalogData, "autoCatalogData");
        this.a = autoCatalogData;
        this.b = str;
        this.c = str2;
    }

    public static /* synthetic */ AutoCatalogArguments copy$default(AutoCatalogArguments autoCatalogArguments, AutoCatalogData autoCatalogData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            autoCatalogData = autoCatalogArguments.a;
        }
        if ((i & 2) != 0) {
            str = autoCatalogArguments.b;
        }
        if ((i & 4) != 0) {
            str2 = autoCatalogArguments.c;
        }
        return autoCatalogArguments.copy(autoCatalogData, str, str2);
    }

    @NotNull
    public final AutoCatalogData component1() {
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
    public final AutoCatalogArguments copy(@NotNull AutoCatalogData autoCatalogData, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(autoCatalogData, "autoCatalogData");
        return new AutoCatalogArguments(autoCatalogData, str, str2);
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
        if (!(obj instanceof AutoCatalogArguments)) {
            return false;
        }
        AutoCatalogArguments autoCatalogArguments = (AutoCatalogArguments) obj;
        return Intrinsics.areEqual(this.a, autoCatalogArguments.a) && Intrinsics.areEqual(this.b, autoCatalogArguments.b) && Intrinsics.areEqual(this.c, autoCatalogArguments.c);
    }

    @NotNull
    public final AutoCatalogData getAutoCatalogData() {
        return this.a;
    }

    @Nullable
    public final String getFrom() {
        return this.c;
    }

    @Nullable
    public final String getSearchContext() {
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        AutoCatalogData autoCatalogData = this.a;
        int i = 0;
        int hashCode = (autoCatalogData != null ? autoCatalogData.hashCode() : 0) * 31;
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
        StringBuilder L = a.L("AutoCatalogArguments(autoCatalogData=");
        L.append(this.a);
        L.append(", searchContext=");
        L.append(this.b);
        L.append(", from=");
        return a.t(L, this.c, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.a.writeToParcel(parcel, 0);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}
