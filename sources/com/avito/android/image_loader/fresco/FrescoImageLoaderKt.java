package com.avito.android.image_loader.fresco;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.avito.android.image_loader.ImageRequest;
import com.avito.android.util.Views;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"image-loader-fresco_release"}, k = 2, mv = {1, 4, 2})
public final class FrescoImageLoaderKt {
    public static final void access$showOverlay(SimpleDraweeView simpleDraweeView, ImageRequest imageRequest) {
        Drawable foreground = imageRequest.getForeground();
        if (foreground != null) {
            foreground.setBounds(new Rect(0, 0, Views.getDefinedWidth(simpleDraweeView), Views.getDefinedHeight(simpleDraweeView)));
            simpleDraweeView.getOverlay().add(foreground);
        }
    }
}
