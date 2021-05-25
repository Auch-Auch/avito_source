package com.avito.android.remote.model.delivery;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Coordinates;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b,\u0010-J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ@\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u000bJ\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0016J \u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b!\u0010\"R\u001c\u0010\u000e\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010#\u001a\u0004\b$\u0010\tR\u001c\u0010\u000f\u001a\u00020\u00048\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010%\u001a\u0004\b&\u0010\u000bR\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010'\u001a\u0004\b(\u0010\u0006R\u0016\u0010*\u001a\u00020\u00048V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u000bR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b+\u0010\u000b¨\u0006."}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliveryPointRect;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/delivery/Markerable;", "", "", "component1", "()Ljava/util/List;", "Lcom/avito/android/remote/model/Coordinates;", "component2", "()Lcom/avito/android/remote/model/Coordinates;", "component3", "()Ljava/lang/String;", "component4", "serviceIds", "coordinates", "fiasGuid", "hint", "copy", "(Ljava/util/List;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/delivery/DeliveryPointRect;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Coordinates;", "getCoordinates", "Ljava/lang/String;", "getFiasGuid", "Ljava/util/List;", "getServiceIds", "getId", "id", "getHint", "<init>", "(Ljava/util/List;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/String;Ljava/lang/String;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryPointRect implements Parcelable, Markerable {
    public static final Parcelable.Creator<DeliveryPointRect> CREATOR = new Creator();
    @SerializedName("coordinates")
    @NotNull
    private final Coordinates coordinates;
    @SerializedName("fiasGuid")
    @NotNull
    private final String fiasGuid;
    @SerializedName("hint")
    @Nullable
    private final String hint;
    @SerializedName("serviceIds")
    @NotNull
    private final List<String> serviceIds;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DeliveryPointRect> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliveryPointRect createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new DeliveryPointRect(parcel.createStringArrayList(), (Coordinates) parcel.readParcelable(DeliveryPointRect.class.getClassLoader()), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliveryPointRect[] newArray(int i) {
            return new DeliveryPointRect[i];
        }
    }

    public DeliveryPointRect(@NotNull List<String> list, @NotNull Coordinates coordinates2, @NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(list, "serviceIds");
        Intrinsics.checkNotNullParameter(coordinates2, "coordinates");
        Intrinsics.checkNotNullParameter(str, "fiasGuid");
        this.serviceIds = list;
        this.coordinates = coordinates2;
        this.fiasGuid = str;
        this.hint = str2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.delivery.DeliveryPointRect */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeliveryPointRect copy$default(DeliveryPointRect deliveryPointRect, List list, Coordinates coordinates2, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = deliveryPointRect.serviceIds;
        }
        if ((i & 2) != 0) {
            coordinates2 = deliveryPointRect.coordinates;
        }
        if ((i & 4) != 0) {
            str = deliveryPointRect.fiasGuid;
        }
        if ((i & 8) != 0) {
            str2 = deliveryPointRect.hint;
        }
        return deliveryPointRect.copy(list, coordinates2, str, str2);
    }

    @NotNull
    public final List<String> component1() {
        return this.serviceIds;
    }

    @NotNull
    public final Coordinates component2() {
        return this.coordinates;
    }

    @NotNull
    public final String component3() {
        return this.fiasGuid;
    }

    @Nullable
    public final String component4() {
        return this.hint;
    }

    @NotNull
    public final DeliveryPointRect copy(@NotNull List<String> list, @NotNull Coordinates coordinates2, @NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(list, "serviceIds");
        Intrinsics.checkNotNullParameter(coordinates2, "coordinates");
        Intrinsics.checkNotNullParameter(str, "fiasGuid");
        return new DeliveryPointRect(list, coordinates2, str, str2);
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
        if (!(obj instanceof DeliveryPointRect)) {
            return false;
        }
        DeliveryPointRect deliveryPointRect = (DeliveryPointRect) obj;
        return Intrinsics.areEqual(this.serviceIds, deliveryPointRect.serviceIds) && Intrinsics.areEqual(this.coordinates, deliveryPointRect.coordinates) && Intrinsics.areEqual(this.fiasGuid, deliveryPointRect.fiasGuid) && Intrinsics.areEqual(this.hint, deliveryPointRect.hint);
    }

    @NotNull
    public final Coordinates getCoordinates() {
        return this.coordinates;
    }

    @NotNull
    public final String getFiasGuid() {
        return this.fiasGuid;
    }

    @Nullable
    public final String getHint() {
        return this.hint;
    }

    @Override // com.avito.android.remote.model.delivery.Markerable
    @NotNull
    public String getId() {
        return this.coordinates.toString();
    }

    @NotNull
    public final List<String> getServiceIds() {
        return this.serviceIds;
    }

    @Override // java.lang.Object
    public int hashCode() {
        List<String> list = this.serviceIds;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        Coordinates coordinates2 = this.coordinates;
        int hashCode2 = (hashCode + (coordinates2 != null ? coordinates2.hashCode() : 0)) * 31;
        String str = this.fiasGuid;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.hint;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("DeliveryPointRect(serviceIds=");
        L.append(this.serviceIds);
        L.append(", coordinates=");
        L.append(this.coordinates);
        L.append(", fiasGuid=");
        L.append(this.fiasGuid);
        L.append(", hint=");
        return a.t(L, this.hint, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeStringList(this.serviceIds);
        parcel.writeParcelable(this.coordinates, i);
        parcel.writeString(this.fiasGuid);
        parcel.writeString(this.hint);
    }
}
