package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004JD\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0015J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b \u0010!R\u001c\u0010\f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\"\u001a\u0004\b#\u0010\u0004R$\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010$\u001a\u0004\b%\u0010\nR\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010&\u001a\u0004\b'\u0010\u0007R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b(\u0010\u0004¨\u0006+"}, d2 = {"Lcom/avito/android/remote/model/PriceFeatureSwitch;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/SwitchType;", "component2", "()Lcom/avito/android/remote/model/SwitchType;", "", "component3", "()Ljava/util/List;", "component4", "title", "type", "features", "fallback", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/SwitchType;Ljava/util/List;Ljava/lang/String;)Lcom/avito/android/remote/model/PriceFeatureSwitch;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Ljava/util/List;", "getFeatures", "Lcom/avito/android/remote/model/SwitchType;", "getType", "getFallback", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/SwitchType;Ljava/util/List;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class PriceFeatureSwitch implements Parcelable {
    public static final Parcelable.Creator<PriceFeatureSwitch> CREATOR = new Creator();
    @SerializedName("fallback")
    @Nullable
    private final String fallback;
    @SerializedName("list")
    @Nullable
    private final List<String> features;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName("type")
    @Nullable
    private final SwitchType type;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PriceFeatureSwitch> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PriceFeatureSwitch createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new PriceFeatureSwitch(parcel.readString(), parcel.readInt() != 0 ? (SwitchType) Enum.valueOf(SwitchType.class, parcel.readString()) : null, parcel.createStringArrayList(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PriceFeatureSwitch[] newArray(int i) {
            return new PriceFeatureSwitch[i];
        }
    }

    public PriceFeatureSwitch(@NotNull String str, @Nullable SwitchType switchType, @Nullable List<String> list, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.title = str;
        this.type = switchType;
        this.features = list;
        this.fallback = str2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.PriceFeatureSwitch */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PriceFeatureSwitch copy$default(PriceFeatureSwitch priceFeatureSwitch, String str, SwitchType switchType, List list, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = priceFeatureSwitch.title;
        }
        if ((i & 2) != 0) {
            switchType = priceFeatureSwitch.type;
        }
        if ((i & 4) != 0) {
            list = priceFeatureSwitch.features;
        }
        if ((i & 8) != 0) {
            str2 = priceFeatureSwitch.fallback;
        }
        return priceFeatureSwitch.copy(str, switchType, list, str2);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final SwitchType component2() {
        return this.type;
    }

    @Nullable
    public final List<String> component3() {
        return this.features;
    }

    @Nullable
    public final String component4() {
        return this.fallback;
    }

    @NotNull
    public final PriceFeatureSwitch copy(@NotNull String str, @Nullable SwitchType switchType, @Nullable List<String> list, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        return new PriceFeatureSwitch(str, switchType, list, str2);
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
        if (!(obj instanceof PriceFeatureSwitch)) {
            return false;
        }
        PriceFeatureSwitch priceFeatureSwitch = (PriceFeatureSwitch) obj;
        return Intrinsics.areEqual(this.title, priceFeatureSwitch.title) && Intrinsics.areEqual(this.type, priceFeatureSwitch.type) && Intrinsics.areEqual(this.features, priceFeatureSwitch.features) && Intrinsics.areEqual(this.fallback, priceFeatureSwitch.fallback);
    }

    @Nullable
    public final String getFallback() {
        return this.fallback;
    }

    @Nullable
    public final List<String> getFeatures() {
        return this.features;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final SwitchType getType() {
        return this.type;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        SwitchType switchType = this.type;
        int hashCode2 = (hashCode + (switchType != null ? switchType.hashCode() : 0)) * 31;
        List<String> list = this.features;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.fallback;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("PriceFeatureSwitch(title=");
        L.append(this.title);
        L.append(", type=");
        L.append(this.type);
        L.append(", features=");
        L.append(this.features);
        L.append(", fallback=");
        return a.t(L, this.fallback, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        SwitchType switchType = this.type;
        if (switchType != null) {
            parcel.writeInt(1);
            parcel.writeString(switchType.name());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeStringList(this.features);
        parcel.writeString(this.fallback);
    }
}
