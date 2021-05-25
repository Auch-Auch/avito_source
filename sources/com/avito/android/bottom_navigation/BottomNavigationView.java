package com.avito.android.bottom_navigation;

import com.avito.android.bottom_navigation.ui.OnTabClickListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/avito/android/bottom_navigation/BottomNavigationView;", "", "Lcom/avito/android/bottom_navigation/ui/OnTabClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setOnTabClickListener", "(Lcom/avito/android/bottom_navigation/ui/OnTabClickListener;)V", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "tab", "", "count", "setTabBadge", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;I)V", "selectTab", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)V", "Lcom/avito/android/bottom_navigation/AddButtonState;", "state", "setAddButtonState", "(Lcom/avito/android/bottom_navigation/AddButtonState;)V", "", "isVisible", "setVisible", "(Z)V", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
public interface BottomNavigationView {
    void selectTab(@NotNull NavigationTabSetItem navigationTabSetItem);

    void setAddButtonState(@NotNull AddButtonState addButtonState);

    void setOnTabClickListener(@NotNull OnTabClickListener onTabClickListener);

    void setTabBadge(@NotNull NavigationTabSetItem navigationTabSetItem, int i);

    void setVisible(boolean z);
}
