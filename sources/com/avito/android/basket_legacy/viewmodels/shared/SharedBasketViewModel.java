package com.avito.android.basket_legacy.viewmodels.shared;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import com.avito.android.basket_legacy.repositories.BasketRepository;
import com.avito.android.basket_legacy.utils.PackageService;
import com.avito.android.basket_legacy.utils.PaidService;
import com.avito.android.basket_legacy.utils.SingleFeeService;
import com.avito.android.basket_legacy.utils.VasService;
import com.avito.android.basket_legacy.utils.VasType;
import com.jakewharton.rxrelay2.BehaviorRelay;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u000e\u0010B\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\t¢\u0006\u0004\bC\u0010\fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001d\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\tH\u0016¢\u0006\u0004\b\u001d\u0010\fJ'\u0010 \u001a\u00020\u001f*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\t0\u001e2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b \u0010!R\"\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00170\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001b0\t8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)RR\u0010.\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 +*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t0\t +*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 +*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t0\t\u0018\u00010\u001e0\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u001f8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R:\u00103\u001a&\u0012\f\u0012\n +*\u0004\u0018\u00010\u00170\u0017 +*\u0012\u0012\f\u0012\n +*\u0004\u0018\u00010\u00170\u0017\u0018\u00010\u001e0\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u0010-R(\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\t0\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b4\u0010$\u001a\u0004\b5\u0010&R:\u00107\u001a&\u0012\f\u0012\n +*\u0004\u0018\u00010\u00130\u0013 +*\u0012\u0012\f\u0012\n +*\u0004\u0018\u00010\u00130\u0013\u0018\u00010\u001e0\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010-R\u0016\u00108\u001a\u00020\u001f8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b8\u00100RR\u0010:\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 +*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t0\t +*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 +*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t0\t\u0018\u00010\u001e0\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010-R\u0016\u0010<\u001a\u00020\u001f8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b;\u00100R\u0016\u0010>\u001a\u00020\u001f8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b=\u00100R\"\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00130\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b?\u0010$\u001a\u0004\b@\u0010&¨\u0006D"}, d2 = {"Lcom/avito/android/basket_legacy/viewmodels/shared/SharedBasketViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/basket_legacy/repositories/BasketRepository;", "Lcom/avito/android/basket_legacy/utils/VasService;", "vas", "", "addVas", "(Lcom/avito/android/basket_legacy/utils/VasService;)V", "addFirstStepVas", "", "vasList", "addSecondStepVas", "(Ljava/util/List;)V", "", "id", "removeVas", "(Ljava/lang/String;)V", "clearFirstStepVasSelection", "()V", "Lcom/avito/android/basket_legacy/utils/PackageService;", "ownedPackage", "addPackage", "(Lcom/avito/android/basket_legacy/utils/PackageService;)V", "Lcom/avito/android/basket_legacy/utils/SingleFeeService;", "singleFee", "addSingleFee", "(Lcom/avito/android/basket_legacy/utils/SingleFeeService;)V", "Lcom/avito/android/basket_legacy/utils/PaidService;", "list", "restoreSelection", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "", "c", "(Lcom/jakewharton/rxrelay2/BehaviorRelay;Ljava/lang/String;)Z", "Lio/reactivex/Observable;", "i", "Lio/reactivex/Observable;", "getSingleFeeObservable", "()Lio/reactivex/Observable;", "singleFeeObservable", "getSelectedServices", "()Ljava/util/List;", "selectedServices", "kotlin.jvm.PlatformType", "f", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "secondStepVasRelay", "getContainsLfPackage", "()Z", "containsLfPackage", "d", "singleFeeRelay", g.a, "getVasObservable", "vasObservable", "packageRelay", "isEmpty", "e", "firstStepVasRelay", "getContainsVas", "containsVas", "getContainsListingFees", "containsListingFees", "h", "getLfPackageObservable", "lfPackageObservable", "state", "<init>", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class SharedBasketViewModel extends ViewModel implements BasketRepository {
    public final BehaviorRelay<PackageService> c;
    public final BehaviorRelay<SingleFeeService> d;
    public final BehaviorRelay<List<VasService>> e;
    public final BehaviorRelay<List<VasService>> f;
    @NotNull
    public final Observable<List<VasService>> g;
    @NotNull
    public final Observable<PackageService> h;
    @NotNull
    public final Observable<SingleFeeService> i;

    public static final class a<T1, T2, R> implements BiFunction<List<? extends VasService>, List<? extends VasService>, List<? extends VasService>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // io.reactivex.functions.BiFunction
        public List<? extends VasService> apply(List<? extends VasService> list, List<? extends VasService> list2) {
            List<? extends VasService> list3 = list;
            List<? extends VasService> list4 = list2;
            Intrinsics.checkNotNullParameter(list3, "firstVas");
            Intrinsics.checkNotNullParameter(list4, "secondVas");
            return CollectionsKt___CollectionsKt.plus((Collection) list3, (Iterable) list4);
        }
    }

    public SharedBasketViewModel(@Nullable List<? extends PaidService> list) {
        BehaviorRelay<PackageService> create = BehaviorRelay.create();
        this.c = create;
        BehaviorRelay<SingleFeeService> create2 = BehaviorRelay.create();
        this.d = create2;
        BehaviorRelay<List<VasService>> create3 = BehaviorRelay.create();
        this.e = create3;
        BehaviorRelay<List<VasService>> create4 = BehaviorRelay.create();
        this.f = create4;
        Observable<List<VasService>> combineLatest = Observable.combineLatest(create3, create4, a.a);
        Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…> firstVas + secondVas })");
        this.g = combineLatest;
        Intrinsics.checkNotNullExpressionValue(create, "packageRelay");
        this.h = create;
        Intrinsics.checkNotNullExpressionValue(create2, "singleFeeRelay");
        this.i = create2;
        if (list != null) {
            restoreSelection(list);
        }
    }

    @Override // com.avito.android.basket_legacy.repositories.BasketRepository
    public void addFirstStepVas(@NotNull VasService vasService) {
        Intrinsics.checkNotNullParameter(vasService, "vas");
        this.e.accept(d.listOf(vasService));
    }

    @Override // com.avito.android.basket_legacy.repositories.BasketRepository
    public void addPackage(@NotNull PackageService packageService) {
        Intrinsics.checkNotNullParameter(packageService, "ownedPackage");
        this.c.accept(packageService);
    }

    @Override // com.avito.android.basket_legacy.repositories.BasketRepository
    public void addSecondStepVas(@NotNull List<VasService> list) {
        Intrinsics.checkNotNullParameter(list, "vasList");
        this.f.accept(list);
    }

    @Override // com.avito.android.basket_legacy.repositories.BasketRepository
    public void addSingleFee(@NotNull SingleFeeService singleFeeService) {
        Intrinsics.checkNotNullParameter(singleFeeService, "singleFee");
        this.d.accept(singleFeeService);
    }

    @Override // com.avito.android.basket_legacy.repositories.BasketRepository
    public void addVas(@NotNull VasService vasService) {
        Intrinsics.checkNotNullParameter(vasService, "vas");
        addFirstStepVas(vasService);
    }

    public final boolean c(BehaviorRelay<List<VasService>> behaviorRelay, String str) {
        T t;
        List<VasService> value = behaviorRelay.getValue();
        if (value == null) {
            return false;
        }
        Iterator<T> it = value.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual(t.getSlug(), str)) {
                break;
            }
        }
        T t2 = t;
        if (t2 == null) {
            return false;
        }
        List<VasService> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) value);
        boolean remove = mutableList.remove(t2);
        behaviorRelay.accept(mutableList);
        return remove;
    }

    @Override // com.avito.android.basket_legacy.repositories.BasketRepository
    public void clearFirstStepVasSelection() {
        this.e.accept(CollectionsKt__CollectionsKt.emptyList());
    }

    @Override // com.avito.android.basket_legacy.repositories.BasketRepository
    public boolean getContainsLfPackage() {
        return this.c.hasValue();
    }

    @Override // com.avito.android.basket_legacy.repositories.BasketRepository
    public boolean getContainsListingFees() {
        return this.c.hasValue() || this.d.hasValue();
    }

    @Override // com.avito.android.basket_legacy.repositories.BasketRepository
    public boolean getContainsVas() {
        return this.e.hasValue() || this.f.hasValue();
    }

    @Override // com.avito.android.basket_legacy.repositories.BasketRepository
    @NotNull
    public Observable<PackageService> getLfPackageObservable() {
        return this.h;
    }

    @Override // com.avito.android.basket_legacy.repositories.BasketRepository
    @NotNull
    public List<PaidService> getSelectedServices() {
        ArrayList arrayList = new ArrayList();
        List<BehaviorRelay> listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new BehaviorRelay[]{this.e, this.f, this.c, this.d});
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(listOf, 10));
        for (BehaviorRelay behaviorRelay : listOf) {
            Intrinsics.checkNotNullExpressionValue(behaviorRelay, "it");
            arrayList2.add(behaviorRelay.getValue());
        }
        for (Object obj : arrayList2) {
            if (obj instanceof PaidService) {
                arrayList.add(obj);
            } else if (obj instanceof List) {
                for (Object obj2 : (Iterable) obj) {
                    if (obj2 instanceof PaidService) {
                        arrayList.add(obj2);
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.avito.android.basket_legacy.repositories.BasketRepository
    @NotNull
    public Observable<SingleFeeService> getSingleFeeObservable() {
        return this.i;
    }

    @Override // com.avito.android.basket_legacy.repositories.BasketRepository
    @NotNull
    public Observable<List<VasService>> getVasObservable() {
        return this.g;
    }

    @Override // com.avito.android.basket_legacy.repositories.BasketRepository
    public boolean isEmpty() {
        return !getContainsListingFees() && !getContainsVas();
    }

    @Override // com.avito.android.basket_legacy.repositories.BasketRepository
    public void removeVas(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        BehaviorRelay<List<VasService>> behaviorRelay = this.e;
        Intrinsics.checkNotNullExpressionValue(behaviorRelay, "firstStepVasRelay");
        if (!c(behaviorRelay, str)) {
            BehaviorRelay<List<VasService>> behaviorRelay2 = this.f;
            Intrinsics.checkNotNullExpressionValue(behaviorRelay2, "secondStepVasRelay");
            c(behaviorRelay2, str);
        }
    }

    @Override // com.avito.android.basket_legacy.repositories.BasketRepository
    public void restoreSelection(@NotNull List<? extends PaidService> list) {
        ArrayList i0 = a2.b.a.a.a.i0(list, "list");
        for (T t : list) {
            if (t instanceof VasService) {
                i0.add(t);
            } else if (t instanceof PackageService) {
                this.c.accept(t);
            } else if (t instanceof SingleFeeService) {
                this.d.accept(t);
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : i0) {
            if (((VasService) obj).getType() != VasType.VISUAL) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        this.e.accept((List) pair.component1());
        this.f.accept((List) pair.component2());
    }
}
