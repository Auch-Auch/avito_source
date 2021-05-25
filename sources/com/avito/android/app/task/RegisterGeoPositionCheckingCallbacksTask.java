package com.avito.android.app.task;

import android.app.Application;
import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.ApplicationStartupTask;
import com.avito.android.geo.GeoPositionModel;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.avito.android.permissions.PermissionChecker;
import com.avito.android.util.SchedulersFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0012\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/avito/android/app/task/RegisterGeoPositionCheckingCallbacksTask;", "Lcom/avito/android/app/task/ApplicationBlockingStartupTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "execute", "(Landroid/app/Application;)Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "Lcom/avito/android/permissions/PermissionChecker;", "permissionChecker", "Lcom/avito/android/permissions/PermissionChecker;", "getPermissionChecker", "()Lcom/avito/android/permissions/PermissionChecker;", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/util/SchedulersFactory;", "getSchedulers", "()Lcom/avito/android/util/SchedulersFactory;", "Lcom/avito/android/geo/GeoPositionModel;", VerticalFilterCloseDialogEventKt.MODEL_DIALOG, "Lcom/avito/android/geo/GeoPositionModel;", "getModel", "()Lcom/avito/android/geo/GeoPositionModel;", "Lio/reactivex/disposables/Disposable;", "disposable", "Lio/reactivex/disposables/Disposable;", "<init>", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/permissions/PermissionChecker;Lcom/avito/android/geo/GeoPositionModel;)V", "geo_release"}, k = 1, mv = {1, 4, 2})
public final class RegisterGeoPositionCheckingCallbacksTask implements ApplicationBlockingStartupTask {
    public Disposable disposable;
    @NotNull
    public final GeoPositionModel model;
    @NotNull
    public final PermissionChecker permissionChecker;
    @NotNull
    public final SchedulersFactory schedulers;

    @Inject
    public RegisterGeoPositionCheckingCallbacksTask(@NotNull SchedulersFactory schedulersFactory, @NotNull PermissionChecker permissionChecker2, @NotNull GeoPositionModel geoPositionModel) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(permissionChecker2, "permissionChecker");
        Intrinsics.checkNotNullParameter(geoPositionModel, VerticalFilterCloseDialogEventKt.MODEL_DIALOG);
        this.schedulers = schedulersFactory;
        this.permissionChecker = permissionChecker2;
        this.model = geoPositionModel;
    }

    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationStartupTask.ExecutionResult execute(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        application.registerActivityLifecycleCallbacks(new RegisterGeoPositionCheckingCallbacksTask$execute$1(this, application));
        return ApplicationStartupTask.ExecutionResult.Success.INSTANCE;
    }

    @NotNull
    public final GeoPositionModel getModel() {
        return this.model;
    }

    @NotNull
    public final PermissionChecker getPermissionChecker() {
        return this.permissionChecker;
    }

    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationBlockingStartupTask.Priority getPriority() {
        return ApplicationBlockingStartupTask.DefaultImpls.getPriority(this);
    }

    @NotNull
    public final SchedulersFactory getSchedulers() {
        return this.schedulers;
    }
}
