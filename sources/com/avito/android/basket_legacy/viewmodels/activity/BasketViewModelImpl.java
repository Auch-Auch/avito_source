package com.avito.android.basket_legacy.viewmodels.activity;

import a2.g.r.g;
import android.content.Intent;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.basket_legacy.fees.BasketInteractor;
import com.avito.android.basket_legacy.utils.BasketStep;
import com.avito.android.basket_legacy.utils.ProgressState;
import com.avito.android.basket_legacy.utils.VasType;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.IntentDataHolder;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.architecture_components.StartActivityEvent;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010A\u001a\u00020>\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u0010=\u001a\u00020:¢\u0006\u0004\bB\u0010CJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0005R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\"\u0010'\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010$R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010\u0014R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\"\u00105\u001a\b\u0012\u0004\u0012\u00020\u00120\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b3\u0010\u001d\u001a\u0004\b4\u0010\u001fR\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006D"}, d2 = {"Lcom/avito/android/basket_legacy/viewmodels/activity/BasketViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/basket_legacy/viewmodels/activity/BasketViewModel;", "", "onCleared", "()V", "onRetryClicked", "onPerformanceVasSelected", "onVisualVasSelected", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onDeeplinkClicked", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "onShowSingleFeeInfoClicked", "onLfPackageSelected", "onSingleFeeSelected", "c", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/basket_legacy/utils/ProgressState;", "d", "Landroidx/lifecycle/MutableLiveData;", "progressLiveData", "Lcom/avito/android/basket_legacy/fees/BasketInteractor;", "k", "Lcom/avito/android/basket_legacy/fees/BasketInteractor;", "interactor", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/util/architecture_components/StartActivityEvent;", "i", "Landroidx/lifecycle/LiveData;", "getStartActivityEvents", "()Landroidx/lifecycle/LiveData;", "startActivityEvents", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/basket_legacy/utils/BasketStep;", g.a, "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getRouterEvents", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "routerEvents", "basketEventsLiveData", "e", "startActivityLiveData", "Lio/reactivex/disposables/Disposable;", "f", "Lio/reactivex/disposables/Disposable;", "disposable", "Lcom/avito/android/util/SchedulersFactory;", "l", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "h", "getProgressEvents", "progressEvents", "Lcom/avito/android/ActivityIntentFactory;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "n", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/basket_legacy/utils/VasType;", "j", "Lcom/avito/android/basket_legacy/utils/VasType;", "defaultVasType", "<init>", "(Lcom/avito/android/basket_legacy/utils/VasType;Lcom/avito/android/basket_legacy/fees/BasketInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/ActivityIntentFactory;Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class BasketViewModelImpl extends ViewModel implements BasketViewModel {
    public final SingleLiveEvent<BasketStep> c;
    public final MutableLiveData<ProgressState> d;
    public final MutableLiveData<StartActivityEvent> e;
    public Disposable f;
    @NotNull
    public final SingleLiveEvent<BasketStep> g;
    @NotNull
    public final LiveData<ProgressState> h;
    @NotNull
    public final LiveData<StartActivityEvent> i;
    public final VasType j;
    public final BasketInteractor k;
    public final SchedulersFactory l;
    public final ActivityIntentFactory m;
    public final DeepLinkIntentFactory n;

    public static final class a<T> implements Consumer<Disposable> {
        public final /* synthetic */ BasketViewModelImpl a;

        public a(BasketViewModelImpl basketViewModelImpl) {
            this.a = basketViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) {
            this.a.d.setValue(ProgressState.LOADING);
        }
    }

    public static final class b<T> implements Consumer<BasketStep> {
        public final /* synthetic */ BasketViewModelImpl a;

        public b(BasketViewModelImpl basketViewModelImpl) {
            this.a = basketViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(BasketStep basketStep) {
            this.a.d.setValue(ProgressState.FINISHED);
        }
    }

    public static final class c<T> implements Consumer<BasketStep> {
        public final /* synthetic */ BasketViewModelImpl a;

        public c(BasketViewModelImpl basketViewModelImpl) {
            this.a = basketViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(BasketStep basketStep) {
            this.a.c.postValue(basketStep);
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ BasketViewModelImpl a;

        public d(BasketViewModelImpl basketViewModelImpl) {
            this.a = basketViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.d.postValue(ProgressState.ERROR);
        }
    }

    public BasketViewModelImpl(@NotNull VasType vasType, @NotNull BasketInteractor basketInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull ActivityIntentFactory activityIntentFactory, @NotNull DeepLinkIntentFactory deepLinkIntentFactory) {
        Intrinsics.checkNotNullParameter(vasType, "defaultVasType");
        Intrinsics.checkNotNullParameter(basketInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        this.j = vasType;
        this.k = basketInteractor;
        this.l = schedulersFactory;
        this.m = activityIntentFactory;
        this.n = deepLinkIntentFactory;
        SingleLiveEvent<BasketStep> singleLiveEvent = new SingleLiveEvent<>();
        this.c = singleLiveEvent;
        MutableLiveData<ProgressState> mutableLiveData = new MutableLiveData<>();
        this.d = mutableLiveData;
        MutableLiveData<StartActivityEvent> mutableLiveData2 = new MutableLiveData<>();
        this.e = mutableLiveData2;
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.f = empty;
        c();
        this.g = singleLiveEvent;
        this.h = mutableLiveData;
        this.i = mutableLiveData2;
    }

    public final void c() {
        this.f.dispose();
        Disposable subscribe = this.k.getFirstStep().observeOn(this.l.mainThread()).doOnSubscribe(new a(this)).doOnNext(new b(this)).subscribe(new c(this), new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.getFirstStep(…e(ProgressState.ERROR) })");
        this.f = subscribe;
    }

    @Override // com.avito.android.basket_legacy.viewmodels.activity.BasketViewModel
    @NotNull
    public LiveData<ProgressState> getProgressEvents() {
        return this.h;
    }

    @Override // com.avito.android.basket_legacy.viewmodels.activity.BasketViewModel
    @NotNull
    public SingleLiveEvent<BasketStep> getRouterEvents() {
        return this.g;
    }

    @Override // com.avito.android.basket_legacy.viewmodels.activity.BasketViewModel
    @NotNull
    public LiveData<StartActivityEvent> getStartActivityEvents() {
        return this.i;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.f.dispose();
        super.onCleared();
    }

    @Override // com.avito.android.basket_legacy.viewmodels.activity.BasketViewModel
    public void onDeeplinkClicked(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intent intent = this.n.getIntent(deepLink);
        if (intent != null) {
            this.e.postValue(new StartActivityEvent(new IntentDataHolder(intent, false)));
        }
    }

    @Override // com.avito.android.basket_legacy.viewmodels.activity.BasketViewModel
    public void onLfPackageSelected() {
        this.c.postValue(new BasketStep.VasChoice(this.j, false));
    }

    @Override // com.avito.android.basket_legacy.viewmodels.activity.BasketViewModel
    public void onPerformanceVasSelected() {
        this.c.postValue(new BasketStep.VasChoice(VasType.VISUAL, true));
    }

    @Override // com.avito.android.basket_legacy.viewmodels.activity.BasketViewModel
    public void onRetryClicked() {
        c();
    }

    @Override // com.avito.android.basket_legacy.viewmodels.activity.BasketViewModel
    public void onShowSingleFeeInfoClicked() {
        this.e.postValue(new StartActivityEvent(new IntentDataHolder(this.m.infoForPaidPlacementIntent(), false)));
    }

    @Override // com.avito.android.basket_legacy.viewmodels.activity.BasketViewModel
    public void onSingleFeeSelected() {
        this.c.postValue(new BasketStep.VasChoice(this.j, true));
    }

    @Override // com.avito.android.basket_legacy.viewmodels.activity.BasketViewModel
    public void onVisualVasSelected() {
        this.c.postValue(new BasketStep.Checkout());
    }
}
