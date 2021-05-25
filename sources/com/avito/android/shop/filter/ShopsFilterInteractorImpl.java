package com.avito.android.shop.filter;

import a2.a.a.s2.c.b;
import a2.b.a.a.a;
import com.avito.android.CategoriesInteractor;
import com.avito.android.Features;
import com.avito.android.TopLocationInteractor;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Category;
import com.avito.android.remote.model.Location;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.funktionale.option.Option;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/shop/filter/ShopsFilterInteractorImpl;", "Lcom/avito/android/shop/filter/ShopsFilterInteractor;", "", "locationId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/shop/filter/ShopsFilterData;", "loadShopsFilterData", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/CategoriesInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/CategoriesInteractor;", "categoriesInteractor", "Lcom/avito/android/remote/LocationApi;", "c", "Lcom/avito/android/remote/LocationApi;", "locationApi", "Lcom/avito/android/Features;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/Features;", "features", "Lcom/avito/android/util/SchedulersFactory3;", "e", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/TopLocationInteractor;", "d", "Lcom/avito/android/TopLocationInteractor;", "topLocationInteractor", "<init>", "(Lcom/avito/android/CategoriesInteractor;Lcom/avito/android/Features;Lcom/avito/android/remote/LocationApi;Lcom/avito/android/TopLocationInteractor;Lcom/avito/android/util/SchedulersFactory3;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopsFilterInteractorImpl implements ShopsFilterInteractor {
    public final CategoriesInteractor a;
    public final Features b;
    public final LocationApi c;
    public final TopLocationInteractor d;
    public final SchedulersFactory3 e;

    @Inject
    public ShopsFilterInteractorImpl(@NotNull CategoriesInteractor categoriesInteractor, @NotNull Features features, @NotNull LocationApi locationApi, @NotNull TopLocationInteractor topLocationInteractor, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(categoriesInteractor, "categoriesInteractor");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(locationApi, "locationApi");
        Intrinsics.checkNotNullParameter(topLocationInteractor, "topLocationInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        this.a = categoriesInteractor;
        this.b = features;
        this.c = locationApi;
        this.d = topLocationInteractor;
        this.e = schedulersFactory3;
    }

    public static final List access$sortCategories(ShopsFilterInteractorImpl shopsFilterInteractorImpl, List list) {
        Objects.requireNonNull(shopsFilterInteractorImpl);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (((Category) obj).getParentId() == null) {
                arrayList2.add(obj);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Category category = (Category) it.next();
            arrayList.add(category);
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : list) {
                if (Intrinsics.areEqual(category.getId(), ((Category) obj2).getParentId())) {
                    arrayList3.add(obj2);
                }
            }
            arrayList.addAll(arrayList3);
        }
        return arrayList;
    }

    @Override // com.avito.android.shop.filter.ShopsFilterInteractor
    @NotNull
    public Observable<ShopsFilterData> loadShopsFilterData(@Nullable String str) {
        Observable<Location> observable;
        Observable observable2;
        Observable<R> map = this.a.getCategories().subscribeOn(this.e.io()).map(new b(this));
        Intrinsics.checkNotNullExpressionValue(map, "categoriesInteractor.get…ap { sortCategories(it) }");
        if (this.b.getTopLocationSingleRequest().invoke().booleanValue()) {
            observable = this.d.getTopLocation();
        } else {
            observable = this.c.getTopLocation();
        }
        Observable a22 = a.a2(this.e, observable, "observable.subscribeOn(schedulersFactory.io())");
        if (str == null) {
            observable2 = Observable.just(Option.None.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(observable2, "Observable.just(Option.None)");
        } else {
            observable2 = a.a2(this.e, this.c.getLocation(str).map(a2.a.a.s2.c.a.a), "locationApi.getLocation(…n(schedulersFactory.io())");
        }
        Observable<ShopsFilterData> zip = Observable.zip(map, a22, observable2, new Function3<T1, T2, T3, R>() { // from class: com.avito.android.shop.filter.ShopsFilterInteractorImpl$loadShopsFilterData$$inlined$zip$1
            @Override // io.reactivex.rxjava3.functions.Function3
            @NotNull
            public final R apply(@NotNull T1 t1, @NotNull T2 t2, @NotNull T3 t3) {
                Intrinsics.checkParameterIsNotNull(t1, "t1");
                Intrinsics.checkParameterIsNotNull(t2, "t2");
                Intrinsics.checkParameterIsNotNull(t3, "t3");
                T3 t32 = t3;
                return (R) new ShopsFilterData(t1, t2, t32.isDefined() ? (Location) t32.get() : null);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zip, "Observable.zip(source1, …neFunction(t1, t2, t3) })");
        return zip;
    }
}
