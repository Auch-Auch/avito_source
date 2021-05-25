package com.avito.android.user_favorites;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.avito.android.bottom_navigation.ui.fragment.ScrollToUpHandler;
import com.avito.android.deprecated_design.R;
import com.avito.android.design.widget.tab.TabPagerAdapter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.SafeViewPager;
import com.avito.android.ui.adapter.tab.TabAdapter;
import com.avito.android.util.TabLayoutsKt;
import com.google.android.material.tabs.TabLayout;
import com.jakewharton.rxbinding4.appcompat.RxToolbar;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010$\u001a\u00020#\u0012\u000e\u0010\u001a\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b%\u0010&J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0007R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u001a\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006'"}, d2 = {"Lcom/avito/android/user_favorites/UserFavoritesViewImpl;", "Lcom/avito/android/user_favorites/UserFavoritesView;", "Lio/reactivex/rxjava3/core/Observable;", "", "navigationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "notifyTabsChanged", "()V", "notifyTabCountersChanged", "", VKApiConst.POSITION, "setTabPosition", "(I)V", "pageChanges", "scrollToTop", "Lcom/avito/android/ui/SafeViewPager;", "c", "Lcom/avito/android/ui/SafeViewPager;", "viewPager", "Landroidx/appcompat/widget/Toolbar;", AuthSource.SEND_ABUSE, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lcom/avito/android/ui/adapter/tab/TabAdapter;", "d", "Lcom/avito/android/ui/adapter/tab/TabAdapter;", "tabsAdapter", "Lcom/avito/android/design/widget/tab/TabPagerAdapter;", "e", "Lcom/avito/android/design/widget/tab/TabPagerAdapter;", "pagerAdapter", "Lcom/google/android/material/tabs/TabLayout;", AuthSource.BOOKING_ORDER, "Lcom/google/android/material/tabs/TabLayout;", "tabLayout", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/ui/adapter/tab/TabAdapter;Lcom/avito/android/design/widget/tab/TabPagerAdapter;)V", "user-favorites_release"}, k = 1, mv = {1, 4, 2})
public final class UserFavoritesViewImpl implements UserFavoritesView {
    public final Toolbar a;
    public final TabLayout b;
    public final SafeViewPager c;
    public final TabAdapter<?, ?> d;
    public final TabPagerAdapter e;

    public UserFavoritesViewImpl(@NotNull View view, @NotNull TabAdapter<?, ?> tabAdapter, @NotNull TabPagerAdapter tabPagerAdapter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(tabAdapter, "tabsAdapter");
        Intrinsics.checkNotNullParameter(tabPagerAdapter, "pagerAdapter");
        this.d = tabAdapter;
        this.e = tabPagerAdapter;
        View findViewById = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        this.a = (Toolbar) findViewById;
        View findViewById2 = view.findViewById(R.id.tabs);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.google.android.material.tabs.TabLayout");
        TabLayout tabLayout = (TabLayout) findViewById2;
        this.b = tabLayout;
        View findViewById3 = view.findViewById(R.id.view_pager);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.ui.SafeViewPager");
        SafeViewPager safeViewPager = (SafeViewPager) findViewById3;
        this.c = safeViewPager;
        safeViewPager.setPagingEnabled(false);
        safeViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayout.ViewPagerOnTabSelectedListener(safeViewPager));
        TabLayoutsKt.setAdapter(tabLayout, tabAdapter);
        safeViewPager.setAdapter(tabPagerAdapter);
    }

    @Override // com.avito.android.user_favorites.UserFavoritesView
    @NotNull
    public Observable<Unit> navigationClicks() {
        return RxToolbar.navigationClicks(this.a);
    }

    @Override // com.avito.android.user_favorites.UserFavoritesView
    public void notifyTabCountersChanged() {
        this.d.notifyDataSetChanged();
    }

    @Override // com.avito.android.user_favorites.UserFavoritesView
    public void notifyTabsChanged() {
        notifyTabCountersChanged();
        this.e.notifyDataSetChanged();
    }

    @Override // com.avito.android.user_favorites.UserFavoritesView
    @NotNull
    public Observable<Integer> pageChanges() {
        Observable<Integer> create = Observable.create(new UserFavoritesViewImpl$pageChanges$1(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…)\n            }\n        }");
        return create;
    }

    @Override // com.avito.android.user_favorites.UserFavoritesView
    public void scrollToTop() {
        Fragment primaryItem = this.e.getPrimaryItem();
        if (!(primaryItem instanceof ScrollToUpHandler)) {
            primaryItem = null;
        }
        ScrollToUpHandler scrollToUpHandler = (ScrollToUpHandler) primaryItem;
        if (scrollToUpHandler != null) {
            scrollToUpHandler.scrollToUp();
        }
    }

    @Override // com.avito.android.user_favorites.UserFavoritesView
    public void setTabPosition(int i) {
        this.c.setCurrentItem(i);
    }
}
