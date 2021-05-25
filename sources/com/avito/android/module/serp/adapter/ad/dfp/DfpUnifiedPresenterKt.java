package com.avito.android.module.serp.adapter.ad.dfp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.component.ads.dfp.AdDfpUnified;
import com.avito.android.util.Logs;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import io.reactivex.rxjava3.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a!\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/module/serp/adapter/ad/dfp/DfpImageLoaderImpl;", "Lcom/google/android/gms/ads/formats/UnifiedNativeAd;", "ad", "Lcom/avito/android/component/ads/dfp/AdDfpUnified;", "view", "", "bindMedia", "(Lcom/avito/android/module/serp/adapter/ad/dfp/DfpImageLoaderImpl;Lcom/google/android/gms/ads/formats/UnifiedNativeAd;Lcom/avito/android/component/ads/dfp/AdDfpUnified;)I", "serp-core_release"}, k = 2, mv = {1, 4, 2})
public final class DfpUnifiedPresenterKt {

    public static final class a<T> implements Consumer<Drawable> {
        public final /* synthetic */ WeakReference a;
        public final /* synthetic */ WeakReference b;
        public final /* synthetic */ Ref.IntRef c;

        public a(WeakReference weakReference, WeakReference weakReference2, Ref.IntRef intRef) {
            this.a = weakReference;
            this.b = weakReference2;
            this.c = intRef;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Drawable drawable) {
            Drawable drawable2 = drawable;
            AdDfpUnified adDfpUnified = (AdDfpUnified) this.a.get();
            UnifiedNativeAd unifiedNativeAd = (UnifiedNativeAd) this.b.get();
            if (adDfpUnified != null && unifiedNativeAd != null && adDfpUnified.getImageOperationId() == this.c.element) {
                Intrinsics.checkNotNullExpressionValue(drawable2, "loadedImage");
                DfpUnifiedPresenterKt.access$setLoadedImage(adDfpUnified, drawable2, unifiedNativeAd, true);
                adDfpUnified.setNativeAd(unifiedNativeAd);
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("DfpImageLoaderImpl.bindImage image load error", th);
        }
    }

    public static final void access$setLoadedImage(AdDfpUnified adDfpUnified, Drawable drawable, UnifiedNativeAd unifiedNativeAd, boolean z) {
        MediaContent mediaContent = unifiedNativeAd.getMediaContent();
        Intrinsics.checkNotNullExpressionValue(mediaContent, "localMediaContent");
        mediaContent.setMainImage(drawable);
        adDfpUnified.setMediaContent(mediaContent, z);
    }

    public static final int bindMedia(@NotNull DfpImageLoaderImpl dfpImageLoaderImpl, @NotNull UnifiedNativeAd unifiedNativeAd, @NotNull AdDfpUnified adDfpUnified) {
        Intrinsics.checkNotNullParameter(dfpImageLoaderImpl, "$this$bindMedia");
        Intrinsics.checkNotNullParameter(unifiedNativeAd, "ad");
        Intrinsics.checkNotNullParameter(adDfpUnified, "view");
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 0;
        List<NativeAd.Image> images = unifiedNativeAd.getImages();
        Intrinsics.checkNotNullExpressionValue(images, "ad.images");
        NativeAd.Image image = (NativeAd.Image) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) images);
        Uri uri = image != null ? image.getUri() : null;
        MediaContent mediaContent = unifiedNativeAd.getMediaContent();
        Intrinsics.checkNotNullExpressionValue(mediaContent, "adMediaContent");
        Drawable mainImage = mediaContent.getMainImage();
        boolean z = true;
        if (!(!Intrinsics.areEqual(adDfpUnified.getImageUri(), uri)) || mainImage == null) {
            z = false;
        } else {
            dfpImageLoaderImpl.cancel(adDfpUnified.getImageOperationId());
            mediaContent.setMainImage(null);
            adDfpUnified.clearImageData();
        }
        adDfpUnified.setMediaContent(mediaContent, false);
        if (uri != null && (mainImage == null || z)) {
            Drawable takeImageFromCache = dfpImageLoaderImpl.takeImageFromCache(uri);
            if (takeImageFromCache != null) {
                MediaContent mediaContent2 = unifiedNativeAd.getMediaContent();
                Intrinsics.checkNotNullExpressionValue(mediaContent2, "localMediaContent");
                mediaContent2.setMainImage(takeImageFromCache);
                adDfpUnified.setMediaContent(mediaContent2, false);
            } else {
                int createLoadOperationId = dfpImageLoaderImpl.createLoadOperationId();
                intRef.element = createLoadOperationId;
                adDfpUnified.setImageOperationId(createLoadOperationId);
                adDfpUnified.setImageUri(uri);
                WeakReference weakReference = new WeakReference(adDfpUnified);
                WeakReference weakReference2 = new WeakReference(unifiedNativeAd);
                RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) adDfpUnified;
                int imageOperationId = adDfpUnified.getImageOperationId();
                View view = viewHolder.itemView;
                Intrinsics.checkNotNullExpressionValue(view, "view.itemView");
                Context context = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "view.itemView.context");
                dfpImageLoaderImpl.loadImage(imageOperationId, uri, context).subscribe(new a(weakReference, weakReference2, intRef), b.a);
            }
        }
        return intRef.element;
    }
}
