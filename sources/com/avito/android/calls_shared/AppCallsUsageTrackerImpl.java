package com.avito.android.calls_shared;

import com.avito.android.calls_shared.di.CallsModule;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Preferences;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/calls_shared/AppCallsUsageTrackerImpl;", "Lcom/avito/android/calls_shared/AppCallsUsageTracker;", "", "hasBeenUsed", "()Z", "", "trackUsed", "()V", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/preferences/Preferences;", "preferences", "<init>", "(Lcom/avito/android/util/preferences/Preferences;)V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
public final class AppCallsUsageTrackerImpl implements AppCallsUsageTracker {
    public final Preferences a;

    @Inject
    public AppCallsUsageTrackerImpl(@CallsModule.InAppCallsPreferences @NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        this.a = preferences;
    }

    @Override // com.avito.android.calls_shared.AppCallsUsageTracker
    public boolean hasBeenUsed() {
        return this.a.getBoolean("calls.has_been_used", false);
    }

    @Override // com.avito.android.calls_shared.AppCallsUsageTracker
    public void trackUsed() {
        this.a.putBoolean("calls.has_been_used", true);
    }
}
