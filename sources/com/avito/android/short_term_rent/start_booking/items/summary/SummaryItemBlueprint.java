package com.avito.android.short_term_rent.start_booking.items.summary;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.short_term_rent.R;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001b\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR(\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/short_term_rent/start_booking/items/summary/SummaryItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/short_term_rent/start_booking/items/summary/SummaryItemView;", "Lcom/avito/android/short_term_rent/start_booking/items/summary/SummaryItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/blueprint/ItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/konveyor/blueprint/ItemPresenter;", "getPresenter", "()Lcom/avito/konveyor/blueprint/ItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/short_term_rent/start_booking/items/summary/SummaryItemViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "<init>", "(Lcom/avito/konveyor/blueprint/ItemPresenter;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class SummaryItemBlueprint implements ItemBlueprint<SummaryItemView, SummaryItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<SummaryItemViewImpl> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.start_booking_summary_item, a.a);
    @NotNull
    public final ItemPresenter<SummaryItemView, SummaryItem> b;

    public static final class a extends Lambda implements Function2<ViewGroup, View, SummaryItemViewImpl> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public SummaryItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new SummaryItemViewImpl(view2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.konveyor.blueprint.ItemPresenter<? super com.avito.android.short_term_rent.start_booking.items.summary.SummaryItemView, ? super com.avito.android.short_term_rent.start_booking.items.summary.SummaryItem> */
    /* JADX WARN: Multi-variable type inference failed */
    public SummaryItemBlueprint(@NotNull ItemPresenter<? super SummaryItemView, ? super SummaryItem> itemPresenter) {
        Intrinsics.checkNotNullParameter(itemPresenter, "presenter");
        this.b = itemPresenter;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<SummaryItemView, SummaryItem> getPresenter() {
        return this.b;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<SummaryItemViewImpl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof SummaryItem;
    }
}
