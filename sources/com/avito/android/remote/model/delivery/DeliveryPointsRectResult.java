package com.avito.android.remote.model.delivery;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B7\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliveryPointsRectResult;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/delivery/Cluster;", "clusters", "Ljava/util/List;", "getClusters", "()Ljava/util/List;", "Lcom/avito/android/remote/model/delivery/Overlay;", "overlay", "Lcom/avito/android/remote/model/delivery/Overlay;", "getOverlay", "()Lcom/avito/android/remote/model/delivery/Overlay;", "Lcom/avito/android/remote/model/delivery/DeliveryPointRect;", "pins", "getPins", "Lcom/avito/android/remote/model/delivery/DeliveryPreselectPoint;", "preferredLocation", "Lcom/avito/android/remote/model/delivery/DeliveryPreselectPoint;", "getPreferredLocation", "()Lcom/avito/android/remote/model/delivery/DeliveryPreselectPoint;", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/avito/android/remote/model/delivery/Overlay;Lcom/avito/android/remote/model/delivery/DeliveryPreselectPoint;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryPointsRectResult implements Parcelable {
    public static final Parcelable.Creator<DeliveryPointsRectResult> CREATOR = new Creator();
    @SerializedName("clusters")
    @NotNull
    private final List<Cluster> clusters;
    @SerializedName("topOverlay")
    @Nullable
    private final Overlay overlay;
    @SerializedName("pins")
    @NotNull
    private final List<DeliveryPointRect> pins;
    @SerializedName("preferredLocation")
    @Nullable
    private final DeliveryPreselectPoint preferredLocation;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DeliveryPointsRectResult> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliveryPointsRectResult createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(DeliveryPointRect.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            int readInt2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList2.add(Cluster.CREATOR.createFromParcel(parcel));
                readInt2--;
            }
            return new DeliveryPointsRectResult(arrayList, arrayList2, (Overlay) parcel.readParcelable(DeliveryPointsRectResult.class.getClassLoader()), parcel.readInt() != 0 ? DeliveryPreselectPoint.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliveryPointsRectResult[] newArray(int i) {
            return new DeliveryPointsRectResult[i];
        }
    }

    public DeliveryPointsRectResult(@NotNull List<DeliveryPointRect> list, @NotNull List<Cluster> list2, @Nullable Overlay overlay2, @Nullable DeliveryPreselectPoint deliveryPreselectPoint) {
        Intrinsics.checkNotNullParameter(list, "pins");
        Intrinsics.checkNotNullParameter(list2, "clusters");
        this.pins = list;
        this.clusters = list2;
        this.overlay = overlay2;
        this.preferredLocation = deliveryPreselectPoint;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<Cluster> getClusters() {
        return this.clusters;
    }

    @Nullable
    public final Overlay getOverlay() {
        return this.overlay;
    }

    @NotNull
    public final List<DeliveryPointRect> getPins() {
        return this.pins;
    }

    @Nullable
    public final DeliveryPreselectPoint getPreferredLocation() {
        return this.preferredLocation;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Iterator n0 = a.n0(this.pins, parcel);
        while (n0.hasNext()) {
            ((DeliveryPointRect) n0.next()).writeToParcel(parcel, 0);
        }
        Iterator n02 = a.n0(this.clusters, parcel);
        while (n02.hasNext()) {
            ((Cluster) n02.next()).writeToParcel(parcel, 0);
        }
        parcel.writeParcelable(this.overlay, i);
        DeliveryPreselectPoint deliveryPreselectPoint = this.preferredLocation;
        if (deliveryPreselectPoint != null) {
            parcel.writeInt(1);
            deliveryPreselectPoint.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
