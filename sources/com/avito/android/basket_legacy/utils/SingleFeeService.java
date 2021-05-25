package com.avito.android.basket_legacy.utils;

import a2.g.r.g;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010(\u001a\u00020\u000b\u0012\u0006\u0010+\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u001f\u001a\u00020\u000b\u0012\u0006\u0010\"\u001a\u00020\u000b\u0012\u0006\u0010%\u001a\u00020\u000b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001e\u0010\u000fR\u0019\u0010\"\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\r\u001a\u0004\b!\u0010\u000fR\u0019\u0010%\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\r\u001a\u0004\b$\u0010\u000fR\u0019\u0010(\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\r\u001a\u0004\b'\u0010\u000fR\u0019\u0010+\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u0013\u001a\u0004\b*\u0010\u0015¨\u0006."}, d2 = {"Lcom/avito/android/basket_legacy/utils/SingleFeeService;", "Lcom/avito/android/basket_legacy/utils/PaidService;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "d", "Ljava/lang/String;", "getPriceDetails", "()Ljava/lang/String;", "priceDetails", "", AuthSource.SEND_ABUSE, "J", "getServiceId", "()J", "serviceId", "Lcom/avito/android/remote/model/Image;", "h", "Lcom/avito/android/remote/model/Image;", "getIcon", "()Lcom/avito/android/remote/model/Image;", "icon", "e", "getDescription", "description", "f", "getCategory", "category", g.a, "getLocation", "location", AuthSource.BOOKING_ORDER, "getSlug", "slug", "c", "getPrice", "price", "<init>", "(JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class SingleFeeService extends PaidService {
    public static final Parcelable.Creator<SingleFeeService> CREATOR = new Creator();
    public final long a;
    @NotNull
    public final String b;
    public final long c;
    @NotNull
    public final String d;
    @NotNull
    public final String e;
    @NotNull
    public final String f;
    @NotNull
    public final String g;
    @Nullable
    public final Image h;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SingleFeeService> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SingleFeeService createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SingleFeeService(parcel.readLong(), parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (Image) parcel.readParcelable(SingleFeeService.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SingleFeeService[] newArray(int i) {
            return new SingleFeeService[i];
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleFeeService(long j, @NotNull String str, long j2, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @Nullable Image image) {
        super(null);
        Intrinsics.checkNotNullParameter(str, "slug");
        Intrinsics.checkNotNullParameter(str2, "priceDetails");
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(str4, "category");
        Intrinsics.checkNotNullParameter(str5, "location");
        this.a = j;
        this.b = str;
        this.c = j2;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = image;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getCategory() {
        return this.f;
    }

    @NotNull
    public final String getDescription() {
        return this.e;
    }

    @Nullable
    public final Image getIcon() {
        return this.h;
    }

    @NotNull
    public final String getLocation() {
        return this.g;
    }

    public final long getPrice() {
        return this.c;
    }

    @NotNull
    public final String getPriceDetails() {
        return this.d;
    }

    public final long getServiceId() {
        return this.a;
    }

    @NotNull
    public final String getSlug() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.a);
        parcel.writeString(this.b);
        parcel.writeLong(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeParcelable(this.h, i);
    }
}
