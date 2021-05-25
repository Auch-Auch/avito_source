package com.avito.android.remote.model.delivery;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliveryPreselectPoint;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "zoomLevel", "Ljava/lang/Float;", "getZoomLevel", "()Ljava/lang/Float;", "Lcom/avito/android/remote/model/delivery/DeliveryPointRect;", "pin", "Lcom/avito/android/remote/model/delivery/DeliveryPointRect;", "getPin", "()Lcom/avito/android/remote/model/delivery/DeliveryPointRect;", "", "moveCamera", "Ljava/lang/Boolean;", "getMoveCamera", "()Ljava/lang/Boolean;", "<init>", "(Lcom/avito/android/remote/model/delivery/DeliveryPointRect;Ljava/lang/Float;Ljava/lang/Boolean;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryPreselectPoint implements Parcelable {
    public static final Parcelable.Creator<DeliveryPreselectPoint> CREATOR = new Creator();
    @SerializedName("moveCamera")
    @Nullable
    private final Boolean moveCamera;
    @SerializedName("pin")
    @NotNull
    private final DeliveryPointRect pin;
    @SerializedName("zoomLevel")
    @Nullable
    private final Float zoomLevel;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DeliveryPreselectPoint> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliveryPreselectPoint createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            DeliveryPointRect createFromParcel = DeliveryPointRect.CREATOR.createFromParcel(parcel);
            Boolean bool = null;
            Float valueOf = parcel.readInt() != 0 ? Float.valueOf(parcel.readFloat()) : null;
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new DeliveryPreselectPoint(createFromParcel, valueOf, bool);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliveryPreselectPoint[] newArray(int i) {
            return new DeliveryPreselectPoint[i];
        }
    }

    public DeliveryPreselectPoint(@NotNull DeliveryPointRect deliveryPointRect, @Nullable Float f, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(deliveryPointRect, "pin");
        this.pin = deliveryPointRect;
        this.zoomLevel = f;
        this.moveCamera = bool;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Boolean getMoveCamera() {
        return this.moveCamera;
    }

    @NotNull
    public final DeliveryPointRect getPin() {
        return this.pin;
    }

    @Nullable
    public final Float getZoomLevel() {
        return this.zoomLevel;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.pin.writeToParcel(parcel, 0);
        Float f = this.zoomLevel;
        if (f != null) {
            parcel.writeInt(1);
            parcel.writeFloat(f.floatValue());
        } else {
            parcel.writeInt(0);
        }
        Boolean bool = this.moveCamera;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
    }
}
