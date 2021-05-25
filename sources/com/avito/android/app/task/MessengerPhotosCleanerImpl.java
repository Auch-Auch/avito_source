package com.avito.android.app.task;

import android.net.Uri;
import com.avito.android.messenger.conversation.mvi.send.MessengerPhotoStorage;
import com.avito.android.photo_picker.PhotoUpload;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CloseableDataSource;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.CloseableDatasourcesKt;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/app/task/MessengerPhotosCleanerImpl;", "Lcom/avito/android/app/task/MessengerPhotosCleaner;", "", "deleteOldPhotos", "()V", "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "c", "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "photoInteractor", "Lcom/avito/android/server_time/TimeSource;", AuthSource.SEND_ABUSE, "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/messenger/conversation/mvi/send/MessengerPhotoStorage;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/mvi/send/MessengerPhotoStorage;", "photoStorage", "<init>", "(Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/messenger/conversation/mvi/send/MessengerPhotoStorage;Lcom/avito/android/photo_picker/legacy/PhotoInteractor;Lcom/avito/android/util/SchedulersFactory;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessengerPhotosCleanerImpl implements MessengerPhotosCleaner {
    public final TimeSource a;
    public final MessengerPhotoStorage b;
    public final PhotoInteractor c;
    public final SchedulersFactory d;

    public static final class a<T, R> implements Function<CloseableDataSource<? extends PhotoUpload>, List<? extends PhotoUpload>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends PhotoUpload> apply(CloseableDataSource<? extends PhotoUpload> closeableDataSource) {
            CloseableDataSource<? extends PhotoUpload> closeableDataSource2 = closeableDataSource;
            Intrinsics.checkNotNullParameter(closeableDataSource2, "it");
            return CloseableDatasourcesKt.readAllAndClose(closeableDataSource2);
        }
    }

    public static final class b<T> implements Consumer<List<? extends PhotoUpload>> {
        public final /* synthetic */ MessengerPhotosCleanerImpl a;

        public b(MessengerPhotosCleanerImpl messengerPhotosCleanerImpl) {
            this.a = messengerPhotosCleanerImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(List<? extends PhotoUpload> list) {
            List<? extends PhotoUpload> list2 = list;
            MessengerPhotosCleanerImpl.access$deleteExpiredFiles(this.a);
            MessengerPhotosCleanerImpl messengerPhotosCleanerImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(list2, "photoUploads");
            MessengerPhotosCleanerImpl.access$deleteInvalidUploads(messengerPhotosCleanerImpl, list2);
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("MessengerPhotosCleaner", "Failed to clear photo storage", th);
        }
    }

    @Inject
    public MessengerPhotosCleanerImpl(@NotNull TimeSource timeSource, @NotNull MessengerPhotoStorage messengerPhotoStorage, @NotNull PhotoInteractor photoInteractor, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(messengerPhotoStorage, "photoStorage");
        Intrinsics.checkNotNullParameter(photoInteractor, "photoInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.a = timeSource;
        this.b = messengerPhotoStorage;
        this.c = photoInteractor;
        this.d = schedulersFactory;
    }

    public static final void access$deleteExpiredFiles(MessengerPhotosCleanerImpl messengerPhotosCleanerImpl) {
        messengerPhotosCleanerImpl.b.deleteFilesModifiedBefore(messengerPhotosCleanerImpl.a.now() - TimeUnit.DAYS.toMillis(29));
    }

    public static final void access$deleteInvalidUploads(MessengerPhotosCleanerImpl messengerPhotosCleanerImpl, List list) {
        Objects.requireNonNull(messengerPhotosCleanerImpl);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            PhotoUpload photoUpload = (PhotoUpload) it.next();
            Uri contentUri = photoUpload.getContentUri();
            if (contentUri == null || !messengerPhotosCleanerImpl.b.exists(contentUri)) {
                boolean delete = messengerPhotosCleanerImpl.c.delete(String.valueOf(photoUpload.getId()));
                Logs.verbose$default("MessengerPhotosCleaner", "Deleted invalid upload (" + delete + "): " + photoUpload.getContentUri(), null, 4, null);
            }
        }
    }

    @Override // com.avito.android.app.task.MessengerPhotosCleaner
    public void deleteOldPhotos() {
        this.c.selectUploadsOfType("messenger").observeOn(this.d.io()).map(a.a).first((R) CollectionsKt__CollectionsKt.emptyList()).subscribeOn(this.d.io()).subscribe(new b(this), c.a);
    }
}
