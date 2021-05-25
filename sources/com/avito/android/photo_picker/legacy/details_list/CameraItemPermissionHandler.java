package com.avito.android.photo_picker.legacy.details_list;

import com.avito.android.permissions.Permission;
import com.avito.android.permissions.PermissionResultHandler;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\b2\b\b\u0001\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\nJ'\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPermissionHandler;", "Lcom/avito/android/permissions/PermissionResultHandler;", "", "checkPermissions", "()V", "requestUnmetPermissions", "", "permission", "", "isGranted", "(Ljava/lang/String;)Z", "canRequest", "Lkotlin/Function0;", "onCantRequest", "requestPermission", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "Lio/reactivex/Observable;", "getCanRequestCameraPermissionChanges", "()Lio/reactivex/Observable;", "canRequestCameraPermissionChanges", "getStoragePermissionChanges", "storagePermissionChanges", "getCameraPermissionChanges", "cameraPermissionChanges", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface CameraItemPermissionHandler extends PermissionResultHandler {
    boolean canRequest(@Permission @NotNull String str);

    void checkPermissions();

    @NotNull
    Observable<Boolean> getCameraPermissionChanges();

    @NotNull
    Observable<Boolean> getCanRequestCameraPermissionChanges();

    @NotNull
    Observable<Boolean> getStoragePermissionChanges();

    boolean isGranted(@Permission @NotNull String str);

    void requestPermission(@Permission @NotNull String str, @NotNull Function0<Unit> function0);

    void requestUnmetPermissions();
}
