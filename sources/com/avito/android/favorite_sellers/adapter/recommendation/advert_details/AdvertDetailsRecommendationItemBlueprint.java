package com.avito.android.favorite_sellers.adapter.recommendation.advert_details;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.favorite_sellers.AdvertDetailsRecommendationItem;
import com.avito.android.favorite_sellers.adapter.recommendation.ForRecommendation;
import com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenter;
import com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemView;
import com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemViewImpl;
import com.avito.android.favorite_sellers_items.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B%\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\b\b\u0001\u0010\u0017\u001a\u00020\u0014\u0012\b\b\u0001\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001d\u001a\u00020\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/recommendation/advert_details/AdvertDetailsRecommendationItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemView;", "Lcom/avito/android/favorite_sellers/AdvertDetailsRecommendationItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/ItemBinder;", "d", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "c", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemPresenter;", "getPresenter", "()Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemPresenter;", "presenter", "<init>", "(Lcom/avito/android/favorite_sellers/adapter/recommendation/RecommendationItemPresenter;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)V", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsRecommendationItemBlueprint implements ItemBlueprint<RecommendationItemView, AdvertDetailsRecommendationItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<BaseViewHolder> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.advert_details_recommendation_item, new a(this));
    @NotNull
    public final RecommendationItemPresenter b;
    public final AdapterPresenter c;
    public final ItemBinder d;

    public static final class a extends Lambda implements Function2<ViewGroup, View, RecommendationItemViewImpl> {
        public final /* synthetic */ AdvertDetailsRecommendationItemBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AdvertDetailsRecommendationItemBlueprint advertDetailsRecommendationItemBlueprint) {
            super(2);
            this.a = advertDetailsRecommendationItemBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public RecommendationItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new RecommendationItemViewImpl(view2, this.a.c, this.a.d);
        }
    }

    @Inject
    public AdvertDetailsRecommendationItemBlueprint(@NotNull RecommendationItemPresenter recommendationItemPresenter, @ForRecommendation @NotNull AdapterPresenter adapterPresenter, @ForRecommendation @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(recommendationItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        this.b = recommendationItemPresenter;
        this.c = adapterPresenter;
        this.d = itemBinder;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<BaseViewHolder> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof AdvertDetailsRecommendationItem;
    }

    /* Return type fixed from 'com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<RecommendationItemView, AdvertDetailsRecommendationItem> getPresenter() {
        return this.b;
    }
}
