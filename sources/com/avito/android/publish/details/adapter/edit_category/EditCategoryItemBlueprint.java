package com.avito.android.publish.details.adapter.edit_category;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.item_temporary.R;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/publish/details/adapter/edit_category/EditCategoryItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/publish/details/adapter/edit_category/EditCategoryItemView;", "Lcom/avito/android/category_parameters/ParameterElement$EditCategoryButton;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/android/publish/details/adapter/edit_category/EditCategoryItemPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/publish/details/adapter/edit_category/EditCategoryItemPresenter;", "getPresenter", "()Lcom/avito/android/publish/details/adapter/edit_category/EditCategoryItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/publish/details/adapter/edit_category/EditCategoryItemViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "<init>", "(Lcom/avito/android/publish/details/adapter/edit_category/EditCategoryItemPresenter;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class EditCategoryItemBlueprint implements ItemBlueprint<EditCategoryItemView, ParameterElement.EditCategoryButton> {
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<EditCategoryItemViewImpl> a = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.component_container_with_select, a.a);
    @NotNull
    public final EditCategoryItemPresenter b;

    public static final class a extends Lambda implements Function2<ViewGroup, View, EditCategoryItemViewImpl> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public EditCategoryItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new EditCategoryItemViewImpl(view2);
        }
    }

    public EditCategoryItemBlueprint(@NotNull EditCategoryItemPresenter editCategoryItemPresenter) {
        Intrinsics.checkNotNullParameter(editCategoryItemPresenter, "presenter");
        this.b = editCategoryItemPresenter;
    }

    /* Return type fixed from 'com.avito.android.publish.details.adapter.edit_category.EditCategoryItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<EditCategoryItemView, ParameterElement.EditCategoryButton> getPresenter() {
        return this.b;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<EditCategoryItemViewImpl> getViewHolderProvider() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof ParameterElement.EditCategoryButton;
    }
}
