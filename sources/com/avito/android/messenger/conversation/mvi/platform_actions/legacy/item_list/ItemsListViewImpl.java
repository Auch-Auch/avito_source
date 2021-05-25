package com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list;

import a2.g.r.g;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.ChannelRootRouter;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010]\u001a\u00020\\\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u0010_\u001a\u00020^\u0012\b\u00107\u001a\u0004\u0018\u000104¢\u0006\u0004\b`\u0010aJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ)\u0010\u0011\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0013\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u001e\u0010 \u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R:\u0010(\u001a&\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00060\u0006 \u001d*\u0012\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00060\u0006\u0018\u00010%0%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u001e\u00103\u001a\n \u001d*\u0004\u0018\u000100008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0003X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR:\u0010E\u001a&\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00060\u0006 \u001d*\u0012\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00060\u0006\u0018\u00010%0%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010'R\u001e\u0010I\u001a\n \u001d*\u0004\u0018\u00010F0F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u001c\u0010M\u001a\u00020F8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bJ\u0010H\u001a\u0004\bK\u0010LR\u001e\u0010Q\u001a\n \u001d*\u0004\u0018\u00010N0N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR%\u0010X\u001a\n\u0012\u0006\b\u0001\u0012\u00020S0R8B@\u0002X\u0002¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR\u001e\u0010[\u001a\n \u001d*\u0004\u0018\u00010\u000f0\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010Z¨\u0006b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListViewImpl;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListView;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter;", "presenter", "", "bindPresenter", "(Landroidx/lifecycle/LifecycleOwner;Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter;)V", "unbindPresenter", "()V", "Landroid/view/ViewGroup;", "container", "Landroid/view/ViewGroup$LayoutParams;", "params", "Landroid/view/View;", "closeButton", "addToParent", "(Landroid/view/ViewGroup;Landroid/view/ViewGroup$LayoutParams;Landroid/view/View;)V", "removeFromParent", "(Landroid/view/ViewGroup;Landroid/view/View;)V", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter$State;", "content", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$UiData;", "uiData", "", "render", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter$State;Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$UiData;)Z", "Landroid/widget/ProgressBar;", "kotlin.jvm.PlatformType", "f", "Landroid/widget/ProgressBar;", "progress", "Landroid/view/View$OnClickListener;", "e", "Landroid/view/View$OnClickListener;", "closeClickListener", "Lcom/jakewharton/rxrelay2/PublishRelay;", "l", "Lcom/jakewharton/rxrelay2/PublishRelay;", "retryClicks", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "o", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "n", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListPresenter$State;", "lastRenderedState", "Landroid/view/LayoutInflater;", AuthSource.SEND_ABUSE, "Landroid/view/LayoutInflater;", "inflater", "Lcom/avito/android/messenger/conversation/ChannelRootRouter;", "p", "Lcom/avito/android/messenger/conversation/ChannelRootRouter;", "router", "Landroidx/recyclerview/widget/LinearLayoutManager;", "h", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "Lio/reactivex/disposables/CompositeDisposable;", AuthSource.OPEN_CHANNEL_LIST, "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Landroidx/constraintlayout/widget/ConstraintLayout;", AuthSource.BOOKING_ORDER, "Landroidx/constraintlayout/widget/ConstraintLayout;", "layout", "d", "closeClicks", "Landroid/widget/TextView;", "k", "Landroid/widget/TextView;", "errorIndicatorButton", "c", "getTitleView", "()Landroid/widget/TextView;", "titleView", "Landroidx/recyclerview/widget/RecyclerView;", g.a, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "i", "Lkotlin/Lazy;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "j", "Landroid/view/View;", "errorIndicator", "Landroid/content/Context;", "context", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "<init>", "(Landroid/content/Context;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;Lcom/avito/android/messenger/conversation/ChannelRootRouter;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ItemsListViewImpl implements ItemsListView {
    public final LayoutInflater a;
    @SuppressLint({"InflateParams"})
    public final ConstraintLayout b;
    @NotNull
    public final TextView c;
    public final PublishRelay<Unit> d = PublishRelay.create();
    public final View.OnClickListener e = new a(1, this);
    public final ProgressBar f;
    public final RecyclerView g;
    public final LinearLayoutManager h;
    public final Lazy i;
    public final View j;
    public final TextView k;
    public final PublishRelay<Unit> l;
    public final CompositeDisposable m;
    public ItemsListPresenter.State n;
    public final AdapterPresenter o;
    public final ChannelRootRouter p;

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                ((ItemsListViewImpl) this.b).l.accept(Unit.INSTANCE);
            } else if (i == 1) {
                ((ItemsListViewImpl) this.b).d.accept(Unit.INSTANCE);
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public b(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                ((ItemsListPresenter) this.b).handleRetryClick();
            } else if (i == 1) {
                ((ItemsListPresenter) this.b).handleCloseAction();
            } else {
                throw null;
            }
        }
    }

    public static final class c extends Lambda implements Function0<SimpleRecyclerAdapter> {
        public final /* synthetic */ ItemsListViewImpl a;
        public final /* synthetic */ ItemBinder b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ItemsListViewImpl itemsListViewImpl, ItemBinder itemBinder) {
            super(0);
            this.a = itemsListViewImpl;
            this.b = itemBinder;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public SimpleRecyclerAdapter invoke() {
            SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(this.a.o, this.b);
            RecyclerView recyclerView = this.a.g;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "recycler");
            recyclerView.setAdapter(simpleRecyclerAdapter);
            return simpleRecyclerAdapter;
        }
    }

    public ItemsListViewImpl(@NotNull Context context, @NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder, @Nullable ChannelRootRouter channelRootRouter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        this.o = adapterPresenter;
        this.p = channelRootRouter;
        LayoutInflater from = LayoutInflater.from(context);
        this.a = from;
        View inflate = from.inflate(R.layout.messenger_platform_items_list, (ViewGroup) null);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.b = constraintLayout;
        View findViewById = constraintLayout.findViewById(R.id.platform_items_list_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "layout.findViewById(R.id…latform_items_list_title)");
        this.c = (TextView) findViewById;
        this.f = (ProgressBar) constraintLayout.findViewById(R.id.platform_items_list_progress);
        RecyclerView recyclerView = (RecyclerView) constraintLayout.findViewById(R.id.platform_items_list_recycler);
        this.g = recyclerView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false);
        this.h = linearLayoutManager;
        this.i = t6.c.lazy(LazyThreadSafetyMode.NONE, (Function0) new c(this, itemBinder));
        View findViewById2 = constraintLayout.findViewById(R.id.platform_items_list_connection_error_indicator);
        this.j = findViewById2;
        TextView textView = (TextView) findViewById2.findViewById(R.id.connection_error_action);
        this.k = textView;
        this.l = PublishRelay.create();
        this.m = new CompositeDisposable();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recycler");
        recyclerView.setLayoutManager(linearLayoutManager);
        ((TextView) findViewById2.findViewById(R.id.connection_error_message)).setText(R.string.messenger_recommendations_error_indicator_message);
        textView.setText(R.string.messenger_recommendations_error_indicator_action_name);
        textView.setOnClickListener(new a(0, this));
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsView.ContentView
    public void addToParent(@NotNull ViewGroup viewGroup, @NotNull ViewGroup.LayoutParams layoutParams, @Nullable View view) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Intrinsics.checkNotNullParameter(layoutParams, "params");
        if (!Intrinsics.areEqual(this.b.getParent(), viewGroup)) {
            Views.removeFromParent(this.b);
            viewGroup.addView(this.b, layoutParams);
        }
        if (view != null) {
            Views.show(view);
        }
        if (view != null) {
            view.setOnClickListener(this.e);
        }
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsView.ContentView
    public void removeFromParent(@Nullable ViewGroup viewGroup, @Nullable View view) {
        if (viewGroup == null || Intrinsics.areEqual(this.b.getParent(), viewGroup)) {
            if (view != null) {
                view.setOnClickListener(null);
            }
            Views.removeFromParent(this.b);
        }
        this.n = null;
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsView.ContentView
    public void unbindPresenter() {
        this.m.clear();
    }

    public void bindPresenter(@NotNull LifecycleOwner lifecycleOwner, @NotNull ItemsListPresenter itemsListPresenter) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(itemsListPresenter, "presenter");
        PublishRelay<Unit> publishRelay = this.l;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Disposable subscribe = publishRelay.throttleFirst(500, timeUnit).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(0, itemsListPresenter));
        Intrinsics.checkNotNullExpressionValue(subscribe, "retryClicks\n            …nter.handleRetryClick() }");
        DisposableKt.addTo(subscribe, this.m);
        Disposable subscribe2 = this.d.throttleFirst(500, timeUnit).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(1, itemsListPresenter));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "closeClicks\n            …ter.handleCloseAction() }");
        DisposableKt.addTo(subscribe2, this.m);
        itemsListPresenter.getOpenItemStream().observe(lifecycleOwner, new Observer<T>(this) { // from class: com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListViewImpl$bindPresenter$$inlined$observeNotNull$1
            public final /* synthetic */ ItemsListViewImpl a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    T t2 = t;
                    ChannelRootRouter channelRootRouter = this.a.p;
                    if (channelRootRouter != null) {
                        channelRootRouter.openAdvertScreen(t2, true);
                    }
                }
            }
        });
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsView.ContentView
    @NotNull
    public TextView getTitleView() {
        return this.c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0086, code lost:
        if (r7 == r0.getShowProgress()) goto L_0x0115;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean render(@org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListPresenter.State r6, @org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter.UiData r7) {
        /*
        // Method dump skipped, instructions count: 285
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListViewImpl.render(com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListPresenter$State, com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter$UiData):boolean");
    }
}
