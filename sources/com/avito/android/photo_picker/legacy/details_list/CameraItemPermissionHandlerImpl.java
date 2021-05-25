package com.avito.android.photo_picker.legacy.details_list;

import com.avito.android.permissions.PermissionHelper;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010*\u001a\u00020'¢\u0006\u0004\b/\u00100J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ%\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\u0004R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u00198V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u00198V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001bR\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001fR\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0\u00198V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001bR\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010,R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\b0\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010\u001f¨\u00061"}, d2 = {"Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPermissionHandlerImpl;", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPermissionHandler;", "", "checkPermissions", "()V", "requestUnmetPermissions", "", "permission", "", "isGranted", "(Ljava/lang/String;)Z", "canRequest", "Lkotlin/Function0;", "onCantRequest", "requestPermission", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "", "requestCode", "", "permissions", "", "grantResults", "onPermissionResult", "(I[Ljava/lang/String;[I)V", AuthSource.SEND_ABUSE, "Lio/reactivex/Observable;", "getStoragePermissionChanges", "()Lio/reactivex/Observable;", "storagePermissionChanges", "Lcom/jakewharton/rxrelay2/PublishRelay;", "d", "Lcom/jakewharton/rxrelay2/PublishRelay;", "canRequestCameraPermissionRelay", "getCanRequestCameraPermissionChanges", "canRequestCameraPermissionChanges", AuthSource.BOOKING_ORDER, "cameraPermissionRelay", "getCameraPermissionChanges", "cameraPermissionChanges", "Lcom/avito/android/permissions/PermissionHelper;", "e", "Lcom/avito/android/permissions/PermissionHelper;", "permissionsHelper", "", "Ljava/util/Set;", "c", "storagePermissionRelay", "<init>", "(Lcom/avito/android/permissions/PermissionHelper;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class CameraItemPermissionHandlerImpl implements CameraItemPermissionHandler {
    public final Set<String> a = y.setOf((Object[]) new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"});
    public final PublishRelay<Boolean> b;
    public final PublishRelay<Boolean> c;
    public final PublishRelay<Boolean> d;
    public final PermissionHelper e;

    public CameraItemPermissionHandlerImpl(@NotNull PermissionHelper permissionHelper) {
        Intrinsics.checkNotNullParameter(permissionHelper, "permissionsHelper");
        this.e = permissionHelper;
        PublishRelay<Boolean> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.b = create;
        PublishRelay<Boolean> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.c = create2;
        PublishRelay<Boolean> create3 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create()");
        this.d = create3;
    }

    public final void a() {
        this.b.accept(Boolean.valueOf(this.e.checkPermission("android.permission.CAMERA")));
        this.c.accept(Boolean.valueOf(this.e.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE")));
        this.d.accept(Boolean.valueOf(canRequest("android.permission.CAMERA")));
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemPermissionHandler
    public boolean canRequest(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "permission");
        return this.e.shouldShowRequestPermissionRationale(str);
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemPermissionHandler
    public void checkPermissions() {
        a();
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemPermissionHandler
    @NotNull
    public Observable<Boolean> getCameraPermissionChanges() {
        Observable<Boolean> distinct = this.b.distinct();
        Intrinsics.checkNotNullExpressionValue(distinct, "cameraPermissionRelay.distinct()");
        return distinct;
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemPermissionHandler
    @NotNull
    public Observable<Boolean> getCanRequestCameraPermissionChanges() {
        Observable<Boolean> distinct = this.d.distinct();
        Intrinsics.checkNotNullExpressionValue(distinct, "canRequestCameraPermissionRelay.distinct()");
        return distinct;
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemPermissionHandler
    @NotNull
    public Observable<Boolean> getStoragePermissionChanges() {
        Observable<Boolean> distinct = this.c.distinct();
        Intrinsics.checkNotNullExpressionValue(distinct, "storagePermissionRelay.distinct()");
        return distinct;
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemPermissionHandler
    public boolean isGranted(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "permission");
        return this.e.checkPermission(str);
    }

    @Override // com.avito.android.permissions.PermissionResultHandler
    public void onPermissionResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        if (i == 103) {
            if (!(strArr.length == 0)) {
                a();
            }
        }
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemPermissionHandler
    public void requestPermission(@NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "permission");
        Intrinsics.checkNotNullParameter(function0, "onCantRequest");
        if (canRequest(str)) {
            this.e.requestPermissions(103, str);
        } else {
            function0.invoke();
        }
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemPermissionHandler
    public void requestUnmetPermissions() {
        Set<String> set = this.a;
        ArrayList arrayList = new ArrayList();
        for (T t : set) {
            if (!isGranted(t)) {
                arrayList.add(t);
            }
        }
        if (!arrayList.isEmpty()) {
            PermissionHelper permissionHelper = this.e;
            Object[] array = arrayList.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            String[] strArr = (String[]) array;
            permissionHelper.requestPermissions(103, (String[]) Arrays.copyOf(strArr, strArr.length));
        }
    }
}
