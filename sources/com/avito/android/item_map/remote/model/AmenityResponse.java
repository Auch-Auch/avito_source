package com.avito.android.item_map.remote.model;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u0005¨\u0006\u001f"}, d2 = {"Lcom/avito/android/item_map/remote/model/AmenityResponse;", "Landroid/os/Parcelable;", "", "Lcom/avito/android/item_map/remote/model/AmenityPin;", "component1", "()Ljava/util/List;", "pins", "copy", "(Ljava/util/List;)Lcom/avito/android/item_map/remote/model/AmenityResponse;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getPins", "<init>", "(Ljava/util/List;)V", "item-map_release"}, k = 1, mv = {1, 4, 2})
public final class AmenityResponse implements Parcelable {
    public static final Parcelable.Creator<AmenityResponse> CREATOR = new Creator();
    @SerializedName("pins")
    @NotNull
    private final List<AmenityPin> pins;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AmenityResponse> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AmenityResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(AmenityPin.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new AmenityResponse(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AmenityResponse[] newArray(int i) {
            return new AmenityResponse[i];
        }
    }

    public AmenityResponse(@NotNull List<AmenityPin> list) {
        Intrinsics.checkNotNullParameter(list, "pins");
        this.pins = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.item_map.remote.model.AmenityResponse */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AmenityResponse copy$default(AmenityResponse amenityResponse, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = amenityResponse.pins;
        }
        return amenityResponse.copy(list);
    }

    @NotNull
    public final List<AmenityPin> component1() {
        return this.pins;
    }

    @NotNull
    public final AmenityResponse copy(@NotNull List<AmenityPin> list) {
        Intrinsics.checkNotNullParameter(list, "pins");
        return new AmenityResponse(list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof AmenityResponse) && Intrinsics.areEqual(this.pins, ((AmenityResponse) obj).pins);
        }
        return true;
    }

    @NotNull
    public final List<AmenityPin> getPins() {
        return this.pins;
    }

    @Override // java.lang.Object
    public int hashCode() {
        List<AmenityPin> list = this.pins;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return a.w(a.L("AmenityResponse(pins="), this.pins, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Iterator n0 = a.n0(this.pins, parcel);
        while (n0.hasNext()) {
            ((AmenityPin) n0.next()).writeToParcel(parcel, 0);
        }
    }
}
