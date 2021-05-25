package com.avito.android.module.serp.adapter.ad.dfp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.avito.android.module.serp.adapter.ad.dfp.DfpImageLoaderImpl;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class DfpImageLoaderImpl$loadImage$1<T> implements SingleOnSubscribe<Drawable> {
    public final /* synthetic */ DfpImageLoaderImpl a;
    public final /* synthetic */ Uri b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ int d;

    public DfpImageLoaderImpl$loadImage$1(DfpImageLoaderImpl dfpImageLoaderImpl, Uri uri, Context context, int i) {
        this.a = dfpImageLoaderImpl;
        this.b = uri;
        this.c = context;
        this.d = i;
    }

    @Override // io.reactivex.rxjava3.core.SingleOnSubscribe
    public final void subscribe(final SingleEmitter<Drawable> singleEmitter) {
        DataSource<CloseableReference<CloseableImage>> fetchDecodedImage = Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(this.b).build(), this.c);
        HashMap hashMap = this.a.c;
        Integer valueOf = Integer.valueOf(this.d);
        Intrinsics.checkNotNullExpressionValue(fetchDecodedImage, "imageSource");
        hashMap.put(valueOf, fetchDecodedImage);
        fetchDecodedImage.subscribe(new BaseBitmapDataSubscriber(this) { // from class: com.avito.android.module.serp.adapter.ad.dfp.DfpImageLoaderImpl$loadImage$1.1
            public final /* synthetic */ DfpImageLoaderImpl$loadImage$1 a;

            {
                this.a = r1;
            }

            @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
            public void onCancellation(@NotNull DataSource<CloseableReference<CloseableImage>> dataSource) {
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                singleEmitter.onError(new DfpImageLoaderImpl.ImageLoadException(true));
            }

            @Override // com.facebook.datasource.BaseDataSubscriber
            public void onFailureImpl(@NotNull DataSource<CloseableReference<CloseableImage>> dataSource) {
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                singleEmitter.onError(new DfpImageLoaderImpl.ImageLoadException(false));
            }

            /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: io.reactivex.rxjava3.core.SingleEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
            public void onNewResultImpl(@Nullable Bitmap bitmap) {
                if (bitmap != null) {
                    singleEmitter.onSuccess(new BitmapDrawable(this.a.c.getResources(), bitmap.copy(bitmap.getConfig(), false)));
                }
            }
        }, this.a.a);
    }
}
