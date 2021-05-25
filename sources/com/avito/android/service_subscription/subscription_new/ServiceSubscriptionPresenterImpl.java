package com.avito.android.service_subscription.subscription_new;

import a2.a.a.p2.a.b;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Color;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.remote.model.UniversalColorKt;
import com.avito.android.remote.model.profile.DescriptionAttribute;
import com.avito.android.remote.model.service_subscription.PackageAttribute;
import com.avito.android.remote.model.service_subscription_legacy.ServiceSubscriptionResponse;
import com.avito.android.service_subscription.ServiceSubscriptionInteractor;
import com.avito.android.service_subscription.remote.Background;
import com.avito.android.service_subscription.remote.Banner;
import com.avito.android.service_subscription.remote.Footer;
import com.avito.android.service_subscription.remote.ServiceSubscription;
import com.avito.android.service_subscription.remote.ServiceSubscriptionPackages;
import com.avito.android.service_subscription.subscription_new.PackageAttributeViewData;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.util.Flowables;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Observables;
import com.avito.android.util.SchedulersFactory;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010#\u001a\u00020 \u0012\b\u00104\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b5\u00106J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\bJ\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\bJ'\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010-R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00103\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102¨\u00067"}, d2 = {"Lcom/avito/android/service_subscription/subscription_new/ServiceSubscriptionPresenterImpl;", "Lcom/avito/android/service_subscription/subscription_new/ServiceSubscriptionPresenter;", "Lcom/avito/android/service_subscription/subscription_new/ServiceSubscriptionView;", "view", "", "attachView", "(Lcom/avito/android/service_subscription/subscription_new/ServiceSubscriptionView;)V", "detachView", "()V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "attachBackPressedListener", "(Lcom/avito/android/ui/fragments/OnBackPressedListener;)V", "detachBackPressedListener", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/service_subscription_legacy/ServiceSubscriptionResponse;", "subscriptionResponse", "", "Lcom/avito/android/service_subscription/subscription_new/PackageAttributeViewData;", "packageAttributes", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/service_subscription_legacy/ServiceSubscriptionResponse;Ljava/util/List;)V", "Lcom/avito/android/service_subscription/ServiceSubscriptionInteractor;", g.a, "Lcom/avito/android/service_subscription/ServiceSubscriptionInteractor;", "interactor", "d", "Ljava/util/List;", "Lcom/avito/android/service_subscription/subscription_new/ServiceSubscriptionView;", "Lcom/avito/android/service_subscription/subscription_new/ColorParser;", "i", "Lcom/avito/android/service_subscription/subscription_new/ColorParser;", "colorParser", "", "e", "Z", "actionEnabled", "Lcom/avito/android/util/SchedulersFactory;", "h", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "c", "Lcom/avito/android/remote/model/service_subscription_legacy/ServiceSubscriptionResponse;", "f", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "backListener", "state", "<init>", "(Lcom/avito/android/service_subscription/ServiceSubscriptionInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/service_subscription/subscription_new/ColorParser;Lcom/avito/android/util/Kundle;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ServiceSubscriptionPresenterImpl implements ServiceSubscriptionPresenter {
    public CompositeDisposable a = new CompositeDisposable();
    public ServiceSubscriptionView b;
    public ServiceSubscriptionResponse c;
    public List<? extends PackageAttributeViewData> d;
    public boolean e;
    public OnBackPressedListener f;
    public final ServiceSubscriptionInteractor g;
    public final SchedulersFactory h;
    public final ColorParser i;

    public static final class a extends Lambda implements Function1<LoadingState<? super ServiceSubscriptionResponse>, Unit> {
        public final /* synthetic */ ServiceSubscriptionPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ServiceSubscriptionPresenterImpl serviceSubscriptionPresenterImpl) {
            super(1);
            this.a = serviceSubscriptionPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(LoadingState<? super ServiceSubscriptionResponse> loadingState) {
            LoadingState<? super ServiceSubscriptionResponse> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loading) {
                ServiceSubscriptionView serviceSubscriptionView = this.a.b;
                if (serviceSubscriptionView != null) {
                    serviceSubscriptionView.showProgress();
                }
            } else if (loadingState2 instanceof LoadingState.Loaded) {
                ServiceSubscriptionPresenterImpl.access$onSubscriptionLoadingSuccess(this.a, (LoadingState.Loaded) loadingState2);
            } else if (loadingState2 instanceof LoadingState.Error) {
                ServiceSubscriptionPresenterImpl.access$onSubscriptionLoadingError(this.a, (LoadingState.Error) loadingState2);
            }
            return Unit.INSTANCE;
        }
    }

    public ServiceSubscriptionPresenterImpl(@NotNull ServiceSubscriptionInteractor serviceSubscriptionInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull ColorParser colorParser, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(serviceSubscriptionInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(colorParser, "colorParser");
        this.g = serviceSubscriptionInteractor;
        this.h = schedulersFactory;
        this.i = colorParser;
        List<? extends PackageAttributeViewData> list = null;
        this.c = kundle != null ? (ServiceSubscriptionResponse) kundle.getParcelable("subscription") : null;
        this.d = kundle != null ? kundle.getParcelableList("packages_attributes") : list;
        this.e = kundle != null ? kundle.getBoolean("action_enabled", true) : true;
    }

    public static final void access$onOrderCallbackError(ServiceSubscriptionPresenterImpl serviceSubscriptionPresenterImpl, LoadingState.Error error) {
        ServiceSubscriptionView serviceSubscriptionView;
        Objects.requireNonNull(serviceSubscriptionPresenterImpl);
        TypedError error2 = error.getError();
        if (error2 instanceof ErrorWithMessage.NetworkError) {
            ServiceSubscriptionView serviceSubscriptionView2 = serviceSubscriptionPresenterImpl.b;
            if (serviceSubscriptionView2 != null) {
                serviceSubscriptionView2.showActionError(((ErrorWithMessage.NetworkError) error2).getMessage());
            }
            serviceSubscriptionPresenterImpl.e = true;
            ServiceSubscriptionView serviceSubscriptionView3 = serviceSubscriptionPresenterImpl.b;
            if (serviceSubscriptionView3 != null) {
                serviceSubscriptionView3.setActionEnabled(true);
            }
        } else if ((error2 instanceof ErrorWithMessage) && (serviceSubscriptionView = serviceSubscriptionPresenterImpl.b) != null) {
            serviceSubscriptionView.showActionError(((ErrorWithMessage) error2).getMessage());
        }
    }

    public static final void access$onOrderCallbackSuccess(ServiceSubscriptionPresenterImpl serviceSubscriptionPresenterImpl, LoadingState.Loaded loaded) {
        ServiceSubscriptionView serviceSubscriptionView;
        Objects.requireNonNull(serviceSubscriptionPresenterImpl);
        String message = ((SuccessResult) loaded.getData()).getMessage();
        if (message != null && (serviceSubscriptionView = serviceSubscriptionPresenterImpl.b) != null) {
            serviceSubscriptionView.showSnackbar(message);
        }
    }

    public static final void access$onSubscriptionLoadingError(ServiceSubscriptionPresenterImpl serviceSubscriptionPresenterImpl, LoadingState.Error error) {
        ServiceSubscriptionView serviceSubscriptionView = serviceSubscriptionPresenterImpl.b;
        if (serviceSubscriptionView != null) {
            serviceSubscriptionView.hideProgress();
            if (error.getError() instanceof ErrorWithMessage) {
                TypedError error2 = error.getError();
                Objects.requireNonNull(error2, "null cannot be cast to non-null type com.avito.android.remote.error.ErrorWithMessage");
                serviceSubscriptionView.showLoadingError(((ErrorWithMessage) error2).getMessage());
            }
        }
    }

    public static final void access$onSubscriptionLoadingSuccess(ServiceSubscriptionPresenterImpl serviceSubscriptionPresenterImpl, LoadingState.Loaded loaded) {
        ArrayList arrayList;
        ServiceSubscriptionPackages packages;
        List<PackageAttribute> attributes;
        Object obj;
        ServiceSubscriptionView serviceSubscriptionView = serviceSubscriptionPresenterImpl.b;
        if (serviceSubscriptionView != null) {
            serviceSubscriptionView.hideProgress();
        }
        ServiceSubscriptionResponse serviceSubscriptionResponse = (ServiceSubscriptionResponse) loaded.getData();
        serviceSubscriptionPresenterImpl.c = serviceSubscriptionResponse;
        ServiceSubscription subscription = serviceSubscriptionResponse.getSubscription();
        if (subscription == null || (packages = subscription.getPackages()) == null || (attributes = packages.getAttributes()) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(e.collectionSizeOrDefault(attributes, 10));
            for (T t : attributes) {
                if (t instanceof PackageAttribute.Regular) {
                    obj = new PackageAttributeViewData.Regular(t);
                } else if (t instanceof PackageAttribute.Monster) {
                    obj = new PackageAttributeViewData.Monster(t);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                arrayList.add(obj);
            }
        }
        serviceSubscriptionPresenterImpl.d = arrayList;
        serviceSubscriptionPresenterImpl.a(serviceSubscriptionResponse, arrayList);
    }

    public static final void access$orderCallback(ServiceSubscriptionPresenterImpl serviceSubscriptionPresenterImpl) {
        serviceSubscriptionPresenterImpl.e = false;
        ServiceSubscriptionView serviceSubscriptionView = serviceSubscriptionPresenterImpl.b;
        if (serviceSubscriptionView != null) {
            serviceSubscriptionView.setActionEnabled(false);
        }
        CompositeDisposable compositeDisposable = serviceSubscriptionPresenterImpl.a;
        Flowable<LoadingState<SuccessResult>> observeOn = serviceSubscriptionPresenterImpl.g.orderCallback().toFlowable(BackpressureStrategy.DROP).observeOn(serviceSubscriptionPresenterImpl.h.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "interactor\n            .…lersFactory.mainThread())");
        DisposableKt.plusAssign(compositeDisposable, Flowables.subscribeOnNext(observeOn, new a2.a.a.p2.a.a(serviceSubscriptionPresenterImpl)));
    }

    public final void a(ServiceSubscriptionResponse serviceSubscriptionResponse, List<? extends PackageAttributeViewData> list) {
        ServiceSubscription subscription;
        Color color;
        ServiceSubscriptionView serviceSubscriptionView = this.b;
        if (serviceSubscriptionView != null && (subscription = serviceSubscriptionResponse.getSubscription()) != null) {
            serviceSubscriptionView.setTitle(serviceSubscriptionResponse.getTitle());
            serviceSubscriptionView.setSubscriptionTitle(subscription.getTitle());
            serviceSubscriptionView.setSubscriptionSubtitle(subscription.getSubtitle());
            List<DescriptionAttribute> params = subscription.getParams();
            if (params != null) {
                serviceSubscriptionView.setAttributes(params);
            }
            ServiceSubscriptionPackages packages = subscription.getPackages();
            UniversalColor universalColor = null;
            String str = null;
            universalColor = null;
            serviceSubscriptionView.setPackagesTitle(packages != null ? packages.getTitle() : null);
            Footer footer = subscription.getFooter();
            serviceSubscriptionView.setFooter(footer != null ? footer.getDescription() : null);
            if (list != null) {
                serviceSubscriptionView.setPackageAttributes(list);
            }
            Banner banner = subscription.getBanner();
            if (banner != null) {
                Background background = banner.getBackground();
                if (!(background == null || (color = background.getColor()) == null)) {
                    int value = color.getValue();
                    Background background2 = banner.getBackground();
                    if (background2 != null) {
                        str = background2.getColorKey();
                    }
                    universalColor = UniversalColorKt.universalColorOf(str, value);
                }
                serviceSubscriptionView.showBanner(banner.getTitle(), banner.getDescription(), universalColor);
            }
            Action action = subscription.getAction();
            if (action != null) {
                serviceSubscriptionView.initActionButton(action.getTitle());
                serviceSubscriptionView.setActionEnabled(this.e);
            }
        }
    }

    @Override // com.avito.android.service_subscription.subscription_new.ServiceSubscriptionPresenter
    public void attachBackPressedListener(@NotNull OnBackPressedListener onBackPressedListener) {
        Intrinsics.checkNotNullParameter(onBackPressedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f = onBackPressedListener;
    }

    @Override // com.avito.android.service_subscription.subscription_new.ServiceSubscriptionPresenter
    public void attachView(@NotNull ServiceSubscriptionView serviceSubscriptionView) {
        Intrinsics.checkNotNullParameter(serviceSubscriptionView, "view");
        this.b = serviceSubscriptionView;
        CompositeDisposable compositeDisposable = this.a;
        Observable<Unit> subscribeOn = serviceSubscriptionView.getSubscriptionActionClicks().subscribeOn(this.h.mainThread());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "view.subscriptionActionC…lersFactory.mainThread())");
        DisposableKt.plusAssign(compositeDisposable, Observables.subscribeOnNext(subscribeOn, new f6(0, this)));
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(serviceSubscriptionView.getNavigationClicks(), new b(this)));
        CompositeDisposable compositeDisposable2 = this.a;
        Observable<Unit> debounce = serviceSubscriptionView.getRefreshClicks().debounce(300, TimeUnit.MILLISECONDS, this.h.computation());
        Intrinsics.checkNotNullExpressionValue(debounce, "view.refreshClicks\n     …ersFactory.computation())");
        DisposableKt.plusAssign(compositeDisposable2, Observables.subscribeOnNext(debounce, new f6(1, this)));
        ServiceSubscriptionResponse serviceSubscriptionResponse = this.c;
        if ((serviceSubscriptionResponse != null ? serviceSubscriptionResponse.getSubscription() : null) == null) {
            b();
        } else {
            a(serviceSubscriptionResponse, this.d);
        }
    }

    public final void b() {
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.T1(this.h, this.g.loadServiceSubscription(), "interactor.loadServiceSu…lersFactory.mainThread())"), new a(this)));
    }

    @Override // com.avito.android.service_subscription.subscription_new.ServiceSubscriptionPresenter
    public void detachBackPressedListener() {
        this.f = null;
    }

    @Override // com.avito.android.service_subscription.subscription_new.ServiceSubscriptionPresenter
    public void detachView() {
        this.a.clear();
        this.b = null;
    }

    @Override // com.avito.android.service_subscription.subscription_new.ServiceSubscriptionPresenter
    @NotNull
    public Kundle onSaveState() {
        Kundle kundle = new Kundle();
        kundle.putParcelable("subscription", this.c);
        kundle.putParcelableList("packages_attributes", this.d);
        kundle.putBoolean("action_enabled", Boolean.valueOf(this.e));
        return kundle;
    }
}
