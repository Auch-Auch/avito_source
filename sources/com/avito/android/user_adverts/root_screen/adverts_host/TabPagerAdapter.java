package com.avito.android.user_adverts.root_screen.adverts_host;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.avito.android.analytics.screens.UserAdvertsScreen;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.user_adverts.tab_screens.UserAdvertsListFragment;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b \u0010!J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R(\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\""}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/TabPagerAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "", VKApiConst.POSITION, "Landroidx/fragment/app/Fragment;", "getItem", "(I)Landroidx/fragment/app/Fragment;", "getCount", "()I", "", "getPageTitle", "(I)Ljava/lang/CharSequence;", "Landroid/view/ViewGroup;", "container", "", "item", "", "setPrimaryItem", "(Landroid/view/ViewGroup;ILjava/lang/Object;)V", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/TabItem;", "k", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "tabs", "<set-?>", "j", "Landroidx/fragment/app/Fragment;", "getPrimaryItem", "()Landroidx/fragment/app/Fragment;", "primaryItem", "Landroidx/fragment/app/FragmentManager;", "fm", "<init>", "(Landroidx/fragment/app/FragmentManager;Lcom/avito/android/ui/adapter/tab/TabsDataProvider;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class TabPagerAdapter extends FragmentStatePagerAdapter {
    @Nullable
    public Fragment j;
    public final TabsDataProvider<TabItem> k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabPagerAdapter(@NotNull FragmentManager fragmentManager, @NotNull TabsDataProvider<TabItem> tabsDataProvider) {
        super(fragmentManager);
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(tabsDataProvider, "tabs");
        this.k = tabsDataProvider;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.k.getCount();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    @NotNull
    public Fragment getItem(int i) {
        return new UserAdvertsListFragment.Factory().create(this.k.getItem(i).getShortcut(), i, UserAdvertsScreen.INSTANCE, true);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Nullable
    public CharSequence getPageTitle(int i) {
        return this.k.getItem(i).getTitle();
    }

    @Nullable
    public final Fragment getPrimaryItem() {
        return this.j;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NotNull ViewGroup viewGroup, int i, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Intrinsics.checkNotNullParameter(obj, "item");
        super.setPrimaryItem(viewGroup, i, obj);
        this.j = (Fragment) obj;
    }
}
