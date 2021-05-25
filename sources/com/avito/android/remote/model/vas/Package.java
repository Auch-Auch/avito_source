package com.avito.android.remote.model.vas;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.VKApiConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\b\u0018\u0000 ;2\u00020\u0001:\u0001;B_\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0011\u0012\u0006\u0010\u001f\u001a\u00020\u0005\u0012\u0006\u0010 \u001a\u00020\u0005\u0012\u0006\u0010!\u001a\u00020\u0005\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b9\u0010:J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0007J\u0010\u0010\u0015\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0007J\u0010\u0010\u0016\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0007J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0004Jz\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00022\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b&\u0010\u0007J\u001a\u0010*\u001a\u00020)2\b\u0010(\u001a\u0004\u0018\u00010'HÖ\u0003¢\u0006\u0004\b*\u0010+R\u001c\u0010\u001c\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010,\u001a\u0004\b-\u0010\u0004R\u001c\u0010\u001d\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010,\u001a\u0004\b.\u0010\u0004R(\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010/\u001a\u0004\b0\u0010\u0013R\u001c\u0010!\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b!\u00101\u001a\u0004\b2\u0010\u0007R\u001c\u0010\u001b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010,\u001a\u0004\b3\u0010\u0004R\u001c\u0010 \u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u00101\u001a\u0004\b4\u0010\u0007R\u001c\u0010\u001f\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u00101\u001a\u0004\b5\u0010\u0007R\u001e\u0010\"\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\"\u00106\u001a\u0004\b7\u0010\u0019R\u001e\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b#\u0010,\u001a\u0004\b8\u0010\u0004¨\u0006<"}, d2 = {"Lcom/avito/android/remote/model/vas/Package;", "Lcom/avito/android/remote/model/vas/VasElement;", "", "toString", "()Ljava/lang/String;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "component2", "component3", "", "component4", "()Ljava/util/Map;", "component5", "component6", "component7", "Lcom/avito/android/remote/model/vas/ServiceDiscount;", "component8", "()Lcom/avito/android/remote/model/vas/ServiceDiscount;", "component9", "code", "name", "description", VKApiConst.SERVICES, "ttlDays", "price", "fullPrice", FirebaseAnalytics.Param.DISCOUNT, "priceMetric", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;IIILcom/avito/android/remote/model/vas/ServiceDiscount;Ljava/lang/String;)Lcom/avito/android/remote/model/vas/Package;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "getDescription", "Ljava/util/Map;", "getServices", "I", "getFullPrice", "getCode", "getPrice", "getTtlDays", "Lcom/avito/android/remote/model/vas/ServiceDiscount;", "getDiscount", "getPriceMetric", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;IIILcom/avito/android/remote/model/vas/ServiceDiscount;Ljava/lang/String;)V", "Companion", "vas_release"}, k = 1, mv = {1, 4, 2})
public final class Package implements VasElement {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<Package> CREATOR = Parcels.creator(Package$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("code")
    @NotNull
    private final String code;
    @SerializedName("description")
    @NotNull
    private final String description;
    @SerializedName(FirebaseAnalytics.Param.DISCOUNT)
    @Nullable
    private final ServiceDiscount discount;
    @SerializedName("fullPrice")
    private final int fullPrice;
    @SerializedName("name")
    @NotNull
    private final String name;
    @SerializedName("price")
    private final int price;
    @SerializedName("priceMetric")
    @Nullable
    private final String priceMetric;
    @SerializedName(VKApiConst.SERVICES)
    @NotNull
    private final Map<String, Integer> services;
    @SerializedName("ttlDays")
    private final int ttlDays;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/vas/Package$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/vas/Package;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "vas_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public Package(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Map<String, Integer> map, int i, int i2, int i3, @Nullable ServiceDiscount serviceDiscount, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "code");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(map, VKApiConst.SERVICES);
        this.code = str;
        this.name = str2;
        this.description = str3;
        this.services = map;
        this.ttlDays = i;
        this.price = i2;
        this.fullPrice = i3;
        this.discount = serviceDiscount;
        this.priceMetric = str4;
    }

    public static /* synthetic */ Package copy$default(Package r10, String str, String str2, String str3, Map map, int i, int i2, int i3, ServiceDiscount serviceDiscount, String str4, int i4, Object obj) {
        return r10.copy((i4 & 1) != 0 ? r10.code : str, (i4 & 2) != 0 ? r10.name : str2, (i4 & 4) != 0 ? r10.description : str3, (i4 & 8) != 0 ? r10.services : map, (i4 & 16) != 0 ? r10.ttlDays : i, (i4 & 32) != 0 ? r10.price : i2, (i4 & 64) != 0 ? r10.fullPrice : i3, (i4 & 128) != 0 ? r10.discount : serviceDiscount, (i4 & 256) != 0 ? r10.priceMetric : str4);
    }

    @NotNull
    public final String component1() {
        return this.code;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    @NotNull
    public final String component3() {
        return this.description;
    }

    @NotNull
    public final Map<String, Integer> component4() {
        return this.services;
    }

    public final int component5() {
        return this.ttlDays;
    }

    public final int component6() {
        return this.price;
    }

    public final int component7() {
        return this.fullPrice;
    }

    @Nullable
    public final ServiceDiscount component8() {
        return this.discount;
    }

    @Nullable
    public final String component9() {
        return this.priceMetric;
    }

    @NotNull
    public final Package copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Map<String, Integer> map, int i, int i2, int i3, @Nullable ServiceDiscount serviceDiscount, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "code");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(map, VKApiConst.SERVICES);
        return new Package(str, str2, str3, map, i, i2, i3, serviceDiscount, str4);
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
        if (!(obj instanceof Package)) {
            return false;
        }
        Package r3 = (Package) obj;
        return Intrinsics.areEqual(this.code, r3.code) && Intrinsics.areEqual(this.name, r3.name) && Intrinsics.areEqual(this.description, r3.description) && Intrinsics.areEqual(this.services, r3.services) && this.ttlDays == r3.ttlDays && this.price == r3.price && this.fullPrice == r3.fullPrice && Intrinsics.areEqual(this.discount, r3.discount) && Intrinsics.areEqual(this.priceMetric, r3.priceMetric);
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final ServiceDiscount getDiscount() {
        return this.discount;
    }

    public final int getFullPrice() {
        return this.fullPrice;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getPrice() {
        return this.price;
    }

    @Nullable
    public final String getPriceMetric() {
        return this.priceMetric;
    }

    @NotNull
    public final Map<String, Integer> getServices() {
        return this.services;
    }

    public final int getTtlDays() {
        return this.ttlDays;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.code;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.description;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Map<String, Integer> map = this.services;
        int hashCode4 = (((((((hashCode3 + (map != null ? map.hashCode() : 0)) * 31) + this.ttlDays) * 31) + this.price) * 31) + this.fullPrice) * 31;
        ServiceDiscount serviceDiscount = this.discount;
        int hashCode5 = (hashCode4 + (serviceDiscount != null ? serviceDiscount.hashCode() : 0)) * 31;
        String str4 = this.priceMetric;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode5 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("Package[");
        L.append(this.code);
        L.append(',');
        L.append(this.name);
        L.append(',');
        return a.s(L, this.description, ']');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.code);
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeInt(this.ttlDays);
        parcel.writeInt(this.price);
        parcel.writeInt(this.fullPrice);
        ParcelsKt.writeValueMap(parcel, this.services);
        parcel.writeParcelable(this.discount, i);
        parcel.writeString(this.priceMetric);
    }
}
