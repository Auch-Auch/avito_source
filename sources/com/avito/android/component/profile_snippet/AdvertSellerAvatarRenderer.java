package com.avito.android.component.profile_snippet;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.image_loader.Picture;
import com.avito.android.image_loader.SimpleImageRequestListener;
import com.avito.android.lib.design.R;
import com.avito.android.remote.model.advert_details.UserIconType;
import com.avito.android.util.Contexts;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\r\u0010\u000eJ3\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/component/profile_snippet/AdvertSellerAvatarRenderer;", "Lcom/avito/android/component/profile_snippet/AvatarRenderer;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "view", "Lcom/avito/android/image_loader/Picture;", "avatar", "Lcom/avito/android/remote/model/advert_details/UserIconType;", "userIconType", "Landroid/graphics/drawable/Drawable;", InternalConstsKt.PLACEHOLDER, "", "renderAvatar", "(Lcom/facebook/drawee/view/SimpleDraweeView;Lcom/avito/android/image_loader/Picture;Lcom/avito/android/remote/model/advert_details/UserIconType;Landroid/graphics/drawable/Drawable;)V", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertSellerAvatarRenderer implements AvatarRenderer {
    @Override // com.avito.android.component.profile_snippet.AvatarRenderer
    public void renderAvatar(@NotNull SimpleDraweeView simpleDraweeView, @Nullable Picture picture, @NotNull UserIconType userIconType, @Nullable Drawable drawable) {
        Intrinsics.checkNotNullParameter(simpleDraweeView, "view");
        Intrinsics.checkNotNullParameter(userIconType, "userIconType");
        ((GenericDraweeHierarchy) simpleDraweeView.getHierarchy()).setPlaceholderImage(drawable);
        if (picture != null) {
            SimpleDraweeViewsKt.getRequestBuilder(simpleDraweeView).picture(picture).listener(new SimpleImageRequestListener(simpleDraweeView, picture, userIconType) { // from class: com.avito.android.component.profile_snippet.AdvertSellerAvatarRenderer$renderAvatar$$inlined$let$lambda$1
                public final /* synthetic */ SimpleDraweeView a;
                public final /* synthetic */ Picture b;
                public final /* synthetic */ UserIconType c;

                {
                    this.a = r1;
                    this.b = r2;
                    this.c = r3;
                }

                @Override // com.avito.android.image_loader.SimpleImageRequestListener, com.avito.android.image_loader.ImageRequestListener
                public void onLoaded(int i, int i2) {
                    if (this.c == UserIconType.SHOP) {
                        GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) this.a.getHierarchy();
                        Intrinsics.checkNotNullExpressionValue(genericDraweeHierarchy, "view.hierarchy");
                        genericDraweeHierarchy.setRoundingParams(null);
                        Context context = this.a.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "view.context");
                        ((GenericDraweeHierarchy) this.a.getHierarchy()).setBackgroundImage(new ColorDrawable(Contexts.getColorByAttr(context, R.attr.white)));
                        GenericDraweeHierarchy genericDraweeHierarchy2 = (GenericDraweeHierarchy) this.a.getHierarchy();
                        Intrinsics.checkNotNullExpressionValue(genericDraweeHierarchy2, "view.hierarchy");
                        genericDraweeHierarchy2.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE);
                    }
                }
            }).load();
        }
    }
}
