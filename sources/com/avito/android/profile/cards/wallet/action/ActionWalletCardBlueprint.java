package com.avito.android.profile.cards.wallet.action;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0019\u001a\u00020\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/profile/cards/wallet/action/ActionWalletCardBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/profile/cards/wallet/action/ActionWalletCardItemView;", "Lcom/avito/android/profile/cards/CardItem$WalletCardItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/Features;", "c", "Lcom/avito/android/Features;", "features", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/profile/cards/wallet/action/ActionWalletCardItemViewHolder;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/profile/cards/wallet/action/ActionWalletCardItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/profile/cards/wallet/action/ActionWalletCardItemPresenter;", "getPresenter", "()Lcom/avito/android/profile/cards/wallet/action/ActionWalletCardItemPresenter;", "presenter", "<init>", "(Lcom/avito/android/profile/cards/wallet/action/ActionWalletCardItemPresenter;Lcom/avito/android/Features;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class ActionWalletCardBlueprint implements ItemBlueprint<ActionWalletCardItemView, CardItem.WalletCardItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<ActionWalletCardItemViewHolder> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.user_profile_action_wallet_card, new a(this));
    @NotNull
    public final ActionWalletCardItemPresenter b;
    public final Features c;

    public static final class a extends Lambda implements Function2<ViewGroup, View, ActionWalletCardItemViewHolder> {
        public final /* synthetic */ ActionWalletCardBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ActionWalletCardBlueprint actionWalletCardBlueprint) {
            super(2);
            this.a = actionWalletCardBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public ActionWalletCardItemViewHolder invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new ActionWalletCardItemViewHolder(view2, this.a.c);
        }
    }

    public ActionWalletCardBlueprint(@NotNull ActionWalletCardItemPresenter actionWalletCardItemPresenter, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(actionWalletCardItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(features, "features");
        this.b = actionWalletCardItemPresenter;
        this.c = features;
    }

    /* Return type fixed from 'com.avito.android.profile.cards.wallet.action.ActionWalletCardItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<ActionWalletCardItemView, CardItem.WalletCardItem> getPresenter() {
        return this.b;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<ActionWalletCardItemViewHolder> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof CardItem.WalletCardItem;
    }
}
