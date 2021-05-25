package com.avito.android.publish.slots.profile_info.item;

import com.avito.android.image_loader.Picture;
import com.avito.android.remote.model.advert_details.UserIconType;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0010\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/publish/slots/profile_info/item/UserInfoItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/image_loader/Picture;", "image", "Lcom/avito/android/remote/model/advert_details/UserIconType;", "iconType", "", "setAvatar", "(Lcom/avito/android/image_loader/Picture;Lcom/avito/android/remote/model/advert_details/UserIconType;)V", "", "name", "setName", "(Ljava/lang/String;)V", "", "score", "text", "setRating", "(Ljava/lang/Float;Ljava/lang/String;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface UserInfoItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull UserInfoItemView userInfoItemView) {
            ItemView.DefaultImpls.onUnbind(userInfoItemView);
        }

        public static /* synthetic */ void setRating$default(UserInfoItemView userInfoItemView, Float f, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = null;
                }
                userInfoItemView.setRating(f, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setRating");
        }
    }

    void setAvatar(@Nullable Picture picture, @NotNull UserIconType userIconType);

    void setName(@Nullable String str);

    void setRating(@Nullable Float f, @Nullable String str);
}
