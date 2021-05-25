package com.avito.android.inline_filters.dialog.select.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp_core.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001b\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR(\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/inline_filters/dialog/select/adapter/InlineFiltersDialogHeadingItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/inline_filters/dialog/select/adapter/InlineFiltersDialogItemView;", "Lcom/avito/android/inline_filters/dialog/select/adapter/InlineFiltersDialogItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/blueprint/ItemPresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ItemPresenter;", "getPresenter", "()Lcom/avito/konveyor/blueprint/ItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "<init>", "(Lcom/avito/konveyor/blueprint/ItemPresenter;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class InlineFiltersDialogHeadingItemBlueprint implements ItemBlueprint<InlineFiltersDialogItemView, InlineFiltersDialogItem> {
    @NotNull
    public final ItemPresenter<InlineFiltersDialogItemView, InlineFiltersDialogItem> a;

    public static final class a extends Lambda implements Function2<ViewGroup, View, InlineFiltersDialogItemViewImpl> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public InlineFiltersDialogItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new InlineFiltersDialogItemViewImpl(view2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.avito.konveyor.blueprint.ItemPresenter<? super com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItemView, ? super com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItem> */
    /* JADX WARN: Multi-variable type inference failed */
    public InlineFiltersDialogHeadingItemBlueprint(@NotNull ItemPresenter<? super InlineFiltersDialogItemView, ? super InlineFiltersDialogItem> itemPresenter) {
        Intrinsics.checkNotNullParameter(itemPresenter, "presenter");
        this.a = itemPresenter;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<InlineFiltersDialogItemView, InlineFiltersDialogItem> getPresenter() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<BaseViewHolder> getViewHolderProvider() {
        return new ViewHolderBuilder.ViewHolderProvider<>(R.layout.inline_filters_dialog_subheading, a.a);
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return (item instanceof InlineFiltersDialogItem) && ((InlineFiltersDialogItem) item).isHeading();
    }
}
