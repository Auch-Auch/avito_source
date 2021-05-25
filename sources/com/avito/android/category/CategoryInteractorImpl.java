package com.avito.android.category;

import android.text.TextUtils;
import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.DeepLinkResponse;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.MainSearchResult;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B+\b\u0007\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b#\u0010$J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lcom/avito/android/category/CategoryInteractorImpl;", "Lcom/avito/android/category/CategoryInteractor;", "Lcom/avito/android/remote/model/Location;", "location", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/MainSearchResult;", "loadMainSearch", "(Lcom/avito/android/remote/model/Location;)Lio/reactivex/rxjava3/core/Observable;", "", "categoryId", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/DeepLinkResponse;", "loadSerpDeeplink", "(Lcom/avito/android/remote/model/Location;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/category/CategoryInteractorState;", "getState", "()Lcom/avito/android/category/CategoryInteractorState;", "getLocation", "()Lcom/avito/android/remote/model/Location;", "Lcom/avito/android/remote/SearchApi;", "c", "Lcom/avito/android/remote/SearchApi;", "api", "Lcom/avito/android/remote/model/SearchParamsConverter;", "d", "Lcom/avito/android/remote/model/SearchParamsConverter;", "searchParamsConverter", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/Location;", "geolocation", "Lcom/avito/android/location/SavedLocationInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/location/SavedLocationInteractor;", "locationInteractor", "categoryInteractorState", "<init>", "(Lcom/avito/android/category/CategoryInteractorState;Lcom/avito/android/location/SavedLocationInteractor;Lcom/avito/android/remote/SearchApi;Lcom/avito/android/remote/model/SearchParamsConverter;)V", "category_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryInteractorImpl implements CategoryInteractor {
    public Location a;
    public final SavedLocationInteractor b;
    public final SearchApi c;
    public final SearchParamsConverter d;

    public static final class a<T, R> implements Function<Location, ObservableSource<? extends MainSearchResult>> {
        public final /* synthetic */ CategoryInteractorImpl a;

        public a(CategoryInteractorImpl categoryInteractorImpl) {
            this.a = categoryInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends MainSearchResult> apply(Location location) {
            Location location2 = location;
            this.a.a = location2;
            return this.a.c.getCategoriesSearch(location2.getId());
        }
    }

    @Inject
    public CategoryInteractorImpl(@Nullable CategoryInteractorState categoryInteractorState, @NotNull SavedLocationInteractor savedLocationInteractor, @NotNull SearchApi searchApi, @NotNull SearchParamsConverter searchParamsConverter) {
        Intrinsics.checkNotNullParameter(savedLocationInteractor, "locationInteractor");
        Intrinsics.checkNotNullParameter(searchApi, "api");
        Intrinsics.checkNotNullParameter(searchParamsConverter, "searchParamsConverter");
        this.b = savedLocationInteractor;
        this.c = searchApi;
        this.d = searchParamsConverter;
        this.a = categoryInteractorState != null ? categoryInteractorState.getLocation() : null;
    }

    @Override // com.avito.android.category.CategoryInteractor
    @Nullable
    public Location getLocation() {
        return this.a;
    }

    @Override // com.avito.android.category.CategoryInteractor
    @NotNull
    public CategoryInteractorState getState() {
        return new CategoryInteractorState(this.a);
    }

    @Override // com.avito.android.category.CategoryInteractor
    @NotNull
    public Observable<MainSearchResult> loadMainSearch(@Nullable Location location) {
        Observable observable;
        if (location != null) {
            observable = Observable.just(location);
            Intrinsics.checkNotNullExpressionValue(observable, "Observable.just(this)");
        } else {
            observable = SavedLocationInteractor.DefaultImpls.savedLocation$default(this.b, null, false, 3, null);
        }
        Observable<MainSearchResult> flatMap = observable.flatMap(new a(this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "locationObservable.flatM…esSearch(it.id)\n        }");
        return flatMap;
    }

    @Override // com.avito.android.category.CategoryInteractor
    @NotNull
    public Observable<TypedResult<DeepLinkResponse>> loadSerpDeeplink(@NotNull Location location, @Nullable String str) {
        Intrinsics.checkNotNullParameter(location, "location");
        SearchParams searchParams = new SearchParams(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null);
        if (!TextUtils.isEmpty(str)) {
            searchParams.setCategoryId(str);
        }
        searchParams.setLocationId(location.getId());
        return this.c.getSerpDeeplink(Boolean.FALSE, null, SearchParamsConverter.DefaultImpls.convertToMap$default(this.d, searchParams, null, false, false, 14, null));
    }
}
