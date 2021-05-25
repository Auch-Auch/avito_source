package com.avito.android.serp.adapter.vertical_main.vertical_filter.item;

import android.view.View;
import com.avito.android.recycler.base.SafeRecyclerAdapter;
import com.avito.android.serp.BaseSerpViewHolder;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterViewImpl;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalSearchFilterResourceProvider;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.VerticalSearchFilterFormItem;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u001e\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\r\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0001¢\u0006\u0004\b\r\u0010\u000eJ*\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0001¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/item/VerticalFilterItemViewImpl;", "Lcom/avito/android/serp/BaseSerpViewHolder;", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/item/VerticalFilterItemView;", "", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/VerticalSearchFilterFormItem;", "items", "", "bindItems", "(Ljava/util/List;)V", "onUnbind", "()V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSubmitListener", "(Lkotlin/jvm/functions/Function0;)V", "", "isEnabled", "isLoading", "", "title", "setSubmitState", "(ZZLjava/lang/String;)V", "setTitle", "(Ljava/lang/String;)V", "Landroid/view/View;", "view", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "recyclerAdapter", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalSearchFilterResourceProvider;", "resourceProvider", "<init>", "(Landroid/view/View;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/base/SafeRecyclerAdapter;Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalSearchFilterResourceProvider;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class VerticalFilterItemViewImpl extends BaseSerpViewHolder implements VerticalFilterItemView {
    public final /* synthetic */ VerticalFilterViewImpl s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerticalFilterItemViewImpl(@NotNull View view, @NotNull AdapterPresenter adapterPresenter, @NotNull SafeRecyclerAdapter safeRecyclerAdapter, @NotNull VerticalSearchFilterResourceProvider verticalSearchFilterResourceProvider) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(safeRecyclerAdapter, "recyclerAdapter");
        Intrinsics.checkNotNullParameter(verticalSearchFilterResourceProvider, "resourceProvider");
        this.s = new VerticalFilterViewImpl(view, adapterPresenter, safeRecyclerAdapter, verticalSearchFilterResourceProvider);
    }

    @Override // com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterView
    public void bindItems(@NotNull List<VerticalSearchFilterFormItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.s.bindItems(list);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        this.s.onUnbind();
    }

    @Override // com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterView
    public void setSubmitListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setSubmitListener(function0);
    }

    @Override // com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterView
    public void setSubmitState(boolean z, boolean z2, @Nullable String str) {
        this.s.setSubmitState(z, z2, str);
    }

    @Override // com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterView
    public void setTitle(@Nullable String str) {
        this.s.setTitle(str);
    }
}
