package ru.avito.messenger.internal.di;

import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.applinks.AppLinkData;
import dagger.Module;
import dagger.Provides;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lru/avito/messenger/internal/di/ErrorTrackerModule;", "", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "provideErrorTracker", "()Lcom/avito/android/communications_common/analytics/ErrorTracker;", AuthSource.SEND_ABUSE, "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "errorTracker", "<init>", "(Lcom/avito/android/communications_common/analytics/ErrorTracker;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class ErrorTrackerModule {
    public final ErrorTracker a;

    public ErrorTrackerModule(@Nullable ErrorTracker errorTracker) {
        this.a = errorTracker;
    }

    @Provides
    @PerMessenger
    @NotNull
    public final ErrorTracker provideErrorTracker() {
        ErrorTracker errorTracker = this.a;
        return errorTracker != null ? errorTracker : new ErrorTracker() { // from class: ru.avito.messenger.internal.di.ErrorTrackerModule$provideErrorTracker$1
            @Override // com.avito.android.communications_common.analytics.ErrorTracker
            public void track(@NotNull Throwable th, @Nullable String str, @NotNull Map<String, ? extends Object> map) {
                Intrinsics.checkNotNullParameter(th, "cause");
                Intrinsics.checkNotNullParameter(map, AppLinkData.ARGUMENTS_EXTRAS_KEY);
            }
        };
    }
}
