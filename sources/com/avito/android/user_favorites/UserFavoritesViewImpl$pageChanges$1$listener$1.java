package com.avito.android.user_favorites;

import com.avito.android.ui.adapter.tab.SimpleOnTabSelectedListener;
import com.google.android.material.tabs.TabLayout;
import io.reactivex.rxjava3.core.ObservableEmitter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/avito/android/user_favorites/UserFavoritesViewImpl$pageChanges$1$listener$1", "Lcom/avito/android/ui/adapter/tab/SimpleOnTabSelectedListener;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tab", "", "onTabSelected", "(Lcom/google/android/material/tabs/TabLayout$Tab;)V", "user-favorites_release"}, k = 1, mv = {1, 4, 2})
public final class UserFavoritesViewImpl$pageChanges$1$listener$1 extends SimpleOnTabSelectedListener {
    public final /* synthetic */ ObservableEmitter a;

    public UserFavoritesViewImpl$pageChanges$1$listener$1(ObservableEmitter observableEmitter) {
        this.a = observableEmitter;
    }

    @Override // com.avito.android.ui.adapter.tab.SimpleOnTabSelectedListener, com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(@NotNull TabLayout.Tab tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        super.onTabSelected(tab);
        this.a.onNext(Integer.valueOf(tab.getPosition()));
    }
}
