package com.avito.android.permissions;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/permissions/PermissionChecker;", "", "", "permission", "", "checkPermission", "(Ljava/lang/String;)Z", "", "permissions", "", "grantResults", "([Ljava/lang/String;[ILjava/lang/String;)Z", "permissions_release"}, k = 1, mv = {1, 4, 2})
public interface PermissionChecker {
    boolean checkPermission(@NotNull String str);

    boolean checkPermission(@NotNull String[] strArr, @NotNull int[] iArr, @NotNull String str);
}
