package com.avito.android.vas_discount.ui.dialog;

import a2.a.a.p3.a.a.f;
import a2.a.a.p3.a.a.h;
import a2.a.a.p3.a.a.i;
import a2.g.r.g;
import android.content.Intent;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.DeeplinkClickStreamProvider;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.MyAdvertDetailsLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.DiscountResponse;
import com.avito.android.util.Constants;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.IntentDataHolder;
import com.avito.android.util.architecture_components.StartActivityEvent;
import com.avito.android.vas_discount.business.DiscountToItemConverter;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.blueprint.ItemPresenter;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u00106\u001a\u000203\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010:\u001a\u000207\u0012\u0006\u00102\u001a\u00020/¢\u0006\u0004\b;\u0010<J*\u0010\b\u001a\u00020\u00072\u0019\u0010\u0006\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004¢\u0006\u0002\b\u00050\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0016R(\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001f\u0010\u0010R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00070\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010\u0016R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109¨\u0006="}, d2 = {"Lcom/avito/android/vas_discount/ui/dialog/DiscountPickerViewModelImpl;", "Lcom/avito/android/vas_discount/ui/dialog/DiscountPickerViewModel;", "Landroidx/lifecycle/ViewModel;", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresenterSet", "", "subscribeToItemClicks", "(Ljava/util/Set;)V", "onCleared", "()V", "Landroidx/lifecycle/LiveData;", "j", "Landroidx/lifecycle/LiveData;", "getErrorEvents", "()Landroidx/lifecycle/LiveData;", "errorEvents", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/avito/conveyor_item/Item;", "c", "Landroidx/lifecycle/MutableLiveData;", "dataChangesLiveData", "Lcom/avito/android/util/architecture_components/StartActivityEvent;", "i", "getRoutingEvents", "routingEvents", "d", "startActivityEventData", "h", "getDataChanges", "dataChanges", "Lcom/avito/android/vas_discount/business/DiscountToItemConverter;", "l", "Lcom/avito/android/vas_discount/business/DiscountToItemConverter;", "converter", "Lio/reactivex/disposables/Disposable;", g.a, "Lio/reactivex/disposables/Disposable;", "clickDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "f", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "e", "errorsLiveData", "Lcom/avito/android/util/SchedulersFactory;", "n", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/remote/model/DiscountResponse;", "k", "Lcom/avito/android/remote/model/DiscountResponse;", "discountResponse", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deeplinkIntentFactory", "<init>", "(Lcom/avito/android/remote/model/DiscountResponse;Lcom/avito/android/vas_discount/business/DiscountToItemConverter;Lcom/avito/android/deep_linking/DeepLinkIntentFactory;Lcom/avito/android/util/SchedulersFactory;)V", "vas-discount_release"}, k = 1, mv = {1, 4, 2})
public final class DiscountPickerViewModelImpl extends ViewModel implements DiscountPickerViewModel {
    public final MutableLiveData<List<Item>> c;
    public final MutableLiveData<StartActivityEvent> d;
    public final MutableLiveData<Unit> e;
    public final CompositeDisposable f;
    public Disposable g;
    @NotNull
    public final LiveData<List<Item>> h;
    @NotNull
    public final LiveData<StartActivityEvent> i;
    @NotNull
    public final LiveData<Unit> j;
    public final DiscountResponse k;
    public final DiscountToItemConverter l;
    public final DeepLinkIntentFactory m;
    public final SchedulersFactory n;

    public static final class a<T> implements Consumer<DeepLink> {
        public final /* synthetic */ DiscountPickerViewModelImpl a;

        public a(DiscountPickerViewModelImpl discountPickerViewModelImpl) {
            this.a = discountPickerViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(DeepLink deepLink) {
            DeepLink deepLink2 = deepLink;
            DiscountPickerViewModelImpl discountPickerViewModelImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
            DiscountPickerViewModelImpl.access$followDeepLink(discountPickerViewModelImpl, deepLink2);
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

    public DiscountPickerViewModelImpl(@NotNull DiscountResponse discountResponse, @NotNull DiscountToItemConverter discountToItemConverter, @NotNull DeepLinkIntentFactory deepLinkIntentFactory, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(discountResponse, "discountResponse");
        Intrinsics.checkNotNullParameter(discountToItemConverter, "converter");
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deeplinkIntentFactory");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.k = discountResponse;
        this.l = discountToItemConverter;
        this.m = deepLinkIntentFactory;
        this.n = schedulersFactory;
        MutableLiveData<List<Item>> mutableLiveData = new MutableLiveData<>();
        this.c = mutableLiveData;
        MutableLiveData<StartActivityEvent> mutableLiveData2 = new MutableLiveData<>();
        this.d = mutableLiveData2;
        MutableLiveData<Unit> mutableLiveData3 = new MutableLiveData<>();
        this.e = mutableLiveData3;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.f = compositeDisposable;
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.g = empty;
        Disposable subscribe = Single.fromCallable(new f(this)).subscribe(new a2.a.a.p3.a.a.g(this), new h(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "Single.fromCallable { co…ue = Unit }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        this.h = mutableLiveData;
        this.i = mutableLiveData2;
        this.j = mutableLiveData3;
    }

    public static final void access$followDeepLink(DiscountPickerViewModelImpl discountPickerViewModelImpl, DeepLink deepLink) {
        Intent intent = discountPickerViewModelImpl.m.getIntent(deepLink);
        if (intent != null) {
            if (deepLink instanceof MyAdvertDetailsLink) {
                intent.removeExtra(Constants.UP_INTENT);
            }
            discountPickerViewModelImpl.d.postValue(new StartActivityEvent(new IntentDataHolder(intent, true)));
        }
    }

    @Override // com.avito.android.vas_discount.ui.dialog.DiscountPickerViewModel
    @NotNull
    public LiveData<List<Item>> getDataChanges() {
        return this.h;
    }

    @Override // com.avito.android.vas_discount.ui.dialog.DiscountPickerViewModel
    @NotNull
    public LiveData<Unit> getErrorEvents() {
        return this.j;
    }

    @Override // com.avito.android.vas_discount.ui.dialog.DiscountPickerViewModel
    @NotNull
    public LiveData<StartActivityEvent> getRoutingEvents() {
        return this.i;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.f.clear();
    }

    @Override // com.avito.android.vas_discount.ui.dialog.DiscountPickerViewModel
    public void subscribeToItemClicks(@NotNull Set<ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "itemPresenterSet");
        List list = SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.map(t6.x.f.filterIsInstance(CollectionsKt___CollectionsKt.asSequence(set), DeeplinkClickStreamProvider.class), i.a));
        this.g.dispose();
        Disposable subscribe = Observable.merge(list).throttleFirst(100, TimeUnit.MILLISECONDS).subscribeOn(this.n.mainThread()).subscribe(new a(this), b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "Observable.merge(observa…ber.e(it) }\n            )");
        this.g = subscribe;
        DisposableKt.plusAssign(this.f, subscribe);
    }
}
