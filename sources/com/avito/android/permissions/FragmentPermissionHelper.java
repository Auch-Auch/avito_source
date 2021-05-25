package com.avito.android.permissions;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ0\u0010\u0011\u001a\u00020\f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0001\u0010\u000b\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0011\u001a\u00020\f2\b\b\u0001\u0010\u000b\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/permissions/FragmentPermissionHelper;", "Lcom/avito/android/permissions/PermissionHelper;", "Lcom/avito/android/permissions/PermissionChecker;", "", "requestCode", "", "", "permissions", "", "requestPermissions", "(I[Ljava/lang/String;)V", "permission", "", "shouldShowRequestPermissionRationale", "(Ljava/lang/String;)Z", "", "grantResults", "checkPermission", "([Ljava/lang/String;[ILjava/lang/String;)Z", "Landroidx/fragment/app/Fragment;", AuthSource.SEND_ABUSE, "Landroidx/fragment/app/Fragment;", "fragment", "<init>", "(Landroidx/fragment/app/Fragment;)V", "permissions_release"}, k = 1, mv = {1, 4, 2})
public final class FragmentPermissionHelper implements PermissionHelper, PermissionChecker {
    public final Fragment a;
    public final /* synthetic */ PermissionCheckerImpl b;

    @Inject
    public FragmentPermissionHelper(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Context requireContext = fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "fragment.requireContext()");
        this.b = new PermissionCheckerImpl(requireContext);
        this.a = fragment;
    }

    @Override // com.avito.android.permissions.PermissionChecker
    public boolean checkPermission(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "permission");
        return this.b.checkPermission(str);
    }

    @Override // com.avito.android.permissions.PermissionChecker
    public boolean checkPermission(@NotNull String[] strArr, @NotNull int[] iArr, @NotNull String str) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        Intrinsics.checkNotNullParameter(str, "permission");
        return this.b.checkPermission(strArr, iArr, str);
    }

    @Override // com.avito.android.permissions.PermissionHelper
    public void requestPermissions(int i, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        if (this.a.isAdded()) {
            this.a.requestPermissions(strArr, i);
        }
    }

    @Override // com.avito.android.permissions.PermissionHelper
    public boolean shouldShowRequestPermissionRationale(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "permission");
        return this.a.shouldShowRequestPermissionRationale(str);
    }
}
