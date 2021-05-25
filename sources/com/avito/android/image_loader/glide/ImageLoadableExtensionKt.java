package com.avito.android.image_loader.glide;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import com.avito.android.design.ImageLoadable;
import com.avito.android.design.State;
import com.avito.android.remote.model.Image;
import com.avito.android.util.ImageFitting;
import com.avito.android.util.Images;
import com.avito.android.util.Views;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001aG\u0010\t\u001a\u00020\u0005*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0014\b\u0006\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u000e\b\u0006\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001aO\u0010\u000f\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0014\b\u0006\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u000e\b\u0006\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001aO\u0010\u0011\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0014\b\u0006\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u000e\b\u0006\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0010\u001aE\u0010\u0011\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0014\b\u0006\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u000e\b\u0006\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\n\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0012"}, d2 = {"Lcom/avito/android/design/ImageLoadable;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "", "onSuccessLoad", "Lkotlin/Function0;", "onErrorLoad", "loadUri", "(Lcom/avito/android/design/ImageLoadable;Landroid/net/Uri;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/remote/model/Image;", "image", "", "fitWidth", "loadImage", "(Lcom/avito/android/design/ImageLoadable;Lcom/avito/android/remote/model/Image;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "load", "image-loader-glide_release"}, k = 2, mv = {1, 4, 2})
public final class ImageLoadableExtensionKt {
    public static final void load(@NotNull ImageLoadable imageLoadable, @NotNull Image image, boolean z, @NotNull Function1<? super Drawable, Unit> function1, @NotNull Function0<Unit> function0) {
        Uri uri;
        Intrinsics.checkNotNullParameter(imageLoadable, "$this$load");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(function1, "onSuccessLoad");
        Intrinsics.checkNotNullParameter(function0, "onErrorLoad");
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
            if ((!Intrinsics.areEqual(uri, Uri.EMPTY)) && (imageLoadable instanceof View)) {
                if (uri == null) {
                    imageLoadable.setImage(null);
                    return;
                }
                View view = (View) imageLoadable;
                Glide.with(view).load(uri).into((RequestBuilder<Drawable>) new CustomViewTarget<View, Drawable>(imageLoadable, view, imageLoadable, function0, imageLoadable, function1) { // from class: com.avito.android.image_loader.glide.ImageLoadableExtensionKt$load$$inlined$loadImage$1
                    public final /* synthetic */ ImageLoadable f;
                    public final /* synthetic */ ImageLoadable g;
                    public final /* synthetic */ Function0 h;
                    public final /* synthetic */ ImageLoadable i;
                    public final /* synthetic */ Function1 j;

                    {
                        this.f = r1;
                        this.g = r3;
                        this.h = r4;
                        this.i = r5;
                        this.j = r6;
                    }

                    @Override // com.bumptech.glide.request.target.Target
                    public void onLoadFailed(@Nullable Drawable drawable) {
                        this.g.setState(State.ERROR);
                        this.h.invoke();
                    }

                    @Override // com.bumptech.glide.request.target.CustomViewTarget
                    public void onResourceCleared(@Nullable Drawable drawable) {
                    }

                    @Override // com.bumptech.glide.request.target.Target
                    public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                        onResourceReady((Drawable) obj, (Transition<? super Drawable>) transition);
                    }

                    public void onResourceReady(@NotNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
                        Intrinsics.checkNotNullParameter(drawable, "resource");
                        this.i.setState(State.LOADED);
                        this.j.invoke(drawable);
                        this.f.setImage(drawable);
                    }
                });
            }
        }
    }

    public static /* synthetic */ void load$default(ImageLoadable imageLoadable, Image image, boolean z, Function1 function1, Function0 function0, int i, Object obj) {
        Uri uri;
        boolean z2 = (i & 2) != 0 ? true : z;
        ImageLoadableExtensionKt$load$1 imageLoadableExtensionKt$load$1 = (i & 4) != 0 ? ImageLoadableExtensionKt$load$1.INSTANCE : function1;
        ImageLoadableExtensionKt$load$2 imageLoadableExtensionKt$load$2 = (i & 8) != 0 ? ImageLoadableExtensionKt$load$2.INSTANCE : function0;
        Intrinsics.checkNotNullParameter(imageLoadable, "$this$load");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(imageLoadableExtensionKt$load$1, "onSuccessLoad");
        Intrinsics.checkNotNullParameter(imageLoadableExtensionKt$load$2, "onErrorLoad");
        View imageContainerView = imageLoadable.getImageContainerView();
        if (imageContainerView != null) {
            ImageFitting fit = Images.fit(image, Views.getDefinedWidth(imageContainerView), Views.getDefinedHeight(imageContainerView), 0.0f, 1.5f, 2);
            if (z2) {
                uri = fit.width();
            } else {
                uri = fit.height();
            }
            if (uri == null) {
                uri = Uri.EMPTY;
            }
            if ((true ^ Intrinsics.areEqual(uri, Uri.EMPTY)) && (imageLoadable instanceof View)) {
                if (uri == null) {
                    imageLoadable.setImage(null);
                    return;
                }
                View view = (View) imageLoadable;
                Glide.with(view).load(uri).into((RequestBuilder<Drawable>) new CustomViewTarget<View, Drawable>(imageLoadable, view, imageLoadable, imageLoadableExtensionKt$load$2, imageLoadable, imageLoadableExtensionKt$load$1) { // from class: com.avito.android.image_loader.glide.ImageLoadableExtensionKt$load$$inlined$loadImage$2
                    public final /* synthetic */ ImageLoadable f;
                    public final /* synthetic */ ImageLoadable g;
                    public final /* synthetic */ Function0 h;
                    public final /* synthetic */ ImageLoadable i;
                    public final /* synthetic */ Function1 j;

                    {
                        this.f = r1;
                        this.g = r3;
                        this.h = r4;
                        this.i = r5;
                        this.j = r6;
                    }

                    @Override // com.bumptech.glide.request.target.Target
                    public void onLoadFailed(@Nullable Drawable drawable) {
                        this.g.setState(State.ERROR);
                        this.h.invoke();
                    }

                    @Override // com.bumptech.glide.request.target.CustomViewTarget
                    public void onResourceCleared(@Nullable Drawable drawable) {
                    }

                    @Override // com.bumptech.glide.request.target.Target
                    public /* bridge */ /* synthetic */ void onResourceReady(Object obj2, Transition transition) {
                        onResourceReady((Drawable) obj2, (Transition<? super Drawable>) transition);
                    }

                    public void onResourceReady(@NotNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
                        Intrinsics.checkNotNullParameter(drawable, "resource");
                        this.i.setState(State.LOADED);
                        this.j.invoke(drawable);
                        this.f.setImage(drawable);
                    }
                });
            }
        }
    }

    public static final void loadImage(@NotNull ImageLoadable imageLoadable, @NotNull Image image, boolean z, @NotNull Function1<? super Drawable, Unit> function1, @NotNull Function0<Unit> function0) {
        Uri uri;
        Intrinsics.checkNotNullParameter(imageLoadable, "$this$loadImage");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(function1, "onSuccessLoad");
        Intrinsics.checkNotNullParameter(function0, "onErrorLoad");
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
            if ((!Intrinsics.areEqual(uri, Uri.EMPTY)) && (imageLoadable instanceof View)) {
                if (uri == null) {
                    imageLoadable.setImage(null);
                    return;
                }
                View view = (View) imageLoadable;
                Glide.with(view).load(uri).into((RequestBuilder<Drawable>) new ImageLoadableExtensionKt$loadUri$3(imageLoadable, function0, function1, view));
            }
        }
    }

    public static /* synthetic */ void loadImage$default(ImageLoadable imageLoadable, Image image, boolean z, Function1 function1, Function0 function0, int i, Object obj) {
        Uri uri;
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            function1 = ImageLoadableExtensionKt$loadImage$1.INSTANCE;
        }
        if ((i & 8) != 0) {
            function0 = ImageLoadableExtensionKt$loadImage$2.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(imageLoadable, "$this$loadImage");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(function1, "onSuccessLoad");
        Intrinsics.checkNotNullParameter(function0, "onErrorLoad");
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
            if ((!Intrinsics.areEqual(uri, Uri.EMPTY)) && (imageLoadable instanceof View)) {
                if (uri == null) {
                    imageLoadable.setImage(null);
                    return;
                }
                View view = (View) imageLoadable;
                Glide.with(view).load(uri).into((RequestBuilder<Drawable>) new ImageLoadableExtensionKt$loadUri$3(imageLoadable, function0, function1, view));
            }
        }
    }

    public static final void loadUri(@NotNull ImageLoadable imageLoadable, @Nullable Uri uri, @NotNull Function1<? super Drawable, Unit> function1, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(imageLoadable, "$this$loadUri");
        Intrinsics.checkNotNullParameter(function1, "onSuccessLoad");
        Intrinsics.checkNotNullParameter(function0, "onErrorLoad");
        if (imageLoadable instanceof View) {
            if (uri == null) {
                imageLoadable.setImage(null);
                return;
            }
            View view = (View) imageLoadable;
            Glide.with(view).load(uri).into((RequestBuilder<Drawable>) new ImageLoadableExtensionKt$loadUri$3(imageLoadable, function0, function1, view));
        }
    }

    public static /* synthetic */ void loadUri$default(ImageLoadable imageLoadable, Uri uri, Function1 function1, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = ImageLoadableExtensionKt$loadUri$1.INSTANCE;
        }
        if ((i & 4) != 0) {
            function0 = ImageLoadableExtensionKt$loadUri$2.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(imageLoadable, "$this$loadUri");
        Intrinsics.checkNotNullParameter(function1, "onSuccessLoad");
        Intrinsics.checkNotNullParameter(function0, "onErrorLoad");
        if (imageLoadable instanceof View) {
            if (uri == null) {
                imageLoadable.setImage(null);
                return;
            }
            View view = (View) imageLoadable;
            Glide.with(view).load(uri).into((RequestBuilder<Drawable>) new ImageLoadableExtensionKt$loadUri$3(imageLoadable, function0, function1, view));
        }
    }

    public static final void load(@NotNull ImageLoadable imageLoadable, @NotNull Uri uri, @NotNull Function1<? super Drawable, Unit> function1, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(imageLoadable, "$this$load");
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Intrinsics.checkNotNullParameter(function1, "onSuccessLoad");
        Intrinsics.checkNotNullParameter(function0, "onErrorLoad");
        if (imageLoadable instanceof View) {
            View view = (View) imageLoadable;
            Glide.with(view).load(uri).into((RequestBuilder<Drawable>) new CustomViewTarget<View, Drawable>(imageLoadable, view, imageLoadable, function0, imageLoadable, function1) { // from class: com.avito.android.image_loader.glide.ImageLoadableExtensionKt$load$$inlined$loadUri$1
                public final /* synthetic */ ImageLoadable f;
                public final /* synthetic */ ImageLoadable g;
                public final /* synthetic */ Function0 h;
                public final /* synthetic */ ImageLoadable i;
                public final /* synthetic */ Function1 j;

                {
                    this.f = r1;
                    this.g = r3;
                    this.h = r4;
                    this.i = r5;
                    this.j = r6;
                }

                @Override // com.bumptech.glide.request.target.Target
                public void onLoadFailed(@Nullable Drawable drawable) {
                    this.g.setState(State.ERROR);
                    this.h.invoke();
                }

                @Override // com.bumptech.glide.request.target.CustomViewTarget
                public void onResourceCleared(@Nullable Drawable drawable) {
                }

                @Override // com.bumptech.glide.request.target.Target
                public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                    onResourceReady((Drawable) obj, (Transition<? super Drawable>) transition);
                }

                public void onResourceReady(@NotNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
                    Intrinsics.checkNotNullParameter(drawable, "resource");
                    this.i.setState(State.LOADED);
                    this.j.invoke(drawable);
                    this.f.setImage(drawable);
                }
            });
        }
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
        if (imageLoadable instanceof View) {
            View view = (View) imageLoadable;
            Glide.with(view).load(uri).into((RequestBuilder<Drawable>) new CustomViewTarget<View, Drawable>(imageLoadable, view, imageLoadable, function0, imageLoadable, function1) { // from class: com.avito.android.image_loader.glide.ImageLoadableExtensionKt$load$$inlined$loadUri$2
                public final /* synthetic */ ImageLoadable f;
                public final /* synthetic */ ImageLoadable g;
                public final /* synthetic */ Function0 h;
                public final /* synthetic */ ImageLoadable i;
                public final /* synthetic */ Function1 j;

                {
                    this.f = r1;
                    this.g = r3;
                    this.h = r4;
                    this.i = r5;
                    this.j = r6;
                }

                @Override // com.bumptech.glide.request.target.Target
                public void onLoadFailed(@Nullable Drawable drawable) {
                    this.g.setState(State.ERROR);
                    this.h.invoke();
                }

                @Override // com.bumptech.glide.request.target.CustomViewTarget
                public void onResourceCleared(@Nullable Drawable drawable) {
                }

                @Override // com.bumptech.glide.request.target.Target
                public /* bridge */ /* synthetic */ void onResourceReady(Object obj2, Transition transition) {
                    onResourceReady((Drawable) obj2, (Transition<? super Drawable>) transition);
                }

                public void onResourceReady(@NotNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
                    Intrinsics.checkNotNullParameter(drawable, "resource");
                    this.i.setState(State.LOADED);
                    this.j.invoke(drawable);
                    this.f.setImage(drawable);
                }
            });
        }
    }
}
