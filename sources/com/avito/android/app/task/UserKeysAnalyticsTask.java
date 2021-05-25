package com.avito.android.app.task;

import android.app.Application;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.NonFatalError;
import com.avito.android.analytics.provider.crashlytics.FirebaseCrashlytics;
import com.avito.android.remote.DeviceIdProvider;
import com.avito.android.util.GooglePlayServicesInfo;
import com.avito.android.util.InitializeOperator;
import com.avito.android.util.Observables;
import com.avito.android.util.SchedulersFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import com.sumsub.sns.core.common.SNSConstants;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.logger.UploadServiceLogger;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/avito/android/app/task/UserKeysAnalyticsTask;", "Lcom/avito/android/app/task/ApplicationBackgroundStartupTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "", "execute", "(Landroid/app/Application;)V", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlytics;", "crashlytics", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlytics;", "Lcom/avito/android/util/GooglePlayServicesInfo;", "googlePlayServicesInfo", "Lcom/avito/android/util/GooglePlayServicesInfo;", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "Lcom/avito/android/remote/DeviceIdProvider;", "deviceIdProvider", "Lcom/avito/android/remote/DeviceIdProvider;", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/util/SchedulersFactory;", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlytics;Lcom/avito/android/remote/DeviceIdProvider;Lcom/avito/android/util/GooglePlayServicesInfo;Lcom/avito/android/util/SchedulersFactory;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class UserKeysAnalyticsTask implements ApplicationBackgroundStartupTask {
    public final Analytics analytics;
    public final FirebaseCrashlytics crashlytics;
    public final DeviceIdProvider deviceIdProvider;
    public final GooglePlayServicesInfo googlePlayServicesInfo;
    public final SchedulersFactory schedulers;

    public static final class a<T> implements ObservableOnSubscribe<Unit> {
        public static final a a = new a();

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(@NotNull ObservableEmitter<Unit> observableEmitter) {
            Intrinsics.checkNotNullParameter(observableEmitter, "it");
            observableEmitter.onNext(Unit.INSTANCE);
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ UserKeysAnalyticsTask a;

        public b(UserKeysAnalyticsTask userKeysAnalyticsTask) {
            this.a = userKeysAnalyticsTask;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            UserKeysAnalyticsTask.access$trackGooglePlayServiceVersion(this.a);
        }
    }

    public UserKeysAnalyticsTask(@NotNull Analytics analytics2, @NotNull FirebaseCrashlytics firebaseCrashlytics, @NotNull DeviceIdProvider deviceIdProvider2, @NotNull GooglePlayServicesInfo googlePlayServicesInfo2, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(analytics2, "analytics");
        Intrinsics.checkNotNullParameter(firebaseCrashlytics, "crashlytics");
        Intrinsics.checkNotNullParameter(deviceIdProvider2, "deviceIdProvider");
        Intrinsics.checkNotNullParameter(googlePlayServicesInfo2, "googlePlayServicesInfo");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.analytics = analytics2;
        this.crashlytics = firebaseCrashlytics;
        this.deviceIdProvider = deviceIdProvider2;
        this.googlePlayServicesInfo = googlePlayServicesInfo2;
        this.schedulers = schedulersFactory;
    }

    public static final void access$trackGooglePlayServiceVersion(UserKeysAnalyticsTask userKeysAnalyticsTask) {
        Objects.requireNonNull(userKeysAnalyticsTask);
        try {
            userKeysAnalyticsTask.crashlytics.setString(SNSConstants.Preference.KEY_DEVICE_ID, userKeysAnalyticsTask.deviceIdProvider.getValue());
        } catch (Exception e) {
            userKeysAnalyticsTask.analytics.track(new NonFatalError("Failed to set custom key", e, null, 4, null));
        }
        try {
            FirebaseCrashlytics firebaseCrashlytics = userKeysAnalyticsTask.crashlytics;
            Integer versionCode = userKeysAnalyticsTask.googlePlayServicesInfo.getVersionCode();
            firebaseCrashlytics.setInt("gps_version_code", versionCode != null ? versionCode.intValue() : -1);
        } catch (Exception e2) {
            userKeysAnalyticsTask.analytics.track(new NonFatalError("Failed to set custom key", e2, null, 4, null));
        }
        try {
            FirebaseCrashlytics firebaseCrashlytics2 = userKeysAnalyticsTask.crashlytics;
            String versionName = userKeysAnalyticsTask.googlePlayServicesInfo.getVersionName();
            if (versionName == null) {
                versionName = UploadServiceLogger.NA;
            }
            firebaseCrashlytics2.setString("gps_version_name", versionName);
        } catch (Exception e3) {
            userKeysAnalyticsTask.analytics.track(new NonFatalError("Failed to set custom key", e3, null, 4, null));
        }
        try {
            userKeysAnalyticsTask.crashlytics.setInt("gps_library_version_code", userKeysAnalyticsTask.googlePlayServicesInfo.getLibraryVersionCode());
        } catch (Exception e4) {
            userKeysAnalyticsTask.analytics.track(new NonFatalError("Failed to set custom key", e4, null, 4, null));
        }
    }

    @Override // com.avito.android.app.task.ApplicationBackgroundStartupTask
    public void execute(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Observable subscribeOn = Observable.create(a.a).lift(new InitializeOperator(this.crashlytics)).doOnNext(new b(this)).subscribeOn(this.schedulers.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "Observable.create<Unit> …scribeOn(schedulers.io())");
        Observables.subscribeIgnoreResult(subscribeOn);
    }
}
