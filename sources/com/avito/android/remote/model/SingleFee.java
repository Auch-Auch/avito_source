package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 *2\u00020\u0001:\u0001*BO\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010&\u001a\u0004\u0018\u00010!\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b(\u0010)J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000fR\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000fR\u001c\u0010\u001a\u001a\u00020\u00198\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u00020\u00048\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\nR\u001e\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001e\u0010&\u001a\u0004\u0018\u00010!8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b&\u0010#\u001a\u0004\b'\u0010%¨\u0006+"}, d2 = {"Lcom/avito/android/remote/model/SingleFee;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "priceDetails", "Ljava/lang/String;", "getPriceDetails", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Image;", "icon", "Lcom/avito/android/remote/model/Image;", "getIcon", "()Lcom/avito/android/remote/model/Image;", "paymentServiceId", "getPaymentServiceId", "description", "getDescription", "", "serviceId", "J", "getServiceId", "()J", "price", "I", "getPrice", "Lcom/avito/android/remote/model/FeeParam;", "location", "Lcom/avito/android/remote/model/FeeParam;", "getLocation", "()Lcom/avito/android/remote/model/FeeParam;", "category", "getCategory", "<init>", "(JILjava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/FeeParam;Lcom/avito/android/remote/model/FeeParam;Lcom/avito/android/remote/model/Image;Ljava/lang/String;)V", "Companion", "fees_release"}, k = 1, mv = {1, 4, 2})
public final class SingleFee implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SingleFee> CREATOR = Parcels.creator(SingleFee$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("category")
    @Nullable
    private final FeeParam category;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("icon")
    @Nullable
    private final Image icon;
    @SerializedName("location")
    @Nullable
    private final FeeParam location;
    @SerializedName("paymentServiceId")
    @NotNull
    private final String paymentServiceId;
    @SerializedName("price")
    private final int price;
    @SerializedName("priceDetails")
    @NotNull
    private final String priceDetails;
    @SerializedName("serviceId")
    private final long serviceId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/SingleFee$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/SingleFee;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "fees_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public SingleFee(long j, int i, @NotNull String str, @Nullable String str2, @Nullable FeeParam feeParam, @Nullable FeeParam feeParam2, @Nullable Image image, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "priceDetails");
        Intrinsics.checkNotNullParameter(str3, "paymentServiceId");
        this.serviceId = j;
        this.price = i;
        this.priceDetails = str;
        this.description = str2;
        this.category = feeParam;
        this.location = feeParam2;
        this.icon = image;
        this.paymentServiceId = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final FeeParam getCategory() {
        return this.category;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final Image getIcon() {
        return this.icon;
    }

    @Nullable
    public final FeeParam getLocation() {
        return this.location;
    }

    @NotNull
    public final String getPaymentServiceId() {
        return this.paymentServiceId;
    }

    public final int getPrice() {
        return this.price;
    }

    @NotNull
    public final String getPriceDetails() {
        return this.priceDetails;
    }

    public final long getServiceId() {
        return this.serviceId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeLong(this.serviceId);
        parcel.writeInt(this.price);
        parcel.writeString(this.priceDetails);
        parcel.writeString(this.description);
        parcel.writeParcelable(this.category, i);
        parcel.writeParcelable(this.location, i);
        parcel.writeParcelable(this.icon, i);
        parcel.writeString(this.paymentServiceId);
    }
}
