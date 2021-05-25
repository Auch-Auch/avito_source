package com.avito.android.bottom_navigation.ui.fragment;

import a2.g.r.g;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.avito.android.bottom_navigation.AddButtonState;
import com.avito.android.bottom_navigation.BottomNavigationTestGroup;
import com.avito.android.bottom_navigation.NavigationTabSet;
import com.avito.android.bottom_navigation.NavigationTabSetItem;
import com.avito.android.bottom_navigation.ui.fragment.factory.NavigationState;
import com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.fragments.ResultFragmentData;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B?\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u0010'\u001a\u00020\t\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010:\u001a\u000209\u0012\u0006\u0010;\u001a\u00020!¢\u0006\u0004\b<\u0010=J!\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020!0 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001d0 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010#R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u0006>"}, d2 = {"Lcom/avito/android/bottom_navigation/ui/fragment/TabFragmentManagerImpl;", "Lcom/avito/android/bottom_navigation/ui/fragment/TabFragmentManager;", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "newTab", "previousTab", "", "changeTab", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)V", "tab", "", "isBackPressed", "finish", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;Z)Z", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;", "data", "currentTab", "Lcom/avito/android/ui/fragments/ResultFragmentData;", "resultData", "openData", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;Lcom/avito/android/bottom_navigation/NavigationTabSetItem;Lcom/avito/android/ui/fragments/ResultFragmentData;)V", "upNavigationTab", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)V", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "currentState", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "navigationStateIsAvailable", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)Z", "isEnable", "()Z", "Lcom/avito/android/bottom_navigation/ui/fragment/TabContainerFragment;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)Lcom/avito/android/bottom_navigation/ui/fragment/TabContainerFragment;", "", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "tabViewContainers", "f", "Z", "useFragmentNotAddedCondition", "tabs", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory;", "d", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory;", "tabFragmentFactory", "Lcom/avito/android/bottom_navigation/BottomNavigationTestGroup;", g.a, "Lcom/avito/android/bottom_navigation/BottomNavigationTestGroup;", "userAdvertsTabTestGroup", "Landroidx/fragment/app/FragmentManager;", "e", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/avito/android/bottom_navigation/NavigationTabSet;", "c", "Lcom/avito/android/bottom_navigation/NavigationTabSet;", "navigationTabSet", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "lifecycleCallbacks", "container", "<init>", "(Lcom/avito/android/bottom_navigation/NavigationTabSet;Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory;Landroidx/fragment/app/FragmentManager;ZLcom/avito/android/bottom_navigation/BottomNavigationTestGroup;Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;Landroid/view/View;)V", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
public final class TabFragmentManagerImpl implements TabFragmentManager {
    public final Map<NavigationTabSetItem, TabContainerFragment> a = new LinkedHashMap();
    public final Map<NavigationTabSetItem, View> b = new LinkedHashMap();
    public final NavigationTabSet c;
    public final TabFragmentFactory d;
    public final FragmentManager e;
    public final boolean f;
    public final BottomNavigationTestGroup g;

    /* JADX DEBUG: Multi-variable search result rejected for r5v5, resolved type: java.util.Map<com.avito.android.bottom_navigation.NavigationTabSetItem, com.avito.android.bottom_navigation.ui.fragment.TabContainerFragment> */
    /* JADX WARN: Multi-variable type inference failed */
    public TabFragmentManagerImpl(@NotNull NavigationTabSet navigationTabSet, @NotNull TabFragmentFactory tabFragmentFactory, @NotNull FragmentManager fragmentManager, boolean z, @NotNull BottomNavigationTestGroup bottomNavigationTestGroup, @NotNull FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, @NotNull View view) {
        Intrinsics.checkNotNullParameter(navigationTabSet, "navigationTabSet");
        Intrinsics.checkNotNullParameter(tabFragmentFactory, "tabFragmentFactory");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(bottomNavigationTestGroup, "userAdvertsTabTestGroup");
        Intrinsics.checkNotNullParameter(fragmentLifecycleCallbacks, "lifecycleCallbacks");
        Intrinsics.checkNotNullParameter(view, "container");
        this.c = navigationTabSet;
        this.d = tabFragmentFactory;
        this.e = fragmentManager;
        this.f = z;
        this.g = bottomNavigationTestGroup;
        Iterator it = navigationTabSet.iterator();
        while (it.hasNext()) {
            NavigationTabSetItem navigationTabSetItem = (NavigationTabSetItem) it.next();
            Fragment findFragmentByTag = this.e.findFragmentByTag(navigationTabSetItem.getName());
            if (findFragmentByTag instanceof TabContainerFragment) {
                Map<NavigationTabSetItem, TabContainerFragment> map = this.a;
                Intrinsics.checkNotNullExpressionValue(navigationTabSetItem, "tab");
                map.put(navigationTabSetItem, findFragmentByTag);
            }
            Map<NavigationTabSetItem, View> map2 = this.b;
            Intrinsics.checkNotNullExpressionValue(navigationTabSetItem, "tab");
            View findViewById = view.findViewById(navigationTabSetItem.getTabContainerId());
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
            map2.put(navigationTabSetItem, findViewById);
        }
        this.e.registerFragmentLifecycleCallbacks(fragmentLifecycleCallbacks, true);
    }

