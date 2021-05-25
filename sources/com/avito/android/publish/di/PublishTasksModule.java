package com.avito.android.publish.di;

import android.app.Application;
import android.content.ContentResolver;
import android.os.Looper;
import com.avito.android.TypedLazy;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.app.task.ApplicationBackgroundStartupTask;
import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.CacheWarmUpTask;
import com.avito.android.app.task.PhotosCleanTask;
import com.avito.android.app.task.PublishDraftsCleanupTask;
import com.avito.android.app.task.PublishDraftsSyncTask;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.photo_picker.legacy.PhotoInteractorImpl;
import com.avito.android.photo_picker.legacy.PhotoStorageCleaner;
import com.avito.android.photo_picker.legacy.UploadingProgressInteractorImpl;
import com.avito.android.publish.drafts.PublishDraftRepository;
import com.avito.android.publish.drafts.PublishDraftWiper;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.floating_add_advert.AddAdvertInteractor;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b.\u0010/J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007JG\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f0\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\bH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0007¢\u0006\u0004\b\u001f\u0010 J/\u0010&\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001dH\u0007¢\u0006\u0004\b&\u0010'J7\u0010,\u001a\u00020\r2\u0006\u0010)\u001a\u00020(2\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020*H\u0007¢\u0006\u0004\b,\u0010-¨\u00060"}, d2 = {"Lcom/avito/android/publish/di/PublishTasksModule;", "", "Lcom/avito/android/app/task/CacheWarmUpTask;", "cacheWarmUpTask", "", "Lcom/avito/android/app/task/ApplicationBlockingStartupTask;", "provideBlockingTasks", "(Lcom/avito/android/app/task/CacheWarmUpTask;)Ljava/util/List;", "Ldagger/Lazy;", "Lcom/avito/android/app/task/PublishDraftsCleanupTask;", "publishDraftsCleanupTask", "Lcom/avito/android/app/task/PhotosCleanTask;", "photosCleanTask", "Lcom/avito/android/app/task/PublishDraftsSyncTask;", "publishDraftsSyncTask", "Lcom/avito/android/TypedLazy;", "Lcom/avito/android/app/task/ApplicationBackgroundStartupTask;", "provideBackgroundTasks", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)Ljava/util/List;", "Lru/avito/component/floating_add_advert/AddAdvertInteractor;", "newAdvertInteractor", "provideCacheWarmUpTask", "(Lru/avito/component/floating_add_advert/AddAdvertInteractor;)Lcom/avito/android/app/task/CacheWarmUpTask;", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/publish/drafts/PublishDraftWiper;", "publishDraftWiper", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/util/BuildInfo;", "build", "providePublishDraftsCleanupTask", "(Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/publish/drafts/PublishDraftWiper;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/BuildInfo;)Lcom/avito/android/app/task/PublishDraftsCleanupTask;", "Lcom/avito/android/publish/drafts/PublishDraftRepository;", "draftRepository", "Lcom/avito/android/photo_picker/legacy/PhotoStorageCleaner;", "photosCleaner", "buildInfo", "providePhotosCleanTask", "(Lcom/avito/android/publish/drafts/PublishDraftRepository;Lcom/avito/android/photo_picker/legacy/PhotoStorageCleaner;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/BuildInfo;)Lcom/avito/android/app/task/PhotosCleanTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "providePublishDraftsSaveTask", "(Landroid/app/Application;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/publish/drafts/PublishDraftRepository;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;)Lcom/avito/android/app/task/PublishDraftsSyncTask;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class PublishTasksModule {
    @NotNull
    public static final PublishTasksModule INSTANCE = new PublishTasksModule();

    public static final class a extends Lambda implements Function1<String, UploadingProgressInteractorImpl> {
        public final /* synthetic */ Application a;
        public final /* synthetic */ BuildInfo b;
        public final /* synthetic */ SchedulersFactory c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Application application, BuildInfo buildInfo, SchedulersFactory schedulersFactory) {
            super(1);
            this.a = application;
            this.b = buildInfo;
            this.c = schedulersFactory;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public UploadingProgressInteractorImpl invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "draftId");
            Looper mainLooper = this.a.getMainLooper();
            Intrinsics.checkNotNullExpressionValue(mainLooper, "application.mainLooper");
            BuildInfo buildInfo = this.b;
            ContentResolver contentResolver = this.a.getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver, "application.contentResolver");
            return new UploadingProgressInteractorImpl(str2, new PhotoInteractorImpl(mainLooper, buildInfo, contentResolver, null, 8, null), this.c);
        }
    }

    @Provides
    @NotNull
    @PublishTasks
    public final List<TypedLazy<? extends ApplicationBackgroundStartupTask>> provideBackgroundTasks(@NotNull Lazy<PublishDraftsCleanupTask> lazy, @NotNull Lazy<PhotosCleanTask> lazy2, @NotNull Lazy<PublishDraftsSyncTask> lazy3) {
        Intrinsics.checkNotNullParameter(lazy, "publishDraftsCleanupTask");
        Intrinsics.checkNotNullParameter(lazy2, "photosCleanTask");
        Intrinsics.checkNotNullParameter(lazy3, "publishDraftsSyncTask");
        return CollectionsKt__CollectionsKt.listOf((Object[]) new TypedLazy[]{new TypedLazy(PublishDraftsCleanupTask.class, lazy), new TypedLazy(PhotosCleanTask.class, lazy2), new TypedLazy(PublishDraftsSyncTask.class, lazy3)});
    }

    @Provides
    @NotNull
    @PublishTasks
    public final List<ApplicationBlockingStartupTask> provideBlockingTasks(@NotNull CacheWarmUpTask cacheWarmUpTask) {
        Intrinsics.checkNotNullParameter(cacheWarmUpTask, "cacheWarmUpTask");
        return d.listOf(cacheWarmUpTask);
    }

    @Provides
    @NotNull
    public final CacheWarmUpTask provideCacheWarmUpTask(@NotNull AddAdvertInteractor addAdvertInteractor) {
        Intrinsics.checkNotNullParameter(addAdvertInteractor, "newAdvertInteractor");
        return new CacheWarmUpTask(addAdvertInteractor);
    }

    @Provides
    @NotNull
    public final PhotosCleanTask providePhotosCleanTask(@NotNull PublishDraftRepository publishDraftRepository, @NotNull PhotoStorageCleaner photoStorageCleaner, @NotNull SchedulersFactory schedulersFactory, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(publishDraftRepository, "draftRepository");
        Intrinsics.checkNotNullParameter(photoStorageCleaner, "photosCleaner");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        return new PhotosCleanTask(publishDraftRepository, photoStorageCleaner, schedulersFactory, buildInfo);
    }

    @Provides
    @NotNull
    public final PublishDraftsCleanupTask providePublishDraftsCleanupTask(@NotNull AccountStateProvider accountStateProvider, @NotNull PublishDraftWiper publishDraftWiper, @NotNull SchedulersFactory schedulersFactory, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(publishDraftWiper, "publishDraftWiper");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(buildInfo, "build");
        return new PublishDraftsCleanupTask(accountStateProvider, publishDraftWiper, schedulersFactory, buildInfo);
    }

    @Provides
    @NotNull
    public final PublishDraftsSyncTask providePublishDraftsSaveTask(@NotNull Application application, @NotNull BuildInfo buildInfo, @NotNull PublishDraftRepository publishDraftRepository, @NotNull SchedulersFactory schedulersFactory, @NotNull ConnectivityProvider connectivityProvider) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(publishDraftRepository, "draftRepository");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(connectivityProvider, "connectivityProvider");
        return new PublishDraftsSyncTask(publishDraftRepository, schedulersFactory, connectivityProvider, new a(application, buildInfo, schedulersFactory));
    }
}
