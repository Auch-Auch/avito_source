package com.avito.android.permissions;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\n\u001a\u00020\u0005H&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/permissions/PermissionHelper;", "Lcom/avito/android/permissions/PermissionChecker;", "", "requestCode", "", "", "permissions", "", "requestPermissions", "(I[Ljava/lang/String;)V", "permission", "", "shouldShowRequestPermissionRationale", "(Ljava/lang/String;)Z", "permissions_release"}, k = 1, mv = {1, 4, 2})
public interface PermissionHelper extends PermissionChecker {
    void requestPermissions(int i, @NotNull String... strArr);

    boolean shouldShowRequestPermissionRationale(@NotNull String str);
}
