package com.avito.android.remote.model.delivery;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.avito.android.remote.model.Coordinates;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0005JD\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0016J \u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b!\u0010\"R\u0013\u0010%\u001a\u00020\u00198F@\u0006¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001c\u0010\f\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\f\u0010&\u001a\u0004\b'\u0010\u0005R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010&\u001a\u0004\b(\u0010\u0005R\u001c\u0010\u000f\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010)\u001a\u0004\b*\u0010\nR\u001c\u0010\r\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010&\u001a\u0004\b+\u0010\u0005R\u001c\u0010\u000e\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010&\u001a\u0004\b,\u0010\u0005¨\u0006/"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliveryPointGeo;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/delivery/Markerable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Lcom/avito/android/remote/model/Coordinates;", "component4", "()Lcom/avito/android/remote/model/Coordinates;", "component5", "id", NotificationCompat.CATEGORY_SERVICE, "fiasGuid", "coordinates", "hint", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/String;)Lcom/avito/android/remote/model/delivery/DeliveryPointGeo;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "getHasLabel", "()Z", "hasLabel", "Ljava/lang/String;", "getId", "getHint", "Lcom/avito/android/remote/model/Coordinates;", "getCoordinates", "getService", "getFiasGuid", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/String;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryPointGeo implements Parcelable, Markerable {
    public static final Parcelable.Creator<DeliveryPointGeo> CREATOR = new Creator();
    @SerializedName("coordinates")
    @NotNull
    private final Coordinates coordinates;
    @SerializedName("fiasGuid")
    @NotNull
    private final String fiasGuid;
    @SerializedName("hint")
    @Nullable
    private final String hint;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName(NotificationCompat.CATEGORY_SERVICE)
    @NotNull
    private final String service;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DeliveryPointGeo> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliveryPointGeo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new DeliveryPointGeo(parcel.readString(), parcel.readString(), parcel.readString(), (Coordinates) parcel.readParcelable(DeliveryPointGeo.class.getClassLoader()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliveryPointGeo[] newArray(int i) {
            return new DeliveryPointGeo[i];
        }
    }

    public DeliveryPointGeo(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Coordinates coordinates2, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_SERVICE);
        Intrinsics.checkNotNullParameter(str3, "fiasGuid");
        Intrinsics.checkNotNullParameter(coordinates2, "coordinates");
        this.id = str;
        this.service = str2;
        this.fiasGuid = str3;
        this.coordinates = coordinates2;
        this.hint = str4;
    }

    public static /* synthetic */ DeliveryPointGeo copy$default(DeliveryPointGeo deliveryPointGeo, String str, String str2, String str3, Coordinates coordinates2, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deliveryPointGeo.getId();
        }
        if ((i & 2) != 0) {
            str2 = deliveryPointGeo.service;
        }
        if ((i & 4) != 0) {
            str3 = deliveryPointGeo.fiasGuid;
        }
        if ((i & 8) != 0) {
            coordinates2 = deliveryPointGeo.coordinates;
        }
        if ((i & 16) != 0) {
            str4 = deliveryPointGeo.hint;
        }
        return deliveryPointGeo.copy(str, str2, str3, coordinates2, str4);
    }

    @NotNull
    public final String component1() {
        return getId();
    }

    @NotNull
    public final String component2() {
        return this.service;
    }

    @NotNull
    public final String component3() {
        return this.fiasGuid;
    }

    @NotNull
    public final Coordinates component4() {
        return this.coordinates;
    }

    @Nullable
    public final String component5() {
        return this.hint;
    }

    @NotNull
    public final DeliveryPointGeo copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Coordinates coordinates2, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_SERVICE);
        Intrinsics.checkNotNullParameter(str3, "fiasGuid");
        Intrinsics.checkNotNullParameter(coordinates2, "coordinates");
        return new DeliveryPointGeo(str, str2, str3, coordinates2, str4);
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
        if (!(obj instanceof DeliveryPointGeo)) {
            return false;
        }
        DeliveryPointGeo deliveryPointGeo = (DeliveryPointGeo) obj;
        return Intrinsics.areEqual(getId(), deliveryPointGeo.getId()) && Intrinsics.areEqual(this.service, deliveryPointGeo.service) && Intrinsics.areEqual(this.fiasGuid, deliveryPointGeo.fiasGuid) && Intrinsics.areEqual(this.coordinates, deliveryPointGeo.coordinates) && Intrinsics.areEqual(this.hint, deliveryPointGeo.hint);
    }

    @NotNull
    public final Coordinates getCoordinates() {
        return this.coordinates;
    }

    @NotNull
    public final String getFiasGuid() {
        return this.fiasGuid;
    }

    public final boolean getHasLabel() {
        return this.hint != null;
    }

    @Nullable
    public final String getHint() {
        return this.hint;
    }

    @Override // com.avito.android.remote.model.delivery.Markerable
    @NotNull
    public String getId() {
        return this.id;
    }

    @NotNull
    public final String getService() {
        return this.service;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String id2 = getId();
        int i = 0;
        int hashCode = (id2 != null ? id2.hashCode() : 0) * 31;
        String str = this.service;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.fiasGuid;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Coordinates coordinates2 = this.coordinates;
        int hashCode4 = (hashCode3 + (coordinates2 != null ? coordinates2.hashCode() : 0)) * 31;
        String str3 = this.hint;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode4 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("DeliveryPointGeo(id=");
        L.append(getId());
        L.append(", service=");
        L.append(this.service);
        L.append(", fiasGuid=");
        L.append(this.fiasGuid);
        L.append(", coordinates=");
        L.append(this.coordinates);
        L.append(", hint=");
        return a.t(L, this.hint, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.service);
        parcel.writeString(this.fiasGuid);
        parcel.writeParcelable(this.coordinates, i);
        parcel.writeString(this.hint);
    }
}
