package com.avito.android.brandspace.view;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/brandspace/view/FragmentDelegateImpl;", "Lcom/avito/android/brandspace/view/FragmentDelegate;", "Landroidx/fragment/app/FragmentManager;", "childFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "Landroidx/fragment/app/Fragment;", AuthSource.SEND_ABUSE, "Landroidx/fragment/app/Fragment;", "fragment", "<init>", "(Landroidx/fragment/app/Fragment;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class FragmentDelegateImpl implements FragmentDelegate {
    public final Fragment a;

    public FragmentDelegateImpl(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.a = fragment;
    }

    @Override // com.avito.android.brandspace.view.FragmentDelegate
    @NotNull
    public FragmentManager childFragmentManager() {
        FragmentManager childFragmentManager = this.a.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
        return childFragmentManager;
    }
}
