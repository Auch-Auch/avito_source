package com.avito.android.advert.item.dfpcreditinfo;

import a2.a.a.f.x.t.c;
import a2.a.a.f.x.t.d;
import a2.a.a.f.x.t.e;
import a2.a.a.f.x.t.f;
import a2.g.r.g;
import android.app.Application;
import android.net.Uri;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.ab_tests.configs.SravniWebTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditButton;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfo;
import com.avito.android.advert.item.dfpcreditinfo.PhoneChooserItem;
import com.avito.android.advert.item.dfpcreditinfo.PhoneChooserView;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.advert_core.analytics.broker.CalculatorType;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.model.AdvertDetails;
import com.avito.android.remote.model.DfpBannerItem;
import com.avito.android.remote.model.user_profile.Phone;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.Uris;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.utils.extlib.LibUtilKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BM\u0012\u0006\u0010D\u001a\u00020A\u0012\u0006\u0010Y\u001a\u00020V\u0012\u0006\u0010k\u001a\u00020h\u0012\u0006\u0010t\u001a\u00020q\u0012\u0006\u0010Q\u001a\u00020N\u0012\u0006\u0010g\u001a\u00020d\u0012\u0006\u0010U\u001a\u00020R\u0012\f\u0010c\u001a\b\u0012\u0004\u0012\u00020`0_¢\u0006\u0004\bu\u0010vJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0011J\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012¢\u0006\u0004\b\u0016\u0010\u0015J\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012¢\u0006\u0004\b\u0018\u0010\u0015J\u0013\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0012¢\u0006\u0004\b\u001a\u0010\u0015J\u001f\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001b0\u0012¢\u0006\u0004\b\u001e\u0010\u0015J\u0013\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u001f\u0010\u0015J\u0013\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170\u0012¢\u0006\u0004\b \u0010\u0015J\u0013\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012¢\u0006\u0004\b!\u0010\u0015J\u000f\u0010\"\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\"\u0010\nJ\u000f\u0010#\u001a\u00020\u0006H\u0016¢\u0006\u0004\b#\u0010\nJ\u000f\u0010$\u001a\u00020\u0006H\u0016¢\u0006\u0004\b$\u0010\nJ\u000f\u0010%\u001a\u00020\u0006H\u0016¢\u0006\u0004\b%\u0010\nJ\u000f\u0010&\u001a\u00020\u0006H\u0016¢\u0006\u0004\b&\u0010\nJ\u000f\u0010'\u001a\u00020\u0006H\u0016¢\u0006\u0004\b'\u0010\nJ\u0017\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0019H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010-\u001a\u00020\u00062\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\u00062\u0006\u0010/\u001a\u00020+H\u0016¢\u0006\u0004\b0\u0010.J\u000f\u00101\u001a\u00020\u0006H\u0016¢\u0006\u0004\b1\u0010\nJ\u0017\u00103\u001a\u00020\u00062\u0006\u00102\u001a\u00020+H\u0016¢\u0006\u0004\b3\u0010.J\u000f\u00104\u001a\u00020\u0006H\u0016¢\u0006\u0004\b4\u0010\nJ\u000f\u00105\u001a\u00020\u0006H\u0016¢\u0006\u0004\b5\u0010\nJ\u000f\u00106\u001a\u00020\u0006H\u0016¢\u0006\u0004\b6\u0010\nJ\u0017\u00109\u001a\u00020\u00062\u0006\u00108\u001a\u000207H\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0006H\u0016¢\u0006\u0004\b;\u0010\nJ\u000f\u0010<\u001a\u00020\u0006H\u0016¢\u0006\u0004\b<\u0010\nJ\u000f\u0010=\u001a\u00020\u0006H\u0014¢\u0006\u0004\b=\u0010\nR$\u0010@\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010FR(\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001b0H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010JR\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010JR\u001c\u0010c\u001a\b\u0012\u0004\u0012\u00020`0_8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010g\u001a\u00020d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010JR\u0016\u0010k\u001a\u00020h8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bn\u0010MR\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bo\u0010MR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bp\u0010MR\u0016\u0010t\u001a\u00020q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\br\u0010s¨\u0006w"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditButton$Listener;", "Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserView$Listener;", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo;", "dfpCreditInfo", "", "d", "(Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo;)V", "c", "()V", "Lcom/avito/android/remote/model/DfpBannerItem;", "dfpBanner", "Lcom/avito/android/remote/model/AdvertDetails;", "advert", "updateDfpBanner", "(Lcom/avito/android/remote/model/DfpBannerItem;Lcom/avito/android/remote/model/AdvertDetails;)V", "(Lcom/avito/android/remote/model/AdvertDetails;)V", "Landroidx/lifecycle/LiveData;", "", "legalInfoText", "()Landroidx/lifecycle/LiveData;", "creditData", "Landroid/net/Uri;", "privacyUri", "", "isEditing", "Lcom/avito/android/util/LoadingState;", "", "Lcom/avito/android/remote/model/user_profile/Phone;", "phoneChooser", "sravniPhone", "sravniFormUri", "tinkoffFormUri", "onCreditHeaderClick", "onCreditIconClick", "onCreditInfoButtonClick", "onCreditTextClick", "onCreditButtonClick", "onCreditPrivacyLinkClick", "hasFocus", "onInputFieldFocusChanged", "(Z)V", "", "initialPayment", "onInitialPaymentChanged", "(I)V", "loan", "onLoanChanged", "onTermClicked", FirebaseAnalytics.Param.TERM, "onTermSelected", "onAdBlockShown", "onLegalInfoDialogDismiss", "onReloadPhonesClicked", "Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserItem$Phone;", "phone", "onPhoneClicked", "(Lcom/avito/android/advert/item/dfpcreditinfo/PhoneChooserItem$Phone;)V", "onOtherPhoneClicked", "onPhoneChooserClosed", "onCleared", "j", "Lcom/avito/android/util/LoadingState;", "phones", "Landroid/app/Application;", "o", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, g.a, "Z", "loading", "Landroidx/lifecycle/MutableLiveData;", "k", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "n", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/remote/ProfileApi;", "s", "Lcom/avito/android/remote/ProfileApi;", "profileApi", "Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditStorage;", "u", "Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditStorage;", "creditStorage", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditBannerLoader;", "p", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditBannerLoader;", "creditInfoLoader", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "h", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "f", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/configs/SravniWebTestGroup;", VKApiConst.VERSION, "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "sravniWebTestGroup", "Lcom/avito/android/account/AccountStateProvider;", "t", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/util/SchedulersFactory3;", VKApiConst.Q, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "i", "Lcom/avito/android/remote/model/AdvertDetails;", AuthSource.OPEN_CHANNEL_LIST, "e", "l", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "r", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "analyticsInteractor", "<init>", "(Landroid/app/Application;Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditBannerLoader;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/advert/item/dfpcreditinfo/AdvertDetailsCreditStorage;Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class DfpCreditViewModel extends ViewModel implements DfpCreditButton.Listener, PhoneChooserView.Listener {
    public final MutableLiveData<DfpCreditInfo> c = new MutableLiveData<>();
    public final MutableLiveData<String> d = new MutableLiveData<>();
    public final SingleLiveEvent<Uri> e = new SingleLiveEvent<>();
    public final MutableLiveData<Boolean> f = new MutableLiveData<>();
    public boolean g;
    public CompositeDisposable h = new CompositeDisposable();
    public AdvertDetails i;
    public LoadingState<? super List<Phone>> j;
    public final MutableLiveData<LoadingState<List<Phone>>> k = new MutableLiveData<>();
    public final SingleLiveEvent<String> l = new SingleLiveEvent<>();
    public final SingleLiveEvent<Uri> m = new SingleLiveEvent<>();
    public final SingleLiveEvent<Uri> n = new SingleLiveEvent<>();
    public final Application o;
    public final DfpCreditBannerLoader p;
    public final SchedulersFactory3 q;
    public final AdvertDetailsAnalyticsInteractor r;
    public final ProfileApi s;
    public final AccountStateProvider t;
    public final AdvertDetailsCreditStorage u;
    public final SingleManuallyExposedAbTestGroup<SravniWebTestGroup> v;

    public static final class a<T> implements Consumer<List<? extends Phone>> {
        public final /* synthetic */ DfpCreditViewModel a;

        public a(DfpCreditViewModel dfpCreditViewModel) {
            this.a = dfpCreditViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(List<? extends Phone> list) {
            List<? extends Phone> list2 = list;
            Intrinsics.checkNotNullExpressionValue(list2, "result");
            LoadingState.Loaded loaded = new LoadingState.Loaded(list2);
            this.a.j = loaded;
            DfpCreditViewModel.access$updatePhoneChooserIfNeeded(this.a, loaded);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ DfpCreditViewModel a;

        public b(DfpCreditViewModel dfpCreditViewModel) {
            this.a = dfpCreditViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            String message = th.getMessage();
            if (message == null) {
                message = "";
            }
            LoadingState.Error error = new LoadingState.Error(new ErrorWithMessage.SimpleMessageError(message));
            this.a.j = error;
            DfpCreditViewModel.access$updatePhoneChooserIfNeeded(this.a, error);
        }
    }

    public DfpCreditViewModel(@NotNull Application application, @NotNull DfpCreditBannerLoader dfpCreditBannerLoader, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, @NotNull ProfileApi profileApi, @NotNull AccountStateProvider accountStateProvider, @NotNull AdvertDetailsCreditStorage advertDetailsCreditStorage, @NotNull SingleManuallyExposedAbTestGroup<SravniWebTestGroup> singleManuallyExposedAbTestGroup) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(dfpCreditBannerLoader, "creditInfoLoader");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(advertDetailsAnalyticsInteractor, "analyticsInteractor");
        Intrinsics.checkNotNullParameter(profileApi, "profileApi");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(advertDetailsCreditStorage, "creditStorage");
        Intrinsics.checkNotNullParameter(singleManuallyExposedAbTestGroup, "sravniWebTestGroup");
        this.o = application;
        this.p = dfpCreditBannerLoader;
        this.q = schedulersFactory3;
        this.r = advertDetailsAnalyticsInteractor;
        this.s = profileApi;
        this.t = accountStateProvider;
        this.u = advertDetailsCreditStorage;
        this.v = singleManuallyExposedAbTestGroup;
    }

    public static final void access$trackCalculatorRender(DfpCreditViewModel dfpCreditViewModel, DfpCreditInfo dfpCreditInfo) {
        CalculatorType calculatorType;
        dfpCreditViewModel.v.exposeIfNeeded();
        if (dfpCreditInfo instanceof DfpCreditInfo.CreditCalculator) {
            AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor = dfpCreditViewModel.r;
            if (dfpCreditInfo instanceof DfpCreditInfo.CreditCalculator.Tinkoff) {
                calculatorType = CalculatorType.TINKOFF;
            } else if (dfpCreditInfo instanceof DfpCreditInfo.CreditCalculator.Sravni) {
                calculatorType = CalculatorType.SRAVNI;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            advertDetailsAnalyticsInteractor.setCalculatorType(calculatorType);
            dfpCreditViewModel.r.sendCreditCalculatorRender();
        }
    }

    public static final void access$updatePhoneChooserIfNeeded(DfpCreditViewModel dfpCreditViewModel, LoadingState loadingState) {
        if (dfpCreditViewModel.k.getValue() != null) {
            dfpCreditViewModel.k.setValue(loadingState);
        }
    }

    public final void c() {
        this.j = LoadingState.Loading.INSTANCE;
        CompositeDisposable compositeDisposable = this.h;
        Single flatMap = a2.b.a.a.a.e2(this.q, this.s.getProfilePhones(), "profileApi.getProfilePho…scribeOn(schedulers.io())").flatMap(DfpCreditViewModel$getPhones$$inlined$toTyped$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.toTypedSingle() }");
        Single map = flatMap.map(c.a);
        Intrinsics.checkNotNullExpressionValue(map, "profileApi.getProfilePho…       .map { it.phones }");
        Disposable subscribe = map.observeOn(this.q.mainThread()).subscribe(new a(this), new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "getPhones()\n            …(newState)\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @NotNull
    public final LiveData<DfpCreditInfo> creditData() {
        return this.c;
    }

    public final void d(DfpCreditInfo dfpCreditInfo) {
        if (dfpCreditInfo instanceof DfpCreditInfo.Web) {
            BannerInfo bannerInfo = ((DfpCreditInfo.Web) dfpCreditInfo).getBannerInfo();
            AdvertDetails advertDetails = this.i;
            if (advertDetails != null) {
                this.r.sendCreditBannerClick(bannerInfo, advertDetails);
            }
        }
    }

    @NotNull
    public final LiveData<Boolean> isEditing() {
        return this.f;
    }

    @NotNull
    public final LiveData<String> legalInfoText() {
        return this.d;
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditButton.Listener
    public void onAdBlockShown() {
        NativeCustomTemplateAd templateAdOpt;
        DfpCreditInfo value = creditData().getValue();
        if (value != null && (templateAdOpt = value.getTemplateAdOpt()) != null) {
            templateAdOpt.recordImpression();
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.g = false;
        this.h.clear();
        super.onCleared();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: androidx.lifecycle.MutableLiveData<com.avito.android.util.LoadingState<java.util.List<com.avito.android.remote.model.user_profile.Phone>>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditButton.Listener
    public void onCreditButtonClick() {
        DfpCreditInfo value = creditData().getValue();
        if (value != null) {
            Intrinsics.checkNotNullExpressionValue(value, "creditData().value ?: return");
            if (!(value instanceof DfpCreditInfo.CreditCalculator)) {
                value = null;
            }
            DfpCreditInfo.CreditCalculator creditCalculator = (DfpCreditInfo.CreditCalculator) value;
            if (creditCalculator != null) {
                this.r.sendCreditCalculatorSubmit(creditCalculator.getLoan(), creditCalculator.getInitialPayment(), creditCalculator.getPaymentTerm());
                if (creditCalculator instanceof DfpCreditInfo.CreditCalculator.Sravni) {
                    String currentUserId = this.t.getCurrentUserId();
                    Uri buildUri$default = DfpCreditInfo.CreditCalculator.Sravni.buildUri$default((DfpCreditInfo.CreditCalculator.Sravni) creditCalculator, null, 1, null);
                    if (currentUserId == null) {
                        LibUtilKt.clearSravniToken(this.o);
                        if (!Intrinsics.areEqual(buildUri$default, Uri.EMPTY)) {
                            this.m.setValue(buildUri$default);
                        } else {
                            this.l.setValue("");
                        }
                    } else if (!this.u.hasSravniUserId(currentUserId) || !LibUtilKt.isSravniTokenAvailable(this.o)) {
                        LoadingState<? super List<Phone>> loadingState = this.j;
                        if (loadingState == null || (loadingState instanceof LoadingState.Error)) {
                            c();
                        }
                        LibUtilKt.clearSravniToken(this.o);
                        this.k.setValue(this.j);
                    } else if (!Intrinsics.areEqual(buildUri$default, Uri.EMPTY)) {
                        this.m.setValue(buildUri$default);
                    } else {
                        this.l.setValue("");
                    }
                } else if (creditCalculator instanceof DfpCreditInfo.CreditCalculator.Tinkoff) {
                    this.n.setValue(((DfpCreditInfo.CreditCalculator.Tinkoff) creditCalculator).getExternalUri());
                }
            }
        }
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditButton.Listener
    public void onCreditHeaderClick() {
        DfpCreditInfo value = creditData().getValue();
        if (value != null) {
            Intrinsics.checkNotNullExpressionValue(value, "creditData().value ?: return");
            if (value instanceof DfpCreditInfo.Web) {
                ((DfpCreditInfo.Web) value).onHeaderClick();
                d(value);
            }
        }
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditButton.Listener
    public void onCreditIconClick() {
        DfpCreditInfo value = creditData().getValue();
        if (value != null) {
            Intrinsics.checkNotNullExpressionValue(value, "creditData().value ?: return");
            if (value instanceof DfpCreditInfo.Web) {
                ((DfpCreditInfo.Web) value).onLogoClick();
                d(value);
            }
        }
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditButton.Listener
    public void onCreditInfoButtonClick() {
        String legalInfoOpt;
        DfpCreditInfo value = this.c.getValue();
        if (value != null && (legalInfoOpt = value.getLegalInfoOpt()) != null) {
            this.d.setValue(legalInfoOpt);
            AdvertDetails advertDetails = this.i;
            if (advertDetails != null) {
                this.r.sendCreditBannerInfoClick(advertDetails);
            }
        }
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditButton.Listener
    public void onCreditPrivacyLinkClick() {
        DfpCreditInfo value = creditData().getValue();
        if (value != null) {
            Intrinsics.checkNotNullExpressionValue(value, "creditData().value ?: return");
            if (value instanceof DfpCreditInfo.CreditCalculator) {
                DfpCreditInfo.CreditCalculator creditCalculator = (DfpCreditInfo.CreditCalculator) value;
                if (!Uris.isNullOrEmpty(creditCalculator.getClickUri())) {
                    this.e.setValue(creditCalculator.getClickUri());
                }
            }
        }
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditButton.Listener
    public void onCreditTextClick() {
        DfpCreditInfo value = creditData().getValue();
        if (value != null) {
            Intrinsics.checkNotNullExpressionValue(value, "creditData().value ?: return");
            if (value instanceof DfpCreditInfo.Web) {
                ((DfpCreditInfo.Web) value).onTextClick();
                d(value);
            }
        }
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditButton.Listener
    public void onInitialPaymentChanged(int i2) {
        DfpCreditInfo value = creditData().getValue();
        if (value != null) {
            Intrinsics.checkNotNullExpressionValue(value, "creditData().value ?: return");
            if (value instanceof DfpCreditInfo.CreditCalculator) {
                DfpCreditInfo.CreditCalculator creditCalculator = (DfpCreditInfo.CreditCalculator) value;
                creditCalculator.calculate(Math.min(creditCalculator.getPrice() - creditCalculator.getMinLoan(), i2), creditCalculator.getPaymentTerm(), creditCalculator.getLoan());
                this.c.setValue(value);
            }
        }
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditButton.Listener
    public void onInputFieldFocusChanged(boolean z) {
        if (!Intrinsics.areEqual(Boolean.valueOf(z), this.f.getValue())) {
            this.f.setValue(Boolean.valueOf(z));
            if (z) {
                this.r.sendCreditCalculatorValueChanged();
            }
        }
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditButton.Listener
    public void onLegalInfoDialogDismiss() {
        this.d.setValue(null);
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditButton.Listener
    public void onLoanChanged(int i2) {
        DfpCreditInfo value = creditData().getValue();
        if (value != null) {
            Intrinsics.checkNotNullExpressionValue(value, "creditData().value ?: return");
            if (value instanceof DfpCreditInfo.CreditCalculator) {
                DfpCreditInfo.CreditCalculator creditCalculator = (DfpCreditInfo.CreditCalculator) value;
                creditCalculator.calculate(creditCalculator.getInitialPayment(), creditCalculator.getPaymentTerm(), i2);
                this.c.setValue(value);
            }
        }
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.PhoneChooserView.Listener
    public void onOtherPhoneClicked() {
        DfpCreditInfo value = creditData().getValue();
        if (!(value instanceof DfpCreditInfo.CreditCalculator.Sravni)) {
            value = null;
        }
        DfpCreditInfo.CreditCalculator.Sravni sravni = (DfpCreditInfo.CreditCalculator.Sravni) value;
        if (sravni != null) {
            String currentUserId = this.t.getCurrentUserId();
            if (currentUserId != null) {
                this.u.setSravniUserId(currentUserId);
            }
            Uri buildUri$default = DfpCreditInfo.CreditCalculator.Sravni.buildUri$default(sravni, null, 1, null);
            if (true ^ Intrinsics.areEqual(buildUri$default, Uri.EMPTY)) {
                this.m.setValue(buildUri$default);
            } else {
                this.l.setValue("");
            }
            this.k.setValue(null);
        }
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.PhoneChooserView.Listener
    public void onPhoneChooserClosed() {
        this.k.setValue(null);
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.PhoneChooserView.Listener
    public void onPhoneClicked(@NotNull PhoneChooserItem.Phone phone) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        DfpCreditInfo value = creditData().getValue();
        if (!(value instanceof DfpCreditInfo.CreditCalculator.Sravni)) {
            value = null;
        }
        DfpCreditInfo.CreditCalculator.Sravni sravni = (DfpCreditInfo.CreditCalculator.Sravni) value;
        if (sravni != null) {
            String currentUserId = this.t.getCurrentUserId();
            if (currentUserId != null) {
                this.u.setSravniUserId(currentUserId);
            }
            Uri buildUri = sravni.buildUri(phone.getPhone());
            if (!Intrinsics.areEqual(buildUri, Uri.EMPTY)) {
                this.m.setValue(buildUri);
            } else {
                this.l.setValue(phone.getPhone());
            }
            this.k.setValue(null);
        }
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.PhoneChooserView.Listener
    public void onReloadPhonesClicked() {
        c();
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditButton.Listener
    public void onTermClicked() {
        this.r.sendCreditCalculatorValueChanged();
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditButton.Listener
    public void onTermSelected(int i2) {
        DfpCreditInfo value = creditData().getValue();
        if (value != null) {
            Intrinsics.checkNotNullExpressionValue(value, "creditData().value ?: return");
            if (value instanceof DfpCreditInfo.CreditCalculator) {
                DfpCreditInfo.CreditCalculator creditCalculator = (DfpCreditInfo.CreditCalculator) value;
                creditCalculator.calculate(creditCalculator.getInitialPayment(), i2, creditCalculator.getLoan());
                this.c.setValue(value);
            }
        }
    }

    @NotNull
    public final LiveData<LoadingState<List<Phone>>> phoneChooser() {
        return this.k;
    }

    @NotNull
    public final LiveData<Uri> privacyUri() {
        return this.e;
    }

    @NotNull
    public final LiveData<Uri> sravniFormUri() {
        return this.m;
    }

    @NotNull
    public final LiveData<String> sravniPhone() {
        return this.l;
    }

    @NotNull
    public final LiveData<Uri> tinkoffFormUri() {
        return this.n;
    }

    public final void updateDfpBanner(@NotNull DfpBannerItem dfpBannerItem, @NotNull AdvertDetails advertDetails) {
        Intrinsics.checkNotNullParameter(dfpBannerItem, "dfpBanner");
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        this.i = advertDetails;
        if (!this.g && this.c.getValue() == null) {
            this.c.setValue(new DfpCreditInfo.Empty());
            this.g = true;
            CompositeDisposable compositeDisposable = this.h;
            Disposable subscribe = this.p.loadBanner(dfpBannerItem, advertDetails).subscribeOn(this.q.io()).observeOn(this.q.mainThread()).subscribe(new f(this), new a2.a.a.f.x.t.g(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "creditInfoLoader.loadBan…          }\n            )");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    public final void updateDfpBanner(@NotNull AdvertDetails advertDetails) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        this.i = advertDetails;
        if (!this.g && this.c.getValue() == null) {
            if (advertDetails.getNeedToCheckCreditInfo()) {
                this.g = true;
                CompositeDisposable compositeDisposable = this.h;
                Disposable subscribe = this.p.loadBanner(advertDetails).observeOn(this.q.mainThread()).subscribe(new d(this), new e(this));
                Intrinsics.checkNotNullExpressionValue(subscribe, "creditInfoLoader.loadBan…edit\")\n                })");
                DisposableKt.plusAssign(compositeDisposable, subscribe);
                this.c.setValue(new DfpCreditInfo.Stub());
                return;
            }
            this.c.setValue(new DfpCreditInfo.Empty());
        }
    }
}
