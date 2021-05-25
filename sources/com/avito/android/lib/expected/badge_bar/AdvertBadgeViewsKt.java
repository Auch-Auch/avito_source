package com.avito.android.lib.expected.badge_bar;

import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import com.avito.android.design.ImageLoadable;
import com.avito.android.design.State;
import com.avito.android.image_loader.fresco.ImageLoadableExtensionKt;
import com.avito.android.remote.model.Image;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\b\u001a\u00020\u0003*\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/lib/expected/badge_bar/AdvertBadgeView;", "Lcom/avito/android/remote/model/Image;", "image", "", "loadImage", "(Lcom/avito/android/lib/expected/badge_bar/AdvertBadgeView;Lcom/avito/android/remote/model/Image;)V", "", "imageRes", "setImage", "(Lcom/avito/android/lib/expected/badge_bar/AdvertBadgeView;I)V", "components_release"}, k = 2, mv = {1, 4, 2})
public final class AdvertBadgeViewsKt {
    public static final void loadImage(@NotNull AdvertBadgeView advertBadgeView, @NotNull Image image) {
        Intrinsics.checkNotNullParameter(advertBadgeView, "$this$loadImage");
        Intrinsics.checkNotNullParameter(image, "image");
        ImageLoadableView iconView$components_release = advertBadgeView.getIconView$components_release();
        ImageLoadableExtensionKt.loadImage(iconView$components_release, image, true, new Function1<Drawable, Unit>(iconView$components_release) { // from class: com.avito.android.lib.expected.badge_bar.AdvertBadgeViewsKt$loadImage$$inlined$load$1
            public final /* synthetic */ ImageLoadable a;

            {
                this.a = r1;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
                invoke(drawable);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Drawable drawable) {
                Intrinsics.checkNotNullParameter(drawable, "drawable");
                this.a.setState(State.LOADED);
            }
        }, new Function0<Unit>(iconView$components_release) { // from class: com.avito.android.lib.expected.badge_bar.AdvertBadgeViewsKt$loadImage$$inlined$load$2
            public final /* synthetic */ ImageLoadable a;

            {
                this.a = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            public final void invoke() {
                this.a.setState(State.ERROR);
            }
        });
    }

    public static final void setImage(@NotNull AdvertBadgeView advertBadgeView, @DrawableRes int i) {
        Intrinsics.checkNotNullParameter(advertBadgeView, "$this$setImage");
        advertBadgeView.getIconView$components_release().setImage(ContextCompat.getDrawable(advertBadgeView.getContext(), i));
        advertBadgeView.getIconView$components_release().setState(State.LOADED);
    }
}
