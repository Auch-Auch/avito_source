package com.avito.android.vas_performance.ui.applied_services;

import a2.a.a.q3.f.q0.e;
import a2.a.a.q3.f.q0.f;
import a2.a.a.q3.f.q0.h;
import a2.a.a.q3.f.q0.i;
import a2.a.a.q3.f.q0.j;
import a2.a.a.q3.f.q0.k;
import a2.a.a.q3.f.q0.l;
import a2.g.r.g;
import android.content.Intent;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.IntentDataHolder;
import com.avito.android.util.architecture_components.StartActivityEvent;
import com.avito.android.vas_performance.AppliedServicesConverter;
import com.avito.android.vas_performance.repository.VasRepository;
import com.avito.konveyor.blueprint.ItemPresenter;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b9\u0010:J*\u0010\b\u001a\u00020\u00072\u0019\u0010\u0006\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004¢\u0006\u0002\b\u00050\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bR \u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR&\u0010%\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0 8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\"\u00104\u001a\b\u0012\u0004\u0012\u00020\u00110 8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b2\u0010\"\u001a\u0004\b3\u0010$R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u0006;"}, d2 = {"Lcom/avito/android/vas_performance/ui/applied_services/AppliedServicesViewModelImpl;", "Lcom/avito/android/vas_performance/ui/applied_services/AppliedServicesViewModel;", "Landroidx/lifecycle/ViewModel;", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "", "subscribeToItemClicks", "(Ljava/util/Set;)V", "onCleared", "()V", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/util/LoadingState;", "c", "Landroidx/lifecycle/MutableLiveData;", "progressChangesLiveData", "Lcom/avito/android/util/architecture_components/StartActivityEvent;", "d", "startActivityEventData", "Lcom/avito/android/vas_performance/repository/VasRepository;", "j", "Lcom/avito/android/vas_performance/repository/VasRepository;", "repository", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/vas_performance/AppliedServicesConverter;", "k", "Lcom/avito/android/vas_performance/AppliedServicesConverter;", "converter", "Landroidx/lifecycle/LiveData;", "h", "Landroidx/lifecycle/LiveData;", "getProgressChanges", "()Landroidx/lifecycle/LiveData;", "progressChanges", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "l", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deeplinkIntentFactory", "Lio/reactivex/disposables/CompositeDisposable;", "e", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Lio/reactivex/disposables/Disposable;", "f", "Lio/reactivex/disposables/Disposable;", "clickDisposable", g.a, "getRoutingEvents", "routingEvents", "", "i", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "<init>", "(Ljava/lang/String;Lcom/avito/android/vas_performance/repository/VasRepository;Lcom/avito/android/vas_performance/AppliedServicesConverter;Lcom/avito/android/deep_linking/DeepLinkIntentFactory;Lcom/avito/android/util/SchedulersFactory;)V", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public final class AppliedServicesViewModelImpl extends ViewModel implements AppliedServicesViewModel {
    public final MutableLiveData<LoadingState<?>> c;
    public final MutableLiveData<StartActivityEvent> d;
    public final CompositeDisposable e;
    public Disposable f;
    @NotNull
    public final LiveData<StartActivityEvent> g;
    @NotNull
    public final LiveData<LoadingState<?>> h;
    public final String i;
    public final VasRepository j;
    public final AppliedServicesConverter k;
    public final DeepLinkIntentFactory l;
    public final SchedulersFactory m;

    public static final class a<T> implements Consumer<DeepLink> {
        public final /* synthetic */ AppliedServicesViewModelImpl a;

        public a(AppliedServicesViewModelImpl appliedServicesViewModelImpl) {
            this.a = appliedServicesViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(DeepLink deepLink) {
            DeepLink deepLink2 = deepLink;
            AppliedServicesViewModelImpl appliedServicesViewModelImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
            AppliedServicesViewModelImpl.access$followDeepLink(appliedServicesViewModelImpl, deepLink2);
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

    public AppliedServicesViewModelImpl(@NotNull String str, @NotNull VasRepository vasRepository, @NotNull AppliedServicesConverter appliedServicesConverter, @NotNull DeepLinkIntentFactory deepLinkIntentFactory, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(vasRepository, "repository");
        Intrinsics.checkNotNullParameter(appliedServicesConverter, "converter");
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deeplinkIntentFactory");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.i = str;
        this.j = vasRepository;
        this.k = appliedServicesConverter;
        this.l = deepLinkIntentFactory;
        this.m = schedulersFactory;
        MutableLiveData<LoadingState<?>> mutableLiveData = new MutableLiveData<>();
        this.c = mutableLiveData;
        MutableLiveData<StartActivityEvent> mutableLiveData2 = new MutableLiveData<>();
        this.d = mutableLiveData2;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.e = compositeDisposable;
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.f = empty;
        Disposable subscribe = vasRepository.getAppliedVas(str).doOnNext(new e(this)).filter(f.a).map(a2.a.a.q3.f.q0.g.a).map(new h(this)).map(i.a).subscribe(new j(this), new k(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "repository.getAppliedVas…          }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        this.g = mutableLiveData2;
        this.h = mutableLiveData;
    }

    public static final void access$followDeepLink(AppliedServicesViewModelImpl appliedServicesViewModelImpl, DeepLink deepLink) {
        Intent intent = appliedServicesViewModelImpl.l.getIntent(deepLink);
        if (intent != null) {
            appliedServicesViewModelImpl.d.postValue(new StartActivityEvent(new IntentDataHolder(intent, true)));
        }
    }

    @Override // com.avito.android.vas_performance.ui.applied_services.AppliedServicesViewModel
    @NotNull
    public LiveData<LoadingState<?>> getProgressChanges() {
        return this.h;
    }

    @Override // com.avito.android.vas_performance.ui.applied_services.AppliedServicesViewModel
    @NotNull
    public LiveData<StartActivityEvent> getRoutingEvents() {
        return this.g;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.e.clear();
    }

    @Override // com.avito.android.vas_performance.ui.applied_services.AppliedServicesViewModel
    public void subscribeToItemClicks(@NotNull Set<ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "itemPresenterSet");
        Sequence filter = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(set), AppliedServicesViewModelImpl$subscribeToItemClicks$$inlined$filterIsInstance$1.INSTANCE);
        Objects.requireNonNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
        List list = SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.map(filter, l.a));
        this.f.dispose();
        Disposable subscribe = Observable.merge(list).throttleFirst(300, TimeUnit.MILLISECONDS).subscribeOn(this.m.mainThread()).subscribe(new a(this), b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "Observable.merge(observa…ber.e(it) }\n            )");
        this.f = subscribe;
        DisposableKt.plusAssign(this.e, subscribe);
    }
}
