package com.avito.android.image_loader.glide;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.avito.android.image_loader.ImageLoader;
import com.avito.android.image_loader.ImageRequest;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/image_loader/glide/GlideImageLoader;", "Lcom/avito/android/image_loader/ImageLoader;", "Lcom/avito/android/image_loader/ImageRequest;", "request", "", "load", "(Lcom/avito/android/image_loader/ImageRequest;)V", "Landroid/widget/ImageView;", AuthSource.SEND_ABUSE, "Landroid/widget/ImageView;", "view", "<init>", "(Landroid/widget/ImageView;)V", "image-loader-glide_release"}, k = 1, mv = {1, 4, 2})
public final class GlideImageLoader implements ImageLoader {
    public final ImageView a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ GlideImageLoader a;
        public final /* synthetic */ ImageRequest b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(GlideImageLoader glideImageLoader, ImageRequest imageRequest) {
            super(0);
            this.a = glideImageLoader;
            this.b = imageRequest;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            if (this.b.getOnLoadFinished() == null) {
                GlideImageLoader.access$loadImage(this.a, this.b);
            } else {
                GlideImageLoader.access$loadImageWithCallback(this.a, this.b);
            }
            return Unit.INSTANCE;
        }
    }

    public GlideImageLoader(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "view");
        this.a = imageView;
    }

    public static final void access$loadImage(GlideImageLoader glideImageLoader, ImageRequest imageRequest) {
        Objects.requireNonNull(glideImageLoader);
        ImageRequest.Source source = imageRequest.getSource();
        Objects.requireNonNull(source, "null cannot be cast to non-null type com.avito.android.image_loader.ImageRequest.Source.UriSource");
        Uri uri = ((ImageRequest.Source.UriSource) source).getUri();
        RequestOptions requestOptions = new RequestOptions();
        Integer failureImage = imageRequest.getFailureImage();
        if (failureImage != null) {
            int intValue = failureImage.intValue();
            requestOptions.error(intValue);
            RequestOptions requestOptions2 = (RequestOptions) requestOptions.fallback(intValue);
        }
        if (imageRequest.getCenterCrop() || imageRequest.getCornerRadius() != 0) {
            ArrayList arrayList = new ArrayList();
            if (imageRequest.getCenterCrop()) {
                arrayList.add(new CenterCrop());
            }
            if (imageRequest.getCornerRadius() != 0) {
                arrayList.add(new RoundedCorners(imageRequest.getCornerRadius()));
            }
            if (!arrayList.isEmpty()) {
                Object[] array = arrayList.toArray(new Transformation[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                Transformation[] transformationArr = (Transformation[]) array;
                requestOptions.transform((Transformation[]) Arrays.copyOf(transformationArr, transformationArr.length));
            }
        }
        Glide.with(glideImageLoader.a.getContext()).load(uri).apply((BaseRequestOptions<?>) requestOptions).transition(DrawableTransitionOptions.withCrossFade()).into(glideImageLoader.a);
    }

    public static final void access$loadImageWithCallback(GlideImageLoader glideImageLoader, ImageRequest imageRequest) {
        Objects.requireNonNull(glideImageLoader);
        ImageRequest.Source source = imageRequest.getSource();
        Objects.requireNonNull(source, "null cannot be cast to non-null type com.avito.android.image_loader.ImageRequest.Source.UriSource");
        Uri uri = ((ImageRequest.Source.UriSource) source).getUri();
        Glide.with(glideImageLoader.a.getContext()).load(uri).into((RequestBuilder<Drawable>) new SimpleTarget<Drawable>(imageRequest) { // from class: com.avito.android.image_loader.glide.GlideImageLoader$loadImageWithCallback$target$1
            public final /* synthetic */ ImageRequest e;

            {
                this.e = r2;
            }

            @Override // com.bumptech.glide.request.target.Target
            public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                onResourceReady((Drawable) obj, (Transition<? super Drawable>) transition);
            }

            public void onResourceReady(@NotNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
                Intrinsics.checkNotNullParameter(drawable, "resource");
                if (drawable instanceof BitmapDrawable) {
                    GlideImageLoader.access$getView$p(GlideImageLoader.this).setImageDrawable(drawable);
                    Function0<Unit> onLoadFinished = this.e.getOnLoadFinished();
                    if (onLoadFinished != null) {
                        onLoadFinished.invoke();
                    }
                }
            }
        });
    }

    @Override // com.avito.android.image_loader.ImageLoader
    public void load(@NotNull ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, "request");
        ImageRequest.Source source = imageRequest.getSource();
        if (source instanceof ImageRequest.Source.ResourceDrawableSource) {
            this.a.setImageResource(((ImageRequest.Source.ResourceDrawableSource) source).getDrawable());
        } else if (source instanceof ImageRequest.Source.DrawableSource) {
            this.a.setImageDrawable(((ImageRequest.Source.DrawableSource) source).getDrawable());
        } else {
            Views.ensureMeasured$default(this.a, false, new a(this, imageRequest), 1, null);
        }
    }
}
