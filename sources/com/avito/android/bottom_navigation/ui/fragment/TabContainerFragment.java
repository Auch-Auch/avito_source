package com.avito.android.bottom_navigation.ui.fragment;

import androidx.fragment.app.Fragment;
import com.avito.android.bottom_navigation.NavigationTabSetItem;
import com.avito.android.bottom_navigation.ui.fragment.factory.NavigationState;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u0001H&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0001H&¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/avito/android/bottom_navigation/ui/fragment/TabContainerFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "tab", "", "upNavigation", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)Z", "isBackPressed", "finish", "(Z)Z", "isEmpty", "()Z", "getTopFragment", "()Landroidx/fragment/app/Fragment;", "fragment", "", "addFragment", "(Landroidx/fragment/app/Fragment;)V", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "currentState", "()Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "navigationStateIsAvailable", "<init>", "()V", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
public abstract class TabContainerFragment extends Fragment {
    public abstract void addFragment(@NotNull Fragment fragment);

    @Nullable
    public abstract NavigationState currentState();

    public abstract boolean finish(boolean z);

    @Nullable
    public abstract Fragment getTopFragment();

    public abstract boolean isEmpty();

    public abstract boolean navigationStateIsAvailable();

    public abstract boolean upNavigation(@NotNull NavigationTabSetItem navigationTabSetItem);
}
