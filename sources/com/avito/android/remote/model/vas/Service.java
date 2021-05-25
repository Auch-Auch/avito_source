package com.avito.android.remote.model.vas;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001d\b\b\u0018\u0000 72\u00020\u0001:\u00017BM\u0012\u0006\u0010\u001f\u001a\u00020\n\u0012\u0006\u0010 \u001a\u00020\n\u0012\u0006\u0010!\u001a\u00020\n\u0012\u0006\u0010\"\u001a\u00020\n\u0012\u0006\u0010#\u001a\u00020\u0007\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010%\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010&\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b5\u00106J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\tJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u0014\u0010\fJ\u0010\u0010\u0015\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u0015\u0010\fJ\u0010\u0010\u0016\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u0016\u0010\fJ\u0010\u0010\u0017\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u0017\u0010\fJ\u0010\u0010\u0018\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0018\u0010\tJ\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u001e\u0010\fJf\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u001f\u001a\u00020\n2\b\b\u0002\u0010 \u001a\u00020\n2\b\b\u0002\u0010!\u001a\u00020\n2\b\b\u0002\u0010\"\u001a\u00020\n2\b\b\u0002\u0010#\u001a\u00020\u00072\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b'\u0010(R\u0019\u0010\u001f\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010)\u001a\u0004\b*\u0010\fR\u0019\u0010 \u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010)\u001a\u0004\b+\u0010\fR\u001b\u0010$\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010,\u001a\u0004\b-\u0010\u001aR\u001b\u0010&\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010)\u001a\u0004\b.\u0010\fR\u001b\u0010%\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010/\u001a\u0004\b0\u0010\u001dR\u0019\u0010!\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010)\u001a\u0004\b1\u0010\fR\u0019\u0010#\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b#\u00102\u001a\u0004\b3\u0010\tR\u0019\u0010\"\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010)\u001a\u0004\b4\u0010\f¨\u00068"}, d2 = {"Lcom/avito/android/remote/model/vas/Service;", "Lcom/avito/android/remote/model/vas/VasElement;", "", "o", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "component2", "component3", "component4", "component5", "component6", "()Ljava/lang/Integer;", "Lcom/avito/android/remote/model/vas/ServiceDiscount;", "component7", "()Lcom/avito/android/remote/model/vas/ServiceDiscount;", "component8", "id", "shortName", "fullName", "description", "price", "fullPrice", FirebaseAnalytics.Param.DISCOUNT, "priceMetric", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Lcom/avito/android/remote/model/vas/ServiceDiscount;Ljava/lang/String;)Lcom/avito/android/remote/model/vas/Service;", "Ljava/lang/String;", "getId", "getShortName", "Ljava/lang/Integer;", "getFullPrice", "getPriceMetric", "Lcom/avito/android/remote/model/vas/ServiceDiscount;", "getDiscount", "getFullName", "I", "getPrice", "getDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Lcom/avito/android/remote/model/vas/ServiceDiscount;Ljava/lang/String;)V", "Companion", "vas_release"}, k = 1, mv = {1, 4, 2})
public final class Service implements VasElement {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<Service> CREATOR = Parcels.creator(Service$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String description;
    @Nullable
    private final ServiceDiscount discount;
    @NotNull
    private final String fullName;
    @Nullable
    private final Integer fullPrice;
    @NotNull
    private final String id;
    private final int price;
    @Nullable
    private final String priceMetric;
    @NotNull
    private final String shortName;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/vas/Service$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/vas/Service;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "vas_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public Service(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i, @Nullable Integer num, @Nullable ServiceDiscount serviceDiscount, @Nullable String str5) {
        a.b1(str, "id", str2, "shortName", str3, "fullName", str4, "description");
        this.id = str;
        this.shortName = str2;
        this.fullName = str3;
        this.description = str4;
        this.price = i;
        this.fullPrice = num;
        this.discount = serviceDiscount;
        this.priceMetric = str5;
    }

    public static /* synthetic */ Service copy$default(Service service, String str, String str2, String str3, String str4, int i, Integer num, ServiceDiscount serviceDiscount, String str5, int i2, Object obj) {
        return service.copy((i2 & 1) != 0 ? service.id : str, (i2 & 2) != 0 ? service.shortName : str2, (i2 & 4) != 0 ? service.fullName : str3, (i2 & 8) != 0 ? service.description : str4, (i2 & 16) != 0 ? service.price : i, (i2 & 32) != 0 ? service.fullPrice : num, (i2 & 64) != 0 ? service.discount : serviceDiscount, (i2 & 128) != 0 ? service.priceMetric : str5);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.shortName;
    }

    @NotNull
    public final String component3() {
        return this.fullName;
    }

    @NotNull
    public final String component4() {
        return this.description;
    }

    public final int component5() {
        return this.price;
    }

    @Nullable
    public final Integer component6() {
        return this.fullPrice;
    }

    @Nullable
    public final ServiceDiscount component7() {
        return this.discount;
    }

    @Nullable
    public final String component8() {
        return this.priceMetric;
    }

    @NotNull
    public final Service copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i, @Nullable Integer num, @Nullable ServiceDiscount serviceDiscount, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "shortName");
        Intrinsics.checkNotNullParameter(str3, "fullName");
        Intrinsics.checkNotNullParameter(str4, "description");
        return new Service(str, str2, str3, str4, i, num, serviceDiscount, str5);
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
        if (!(obj instanceof Service)) {
            return false;
        }
        return Intrinsics.areEqual(this.id, ((Service) obj).id);
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final ServiceDiscount getDiscount() {
        return this.discount;
    }

    @NotNull
    public final String getFullName() {
        return this.fullName;
    }

    @Nullable
    public final Integer getFullPrice() {
        return this.fullPrice;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final int getPrice() {
        return this.price;
    }

    @Nullable
    public final String getPriceMetric() {
        return this.priceMetric;
    }

    @NotNull
    public final String getShortName() {
        return this.shortName;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("Services[");
        L.append(this.id);
        L.append(',');
        return a.s(L, this.shortName, ']');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.shortName);
        parcel.writeString(this.fullName);
        parcel.writeString(this.description);
        parcel.writeInt(this.price);
        ParcelsKt.writeNullableValue(parcel, this.fullPrice);
        parcel.writeParcelable(this.discount, i);
        parcel.writeString(this.priceMetric);
    }
}
