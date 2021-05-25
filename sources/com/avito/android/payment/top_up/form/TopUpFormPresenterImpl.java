package com.avito.android.payment.top_up.form;

import a2.a.a.t1.e.a.h;
import a2.a.a.t1.e.a.i;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.payment.top_up.form.ScreenState;
import com.avito.android.payment.top_up.form.TopUpFormItemConverter;
import com.avito.android.payment.top_up.form.items.bubble.BubbleItem;
import com.avito.android.payment.top_up.form.items.input.TopUpInputItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.PretendResult;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.SimpleParametersTree;
import com.avito.android.remote.model.payment.top_up.TopUpForm;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010T\u001a\u00020Q\u0012\u0006\u0010L\u001a\u00020I\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u0010&\u001a\u00020#\u0012\b\u0010W\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\bX\u0010YJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R0\u0010\u0019\u001a\u0016\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00130\u0013\u0012\u0004\u0012\u00020\u00040\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010!R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020-0\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010!R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00102R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u00102R\"\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00040<8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R.\u0010H\u001a\u0014\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u00040B8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010W\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010V¨\u0006Z"}, d2 = {"Lcom/avito/android/payment/top_up/form/TopUpFormPresenterImpl;", "Lcom/avito/android/payment/top_up/form/TopUpFormPresenter;", "Lcom/avito/android/payment/top_up/form/TopUpFormView;", "view", "", "attachView", "(Lcom/avito/android/payment/top_up/form/TopUpFormView;)V", "Lcom/avito/android/payment/top_up/form/TopUpFormRouter;", "router", "attachRouter", "(Lcom/avito/android/payment/top_up/form/TopUpFormRouter;)V", "detachView", "()V", "detachRouter", "dispose", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lkotlin/Function1;", "Lcom/avito/android/payment/top_up/form/items/bubble/BubbleItem;", "kotlin.jvm.PlatformType", "k", "Lkotlin/jvm/functions/Function1;", "getBubbleItemListener", "()Lkotlin/jvm/functions/Function1;", "bubbleItemListener", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "Lcom/avito/android/payment/top_up/form/ScreenState;", "c", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "state", "Lcom/jakewharton/rxrelay2/PublishRelay;", "e", "Lcom/jakewharton/rxrelay2/PublishRelay;", "bubbleClicks", "Lcom/avito/android/payment/top_up/form/TopUpFormItemConverter;", "p", "Lcom/avito/android/payment/top_up/form/TopUpFormItemConverter;", "itemConverter", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "d", "submitClicks", "Lcom/avito/android/payment/top_up/form/items/input/TopUpInputItem;", "f", "topUpItemChanges", "Lio/reactivex/disposables/CompositeDisposable;", a2.g.r.g.a, "Lio/reactivex/disposables/CompositeDisposable;", "routerDisposable", "i", "lifecycleDisposable", "Lcom/avito/android/util/SchedulersFactory;", "o", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "h", "viewDisposable", "Lkotlin/Function0;", "j", "Lkotlin/jvm/functions/Function0;", "getSubmitButtonListener", "()Lkotlin/jvm/functions/Function0;", "submitButtonListener", "Lkotlin/Function2;", "", "l", "Lkotlin/jvm/functions/Function2;", "getInputListener", "()Lkotlin/jvm/functions/Function2;", "inputListener", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "n", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/remote/model/payment/top_up/TopUpForm;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/payment/top_up/TopUpForm;", "topUpForm", "Lcom/avito/android/payment/top_up/form/TopUpFormInteractor;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/payment/top_up/form/TopUpFormInteractor;", "interactor", VKApiConst.Q, "Lcom/avito/android/util/Kundle;", "savedState", "<init>", "(Lcom/avito/android/payment/top_up/form/TopUpFormInteractor;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/payment/top_up/form/TopUpFormItemConverter;Lcom/avito/android/util/Kundle;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class TopUpFormPresenterImpl implements TopUpFormPresenter {
    public ParametersTree a;
    public TopUpForm b;
    public final BehaviorRelay<ScreenState> c;
    public final PublishRelay<Unit> d;
    public final PublishRelay<BubbleItem> e;
    public final PublishRelay<TopUpInputItem> f;
    public final CompositeDisposable g = new CompositeDisposable();
    public final CompositeDisposable h = new CompositeDisposable();
    public final CompositeDisposable i;
    @NotNull
    public final Function0<Unit> j;
    @NotNull
    public final Function1<BubbleItem, Unit> k;
    @NotNull
    public final Function2<TopUpInputItem, String, Unit> l;
    public final TopUpFormInteractor m;
    public final AdapterPresenter n;
    public final SchedulersFactory o;
    public final TopUpFormItemConverter p;
    public final Kundle q;

    public static final class a<T, R> implements Function<ScreenState, ObservableSource<? extends ScreenState>> {
        public final /* synthetic */ TopUpFormPresenterImpl a;

        public a(TopUpFormPresenterImpl topUpFormPresenterImpl) {
            this.a = topUpFormPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends ScreenState> apply(ScreenState screenState) {
            ScreenState screenState2 = screenState;
            Intrinsics.checkNotNullParameter(screenState2, "currentState");
            if (screenState2 instanceof ScreenState.Content) {
                TopUpFormPresenterImpl topUpFormPresenterImpl = this.a;
                TopUpFormPresenterImpl.access$bindMutableContentChanges(topUpFormPresenterImpl, TopUpFormPresenterImpl.access$getTopUpForm$p(topUpFormPresenterImpl), TopUpFormPresenterImpl.access$getParameters$p(this.a));
                return TopUpFormPresenterImpl.access$getTypeOfScreenStateWillNotChangeAnyMore$p(this.a);
            } else if (screenState2 instanceof ScreenState.FullScreenLoading) {
                return TopUpFormPresenterImpl.access$requestInitialContent(this.a);
            } else {
                if (screenState2 instanceof ScreenState.FullScreenError) {
                    return TopUpFormPresenterImpl.access$getTypeOfScreenStateWillNotChangeAnyMore$p(this.a);
                }
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public static final class b<T, R> implements Function<Unit, ObservableSource<? extends PretendResult>> {
        public final /* synthetic */ TopUpFormPresenterImpl a;

        public b(TopUpFormPresenterImpl topUpFormPresenterImpl) {
            this.a = topUpFormPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends PretendResult> apply(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return this.a.m.validateUserInput(TopUpFormPresenterImpl.access$getParameters$p(this.a));
        }
    }

    public static final class c<T> implements Predicate<PretendResult> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(PretendResult pretendResult) {
            PretendResult pretendResult2 = pretendResult;
            Intrinsics.checkNotNullParameter(pretendResult2, "pretendResult");
            return pretendResult2.getSuccess();
        }
    }

    public static final class d<T> implements Consumer<PretendResult> {
        public final /* synthetic */ TopUpFormPresenterImpl a;
        public final /* synthetic */ TopUpFormRouter b;

        public d(TopUpFormPresenterImpl topUpFormPresenterImpl, TopUpFormRouter topUpFormRouter) {
            this.a = topUpFormPresenterImpl;
            this.b = topUpFormRouter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(PretendResult pretendResult) {
            this.b.submitTopUp(TopUpFormPresenterImpl.access$getParameters$p(this.a));
        }
    }

    public static final class e<T> implements Consumer<ScreenState> {
        public final /* synthetic */ TopUpFormRouter a;

        public e(TopUpFormRouter topUpFormRouter) {
            this.a = topUpFormRouter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ScreenState screenState) {
            ScreenState screenState2 = screenState;
            if (screenState2 instanceof ScreenState.FullScreenError) {
                this.a.closeScreenWithError(((ScreenState.FullScreenError) screenState2).getErrorMessage());
            }
        }
    }

    public static final class f<T> implements Consumer<ScreenState> {
        public final /* synthetic */ TopUpFormPresenterImpl a;
        public final /* synthetic */ TopUpFormView b;

        public f(TopUpFormPresenterImpl topUpFormPresenterImpl, TopUpFormView topUpFormView) {
            this.a = topUpFormPresenterImpl;
            this.b = topUpFormView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ScreenState screenState) {
            ScreenState screenState2 = screenState;
            if (screenState2 instanceof ScreenState.Content) {
                a2.b.a.a.a.s1(((ScreenState.Content) screenState2).getDecoratedItems().getItems(), this.a.n);
            }
            this.b.getScreenBinding().accept(screenState2);
        }
    }

    public static final class g extends Lambda implements Function2<TopUpInputItem, String, Unit> {
        public final /* synthetic */ TopUpFormPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(TopUpFormPresenterImpl topUpFormPresenterImpl) {
            super(2);
            this.a = topUpFormPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(TopUpInputItem topUpInputItem, String str) {
            TopUpInputItem topUpInputItem2 = topUpInputItem;
            String str2 = str;
            Intrinsics.checkNotNullParameter(topUpInputItem2, "item");
            Intrinsics.checkNotNullParameter(str2, "newValue");
            this.a.f.accept(TopUpInputItem.copy$default(topUpInputItem2, null, str2, false, 5, null));
            return Unit.INSTANCE;
        }
    }

    public TopUpFormPresenterImpl(@NotNull TopUpFormInteractor topUpFormInteractor, @NotNull AdapterPresenter adapterPresenter, @NotNull SchedulersFactory schedulersFactory, @NotNull TopUpFormItemConverter topUpFormItemConverter, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(topUpFormInteractor, "interactor");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(topUpFormItemConverter, "itemConverter");
        this.m = topUpFormInteractor;
        this.n = adapterPresenter;
        this.o = schedulersFactory;
        this.p = topUpFormItemConverter;
        this.q = kundle;
        BehaviorRelay<ScreenState> createDefault = BehaviorRelay.createDefault(new ScreenState.FullScreenLoading());
        Intrinsics.checkNotNullExpressionValue(createDefault, "createDefault(\n        S…FullScreenLoading()\n    )");
        this.c = createDefault;
        PublishRelay<Unit> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.d = create;
        PublishRelay<BubbleItem> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.e = create2;
        PublishRelay<TopUpInputItem> create3 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create()");
        this.f = create3;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.i = compositeDisposable;
        this.j = new a2.a.a.t1.e.a.a(create);
        this.k = new Function1<T, Unit>() { // from class: com.avito.android.payment.top_up.form.TopUpFormPresenterImpl$asLambda$1
            @Override // kotlin.jvm.functions.Function1
            public final void invoke(@NotNull T t) {
                Intrinsics.checkNotNullParameter(t, "arg");
                Relay.this.accept(t);
            }
        };
        Observable<ScreenState> distinctUntilChanged = createDefault.distinctUntilChanged(TopUpFormPresenterImpl$$special$$inlined$distinctTypes$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "this.distinctUntilChange…vaClass == t2.javaClass }");
        Disposable subscribe = distinctUntilChanged.switchMap(new a(this)).subscribe(createDefault);
        Intrinsics.checkNotNullExpressionValue(subscribe, "state\n            .disti…        .subscribe(state)");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        this.l = new g(this);
    }

    public static final ScreenState access$bakeInitialContent(TopUpFormPresenterImpl topUpFormPresenterImpl, TopUpForm topUpForm) {
        topUpFormPresenterImpl.b = topUpForm;
        Kundle kundle = topUpFormPresenterImpl.q;
        ParametersTree parametersTree = kundle != null ? (ParametersTree) kundle.getParcelable("TopUpFormPresenterImpl_entered_params") : null;
        if (parametersTree == null) {
            parametersTree = new SimpleParametersTree(topUpForm.getFields(), null, 2, null);
        }
        topUpFormPresenterImpl.a = parametersTree;
        boolean z = topUpFormPresenterImpl.q == null;
        TopUpFormItemConverter topUpFormItemConverter = topUpFormPresenterImpl.p;
        TopUpForm topUpForm2 = topUpFormPresenterImpl.b;
        if (topUpForm2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topUpForm");
        }
        ParametersTree parametersTree2 = topUpFormPresenterImpl.a;
        if (parametersTree2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        }
        return TopUpFormItemConverter.DefaultImpls.convert$default(topUpFormItemConverter, topUpForm2, parametersTree2, false, z, 4, null);
    }

    public static final void access$bindMutableContentChanges(TopUpFormPresenterImpl topUpFormPresenterImpl, TopUpForm topUpForm, ParametersTree parametersTree) {
        Disposable subscribe = topUpFormPresenterImpl.e.doOnNext(new a2.a.a.t1.e.a.b(parametersTree)).map(new a2.a.a.t1.e.a.c(topUpFormPresenterImpl, topUpForm, parametersTree)).subscribe(topUpFormPresenterImpl.c);
        Disposable subscribe2 = topUpFormPresenterImpl.f.distinctUntilChanged(a2.a.a.t1.e.a.f.a).doOnNext(new a2.a.a.t1.e.a.g(parametersTree)).switchMap(new h(topUpFormPresenterImpl, parametersTree)).doOnNext(new a2.a.a.t1.e.a.d(parametersTree)).map(new a2.a.a.t1.e.a.e(topUpFormPresenterImpl, topUpForm, parametersTree)).debounce(350, TimeUnit.MILLISECONDS, topUpFormPresenterImpl.o.computation()).observeOn(topUpFormPresenterImpl.o.mainThread()).subscribe(topUpFormPresenterImpl.c);
        CompositeDisposable compositeDisposable = topUpFormPresenterImpl.i;
        Intrinsics.checkNotNullExpressionValue(subscribe2, "rebindOnVerification");
        DisposableKt.plusAssign(compositeDisposable, subscribe2);
        CompositeDisposable compositeDisposable2 = topUpFormPresenterImpl.i;
        Intrinsics.checkNotNullExpressionValue(subscribe, "rebindOnBubbleClick");
        DisposableKt.plusAssign(compositeDisposable2, subscribe);
    }

    public static final /* synthetic */ ParametersTree access$getParameters$p(TopUpFormPresenterImpl topUpFormPresenterImpl) {
        ParametersTree parametersTree = topUpFormPresenterImpl.a;
        if (parametersTree == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        }
        return parametersTree;
    }

    public static final /* synthetic */ TopUpForm access$getTopUpForm$p(TopUpFormPresenterImpl topUpFormPresenterImpl) {
        TopUpForm topUpForm = topUpFormPresenterImpl.b;
        if (topUpForm == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topUpForm");
        }
        return topUpForm;
    }

    public static final Observable access$getTypeOfScreenStateWillNotChangeAnyMore$p(TopUpFormPresenterImpl topUpFormPresenterImpl) {
        Objects.requireNonNull(topUpFormPresenterImpl);
        Observable never = Observable.never();
        Intrinsics.checkNotNullExpressionValue(never, "Observable.never<ScreenState>()");
        return never;
    }

    public static final Observable access$requestInitialContent(TopUpFormPresenterImpl topUpFormPresenterImpl) {
        Observable<R> map = topUpFormPresenterImpl.m.getTopUpForm().map(new i(topUpFormPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(map, "interactor.getTopUpForm(…)\n            }\n        }");
        return map;
    }

    @Override // com.avito.android.payment.top_up.form.TopUpFormPresenter
    public void attachRouter(@NotNull TopUpFormRouter topUpFormRouter) {
        Intrinsics.checkNotNullParameter(topUpFormRouter, "router");
        CompositeDisposable compositeDisposable = this.g;
        Disposable subscribe = this.d.switchMap(new b(this)).filter(c.a).subscribe(new d(this, topUpFormRouter));
        Intrinsics.checkNotNullExpressionValue(subscribe, "submitClicks\n           …parameters)\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.g;
        Disposable subscribe2 = this.c.subscribe(new e(topUpFormRouter));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "state\n            .subsc…          }\n            }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
    }

    @Override // com.avito.android.payment.top_up.form.TopUpFormPresenter
    public void attachView(@NotNull TopUpFormView topUpFormView) {
        Intrinsics.checkNotNullParameter(topUpFormView, "view");
        CompositeDisposable compositeDisposable = this.h;
        Disposable subscribe = this.c.observeOn(this.o.mainThread()).subscribe(new f(this, topUpFormView));
        Intrinsics.checkNotNullExpressionValue(subscribe, "state\n            .obser….accept(it)\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.payment.top_up.form.TopUpFormPresenter
    public void detachRouter() {
        this.g.clear();
    }

    @Override // com.avito.android.payment.top_up.form.TopUpFormPresenter
    public void detachView() {
        this.h.clear();
    }

    @Override // com.avito.android.payment.top_up.form.TopUpFormPresenter
    public void dispose() {
        this.i.dispose();
    }

    @Override // com.avito.android.payment.top_up.form.TopUpFormPresenter
    @NotNull
    public Function1<BubbleItem, Unit> getBubbleItemListener() {
        return this.k;
    }

    @Override // com.avito.android.payment.top_up.form.TopUpFormPresenter
    @NotNull
    public Function2<TopUpInputItem, String, Unit> getInputListener() {
        return this.l;
    }

    @Override // com.avito.android.payment.top_up.form.TopUpFormPresenter
    @NotNull
    public Function0<Unit> getSubmitButtonListener() {
        return this.j;
    }

    @Override // com.avito.android.payment.top_up.form.TopUpFormPresenter
    @NotNull
    public Kundle onSaveState() {
        Kundle kundle = new Kundle();
        ParametersTree parametersTree = this.a;
        if (parametersTree != null) {
            if (parametersTree == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
            }
            kundle.putParcelable("TopUpFormPresenterImpl_entered_params", parametersTree);
        }
        return kundle;
    }
}
