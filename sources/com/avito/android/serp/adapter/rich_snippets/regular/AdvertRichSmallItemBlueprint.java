package com.avito.android.serp.adapter.rich_snippets.regular;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.Features;
import com.avito.android.ab_tests.configs.SerpItemsPrefetchTestGroup;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.AdvertItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.serp.adapter.rich_snippets.SellerInfoParamsFactory;
import com.avito.android.ui_components.R;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.serp.cyclic_gallery.image_carousel.GalleryRatio;
import ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.SellerInfoParams;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B1\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u001a\u001a\u00020\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertRichSmallItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertRichItemView;", "Lcom/avito/android/serp/adapter/AdvertItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/Features;", "d", "Lcom/avito/android/Features;", "features", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "c", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "recycledViewPool", "Lcom/avito/android/ab_tests/configs/SerpItemsPrefetchTestGroup;", "f", "Lcom/avito/android/ab_tests/configs/SerpItemsPrefetchTestGroup;", "prefetchTestGroup", "Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertRichItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertRichItemPresenter;", "getPresenter", "()Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertRichItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertRichItemViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/serp/adapter/rich_snippets/SellerInfoParamsFactory;", "e", "Lcom/avito/android/serp/adapter/rich_snippets/SellerInfoParamsFactory;", "sellerInfoParamsFactory", "<init>", "(Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertRichItemPresenter;Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;Lcom/avito/android/Features;Lcom/avito/android/serp/adapter/rich_snippets/SellerInfoParamsFactory;Lcom/avito/android/ab_tests/configs/SerpItemsPrefetchTestGroup;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertRichSmallItemBlueprint implements ItemBlueprint<AdvertRichItemView, AdvertItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<AdvertRichItemViewImpl> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.advert_item_rich, new a(this));
    @NotNull
    public final AdvertRichItemPresenter b;
    public final RecyclerView.RecycledViewPool c;
    public final Features d;
    public final SellerInfoParamsFactory e;
    public final SerpItemsPrefetchTestGroup f;

    public static final class a extends Lambda implements Function2<ViewGroup, View, AdvertRichItemViewImpl> {
        public final /* synthetic */ AdvertRichSmallItemBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AdvertRichSmallItemBlueprint advertRichSmallItemBlueprint) {
            super(2);
            this.a = advertRichSmallItemBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public AdvertRichItemViewImpl invoke(ViewGroup viewGroup, View view) {
            SellerInfoParams sellerInfoParams;
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            Resources resources = view2.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
            float f = resources.getConfiguration().orientation != 2 ? 1.3333334f : 0.6666667f;
            Resources resources2 = view2.getResources();
            Intrinsics.checkNotNullExpressionValue(resources2, "view.resources");
            float f2 = resources2.getConfiguration().orientation != 2 ? 1.7142857f : 1.0370371f;
            Resources resources3 = view2.getResources();
            Intrinsics.checkNotNullExpressionValue(resources3, "view.resources");
            if (resources3.getConfiguration().orientation != 2) {
                sellerInfoParams = this.a.e.createSmallParams();
            } else {
                sellerInfoParams = this.a.e.createRegularParams();
            }
            return new AdvertRichItemViewImpl(view2, new GalleryRatio(0.32f, 1.3333334f, f, f2), this.a.c, this.a.d.getStickyBadgesInRichSnippet().invoke().booleanValue(), sellerInfoParams, this.a.f.isTest());
        }
    }

    @Inject
    public AdvertRichSmallItemBlueprint(@NotNull AdvertRichItemPresenter advertRichItemPresenter, @NotNull RecyclerView.RecycledViewPool recycledViewPool, @NotNull Features features, @NotNull SellerInfoParamsFactory sellerInfoParamsFactory, @NotNull SerpItemsPrefetchTestGroup serpItemsPrefetchTestGroup) {
        Intrinsics.checkNotNullParameter(advertRichItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(recycledViewPool, "recycledViewPool");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(sellerInfoParamsFactory, "sellerInfoParamsFactory");
        Intrinsics.checkNotNullParameter(serpItemsPrefetchTestGroup, "prefetchTestGroup");
        this.b = advertRichItemPresenter;
        this.c = recycledViewPool;
        this.d = features;
        this.e = sellerInfoParamsFactory;
        this.f = serpItemsPrefetchTestGroup;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<AdvertRichItemViewImpl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item instanceof AdvertItem) {
            AdvertItem advertItem = (AdvertItem) item;
            if (advertItem.getViewType() == SerpViewType.LIST && advertItem.getDisplayType().isRich()) {
                return true;
            }
        }
        return false;
    }

    /* Return type fixed from 'com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<AdvertRichItemView, AdvertItem> getPresenter() {
        return this.b;
    }
}
