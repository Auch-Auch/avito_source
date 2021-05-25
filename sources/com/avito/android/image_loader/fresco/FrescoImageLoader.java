package com.avito.android.image_loader.fresco;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Size;
import com.avito.android.image_loader.ImageLoader;
import com.avito.android.image_loader.ImageRequest;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Uris;
import com.avito.android.util.Views;
import com.facebook.datasource.RetainingDataSourceSupplier;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/image_loader/fresco/FrescoImageLoader;", "Lcom/avito/android/image_loader/ImageLoader;", "Lcom/avito/android/image_loader/ImageRequest;", "request", "", "load", "(Lcom/avito/android/image_loader/ImageRequest;)V", "Lcom/facebook/imagepipeline/request/ImageRequest;", "frescoRequest", "La2/a/a/d1/a/a;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/image_loader/ImageRequest;Lcom/facebook/imagepipeline/request/ImageRequest;)La2/a/a/d1/a/a;", "Lcom/avito/android/image_loader/fresco/FrescoImageRequestFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/image_loader/fresco/FrescoImageRequestFactory;", "requestFactory", "Lcom/facebook/drawee/view/SimpleDraweeView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "view", "<init>", "(Lcom/facebook/drawee/view/SimpleDraweeView;Lcom/avito/android/image_loader/fresco/FrescoImageRequestFactory;)V", "image-loader-fresco_release"}, k = 1, mv = {1, 4, 2})
public final class FrescoImageLoader implements ImageLoader {
    public final SimpleDraweeView a;
    public final FrescoImageRequestFactory b;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj, Object obj2) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                FrescoImageLoaderKt.access$showOverlay(((FrescoImageLoader) this.b).a, (ImageRequest) this.c);
                return Unit.INSTANCE;
            } else if (i == 1) {
                FrescoImageLoader.access$loadImage((FrescoImageLoader) this.b, (ImageRequest) this.c);
                FrescoImageLoaderKt.access$showOverlay(((FrescoImageLoader) this.b).a, (ImageRequest) this.c);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public FrescoImageLoader(@NotNull SimpleDraweeView simpleDraweeView, @NotNull FrescoImageRequestFactory frescoImageRequestFactory) {
        Intrinsics.checkNotNullParameter(simpleDraweeView, "view");
        Intrinsics.checkNotNullParameter(frescoImageRequestFactory, "requestFactory");
        this.a = simpleDraweeView;
        this.b = frescoImageRequestFactory;
    }

    public static final void access$loadImage(FrescoImageLoader frescoImageLoader, ImageRequest imageRequest) {
        Objects.requireNonNull(frescoImageLoader);
        com.facebook.imagepipeline.request.ImageRequest imageRequest2 = null;
        if (imageRequest.getRetain()) {
            com.facebook.imagepipeline.request.ImageRequest create = frescoImageLoader.b.create(imageRequest);
            if (!(frescoImageLoader.a.getTag() instanceof RetainingDataSourceSupplier)) {
                RetainingDataSourceSupplier retainingDataSourceSupplier = new RetainingDataSourceSupplier();
                frescoImageLoader.a.setController(((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setOldController(frescoImageLoader.a.getController())).setDataSourceSupplier(retainingDataSourceSupplier)).setControllerListener(frescoImageLoader.a(imageRequest, create))).setAutoPlayAnimations(imageRequest.getAutoPlayAnimations())).build());
                frescoImageLoader.a.setTag(retainingDataSourceSupplier);
            }
            Object tag = frescoImageLoader.a.getTag();
            Objects.requireNonNull(tag, "null cannot be cast to non-null type com.facebook.datasource.RetainingDataSourceSupplier<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>");
            ((RetainingDataSourceSupplier) tag).replaceSupplier(Fresco.getImagePipeline().getDataSourceSupplier(create, null, ImageRequest.RequestLevel.FULL_FETCH));
        } else {
            Object tag2 = frescoImageLoader.a.getTag();
            if (!(tag2 instanceof com.avito.android.image_loader.ImageRequest)) {
                tag2 = null;
            }
            com.avito.android.image_loader.ImageRequest imageRequest3 = (com.avito.android.image_loader.ImageRequest) tag2;
            boolean z = false;
            if (imageRequest3 != null) {
                if (Intrinsics.areEqual(frescoImageLoader.b.create(imageRequest), frescoImageLoader.b.create(imageRequest3)) && Intrinsics.areEqual(imageRequest, imageRequest3)) {
                    z = true;
                }
            }
            if (!z) {
                frescoImageLoader.a.setTag(imageRequest);
                com.facebook.imagepipeline.request.ImageRequest create2 = frescoImageLoader.b.create(imageRequest);
                com.avito.android.image_loader.ImageRequest lowResRequest = imageRequest.getLowResRequest();
                if (lowResRequest != null) {
                    imageRequest2 = ImageRequestBuilder.fromRequest(frescoImageLoader.b.create(lowResRequest)).setRequestPriority(Priority.HIGH).build();
                }
                frescoImageLoader.a.setController(((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setOldController(frescoImageLoader.a.getController())).setControllerListener(frescoImageLoader.a(imageRequest, create2))).setImageRequest(create2)).setLowResImageRequest(imageRequest2)).setAutoPlayAnimations(imageRequest.getAutoPlayAnimations())).build());
            } else {
                return;
            }
        }
        Float aspectRatio = imageRequest.getAspectRatio();
        if (aspectRatio != null) {
            frescoImageLoader.a.setAspectRatio(aspectRatio.floatValue());
        }
    }

    public final a2.a.a.d1.a.a a(com.avito.android.image_loader.ImageRequest imageRequest, com.facebook.imagepipeline.request.ImageRequest imageRequest2) {
        Uri uri = null;
        if (imageRequest2 != null ? Uris.isNullOrEmpty(imageRequest2.getSourceUri()) : true) {
            return null;
        }
        Uri sourceUri = imageRequest2 != null ? imageRequest2.getSourceUri() : null;
        ImageRequest.SourcePlace sourcePlace = imageRequest.getSourcePlace();
        if (imageRequest2 != null) {
            uri = imageRequest2.getSourceUri();
        }
        return new a2.a.a.d1.a.a(sourceUri, sourcePlace, uri, new Size(Views.getDefinedWidth(this.a), Views.getDefinedHeight(this.a)), imageRequest.getAdvertId(), imageRequest.isConnectionAvailable(), ImageRequestListenersKt.toControllerListener(imageRequest.getListener()));
    }

    @Override // com.avito.android.image_loader.ImageLoader
    public void load(@NotNull com.avito.android.image_loader.ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, "request");
        Drawable placeholder = imageRequest.getPlaceholder();
        if (placeholder != null) {
            ((GenericDraweeHierarchy) this.a.getHierarchy()).setPlaceholderImage(placeholder, ScalingUtils.ScaleType.CENTER_INSIDE);
        }
        Integer failureImage = imageRequest.getFailureImage();
        if (failureImage != null) {
            ((GenericDraweeHierarchy) this.a.getHierarchy()).setFailureImage(failureImage.intValue(), ScalingUtils.ScaleType.CENTER_INSIDE);
        }
        if (imageRequest.getNoFadeAnimation()) {
            GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) this.a.getHierarchy();
            Intrinsics.checkNotNullExpressionValue(genericDraweeHierarchy, "view.hierarchy");
            genericDraweeHierarchy.setFadeDuration(0);
        }
        this.a.getOverlay().clear();
        ImageRequest.Source source = imageRequest.getSource();
        if (source instanceof ImageRequest.Source.DrawableSource) {
            ((GenericDraweeHierarchy) this.a.getHierarchy()).setPlaceholderImage(((ImageRequest.Source.DrawableSource) source).getDrawable());
            Views.ensureMeasured(this.a, imageRequest.getCancelOnDetach(), new a(0, this, imageRequest));
            return;
        }
        Views.ensureMeasured(this.a, imageRequest.getCancelOnDetach(), new a(1, this, imageRequest));
    }
}
