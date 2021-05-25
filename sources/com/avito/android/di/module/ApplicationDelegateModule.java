package com.avito.android.di.module;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.res.Resources;
import com.avito.android.MessengerTasksModule;
import com.avito.android.TypedLazy;
import com.avito.android.account.AccountStorageMigrationManager;
import com.avito.android.advert_core.di.module.AdvertCoreTasksModule;
import com.avito.android.app.ApplicationDelegate;
import com.avito.android.app.MainProcessApplicationDelegate;
import com.avito.android.app.task.ApplicationBackgroundStartupTask;
import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.ApplicationForegroundStartupTask;
import com.avito.android.app.task.ApplicationStartupTasksExecutor;
import com.avito.android.app.task.SendStartupTimeTask;
import com.avito.android.di.MapTasksModule;
import com.avito.android.di.module.ApplicationDelegateOptionalModule;
import com.avito.android.enabler.RemoteFeaturesStartupMonitor;
import com.avito.android.geo.di.GeoTasksModule;
import com.avito.android.in_app_calls.di.InAppCallsTasksModule;
import com.avito.android.notification_center.di.NotificationsTasks;
import com.avito.android.photo_picker.legacy.PhotoStorageCleaner;
import com.avito.android.photo_picker.legacy.PhotoStorageCleanerImpl;
import com.avito.android.preferences.migration.PreferencesMigrationManager;
import com.avito.android.preferences.migration.PreferencesMigrationProvider;
import com.avito.android.preferences.migration.delegate.PreferenceUpdateTask;
import com.avito.android.publish.di.PublishTasks;
import com.avito.android.publish.di.PublishTasksModule;
import com.avito.android.version_conflict.di.module.VersionConflictTasks;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b4\u00105J?\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0017¢\u0006\u0004\b\u000f\u0010\u0010J\u0001\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0013\b\u0001\u0010\u0014\u001a\r\u0012\t\u0012\u00070\u0012¢\u0006\u0002\b\u00130\u00112\u0013\b\u0001\u0010\u0015\u001a\r\u0012\t\u0012\u00070\u0012¢\u0006\u0002\b\u00130\u00112\u0013\b\u0001\u0010\u0016\u001a\r\u0012\t\u0012\u00070\u0012¢\u0006\u0002\b\u00130\u00112\u0013\b\u0001\u0010\u0017\u001a\r\u0012\t\u0012\u00070\u0012¢\u0006\u0002\b\u00130\u00112\u0013\b\u0001\u0010\u0018\u001a\r\u0012\t\u0012\u00070\u0012¢\u0006\u0002\b\u00130\u00112\u0011\u0010\u001a\u001a\r\u0012\t\u0012\u00070\u0012¢\u0006\u0002\b\u00130\u0019H\u0017¢\u0006\u0004\b\u001b\u0010\u001cJæ\u0001\u0010\"\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001e0\u001d0\u00112\u001b\b\u0001\u0010\u001f\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0006\b\u0001\u0012\u00020\u001e0\u001d¢\u0006\u0002\b\u00130\u00112\u001b\b\u0001\u0010\u0014\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0006\b\u0001\u0012\u00020\u001e0\u001d¢\u0006\u0002\b\u00130\u00112\u001b\b\u0001\u0010 \u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0006\b\u0001\u0012\u00020\u001e0\u001d¢\u0006\u0002\b\u00130\u00112\u001b\b\u0001\u0010!\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0006\b\u0001\u0012\u00020\u001e0\u001d¢\u0006\u0002\b\u00130\u00112\u001b\b\u0001\u0010\u0016\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0006\b\u0001\u0012\u00020\u001e0\u001d¢\u0006\u0002\b\u00130\u00112\u001b\b\u0001\u0010\u0015\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0006\b\u0001\u0012\u00020\u001e0\u001d¢\u0006\u0002\b\u00130\u00112\u0019\u0010\u001a\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0006\b\u0001\u0012\u00020\u001e0\u001d¢\u0006\u0002\b\u00130\u0019H\u0017¢\u0006\u0004\b\"\u0010#Jl\u0010'\u001a\r\u0012\t\u0012\u00070$¢\u0006\u0002\b\u00130\u00112\u0011\u0010\u001a\u001a\r\u0012\t\u0012\u00070$¢\u0006\u0002\b\u00130\u00192\u0013\b\u0001\u0010%\u001a\r\u0012\t\u0012\u00070$¢\u0006\u0002\b\u00130\u00112\u0013\b\u0001\u0010\u0015\u001a\r\u0012\t\u0012\u00070$¢\u0006\u0002\b\u00130\u00112\u0013\b\u0001\u0010&\u001a\r\u0012\t\u0012\u00070$¢\u0006\u0002\b\u00130\u0011H\u0017¢\u0006\u0004\b'\u0010(J\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u00112\u0006\u0010*\u001a\u00020)H\u0007¢\u0006\u0004\b,\u0010-J*\u0010/\u001a\u00020\b2\u0006\u0010.\u001a\u00020)2\u0011\u0010\u001a\u001a\r\u0012\t\u0012\u00070+¢\u0006\u0002\b\u00130\u0011H\u0007¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u0002012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b2\u00103¨\u00067"}, d2 = {"Lcom/avito/android/di/module/ApplicationDelegateModule;", "", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/app/task/ApplicationStartupTasksExecutor;", "startupTasksExecutor", "Lcom/avito/android/account/AccountStorageMigrationManager;", "accountStorageMigrationManager", "Lcom/avito/android/preferences/migration/PreferencesMigrationManager;", "migrationManager", "Lcom/avito/android/app/task/SendStartupTimeTask;", "sendTimeTask", "Lcom/avito/android/enabler/RemoteFeaturesStartupMonitor;", "remoteFeaturesStartupMonitor", "Lcom/avito/android/app/ApplicationDelegate;", "provideApplicationDelegate", "(Landroid/app/Application;Lcom/avito/android/app/task/ApplicationStartupTasksExecutor;Lcom/avito/android/account/AccountStorageMigrationManager;Lcom/avito/android/preferences/migration/PreferencesMigrationManager;Lcom/avito/android/app/task/SendStartupTimeTask;Lcom/avito/android/enabler/RemoteFeaturesStartupMonitor;)Lcom/avito/android/app/ApplicationDelegate;", "", "Lcom/avito/android/app/task/ApplicationBlockingStartupTask;", "Lkotlin/jvm/JvmSuppressWildcards;", "analyticsTasks", "messengerTasks", "publishTasks", "favoritesTasks", "optionalTasks", "", "tasks", "provideApplicationBlockingStartupTasks", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Set;)Ljava/util/List;", "Lcom/avito/android/TypedLazy;", "Lcom/avito/android/app/task/ApplicationBackgroundStartupTask;", "advertCoreTasks", "abTasks", "serpTasks", "provideApplicationBackgroundStartupTasks", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Set;)Ljava/util/List;", "Lcom/avito/android/app/task/ApplicationForegroundStartupTask;", "notificationsTasks", "versionConflictTasks", "provideApplicationForegroundStartupTasks", "(Ljava/util/Set;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Ljava/util/List;", "Landroid/content/SharedPreferences;", "preferences", "Lcom/avito/android/preferences/migration/delegate/PreferenceUpdateTask;", "providePreferenceUpdateTasks", "(Landroid/content/SharedPreferences;)Ljava/util/List;", "sharedPreferences", "providePreferencesMigrationManager", "(Landroid/content/SharedPreferences;Ljava/util/List;)Lcom/avito/android/preferences/migration/PreferencesMigrationManager;", "Landroid/content/res/Resources;", "provideResources", "(Landroid/app/Application;)Landroid/content/res/Resources;", "<init>", "()V", "Declarations", "avito-103.5-(1342)_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {ApplicationStartupTasksModule.class, AbTestModule.class, AnalyticsTasksModule.class, Declarations.class, ApplicationDelegateOptionalModule.class, CoreTasksModule.class, FavoritesTasksModule.class, GeoTasksModule.class, MapTasksModule.class, InAppCallsTasksModule.class, PublishTasksModule.class, SerpTasksModule.class, AdvertCoreTasksModule.class})
public class ApplicationDelegateModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/di/module/ApplicationDelegateModule$Declarations;", "", "Lcom/avito/android/photo_picker/legacy/PhotoStorageCleanerImpl;", "photoStorageCleaner", "Lcom/avito/android/photo_picker/legacy/PhotoStorageCleaner;", "providePhotoStorageCleaner", "(Lcom/avito/android/photo_picker/legacy/PhotoStorageCleanerImpl;)Lcom/avito/android/photo_picker/legacy/PhotoStorageCleaner;", "avito-103.5-(1342)_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        PhotoStorageCleaner providePhotoStorageCleaner(@NotNull PhotoStorageCleanerImpl photoStorageCleanerImpl);
    }

    @Provides
    @NotNull
    public List<TypedLazy<? extends ApplicationBackgroundStartupTask>> provideApplicationBackgroundStartupTasks(@AdvertCoreTasksModule.AdvertCoreTasks @NotNull List<TypedLazy<? extends ApplicationBackgroundStartupTask>> list, @AnalyticsTasks @NotNull List<TypedLazy<? extends ApplicationBackgroundStartupTask>> list2, @AbTestsTasks @NotNull List<TypedLazy<? extends ApplicationBackgroundStartupTask>> list3, @SerpTasks @NotNull List<TypedLazy<? extends ApplicationBackgroundStartupTask>> list4, @PublishTasks @NotNull List<TypedLazy<? extends ApplicationBackgroundStartupTask>> list5, @MessengerTasksModule.MessengerTasks @NotNull List<TypedLazy<? extends ApplicationBackgroundStartupTask>> list6, @NotNull Set<TypedLazy<? extends ApplicationBackgroundStartupTask>> set) {
        Intrinsics.checkNotNullParameter(list, "advertCoreTasks");
        Intrinsics.checkNotNullParameter(list2, "analyticsTasks");
        Intrinsics.checkNotNullParameter(list3, "abTasks");
        Intrinsics.checkNotNullParameter(list4, "serpTasks");
        Intrinsics.checkNotNullParameter(list5, "publishTasks");
        Intrinsics.checkNotNullParameter(list6, "messengerTasks");
        Intrinsics.checkNotNullParameter(set, "tasks");
        return CollectionsKt___CollectionsKt.plus((Collection) CollectionsKt___CollectionsKt.plus((Collection) CollectionsKt___CollectionsKt.plus((Collection) CollectionsKt___CollectionsKt.plus((Collection) CollectionsKt___CollectionsKt.plus((Collection) CollectionsKt___CollectionsKt.plus((Collection) CollectionsKt___CollectionsKt.toList(set), (Iterable) list), (Iterable) list2), (Iterable) list3), (Iterable) list4), (Iterable) list5), (Iterable) list6);
    }

    @Provides
    @NotNull
    public List<ApplicationBlockingStartupTask> provideApplicationBlockingStartupTasks(@AnalyticsTasks @NotNull List<ApplicationBlockingStartupTask> list, @MessengerTasksModule.MessengerTasks @NotNull List<ApplicationBlockingStartupTask> list2, @PublishTasks @NotNull List<ApplicationBlockingStartupTask> list3, @FavoritesTasks @NotNull List<ApplicationBlockingStartupTask> list4, @ApplicationDelegateOptionalModule.OptionalTasks @NotNull List<ApplicationBlockingStartupTask> list5, @NotNull Set<ApplicationBlockingStartupTask> set) {
        Intrinsics.checkNotNullParameter(list, "analyticsTasks");
        Intrinsics.checkNotNullParameter(list2, "messengerTasks");
        Intrinsics.checkNotNullParameter(list3, "publishTasks");
        Intrinsics.checkNotNullParameter(list4, "favoritesTasks");
        Intrinsics.checkNotNullParameter(list5, "optionalTasks");
        Intrinsics.checkNotNullParameter(set, "tasks");
        return CollectionsKt___CollectionsKt.plus((Collection) CollectionsKt___CollectionsKt.plus((Collection) CollectionsKt___CollectionsKt.plus((Collection) CollectionsKt___CollectionsKt.plus((Collection) CollectionsKt___CollectionsKt.plus((Collection) CollectionsKt___CollectionsKt.toList(set), (Iterable) list), (Iterable) list2), (Iterable) list3), (Iterable) list4), (Iterable) list5);
    }

    @Provides
    @NotNull
    public ApplicationDelegate provideApplicationDelegate(@NotNull Application application, @NotNull ApplicationStartupTasksExecutor applicationStartupTasksExecutor, @NotNull AccountStorageMigrationManager accountStorageMigrationManager, @NotNull PreferencesMigrationManager preferencesMigrationManager, @NotNull SendStartupTimeTask sendStartupTimeTask, @NotNull RemoteFeaturesStartupMonitor remoteFeaturesStartupMonitor) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(applicationStartupTasksExecutor, "startupTasksExecutor");
        Intrinsics.checkNotNullParameter(accountStorageMigrationManager, "accountStorageMigrationManager");
        Intrinsics.checkNotNullParameter(preferencesMigrationManager, "migrationManager");
        Intrinsics.checkNotNullParameter(sendStartupTimeTask, "sendTimeTask");
        Intrinsics.checkNotNullParameter(remoteFeaturesStartupMonitor, "remoteFeaturesStartupMonitor");
        return new MainProcessApplicationDelegate(application, applicationStartupTasksExecutor, accountStorageMigrationManager, preferencesMigrationManager, sendStartupTimeTask, remoteFeaturesStartupMonitor);
    }

    @Provides
    @NotNull
    public List<ApplicationForegroundStartupTask> provideApplicationForegroundStartupTasks(@NotNull Set<ApplicationForegroundStartupTask> set, @NotificationsTasks @NotNull List<ApplicationForegroundStartupTask> list, @MessengerTasksModule.MessengerTasks @NotNull List<ApplicationForegroundStartupTask> list2, @VersionConflictTasks @NotNull List<ApplicationForegroundStartupTask> list3) {
        Intrinsics.checkNotNullParameter(set, "tasks");
        Intrinsics.checkNotNullParameter(list, "notificationsTasks");
        Intrinsics.checkNotNullParameter(list2, "messengerTasks");
        Intrinsics.checkNotNullParameter(list3, "versionConflictTasks");
        return CollectionsKt___CollectionsKt.plus((Collection) CollectionsKt___CollectionsKt.plus((Collection) CollectionsKt___CollectionsKt.plus((Collection) CollectionsKt___CollectionsKt.toList(set), (Iterable) list2), (Iterable) list), (Iterable) list3);
    }

    @Provides
    @NotNull
    public final List<PreferenceUpdateTask> providePreferenceUpdateTasks(@NotNull SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "preferences");
        return new PreferencesMigrationProvider().provide(sharedPreferences);
    }

    @Provides
    @NotNull
    public final PreferencesMigrationManager providePreferencesMigrationManager(@NotNull SharedPreferences sharedPreferences, @NotNull List<PreferenceUpdateTask> list) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(list, "tasks");
        return new PreferencesMigrationManager(sharedPreferences, list);
    }

    @Provides
    @NotNull
    public final Resources provideResources(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Resources resources = application.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "application.resources");
        return resources;
    }
}
