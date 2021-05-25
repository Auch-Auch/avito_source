package com.avito.android.service.short_task.app_update;

import android.os.Bundle;
import com.avito.android.BaseApp;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.NonFatalError;
import com.avito.android.di.AppUpdateServiceDependencies;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.component.DaggerAppUpdateServiceComponent;
import com.avito.android.preferences.VersionStorage;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.service.short_task.ShortTask;
import com.avito.android.util.AvitoResponseException;
import com.avito.android.util.BuildInfo;
import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bF\u0010GJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R+\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00128B@BX\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010 \u001a\u00020\u001b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010&\u001a\u00020!8\u0016@\u0016XD¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\"\u0010(\u001a\u00020'8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00106\u001a\u0002058\u0006@\u0006X.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R+\u0010>\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00128B@BX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0015\u001a\u0004\b<\u0010\u0017\"\u0004\b=\u0010\u0019R\"\u0010@\u001a\u00020?8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006H"}, d2 = {"Lcom/avito/android/service/short_task/app_update/AppUpdateTask;", "Lcom/avito/android/service/short_task/ShortTask;", "Landroid/os/Bundle;", "bundle", "", "initialize", "(Landroid/os/Bundle;)V", "", "isAppUpdatePersisted", "()Z", "Lio/reactivex/Single;", "Lcom/avito/android/service/short_task/ShortTask$Status;", Tracker.Events.CREATIVE_START, "()Lio/reactivex/Single;", "Lcom/avito/android/remote/model/SuccessResult;", "it", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/SuccessResult;)V", "", "<set-?>", AuthSource.BOOKING_ORDER, "Lkotlin/properties/ReadWriteProperty;", "getActualVersionCode", "()I", "setActualVersionCode", "(I)V", "actualVersionCode", "Lcom/avito/android/service/short_task/ShortTask$NetworkState;", "c", "Lcom/avito/android/service/short_task/ShortTask$NetworkState;", "getRequiredNetworkState", "()Lcom/avito/android/service/short_task/ShortTask$NetworkState;", "requiredNetworkState", "", "d", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/util/BuildInfo;", "getBuildInfo", "()Lcom/avito/android/util/BuildInfo;", "setBuildInfo", "(Lcom/avito/android/util/BuildInfo;)V", "Lcom/avito/android/preferences/VersionStorage;", "versionStorage", "Lcom/avito/android/preferences/VersionStorage;", "getVersionStorage", "()Lcom/avito/android/preferences/VersionStorage;", "setVersionStorage", "(Lcom/avito/android/preferences/VersionStorage;)V", "Lcom/avito/android/service/short_task/app_update/AppUpdateInteractor;", "appUpdateInteractor", "Lcom/avito/android/service/short_task/app_update/AppUpdateInteractor;", "getAppUpdateInteractor", "()Lcom/avito/android/service/short_task/app_update/AppUpdateInteractor;", "setAppUpdateInteractor", "(Lcom/avito/android/service/short_task/app_update/AppUpdateInteractor;)V", "getStoredVersionCode", "setStoredVersionCode", "storedVersionCode", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "<init>", "()V", "application_release"}, k = 1, mv = {1, 4, 2})
public class AppUpdateTask implements ShortTask {
    public static final /* synthetic */ KProperty[] e = {a2.b.a.a.a.u0(AppUpdateTask.class, "storedVersionCode", "getStoredVersionCode()I", 0), a2.b.a.a.a.u0(AppUpdateTask.class, "actualVersionCode", "getActualVersionCode()I", 0)};
    public final ReadWriteProperty a;
    @Inject
    public Analytics analytics;
    @Inject
    public AppUpdateInteractor appUpdateInteractor;
    public final ReadWriteProperty b;
    @Inject
    public BuildInfo buildInfo;
    @NotNull
    public final ShortTask.NetworkState c = ShortTask.NetworkState.CONNECTED;
    @NotNull
    public final String d = AppUpdateTaskKt.APP_UPDATE_TASK_TAG;
    @Inject
    public VersionStorage versionStorage;

    public static final class a<T> implements Consumer<SuccessResult> {
        public final /* synthetic */ AppUpdateTask a;

        public a(AppUpdateTask appUpdateTask) {
            this.a = appUpdateTask;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(SuccessResult successResult) {
            this.a.a();
        }
    }

    public static final class b<T, R> implements Function<SuccessResult, ShortTask.Status> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ShortTask.Status apply(SuccessResult successResult) {
            Intrinsics.checkNotNullParameter(successResult, "it");
            return ShortTask.Status.SUCCESS;
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ AppUpdateTask a;

        public c(AppUpdateTask appUpdateTask) {
            this.a = appUpdateTask;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            AppUpdateTask.access$onErrorSending(this.a, th);
        }
    }

