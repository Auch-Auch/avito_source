package com.avito.android.bottom_navigation.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.avito.android.bottom_navigation.NavigationTabSetItem;
import com.avito.android.bottom_navigation.R;
import com.avito.android.bottom_navigation.ui.fragment.factory.Navigable;
import com.avito.android.bottom_navigation.ui.fragment.factory.NavigationState;
import com.avito.android.ui.fragments.OnBackPressedListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!J-\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0018\u0010\u0014J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0011\u0010\u001e\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/avito/android/bottom_navigation/ui/fragment/TabContainerFragmentImpl;", "Lcom/avito/android/bottom_navigation/ui/fragment/TabContainerFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "tab", "", "upNavigation", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)Z", "isBackPressed", "finish", "(Z)Z", "isEmpty", "()Z", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "currentState", "()Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "navigationStateIsAvailable", "Landroidx/fragment/app/Fragment;", "fragment", "", "addFragment", "(Landroidx/fragment/app/Fragment;)V", "getTopFragment", "()Landroidx/fragment/app/Fragment;", "<init>", "()V", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
public final class TabContainerFragmentImpl extends TabContainerFragment {
    @Override // com.avito.android.bottom_navigation.ui.fragment.TabContainerFragment
    public void addFragment(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        getChildFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment, fragment.toString()).addToBackStack(fragment.toString()).commit();
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.TabContainerFragment
    @Nullable
    public NavigationState currentState() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        List<Fragment> fragments = childFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "childFragmentManager.fragments");
        Object lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) fragments);
        if (!(lastOrNull instanceof Navigable)) {
            lastOrNull = null;
        }
        Navigable navigable = (Navigable) lastOrNull;
        if (navigable != null) {
            return navigable.currentState();
        }
        return null;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.TabContainerFragment
    public boolean finish(boolean z) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        List<Fragment> fragments = childFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "childFragmentManager.fragments");
        Fragment fragment = (Fragment) CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) fragments);
        if ((!(fragment instanceof OnBackPressedListener) || !z) ? false : ((OnBackPressedListener) fragment).onBackPressed()) {
            return true;
        }
        FragmentManager childFragmentManager2 = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "childFragmentManager");
        if (childFragmentManager2.getBackStackEntryCount() >= 1) {
            getChildFragmentManager().popBackStack();
        }
        FragmentManager childFragmentManager3 = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager3, "childFragmentManager");
        if (childFragmentManager3.getBackStackEntryCount() > 1) {
            return true;
        }
        FragmentManager childFragmentManager4 = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager4, "childFragmentManager");
        childFragmentManager4.getBackStackEntryCount();
        return false;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.TabContainerFragment
    @Nullable
    public Fragment getTopFragment() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        List<Fragment> fragments = childFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "childFragmentManager.fragments");
        return (Fragment) CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) fragments);
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.TabContainerFragment
    public boolean isEmpty() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        return childFragmentManager.getBackStackEntryCount() == 0;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.TabContainerFragment
    public boolean navigationStateIsAvailable() {
        return isAdded();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.tab_fragment, viewGroup, false);
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.TabContainerFragment
    public boolean upNavigation(@NotNull NavigationTabSetItem navigationTabSetItem) {
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        boolean z = childFragmentManager.getBackStackEntryCount() > 1;
        if (z) {
            FragmentManager childFragmentManager2 = getChildFragmentManager();
            FragmentManager.BackStackEntry backStackEntryAt = getChildFragmentManager().getBackStackEntryAt(0);
            Intrinsics.checkNotNullExpressionValue(backStackEntryAt, "childFragmentManager.getBackStackEntryAt(0)");
            childFragmentManager2.popBackStack(backStackEntryAt.getName(), 0);
            getChildFragmentManager().executePendingTransactions();
        }
        FragmentManager childFragmentManager3 = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager3, "childFragmentManager");
        List<Fragment> fragments = childFragmentManager3.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "childFragmentManager.fragments");
        Fragment fragment = (Fragment) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) fragments);
        if (!(fragment instanceof TabRootFragment) || !((TabRootFragment) fragment).isRoot(navigationTabSetItem)) {
            FragmentManager childFragmentManager4 = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager4, "childFragmentManager");
            if (childFragmentManager4.getBackStackEntryCount() > 0) {
                getChildFragmentManager().popBackStack();
            }
            return false;
        } else if (z || !(fragment instanceof ScrollToUpHandler)) {
            return true;
        } else {
            ((ScrollToUpHandler) fragment).scrollToUp();
            return true;
        }
    }
}
