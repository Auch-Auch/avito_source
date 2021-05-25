package com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.segmented;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.ItemType;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.VerticalSearchFilterFormItem;
import com.avito.android.serp_core.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0011\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/segmented/VerticalSearchFilterSegmentedItemBlueprintImpl;", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/segmented/VerticalSearchFilterSegmentedItemBlueprint;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/segmented/VerticalSearchFilterSegmentedItemPresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/segmented/VerticalSearchFilterSegmentedItemPresenter;", "getPresenter", "()Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/segmented/VerticalSearchFilterSegmentedItemPresenter;", "presenter", "<init>", "(Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/segmented/VerticalSearchFilterSegmentedItemPresenter;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class VerticalSearchFilterSegmentedItemBlueprintImpl implements VerticalSearchFilterSegmentedItemBlueprint {
    @NotNull
    public final VerticalSearchFilterSegmentedItemPresenter a;

    public static final class a extends Lambda implements Function2<ViewGroup, View, VerticalSearchFilterSegmentedItemViewImpl> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public VerticalSearchFilterSegmentedItemViewImpl invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new VerticalSearchFilterSegmentedItemViewImpl(view2);
        }
    }

    @Inject
    public VerticalSearchFilterSegmentedItemBlueprintImpl(@NotNull VerticalSearchFilterSegmentedItemPresenter verticalSearchFilterSegmentedItemPresenter) {
        Intrinsics.checkNotNullParameter(verticalSearchFilterSegmentedItemPresenter, "presenter");
        this.a = verticalSearchFilterSegmentedItemPresenter;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<BaseViewHolder> getViewHolderProvider() {
        return new ViewHolderBuilder.ViewHolderProvider<>(R.layout.vertical_main_segmented_item, a.a);
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return (item instanceof VerticalSearchFilterFormItem) && ((VerticalSearchFilterFormItem) item).getItemType() == ItemType.SEGMENTED;
    }

    /* Return type fixed from 'com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.segmented.VerticalSearchFilterSegmentedItemPresenter' to match base method */
    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<VerticalSearchFilterSegmentedItemView, VerticalSearchFilterFormItem> getPresenter() {
        return this.a;
    }
}
