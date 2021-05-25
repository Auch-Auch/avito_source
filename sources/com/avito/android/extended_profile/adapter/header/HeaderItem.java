package com.avito.android.extended_profile.adapter.header;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.extended_profile.adapter.ExtendedProfileListItem;
import com.avito.android.extended_profile.adapter.ExtendedProfileSpanLookup;
import com.avito.android.public_profile.remote.model.SubscribeInfo;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ProfileRating;
import com.avito.android.remote.model.SellerReplySpeed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b#\b\b\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0014\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bR\u0010SJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0001\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b$\u0010\u0004J\u0010\u0010&\u001a\u00020%HÖ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010+\u001a\u00020*2\b\u0010)\u001a\u0004\u0018\u00010(HÖ\u0003¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020%HÖ\u0001¢\u0006\u0004\b-\u0010'J \u00102\u001a\u0002012\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020%HÖ\u0001¢\u0006\u0004\b2\u00103R\u0019\u0010\u001b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u0010\u0004R$\u0010\u001e\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010\u0010\"\u0004\b:\u0010;R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010\rR\u001b\u0010!\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b?\u00105\u001a\u0004\b@\u0010\u0004R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bA\u00105\u001a\u0004\bB\u0010\u0004R\u001b\u0010 \u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010\u0016R\u001c\u0010\u0019\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010\u0007R$\u0010\u001f\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010\u0013\"\u0004\bL\u0010MR\u001c\u0010\u0018\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bN\u00105\u001a\u0004\bO\u0010\u0004R\u0019\u0010\u001a\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bP\u00105\u001a\u0004\bQ\u0010\u0004¨\u0006T"}, d2 = {"Lcom/avito/android/extended_profile/adapter/header/HeaderItem;", "Lcom/avito/android/extended_profile/adapter/ExtendedProfileListItem;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;", "component2", "()Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;", "component3", "component4", "component5", "Lcom/avito/android/remote/model/Image;", "component6", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/remote/model/ProfileRating;", "component7", "()Lcom/avito/android/remote/model/ProfileRating;", "Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "component8", "()Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "Lcom/avito/android/remote/model/SellerReplySpeed;", "component9", "()Lcom/avito/android/remote/model/SellerReplySpeed;", "component10", "stringId", "gridItemType", "userKey", "name", "description", "avatar", "rating", "subscribeInfo", "replySpeed", "contextId", "copy", "(Ljava/lang/String;Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/ProfileRating;Lcom/avito/android/public_profile/remote/model/SubscribeInfo;Lcom/avito/android/remote/model/SellerReplySpeed;Ljava/lang/String;)Lcom/avito/android/extended_profile/adapter/header/HeaderItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "d", "Ljava/lang/String;", "getName", g.a, "Lcom/avito/android/remote/model/ProfileRating;", "getRating", "setRating", "(Lcom/avito/android/remote/model/ProfileRating;)V", "f", "Lcom/avito/android/remote/model/Image;", "getAvatar", "j", "getContextId", "e", "getDescription", "i", "Lcom/avito/android/remote/model/SellerReplySpeed;", "getReplySpeed", AuthSource.BOOKING_ORDER, "Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;", "getGridItemType", "h", "Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "getSubscribeInfo", "setSubscribeInfo", "(Lcom/avito/android/public_profile/remote/model/SubscribeInfo;)V", AuthSource.SEND_ABUSE, "getStringId", "c", "getUserKey", "<init>", "(Ljava/lang/String;Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/ProfileRating;Lcom/avito/android/public_profile/remote/model/SubscribeInfo;Lcom/avito/android/remote/model/SellerReplySpeed;Ljava/lang/String;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class HeaderItem implements ExtendedProfileListItem {
    public static final Parcelable.Creator<HeaderItem> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final ExtendedProfileSpanLookup.GridItemType b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final Image f;
    @Nullable
    public ProfileRating g;
    @Nullable
    public SubscribeInfo h;
    @Nullable
    public final SellerReplySpeed i;
    @Nullable
    public final String j;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<HeaderItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final HeaderItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new HeaderItem(parcel.readString(), (ExtendedProfileSpanLookup.GridItemType) Enum.valueOf(ExtendedProfileSpanLookup.GridItemType.class, parcel.readString()), parcel.readString(), parcel.readString(), parcel.readString(), (Image) parcel.readParcelable(HeaderItem.class.getClassLoader()), (ProfileRating) parcel.readParcelable(HeaderItem.class.getClassLoader()), (SubscribeInfo) parcel.readParcelable(HeaderItem.class.getClassLoader()), (SellerReplySpeed) parcel.readParcelable(HeaderItem.class.getClassLoader()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final HeaderItem[] newArray(int i) {
            return new HeaderItem[i];
        }
    }

    public HeaderItem(@NotNull String str, @NotNull ExtendedProfileSpanLookup.GridItemType gridItemType, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable Image image, @Nullable ProfileRating profileRating, @Nullable SubscribeInfo subscribeInfo, @Nullable SellerReplySpeed sellerReplySpeed, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(gridItemType, "gridItemType");
        Intrinsics.checkNotNullParameter(str2, "userKey");
        Intrinsics.checkNotNullParameter(str3, "name");
        this.a = str;
        this.b = gridItemType;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = image;
        this.g = profileRating;
        this.h = subscribeInfo;
        this.i = sellerReplySpeed;
        this.j = str5;
    }

    public static /* synthetic */ HeaderItem copy$default(HeaderItem headerItem, String str, ExtendedProfileSpanLookup.GridItemType gridItemType, String str2, String str3, String str4, Image image, ProfileRating profileRating, SubscribeInfo subscribeInfo, SellerReplySpeed sellerReplySpeed, String str5, int i2, Object obj) {
        return headerItem.copy((i2 & 1) != 0 ? headerItem.getStringId() : str, (i2 & 2) != 0 ? headerItem.getGridItemType() : gridItemType, (i2 & 4) != 0 ? headerItem.c : str2, (i2 & 8) != 0 ? headerItem.d : str3, (i2 & 16) != 0 ? headerItem.e : str4, (i2 & 32) != 0 ? headerItem.f : image, (i2 & 64) != 0 ? headerItem.g : profileRating, (i2 & 128) != 0 ? headerItem.h : subscribeInfo, (i2 & 256) != 0 ? headerItem.i : sellerReplySpeed, (i2 & 512) != 0 ? headerItem.j : str5);
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @Nullable
    public final String component10() {
        return this.j;
    }

    @NotNull
    public final ExtendedProfileSpanLookup.GridItemType component2() {
        return getGridItemType();
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final String component4() {
        return this.d;
    }

    @Nullable
    public final String component5() {
        return this.e;
    }

    @Nullable
    public final Image component6() {
        return this.f;
    }

    @Nullable
    public final ProfileRating component7() {
        return this.g;
    }

    @Nullable
    public final SubscribeInfo component8() {
        return this.h;
    }

    @Nullable
    public final SellerReplySpeed component9() {
        return this.i;
    }

    @NotNull
    public final HeaderItem copy(@NotNull String str, @NotNull ExtendedProfileSpanLookup.GridItemType gridItemType, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable Image image, @Nullable ProfileRating profileRating, @Nullable SubscribeInfo subscribeInfo, @Nullable SellerReplySpeed sellerReplySpeed, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(gridItemType, "gridItemType");
        Intrinsics.checkNotNullParameter(str2, "userKey");
        Intrinsics.checkNotNullParameter(str3, "name");
        return new HeaderItem(str, gridItemType, str2, str3, str4, image, profileRating, subscribeInfo, sellerReplySpeed, str5);
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
        if (!(obj instanceof HeaderItem)) {
            return false;
        }
        HeaderItem headerItem = (HeaderItem) obj;
        return Intrinsics.areEqual(getStringId(), headerItem.getStringId()) && Intrinsics.areEqual(getGridItemType(), headerItem.getGridItemType()) && Intrinsics.areEqual(this.c, headerItem.c) && Intrinsics.areEqual(this.d, headerItem.d) && Intrinsics.areEqual(this.e, headerItem.e) && Intrinsics.areEqual(this.f, headerItem.f) && Intrinsics.areEqual(this.g, headerItem.g) && Intrinsics.areEqual(this.h, headerItem.h) && Intrinsics.areEqual(this.i, headerItem.i) && Intrinsics.areEqual(this.j, headerItem.j);
    }

    @Nullable
    public final Image getAvatar() {
        return this.f;
    }

    @Nullable
    public final String getContextId() {
        return this.j;
    }

    @Nullable
    public final String getDescription() {
        return this.e;
    }

    @Override // com.avito.android.extended_profile.adapter.ExtendedProfileListItem
    @NotNull
    public ExtendedProfileSpanLookup.GridItemType getGridItemType() {
        return this.b;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return ExtendedProfileListItem.DefaultImpls.getId(this);
    }

    @NotNull
    public final String getName() {
        return this.d;
    }

    @Nullable
    public final ProfileRating getRating() {
        return this.g;
    }

    @Nullable
    public final SellerReplySpeed getReplySpeed() {
        return this.i;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Nullable
    public final SubscribeInfo getSubscribeInfo() {
        return this.h;
    }

    @NotNull
    public final String getUserKey() {
        return this.c;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String stringId = getStringId();
        int i2 = 0;
        int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
        ExtendedProfileSpanLookup.GridItemType gridItemType = getGridItemType();
        int hashCode2 = (hashCode + (gridItemType != null ? gridItemType.hashCode() : 0)) * 31;
        String str = this.c;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.d;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.e;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Image image = this.f;
        int hashCode6 = (hashCode5 + (image != null ? image.hashCode() : 0)) * 31;
        ProfileRating profileRating = this.g;
        int hashCode7 = (hashCode6 + (profileRating != null ? profileRating.hashCode() : 0)) * 31;
        SubscribeInfo subscribeInfo = this.h;
        int hashCode8 = (hashCode7 + (subscribeInfo != null ? subscribeInfo.hashCode() : 0)) * 31;
        SellerReplySpeed sellerReplySpeed = this.i;
        int hashCode9 = (hashCode8 + (sellerReplySpeed != null ? sellerReplySpeed.hashCode() : 0)) * 31;
        String str4 = this.j;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode9 + i2;
    }

    public final void setRating(@Nullable ProfileRating profileRating) {
        this.g = profileRating;
    }

    public final void setSubscribeInfo(@Nullable SubscribeInfo subscribeInfo) {
        this.h = subscribeInfo;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("HeaderItem(stringId=");
        L.append(getStringId());
        L.append(", gridItemType=");
        L.append(getGridItemType());
        L.append(", userKey=");
        L.append(this.c);
        L.append(", name=");
        L.append(this.d);
        L.append(", description=");
        L.append(this.e);
        L.append(", avatar=");
        L.append(this.f);
        L.append(", rating=");
        L.append(this.g);
        L.append(", subscribeInfo=");
        L.append(this.h);
        L.append(", replySpeed=");
        L.append(this.i);
        L.append(", contextId=");
        return a.t(L, this.j, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b.name());
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeParcelable(this.f, i2);
        parcel.writeParcelable(this.g, i2);
        parcel.writeParcelable(this.h, i2);
        parcel.writeParcelable(this.i, i2);
        parcel.writeString(this.j);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HeaderItem(String str, ExtendedProfileSpanLookup.GridItemType gridItemType, String str2, String str3, String str4, Image image, ProfileRating profileRating, SubscribeInfo subscribeInfo, SellerReplySpeed sellerReplySpeed, String str5, int i2, j jVar) {
        this((i2 & 1) != 0 ? "header_item" : str, (i2 & 2) != 0 ? ExtendedProfileSpanLookup.GridItemType.FULL_WIDTH : gridItemType, str2, str3, str4, image, profileRating, subscribeInfo, sellerReplySpeed, str5);
    }
}
