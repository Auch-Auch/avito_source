package com.avito.android.settings;

import a2.a.a.r2.d;
import a2.g.r.g;
import com.avito.android.lib.util.DarkThemeConfig;
import com.avito.android.lib.util.DarkThemeManager;
import com.avito.android.location.LocationSource;
import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.remote.DeviceIdProvider;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.Location;
import com.avito.android.settings.SettingsPresenter;
import com.avito.android.settings.adapter.SettingsItem;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Kundle;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.Preferences;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKApiUserFull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import t6.n.r;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001By\b\u0007\u0012\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u001e06\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u0010S\u001a\u00020P\u0012\u0006\u0010W\u001a\u00020T\u0012\u0006\u0010=\u001a\u00020:\u0012\u0006\u0010K\u001a\u00020H\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010E\u001a\u00020B\u0012\u0006\u0010%\u001a\u00020\"\u0012\b\u0010X\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\bY\u0010ZJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u0019\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010&R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020\u001e068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010-R\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010O\u001a\u00020>8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010@R\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010V¨\u0006["}, d2 = {"Lcom/avito/android/settings/SettingsPresenterImpl;", "Lcom/avito/android/settings/SettingsPresenter;", "", AuthSource.SEND_ABUSE, "()V", "Lcom/avito/android/settings/SettingsView;", "view", "attachView", "(Lcom/avito/android/settings/SettingsView;)V", "detachView", "Lcom/avito/android/settings/SettingsPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/settings/SettingsPresenter$Router;)V", "detachRouter", "Lcom/avito/android/remote/model/Location;", "location", "onLocationSelected", "(Lcom/avito/android/remote/model/Location;)V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/remote/DeviceIdProvider;", "n", "Lcom/avito/android/remote/DeviceIdProvider;", "deviceIdProvider", "Lcom/avito/android/util/BuildInfo;", "p", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "", VKApiConst.Q, "Ljava/lang/String;", "appVersionName", "Lcom/avito/android/util/preferences/Preferences;", "s", "Lcom/avito/android/util/preferences/Preferences;", "preferences", "Lcom/avito/android/settings/SettingsPresenter$Router;", "Lcom/avito/android/location/SavedLocationInteractor;", "i", "Lcom/avito/android/location/SavedLocationInteractor;", "locationInteractor", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "d", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/lib/util/DarkThemeManager;", "o", "Lcom/avito/android/lib/util/DarkThemeManager;", "darkThemeManager", "f", "Lcom/avito/android/remote/model/Location;", "selectedLocation", "Lio/reactivex/rxjava3/core/Observable;", "h", "Lio/reactivex/rxjava3/core/Observable;", "settingsItemsStream", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "l", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "", g.a, "Z", "clearSearchHistoryInProgress", "Lcom/avito/android/lib/util/DarkThemeConfig;", "r", "Lcom/avito/android/lib/util/DarkThemeConfig;", "darkThemeConfig", "c", "viewActionDisposables", "Lcom/avito/android/settings/SettingsResourceProvider;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/settings/SettingsResourceProvider;", "settingsResourceProvider", AuthSource.BOOKING_ORDER, "Lcom/avito/android/settings/SettingsView;", "e", "isDeviceIdVisible", "Lcom/avito/android/remote/SearchApi;", "j", "Lcom/avito/android/remote/SearchApi;", "searchApi", "Lcom/avito/android/util/SchedulersFactory3;", "k", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "state", "<init>", "(Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/location/SavedLocationInteractor;Lcom/avito/android/remote/SearchApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/settings/SettingsResourceProvider;Lcom/avito/android/remote/DeviceIdProvider;Lcom/avito/android/lib/util/DarkThemeManager;Lcom/avito/android/util/BuildInfo;Ljava/lang/String;Lcom/avito/android/lib/util/DarkThemeConfig;Lcom/avito/android/util/preferences/Preferences;Lcom/avito/android/util/Kundle;)V", "settings_release"}, k = 1, mv = {1, 4, 2})
public final class SettingsPresenterImpl implements SettingsPresenter {
    public SettingsPresenter.Router a;
    public SettingsView b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final CompositeDisposable d = new CompositeDisposable();
    public boolean e;
    public Location f;
    public boolean g;
    public final Observable<String> h;
    public final SavedLocationInteractor i;
    public final SearchApi j;
    public final SchedulersFactory3 k;
    public final AdapterPresenter l;
    public final SettingsResourceProvider m;
    public final DeviceIdProvider n;
    public final DarkThemeManager o;
    public final BuildInfo p;
    public final String q;
    public final DarkThemeConfig r;
    public final Preferences s;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ SettingsPresenterImpl a;

        public a(SettingsPresenterImpl settingsPresenterImpl) {
            this.a = settingsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            SettingsPresenter.Router router = this.a.a;
            if (router != null) {
                router.close();
            }
        }
    }

    public static final class b<T> implements Consumer<String> {
        public final /* synthetic */ SettingsPresenterImpl a;

        public b(SettingsPresenterImpl settingsPresenterImpl) {
            this.a = settingsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            SettingsPresenterImpl settingsPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(str2, "it");
            SettingsPresenterImpl.access$onItemClicked(settingsPresenterImpl, str2);
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("SettingsPresenter", "Settings items click stream error", th);
        }
    }

    @Inject
    public SettingsPresenterImpl(@NotNull Observable<String> observable, @NotNull SavedLocationInteractor savedLocationInteractor, @NotNull SearchApi searchApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull AdapterPresenter adapterPresenter, @NotNull SettingsResourceProvider settingsResourceProvider, @NotNull DeviceIdProvider deviceIdProvider, @NotNull DarkThemeManager darkThemeManager, @NotNull BuildInfo buildInfo, @NotNull String str, @NotNull DarkThemeConfig darkThemeConfig, @NotNull Preferences preferences, @Nullable Kundle kundle) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(observable, "settingsItemsStream");
        Intrinsics.checkNotNullParameter(savedLocationInteractor, "locationInteractor");
        Intrinsics.checkNotNullParameter(searchApi, "searchApi");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(settingsResourceProvider, "settingsResourceProvider");
        Intrinsics.checkNotNullParameter(deviceIdProvider, "deviceIdProvider");
        Intrinsics.checkNotNullParameter(darkThemeManager, "darkThemeManager");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(str, "appVersionName");
        Intrinsics.checkNotNullParameter(darkThemeConfig, "darkThemeConfig");
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        this.h = observable;
        this.i = savedLocationInteractor;
        this.j = searchApi;
        this.k = schedulersFactory3;
        this.l = adapterPresenter;
        this.m = settingsResourceProvider;
        this.n = deviceIdProvider;
        this.o = darkThemeManager;
        this.p = buildInfo;
        this.q = str;
        this.r = darkThemeConfig;
        this.s = preferences;
        this.e = (kundle == null || (bool = kundle.getBoolean("deviceIdVisible")) == null) ? false : bool.booleanValue();
        this.f = kundle != null ? (Location) kundle.getParcelable("selectedLocation") : null;
    }

    public static final void access$onClearSearchHistoryError(SettingsPresenterImpl settingsPresenterImpl, ErrorResult errorResult) {
        String str;
        settingsPresenterImpl.g = false;
        settingsPresenterImpl.a();
        if (!(errorResult instanceof ErrorResult.NetworkIOError) || !(!m.isBlank(errorResult.getMessage()))) {
            str = settingsPresenterImpl.m.getClearSearchHistoryFailMessage();
        } else {
            str = errorResult.getMessage();
        }
        SettingsView settingsView = settingsPresenterImpl.b;
        if (settingsView != null) {
            settingsView.showErrorMessage(str);
        }
    }

    public static final void access$onClearSearchHistorySuccess(SettingsPresenterImpl settingsPresenterImpl) {
        settingsPresenterImpl.g = false;
        settingsPresenterImpl.a();
        SettingsView settingsView = settingsPresenterImpl.b;
        if (settingsView != null) {
            settingsView.showSuccessMessage(settingsPresenterImpl.m.getClearSearchHistorySuccessMessage());
        }
    }

    public static final void access$onItemClicked(SettingsPresenterImpl settingsPresenterImpl, String str) {
        SettingsPresenter.Router router;
        SettingsPresenter.Router router2;
        SettingsPresenter.Router router3;
        SettingsPresenter.Router router4;
        SettingsPresenter.Router router5;
        SettingsPresenter.Router router6;
        SettingsPresenter.Router router7;
        SettingsPresenter.Router router8;
        SettingsPresenter.Router router9;
        Location location;
        SettingsPresenter.Router router10;
        Objects.requireNonNull(settingsPresenterImpl);
        switch (str.hashCode()) {
            case -1694056056:
                if (str.equals("b2b_hub") && (router = settingsPresenterImpl.a) != null) {
                    router.openB2bHub();
                    return;
                }
                return;
            case -1355179393:
                if (str.equals("userAgreement") && (router2 = settingsPresenterImpl.a) != null) {
                    router2.openUserAgreementScreen();
                    return;
                }
                return;
            case -1097853370:
                if (str.equals("osLicences") && (router3 = settingsPresenterImpl.a) != null) {
                    router3.openSourceLicencesScreen();
                    return;
                }
                return;
            case -537425719:
                if (str.equals("userBehaviorAnalytics")) {
                    settingsPresenterImpl.s.putBoolean("userBehaviorAnalytics", !settingsPresenterImpl.s.getBoolean("userBehaviorAnalytics", true));
                    return;
                }
                return;
            case -449416299:
                if (str.equals("uiTheme") && (router4 = settingsPresenterImpl.a) != null) {
                    router4.openThemeSettings();
                    return;
                }
                return;
            case 3327403:
                if (str.equals("logo") && settingsPresenterImpl.p.isDebug() && (router5 = settingsPresenterImpl.a) != null) {
                    router5.openDebugScreen();
                    return;
                }
                return;
            case 105650780:
                if (str.equals(BaseAnalyticKt.ANALYTIC_MODULE_OFFER) && (router6 = settingsPresenterImpl.a) != null) {
                    router6.openOfferScreen();
                    return;
                }
                return;
            case 351608024:
                if (str.equals("version")) {
                    settingsPresenterImpl.e = !settingsPresenterImpl.e;
                    settingsPresenterImpl.a();
                    return;
                }
                return;
            case 749097718:
                if (str.equals("helpCenter") && (router7 = settingsPresenterImpl.a) != null) {
                    router7.openHelpCenter();
                    return;
                }
                return;
            case 1074400127:
                if (str.equals("appsLicence") && (router8 = settingsPresenterImpl.a) != null) {
                    router8.openAppsLicenceScreen();
                    return;
                }
                return;
            case 1272354024:
                if (str.equals("notifications") && (router9 = settingsPresenterImpl.a) != null) {
                    router9.openNotifications();
                    return;
                }
                return;
            case 1625213055:
                if (str.equals("clearSearchHistory") && !settingsPresenterImpl.g) {
                    settingsPresenterImpl.g = true;
                    settingsPresenterImpl.a();
                    CompositeDisposable compositeDisposable = settingsPresenterImpl.d;
                    Disposable subscribe = settingsPresenterImpl.j.clearSearchHistory(r.emptyMap()).subscribeOn(settingsPresenterImpl.k.io()).observeOn(settingsPresenterImpl.k.mainThread()).subscribe(new a2.a.a.r2.a(settingsPresenterImpl), new a2.a.a.r2.b(settingsPresenterImpl));
                    Intrinsics.checkNotNullExpressionValue(subscribe, "searchApi.clearSearchHis…(null)\n                })");
                    DisposableKt.plusAssign(compositeDisposable, subscribe);
                    return;
                }
                return;
            case 1901043637:
                if (str.equals("location") && (location = settingsPresenterImpl.f) != null && (router10 = settingsPresenterImpl.a) != null) {
                    router10.openLocationScreen(location);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void a() {
        String str;
        ArrayList arrayList = new ArrayList();
        String regionForSearch = this.m.getRegionForSearch();
        Location location = this.f;
        arrayList.add(new SettingsItem.Select("location", regionForSearch, location != null ? location.getName() : null));
        arrayList.add(new SettingsItem.Divider("divider_1"));
        arrayList.add(new SettingsItem.Info("notifications", this.m.getNotifications()));
        arrayList.add(new SettingsItem.Divider("divider_2"));
        arrayList.add(new SettingsItem.InfoWithProgress("clearSearchHistory", this.m.getClearSearchHistory(), this.g));
        if (this.r.isEnabled()) {
            arrayList.add(new SettingsItem.Divider("divider_3"));
            arrayList.add(new SettingsItem.ListItem("uiTheme", this.m.getUiTheme(), this.m.themeMode(this.o.getCurrentMode())));
        }
        arrayList.add(new SettingsItem.Divider("divider_4"));
        arrayList.add(new SettingsItem.Info("b2b_hub", this.m.getB2bHub()));
        arrayList.add(new SettingsItem.Divider("divider_5"));
        arrayList.add(new SettingsItem.Category(VKApiUserFull.ABOUT, this.m.getAboutApp()));
        arrayList.add(new SettingsItem.Info("helpCenter", this.m.getHelpCenter()));
        arrayList.add(new SettingsItem.Divider("divider_6"));
        arrayList.add(new SettingsItem.Category("licenceAndAgreements", this.m.getLicencesAndAgreements()));
        arrayList.add(new SettingsItem.Info("userAgreement", this.m.getReadTermOfUse()));
        arrayList.add(new SettingsItem.Info(BaseAnalyticKt.ANALYTIC_MODULE_OFFER, this.m.getReadOffer()));
        arrayList.add(new SettingsItem.Info("appsLicence", this.m.getReadAppsLicence()));
        arrayList.add(new SettingsItem.Info("osLicences", this.m.getOpenSourceLicences()));
        if (this.e) {
            str = this.m.deviceId(this.n.getValue());
        } else {
            SettingsResourceProvider settingsResourceProvider = this.m;
            str = settingsResourceProvider.appVersion(this.q + " (" + this.p.getVersionCode() + ')');
        }
        arrayList.add(new SettingsItem.LogoWithVersion("logo", "version", str));
        this.l.onDataSourceChanged(new ListDataSource(arrayList));
        SettingsView settingsView = this.b;
        if (settingsView != null) {
            settingsView.updateSettings();
        }
    }

    @Override // com.avito.android.settings.SettingsPresenter
    public void attachRouter(@NotNull SettingsPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.a = router;
        a();
        if (this.f == null) {
            CompositeDisposable compositeDisposable = this.d;
            Disposable subscribe = SavedLocationInteractor.DefaultImpls.savedLocation$default(this.i, null, false, 3, null).subscribeOn(this.k.io()).observeOn(this.k.mainThread()).subscribe(new a2.a.a.r2.c(this), d.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "locationInteractor.saved…lure\", it)\n            })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            return;
        }
        a();
    }

    @Override // com.avito.android.settings.SettingsPresenter
    public void attachView(@NotNull SettingsView settingsView) {
        Intrinsics.checkNotNullParameter(settingsView, "view");
        this.b = settingsView;
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = settingsView.navigationClicks().subscribe(new a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.navigationClicks().…cribe { router?.close() }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.c;
        Disposable subscribe2 = this.h.subscribe(new b(this), c.a);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "settingsItemsStream\n    …ror\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
    }

    @Override // com.avito.android.settings.SettingsPresenter
    public void detachRouter() {
        this.a = null;
    }

    @Override // com.avito.android.settings.SettingsPresenter
    public void detachView() {
        this.c.clear();
        this.d.clear();
        this.b = null;
    }

    @Override // com.avito.android.settings.SettingsPresenter
    public void onLocationSelected(@Nullable Location location) {
        this.f = location;
        SavedLocationInteractor.DefaultImpls.saveLocation$default(this.i, location, LocationSource.LOCATION_FOR_SEARCH, false, 4, null);
        this.i.saveLocation(location, LocationSource.LOCATION_FROM_FILTERS, true);
        SavedLocationInteractor.DefaultImpls.saveLocation$default(this.i, location, null, true, 2, null);
        a();
    }

    @Override // com.avito.android.settings.SettingsPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putBoolean("deviceIdVisible", Boolean.valueOf(this.e)).putParcelable("selectedLocation", this.f);
    }
}
