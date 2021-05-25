package com.avito.android.bundles.viewmodel;

import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.bundles.VasBundlesConverter;
import com.avito.android.bundles.repository.VasBundlesRepository;
import com.avito.android.bundles.ui.recycler.item.benefit.BenefitItemPresenter;
import com.avito.android.bundles.ui.recycler.item.bundle.VasBundleItemPresenter;
import com.avito.android.bundles.ui.recycler.item.skip_button.BundleSkipButtonItemPresenter;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.VasBundlesResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemPresenter;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010%\u001a\u00020\"¢\u0006\u0004\b7\u00108J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J(\u0010\t\u001a\u00020\u00022\u0019\u0010\b\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006¢\u0006\u0002\b\u00070\u0005¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u000fR\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001f\u0010,\u001a\b\u0012\u0004\u0012\u00020'0&8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u0014\u001a\u0004\b2\u0010\u0016R\u001f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010\u0014\u001a\u0004\b5\u0010\u0016¨\u00069"}, d2 = {"Lcom/avito/android/bundles/viewmodel/VasBundlesViewModel;", "Landroidx/lifecycle/ViewModel;", "", "onCleared", "()V", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "observeItemClicks", "(Ljava/util/Set;)V", "onRetryButtonClick", "loadContent", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", g.a, "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/deep_linking/links/DeepLink;", "d", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getChooseBundleButtonClickEvent", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "chooseBundleButtonClickEvent", "h", "clickSubscriptions", "Lcom/avito/android/bundles/VasBundlesConverter;", "j", "Lcom/avito/android/bundles/VasBundlesConverter;", "converter", "", "i", "Ljava/lang/String;", "checkoutContext", "Lcom/avito/android/util/SchedulersFactory3;", "l", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/bundles/viewmodel/VasBundlesViewState;", "c", "Landroidx/lifecycle/MutableLiveData;", "getViewState", "()Landroidx/lifecycle/MutableLiveData;", "viewState", "Lcom/avito/android/bundles/repository/VasBundlesRepository;", "k", "Lcom/avito/android/bundles/repository/VasBundlesRepository;", "bundlesRepository", "f", "getBenefitClickEvent", "benefitClickEvent", "e", "getSkipButtonClickEvent", "skipButtonClickEvent", "<init>", "(Ljava/lang/String;Lcom/avito/android/bundles/VasBundlesConverter;Lcom/avito/android/bundles/repository/VasBundlesRepository;Lcom/avito/android/util/SchedulersFactory3;)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class VasBundlesViewModel extends ViewModel {
    @NotNull
    public final MutableLiveData<VasBundlesViewState> c;
    @NotNull
    public final SingleLiveEvent<DeepLink> d = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<DeepLink> e = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<DeepLink> f = new SingleLiveEvent<>();
    public final CompositeDisposable g = new CompositeDisposable();
    public CompositeDisposable h = new CompositeDisposable();
    public final String i;
    public final VasBundlesConverter j;
    public final VasBundlesRepository k;
    public final SchedulersFactory3 l;

    public VasBundlesViewModel(@NotNull String str, @NotNull VasBundlesConverter vasBundlesConverter, @NotNull VasBundlesRepository vasBundlesRepository, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(str, "checkoutContext");
        Intrinsics.checkNotNullParameter(vasBundlesConverter, "converter");
        Intrinsics.checkNotNullParameter(vasBundlesRepository, "bundlesRepository");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.i = str;
        this.j = vasBundlesConverter;
        this.k = vasBundlesRepository;
        this.l = schedulersFactory3;
        MutableLiveData<VasBundlesViewState> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(new VasBundlesViewState(null, null, 3, null));
        this.c = mutableLiveData;
        loadContent();
    }

    public static final void access$handleLoadingState(VasBundlesViewModel vasBundlesViewModel, LoadingState loadingState) {
        VasBundlesViewState copy;
        Objects.requireNonNull(vasBundlesViewModel);
        List<Item> list = null;
        if (((LoadingState.Loaded) (!(loadingState instanceof LoadingState.Loaded) ? null : loadingState)) != null) {
            list = vasBundlesViewModel.j.convert((VasBundlesResult) ((LoadingState.Loaded) loadingState).getData());
        }
        VasBundlesViewState value = vasBundlesViewModel.c.getValue();
        if (value != null && (copy = value.copy(loadingState, list)) != null) {
            vasBundlesViewModel.c.postValue(copy);
        }
    }

    @NotNull
    public final SingleLiveEvent<DeepLink> getBenefitClickEvent() {
        return this.f;
    }

    @NotNull
    public final SingleLiveEvent<DeepLink> getChooseBundleButtonClickEvent() {
        return this.d;
    }

    @NotNull
    public final SingleLiveEvent<DeepLink> getSkipButtonClickEvent() {
        return this.e;
    }

    @NotNull
    public final MutableLiveData<VasBundlesViewState> getViewState() {
        return this.c;
    }

    public final void loadContent() {
        CompositeDisposable compositeDisposable = this.g;
        Disposable subscribe = this.k.getBundles(this.i).observeOn(this.l.mainThread()).subscribe(new a2.a.a.x.c.g(new Function1<LoadingState<? super VasBundlesResult>, Unit>(this) { // from class: com.avito.android.bundles.viewmodel.VasBundlesViewModel.a
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(LoadingState<? super VasBundlesResult> loadingState) {
                LoadingState<? super VasBundlesResult> loadingState2 = loadingState;
                Intrinsics.checkNotNullParameter(loadingState2, "p1");
                VasBundlesViewModel.access$handleLoadingState((VasBundlesViewModel) this.receiver, loadingState2);
                return Unit.INSTANCE;
            }
        }), new a2.a.a.x.c.g(new Function1<Throwable, Unit>(Logs.INSTANCE) { // from class: com.avito.android.bundles.viewmodel.VasBundlesViewModel.b
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Throwable th) {
                Logs logs = (Logs) this.receiver;
                Logs.error(th);
                return Unit.INSTANCE;
            }
        }));
        Intrinsics.checkNotNullExpressionValue(subscribe, "bundlesRepository.getBun…oadingState, Logs::error)");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void observeItemClicks(@NotNull Set<ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "itemPresenterSet");
        this.h.clear();
        for (T t : set) {
            if (t instanceof VasBundleItemPresenter) {
                CompositeDisposable compositeDisposable = this.h;
                Disposable subscribe = t.getDeeplinkClicks().throttleFirst(100, TimeUnit.MILLISECONDS).observeOn(this.l.mainThread()).subscribe(new a2.a.a.x.c.g(new Function1<DeepLink, Unit>(this.d) { // from class: a2.a.a.x.c.c
                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public Unit invoke(DeepLink deepLink) {
                        DeepLink deepLink2 = deepLink;
                        Intrinsics.checkNotNullParameter(deepLink2, "p1");
                        ((SingleLiveEvent) this.receiver).setValue(deepLink2);
                        return Unit.INSTANCE;
                    }
                }), new a2.a.a.x.c.g(new Function1<Throwable, Unit>(Logs.INSTANCE) { // from class: a2.a.a.x.c.d
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
            } else if (t instanceof BundleSkipButtonItemPresenter) {
                CompositeDisposable compositeDisposable2 = this.h;
                Disposable subscribe2 = t.getDeeplinkClicks().throttleFirst(100, TimeUnit.MILLISECONDS).observeOn(this.l.mainThread()).subscribe(new a2.a.a.x.c.g(new Function1<DeepLink, Unit>(this.e) { // from class: a2.a.a.x.c.e
                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public Unit invoke(DeepLink deepLink) {
                        DeepLink deepLink2 = deepLink;
                        Intrinsics.checkNotNullParameter(deepLink2, "p1");
                        ((SingleLiveEvent) this.receiver).setValue(deepLink2);
                        return Unit.INSTANCE;
                    }
                }), new a2.a.a.x.c.g(new Function1<Throwable, Unit>(Logs.INSTANCE) { // from class: a2.a.a.x.c.f
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
            } else if (t instanceof BenefitItemPresenter) {
                CompositeDisposable compositeDisposable3 = this.h;
                Disposable subscribe3 = t.getDeeplinkClicks().throttleFirst(100, TimeUnit.MILLISECONDS).observeOn(this.l.mainThread()).subscribe(new a2.a.a.x.c.g(new Function1<DeepLink, Unit>(this.f) { // from class: a2.a.a.x.c.a
                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public Unit invoke(DeepLink deepLink) {
                        DeepLink deepLink2 = deepLink;
                        Intrinsics.checkNotNullParameter(deepLink2, "p1");
                        ((SingleLiveEvent) this.receiver).setValue(deepLink2);
                        return Unit.INSTANCE;
                    }
                }), new a2.a.a.x.c.g(new Function1<Throwable, Unit>(Logs.INSTANCE) { // from class: a2.a.a.x.c.b
                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public Unit invoke(Throwable th) {
                        Logs logs = (Logs) this.receiver;
                        Logs.error(th);
                        return Unit.INSTANCE;
                    }
                }));
                Intrinsics.checkNotNullExpressionValue(subscribe3, "deeplinkClickStreamProvi…t::setValue, Logs::error)");
                DisposableKt.plusAssign(compositeDisposable3, subscribe3);
            }
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.g.dispose();
        super.onCleared();
    }

    public final void onRetryButtonClick() {
        loadContent();
    }
}
