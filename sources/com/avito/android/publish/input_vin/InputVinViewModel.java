package com.avito.android.publish.input_vin;

import a2.a.a.e2.w.h;
import a2.a.a.e2.w.i;
import a2.a.a.e2.w.k;
import a2.a.a.e2.w.l;
import a2.g.r.g;
import android.net.Uri;
import android.os.Parcelable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.items.ItemWithAdditionalButton;
import com.avito.android.publish.PublishParametersInteractor;
import com.avito.android.publish.PublishState;
import com.avito.android.publish.PublishViewModel;
import com.avito.android.publish.R;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.input_vin.RoutingAction;
import com.avito.android.publish.input_vin.items.divider.DividerWithTextItem;
import com.avito.android.publish.input_vin.items.scan_button.ScanVinButtonItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.CharParameter;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.util.MultiStateLoading;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.validation.ParametersListPresenter;
import com.avito.conveyor_item.Item;
import com.jakewharton.rxrelay2.BehaviorRelay;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.toolbar.OnboardingData;
import t6.r.a.j;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001SB/\u0012\u0006\u0010@\u001a\u00020=\u0012\u0006\u0010L\u001a\u00020I\u0012\u0006\u0010P\u001a\u00020M\u0012\u0006\u0010D\u001a\u00020A\u0012\u0006\u0010,\u001a\u00020)¢\u0006\u0004\bQ\u0010RJ\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\f¢\u0006\u0004\b\u0017\u0010\u000eJ\r\u0010\u0018\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u000eJ\r\u0010\u0019\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u000eJ\u0015\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\f¢\u0006\u0004\b\u001e\u0010\u000eJ\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b#\u0010$R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010%R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u001f\u00105\u001a\b\u0012\u0004\u0012\u0002000/8\u0006@\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X.¢\u0006\u0006\n\u0004\b6\u00107R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u0010(R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010H\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010.R\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010O¨\u0006T"}, d2 = {"Lcom/avito/android/publish/input_vin/InputVinViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/remote/model/category_parameters/CharParameter;", "screenData", "()Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/publish/input_vin/InputVinViewModel$InputVinEvents;", "inputVinEvents", "()Landroidx/lifecycle/LiveData;", "Lcom/avito/android/publish/input_vin/RoutingAction;", "routingActions", "", "onCleared", "()V", "Lcom/avito/android/publish/PublishViewModel;", "publishViewModel", "Lcom/avito/android/validation/ParametersListPresenter;", "paramsListPresenter", "", "stepIndex", "initScreen", "(Lcom/avito/android/publish/PublishViewModel;Lcom/avito/android/validation/ParametersListPresenter;I)V", "onMainButtonClicked", "onCloseClicked", "onLeaveClicked", "Lcom/avito/android/items/ItemWithAdditionalButton;", "element", "onInputAdditionalButtonClick", "(Lcom/avito/android/items/ItemWithAdditionalButton;)V", "onVinScanButtonClick", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "", "Lcom/avito/conveyor_item/Item;", "c", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Ljava/util/List;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "e", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/publish/input_vin/InputVinResourceProvider;", "p", "Lcom/avito/android/publish/input_vin/InputVinResourceProvider;", "resourceProvider", "i", "I", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "", "k", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "getVinTextChangedRelay", "()Lcom/jakewharton/rxrelay2/BehaviorRelay;", "vinTextChangedRelay", "h", "Lcom/avito/android/validation/ParametersListPresenter;", "d", "Lio/reactivex/disposables/CompositeDisposable;", "f", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/publish/PublishParametersInteractor;", "l", "Lcom/avito/android/publish/PublishParametersInteractor;", "publishParametersInteractor", "Lcom/avito/android/util/SchedulersFactory;", "o", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", g.a, "Lcom/avito/android/publish/PublishViewModel;", "j", "retriesWithWarningCount", "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "elementConverter", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "n", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "publishEventTracker", "<init>", "(Lcom/avito/android/publish/PublishParametersInteractor;Lcom/avito/android/category_parameters/CategoryParametersElementConverter;Lcom/avito/android/publish/analytics/PublishEventTracker;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/publish/input_vin/InputVinResourceProvider;)V", "InputVinEvents", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class InputVinViewModel extends ViewModel {
    public final MutableLiveData<CharParameter> c = new MutableLiveData<>();
    public final SingleLiveEvent<InputVinEvents> d = new SingleLiveEvent<>();
    public final SingleLiveEvent<RoutingAction> e = new SingleLiveEvent<>();
    public final CompositeDisposable f = new CompositeDisposable();
    public PublishViewModel g;
    public ParametersListPresenter h;
    public int i = -1;
    public int j;
    @NotNull
    public final BehaviorRelay<String> k;
    public final PublishParametersInteractor l;
    public final CategoryParametersElementConverter m;
    public final PublishEventTracker n;
    public final SchedulersFactory o;
    public final InputVinResourceProvider p;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/publish/input_vin/InputVinViewModel$InputVinEvents;", "", "<init>", "()V", "DismissProgressDialog", "ShowErrorMessage", "ShowProgressDialog", "Lcom/avito/android/publish/input_vin/InputVinViewModel$InputVinEvents$ShowProgressDialog;", "Lcom/avito/android/publish/input_vin/InputVinViewModel$InputVinEvents$DismissProgressDialog;", "Lcom/avito/android/publish/input_vin/InputVinViewModel$InputVinEvents$ShowErrorMessage;", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class InputVinEvents {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/publish/input_vin/InputVinViewModel$InputVinEvents$DismissProgressDialog;", "Lcom/avito/android/publish/input_vin/InputVinViewModel$InputVinEvents;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class DismissProgressDialog extends InputVinEvents {
            @NotNull
            public static final DismissProgressDialog INSTANCE = new DismissProgressDialog();

            public DismissProgressDialog() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/publish/input_vin/InputVinViewModel$InputVinEvents$ShowErrorMessage;", "Lcom/avito/android/publish/input_vin/InputVinViewModel$InputVinEvents;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", "<init>", "(Ljava/lang/String;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class ShowErrorMessage extends InputVinEvents {
            @NotNull
            public final String a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ShowErrorMessage(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "text");
                this.a = str;
            }

            @NotNull
            public final String getText() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/publish/input_vin/InputVinViewModel$InputVinEvents$ShowProgressDialog;", "Lcom/avito/android/publish/input_vin/InputVinViewModel$InputVinEvents;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class ShowProgressDialog extends InputVinEvents {
            @NotNull
            public static final ShowProgressDialog INSTANCE = new ShowProgressDialog();

            public ShowProgressDialog() {
                super(null);
            }
        }

        public InputVinEvents() {
        }

        public InputVinEvents(j jVar) {
        }
    }

    public static final class a<T> implements Consumer<OnboardingData> {
        public final /* synthetic */ InputVinViewModel a;

        public a(InputVinViewModel inputVinViewModel) {
            this.a = inputVinViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(OnboardingData onboardingData) {
            OnboardingData onboardingData2 = onboardingData;
            SingleLiveEvent singleLiveEvent = this.a.e;
            Intrinsics.checkNotNullExpressionValue(onboardingData2, "it");
            singleLiveEvent.setValue(new RoutingAction.ShowOnboarding(onboardingData2));
        }
    }

    public InputVinViewModel(@NotNull PublishParametersInteractor publishParametersInteractor, @NotNull CategoryParametersElementConverter categoryParametersElementConverter, @NotNull PublishEventTracker publishEventTracker, @NotNull SchedulersFactory schedulersFactory, @NotNull InputVinResourceProvider inputVinResourceProvider) {
        Intrinsics.checkNotNullParameter(publishParametersInteractor, "publishParametersInteractor");
        Intrinsics.checkNotNullParameter(categoryParametersElementConverter, "elementConverter");
        Intrinsics.checkNotNullParameter(publishEventTracker, "publishEventTracker");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(inputVinResourceProvider, "resourceProvider");
        this.l = publishParametersInteractor;
        this.m = categoryParametersElementConverter;
        this.n = publishEventTracker;
        this.o = schedulersFactory;
        this.p = inputVinResourceProvider;
        BehaviorRelay<String> create = BehaviorRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "BehaviorRelay.create()");
        this.k = create;
    }

    public static final /* synthetic */ PublishViewModel access$getPublishViewModel$p(InputVinViewModel inputVinViewModel) {
        PublishViewModel publishViewModel = inputVinViewModel.g;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        return publishViewModel;
    }

    public static final void access$loadCategoryParametersByVinAndContinue(InputVinViewModel inputVinViewModel) {
        PublishParametersInteractor publishParametersInteractor = inputVinViewModel.l;
        String value = inputVinViewModel.k.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "vinTextChangedRelay.value");
        String str = value;
        PublishViewModel publishViewModel = inputVinViewModel.g;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        Navigation navigation = publishViewModel.getNavigation();
        PublishViewModel publishViewModel2 = inputVinViewModel.g;
        if (publishViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        CategoryParameters categoryParameters = publishViewModel2.getCategoryParameters();
        Intrinsics.checkNotNull(categoryParameters);
        ConnectableObservable<MultiStateLoading<CategoryParameters>> publish = publishParametersInteractor.loadAutoParamsByVin(str, navigation, categoryParameters).subscribeOn(inputVinViewModel.o.io()).publish();
        CompositeDisposable compositeDisposable = inputVinViewModel.f;
        Disposable subscribe = publish.ofType(MultiStateLoading.Loading.class).map(a2.a.a.e2.w.g.a).observeOn(inputVinViewModel.o.mainThread()).subscribe(new h(inputVinViewModel), z0.b);
        Intrinsics.checkNotNullExpressionValue(subscribe, "vinRecognize.ofType(Mult…Vin\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = inputVinViewModel.f;
        Disposable subscribe2 = publish.ofType(MultiStateLoading.Error.class).observeOn(inputVinViewModel.o.mainThread()).subscribe(new i(inputVinViewModel), z0.c);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "vinRecognize.ofType(Mult…Vin\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = inputVinViewModel.f;
        Disposable subscribe3 = publish.ofType(MultiStateLoading.Loaded.class).map(a2.a.a.e2.w.j.a).observeOn(inputVinViewModel.o.mainThread()).subscribe(new k(inputVinViewModel), z0.d);
        Intrinsics.checkNotNullExpressionValue(subscribe3, "vinRecognize.ofType(Mult…Vin\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = inputVinViewModel.f;
        Disposable connect = publish.connect();
        Intrinsics.checkNotNullExpressionValue(connect, "vinRecognize.connect()");
        DisposableKt.plusAssign(compositeDisposable4, connect);
    }

    public final List<Item> c(ParametersTree parametersTree) {
        List<Item> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) CategoryParametersElementConverter.convert$default(this.m, parametersTree, null, null, 6, null));
        mutableList.add(0, new ScanVinButtonItem());
        mutableList.add(1, new DividerWithTextItem(R.string.vin_divider_text));
        return mutableList;
    }

    @NotNull
    public final BehaviorRelay<String> getVinTextChangedRelay() {
        return this.k;
    }

    public final void initScreen(@NotNull PublishViewModel publishViewModel, @NotNull ParametersListPresenter parametersListPresenter, int i2) {
        Intrinsics.checkNotNullParameter(publishViewModel, "publishViewModel");
        Intrinsics.checkNotNullParameter(parametersListPresenter, "paramsListPresenter");
        this.i = i2;
        this.g = publishViewModel;
        this.h = parametersListPresenter;
        ParametersTree paramsForStep = publishViewModel.getParamsForStep(i2);
        CharParameter charParameter = (CharParameter) paramsForStep.getFirstParameterOfType(CharParameter.class);
        String str = charParameter != null ? (String) charParameter.getValue() : null;
        if (!(str == null || m.isBlank(str))) {
            this.k.accept(str);
        }
        parametersListPresenter.sendParametersToValidator(paramsForStep, publishViewModel.getCategoryParameters());
        ParametersListPresenter parametersListPresenter2 = this.h;
        if (parametersListPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paramsListPresenter");
        }
        parametersListPresenter2.getItemListConsumer().accept(c(paramsForStep));
        CompositeDisposable compositeDisposable = this.f;
        Disposable subscribe = publishViewModel.shouldShowDraftOnboardingForStep(i2).subscribe(new a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "publishViewModel\n       …ion.ShowOnboarding(it)) }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @NotNull
    public final LiveData<InputVinEvents> inputVinEvents() {
        return this.d;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.f.clear();
        super.onCleared();
    }

    public final void onCloseClicked() {
        this.e.setValue(RoutingAction.SaveAndExitPublishing.INSTANCE);
    }

    public final void onInputAdditionalButtonClick(@NotNull ItemWithAdditionalButton itemWithAdditionalButton) {
        Intrinsics.checkNotNullParameter(itemWithAdditionalButton, "element");
        ItemWithAdditionalButton.AdditionalButton additionalButton = itemWithAdditionalButton.getAdditionalButton();
        String link = additionalButton != null ? additionalButton.getLink() : null;
        this.n.trackInfoLinkClickEvent(link != null ? link : "");
        if (link != null) {
            SingleLiveEvent<RoutingAction> singleLiveEvent = this.e;
            Uri parse = Uri.parse(link);
            Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(it)");
            singleLiveEvent.setValue(new RoutingAction.OpenLink(parse));
        }
    }

    public final void onLeaveClicked() {
        PublishViewModel publishViewModel = this.g;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        publishViewModel.goToPreviousStep();
    }

    public final void onMainButtonClicked() {
        PublishState.StepState stepState;
        if (this.k.getValue() != null) {
            String value = this.k.getValue();
            PublishViewModel publishViewModel = this.g;
            if (publishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
            }
            PublishState state = publishViewModel.getState();
            int i2 = this.i;
            Parcelable parcelable = (PublishState.StepState) state.getStepStates().get(Integer.valueOf(i2));
            if (!(parcelable instanceof PublishState.StepState.Vin)) {
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(PublishState.StepState.Vin.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(PublishState.StepState.Wizard.class))) {
                    stepState = new PublishState.StepState.Wizard(null, null, null, 7, null);
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(PublishState.StepState.CategoriesSuggestions.class))) {
                    stepState = new PublishState.StepState.CategoriesSuggestions(null, null, null, null, 15, null);
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(PublishState.StepState.Vin.class))) {
                    stepState = new PublishState.StepState.Vin(null, 1, null);
                } else {
                    StringBuilder L = a2.b.a.a.a.L("Unknown StepState type '");
                    L.append(Reflection.getOrCreateKotlinClass(PublishState.StepState.Vin.class));
                    L.append('\'');
                    throw new IllegalArgumentException(L.toString());
                }
                state.getStepStates().put(Integer.valueOf(i2), stepState);
                parcelable = (PublishState.StepState.Vin) stepState;
            }
            if (Intrinsics.areEqual(value, ((PublishState.StepState.Vin) parcelable).getRecognizedVin())) {
                PublishViewModel publishViewModel2 = this.g;
                if (publishViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
                }
                PublishViewModel.goToNextStep$default(publishViewModel2, null, 1, null);
                return;
            }
        }
        PublishViewModel publishViewModel3 = this.g;
        if (publishViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        ParametersTree paramsForStep = publishViewModel3.getParamsForStep(this.i);
        CompositeDisposable compositeDisposable = this.f;
        ParametersListPresenter parametersListPresenter = this.h;
        if (parametersListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paramsListPresenter");
        }
        Objects.requireNonNull(parametersListPresenter, "null cannot be cast to non-null type com.avito.android.validation.SubmissionListener");
        Disposable subscribe = parametersListPresenter.onSubmissionRequested(c(paramsForStep)).observeOn(this.o.mainThread()).subscribe(new l(this), a2.a.a.e2.w.m.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "(paramsListPresenter as …ion\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void onVinScanButtonClick() {
        this.n.trackItemAddAutoStsPhotoOpen();
        this.e.setValue(RoutingAction.ScanVin.INSTANCE);
    }

    @NotNull
    public final LiveData<RoutingAction> routingActions() {
        return this.e;
    }

    @NotNull
    public final MutableLiveData<CharParameter> screenData() {
        return this.c;
    }
}
