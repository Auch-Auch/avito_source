package com.avito.android.notification_center.landing.share;

import android.content.Context;
import android.net.Uri;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001:\u0001\tJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/notification_center/landing/share/ShareImageInteractor;", "", "", "url", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Landroid/net/Uri;", "load", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Impl", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public interface ShareImageInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/notification_center/landing/share/ShareImageInteractor$Impl;", "Lcom/avito/android/notification_center/landing/share/ShareImageInteractor;", "", "url", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Landroid/net/Uri;", "load", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Landroid/content/Context;", AuthSource.BOOKING_ORDER, "Landroid/content/Context;", "context", "Lio/reactivex/Scheduler;", AuthSource.SEND_ABUSE, "Lio/reactivex/Scheduler;", "scheduler", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "<init>", "(Landroid/content/Context;Lcom/avito/android/util/SchedulersFactory;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements ShareImageInteractor {
        public final Scheduler a;
        public final Context b;

        public static final class a<T> implements Consumer<Disposable> {
            public final /* synthetic */ DataSource a;
            public final /* synthetic */ DataSubscriber b;
            public final /* synthetic */ Executor c;

            public a(DataSource dataSource, DataSubscriber dataSubscriber, Executor executor) {
                this.a = dataSource;
                this.b = dataSubscriber;
                this.c = executor;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public void accept(Disposable disposable) {
                this.a.subscribe(this.b, this.c);
            }
        }

        public static final class b implements Action {
            public final /* synthetic */ DataSource a;

            public b(DataSource dataSource) {
                this.a = dataSource;
            }

            @Override // io.reactivex.functions.Action
            public final void run() {
                this.a.close();
            }
        }

        public static final class c implements Executor {
            public final /* synthetic */ Impl a;

            public c(Impl impl) {
                this.a = impl;
            }

            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                this.a.a.scheduleDirect(runnable);
            }
        }

        public Impl(@NotNull Context context, @NotNull SchedulersFactory schedulersFactory) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
            this.b = context;
            this.a = schedulersFactory.io();
        }

        @Override // com.avito.android.notification_center.landing.share.ShareImageInteractor
        @NotNull
        public Observable<LoadingState<Uri>> load(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            PublishRelay create = PublishRelay.create();
            DataSource<CloseableReference<CloseableImage>> fetchDecodedImage = Fresco.getImagePipeline().fetchDecodedImage(ImageRequest.fromUri(str), null);
            Intrinsics.checkNotNullExpressionValue(fetchDecodedImage, "imagePipeline.fetchDecod…Image(imageRequest, null)");
            Intrinsics.checkNotNullExpressionValue(create, "relay");
            Observable<LoadingState<Uri>> doOnDispose = create.subscribeOn(this.a).doOnSubscribe(new a(fetchDecodedImage, new ShareImageInteractor$Impl$getDataSubscriber$1(this, create), new c(this))).doOnDispose(new b(fetchDecodedImage));
            Intrinsics.checkNotNullExpressionValue(doOnDispose, "relay\n                .s…se { dataSource.close() }");
            return doOnDispose;
        }
    }

    @NotNull
    Observable<LoadingState<Uri>> load(@NotNull String str);
}
