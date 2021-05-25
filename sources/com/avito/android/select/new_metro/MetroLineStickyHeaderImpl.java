package com.avito.android.select.new_metro;

import a2.g.r.g;
import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.select.R;
import com.avito.android.select.new_metro.adapter.lineItem.MetroLineItem;
import com.avito.android.select.new_metro.adapter.lineItem.MetroLineItemPresenter;
import com.avito.android.select.new_metro.adapter.lineItem.MetroLineItemViewImpl;
import com.avito.android.util.Logs;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.data_source.DataSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u000e\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001b0\u001a\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u0012\u0006\u00100\u001a\u00020)¢\u0006\u0004\b=\u0010>J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R*\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001b0\u001a8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\"\u00100\u001a\u00020)8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R(\u0010<\u001a\u0014 9*\t\u0018\u000107¢\u0006\u0002\b807¢\u0006\u0002\b88\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006?"}, d2 = {"Lcom/avito/android/select/new_metro/MetroLineStickyHeaderImpl;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", "hideHeader", "()V", "translation", AuthSource.SEND_ABUSE, "(I)V", "Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItemViewImpl;", g.a, "Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItemViewImpl;", "getItemView", "()Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItemViewImpl;", "setItemView", "(Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItemViewImpl;)V", "itemView", "c", "Ljava/lang/Integer;", "currentHeaderAdapterPosition", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/conveyor_item/Item;", "e", "Lcom/avito/konveyor/data_source/DataSource;", "getDataSource", "()Lcom/avito/konveyor/data_source/DataSource;", "setDataSource", "(Lcom/avito/konveyor/data_source/DataSource;)V", "dataSource", "I", "headerHeight", "Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItem;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItem;", "currentHeader", "Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItemPresenter;", "h", "Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItemPresenter;", "getItemPresenter", "()Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItemPresenter;", "setItemPresenter", "(Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItemPresenter;)V", "itemPresenter", "f", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Lio/reactivex/rxjava3/disposables/Disposable;", "Lio/reactivex/rxjava3/annotations/NonNull;", "kotlin.jvm.PlatformType", "d", "Lio/reactivex/rxjava3/disposables/Disposable;", "subscription", "<init>", "(Lcom/avito/konveyor/data_source/DataSource;Landroidx/recyclerview/widget/RecyclerView;Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItemViewImpl;Lcom/avito/android/select/new_metro/adapter/lineItem/MetroLineItemPresenter;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class MetroLineStickyHeaderImpl extends RecyclerView.OnScrollListener {
    public int a;
    public MetroLineItem b;
    public Integer c;
    public final Disposable d = this.h.getExpandedChangeObservable().subscribe(new a(this), b.a);
    @NotNull
    public DataSource<? extends Item> e;
    @NotNull
    public RecyclerView f;
    @NotNull
    public MetroLineItemViewImpl g;
    @NotNull
    public MetroLineItemPresenter h;

    public static final class a<T> implements Consumer<MetroLineItem> {
        public final /* synthetic */ MetroLineStickyHeaderImpl a;

        public a(MetroLineStickyHeaderImpl metroLineStickyHeaderImpl) {
            this.a = metroLineStickyHeaderImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(MetroLineItem metroLineItem) {
            MetroLineItem metroLineItem2 = metroLineItem;
            int childAdapterPosition = this.a.getRecyclerView().getChildAdapterPosition(this.a.getRecyclerView().getChildAt(0));
            Item item = (Item) this.a.getDataSource().getItem(childAdapterPosition);
            if (Intrinsics.areEqual(metroLineItem2, this.a.b)) {
                if (Intrinsics.areEqual(item, this.a.b)) {
                    RecyclerView.Adapter adapter = this.a.getRecyclerView().getAdapter();
                    if (adapter != null) {
                        adapter.notifyItemChanged(childAdapterPosition);
                    }
                } else {
                    Integer num = this.a.c;
                    if (num != null) {
                        this.a.getRecyclerView().smoothScrollToPosition(num.intValue());
                    }
                }
            }
            if (Intrinsics.areEqual(item, metroLineItem2)) {
                MetroLineStickyHeaderImpl metroLineStickyHeaderImpl = this.a;
                metroLineStickyHeaderImpl.onScrolled(metroLineStickyHeaderImpl.getRecyclerView(), 0, 0);
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public MetroLineStickyHeaderImpl(@NotNull DataSource<? extends Item> dataSource, @NotNull RecyclerView recyclerView, @NotNull MetroLineItemViewImpl metroLineItemViewImpl, @NotNull MetroLineItemPresenter metroLineItemPresenter) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(metroLineItemViewImpl, "itemView");
        Intrinsics.checkNotNullParameter(metroLineItemPresenter, "itemPresenter");
        this.e = dataSource;
        this.f = recyclerView;
        this.g = metroLineItemViewImpl;
        this.h = metroLineItemPresenter;
        Context context = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "recyclerView.context");
        this.a = context.getResources().getDimensionPixelSize(R.dimen.select_metro_header_height);
        this.f.addOnScrollListener(this);
    }

    public final void a(int i) {
        View view = this.g.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "itemView.itemView");
        view.setVisibility(0);
        View view2 = this.g.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "itemView.itemView");
        view2.setTranslationY((float) i);
    }

    @NotNull
    public final DataSource<? extends Item> getDataSource() {
        return this.e;
    }

    @NotNull
    public final MetroLineItemPresenter getItemPresenter() {
        return this.h;
    }

    @NotNull
    public final MetroLineItemViewImpl getItemView() {
        return this.g;
    }

    @NotNull
    public final RecyclerView getRecyclerView() {
        return this.f;
    }

    public final void hideHeader() {
        this.b = null;
        this.c = null;
        View view = this.g.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "itemView.itemView");
        if (view.getVisibility() != 4) {
            View view2 = this.g.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "itemView.itemView");
            view2.setVisibility(4);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0046  */
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onScrolled(@org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView r5, int r6, int r7) {
        /*
            r4 = this;
            java.lang.String r0 = "recyclerView"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            super.onScrolled(r5, r6, r7)
            int r6 = r5.getChildCount()
            if (r6 != 0) goto L_0x000f
            return
        L_0x000f:
            r6 = 0
            android.view.View r7 = r5.getChildAt(r6)
            int r7 = r5.getChildAdapterPosition(r7)
            r0 = -1
            if (r7 < 0) goto L_0x003f
            com.avito.konveyor.data_source.DataSource<? extends com.avito.conveyor_item.Item> r1 = r4.e
            int r1 = r1.getCount()
            if (r7 < r1) goto L_0x0024
            goto L_0x003f
        L_0x0024:
            r1 = r7
        L_0x0025:
            if (r1 <= 0) goto L_0x003f
            com.avito.konveyor.data_source.DataSource<? extends com.avito.conveyor_item.Item> r2 = r4.e
            java.lang.Object r2 = r2.getItem(r1)
            com.avito.conveyor_item.Item r2 = (com.avito.conveyor_item.Item) r2
            boolean r3 = r2 instanceof com.avito.android.select.new_metro.adapter.lineItem.MetroLineItem
            if (r3 == 0) goto L_0x003c
            com.avito.android.select.new_metro.adapter.lineItem.MetroLineItem r2 = (com.avito.android.select.new_metro.adapter.lineItem.MetroLineItem) r2
            boolean r2 = r2.isExpanded()
            if (r2 == 0) goto L_0x003c
            goto L_0x0040
        L_0x003c:
            int r1 = r1 + -1
            goto L_0x0025
        L_0x003f:
            r1 = -1
        L_0x0040:
            if (r1 != r0) goto L_0x0046
            r4.hideHeader()
            return
        L_0x0046:
            com.avito.konveyor.data_source.DataSource<? extends com.avito.conveyor_item.Item> r0 = r4.e
            java.lang.Object r0 = r0.getItem(r1)
            boolean r1 = r0 instanceof com.avito.android.select.new_metro.adapter.lineItem.MetroLineItem
            if (r1 != 0) goto L_0x0051
            r0 = 0
        L_0x0051:
            com.avito.android.select.new_metro.adapter.lineItem.MetroLineItem r0 = (com.avito.android.select.new_metro.adapter.lineItem.MetroLineItem) r0
            if (r0 != 0) goto L_0x0059
            r4.hideHeader()
            return
        L_0x0059:
            com.avito.android.select.new_metro.adapter.lineItem.MetroLineItem r1 = r4.b
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            r1 = r1 ^ 1
            if (r1 == 0) goto L_0x0072
            r4.b = r0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r4.c = r7
            com.avito.android.select.new_metro.adapter.lineItem.MetroLineItemPresenter r7 = r4.h
            com.avito.android.select.new_metro.adapter.lineItem.MetroLineItemViewImpl r1 = r4.g
            r7.bindView(r1, r0, r6)
        L_0x0072:
            r4.a(r6)
        L_0x0075:
            android.view.View r7 = r5.getChildAt(r6)
            int r0 = r5.getChildAdapterPosition(r7)
            com.avito.konveyor.data_source.DataSource<? extends com.avito.conveyor_item.Item> r1 = r4.e
            java.lang.Object r0 = r1.getItem(r0)
            com.avito.conveyor_item.Item r0 = (com.avito.conveyor_item.Item) r0
            boolean r1 = r0 instanceof com.avito.android.select.new_metro.adapter.lineItem.MetroLineItem
            java.lang.String r2 = "view"
            if (r1 == 0) goto L_0x00a3
            com.avito.android.select.new_metro.adapter.lineItem.MetroLineItem r5 = r4.b
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r5)
            r5 = r5 ^ 1
            if (r5 == 0) goto L_0x00a2
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r2)
            int r5 = r7.getTop()
            int r6 = r4.a
            int r5 = r5 - r6
            r4.a(r5)
        L_0x00a2:
            return
        L_0x00a3:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r2)
            int r7 = r7.getBottom()
            int r0 = r4.a
            if (r7 >= r0) goto L_0x00b6
            int r6 = r6 + 1
            int r7 = r5.getChildCount()
            if (r6 < r7) goto L_0x0075
        L_0x00b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.select.new_metro.MetroLineStickyHeaderImpl.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    public final void setDataSource(@NotNull DataSource<? extends Item> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "<set-?>");
        this.e = dataSource;
    }

    public final void setItemPresenter(@NotNull MetroLineItemPresenter metroLineItemPresenter) {
        Intrinsics.checkNotNullParameter(metroLineItemPresenter, "<set-?>");
        this.h = metroLineItemPresenter;
    }

    public final void setItemView(@NotNull MetroLineItemViewImpl metroLineItemViewImpl) {
        Intrinsics.checkNotNullParameter(metroLineItemViewImpl, "<set-?>");
        this.g = metroLineItemViewImpl;
    }

    public final void setRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.f = recyclerView;
    }
}
