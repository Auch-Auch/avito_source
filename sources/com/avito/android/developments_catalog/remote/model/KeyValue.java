package com.avito.android.developments_catalog.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b#\u0010$J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ4\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001e\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b \u0010\u0004R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010!\u001a\u0004\b\"\u0010\b¨\u0006%"}, d2 = {"Lcom/avito/android/developments_catalog/remote/model/KeyValue;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/developments_catalog/remote/model/DopValue;", "component3", "()Lcom/avito/android/developments_catalog/remote/model/DopValue;", "name", "value", "dopValue", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/developments_catalog/remote/model/DopValue;)Lcom/avito/android/developments_catalog/remote/model/KeyValue;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getValue", "getName", "Lcom/avito/android/developments_catalog/remote/model/DopValue;", "getDopValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/developments_catalog/remote/model/DopValue;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class KeyValue implements Parcelable {
    public static final Parcelable.Creator<KeyValue> CREATOR = new Creator();
    @SerializedName("dopValue")
    @Nullable
    private final DopValue dopValue;
    @SerializedName("title")
    @Nullable
    private final String name;
    @SerializedName("value")
    @Nullable
    private final String value;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<KeyValue> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final KeyValue createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new KeyValue(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? DopValue.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final KeyValue[] newArray(int i) {
            return new KeyValue[i];
        }
    }

    public KeyValue(@Nullable String str, @Nullable String str2, @Nullable DopValue dopValue2) {
        this.name = str;
        this.value = str2;
        this.dopValue = dopValue2;
    }

    public static /* synthetic */ KeyValue copy$default(KeyValue keyValue, String str, String str2, DopValue dopValue2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = keyValue.name;
        }
        if ((i & 2) != 0) {
            str2 = keyValue.value;
        }
        if ((i & 4) != 0) {
            dopValue2 = keyValue.dopValue;
        }
        return keyValue.copy(str, str2, dopValue2);
    }

    @Nullable
    public final String component1() {
        return this.name;
    }

    @Nullable
    public final String component2() {
        return this.value;
    }

    @Nullable
    public final DopValue component3() {
        return this.dopValue;
    }

    @NotNull
    public final KeyValue copy(@Nullable String str, @Nullable String str2, @Nullable DopValue dopValue2) {
        return new KeyValue(str, str2, dopValue2);
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
        if (!(obj instanceof KeyValue)) {
            return false;
        }
        KeyValue keyValue = (KeyValue) obj;
        return Intrinsics.areEqual(this.name, keyValue.name) && Intrinsics.areEqual(this.value, keyValue.value) && Intrinsics.areEqual(this.dopValue, keyValue.dopValue);
    }

    @Nullable
    public final DopValue getDopValue() {
        return this.dopValue;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getValue() {
        return this.value;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        DopValue dopValue2 = this.dopValue;
        if (dopValue2 != null) {
            i = dopValue2.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("KeyValue(name=");
        L.append(this.name);
        L.append(", value=");
        L.append(this.value);
        L.append(", dopValue=");
        L.append(this.dopValue);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.name);
        parcel.writeString(this.value);
        DopValue dopValue2 = this.dopValue;
        if (dopValue2 != null) {
            parcel.writeInt(1);
            dopValue2.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ KeyValue(String str, String str2, DopValue dopValue2, int i, j jVar) {
        this(str, str2, (i & 4) != 0 ? null : dopValue2);
    }
}
