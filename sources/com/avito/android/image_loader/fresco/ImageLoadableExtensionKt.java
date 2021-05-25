package com.avito.android.image_loader.fresco;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import com.avito.android.design.ImageLoadable;
import com.avito.android.remote.model.Image;
import com.avito.android.util.ImageFitting;
import com.avito.android.util.Images;
import com.avito.android.util.Views;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001aE\u0010\t\u001a\u00020\u0005*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\n\u001aM\u0010\u000f\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001aO\u0010\u0011\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0014\b\u0006\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u000e\b\u0006\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0010\u001aE\u0010\u0011\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0006\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u000e\b\u0006\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\n\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0012"}, d2 = {"Lcom/avito/android/design/ImageLoadable;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "", "onSuccessLoad", "Lkotlin/Function0;", "onErrorLoad", "loadUri", "(Lcom/avito/android/design/ImageLoadable;Landroid/net/Uri;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/remote/model/Image;", "image", "", "fitWidth", "loadImage", "(Lcom/avito/android/design/ImageLoadable;Lcom/avito/android/remote/model/Image;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "load", "image-loader-fresco_release"}, k = 2, mv = {1, 4, 2})
public final class ImageLoadableExtensionKt {
    public static final void load(@NotNull ImageLoadable imageLoadable, @NotNull Image image, boolean z, @NotNull Function1<? super Drawable, Unit> function1, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(imageLoadable, "$this$load");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(function1, "onSuccessLoad");
        Intrinsics.checkNotNullParameter(function0, "onErrorLoad");
        loadImage(imageLoadable, image, z, new ImageLoadableExtensionKt$load$3(imageLoadable, function1), new ImageLoadableExtensionKt$load$4(imageLoadable, function0));
    }

    public static /* synthetic */ void load$default(ImageLoadable imageLoadable, Image image, boolean z, Function1 function1, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            function1 = ImageLoadableExtensionKt$load$1.INSTANCE;
        }
        if ((i & 8) != 0) {
            function0 = ImageLoadableExtensionKt$load$2.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(imageLoadable, "$this$load");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(function1, "onSuccessLoad");
        Intrinsics.checkNotNullParameter(function0, "onErrorLoad");
        loadImage(imageLoadable, image, z, new ImageLoadableExtensionKt$load$3(imageLoadable, function1), new ImageLoadableExtensionKt$load$4(imageLoadable, function0));
    }

    public static final void loadImage(@NotNull ImageLoadable imageLoadable, @NotNull Image image, boolean z, @Nullable Function1<? super Drawable, Unit> function1, @Nullable Function0<Unit> function0) {
        Uri uri;
        Intrinsics.checkNotNullParameter(imageLoadable, "$this$loadImage");
        Intrinsics.checkNotNullParameter(image, "image");
        View imageContainerView = imageLoadable.getImageContainerView();
        if (imageContainerView != null) {
            ImageFitting fit = Images.fit(image, Views.getDefinedWidth(imageContainerView), Views.getDefinedHeight(imageContainerView), 0.0f, 1.5f, 2);
            if (z) {
                uri = fit.width();
            } else {
                uri = fit.height();
            }
            if (uri == null) {
                uri = Uri.EMPTY;
            }
            if (!Intrinsics.areEqual(uri, Uri.EMPTY)) {
                loadUri(imageLoadable, uri, function1, function0);
            }
        }
    }

    public static /* synthetic */ void loadImage$default(ImageLoadable imageLoadable, Image image, boolean z, Function1 function1, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        if ((i & 8) != 0) {
            function0 = null;
        }
        loadImage(imageLoadable, image, z, function1, function0);
    }

    public static final void loadUri(@NotNull ImageLoadable imageLoadable, @Nullable Uri uri, @Nullable Function1<? super Drawable, Unit> function1, @Nullable Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(imageLoadable, "$this$loadUri");
        View imageContainerView = imageLoadable.getImageContainerView();
        if (imageContainerView == null) {
            return;
        }
        if (uri == null) {
            imageLoadable.setImage(null);
            return;
        }
        DataSource<CloseableReference<CloseableImage>> fetchDecodedImage = Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(uri).setLowestPermittedRequestLevel(ImageRequest.RequestLevel.FULL_FETCH).build(), imageContainerView.getContext());
        Intrinsics.checkNotNullExpressionValue(fetchDecodedImage, "imagePipeline.fetchDecod…uest, targetView.context)");
        fetchDecodedImage.subscribe(new BaseBitmapDataSubscriber(imageLoadable, fetchDecodedImage, imageContainerView, function1, function0) { // from class: com.avito.android.image_loader.fresco.ImageLoadableExtensionKt$loadUri$dataSubscriber$1
            public final /* synthetic */ ImageLoadable a;
            public final /* synthetic */ DataSource b;
            public final /* synthetic */ View c;
            public final /* synthetic */ Function1 d;
            public final /* synthetic */ Function0 e;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
            }

            @Override // com.facebook.datasource.BaseDataSubscriber
            public void onFailureImpl(@NotNull DataSource<CloseableReference<CloseableImage>> dataSource) {
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                Function0 function02 = this.e;
                if (function02 != null) {
                    Unit unit = (Unit) function02.invoke();
                }
            }

            @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
            public void onNewResultImpl(@Nullable Bitmap bitmap) {
                if (this.b.isFinished()) {
                    if (bitmap != null) {
                        try {
                            if (!bitmap.isRecycled()) {
                                this.a.setImage(null);
                                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.c.getResources(), bitmap.copy(Bitmap.Config.ARGB_8888, true));
                                Function1 function12 = this.d;
                                if (function12 != null) {
                                    Unit unit = (Unit) function12.invoke(bitmapDrawable);
                                }
                                this.a.setImage(bitmapDrawable);
                            }
                        } catch (Throwable th) {
                            this.b.close();
                            throw th;
                        }
                    }
                    this.b.close();
                }
            }
        }, UiThreadImmediateExecutorService.getInstance());
        imageContainerView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(fetchDecodedImage) { // from class: com.avito.android.image_loader.fresco.ImageLoadableExtensionKt$loadUri$1
            public final /* synthetic */ DataSource a;

            {
                this.a = r1;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(@Nullable View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(@Nullable View view) {
                this.a.close();
            }
        });
    }

    public static /* synthetic */ void loadUri$default(ImageLoadable imageLoadable, Uri uri, Function1 function1, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        loadUri(imageLoadable, uri, function1, function0);
    }

    public static final void load(@NotNull ImageLoadable imageLoadable, @NotNull Uri uri, @NotNull Function1<? super Drawable, Unit> function1, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(imageLoadable, "$this$load");
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Intrinsics.checkNotNullParameter(function1, "onSuccessLoad");
        Intrinsics.checkNotNullParameter(function0, "onErrorLoad");
        loadUri(imageLoadable, uri, new ImageLoadableExtensionKt$load$7(imageLoadable, function1), new ImageLoadableExtensionKt$load$8(imageLoadable, function0));
    }

    public static /* synthetic */ void load$default(ImageLoadable imageLoadable, Uri uri, Function1 function1, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = ImageLoadableExtensionKt$load$5.INSTANCE;
        }
        if ((i & 4) != 0) {
            function0 = ImageLoadableExtensionKt$load$6.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(imageLoadable, "$this$load");
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Intrinsics.checkNotNullParameter(function1, "onSuccessLoad");
        Intrinsics.checkNotNullParameter(function0, "onErrorLoad");
        loadUri(imageLoadable, uri, new ImageLoadableExtensionKt$load$7(imageLoadable, function1), new ImageLoadableExtensionKt$load$8(imageLoadable, function0));
    }
}
