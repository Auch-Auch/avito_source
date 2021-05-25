package com.avito.android.serp.adapter.rich_snippets.regular;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.Features;
import com.avito.android.ab_tests.configs.SerpItemsPrefetchTestGroup;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.advert_xl.AdvertXlItem;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B1\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0019\u001a\u00020\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertXlRichItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertRichItemView;", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/Features;", "d", "Lcom/avito/android/Features;", "features", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertRichItemViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertXlRichItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertXlRichItemPresenter;", "getPresenter", "()Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertXlRichItemPresenter;", "presenter", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "c", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "recycledViewPool", "Lcom/avito/android/ab_tests/configs/SerpItemsPrefetchTestGroup;", "f", "Lcom/avito/android/ab_tests/configs/SerpItemsPrefetchTestGroup;", "prefetchTestGroup", "Lcom/avito/android/serp/adapter/rich_snippets/SellerInfoParamsFactory;", "e", "Lcom/avito/android/serp/adapter/rich_snippets/SellerInfoParamsFactory;", "sellerInfoParamsFactory", "<init>", "(Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertXlRichItemPresenter;Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;Lcom/avito/android/Features;Lcom/avito/android/serp/adapter/rich_snippets/SellerInfoParamsFactory;Lcom/avito/android/ab_tests/configs/SerpItemsPrefetchTestGroup;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertXlRichItemBlueprint implements ItemBlueprint<AdvertRichItemView, AdvertXlItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<AdvertRichItemViewImpl> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.advert_xl_item_rich, new a(this));
    @NotNull
    public final AdvertXlRichItemPresenter b;
    public final RecyclerView.RecycledViewPool c;
    public final Features d;
    public final SellerInfoParamsFactory e;
    public final SerpItemsPrefetchTestGroup f;

    public static final class a extends Lambda implements Function2<ViewGroup, View, AdvertRichItemViewImpl> {
        public final /* synthetic */ AdvertXlRichItemBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AdvertXlRichItemBlueprint advertXlRichItemBlueprint) {
            super(2);
            this.a = advertXlRichItemBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public AdvertRichItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            Resources resources = view2.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
            return new AdvertRichItemViewImpl(view2, new GalleryRatio(resources.getConfiguration().orientation != 2 ? 0.75f : 0.32f, 1.3333334f, 0.0f, 0.0f, 12, null), this.a.c, this.a.d.getStickyBadgesInRichSnippet().invoke().booleanValue(), this.a.e.createVasParams(), this.a.f.isTest());
        }
    }

    @Inject
    public AdvertXlRichItemBlueprint(@NotNull AdvertXlRichItemPresenter advertXlRichItemPresenter, @NotNull RecyclerView.RecycledViewPool recycledViewPool, @NotNull Features features, @NotNull SellerInfoParamsFactory sellerInfoParamsFactory, @NotNull SerpItemsPrefetchTestGroup serpItemsPrefetchTestGroup) {
        Intrinsics.checkNotNullParameter(advertXlRichItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(recycledViewPool, "recycledViewPool");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(sellerInfoParamsFactory, "sellerInfoParamsFactory");
        Intrinsics.checkNotNullParameter(serpItemsPrefetchTestGroup, "prefetchTestGroup");
        this.b = advertXlRichItemPresenter;
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
        return (item instanceof AdvertXlItem) && ((AdvertXlItem) item).getDisplayType().isRich();
    }

    /* Return type fixed from 'com.avito.android.serp.adapter.rich_snippets.regular.AdvertXlRichItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<AdvertRichItemView, AdvertXlItem> getPresenter() {
        return this.b;
    }
}
