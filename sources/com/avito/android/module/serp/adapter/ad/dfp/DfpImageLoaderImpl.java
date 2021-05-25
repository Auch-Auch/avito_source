package com.avito.android.module.serp.adapter.ad.dfp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.collection.LruCache;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.concurrent.RxExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.share.internal.ShareConstants;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u00010B\u000f\u0012\u0006\u0010-\u001a\u00020*¢\u0006\u0004\b.\u0010/J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R(\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00150\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bRJ\u0010$\u001a6\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e0\u001dj\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e`!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010)\u001a\u00020\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0004\"\u0004\b(\u0010\u0013R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u00061"}, d2 = {"Lcom/avito/android/module/serp/adapter/ad/dfp/DfpImageLoaderImpl;", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpImageLoader;", "", "createLoadOperationId", "()I", "newOperationId", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Landroid/content/Context;", "context", "Lio/reactivex/rxjava3/core/Single;", "Landroid/graphics/drawable/Drawable;", "loadImage", "(ILandroid/net/Uri;Landroid/content/Context;)Lio/reactivex/rxjava3/core/Single;", "takeImageFromCache", "(Landroid/net/Uri;)Landroid/graphics/drawable/Drawable;", "anOperationId", "", "cancel", "(I)V", "Landroidx/collection/LruCache;", "Ljava/lang/ref/WeakReference;", "d", "Landroidx/collection/LruCache;", "imageRefMemCache", "Lcom/avito/android/util/rx3/concurrent/RxExecutor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/rx3/concurrent/RxExecutor;", "rxExecutor", "Ljava/util/HashMap;", "Lcom/facebook/datasource/DataSource;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "imageSources", AuthSource.BOOKING_ORDER, "I", "getLastOperationId", "setLastOperationId", "lastOperationId", "Lcom/avito/android/util/SchedulersFactory3;", "e", "Lcom/avito/android/util/SchedulersFactory3;", "scheduler", "<init>", "(Lcom/avito/android/util/SchedulersFactory3;)V", "ImageLoadException", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class DfpImageLoaderImpl implements DfpImageLoader {
    public RxExecutor a;
    public int b;
    public HashMap<Integer, DataSource<CloseableReference<CloseableImage>>> c = new HashMap<>();
    public LruCache<Uri, WeakReference<Drawable>> d = new LruCache<>(4);
    public final SchedulersFactory3 e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0006\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/module/serp/adapter/ad/dfp/DfpImageLoaderImpl$ImageLoadException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "", AuthSource.SEND_ABUSE, "Z", "isCancelled", "()Z", "<init>", "(Z)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class ImageLoadException extends RuntimeException {
        public final boolean a;

        public ImageLoadException(boolean z) {
            this.a = z;
        }

        public final boolean isCancelled() {
            return this.a;
        }
    }

    public static final class a<T> implements Consumer<Drawable> {
        public final /* synthetic */ DfpImageLoaderImpl a;
        public final /* synthetic */ Uri b;

        public a(DfpImageLoaderImpl dfpImageLoaderImpl, Uri uri) {
            this.a = dfpImageLoaderImpl;
            this.b = uri;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Drawable drawable) {
            this.a.d.put(this.b, new WeakReference(drawable));
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ DfpImageLoaderImpl a;
        public final /* synthetic */ int b;

        public b(DfpImageLoaderImpl dfpImageLoaderImpl, int i) {
            this.a = dfpImageLoaderImpl;
            this.b = i;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            DfpImageLoaderImpl.access$removeImageSource(this.a, this.b);
        }
    }

    public DfpImageLoaderImpl(@NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "scheduler");
        this.e = schedulersFactory3;
        this.a = new RxExecutor(schedulersFactory3.computation());
    }

    public static final void access$removeImageSource(DfpImageLoaderImpl dfpImageLoaderImpl, int i) {
        DataSource<CloseableReference<CloseableImage>> dataSource = dfpImageLoaderImpl.c.get(Integer.valueOf(i));
        if (dataSource != null) {
            dataSource.close();
        }
        dfpImageLoaderImpl.c.remove(Integer.valueOf(i));
    }

    @Override // com.avito.android.module.serp.adapter.ad.dfp.DfpImageLoader
    public void cancel(int i) {
        DataSource<CloseableReference<CloseableImage>> dataSource;
        if (this.c.containsKey(Integer.valueOf(i)) && (dataSource = this.c.get(Integer.valueOf(i))) != null) {
            dataSource.close();
        }
    }

    @Override // com.avito.android.module.serp.adapter.ad.dfp.DfpImageLoader
    public int createLoadOperationId() {
        setLastOperationId(getLastOperationId() + 1);
        return getLastOperationId();
    }

    @Override // com.avito.android.module.serp.adapter.ad.dfp.DfpImageLoader
    public int getLastOperationId() {
        return this.b;
    }

    @Override // com.avito.android.module.serp.adapter.ad.dfp.DfpImageLoader
    @NotNull
    public Single<Drawable> loadImage(int i, @NotNull Uri uri, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Intrinsics.checkNotNullParameter(context, "context");
        Single<Drawable> doFinally = Single.create(new DfpImageLoaderImpl$loadImage$1(this, uri, context, i)).observeOn(this.e.mainThread()).doOnSuccess(new a(this, uri)).doFinally(new b(this, i));
        Intrinsics.checkNotNullExpressionValue(doFinally, "Single.create<Drawable> …perationId)\n            }");
        return doFinally;
    }

    @Override // com.avito.android.module.serp.adapter.ad.dfp.DfpImageLoader
    public void setLastOperationId(int i) {
        this.b = i;
    }

    @Override // com.avito.android.module.serp.adapter.ad.dfp.DfpImageLoader
    @Nullable
    public Drawable takeImageFromCache(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        WeakReference<Drawable> weakReference = this.d.get(uri);
        Drawable drawable = weakReference != null ? weakReference.get() : null;
        if (drawable != null) {
            return drawable;
        }
        return null;
    }
}
