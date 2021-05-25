package com.avito.android.shop_settings;

import a2.a.a.t2.n;
import a2.a.a.t2.o;
import a2.a.a.t2.p;
import a2.a.a.t2.q;
import a2.a.a.t2.r;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ShopSettings;
import com.avito.android.remote.model.ShopSettingsConfirmation;
import com.avito.android.remote.model.ShopSettingsSave;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.shop_settings.blueprints.ShopSettingsItem;
import com.avito.android.shop_settings.blueprints.save_button.ShopSettingsSaveButtonItem;
import com.avito.android.shop_settings_select.ShopSettingsSelectResult;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.rx3.InteropKt;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\u0006\u0010u\u001a\u00020r\u0012\u0006\u0010W\u001a\u00020T\u0012\u0006\u0010[\u001a\u00020X\u0012\u0006\u0010P\u001a\u00020M\u0012\u0006\u0010,\u001a\u00020\u0013\u0012\u0006\u0010>\u001a\u00020;¢\u0006\u0004\bv\u0010wJ%\u0010\t\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ/\u0010\u000f\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00032\u000e\u0010\r\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001f\u0010\u0012J\u000f\u0010 \u001a\u00020\bH\u0016¢\u0006\u0004\b \u0010\u0012R\"\u0010'\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010$R\u0016\u0010,\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001a0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\"\u00105\u001a\b\u0012\u0004\u0012\u00020\b008\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R&\u0010:\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003060\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b7\u0010.\u001a\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\"\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001a0!8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b?\u0010$\u001a\u0004\b@\u0010&R\"\u0010D\u001a\b\u0012\u0004\u0012\u00020\b0!8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bB\u0010$\u001a\u0004\bC\u0010&R\u0018\u0010G\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u001c\u0010I\u001a\b\u0012\u0004\u0012\u00020\b0!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010$R\"\u0010L\u001a\b\u0012\u0004\u0012\u00020\u001a0\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bJ\u0010.\u001a\u0004\bK\u00109R\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u001c\u0010S\u001a\b\u0012\u0004\u0012\u00020Q0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010.R\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\"\u0010_\u001a\b\u0012\u0004\u0012\u00020\\0!8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b]\u0010$\u001a\u0004\b^\u0010&R \u0010`\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003060\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010.R\u001c\u0010b\u001a\b\u0012\u0004\u0012\u00020\u001a0!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\ba\u0010$R\u001c\u0010d\u001a\b\u0012\u0004\u0012\u00020\\0!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010$R(\u0010i\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020f0e0\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bg\u0010.\u001a\u0004\bh\u00109R\"\u0010j\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020f0e0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010.R\u0016\u0010n\u001a\u00020k8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\"\u0010q\u001a\b\u0012\u0004\u0012\u00020Q0\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bo\u0010.\u001a\u0004\bp\u00109R\u0016\u0010u\u001a\u00020r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bs\u0010t¨\u0006x"}, d2 = {"Lcom/avito/android/shop_settings/ShopSettingsViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/shop_settings/ShopSettingsViewModel;", "Lio/reactivex/Observable;", "Lcom/avito/android/shop_settings/ShopSettingsViewData;", "shopSettingsItemsSource", "", "shouldScrollToFirstError", "", "c", "(Lio/reactivex/Observable;Z)V", "T", "Landroidx/lifecycle/MutableLiveData;", "data", "Lio/reactivex/disposables/Disposable;", "d", "(Lio/reactivex/Observable;Landroidx/lifecycle/MutableLiveData;)Lio/reactivex/disposables/Disposable;", "onCleared", "()V", "Lcom/avito/android/util/Kundle;", "saveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/shop_settings_select/ShopSettingsSelectResult;", "result", "handleSelectResult", "(Lcom/avito/android/shop_settings_select/ShopSettingsSelectResult;)V", "", "id", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", "handleLocationPickerResult", "(Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;)V", "onRetryButtonClick", "loadContent", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "", "s", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getScrollPositionChanges", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "scrollPositionChanges", "i", "scrollPositionLiveData", "z", "Lcom/avito/android/util/Kundle;", "savedState", "e", "Landroidx/lifecycle/MutableLiveData;", "titleChangesLiveData", "Lcom/jakewharton/rxrelay2/PublishRelay;", "t", "Lcom/jakewharton/rxrelay2/PublishRelay;", "getSaveButtonClickRelay", "()Lcom/jakewharton/rxrelay2/PublishRelay;", "saveButtonClickRelay", "Lcom/avito/android/util/LoadingState;", AuthSource.OPEN_CHANNEL_LIST, "getProgressChanges", "()Landroidx/lifecycle/MutableLiveData;", "progressChanges", "Lcom/avito/android/account/AccountStateProvider;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/account/AccountStateProvider;", "accountState", VKApiConst.Q, "getMessageChanges", "messageChanges", "u", "getGoToLoginChanges", "goToLoginChanges", "l", "Lcom/avito/android/shop_settings/ShopSettingsViewData;", "shopSettingsViewData", "j", "goToLoginLiveData", "o", "getTitleChanges", "titleChanges", "Lcom/avito/android/shop_settings/ShopSettingsStringProvider;", "y", "Lcom/avito/android/shop_settings/ShopSettingsStringProvider;", "stringProvider", "Lcom/avito/android/shop_settings/ShopSettingsSaveButtonData;", "f", "saveButtonLiveData", "Lcom/avito/android/shop_settings/ShopSettingsInteractor;", "w", "Lcom/avito/android/shop_settings/ShopSettingsInteractor;", "interactor", "Lcom/avito/android/util/SchedulersFactory;", "x", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/remote/model/ShopSettingsConfirmation;", "r", "getConfirmationChanges", "confirmationChanges", "progressLiveData", a2.g.r.g.a, "messageLiveData", "h", "confirmationLiveData", "", "Lcom/avito/android/shop_settings/blueprints/ShopSettingsItem;", "n", "getListChanges", "listChanges", "listChangesLiveData", "Lio/reactivex/disposables/CompositeDisposable;", "k", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "p", "getSaveButtonDataChanges", "saveButtonDataChanges", "Lcom/avito/android/shop_settings/ShopSettingsConverter;", VKApiConst.VERSION, "Lcom/avito/android/shop_settings/ShopSettingsConverter;", "converter", "<init>", "(Lcom/avito/android/shop_settings/ShopSettingsConverter;Lcom/avito/android/shop_settings/ShopSettingsInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/shop_settings/ShopSettingsStringProvider;Lcom/avito/android/util/Kundle;Lcom/avito/android/account/AccountStateProvider;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsViewModelImpl extends ViewModel implements ShopSettingsViewModel {
    public final AccountStateProvider A;
    public final MutableLiveData<LoadingState<?>> c;
    public final MutableLiveData<List<ShopSettingsItem>> d;
    public final MutableLiveData<String> e;
    public final MutableLiveData<ShopSettingsSaveButtonData> f;
    public final SingleLiveEvent<String> g;
    public final SingleLiveEvent<ShopSettingsConfirmation> h;
    public final SingleLiveEvent<Integer> i;
    public final SingleLiveEvent<Unit> j;
    public CompositeDisposable k = new CompositeDisposable();
    public ShopSettingsViewData l;
    @NotNull
    public final MutableLiveData<LoadingState<?>> m;
    @NotNull
    public final MutableLiveData<List<ShopSettingsItem>> n;
    @NotNull
    public final MutableLiveData<String> o;
    @NotNull
    public final MutableLiveData<ShopSettingsSaveButtonData> p;
    @NotNull
    public final SingleLiveEvent<String> q;
    @NotNull
    public final SingleLiveEvent<ShopSettingsConfirmation> r;
    @NotNull
    public final SingleLiveEvent<Integer> s;
    @NotNull
    public final PublishRelay<Unit> t;
    @NotNull
    public final SingleLiveEvent<Unit> u;
    public final ShopSettingsConverter v;
    public final ShopSettingsInteractor w;
    public final SchedulersFactory x;
    public final ShopSettingsStringProvider y;
    public final Kundle z;

    public static final class a<T, R> implements Function<ShopSettingsViewData, ObservableSource<? extends String>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends String> apply(ShopSettingsViewData shopSettingsViewData) {
            ShopSettingsViewData shopSettingsViewData2 = shopSettingsViewData;
            Intrinsics.checkNotNullParameter(shopSettingsViewData2, "it");
            return shopSettingsViewData2.getTitleObservable();
        }
    }

    public static final class b<T> implements Consumer<ShopSettingsViewData> {
        public final /* synthetic */ ShopSettingsViewModelImpl a;

        public b(ShopSettingsViewModelImpl shopSettingsViewModelImpl) {
            this.a = shopSettingsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ShopSettingsViewData shopSettingsViewData) {
            this.a.l = shopSettingsViewData;
        }
    }

    public static final class c<T, R> implements Function<ShopSettingsViewData, ObservableSource<? extends ShopSettingsSaveButtonData>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends ShopSettingsSaveButtonData> apply(ShopSettingsViewData shopSettingsViewData) {
            ShopSettingsViewData shopSettingsViewData2 = shopSettingsViewData;
            Intrinsics.checkNotNullParameter(shopSettingsViewData2, "it");
            return shopSettingsViewData2.getSaveButtonDataObservable();
        }
    }

    public static final class d<T, R> implements Function<ShopSettingsSaveButtonData, ObservableSource<? extends ShopSettingsSaveButtonData>> {
        public final /* synthetic */ ShopSettingsViewModelImpl a;

        public d(ShopSettingsViewModelImpl shopSettingsViewModelImpl) {
            this.a = shopSettingsViewModelImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends ShopSettingsSaveButtonData> apply(ShopSettingsSaveButtonData shopSettingsSaveButtonData) {
            ShopSettingsSaveButtonData shopSettingsSaveButtonData2 = shopSettingsSaveButtonData;
            Intrinsics.checkNotNullParameter(shopSettingsSaveButtonData2, "saveButtonData");
            return this.a.getSaveButtonClickRelay().map(new n(shopSettingsSaveButtonData2)).startWith((Observable<R>) shopSettingsSaveButtonData2);
        }
    }

    public static final class e<T, R> implements Function<List<? extends ShopSettingsItem>, Integer> {
        public static final e a = new e();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Integer apply(List<? extends ShopSettingsItem> list) {
            T t;
            List<? extends ShopSettingsItem> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "items");
            Iterator<T> it = CollectionsKt___CollectionsKt.withIndex(list2).iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (((ShopSettingsItem) t.getValue()).getShouldScrollTo()) {
                    break;
                }
            }
            T t2 = t;
            return Integer.valueOf(t2 != null ? t2.getIndex() : 0);
        }
    }

    public static final class f<T, R> implements Function<Pair<? extends Unit, ? extends List<? extends ShopSettingsItem>>, ObservableSource<? extends Pair<? extends LoadingState<? super ShopSettingsSave>, ? extends List<? extends ShopSettingsItem>>>> {
        public final /* synthetic */ ShopSettingsViewModelImpl a;

        public f(ShopSettingsViewModelImpl shopSettingsViewModelImpl) {
            this.a = shopSettingsViewModelImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends Pair<? extends LoadingState<? super ShopSettingsSave>, ? extends List<? extends ShopSettingsItem>>> apply(Pair<? extends Unit, ? extends List<? extends ShopSettingsItem>> pair) {
            Pair<? extends Unit, ? extends List<? extends ShopSettingsItem>> pair2 = pair;
            Intrinsics.checkNotNullParameter(pair2, "<name for destructuring parameter 0>");
            List<? extends ShopSettingsItem> list = (List) pair2.component2();
            ShopSettingsInteractor shopSettingsInteractor = this.a.w;
            Intrinsics.checkNotNullExpressionValue(list, PlatformActions.ItemsList.TYPE);
            return shopSettingsInteractor.saveShopSettings(list).map(new o(list));
        }
    }

    public static final class g<T> implements Consumer<Pair<? extends LoadingState<? super ShopSettingsSave>, ? extends List<? extends ShopSettingsItem>>> {
        public final /* synthetic */ ShopSettingsViewModelImpl a;

        public g(ShopSettingsViewModelImpl shopSettingsViewModelImpl) {
            this.a = shopSettingsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Pair<? extends LoadingState<? super ShopSettingsSave>, ? extends List<? extends ShopSettingsItem>> pair) {
            Pair<? extends LoadingState<? super ShopSettingsSave>, ? extends List<? extends ShopSettingsItem>> pair2 = pair;
            LoadingState loadingState = (LoadingState) pair2.component1();
            List list = (List) pair2.component2();
            if (loadingState instanceof LoadingState.Loaded) {
                ShopSettingsViewModelImpl shopSettingsViewModelImpl = this.a;
                LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState;
                Observable just = Observable.just(((ShopSettingsSave) loaded.getData()).getSettings());
                Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
                ShopSettingsViewModelImpl.access$convertShopSettings(shopSettingsViewModelImpl, just, true);
                ShopSettingsConfirmation confirmation = ((ShopSettingsSave) loaded.getData()).getConfirmation();
                if (confirmation != null) {
                    this.a.h.postValue(confirmation);
                }
            } else if (loadingState instanceof LoadingState.Error) {
                ShopSettingsViewModelImpl shopSettingsViewModelImpl2 = this.a;
                Intrinsics.checkNotNullExpressionValue(list, "oldItemsList");
                ShopSettingsViewModelImpl.access$handleSavingError(shopSettingsViewModelImpl2, list);
            }
        }
    }

    public static final class h<T> implements Consumer<Throwable> {
        public static final h a = new h();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public static final class i<T, R> implements Function<ShopSettingsViewData, ObservableSource<? extends List<? extends ShopSettingsItem>>> {
        public static final i a = new i();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends List<? extends ShopSettingsItem>> apply(ShopSettingsViewData shopSettingsViewData) {
            ShopSettingsViewData shopSettingsViewData2 = shopSettingsViewData;
            Intrinsics.checkNotNullParameter(shopSettingsViewData2, "it");
            return shopSettingsViewData2.itemsList();
        }
    }

    public static final class j<T> implements Consumer<Boolean> {
        public final /* synthetic */ ShopSettingsViewModelImpl a;

        public j(ShopSettingsViewModelImpl shopSettingsViewModelImpl) {
            this.a = shopSettingsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "currentAuthorized");
            if (bool2.booleanValue()) {
                ShopSettingsViewModelImpl.access$loadContentAuthoried(this.a);
            } else {
                this.a.j.postValue(Unit.INSTANCE);
            }
        }
    }

    public static final class k<T> implements Consumer<Throwable> {
        public final /* synthetic */ ShopSettingsViewModelImpl a;

        public k(ShopSettingsViewModelImpl shopSettingsViewModelImpl) {
            this.a = shopSettingsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            ShopSettingsViewModelImpl.access$loadContentAuthoried(this.a);
        }
    }

    public static final class l<T> implements Consumer<T> {
        public final /* synthetic */ MutableLiveData a;

        public l(MutableLiveData mutableLiveData) {
            this.a = mutableLiveData;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(T t) {
            this.a.setValue(t);
        }
    }

    public static final class m<T> implements Consumer<Throwable> {
        public static final m a = new m();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public ShopSettingsViewModelImpl(@NotNull ShopSettingsConverter shopSettingsConverter, @NotNull ShopSettingsInteractor shopSettingsInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull ShopSettingsStringProvider shopSettingsStringProvider, @NotNull Kundle kundle, @NotNull AccountStateProvider accountStateProvider) {
        Intrinsics.checkNotNullParameter(shopSettingsConverter, "converter");
        Intrinsics.checkNotNullParameter(shopSettingsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(shopSettingsStringProvider, "stringProvider");
        Intrinsics.checkNotNullParameter(kundle, "savedState");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountState");
        this.v = shopSettingsConverter;
        this.w = shopSettingsInteractor;
        this.x = schedulersFactory;
        this.y = shopSettingsStringProvider;
        this.z = kundle;
        this.A = accountStateProvider;
        MutableLiveData<LoadingState<?>> mutableLiveData = new MutableLiveData<>();
        this.c = mutableLiveData;
        MutableLiveData<List<ShopSettingsItem>> mutableLiveData2 = new MutableLiveData<>();
        this.d = mutableLiveData2;
        MutableLiveData<String> mutableLiveData3 = new MutableLiveData<>();
        this.e = mutableLiveData3;
        MutableLiveData<ShopSettingsSaveButtonData> mutableLiveData4 = new MutableLiveData<>();
        this.f = mutableLiveData4;
        SingleLiveEvent<String> singleLiveEvent = new SingleLiveEvent<>();
        this.g = singleLiveEvent;
        SingleLiveEvent<ShopSettingsConfirmation> singleLiveEvent2 = new SingleLiveEvent<>();
        this.h = singleLiveEvent2;
        SingleLiveEvent<Integer> singleLiveEvent3 = new SingleLiveEvent<>();
        this.i = singleLiveEvent3;
        SingleLiveEvent<Unit> singleLiveEvent4 = new SingleLiveEvent<>();
        this.j = singleLiveEvent4;
        this.m = mutableLiveData;
        this.n = mutableLiveData2;
        this.o = mutableLiveData3;
        this.p = mutableLiveData4;
        this.q = singleLiveEvent;
        this.r = singleLiveEvent2;
        this.s = singleLiveEvent3;
        PublishRelay<Unit> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.t = create;
        this.u = singleLiveEvent4;
        loadContent();
    }

    public static final void access$convertShopSettings(ShopSettingsViewModelImpl shopSettingsViewModelImpl, Observable observable, boolean z2) {
        Objects.requireNonNull(shopSettingsViewModelImpl);
        Observable<ShopSettingsViewData> share = observable.map(new p(shopSettingsViewModelImpl)).share();
        Intrinsics.checkNotNullExpressionValue(share, "shopSettingsSource.map {…ter.convert(it) }.share()");
        shopSettingsViewModelImpl.c(share, z2);
    }

    public static final void access$handleSavingError(ShopSettingsViewModelImpl shopSettingsViewModelImpl, List list) {
        Object obj;
        Objects.requireNonNull(shopSettingsViewModelImpl);
        Iterator it = CollectionsKt___CollectionsKt.withIndex(list).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((IndexedValue) obj).getValue() instanceof ShopSettingsSaveButtonItem) {
                break;
            }
        }
        IndexedValue indexedValue = (IndexedValue) obj;
        List<ShopSettingsItem> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        if (indexedValue != null) {
            Object value = indexedValue.getValue();
            Objects.requireNonNull(value, "null cannot be cast to non-null type com.avito.android.shop_settings.blueprints.save_button.ShopSettingsSaveButtonItem");
            ShopSettingsSaveButtonItem copy$default = ShopSettingsSaveButtonItem.copy$default((ShopSettingsSaveButtonItem) value, null, null, false, false, 11, null);
            mutableList.set(indexedValue.getIndex(), copy$default);
            ShopSettingsViewData shopSettingsViewData = shopSettingsViewModelImpl.l;
            if (shopSettingsViewData != null) {
                shopSettingsViewData.setSaveButtonItem(copy$default);
            }
        }
        shopSettingsViewModelImpl.d.setValue(mutableList);
        ShopSettingsSaveButtonData value2 = shopSettingsViewModelImpl.f.getValue();
        if (value2 != null) {
            value2.setLoading(false);
            shopSettingsViewModelImpl.f.setValue(value2);
        }
        shopSettingsViewModelImpl.g.postValue(shopSettingsViewModelImpl.y.getUnknownError());
    }

    public static final void access$loadContentAuthoried(ShopSettingsViewModelImpl shopSettingsViewModelImpl) {
        ShopSettingsViewData shopSettingsViewData = (ShopSettingsViewData) shopSettingsViewModelImpl.z.getParcelable("shop_settings_content");
        if (shopSettingsViewData != null) {
            shopSettingsViewModelImpl.l = shopSettingsViewData;
            Observable<ShopSettingsViewData> just = Observable.just(shopSettingsViewData);
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            shopSettingsViewModelImpl.c(just, false);
            MutableLiveData<LoadingState<?>> mutableLiveData = shopSettingsViewModelImpl.c;
            Unit unit = Unit.INSTANCE;
            mutableLiveData.setValue(new LoadingState.Loaded(unit));
            ShopSettingsViewData shopSettingsViewData2 = shopSettingsViewModelImpl.l;
            if (shopSettingsViewData2 != null && shopSettingsViewData2.isSaving()) {
                shopSettingsViewModelImpl.getSaveButtonClickRelay().accept(unit);
                return;
            }
            return;
        }
        ConnectableObservable<LoadingState<ShopSettings>> publish = shopSettingsViewModelImpl.w.getShopSettings().observeOn(shopSettingsViewModelImpl.x.mainThread()).startWith((Observable<LoadingState<ShopSettings>>) LoadingState.Loading.INSTANCE).publish();
        Intrinsics.checkNotNullExpressionValue(publish, "loadingObservable");
        Observable<R> flatMap = publish.flatMap(new r(q.a));
        Intrinsics.checkNotNullExpressionValue(flatMap, "this.flatMap { value ->\n…ervable.empty()\n        }");
        Observable<R> share = flatMap.map(new p(shopSettingsViewModelImpl)).share();
        Intrinsics.checkNotNullExpressionValue(share, "shopSettingsSource.map {…ter.convert(it) }.share()");
        shopSettingsViewModelImpl.c(share, false);
        DisposableKt.plusAssign(shopSettingsViewModelImpl.k, shopSettingsViewModelImpl.d(publish, shopSettingsViewModelImpl.c));
        CompositeDisposable compositeDisposable = shopSettingsViewModelImpl.k;
        Disposable connect = publish.connect();
        Intrinsics.checkNotNullExpressionValue(connect, "loadingObservable.connect()");
        DisposableKt.plusAssign(compositeDisposable, connect);
    }

    public final void c(Observable<ShopSettingsViewData> observable, boolean z2) {
        this.k.clear();
        ConnectableObservable<ShopSettingsViewData> publish = observable.publish();
        CompositeDisposable compositeDisposable = this.k;
        Observable<R> switchMap = publish.switchMap(a.a);
        Intrinsics.checkNotNullExpressionValue(switchMap, "sharedShopSettingsItemsS…ap { it.titleObservable }");
        DisposableKt.plusAssign(compositeDisposable, d(switchMap, this.e));
        CompositeDisposable compositeDisposable2 = this.k;
        Disposable subscribe = publish.subscribe(new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "sharedShopSettingsItemsS…opSettingsViewData = it }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe);
        CompositeDisposable compositeDisposable3 = this.k;
        Observable<R> switchMap2 = publish.switchMap(c.a).switchMap(new d(this));
        Intrinsics.checkNotNullExpressionValue(switchMap2, "sharedShopSettingsItemsS…ButtonData)\n            }");
        DisposableKt.plusAssign(compositeDisposable3, d(switchMap2, this.f));
        Observable<R> share = publish.switchMap(i.a).share();
        CompositeDisposable compositeDisposable4 = this.k;
        Intrinsics.checkNotNullExpressionValue(share, PlatformActions.ItemsList.TYPE);
        DisposableKt.plusAssign(compositeDisposable4, d(share, this.d));
        if (z2) {
            CompositeDisposable compositeDisposable5 = this.k;
            Observable<R> map = share.take(1).map(e.a);
            Intrinsics.checkNotNullExpressionValue(map, "itemsList\n              …dScrollTo }?.index ?: 0 }");
            DisposableKt.plusAssign(compositeDisposable5, d(map, this.i));
        }
        CompositeDisposable compositeDisposable6 = this.k;
        Observable<R> withLatestFrom = getSaveButtonClickRelay().withLatestFrom(share, ShopSettingsViewModelImpl$bindShopSettingsItems$$inlined$withLatestFrom$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(withLatestFrom, "withLatestFrom(other, Bi…n { t1, t2 -> t1 to t2 })");
        Disposable subscribe2 = withLatestFrom.switchMap(new f(this)).observeOn(this.x.mainThread()).subscribe(new g(this), h.a);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "saveButtonClickRelay\n   …error(it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable6, subscribe2);
        CompositeDisposable compositeDisposable7 = this.k;
        Disposable connect = publish.connect();
        Intrinsics.checkNotNullExpressionValue(connect, "sharedShopSettingsItemsSource.connect()");
        DisposableKt.plusAssign(compositeDisposable7, connect);
    }

    public final <T> Disposable d(Observable<T> observable, MutableLiveData<? super T> mutableLiveData) {
        Disposable subscribe = observable.subscribe(new l(mutableLiveData), m.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "this.subscribe(\n        …ogs.error(it) }\n        )");
        return subscribe;
    }

    @Override // com.avito.android.shop_settings.ShopSettingsViewModel
    @NotNull
    public SingleLiveEvent<ShopSettingsConfirmation> getConfirmationChanges() {
        return this.r;
    }

    @Override // com.avito.android.shop_settings.ShopSettingsViewModel
    @NotNull
    public SingleLiveEvent<Unit> getGoToLoginChanges() {
        return this.u;
    }

    @Override // com.avito.android.shop_settings.ShopSettingsViewModel
    @NotNull
    public SingleLiveEvent<String> getMessageChanges() {
        return this.q;
    }

    @Override // com.avito.android.shop_settings.ShopSettingsViewModel
    @NotNull
    public PublishRelay<Unit> getSaveButtonClickRelay() {
        return this.t;
    }

    @Override // com.avito.android.shop_settings.ShopSettingsViewModel
    @NotNull
    public SingleLiveEvent<Integer> getScrollPositionChanges() {
        return this.s;
    }

    @Override // com.avito.android.shop_settings.ShopSettingsViewModel
    public void handleLocationPickerResult(@NotNull String str, @NotNull AddressParameter.Value value) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(value, "result");
        ShopSettingsViewData shopSettingsViewData = this.l;
        if (shopSettingsViewData != null) {
            shopSettingsViewData.handleLocationPickerResult(str, value);
        }
    }

    @Override // com.avito.android.shop_settings.ShopSettingsViewModel
    public void handleSelectResult(@NotNull ShopSettingsSelectResult shopSettingsSelectResult) {
        Intrinsics.checkNotNullParameter(shopSettingsSelectResult, "result");
        ShopSettingsViewData shopSettingsViewData = this.l;
        if (shopSettingsViewData != null) {
            shopSettingsViewData.handleSelectResult(shopSettingsSelectResult);
        }
    }

    @Override // com.avito.android.shop_settings.ShopSettingsViewModel
    public void loadContent() {
        CompositeDisposable compositeDisposable = this.k;
        Disposable subscribe = InteropKt.toV2(this.A.currentAuthorized()).subscribe(new j(this), new k(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "accountState\n           …uthoried()\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.k.dispose();
    }

    @Override // com.avito.android.shop_settings.ShopSettingsViewModel
    public void onRetryButtonClick() {
        loadContent();
    }

    @Override // com.avito.android.shop_settings.ShopSettingsViewModel
    @NotNull
    public Kundle saveState() {
        Kundle putParcelable;
        return (this.l == null || (putParcelable = new Kundle().putParcelable("shop_settings_content", this.l)) == null) ? Kundle.Companion.getEMPTY() : putParcelable;
    }

    @Override // com.avito.android.shop_settings.ShopSettingsViewModel
    @NotNull
    public MutableLiveData<List<ShopSettingsItem>> getListChanges() {
        return this.n;
    }

    @Override // com.avito.android.shop_settings.ShopSettingsViewModel
    @NotNull
    public MutableLiveData<LoadingState<?>> getProgressChanges() {
        return this.m;
    }

    @Override // com.avito.android.shop_settings.ShopSettingsViewModel
    @NotNull
    public MutableLiveData<ShopSettingsSaveButtonData> getSaveButtonDataChanges() {
        return this.p;
    }

    @Override // com.avito.android.shop_settings.ShopSettingsViewModel
    @NotNull
    public MutableLiveData<String> getTitleChanges() {
        return this.o;
    }
}
