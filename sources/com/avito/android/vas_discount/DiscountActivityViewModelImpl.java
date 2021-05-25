package com.avito.android.vas_discount;

import androidx.lifecycle.ViewModel;
import com.avito.android.remote.model.DiscountResponse;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.vas_discount.business.DiscountRepository;
import com.avito.android.vas_discount.di.DiscountContext;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR(\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/avito/android/vas_discount/DiscountActivityViewModelImpl;", "Lcom/avito/android/vas_discount/DiscountActivityViewModel;", "Landroidx/lifecycle/ViewModel;", "", "onCleared", "()V", "Lio/reactivex/disposables/Disposable;", "c", "Lio/reactivex/disposables/Disposable;", "disposable", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/DiscountResponse;", "d", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "dataChangeEvent", "e", "getDataChanges", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "dataChanges", "", "discountContext", "Lcom/avito/android/vas_discount/business/DiscountRepository;", "repository", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "<init>", "(Ljava/lang/String;Lcom/avito/android/vas_discount/business/DiscountRepository;Lcom/avito/android/util/SchedulersFactory;)V", "vas-discount_release"}, k = 1, mv = {1, 4, 2})
public final class DiscountActivityViewModelImpl extends ViewModel implements DiscountActivityViewModel {
    public Disposable c;
    public final SingleLiveEvent<LoadingState<DiscountResponse>> d;
    @NotNull
    public final SingleLiveEvent<LoadingState<DiscountResponse>> e;

    public static final class a<T> implements Consumer<LoadingState<? super DiscountResponse>> {
        public final /* synthetic */ DiscountActivityViewModelImpl a;

        public a(DiscountActivityViewModelImpl discountActivityViewModelImpl) {
            this.a = discountActivityViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super DiscountResponse> loadingState) {
            this.a.d.postValue(loadingState);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Timber.e(th);
        }
    }

    public DiscountActivityViewModelImpl(@DiscountContext @Nullable String str, @NotNull DiscountRepository discountRepository, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(discountRepository, "repository");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.c = empty;
        SingleLiveEvent<LoadingState<DiscountResponse>> singleLiveEvent = new SingleLiveEvent<>();
        this.d = singleLiveEvent;
        this.e = singleLiveEvent;
        Disposable subscribe = discountRepository.getDiscount(str).observeOn(schedulersFactory.mainThread()).subscribe(new a(this), b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "repository.getDiscount(d…ber.e(it) }\n            )");
        this.c = subscribe;
    }

    @Override // com.avito.android.vas_discount.DiscountActivityViewModel
    @NotNull
    public SingleLiveEvent<LoadingState<DiscountResponse>> getDataChanges() {
        return this.e;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.c.dispose();
    }
}
