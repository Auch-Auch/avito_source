package com.avito.android.tariff.landing.viewmodel;

import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\n\u0010\u0005J#\u0010\u000f\u001a\u00020\u00032\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R(\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R)\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b8B@\u0002X\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0014R\u0016\u0010*\u001a\u00020(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010)R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00060\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010\u001c¨\u0006/"}, d2 = {"Lcom/avito/android/tariff/landing/viewmodel/TariffLandingViewModelImpl;", "Lcom/avito/android/tariff/landing/viewmodel/TariffLandingViewModel;", "Landroidx/lifecycle/ViewModel;", "", "onRetryButtonClick", "()V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onContinueButtonClick", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "onCleared", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/tariff/landing/viewmodel/TariffLanding;", "liveData", "c", "(Landroidx/lifecycle/MutableLiveData;)V", "f", "Landroidx/lifecycle/MutableLiveData;", "getProgressChanges", "()Landroidx/lifecycle/MutableLiveData;", "progressChanges", "Lcom/avito/android/util/SchedulersFactory;", "i", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", g.a, "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getRoutingEvents", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "routingEvents", "Lcom/avito/android/tariff/landing/viewmodel/LandingInteractor;", "h", "Lcom/avito/android/tariff/landing/viewmodel/LandingInteractor;", "interactor", "e", "Lkotlin/Lazy;", "getProgressChangesLiveData", "progressChangesLiveData", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "subscription", "d", "routingEventsLiveData", "<init>", "(Lcom/avito/android/tariff/landing/viewmodel/LandingInteractor;Lcom/avito/android/util/SchedulersFactory;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffLandingViewModelImpl extends ViewModel implements TariffLandingViewModel {
    public Disposable c;
    public final SingleLiveEvent<DeepLink> d;
    public final Lazy e;
    @NotNull
    public final MutableLiveData<LoadingState<TariffLanding>> f;
    @NotNull
    public final SingleLiveEvent<DeepLink> g;
    public final LandingInteractor h;
    public final SchedulersFactory i;

    public static final class a<T> implements Consumer<LoadingState<? super TariffLanding>> {
        public final /* synthetic */ MutableLiveData a;

        public a(MutableLiveData mutableLiveData) {
            this.a = mutableLiveData;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super TariffLanding> loadingState) {
            this.a.setValue(loadingState);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public static final class c extends Lambda implements Function0<MutableLiveData<LoadingState<? super TariffLanding>>> {
        public final /* synthetic */ TariffLandingViewModelImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(TariffLandingViewModelImpl tariffLandingViewModelImpl) {
            super(0);
            this.a = tariffLandingViewModelImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public MutableLiveData<LoadingState<? super TariffLanding>> invoke() {
            MutableLiveData<LoadingState<? super TariffLanding>> mutableLiveData = new MutableLiveData<>();
            this.a.c(mutableLiveData);
            return mutableLiveData;
        }
    }

    public TariffLandingViewModelImpl(@NotNull LandingInteractor landingInteractor, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(landingInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.h = landingInteractor;
        this.i = schedulersFactory;
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.c = empty;
        SingleLiveEvent<DeepLink> singleLiveEvent = new SingleLiveEvent<>();
        this.d = singleLiveEvent;
        Lazy lazy = t6.c.lazy(new c(this));
        this.e = lazy;
        this.f = (MutableLiveData) lazy.getValue();
        this.g = singleLiveEvent;
    }

    public final void c(MutableLiveData<LoadingState<TariffLanding>> mutableLiveData) {
        this.c.dispose();
        Disposable subscribe = this.h.getLanding().observeOn(this.i.mainThread()).startWith((Observable<LoadingState<TariffLanding>>) LoadingState.Loading.INSTANCE).subscribe(new a(mutableLiveData), b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.getLanding()\n…error(it) }\n            )");
        this.c = subscribe;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.c.dispose();
    }

    @Override // com.avito.android.tariff.landing.viewmodel.TariffLandingViewModel
    public void onContinueButtonClick(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        this.d.setValue(deepLink);
    }

    @Override // com.avito.android.tariff.landing.viewmodel.TariffLandingViewModel
    public void onRetryButtonClick() {
        c((MutableLiveData) this.e.getValue());
    }

    @Override // com.avito.android.tariff.landing.viewmodel.TariffLandingViewModel
    @NotNull
    public MutableLiveData<LoadingState<TariffLanding>> getProgressChanges() {
        return this.f;
    }

    @Override // com.avito.android.tariff.landing.viewmodel.TariffLandingViewModel
    @NotNull
    public SingleLiveEvent<DeepLink> getRoutingEvents() {
        return this.g;
    }
}
