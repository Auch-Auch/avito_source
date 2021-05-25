package com.avito.android.orders.feature.list;

import a2.g.r.g;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.lib.design.button.Button;
import com.avito.android.orders.R;
import com.avito.android.orders.feature.common.viewmodel.OrderItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.orders.model.OrdersPlaceholder;
import com.avito.android.ui.VerticalListItemDecoration;
import com.avito.android.util.Contexts;
import com.avito.android.util.ContextsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.ViewSizeKt;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.Item;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 G2\u00020\u0001:\u0001GBE\b\u0007\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u0010=\u001a\u00020:\u0012\u0006\u00109\u001a\u000206\u0012\u0010\u0010B\u001a\f\u0012\u0004\u0012\u00020\u00050>j\u0002`?\u0012\u0010\u0010D\u001a\f\u0012\u0004\u0012\u00020#0\u0014j\u0002`C¢\u0006\u0004\bE\u0010FJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019RD\u0010 \u001a0\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\u00150\u0015 \u001c*\u0017\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\u00150\u0015\u0018\u00010\u001b¢\u0006\u0002\b\u001d0\u001b¢\u0006\u0002\b\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fRD\u0010\"\u001a0\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\u00050\u0005 \u001c*\u0017\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u001b¢\u0006\u0002\b\u001d0\u001b¢\u0006\u0002\b\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001fR\"\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010\u0017\u001a\u0004\b%\u0010\u0019R\u0016\u0010(\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010'R\u0016\u0010*\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010'R\"\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b+\u0010\u0017\u001a\u0004\b,\u0010\u0019R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R \u0010B\u001a\f\u0012\u0004\u0012\u00020\u00050>j\u0002`?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006H"}, d2 = {"Lcom/avito/android/orders/feature/list/OrdersListViewImpl;", "Lcom/avito/android/orders/feature/list/OrdersListView;", "", "Lcom/avito/konveyor/blueprint/Item;", "orderItems", "", "showContent", "(Ljava/util/List;)V", "Lcom/avito/android/remote/orders/model/OrdersPlaceholder;", InternalConstsKt.PLACEHOLDER, "showEmptyState", "(Lcom/avito/android/remote/orders/model/OrdersPlaceholder;)V", "", "errorMessage", "showPartScreenError", "(Ljava/lang/String;)V", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "refreshLayout", AuthSource.SEND_ABUSE, "(Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;)V", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/deep_linking/links/DeepLink;", "h", "Lio/reactivex/rxjava3/core/Observable;", "getEmptyStateClicks", "()Lio/reactivex/rxjava3/core/Observable;", "emptyStateClicks", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "e", "Lcom/jakewharton/rxrelay3/PublishRelay;", "emptyStateClicksRelay", "d", "refreshSwipesRelay", "Lcom/avito/android/orders/feature/common/viewmodel/OrderItem;", "f", "getOrderClicks", "orderClicks", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "contentRefreshLayout", "c", "emptyRefreshLayout", g.a, "getRefreshSwipes", "refreshSwipes", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/view/View;", "i", "Landroid/view/View;", "view", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "k", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "j", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/orders/feature/list/adapter/OrdersLoadMoreConsumer;", "l", "Lio/reactivex/rxjava3/functions/Consumer;", "ordersLoadMoreConsumer", "Lcom/avito/android/orders/feature/list/adapter/OrderItemClicksObservable;", "orderItemClicksObservable", "<init>", "(Landroid/view/View;Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;Lcom/avito/konveyor/adapter/AdapterPresenter;Lio/reactivex/rxjava3/functions/Consumer;Lio/reactivex/rxjava3/core/Observable;)V", "Companion", "orders_release"}, k = 1, mv = {1, 4, 2})
public final class OrdersListViewImpl implements OrdersListView {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final SwipeRefreshLayout a;
    public final RecyclerView b;
    public final SwipeRefreshLayout c;
    public final PublishRelay<Unit> d;
    public final PublishRelay<DeepLink> e;
    @NotNull
    public final Observable<OrderItem> f;
    @NotNull
    public final Observable<Unit> g;
    @NotNull
    public final Observable<DeepLink> h;
    public final View i;
    public final SimpleRecyclerAdapter j;
    public final AdapterPresenter k;
    public final Consumer<Unit> l;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/orders/feature/list/OrdersListViewImpl$Companion;", "", "", "LOADING_GAP", "I", "<init>", "()V", "orders_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a implements SwipeRefreshLayout.OnRefreshListener {
        public final /* synthetic */ OrdersListViewImpl a;

        public a(OrdersListViewImpl ordersListViewImpl) {
            this.a = ordersListViewImpl;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            this.a.d.accept(Unit.INSTANCE);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ OrdersListViewImpl a;
        public final /* synthetic */ OrdersPlaceholder b;

        public b(OrdersListViewImpl ordersListViewImpl, OrdersPlaceholder ordersPlaceholder) {
            this.a = ordersListViewImpl;
            this.b = ordersPlaceholder;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.e.accept(this.b.getButton().getDeepLink());
        }
    }

    @Inject
    public OrdersListViewImpl(@NotNull View view, @NotNull SimpleRecyclerAdapter simpleRecyclerAdapter, @NotNull AdapterPresenter adapterPresenter, @NotNull Consumer<Unit> consumer, @NotNull Observable<OrderItem> observable) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "adapter");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(consumer, "ordersLoadMoreConsumer");
        Intrinsics.checkNotNullParameter(observable, "orderItemClicksObservable");
        this.i = view;
        this.j = simpleRecyclerAdapter;
        this.k = adapterPresenter;
        this.l = consumer;
        View findViewById = view.findViewById(R.id.orders_swipe_refresh_layout);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById;
        this.a = swipeRefreshLayout;
        View findViewById2 = view.findViewById(R.id.orders_recycler_view);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.b = recyclerView;
        View findViewById3 = view.findViewById(R.id.orders_empty_swipe_refresh_layout);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
        this.c = (SwipeRefreshLayout) findViewById3;
        PublishRelay<Unit> create = PublishRelay.create();
        this.d = create;
        PublishRelay<DeepLink> create2 = PublishRelay.create();
        this.e = create2;
        this.f = observable;
        Observable<Unit> hide = create.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "refreshSwipesRelay.hide()");
        this.g = hide;
        Observable<DeepLink> hide2 = create2.hide();
        Intrinsics.checkNotNullExpressionValue(hide2, "emptyStateClicksRelay.hide()");
        this.h = hide2;
        simpleRecyclerAdapter.setHasStableIds(true);
        recyclerView.setAdapter(simpleRecyclerAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(this) { // from class: com.avito.android.orders.feature.list.OrdersListViewImpl$setupList$$inlined$with$lambda$1
            public final /* synthetic */ OrdersListViewImpl b;

            {
                this.b = r2;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView2, int i2) {
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                if (!recyclerView2.canScrollVertically(1) && i2 == 0) {
                    this.b.l.accept(Unit.INSTANCE);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView2, int i2, int i3) {
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                if (LinearLayoutManager.this.findLastVisibleItemPosition() > LinearLayoutManager.this.getItemCount() - 5 && i3 > 0 && recyclerView2.canScrollVertically(1)) {
                    this.b.l.accept(Unit.INSTANCE);
                }
            }
        });
        recyclerView.addItemDecoration(new VerticalListItemDecoration.Builder(ContextCompat.getDrawable(view.getContext(), com.avito.android.ui_components.R.drawable.recycler_view_divider)).setPadding(ViewSizeKt.getDp(16), ViewSizeKt.getDp(16)).drawForLastItem(false).build());
        a(swipeRefreshLayout);
    }

    public final void a(SwipeRefreshLayout swipeRefreshLayout) {
        Context context = swipeRefreshLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int[] pullRefreshColorScheme = ContextsKt.getPullRefreshColorScheme(context);
        swipeRefreshLayout.setColorSchemeColors(Arrays.copyOf(pullRefreshColorScheme, pullRefreshColorScheme.length));
        Context context2 = swipeRefreshLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.white));
        swipeRefreshLayout.setProgressViewOffset(true, ViewSizeKt.getDp(8), ViewSizeKt.getDp(48));
        swipeRefreshLayout.setOnRefreshListener(new a(this));
    }

    @Override // com.avito.android.orders.feature.list.OrdersListView
    @NotNull
    public Observable<DeepLink> getEmptyStateClicks() {
        return this.h;
    }

    @Override // com.avito.android.orders.feature.list.OrdersListView
    @NotNull
    public Observable<OrderItem> getOrderClicks() {
        return this.f;
    }

    @Override // com.avito.android.orders.feature.list.OrdersListView
    @NotNull
    public Observable<Unit> getRefreshSwipes() {
        return this.g;
    }

    @Override // com.avito.android.orders.feature.list.OrdersListView
    public void showContent(@NotNull List<? extends Item> list) {
        Intrinsics.checkNotNullParameter(list, "orderItems");
        Views.show(this.a);
        Views.hide(this.c);
        a2.b.a.a.a.s1(list, this.k);
    }

    @Override // com.avito.android.orders.feature.list.OrdersListView
    public void showEmptyState(@NotNull OrdersPlaceholder ordersPlaceholder) {
        Intrinsics.checkNotNullParameter(ordersPlaceholder, InternalConstsKt.PLACEHOLDER);
        Views.hide(this.a);
        Views.show(this.c);
        SwipeRefreshLayout swipeRefreshLayout = this.c;
        View findViewById = swipeRefreshLayout.findViewById(R.id.orders_empty_title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextViews.bindText$default((TextView) findViewById, ordersPlaceholder.getTitle(), false, 2, null);
        View findViewById2 = swipeRefreshLayout.findViewById(R.id.orders_empty_subtitle);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        TextViews.bindText$default((TextView) findViewById2, ordersPlaceholder.getSubtitle(), false, 2, null);
        View findViewById3 = swipeRefreshLayout.findViewById(R.id.orders_empty_button);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        Button button = (Button) findViewById3;
        button.setText(ordersPlaceholder.getButton().getTitle());
        button.setOnClickListener(new b(this, ordersPlaceholder));
        a(swipeRefreshLayout);
    }

    @Override // com.avito.android.orders.feature.list.OrdersListView
    public void showPartScreenError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        Views.showSnackBar$default(this.i, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }
}
