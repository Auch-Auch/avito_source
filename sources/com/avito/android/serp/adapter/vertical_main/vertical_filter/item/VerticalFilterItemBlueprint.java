package com.avito.android.serp.adapter.vertical_main.vertical_filter.item;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.recycler.base.SafeRecyclerAdapter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalSearchFilterResourceProvider;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.di.VerticalSearchFilterAdapterPresenter;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.di.VerticalSearchFilterRecyclerAdapter;
import com.avito.android.ui_components.R;
import com.avito.konveyor.adapter.AdapterPresenter;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B-\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b \u0010!J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001b\u001a\u00020\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/item/VerticalFilterItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/item/VerticalFilterItemView;", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/item/VerticalFilterItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/konveyor/adapter/AdapterPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "c", "Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "recyclerAdapter", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/item/VerticalFilterItemPresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/item/VerticalFilterItemPresenter;", "getPresenter", "()Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/item/VerticalFilterItemPresenter;", "presenter", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalSearchFilterResourceProvider;", "d", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalSearchFilterResourceProvider;", "resourceProvider", "<init>", "(Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/item/VerticalFilterItemPresenter;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/base/SafeRecyclerAdapter;Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalSearchFilterResourceProvider;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class VerticalFilterItemBlueprint implements ItemBlueprint<VerticalFilterItemView, VerticalFilterItem> {
    @NotNull
    public final VerticalFilterItemPresenter a;
    public final AdapterPresenter b;
    public final SafeRecyclerAdapter c;
    public final VerticalSearchFilterResourceProvider d;

    public static final class a extends Lambda implements Function2<ViewGroup, View, VerticalFilterItemViewImpl> {
        public final /* synthetic */ VerticalFilterItemBlueprint a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(VerticalFilterItemBlueprint verticalFilterItemBlueprint) {
            super(2);
            this.a = verticalFilterItemBlueprint;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public VerticalFilterItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new VerticalFilterItemViewImpl(view2, this.a.b, this.a.c, this.a.d);
        }
    }

    @Inject
    public VerticalFilterItemBlueprint(@NotNull VerticalFilterItemPresenter verticalFilterItemPresenter, @VerticalSearchFilterAdapterPresenter @NotNull AdapterPresenter adapterPresenter, @VerticalSearchFilterRecyclerAdapter @NotNull SafeRecyclerAdapter safeRecyclerAdapter, @NotNull VerticalSearchFilterResourceProvider verticalSearchFilterResourceProvider) {
        Intrinsics.checkNotNullParameter(verticalFilterItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(safeRecyclerAdapter, "recyclerAdapter");
        Intrinsics.checkNotNullParameter(verticalSearchFilterResourceProvider, "resourceProvider");
        this.a = verticalFilterItemPresenter;
        this.b = adapterPresenter;
        this.c = safeRecyclerAdapter;
        this.d = verticalSearchFilterResourceProvider;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<BaseViewHolder> getViewHolderProvider() {
        return new ViewHolderBuilder.ViewHolderProvider<>(R.layout.main_vertical_search_filter, new a(this));
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof VerticalFilterItem;
    }

    /* Return type fixed from 'com.avito.android.serp.adapter.vertical_main.vertical_filter.item.VerticalFilterItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<VerticalFilterItemView, VerticalFilterItem> getPresenter() {
        return this.a;
    }
}
