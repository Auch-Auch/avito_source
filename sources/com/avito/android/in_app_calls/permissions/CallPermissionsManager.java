package com.avito.android.in_app_calls.permissions;

import a2.b.a.a.a;
import com.avito.android.calls_shared.AppCallInfo;
import com.avito.android.permissions.PermissionState;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0010J'\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/in_app_calls/permissions/CallPermissionsManager;", "", "", "", "permissions", "Lcom/avito/android/calls_shared/AppCallInfo;", "callInfo", "Lcom/avito/android/in_app_calls/permissions/CallPermissionsManager$PermissionRequest;", "createPermissionsRequest", "(Ljava/util/List;Lcom/avito/android/calls_shared/AppCallInfo;)Lcom/avito/android/in_app_calls/permissions/CallPermissionsManager$PermissionRequest;", "permission", "Lcom/avito/android/permissions/PermissionState;", "state", "", "updatePermissionState", "(Ljava/lang/String;Lcom/avito/android/permissions/PermissionState;)V", "PermissionRequest", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public interface CallPermissionsManager {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001B/\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b&\u0010'J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ@\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\fR\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0005R\u0019\u0010\u000f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\bR\u0019\u0010\u000e\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\"\u001a\u0004\b%\u0010\b¨\u0006("}, d2 = {"Lcom/avito/android/in_app_calls/permissions/CallPermissionsManager$PermissionRequest;", "", "", "", "component1", "()Ljava/util/List;", "", "component2", "()Z", "component3", "Lcom/avito/android/calls_shared/AppCallInfo;", "component4", "()Lcom/avito/android/calls_shared/AppCallInfo;", "permissions", "needClarification", "needShowSettings", "callInfo", "copy", "(Ljava/util/List;ZZLcom/avito/android/calls_shared/AppCallInfo;)Lcom/avito/android/in_app_calls/permissions/CallPermissionsManager$PermissionRequest;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "d", "Lcom/avito/android/calls_shared/AppCallInfo;", "getCallInfo", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getPermissions", "c", "Z", "getNeedShowSettings", AuthSource.BOOKING_ORDER, "getNeedClarification", "<init>", "(Ljava/util/List;ZZLcom/avito/android/calls_shared/AppCallInfo;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    public static final class PermissionRequest {
        @NotNull
        public final List<String> a;
        public final boolean b;
        public final boolean c;
        @Nullable
        public final AppCallInfo d;

        public PermissionRequest(@NotNull List<String> list, boolean z, boolean z2, @Nullable AppCallInfo appCallInfo) {
            Intrinsics.checkNotNullParameter(list, "permissions");
            this.a = list;
            this.b = z;
            this.c = z2;
            this.d = appCallInfo;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.in_app_calls.permissions.CallPermissionsManager$PermissionRequest */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PermissionRequest copy$default(PermissionRequest permissionRequest, List list, boolean z, boolean z2, AppCallInfo appCallInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                list = permissionRequest.a;
            }
            if ((i & 2) != 0) {
                z = permissionRequest.b;
            }
            if ((i & 4) != 0) {
                z2 = permissionRequest.c;
            }
            if ((i & 8) != 0) {
                appCallInfo = permissionRequest.d;
            }
            return permissionRequest.copy(list, z, z2, appCallInfo);
        }

        @NotNull
        public final List<String> component1() {
            return this.a;
        }

        public final boolean component2() {
            return this.b;
        }

        public final boolean component3() {
            return this.c;
        }

        @Nullable
        public final AppCallInfo component4() {
            return this.d;
        }

        @NotNull
        public final PermissionRequest copy(@NotNull List<String> list, boolean z, boolean z2, @Nullable AppCallInfo appCallInfo) {
            Intrinsics.checkNotNullParameter(list, "permissions");
            return new PermissionRequest(list, z, z2, appCallInfo);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PermissionRequest)) {
                return false;
            }
            PermissionRequest permissionRequest = (PermissionRequest) obj;
            return Intrinsics.areEqual(this.a, permissionRequest.a) && this.b == permissionRequest.b && this.c == permissionRequest.c && Intrinsics.areEqual(this.d, permissionRequest.d);
        }

        @Nullable
        public final AppCallInfo getCallInfo() {
            return this.d;
        }

        public final boolean getNeedClarification() {
            return this.b;
        }

        public final boolean getNeedShowSettings() {
            return this.c;
        }

        @NotNull
        public final List<String> getPermissions() {
            return this.a;
        }

        public int hashCode() {
            List<String> list = this.a;
            int i = 0;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            boolean z = this.b;
            int i2 = 1;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = (hashCode + i3) * 31;
            boolean z2 = this.c;
            if (!z2) {
                i2 = z2 ? 1 : 0;
            }
            int i7 = (i6 + i2) * 31;
            AppCallInfo appCallInfo = this.d;
            if (appCallInfo != null) {
                i = appCallInfo.hashCode();
            }
            return i7 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("PermissionRequest(permissions=");
            L.append(this.a);
            L.append(", needClarification=");
            L.append(this.b);
            L.append(", needShowSettings=");
            L.append(this.c);
            L.append(", callInfo=");
            L.append(this.d);
            L.append(")");
            return L.toString();
        }
    }

    @NotNull
    PermissionRequest createPermissionsRequest(@NotNull List<String> list, @Nullable AppCallInfo appCallInfo);

    void updatePermissionState(@NotNull String str, @NotNull PermissionState permissionState);
}
