package com.avito.android.profile.edit;

import com.avito.android.permissions.Permission;
import com.avito.android.permissions.PermissionHelper;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001B!\u0012\b\b\u0001\u0010!\u001a\u00020\u0011\u0012\u0006\u0010*\u001a\u00020\u000e\u0012\u0006\u0010%\u001a\u00020\"¢\u0006\u0004\b-\u0010.J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bJ\u001d\u0010\f\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u001b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060\u001b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u001dR\u0016\u0010*\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00060\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010\u0019¨\u0006/"}, d2 = {"Lcom/avito/android/profile/edit/PermissionHandlerImpl;", "Lcom/avito/android/profile/edit/PermissionHandler;", "", "checkPermissions", "()V", "requestUnmetPermissions", "", "isGranted", "()Z", "canRequest", "Lkotlin/Function0;", "onCantRequest", "requestPermission", "(Lkotlin/jvm/functions/Function0;)V", "", "requestCode", "", "", "permissions", "", "grantResults", "onPermissionResult", "(I[Ljava/lang/String;[I)V", "Lcom/jakewharton/rxrelay2/PublishRelay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "permissionRelay", "Lio/reactivex/Observable;", "getPermissionChanges", "()Lio/reactivex/Observable;", "permissionChanges", "c", "Ljava/lang/String;", "permission", "Lcom/avito/android/permissions/PermissionHelper;", "e", "Lcom/avito/android/permissions/PermissionHelper;", "permissionsHelper", "getCanRequestPermissionChanges", "canRequestPermissionChanges", "d", "I", "permissionsCode", AuthSource.BOOKING_ORDER, "canRequestPermissionRelay", "<init>", "(Ljava/lang/String;ILcom/avito/android/permissions/PermissionHelper;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public class PermissionHandlerImpl implements PermissionHandler {
    public final PublishRelay<Boolean> a;
    public final PublishRelay<Boolean> b;
    public final String c;
    public final int d;
    public final PermissionHelper e;

    public PermissionHandlerImpl(@Permission @NotNull String str, int i, @NotNull PermissionHelper permissionHelper) {
        Intrinsics.checkNotNullParameter(str, "permission");
        Intrinsics.checkNotNullParameter(permissionHelper, "permissionsHelper");
        this.c = str;
        this.d = i;
        this.e = permissionHelper;
        PublishRelay<Boolean> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.a = create;
        PublishRelay<Boolean> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.b = create2;
    }

    @Override // com.avito.android.profile.edit.PermissionHandler
    public boolean canRequest() {
        return this.e.shouldShowRequestPermissionRationale(this.c);
    }

    @Override // com.avito.android.profile.edit.PermissionHandler
    public void checkPermissions() {
        boolean isGranted = isGranted();
        boolean canRequest = canRequest();
        if (isGranted) {
            this.a.accept(Boolean.valueOf(isGranted));
        } else {
            this.b.accept(Boolean.valueOf(canRequest));
        }
    }

    @Override // com.avito.android.profile.edit.PermissionHandler
    @NotNull
    public Observable<Boolean> getCanRequestPermissionChanges() {
        return this.b;
    }

    @Override // com.avito.android.profile.edit.PermissionHandler
    @NotNull
    public Observable<Boolean> getPermissionChanges() {
        return this.a;
    }

    @Override // com.avito.android.profile.edit.PermissionHandler
    public boolean isGranted() {
        return this.e.checkPermission(this.c);
    }

    @Override // com.avito.android.permissions.PermissionResultHandler
    public void onPermissionResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        if (i == this.d) {
            if (!(strArr.length == 0)) {
                boolean isGranted = isGranted();
                boolean canRequest = canRequest();
                if (isGranted || canRequest) {
                    this.a.accept(Boolean.valueOf(isGranted));
                } else if (!isGranted) {
                    this.b.accept(Boolean.valueOf(canRequest));
                }
            }
        }
    }

    @Override // com.avito.android.profile.edit.PermissionHandler
    public void requestPermission(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onCantRequest");
        if (canRequest()) {
            this.e.requestPermissions(this.d, this.c);
        } else {
            function0.invoke();
        }
    }

    @Override // com.avito.android.profile.edit.PermissionHandler
    public void requestUnmetPermissions() {
        if (!isGranted()) {
            this.e.requestPermissions(this.d, this.c);
        }
    }
}
