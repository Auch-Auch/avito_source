package com.avito.android.advert_core.delivery;

import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlock;
import com.avito.android.remote.model.AdvertDeliveryC2C;
import com.avito.android.remote.model.AdvertDeliverySwitchResponse;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.text.AttributedTextFormatter;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b-\u0010.J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR(\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010(\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockViewModel;", "", "newValue", "", "onSwitchChanged", "(Z)V", "onCleared", "()V", "Lcom/avito/android/util/text/AttributedTextFormatter;", "i", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/AdvertDeliverySwitchResponse;", "c", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getSwitchProgressChanges", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "switchProgressChanges", "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockRepository;", g.a, "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockRepository;", "repository", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "f", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/remote/model/AdvertDeliveryC2C;", "e", "Lcom/avito/android/remote/model/AdvertDeliveryC2C;", "advertDeliveryData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlock;", "d", "Landroidx/lifecycle/MutableLiveData;", "getDataChanges", "()Landroidx/lifecycle/MutableLiveData;", "dataChanges", "Lcom/avito/android/util/SchedulersFactory3;", "h", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockRepository;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDeliveryBlockViewModelImpl extends ViewModel implements AdvertDeliveryBlockViewModel {
    @NotNull
    public final SingleLiveEvent<LoadingState<AdvertDeliverySwitchResponse>> c = new SingleLiveEvent<>();
    @NotNull
    public final MutableLiveData<AdvertDeliveryBlock> d = new MutableLiveData<>();
    public AdvertDeliveryC2C e;
    public final CompositeDisposable f;
    public final AdvertDeliveryBlockRepository g;
    public final SchedulersFactory3 h;
    public final AttributedTextFormatter i;

    public static final class a<T> implements Consumer<AdvertDeliveryC2C> {
        public final /* synthetic */ AdvertDeliveryBlockViewModelImpl a;

        public a(AdvertDeliveryBlockViewModelImpl advertDeliveryBlockViewModelImpl) {
            this.a = advertDeliveryBlockViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(AdvertDeliveryC2C advertDeliveryC2C) {
            AdvertDeliveryC2C advertDeliveryC2C2 = advertDeliveryC2C;
            this.a.e = advertDeliveryC2C2;
            MutableLiveData<AdvertDeliveryBlock> dataChanges = this.a.getDataChanges();
            AdvertDeliveryBlockViewModelImpl advertDeliveryBlockViewModelImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(advertDeliveryC2C2, "it");
            dataChanges.setValue(AdvertDeliveryBlockViewModelImpl.access$toAdvertDeliveryBlock(advertDeliveryBlockViewModelImpl, advertDeliveryC2C2));
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

    public static final class c<T> implements Consumer<LoadingState<? super AdvertDeliverySwitchResponse>> {
        public final /* synthetic */ AdvertDeliveryBlockViewModelImpl a;
        public final /* synthetic */ boolean b;

        public c(AdvertDeliveryBlockViewModelImpl advertDeliveryBlockViewModelImpl, boolean z) {
            this.a = advertDeliveryBlockViewModelImpl;
            this.b = z;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super AdvertDeliverySwitchResponse> loadingState) {
            LoadingState<? super AdvertDeliverySwitchResponse> loadingState2 = loadingState;
            AdvertDeliveryC2C advertDeliveryC2C = this.a.e;
            if (advertDeliveryC2C != null) {
                AdvertDeliveryC2C.Switcher switcher = advertDeliveryC2C.getSwitcher();
                if (switcher != null) {
                    switcher.setValue(this.b);
                }
                this.a.getDataChanges().setValue(AdvertDeliveryBlockViewModelImpl.access$toAdvertDeliveryBlock(this.a, advertDeliveryC2C));
            }
            SingleLiveEvent<LoadingState<AdvertDeliverySwitchResponse>> switchProgressChanges = this.a.getSwitchProgressChanges();
            Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
            switchProgressChanges.setValue(loadingState2);
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

    public AdvertDeliveryBlockViewModelImpl(@NotNull AdvertDeliveryBlockRepository advertDeliveryBlockRepository, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(advertDeliveryBlockRepository, "repository");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.g = advertDeliveryBlockRepository;
        this.h = schedulersFactory3;
        this.i = attributedTextFormatter;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.f = compositeDisposable;
        Disposable subscribe = advertDeliveryBlockRepository.getDeliveryData().observeOn(schedulersFactory3.mainThread()).subscribe(new a(this), b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "repository.getDeliveryDa…          }\n            )");
        DisposableKt.addTo(subscribe, compositeDisposable);
    }

    public static final AdvertDeliveryBlock access$toAdvertDeliveryBlock(AdvertDeliveryBlockViewModelImpl advertDeliveryBlockViewModelImpl, AdvertDeliveryC2C advertDeliveryC2C) {
        AdvertDeliveryBlock.Info info;
        Objects.requireNonNull(advertDeliveryBlockViewModelImpl);
        AdvertDeliveryC2C.Info info2 = advertDeliveryC2C.getInfo();
        AdvertDeliveryBlock.Switcher switcher = null;
        CharSequence charSequence = null;
        if (info2 != null) {
            String title = info2.getTitle();
            AttributedText subtitle = info2.getSubtitle();
            info = new AdvertDeliveryBlock.Info(title, subtitle != null ? advertDeliveryBlockViewModelImpl.i.format(subtitle) : null, info2.getUri());
        } else {
            info = null;
        }
        AdvertDeliveryC2C.Switcher switcher2 = advertDeliveryC2C.getSwitcher();
        if (switcher2 != null) {
            String title2 = switcher2.getTitle();
            AttributedText subtitle2 = switcher2.getSubtitle();
            if (subtitle2 != null) {
                charSequence = advertDeliveryBlockViewModelImpl.i.format(subtitle2);
            }
            switcher = new AdvertDeliveryBlock.Switcher(title2, charSequence, switcher2.getValue());
        }
        return new AdvertDeliveryBlock(info, switcher);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.f.clear();
    }

    @Override // com.avito.android.advert_core.delivery.AdvertDeliveryBlockViewModel
    public void onSwitchChanged(boolean z) {
        Disposable subscribe = this.g.advertItemToggleDelivery(z).observeOn(this.h.mainThread()).subscribe(new c(this, z), d.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "repository.advertItemTog…          }\n            )");
        DisposableKt.addTo(subscribe, this.f);
    }

    @Override // com.avito.android.advert_core.delivery.AdvertDeliveryBlockViewModel
    @NotNull
    public MutableLiveData<AdvertDeliveryBlock> getDataChanges() {
        return this.d;
    }

    @Override // com.avito.android.advert_core.delivery.AdvertDeliveryBlockViewModel
    @NotNull
    public SingleLiveEvent<LoadingState<AdvertDeliverySwitchResponse>> getSwitchProgressChanges() {
        return this.c;
    }
}
