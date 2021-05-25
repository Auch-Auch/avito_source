package com.avito.android.shop.list.business;

import a2.g.r.g;
import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.LinkAction;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.ShopsListResult;
import com.avito.android.remote.model.Shortcuts;
import com.avito.android.remote.shop.filter.ShopsSearchParameters;
import com.avito.android.shop.list.di.ShopListModule;
import com.avito.android.shop.remote.ShopsApi;
import com.avito.android.util.CompressedParcelable;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.UrlParams;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001BM\b\u0007\u0012\u0006\u0010W\u001a\u00020T\u0012\u0006\u0010B\u001a\u00020?\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u0010.\u001a\u00020+\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u0010H\u001a\u00020E\u0012\u0006\u0010&\u001a\u00020#\u0012\n\b\u0001\u0010Z\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b[\u0010\\J+\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00070\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00070\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u0010J_\u0010\u001f\u001aH\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0011 \u001d*\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00070\u0007 \u001d*#\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0011 \u001d*\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00070\u0007\u0018\u00010\u0006¢\u0006\u0002\b\u001e0\u0006¢\u0006\u0002\b\u001e*\b\u0012\u0004\u0012\u00020\u001c0\u0006H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002¢\u0006\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u001e\u00106\u001a\n\u0012\u0004\u0012\u000204\u0018\u0001038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u00105R\u001c\u0010:\u001a\b\u0012\u0004\u0012\u000208078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u00105R$\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010S\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u001c\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00110\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bX\u0010\u0013¨\u0006]"}, d2 = {"Lcom/avito/android/shop/list/business/ShopListInteractorImpl;", "Lcom/avito/android/shop/list/business/ShopListInteractor;", "Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;", "searchParameters", "", "loadNextPage", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/shop/list/business/ShopListInfo;", "getShops", "(Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;Z)Lio/reactivex/rxjava3/core/Observable;", "", "invalidate", "()V", "clearError", "canLoadMore", "()Z", "Lcom/avito/android/shop/list/business/ShopLocation;", "getLocationInfo", "()Lio/reactivex/rxjava3/core/Observable;", "", "locationId", "getLocationInfoById", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/Kundle;", "saveState", "()Lcom/avito/android/util/Kundle;", "hasCachedData", "Lcom/avito/android/remote/model/Location;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.BOOKING_ORDER, "(Lio/reactivex/rxjava3/core/Observable;)Lio/reactivex/rxjava3/core/Observable;", AuthSource.SEND_ABUSE, "()Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/util/SchedulersFactory3;", "n", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/shop/list/business/ShopListResultConverter;", "l", "Lcom/avito/android/shop/list/business/ShopListResultConverter;", "resultConverter", "Lcom/avito/android/shop/list/business/ShopSearchParamsConverter;", "k", "Lcom/avito/android/shop/list/business/ShopSearchParamsConverter;", "paramsConverter", "Lcom/avito/android/location/SavedLocationInteractor;", "j", "Lcom/avito/android/location/SavedLocationInteractor;", "locationInteractor", "", "Lcom/avito/android/remote/model/ShopsListResult$Shop;", "Ljava/util/List;", "cachedShops", "", "Lcom/avito/android/remote/model/LinkAction;", "c", "cachedActions", "", "e", "Ljava/util/Map;", "cachedFirebaseParams", "Lcom/avito/android/remote/LocationApi;", "i", "Lcom/avito/android/remote/LocationApi;", "locationApi", "Z", "lastPageEmpty", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/remote/model/Shortcuts;", "d", "Lcom/avito/android/remote/model/Shortcuts;", "cachedShortcuts", "Lcom/avito/android/remote/error/TypedError;", "f", "Lcom/avito/android/remote/error/TypedError;", "cachedError", g.a, "Ljava/lang/String;", UrlParams.LAST_STAMP, "Lcom/avito/android/shop/remote/ShopsApi;", "h", "Lcom/avito/android/shop/remote/ShopsApi;", "api", "getLocationChanges", "locationChanges", "state", "<init>", "(Lcom/avito/android/shop/remote/ShopsApi;Lcom/avito/android/remote/LocationApi;Lcom/avito/android/location/SavedLocationInteractor;Lcom/avito/android/shop/list/business/ShopSearchParamsConverter;Lcom/avito/android/shop/list/business/ShopListResultConverter;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/util/Kundle;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopListInteractorImpl implements ShopListInteractor {
    public boolean a;
    public List<ShopsListResult.Shop> b;
    public List<LinkAction> c = CollectionsKt__CollectionsKt.emptyList();
    public Shortcuts d;
    public Map<String, String> e;
    public TypedError f;
    public String g;
    public final ShopsApi h;
    public final LocationApi i;
    public final SavedLocationInteractor j;
    public final ShopSearchParamsConverter k;
    public final ShopListResultConverter l;
    public final TypedErrorThrowableConverter m;
    public final SchedulersFactory3 n;

    public static final class a<V> implements Callable<Boolean> {
        public final /* synthetic */ ShopListInteractorImpl a;

        public a(ShopListInteractorImpl shopListInteractorImpl) {
            this.a = shopListInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            return Boolean.valueOf(this.a.f == null);
        }
    }

    public static final class b<T, R> implements Function<Boolean, ObservableSource<? extends LoadingState<? super ShopListInfo>>> {
        public final /* synthetic */ ShopListInteractorImpl a;
        public final /* synthetic */ ShopsSearchParameters b;
        public final /* synthetic */ boolean c;

        public b(ShopListInteractorImpl shopListInteractorImpl, ShopsSearchParameters shopsSearchParameters, boolean z) {
            this.a = shopListInteractorImpl;
            this.b = shopsSearchParameters;
            this.c = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends LoadingState<? super ShopListInfo>> apply(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "noError");
            if (bool2.booleanValue()) {
                return ShopListInteractorImpl.access$loadShops(this.a, this.b, this.c);
            }
            TypedError typedError = this.a.f;
            Intrinsics.checkNotNull(typedError);
            return Observable.just(new LoadingState.Error(typedError));
        }
    }

    public static final class c<T, R> implements Function<Unit, ObservableSource<? extends Location>> {
        public final /* synthetic */ ShopListInteractorImpl a;

        public c(ShopListInteractorImpl shopListInteractorImpl) {
            this.a = shopListInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends Location> apply(Unit unit) {
            return SavedLocationInteractor.DefaultImpls.savedLocation$default(this.a.j, null, false, 3, null);
        }
    }

    public static final class d<T, R> implements Function<Location, ShopLocation> {
        public final /* synthetic */ ShopListInteractorImpl a;

        public d(ShopListInteractorImpl shopListInteractorImpl) {
            this.a = shopListInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ShopLocation apply(Location location) {
            Location location2 = location;
            ShopListResultConverter shopListResultConverter = this.a.l;
            Intrinsics.checkNotNullExpressionValue(location2, "it");
            return shopListResultConverter.convertLocation(location2);
        }
    }

    public static final class e<T, R> implements Function<Location, LoadingState<? super ShopLocation>> {
        public final /* synthetic */ ShopListInteractorImpl a;

        public e(ShopListInteractorImpl shopListInteractorImpl) {
            this.a = shopListInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super ShopLocation> apply(Location location) {
            Location location2 = location;
            ShopListResultConverter shopListResultConverter = this.a.l;
            Intrinsics.checkNotNullExpressionValue(location2, "it");
            return new LoadingState.Loaded(shopListResultConverter.convertLocation(location2));
        }
    }

    public static final class f<T, R> implements Function<Throwable, LoadingState<? super ShopLocation>> {
        public final /* synthetic */ ShopListInteractorImpl a;

        public f(ShopListInteractorImpl shopListInteractorImpl) {
            this.a = shopListInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super ShopLocation> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.m;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    @Inject
    public ShopListInteractorImpl(@NotNull ShopsApi shopsApi, @NotNull LocationApi locationApi, @NotNull SavedLocationInteractor savedLocationInteractor, @NotNull ShopSearchParamsConverter shopSearchParamsConverter, @NotNull ShopListResultConverter shopListResultConverter, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull SchedulersFactory3 schedulersFactory3, @ShopListModule.InteractorState @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(shopsApi, "api");
        Intrinsics.checkNotNullParameter(locationApi, "locationApi");
        Intrinsics.checkNotNullParameter(savedLocationInteractor, "locationInteractor");
        Intrinsics.checkNotNullParameter(shopSearchParamsConverter, "paramsConverter");
        Intrinsics.checkNotNullParameter(shopListResultConverter, "resultConverter");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.h = shopsApi;
        this.i = locationApi;
        this.j = savedLocationInteractor;
        this.k = shopSearchParamsConverter;
        this.l = shopListResultConverter;
        this.m = typedErrorThrowableConverter;
        this.n = schedulersFactory3;
        if (kundle != null) {
            CompressedParcelable compressedParcelable = (CompressedParcelable) kundle.getParcelable("cached_data");
            ShopListInfo shopListInfo = compressedParcelable != null ? (ShopListInfo) compressedParcelable.restore(ShopListInfo.class) : null;
            if (shopListInfo != null) {
                this.b = CollectionsKt___CollectionsKt.toMutableList((Collection) shopListInfo.getShopList());
                this.c = shopListInfo.getShopActions();
                this.d = shopListInfo.getShortcuts();
                this.e = shopListInfo.getFirebaseParams();
            }
            this.g = kundle.getString("last_stamp");
            this.a = kundle.getBoolean("last_page_empty", false);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004f, code lost:
        if (r0 != null) goto L_0x005e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final io.reactivex.rxjava3.core.Observable access$loadShops(com.avito.android.shop.list.business.ShopListInteractorImpl r7, com.avito.android.remote.shop.filter.ShopsSearchParameters r8, boolean r9) {
        /*
            java.util.List<com.avito.android.remote.model.ShopsListResult$Shop> r0 = r7.b
            r1 = 0
            if (r0 == 0) goto L_0x000a
            java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r0)
            goto L_0x000b
        L_0x000a:
            r0 = r1
        L_0x000b:
            if (r9 != 0) goto L_0x001f
            if (r0 != 0) goto L_0x0010
            goto L_0x001f
        L_0x0010:
            com.avito.android.util.LoadingState r7 = r7.a()
            io.reactivex.rxjava3.core.Observable r7 = io.reactivex.rxjava3.core.Observable.just(r7)
            java.lang.String r8 = "Observable.just(cachedResult())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            goto L_0x009d
        L_0x001f:
            com.avito.android.shop.remote.ShopsApi r0 = r7.h
            java.lang.String r9 = r8.getQuery()
            java.lang.String r2 = r8.getLocationId()
            java.lang.String r3 = r8.getCategoryId()
            java.lang.String r4 = r7.g
            java.util.List<com.avito.android.remote.model.ShopsListResult$Shop> r5 = r7.b
            if (r5 == 0) goto L_0x003b
            int r1 = r5.size()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x003b:
            r6 = r1
            r5 = 0
            r1 = r9
            io.reactivex.rxjava3.core.Observable r9 = r0.getShops(r1, r2, r3, r4, r5, r6)
            com.avito.android.remote.model.Shortcuts r0 = r7.d
            if (r0 == 0) goto L_0x0052
            io.reactivex.rxjava3.core.Observable r0 = io.reactivex.rxjava3.core.Observable.just(r0)
            java.lang.String r1 = "Observable.just(this)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            if (r0 == 0) goto L_0x0052
            goto L_0x005e
        L_0x0052:
            com.avito.android.shop.remote.ShopsApi r0 = r7.h
            com.avito.android.shop.list.business.ShopSearchParamsConverter r1 = r7.k
            java.util.Map r8 = r1.convertToMap(r8)
            io.reactivex.rxjava3.core.Observable r0 = r0.getShopsShortcuts(r8)
        L_0x005e:
            com.avito.android.shop.list.business.ShopListInteractorImpl$loadFromNetwork$$inlined$zip$1 r8 = new com.avito.android.shop.list.business.ShopListInteractorImpl$loadFromNetwork$$inlined$zip$1
            r8.<init>()
            io.reactivex.rxjava3.core.Observable r8 = io.reactivex.rxjava3.core.Observable.zip(r9, r0, r8)
            java.lang.String r9 = "Observable.zip(source1, …ombineFunction(t1, t2) })"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r9)
            com.avito.android.util.SchedulersFactory3 r9 = r7.n
            io.reactivex.rxjava3.core.Scheduler r9 = r9.io()
            io.reactivex.rxjava3.core.Observable r8 = r8.subscribeOn(r9)
            com.avito.android.util.SchedulersFactory3 r9 = r7.n
            io.reactivex.rxjava3.core.Scheduler r9 = r9.mainThread()
            io.reactivex.rxjava3.core.Observable r8 = r8.observeOn(r9)
            a2.a.a.s2.d.a.a r9 = new a2.a.a.s2.d.a.a
            r9.<init>(r7)
            io.reactivex.rxjava3.core.Observable r8 = r8.map(r9)
            a2.a.a.s2.d.a.b r9 = new a2.a.a.s2.d.a.b
            r9.<init>(r7)
            io.reactivex.rxjava3.core.Observable r7 = r8.onErrorReturn(r9)
            com.avito.android.util.LoadingState$Loading r8 = com.avito.android.util.LoadingState.Loading.INSTANCE
            io.reactivex.rxjava3.core.Observable r7 = r7.startWithItem(r8)
            java.lang.String r8 = "zip(\n            loadSho…tem(LoadingState.Loading)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
        L_0x009d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.shop.list.business.ShopListInteractorImpl.access$loadShops(com.avito.android.shop.list.business.ShopListInteractorImpl, com.avito.android.remote.shop.filter.ShopsSearchParameters, boolean):io.reactivex.rxjava3.core.Observable");
    }

    public static final void access$saveResults(ShopListInteractorImpl shopListInteractorImpl, ShopsListResult shopsListResult, Shortcuts shortcuts) {
        Objects.requireNonNull(shopListInteractorImpl);
        shopListInteractorImpl.a = shopsListResult.getElements().isEmpty();
        List<ShopsListResult.Shop> convertShops = shopListInteractorImpl.l.convertShops(shopsListResult.getElements());
        if (shopListInteractorImpl.b == null) {
            shopListInteractorImpl.b = new ArrayList();
        }
        List<ShopsListResult.Shop> list = shopListInteractorImpl.b;
        Intrinsics.checkNotNull(list);
        list.addAll(convertShops);
        List<LinkAction> actions = shopsListResult.getActions();
        if (actions == null) {
            actions = CollectionsKt__CollectionsKt.emptyList();
        }
        shopListInteractorImpl.c = actions;
        shopListInteractorImpl.e = shopsListResult.getFirebaseParams();
        shopListInteractorImpl.g = shopsListResult.getLastStamp();
        shopListInteractorImpl.d = shortcuts;
    }

    public final LoadingState<ShopListInfo> a() {
        List<ShopsListResult.Shop> list = this.b;
        Intrinsics.checkNotNull(list);
        List list2 = CollectionsKt___CollectionsKt.toList(list);
        List<LinkAction> list3 = this.c;
        Shortcuts shortcuts = this.d;
        if (shortcuts == null) {
            shortcuts = new Shortcuts(CollectionsKt__CollectionsKt.emptyList(), null);
        }
        return new LoadingState.Loaded(new ShopListInfo(list2, list3, shortcuts, this.e));
    }

    public final Observable<LoadingState<ShopLocation>> b(Observable<Location> observable) {
        return observable.map(new e(this)).onErrorReturn(new f(this)).startWithItem((R) LoadingState.Loading.INSTANCE);
    }

    @Override // com.avito.android.shop.list.business.ShopListInteractor
    public boolean canLoadMore() {
        return !this.a;
    }

    @Override // com.avito.android.shop.list.business.ShopListInteractor
    public void clearError() {
        this.f = null;
    }

    @Override // com.avito.android.shop.list.business.ShopListInteractor
    @NotNull
    public Observable<ShopLocation> getLocationChanges() {
        return a2.b.a.a.a.a2(this.n, this.j.getOnLocationChanged().flatMap(new c(this)).map(new d(this)), "locationInteractor.onLoc…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.shop.list.business.ShopListInteractor
    @NotNull
    public Observable<LoadingState<ShopLocation>> getLocationInfo() {
        return a2.b.a.a.a.a2(this.n, b(SavedLocationInteractor.DefaultImpls.savedLocation$default(this.j, null, false, 3, null)), "locationInteractor.saved…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.shop.list.business.ShopListInteractor
    @NotNull
    public Observable<LoadingState<ShopLocation>> getLocationInfoById(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "locationId");
        return a2.b.a.a.a.a2(this.n, b(this.i.getLocation(str)), "locationApi.getLocation(…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.shop.list.business.ShopListInteractor
    @NotNull
    public Observable<LoadingState<ShopListInfo>> getShops(@NotNull ShopsSearchParameters shopsSearchParameters, boolean z) {
        Intrinsics.checkNotNullParameter(shopsSearchParameters, "searchParameters");
        Observable<LoadingState<ShopListInfo>> subscribeOn = Observable.fromCallable(new a(this)).flatMap(new b(this, shopsSearchParameters, z)).subscribeOn(this.n.mainThread());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "Observable\n            .…(schedulers.mainThread())");
        return subscribeOn;
    }

    @Override // com.avito.android.shop.list.business.ShopListInteractor
    public boolean hasCachedData() {
        return this.b != null;
    }

    @Override // com.avito.android.shop.list.business.ShopListInteractor
    public void invalidate() {
        this.b = null;
        this.c = CollectionsKt__CollectionsKt.emptyList();
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.a = false;
    }

    @Override // com.avito.android.shop.list.business.ShopListInteractor
    @NotNull
    public Kundle saveState() {
        List<ShopsListResult.Shop> list = this.b;
        List list2 = list != null ? CollectionsKt___CollectionsKt.toList(list) : null;
        if (list2 == null) {
            return new Kundle();
        }
        Kundle kundle = new Kundle();
        List<LinkAction> list3 = this.c;
        Shortcuts shortcuts = this.d;
        if (shortcuts == null) {
            shortcuts = new Shortcuts(CollectionsKt__CollectionsKt.emptyList(), null);
        }
        kundle.putParcelable("cached_data", new CompressedParcelable(new ShopListInfo(list2, list3, shortcuts, this.e)));
        kundle.putString("last_stamp", this.g);
        kundle.putBoolean("last_page_empty", Boolean.valueOf(this.a));
        return kundle;
    }
}
