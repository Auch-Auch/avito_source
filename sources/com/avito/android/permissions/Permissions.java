package com.avito.android.permissions;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Deprecated(message = "Use PermissionsHelper instead")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\rJ3\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\t\"\u00020\u0004H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J3\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\t\"\u00020\u0004H\u0007¢\u0006\u0004\b\u0013\u0010\u0017J!\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/avito/android/permissions/Permissions;", "", "Landroid/content/Context;", "context", "", "permission", "", "checkPermission", "(Landroid/content/Context;Ljava/lang/String;)Z", "", "permissions", "", "grantResults", "([Ljava/lang/String;[ILjava/lang/String;)Z", "Landroid/app/Activity;", "activity", "", "requestCode", "", "requestPermissions", "(Landroid/app/Activity;I[Ljava/lang/String;)V", "Landroidx/fragment/app/Fragment;", "fragment", "(Landroidx/fragment/app/Fragment;I[Ljava/lang/String;)V", "shouldShowRequestPermissionRationale", "(Landroid/app/Activity;Ljava/lang/String;)Z", "<init>", "()V", "permissions_release"}, k = 1, mv = {1, 4, 2})
public final class Permissions {
    @NotNull
    public static final Permissions INSTANCE = new Permissions();

    @JvmStatic
    public static final boolean checkPermission(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "permission");
        if (Build.VERSION.SDK_INT >= 23) {
            int checkSelfPermission = ContextCompat.checkSelfPermission(context, str);
            Objects.requireNonNull(INSTANCE);
            if (checkSelfPermission != 0) {
                return false;
            }
        }
        return true;
    }

    @JvmStatic
    public static final void requestPermissions(@NotNull Activity activity, int i, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        ActivityCompat.requestPermissions(activity, strArr, i);
    }

    @JvmStatic
    public static final boolean shouldShowRequestPermissionRationale(@NotNull Activity activity, @NotNull String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "permission");
        return ActivityCompat.shouldShowRequestPermissionRationale(activity, str);
    }

    @JvmStatic
    public static final void requestPermissions(@NotNull Fragment fragment, int i, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        fragment.requestPermissions(strArr, i);
    }

    @JvmStatic
    public static final boolean checkPermission(@NotNull String[] strArr, @NotNull int[] iArr, @NotNull String str) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        Intrinsics.checkNotNullParameter(str, "permission");
        if (iArr.length == strArr.length) {
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                if (Intrinsics.areEqual(str, strArr[i])) {
                    int i2 = iArr[i];
                    Objects.requireNonNull(INSTANCE);
                    if (i2 == 0) {
                        return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }
}
