package com.avito.android.calls_shared.di;

import com.avito.android.calls_shared.CallUuidProvider;
import com.avito.android.calls_shared.CallUuidProviderImpl;
import com.avito.android.calls_shared.tracker.errors.CallsErrorTracker;
import com.avito.android.calls_shared.tracker.events.CallEventTracker;
import com.avito.android.calls_shared.tracker.events.CallEventTrackerImpl;
import com.avito.android.communications_common.analytics.ErrorTracker;
import dagger.Binds;
import dagger.Module;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/avito/android/calls_shared/di/CallsModule;", "", "<init>", "()V", "Declarations", "InAppCallsPreferences", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public class CallsModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/calls_shared/di/CallsModule$Declarations;", "", "Lcom/avito/android/calls_shared/CallUuidProviderImpl;", "impl", "Lcom/avito/android/calls_shared/CallUuidProvider;", "bindCallUuidProvider", "(Lcom/avito/android/calls_shared/CallUuidProviderImpl;)Lcom/avito/android/calls_shared/CallUuidProvider;", "Lcom/avito/android/calls_shared/tracker/events/CallEventTrackerImpl;", "Lcom/avito/android/calls_shared/tracker/events/CallEventTracker;", "bindCallEventTracker", "(Lcom/avito/android/calls_shared/tracker/events/CallEventTrackerImpl;)Lcom/avito/android/calls_shared/tracker/events/CallEventTracker;", "Lcom/avito/android/calls_shared/tracker/errors/CallsErrorTracker;", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "bindCallErrorTracker", "(Lcom/avito/android/calls_shared/tracker/errors/CallsErrorTracker;)Lcom/avito/android/communications_common/analytics/ErrorTracker;", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        ErrorTracker bindCallErrorTracker(@NotNull CallsErrorTracker callsErrorTracker);

        @Binds
        @NotNull
        CallEventTracker bindCallEventTracker(@NotNull CallEventTrackerImpl callEventTrackerImpl);

        @Singleton
        @Binds
        @NotNull
        CallUuidProvider bindCallUuidProvider(@NotNull CallUuidProviderImpl callUuidProviderImpl);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/calls_shared/di/CallsModule$InAppCallsPreferences;", "", "<init>", "()V", "calls-shared_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.CLASS)
    @kotlin.annotation.Retention(AnnotationRetention.BINARY)
    public @interface InAppCallsPreferences {
    }
}
