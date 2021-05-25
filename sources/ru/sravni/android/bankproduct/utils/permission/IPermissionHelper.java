package ru.sravni.android.bankproduct.utils.permission;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lru/sravni/android/bankproduct/utils/permission/IPermissionHelper;", "", "Lru/sravni/android/bankproduct/utils/permission/PermissionSravniInfo;", "permissionInfo", "checkPermissionsAllowed", "(Lru/sravni/android/bankproduct/utils/permission/PermissionSravniInfo;)Lru/sravni/android/bankproduct/utils/permission/PermissionSravniInfo;", "", "requestPermission", "(Lru/sravni/android/bankproduct/utils/permission/PermissionSravniInfo;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IPermissionHelper {
    @NotNull
    PermissionSravniInfo checkPermissionsAllowed(@NotNull PermissionSravniInfo permissionSravniInfo);

    void requestPermission(@NotNull PermissionSravniInfo permissionSravniInfo);
}
