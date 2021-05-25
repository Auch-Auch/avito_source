package com.avito.android.app.task;

import a2.b.a.a.a;
import android.app.Application;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.NonFatalError;
import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.ApplicationStartupTask;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.firebase.messaging.Constants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000fB\u0019\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/app/task/InitLogErrorsToAnalyticsTask;", "Lcom/avito/android/app/task/ApplicationBlockingStartupTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "execute", "(Landroid/app/Application;)Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;)V", "NonFatalsTree", "application_release"}, k = 1, mv = {1, 4, 2})
public final class InitLogErrorsToAnalyticsTask implements ApplicationBlockingStartupTask {
    public final Analytics analytics;
    public final Features features;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ3\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/app/task/InitLogErrorsToAnalyticsTask$NonFatalsTree;", "Ltimber/log/Timber$Tree;", "", "tag", "", Constants.FirelogAnalytics.PARAM_PRIORITY, "", "isLoggable", "(Ljava/lang/String;I)Z", "message", "", "t", "", "log", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;)V", "application_release"}, k = 1, mv = {1, 4, 2})
    public static final class NonFatalsTree extends Timber.Tree {
        public final Analytics b;

        public NonFatalsTree(@NotNull Analytics analytics) {
            Intrinsics.checkNotNullParameter(analytics, "analytics");
            this.b = analytics;
        }

        @Override // timber.log.Timber.Tree
        public boolean isLoggable(@Nullable String str, int i) {
            return i == 6 || i == 7;
        }

        @Override // timber.log.Timber.Tree
        public void log(int i, @Nullable String str, @NotNull String str2, @Nullable Throwable th) {
            Intrinsics.checkNotNullParameter(str2, "message");
            this.b.track(new NonFatalError(a.L2(str, ' ', str2), th, null, 4, null));
        }
    }

    @Inject
    public InitLogErrorsToAnalyticsTask(@NotNull Analytics analytics2, @NotNull Features features2) {
        Intrinsics.checkNotNullParameter(analytics2, "analytics");
        Intrinsics.checkNotNullParameter(features2, "features");
        this.analytics = analytics2;
        this.features = features2;
    }

    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationStartupTask.ExecutionResult execute(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        if (this.features.getSendErrorsAsNonFatals().invoke().booleanValue()) {
            Timber.plant(new NonFatalsTree(this.analytics));
        }
        return ApplicationStartupTask.ExecutionResult.Success.INSTANCE;
    }

    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationBlockingStartupTask.Priority getPriority() {
        return ApplicationBlockingStartupTask.DefaultImpls.getPriority(this);
    }
}
