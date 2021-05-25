package com.avito.android.in_app_calls.ui.call;

import com.avito.android.ab_tests.groups.CallsNewDesignTestGroup;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.NetworkTypeProvider;
import com.avito.android.calls.analytics.CallAnalyticsTracker;
import com.avito.android.calls.audio.CallAudioManager;
import com.avito.android.calls.auth.UsernameProvider;
import com.avito.android.calls.remote.CallsApi;
import com.avito.android.calls_shared.CallUuidProvider;
import com.avito.android.calls_shared.storage.CallStorage;
import com.avito.android.calls_shared.tracker.events.CallEventTracker;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.in_app_calls.permissions.CallPermissionsManager;
import com.avito.android.permissions.PermissionChecker;
import com.avito.android.server_time.TimeSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H&¢\u0006\u0004\b!\u0010\"J\u0015\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#H&¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u00020'H&¢\u0006\u0004\b(\u0010)J\u000f\u0010+\u001a\u00020*H&¢\u0006\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/avito/android/in_app_calls/ui/call/CallFragmentComponentDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "()Lcom/avito/android/server_time/TimeSource;", "Lcom/avito/android/calls/audio/CallAudioManager;", "callAudioManager", "()Lcom/avito/android/calls/audio/CallAudioManager;", "Lcom/avito/android/calls/remote/CallsApi;", "callsApi", "()Lcom/avito/android/calls/remote/CallsApi;", "Lcom/avito/android/analytics/NetworkTypeProvider;", "networkTypeProvider", "()Lcom/avito/android/analytics/NetworkTypeProvider;", "Lcom/avito/android/calls_shared/CallUuidProvider;", "callUuidProvider", "()Lcom/avito/android/calls_shared/CallUuidProvider;", "Lcom/avito/android/in_app_calls/permissions/CallPermissionsManager;", "callPermissionsManager", "()Lcom/avito/android/in_app_calls/permissions/CallPermissionsManager;", "Lcom/avito/android/calls/auth/UsernameProvider;", "usernameProvider", "()Lcom/avito/android/calls/auth/UsernameProvider;", "Lcom/avito/android/calls_shared/storage/CallStorage;", "callStorage", "()Lcom/avito/android/calls_shared/storage/CallStorage;", "Lcom/avito/android/calls/analytics/CallAnalyticsTracker;", "callAnalyticsTracker", "()Lcom/avito/android/calls/analytics/CallAnalyticsTracker;", "Lcom/avito/android/calls_shared/tracker/events/CallEventTracker;", "callEventTracker", "()Lcom/avito/android/calls_shared/tracker/events/CallEventTracker;", "Lcom/avito/android/communications_common/analytics/ErrorTracker;", "callErrorTracker", "()Lcom/avito/android/communications_common/analytics/ErrorTracker;", "Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/CallsNewDesignTestGroup;", "newDesignTestGroup", "()Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "()Lcom/avito/android/account/AccountStateProvider;", "Lcom/avito/android/permissions/PermissionChecker;", "permissionChecker", "()Lcom/avito/android/permissions/PermissionChecker;", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public interface CallFragmentComponentDependencies extends CoreComponentDependencies {
    @Override // com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies, com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies, com.avito.android.booking.di.BookingOrderDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.cart.di.deps.CartSummaryDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    AccountStateProvider accountStateProvider();

    @Override // com.avito.android.in_app_calls.di.CallManagerServiceComponentDependencies
    @NotNull
    CallAnalyticsTracker callAnalyticsTracker();

    @Override // com.avito.android.in_app_calls.di.CallManagerServiceComponentDependencies
    @NotNull
    CallAudioManager callAudioManager();

    @Override // com.avito.android.in_app_calls.di.CallManagerServiceComponentDependencies
    @NotNull
    ErrorTracker callErrorTracker();

    @Override // com.avito.android.in_app_calls.di.CallManagerServiceComponentDependencies
    @NotNull
    CallEventTracker callEventTracker();

    @NotNull
    CallPermissionsManager callPermissionsManager();

    @NotNull
    CallStorage callStorage();

    @Override // com.avito.android.in_app_calls.di.CallManagerServiceComponentDependencies
    @NotNull
    CallUuidProvider callUuidProvider();

    @Override // com.avito.android.in_app_calls.di.CallManagerServiceComponentDependencies, com.avito.android.in_app_calls.di.SendCallLogsDependencies
    @NotNull
    CallsApi callsApi();

    @Override // com.avito.android.in_app_calls.di.CallManagerServiceComponentDependencies
    @NotNull
    NetworkTypeProvider networkTypeProvider();

    @NotNull
    ExposedAbTestGroup<CallsNewDesignTestGroup> newDesignTestGroup();

    @NotNull
    PermissionChecker permissionChecker();

    @Override // com.avito.android.in_app_calls.di.CallManagerServiceComponentDependencies, com.avito.android.app_rater.di.AppRaterDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.player.di.PlayerFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    TimeSource timeSource();

    @NotNull
    UsernameProvider usernameProvider();
}
