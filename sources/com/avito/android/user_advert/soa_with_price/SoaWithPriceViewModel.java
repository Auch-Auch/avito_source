package com.avito.android.user_advert.soa_with_price;

import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CloseReason;
import com.avito.android.user_advert.soa_with_price.RoutingEventInfo;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.data_source.ListDataSource;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\f\u0010B\u001a\b\u0012\u0004\u0012\u00020/0?\u0012\u0006\u00106\u001a\u000203\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\bC\u0010DJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0004J\r\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u001b\u0010\u000e\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\u0004\b\u000e\u0010\tJ\u001b\u0010\u0010\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0010\u0010\tJ\u000f\u0010\u0011\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0011\u0010\u0004J\r\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\"\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060#0\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010!R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00180\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010!R\u001f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00178\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u001a\u001a\u0004\b-\u0010\u001cR\u0016\u00102\u001a\u00020/8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R%\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060#0\u00178\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010\u001a\u001a\u0004\b;\u0010\u001cR\u0016\u0010>\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010(R\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020/0?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006E"}, d2 = {"Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceViewModel;", "Landroidx/lifecycle/ViewModel;", "", "prepareData", "()V", "Lio/reactivex/Observable;", "Lcom/avito/android/user_advert/soa_with_price/CloseReasonItem;", "itemSelectionsObservable", "subscribeToReasonItemSelections", "(Lio/reactivex/Observable;)V", "onBackClicked", "onCloseClicked", "", "priceChangingEventsObservable", "subscribeToPriceChangingEvents", "priceSubmittedObservable", "subscribeToPriceSubmittedEvents", "onCleared", "onDestroyView", "Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceResourceProvider;", "o", "Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceResourceProvider;", "resourceProvider", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/user_advert/soa_with_price/RoutingEventInfo;", "j", "Landroidx/lifecycle/LiveData;", "getRoutingEvents", "()Landroidx/lifecycle/LiveData;", "routingEvents", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/user_advert/soa_with_price/EnterPriceDetails;", "c", "Landroidx/lifecycle/MutableLiveData;", "enterPriceDetailsLiveData", "Lcom/avito/konveyor/data_source/DataSource;", "e", "closeReasonItemsLiveData", "Lio/reactivex/disposables/CompositeDisposable;", g.a, "Lio/reactivex/disposables/CompositeDisposable;", "priceStepDisposables", "d", "routingEventsLiveData", "k", "getEnterPriceDetails", "enterPriceDetails", "Lcom/avito/android/remote/model/CloseReason;", "h", "Lcom/avito/android/remote/model/CloseReason;", "selectedReason", "Lcom/avito/android/util/SchedulersFactory;", "n", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "i", "Ljava/lang/String;", "updatedPrice", "l", "getCloseReasonItems", "closeReasonItems", "f", "reasonsStepDisposables", "", AuthSource.OPEN_CHANNEL_LIST, "Ljava/util/List;", "reasonsList", "<init>", "(Ljava/util/List;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceResourceProvider;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class SoaWithPriceViewModel extends ViewModel {
    public final MutableLiveData<EnterPriceDetails> c;
    public final MutableLiveData<RoutingEventInfo> d;
    public final MutableLiveData<DataSource<CloseReasonItem>> e;
    public final CompositeDisposable f = new CompositeDisposable();
    public final CompositeDisposable g = new CompositeDisposable();
    public CloseReason h;
    public String i;
    @NotNull
    public final LiveData<RoutingEventInfo> j;
    @NotNull
    public final LiveData<EnterPriceDetails> k;
    @NotNull
    public final LiveData<DataSource<CloseReasonItem>> l;
    public final List<CloseReason> m;
    public final SchedulersFactory n;
    public final SoaWithPriceResourceProvider o;

    public static final class a<T> implements Consumer<String> {
        public final /* synthetic */ SoaWithPriceViewModel a;

        public a(SoaWithPriceViewModel soaWithPriceViewModel) {
            this.a = soaWithPriceViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(String str) {
            this.a.i = str;
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Failed to observe price submitted events", th);
        }
    }

    public static final class c<T> implements Consumer<Unit> {
        public final /* synthetic */ SoaWithPriceViewModel a;

        public c(SoaWithPriceViewModel soaWithPriceViewModel) {
            this.a = soaWithPriceViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            SoaWithPriceViewModel.access$exitWithSuccess(this.a);
            this.a.g.clear();
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Failed to observe price submitted events", th);
        }
    }

    public static final class e<T> implements Consumer<CloseReasonItem> {
        public final /* synthetic */ SoaWithPriceViewModel a;

        public e(SoaWithPriceViewModel soaWithPriceViewModel) {
            this.a = soaWithPriceViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(CloseReasonItem closeReasonItem) {
            T t;
            CloseReasonItem closeReasonItem2 = closeReasonItem;
            Iterator<T> it = this.a.m.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (Intrinsics.areEqual(t.getId(), closeReasonItem2.getStringId())) {
                    break;
                }
            }
            T t2 = t;
            if (t2 != null) {
                this.a.h = t2;
                this.a.i = t2.getCurrentPrice();
                if (Intrinsics.areEqual(t2.getShowInput(), Boolean.TRUE)) {
                    SoaWithPriceViewModel.access$goToPriceStep(this.a);
                } else {
                    SoaWithPriceViewModel.access$exitWithSuccess(this.a);
                }
                this.a.f.clear();
            }
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public static final f a = new f();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Failed to observe item selection", th);
        }
    }

    public SoaWithPriceViewModel(@NotNull List<CloseReason> list, @NotNull SchedulersFactory schedulersFactory, @NotNull SoaWithPriceResourceProvider soaWithPriceResourceProvider) {
        Intrinsics.checkNotNullParameter(list, "reasonsList");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(soaWithPriceResourceProvider, "resourceProvider");
        this.m = list;
        this.n = schedulersFactory;
        this.o = soaWithPriceResourceProvider;
        MutableLiveData<EnterPriceDetails> mutableLiveData = new MutableLiveData<>();
        this.c = mutableLiveData;
        MutableLiveData<RoutingEventInfo> mutableLiveData2 = new MutableLiveData<>();
        this.d = mutableLiveData2;
        MutableLiveData<DataSource<CloseReasonItem>> mutableLiveData3 = new MutableLiveData<>();
        this.e = mutableLiveData3;
        this.j = mutableLiveData2;
        this.k = mutableLiveData;
        this.l = mutableLiveData3;
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            arrayList.add(new CloseReasonItem(t.getId(), t.getTitle(), false));
        }
        mutableLiveData3.setValue(new ListDataSource(arrayList));
        this.d.setValue(new RoutingEventInfo.ChooseReasonRoutingInfo(this.o.getCloseReasonsTitle()));
    }

    public static final void access$exitWithSuccess(SoaWithPriceViewModel soaWithPriceViewModel) {
        RoutingEventInfo.ExitWithSuccess exitWithSuccess;
        MutableLiveData<RoutingEventInfo> mutableLiveData = soaWithPriceViewModel.d;
        if (soaWithPriceViewModel.i != null) {
            CloseReason closeReason = soaWithPriceViewModel.h;
            if (closeReason == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedReason");
            }
            if (!Intrinsics.areEqual(closeReason.getCurrentPrice(), soaWithPriceViewModel.i)) {
                CloseReason closeReason2 = soaWithPriceViewModel.h;
                if (closeReason2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectedReason");
                }
                exitWithSuccess = new RoutingEventInfo.ExitWithSuccess(closeReason2, soaWithPriceViewModel.i);
                mutableLiveData.setValue(exitWithSuccess);
            }
        }
        CloseReason closeReason3 = soaWithPriceViewModel.h;
        if (closeReason3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedReason");
        }
        exitWithSuccess = new RoutingEventInfo.ExitWithSuccess(closeReason3, null, 2, null);
        mutableLiveData.setValue(exitWithSuccess);
    }

    public static final /* synthetic */ CloseReason access$getSelectedReason$p(SoaWithPriceViewModel soaWithPriceViewModel) {
        CloseReason closeReason = soaWithPriceViewModel.h;
        if (closeReason == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedReason");
        }
        return closeReason;
    }

    public static final void access$goToPriceStep(SoaWithPriceViewModel soaWithPriceViewModel) {
        if (!(soaWithPriceViewModel.d.getValue() instanceof RoutingEventInfo.EnterPriceRoutingInfo)) {
            MutableLiveData<RoutingEventInfo> mutableLiveData = soaWithPriceViewModel.d;
            CloseReason closeReason = soaWithPriceViewModel.h;
            if (closeReason == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedReason");
            }
            mutableLiveData.setValue(new RoutingEventInfo.EnterPriceRoutingInfo(closeReason.getTitle()));
            MutableLiveData<EnterPriceDetails> mutableLiveData2 = soaWithPriceViewModel.c;
            CloseReason closeReason2 = soaWithPriceViewModel.h;
            if (closeReason2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedReason");
            }
            String currentPrice = closeReason2.getCurrentPrice();
            CloseReason closeReason3 = soaWithPriceViewModel.h;
            if (closeReason3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedReason");
            }
            mutableLiveData2.setValue(new EnterPriceDetails(currentPrice, closeReason3.getMotivationText()));
        }
    }

    @NotNull
    public final LiveData<DataSource<CloseReasonItem>> getCloseReasonItems() {
        return this.l;
    }

    @NotNull
    public final LiveData<EnterPriceDetails> getEnterPriceDetails() {
        return this.k;
    }

    @NotNull
    public final LiveData<RoutingEventInfo> getRoutingEvents() {
        return this.j;
    }

    public final void onBackClicked() {
        if (!(this.d.getValue() instanceof RoutingEventInfo.ChooseReasonRoutingInfo)) {
            this.d.setValue(new RoutingEventInfo.ChooseReasonRoutingInfo(this.o.getCloseReasonsTitle()));
            MutableLiveData<DataSource<CloseReasonItem>> mutableLiveData = this.e;
            List<CloseReason> list = this.m;
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
            for (T t : list) {
                String id = t.getId();
                String title = t.getTitle();
                CloseReason closeReason = this.h;
                arrayList.add(new CloseReasonItem(id, title, closeReason != null ? Intrinsics.areEqual(closeReason.getId(), t.getId()) : false));
            }
            mutableLiveData.setValue(new ListDataSource(arrayList));
        }
        this.g.clear();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.f.dispose();
        this.g.dispose();
    }

    public final void onCloseClicked() {
        this.d.setValue(RoutingEventInfo.CancelDialog.INSTANCE);
        this.f.clear();
    }

    public final void onDestroyView() {
        this.f.clear();
        this.g.clear();
    }

    public final void prepareData() {
        if (this.d.getValue() instanceof RoutingEventInfo.EnterPriceRoutingInfo) {
            MutableLiveData<EnterPriceDetails> mutableLiveData = this.c;
            String str = this.i;
            CloseReason closeReason = this.h;
            if (closeReason == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedReason");
            }
            mutableLiveData.setValue(new EnterPriceDetails(str, closeReason.getMotivationText()));
        }
    }

    public final void subscribeToPriceChangingEvents(@NotNull Observable<String> observable) {
        Intrinsics.checkNotNullParameter(observable, "priceChangingEventsObservable");
        CompositeDisposable compositeDisposable = this.g;
        Disposable subscribe = observable.observeOn(this.n.mainThread()).subscribe(new a(this), b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "priceChangingEventsObser…nts\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void subscribeToPriceSubmittedEvents(@NotNull Observable<Unit> observable) {
        Intrinsics.checkNotNullParameter(observable, "priceSubmittedObservable");
        CompositeDisposable compositeDisposable = this.g;
        Disposable subscribe = observable.observeOn(this.n.mainThread()).subscribe(new c(this), d.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "priceSubmittedObservable…nts\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void subscribeToReasonItemSelections(@NotNull Observable<CloseReasonItem> observable) {
        Intrinsics.checkNotNullParameter(observable, "itemSelectionsObservable");
        CompositeDisposable compositeDisposable = this.f;
        Disposable subscribe = observable.observeOn(this.n.mainThread()).subscribe(new e(this), f.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "itemSelectionsObservable…ion\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }
}
