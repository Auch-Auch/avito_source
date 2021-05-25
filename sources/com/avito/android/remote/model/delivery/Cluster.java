package com.avito.android.remote.model.delivery;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Coordinates;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\f8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\u0018\u001a\u00020\u00158F@\u0006¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001a\u001a\u00020\u00198\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/avito/android/remote/model/delivery/Cluster;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/delivery/Markerable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "count", "Ljava/lang/String;", "getCount", "()Ljava/lang/String;", "getId", "id", "hint", "getHint", "", "getHasLabel", "()Z", "hasLabel", "Lcom/avito/android/remote/model/Coordinates;", "coordinates", "Lcom/avito/android/remote/model/Coordinates;", "getCoordinates", "()Lcom/avito/android/remote/model/Coordinates;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/String;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class Cluster implements Parcelable, Markerable {
    public static final Parcelable.Creator<Cluster> CREATOR = new Creator();
    @SerializedName("coordinates")
    @NotNull
    private final Coordinates coordinates;
    @SerializedName("count")
    @NotNull
    private final String count;
    @SerializedName("hint")
    @Nullable
    private final String hint;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<Cluster> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Cluster createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new Cluster(parcel.readString(), (Coordinates) parcel.readParcelable(Cluster.class.getClassLoader()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Cluster[] newArray(int i) {
            return new Cluster[i];
        }
    }

    public Cluster(@NotNull String str, @NotNull Coordinates coordinates2, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "count");
        Intrinsics.checkNotNullParameter(coordinates2, "coordinates");
        this.count = str;
        this.coordinates = coordinates2;
        this.hint = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final Coordinates getCoordinates() {
        return this.coordinates;
    }

    @NotNull
    public final String getCount() {
        return this.count;
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
        return this.count + String.valueOf(this.coordinates.getLatitude()) + String.valueOf(this.coordinates.getLongitude());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.count);
        parcel.writeParcelable(this.coordinates, i);
        parcel.writeString(this.hint);
    }
}
