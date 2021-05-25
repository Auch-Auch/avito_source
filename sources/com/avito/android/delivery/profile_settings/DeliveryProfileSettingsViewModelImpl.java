package com.avito.android.delivery.profile_settings;

import a2.a.a.k0.c.h;
import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.delivery.profile_settings.DeliveryProfileSettings;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b2\u00103J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR&\u0010$\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001f0\u001e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\"\u0010(\u001a\b\u0012\u0004\u0012\u00020%0\u001e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#R&\u0010.\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001f0)8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100¨\u00064"}, d2 = {"Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsViewModel;", "", "onCleared", "()V", "", "enabled", "deliveryToggleUserDefault", "(Z)V", "Lio/reactivex/disposables/CompositeDisposable;", "f", "Lio/reactivex/disposables/CompositeDisposable;", "disposable", "Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsResponseConverter;", "i", "Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsResponseConverter;", "converter", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "k", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "tracker", "Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsRepository;", "h", "Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsRepository;", "repository", "Lcom/avito/android/util/SchedulersFactory;", "j", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/util/LoadingState;", "c", "Landroidx/lifecycle/MutableLiveData;", "getProgressChanges", "()Landroidx/lifecycle/MutableLiveData;", "progressChanges", "Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettings;", "e", "getDataChanges", "dataChanges", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "d", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getSwitchProgressChanges", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "switchProgressChanges", g.a, "Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettings;", "data", "<init>", "(Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsRepository;Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettingsResponseConverter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryProfileSettingsViewModelImpl extends ViewModel implements DeliveryProfileSettingsViewModel {
    @NotNull
    public final MutableLiveData<LoadingState<?>> c = new MutableLiveData<>();
    @NotNull
    public final SingleLiveEvent<LoadingState<?>> d = new SingleLiveEvent<>();
    @NotNull
    public final MutableLiveData<DeliveryProfileSettings> e = new MutableLiveData<>();
    public final CompositeDisposable f;
    public DeliveryProfileSettings g;
    public final DeliveryProfileSettingsRepository h;
    public final DeliveryProfileSettingsResponseConverter i;
    public final SchedulersFactory j;
    public final BaseScreenPerformanceTracker k;

    public static final class a<T> implements Consumer<LoadingState<? super Unit>> {
        public final /* synthetic */ DeliveryProfileSettingsViewModelImpl a;

        public a(DeliveryProfileSettingsViewModelImpl deliveryProfileSettingsViewModelImpl) {
            this.a = deliveryProfileSettingsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super Unit> loadingState) {
            DeliveryProfileSettings deliveryProfileSettings;
            DeliveryProfileSettings.Switch r0;
            LoadingState<? super Unit> loadingState2 = loadingState;
            if (!(!(loadingState2 instanceof LoadingState.Loaded) || (deliveryProfileSettings = this.a.g) == null || (r0 = deliveryProfileSettings.getSwitch()) == null)) {
                r0.setValue(!r0.getValue());
                this.a.getDataChanges().postValue(this.a.g);
            }
            SingleLiveEvent<LoadingState<?>> switchProgressChanges = this.a.getSwitchProgressChanges();
            Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
            switchProgressChanges.setValue(loadingState2);
        }
    }

    public DeliveryProfileSettingsViewModelImpl(@NotNull DeliveryProfileSettingsRepository deliveryProfileSettingsRepository, @NotNull DeliveryProfileSettingsResponseConverter deliveryProfileSettingsResponseConverter, @NotNull SchedulersFactory schedulersFactory, @NotNull BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        Intrinsics.checkNotNullParameter(deliveryProfileSettingsRepository, "repository");
        Intrinsics.checkNotNullParameter(deliveryProfileSettingsResponseConverter, "converter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(baseScreenPerformanceTracker, "tracker");
        this.h = deliveryProfileSettingsRepository;
        this.i = deliveryProfileSettingsResponseConverter;
        this.j = schedulersFactory;
        this.k = baseScreenPerformanceTracker;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.f = compositeDisposable;
        baseScreenPerformanceTracker.startLoading();
        Observable<R> map = deliveryProfileSettingsRepository.getDeliveryUserProfile().map(new a2.a.a.k0.c.g(this));
        Intrinsics.checkNotNullExpressionValue(map, "map {\n            if (it…rofileSettings>\n        }");
        Disposable subscribe = map.observeOn(schedulersFactory.mainThread()).subscribe(new h(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "repository.getDeliveryUs…stValue(it)\n            }");
        DisposableKt.addTo(subscribe, compositeDisposable);
    }

    @Override // com.avito.android.delivery.profile_settings.DeliveryProfileSettingsViewModel
    public void deliveryToggleUserDefault(boolean z) {
        Disposable subscribe = this.h.deliveryToggleUserDefault(z).observeOn(this.j.mainThread()).subscribe(new a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "repository.deliveryToggl…etValue(it)\n            }");
        DisposableKt.addTo(subscribe, this.f);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.f.clear();
        super.onCleared();
    }

    @Override // com.avito.android.delivery.profile_settings.DeliveryProfileSettingsViewModel
    @NotNull
    public MutableLiveData<DeliveryProfileSettings> getDataChanges() {
        return this.e;
    }

    @Override // com.avito.android.delivery.profile_settings.DeliveryProfileSettingsViewModel
    @NotNull
    public MutableLiveData<LoadingState<?>> getProgressChanges() {
        return this.c;
    }

    @Override // com.avito.android.delivery.profile_settings.DeliveryProfileSettingsViewModel
    @NotNull
    public SingleLiveEvent<LoadingState<?>> getSwitchProgressChanges() {
        return this.d;
    }
}
