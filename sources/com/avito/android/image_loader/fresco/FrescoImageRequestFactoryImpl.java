package com.avito.android.image_loader.fresco;

import android.content.res.Resources;
import android.view.View;
import com.avito.android.image_loader.BackgroundColorReceiver;
import com.avito.android.image_loader.ImageRequest;
import com.avito.android.image_loader.fresco.postprocessor.DominantColorBackgroundPostProcessor;
import com.avito.android.image_loader.fresco.postprocessor.DominantColorEdgePostProcessor;
import com.avito.android.image_loader.fresco.postprocessor.RotationPostProcessor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Rotation;
import com.avito.android.util.Views;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\u00020\b*\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u000f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/image_loader/fresco/FrescoImageRequestFactoryImpl;", "Lcom/avito/android/image_loader/fresco/FrescoImageRequestFactory;", "Lcom/avito/android/image_loader/ImageRequest;", "request", "Lcom/facebook/imagepipeline/request/ImageRequest;", "create", "(Lcom/avito/android/image_loader/ImageRequest;)Lcom/facebook/imagepipeline/request/ImageRequest;", "Lcom/facebook/imagepipeline/request/ImageRequestBuilder;", "", AuthSource.SEND_ABUSE, "(Lcom/facebook/imagepipeline/request/ImageRequestBuilder;)V", "Landroid/view/View;", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "image-loader-fresco_release"}, k = 1, mv = {1, 4, 2})
public final class FrescoImageRequestFactoryImpl implements FrescoImageRequestFactory {
    @NotNull
    public final View a;

    public FrescoImageRequestFactoryImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.a = view;
    }

    public final void a(ImageRequestBuilder imageRequestBuilder) {
        if (imageRequestBuilder.getPostprocessor() != null) {
            throw new IllegalArgumentException("Postprocessor already exists");
        }
    }

    @Override // com.avito.android.image_loader.fresco.FrescoImageRequestFactory
    @Nullable
    public ImageRequest create(@NotNull com.avito.android.image_loader.ImageRequest imageRequest) {
        ImageRequestBuilder imageRequestBuilder;
        Intrinsics.checkNotNullParameter(imageRequest, "request");
        View view = this.a;
        ImageRequest.Source source = imageRequest.getSource();
        ResizeOptions resizeOptions = null;
        if (source instanceof ImageRequest.Source.ResourceDrawableSource) {
            imageRequestBuilder = ImageRequestBuilder.newBuilderWithResourceId(((ImageRequest.Source.ResourceDrawableSource) source).getDrawable());
        } else if (source instanceof ImageRequest.Source.UriSource) {
            imageRequestBuilder = ImageRequestBuilder.newBuilderWithSource(((ImageRequest.Source.UriSource) source).getUri());
        } else {
            imageRequestBuilder = source instanceof ImageRequest.Source.ImageSource ? ImageRequestBuilder.newBuilderWithSource(((ImageRequest.Source.ImageSource) source).getPicture().getUri(view)) : null;
        }
        if (imageRequestBuilder == null) {
            return null;
        }
        if (imageRequest.getBackgroundColorReceiver() != null) {
            a(imageRequestBuilder);
            BackgroundColorReceiver backgroundColorReceiver = imageRequest.getBackgroundColorReceiver();
            Intrinsics.checkNotNull(backgroundColorReceiver);
            imageRequestBuilder.setPostprocessor(new DominantColorBackgroundPostProcessor(backgroundColorReceiver));
        } else {
            Integer dominantColorEdgeFallbackColor = imageRequest.getDominantColorEdgeFallbackColor();
            if (dominantColorEdgeFallbackColor != null) {
                a(imageRequestBuilder);
                imageRequestBuilder.setPostprocessor(new DominantColorEdgePostProcessor(dominantColorEdgeFallbackColor.intValue()));
            }
        }
        Rotation rotation = imageRequest.getRotation();
        if (rotation != null && (!Intrinsics.areEqual(rotation, new Rotation.Rotation_0()))) {
            a(imageRequestBuilder);
            imageRequestBuilder.setPostprocessor(new RotationPostProcessor(rotation));
        }
        View view2 = this.a;
        if (Views.isMeasured(view2)) {
            resizeOptions = new ResizeOptions(Views.getDefinedWidth(view2), Views.getDefinedHeight(view2));
        }
        if (resizeOptions == null) {
            Resources resources = this.a.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
            int i = resources.getDisplayMetrics().heightPixels;
            Resources resources2 = this.a.getResources();
            Intrinsics.checkNotNullExpressionValue(resources2, "view.resources");
            resizeOptions = new ResizeOptions(resources2.getDisplayMetrics().widthPixels, i);
        }
        return imageRequestBuilder.setResizeOptions(resizeOptions).setRotationOptions(RotationOptions.autoRotate()).build();
    }

    @NotNull
    public final View getView() {
        return this.a;
    }
}
