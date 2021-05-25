package com.avito.android.permissions;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Builds;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/permissions/PermissionCheckerImpl;", "Lcom/avito/android/permissions/PermissionChecker;", "", "permission", "", "checkPermission", "(Ljava/lang/String;)Z", "", "permissions", "", "grantResults", "([Ljava/lang/String;[ILjava/lang/String;)Z", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "permissions_release"}, k = 1, mv = {1, 4, 2})
public final class PermissionCheckerImpl implements PermissionChecker {
    public final Context a;

    @Inject
    public PermissionCheckerImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // com.avito.android.permissions.PermissionChecker
    public boolean checkPermission(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "permission");
        return !Builds.isAtLeastMarshmallow || ContextCompat.checkSelfPermission(this.a, str) == 0;
    }

    @Override // com.avito.android.permissions.PermissionChecker
    public boolean checkPermission(@NotNull String[] strArr, @NotNull int[] iArr, @NotNull String str) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        Intrinsics.checkNotNullParameter(str, "permission");
        if (iArr.length == strArr.length) {
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                if (Intrinsics.areEqual(str, strArr[i])) {
                    if (iArr[i] == 0) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }
}
