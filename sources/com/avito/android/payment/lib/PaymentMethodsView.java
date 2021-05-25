package com.avito.android.payment.lib;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.lib.design.button.Button;
import com.avito.android.payment.ModalState;
import com.avito.android.payment.lib.PaymentMethodsViewModel;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SimpleUserDialog;
import com.avito.android.section.GravitySnapHelper;
import com.avito.android.ui_components.R;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.SimpleUserDialogsKt;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.data_source.ListDataSource;
import com.jakewharton.rxbinding3.view.RxView;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u0010O\u001a\u00020L\u0012\u0006\u0010K\u001a\u00020H\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00060\u0012\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00060\u0012\u0012\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\u00060\u0012¢\u0006\u0004\b\\\u0010]J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001e\u0010\u0011\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00060\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001e\u001a\n \u000e*\u0004\u0018\u00010\u001b0\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001e\u0010\"\u001a\n \u000e*\u0004\u0018\u00010\u001f0\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001e\u0010&\u001a\n \u000e*\u0004\u0018\u00010#0#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001e\u0010,\u001a\n \u000e*\u0004\u0018\u00010\u001f0\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010!R\"\u0010/\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00060\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010\u0015R:\u00104\u001a&\u0012\f\u0012\n \u000e*\u0004\u0018\u00010101 \u000e*\u0012\u0012\f\u0012\n \u000e*\u0004\u0018\u00010101\u0018\u000100008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u001e\u00106\u001a\n \u000e*\u0004\u0018\u00010\u001b0\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u0010\u001dR\u001e\u00108\u001a\n \u000e*\u0004\u0018\u00010\u001b0\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u0010\u001dR:\u0010<\u001a&\u0012\f\u0012\n \u000e*\u0004\u0018\u00010101 \u000e*\u0012\u0012\f\u0012\n \u000e*\u0004\u0018\u00010101\u0018\u000109098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\"\u0010?\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\u00060\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010\u0015R\u001e\u0010C\u001a\n \u000e*\u0004\u0018\u00010@0@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u001e\u0010G\u001a\n \u000e*\u0004\u0018\u00010D0D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u001e\u0010S\u001a\n \u000e*\u0004\u0018\u00010P0P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u001e\u0010W\u001a\n \u000e*\u0004\u0018\u00010T0T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010Z¨\u0006^"}, d2 = {"Lcom/avito/android/payment/lib/PaymentMethodsView;", "", "Lcom/avito/android/payment/lib/PaymentMethodsViewModel;", "paymentMethodsViewModel", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "", "bindTo", "(Lcom/avito/android/payment/lib/PaymentMethodsViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "Lcom/avito/android/util/DialogRouter;", "s", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Landroid/widget/ImageButton;", "kotlin.jvm.PlatformType", "j", "Landroid/widget/ImageButton;", "closeButton", "Lkotlin/Function1;", "", "u", "Lkotlin/jvm/functions/Function1;", "onUriListener", "Lio/reactivex/disposables/CompositeDisposable;", AuthSource.SEND_ABUSE, "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/lib/design/button/Button;", a2.g.r.g.a, "Lcom/avito/android/lib/design/button/Button;", "googlePayButton", "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "error", "Lru/tinkoff/scrollingpagerindicator/ScrollingPagerIndicator;", "k", "Lru/tinkoff/scrollingpagerindicator/ScrollingPagerIndicator;", "scrollingPagerIndicator", "Landroid/view/View;", "p", "Landroid/view/View;", "view", AuthSource.BOOKING_ORDER, "content", "Lcom/avito/android/deep_linking/links/DeepLink;", "t", "onDeeplinkListener", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "", "o", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "suppressButtonClicks", "l", "refreshButton", "i", "payButton", "Lcom/jakewharton/rxrelay2/PublishRelay;", "n", "Lcom/jakewharton/rxrelay2/PublishRelay;", "dialogClosingEventsRelay", "Lcom/avito/android/payment/lib/PaymentResult;", VKApiConst.VERSION, "onClosePaymentScreen", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "errorTextView", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "r", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "recyclerViewAdapter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", VKApiConst.Q, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Landroid/widget/Space;", "h", "Landroid/widget/Space;", "spaceBetweenButtons", "Landroid/widget/FrameLayout;", "c", "Landroid/widget/FrameLayout;", "loadingIndicator", "Lcom/avito/android/section/GravitySnapHelper;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/section/GravitySnapHelper;", "pagingSnapHelper", "<init>", "(Landroid/view/View;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;Lcom/avito/android/util/DialogRouter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "payment-lib_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentMethodsView {
    public final CompositeDisposable a = new CompositeDisposable();
    public final LinearLayout b;
    public final FrameLayout c;
    public final LinearLayout d;
    public final TextView e;
    public final RecyclerView f;
    public final Button g;
    public final Space h;
    public final Button i;
    public final ImageButton j;
    public final ScrollingPagerIndicator k;
    public final Button l;
    public final GravitySnapHelper m;
    public final PublishRelay<Boolean> n;
    public final BehaviorRelay<Boolean> o;
    public final View p;
    public final AdapterPresenter q;
    public final SimpleRecyclerAdapter r;
    public final DialogRouter s;
    public final Function1<DeepLink, Unit> t;
    public final Function1<String, Unit> u;
    public final Function1<PaymentResult, Unit> v;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Observer<Boolean> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: com.jakewharton.rxrelay2.BehaviorRelay */
        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.jakewharton.rxrelay2.BehaviorRelay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Boolean bool) {
            int i = this.a;
            if (i == 0) {
                Boolean bool2 = bool;
                if (bool2 != null) {
                    bool2.booleanValue();
                    ((PaymentMethodsView) this.b).i.setLoading(bool2.booleanValue());
                    ((PaymentMethodsView) this.b).o.accept(bool2);
                }
            } else if (i == 1) {
                Boolean bool3 = bool;
                if (bool3 != null) {
                    bool3.booleanValue();
                    ((PaymentMethodsView) this.b).g.setLoading(bool3.booleanValue());
                    ((PaymentMethodsView) this.b).o.accept(bool3);
                }
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b<T> implements Observer<String> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public b(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(String str) {
            int i = this.a;
            if (i == 0) {
                String str2 = str;
                if (str2 != null) {
                    ((PaymentMethodsView) this.b).i.setText(str2);
                }
            } else if (i == 1) {
                String str3 = str;
                if (str3 != null) {
                    ((PaymentMethodsView) this.b).u.invoke(str3);
                }
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class c<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public c(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                ((PaymentMethodsViewModel) this.b).onRefreshButtonClick();
            } else if (i == 1) {
                ((PaymentMethodsViewModel) this.b).onCloseButtonClick();
            } else {
                throw null;
            }
        }
    }

    public static final class d<T> implements Observer<PaymentResult> {
        public final /* synthetic */ PaymentMethodsView a;

        public d(PaymentMethodsView paymentMethodsView) {
            this.a = paymentMethodsView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(PaymentResult paymentResult) {
            PaymentResult paymentResult2 = paymentResult;
            if (paymentResult2 != null) {
                this.a.v.invoke(paymentResult2);
            }
        }
    }

    public static final class e<T> implements Consumer<Pair<? extends Unit, ? extends Boolean>> {
        public final /* synthetic */ PaymentMethodsView a;
        public final /* synthetic */ PaymentMethodsViewModel b;

        public e(PaymentMethodsView paymentMethodsView, PaymentMethodsViewModel paymentMethodsViewModel) {
            this.a = paymentMethodsView;
            this.b = paymentMethodsViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.jakewharton.rxrelay2.BehaviorRelay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Pair<? extends Unit, ? extends Boolean> pair) {
            if (!((Boolean) pair.component2()).booleanValue()) {
                this.b.onGooglePayButtonClick();
                this.a.o.accept(Boolean.TRUE);
            }
        }
    }

    public static final class f<T> implements Consumer<Pair<? extends Unit, ? extends Boolean>> {
        public final /* synthetic */ PaymentMethodsViewModel a;

        public f(PaymentMethodsViewModel paymentMethodsViewModel) {
            this.a = paymentMethodsViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Pair<? extends Unit, ? extends Boolean> pair) {
            if (!((Boolean) pair.component2()).booleanValue()) {
                this.a.onSubmitPaymentButtonClick();
            }
        }
    }

    public static final class g<T> implements Consumer<Boolean> {
        public final /* synthetic */ PaymentMethodsViewModel a;

        public g(PaymentMethodsViewModel paymentMethodsViewModel) {
            this.a = paymentMethodsViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            PaymentMethodsViewModel paymentMethodsViewModel = this.a;
            Intrinsics.checkNotNullExpressionValue(bool2, "it");
            paymentMethodsViewModel.onDialogClosed(bool2.booleanValue());
        }
    }

    public static final class h<T> implements Observer<PaymentMethodsViewModel.ViewState> {
        public final /* synthetic */ PaymentMethodsView a;
        public final /* synthetic */ Ref.ObjectRef b;

        public h(PaymentMethodsView paymentMethodsView, Ref.ObjectRef objectRef) {
            this.a = paymentMethodsView;
            this.b = objectRef;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(PaymentMethodsViewModel.ViewState viewState) {
            PaymentMethodsViewModel.ViewState viewState2 = viewState;
            if (viewState2 == null) {
                return;
            }
            if (viewState2 instanceof PaymentMethodsViewModel.ViewState.PaymentMethodsList) {
                this.a.q.onDataSourceChanged(new ListDataSource(((PaymentMethodsViewModel.ViewState.PaymentMethodsList) viewState2).getPaymentMethods()));
                RecyclerView recyclerView = this.a.f;
                Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                }
                this.a.f.post(new a2.a.a.t1.c.a(this));
                Views.show(this.a.b);
                Views.hide(this.a.c);
                Views.hide(this.a.d);
            } else if (viewState2 instanceof PaymentMethodsViewModel.ViewState.Loading) {
                Views.hide(this.a.b);
                Views.show(this.a.c);
                Views.hide(this.a.d);
            } else if (viewState2 instanceof PaymentMethodsViewModel.ViewState.Error) {
                Views.hide(this.a.b);
                Views.hide(this.a.c);
                Views.show(this.a.d);
                TextView textView = this.a.e;
                Intrinsics.checkNotNullExpressionValue(textView, "errorTextView");
                textView.setText(((PaymentMethodsViewModel.ViewState.Error) viewState2).getMessage());
            }
        }
    }

    public static final class i<T> implements Observer<PaymentMethodsViewModel.GooglePayViewState> {
        public final /* synthetic */ PaymentMethodsView a;

        public i(PaymentMethodsView paymentMethodsView) {
            this.a = paymentMethodsView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(PaymentMethodsViewModel.GooglePayViewState googlePayViewState) {
            PaymentMethodsViewModel.GooglePayViewState googlePayViewState2 = googlePayViewState;
            if (googlePayViewState2 == null) {
                return;
            }
            if (googlePayViewState2 instanceof PaymentMethodsViewModel.GooglePayViewState.Available) {
                Views.show(this.a.h);
                Views.show(this.a.g);
            } else if (googlePayViewState2 instanceof PaymentMethodsViewModel.GooglePayViewState.Unavailable) {
                Views.hide(this.a.h);
                Views.hide(this.a.g);
            }
        }
    }

    public static final class j<T> implements Observer<Integer> {
        public final /* synthetic */ PaymentMethodsView a;
        public final /* synthetic */ Ref.ObjectRef b;

        public j(PaymentMethodsView paymentMethodsView, Ref.ObjectRef objectRef) {
            this.a = paymentMethodsView;
            this.b = objectRef;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Integer num) {
            T t = (T) num;
            if (t != null) {
                t.intValue();
                this.b.element = t;
                RecyclerView recyclerView = this.a.f;
                Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null) {
                    Intrinsics.checkNotNullExpressionValue(layoutManager, "recyclerView.layoutManager ?: return@Observer");
                    View findViewByPosition = layoutManager.findViewByPosition(t.intValue());
                    if (findViewByPosition != null) {
                        Intrinsics.checkNotNullExpressionValue(findViewByPosition, "layoutManager.findViewBy…ition) ?: return@Observer");
                        this.a.f.smoothScrollBy(this.a.m.calculateDistanceToFinalSnap(layoutManager, findViewByPosition)[0], 0);
                        this.b.element = null;
                    }
                }
            }
        }
    }

    public static final class k<T> implements Observer<DeepLink> {
        public final /* synthetic */ PaymentMethodsView a;

        public k(PaymentMethodsView paymentMethodsView) {
            this.a = paymentMethodsView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(DeepLink deepLink) {
            DeepLink deepLink2 = deepLink;
            if (deepLink2 != null) {
                this.a.t.invoke(deepLink2);
            }
        }
    }

    public static final class l<T> implements Observer<ModalState> {
        public final /* synthetic */ PaymentMethodsView a;

        public l(PaymentMethodsView paymentMethodsView) {
            this.a = paymentMethodsView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(ModalState modalState) {
            SimpleUserDialog simpleUserDialog;
            ModalState modalState2 = modalState;
            if (modalState2 == null) {
                return;
            }
            if (modalState2 instanceof ModalState.NotifyingDialog) {
                ModalState.NotifyingDialog notifyingDialog = (ModalState.NotifyingDialog) modalState2;
                PaymentMethodsView.access$showDialog(this.a, notifyingDialog.getUserDialog(), notifyingDialog.getShouldCloseActivityOnDismiss());
            } else if (modalState2 instanceof ModalState.ModalError) {
                PaymentMethodsView.access$showModalError(this.a, ((ModalState.ModalError) modalState2).getMessage());
            } else if (modalState2 instanceof ModalState.SBOLResultDialog) {
                if (((ModalState.SBOLResultDialog) modalState2).getSuccess()) {
                    String string = this.a.p.getContext().getString(R.string.payment_in_progress);
                    Intrinsics.checkNotNullExpressionValue(string, "view.context.getString(R…ring.payment_in_progress)");
                    String string2 = this.a.p.getContext().getString(R.string.payment_will_be_processed);
                    Intrinsics.checkNotNullExpressionValue(string2, "view.context.getString(R…ayment_will_be_processed)");
                    simpleUserDialog = new SimpleUserDialog(string, string2, null);
                } else {
                    String string3 = this.a.p.getContext().getString(R.string.payment_error);
                    Intrinsics.checkNotNullExpressionValue(string3, "view.context.getString(R.string.payment_error)");
                    String string4 = this.a.p.getContext().getString(R.string.try_later_or_choose_another_payment_method);
                    Intrinsics.checkNotNullExpressionValue(string4, "view.context.getString(R…e_another_payment_method)");
                    simpleUserDialog = new SimpleUserDialog(string3, string4, null);
                }
                PaymentMethodsView.access$showDialog(this.a, simpleUserDialog, true);
            } else if (modalState2 instanceof ModalState.SBOLAppLaunchError) {
                PaymentMethodsView paymentMethodsView = this.a;
                String string5 = paymentMethodsView.p.getContext().getString(R.string.sbol_app_doesnt_exist);
                Intrinsics.checkNotNullExpressionValue(string5, "view.context.getString(R…ng.sbol_app_doesnt_exist)");
                PaymentMethodsView.access$showModalError(paymentMethodsView, string5);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: kotlin.jvm.functions.Function1<? super com.avito.android.deep_linking.links.DeepLink, kotlin.Unit> */
    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> */
    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: kotlin.jvm.functions.Function1<? super com.avito.android.payment.lib.PaymentResult, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public PaymentMethodsView(@NotNull View view, @NotNull AdapterPresenter adapterPresenter, @NotNull SimpleRecyclerAdapter simpleRecyclerAdapter, @NotNull DialogRouter dialogRouter, @NotNull Function1<? super DeepLink, Unit> function1, @NotNull Function1<? super String, Unit> function12, @NotNull Function1<? super PaymentResult, Unit> function13) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "recyclerViewAdapter");
        Intrinsics.checkNotNullParameter(dialogRouter, "dialogRouter");
        Intrinsics.checkNotNullParameter(function1, "onDeeplinkListener");
        Intrinsics.checkNotNullParameter(function12, "onUriListener");
        Intrinsics.checkNotNullParameter(function13, "onClosePaymentScreen");
        this.p = view;
        this.q = adapterPresenter;
        this.r = simpleRecyclerAdapter;
        this.s = dialogRouter;
        this.t = function1;
        this.u = function12;
        this.v = function13;
        this.b = (LinearLayout) view.findViewById(R.id.content_container);
        this.c = (FrameLayout) view.findViewById(R.id.loading_indicator);
        this.d = (LinearLayout) view.findViewById(R.id.error);
        this.e = (TextView) view.findViewById(R.id.error_text_view);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        this.f = recyclerView;
        Button button = (Button) view.findViewById(R.id.payment_google_pay);
        button.setImageResource(R.drawable.ic_payment_gpay_logo);
        this.g = button;
        this.h = (Space) view.findViewById(R.id.space_between_buttons);
        this.i = (Button) view.findViewById(R.id.payment_submit_button);
        this.j = (ImageButton) view.findViewById(R.id.close_payment_methods_button);
        this.k = (ScrollingPagerIndicator) view.findViewById(R.id.indicator);
        this.l = (Button) view.findViewById(R.id.error_refresh_button);
        this.m = new GravitySnapHelper(GravityCompat.START, 0, 2, null);
        this.n = PublishRelay.create();
        this.o = BehaviorRelay.createDefault(Boolean.FALSE);
        final int dimensionPixelSize = a2.b.a.a.a.u1(view, "view.context").getDimensionPixelSize(R.dimen.payment_method_list_card_material_horizontal_margin);
        final GravitySnapHelper gravitySnapHelper = new GravitySnapHelper(GravityCompat.START, 0, 2, null);
        simpleRecyclerAdapter.setHasStableIds(true);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), 0, false));
        recyclerView.setHasFixedSize(true);
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.avito.android.payment.lib.PaymentMethodsView.1
            public final /* synthetic */ PaymentMethodsView a;

            {
                this.a = r1;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                LinearLayout linearLayout = this.a.b;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "content");
                int width = linearLayout.getWidth();
                if (width > 0) {
                    RecyclerView recyclerView2 = this.a.f;
                    RecyclerView recyclerView3 = this.a.f;
                    Intrinsics.checkNotNullExpressionValue(recyclerView3, "recyclerView");
                    int paddingLeft = recyclerView3.getPaddingLeft();
                    RecyclerView recyclerView4 = this.a.f;
                    Intrinsics.checkNotNullExpressionValue(recyclerView4, "recyclerView");
                    RecyclerView recyclerView5 = this.a.f;
                    Intrinsics.checkNotNullExpressionValue(recyclerView5, "recyclerView");
                    recyclerView2.setPadding(paddingLeft, recyclerView4.getPaddingTop(), width - (((int) ((((float) width) / 7.0f) * 4.0f)) - (dimensionPixelSize * 2)), recyclerView5.getPaddingBottom());
                    RecyclerView recyclerView6 = this.a.f;
                    Intrinsics.checkNotNullExpressionValue(recyclerView6, "recyclerView");
                    recyclerView6.setAdapter(this.a.r);
                    gravitySnapHelper.attachToRecyclerView(this.a.f);
                    this.a.k.attachToRecyclerView(this.a.f, dimensionPixelSize * 6);
                    int dimensionPixelSize2 = this.a.p.getResources().getDimensionPixelSize(R.dimen.payment_method_list_button_bar_padding);
                    int dimensionPixelSize3 = this.a.p.getResources().getDimensionPixelSize(R.dimen.payment_method_list_space_between_blocks_size);
                    Button button2 = this.a.g;
                    Intrinsics.checkNotNullExpressionValue(button2, "googlePayButton");
                    ViewGroup.LayoutParams layoutParams = button2.getLayoutParams();
                    layoutParams.width = (int) ((((float) 2) * (((float) ((width - (dimensionPixelSize2 * 2)) - (dimensionPixelSize3 * 4))) / 5.0f)) + ((float) dimensionPixelSize3));
                    Button button3 = this.a.g;
                    Intrinsics.checkNotNullExpressionValue(button3, "googlePayButton");
                    button3.setLayoutParams(layoutParams);
                    RecyclerView recyclerView7 = this.a.f;
                    Intrinsics.checkNotNullExpressionValue(recyclerView7, "recyclerView");
                    recyclerView7.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        });
    }

    public static final void access$showDialog(PaymentMethodsView paymentMethodsView, SimpleUserDialog simpleUserDialog, boolean z) {
        SimpleUserDialogsKt.show(simpleUserDialog, paymentMethodsView.s, new a2.a.a.t1.c.b(paymentMethodsView, z));
    }

    public static final void access$showModalError(PaymentMethodsView paymentMethodsView, String str) {
        Views.showSnackBar$default(paymentMethodsView.p, str, 0, (String) null, 3, (Function0) null, (Function0) null, 0, 118, (Object) null);
    }

    public final void bindTo(@NotNull PaymentMethodsViewModel paymentMethodsViewModel, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(paymentMethodsViewModel, "paymentMethodsViewModel");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        paymentMethodsViewModel.getViewStateLiveData().observe(lifecycleOwner, new h(this, objectRef));
        paymentMethodsViewModel.getGooglePayViewState().observe(lifecycleOwner, new i(this));
        paymentMethodsViewModel.getPayButtonCaptionLiveData().observe(lifecycleOwner, new b(0, this));
        paymentMethodsViewModel.getSelectedPaymentMethodPositionLiveData().observe(lifecycleOwner, new j(this, objectRef));
        paymentMethodsViewModel.getDeepLinkLiveData().observe(lifecycleOwner, new k(this));
        paymentMethodsViewModel.getUriLiveData().observe(lifecycleOwner, new b(1, this));
        paymentMethodsViewModel.getSubmitButtonInLoadingState().observe(lifecycleOwner, new a(0, this));
        paymentMethodsViewModel.getGooglePayButtonIsInLoadingState().observe(lifecycleOwner, new a(1, this));
        paymentMethodsViewModel.getDialogLiveData().observe(lifecycleOwner, new l(this));
        paymentMethodsViewModel.getClosePaymentScreenEvent().observe(lifecycleOwner, new d(this));
        CompositeDisposable compositeDisposable = this.a;
        Button button = this.l;
        Intrinsics.checkNotNullExpressionValue(button, "refreshButton");
        Disposable subscribe = RxView.clicks(button).subscribe(new c(0, paymentMethodsViewModel));
        Intrinsics.checkNotNullExpressionValue(subscribe, "refreshButton.clicks().s…shButtonClick()\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.a;
        ImageButton imageButton = this.j;
        Intrinsics.checkNotNullExpressionValue(imageButton, "closeButton");
        Disposable subscribe2 = RxView.clicks(imageButton).subscribe(new c(1, paymentMethodsViewModel));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "closeButton.clicks().sub…seButtonClick()\n        }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.a;
        Button button2 = this.g;
        Intrinsics.checkNotNullExpressionValue(button2, "googlePayButton");
        Observable<Unit> clicks = RxView.clicks(button2);
        BehaviorRelay<Boolean> behaviorRelay = this.o;
        Intrinsics.checkNotNullExpressionValue(behaviorRelay, "suppressButtonClicks");
        Observable<R> withLatestFrom = clicks.withLatestFrom(behaviorRelay, PaymentMethodsView$bindTo$$inlined$withLatestFrom$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(withLatestFrom, "withLatestFrom(other, Bi…n { t1, t2 -> t1 to t2 })");
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Disposable subscribe3 = withLatestFrom.throttleFirst(300, timeUnit).subscribe(new e(this, paymentMethodsViewModel));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "googlePayButton.clicks()…          }\n            }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.a;
        Button button3 = this.i;
        Intrinsics.checkNotNullExpressionValue(button3, "payButton");
        Observable<Unit> clicks2 = RxView.clicks(button3);
        BehaviorRelay<Boolean> behaviorRelay2 = this.o;
        Intrinsics.checkNotNullExpressionValue(behaviorRelay2, "suppressButtonClicks");
        Observable<R> withLatestFrom2 = clicks2.withLatestFrom(behaviorRelay2, PaymentMethodsView$bindTo$$inlined$withLatestFrom$2.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(withLatestFrom2, "withLatestFrom(other, Bi…n { t1, t2 -> t1 to t2 })");
        Disposable subscribe4 = withLatestFrom2.throttleFirst(300, timeUnit).subscribe(new f(paymentMethodsViewModel));
        Intrinsics.checkNotNullExpressionValue(subscribe4, "payButton.clicks().withL…ttonClick()\n            }");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        CompositeDisposable compositeDisposable5 = this.a;
        Disposable subscribe5 = this.n.subscribe(new g(paymentMethodsViewModel));
        Intrinsics.checkNotNullExpressionValue(subscribe5, "dialogClosingEventsRelay…ialogClosed(it)\n        }");
        DisposableKt.plusAssign(compositeDisposable5, subscribe5);
    }
}