    public static final class d<T, R> implements Function<Throwable, ShortTask.Status> {
        public static final d a = new d();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ShortTask.Status apply(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "it");
            return ShortTask.Status.FAILED_AND_NEED_RETRY;
        }
    }

    public AppUpdateTask() {
        Delegates delegates = Delegates.INSTANCE;
        this.a = delegates.notNull();
        this.b = delegates.notNull();
    }

    public static final void access$onErrorSending(AppUpdateTask appUpdateTask, Throwable th) {
        Objects.requireNonNull(appUpdateTask);
        if (th instanceof AvitoResponseException) {
            Analytics analytics2 = appUpdateTask.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            analytics2.track(new NonFatalError("Error while sending app version metadata", th, null, 4, null));
        }
    }

    public final void a() {
        VersionStorage versionStorage2 = this.versionStorage;
        if (versionStorage2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("versionStorage");
        }
        versionStorage2.setVersionCode(((Number) this.b.getValue(this, e[1])).intValue());
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final AppUpdateInteractor getAppUpdateInteractor() {
        AppUpdateInteractor appUpdateInteractor2 = this.appUpdateInteractor;
        if (appUpdateInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appUpdateInteractor");
        }
        return appUpdateInteractor2;
    }

    @NotNull
    public final BuildInfo getBuildInfo() {
        BuildInfo buildInfo2 = this.buildInfo;
        if (buildInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buildInfo");
        }
        return buildInfo2;
    }

    @Override // com.avito.android.service.short_task.ShortTask
    @NotNull
    public ShortTask.NetworkState getRequiredNetworkState() {
        return this.c;
    }

    @Override // com.avito.android.service.short_task.ShortTask
    @NotNull
    public String getTag() {
        return this.d;
    }

    @NotNull
    public final VersionStorage getVersionStorage() {
        VersionStorage versionStorage2 = this.versionStorage;
        if (versionStorage2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("versionStorage");
        }
        return versionStorage2;
    }

    @Override // com.avito.android.service.short_task.ShortTask
    public void initialize(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        DaggerAppUpdateServiceComponent.builder().dependencies((AppUpdateServiceDependencies) ComponentDependenciesKt.getDependencies(AppUpdateServiceDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(BaseApp.Companion.getInstance()))).build().inject(this);
        VersionStorage versionStorage2 = this.versionStorage;
        if (versionStorage2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("versionStorage");
        }
        int versionCode = versionStorage2.getVersionCode();
        ReadWriteProperty readWriteProperty = this.a;
        KProperty<?>[] kPropertyArr = e;
        readWriteProperty.setValue(this, kPropertyArr[0], Integer.valueOf(versionCode));
        BuildInfo buildInfo2 = this.buildInfo;
        if (buildInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buildInfo");
        }
        this.b.setValue(this, kPropertyArr[1], Integer.valueOf(buildInfo2.getVersionCode()));
    }

    public boolean isAppUpdatePersisted() {
        ReadWriteProperty readWriteProperty = this.a;
        KProperty<?>[] kPropertyArr = e;
        if (((Number) readWriteProperty.getValue(this, kPropertyArr[0])).intValue() == ((Number) this.b.getValue(this, kPropertyArr[1])).intValue()) {
            return true;
        }
        return false;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setAppUpdateInteractor(@NotNull AppUpdateInteractor appUpdateInteractor2) {
        Intrinsics.checkNotNullParameter(appUpdateInteractor2, "<set-?>");
        this.appUpdateInteractor = appUpdateInteractor2;
    }

    public final void setBuildInfo(@NotNull BuildInfo buildInfo2) {
        Intrinsics.checkNotNullParameter(buildInfo2, "<set-?>");
        this.buildInfo = buildInfo2;
    }

    public final void setVersionStorage(@NotNull VersionStorage versionStorage2) {
        Intrinsics.checkNotNullParameter(versionStorage2, "<set-?>");
        this.versionStorage = versionStorage2;
    }

    @Override // com.avito.android.service.short_task.ShortTask
    @NotNull
    public Single<ShortTask.Status> start() {
        if (isAppUpdatePersisted()) {
            Single<ShortTask.Status> just = Single.just(ShortTask.Status.SUCCESS);
            Intrinsics.checkNotNullExpressionValue(just, "Single.just(ShortTask.Status.SUCCESS)");
            return just;
        }
        AppUpdateInteractor appUpdateInteractor2 = this.appUpdateInteractor;
        if (appUpdateInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appUpdateInteractor");
        }
        Single<R> firstOrError = appUpdateInteractor2.sendMetaData().doOnNext(new a(this)).map(b.a).doOnError(new c(this)).onErrorReturn(d.a).firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError, "appUpdateInteractor\n    …          .firstOrError()");
        return firstOrError;
    }
}
