package com.avito.android.payment.form.status;

import a2.a.a.t1.b.n.e;
import a2.a.a.t1.b.n.f;
import a2.a.a.t1.b.n.h;
import a2.g.r.g;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.payment.ModalErrorView;
import com.avito.android.payment.ModalState;
import com.avito.android.payment.ModalView;
import com.avito.android.payment.R;
import com.avito.android.payment.form.status.ScreenState;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SimpleUserDialog;
import com.avito.android.util.CompositeConsumer;
import com.avito.android.util.CompositeConsumerKt;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Logs;
import com.avito.android.util.Toolbars;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import com.jakewharton.rxbinding3.view.RxView;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B3\u0012\u0006\u0010A\u001a\u00020>\u0012\n\u0010C\u001a\u0006\u0012\u0002\b\u00030B\u0012\u0006\u0010E\u001a\u00020D\u0012\u0006\u0010G\u001a\u00020F\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\bH\u0010IJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\"\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060$8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010\"R:\u00100\u001a&\u0012\f\u0012\n -*\u0004\u0018\u00010\u00060\u0006 -*\u0012\u0012\f\u0012\n -*\u0004\u0018\u00010\u00060\u0006\u0018\u00010,0,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\"\u00103\u001a\b\u0012\u0004\u0012\u00020\u00060$8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b1\u0010&\u001a\u0004\b2\u0010(R\"\u00108\u001a\b\u0012\u0004\u0012\u0002040 8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b5\u0010\"\u001a\u0004\b6\u00107R\"\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00060$8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b9\u0010&\u001a\u0004\b:\u0010(R:\u0010=\u001a&\u0012\f\u0012\n -*\u0004\u0018\u00010\u00060\u0006 -*\u0012\u0012\f\u0012\n -*\u0004\u0018\u00010\u00060\u0006\u0018\u00010,0,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010/R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006J"}, d2 = {"Lcom/avito/android/payment/form/status/PaymentStatusFormViewImpl;", "Lcom/avito/android/payment/form/status/PaymentStatusFormView;", "Lcom/avito/android/payment/ModalErrorView;", "Lcom/avito/android/payment/ModalView;", "", "message", "", "showModalError", "(Ljava/lang/String;)V", "Lcom/avito/android/util/CompositeConsumer;", "Lcom/avito/android/payment/form/status/ScreenState;", "l", "Lcom/avito/android/util/CompositeConsumer;", "getScreenBinding", "()Lcom/avito/android/util/CompositeConsumer;", "screenBinding", "Lcom/avito/android/progress_overlay/ProgressOverlay;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroidx/recyclerview/widget/RecyclerView;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/avito/android/util/DialogRouter;", "n", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Landroidx/appcompat/widget/Toolbar;", AuthSource.SEND_ABUSE, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lio/reactivex/functions/Consumer;", "h", "Lio/reactivex/functions/Consumer;", "overlayBinding", "Lio/reactivex/Observable;", "f", "Lio/reactivex/Observable;", "getToolbarUpClicks", "()Lio/reactivex/Observable;", "toolbarUpClicks", "i", "itemsBinding", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", "e", "Lcom/jakewharton/rxrelay2/PublishRelay;", "tempRetrySubject", g.a, "getRetryClicks", "retryClicks", "Lcom/avito/android/payment/ModalState;", "j", "getModalViewBinding", "()Lio/reactivex/functions/Consumer;", "modalViewBinding", "k", "getDialogOkClicks", "dialogOkClicks", "d", "dialogClosingEventsRelay", "Landroid/view/View;", AuthSource.OPEN_CHANNEL_LIST, "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView$Adapter;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/DialogRouter;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentStatusFormViewImpl implements PaymentStatusFormView, ModalErrorView, ModalView {
    public final Toolbar a;
    public final ProgressOverlay b;
    public final RecyclerView c;
    public PublishRelay<Unit> d = PublishRelay.create();
    public final PublishRelay<Unit> e;
    @NotNull
    public final Observable<Unit> f;
    @NotNull
    public final Observable<Unit> g;
    public final Consumer<ScreenState> h;
    public final Consumer<ScreenState> i;
    @NotNull
    public final Consumer<ModalState> j;
    @NotNull
    public final Observable<Unit> k;
    @NotNull
    public final CompositeConsumer<ScreenState> l;
    public final View m;
    public final DialogRouter n;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ PaymentStatusFormViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PaymentStatusFormViewImpl paymentStatusFormViewImpl) {
            super(0);
            this.a = paymentStatusFormViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            PublishRelay publishRelay = this.a.e;
            Unit unit = Unit.INSTANCE;
            publishRelay.accept(unit);
            return unit;
        }
    }

    public static final class b<T> implements Consumer<ScreenState> {
        public final /* synthetic */ PaymentStatusFormViewImpl a;
        public final /* synthetic */ AdapterPresenter b;
        public final /* synthetic */ RecyclerView.Adapter c;

        public b(PaymentStatusFormViewImpl paymentStatusFormViewImpl, AdapterPresenter adapterPresenter, RecyclerView.Adapter adapter) {
            this.a = paymentStatusFormViewImpl;
            this.b = adapterPresenter;
            this.c = adapter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ScreenState screenState) {
            ScreenState screenState2 = screenState;
            Logs.error$default("DEBUG BUG", screenState2.toString(), null, 4, null);
            if (screenState2 instanceof ScreenState.Content) {
                ScreenState.Content content = (ScreenState.Content) screenState2;
                this.b.onDataSourceChanged(new ListDataSource(content.getItems()));
                this.c.notifyDataSetChanged();
                this.a.a.setTitle(content.getTitle());
            }
        }
    }

    public static final class c<T> implements Consumer<ModalState> {
        public final /* synthetic */ PaymentStatusFormViewImpl a;

        public c(PaymentStatusFormViewImpl paymentStatusFormViewImpl) {
            this.a = paymentStatusFormViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ModalState modalState) {
            ModalState modalState2 = modalState;
            if (modalState2 instanceof ModalState.NotifyingDialog) {
                PaymentStatusFormViewImpl.access$showDialog(this.a, ((ModalState.NotifyingDialog) modalState2).getUserDialog());
            } else if (modalState2 instanceof ModalState.ModalError) {
                this.a.showModalError(((ModalState.ModalError) modalState2).getMessage());
            }
        }
    }

    public static final class d<T> implements Consumer<ScreenState> {
        public final /* synthetic */ PaymentStatusFormViewImpl a;

        public d(PaymentStatusFormViewImpl paymentStatusFormViewImpl) {
            this.a = paymentStatusFormViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ScreenState screenState) {
            ScreenState screenState2 = screenState;
            if (screenState2 instanceof ScreenState.Content) {
                this.a.b.showContent();
            } else if (screenState2 instanceof ScreenState.FullScreenLoading) {
                this.a.b.showLoading();
            } else if (screenState2 instanceof ScreenState.FullScreenError) {
                this.a.b.showLoadingProblem(((ScreenState.FullScreenError) screenState2).getErrorMessage());
            }
        }
    }

    public PaymentStatusFormViewImpl(@NotNull View view, @NotNull RecyclerView.Adapter<?> adapter, @NotNull AdapterPresenter adapterPresenter, @NotNull Analytics analytics, @NotNull DialogRouter dialogRouter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(dialogRouter, "dialogRouter");
        this.m = view;
        this.n = dialogRouter;
        View findViewById = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById;
        this.a = toolbar;
        int i2 = R.id.payment_form_recycler;
        View findViewById2 = view.findViewById(i2);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.c = recyclerView;
        PublishRelay<Unit> create = PublishRelay.create();
        this.e = create;
        adapter.setHasStableIds(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        View findViewById3 = view.findViewById(R.id.payment_form_content_holder);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.ViewGroup");
        ProgressOverlay progressOverlay = new ProgressOverlay((ViewGroup) findViewById3, i2, analytics, false, 0, 24, null);
        this.b = progressOverlay;
        progressOverlay.setOnRefreshListener(new a(this));
        if (view.getResources().getBoolean(com.avito.android.ui_components.R.bool.is_tablet)) {
            RxView.layoutChangeEvents(view).filter(e.a).map(f.a).subscribe(new a2.a.a.t1.b.n.g(this));
        }
        this.f = InteropKt.toV2(Toolbars.upClicks(toolbar));
        Intrinsics.checkNotNullExpressionValue(create, "tempRetrySubject");
        this.g = create;
        d dVar = new d(this);
        this.h = dVar;
        b bVar = new b(this, adapterPresenter, adapter);
        this.i = bVar;
        this.j = new c(this);
        PublishRelay<Unit> publishRelay = this.d;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "dialogClosingEventsRelay");
        this.k = publishRelay;
        this.l = CompositeConsumerKt.plus(dVar, bVar);
    }

    public static final void access$showDialog(PaymentStatusFormViewImpl paymentStatusFormViewImpl, SimpleUserDialog simpleUserDialog) {
        paymentStatusFormViewImpl.n.showSimpleNotifyingDismissDialog(simpleUserDialog.getTitle(), simpleUserDialog.getMessage(), new h(paymentStatusFormViewImpl));
    }

    @Override // com.avito.android.payment.ModalView
    @NotNull
    public Observable<Unit> getDialogOkClicks() {
        return this.k;
    }

    @Override // com.avito.android.payment.ModalView
    @NotNull
    public Consumer<ModalState> getModalViewBinding() {
        return this.j;
    }

    @Override // com.avito.android.payment.form.status.PaymentStatusFormView
    @NotNull
    public Observable<Unit> getRetryClicks() {
        return this.g;
    }

    @Override // com.avito.android.payment.form.status.PaymentStatusFormView
    @NotNull
    public Observable<Unit> getToolbarUpClicks() {
        return this.f;
    }

    @Override // com.avito.android.payment.ModalErrorView
    public void showModalError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Views.showSnackBar$default(this.m, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.payment.form.status.PaymentStatusFormView
    @NotNull
    public CompositeConsumer<ScreenState> getScreenBinding() {
        return this.l;
    }
}
