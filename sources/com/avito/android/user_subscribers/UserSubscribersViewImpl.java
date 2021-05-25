package com.avito.android.user_subscribers;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.user_subscribers.adapter.UserSubscriberItem;
import com.avito.android.util.Contexts;
import com.avito.android.util.ContextsKt;
import com.avito.android.util.Views;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.data_source.DataSource;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010%\u001a\u00020\u0015\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006*"}, d2 = {"Lcom/avito/android/user_subscribers/UserSubscribersViewImpl;", "Lcom/avito/android/user_subscribers/UserSubscribersView;", "Lio/reactivex/Observable;", "", "refreshClicks", "()Lio/reactivex/Observable;", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/user_subscribers/adapter/UserSubscriberItem;", "dataSource", "setItems", "(Lcom/avito/konveyor/data_source/DataSource;)V", "", "show", "showEmptyState", "(Z)V", "hideRefreshProgress", "()V", "Landroid/view/ViewGroup;", AuthSource.BOOKING_ORDER, "Landroid/view/ViewGroup;", "emptyState", "Landroid/view/View;", "d", "Landroid/view/View;", "shadow", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "c", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "refreshLayout", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "e", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "view", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "<init>", "(Landroid/view/View;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)V", "user-subscribers_release"}, k = 1, mv = {1, 4, 2})
public final class UserSubscribersViewImpl implements UserSubscribersView {
    public final RecyclerView a;
    public final ViewGroup b;
    public final SwipeRefreshLayout c;
    public final View d;
    public final AdapterPresenter e;

    public static final class a<T> implements ObservableOnSubscribe<Unit> {
        public final /* synthetic */ UserSubscribersViewImpl a;

        /* renamed from: com.avito.android.user_subscribers.UserSubscribersViewImpl$a$a  reason: collision with other inner class name */
        public static final class C0164a implements SwipeRefreshLayout.OnRefreshListener {
            public final /* synthetic */ ObservableEmitter a;

            public C0164a(ObservableEmitter observableEmitter) {
                this.a = observableEmitter;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: io.reactivex.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                this.a.onNext(Unit.INSTANCE);
            }
        }

        public a(UserSubscribersViewImpl userSubscribersViewImpl) {
            this.a = userSubscribersViewImpl;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(@NotNull ObservableEmitter<Unit> observableEmitter) {
            Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
            this.a.c.setOnRefreshListener(new C0164a(observableEmitter));
        }
    }

    public UserSubscribersViewImpl(@NotNull View view, @NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        this.e = adapterPresenter;
        View findViewById = view.findViewById(R.id.recycler);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.a = recyclerView;
        View findViewById2 = view.findViewById(R.id.empty_state);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.ViewGroup");
        this.b = (ViewGroup) findViewById2;
        View findViewById3 = view.findViewById(R.id.swipe_refresh_layout);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById3;
        this.c = swipeRefreshLayout;
        View findViewById4 = view.findViewById(R.id.shadow);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.d = findViewById4;
        View findViewById5 = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        ((Toolbar) findViewById5).setTitle(R.string.user_subscribers_title);
        Context context = swipeRefreshLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int[] pullRefreshColorScheme = ContextsKt.getPullRefreshColorScheme(context);
        swipeRefreshLayout.setColorSchemeColors(Arrays.copyOf(pullRefreshColorScheme, pullRefreshColorScheme.length));
        Context context2 = swipeRefreshLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.white));
        recyclerView.setAdapter(new SimpleRecyclerAdapter(adapterPresenter, itemBinder));
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(this) { // from class: com.avito.android.user_subscribers.UserSubscribersViewImpl.2
            public final /* synthetic */ UserSubscribersViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView2, int i, int i2) {
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                Views.setVisible(this.a.d, recyclerView2.canScrollVertically(-1));
            }
        });
    }

    @Override // com.avito.android.user_subscribers.UserSubscribersView
    public void hideRefreshProgress() {
        this.c.setRefreshing(false);
    }

    @Override // com.avito.android.user_subscribers.UserSubscribersView
    @NotNull
    public Observable<Unit> refreshClicks() {
        Observable<Unit> create = Observable.create(new a(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…tter.onNext(Unit) }\n    }");
        return create;
    }

    @Override // com.avito.android.user_subscribers.UserSubscribersView
    public void setItems(@NotNull DataSource<UserSubscriberItem> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.e.onDataSourceChanged(dataSource);
        RecyclerView.Adapter adapter = this.a.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.avito.android.user_subscribers.UserSubscribersView
    public void showEmptyState(boolean z) {
        Views.setVisible(this.b, z);
    }
}
