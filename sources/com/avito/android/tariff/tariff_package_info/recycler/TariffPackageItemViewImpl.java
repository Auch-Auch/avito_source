package com.avito.android.tariff.tariff_package_info.recycler;

import a2.b.a.a.a;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.tariff.R;
import com.avito.android.tariff.edit_info.item.edit_package.EditPackageMicroCategoryItem;
import com.avito.android.tariff.tariff_package_info.recycler.TariffPackageItemView;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0012\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006!"}, d2 = {"Lcom/avito/android/tariff/tariff_package_info/recycler/TariffPackageItemViewImpl;", "Lcom/avito/android/tariff/tariff_package_info/recycler/TariffPackageItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "", "Lcom/avito/android/tariff/edit_info/item/edit_package/EditPackageMicroCategoryItem;", "microCategories", "setMicroCategories", "(Ljava/util/List;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "u", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Landroidx/recyclerview/widget/RecyclerView;", "s", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "titleView", "Landroid/view/View;", "view", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "<init>", "(Landroid/view/View;Lcom/avito/konveyor/ItemBinder;Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffPackageItemViewImpl extends BaseViewHolder implements TariffPackageItemView {
    public final RecyclerView s;
    public final TextView t;
    @NotNull
    public final AdapterPresenter u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TariffPackageItemViewImpl(@NotNull View view, @NotNull ItemBinder itemBinder, @NotNull AdapterPresenter adapterPresenter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        this.u = adapterPresenter;
        View findViewById = view.findViewById(R.id.micro_category_recycler_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.m…o_category_recycler_view)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.s = recyclerView;
        View findViewById2 = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.title)");
        this.t = (TextView) findViewById2;
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(new SimpleRecyclerAdapter(adapterPresenter, itemBinder));
    }

    @NotNull
    public final AdapterPresenter getAdapterPresenter() {
        return this.u;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        TariffPackageItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.tariff.tariff_package_info.recycler.TariffPackageItemView
    public void setMicroCategories(@NotNull List<EditPackageMicroCategoryItem> list) {
        Intrinsics.checkNotNullParameter(list, "microCategories");
        a.s1(list, this.u);
        RecyclerView.Adapter adapter = this.s.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.avito.android.tariff.tariff_package_info.recycler.TariffPackageItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.t.setText(str);
    }
}
