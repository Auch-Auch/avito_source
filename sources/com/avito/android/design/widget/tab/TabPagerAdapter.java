package com.avito.android.design.widget.tab;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.vk.sdk.api.VKApiConst;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001)B?\u0012\u0006\u0010$\u001a\u00020#\u0012\u000e\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0019\u0012\u0014\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u00140\u0013\u0012\b\b\u0002\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u00140\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR(\u0010\"\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0006@BX\u000e¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006*"}, d2 = {"Lcom/avito/android/design/widget/tab/TabPagerAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "", VKApiConst.POSITION, "Landroidx/fragment/app/Fragment;", "getItem", "(I)Landroidx/fragment/app/Fragment;", "getCount", "()I", "", "getPageTitle", "(I)Ljava/lang/CharSequence;", "Landroid/view/ViewGroup;", "container", "", "item", "", "setPrimaryItem", "(Landroid/view/ViewGroup;ILjava/lang/Object;)V", "", "Lcom/avito/android/design/widget/tab/TabBlueprint;", "Lcom/avito/android/design/widget/tab/Tab;", "l", "Ljava/util/Set;", "blueprints", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "k", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "tabs", "<set-?>", "j", "Landroidx/fragment/app/Fragment;", "getPrimaryItem", "()Landroidx/fragment/app/Fragment;", "primaryItem", "Landroidx/fragment/app/FragmentManager;", "fm", "Lcom/avito/android/design/widget/tab/TabPagerAdapter$Behaviour;", "behaviour", "<init>", "(Landroidx/fragment/app/FragmentManager;Lcom/avito/android/ui/adapter/tab/TabsDataProvider;Ljava/util/Set;Lcom/avito/android/design/widget/tab/TabPagerAdapter$Behaviour;)V", "Behaviour", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class TabPagerAdapter extends FragmentStatePagerAdapter {
    @Nullable
    public Fragment j;
    public final TabsDataProvider<? extends Tab> k;
    public final Set<TabBlueprint<? extends Tab>> l;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/design/widget/tab/TabPagerAdapter$Behaviour;", "", "", AuthSource.SEND_ABUSE, "I", "getValue", "()I", "value", "<init>", "(Ljava/lang/String;II)V", "SET_USER_VISIBLE_HINT", "RESUME_ONLY_CURRENT_FRAGMENT", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public enum Behaviour {
        SET_USER_VISIBLE_HINT(0),
        RESUME_ONLY_CURRENT_FRAGMENT(1);
        
        public final int a;

        /* access modifiers changed from: public */
        Behaviour(int i) {
            this.a = i;
        }

        public final int getValue() {
            return this.a;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TabPagerAdapter(FragmentManager fragmentManager, TabsDataProvider tabsDataProvider, Set set, Behaviour behaviour, int i, j jVar) {
        this(fragmentManager, tabsDataProvider, set, (i & 8) != 0 ? Behaviour.SET_USER_VISIBLE_HINT : behaviour);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.k.getCount();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    @NotNull
    public Fragment getItem(int i) {
        Fragment fragment;
        T t;
        Tab tab = (Tab) this.k.getItem(i);
        Iterator<T> it = this.l.iterator();
        while (true) {
            fragment = null;
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t.isRelevantItem(tab)) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            fragment = t2.createFragment(tab);
        }
        Intrinsics.checkNotNull(fragment);
        return fragment;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Nullable
    public CharSequence getPageTitle(int i) {
        return ((Tab) this.k.getItem(i)).getTitle();
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
        if (!(obj instanceof Fragment)) {
            obj = null;
        }
        Fragment fragment = (Fragment) obj;
        this.j = fragment;
        if (fragment != null) {
            fragment.setMenuVisibility(true);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Set<? extends com.avito.android.design.widget.tab.TabBlueprint<? extends com.avito.android.design.widget.tab.Tab>> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabPagerAdapter(@NotNull FragmentManager fragmentManager, @NotNull TabsDataProvider<? extends Tab> tabsDataProvider, @NotNull Set<? extends TabBlueprint<? extends Tab>> set, @NotNull Behaviour behaviour) {
        super(fragmentManager, behaviour.getValue());
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(tabsDataProvider, "tabs");
        Intrinsics.checkNotNullParameter(set, "blueprints");
        Intrinsics.checkNotNullParameter(behaviour, "behaviour");
        this.k = tabsDataProvider;
        this.l = set;
    }
}
