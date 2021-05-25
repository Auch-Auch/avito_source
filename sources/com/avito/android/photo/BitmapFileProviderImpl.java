package com.avito.android.photo;

import android.content.Context;
import android.net.Uri;
import com.avito.android.analytics.Analytics;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.PrivatePhotosStorage;
import com.facebook.share.internal.ShareConstants;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/photo/BitmapFileProviderImpl;", "Lcom/avito/android/photo/BitmapFileProvider;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Lcom/avito/android/photo/ImageConvertOptions;", "convertOptions", "Lio/reactivex/Observable;", "Lcom/avito/android/photo/BitmapConversionResult;", "getConvertedFileForUri", "(Landroid/net/Uri;Lcom/avito/android/photo/ImageConvertOptions;)Lio/reactivex/Observable;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/PrivatePhotosStorage;", "c", "Lcom/avito/android/util/PrivatePhotosStorage;", "privatePhotosStorage", "<init>", "(Landroid/content/Context;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/PrivatePhotosStorage;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class BitmapFileProviderImpl implements BitmapFileProvider {
    public final Context a;
    public final Analytics b;
    public final PrivatePhotosStorage c;

    public static final class a<T> implements ObservableOnSubscribe<BitmapConversionResult> {
        public final /* synthetic */ BitmapFileProviderImpl a;
        public final /* synthetic */ Uri b;
        public final /* synthetic */ ImageConvertOptions c;

        public a(BitmapFileProviderImpl bitmapFileProviderImpl, Uri uri, ImageConvertOptions imageConvertOptions) {
            this.a = bitmapFileProviderImpl;
            this.b = uri;
            this.c = imageConvertOptions;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(@NotNull ObservableEmitter<BitmapConversionResult> observableEmitter) {
            Intrinsics.checkNotNullParameter(observableEmitter, "subscriber");
            try {
                BitmapConversionResult convert = new BitmapConverter(this.a.a, this.b, this.c, this.a.b, this.a.c).convert();
                if (convert == null) {
                    observableEmitter.onError(new IOException());
                    return;
                }
                observableEmitter.onNext(convert);
                observableEmitter.onComplete();
            } catch (Exception e) {
                observableEmitter.onError(e);
            }
        }
    }

    public BitmapFileProviderImpl(@NotNull Context context, @NotNull Analytics analytics, @NotNull PrivatePhotosStorage privatePhotosStorage) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(privatePhotosStorage, "privatePhotosStorage");
        this.a = context;
        this.b = analytics;
        this.c = privatePhotosStorage;
    }

    @Override // com.avito.android.photo.BitmapFileProvider
    @NotNull
    public Observable<BitmapConversionResult> getConvertedFileForUri(@NotNull Uri uri, @NotNull ImageConvertOptions imageConvertOptions) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Intrinsics.checkNotNullParameter(imageConvertOptions, "convertOptions");
        Observable<BitmapConversionResult> create = Observable.create(new a(this, uri, imageConvertOptions));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { subs…)\n            }\n        }");
        return create;
    }
}
