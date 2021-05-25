package com.avito.android.user_stats.tab;

import android.os.Parcelable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0013\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/avito/android/user_stats/tab/UserStatsPagerAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "", VKApiConst.POSITION, "Lcom/avito/android/user_stats/tab/UserStatsTabFragment;", "getItem", "(I)Lcom/avito/android/user_stats/tab/UserStatsTabFragment;", "getCount", "()I", "", "getPageTitle", "(I)Ljava/lang/CharSequence;", "Landroid/os/Parcelable;", "saveState", "()Landroid/os/Parcelable;", "state", "Ljava/lang/ClassLoader;", "loader", "", "restoreState", "(Landroid/os/Parcelable;Ljava/lang/ClassLoader;)V", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "Lcom/avito/android/user_stats/tab/UserStatsTabItem;", "j", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "tabsDataProvider", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "<init>", "(Landroidx/fragment/app/FragmentManager;Lcom/avito/android/ui/adapter/tab/TabsDataProvider;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class UserStatsPagerAdapter extends FragmentStatePagerAdapter {
    public final TabsDataProvider<UserStatsTabItem> j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserStatsPagerAdapter(@NotNull FragmentManager fragmentManager, @NotNull TabsDataProvider<UserStatsTabItem> tabsDataProvider) {
        super(fragmentManager, 1);
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(tabsDataProvider, "tabsDataProvider");
        this.j = tabsDataProvider;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.j.getCount();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NotNull
    public CharSequence getPageTitle(int i) {
        return this.j.getItem(i).getTitle();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void restoreState(@Nullable Parcelable parcelable, @Nullable ClassLoader classLoader) {
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    @Nullable
    public Parcelable saveState() {
        return null;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    @NotNull
    public UserStatsTabFragment getItem(int i) {
        return UserStatsTabFragmentKt.createUserStatsTabFragment(this.j.getItem(i).getShortcut());
    }
}
