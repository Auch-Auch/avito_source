package com.avito.android.favorite_sellers;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.favorite_sellers.RecommendationCarouselItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0007\u0018\u00002\u00020\u0001:\u0001BB{\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u00105\u001a\u00020\t\u0012\b\u0010?\u001a\u0004\u0018\u00010\t\u0012\b\u0010!\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010%\u001a\u00020\"\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\b\u0010,\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u00107\u001a\u00020\"\u0012\b\b\u0002\u0010;\u001a\u00020\"\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b@\u0010AJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0011\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001b\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\rR\u001b\u0010!\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010%\u001a\u00020\"8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001b\u0010,\u001a\u0004\u0018\u00010'8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R$\u0010/\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0019\u00105\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u000b\u001a\u0004\b4\u0010\rR\"\u00107\u001a\u00020\"8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b6\u0010$\u001a\u0004\b7\u0010&\"\u0004\b8\u00109R\"\u0010;\u001a\u00020\"8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b:\u0010$\u001a\u0004\b;\u0010&\"\u0004\b<\u00109R\u001b\u0010?\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010\u000b\u001a\u0004\b>\u0010\r¨\u0006C"}, d2 = {"Lcom/avito/android/favorite_sellers/SellerCarouselItem;", "Lcom/avito/android/favorite_sellers/RecommendationCarouselItem;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "c", "Ljava/lang/String;", "getUserKey", "()Ljava/lang/String;", "userKey", AuthSource.SEND_ABUSE, "getStringId", "stringId", "", "Lcom/avito/android/favorite_sellers/SellerCarouselItem$Advert;", "h", "Ljava/util/List;", "getAdverts", "()Ljava/util/List;", "adverts", AuthSource.BOOKING_ORDER, "getRecommendationId", "recommendationId", "Lcom/avito/android/remote/model/Image;", "f", "Lcom/avito/android/remote/model/Image;", "getAvatar", "()Lcom/avito/android/remote/model/Image;", "avatar", "", g.a, "Z", "isShop", "()Z", "Lcom/avito/android/deep_linking/links/DeepLink;", "i", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "l", "Ljava/lang/Boolean;", "isNotificationsActivated", "()Ljava/lang/Boolean;", "setNotificationsActivated", "(Ljava/lang/Boolean;)V", "d", "getName", "name", "j", "isSubscribed", "setSubscribed", "(Z)V", "k", "isSubscribeLoading", "setSubscribeLoading", "e", "getDescription", "description", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;ZLjava/util/List;Lcom/avito/android/deep_linking/links/DeepLink;ZZLjava/lang/Boolean;)V", "Advert", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SellerCarouselItem implements RecommendationCarouselItem {
    public static final Parcelable.Creator<SellerCarouselItem> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final Image f;
    public final boolean g;
    @NotNull
    public final List<Advert> h;
    @Nullable
    public final DeepLink i;
    public boolean j;
    public boolean k;
    @Nullable
    public Boolean l;

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/avito/android/favorite_sellers/SellerCarouselItem$Advert;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Image;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "image", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "c", "getSubtitle", MessengerShareContentUtility.SUBTITLE, "<init>", "(Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Advert implements Parcelable {
        public static final Parcelable.Creator<Advert> CREATOR = new Creator();
        @Nullable
        public final Image a;
        @Nullable
        public final String b;
        @Nullable
        public final String c;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Advert> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Advert createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Advert((Image) parcel.readParcelable(Advert.class.getClassLoader()), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Advert[] newArray(int i) {
                return new Advert[i];
            }
        }

        public Advert(@Nullable Image image, @Nullable String str, @Nullable String str2) {
            this.a = image;
            this.b = str;
            this.c = str2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final Image getImage() {
            return this.a;
        }

        @Nullable
        public final String getSubtitle() {
            return this.c;
        }

        @Nullable
        public final String getTitle() {
            return this.b;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeParcelable(this.a, i);
            parcel.writeString(this.b);
            parcel.writeString(this.c);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Advert(Image image, String str, String str2, int i, j jVar) {
            this(image, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SellerCarouselItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SellerCarouselItem createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            Image image = (Image) parcel.readParcelable(SellerCarouselItem.class.getClassLoader());
            boolean z = true;
            boolean z2 = parcel.readInt() != 0;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(Advert.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            DeepLink deepLink = (DeepLink) parcel.readParcelable(SellerCarouselItem.class.getClassLoader());
            boolean z3 = parcel.readInt() != 0;
            boolean z4 = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                if (parcel.readInt() == 0) {
                    z = false;
                }
                bool = Boolean.valueOf(z);
            } else {
                bool = null;
            }
            return new SellerCarouselItem(readString, readString2, readString3, readString4, readString5, image, z2, arrayList, deepLink, z3, z4, bool);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SellerCarouselItem[] newArray(int i) {
            return new SellerCarouselItem[i];
        }
    }

    public SellerCarouselItem(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable String str5, @Nullable Image image, boolean z, @NotNull List<Advert> list, @Nullable DeepLink deepLink, boolean z2, boolean z3, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "recommendationId");
        Intrinsics.checkNotNullParameter(str3, "userKey");
        Intrinsics.checkNotNullParameter(str4, "name");
        Intrinsics.checkNotNullParameter(list, "adverts");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = image;
        this.g = z;
        this.h = list;
        this.i = deepLink;
        this.j = z2;
        this.k = z3;
        this.l = bool;
    }

    @Override // com.avito.android.favorite_sellers.RecommendationCarouselItem, android.os.Parcelable
    public int describeContents() {
        return RecommendationCarouselItem.DefaultImpls.describeContents(this);
    }

    @NotNull
    public final List<Advert> getAdverts() {
        return this.h;
    }

    @Nullable
    public final Image getAvatar() {
        return this.f;
    }

    @Nullable
    public final DeepLink getDeepLink() {
        return this.i;
    }

    @Nullable
    public final String getDescription() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return RecommendationCarouselItem.DefaultImpls.getId(this);
    }

    @NotNull
    public final String getName() {
        return this.d;
    }

    @NotNull
    public final String getRecommendationId() {
        return this.b;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @NotNull
    public final String getUserKey() {
        return this.c;
    }

    @Nullable
    public final Boolean isNotificationsActivated() {
        return this.l;
    }

    public final boolean isShop() {
        return this.g;
    }

    public final boolean isSubscribeLoading() {
        return this.k;
    }

    public final boolean isSubscribed() {
        return this.j;
    }

    public final void setNotificationsActivated(@Nullable Boolean bool) {
        this.l = bool;
    }

    public final void setSubscribeLoading(boolean z) {
        this.k = z;
    }

    public final void setSubscribed(boolean z) {
        this.j = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeParcelable(this.f, i2);
        parcel.writeInt(this.g ? 1 : 0);
        Iterator n0 = a.n0(this.h, parcel);
        while (n0.hasNext()) {
            ((Advert) n0.next()).writeToParcel(parcel, 0);
        }
        parcel.writeParcelable(this.i, i2);
        parcel.writeInt(this.j ? 1 : 0);
        parcel.writeInt(this.k ? 1 : 0);
        Boolean bool = this.l;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SellerCarouselItem(String str, String str2, String str3, String str4, String str5, Image image, boolean z, List list, DeepLink deepLink, boolean z2, boolean z3, Boolean bool, int i2, j jVar) {
        this(str, str2, str3, str4, str5, image, z, list, deepLink, (i2 & 512) != 0 ? false : z2, (i2 & 1024) != 0 ? false : z3, (i2 & 2048) != 0 ? null : bool);
    }
}
