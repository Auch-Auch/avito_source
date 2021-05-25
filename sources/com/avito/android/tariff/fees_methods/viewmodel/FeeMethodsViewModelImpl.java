package com.avito.android.tariff.fees_methods.viewmodel;

import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.deep_linking.DeeplinkClickStreamProvider;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.publish_limits_info.ItemId;
import com.avito.android.publish_limits_info.analytics.PublishLimitsEventTracker;
import com.avito.android.publish_limits_info.item.LimitsInfoItem;
import com.avito.android.publish_limits_info.item.LimitsInfoItemPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.model.FeeMethodsResult;
import com.avito.android.remote.model.LimitsInfo;
import com.avito.android.tariff.fees_methods.items.FeeMethodPresenter;
import com.avito.android.tariff.fees_methods.items.high_demand.HighDemandPresenter;
import com.avito.android.tariff.routing.NavigationIcon;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\u0006\u0010H\u001a\u00020E\u0012\u0006\u0010A\u001a\u00020>\u0012\u0006\u0010L\u001a\u00020I\u0012\u0006\u0010P\u001a\u00020M\u0012\u0006\u0010R\u001a\u00020Q\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\bS\u0010TJ%\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00040\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\nR\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0017R\u001e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001cR\"\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010%R\"\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020-0'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010+R$\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b0\u0010\u001c\u001a\u0004\b1\u0010#R\"\u00108\u001a\b\u0012\u0004\u0012\u00020-038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\"\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00060\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b9\u0010\u001c\u001a\u0004\b:\u0010#R\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00060\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010\u001cR\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R(\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bB\u00105\u001a\u0004\bC\u00107R\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010O¨\u0006U"}, d2 = {"Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsViewModelImpl;", "Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsViewModel;", "Landroidx/lifecycle/ViewModel;", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "itemPresenterSet", "", "observeItemClicks", "(Ljava/util/Set;)V", "onCleared", "()V", "onRetryButtonClick", "Lcom/avito/android/deep_linking/DeeplinkClickStreamProvider;", GeoContract.PROVIDER, "Lio/reactivex/disposables/Disposable;", "d", "(Lcom/avito/android/deep_linking/DeeplinkClickStreamProvider;)Lio/reactivex/disposables/Disposable;", "c", "Lcom/avito/android/publish_limits_info/analytics/PublishLimitsEventTracker;", "s", "Lcom/avito/android/publish_limits_info/analytics/PublishLimitsEventTracker;", "limitAnalyticsTracker", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "clickSubscription", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/tariff/fees_methods/viewmodel/HighDemandBottomSheetParams;", "h", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "bottomSheetLiveData", "Lcom/avito/android/deep_linking/links/DeepLink;", "f", "routingEventsLiveData", "k", "getRoutingEvents", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "routingEvents", "Lio/reactivex/disposables/Disposable;", "loadingSubscription", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/tariff/fees_methods/viewmodel/FeesScreenState;", "e", "Landroidx/lifecycle/MutableLiveData;", "progressChangesLiveData", "Lcom/avito/android/tariff/routing/NavigationIcon;", g.a, "navigationIconLiveData", AuthSource.OPEN_CHANNEL_LIST, "getBottomSheetChanges", "bottomSheetChanges", "Landroidx/lifecycle/LiveData;", "l", "Landroidx/lifecycle/LiveData;", "getNavigationIconChanges", "()Landroidx/lifecycle/LiveData;", "navigationIconChanges", "n", "getCloseBottomSheetChanges", "closeBottomSheetChanges", "i", "closeBottomSheetLiveData", "Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsRepository;", "p", "Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsRepository;", "repository", "j", "getProgressChanges", "progressChanges", "", "o", "Ljava/lang/String;", "checkoutContext", "Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsConverter;", VKApiConst.Q, "Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsConverter;", "converter", "Lcom/avito/android/util/SchedulersFactory;", "r", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "", "isClosable", "<init>", "(Ljava/lang/String;Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsRepository;Lcom/avito/android/tariff/fees_methods/viewmodel/FeeMethodsConverter;Lcom/avito/android/util/SchedulersFactory;ZLcom/avito/android/publish_limits_info/analytics/PublishLimitsEventTracker;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class FeeMethodsViewModelImpl extends ViewModel implements FeeMethodsViewModel {
    public Disposable c;
    public CompositeDisposable d = new CompositeDisposable();
    public final MutableLiveData<LoadingState<FeesScreenState>> e;
    public final SingleLiveEvent<DeepLink> f;
    public final MutableLiveData<NavigationIcon> g;
    public final SingleLiveEvent<HighDemandBottomSheetParams> h;
    public final SingleLiveEvent<Unit> i;
    @NotNull
    public final LiveData<LoadingState<FeesScreenState>> j;
    @NotNull
    public final SingleLiveEvent<DeepLink> k;
    @NotNull
    public final LiveData<NavigationIcon> l;
    @NotNull
    public final SingleLiveEvent<HighDemandBottomSheetParams> m;
    @NotNull
    public final SingleLiveEvent<Unit> n;
    public final String o;
    public final FeeMethodsRepository p;
    public final FeeMethodsConverter q;
    public final SchedulersFactory r;
    public final PublishLimitsEventTracker s;

    public static final class a<T, R> implements Function<LoadingState<? super Pair<? extends FeeMethodsResult, ? extends LimitsInfo>>, LoadingState<? super FeesScreenState>> {
        public final /* synthetic */ FeeMethodsViewModelImpl a;

        public a(FeeMethodsViewModelImpl feeMethodsViewModelImpl) {
            this.a = feeMethodsViewModelImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsConverter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super FeesScreenState> apply(LoadingState<? super Pair<? extends FeeMethodsResult, ? extends LimitsInfo>> loadingState) {
            LoadingState<? super Pair<? extends FeeMethodsResult, ? extends LimitsInfo>> loadingState2 = loadingState;
            Intrinsics.checkNotNullParameter(loadingState2, "it");
            return this.a.q.convert(loadingState2);
        }
    }

    public static final class b<T> implements Consumer<LoadingState<? super FeesScreenState>> {
        public final /* synthetic */ FeeMethodsViewModelImpl a;

        public b(FeeMethodsViewModelImpl feeMethodsViewModelImpl) {
            this.a = feeMethodsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super FeesScreenState> loadingState) {
            LoadingState<? super FeesScreenState> loadingState2 = loadingState;
            FeeMethodsViewModelImpl feeMethodsViewModelImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
            FeeMethodsViewModelImpl.access$trackLimitsInfoShow(feeMethodsViewModelImpl, loadingState2);
            this.a.e.setValue(loadingState2);
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ FeeMethodsViewModelImpl a;

        public c(FeeMethodsViewModelImpl feeMethodsViewModelImpl) {
            this.a = feeMethodsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r3v4, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.e.setValue(new LoadingState.Error(new ErrorWithMessage.SimpleMessageError(th.toString())));
        }
    }

    public static final class d<T> implements Consumer<DeepLink> {
        public final /* synthetic */ FeeMethodsViewModelImpl a;

        public d(FeeMethodsViewModelImpl feeMethodsViewModelImpl) {
            this.a = feeMethodsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(DeepLink deepLink) {
            DeepLink deepLink2 = deepLink;
            SingleLiveEvent singleLiveEvent = this.a.f;
            Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
            singleLiveEvent.setValue(deepLink2);
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public static final e a = new e();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Timber.e(th);
        }
    }

    public FeeMethodsViewModelImpl(@NotNull String str, @NotNull FeeMethodsRepository feeMethodsRepository, @NotNull FeeMethodsConverter feeMethodsConverter, @NotNull SchedulersFactory schedulersFactory, boolean z, @NotNull PublishLimitsEventTracker publishLimitsEventTracker) {
        Intrinsics.checkNotNullParameter(str, "checkoutContext");
        Intrinsics.checkNotNullParameter(feeMethodsRepository, "repository");
        Intrinsics.checkNotNullParameter(feeMethodsConverter, "converter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(publishLimitsEventTracker, "limitAnalyticsTracker");
        this.o = str;
        this.p = feeMethodsRepository;
        this.q = feeMethodsConverter;
        this.r = schedulersFactory;
        this.s = publishLimitsEventTracker;
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.c = empty;
        MutableLiveData<LoadingState<FeesScreenState>> mutableLiveData = new MutableLiveData<>();
        this.e = mutableLiveData;
        SingleLiveEvent<DeepLink> singleLiveEvent = new SingleLiveEvent<>();
        this.f = singleLiveEvent;
        MutableLiveData<NavigationIcon> mutableLiveData2 = new MutableLiveData<>();
        this.g = mutableLiveData2;
        SingleLiveEvent<HighDemandBottomSheetParams> singleLiveEvent2 = new SingleLiveEvent<>();
        this.h = singleLiveEvent2;
        SingleLiveEvent<Unit> singleLiveEvent3 = new SingleLiveEvent<>();
        this.i = singleLiveEvent3;
        c();
        mutableLiveData2.setValue(z ? NavigationIcon.CROSS : NavigationIcon.BACK);
        this.j = mutableLiveData;
        this.k = singleLiveEvent;
        this.l = mutableLiveData2;
        this.m = singleLiveEvent2;
        this.n = singleLiveEvent3;
    }

    public static final void access$trackFeesMethodClicked(FeeMethodsViewModelImpl feeMethodsViewModelImpl, String str) {
        T t;
        LoadingState<FeesScreenState> value = feeMethodsViewModelImpl.e.getValue();
        LimitsInfo limitsInfo = null;
        if (!(value instanceof LoadingState.Loaded)) {
            value = null;
        }
        LoadingState.Loaded loaded = (LoadingState.Loaded) value;
        if (loaded != null) {
            String itemId = ((FeesScreenState) loaded.getData()).getItemId();
            Iterator<T> it = ((FeesScreenState) loaded.getData()).getItems().iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (t instanceof LimitsInfoItem) {
                    break;
                }
            }
            T t2 = t;
            if (t2 != null) {
                limitsInfo = t2.getInfo();
            }
            feeMethodsViewModelImpl.s.trackFeesMethodClicked(itemId, str, limitsInfo);
        }
    }

    public static final void access$trackLimitsInfoShow(FeeMethodsViewModelImpl feeMethodsViewModelImpl, LoadingState loadingState) {
        T t;
        Objects.requireNonNull(feeMethodsViewModelImpl);
        if (loadingState instanceof LoadingState.Loaded) {
            LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState;
            String itemId = ((FeesScreenState) loaded.getData()).getItemId();
            Iterator<T> it = ((FeesScreenState) loaded.getData()).getItems().iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (t instanceof LimitsInfoItem) {
                    break;
                }
            }
            T t2 = t;
            if (t2 != null) {
                feeMethodsViewModelImpl.s.trackLimitsInfoShown(new ItemId.Advert(itemId), t2.getInfo());
            }
        }
    }

    public final void c() {
        this.c.dispose();
        Disposable subscribe = this.p.getFeeMethods(this.o).map(new a(this)).observeOn(this.r.mainThread()).subscribe(new b(this), new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "repository.getFeeMethods…ror(error)\n            })");
        this.c = subscribe;
    }

    public final Disposable d(DeeplinkClickStreamProvider deeplinkClickStreamProvider) {
        Disposable subscribe = deeplinkClickStreamProvider.getDeeplinkClicks().throttleFirst(100, TimeUnit.MILLISECONDS).observeOn(this.r.mainThread()).subscribe(new d(this), e.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "provider.deeplinkClicks\n…ber.e(it) }\n            )");
        return subscribe;
    }

    @Override // com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsViewModel
    @NotNull
    public SingleLiveEvent<HighDemandBottomSheetParams> getBottomSheetChanges() {
        return this.m;
    }

    @Override // com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsViewModel
    @NotNull
    public SingleLiveEvent<Unit> getCloseBottomSheetChanges() {
        return this.n;
    }

    @Override // com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsViewModel
    @NotNull
    public LiveData<NavigationIcon> getNavigationIconChanges() {
        return this.l;
    }

    @Override // com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsViewModel
    @NotNull
    public LiveData<LoadingState<FeesScreenState>> getProgressChanges() {
        return this.j;
    }

    @Override // com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsViewModel
    @NotNull
    public SingleLiveEvent<DeepLink> getRoutingEvents() {
        return this.k;
    }

    @Override // com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsViewModel
    public void observeItemClicks(@NotNull Set<? extends ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "itemPresenterSet");
        this.d.clear();
        for (T t : set) {
            if (t instanceof LimitsInfoItemPresenter) {
                DisposableKt.plusAssign(this.d, d(t));
            } else if (t instanceof FeeMethodPresenter) {
                CompositeDisposable compositeDisposable = this.d;
                Disposable subscribe = t.getDeeplinkClicks().throttleFirst(100, TimeUnit.MILLISECONDS).observeOn(this.r.mainThread()).doOnNext(new a0(0, this)).subscribe(new a0(1, this), a2.a.a.e3.e.f.d.a);
                Intrinsics.checkNotNullExpressionValue(subscribe, "provider.deeplinkClicks\n…ber.e(it) }\n            )");
                DisposableKt.plusAssign(compositeDisposable, subscribe);
            } else if (t instanceof DeeplinkClickStreamProvider) {
                DisposableKt.plusAssign(this.d, d(t));
            } else if (t instanceof HighDemandPresenter) {
                CompositeDisposable compositeDisposable2 = this.d;
                Disposable subscribe2 = t.getButtonClicks().throttleFirst(100, TimeUnit.MILLISECONDS).observeOn(this.r.mainThread()).subscribe(new a2.a.a.e3.e.f.b(this), a2.a.a.e3.e.f.c.a);
                Intrinsics.checkNotNullExpressionValue(subscribe2, "item.buttonClicks\n      …ber.e(it) }\n            )");
                DisposableKt.plusAssign(compositeDisposable2, subscribe2);
            }
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.d.clear();
        this.c.dispose();
    }

    @Override // com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsViewModel
    public void onRetryButtonClick() {
        c();
    }
}
