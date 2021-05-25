package com.avito.android.in_app_calls.di;

import com.avito.android.analytics.NetworkTypeProvider;
import com.avito.android.calls.analytics.CallAnalyticsTracker;
import com.avito.android.calls.audio.CallAudioManager;
import com.avito.android.calls.remote.CallsApi;
import com.avito.android.calls_shared.CallUuidProvider;
import com.avito.android.calls_shared.tracker.events.CallEventTracker;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.in_app_calls.CallManager;
import com.avito.android.in_app_calls.IncomingCallHandler;
import com.avito.android.in_app_calls.service.SystemCallStateProvider;
import com.avito.android.in_app_calls.service.callStartTasks.CallStartTask;
import com.avito.android.server_time.TimeSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H&¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H&¢\u0006\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/avito/android/in_app_calls/di/CallManagerServiceComponentDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/in_app_calls/CallManager;", "callManager", "()Lcom/avito/android/in_app_calls/CallManager;", "Lcom/avito/android/in_app_calls/IncomingCallHandler;", "incomingCallHandler", "()Lcom/avito/android/in_app_calls/IncomingCallHandler;", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "()Lcom/avito/android/server_time/TimeSource;", "Lcom/avito/android/analytics/NetworkTypeProvider;", "networkTypeProvider", "()Lcom/avito/android/analytics/NetworkTypeProvider;", "Lcom/avito/android/calls/audio/CallAudioManager;", "callAudioManager", "()Lcom/avito/android/calls/audio/CallAudioManager;", "Lcom/avito/android/in_app_calls/service/SystemCallStateProvider;", "systemCallStateProvider", "()Lcom/avito/android/in_app_calls/service/SystemCallStateProvider;", "Lcom/avito/android/calls/analytics/CallAnalyticsTracker;", "callAnalyticsTracker", "()Lcom/avito/android/calls/analytics/CallAnalyticsTracker;", "Lcom/avito/android/calls/remote/CallsApi;", "callsApi", "()Lcom/avito/android/calls/remote/CallsApi;", "Lcom/avito/android/in_app_calls/service/callStartTasks/CallStartTask;", "callStartupTasks", "()Lcom/avito/android/in_app_calls/service/callStartTasks/CallStartTask;", "Lcom/avito/android/calls_shared/tracker/events/CallEventTracker;", "callEventTracker", "()Lcom/avito/android/calls_shared/tracker/events/CallEventTracker;", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "callErrorTracker", "()Lcom/avito/android/communications_common/analytics/ErrorTracker;", "Lcom/avito/android/calls_shared/CallUuidProvider;", "callUuidProvider", "()Lcom/avito/android/calls_shared/CallUuidProvider;", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public interface CallManagerServiceComponentDependencies extends CoreComponentDependencies {
    @NotNull
    CallAnalyticsTracker callAnalyticsTracker();

    @NotNull
    CallAudioManager callAudioManager();

    @NotNull
    ErrorTracker callErrorTracker();

    @NotNull
    CallEventTracker callEventTracker();

    @NotNull
    CallManager callManager();

    @NotNull
    CallStartTask callStartupTasks();

    @NotNull
    CallUuidProvider callUuidProvider();

    @Override // com.avito.android.in_app_calls.di.SendCallLogsDependencies
    @NotNull
    CallsApi callsApi();

    @NotNull
    IncomingCallHandler incomingCallHandler();

    @NotNull
    NetworkTypeProvider networkTypeProvider();

    @NotNull
    SystemCallStateProvider systemCallStateProvider();

    @Override // com.avito.android.app_rater.di.AppRaterDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.player.di.PlayerFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    TimeSource timeSource();
}
