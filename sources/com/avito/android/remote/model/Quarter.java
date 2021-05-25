package com.avito.android.remote.model;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ<\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0012J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010!\u001a\u0004\b\"\u0010\bR\u0016\u0010$\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b%\u0010\u0004R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010!\u001a\u0004\b&\u0010\b¨\u0006)"}, d2 = {"Lcom/avito/android/remote/model/Quarter;", "Lcom/avito/android/remote/model/ParcelableEntity;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/lang/Integer;", "component4", "id", "title", "fromInt", "toInt", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/avito/android/remote/model/Quarter;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getId", "Ljava/lang/Integer;", "getToInt", "getName", "name", "getTitle", "getFromInt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class Quarter implements ParcelableEntity<String> {
    public static final Parcelable.Creator<Quarter> CREATOR = new Creator();
    @SerializedName("fromInt")
    @Nullable
    private final Integer fromInt;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName("toInt")
    @Nullable
    private final Integer toInt;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<Quarter> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Quarter createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            Integer num = null;
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            if (parcel.readInt() != 0) {
                num = Integer.valueOf(parcel.readInt());
            }
            return new Quarter(readString, readString2, valueOf, num);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Quarter[] newArray(int i) {
            return new Quarter[i];
        }
    }

    public Quarter(@NotNull String str, @NotNull String str2, @Nullable Integer num, @Nullable Integer num2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.id = str;
        this.title = str2;
        this.fromInt = num;
        this.toInt = num2;
    }

    public static /* synthetic */ Quarter copy$default(Quarter quarter, String str, String str2, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = quarter.getId();
        }
        if ((i & 2) != 0) {
            str2 = quarter.title;
        }
        if ((i & 4) != 0) {
            num = quarter.fromInt;
        }
        if ((i & 8) != 0) {
            num2 = quarter.toInt;
        }
        return quarter.copy(str, str2, num, num2);
    }

    @NotNull
    public final String component1() {
        return getId();
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final Integer component3() {
        return this.fromInt;
    }

    @Nullable
    public final Integer component4() {
        return this.toInt;
    }

    @NotNull
    public final Quarter copy(@NotNull String str, @NotNull String str2, @Nullable Integer num, @Nullable Integer num2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new Quarter(str, str2, num, num2);
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
        if (!(obj instanceof Quarter)) {
            return false;
        }
        Quarter quarter = (Quarter) obj;
        return Intrinsics.areEqual(getId(), quarter.getId()) && Intrinsics.areEqual(this.title, quarter.title) && Intrinsics.areEqual(this.fromInt, quarter.fromInt) && Intrinsics.areEqual(this.toInt, quarter.toInt);
    }

    @Nullable
    public final Integer getFromInt() {
        return this.fromInt;
    }

    @Override // com.avito.android.remote.model.Entity
    @NotNull
    public String getName() {
        return this.title;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final Integer getToInt() {
        return this.toInt;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String id2 = getId();
        int i = 0;
        int hashCode = (id2 != null ? id2.hashCode() : 0) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Integer num = this.fromInt;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.toInt;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("Quarter(id=");
        L.append(getId());
        L.append(", title=");
        L.append(this.title);
        L.append(", fromInt=");
        L.append(this.fromInt);
        L.append(", toInt=");
        return a.p(L, this.toInt, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        Integer num = this.fromInt;
        if (num != null) {
            a.H0(parcel, 1, num);
        } else {
            parcel.writeInt(0);
        }
        Integer num2 = this.toInt;
        if (num2 != null) {
            a.H0(parcel, 1, num2);
        } else {
            parcel.writeInt(0);
        }
    }

    @Override // com.avito.android.remote.model.Entity
    @NotNull
    public String getId() {
        return this.id;
    }
}
