package com.avito.android.tariff.fees_methods.items.tariff_package;

import a2.b.a.a.a;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.tariff.R;
import com.avito.android.tariff.edit_info.item.edit_package.EditPackageMicroCategoryItem;
import com.avito.android.tariff.fees_methods.items.tariff_package.FeeMethodPackageItemView;
import com.avito.android.util.TextViews;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0012\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006!"}, d2 = {"Lcom/avito/android/tariff/fees_methods/items/tariff_package/FeeMethodPackageItemViewImpl;", "Lcom/avito/android/tariff/fees_methods/items/tariff_package/FeeMethodPackageItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "Lcom/avito/android/tariff/edit_info/item/edit_package/EditPackageMicroCategoryItem;", "microCategories", "", "setMicroCategories", "(Ljava/util/List;)V", "", "locations", "setLocations", "(Ljava/lang/String;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "u", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "locationsTextView", "Landroidx/recyclerview/widget/RecyclerView;", "s", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroid/view/View;", "view", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "<init>", "(Landroid/view/View;Lcom/avito/konveyor/ItemBinder;Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class FeeMethodPackageItemViewImpl extends BaseViewHolder implements FeeMethodPackageItemView {
    public RecyclerView s;
    public TextView t;
    @NotNull
    public final AdapterPresenter u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeeMethodPackageItemViewImpl(@NotNull View view, @NotNull ItemBinder itemBinder, @NotNull AdapterPresenter adapterPresenter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        this.u = adapterPresenter;
        View findViewById = view.findViewById(R.id.recycler_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.recycler_view)");
        this.s = (RecyclerView) findViewById;
        View findViewById2 = view.findViewById(R.id.locations);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.locations)");
        this.t = (TextView) findViewById2;
        this.s.setItemAnimator(null);
        this.s.setAdapter(new SimpleRecyclerAdapter(adapterPresenter, itemBinder));
    }

    @NotNull
    public final AdapterPresenter getAdapterPresenter() {
        return this.u;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        FeeMethodPackageItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.tariff.fees_methods.items.tariff_package.FeeMethodPackageItemView
    public void setLocations(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "locations");
        TextViews.bindText$default(this.t, str, false, 2, null);
    }

    @Override // com.avito.android.tariff.fees_methods.items.tariff_package.FeeMethodPackageItemView
    public void setMicroCategories(@NotNull List<EditPackageMicroCategoryItem> list) {
        Intrinsics.checkNotNullParameter(list, "microCategories");
        a.s1(list, this.u);
        RecyclerView.Adapter adapter = this.s.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}
