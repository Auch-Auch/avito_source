package com.avito.android.auto_catalog.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b%\u0010&J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\n\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000b\u0010\bJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0012\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0014J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010\f\u001a\u00020\u00048\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\bR\u001c\u0010\u000e\u001a\u00020\u00048\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b\"\u0010\bR\u001c\u0010\u000f\u001a\u00020\u00048\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b#\u0010\bR\u001c\u0010\r\u001a\u00020\u00048\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b$\u0010\b¨\u0006'"}, d2 = {"Lcom/avito/android/auto_catalog/remote/model/PluralString;", "Landroid/os/Parcelable;", "", "count", "", "getStringByCount", "(I)Ljava/lang/String;", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "one", "few", "many", "other", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/auto_catalog/remote/model/PluralString;", "toString", "hashCode", "()I", "", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getOne", "getMany", "getOther", "getFew", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class PluralString implements Parcelable {
    public static final Parcelable.Creator<PluralString> CREATOR = new Creator();
    @SerializedName("few")
    @NotNull
    private final String few;
    @SerializedName("many")
    @NotNull
    private final String many;
    @SerializedName("one")
    @NotNull
    private final String one;
    @SerializedName("other")
    @NotNull
    private final String other;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PluralString> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PluralString createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new PluralString(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PluralString[] newArray(int i) {
            return new PluralString[i];
        }
    }

    public PluralString(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        a.b1(str, "one", str2, "few", str3, "many", str4, "other");
        this.one = str;
        this.few = str2;
        this.many = str3;
        this.other = str4;
    }

    public static /* synthetic */ PluralString copy$default(PluralString pluralString, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pluralString.one;
        }
        if ((i & 2) != 0) {
            str2 = pluralString.few;
        }
        if ((i & 4) != 0) {
            str3 = pluralString.many;
        }
        if ((i & 8) != 0) {
            str4 = pluralString.other;
        }
        return pluralString.copy(str, str2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.one;
    }

    @NotNull
    public final String component2() {
        return this.few;
    }

    @NotNull
    public final String component3() {
        return this.many;
    }

    @NotNull
    public final String component4() {
        return this.other;
    }

    @NotNull
    public final PluralString copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "one");
        Intrinsics.checkNotNullParameter(str2, "few");
        Intrinsics.checkNotNullParameter(str3, "many");
        Intrinsics.checkNotNullParameter(str4, "other");
        return new PluralString(str, str2, str3, str4);
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
        if (!(obj instanceof PluralString)) {
            return false;
        }
        PluralString pluralString = (PluralString) obj;
        return Intrinsics.areEqual(this.one, pluralString.one) && Intrinsics.areEqual(this.few, pluralString.few) && Intrinsics.areEqual(this.many, pluralString.many) && Intrinsics.areEqual(this.other, pluralString.other);
    }

    @NotNull
    public final String getFew() {
        return this.few;
    }

    @NotNull
    public final String getMany() {
        return this.many;
    }

    @NotNull
    public final String getOne() {
        return this.one;
    }

    @NotNull
    public final String getOther() {
        return this.other;
    }

    @NotNull
    public final String getStringByCount(int i) {
        if (i == 1) {
            return this.one;
        }
        if (i == 2 || i == 3 || i == 4) {
            return this.few;
        }
        if (i != 5) {
            return this.other;
        }
        return this.many;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.one;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.few;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.many;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.other;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("PluralString(one=");
        L.append(this.one);
        L.append(", few=");
        L.append(this.few);
        L.append(", many=");
        L.append(this.many);
        L.append(", other=");
        return a.t(L, this.other, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.one);
        parcel.writeString(this.few);
        parcel.writeString(this.many);
        parcel.writeString(this.other);
    }
}
