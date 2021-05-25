package com.avito.android.publish_limits_info.history;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.avito.android.publish_limits_info.history.tab.HistoryTabItem;
import com.avito.android.publish_limits_info.history.tab.PublishAdvertsHistoryFragment;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/publish_limits_info/history/TabPagerAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "", VKApiConst.POSITION, "Landroidx/fragment/app/Fragment;", "getItem", "(I)Landroidx/fragment/app/Fragment;", "getCount", "()I", "", "getPageTitle", "(I)Ljava/lang/CharSequence;", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "Lcom/avito/android/publish_limits_info/history/tab/HistoryTabItem;", "j", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "tabs", "Landroidx/fragment/app/FragmentManager;", "fm", "<init>", "(Landroidx/fragment/app/FragmentManager;Lcom/avito/android/ui/adapter/tab/TabsDataProvider;)V", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
public final class TabPagerAdapter extends FragmentStatePagerAdapter {
    public final TabsDataProvider<HistoryTabItem> j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabPagerAdapter(@NotNull FragmentManager fragmentManager, @NotNull TabsDataProvider<HistoryTabItem> tabsDataProvider) {
        super(fragmentManager);
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(tabsDataProvider, "tabs");
        this.j = tabsDataProvider;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.j.getCount();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    @NotNull
    public Fragment getItem(int i) {
        return PublishAdvertsHistoryFragment.Companion.create(this.j.getItem(i).getShortcut());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NotNull
    public CharSequence getPageTitle(int i) {
        return this.j.getItem(i).getTitle();
    }
}
