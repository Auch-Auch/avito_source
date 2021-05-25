package com.avito.android.in_app_calls.permissions;

import com.avito.android.calls_shared.AppCallInfo;
import com.avito.android.in_app_calls.permissions.CallPermissionsManager;
import com.avito.android.permissions.PermissionState;
import com.avito.android.permissions.PermissionStateProvider;
import com.avito.android.permissions.PermissionStorage;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/in_app_calls/permissions/CallPermissionsManagerImpl;", "Lcom/avito/android/in_app_calls/permissions/CallPermissionsManager;", "", "", "permissions", "Lcom/avito/android/calls_shared/AppCallInfo;", "callInfo", "Lcom/avito/android/in_app_calls/permissions/CallPermissionsManager$PermissionRequest;", "createPermissionsRequest", "(Ljava/util/List;Lcom/avito/android/calls_shared/AppCallInfo;)Lcom/avito/android/in_app_calls/permissions/CallPermissionsManager$PermissionRequest;", "permission", "Lcom/avito/android/permissions/PermissionState;", "state", "", "updatePermissionState", "(Ljava/lang/String;Lcom/avito/android/permissions/PermissionState;)V", "Lcom/avito/android/permissions/PermissionStateProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/permissions/PermissionStateProvider;", "permissionStateProvider", "Lcom/avito/android/permissions/PermissionStorage;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/permissions/PermissionStorage;", "permissionStorage", "<init>", "(Lcom/avito/android/permissions/PermissionStateProvider;Lcom/avito/android/permissions/PermissionStorage;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallPermissionsManagerImpl implements CallPermissionsManager {
    public final PermissionStateProvider a;
    public final PermissionStorage b;

    @Inject
    public CallPermissionsManagerImpl(@NotNull PermissionStateProvider permissionStateProvider, @NotNull PermissionStorage permissionStorage) {
        Intrinsics.checkNotNullParameter(permissionStateProvider, "permissionStateProvider");
        Intrinsics.checkNotNullParameter(permissionStorage, "permissionStorage");
        this.a = permissionStateProvider;
        this.b = permissionStorage;
    }

    @Override // com.avito.android.in_app_calls.permissions.CallPermissionsManager
    @NotNull
    public CallPermissionsManager.PermissionRequest createPermissionsRequest(@NotNull List<String> list, @Nullable AppCallInfo appCallInfo) {
        Intrinsics.checkNotNullParameter(list, "permissions");
        CallPermissionsManager.PermissionRequest permissionRequest = new CallPermissionsManager.PermissionRequest(list, this.b.getWasMicPermissionAsked(), this.b.getWasMicPermissionForeverDenied(), appCallInfo);
        this.b.setWasMicPermissionAsked(true);
        return permissionRequest;
    }

    @Override // com.avito.android.in_app_calls.permissions.CallPermissionsManager
    public void updatePermissionState(@NotNull String str, @NotNull PermissionState permissionState) {
        Intrinsics.checkNotNullParameter(str, "permission");
        Intrinsics.checkNotNullParameter(permissionState, "state");
        this.a.updatePermissionState(str, permissionState);
    }
}
