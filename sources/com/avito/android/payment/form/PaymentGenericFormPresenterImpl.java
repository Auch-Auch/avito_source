package com.avito.android.payment.form;

import a2.a.a.t1.b.h;
import a2.a.a.t1.b.i;
import a2.a.a.t1.b.j;
import a2.a.a.t1.b.k;
import a2.a.a.t1.b.l;
import a2.g.r.g;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.conveyor_shared_item.phone_item.PhoneInputItem;
import com.avito.android.items.InputItem;
import com.avito.android.payment.form.ScreenState;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.CharParameter;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.SimpleParametersTree;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.payment.form.PaymentGenericFormResult;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010<\u001a\u000209\u0012\u0006\u0010B\u001a\u00020?\u0012\u0006\u0010J\u001a\u00020G\u0012\u0006\u0010F\u001a\u00020C\u0012\b\u0010Q\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b^\u0010_J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0015J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020!0 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b*\u0010+R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00040 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010#R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\"\u00108\u001a\b\u0012\u0004\u0012\u00020\u0004038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u00101R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u00101R\u001c\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00040 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010#R\u0018\u0010Q\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u001c\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00040 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010#R\u001c\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00040 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010#R(\u0010[\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00040V8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u001c\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00040 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\\\u0010#¨\u0006`"}, d2 = {"Lcom/avito/android/payment/form/PaymentGenericFormPresenterImpl;", "Lcom/avito/android/payment/form/PaymentGenericFormPresenter;", "Lcom/avito/android/payment/form/PaymentGenericFormRouter;", "router", "", "attachRouter", "(Lcom/avito/android/payment/form/PaymentGenericFormRouter;)V", "Lcom/avito/android/payment/form/PaymentGenericFormView;", "view", "attachView", "(Lcom/avito/android/payment/form/PaymentGenericFormView;)V", "Lcom/avito/conveyor_item/Item;", "element", "", "newValue", "onElementValueChanged", "(Lcom/avito/conveyor_item/Item;Ljava/lang/String;)V", "Lcom/avito/android/items/InputItem;", "onElementErrorDismissed", "(Lcom/avito/android/items/InputItem;)V", "detachView", "()V", "detachRouter", "dispose", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "Lcom/avito/android/payment/form/ScreenState;", "c", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "state", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/conveyor_shared_item/phone_item/PhoneInputItem;", g.a, "Lcom/jakewharton/rxrelay2/PublishRelay;", "phoneItemChanges", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Lcom/avito/android/payment/form/ContentModel;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/payment/form/ContentModel;", "contentModel", "i", "nonPhoneItemsInputClearError", "Lio/reactivex/disposables/CompositeDisposable;", "j", "Lio/reactivex/disposables/CompositeDisposable;", "routerDisposable", "Lkotlin/Function0;", AuthSource.OPEN_CHANNEL_LIST, "Lkotlin/jvm/functions/Function0;", "getSubmitButtonListener", "()Lkotlin/jvm/functions/Function0;", "submitButtonListener", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "o", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "l", "lifecycleDisposable", "Lcom/avito/android/payment/form/PaymentGenericFormInteractor;", "p", "Lcom/avito/android/payment/form/PaymentGenericFormInteractor;", "interactor", "Lcom/avito/android/util/SchedulersFactory;", "r", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/payment/form/PaymentGenericFormItemConverter;", VKApiConst.Q, "Lcom/avito/android/payment/form/PaymentGenericFormItemConverter;", "itemConverter", "k", "viewDisposable", "h", "routerSubmit", "s", "Lcom/avito/android/util/Kundle;", "savedState", "d", "toolbarUpClicks", "f", "submitClicks", "Lkotlin/Function1;", "n", "Lkotlin/jvm/functions/Function1;", "getPhoneInputListener", "()Lkotlin/jvm/functions/Function1;", "phoneInputListener", "e", "retryClicks", "<init>", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/payment/form/PaymentGenericFormInteractor;Lcom/avito/android/payment/form/PaymentGenericFormItemConverter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/Kundle;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentGenericFormPresenterImpl implements PaymentGenericFormPresenter {
    public ParametersTree a;
    public ContentModel b;
    public final BehaviorRelay<ScreenState> c;
    public final PublishRelay<Unit> d;
    public final PublishRelay<Unit> e;
    public final PublishRelay<Unit> f;
    public final PublishRelay<PhoneInputItem> g;
    public final PublishRelay<Unit> h;
    public final PublishRelay<Unit> i;
    public final CompositeDisposable j = new CompositeDisposable();
    public final CompositeDisposable k = new CompositeDisposable();
    public final CompositeDisposable l;
    @NotNull
    public final Function0<Unit> m;
    @NotNull
    public final Function1<PhoneInputItem, Unit> n;
    public final AdapterPresenter o;
    public final PaymentGenericFormInteractor p;
    public final PaymentGenericFormItemConverter q;
    public final SchedulersFactory r;
    public final Kundle s;

    public static final class a<T, R> implements Function<ScreenState, ObservableSource<? extends ScreenState>> {
        public final /* synthetic */ PaymentGenericFormPresenterImpl a;

        public a(PaymentGenericFormPresenterImpl paymentGenericFormPresenterImpl) {
            this.a = paymentGenericFormPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends ScreenState> apply(ScreenState screenState) {
            ScreenState screenState2 = screenState;
            Intrinsics.checkNotNullParameter(screenState2, "currentState");
            if (screenState2 instanceof ScreenState.Content) {
                PaymentGenericFormPresenterImpl paymentGenericFormPresenterImpl = this.a;
                PaymentGenericFormPresenterImpl.access$bindMutableContentChanges(paymentGenericFormPresenterImpl, PaymentGenericFormPresenterImpl.access$getContentModel$p(paymentGenericFormPresenterImpl), PaymentGenericFormPresenterImpl.access$getParameters$p(this.a));
                return Observable.never();
            } else if (screenState2 instanceof ScreenState.FullScreenLoading) {
                return PaymentGenericFormPresenterImpl.access$requestInitialContent(this.a);
            } else {
                if (screenState2 instanceof ScreenState.FullScreenError) {
                    return PaymentGenericFormPresenterImpl.access$reloadDataByRetryClicks(this.a);
                }
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ PaymentGenericFormPresenterImpl a;
        public final /* synthetic */ PaymentGenericFormRouter b;

        public b(PaymentGenericFormPresenterImpl paymentGenericFormPresenterImpl, PaymentGenericFormRouter paymentGenericFormRouter) {
            this.a = paymentGenericFormPresenterImpl;
            this.b = paymentGenericFormRouter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            this.b.onSubmitForm(PaymentGenericFormPresenterImpl.access$getContentModel$p(this.a).getPaymentSessionId(), PaymentGenericFormPresenterImpl.access$getContentModel$p(this.a).getMethodSignature(), PaymentGenericFormPresenterImpl.access$getParameters$p(this.a));
        }
    }

    public static final class c<T> implements Consumer<Unit> {
        public final /* synthetic */ PaymentGenericFormRouter a;

        public c(PaymentGenericFormRouter paymentGenericFormRouter) {
            this.a = paymentGenericFormRouter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            this.a.leaveScreen();
        }
    }

    public static final class d<T> implements Consumer<ScreenState> {
        public final /* synthetic */ PaymentGenericFormRouter a;

        public d(PaymentGenericFormRouter paymentGenericFormRouter) {
            this.a = paymentGenericFormRouter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ScreenState screenState) {
            ScreenState screenState2 = screenState;
            if (screenState2 instanceof ScreenState.FullScreenError) {
                this.a.leaveScreenWithError(((ScreenState.FullScreenError) screenState2).getErrorMessage());
            }
        }
    }

    public static final class e<T> implements Consumer<ScreenState> {
        public final /* synthetic */ PaymentGenericFormPresenterImpl a;

        public e(PaymentGenericFormPresenterImpl paymentGenericFormPresenterImpl) {
            this.a = paymentGenericFormPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ScreenState screenState) {
            ScreenState screenState2 = screenState;
            if (screenState2 instanceof ScreenState.Content) {
                a2.b.a.a.a.s1(((ScreenState.Content) screenState2).getItems(), this.a.o);
            }
        }
    }

    public static final class f extends Lambda implements Function1<PhoneInputItem, Unit> {
        public final /* synthetic */ PaymentGenericFormPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(PaymentGenericFormPresenterImpl paymentGenericFormPresenterImpl) {
            super(1);
            this.a = paymentGenericFormPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(PhoneInputItem phoneInputItem) {
            PhoneInputItem phoneInputItem2 = phoneInputItem;
            Intrinsics.checkNotNullParameter(phoneInputItem2, "it");
            this.a.g.accept(phoneInputItem2);
            return Unit.INSTANCE;
        }
    }

    public PaymentGenericFormPresenterImpl(@NotNull AdapterPresenter adapterPresenter, @NotNull PaymentGenericFormInteractor paymentGenericFormInteractor, @NotNull PaymentGenericFormItemConverter paymentGenericFormItemConverter, @NotNull SchedulersFactory schedulersFactory, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(paymentGenericFormInteractor, "interactor");
        Intrinsics.checkNotNullParameter(paymentGenericFormItemConverter, "itemConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.o = adapterPresenter;
        this.p = paymentGenericFormInteractor;
        this.q = paymentGenericFormItemConverter;
        this.r = schedulersFactory;
        this.s = kundle;
        BehaviorRelay<ScreenState> createDefault = BehaviorRelay.createDefault(new ScreenState.FullScreenLoading());
        Intrinsics.checkNotNullExpressionValue(createDefault, "createDefault(FullScreenLoading())");
        this.c = createDefault;
        PublishRelay<Unit> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.d = create;
        PublishRelay<Unit> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.e = create2;
        PublishRelay<Unit> create3 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create()");
        this.f = create3;
        PublishRelay<PhoneInputItem> create4 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create4, "PublishRelay.create()");
        this.g = create4;
        PublishRelay<Unit> create5 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create5, "PublishRelay.create()");
        this.h = create5;
        PublishRelay<Unit> create6 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create6, "PublishRelay.create()");
        this.i = create6;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.l = compositeDisposable;
        this.m = new a2.a.a.t1.b.a(create3);
        Observable<ScreenState> distinctUntilChanged = createDefault.distinctUntilChanged(PaymentGenericFormPresenterImpl$$special$$inlined$distinctTypes$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "this.distinctUntilChange…vaClass == t2.javaClass }");
        Disposable subscribe = distinctUntilChanged.switchMap(new a(this)).subscribe(createDefault);
        Intrinsics.checkNotNullExpressionValue(subscribe, "state\n            .disti…        .subscribe(state)");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        this.n = new f(this);
    }

    public static final ScreenState access$bakeInitialContent(PaymentGenericFormPresenterImpl paymentGenericFormPresenterImpl, PaymentGenericFormResult.Ok ok) {
        Kundle kundle = paymentGenericFormPresenterImpl.s;
        ParametersTree parametersTree = kundle != null ? (ParametersTree) kundle.getParcelable("PaymentGenericFormPresenterImpl_entered_params") : null;
        if (parametersTree == null) {
            parametersTree = new SimpleParametersTree(ok.getFields(), null, 2, null);
        }
        paymentGenericFormPresenterImpl.a = parametersTree;
        ContentModel contentModel = new ContentModel(ok.getTitle(), ok.getInformation(), ok.getSubmitText(), ok.getPaymentSessionId(), ok.getMethodSignature());
        paymentGenericFormPresenterImpl.b = contentModel;
        boolean z = paymentGenericFormPresenterImpl.s == null;
        PaymentGenericFormItemConverter paymentGenericFormItemConverter = paymentGenericFormPresenterImpl.q;
        ParametersTree parametersTree2 = paymentGenericFormPresenterImpl.a;
        if (parametersTree2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        }
        return paymentGenericFormItemConverter.convert(contentModel, parametersTree2, z);
    }

    public static final void access$bindMutableContentChanges(PaymentGenericFormPresenterImpl paymentGenericFormPresenterImpl, ContentModel contentModel, ParametersTree parametersTree) {
        Disposable subscribe = paymentGenericFormPresenterImpl.g.distinctUntilChanged(a2.a.a.t1.b.c.a).doOnNext(new a2.a.a.t1.b.d(parametersTree)).map(new a2.a.a.t1.b.e(paymentGenericFormPresenterImpl, contentModel, parametersTree)).subscribe(paymentGenericFormPresenterImpl.c);
        Disposable subscribe2 = paymentGenericFormPresenterImpl.i.map(new a2.a.a.t1.b.b(paymentGenericFormPresenterImpl, contentModel, parametersTree)).subscribe(paymentGenericFormPresenterImpl.c);
        Observable<R> share = paymentGenericFormPresenterImpl.f.switchMap(new j(paymentGenericFormPresenterImpl, parametersTree)).observeOn(paymentGenericFormPresenterImpl.r.mainThread()).share();
        Disposable subscribe3 = share.doOnNext(new a2.a.a.t1.b.f(parametersTree)).map(new a2.a.a.t1.b.g(paymentGenericFormPresenterImpl, contentModel, parametersTree)).subscribe(paymentGenericFormPresenterImpl.c);
        Disposable subscribe4 = share.filter(h.a).subscribe(new i(paymentGenericFormPresenterImpl));
        CompositeDisposable compositeDisposable = paymentGenericFormPresenterImpl.l;
        Intrinsics.checkNotNullExpressionValue(subscribe, "rebindOnInputChanges");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = paymentGenericFormPresenterImpl.l;
        Intrinsics.checkNotNullExpressionValue(subscribe3, "rebindOnVerification");
        DisposableKt.plusAssign(compositeDisposable2, subscribe3);
        CompositeDisposable compositeDisposable3 = paymentGenericFormPresenterImpl.l;
        Intrinsics.checkNotNullExpressionValue(subscribe2, "rebindOnClearErrorNonPhoneInput");
        DisposableKt.plusAssign(compositeDisposable3, subscribe2);
        CompositeDisposable compositeDisposable4 = paymentGenericFormPresenterImpl.l;
        Intrinsics.checkNotNullExpressionValue(subscribe4, "submitRouterOnSuccessVerification");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
    }

    public static final /* synthetic */ ContentModel access$getContentModel$p(PaymentGenericFormPresenterImpl paymentGenericFormPresenterImpl) {
        ContentModel contentModel = paymentGenericFormPresenterImpl.b;
        if (contentModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentModel");
        }
        return contentModel;
    }

    public static final /* synthetic */ ParametersTree access$getParameters$p(PaymentGenericFormPresenterImpl paymentGenericFormPresenterImpl) {
        ParametersTree parametersTree = paymentGenericFormPresenterImpl.a;
        if (parametersTree == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        }
        return parametersTree;
    }

    public static final Observable access$reloadDataByRetryClicks(PaymentGenericFormPresenterImpl paymentGenericFormPresenterImpl) {
        return paymentGenericFormPresenterImpl.e.map(k.a);
    }

    public static final Observable access$requestInitialContent(PaymentGenericFormPresenterImpl paymentGenericFormPresenterImpl) {
        Observable<R> map = paymentGenericFormPresenterImpl.p.getPaymentForm().map(new l(paymentGenericFormPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(map, "interactor.getPaymentFor…)\n            }\n        }");
        return map;
    }

    @Override // com.avito.android.payment.form.PaymentGenericFormPresenter
    public void attachRouter(@NotNull PaymentGenericFormRouter paymentGenericFormRouter) {
        Intrinsics.checkNotNullParameter(paymentGenericFormRouter, "router");
        CompositeDisposable compositeDisposable = this.j;
        Disposable subscribe = this.h.subscribe(new b(this, paymentGenericFormRouter));
        Intrinsics.checkNotNullExpressionValue(subscribe, "routerSubmit\n           …          )\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.j;
        Disposable subscribe2 = this.d.subscribe(new c(paymentGenericFormRouter));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "toolbarUpClicks\n        … { router.leaveScreen() }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.j;
        Disposable subscribe3 = this.c.subscribe(new d(paymentGenericFormRouter));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "state\n            .subsc…          }\n            }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
    }

    @Override // com.avito.android.payment.form.PaymentGenericFormPresenter
    public void attachView(@NotNull PaymentGenericFormView paymentGenericFormView) {
        Intrinsics.checkNotNullParameter(paymentGenericFormView, "view");
        CompositeDisposable compositeDisposable = this.k;
        Disposable subscribe = paymentGenericFormView.getToolbarUpClicks().subscribe(this.d);
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.toolbarUpClicks.subscribe(toolbarUpClicks)");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.k;
        Disposable subscribe2 = paymentGenericFormView.getRetryClicks().subscribe(this.e);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.retryClicks.subscribe(retryClicks)");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.k;
        Disposable subscribe3 = this.c.observeOn(this.r.mainThread()).subscribe(paymentGenericFormView.getScreenBinding());
        Intrinsics.checkNotNullExpressionValue(subscribe3, "state\n            .obser…cribe(view.screenBinding)");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.k;
        Disposable subscribe4 = this.c.observeOn(this.r.mainThread()).subscribe(new e(this));
        Intrinsics.checkNotNullExpressionValue(subscribe4, "state\n            .obser…          }\n            }");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
    }

    @Override // com.avito.android.payment.form.PaymentGenericFormPresenter
    public void detachRouter() {
        this.j.clear();
    }

    @Override // com.avito.android.payment.form.PaymentGenericFormPresenter
    public void detachView() {
        this.k.clear();
    }

    @Override // com.avito.android.payment.form.PaymentGenericFormPresenter
    public void dispose() {
        this.l.dispose();
    }

    @Override // com.avito.android.payment.form.PaymentGenericFormViewListener
    @NotNull
    public Function1<PhoneInputItem, Unit> getPhoneInputListener() {
        return this.n;
    }

    @Override // com.avito.android.payment.form.PaymentGenericFormViewListener
    @NotNull
    public Function0<Unit> getSubmitButtonListener() {
        return this.m;
    }

    @Override // com.avito.android.blueprints.InputItemPresenter.Listener
    public void onElementErrorDismissed(@NotNull InputItem inputItem) {
        Intrinsics.checkNotNullParameter(inputItem, "element");
        ParametersTree parametersTree = this.a;
        if (parametersTree == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        }
        ParameterSlot findParameter = parametersTree.findParameter(inputItem.getStringId());
        if (findParameter != null && (findParameter instanceof EditableParameter)) {
            ((EditableParameter) findParameter).setError(null);
            this.i.accept(Unit.INSTANCE);
        }
    }

    @Override // com.avito.android.blueprints.InputItemPresenter.Listener
    public void onElementValueChanged(@NotNull Item item, @NotNull String str) {
        Intrinsics.checkNotNullParameter(item, "element");
        Intrinsics.checkNotNullParameter(str, "newValue");
        ParametersTree parametersTree = this.a;
        if (parametersTree == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        }
        ParameterSlot findParameter = parametersTree.findParameter(item.getStringId());
        if (findParameter != null && (findParameter instanceof CharParameter)) {
            EditableParameter editableParameter = (EditableParameter) findParameter;
            if (!Intrinsics.areEqual(editableParameter.getValue(), str)) {
                editableParameter.setValue(str);
                editableParameter.setError(null);
            }
        }
    }

    @Override // com.avito.android.payment.form.PaymentGenericFormPresenter
    @NotNull
    public Kundle onSaveState() {
        Kundle kundle = new Kundle();
        ParametersTree parametersTree = this.a;
        if (parametersTree != null) {
            if (parametersTree == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
            }
            kundle.putParcelable("PaymentGenericFormPresenterImpl_entered_params", parametersTree);
        }
        return kundle;
    }
}
