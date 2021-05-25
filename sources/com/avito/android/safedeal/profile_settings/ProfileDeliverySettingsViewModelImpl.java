package com.avito.android.safedeal.profile_settings;

import a2.a.a.i2.c.h;
import a2.g.r.g;
import androidx.collection.ArrayMap;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.safedeal.profile_settings.konveyor.ProfileDeliverySettingsItemsConverter;
import com.avito.android.safedeal.profile_settings.konveyor.skeleton.SkeletonItem;
import com.avito.android.safedeal.profile_settings.konveyor.switcher.SwitcherItem;
import com.avito.android.safedeal.remote.model.ProfileDeliverySettings;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010W\u001a\u00020T\u0012\u0006\u0010[\u001a\u00020X\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010L\u001a\u00020I¢\u0006\u0004\b_\u0010`J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\u0005R\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010\u0019R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010'R.\u00101\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*0)8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\"\u00107\u001a\b\u0012\u0004\u0012\u00020+028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\"\u0010;\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010<RD\u0010C\u001a0\u0012\f\u0012\n ?*\u0004\u0018\u00010>0> ?*\u0017\u0012\f\u0012\n ?*\u0004\u0018\u00010>0>\u0018\u00010=¢\u0006\u0002\b@0=¢\u0006\u0002\b@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020E0D8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\"\u0010O\u001a\b\u0012\u0004\u0012\u00020>0\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bM\u0010\u0010\u001a\u0004\bN\u0010\u0012Rt\u0010Q\u001a`\u0012$\u0012\"\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020, ?*\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,\u0018\u00010*0* ?*/\u0012$\u0012\"\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020, ?*\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,\u0018\u00010*0*\u0018\u00010=¢\u0006\u0002\b@0=¢\u0006\u0002\b@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010BRD\u0010S\u001a0\u0012\f\u0012\n ?*\u0004\u0018\u00010\u000e0\u000e ?*\u0017\u0012\f\u0012\n ?*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010=¢\u0006\u0002\b@0=¢\u0006\u0002\b@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010BR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR$\u0010^\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\\\u00104\u001a\u0004\b]\u00106¨\u0006a"}, d2 = {"Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsViewModelImpl;", "Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "", "fetchSettings", "()V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "onCleared", "c", "d", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/deep_linking/links/DeepLink;", "j", "Lio/reactivex/rxjava3/functions/Consumer;", "getDeepLinkClicks", "()Lio/reactivex/rxjava3/functions/Consumer;", "deepLinkClicks", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "", "p", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getActivityResultChanges", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "activityResultChanges", "Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsResourceProvider;", "t", "Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsResourceProvider;", "resProvider", AuthSource.OPEN_CHANNEL_LIST, "getDeepLinkChanges", "deepLinkChanges", "Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsInteractor;", VKApiConst.Q, "Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsInteractor;", "interactor", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscriptions", "Lio/reactivex/rxjava3/core/Observable;", "Lkotlin/Pair;", "", "", "l", "Lio/reactivex/rxjava3/core/Observable;", "getSwitcherLoadingStateObservable", "()Lio/reactivex/rxjava3/core/Observable;", "switcherLoadingStateObservable", "Landroidx/lifecycle/MutableLiveData;", "o", "Landroidx/lifecycle/MutableLiveData;", "getFullScreenErrorChanges", "()Landroidx/lifecycle/MutableLiveData;", "fullScreenErrorChanges", "Landroidx/collection/ArrayMap;", "i", "Landroidx/collection/ArrayMap;", "areSwitchersValueChanged", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/safedeal/profile_settings/konveyor/switcher/SwitcherItem;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "f", "Lcom/jakewharton/rxrelay3/PublishRelay;", "switcherClicksRelay", "", "Lcom/avito/conveyor_item/Item;", "h", "Ljava/util/List;", PlatformActions.ItemsList.TYPE, "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "u", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "tracker", "k", "getSwitcherClicks", "switcherClicks", g.a, "switcherLoadingStateRelay", "e", "deepLinkClicksRelay", "Lcom/avito/android/util/SchedulersFactory3;", "r", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/safedeal/profile_settings/konveyor/ProfileDeliverySettingsItemsConverter;", "s", "Lcom/avito/android/safedeal/profile_settings/konveyor/ProfileDeliverySettingsItemsConverter;", "itemsConverter", "n", "getToolbarTitleChanges", "toolbarTitleChanges", "<init>", "(Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/safedeal/profile_settings/konveyor/ProfileDeliverySettingsItemsConverter;Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsResourceProvider;Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileDeliverySettingsViewModelImpl extends ViewModel implements ProfileDeliverySettingsViewModel {
    public AdapterPresenter c;
    public final CompositeDisposable d = new CompositeDisposable();
    public final PublishRelay<DeepLink> e;
    public final PublishRelay<SwitcherItem> f;
    public final PublishRelay<Pair<String, Boolean>> g;
    public List<? extends Item> h;
    public final ArrayMap<String, Boolean> i;
    @NotNull
    public final Consumer<DeepLink> j;
    @NotNull
    public final Consumer<SwitcherItem> k;
    @NotNull
    public final Observable<Pair<String, Boolean>> l;
    @NotNull
    public final SingleLiveEvent<DeepLink> m;
    @NotNull
    public final MutableLiveData<String> n;
    @NotNull
    public final MutableLiveData<String> o;
    @NotNull
    public final SingleLiveEvent<Integer> p;
    public final ProfileDeliverySettingsInteractor q;
    public final SchedulersFactory3 r;
    public final ProfileDeliverySettingsItemsConverter s;
    public final ProfileDeliverySettingsResourceProvider t;
    public final BaseScreenPerformanceTracker u;

    public static final class a<T> implements Consumer<LoadingState<? super ProfileDeliverySettings>> {
        public final /* synthetic */ ProfileDeliverySettingsViewModelImpl a;

        public a(ProfileDeliverySettingsViewModelImpl profileDeliverySettingsViewModelImpl) {
            this.a = profileDeliverySettingsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super ProfileDeliverySettings> loadingState) {
            String str;
            LoadingState<? super ProfileDeliverySettings> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loading) {
                ProfileDeliverySettingsViewModelImpl.access$updateView(this.a, t6.n.d.listOf(new SkeletonItem(null, 1, null)));
            } else if (loadingState2 instanceof LoadingState.Loaded) {
                this.a.u.trackLoaded();
                this.a.u.startPreparing();
                LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
                List<Item> convert = this.a.s.convert((ProfileDeliverySettings) loaded.getData());
                this.a.u.trackPrepared();
                this.a.u.startDrawing();
                ProfileDeliverySettingsViewModelImpl.access$updateView(this.a, convert);
                this.a.u.trackDrawn();
                this.a.getToolbarTitleChanges().setValue(((ProfileDeliverySettings) loaded.getData()).getToolbarTitle());
                this.a.getFullScreenErrorChanges().setValue(null);
                List<ProfileDeliverySettings.Service> services = ((ProfileDeliverySettings) loaded.getData()).getServices();
                if (services != null) {
                    ArrayList arrayList = new ArrayList();
                    for (T t : services) {
                        if (t.getType() == ProfileDeliverySettings.Service.Type.SWITCHER) {
                            arrayList.add(t);
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String id = ((ProfileDeliverySettings.Service) it.next()).getContent().getId();
                        if (id != null) {
                            this.a.i.put(id, Boolean.FALSE);
                        } else {
                            throw new IllegalStateException("Switcher's id must not be null".toString());
                        }
                    }
                }
            } else if (loadingState2 instanceof LoadingState.Error) {
                this.a.u.trackLoadingError();
                TypedError error = ((LoadingState.Error) loadingState2).getError();
                this.a.u.startDrawing();
                MutableLiveData<String> fullScreenErrorChanges = this.a.getFullScreenErrorChanges();
                if (error instanceof ErrorWithMessage) {
                    str = ((ErrorWithMessage) error).getMessage();
                } else {
                    str = this.a.t.getSettingsLoadingError();
                }
                fullScreenErrorChanges.setValue(str);
                this.a.u.trackDrawnError();
            }
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

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ ProfileDeliverySettingsViewModelImpl a;

        public d(ProfileDeliverySettingsViewModelImpl profileDeliverySettingsViewModelImpl) {
            this.a = profileDeliverySettingsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.c();
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public final /* synthetic */ ProfileDeliverySettingsViewModelImpl a;

        public f(ProfileDeliverySettingsViewModelImpl profileDeliverySettingsViewModelImpl) {
            this.a = profileDeliverySettingsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.d();
        }
    }

    public ProfileDeliverySettingsViewModelImpl(@NotNull ProfileDeliverySettingsInteractor profileDeliverySettingsInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ProfileDeliverySettingsItemsConverter profileDeliverySettingsItemsConverter, @NotNull ProfileDeliverySettingsResourceProvider profileDeliverySettingsResourceProvider, @NotNull BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        Intrinsics.checkNotNullParameter(profileDeliverySettingsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(profileDeliverySettingsItemsConverter, "itemsConverter");
        Intrinsics.checkNotNullParameter(profileDeliverySettingsResourceProvider, "resProvider");
        Intrinsics.checkNotNullParameter(baseScreenPerformanceTracker, "tracker");
        this.q = profileDeliverySettingsInteractor;
        this.r = schedulersFactory3;
        this.s = profileDeliverySettingsItemsConverter;
        this.t = profileDeliverySettingsResourceProvider;
        this.u = baseScreenPerformanceTracker;
        PublishRelay<DeepLink> create = PublishRelay.create();
        this.e = create;
        PublishRelay<SwitcherItem> create2 = PublishRelay.create();
        this.f = create2;
        PublishRelay<Pair<String, Boolean>> create3 = PublishRelay.create();
        this.g = create3;
        this.h = CollectionsKt__CollectionsKt.emptyList();
        this.i = new ArrayMap<>(3);
        Intrinsics.checkNotNullExpressionValue(create, "deepLinkClicksRelay");
        this.j = create;
        Intrinsics.checkNotNullExpressionValue(create2, "switcherClicksRelay");
        this.k = create2;
        Intrinsics.checkNotNullExpressionValue(create3, "switcherLoadingStateRelay");
        this.l = create3;
        this.m = new SingleLiveEvent<>();
        this.n = new MutableLiveData<>();
        this.o = new MutableLiveData<>();
        this.p = new SingleLiveEvent<>();
        c();
        d();
        fetchSettings();
    }

    public static final void access$toggleService(ProfileDeliverySettingsViewModelImpl profileDeliverySettingsViewModelImpl, SwitcherItem switcherItem) {
        Disposable subscribe = profileDeliverySettingsViewModelImpl.q.toggleService(switcherItem.getStringId(), !switcherItem.isChecked()).observeOn(profileDeliverySettingsViewModelImpl.r.mainThread()).doOnError(new a2.a.a.i2.c.f(new Function1<Throwable, Unit>(Logs.INSTANCE) { // from class: a2.a.a.i2.c.g
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Throwable th) {
                Logs logs = (Logs) this.receiver;
                Logs.error(th);
                return Unit.INSTANCE;
            }
        })).subscribe(new h(profileDeliverySettingsViewModelImpl, switcherItem));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.toggleService…          }\n            }");
        DisposableKt.addTo(subscribe, profileDeliverySettingsViewModelImpl.d);
    }

    public static final void access$updateView(ProfileDeliverySettingsViewModelImpl profileDeliverySettingsViewModelImpl, List list) {
        AdapterPresenter adapterPresenter = profileDeliverySettingsViewModelImpl.c;
        if (adapterPresenter != null) {
            a2.b.a.a.a.s1(list, adapterPresenter);
        }
        profileDeliverySettingsViewModelImpl.h = list;
    }

    public final void c() {
        Disposable subscribe = this.e.observeOn(this.r.mainThread()).subscribe(new a2.a.a.i2.c.f(new Function1<DeepLink, Unit>(getDeepLinkChanges()) { // from class: com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsViewModelImpl.c
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(DeepLink deepLink) {
                DeepLink deepLink2 = deepLink;
                Intrinsics.checkNotNullParameter(deepLink2, "p1");
                ((SingleLiveEvent) this.receiver).setValue(deepLink2);
                return Unit.INSTANCE;
            }
        }), new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "deepLinkClicksRelay\n    …inkClicks()\n            }");
        DisposableKt.addTo(subscribe, this.d);
    }

    public final void d() {
        Disposable subscribe = this.f.observeOn(this.r.mainThread()).subscribe(new a2.a.a.i2.c.f(new Function1<SwitcherItem, Unit>(this) { // from class: com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsViewModelImpl.e
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(SwitcherItem switcherItem) {
                SwitcherItem switcherItem2 = switcherItem;
                Intrinsics.checkNotNullParameter(switcherItem2, "p1");
                ProfileDeliverySettingsViewModelImpl.access$toggleService((ProfileDeliverySettingsViewModelImpl) this.receiver, switcherItem2);
                return Unit.INSTANCE;
            }
        }), new f(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "switcherClicksRelay\n    …herClicks()\n            }");
        DisposableKt.addTo(subscribe, this.d);
    }

    @Override // com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsViewModel
    public void fetchSettings() {
        this.u.startLoading();
        Disposable subscribe = this.q.getSettings().observeOn(this.r.mainThread()).subscribe(new a(this), b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.getSettings()…          }\n            )");
        DisposableKt.addTo(subscribe, this.d);
    }

    @Override // com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsViewModel
    @NotNull
    public Consumer<DeepLink> getDeepLinkClicks() {
        return this.j;
    }

    @Override // com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsViewModel
    @NotNull
    public Consumer<SwitcherItem> getSwitcherClicks() {
        return this.k;
    }

    @Override // com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsViewModel
    @NotNull
    public Observable<Pair<String, Boolean>> getSwitcherLoadingStateObservable() {
        return this.l;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.d.clear();
    }

    @Override // com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsViewModel
    public void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        this.c = adapterPresenter;
        adapterPresenter.onDataSourceChanged(new ListDataSource(this.h));
    }

    @Override // com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsViewModel
    @NotNull
    public SingleLiveEvent<Integer> getActivityResultChanges() {
        return this.p;
    }

    @Override // com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsViewModel
    @NotNull
    public SingleLiveEvent<DeepLink> getDeepLinkChanges() {
        return this.m;
    }

    @Override // com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsViewModel
    @NotNull
    public MutableLiveData<String> getFullScreenErrorChanges() {
        return this.o;
    }

    @Override // com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsViewModel
    @NotNull
    public MutableLiveData<String> getToolbarTitleChanges() {
        return this.n;
    }
}
