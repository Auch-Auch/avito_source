package com.avito.android.shop.detailed;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.remote.shop.detailed.ShopElement;
import com.avito.android.util.ParcelUtils;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 22\u00020\u0001:\u00012BM\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\u0006\u0010/\u001a\u00020*\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010$\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010#\u001a\u00020\u001e¢\u0006\u0004\b0\u00101J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001d\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010#\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R'\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010/\u001a\u00020*8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.¨\u00063"}, d2 = {"Lcom/avito/android/shop/detailed/ShopDetailedData;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "e", "Ljava/lang/String;", "getSearchHint", "()Ljava/lang/String;", "searchHint", "", "Lcom/avito/android/remote/model/SerpElement;", "c", "Ljava/util/List;", "getElements", "()Ljava/util/List;", MessengerShareContentUtility.ELEMENTS, "Lcom/avito/android/remote/shop/detailed/ShopElement;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/shop/detailed/ShopElement;", "getShop", "()Lcom/avito/android/remote/shop/detailed/ShopElement;", ScreenPublicConstsKt.CONTENT_TYPE_SHOP, "Lcom/avito/android/remote/model/SerpDisplayType;", "f", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "", "d", "Ljava/util/Map;", "getFirebaseParams", "()Ljava/util/Map;", "firebaseParams", "", AuthSource.BOOKING_ORDER, "J", "getCount", "()J", "count", "<init>", "(Lcom/avito/android/remote/shop/detailed/ShopElement;JLjava/util/List;Ljava/util/Map;Ljava/lang/String;Lcom/avito/android/remote/model/SerpDisplayType;)V", "Companion", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopDetailedData implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ShopDetailedData> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final ShopElement a;
    public final long b;
    @NotNull
    public final List<SerpElement> c;
    @Nullable
    public final Map<String, String> d;
    @Nullable
    public final String e;
    @NotNull
    public final SerpDisplayType f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/shop/detailed/ShopDetailedData$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/shop/detailed/ShopDetailedData;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, ShopDetailedData> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ShopDetailedData invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            ShopElement shopElement = (ShopElement) a2.b.a.a.a.z1(ShopElement.class, parcel2);
            long readLong = parcel2.readLong();
            List createParcelableList = ParcelsKt.createParcelableList(parcel2, SerpElement.class);
            if (createParcelableList == null) {
                createParcelableList = CollectionsKt__CollectionsKt.emptyList();
            }
            return new ShopDetailedData(shopElement, readLong, createParcelableList, ParcelUtils.createValueMap(parcel2, String.class, String.class), parcel2.readString(), (SerpDisplayType) ParcelsKt.readEnum(parcel2, SerpDisplayType.values()));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.List<? extends com.avito.android.remote.model.SerpElement> */
    /* JADX WARN: Multi-variable type inference failed */
    public ShopDetailedData(@NotNull ShopElement shopElement, long j, @NotNull List<? extends SerpElement> list, @Nullable Map<String, String> map, @Nullable String str, @NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(shopElement, ScreenPublicConstsKt.CONTENT_TYPE_SHOP);
        Intrinsics.checkNotNullParameter(list, MessengerShareContentUtility.ELEMENTS);
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        this.a = shopElement;
        this.b = j;
        this.c = list;
        this.d = map;
        this.e = str;
        this.f = serpDisplayType;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final long getCount() {
        return this.b;
    }

    @NotNull
    public final SerpDisplayType getDisplayType() {
        return this.f;
    }

    @NotNull
    public final List<SerpElement> getElements() {
        return this.c;
    }

    @Nullable
    public final Map<String, String> getFirebaseParams() {
        return this.d;
    }

    @Nullable
    public final String getSearchHint() {
        return this.e;
    }

    @NotNull
    public final ShopElement getShop() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeParcelable(this.a, i);
        parcel.writeLong(this.b);
        ParcelsKt.writeOptimizedParcelableList$default(parcel, this.c, 0, 2, null);
        ParcelsKt.writeValueMap(parcel, this.d);
        parcel.writeString(this.e);
        ParcelsKt.writeEnum(parcel, this.f);
    }
}
