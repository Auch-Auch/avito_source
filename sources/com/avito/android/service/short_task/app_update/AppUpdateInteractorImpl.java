package com.avito.android.service.short_task.app_update;

import com.avito.android.analytics.Analytics;
import com.avito.android.preferences.TokenStorage;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/service/short_task/app_update/AppUpdateInteractorImpl;", "Lcom/avito/android/service/short_task/app_update/AppUpdateInteractor;", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/SuccessResult;", "sendMetaData", "()Lio/reactivex/Observable;", "Lcom/avito/android/service/short_task/app_update/AppUpdateApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/service/short_task/app_update/AppUpdateApi;", "api", "Lcom/avito/android/analytics/Analytics;", "d", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/preferences/TokenStorage;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/preferences/TokenStorage;", "tokenStorage", "Lcom/avito/android/util/BuildInfo;", "c", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "<init>", "(Lcom/avito/android/service/short_task/app_update/AppUpdateApi;Lcom/avito/android/preferences/TokenStorage;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/analytics/Analytics;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class AppUpdateInteractorImpl implements AppUpdateInteractor {
    public final AppUpdateApi a;
    public final TokenStorage b;
    public final BuildInfo c;
    public final Analytics d;

    public static final class a<T> implements Consumer<SuccessResult> {
        public final /* synthetic */ AppUpdateInteractorImpl a;

        public a(AppUpdateInteractorImpl appUpdateInteractorImpl) {
            this.a = appUpdateInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(SuccessResult successResult) {
            this.a.d.track(new AppUpdateEvent(this.a.c.getVersionName(), String.valueOf(this.a.c.getVersionCode())));
        }
    }

    @Inject
    public AppUpdateInteractorImpl(@NotNull AppUpdateApi appUpdateApi, @NotNull TokenStorage tokenStorage, @NotNull BuildInfo buildInfo, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(appUpdateApi, "api");
        Intrinsics.checkNotNullParameter(tokenStorage, "tokenStorage");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = appUpdateApi;
        this.b = tokenStorage;
        this.c = buildInfo;
        this.d = analytics;
    }

    @Override // com.avito.android.service.short_task.app_update.AppUpdateInteractor
    @NotNull
    public Observable<SuccessResult> sendMetaData() {
        Observable<SuccessResult> doOnNext = InteropKt.toV2(this.a.sendMetaDataLegacy(this.b.getGcmToken())).doOnNext(new a(this));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "api.sendMetaDataLegacy(t…pdateEvent)\n            }");
        return doOnNext;
    }
}
