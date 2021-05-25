package com.avito.android.bundles.vas_union.viewmodel;

import a2.a.a.x.b.c.k;
import a2.a.a.x.b.c.o;
import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.bundles.ui.recycler.item.benefit.BenefitItemPresenter;
import com.avito.android.bundles.ui.recycler.item.bundle.VasBundleItemPresenter;
import com.avito.android.bundles.ui.recycler.item.skip_button.BundleSkipButtonItemPresenter;
import com.avito.android.bundles.vas_union.VasUnionConverter;
import com.avito.android.bundles.vas_union.item.ContinueInfo;
import com.avito.android.bundles.vas_union.item.VasUnionConvertInfo;
import com.avito.android.bundles.vas_union.item.performance.info_action.InfoActionItemPresenter;
import com.avito.android.bundles.vas_union.item.performance.tabs.PerformanceTabsItemPresenter;
import com.avito.android.bundles.vas_union.item.performance.vas.PerformanceVasItem;
import com.avito.android.bundles.vas_union.item.performance.vas.PerformanceVasItemPresenter;
import com.avito.android.bundles.vas_union.item.tabs.Tab;
import com.avito.android.bundles.vas_union.item.tabs.TabsItemPresenter;
import com.avito.android.bundles.vas_union.repository.VasUnionRepository;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.design.widget.tab.CommonTab;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.VasUnionResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.blueprint.ItemPresenter;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0017\u001a\u00020\u0011\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u00106\u001a\u000203¢\u0006\u0004\bH\u0010IJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J(\u0010\t\u001a\u00020\u00022\u0019\u0010\b\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006¢\u0006\u0002\b\u00070\u0005¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\r\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u0004J)\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f*\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R#\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001f\u0010/\u001a\b\u0012\u0004\u0012\u00020*0)8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0016\u00102\u001a\u0002008\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u000e\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u001f\u0010<\u001a\b\u0012\u0004\u0012\u000208078\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u00109\u001a\u0004\b:\u0010;R\u001f\u0010?\u001a\b\u0012\u0004\u0012\u00020*0)8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010,\u001a\u0004\b>\u0010.R!\u0010B\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0011078\u0006@\u0006¢\u0006\f\n\u0004\b@\u00109\u001a\u0004\bA\u0010;R\u001f\u0010E\u001a\b\u0012\u0004\u0012\u00020*0)8\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010,\u001a\u0004\bD\u0010.R\u0016\u0010G\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010#¨\u0006J"}, d2 = {"Lcom/avito/android/bundles/vas_union/viewmodel/VasUnionViewModel;", "Landroidx/lifecycle/ViewModel;", "", "onCleared", "()V", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "observeItemClicks", "(Ljava/util/Set;)V", "onRetryButtonClick", "onNextButtonClick", "loadContent", "d", "", "Lcom/avito/conveyor_item/Item;", "", "tabId", "c", "(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;", "l", "Ljava/lang/String;", "checkoutContext", "e", "Lkotlin/Lazy;", "getHeaderItems", "()Ljava/util/List;", "headerItems", "Lcom/avito/android/bundles/vas_union/repository/VasUnionRepository;", "n", "Lcom/avito/android/bundles/vas_union/repository/VasUnionRepository;", "unionVasRepository", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "k", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "clickSubscriptions", "Lcom/avito/android/bundles/vas_union/VasUnionConverter;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/bundles/vas_union/VasUnionConverter;", "converter", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/deep_linking/links/DeepLink;", g.a, "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getSkipButtonClickEvent", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "skipButtonClickEvent", "Lcom/avito/android/bundles/vas_union/item/VasUnionConvertInfo;", "Lcom/avito/android/bundles/vas_union/item/VasUnionConvertInfo;", "vasUnionConvertInfo", "Lcom/avito/android/util/SchedulersFactory3;", "o", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/bundles/vas_union/viewmodel/VasUnionViewState;", "Landroidx/lifecycle/MutableLiveData;", "getViewState", "()Landroidx/lifecycle/MutableLiveData;", "viewState", "f", "getDeeplinkNavigateEvent", "deeplinkNavigateEvent", "i", "getNextButtonTextChanges", "nextButtonTextChanges", "h", "getInfoPerformanceClickEvent", "infoPerformanceClickEvent", "j", "disposables", "<init>", "(Ljava/lang/String;Lcom/avito/android/bundles/vas_union/VasUnionConverter;Lcom/avito/android/bundles/vas_union/repository/VasUnionRepository;Lcom/avito/android/util/SchedulersFactory3;)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class VasUnionViewModel extends ViewModel {
    @NotNull
    public final MutableLiveData<VasUnionViewState> c;
    public VasUnionConvertInfo d;
    public final Lazy e = t6.c.lazy(new a(this));
    @NotNull
    public final SingleLiveEvent<DeepLink> f = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<DeepLink> g = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<DeepLink> h = new SingleLiveEvent<>();
    @NotNull
    public final MutableLiveData<String> i = new MutableLiveData<>();
    public final CompositeDisposable j = new CompositeDisposable();
    public CompositeDisposable k = new CompositeDisposable();
    public final String l;
    public final VasUnionConverter m;
    public final VasUnionRepository n;
    public final SchedulersFactory3 o;

    public static final class a extends Lambda implements Function0<List<? extends Item>> {
        public final /* synthetic */ VasUnionViewModel a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(VasUnionViewModel vasUnionViewModel) {
            super(0);
            this.a = vasUnionViewModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public List<? extends Item> invoke() {
            if (VasUnionViewModel.access$getVasUnionConvertInfo$p(this.a).getTabsItem().getTabs().size() >= 2) {
                return CollectionsKt___CollectionsKt.plus((Collection) d.listOf(VasUnionViewModel.access$getVasUnionConvertInfo$p(this.a).getHeaderItem()), (Iterable) d.listOf(VasUnionViewModel.access$getVasUnionConvertInfo$p(this.a).getTabsItem()));
            }
            return d.listOf(VasUnionViewModel.access$getVasUnionConvertInfo$p(this.a).getHeaderItem());
        }
    }

    public VasUnionViewModel(@NotNull String str, @NotNull VasUnionConverter vasUnionConverter, @NotNull VasUnionRepository vasUnionRepository, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(str, "checkoutContext");
        Intrinsics.checkNotNullParameter(vasUnionConverter, "converter");
        Intrinsics.checkNotNullParameter(vasUnionRepository, "unionVasRepository");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.l = str;
        this.m = vasUnionConverter;
        this.n = vasUnionRepository;
        this.o = schedulersFactory3;
        MutableLiveData<VasUnionViewState> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(new VasUnionViewState(null, null, 3, null));
        this.c = mutableLiveData;
        loadContent();
    }

    public static final List access$getHeaderItems$p(VasUnionViewModel vasUnionViewModel) {
        return (List) vasUnionViewModel.e.getValue();
    }

    public static final /* synthetic */ VasUnionConvertInfo access$getVasUnionConvertInfo$p(VasUnionViewModel vasUnionViewModel) {
        VasUnionConvertInfo vasUnionConvertInfo = vasUnionViewModel.d;
        if (vasUnionConvertInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vasUnionConvertInfo");
        }
        return vasUnionConvertInfo;
    }

    public static final void access$handleLoadingState(VasUnionViewModel vasUnionViewModel, LoadingState loadingState) {
        VasUnionConvertInfo convert;
        VasUnionViewState copy;
        Objects.requireNonNull(vasUnionViewModel);
        if (((LoadingState.Loaded) (!(loadingState instanceof LoadingState.Loaded) ? null : loadingState)) != null && (convert = vasUnionViewModel.m.convert((VasUnionResult) ((LoadingState.Loaded) loadingState).getData())) != null) {
            vasUnionViewModel.d = convert;
            List<Item> c2 = vasUnionViewModel.c(convert.getTabsInfo().getItemsForTab(convert.getTabsInfo().getSelectedTab()), convert.getTabsItem().getSelectedPerformanceTabsTitle());
            VasUnionViewState value = vasUnionViewModel.c.getValue();
            if (!(value == null || (copy = value.copy(loadingState, CollectionsKt___CollectionsKt.plus((Collection) ((List) vasUnionViewModel.e.getValue()), (Iterable) c2))) == null)) {
                vasUnionViewModel.c.postValue(copy);
            }
            vasUnionViewModel.d();
        }
    }

    public final List<Item> c(List<? extends Item> list, String str) {
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            T t2 = t;
            boolean z = true;
            if (!(t2 instanceof PerformanceVasItem) || !(!Intrinsics.areEqual(t2.getTabId(), str))) {
                z = false;
            }
            if (!z) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public final void d() {
        VasUnionConvertInfo vasUnionConvertInfo = this.d;
        if (vasUnionConvertInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vasUnionConvertInfo");
        }
        ContinueInfo continueInfo = vasUnionConvertInfo.getContinueInfo();
        if (continueInfo != null) {
            VasUnionConvertInfo vasUnionConvertInfo2 = this.d;
            if (vasUnionConvertInfo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vasUnionConvertInfo");
            }
            if (Intrinsics.areEqual(vasUnionConvertInfo2.getTabsInfo().getSelectedTab().getTitle(), continueInfo.getTabTitle())) {
                MutableLiveData<String> mutableLiveData = this.i;
                Action continueAction = continueInfo.getContinueAction();
                mutableLiveData.postValue(continueAction != null ? continueAction.getTitle() : null);
                return;
            }
            this.i.postValue("");
        }
    }

    @NotNull
    public final SingleLiveEvent<DeepLink> getDeeplinkNavigateEvent() {
        return this.f;
    }

    @NotNull
    public final SingleLiveEvent<DeepLink> getInfoPerformanceClickEvent() {
        return this.h;
    }

    @NotNull
    public final MutableLiveData<String> getNextButtonTextChanges() {
        return this.i;
    }

    @NotNull
    public final SingleLiveEvent<DeepLink> getSkipButtonClickEvent() {
        return this.g;
    }

    @NotNull
    public final MutableLiveData<VasUnionViewState> getViewState() {
        return this.c;
    }

    public final void loadContent() {
        CompositeDisposable compositeDisposable = this.j;
        Disposable subscribe = this.n.getVasUnion(this.l).observeOn(this.o.mainThread()).subscribe(new o(new Function1<LoadingState<? super VasUnionResult>, Unit>(this) { // from class: com.avito.android.bundles.vas_union.viewmodel.VasUnionViewModel.b
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(LoadingState<? super VasUnionResult> loadingState) {
                LoadingState<? super VasUnionResult> loadingState2 = loadingState;
                Intrinsics.checkNotNullParameter(loadingState2, "p1");
                VasUnionViewModel.access$handleLoadingState((VasUnionViewModel) this.receiver, loadingState2);
                return Unit.INSTANCE;
            }
        }), new o(new Function1<Throwable, Unit>(Logs.INSTANCE) { // from class: com.avito.android.bundles.vas_union.viewmodel.VasUnionViewModel.c
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Throwable th) {
                Logs logs = (Logs) this.receiver;
                Logs.error(th);
                return Unit.INSTANCE;
            }
        }));
        Intrinsics.checkNotNullExpressionValue(subscribe, "unionVasRepository.getVa…oadingState, Logs::error)");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void observeItemClicks(@NotNull Set<ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "itemPresenterSet");
        this.k.clear();
        for (T t : set) {
            if (t instanceof PerformanceVasItemPresenter) {
                CompositeDisposable compositeDisposable = this.k;
                Disposable subscribe = t.getDeeplinkClicks().throttleFirst(300, TimeUnit.MILLISECONDS).observeOn(this.o.mainThread()).subscribe(new o(new Function1<DeepLink, Unit>(this.f) { // from class: a2.a.a.x.b.c.i
                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public Unit invoke(DeepLink deepLink) {
                        DeepLink deepLink2 = deepLink;
                        Intrinsics.checkNotNullParameter(deepLink2, "p1");
                        ((SingleLiveEvent) this.receiver).setValue(deepLink2);
                        return Unit.INSTANCE;
                    }
                }), new o(new Function1<Throwable, Unit>(Logs.INSTANCE) { // from class: a2.a.a.x.b.c.j
                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public Unit invoke(Throwable th) {
                        Logs logs = (Logs) this.receiver;
                        Logs.error(th);
                        return Unit.INSTANCE;
                    }
                }));
                Intrinsics.checkNotNullExpressionValue(subscribe, "deeplinkClickStreamProvi…t::setValue, Logs::error)");
                DisposableKt.plusAssign(compositeDisposable, subscribe);
            } else if (t instanceof InfoActionItemPresenter) {
                CompositeDisposable compositeDisposable2 = this.k;
                Disposable subscribe2 = t.getDeeplinkClicks().throttleFirst(300, TimeUnit.MILLISECONDS).observeOn(this.o.mainThread()).subscribe(new o(new Function1<DeepLink, Unit>(this.h) { // from class: a2.a.a.x.b.c.e
                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public Unit invoke(DeepLink deepLink) {
                        DeepLink deepLink2 = deepLink;
                        Intrinsics.checkNotNullParameter(deepLink2, "p1");
                        ((SingleLiveEvent) this.receiver).setValue(deepLink2);
                        return Unit.INSTANCE;
                    }
                }), new o(new Function1<Throwable, Unit>(Logs.INSTANCE) { // from class: a2.a.a.x.b.c.f
                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public Unit invoke(Throwable th) {
                        Logs logs = (Logs) this.receiver;
                        Logs.error(th);
                        return Unit.INSTANCE;
                    }
                }));
                Intrinsics.checkNotNullExpressionValue(subscribe2, "deeplinkClickStreamProvi…t::setValue, Logs::error)");
                DisposableKt.plusAssign(compositeDisposable2, subscribe2);
            } else if (t instanceof PerformanceTabsItemPresenter) {
                Observable<Tab> tabCheckedObservable = t.getTabCheckedObservable();
                CompositeDisposable compositeDisposable3 = this.k;
                Disposable subscribe3 = tabCheckedObservable.throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new k(this), new o(new Function1<Throwable, Unit>(Logs.INSTANCE) { // from class: a2.a.a.x.b.c.l
                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public Unit invoke(Throwable th) {
                        Logs logs = (Logs) this.receiver;
                        Logs.error(th);
                        return Unit.INSTANCE;
                    }
                }));
                Intrinsics.checkNotNullExpressionValue(subscribe3, "tabsClickObservable\n    …          }, Logs::error)");
                DisposableKt.plusAssign(compositeDisposable3, subscribe3);
            } else if (t instanceof TabsItemPresenter) {
                Observable<CommonTab> tabSelects = t.getTabSelects();
                CompositeDisposable compositeDisposable4 = this.k;
                Disposable subscribe4 = tabSelects.throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new a2.a.a.x.b.c.g(this), new o(new Function1<Throwable, Unit>(Logs.INSTANCE) { // from class: a2.a.a.x.b.c.h
                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public Unit invoke(Throwable th) {
                        Logs logs = (Logs) this.receiver;
                        Logs.error(th);
                        return Unit.INSTANCE;
                    }
                }));
                Intrinsics.checkNotNullExpressionValue(subscribe4, "tabsClickObservable\n    …          }, Logs::error)");
                DisposableKt.plusAssign(compositeDisposable4, subscribe4);
            } else if (t instanceof VasBundleItemPresenter) {
                CompositeDisposable compositeDisposable5 = this.k;
                Disposable subscribe5 = t.getDeeplinkClicks().throttleFirst(300, TimeUnit.MILLISECONDS).observeOn(this.o.mainThread()).subscribe(new o(new Function1<DeepLink, Unit>(this.f) { // from class: a2.a.a.x.b.c.c
                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public Unit invoke(DeepLink deepLink) {
                        DeepLink deepLink2 = deepLink;
                        Intrinsics.checkNotNullParameter(deepLink2, "p1");
                        ((SingleLiveEvent) this.receiver).setValue(deepLink2);
                        return Unit.INSTANCE;
                    }
                }), new o(new Function1<Throwable, Unit>(Logs.INSTANCE) { // from class: a2.a.a.x.b.c.d
                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public Unit invoke(Throwable th) {
                        Logs logs = (Logs) this.receiver;
                        Logs.error(th);
                        return Unit.INSTANCE;
                    }
                }));
                Intrinsics.checkNotNullExpressionValue(subscribe5, "deeplinkClickStreamProvi…t::setValue, Logs::error)");
                DisposableKt.plusAssign(compositeDisposable5, subscribe5);
            } else if (t instanceof BundleSkipButtonItemPresenter) {
                CompositeDisposable compositeDisposable6 = this.k;
                Disposable subscribe6 = t.getDeeplinkClicks().throttleFirst(300, TimeUnit.MILLISECONDS).observeOn(this.o.mainThread()).subscribe(new o(new Function1<DeepLink, Unit>(this.g) { // from class: a2.a.a.x.b.c.m
                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public Unit invoke(DeepLink deepLink) {
                        DeepLink deepLink2 = deepLink;
                        Intrinsics.checkNotNullParameter(deepLink2, "p1");
                        ((SingleLiveEvent) this.receiver).setValue(deepLink2);
                        return Unit.INSTANCE;
                    }
                }), new o(new Function1<Throwable, Unit>(Logs.INSTANCE) { // from class: a2.a.a.x.b.c.n
                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public Unit invoke(Throwable th) {
                        Logs logs = (Logs) this.receiver;
                        Logs.error(th);
                        return Unit.INSTANCE;
                    }
                }));
                Intrinsics.checkNotNullExpressionValue(subscribe6, "deeplinkClickStreamProvi…t::setValue, Logs::error)");
                DisposableKt.plusAssign(compositeDisposable6, subscribe6);
            } else if (t instanceof BenefitItemPresenter) {
                CompositeDisposable compositeDisposable7 = this.k;
                Disposable subscribe7 = t.getDeeplinkClicks().throttleFirst(300, TimeUnit.MILLISECONDS).observeOn(this.o.mainThread()).subscribe(new o(new Function1<DeepLink, Unit>(this.f) { // from class: a2.a.a.x.b.c.a
                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public Unit invoke(DeepLink deepLink) {
                        DeepLink deepLink2 = deepLink;
                        Intrinsics.checkNotNullParameter(deepLink2, "p1");
                        ((SingleLiveEvent) this.receiver).setValue(deepLink2);
                        return Unit.INSTANCE;
                    }
                }), new o(new Function1<Throwable, Unit>(Logs.INSTANCE) { // from class: a2.a.a.x.b.c.b
                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public Unit invoke(Throwable th) {
                        Logs logs = (Logs) this.receiver;
                        Logs.error(th);
                        return Unit.INSTANCE;
                    }
                }));
                Intrinsics.checkNotNullExpressionValue(subscribe7, "deeplinkClickStreamProvi…t::setValue, Logs::error)");
                DisposableKt.plusAssign(compositeDisposable7, subscribe7);
            }
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.k.dispose();
        this.j.dispose();
        super.onCleared();
    }

    public final void onNextButtonClick() {
        Action continueAction;
        VasUnionConvertInfo vasUnionConvertInfo = this.d;
        if (vasUnionConvertInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vasUnionConvertInfo");
        }
        ContinueInfo continueInfo = vasUnionConvertInfo.getContinueInfo();
        this.f.postValue((continueInfo == null || (continueAction = continueInfo.getContinueAction()) == null) ? null : continueAction.getDeepLink());
    }

    public final void onRetryButtonClick() {
        loadContent();
    }
}
