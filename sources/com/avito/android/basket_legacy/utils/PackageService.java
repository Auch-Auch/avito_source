package com.avito.android.basket_legacy.utils;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u0012\u0006\u0010\u0019\u001a\u00020\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0019\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u0019\u0010\u001f\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/basket_legacy/utils/PackageService;", "Lcom/avito/android/basket_legacy/utils/PaidService;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Image;", "d", "Lcom/avito/android/remote/model/Image;", "getIcon", "()Lcom/avito/android/remote/model/Image;", "icon", "", "c", "Ljava/lang/String;", "getLocation", "()Ljava/lang/String;", "location", AuthSource.BOOKING_ORDER, "getCountDetails", "countDetails", "", AuthSource.SEND_ABUSE, "J", "getServiceId", "()J", "serviceId", "<init>", "(JLjava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class PackageService extends PaidService {
    public static final Parcelable.Creator<PackageService> CREATOR = new Creator();
    public final long a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @Nullable
    public final Image d;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PackageService> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PackageService createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new PackageService(parcel.readLong(), parcel.readString(), parcel.readString(), (Image) parcel.readParcelable(PackageService.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PackageService[] newArray(int i) {
            return new PackageService[i];
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PackageService(long j, @NotNull String str, @NotNull String str2, @Nullable Image image) {
        super(null);
        Intrinsics.checkNotNullParameter(str, "countDetails");
        Intrinsics.checkNotNullParameter(str2, "location");
        this.a = j;
        this.b = str;
        this.c = str2;
        this.d = image;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getCountDetails() {
        return this.b;
    }

    @Nullable
    public final Image getIcon() {
        return this.d;
    }

    @NotNull
    public final String getLocation() {
        return this.c;
    }

    public final long getServiceId() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeParcelable(this.d, i);
    }
}
