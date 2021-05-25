package com.avito.android.advert.item.contactbar;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0015\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/avito/android/advert/item/contactbar/AdvertDetailsContactBarBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/advert/item/contactbar/AdvertDetailsContactBarView;", "Lcom/avito/android/advert/item/contactbar/AdvertDetailsContactBarItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/advert/item/contactbar/AdvertDetailsContactBarViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/advert/item/contactbar/AdvertDetailsContactBarPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert/item/contactbar/AdvertDetailsContactBarPresenter;", "getPresenter", "()Lcom/avito/android/advert/item/contactbar/AdvertDetailsContactBarPresenter;", "presenter", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/advert/item/contactbar/AdvertDetailsContactBarPresenter;Lcom/avito/android/Features;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsContactBarBlueprint implements ItemBlueprint<AdvertDetailsContactBarView, AdvertDetailsContactBarItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<AdvertDetailsContactBarViewImpl> a;
    @NotNull
    public final AdvertDetailsContactBarPresenter b;

    public static final class a extends Lambda implements Function2<ViewGroup, View, AdvertDetailsContactBarViewImpl> {
        public final /* synthetic */ Features a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Features features) {
            super(2);
            this.a = features;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public AdvertDetailsContactBarViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new AdvertDetailsContactBarViewImpl(view2, this.a);
        }
    }

    @Inject
    public AdvertDetailsContactBarBlueprint(@NotNull AdvertDetailsContactBarPresenter advertDetailsContactBarPresenter, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(advertDetailsContactBarPresenter, "presenter");
        Intrinsics.checkNotNullParameter(features, "features");
        this.b = advertDetailsContactBarPresenter;
        this.a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.advert_details_contact_bar, new a(features));
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<AdvertDetailsContactBarViewImpl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof AdvertDetailsContactBarItem;
    }

    /* Return type fixed from 'com.avito.android.advert.item.contactbar.AdvertDetailsContactBarPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<AdvertDetailsContactBarView, AdvertDetailsContactBarItem> getPresenter() {
        return this.b;
    }
}
