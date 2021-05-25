package com.avito.android.component.profile_snippet;

import android.graphics.drawable.Drawable;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.model.advert_details.UserIconType;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J3\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/component/profile_snippet/AvatarRenderer;", "", "Lcom/facebook/drawee/view/SimpleDraweeView;", "view", "Lcom/avito/android/image_loader/Picture;", "avatar", "Lcom/avito/android/remote/model/advert_details/UserIconType;", "userIconType", "Landroid/graphics/drawable/Drawable;", InternalConstsKt.PLACEHOLDER, "", "renderAvatar", "(Lcom/facebook/drawee/view/SimpleDraweeView;Lcom/avito/android/image_loader/Picture;Lcom/avito/android/remote/model/advert_details/UserIconType;Landroid/graphics/drawable/Drawable;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface AvatarRenderer {
    void renderAvatar(@NotNull SimpleDraweeView simpleDraweeView, @Nullable Picture picture, @NotNull UserIconType userIconType, @Nullable Drawable drawable);
}
