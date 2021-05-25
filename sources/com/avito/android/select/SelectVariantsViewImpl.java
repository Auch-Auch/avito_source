package com.avito.android.select;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/select/SelectVariantsViewImpl;", "Lcom/avito/android/select/SelectVariantsView;", "", "onDataChanged", "()V", "", "visible", "setEmptyViewVisible", "(Z)V", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "emptyView", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "e", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "viewHolderBuilder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "d", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/RecyclerView;", "variantList", "Landroid/view/ViewGroup;", "c", "Landroid/view/ViewGroup;", "rootView", "<init>", "(Landroid/view/ViewGroup;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/blueprint/ViewHolderBuilder;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class SelectVariantsViewImpl implements SelectVariantsView {
    public final RecyclerView a;
    public final View b;
    public final ViewGroup c;
    public final AdapterPresenter d;
    public final ViewHolderBuilder<BaseViewHolder> e;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.avito.konveyor.blueprint.ViewHolderBuilder<? extends com.avito.konveyor.adapter.BaseViewHolder> */
    /* JADX WARN: Multi-variable type inference failed */
    public SelectVariantsViewImpl(@NotNull ViewGroup viewGroup, @NotNull AdapterPresenter adapterPresenter, @NotNull ViewHolderBuilder<? extends BaseViewHolder> viewHolderBuilder) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(viewHolderBuilder, "viewHolderBuilder");
        this.c = viewGroup;
        this.d = adapterPresenter;
        this.e = viewHolderBuilder;
        View findViewById = viewGroup.findViewById(R.id.variant_list);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.a = recyclerView;
        View findViewById2 = viewGroup.findViewById(16908292);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.b = findViewById2;
        recyclerView.setLayoutManager(new LinearLayoutManager(viewGroup.getContext()));
        Views.hide(findViewById2);
    }

    @Override // com.avito.android.select.SelectVariantsView
    public void onDataChanged() {
        if (this.a.getAdapter() == null) {
            this.a.setAdapter(new SimpleRecyclerAdapter(this.d, this.e));
            return;
        }
        RecyclerView.Adapter adapter = this.a.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.avito.android.select.SelectVariantsView
    public void setEmptyViewVisible(boolean z) {
        Views.setVisible(this.b, z);
    }
}
