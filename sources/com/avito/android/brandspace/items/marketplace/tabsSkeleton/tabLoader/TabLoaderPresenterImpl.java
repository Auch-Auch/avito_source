package com.avito.android.brandspace.items.marketplace.tabsSkeleton.tabLoader;

import com.avito.android.brandspace.items.marketplace.carouselLoader.CarouselLoaderItemView;
import com.avito.android.brandspace.items.marketplace.tabsSkeleton.TabSkeletonItem;
import com.avito.android.brandspace.presenter.BrandspaceResourcesProvider;
import com.avito.android.brandspace.presenter.virtualitems.TabsLoader;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0012\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR#\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/brandspace/items/marketplace/tabsSkeleton/tabLoader/TabLoaderPresenterImpl;", "Lcom/avito/android/brandspace/items/marketplace/tabsSkeleton/tabLoader/TabLoaderPresenter;", "", "getMinimalCountOfTabSkeleton", "()I", "Lcom/avito/android/brandspace/items/marketplace/carouselLoader/CarouselLoaderItemView;", "view", "Lcom/avito/android/brandspace/presenter/virtualitems/TabsLoader;", "item", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/brandspace/items/marketplace/carouselLoader/CarouselLoaderItemView;Lcom/avito/android/brandspace/presenter/virtualitems/TabsLoader;I)V", "Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;", "c", "Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;", "brandspaceResourcesProvider", "", "Lcom/avito/android/brandspace/items/marketplace/tabsSkeleton/TabSkeletonItem;", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "getSkeletonList", "()Ljava/util/List;", "skeletonList", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/items/marketplace/tabsSkeleton/TabSkeletonItem;", "skeletonItem", "<init>", "(Lcom/avito/android/brandspace/items/marketplace/tabsSkeleton/TabSkeletonItem;Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class TabLoaderPresenterImpl implements TabLoaderPresenter {
    public final Lazy a = c.lazy(new a(this));
    public final TabSkeletonItem b;
    public final BrandspaceResourcesProvider c;

    public static final class a extends Lambda implements Function0<List<? extends TabSkeletonItem>> {
        public final /* synthetic */ TabLoaderPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(TabLoaderPresenterImpl tabLoaderPresenterImpl) {
            super(0);
            this.a = tabLoaderPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public List<? extends TabSkeletonItem> invoke() {
            int minimalCountOfTabSkeleton = this.a.getMinimalCountOfTabSkeleton() + 1;
            ArrayList arrayList = new ArrayList(minimalCountOfTabSkeleton);
            for (int i = 0; i < minimalCountOfTabSkeleton; i++) {
                arrayList.add(this.a.b);
            }
            return arrayList;
        }
    }

    @Inject
    public TabLoaderPresenterImpl(@NotNull TabSkeletonItem tabSkeletonItem, @NotNull BrandspaceResourcesProvider brandspaceResourcesProvider) {
        Intrinsics.checkNotNullParameter(tabSkeletonItem, "skeletonItem");
        Intrinsics.checkNotNullParameter(brandspaceResourcesProvider, "brandspaceResourcesProvider");
        this.b = tabSkeletonItem;
        this.c = brandspaceResourcesProvider;
    }

    public void bindView(@NotNull CarouselLoaderItemView carouselLoaderItemView, @NotNull TabsLoader tabsLoader, int i) {
        Intrinsics.checkNotNullParameter(carouselLoaderItemView, "view");
        Intrinsics.checkNotNullParameter(tabsLoader, "item");
        carouselLoaderItemView.bindHorizontal((List) this.a.getValue());
    }

    @Override // com.avito.android.brandspace.items.marketplace.tabsSkeleton.tabLoader.TabLoaderPresenter
    public int getMinimalCountOfTabSkeleton() {
        return this.c.getBrandspaceColumnCount() * 2;
    }
}
