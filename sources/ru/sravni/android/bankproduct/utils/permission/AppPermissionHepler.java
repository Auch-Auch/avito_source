package ru.sravni.android.bankproduct.utils.permission;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lru/sravni/android/bankproduct/utils/permission/AppPermissionHepler;", "Lru/sravni/android/bankproduct/utils/permission/IAppPermissionHepler;", "", "requestAllPermission", "()V", "Lru/sravni/android/bankproduct/utils/permission/PermissionSravniInfo;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/utils/permission/PermissionSravniInfo;", "permissionInfo", "Lru/sravni/android/bankproduct/utils/permission/IPermissionHelper;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/utils/permission/IPermissionHelper;", "permissionHelper", "<init>", "(Lru/sravni/android/bankproduct/utils/permission/IPermissionHelper;Lru/sravni/android/bankproduct/utils/permission/PermissionSravniInfo;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class AppPermissionHepler implements IAppPermissionHepler {
    public final IPermissionHelper a;
    public final PermissionSravniInfo b;

    public AppPermissionHepler(@NotNull IPermissionHelper iPermissionHelper, @NotNull PermissionSravniInfo permissionSravniInfo) {
        Intrinsics.checkParameterIsNotNull(iPermissionHelper, "permissionHelper");
        Intrinsics.checkParameterIsNotNull(permissionSravniInfo, "permissionInfo");
        this.a = iPermissionHelper;
        this.b = permissionSravniInfo;
    }

    @Override // ru.sravni.android.bankproduct.utils.permission.IAppPermissionHepler
    public void requestAllPermission() {
        if (!this.a.checkPermissionsAllowed(this.b).isEmpty()) {
            this.a.requestPermission(this.b);
        }
    }
}
