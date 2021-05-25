package com.avito.android.cart.summary;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.avito.android.cart.R;
import com.avito.android.cart.summary.CartSummaryView;
import com.avito.android.cart.summary.CartSummaryViewModel;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.lib.design.alert_banner.AlertBanner;
import com.avito.android.lib.design.alert_banner.AlertBannerContent;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.snackbar.SnackbarExtensionsKt;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.cart.model.Banner;
import com.avito.android.remote.cart.model.CartSummary;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.Contexts;
import com.avito.android.util.ContextsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.util.AdapterPresentersKt;
import com.jakewharton.rxbinding4.swiperefreshlayout.RxSwipeRefreshLayout;
import com.jakewharton.rxbinding4.view.RxView;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.functions.Consumer;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010T\u001a\u00020S\u0012\u0006\u00109\u001a\u000206\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010=\u001a\u00020:\u0012\f\u0010F\u001a\b\u0012\u0004\u0012\u00020C0B\u0012\u0006\u0010N\u001a\u00020K¢\u0006\u0004\bU\u0010VJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001d\u0010\u0014\u001a\u00020\u000f8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(RX\u00101\u001aD\u0012\u0016\u0012\u0014 -*\n\u0018\u00010+j\u0004\u0018\u0001`,0+j\u0002`, -*!\u0012\u0016\u0012\u0014 -*\n\u0018\u00010+j\u0004\u0018\u0001`,0+j\u0002`,\u0018\u00010*¢\u0006\u0002\b.0*¢\u0006\u0002\b.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020C0B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\"\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00040*8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bG\u00100\u001a\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010Q¨\u0006W"}, d2 = {"Lcom/avito/android/cart/summary/CartSummaryViewImpl;", "Lcom/avito/android/cart/summary/CartSummaryView;", "Lcom/avito/android/cart/summary/CartSummaryViewModel;", "viewModel", "", "bindTo", "(Lcom/avito/android/cart/summary/CartSummaryViewModel;)V", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "containerView", "Landroidx/appcompat/widget/Toolbar;", AuthSource.BOOKING_ORDER, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroidx/constraintlayout/widget/ConstraintLayout;", "e", "Lkotlin/Lazy;", "getFullCart", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "fullCart", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "h", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "l", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "recyclerAdapter", "Lcom/avito/android/util/text/AttributedTextFormatter;", "n", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "adapterPresenter", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "toolbarTitle", "Lcom/jakewharton/rxrelay3/PublishRelay;", "", "Lcom/avito/android/cart/summary/FullScreenLoading;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay3/PublishRelay;", "refreshes", "Lcom/avito/android/lib/design/button/Button;", a2.g.r.g.a, "Lcom/avito/android/lib/design/button/Button;", "submitButton", "Landroidx/lifecycle/LifecycleOwner;", "k", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "o", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "deepLinksConsumer", "Lcom/avito/android/lib/design/alert_banner/AlertBanner;", "f", "Lcom/avito/android/lib/design/alert_banner/AlertBanner;", "alertBanner", "", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "p", "Ljava/util/Set;", "decorations", "j", "getToolbarNavigationClicks", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "toolbarNavigationClicks", "Lcom/avito/android/cart/summary/CartSummaryAnalyticsTracker;", VKApiConst.Q, "Lcom/avito/android/cart/summary/CartSummaryAnalyticsTracker;", "analytics", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "i", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "emptyCart", "Landroid/view/ViewGroup;", "view", "<init>", "(Landroid/view/ViewGroup;Landroidx/lifecycle/LifecycleOwner;Landroidx/recyclerview/widget/RecyclerView$Adapter;Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;Ljava/util/Set;Lcom/avito/android/cart/summary/CartSummaryAnalyticsTracker;)V", "cart_release"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"UseCompatLoadingForDrawables"})
public final class CartSummaryViewImpl implements CartSummaryView {
    public final PublishRelay<Boolean> a = PublishRelay.create();
    public final Toolbar b;
    public final TextView c;
    public final FrameLayout d;
    public final Lazy e;
    public final AlertBanner f;
    public final Button g;
    public final ProgressOverlay h;
    public SwipeRefreshLayout i;
    @NotNull
    public final PublishRelay<Unit> j;
    public final LifecycleOwner k;
    public final RecyclerView.Adapter<BaseViewHolder> l;
    public final DataAwareAdapterPresenter m;
    public final AttributedTextFormatter n;
    public final OnDeepLinkClickListener o;
    public final Set<RecyclerView.ItemDecoration> p;
    public final CartSummaryAnalyticsTracker q;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Observer<String> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(String str) {
            int i = this.a;
            if (i == 0) {
                String str2 = str;
                FrameLayout frameLayout = ((CartSummaryViewImpl) this.b).d;
                Intrinsics.checkNotNullExpressionValue(str2, NotificationCompat.CATEGORY_MESSAGE);
                SnackbarExtensionsKt.showSnackbar$default(frameLayout, str2, 0, (String) null, 0, (Function0) null, 0, (SnackbarPosition) null, SnackbarType.ERROR, 126, (Object) null);
            } else if (i == 1) {
                String str3 = str;
                FrameLayout frameLayout2 = ((CartSummaryViewImpl) this.b).d;
                Intrinsics.checkNotNullExpressionValue(str3, NotificationCompat.CATEGORY_MESSAGE);
                SnackbarExtensionsKt.showSnackbar$default(frameLayout2, str3, 0, (String) null, 0, (Function0) null, 0, (SnackbarPosition) null, SnackbarType.DEFAULT, 126, (Object) null);
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ CartSummaryViewImpl a;

        public b(CartSummaryViewImpl cartSummaryViewImpl) {
            this.a = cartSummaryViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.jakewharton.rxrelay3.PublishRelay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            this.a.a.accept(Boolean.TRUE);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ CartSummaryViewImpl a;

        public c(CartSummaryViewImpl cartSummaryViewImpl) {
            this.a = cartSummaryViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.getToolbarNavigationClicks().accept(Unit.INSTANCE);
        }
    }

    public static final class d<T> implements io.reactivex.rxjava3.functions.Consumer<Boolean> {
        public final /* synthetic */ CartSummaryViewModel a;

        public d(CartSummaryViewModel cartSummaryViewModel) {
            this.a = cartSummaryViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            CartSummaryViewModel cartSummaryViewModel = this.a;
            Intrinsics.checkNotNullExpressionValue(bool2, "isFullScreenLoading");
            cartSummaryViewModel.onRefresh(bool2.booleanValue());
        }
    }

    public static final class e<T> implements Observer<Banner> {
        public final /* synthetic */ CartSummaryViewImpl a;

        public e(CartSummaryViewImpl cartSummaryViewImpl) {
            this.a = cartSummaryViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Banner banner) {
            AttributedText title;
            Banner banner2 = banner;
            String text = (banner2 == null || (title = banner2.getTitle()) == null) ? null : title.getText();
            if (text == null || text.length() == 0) {
                Views.enable(this.a.g);
                Views.hide(this.a.f);
                return;
            }
            Views.disable(this.a.g);
            AlertBanner alertBanner = this.a.f;
            AlertBannerContent content = alertBanner.getContent();
            AttributedTextFormatter attributedTextFormatter = this.a.n;
            Context context = this.a.f.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "alertBanner.context");
            Intrinsics.checkNotNull(banner2);
            content.setTitle(attributedTextFormatter.format(context, banner2.getTitle()));
            AlertBannerContent content2 = alertBanner.getContent();
            AttributedTextFormatter attributedTextFormatter2 = this.a.n;
            Context context2 = this.a.f.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "alertBanner.context");
            content2.setBody(attributedTextFormatter2.format(context2, banner2.getSubtitle()));
            Views.show(alertBanner);
        }
    }

    public static final class f<T> implements Observer<CartSummaryViewModel.ScreenState> {
        public final /* synthetic */ CartSummaryViewImpl a;

        public f(CartSummaryViewImpl cartSummaryViewImpl) {
            this.a = cartSummaryViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(CartSummaryViewModel.ScreenState screenState) {
            CartSummaryViewModel.ScreenState screenState2 = screenState;
            Intrinsics.checkNotNullParameter(screenState2, "state");
            if (screenState2 instanceof CartSummaryViewModel.ScreenState.Loading) {
                CartSummaryViewImpl.access$showLoading(this.a, ((CartSummaryViewModel.ScreenState.Loading) screenState2).isFullScreen());
            } else if (screenState2 instanceof CartSummaryViewModel.ScreenState.Empty) {
                CartSummaryViewImpl.access$showEmpty(this.a, ((CartSummaryViewModel.ScreenState.Empty) screenState2).getData());
            } else if (screenState2 instanceof CartSummaryViewModel.ScreenState.Loaded) {
                CartSummaryViewImpl.access$showContent(this.a, (CartSummaryViewModel.ScreenState.Loaded) screenState2);
            } else if (screenState2 instanceof CartSummaryViewModel.ScreenState.Error) {
                CartSummaryViewImpl.access$showError(this.a, ((CartSummaryViewModel.ScreenState.Error) screenState2).getMessage());
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public static final class g<T> implements Observer<CartSummaryView.SubmitButton> {
        public final /* synthetic */ CartSummaryViewImpl a;
        public final /* synthetic */ CartSummaryViewModel b;

        public g(CartSummaryViewImpl cartSummaryViewImpl, CartSummaryViewModel cartSummaryViewModel) {
            this.a = cartSummaryViewImpl;
            this.b = cartSummaryViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(CartSummaryView.SubmitButton submitButton) {
            CartSummaryView.SubmitButton submitButton2 = submitButton;
            CartSummary.Button data = submitButton2 != null ? submitButton2.getData() : null;
            Views.setVisible(this.a.g, data != null);
            if (data != null) {
                Button button = this.a.g;
                button.setText(data.getTitle());
                button.setLoading(submitButton2.isLoading());
                RxView.clicks(button).throttleFirst(500, TimeUnit.MILLISECONDS).subscribe(new a2.a.a.a0.a.e(this, data, submitButton2));
            }
        }
    }

    public static final class h<T> implements Observer<Unit> {
        public final /* synthetic */ CartSummaryViewImpl a;

        public h(CartSummaryViewImpl cartSummaryViewImpl) {
            this.a = cartSummaryViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Unit unit) {
            SwipeRefreshLayout swipeRefreshLayout = this.a.i;
            if (swipeRefreshLayout != null) {
                swipeRefreshLayout.setRefreshing(false);
            }
        }
    }

    public static final class i extends Lambda implements Function0<ConstraintLayout> {
        public final /* synthetic */ ViewGroup a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(ViewGroup viewGroup) {
            super(0);
            this.a = viewGroup;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ConstraintLayout invoke() {
            View findViewById = this.a.findViewById(R.id.full_cart);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            return (ConstraintLayout) findViewById;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r23v0, resolved type: java.util.Set<? extends androidx.recyclerview.widget.RecyclerView$ItemDecoration> */
    /* JADX WARN: Multi-variable type inference failed */
    public CartSummaryViewImpl(@NotNull ViewGroup viewGroup, @NotNull LifecycleOwner lifecycleOwner, @NotNull RecyclerView.Adapter<BaseViewHolder> adapter, @NotNull DataAwareAdapterPresenter dataAwareAdapterPresenter, @NotNull AttributedTextFormatter attributedTextFormatter, @NotNull OnDeepLinkClickListener onDeepLinkClickListener, @NotNull Set<? extends RecyclerView.ItemDecoration> set, @NotNull CartSummaryAnalyticsTracker cartSummaryAnalyticsTracker) {
        Intrinsics.checkNotNullParameter(viewGroup, "view");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(adapter, "recyclerAdapter");
        Intrinsics.checkNotNullParameter(dataAwareAdapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(onDeepLinkClickListener, "deepLinksConsumer");
        Intrinsics.checkNotNullParameter(set, "decorations");
        Intrinsics.checkNotNullParameter(cartSummaryAnalyticsTracker, "analytics");
        this.k = lifecycleOwner;
        this.l = adapter;
        this.m = dataAwareAdapterPresenter;
        this.n = attributedTextFormatter;
        this.o = onDeepLinkClickListener;
        this.p = set;
        this.q = cartSummaryAnalyticsTracker;
        View findViewById = viewGroup.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById;
        this.b = toolbar;
        View findViewById2 = viewGroup.findViewById(R.id.toolbar_title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.cart_content_container);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) findViewById3;
        this.d = frameLayout;
        this.e = t6.c.lazy(LazyThreadSafetyMode.NONE, (Function0) new i(viewGroup));
        View findViewById4 = frameLayout.findViewById(R.id.alert_banner);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.avito.android.lib.design.alert_banner.AlertBanner");
        this.f = (AlertBanner) findViewById4;
        View findViewById5 = frameLayout.findViewById(R.id.submit_button);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        this.g = (Button) findViewById5;
        ProgressOverlay progressOverlay = new ProgressOverlay(frameLayout, R.id.full_cart, null, false, 0, 28, null);
        progressOverlay.refreshes().subscribe(new b(this));
        Unit unit = Unit.INSTANCE;
        this.h = progressOverlay;
        toolbar.setNavigationOnClickListener(new c(this));
        View findViewById6 = frameLayout.findViewById(R.id.recycler_view);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById6;
        recyclerView.setLayoutManager(new LinearLayoutManager(viewGroup.getContext()));
        adapter.setHasStableIds(true);
        recyclerView.setAdapter(adapter);
        for (RecyclerView.ItemDecoration itemDecoration : set) {
            recyclerView.addItemDecoration(itemDecoration);
        }
        PublishRelay<Unit> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.j = create;
    }

    public static final void access$showContent(CartSummaryViewImpl cartSummaryViewImpl, CartSummaryViewModel.ScreenState.Loaded loaded) {
        Objects.requireNonNull(cartSummaryViewImpl);
        String component1 = loaded.component1();
        List<Item> component2 = loaded.component2();
        Views.hide(cartSummaryViewImpl.i);
        cartSummaryViewImpl.c.setText(component1);
        AdapterPresentersKt.updateItems(cartSummaryViewImpl.m, component2);
        cartSummaryViewImpl.h.showContent();
    }

    public static final void access$showEmpty(CartSummaryViewImpl cartSummaryViewImpl, CartSummary.EmptyCart emptyCart) {
        Objects.requireNonNull(cartSummaryViewImpl);
        if (emptyCart != null) {
            String title = emptyCart.getTitle();
            if (!(title == null || title.length() == 0)) {
                String component1 = emptyCart.component1();
                String component2 = emptyCart.component2();
                String component3 = emptyCart.component3();
                CartSummary.Button component4 = emptyCart.component4();
                AdapterPresentersKt.updateItems(cartSummaryViewImpl.m, CollectionsKt__CollectionsKt.emptyList());
                cartSummaryViewImpl.h.showContent();
                cartSummaryViewImpl.c.setText(component1);
                if (cartSummaryViewImpl.i == null) {
                    View findViewById = cartSummaryViewImpl.d.findViewById(R.id.stub_empty_cart);
                    Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewStub");
                    View inflate = ((ViewStub) findViewById).inflate();
                    Objects.requireNonNull(inflate, "null cannot be cast to non-null type androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
                    SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) inflate;
                    Context context = swipeRefreshLayout.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    int[] pullRefreshColorScheme = ContextsKt.getPullRefreshColorScheme(context);
                    swipeRefreshLayout.setColorSchemeColors(Arrays.copyOf(pullRefreshColorScheme, pullRefreshColorScheme.length));
                    Context context2 = swipeRefreshLayout.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.white));
                    RxSwipeRefreshLayout.refreshes(swipeRefreshLayout).subscribe(new a2.a.a.a0.a.f(cartSummaryViewImpl));
                    cartSummaryViewImpl.i = swipeRefreshLayout;
                }
                SwipeRefreshLayout swipeRefreshLayout2 = cartSummaryViewImpl.i;
                Intrinsics.checkNotNull(swipeRefreshLayout2);
                View findViewById2 = swipeRefreshLayout2.findViewById(R.id.cart_empty_title);
                Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
                TextViews.bindText$default((TextView) findViewById2, component2, false, 2, null);
                View findViewById3 = swipeRefreshLayout2.findViewById(R.id.cart_empty_subtitle);
                Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
                TextViews.bindText$default((TextView) findViewById3, component3, false, 2, null);
                if (component4 != null) {
                    View findViewById4 = swipeRefreshLayout2.findViewById(R.id.cart_empty_button);
                    Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
                    Button button = (Button) findViewById4;
                    button.setText(component4.getTitle());
                    RxView.clicks(button).throttleFirst(500, TimeUnit.MILLISECONDS).subscribe(new a2.a.a.a0.a.g(cartSummaryViewImpl, component2, component3, component4));
                }
                Views.show(swipeRefreshLayout2);
                Views.hide((ConstraintLayout) cartSummaryViewImpl.e.getValue());
                return;
            }
        }
        cartSummaryViewImpl.c.setText("");
        cartSummaryViewImpl.h.showLoadingProblem("Ошибка при показе пустой корзины");
    }

    public static final void access$showError(CartSummaryViewImpl cartSummaryViewImpl, String str) {
        cartSummaryViewImpl.c.setText("");
        cartSummaryViewImpl.h.showLoadingProblem(str);
    }

    public static final void access$showLoading(CartSummaryViewImpl cartSummaryViewImpl, boolean z) {
        Objects.requireNonNull(cartSummaryViewImpl);
        if (z) {
            cartSummaryViewImpl.c.setText("");
            cartSummaryViewImpl.h.showLoading();
        }
    }

    @Override // com.avito.android.cart.summary.CartSummaryView
    public void bindTo(@NotNull CartSummaryViewModel cartSummaryViewModel) {
        Intrinsics.checkNotNullParameter(cartSummaryViewModel, "viewModel");
        this.a.subscribe(new d(cartSummaryViewModel));
        cartSummaryViewModel.getAlertBannerChanges().observe(this.k, new e(this));
        cartSummaryViewModel.getScreenStateChanges().observe(this.k, new f(this));
        cartSummaryViewModel.getSubmitButtonChanges().observe(this.k, new g(this, cartSummaryViewModel));
        cartSummaryViewModel.getStopRefresh().observe(this.k, new h(this));
        cartSummaryViewModel.getSnackbarErrorMessagesChanges().observe(this.k, new a(0, this));
        cartSummaryViewModel.getSnackbarInfoMessagesChanges().observe(this.k, new a(1, this));
    }

    @Override // com.avito.android.cart.summary.CartSummaryView
    @NotNull
    public PublishRelay<Unit> getToolbarNavigationClicks() {
        return this.j;
    }
}
