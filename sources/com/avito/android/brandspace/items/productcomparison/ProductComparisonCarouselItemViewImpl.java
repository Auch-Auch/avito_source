package com.avito.android.brandspace.items.productcomparison;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.brandspace.R;
import com.avito.android.brandspace.items.carousel.CarouselItemView;
import com.avito.android.brandspace.items.carousel.CarouselItemViewImpl;
import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.util.Contexts;
import com.avito.android.util.ViewGroupsKt;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ5\u0010\u000b\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonCarouselItemViewImpl;", "Lcom/avito/android/brandspace/items/carousel/CarouselItemViewImpl;", "", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "items", "", VKApiConst.POSITION, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "Lcom/avito/android/brandspace/items/carousel/CarouselItemView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "bind", "(Ljava/util/List;IILcom/avito/android/brandspace/items/carousel/CarouselItemView$Listener;)V", "Landroid/widget/TextView;", "u", "()Ljava/util/List;", "Landroid/widget/LinearLayout;", "z", "Landroid/widget/LinearLayout;", "headerContainer", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Landroid/view/View;", "view", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "viewHolderProvider", "<init>", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Landroid/view/View;Lcom/avito/konveyor/blueprint/ViewHolderBuilder;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class ProductComparisonCarouselItemViewImpl extends CarouselItemViewImpl {
    public final LinearLayout z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductComparisonCarouselItemViewImpl(@NotNull AdapterPresenter adapterPresenter, @NotNull View view, @NotNull ViewHolderBuilder<? extends BaseViewHolder> viewHolderBuilder) {
        super(adapterPresenter, view, viewHolderBuilder, 0, false, null, 56, null);
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(viewHolderBuilder, "viewHolderProvider");
        View findViewById = view.findViewById(R.id.property_header_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.z = (LinearLayout) findViewById;
    }

    @Override // com.avito.android.brandspace.items.carousel.CarouselItemViewImpl, com.avito.android.brandspace.items.carousel.CarouselItemView
    public void bind(@NotNull List<? extends BrandspaceItem> list, int i, int i2, @NotNull CarouselItemView.Listener listener) {
        List<TextView> list2;
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        super.bind(list, i, -2, listener);
        Object first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
        Objects.requireNonNull(first, "null cannot be cast to non-null type com.avito.android.brandspace.items.productcomparison.ProductComparisonItem");
        List<ProductComparisonItemProperty> properties = ((ProductComparisonItem) first).getProperties();
        int i3 = 0;
        if (this.z.getChildCount() != properties.size()) {
            this.z.removeAllViews();
            int size = properties.size();
            for (int i4 = 0; i4 < size; i4++) {
                LinearLayout linearLayout = this.z;
                View view = this.itemView;
                Intrinsics.checkNotNullExpressionValue(view, "itemView");
                View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.brandspace_item_productcomparison_property, (ViewGroup) null);
                Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
                TextView textView = (TextView) inflate;
                Context context = textView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "view.context");
                textView.setTextColor(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray44));
                textView.setLayoutParams(new ViewGroup.LayoutParams(textView.getResources().getDimensionPixelOffset(R.dimen.brandspace_card_width), -2));
                linearLayout.addView(textView);
            }
            list2 = u();
        } else {
            list2 = u();
        }
        for (T t : list2) {
            int i5 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            ProductComparisonItemProperty productComparisonItemProperty = properties.get(i3);
            View view2 = this.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "itemView");
            Views.changePadding$default(t2, 0, view2.getResources().getDimensionPixelOffset(R.dimen.brandspace_productcomparison_property_header_padding_top), 0, 0, 13, null);
            t2.setHeight(productComparisonItemProperty.getPrecalculatedTextHeight() + productComparisonItemProperty.getTopPadding());
            t2.setText(productComparisonItemProperty.getName());
            i3 = i5;
        }
    }

    public final List<TextView> u() {
        ArrayList arrayList = new ArrayList();
        Iterator<View> children = ViewGroupsKt.getChildren(this.z);
        while (children.hasNext()) {
            View next = children.next();
            if (next instanceof TextView) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }
}
