package com.avito.android.notification_center.landing.share;

import android.net.Uri;
import com.avito.android.notification_center.landing.share.ShareImageInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedError;
import com.avito.android.util.LoadingState;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0011\u001a\u00020\u00062\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"com/avito/android/notification_center/landing/share/ShareImageInteractor$Impl$getDataSubscriber$1", "Lcom/facebook/imagepipeline/datasource/BaseBitmapDataSubscriber;", "Lcom/facebook/datasource/DataSource;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "dataSource", "", "onFailureImpl", "(Lcom/facebook/datasource/DataSource;)V", "Landroid/graphics/Bitmap;", "bitmap", "onNewResultImpl", "(Landroid/graphics/Bitmap;)V", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/util/LoadingState;", "Landroid/net/Uri;", "consumer", AuthSource.SEND_ABUSE, "(Lio/reactivex/functions/Consumer;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class ShareImageInteractor$Impl$getDataSubscriber$1 extends BaseBitmapDataSubscriber {
    public final /* synthetic */ ShareImageInteractor.Impl a;
    public final /* synthetic */ Consumer b;

    public ShareImageInteractor$Impl$getDataSubscriber$1(ShareImageInteractor.Impl impl, Consumer consumer) {
        this.a = impl;
        this.b = consumer;
    }

    public final void a(Consumer<LoadingState<Uri>> consumer) {
        consumer.accept(new LoadingState.Error(new TypedError() { // from class: com.avito.android.notification_center.landing.share.ShareImageInteractor$Impl$getDataSubscriber$1$sendError$error$1
        }));
    }

    @Override // com.facebook.datasource.BaseDataSubscriber
    public void onFailureImpl(@NotNull DataSource<CloseableReference<CloseableImage>> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        a(this.b);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        throw r3;
     */
    @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onNewResultImpl(@org.jetbrains.annotations.Nullable android.graphics.Bitmap r6) {
        /*
            r5 = this;
            if (r6 == 0) goto L_0x0051
            com.avito.android.notification_center.landing.share.ShareImageInteractor$Impl r0 = r5.a
            android.content.Context r0 = com.avito.android.notification_center.landing.share.ShareImageInteractor.Impl.access$getContext$p(r0)
            java.io.File r0 = r0.getCacheDir()
            java.lang.String r1 = "image"
            java.lang.String r2 = ".jpg"
            java.io.File r0 = t6.q.e.createTempFile(r1, r2, r0)
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x002c }
            r2.<init>(r0)     // Catch:{ all -> 0x002c }
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ all -> 0x0025 }
            r4 = 95
            r6.compress(r3, r4, r2)     // Catch:{ all -> 0x0025 }
            kotlin.io.CloseableKt.closeFinally(r2, r1)
            goto L_0x0034
        L_0x0025:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0027 }
        L_0x0027:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r6)
            throw r3
        L_0x002c:
            r6 = move-exception
            com.avito.android.util.Logs.error(r6)
            r0.delete()
            r0 = r1
        L_0x0034:
            if (r0 == 0) goto L_0x004b
            com.avito.android.notification_center.landing.share.ShareImageInteractor$Impl r6 = r5.a
            android.content.Context r6 = com.avito.android.notification_center.landing.share.ShareImageInteractor.Impl.access$getContext$p(r6)
            android.net.Uri r6 = com.avito.android.util.FileProvidersKt.getUriForFile(r6, r0)
            io.reactivex.functions.Consumer r0 = r5.b
            com.avito.android.util.LoadingState$Loaded r1 = new com.avito.android.util.LoadingState$Loaded
            r1.<init>(r6)
            r0.accept(r1)
            return
        L_0x004b:
            io.reactivex.functions.Consumer r6 = r5.b
            r5.a(r6)
            return
        L_0x0051:
            io.reactivex.functions.Consumer r6 = r5.b
            r5.a(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.notification_center.landing.share.ShareImageInteractor$Impl$getDataSubscriber$1.onNewResultImpl(android.graphics.Bitmap):void");
    }
}
