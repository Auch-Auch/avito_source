package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0010J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010\b¨\u0006#"}, d2 = {"Lcom/avito/android/remote/model/PriceDescription;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/PriceFeatureSwitch;", "component2", "()Ljava/util/List;", "title", "featureSwitches", "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/remote/model/PriceDescription;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Ljava/util/List;", "getFeatureSwitches", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class PriceDescription implements Parcelable {
    public static final Parcelable.Creator<PriceDescription> CREATOR = new Creator();
    @SerializedName("switches")
    @NotNull
    private final List<PriceFeatureSwitch> featureSwitches;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PriceDescription> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PriceDescription createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(PriceFeatureSwitch.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new PriceDescription(readString, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PriceDescription[] newArray(int i) {
            return new PriceDescription[i];
        }
    }

    public PriceDescription(@NotNull String str, @NotNull List<PriceFeatureSwitch> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "featureSwitches");
        this.title = str;
        this.featureSwitches = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.PriceDescription */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PriceDescription copy$default(PriceDescription priceDescription, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = priceDescription.title;
        }
        if ((i & 2) != 0) {
            list = priceDescription.featureSwitches;
        }
        return priceDescription.copy(str, list);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final List<PriceFeatureSwitch> component2() {
        return this.featureSwitches;
    }

    @NotNull
    public final PriceDescription copy(@NotNull String str, @NotNull List<PriceFeatureSwitch> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "featureSwitches");
        return new PriceDescription(str, list);
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
        if (!(obj instanceof PriceDescription)) {
            return false;
        }
        PriceDescription priceDescription = (PriceDescription) obj;
        return Intrinsics.areEqual(this.title, priceDescription.title) && Intrinsics.areEqual(this.featureSwitches, priceDescription.featureSwitches);
    }

    @NotNull
    public final List<PriceFeatureSwitch> getFeatureSwitches() {
        return this.featureSwitches;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<PriceFeatureSwitch> list = this.featureSwitches;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("PriceDescription(title=");
        L.append(this.title);
        L.append(", featureSwitches=");
        return a.w(L, this.featureSwitches, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        Iterator n0 = a.n0(this.featureSwitches, parcel);
        while (n0.hasNext()) {
            ((PriceFeatureSwitch) n0.next()).writeToParcel(parcel, 0);
        }
    }
}
