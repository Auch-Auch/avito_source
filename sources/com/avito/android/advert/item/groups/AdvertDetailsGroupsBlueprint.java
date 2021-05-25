package com.avito.android.advert.item.groups;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.advert_core.advert.AdvertDetailsGroupsListener;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/advert/item/groups/AdvertDetailsGroupsBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/advert/item/groups/RdsAdvertDetailsGroupsView;", "Lcom/avito/android/advert/item/groups/AdvertDetailsGroupsItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/advert/item/groups/AdvertDetailsGroupsPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert/item/groups/AdvertDetailsGroupsPresenter;", "getPresenter", "()Lcom/avito/android/advert/item/groups/AdvertDetailsGroupsPresenter;", "presenter", "Lcom/avito/android/advert_core/advert/AdvertDetailsGroupsListener;", "c", "Lcom/avito/android/advert_core/advert/AdvertDetailsGroupsListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/advert/item/groups/RdsAdvertDetailsGroupsViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "<init>", "(Lcom/avito/android/advert/item/groups/AdvertDetailsGroupsPresenter;Lcom/avito/android/advert_core/advert/AdvertDetailsGroupsListener;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsGroupsBlueprint implements ItemBlueprint<RdsAdvertDetailsGroupsView, AdvertDetailsGroupsItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<RdsAdvertDetailsGroupsViewImpl> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.advert_details_groups, new a(this));
    @NotNull
    public final AdvertDetailsGroupsPresenter b;
    public final AdvertDetailsGroupsListener c;

    public static final class a extends Lambda implements Function2<ViewGroup, View, RdsAdvertDetailsGroupsViewImpl> {
        public final /* synthetic */ AdvertDetailsGroupsBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AdvertDetailsGroupsBlueprint advertDetailsGroupsBlueprint) {
            super(2);
            this.a = advertDetailsGroupsBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public RdsAdvertDetailsGroupsViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new RdsAdvertDetailsGroupsViewImpl(view2, this.a.c);
        }
    }

    @Inject
    public AdvertDetailsGroupsBlueprint(@NotNull AdvertDetailsGroupsPresenter advertDetailsGroupsPresenter, @NotNull AdvertDetailsGroupsListener advertDetailsGroupsListener) {
        Intrinsics.checkNotNullParameter(advertDetailsGroupsPresenter, "presenter");
        Intrinsics.checkNotNullParameter(advertDetailsGroupsListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.b = advertDetailsGroupsPresenter;
        this.c = advertDetailsGroupsListener;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<RdsAdvertDetailsGroupsViewImpl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof AdvertDetailsGroupsItem;
    }

    /* Return type fixed from 'com.avito.android.advert.item.groups.AdvertDetailsGroupsPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<RdsAdvertDetailsGroupsView, AdvertDetailsGroupsItem> getPresenter() {
        return this.b;
    }
}
