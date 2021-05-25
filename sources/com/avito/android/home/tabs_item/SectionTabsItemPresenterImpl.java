package com.avito.android.home.tabs_item;

import com.avito.android.home.SectionTabsViewPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.HomeTabItem;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/home/tabs_item/SectionTabsItemPresenterImpl;", "Lcom/avito/android/home/tabs_item/SectionTabsItemPresenter;", "Lcom/avito/android/home/tabs_item/SectionTabsItemView;", "view", "Lcom/avito/android/home/tabs_item/SectionTabsItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/home/tabs_item/SectionTabsItemView;Lcom/avito/android/home/tabs_item/SectionTabsItem;I)V", "Lcom/avito/android/home/SectionTabsViewPresenter;", "presenter", "setSectionTabsPresenter", "(Lcom/avito/android/home/SectionTabsViewPresenter;)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/home/SectionTabsViewPresenter;", "<init>", "()V", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class SectionTabsItemPresenterImpl implements SectionTabsItemPresenter {
    public SectionTabsViewPresenter a;

    public static final class a implements TabItem {
        public final long a;
        @NotNull
        public final String b;
        @Nullable
        public final String c;
        @Nullable
        public final String d;
        public final HomeTabItem e;

        public a(@NotNull HomeTabItem homeTabItem) {
            Intrinsics.checkNotNullParameter(homeTabItem, "item");
            this.e = homeTabItem;
            this.a = (long) homeTabItem.getFeedId().hashCode();
            this.b = homeTabItem.getTitle();
            HomeTabItem.Tooltip tooltip = homeTabItem.getTooltip();
            String str = null;
            this.c = tooltip != null ? tooltip.getTitle() : null;
            HomeTabItem.Tooltip tooltip2 = homeTabItem.getTooltip();
            this.d = tooltip2 != null ? tooltip2.getId() : str;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof a) && Intrinsics.areEqual(this.e, ((a) obj).e);
            }
            return true;
        }

        @Override // com.avito.android.home.tabs_item.TabItem
        public long getId() {
            return this.a;
        }

        @Override // com.avito.android.home.tabs_item.TabItem
        @NotNull
        public String getTitle() {
            return this.b;
        }

        @Override // com.avito.android.home.tabs_item.TabItem
        @Nullable
        public String getTooltip() {
            return this.c;
        }

        @Override // com.avito.android.home.tabs_item.TabItem
        @Nullable
        public String getTooltipId() {
            return this.d;
        }

        public int hashCode() {
            HomeTabItem homeTabItem = this.e;
            if (homeTabItem != null) {
                return homeTabItem.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("SerpSectionTabItem(item=");
            L.append(this.e);
            L.append(")");
            return L.toString();
        }
    }

    public static final class b extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ SectionTabsItemPresenterImpl a;
        public final /* synthetic */ SectionTabsItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SectionTabsItemPresenterImpl sectionTabsItemPresenterImpl, SectionTabsItem sectionTabsItem) {
            super(1);
            this.a = sectionTabsItemPresenterImpl;
            this.b = sectionTabsItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            SectionTabsItemPresenterImpl.access$getPresenter$p(this.a).onTabSelectionChanged(this.b.getTabs().get(num.intValue()));
            return Unit.INSTANCE;
        }
    }

    public static final /* synthetic */ SectionTabsViewPresenter access$getPresenter$p(SectionTabsItemPresenterImpl sectionTabsItemPresenterImpl) {
        SectionTabsViewPresenter sectionTabsViewPresenter = sectionTabsItemPresenterImpl.a;
        if (sectionTabsViewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return sectionTabsViewPresenter;
    }

    @Override // com.avito.android.home.tabs_item.SectionTabsItemPresenter
    public void setSectionTabsPresenter(@NotNull SectionTabsViewPresenter sectionTabsViewPresenter) {
        Intrinsics.checkNotNullParameter(sectionTabsViewPresenter, "presenter");
        this.a = sectionTabsViewPresenter;
    }

    public void bindView(@NotNull SectionTabsItemView sectionTabsItemView, @NotNull SectionTabsItem sectionTabsItem, int i) {
        Intrinsics.checkNotNullParameter(sectionTabsItemView, "view");
        Intrinsics.checkNotNullParameter(sectionTabsItem, "item");
        List<HomeTabItem> tabs = sectionTabsItem.getTabs();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(tabs, 10));
        Iterator<T> it = tabs.iterator();
        while (it.hasNext()) {
            arrayList.add(new a(it.next()));
        }
        sectionTabsItemView.setItems(arrayList);
        Iterator<HomeTabItem> it2 = sectionTabsItem.getTabs().iterator();
        int i2 = 0;
        while (true) {
            if (!it2.hasNext()) {
                i2 = -1;
                break;
            } else if (Intrinsics.areEqual(it2.next().getFeedId(), sectionTabsItem.getSelectedId())) {
                break;
            } else {
                i2++;
            }
        }
        sectionTabsItemView.setSelectedPosition(i2, false);
        sectionTabsItemView.setSelectedItemListener(new b(this, sectionTabsItem));
    }
}
