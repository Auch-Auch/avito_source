package com.avito.android.bottom_navigation.ui.fragment.factory;

import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import com.avito.android.bottom_navigation.NavigationTabControlSetItem;
import com.avito.android.bottom_navigation.NavigationTabProfileRedesignTestSetItem;
import com.avito.android.bottom_navigation.NavigationTabSetItem;
import com.avito.android.bottom_navigation.ui.fragment.TabContainerFragment;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory;", "", "Lcom/avito/android/bottom_navigation/ui/fragment/TabContainerFragment;", "createTabContainer", "()Lcom/avito/android/bottom_navigation/ui/fragment/TabContainerFragment;", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "tab", "Landroidx/fragment/app/Fragment;", "createRootTabFragment", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)Landroidx/fragment/app/Fragment;", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;", "data", "createFragment", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;)Landroidx/fragment/app/Fragment;", "Data", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
public interface TabFragmentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;", "Landroid/os/Parcelable;", "Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "getTabInProfileTest", "()Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "tabInProfileTest", "", "getNeedAuthorization", "()Z", "needAuthorization", "getShowNavigation", "showNavigation", "Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", "getTabInControl", "()Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", "tabInControl", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
    public interface Data extends Parcelable {
        boolean getNeedAuthorization();

        boolean getShowNavigation();

        @Nullable
        NavigationTabControlSetItem getTabInControl();

        @Nullable
        NavigationTabProfileRedesignTestSetItem getTabInProfileTest();
    }

    @NotNull
    Fragment createFragment(@NotNull Data data);

    @NotNull
    Fragment createRootTabFragment(@NotNull NavigationTabSetItem navigationTabSetItem);

    @NotNull
    TabContainerFragment createTabContainer();
}
