package ru.sravni.android.bankproduct.utils.permission;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lru/sravni/android/bankproduct/utils/permission/PermissionHelper;", "Lru/sravni/android/bankproduct/utils/permission/IPermissionHelper;", "Lru/sravni/android/bankproduct/utils/permission/PermissionSravniInfo;", "permissionInfo", "checkPermissionsAllowed", "(Lru/sravni/android/bankproduct/utils/permission/PermissionSravniInfo;)Lru/sravni/android/bankproduct/utils/permission/PermissionSravniInfo;", "", "requestPermission", "(Lru/sravni/android/bankproduct/utils/permission/PermissionSravniInfo;)V", "", AuthSource.BOOKING_ORDER, "I", "permissionRequestCode", "Landroidx/appcompat/app/AppCompatActivity;", AuthSource.SEND_ABUSE, "Landroidx/appcompat/app/AppCompatActivity;", "activity", "<init>", "(Landroidx/appcompat/app/AppCompatActivity;I)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class PermissionHelper implements IPermissionHelper {
    public final AppCompatActivity a;
    public final int b;

    public PermissionHelper(@NotNull AppCompatActivity appCompatActivity, int i) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "activity");
        this.a = appCompatActivity;
        this.b = i;
    }

    @Override // ru.sravni.android.bankproduct.utils.permission.IPermissionHelper
    @NotNull
    public PermissionSravniInfo checkPermissionsAllowed(@NotNull PermissionSravniInfo permissionSravniInfo) {
        Intrinsics.checkParameterIsNotNull(permissionSravniInfo, "permissionInfo");
        List<String> permissions2 = permissionSravniInfo.getPermissions();
        ArrayList arrayList = new ArrayList();
        for (T t : permissions2) {
            if (!(ContextCompat.checkSelfPermission(this.a, t) == 0)) {
                arrayList.add(t);
            }
        }
        return new PermissionSravniInfo(arrayList);
    }

    @Override // ru.sravni.android.bankproduct.utils.permission.IPermissionHelper
    public void requestPermission(@NotNull PermissionSravniInfo permissionSravniInfo) {
        Intrinsics.checkParameterIsNotNull(permissionSravniInfo, "permissionInfo");
        ActivityCompat.requestPermissions(this.a, permissionSravniInfo.getPermissionsArray(), this.b);
    }
}
