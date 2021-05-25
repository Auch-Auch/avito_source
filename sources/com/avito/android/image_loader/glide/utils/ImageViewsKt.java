package com.avito.android.image_loader.glide.utils;

import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import com.avito.android.image_loader.ImageRequest;
import com.avito.android.image_loader.Picture;
import com.avito.android.image_loader.glide.GlideImageLoader;
import com.avito.android.util.Views;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0003\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\b\b\u0003\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\n\u001a1\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\b\b\u0003\u0010\u0004\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0004\b\u0006\u0010\r\u001a\u001b\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\b\b\u0001\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u000f\u001a3\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\b\b\u0003\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroid/widget/ImageView;", "Lcom/avito/android/image_loader/Picture;", "picture", "", "failureImage", "", "load", "(Landroid/widget/ImageView;Lcom/avito/android/image_loader/Picture;I)V", "Landroid/net/Uri;", "url", "(Landroid/widget/ImageView;Landroid/net/Uri;I)V", "Lkotlin/Function0;", "onLoadedCallback", "(Landroid/widget/ImageView;Landroid/net/Uri;ILkotlin/jvm/functions/Function0;)V", "drawableId", "(Landroid/widget/ImageView;I)V", "", "centerCrop", "roundedCorners", "(Landroid/widget/ImageView;Landroid/net/Uri;IZI)V", "image-loader-glide_release"}, k = 2, mv = {1, 4, 2})
public final class ImageViewsKt {

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ Picture b;
        public final /* synthetic */ int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ImageView imageView, Picture picture, int i) {
            super(0);
            this.a = imageView;
            this.b = picture;
            this.c = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            ImageView imageView = this.a;
            ImageViewsKt.load(imageView, this.b.getUri(imageView), this.c);
            return Unit.INSTANCE;
        }
    }

    public static final void load(@NotNull ImageView imageView, @NotNull Picture picture, @DrawableRes int i) {
        Intrinsics.checkNotNullParameter(imageView, "$this$load");
        Intrinsics.checkNotNullParameter(picture, "picture");
        Views.ensureMeasured$default(imageView, false, new a(imageView, picture, i), 1, null);
    }

    public static /* synthetic */ void load$default(ImageView imageView, Picture picture, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        load(imageView, picture, i);
    }

    public static final void load(@NotNull ImageView imageView, @NotNull Uri uri, @DrawableRes int i) {
        Intrinsics.checkNotNullParameter(imageView, "$this$load");
        Intrinsics.checkNotNullParameter(uri, "url");
        new ImageRequest.Builder(new GlideImageLoader(imageView)).uri(uri).failureImage(i).load();
    }

    public static /* synthetic */ void load$default(ImageView imageView, Uri uri, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        load(imageView, uri, i);
    }

    public static /* synthetic */ void load$default(ImageView imageView, Uri uri, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        load(imageView, uri, i, function0);
    }

    public static /* synthetic */ void load$default(ImageView imageView, Uri uri, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        load(imageView, uri, i, z, i2);
    }

    public static final void load(@NotNull ImageView imageView, @NotNull Uri uri, @DrawableRes int i, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(imageView, "$this$load");
        Intrinsics.checkNotNullParameter(uri, "url");
        Intrinsics.checkNotNullParameter(function0, "onLoadedCallback");
        new ImageRequest.Builder(new GlideImageLoader(imageView)).uri(uri).failureImage(i).onLoadFinishedCallback(function0).load();
    }

    public static final void load(@NotNull ImageView imageView, @DrawableRes int i) {
        Intrinsics.checkNotNullParameter(imageView, "$this$load");
        new ImageRequest.Builder(new GlideImageLoader(imageView)).drawable(i).load();
    }

    public static final void load(@NotNull ImageView imageView, @NotNull Uri uri, @DrawableRes int i, boolean z, int i2) {
        Intrinsics.checkNotNullParameter(imageView, "$this$load");
        Intrinsics.checkNotNullParameter(uri, "url");
        new ImageRequest.Builder(new GlideImageLoader(imageView)).uri(uri).failureImage(i).centerCrop(z).roundedCorners(i2).load();
    }
}
