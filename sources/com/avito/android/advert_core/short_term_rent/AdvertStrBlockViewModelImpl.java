package com.avito.android.advert_core.short_term_rent;

import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlock;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.AdvertSellerShortTermRent;
import com.avito.android.remote.model.AdvertStrSwitchResponse;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.text.AttributedTextFormatter;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B=\u0012\u0006\u0010I\u001a\u00020F\u0012\u0006\u0010;\u001a\u000208\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\f\u0010E\u001a\b\u0012\u0004\u0012\u00020%0@¢\u0006\u0004\bJ\u0010KJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\"\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010\u0010\u001a\u0004\b#\u0010\u0012R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\"\u0010,\u001a\b\u0012\u0004\u0012\u00020)0\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010\u0010\u001a\u0004\b+\u0010\u0012R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\"\u00107\u001a\b\u0012\u0004\u0012\u00020\b0\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b5\u0010\u0010\u001a\u0004\b6\u0010\u0012R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\"\u0010E\u001a\b\u0012\u0004\u0012\u00020%0@8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010H¨\u0006L"}, d2 = {"Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockViewModel;", "", "isEnabled", "", "onSwitchChanged", "(Z)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onOpenCalendarButtonClick", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "onCleared", "()V", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "c", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getSwitchChanges", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "switchChanges", "d", "getSwitchEnableChanges", "switchEnableChanges", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlock;", "f", "Landroidx/lifecycle/MutableLiveData;", "getDataChanges", "()Landroidx/lifecycle/MutableLiveData;", "dataChanges", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockAnalyticsInteractor;", "o", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockAnalyticsInteractor;", "analyticsInteractor", g.a, "getShowCalendarChanges", "showCalendarChanges", "Lcom/avito/android/remote/model/AdvertSellerShortTermRent;", "j", "Lcom/avito/android/remote/model/AdvertSellerShortTermRent;", "advertDeliveryData", "", "e", "getSwitchErrorChanges", "switchErrorChanges", "Lcom/avito/android/util/text/AttributedTextFormatter;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockViewResourceProvider;", "n", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockViewResourceProvider;", "resourceProvider", "h", "getOpenDeepLinkChanges", "openDeepLinkChanges", "Lcom/avito/android/util/SchedulersFactory3;", "l", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "i", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposable", "Lcom/jakewharton/rxrelay3/PublishRelay;", "p", "Lcom/jakewharton/rxrelay3/PublishRelay;", "getData", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "data", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockInteractor;", "k", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockInteractor;", "interactor", "<init>", "(Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockViewResourceProvider;Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockAnalyticsInteractor;Lcom/jakewharton/rxrelay3/PublishRelay;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertStrBlockViewModelImpl extends ViewModel implements AdvertStrBlockViewModel {
    @NotNull
    public final SingleLiveEvent<Boolean> c = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<Boolean> d = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<String> e = new SingleLiveEvent<>();
    @NotNull
    public final MutableLiveData<AdvertStrBlock> f = new MutableLiveData<>();
    @NotNull
    public final SingleLiveEvent<DeepLink> g = new SingleLiveEvent<>();
    @NotNull
    public final SingleLiveEvent<DeepLink> h = new SingleLiveEvent<>();
    public final CompositeDisposable i;
    public AdvertSellerShortTermRent j;
    public final AdvertStrBlockInteractor k;
    public final SchedulersFactory3 l;
    public final AttributedTextFormatter m;
    public final AdvertStrBlockViewResourceProvider n;
    public final AdvertStrBlockAnalyticsInteractor o;
    @NotNull
    public final PublishRelay<AdvertSellerShortTermRent> p;

    public static final class a<T> implements Consumer<AdvertSellerShortTermRent> {
        public final /* synthetic */ AdvertStrBlockViewModelImpl a;

        public a(AdvertStrBlockViewModelImpl advertStrBlockViewModelImpl) {
            this.a = advertStrBlockViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(AdvertSellerShortTermRent advertSellerShortTermRent) {
            AdvertSellerShortTermRent advertSellerShortTermRent2 = advertSellerShortTermRent;
            this.a.j = advertSellerShortTermRent2;
            MutableLiveData<AdvertStrBlock> dataChanges = this.a.getDataChanges();
            AdvertStrBlockViewModelImpl advertStrBlockViewModelImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(advertSellerShortTermRent2, "it");
            dataChanges.setValue(AdvertStrBlockViewModelImpl.access$toAdvertStrBlock(advertStrBlockViewModelImpl, advertSellerShortTermRent2));
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public static final class c<T> implements Consumer<LoadingState<? super AdvertStrSwitchResponse>> {
        public final /* synthetic */ AdvertStrBlockViewModelImpl a;
        public final /* synthetic */ boolean b;

        public c(AdvertStrBlockViewModelImpl advertStrBlockViewModelImpl, boolean z) {
            this.a = advertStrBlockViewModelImpl;
            this.b = z;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super AdvertStrSwitchResponse> loadingState) {
            AdvertSellerShortTermRent.Switcher onlineBookingField;
            LoadingState<? super AdvertStrSwitchResponse> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                if (((AdvertStrSwitchResponse) ((LoadingState.Loaded) loadingState2).getData()).getSuccess()) {
                    this.a.getSwitchChanges().setValue(Boolean.valueOf(this.b));
                    AdvertSellerShortTermRent advertSellerShortTermRent = this.a.j;
                    if (!(advertSellerShortTermRent == null || (onlineBookingField = advertSellerShortTermRent.getOnlineBookingField()) == null)) {
                        onlineBookingField.setEnabled(this.b);
                    }
                } else {
                    this.a.getSwitchChanges().setValue(Boolean.valueOf(!this.b));
                }
                this.a.getSwitchEnableChanges().setValue(Boolean.TRUE);
            } else if (loadingState2 instanceof LoadingState.Loading) {
                this.a.getSwitchEnableChanges().setValue(Boolean.FALSE);
            } else if (loadingState2 instanceof LoadingState.Error) {
                this.a.getSwitchErrorChanges().setValue(AdvertStrBlockViewModelImpl.access$toErrorMessage(this.a, ((LoadingState.Error) loadingState2).getError()));
                this.a.getSwitchEnableChanges().setValue(Boolean.TRUE);
            }
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public AdvertStrBlockViewModelImpl(@NotNull AdvertStrBlockInteractor advertStrBlockInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull AttributedTextFormatter attributedTextFormatter, @NotNull AdvertStrBlockViewResourceProvider advertStrBlockViewResourceProvider, @NotNull AdvertStrBlockAnalyticsInteractor advertStrBlockAnalyticsInteractor, @NotNull PublishRelay<AdvertSellerShortTermRent> publishRelay) {
        Intrinsics.checkNotNullParameter(advertStrBlockInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(advertStrBlockViewResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(advertStrBlockAnalyticsInteractor, "analyticsInteractor");
        Intrinsics.checkNotNullParameter(publishRelay, "data");
        this.k = advertStrBlockInteractor;
        this.l = schedulersFactory3;
        this.m = attributedTextFormatter;
        this.n = advertStrBlockViewResourceProvider;
        this.o = advertStrBlockAnalyticsInteractor;
        this.p = publishRelay;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.i = compositeDisposable;
        Disposable subscribe = getData().observeOn(schedulersFactory3.mainThread()).subscribe(new a(this), b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "data\n            .observ…error(it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static final AdvertStrBlock access$toAdvertStrBlock(AdvertStrBlockViewModelImpl advertStrBlockViewModelImpl, AdvertSellerShortTermRent advertSellerShortTermRent) {
        AdvertStrBlock.Switcher switcher;
        ArrayList arrayList;
        CharSequence charSequence;
        Objects.requireNonNull(advertStrBlockViewModelImpl);
        AdvertSellerShortTermRent.Switcher onlineBookingField = advertSellerShortTermRent.getOnlineBookingField();
        Action action = null;
        if (onlineBookingField != null) {
            String title = onlineBookingField.getTitle();
            boolean isEnabled = onlineBookingField.isEnabled();
            AttributedText disclaimer = onlineBookingField.getDisclaimer();
            if (disclaimer != null) {
                disclaimer.setOnDeepLinkClickListener(new OnDeepLinkClickListener() { // from class: com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewModelImpl$toAdvertStrBlock$$inlined$let$lambda$1
                    @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
                    public void onDeepLinkClick(@NotNull DeepLink deepLink) {
                        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
                        AdvertStrBlockViewModelImpl.this.getOpenDeepLinkChanges().postValue(deepLink);
                    }
                });
                charSequence = advertStrBlockViewModelImpl.m.format(disclaimer);
            } else {
                charSequence = null;
            }
            switcher = new AdvertStrBlock.Switcher(title, isEnabled, charSequence);
        } else {
            switcher = null;
        }
        List<AdvertSellerShortTermRent.Parameter> parameters = advertSellerShortTermRent.getParameters();
        if (parameters != null) {
            arrayList = new ArrayList(e.collectionSizeOrDefault(parameters, 10));
            for (T t : parameters) {
                arrayList.add(new AdvertStrBlock.Parameter(t.getTitle(), t.getDescription()));
            }
        } else {
            arrayList = null;
        }
        Action manageCalendarButton = advertSellerShortTermRent.getManageCalendarButton();
        if (manageCalendarButton != null) {
            action = manageCalendarButton;
        }
        return new AdvertStrBlock(switcher, arrayList, action);
    }

    public static final String access$toErrorMessage(AdvertStrBlockViewModelImpl advertStrBlockViewModelImpl, TypedError typedError) {
        Objects.requireNonNull(advertStrBlockViewModelImpl);
        if (typedError instanceof ErrorWithMessage) {
            return ((ErrorWithMessage) typedError).getMessage();
        }
        return advertStrBlockViewModelImpl.n.getUnknownError();
    }

    @Override // com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewModel
    @NotNull
    public PublishRelay<AdvertSellerShortTermRent> getData() {
        return this.p;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.i.clear();
    }

    @Override // com.avito.android.advert_core.short_term_rent.AdvertStrBlockView.CalendarButtonClickListener
    public void onOpenCalendarButtonClick(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        getShowCalendarChanges().postValue(deepLink);
        this.o.sendManageCalendarEvent();
    }

    @Override // com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewModel
    public void onSwitchChanged(boolean z) {
        CompositeDisposable compositeDisposable = this.i;
        Disposable subscribe = this.k.toggleOnlineBooking(z).observeOn(this.l.mainThread()).subscribe(new c(this, z), d.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.toggleOnlineB…          }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewModel
    @NotNull
    public MutableLiveData<AdvertStrBlock> getDataChanges() {
        return this.f;
    }

    @Override // com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewModel
    @NotNull
    public SingleLiveEvent<DeepLink> getOpenDeepLinkChanges() {
        return this.h;
    }

    @Override // com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewModel
    @NotNull
    public SingleLiveEvent<DeepLink> getShowCalendarChanges() {
        return this.g;
    }

    @Override // com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewModel
    @NotNull
    public SingleLiveEvent<Boolean> getSwitchChanges() {
        return this.c;
    }

    @Override // com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewModel
    @NotNull
    public SingleLiveEvent<Boolean> getSwitchEnableChanges() {
        return this.d;
    }

    @Override // com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewModel
    @NotNull
    public SingleLiveEvent<String> getSwitchErrorChanges() {
        return this.e;
    }
}
