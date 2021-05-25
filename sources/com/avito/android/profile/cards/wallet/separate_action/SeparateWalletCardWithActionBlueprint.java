package com.avito.android.profile.cards.wallet.separate_action;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.Features;
import com.avito.android.profile.R;
import com.avito.android.profile.cards.CardItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\u0012\u001a\u00020\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/profile/cards/wallet/separate_action/SeparateWalletCardWithActionBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/profile/cards/wallet/separate_action/SeparateWalletCardWithActionItemView;", "Lcom/avito/android/profile/cards/CardItem$SeparateWalletCardItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/Features;", "c", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/profile/cards/wallet/separate_action/SeparateWalletCardWithActionItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/profile/cards/wallet/separate_action/SeparateWalletCardWithActionItemPresenter;", "getPresenter", "()Lcom/avito/android/profile/cards/wallet/separate_action/SeparateWalletCardWithActionItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/profile/cards/wallet/separate_action/SeparateWalletCardWithActionItemViewHolder;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "<init>", "(Lcom/avito/android/profile/cards/wallet/separate_action/SeparateWalletCardWithActionItemPresenter;Lcom/avito/android/Features;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class SeparateWalletCardWithActionBlueprint implements ItemBlueprint<SeparateWalletCardWithActionItemView, CardItem.SeparateWalletCardItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<SeparateWalletCardWithActionItemViewHolder> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.user_profile_separate_wallet_action_card, new a(this));
    @NotNull
    public final SeparateWalletCardWithActionItemPresenter b;
    public final Features c;

    public static final class a extends Lambda implements Function2<ViewGroup, View, SeparateWalletCardWithActionItemViewHolder> {
        public final /* synthetic */ SeparateWalletCardWithActionBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SeparateWalletCardWithActionBlueprint separateWalletCardWithActionBlueprint) {
            super(2);
            this.a = separateWalletCardWithActionBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public SeparateWalletCardWithActionItemViewHolder invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new SeparateWalletCardWithActionItemViewHolder(view2, this.a.c);
        }
    }

    public SeparateWalletCardWithActionBlueprint(@NotNull SeparateWalletCardWithActionItemPresenter separateWalletCardWithActionItemPresenter, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(separateWalletCardWithActionItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(features, "features");
        this.b = separateWalletCardWithActionItemPresenter;
        this.c = features;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<SeparateWalletCardWithActionItemViewHolder> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof CardItem.SeparateWalletCardItem;
    }

    /* Return type fixed from 'com.avito.android.profile.cards.wallet.separate_action.SeparateWalletCardWithActionItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<SeparateWalletCardWithActionItemView, CardItem.SeparateWalletCardItem> getPresenter() {
        return this.b;
    }
}
