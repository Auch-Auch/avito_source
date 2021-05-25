package com.avito.android.publish.slots.profile_info.item;

import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.remote.model.SellerRating;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/publish/slots/profile_info/item/UserInfoItemPresenterImpl;", "Lcom/avito/android/publish/slots/profile_info/item/UserInfoItemPresenter;", "Lcom/avito/android/publish/slots/profile_info/item/UserInfoItemView;", "view", "Lcom/avito/android/publish/slots/profile_info/item/UserInfoItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/publish/slots/profile_info/item/UserInfoItemView;Lcom/avito/android/publish/slots/profile_info/item/UserInfoItem;I)V", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class UserInfoItemPresenterImpl implements UserInfoItemPresenter {
    public void bindView(@NotNull UserInfoItemView userInfoItemView, @NotNull UserInfoItem userInfoItem, int i) {
        Float f;
        Intrinsics.checkNotNullParameter(userInfoItemView, "view");
        Intrinsics.checkNotNullParameter(userInfoItem, "item");
        userInfoItemView.setName(userInfoItem.getName());
        userInfoItemView.setAvatar(AvitoPictureKt.pictureOf$default(userInfoItem.getAvatar(), true, 0.0f, 0.0f, null, 28, null), userInfoItem.getIconType());
        SellerRating rating = userInfoItem.getRating();
        String str = null;
        if (rating == null || (f = rating.getScoreFloat()) == null) {
            SellerRating rating2 = userInfoItem.getRating();
            f = rating2 != null ? Float.valueOf(rating2.getScore()) : null;
        }
        SellerRating rating3 = userInfoItem.getRating();
        if (rating3 != null) {
            str = rating3.getText();
        }
        userInfoItemView.setRating(f, str);
    }
}
