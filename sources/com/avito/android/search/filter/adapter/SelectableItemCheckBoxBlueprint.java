package com.avito.android.search.filter.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.items.SelectableItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.filter.SelectableItemIconFactory;
import com.avito.android.search.filter.di.FiltersCoreAdapterItemsModule;
import com.avito.android.ui_components.R;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001b\b\u0007\u0012\b\b\u0001\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0019\u001a\u00020\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/search/filter/adapter/SelectableItemCheckBoxBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/search/filter/adapter/SelectableItemView;", "Lcom/avito/android/items/SelectableItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/search/filter/SelectableItemIconFactory;", "c", "Lcom/avito/android/search/filter/SelectableItemIconFactory;", "iconFactory", "Lcom/avito/android/search/filter/adapter/SelectableItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/search/filter/adapter/SelectableItemPresenter;", "getPresenter", "()Lcom/avito/android/search/filter/adapter/SelectableItemPresenter;", "presenter", "<init>", "(Lcom/avito/android/search/filter/adapter/SelectableItemPresenter;Lcom/avito/android/search/filter/SelectableItemIconFactory;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class SelectableItemCheckBoxBlueprint implements ItemBlueprint<SelectableItemView, SelectableItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<BaseViewHolder> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.check_box, new a(this));
    @NotNull
    public final SelectableItemPresenter b;
    public final SelectableItemIconFactory c;

    public static final class a extends Lambda implements Function2<ViewGroup, View, BaseViewHolder> {
        public final /* synthetic */ SelectableItemCheckBoxBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SelectableItemCheckBoxBlueprint selectableItemCheckBoxBlueprint) {
            super(2);
            this.a = selectableItemCheckBoxBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public BaseViewHolder invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new SelectableItemCheckBoxView(view2, this.a.c);
        }
    }

    @Inject
    public SelectableItemCheckBoxBlueprint(@FiltersCoreAdapterItemsModule.SelectableCheckBoxPresenter @NotNull SelectableItemPresenter selectableItemPresenter, @NotNull SelectableItemIconFactory selectableItemIconFactory) {
        Intrinsics.checkNotNullParameter(selectableItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(selectableItemIconFactory, "iconFactory");
        this.b = selectableItemPresenter;
        this.c = selectableItemIconFactory;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<BaseViewHolder> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof SelectableItem;
    }

    /* Return type fixed from 'com.avito.android.search.filter.adapter.SelectableItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<SelectableItemView, SelectableItem> getPresenter() {
        return this.b;
    }
}
