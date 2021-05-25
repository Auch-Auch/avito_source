package com.avito.android.permissions;

import androidx.fragment.app.FragmentActivity;
import com.avito.android.remote.auth.AuthSource;
import com.tbruyelle.rxpermissions3.RxPermissions;
import io.reactivex.rxjava3.core.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/permissions/LocationPermissionProviderWithActivityImpl;", "Lcom/avito/android/permissions/LocationPermissionProvider;", "Lio/reactivex/rxjava3/core/Single;", "", "isRequestRationale", "()Lio/reactivex/rxjava3/core/Single;", "isPermissionsGrantedDialog", "isPermissionGranted", "()Z", "Landroidx/fragment/app/FragmentActivity;", AuthSource.BOOKING_ORDER, "Landroidx/fragment/app/FragmentActivity;", "fragment", "Lcom/tbruyelle/rxpermissions3/RxPermissions;", AuthSource.SEND_ABUSE, "Lcom/tbruyelle/rxpermissions3/RxPermissions;", "rxPermissions", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "permissions_release"}, k = 1, mv = {1, 4, 2})
public final class LocationPermissionProviderWithActivityImpl implements LocationPermissionProvider {
    public final RxPermissions a;
    public final FragmentActivity b;

    @Inject
    public LocationPermissionProviderWithActivityImpl(@NotNull FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "fragment");
        this.b = fragmentActivity;
        this.a = new RxPermissions(fragmentActivity);
    }

    @Override // com.avito.android.permissions.LocationPermissionProvider
    public boolean isPermissionGranted() {
        return this.a.isGranted("android.permission.ACCESS_FINE_LOCATION") && this.a.isGranted("android.permission.ACCESS_COARSE_LOCATION");
    }

    @Override // com.avito.android.permissions.LocationPermissionProvider
    @NotNull
    public Single<Boolean> isPermissionsGrantedDialog() {
        Single<Boolean> firstOrError = this.a.request("android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION").firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError, "rxPermissions\n          …          .firstOrError()");
        return firstOrError;
    }

    @Override // com.avito.android.permissions.LocationPermissionProvider
    @NotNull
    public Single<Boolean> isRequestRationale() {
        Single<Boolean> firstOrError = this.a.shouldShowRequestPermissionRationale(this.b, "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION").firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError, "rxPermissions\n          …          .firstOrError()");
        return firstOrError;
    }
}