    public final TabContainerFragment a(NavigationTabSetItem navigationTabSetItem, NavigationTabSetItem navigationTabSetItem2) {
        int i;
        TabContainerFragment tabContainerFragment = this.a.get(navigationTabSetItem);
        if (tabContainerFragment == null) {
            tabContainerFragment = this.d.createTabContainer();
        }
        if ((!Intrinsics.areEqual(tabContainerFragment, this.a.put(navigationTabSetItem, tabContainerFragment))) && ((this.f && !tabContainerFragment.isAdded()) || !this.f)) {
            FragmentTransaction beginTransaction = this.e.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "fragmentManager.beginTransaction()");
            beginTransaction.add(navigationTabSetItem.getTabContainerId(), tabContainerFragment, navigationTabSetItem.getName());
            beginTransaction.addToBackStack(navigationTabSetItem.getName());
            beginTransaction.commit();
        }
        FragmentTransaction beginTransaction2 = this.e.beginTransaction();
        for (Map.Entry<NavigationTabSetItem, TabContainerFragment> entry : this.a.entrySet()) {
            beginTransaction2.setMaxLifecycle(entry.getValue(), Intrinsics.areEqual(entry.getKey(), navigationTabSetItem) ? Lifecycle.State.RESUMED : Lifecycle.State.STARTED);
        }
        beginTransaction2.commit();
        this.e.executePendingTransactions();
        if (navigationTabSetItem.getAddButtonState() == AddButtonState.ACTIVE) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                NavigationTabSetItem navigationTabSetItem3 = (NavigationTabSetItem) it.next();
                View view = this.b.get(navigationTabSetItem3);
                if (view != null) {
                    if (!Intrinsics.areEqual(navigationTabSetItem3, navigationTabSetItem)) {
                        if (!Intrinsics.areEqual(navigationTabSetItem3.getName(), navigationTabSetItem2 != null ? navigationTabSetItem2.getName() : null)) {
                            i = 8;
                            view.setVisibility(i);
                        }
                    }
                    i = 0;
                    view.setVisibility(i);
                }
            }
        } else {
            Iterator it2 = this.c.iterator();
            while (it2.hasNext()) {
                NavigationTabSetItem navigationTabSetItem4 = (NavigationTabSetItem) it2.next();
                View view2 = this.b.get(navigationTabSetItem4);
                if (view2 != null) {
                    view2.setVisibility(Intrinsics.areEqual(navigationTabSetItem4, navigationTabSetItem) ? 0 : 8);
                }
            }
        }
        return tabContainerFragment;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.TabFragmentManager
    public void changeTab(@NotNull NavigationTabSetItem navigationTabSetItem, @Nullable NavigationTabSetItem navigationTabSetItem2) {
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "newTab");
        TabContainerFragment a3 = a(navigationTabSetItem, navigationTabSetItem2);
        if (a3.isEmpty()) {
            a3.addFragment(this.d.createRootTabFragment(navigationTabSetItem));
        }
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.TabFragmentManager
    @Nullable
    public NavigationState currentState(@NotNull NavigationTabSetItem navigationTabSetItem) {
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        TabContainerFragment tabContainerFragment = this.a.get(navigationTabSetItem);
        if (tabContainerFragment != null) {
            return tabContainerFragment.currentState();
        }
        return null;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.TabFragmentManager
    public boolean finish(@NotNull NavigationTabSetItem navigationTabSetItem, boolean z) {
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        TabContainerFragment tabContainerFragment = this.a.get(navigationTabSetItem);
        if (tabContainerFragment != null) {
            return tabContainerFragment.finish(z);
        }
        return false;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.TabFragmentManager
    public boolean isEnable() {
        return !this.e.isStateSaved();
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.TabFragmentManager
    public boolean navigationStateIsAvailable(@NotNull NavigationTabSetItem navigationTabSetItem) {
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        TabContainerFragment tabContainerFragment = this.a.get(navigationTabSetItem);
        if (tabContainerFragment != null) {
            return tabContainerFragment.navigationStateIsAvailable();
        }
        return false;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.TabFragmentManager
    public void openData(@NotNull TabFragmentFactory.Data data, @Nullable NavigationTabSetItem navigationTabSetItem, @Nullable ResultFragmentData resultFragmentData) {
        NavigationTabSetItem navigationTabSetItem2;
        TabContainerFragment tabContainerFragment;
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.g.isTest()) {
            navigationTabSetItem2 = data.getTabInProfileTest();
        } else {
            navigationTabSetItem2 = data.getTabInControl();
        }
        if (navigationTabSetItem2 != null) {
            if (!Intrinsics.areEqual(navigationTabSetItem2, navigationTabSetItem)) {
                tabContainerFragment = a(navigationTabSetItem2, null);
            } else {
                TabContainerFragment tabContainerFragment2 = this.a.get(navigationTabSetItem2);
                Intrinsics.checkNotNull(tabContainerFragment2);
                tabContainerFragment = tabContainerFragment2;
            }
            Fragment topFragment = tabContainerFragment.getTopFragment();
            boolean z = false;
            if (topFragment instanceof UpdatableTabFragment) {
                z = ((UpdatableTabFragment) topFragment).updateWithNewData(data);
            }
            if (!z) {
                Fragment createFragment = this.d.createFragment(data);
                if (resultFragmentData != null) {
                    Objects.requireNonNull(createFragment, "null cannot be cast to non-null type com.avito.android.bottom_navigation.ui.fragment.ResultDispatcher");
                    ((ResultDispatcher) createFragment).setTargetFragment(resultFragmentData);
                }
                tabContainerFragment.addFragment(createFragment);
            }
        }
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.TabFragmentManager
    public void upNavigationTab(@Nullable NavigationTabSetItem navigationTabSetItem) {
        if (navigationTabSetItem != null) {
            TabContainerFragment tabContainerFragment = this.a.get(navigationTabSetItem);
            if (!(tabContainerFragment != null ? tabContainerFragment.upNavigation(navigationTabSetItem) : false)) {
                a(navigationTabSetItem, null).addFragment(this.d.createRootTabFragment(navigationTabSetItem));
            }
        }
    }
}
