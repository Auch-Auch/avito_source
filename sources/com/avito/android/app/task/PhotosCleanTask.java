package com.avito.android.app.task;

import android.app.Application;
import arrow.core.Option;
import com.avito.android.photo_picker.legacy.PhotoStorageCleaner;
import com.avito.android.publish.drafts.LocalDraft;
import com.avito.android.publish.drafts.PublishDraftRepository;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import io.reactivex.SingleSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/avito/android/app/task/PhotosCleanTask;", "Lcom/avito/android/app/task/ApplicationBackgroundStartupTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "", "execute", "(Landroid/app/Application;)V", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/util/SchedulersFactory;", "Lcom/avito/android/photo_picker/legacy/PhotoStorageCleaner;", "photosCleaner", "Lcom/avito/android/photo_picker/legacy/PhotoStorageCleaner;", "Lcom/avito/android/publish/drafts/PublishDraftRepository;", "draftRepository", "Lcom/avito/android/publish/drafts/PublishDraftRepository;", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/util/BuildInfo;", "<init>", "(Lcom/avito/android/publish/drafts/PublishDraftRepository;Lcom/avito/android/photo_picker/legacy/PhotoStorageCleaner;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/BuildInfo;)V", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
public final class PhotosCleanTask implements ApplicationBackgroundStartupTask {
    public final BuildInfo buildInfo;
    public final PublishDraftRepository draftRepository;
    public final PhotoStorageCleaner photosCleaner;
    public final SchedulersFactory schedulers;

    public static final class a<T, R> implements Function<Option<? extends LocalDraft>, SingleSource<? extends Unit>> {
        public final /* synthetic */ PhotosCleanTask a;

        public a(PhotosCleanTask photosCleanTask) {
            this.a = photosCleanTask;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends Unit> apply(Option<? extends LocalDraft> option) {
            Option<? extends LocalDraft> option2 = option;
            Intrinsics.checkNotNullParameter(option2, "it");
            return this.a.photosCleaner.removeUnnecessaryPhotos(option2.nonEmpty() ? ((LocalDraft) option2.get()).getDraftId() : null);
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            Logs.debug$default("PhotosCleanTask", "Publish photos cleaned on app start", null, 4, null);
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ PhotosCleanTask a;

        public c(PhotosCleanTask photosCleanTask) {
            this.a = photosCleanTask;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            Logs.error("PhotosCleanTask", "Failed to clean photos ", th2);
            if (this.a.buildInfo.isDebug()) {
                Intrinsics.checkNotNullExpressionValue(th2, "it");
                throw th2;
            }
        }
    }

    public PhotosCleanTask(@NotNull PublishDraftRepository publishDraftRepository, @NotNull PhotoStorageCleaner photoStorageCleaner, @NotNull SchedulersFactory schedulersFactory, @NotNull BuildInfo buildInfo2) {
        Intrinsics.checkNotNullParameter(publishDraftRepository, "draftRepository");
        Intrinsics.checkNotNullParameter(photoStorageCleaner, "photosCleaner");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(buildInfo2, "buildInfo");
        this.draftRepository = publishDraftRepository;
        this.photosCleaner = photoStorageCleaner;
        this.schedulers = schedulersFactory;
        this.buildInfo = buildInfo2;
    }

    @Override // com.avito.android.app.task.ApplicationBackgroundStartupTask
    public void execute(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        this.draftRepository.getDraft().flatMap(new a(this)).subscribeOn(this.schedulers.io()).subscribe(b.a, new c(this));
    }
}
