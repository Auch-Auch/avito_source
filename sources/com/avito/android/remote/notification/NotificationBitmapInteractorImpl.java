package com.avito.android.remote.notification;

import android.graphics.Bitmap;
import android.net.Uri;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.Image;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.Images;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.Objects;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/remote/notification/NotificationBitmapInteractorImpl;", "Lcom/avito/android/remote/notification/NotificationBitmapInteractor;", "Lcom/avito/android/remote/model/Image;", "image", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/notification/NotificationImages;", "load", "(Lcom/avito/android/remote/model/Image;)Lio/reactivex/Observable;", "", "dp", AuthSource.SEND_ABUSE, "(I)I", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/util/DeviceMetrics;", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "<init>", "(Lcom/avito/android/util/DeviceMetrics;Lcom/avito/android/util/SchedulersFactory;)V", "notification_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationBitmapInteractorImpl implements NotificationBitmapInteractor {
    public final DeviceMetrics a;
    public final SchedulersFactory b;

    public static final class a<T> implements Consumer<Disposable> {
        public final /* synthetic */ NotificationBitmapInteractorImpl a;
        public final /* synthetic */ PublishRelay b;

        public a(NotificationBitmapInteractorImpl notificationBitmapInteractorImpl, PublishRelay publishRelay) {
            this.a = notificationBitmapInteractorImpl;
            this.b = publishRelay;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) {
            NotificationBitmapInteractorImpl notificationBitmapInteractorImpl = this.a;
            PublishRelay publishRelay = this.b;
            Intrinsics.checkNotNullExpressionValue(publishRelay, "relay");
            NotificationBitmapInteractorImpl.access$sendError(notificationBitmapInteractorImpl, publishRelay);
        }
    }

    public static final class b<T> implements Consumer<Disposable> {
        public final /* synthetic */ DataSource a;
        public final /* synthetic */ NotificationBitmapInteractorImpl$load$dataSubscriber$1 b;
        public final /* synthetic */ Executor c;

        public b(DataSource dataSource, NotificationBitmapInteractorImpl$load$dataSubscriber$1 notificationBitmapInteractorImpl$load$dataSubscriber$1, Executor executor) {
            this.a = dataSource;
            this.b = notificationBitmapInteractorImpl$load$dataSubscriber$1;
            this.c = executor;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) {
            this.a.subscribe(this.b, this.c);
        }
    }

    public static final class c implements Action {
        public final /* synthetic */ DataSource a;

        public c(DataSource dataSource) {
            this.a = dataSource;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.a.close();
        }
    }

    public static final class d implements Executor {
        public final /* synthetic */ Scheduler a;

        public d(Scheduler scheduler) {
            this.a = scheduler;
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.a.scheduleDirect(runnable);
        }
    }

    public NotificationBitmapInteractorImpl(@NotNull DeviceMetrics deviceMetrics, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.a = deviceMetrics;
        this.b = schedulersFactory;
    }

    public static final int access$dpToPx(NotificationBitmapInteractorImpl notificationBitmapInteractorImpl, int i) {
        return (int) (notificationBitmapInteractorImpl.a.getDisplayScaleFactor() * ((float) i));
    }

    public static final Bitmap access$resizeBitmap(NotificationBitmapInteractorImpl notificationBitmapInteractorImpl, Bitmap bitmap, int i, int i2) {
        Objects.requireNonNull(notificationBitmapInteractorImpl);
        float width = ((float) bitmap.getWidth()) / ((float) i);
        float height = ((float) bitmap.getHeight()) / ((float) i2);
        if (width < 1.0f || height < 1.0f) {
            Bitmap copy = bitmap.copy(bitmap.getConfig(), false);
            Intrinsics.checkNotNullExpressionValue(copy, "bitmap.copy(bitmap.config, false)");
            return copy;
        }
        float min = Math.min(width, height);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) (((float) bitmap.getWidth()) / min), (int) (((float) bitmap.getHeight()) / min), false);
        Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "Bitmap.createScaledBitma…ap, width, height, false)");
        return createScaledBitmap;
    }

    public static final void access$sendError(NotificationBitmapInteractorImpl notificationBitmapInteractorImpl, Relay relay) {
        Objects.requireNonNull(notificationBitmapInteractorImpl);
        relay.accept(new LoadingState.Error(new TypedError() { // from class: com.avito.android.remote.notification.NotificationBitmapInteractorImpl$sendError$error$1
        }));
    }

    public final int a(int i) {
        return (int) (this.a.getDisplayScaleFactor() * ((float) i));
    }

    @Override // com.avito.android.remote.notification.NotificationBitmapInteractor
    @NotNull
    public Observable<LoadingState<NotificationImages>> load(@NotNull Image image) {
        Intrinsics.checkNotNullParameter(image, "image");
        PublishRelay create = PublishRelay.create();
        int a3 = a(448);
        int a4 = a(186);
        Uri width = Images.fit$default(image, Math.min(this.a.getDisplayWidth(), a3), a4, 0.0f, 0.0f, 2, 12, null).width();
        Scheduler io2 = this.b.io();
        if (width == null) {
            Observable<LoadingState<NotificationImages>> doOnSubscribe = create.subscribeOn(io2).doOnSubscribe(new a(this, create));
            Intrinsics.checkNotNullExpressionValue(doOnSubscribe, "relay.subscribeOn(schedu…ribe { sendError(relay) }");
            return doOnSubscribe;
        }
        DataSource<CloseableReference<CloseableImage>> fetchDecodedImage = Fresco.getImagePipeline().fetchDecodedImage(ImageRequest.fromUri(width), null);
        Observable<LoadingState<NotificationImages>> doOnDispose = create.subscribeOn(io2).doOnSubscribe(new b(fetchDecodedImage, new NotificationBitmapInteractorImpl$load$dataSubscriber$1(this, create, a3, a4), new d(io2))).doOnDispose(new c(fetchDecodedImage));
        Intrinsics.checkNotNullExpressionValue(doOnDispose, "relay.subscribeOn(schedu…se { dataSource.close() }");
        return doOnDispose;
    }
}
