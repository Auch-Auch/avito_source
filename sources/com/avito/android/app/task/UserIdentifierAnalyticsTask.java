package com.avito.android.app.task;

import android.app.Application;
import com.adjust.sdk.sig.BuildConfig;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.provider.crashlytics.FirebaseCrashlytics;
import com.avito.android.analytics_adjust.Adjust;
import com.avito.android.util.rx3.Observables;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/app/task/UserIdentifierAnalyticsTask;", "Lcom/avito/android/app/task/ApplicationBackgroundStartupTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "", "execute", "(Landroid/app/Application;)V", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlytics;", "crashlytics", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlytics;", "Lcom/avito/android/analytics_adjust/Adjust;", BuildConfig.FLAVOR, "Lcom/avito/android/analytics_adjust/Adjust;", "Lcom/avito/android/account/AccountStateProvider;", "accountState", "Lcom/avito/android/account/AccountStateProvider;", "<init>", "(Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlytics;Lcom/avito/android/analytics_adjust/Adjust;Lcom/avito/android/account/AccountStateProvider;)V", "account-storage_release"}, k = 1, mv = {1, 4, 2})
public final class UserIdentifierAnalyticsTask implements ApplicationBackgroundStartupTask {
    public final AccountStateProvider accountState;
    public final Adjust adjust;
    public final FirebaseCrashlytics crashlytics;

    public static final class a extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ UserIdentifierAnalyticsTask a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(UserIdentifierAnalyticsTask userIdentifierAnalyticsTask) {
            super(1);
            this.a = userIdentifierAnalyticsTask;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "it");
            UserIdentifierAnalyticsTask.access$setUserId(this.a, str2);
            return Unit.INSTANCE;
        }
    }

    public UserIdentifierAnalyticsTask(@NotNull FirebaseCrashlytics firebaseCrashlytics, @NotNull Adjust adjust2, @NotNull AccountStateProvider accountStateProvider) {
        Intrinsics.checkNotNullParameter(firebaseCrashlytics, "crashlytics");
        Intrinsics.checkNotNullParameter(adjust2, BuildConfig.FLAVOR);
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountState");
        this.crashlytics = firebaseCrashlytics;
        this.adjust = adjust2;
        this.accountState = accountStateProvider;
    }

    public static final void access$setUserId(UserIdentifierAnalyticsTask userIdentifierAnalyticsTask, String str) {
        Objects.requireNonNull(userIdentifierAnalyticsTask);
        if (str != null) {
            userIdentifierAnalyticsTask.crashlytics.setUserIdentifier(str);
            userIdentifierAnalyticsTask.adjust.setUserIdentifier(str);
        }
    }

    @Override // com.avito.android.app.task.ApplicationBackgroundStartupTask
    public void execute(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Observables.subscribeOnNext(this.accountState.userId(), new a(this));
    }
}
