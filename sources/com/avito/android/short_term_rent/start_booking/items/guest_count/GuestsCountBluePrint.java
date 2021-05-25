package com.avito.android.short_term_rent.start_booking.items.guest_count;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.short_term_rent.R;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import dagger.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B)\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000e\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR(\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/short_term_rent/start_booking/items/guest_count/GuestsCountBluePrint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/short_term_rent/start_booking/items/guest_count/GuestsCountItemView;", "Lcom/avito/android/short_term_rent/start_booking/items/guest_count/GuestsCountItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/konveyor/blueprint/ItemPresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ItemPresenter;", "getPresenter", "()Lcom/avito/konveyor/blueprint/ItemPresenter;", "presenter", "Ldagger/Lazy;", "Lcom/avito/android/short_term_rent/start_booking/items/guest_count/GuestsCountsProvider;", AuthSource.BOOKING_ORDER, "Ldagger/Lazy;", GeoContract.PROVIDER, "<init>", "(Lcom/avito/konveyor/blueprint/ItemPresenter;Ldagger/Lazy;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class GuestsCountBluePrint implements ItemBlueprint<GuestsCountItemView, GuestsCountItem> {
    @NotNull
    public final ItemPresenter<GuestsCountItemView, GuestsCountItem> a;
    public final Lazy<GuestsCountsProvider> b;

    public static final class a extends Lambda implements Function2<ViewGroup, View, GuestsCountItemViewHolder> {
        public final /* synthetic */ GuestsCountBluePrint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(GuestsCountBluePrint guestsCountBluePrint) {
            super(2);
            this.a = guestsCountBluePrint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public GuestsCountItemViewHolder invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new GuestsCountItemViewHolder(view2, ((GuestsCountsProvider) this.a.b.get()).guestsCounts());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.avito.konveyor.blueprint.ItemPresenter<? super com.avito.android.short_term_rent.start_booking.items.guest_count.GuestsCountItemView, ? super com.avito.android.short_term_rent.start_booking.items.guest_count.GuestsCountItem> */
    /* JADX WARN: Multi-variable type inference failed */
    public GuestsCountBluePrint(@NotNull ItemPresenter<? super GuestsCountItemView, ? super GuestsCountItem> itemPresenter, @NotNull Lazy<GuestsCountsProvider> lazy) {
        Intrinsics.checkNotNullParameter(itemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(lazy, GeoContract.PROVIDER);
        this.a = itemPresenter;
        this.b = lazy;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<GuestsCountItemView, GuestsCountItem> getPresenter() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<BaseViewHolder> getViewHolderProvider() {
        return new ViewHolderBuilder.ViewHolderProvider<>(R.layout.start_booking_guests_count_item, new a(this));
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof GuestsCountItem;
    }
}
