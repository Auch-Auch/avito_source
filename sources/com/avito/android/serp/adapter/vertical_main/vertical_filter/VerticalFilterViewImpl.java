package com.avito.android.serp.adapter.vertical_main.vertical_filter;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.lib.design.button.Button;
import com.avito.android.recycler.base.SafeRecyclerAdapter;
import com.avito.android.serp.BaseSerpViewHolder;
import com.avito.android.serp.adapter.GridPositionProviderImpl;
import com.avito.android.serp.adapter.SerpSpanProviderImpl;
import com.avito.android.serp.adapter.SpanLookup;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.VerticalSearchFilterFormItem;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.item.VerticalFilterItemView;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.item.VerticalSearchFilterItemDecorator;
import com.avito.android.ui.adapter.AppendingListener;
import com.avito.android.ui_components.R;
import com.avito.android.util.RecyclerViewsKt;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u0010=\u001a\u00020:\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010.\u001a\u00020+¢\u0006\u0004\bM\u0010NJ\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ)\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010\u000e\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010H\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010K¨\u0006O"}, d2 = {"Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterViewImpl;", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/item/VerticalFilterItemView;", "Lcom/avito/android/ui/adapter/AppendingListener;", "Lcom/avito/android/serp/BaseSerpViewHolder;", "", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/VerticalSearchFilterFormItem;", "items", "", "bindItems", "(Ljava/util/List;)V", "", "isEnabled", "isLoading", "", "title", "setSubmitState", "(ZZLjava/lang/String;)V", "setTitle", "(Ljava/lang/String;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSubmitListener", "(Lkotlin/jvm/functions/Function0;)V", "canAppend", "()Z", "onAppend", "()V", "Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "D", "Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "recyclerAdapter", "Landroidx/recyclerview/widget/RecyclerView;", "u", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/avito/konveyor/data_source/ListDataSource;", "x", "Lcom/avito/konveyor/data_source/ListDataSource;", "itemsDatasource", "", "w", "Ljava/util/List;", "recyclerItems", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalSearchFilterResourceProvider;", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalSearchFilterResourceProvider;", "resourceProvider", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "Lcom/avito/android/lib/design/button/Button;", "t", "Lcom/avito/android/lib/design/button/Button;", "submitButton", "Landroid/view/View;", "B", "Landroid/view/View;", "view", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "C", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/serp/adapter/SerpSpanProviderImpl;", "z", "Lcom/avito/android/serp/adapter/SerpSpanProviderImpl;", "serpSpanProvider", "Lcom/avito/android/serp/adapter/GridPositionProviderImpl;", "y", "Lcom/avito/android/serp/adapter/GridPositionProviderImpl;", "gridPositionProvider", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/lang/String;", "defaultSubmitTitle", "Landroidx/recyclerview/widget/GridLayoutManager;", VKApiConst.VERSION, "Landroidx/recyclerview/widget/GridLayoutManager;", "layoutManager", "<init>", "(Landroid/view/View;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/base/SafeRecyclerAdapter;Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalSearchFilterResourceProvider;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class VerticalFilterViewImpl extends BaseSerpViewHolder implements VerticalFilterItemView, AppendingListener {
    public final String A;
    public final View B;
    public final AdapterPresenter C;
    public final SafeRecyclerAdapter D;
    public final VerticalSearchFilterResourceProvider E;
    public final TextView s;
    public final Button t;
    public final RecyclerView u;
    public GridLayoutManager v;
    public List<VerticalSearchFilterFormItem> w;
    public final ListDataSource<VerticalSearchFilterFormItem> x;
    public final GridPositionProviderImpl y;
    public final SerpSpanProviderImpl z;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerticalFilterViewImpl(@NotNull View view, @NotNull AdapterPresenter adapterPresenter, @NotNull SafeRecyclerAdapter safeRecyclerAdapter, @NotNull VerticalSearchFilterResourceProvider verticalSearchFilterResourceProvider) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(safeRecyclerAdapter, "recyclerAdapter");
        Intrinsics.checkNotNullParameter(verticalSearchFilterResourceProvider, "resourceProvider");
        this.B = view;
        this.C = adapterPresenter;
        this.D = safeRecyclerAdapter;
        this.E = verticalSearchFilterResourceProvider;
        View findViewById = view.findViewById(R.id.vertical_search_filter_title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.vertical_search_filter_action);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        Button button = (Button) findViewById2;
        this.t = button;
        View findViewById3 = view.findViewById(R.id.vertical_search_filter_content);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById3;
        this.u = recyclerView;
        this.v = new GridLayoutManager(view.getContext(), verticalSearchFilterResourceProvider.spanCount(), 1, false);
        ArrayList arrayList = new ArrayList();
        this.w = arrayList;
        this.x = new ListDataSource<>(arrayList);
        GridPositionProviderImpl gridPositionProviderImpl = new GridPositionProviderImpl(verticalSearchFilterResourceProvider.spanCount());
        this.y = gridPositionProviderImpl;
        SerpSpanProviderImpl serpSpanProviderImpl = new SerpSpanProviderImpl(verticalSearchFilterResourceProvider.spanCount(), gridPositionProviderImpl);
        this.z = serpSpanProviderImpl;
        String string = view.getContext().getString(com.avito.android.serp_core.R.string.show_items);
        Intrinsics.checkNotNullExpressionValue(string, "view.context.getString(R.string.show_items)");
        this.A = string;
        this.v.setSpanSizeLookup(new SpanLookup(serpSpanProviderImpl));
        recyclerView.setLayoutManager(this.v);
        recyclerView.setNestedScrollingEnabled(false);
        button.setText(string);
        view.setClipToOutline(true);
    }

    @Override // com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterView
    public void bindItems(@NotNull List<VerticalSearchFilterFormItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.w.clear();
        this.w.addAll(list);
        if (this.u.getAdapter() == null) {
            this.z.setAppendingListener(this);
            this.z.onDataSourceChanged(this.x);
            this.C.onDataSourceChanged(this.x);
            this.u.setAdapter(this.D);
        } else {
            RecyclerView.Adapter adapter = this.u.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
        RecyclerViewsKt.clearItemDecorations(this.u);
        RecyclerView recyclerView = this.u;
        Resources resources = this.B.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
        recyclerView.addItemDecoration(new VerticalSearchFilterItemDecorator(resources));
    }

    @Override // com.avito.android.ui.adapter.AppendingListener
    public boolean canAppend() {
        return false;
    }

    @Override // com.avito.android.ui.adapter.AppendingListener
    public void onAppend() {
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        VerticalFilterItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterView
    public void setSubmitListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterView
    public void setSubmitState(boolean z2, boolean z3, @Nullable String str) {
        this.t.setLoading(z3);
        this.t.setEnabled(z2);
        Button button = this.t;
        if (str == null) {
            str = this.A;
        }
        button.setText(str);
        Iterator<T> it = this.w.iterator();
        while (it.hasNext()) {
            it.next().setEnabled(z2);
        }
        RecyclerView.Adapter adapter = this.u.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterView
    public void setTitle(@Nullable String str) {
        TextViews.bindText$default(this.s, str, false, 2, null);
    }
}
