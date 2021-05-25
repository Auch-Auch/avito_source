package com.avito.android.remote.model.delivery;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.util.Parcels;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 (2\u00020\u0001:\u0001(B;\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\"\u001a\u00020\u0011\u0012\u0006\u0010\u001b\u001a\u00020\u0011\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0004R\u001c\u0010\u0012\u001a\u00020\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u00020\u00168\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u00020\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u0015R\u0013\u0010!\u001a\u00020\r8F@\u0006¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\u00020\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010\u0015R\u001e\u0010$\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b$\u0010\u0013\u001a\u0004\b%\u0010\u0015¨\u0006)"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliveryPoint;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "o", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Coordinates;", "coordinates", "Lcom/avito/android/remote/model/Coordinates;", "getCoordinates", "()Lcom/avito/android/remote/model/Coordinates;", "title", "getTitle", "hint", "getHint", "getHasLabel", "()Z", "hasLabel", NotificationCompat.CATEGORY_SERVICE, "getService", MessengerShareContentUtility.SUBTITLE, "getSubtitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/String;)V", "Companion", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryPoint implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<DeliveryPoint> CREATOR = Parcels.creator(DeliveryPoint$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("coordinates")
    @NotNull
    private final Coordinates coordinates;
    @SerializedName("hint")
    @Nullable
    private final String hint;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName(NotificationCompat.CATEGORY_SERVICE)
    @NotNull
    private final String service;
    @SerializedName(MessengerShareContentUtility.SUBTITLE)
    @Nullable
    private final String subtitle;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliveryPoint$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/delivery/DeliveryPoint;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public DeliveryPoint(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @NotNull Coordinates coordinates2, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, NotificationCompat.CATEGORY_SERVICE);
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(coordinates2, "coordinates");
        this.id = str;
        this.service = str2;
        this.title = str3;
        this.subtitle = str4;
        this.coordinates = coordinates2;
        this.hint = str5;
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
        if (!(obj instanceof DeliveryPoint)) {
            return false;
        }
        DeliveryPoint deliveryPoint = (DeliveryPoint) obj;
        if (!Intrinsics.areEqual(this.id, deliveryPoint.id) || !Intrinsics.areEqual(this.title, deliveryPoint.title) || !Intrinsics.areEqual(this.subtitle, deliveryPoint.subtitle) || !Intrinsics.areEqual(this.coordinates, deliveryPoint.coordinates) || !Intrinsics.areEqual(this.hint, deliveryPoint.hint)) {
            return false;
        }
        return true;
    }

    @NotNull
    public final Coordinates getCoordinates() {
        return this.coordinates;
    }

    public final boolean getHasLabel() {
        return this.hint != null;
    }

    @Nullable
    public final String getHint() {
        return this.hint;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getService() {
        return this.service;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int B0 = a.B0(this.title, this.id.hashCode() * 31, 31);
        String str = this.subtitle;
        int i = 0;
        int hashCode = (this.coordinates.hashCode() + ((B0 + (str != null ? str.hashCode() : 0)) * 31)) * 31;
        String str2 = this.hint;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.id);
        parcel.writeString(this.service);
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
        parcel.writeParcelable(this.coordinates, i);
        parcel.writeString(this.hint);
    }
}
