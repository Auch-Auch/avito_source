package com.sumsub.sns.camera;

import androidx.core.app.ActivityCompat;
import com.avito.android.remote.auth.AuthSource;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import permissions.dispatcher.PermissionUtils;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a!\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a1\u0010\n\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b\"\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/sumsub/sns/camera/SNSCameraPhotoViewModel;", "VM", "Lcom/sumsub/sns/camera/SNSCameraPhotoActivity;", "", "showExternalStorageWithPermissionCheck", "(Lcom/sumsub/sns/camera/SNSCameraPhotoActivity;)V", "", "requestCode", "", "grantResults", "onRequestPermissionsResult", "(Lcom/sumsub/sns/camera/SNSCameraPhotoActivity;I[I)V", "", "", AuthSource.SEND_ABUSE, "[Ljava/lang/String;", "PERMISSION_SHOWEXTERNALSTORAGE", "sns-camera_release"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "SNSCameraPhotoActivityPermissionsDispatcher")
public final class SNSCameraPhotoActivityPermissionsDispatcher {
    public static final String[] a = {"android.permission.READ_EXTERNAL_STORAGE"};

    public static final <VM extends SNSCameraPhotoViewModel> void onRequestPermissionsResult(@NotNull SNSCameraPhotoActivity<VM> sNSCameraPhotoActivity, int i, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(sNSCameraPhotoActivity, "$this$onRequestPermissionsResult");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        if (i == 0) {
            if (PermissionUtils.verifyPermissions(Arrays.copyOf(iArr, iArr.length))) {
                sNSCameraPhotoActivity.showExternalStorage();
                return;
            }
            String[] strArr = a;
            if (!PermissionUtils.shouldShowRequestPermissionRationale(sNSCameraPhotoActivity, (String[]) Arrays.copyOf(strArr, strArr.length))) {
                sNSCameraPhotoActivity.onCameraNeverAskAgain();
            }
        }
    }

    public static final <VM extends SNSCameraPhotoViewModel> void showExternalStorageWithPermissionCheck(@NotNull SNSCameraPhotoActivity<VM> sNSCameraPhotoActivity) {
        Intrinsics.checkNotNullParameter(sNSCameraPhotoActivity, "$this$showExternalStorageWithPermissionCheck");
        String[] strArr = a;
        if (PermissionUtils.hasSelfPermissions(sNSCameraPhotoActivity, (String[]) Arrays.copyOf(strArr, strArr.length))) {
            sNSCameraPhotoActivity.showExternalStorage();
        } else {
            ActivityCompat.requestPermissions(sNSCameraPhotoActivity, strArr, 0);
        }
    }
}
