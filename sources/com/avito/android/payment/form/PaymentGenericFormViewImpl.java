package com.avito.android.payment.form;

import a2.a.a.t1.b.m;
import a2.g.r.g;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.payment.ModalErrorView;
import com.avito.android.payment.PaymentTabletViewsKt;
import com.avito.android.payment.R;
import com.avito.android.payment.form.ScreenState;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.CompositeConsumer;
import com.avito.android.util.CompositeConsumerKt;
import com.avito.android.util.RecyclerViewsKt;
import com.avito.android.util.Toolbars;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
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
import ru.avito.component.animator.ExtensibleItemAnimator;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\n\u00104\u001a\u0006\u0012\u0002\b\u000303\u0012\u0006\u00106\u001a\u000205¢\u0006\u0004\b7\u00108J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\n\u001a\u0004\b\"\u0010\fR:\u0010(\u001a&\u0012\f\u0012\n %*\u0004\u0018\u00010\u00050\u0005 %*\u0012\u0012\f\u0012\n %*\u0004\u0018\u00010\u00050\u0005\u0018\u00010$0$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\"\u00102\u001a\b\u0012\u0004\u0012\u00020\u00170-8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101¨\u00069"}, d2 = {"Lcom/avito/android/payment/form/PaymentGenericFormViewImpl;", "Lcom/avito/android/payment/form/PaymentGenericFormView;", "Lcom/avito/android/payment/ModalErrorView;", "", "message", "", "showModalError", "(Ljava/lang/String;)V", "Lio/reactivex/Observable;", "f", "Lio/reactivex/Observable;", "getRetryClicks", "()Lio/reactivex/Observable;", "retryClicks", "Landroid/view/View;", "j", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/payment/form/ScreenState;", g.a, "Lio/reactivex/functions/Consumer;", "overlayBinding", "h", "itemsBinding", "Landroidx/appcompat/widget/Toolbar;", AuthSource.SEND_ABUSE, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "e", "getToolbarUpClicks", "toolbarUpClicks", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", "d", "Lcom/jakewharton/rxrelay2/PublishRelay;", "tempRetrySubject", "Lcom/avito/android/progress_overlay/ProgressOverlay;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/android/util/CompositeConsumer;", "i", "Lcom/avito/android/util/CompositeConsumer;", "getScreenBinding", "()Lcom/avito/android/util/CompositeConsumer;", "screenBinding", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView$Adapter;Lcom/avito/android/analytics/Analytics;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentGenericFormViewImpl implements PaymentGenericFormView, ModalErrorView {
    public final Toolbar a;
    public final ProgressOverlay b;
    public final RecyclerView c;
    public final PublishRelay<Unit> d;
    @NotNull
    public final Observable<Unit> e;
    @NotNull
    public final Observable<Unit> f;
    public final Consumer<ScreenState> g;
    public final Consumer<ScreenState> h;
    @NotNull
    public final CompositeConsumer<ScreenState> i;
    public final View j;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<ScreenState> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(ScreenState screenState) {
            int i = this.a;
            if (i == 0) {
                ScreenState screenState2 = screenState;
                if (screenState2 instanceof ScreenState.Content) {
                    ScreenState.Content content = (ScreenState.Content) screenState2;
                    ((PaymentGenericFormViewImpl) this.b).a.setTitle(content.getTitle());
                    if (content.getForceKeyboard()) {
                        RecyclerViewsKt.onFocusedViewSafely$default(((PaymentGenericFormViewImpl) this.b).c, null, 0, m.a, 3, null);
                    }
                }
            } else if (i == 1) {
                ScreenState screenState3 = screenState;
                if (screenState3 instanceof ScreenState.Content) {
                    ((PaymentGenericFormViewImpl) this.b).b.showContent();
                } else if (screenState3 instanceof ScreenState.FullScreenLoading) {
                    ((PaymentGenericFormViewImpl) this.b).b.showLoading();
                } else if (screenState3 instanceof ScreenState.FullScreenError) {
                    ((PaymentGenericFormViewImpl) this.b).b.showLoadingProblem(((ScreenState.FullScreenError) screenState3).getErrorMessage());
                }
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ PaymentGenericFormViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(PaymentGenericFormViewImpl paymentGenericFormViewImpl) {
            super(0);
            this.a = paymentGenericFormViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            PublishRelay publishRelay = this.a.d;
            Unit unit = Unit.INSTANCE;
            publishRelay.accept(unit);
            return unit;
        }
    }

    public PaymentGenericFormViewImpl(@NotNull View view, @NotNull RecyclerView.Adapter<?> adapter, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.j = view;
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
        this.d = create;
        adapter.setHasStableIds(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setItemAnimator(new ExtensibleItemAnimator(false, 1, null));
        View findViewById3 = view.findViewById(R.id.payment_form_content_holder);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.ViewGroup");
        ProgressOverlay progressOverlay = new ProgressOverlay((ViewGroup) findViewById3, i2, analytics, false, 0, 24, null);
        this.b = progressOverlay;
        progressOverlay.setOnRefreshListener(new b(this));
        PaymentTabletViewsKt.setDynamicTabletPaddingsForChild(view, recyclerView);
        this.e = InteropKt.toV2(Toolbars.upClicks(toolbar));
        Intrinsics.checkNotNullExpressionValue(create, "tempRetrySubject");
        this.f = create;
        a aVar = new a(1, this);
        this.g = aVar;
        a aVar2 = new a(0, this);
        this.h = aVar2;
        this.i = CompositeConsumerKt.plus(aVar, aVar2);
    }

    @Override // com.avito.android.payment.form.PaymentGenericFormView
    @NotNull
    public Observable<Unit> getRetryClicks() {
        return this.f;
    }

    @Override // com.avito.android.payment.form.PaymentGenericFormView
    @NotNull
    public Observable<Unit> getToolbarUpClicks() {
        return this.e;
    }

    @Override // com.avito.android.payment.ModalErrorView
    public void showModalError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Views.showSnackBar$default(this.j, str, 0, (String) null, 3, (Function0) null, (Function0) null, 0, 118, (Object) null);
    }

    @Override // com.avito.android.payment.form.PaymentGenericFormView
    @NotNull
    public CompositeConsumer<ScreenState> getScreenBinding() {
        return this.i;
    }
}
