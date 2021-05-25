package com.avito.android.in_app_calls.di;

import android.app.Application;
import android.content.Context;
import com.avito.android.Features;
import com.avito.android.calls.AvitoCallClient;
import com.avito.android.calls.CallClientAvailabilityNotifier;
import com.avito.android.calls.CredentialsStorage;
import com.avito.android.calls.IncomingCallListener;
import com.avito.android.calls.OneTimeLoginCredentialsProvider;
import com.avito.android.calls.analytics.CallAnalyticsTracker;
import com.avito.android.calls.audio.CallAudioManager;
import com.avito.android.calls.auth.UsernameProvider;
import com.avito.android.calls.di.CallsCoreModule;
import com.avito.android.calls.dummy.DummyCallClient;
import com.avito.android.calls.push.PushTokenRegistrationCallback;
import com.avito.android.calls.quality.CallQualityIssueListener;
import com.avito.android.calls.voximplant.VoxCallClient;
import com.avito.android.calls_shared.AppCallsUsageTracker;
import com.avito.android.calls_shared.AppCallsUsageTrackerImpl;
import com.avito.android.calls_shared.di.CallsModule;
import com.avito.android.calls_shared.storage.CallStorage;
import com.avito.android.calls_shared.storage.CallStorageImpl;
import com.avito.android.in_app_calls.CallManager;
import com.avito.android.in_app_calls.CallManagerImpl;
import com.avito.android.in_app_calls.CallPushHandlerImpl;
import com.avito.android.in_app_calls.CallRegistry;
import com.avito.android.in_app_calls.CallRegistryImpl;
import com.avito.android.in_app_calls.IncomingCallHandler;
import com.avito.android.in_app_calls.MicAccessPermissionTracker;
import com.avito.android.in_app_calls.MicAccessPermissionTrackerImpl;
import com.avito.android.in_app_calls.analytics.CallPushHandlingTracker;
import com.avito.android.in_app_calls.analytics.CallPushHandlingTrackerImpl;
import com.avito.android.in_app_calls.analytics.CallQualityIssueTracker;
import com.avito.android.in_app_calls.analytics.StatsdCallAnalyticsTracker;
import com.avito.android.in_app_calls.auth.AvitoCallClientAvailabilityNotifier;
import com.avito.android.in_app_calls.auth.AvitoOneTimeLoginCredentialsProvider;
import com.avito.android.in_app_calls.auth.AvitoUsernameProvider;
import com.avito.android.in_app_calls.auth.CallClientCredentialsManager;
import com.avito.android.in_app_calls.logging.CallLogFileProvider;
import com.avito.android.in_app_calls.logging.LogFileProvider;
import com.avito.android.in_app_calls.permissions.CallPermissionsManager;
import com.avito.android.in_app_calls.permissions.CallPermissionsManagerImpl;
import com.avito.android.in_app_calls.push.PushTokenRegistrationCallbackImpl;
import com.avito.android.in_app_calls.service.SystemCallStateProvider;
import com.avito.android.in_app_calls.service.SystemCallStateProviderImpl;
import com.avito.android.in_app_calls.workers.CallAvailabilityUpdater;
import com.avito.android.in_app_calls.workers.CallAvailabilityUpdaterImpl;
import com.avito.android.push.CallPushHandler;
import com.avito.android.push.PushTokenProviderModule;
import com.avito.android.push.provider.GcmPushTokenProvider;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.preferences.Names;
import com.avito.android.util.preferences.PreferenceFactory;
import com.avito.android.util.preferences.Preferences;
import com.google.android.exoplayer2.util.MimeTypes;
import com.voximplant.sdk.Voximplant;
import com.voximplant.sdk.client.ClientConfig;
import com.voximplant.sdk.client.IClient;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b/\u00100J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0017¢\u0006\u0004\b\n\u0010\u000bJ_\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\u0007H\u0017¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b\"\u0010#J\u001f\u0010'\u001a\u00020&2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010%\u001a\u00020$H\u0007¢\u0006\u0004\b'\u0010(J\u001d\u0010-\u001a\u00020,2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)H\u0007¢\u0006\u0004\b-\u0010.¨\u00062"}, d2 = {"Lcom/avito/android/in_app_calls/di/InAppCallsModule;", "", "Landroid/content/Context;", "context", "Lcom/voximplant/sdk/client/IClient;", "provideVoximplantCallClient", "(Landroid/content/Context;)Lcom/voximplant/sdk/client/IClient;", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/calls/audio/CallAudioManager;", "provideCallAudioManager", "(Lcom/avito/android/Features;)Lcom/avito/android/calls/audio/CallAudioManager;", "Lcom/avito/android/calls/CredentialsStorage;", "credentialStorage", "Lcom/avito/android/calls_shared/storage/CallStorage;", "callStorage", "Lcom/avito/android/calls/OneTimeLoginCredentialsProvider;", "oneTimeLoginCredentialsProvider", "Lcom/avito/android/calls/auth/UsernameProvider;", "usernameProvider", "Lcom/avito/android/calls/analytics/CallAnalyticsTracker;", "callAnalyticsTracker", "Lcom/avito/android/push/provider/GcmPushTokenProvider;", "pushTokenProvider", "Lcom/avito/android/calls/CallClientAvailabilityNotifier;", "callClientAvailabilityNotifier", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/calls/AvitoCallClient;", "provideVoxCallClient", "(Landroid/content/Context;Lcom/avito/android/calls/CredentialsStorage;Lcom/avito/android/calls_shared/storage/CallStorage;Lcom/avito/android/calls/OneTimeLoginCredentialsProvider;Lcom/avito/android/calls/auth/UsernameProvider;Lcom/avito/android/calls/analytics/CallAnalyticsTracker;Lcom/avito/android/push/provider/GcmPushTokenProvider;Lcom/avito/android/calls/CallClientAvailabilityNotifier;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/Features;)Lcom/avito/android/calls/AvitoCallClient;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/in_app_calls/logging/LogFileProvider;", "provideLogFileManager", "(Landroid/app/Application;)Lcom/avito/android/in_app_calls/logging/LogFileProvider;", "Lcom/avito/android/util/preferences/PreferenceFactory;", "factory", "Lcom/avito/android/util/preferences/Preferences;", "provideInAppCallsPreferences", "(Landroid/app/Application;Lcom/avito/android/util/preferences/PreferenceFactory;)Lcom/avito/android/util/preferences/Preferences;", "Ldagger/Lazy;", "Lcom/avito/android/in_app_calls/CallManager;", "callManager", "Lcom/avito/android/push/CallPushHandler;", "provideCallPushHandler", "(Ldagger/Lazy;)Lcom/avito/android/push/CallPushHandler;", "<init>", "()V", "Declarations", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, CallStartupTasksModule.class, CallsModule.class, PushTokenProviderModule.class, CallsCoreModule.class})
public class InAppCallsModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u001bH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u001fH'¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020#H'¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020(2\u0006\u0010\u0003\u001a\u00020'H'¢\u0006\u0004\b)\u0010*J\u0017\u0010-\u001a\u00020,2\u0006\u0010\u0003\u001a\u00020+H'¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\u0002002\u0006\u0010\u0003\u001a\u00020/H'¢\u0006\u0004\b1\u00102J\u0017\u00105\u001a\u0002042\u0006\u0010\u0003\u001a\u000203H'¢\u0006\u0004\b5\u00106J\u0017\u00109\u001a\u0002082\u0006\u0010\u0003\u001a\u000207H'¢\u0006\u0004\b9\u0010:J\u0017\u0010=\u001a\u00020<2\u0006\u0010\u0003\u001a\u00020;H'¢\u0006\u0004\b=\u0010>J\u0017\u0010A\u001a\u00020@2\u0006\u0010\u0003\u001a\u00020?H'¢\u0006\u0004\bA\u0010BJ\u0017\u0010E\u001a\u00020D2\u0006\u0010\u0003\u001a\u00020CH'¢\u0006\u0004\bE\u0010F¨\u0006G"}, d2 = {"Lcom/avito/android/in_app_calls/di/InAppCallsModule$Declarations;", "", "Lcom/avito/android/in_app_calls/auth/AvitoOneTimeLoginCredentialsProvider;", "impl", "Lcom/avito/android/calls/OneTimeLoginCredentialsProvider;", "bindOneTimeLoginCredentialsProvider", "(Lcom/avito/android/in_app_calls/auth/AvitoOneTimeLoginCredentialsProvider;)Lcom/avito/android/calls/OneTimeLoginCredentialsProvider;", "Lcom/avito/android/in_app_calls/auth/AvitoUsernameProvider;", "Lcom/avito/android/calls/auth/UsernameProvider;", "bindUsernameProvider", "(Lcom/avito/android/in_app_calls/auth/AvitoUsernameProvider;)Lcom/avito/android/calls/auth/UsernameProvider;", "Lcom/avito/android/in_app_calls/IncomingCallHandler;", "Lcom/avito/android/calls/IncomingCallListener;", "incomingCallListener", "(Lcom/avito/android/in_app_calls/IncomingCallHandler;)Lcom/avito/android/calls/IncomingCallListener;", "Lcom/avito/android/in_app_calls/analytics/CallQualityIssueTracker;", "Lcom/avito/android/calls/quality/CallQualityIssueListener;", "bindCallQualityIssueListener", "(Lcom/avito/android/in_app_calls/analytics/CallQualityIssueTracker;)Lcom/avito/android/calls/quality/CallQualityIssueListener;", "Lcom/avito/android/calls_shared/AppCallsUsageTrackerImpl;", "Lcom/avito/android/calls_shared/AppCallsUsageTracker;", "bindAppCallsUsageTracker", "(Lcom/avito/android/calls_shared/AppCallsUsageTrackerImpl;)Lcom/avito/android/calls_shared/AppCallsUsageTracker;", "Lcom/avito/android/in_app_calls/MicAccessPermissionTrackerImpl;", "Lcom/avito/android/in_app_calls/MicAccessPermissionTracker;", "bindMicAccessPermissionTracker", "(Lcom/avito/android/in_app_calls/MicAccessPermissionTrackerImpl;)Lcom/avito/android/in_app_calls/MicAccessPermissionTracker;", "Lcom/avito/android/in_app_calls/service/SystemCallStateProviderImpl;", "Lcom/avito/android/in_app_calls/service/SystemCallStateProvider;", "bindSystemCallStateProvider", "(Lcom/avito/android/in_app_calls/service/SystemCallStateProviderImpl;)Lcom/avito/android/in_app_calls/service/SystemCallStateProvider;", "Lcom/avito/android/in_app_calls/analytics/StatsdCallAnalyticsTracker;", "Lcom/avito/android/calls/analytics/CallAnalyticsTracker;", "bindCallAnalyticsTracker", "(Lcom/avito/android/in_app_calls/analytics/StatsdCallAnalyticsTracker;)Lcom/avito/android/calls/analytics/CallAnalyticsTracker;", "Lcom/avito/android/in_app_calls/analytics/CallPushHandlingTrackerImpl;", "Lcom/avito/android/in_app_calls/analytics/CallPushHandlingTracker;", "bindCallPushHandlingTracker", "(Lcom/avito/android/in_app_calls/analytics/CallPushHandlingTrackerImpl;)Lcom/avito/android/in_app_calls/analytics/CallPushHandlingTracker;", "Lcom/avito/android/in_app_calls/push/PushTokenRegistrationCallbackImpl;", "Lcom/avito/android/calls/push/PushTokenRegistrationCallback;", "bindPushTokenRegistrationCallback", "(Lcom/avito/android/in_app_calls/push/PushTokenRegistrationCallbackImpl;)Lcom/avito/android/calls/push/PushTokenRegistrationCallback;", "Lcom/avito/android/in_app_calls/auth/CallClientCredentialsManager;", "Lcom/avito/android/calls/CredentialsStorage;", "bindCallClientCredentialsManager", "(Lcom/avito/android/in_app_calls/auth/CallClientCredentialsManager;)Lcom/avito/android/calls/CredentialsStorage;", "Lcom/avito/android/in_app_calls/CallRegistryImpl;", "Lcom/avito/android/in_app_calls/CallRegistry;", "bindCallRegistry", "(Lcom/avito/android/in_app_calls/CallRegistryImpl;)Lcom/avito/android/in_app_calls/CallRegistry;", "Lcom/avito/android/in_app_calls/CallManagerImpl;", "Lcom/avito/android/in_app_calls/CallManager;", "bindCallManager", "(Lcom/avito/android/in_app_calls/CallManagerImpl;)Lcom/avito/android/in_app_calls/CallManager;", "Lcom/avito/android/in_app_calls/permissions/CallPermissionsManagerImpl;", "Lcom/avito/android/in_app_calls/permissions/CallPermissionsManager;", "bindCallPermissionsManager", "(Lcom/avito/android/in_app_calls/permissions/CallPermissionsManagerImpl;)Lcom/avito/android/in_app_calls/permissions/CallPermissionsManager;", "Lcom/avito/android/calls_shared/storage/CallStorageImpl;", "Lcom/avito/android/calls_shared/storage/CallStorage;", "bindInAppCallStorage", "(Lcom/avito/android/calls_shared/storage/CallStorageImpl;)Lcom/avito/android/calls_shared/storage/CallStorage;", "Lcom/avito/android/in_app_calls/workers/CallAvailabilityUpdaterImpl;", "Lcom/avito/android/in_app_calls/workers/CallAvailabilityUpdater;", "bindCallAvailabilityUpdater", "(Lcom/avito/android/in_app_calls/workers/CallAvailabilityUpdaterImpl;)Lcom/avito/android/in_app_calls/workers/CallAvailabilityUpdater;", "Lcom/avito/android/in_app_calls/auth/AvitoCallClientAvailabilityNotifier;", "Lcom/avito/android/calls/CallClientAvailabilityNotifier;", "bindCallClientAvailabilityNotifier", "(Lcom/avito/android/in_app_calls/auth/AvitoCallClientAvailabilityNotifier;)Lcom/avito/android/calls/CallClientAvailabilityNotifier;", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Reusable
        @Binds
        @NotNull
        AppCallsUsageTracker bindAppCallsUsageTracker(@NotNull AppCallsUsageTrackerImpl appCallsUsageTrackerImpl);

        @Reusable
        @Binds
        @NotNull
        CallAnalyticsTracker bindCallAnalyticsTracker(@NotNull StatsdCallAnalyticsTracker statsdCallAnalyticsTracker);

        @Reusable
        @Binds
        @NotNull
        CallAvailabilityUpdater bindCallAvailabilityUpdater(@NotNull CallAvailabilityUpdaterImpl callAvailabilityUpdaterImpl);

        @Reusable
        @Binds
        @NotNull
        CallClientAvailabilityNotifier bindCallClientAvailabilityNotifier(@NotNull AvitoCallClientAvailabilityNotifier avitoCallClientAvailabilityNotifier);

        @Singleton
        @Binds
        @NotNull
        CredentialsStorage bindCallClientCredentialsManager(@NotNull CallClientCredentialsManager callClientCredentialsManager);

        @Singleton
        @Binds
        @NotNull
        CallManager bindCallManager(@NotNull CallManagerImpl callManagerImpl);

        @Reusable
        @Binds
        @NotNull
        CallPermissionsManager bindCallPermissionsManager(@NotNull CallPermissionsManagerImpl callPermissionsManagerImpl);

        @Reusable
        @Binds
        @NotNull
        CallPushHandlingTracker bindCallPushHandlingTracker(@NotNull CallPushHandlingTrackerImpl callPushHandlingTrackerImpl);

        @Reusable
        @Binds
        @NotNull
        CallQualityIssueListener bindCallQualityIssueListener(@NotNull CallQualityIssueTracker callQualityIssueTracker);

        @Singleton
        @Binds
        @NotNull
        CallRegistry bindCallRegistry(@NotNull CallRegistryImpl callRegistryImpl);

        @Reusable
        @Binds
        @NotNull
        CallStorage bindInAppCallStorage(@NotNull CallStorageImpl callStorageImpl);

        @Reusable
        @Binds
        @NotNull
        MicAccessPermissionTracker bindMicAccessPermissionTracker(@NotNull MicAccessPermissionTrackerImpl micAccessPermissionTrackerImpl);

        @Reusable
        @Binds
        @NotNull
        OneTimeLoginCredentialsProvider bindOneTimeLoginCredentialsProvider(@NotNull AvitoOneTimeLoginCredentialsProvider avitoOneTimeLoginCredentialsProvider);

        @Reusable
        @Binds
        @NotNull
        PushTokenRegistrationCallback bindPushTokenRegistrationCallback(@NotNull PushTokenRegistrationCallbackImpl pushTokenRegistrationCallbackImpl);

        @Reusable
        @Binds
        @NotNull
        SystemCallStateProvider bindSystemCallStateProvider(@NotNull SystemCallStateProviderImpl systemCallStateProviderImpl);

        @Reusable
        @Binds
        @NotNull
        UsernameProvider bindUsernameProvider(@NotNull AvitoUsernameProvider avitoUsernameProvider);

        @Reusable
        @Binds
        @NotNull
        IncomingCallListener incomingCallListener(@NotNull IncomingCallHandler incomingCallHandler);
    }

    public static final class a implements ThreadFactory {
        public static final a a = new a();

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Voximplant");
        }
    }

    @Provides
    @Singleton
    @NotNull
    public CallAudioManager provideCallAudioManager(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        if (features.getMessengerInAppCalls().invoke().booleanValue()) {
            return CallAudioManager.Companion.getVoximplantInstance();
        }
        return CallAudioManager.Companion.getDummyInstance();
    }

    @Provides
    @NotNull
    public final CallPushHandler provideCallPushHandler(@NotNull Lazy<CallManager> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "callManager");
        return new CallPushHandlerImpl(lazy);
    }

    @Provides
    @NotNull
    @CallsModule.InAppCallsPreferences
    @Singleton
    public final Preferences provideInAppCallsPreferences(@NotNull Application application, @NotNull PreferenceFactory preferenceFactory) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(preferenceFactory, "factory");
        return preferenceFactory.getCustomPreferences(application, Names.IN_APP_CALLS);
    }

    @Provides
    @Singleton
    @NotNull
    public final LogFileProvider provideLogFileManager(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        File filesDir = application.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "application.filesDir");
        return new CallLogFileProvider(filesDir, null, 2, null);
    }

    @Provides
    @Singleton
    @NotNull
    public AvitoCallClient provideVoxCallClient(@NotNull Context context, @NotNull CredentialsStorage credentialsStorage, @NotNull CallStorage callStorage, @NotNull OneTimeLoginCredentialsProvider oneTimeLoginCredentialsProvider, @NotNull UsernameProvider usernameProvider, @NotNull CallAnalyticsTracker callAnalyticsTracker, @NotNull GcmPushTokenProvider gcmPushTokenProvider, @NotNull CallClientAvailabilityNotifier callClientAvailabilityNotifier, @NotNull BuildInfo buildInfo, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(credentialsStorage, "credentialStorage");
        Intrinsics.checkNotNullParameter(callStorage, "callStorage");
        Intrinsics.checkNotNullParameter(oneTimeLoginCredentialsProvider, "oneTimeLoginCredentialsProvider");
        Intrinsics.checkNotNullParameter(usernameProvider, "usernameProvider");
        Intrinsics.checkNotNullParameter(callAnalyticsTracker, "callAnalyticsTracker");
        Intrinsics.checkNotNullParameter(gcmPushTokenProvider, "pushTokenProvider");
        Intrinsics.checkNotNullParameter(callClientAvailabilityNotifier, "callClientAvailabilityNotifier");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(features, "features");
        boolean z = buildInfo.isDebug() || features.getCallsSendLogs().invoke().booleanValue();
        if (features.getMessengerInAppCalls().invoke().booleanValue()) {
            return new VoxCallClient.Builder(context, callStorage, features, callAnalyticsTracker).credentialsStorage(credentialsStorage).oneTimeLoginCredentialsProvider(oneTimeLoginCredentialsProvider).usernameProvider(usernameProvider).enableLogcatLogging(z).enableDebugLogging(z).pushTokenProvider(gcmPushTokenProvider).callClientAvailabilityNotifier(callClientAvailabilityNotifier).build();
        }
        return new DummyCallClient();
    }

    @Provides
    @Singleton
    @NotNull
    public IClient provideVoximplantCallClient(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.packageName = context.getPackageName();
        IClient clientInstance = Voximplant.getClientInstance(Executors.newSingleThreadExecutor(a.a), context, clientConfig);
        Intrinsics.checkNotNullExpressionValue(clientInstance, "Voximplant.getClientInst…r, context, clientConfig)");
        return clientInstance;
    }
}
