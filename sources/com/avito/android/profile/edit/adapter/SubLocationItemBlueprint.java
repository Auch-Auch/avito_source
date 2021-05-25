package com.avito.android.profile.edit.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.profile.edit.refactoring.adapter.SelectItemViewImpl;
import com.avito.android.profile.edit.refactoring.adapter.SelectableSinleLineItemView;
import com.avito.android.profile.edit.refactoring.adapter.SubLocationItemPresenter;
import com.avito.android.profile.edit.refactoring.adapter.item.SubLocationItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0015\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/profile/edit/adapter/SubLocationItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/profile/edit/refactoring/adapter/SelectableSinleLineItemView;", "Lcom/avito/android/profile/edit/refactoring/adapter/item/SubLocationItem;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/profile/edit/refactoring/adapter/SubLocationItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/profile/edit/refactoring/adapter/SubLocationItemPresenter;", "getPresenter", "()Lcom/avito/android/profile/edit/refactoring/adapter/SubLocationItemPresenter;", "presenter", "<init>", "(Lcom/avito/android/profile/edit/refactoring/adapter/SubLocationItemPresenter;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class SubLocationItemBlueprint implements ItemBlueprint<SelectableSinleLineItemView, SubLocationItem> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<BaseViewHolder> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.selectable_single_line, a.a);
    @NotNull
    public final SubLocationItemPresenter b;

    public static final class a extends Lambda implements Function2<ViewGroup, View, SelectItemViewImpl> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public SelectItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            int dimensionPixelSize = view2.getResources().getDimensionPixelSize(R.dimen.standard_padding);
            Views.changePadding$default(view2, dimensionPixelSize, 0, dimensionPixelSize, 0, 10, null);
            return new SelectItemViewImpl(view2);
        }
    }

    public SubLocationItemBlueprint(@NotNull SubLocationItemPresenter subLocationItemPresenter) {
        Intrinsics.checkNotNullParameter(subLocationItemPresenter, "presenter");
        this.b = subLocationItemPresenter;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<BaseViewHolder> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof SubLocationItem;
    }

    /* Return type fixed from 'com.avito.android.profile.edit.refactoring.adapter.SubLocationItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<SelectableSinleLineItemView, SubLocationItem> getPresenter() {
        return this.b;
    }
}
