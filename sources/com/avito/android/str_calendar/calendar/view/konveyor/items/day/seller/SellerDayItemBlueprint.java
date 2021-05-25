package com.avito.android.str_calendar.calendar.view.konveyor.items.day.seller;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.str_calendar.R;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B#\u0012\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0014\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R(\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/SellerDayItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/SellerDayItemView;", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/SellerDayItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/SellerDayItemBackgroundsProvider;", "c", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/SellerDayItemBackgroundsProvider;", "backgroundsProvider", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/SellerDayItemViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/konveyor/blueprint/ItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/konveyor/blueprint/ItemPresenter;", "getPresenter", "()Lcom/avito/konveyor/blueprint/ItemPresenter;", "presenter", "<init>", "(Lcom/avito/konveyor/blueprint/ItemPresenter;Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/SellerDayItemBackgroundsProvider;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class SellerDayItemBlueprint implements ItemBlueprint<SellerDayItemView, SellerDayItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<SellerDayItemViewImpl> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.seller_calendar_day_item, new a(this));
    @NotNull
    public final ItemPresenter<SellerDayItemView, SellerDayItem> b;
    public final SellerDayItemBackgroundsProvider c;

    public static final class a extends Lambda implements Function2<ViewGroup, View, SellerDayItemViewImpl> {
        public final /* synthetic */ SellerDayItemBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SellerDayItemBlueprint sellerDayItemBlueprint) {
            super(2);
            this.a = sellerDayItemBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public SellerDayItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new SellerDayItemViewImpl(view2, this.a.c);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.avito.konveyor.blueprint.ItemPresenter<? super com.avito.android.str_calendar.calendar.view.konveyor.items.day.seller.SellerDayItemView, ? super com.avito.android.str_calendar.calendar.view.konveyor.items.day.seller.SellerDayItem> */
    /* JADX WARN: Multi-variable type inference failed */
    public SellerDayItemBlueprint(@NotNull ItemPresenter<? super SellerDayItemView, ? super SellerDayItem> itemPresenter, @NotNull SellerDayItemBackgroundsProvider sellerDayItemBackgroundsProvider) {
        Intrinsics.checkNotNullParameter(itemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(sellerDayItemBackgroundsProvider, "backgroundsProvider");
        this.b = itemPresenter;
        this.c = sellerDayItemBackgroundsProvider;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<SellerDayItemView, SellerDayItem> getPresenter() {
        return this.b;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<SellerDayItemViewImpl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof SellerDayItem;
    }
}
