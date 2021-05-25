package com.avito.android.advert.item.marketplace_delivery;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.Features;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithNone;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.advert_details.R;
import com.avito.android.remote.auth.AuthSource;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR \u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001c"}, d2 = {"Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryView;", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryPresenter;", "getPresenter", "()Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroupWithNone;", "marketplaceDeliveryItemTestGroup", "<init>", "(Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryPresenter;Lcom/avito/android/Features;Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceDeliveryBlueprint implements ItemBlueprint<MarketplaceDeliveryView, MarketplaceDeliveryItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<?> a;
    @NotNull
    public final MarketplaceDeliveryPresenter b;

    public static final class a extends Lambda implements Function2<ViewGroup, View, MarketplaceDeliveryViewAbExpImpl> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public MarketplaceDeliveryViewAbExpImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new MarketplaceDeliveryViewAbExpImpl(view2);
        }
    }

    public static final class b extends Lambda implements Function2<ViewGroup, View, MarketplaceDeliveryViewImpl> {
        public static final b a = new b();

        public b() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public MarketplaceDeliveryViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new MarketplaceDeliveryViewImpl(view2);
        }
    }

    @Inject
    public MarketplaceDeliveryBlueprint(@NotNull MarketplaceDeliveryPresenter marketplaceDeliveryPresenter, @NotNull Features features, @NotNull ManuallyExposedAbTestGroup<SimpleTestGroupWithNone> manuallyExposedAbTestGroup) {
        ViewHolderBuilder.ViewHolderProvider<?> viewHolderProvider;
        Intrinsics.checkNotNullParameter(marketplaceDeliveryPresenter, "presenter");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(manuallyExposedAbTestGroup, "marketplaceDeliveryItemTestGroup");
        this.b = marketplaceDeliveryPresenter;
        if (!features.getMarketplaceDeliveryItem().invoke().booleanValue() || !manuallyExposedAbTestGroup.getTestGroup().isTest()) {
            viewHolderProvider = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.marketplace_delivery, b.a);
        } else {
            viewHolderProvider = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.marketplace_delivery_ab_exp, a.a);
        }
        this.a = viewHolderProvider;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<?> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof MarketplaceDeliveryItem;
    }

    /* Return type fixed from 'com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<MarketplaceDeliveryView, MarketplaceDeliveryItem> getPresenter() {
        return this.b;
    }
}
