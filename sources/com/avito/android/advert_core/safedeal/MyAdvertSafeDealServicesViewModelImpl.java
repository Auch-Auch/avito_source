package com.avito.android.advert_core.safedeal;

import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.MyAdvertSafeDeal;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.jakewharton.rxrelay3.Relay;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010.\u001a\u00020+\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\u0004\b<\u0010=J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\u000bR.\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000e0\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\"R.\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000e0\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010\u0010\u001a\u0004\b%\u0010\u0012R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R.\u00101\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000e0\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b/\u0010\u0010\u001a\u0004\b0\u0010\u0012R\"\u00107\u001a\b\u0012\u0004\u0012\u00020\u0003028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R4\u0010;\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0003080\u000e0\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b9\u0010\u0010\u001a\u0004\b:\u0010\u0012¨\u0006>"}, d2 = {"Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesViewModel;", "", "serviceID", "", "isEnabled", "", "onSwitcherToggled", "(Ljava/lang/String;Z)V", "onCleared", "()V", "c", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "f", "Landroidx/lifecycle/MutableLiveData;", "getSwitcherIsLoadingChanges", "()Landroidx/lifecycle/MutableLiveData;", "switcherIsLoadingChanges", "", "d", "Ljava/util/Set;", "checkedSwitchersSet", "Lcom/avito/android/util/SchedulersFactory3;", "k", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/jakewharton/rxrelay3/Relay;", "Lcom/avito/android/remote/model/MyAdvertSafeDeal;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/jakewharton/rxrelay3/Relay;", "safeDealServicesObservable", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscriptions", g.a, "getSwitcherIsCheckedChanges", "switcherIsCheckedChanges", "Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesInteractor;", "j", "Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesInteractor;", "interactor", "Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealResourceProvider;", "l", "Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealResourceProvider;", "resourcesProvider", "h", "getSwitcherIsEnabledChanges", "switcherIsEnabledChanges", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "i", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getSnackbarChanges", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "snackbarChanges", "", "e", "getDataChanges", "dataChanges", "<init>", "(Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealResourceProvider;Lcom/jakewharton/rxrelay3/Relay;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class MyAdvertSafeDealServicesViewModelImpl extends ViewModel implements MyAdvertSafeDealServicesViewModel {
    public final CompositeDisposable c = new CompositeDisposable();
    public final Set<String> d = new LinkedHashSet();
    @NotNull
    public final MutableLiveData<Pair<MyAdvertSafeDeal, Set<String>>> e = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Pair<String, Boolean>> f = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Pair<String, Boolean>> g = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Pair<String, Boolean>> h = new MutableLiveData<>();
    @NotNull
    public final SingleLiveEvent<String> i = new SingleLiveEvent<>();
    public final MyAdvertSafeDealServicesInteractor j;
    public final SchedulersFactory3 k;
    public final MyAdvertSafeDealResourceProvider l;
    public final Relay<MyAdvertSafeDeal> m;

    public static final class a<T> implements Consumer<LoadingState<? super Unit>> {
        public final /* synthetic */ MyAdvertSafeDealServicesViewModelImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;

        public a(MyAdvertSafeDealServicesViewModelImpl myAdvertSafeDealServicesViewModelImpl, String str, boolean z) {
            this.a = myAdvertSafeDealServicesViewModelImpl;
            this.b = str;
            this.c = z;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super Unit> loadingState) {
            LoadingState<? super Unit> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loading) {
                this.a.getSwitcherIsLoadingChanges().setValue(TuplesKt.to(this.b, Boolean.TRUE));
            } else if (loadingState2 instanceof LoadingState.Loaded) {
                this.a.getSwitcherIsLoadingChanges().setValue(TuplesKt.to(this.b, Boolean.FALSE));
                this.a.getSwitcherIsCheckedChanges().setValue(TuplesKt.to(this.b, Boolean.valueOf(this.c)));
                if (this.c) {
                    this.a.d.add(this.b);
                } else {
                    this.a.d.remove(this.b);
                }
            } else if (loadingState2 instanceof LoadingState.Error) {
                this.a.getSwitcherIsLoadingChanges().setValue(TuplesKt.to(this.b, Boolean.FALSE));
                this.a.getSwitcherIsCheckedChanges().setValue(TuplesKt.to(this.b, Boolean.valueOf(!this.c)));
                MyAdvertSafeDealServicesViewModelImpl.access$showTogglingError(this.a, this.c);
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ MyAdvertSafeDealServicesViewModelImpl a;
        public final /* synthetic */ boolean b;

        public b(MyAdvertSafeDealServicesViewModelImpl myAdvertSafeDealServicesViewModelImpl, boolean z) {
            this.a = myAdvertSafeDealServicesViewModelImpl;
            this.b = z;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            MyAdvertSafeDealServicesViewModelImpl.access$showTogglingError(this.a, this.b);
        }
    }

    public static final class c<T> implements Consumer<MyAdvertSafeDeal> {
        public final /* synthetic */ MyAdvertSafeDealServicesViewModelImpl a;

        public c(MyAdvertSafeDealServicesViewModelImpl myAdvertSafeDealServicesViewModelImpl) {
            this.a = myAdvertSafeDealServicesViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(MyAdvertSafeDeal myAdvertSafeDeal) {
            MyAdvertSafeDeal myAdvertSafeDeal2 = myAdvertSafeDeal;
            this.a.d.clear();
            for (T t : myAdvertSafeDeal2.getServices()) {
                String id = t.getContent().getId();
                if (Intrinsics.areEqual(t.getContent().isSwitchOn(), Boolean.TRUE) && id != null) {
                    this.a.d.add(id);
                }
            }
            this.a.getDataChanges().setValue(TuplesKt.to(myAdvertSafeDeal2, this.a.d));
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ MyAdvertSafeDealServicesViewModelImpl a;

        public d(MyAdvertSafeDealServicesViewModelImpl myAdvertSafeDealServicesViewModelImpl) {
            this.a = myAdvertSafeDealServicesViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.c();
        }
    }

    public MyAdvertSafeDealServicesViewModelImpl(@NotNull MyAdvertSafeDealServicesInteractor myAdvertSafeDealServicesInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull MyAdvertSafeDealResourceProvider myAdvertSafeDealResourceProvider, @NotNull Relay<MyAdvertSafeDeal> relay) {
        Intrinsics.checkNotNullParameter(myAdvertSafeDealServicesInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(myAdvertSafeDealResourceProvider, "resourcesProvider");
        Intrinsics.checkNotNullParameter(relay, "safeDealServicesObservable");
        this.j = myAdvertSafeDealServicesInteractor;
        this.k = schedulersFactory3;
        this.l = myAdvertSafeDealResourceProvider;
        this.m = relay;
        c();
    }

    public static final void access$showTogglingError(MyAdvertSafeDealServicesViewModelImpl myAdvertSafeDealServicesViewModelImpl, boolean z) {
        String str;
        if (z) {
            str = myAdvertSafeDealServicesViewModelImpl.l.getServiceEnablingErrorMessage();
        } else {
            str = myAdvertSafeDealServicesViewModelImpl.l.getServiceDisablingErrorMessage();
        }
        myAdvertSafeDealServicesViewModelImpl.getSnackbarChanges().setValue(str);
    }

    public final void c() {
        Disposable subscribe = this.m.observeOn(this.k.mainThread()).subscribe(new c(this), new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "safeDealServicesObservab…          }\n            )");
        DisposableKt.addTo(subscribe, this.c);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.c.clear();
    }

    @Override // com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesViewModel
    public void onSwitcherToggled(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "serviceID");
        Disposable subscribe = this.j.toggleService(str, z).observeOn(this.k.mainThread()).subscribe(new a(this, str, z), new b(this, z));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.toggleService…          }\n            )");
        DisposableKt.addTo(subscribe, this.c);
    }

    @Override // com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesViewModel
    @NotNull
    public MutableLiveData<Pair<MyAdvertSafeDeal, Set<String>>> getDataChanges() {
        return this.e;
    }

    @Override // com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesViewModel
    @NotNull
    public SingleLiveEvent<String> getSnackbarChanges() {
        return this.i;
    }

    @Override // com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesViewModel
    @NotNull
    public MutableLiveData<Pair<String, Boolean>> getSwitcherIsCheckedChanges() {
        return this.g;
    }

    @Override // com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesViewModel
    @NotNull
    public MutableLiveData<Pair<String, Boolean>> getSwitcherIsEnabledChanges() {
        return this.h;
    }

    @Override // com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesViewModel
    @NotNull
    public MutableLiveData<Pair<String, Boolean>> getSwitcherIsLoadingChanges() {
        return this.f;
    }
}
