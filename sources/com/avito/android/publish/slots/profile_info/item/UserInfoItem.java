package com.avito.android.publish.slots.profile_info.item;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.SellerRating;
import com.avito.android.remote.model.advert_details.UserIconType;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/publish/slots/profile_info/item/UserInfoItem;", "Lcom/avito/conveyor_item/Item;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", AuthSource.BOOKING_ORDER, "getName", "name", "Lcom/avito/android/remote/model/Image;", "d", "Lcom/avito/android/remote/model/Image;", "getAvatar", "()Lcom/avito/android/remote/model/Image;", "avatar", "Lcom/avito/android/remote/model/advert_details/UserIconType;", "c", "Lcom/avito/android/remote/model/advert_details/UserIconType;", "getIconType", "()Lcom/avito/android/remote/model/advert_details/UserIconType;", "iconType", "Lcom/avito/android/remote/model/SellerRating;", "e", "Lcom/avito/android/remote/model/SellerRating;", "getRating", "()Lcom/avito/android/remote/model/SellerRating;", "rating", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/advert_details/UserIconType;Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/SellerRating;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class UserInfoItem implements Item {
    @NotNull
    public final String a;
    @Nullable
    public final String b;
    @NotNull
    public final UserIconType c;
    @Nullable
    public final Image d;
    @Nullable
    public final SellerRating e;

    public UserInfoItem(@NotNull String str, @Nullable String str2, @NotNull UserIconType userIconType, @Nullable Image image, @Nullable SellerRating sellerRating) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(userIconType, "iconType");
        this.a = str;
        this.b = str2;
        this.c = userIconType;
        this.d = image;
        this.e = sellerRating;
    }

    @Nullable
    public final Image getAvatar() {
        return this.d;
    }

    @NotNull
    public final UserIconType getIconType() {
        return this.c;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Nullable
    public final String getName() {
        return this.b;
    }

    @Nullable
    public final SellerRating getRating() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }
}
