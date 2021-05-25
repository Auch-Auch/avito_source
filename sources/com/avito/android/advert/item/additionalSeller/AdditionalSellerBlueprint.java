package com.avito.android.advert.item.additionalSeller;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.advert.item.additionalSeller.AdditionalSellerView;
import com.avito.android.advert_details.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\u0012\u001a\u00020\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/advert/item/additionalSeller/AdditionalSellerBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/advert/item/additionalSeller/AdditionalSellerView;", "Lcom/avito/android/advert/item/additionalSeller/AdditionalSellerItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/advert/item/additionalSeller/AdditionalSellerView$Listener;", "c", "Lcom/avito/android/advert/item/additionalSeller/AdditionalSellerView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/advert/item/additionalSeller/AdditionalSellerPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert/item/additionalSeller/AdditionalSellerPresenter;", "getPresenter", "()Lcom/avito/android/advert/item/additionalSeller/AdditionalSellerPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/advert/item/additionalSeller/AdditionalSellerViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "<init>", "(Lcom/avito/android/advert/item/additionalSeller/AdditionalSellerPresenter;Lcom/avito/android/advert/item/additionalSeller/AdditionalSellerView$Listener;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdditionalSellerBlueprint implements ItemBlueprint<AdditionalSellerView, AdditionalSellerItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<AdditionalSellerViewImpl> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.advert_details_additional_seller, new a(this));
    @NotNull
    public final AdditionalSellerPresenter b;
    public final AdditionalSellerView.Listener c;

    public static final class a extends Lambda implements Function2<ViewGroup, View, AdditionalSellerViewImpl> {
        public final /* synthetic */ AdditionalSellerBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AdditionalSellerBlueprint additionalSellerBlueprint) {
            super(2);
            this.a = additionalSellerBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public AdditionalSellerViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new AdditionalSellerViewImpl(view2, this.a.c);
        }
    }

    @Inject
    public AdditionalSellerBlueprint(@NotNull AdditionalSellerPresenter additionalSellerPresenter, @NotNull AdditionalSellerView.Listener listener) {
        Intrinsics.checkNotNullParameter(additionalSellerPresenter, "presenter");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.b = additionalSellerPresenter;
        this.c = listener;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<AdditionalSellerViewImpl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof AdditionalSellerItem;
    }

    /* Return type fixed from 'com.avito.android.advert.item.additionalSeller.AdditionalSellerPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<AdditionalSellerView, AdditionalSellerItem> getPresenter() {
        return this.b;
    }
}
