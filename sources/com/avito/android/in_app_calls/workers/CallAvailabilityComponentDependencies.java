package com.avito.android.in_app_calls.workers;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.calls.CallClientAvailabilityNotifier;
import com.avito.android.calls_shared.storage.CallStorage;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.in_app_calls.CallManager;
import com.avito.android.permissions.PermissionStateProvider;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/in_app_calls/workers/CallAvailabilityComponentDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/in_app_calls/CallManager;", "callManager", "()Lcom/avito/android/in_app_calls/CallManager;", "Lcom/avito/android/calls_shared/storage/CallStorage;", "callStorage", "()Lcom/avito/android/calls_shared/storage/CallStorage;", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "()Lcom/avito/android/account/AccountStateProvider;", "Lcom/avito/android/permissions/PermissionStateProvider;", "permissionStateProvider", "()Lcom/avito/android/permissions/PermissionStateProvider;", "Lcom/avito/android/in_app_calls/workers/CallAvailabilityUpdater;", "callAvailabilityUpdater", "()Lcom/avito/android/in_app_calls/workers/CallAvailabilityUpdater;", "Lcom/avito/android/calls/CallClientAvailabilityNotifier;", "clientAvailabilityNotifier", "()Lcom/avito/android/calls/CallClientAvailabilityNotifier;", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public interface CallAvailabilityComponentDependencies extends CoreComponentDependencies {
    @Override // com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies, com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies, com.avito.android.booking.di.BookingOrderDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.cart.di.deps.CartSummaryDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    AccountStateProvider accountStateProvider();

    @NotNull
    CallAvailabilityUpdater callAvailabilityUpdater();

    @Override // com.avito.android.in_app_calls.di.CallManagerServiceComponentDependencies
    @NotNull
    CallManager callManager();

    @Override // com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies
    @NotNull
    CallStorage callStorage();

    @NotNull
    CallClientAvailabilityNotifier clientAvailabilityNotifier();

    @NotNull
    PermissionStateProvider permissionStateProvider();
}
