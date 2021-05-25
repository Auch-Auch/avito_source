package com.avito.android.remote.notification;

import android.graphics.Bitmap;
import com.avito.android.util.LoadingState;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.jakewharton.rxrelay2.PublishRelay;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/avito/android/remote/notification/NotificationBitmapInteractorImpl$load$dataSubscriber$1", "Lcom/facebook/imagepipeline/datasource/BaseBitmapDataSubscriber;", "Lcom/facebook/datasource/DataSource;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "dataSource", "", "onFailureImpl", "(Lcom/facebook/datasource/DataSource;)V", "Landroid/graphics/Bitmap;", "bitmap", "onNewResultImpl", "(Landroid/graphics/Bitmap;)V", "notification_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationBitmapInteractorImpl$load$dataSubscriber$1 extends BaseBitmapDataSubscriber {
    public final /* synthetic */ NotificationBitmapInteractorImpl a;
    public final /* synthetic */ PublishRelay b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public NotificationBitmapInteractorImpl$load$dataSubscriber$1(NotificationBitmapInteractorImpl notificationBitmapInteractorImpl, PublishRelay publishRelay, int i, int i2) {
        this.a = notificationBitmapInteractorImpl;
        this.b = publishRelay;
        this.c = i;
        this.d = i2;
    }

    @Override // com.facebook.datasource.BaseDataSubscriber
    public void onFailureImpl(@NotNull DataSource<CloseableReference<CloseableImage>> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        NotificationBitmapInteractorImpl notificationBitmapInteractorImpl = this.a;
        PublishRelay publishRelay = this.b;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "relay");
        NotificationBitmapInteractorImpl.access$sendError(notificationBitmapInteractorImpl, publishRelay);
    }

    @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
    public void onNewResultImpl(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            NotificationBitmapInteractorImpl notificationBitmapInteractorImpl = this.a;
            PublishRelay publishRelay = this.b;
            Intrinsics.checkNotNullExpressionValue(publishRelay, "relay");
            NotificationBitmapInteractorImpl.access$sendError(notificationBitmapInteractorImpl, publishRelay);
            return;
        }
        Bitmap access$resizeBitmap = NotificationBitmapInteractorImpl.access$resizeBitmap(this.a, bitmap, this.c, this.d);
        int access$dpToPx = NotificationBitmapInteractorImpl.access$dpToPx(this.a, 64);
        this.b.accept(new LoadingState.Loaded(new NotificationImages(access$resizeBitmap, NotificationBitmapInteractorImpl.access$resizeBitmap(this.a, bitmap, access$dpToPx, access$dpToPx))));
    }
}
