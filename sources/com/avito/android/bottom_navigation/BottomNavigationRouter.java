package com.avito.android.bottom_navigation;

import com.avito.android.authorization.event.SocialButtonClickedEventKt;
import com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0005\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/bottom_navigation/BottomNavigationRouter;", "", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "tab", "", SocialButtonClickedEventKt.AUTH, "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)V", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;", "data", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;)V", "finishScreen", "()V", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
public interface BottomNavigationRouter {
    void auth(@NotNull NavigationTabSetItem navigationTabSetItem);

    void auth(@NotNull TabFragmentFactory.Data data);

    void finishScreen();
}
