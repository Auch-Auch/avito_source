package com.avito.android.messenger.conversation.mvi.file_upload;

import a2.a.a.o1.d.a0.f.b;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelper;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Logs;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Lazy;
import io.reactivex.rxjava3.core.Completable;
import java.util.Objects;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.UploadServiceConfig;
import net.gotev.uploadservice.data.RetryPolicyConfig;
import net.gotev.uploadservice.okhttp.OkHttpStack;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B7\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInitializerImpl;", "Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInitializer;", "Lio/reactivex/rxjava3/core/Completable;", "initIfNeeded", "()Lio/reactivex/rxjava3/core/Completable;", "Lcom/avito/android/messenger/conversation/mvi/file_upload/UploadStatusUpdatesHandler;", "e", "Lcom/avito/android/messenger/conversation/mvi/file_upload/UploadStatusUpdatesHandler;", "uploadStatusUpdatesHandler", "Landroid/app/Application;", AuthSource.BOOKING_ORDER, "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "", AuthSource.SEND_ABUSE, "Z", "isInitialized", "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelper;", "f", "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelper;", "storageHelper", "Lcom/avito/android/util/BuildInfo;", "d", "Lcom/avito/android/util/BuildInfo;", "build", "Ldagger/Lazy;", "Lokhttp3/OkHttpClient;", "c", "Ldagger/Lazy;", "client", "<init>", "(Landroid/app/Application;Ldagger/Lazy;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/messenger/conversation/mvi/file_upload/UploadStatusUpdatesHandler;Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelper;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class FileUploadInitializerImpl implements FileUploadInitializer {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public boolean a;
    public final Application b;
    public final Lazy<OkHttpClient> c;
    public final BuildInfo d;
    public final UploadStatusUpdatesHandler e;
    public final FileStorageHelper f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInitializerImpl$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a<V> implements Callable<Object> {
        public final /* synthetic */ FileUploadInitializerImpl a;

        public a(FileUploadInitializerImpl fileUploadInitializerImpl) {
            this.a = fileUploadInitializerImpl;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            Unit unit;
            synchronized (this.a) {
                if (!this.a.a) {
                    FileUploadInitializerImpl.access$initializationBlock(this.a);
                    this.a.a = true;
                }
                unit = Unit.INSTANCE;
            }
            return unit;
        }
    }

    @Inject
    public FileUploadInitializerImpl(@NotNull Application application, @NotNull Lazy<OkHttpClient> lazy, @NotNull BuildInfo buildInfo, @NotNull UploadStatusUpdatesHandler uploadStatusUpdatesHandler, @NotNull FileStorageHelper fileStorageHelper) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(lazy, "client");
        Intrinsics.checkNotNullParameter(buildInfo, "build");
        Intrinsics.checkNotNullParameter(uploadStatusUpdatesHandler, "uploadStatusUpdatesHandler");
        Intrinsics.checkNotNullParameter(fileStorageHelper, "storageHelper");
        this.b = application;
        this.c = lazy;
        this.d = buildInfo;
        this.e = uploadStatusUpdatesHandler;
        this.f = fileStorageHelper;
    }

    public static final void access$initializationBlock(FileUploadInitializerImpl fileUploadInitializerImpl) {
        Objects.requireNonNull(fileUploadInitializerImpl);
        Logs.debug$default("FileUploadInitializerImpl", "File upload initialization started", null, 4, null);
        if (Build.VERSION.SDK_INT >= 26) {
            Object systemService = fileUploadInitializerImpl.b.getSystemService("notification");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            ((NotificationManager) systemService).createNotificationChannel(new NotificationChannel(fileUploadInitializerImpl.b.getString(R.string.messenger_file_upload_notification_channel_id), fileUploadInitializerImpl.b.getString(R.string.messenger_file_upload_notification_channel_name), 2));
            Logs.debug$default("FileUploadInitializerImpl", "Created notification channel", null, 4, null);
        }
        Application application = fileUploadInitializerImpl.b;
        String string = application.getString(R.string.messenger_file_upload_notification_channel_id);
        Intrinsics.checkNotNullExpressionValue(string, "application.getString(R.…_notification_channel_id)");
        UploadServiceConfig.initialize(application, string, fileUploadInitializerImpl.d.isDebug());
        OkHttpClient okHttpClient = fileUploadInitializerImpl.c.get();
        Intrinsics.checkNotNullExpressionValue(okHttpClient, "client.get()");
        UploadServiceConfig.setHttpStack(new OkHttpStack(okHttpClient));
        UploadServiceConfig.setRetryPolicy(new RetryPolicyConfig(0, 0, 0, 0));
        Logs.debug$default("FileUploadInitializerImpl", "Upload service library initialized", null, 4, null);
        fileUploadInitializerImpl.e.subscribeToUploadUpdates();
        Logs.debug$default("FileUploadInitializerImpl", "Subscribed to upload updates", null, 4, null);
        fileUploadInitializerImpl.f.clearInternalUploadCacheDir().doAfterSuccess(a2.a.a.o1.d.a0.f.a.a).onErrorResumeNext(b.a).blockingGet();
        Logs.debug$default("FileUploadInitializerImpl", "File upload initialization successfully finished", null, 4, null);
    }

    @Override // com.avito.android.messenger.conversation.mvi.file_upload.FileUploadInitializer
    @NotNull
    public Completable initIfNeeded() {
        Completable fromCallable = Completable.fromCallable(new a(this));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…}\n            }\n        }");
        return fromCallable;
    }
}
