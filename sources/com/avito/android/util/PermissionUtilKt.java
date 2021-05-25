package com.avito.android.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0005\u001a?\u0010\u0010\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0010\u0010\u0011\"\u0016\u0010\u0012\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroid/app/Activity;", "", "checkLocationPermission", "(Landroid/app/Activity;)Z", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)Z", "", "requestCode", "", "", "permissions", "", "grantResults", "Lkotlin/Function0;", "", "action", "locationPermissionGranted", "(Landroid/app/Activity;I[Ljava/lang/String;[ILkotlin/jvm/functions/Function0;)V", "REQUEST_LOCATION", "I", "permissions_release"}, k = 2, mv = {1, 4, 2})
public final class PermissionUtilKt {
    public static final int REQUEST_LOCATION = 200;

    @SuppressLint({"NewApi"})
    public static final boolean checkLocationPermission(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "$this$checkLocationPermission");
        if (ContextCompat.checkSelfPermission(activity, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            return true;
        }
        if (Builds.isAtLeastMarshmallow) {
            activity.requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 200);
        }
        return false;
    }

    public static final void locationPermissionGranted(@NotNull Activity activity, int i, @NotNull String[] strArr, @NotNull int[] iArr, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(activity, "$this$locationPermissionGranted");
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        Intrinsics.checkNotNullParameter(function0, "action");
        if (i == 200) {
            if ((!(strArr.length == 0)) && Intrinsics.areEqual(strArr[0], "android.permission.ACCESS_FINE_LOCATION")) {
                if ((!(iArr.length == 0)) && iArr[0] == 0) {
                    function0.invoke();
                }
            }
        }
    }

    public static final boolean checkLocationPermission(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "$this$checkLocationPermission");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            return checkLocationPermission(activity);
        }
        return false;
    }
}
