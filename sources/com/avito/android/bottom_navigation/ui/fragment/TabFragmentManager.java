package com.avito.android.bottom_navigation.ui.fragment;

import com.avito.android.bottom_navigation.NavigationTabSetItem;
import com.avito.android.bottom_navigation.ui.fragment.factory.NavigationState;
import com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory;
import com.avito.android.ui.fragments.ResultFragmentData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\tH&¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/avito/android/bottom_navigation/ui/fragment/TabFragmentManager;", "", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "newTab", "previousTab", "", "changeTab", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)V", "tab", "", "isBackPressed", "finish", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;Z)Z", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;", "data", "currentTab", "Lcom/avito/android/ui/fragments/ResultFragmentData;", "resultData", "openData", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;Lcom/avito/android/bottom_navigation/NavigationTabSetItem;Lcom/avito/android/ui/fragments/ResultFragmentData;)V", "upNavigationTab", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)V", "isEnable", "()Z", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "currentState", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "navigationStateIsAvailable", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)Z", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
public interface TabFragmentManager {
    void changeTab(@NotNull NavigationTabSetItem navigationTabSetItem, @Nullable NavigationTabSetItem navigationTabSetItem2);

    @Nullable
    NavigationState currentState(@NotNull NavigationTabSetItem navigationTabSetItem);

    boolean finish(@NotNull NavigationTabSetItem navigationTabSetItem, boolean z);

    boolean isEnable();

    boolean navigationStateIsAvailable(@NotNull NavigationTabSetItem navigationTabSetItem);

    void openData(@NotNull TabFragmentFactory.Data data, @Nullable NavigationTabSetItem navigationTabSetItem, @Nullable ResultFragmentData resultFragmentData);

    void upNavigationTab(@Nullable NavigationTabSetItem navigationTabSetItem);
}
