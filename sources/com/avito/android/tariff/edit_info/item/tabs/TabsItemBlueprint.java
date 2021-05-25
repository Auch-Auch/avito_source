package com.avito.android.tariff.edit_info.item.tabs;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.R;
import com.avito.android.util.text.AttributedTextFormatter;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001b\u001a\u00020\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/tabs/TabsItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/tariff/edit_info/item/tabs/TabsItemView;", "Lcom/avito/android/tariff/edit_info/item/tabs/TabsItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/util/text/AttributedTextFormatter;", "c", "Lcom/avito/android/util/text/AttributedTextFormatter;", "getAttributedTextFormatter", "()Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/tariff/edit_info/item/tabs/TabsItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/tariff/edit_info/item/tabs/TabsItemPresenter;", "getPresenter", "()Lcom/avito/android/tariff/edit_info/item/tabs/TabsItemPresenter;", "presenter", "<init>", "(Lcom/avito/android/tariff/edit_info/item/tabs/TabsItemPresenter;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TabsItemBlueprint implements ItemBlueprint<TabsItemView, TabsItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<BaseViewHolder> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.period_tabs_item, new a(this));
    @NotNull
    public final TabsItemPresenter b;
    @NotNull
    public final AttributedTextFormatter c;

    public static final class a extends Lambda implements Function2<ViewGroup, View, TabsItemViewImpl> {
        public final /* synthetic */ TabsItemBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(TabsItemBlueprint tabsItemBlueprint) {
            super(2);
            this.a = tabsItemBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public TabsItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new TabsItemViewImpl(view2, this.a.getAttributedTextFormatter());
        }
    }

    @Inject
    public TabsItemBlueprint(@NotNull TabsItemPresenter tabsItemPresenter, @NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(tabsItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.b = tabsItemPresenter;
        this.c = attributedTextFormatter;
    }

    @NotNull
    public final AttributedTextFormatter getAttributedTextFormatter() {
        return this.c;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<BaseViewHolder> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof TabsItem;
    }

    /* Return type fixed from 'com.avito.android.tariff.edit_info.item.tabs.TabsItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<TabsItemView, TabsItem> getPresenter() {
        return this.b;
    }
}
