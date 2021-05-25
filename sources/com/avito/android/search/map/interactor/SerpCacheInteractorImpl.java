package com.avito.android.search.map.interactor;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.serp.SerpItemProcessor;
import com.avito.android.serp.adapter.SerpCommercialBanner;
import com.avito.android.serp.adapter.SerpDataSource;
import com.avito.android.serp.adapter.SerpItemSaturator;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.avito.konveyor.data_source.ListDataSource;
import com.avito.konveyor.util.DataSources;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Function;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u00103\u001a\u000200\u0012\b\u00104\u001a\u0004\u0018\u00010\u0002\u0012\b\u00105\u001a\u0004\u0018\u00010\t\u0012\b\u00106\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b7\u00108J-\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJE\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J-\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u001f\u0010 R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010\"R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00190\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00069"}, d2 = {"Lcom/avito/android/search/map/interactor/SerpCacheInteractorImpl;", "Lcom/avito/android/search/map/interactor/SerpCacheInteractor;", "", "key", "", "columns", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/search/map/interactor/SerpDataSources;", "getElements", "(Ljava/lang/String;ILcom/avito/android/remote/model/SerpDisplayType;)Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/remote/model/SerpElement;", MessengerShareContentUtility.ELEMENTS, "subscriptionId", "appendElements", "(Ljava/lang/String;Ljava/util/List;ILcom/avito/android/remote/model/SerpDisplayType;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", VKApiConst.POSITION, "Lio/reactivex/rxjava3/core/Completable;", "removeAtPosition", "(Ljava/lang/String;I)Lio/reactivex/rxjava3/core/Completable;", "recalculatePositions", "Lcom/avito/android/serp/adapter/SerpCommercialBanner;", "adBanner", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "replaceAds", "(Lcom/avito/android/serp/adapter/SerpCommercialBanner;Ljava/lang/String;Lcom/avito/android/remote/model/SerpDisplayType;)Lio/reactivex/rxjava3/core/Observable;", "getSubscriptionId", "(Ljava/lang/String;)Ljava/lang/String;", "", "setSubscriptionId", "(Ljava/lang/String;Ljava/lang/String;)V", "d", "Ljava/lang/String;", "Lcom/avito/android/serp/SerpItemProcessor;", "e", "Lcom/avito/android/serp/SerpItemProcessor;", "itemProcessor", AuthSource.BOOKING_ORDER, "lastKey", "c", "Ljava/util/List;", "items", "", AuthSource.SEND_ABUSE, "Z", "needSort", "Lcom/avito/android/serp/adapter/SerpItemSaturator;", "f", "Lcom/avito/android/serp/adapter/SerpItemSaturator;", "saturator", "initKey", "initDataSources", "initSubscriptionId", "<init>", "(Lcom/avito/android/serp/SerpItemProcessor;Lcom/avito/android/serp/adapter/SerpItemSaturator;Ljava/lang/String;Lcom/avito/android/search/map/interactor/SerpDataSources;Ljava/lang/String;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class SerpCacheInteractorImpl implements SerpCacheInteractor {
    public boolean a;
    public String b;
    public List<? extends ViewTypeSerpItem> c;
    public String d;
    public final SerpItemProcessor e;
    public final SerpItemSaturator f;

    public static final class a<V> implements Callable<SerpDataSources> {
        public final /* synthetic */ SerpCacheInteractorImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ List c;
        public final /* synthetic */ int d;
        public final /* synthetic */ SerpDisplayType e;
        public final /* synthetic */ String f;

        public a(SerpCacheInteractorImpl serpCacheInteractorImpl, String str, List list, int i, SerpDisplayType serpDisplayType, String str2) {
            this.a = serpCacheInteractorImpl;
            this.b = str;
            this.c = list;
            this.d = i;
            this.e = serpDisplayType;
            this.f = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public SerpDataSources call() {
            return SerpCacheInteractorImpl.access$appendElementsSync(this.a, this.b, this.c, this.d, this.e, this.f);
        }
    }

    public static final class b<V> implements Callable<SerpDataSources> {
        public final /* synthetic */ SerpCacheInteractorImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ SerpDisplayType d;

        public b(SerpCacheInteractorImpl serpCacheInteractorImpl, String str, int i, SerpDisplayType serpDisplayType) {
            this.a = serpCacheInteractorImpl;
            this.b = str;
            this.c = i;
            this.d = serpDisplayType;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public SerpDataSources call() {
            return SerpCacheInteractorImpl.access$getElementsSync(this.a, this.b, this.c, this.d);
        }
    }

    public static final class c implements Action {
        public final /* synthetic */ SerpCacheInteractorImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        public c(SerpCacheInteractorImpl serpCacheInteractorImpl, String str, int i) {
            this.a = serpCacheInteractorImpl;
            this.b = str;
            this.c = i;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            SerpCacheInteractorImpl.access$recalculatePositionsSync(this.a, this.b, this.c);
        }
    }

    public static final class d implements Action {
        public final /* synthetic */ SerpCacheInteractorImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        public d(SerpCacheInteractorImpl serpCacheInteractorImpl, String str, int i) {
            this.a = serpCacheInteractorImpl;
            this.b = str;
            this.c = i;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            SerpCacheInteractorImpl.access$removeAtPositionSync(this.a, this.b, this.c);
        }
    }

    public static final class e<V> implements Callable<ViewTypeSerpItem> {
        public final /* synthetic */ SerpCacheInteractorImpl a;
        public final /* synthetic */ SerpCommercialBanner b;
        public final /* synthetic */ SerpDisplayType c;

        public e(SerpCacheInteractorImpl serpCacheInteractorImpl, SerpCommercialBanner serpCommercialBanner, SerpDisplayType serpDisplayType) {
            this.a = serpCacheInteractorImpl;
            this.b = serpCommercialBanner;
            this.c = serpDisplayType;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public ViewTypeSerpItem call() {
            return SerpCacheInteractorImpl.access$replaceAdsSync(this.a, this.b, this.c);
        }
    }

    public static final class f<T, R> implements Function<Throwable, ObservableSource<? extends ViewTypeSerpItem>> {
        public static final f a = new f();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends ViewTypeSerpItem> apply(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "<anonymous parameter 0>");
            return Observable.empty();
        }
    }

    public SerpCacheInteractorImpl(@NotNull SerpItemProcessor serpItemProcessor, @NotNull SerpItemSaturator serpItemSaturator, @Nullable String str, @Nullable SerpDataSources serpDataSources, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(serpItemProcessor, "itemProcessor");
        Intrinsics.checkNotNullParameter(serpItemSaturator, "saturator");
        this.e = serpItemProcessor;
        this.f = serpItemSaturator;
        this.d = str2;
        if (str == null || serpDataSources == null) {
            this.a = false;
            this.b = "";
            this.c = CollectionsKt__CollectionsKt.emptyList();
            return;
        }
        this.a = true;
        this.b = str;
        this.c = CollectionsKt___CollectionsKt.toList(DataSources.toIterableDataSource(serpDataSources.getSerpItems()));
    }

    public static final SerpDataSources access$appendElementsSync(SerpCacheInteractorImpl serpCacheInteractorImpl, String str, List list, int i, SerpDisplayType serpDisplayType, String str2) {
        SerpDataSources serpDataSources;
        synchronized (serpCacheInteractorImpl) {
            List<? extends ViewTypeSerpItem> list2 = serpCacheInteractorImpl.c;
            if (!Intrinsics.areEqual(str, serpCacheInteractorImpl.b)) {
                serpCacheInteractorImpl.b = str;
                list2 = CollectionsKt__CollectionsKt.emptyList();
                serpCacheInteractorImpl.c = list2;
                serpCacheInteractorImpl.d = str2;
            }
            List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list2);
            mutableList.addAll(serpCacheInteractorImpl.e.convertSync(list, serpDisplayType));
            List<? extends ViewTypeSerpItem> sortAndAdjustSync = serpCacheInteractorImpl.e.sortAndAdjustSync(mutableList, i);
            serpCacheInteractorImpl.c = sortAndAdjustSync;
            serpCacheInteractorImpl.a = false;
            serpDataSources = new SerpDataSources(new ListDataSource(sortAndAdjustSync), new SerpDataSource(sortAndAdjustSync, serpCacheInteractorImpl.f, serpDisplayType));
        }
        return serpDataSources;
    }

    public static final SerpDataSources access$getElementsSync(SerpCacheInteractorImpl serpCacheInteractorImpl, String str, int i, SerpDisplayType serpDisplayType) {
        SerpDataSources serpDataSources;
        synchronized (serpCacheInteractorImpl) {
            List<? extends ViewTypeSerpItem> list = serpCacheInteractorImpl.c;
            if (!Intrinsics.areEqual(str, serpCacheInteractorImpl.b)) {
                serpCacheInteractorImpl.b = str;
                list = CollectionsKt__CollectionsKt.emptyList();
                serpCacheInteractorImpl.c = list;
            }
            List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
            if (serpCacheInteractorImpl.a) {
                mutableList = serpCacheInteractorImpl.e.sortAndAdjustSync(mutableList, i);
                serpCacheInteractorImpl.a = false;
            }
            serpDataSources = new SerpDataSources(new ListDataSource(mutableList), new SerpDataSource(mutableList, serpCacheInteractorImpl.f, serpDisplayType));
        }
        return serpDataSources;
    }

    public static final void access$recalculatePositionsSync(SerpCacheInteractorImpl serpCacheInteractorImpl, String str, int i) {
        synchronized (serpCacheInteractorImpl) {
            List<? extends ViewTypeSerpItem> list = serpCacheInteractorImpl.c;
            if (!Intrinsics.areEqual(str, serpCacheInteractorImpl.b)) {
                serpCacheInteractorImpl.b = str;
                list = CollectionsKt__CollectionsKt.emptyList();
                serpCacheInteractorImpl.c = list;
            }
            serpCacheInteractorImpl.c = serpCacheInteractorImpl.e.sortAndAdjustSync(CollectionsKt___CollectionsKt.toMutableList((Collection) list), i);
            serpCacheInteractorImpl.a = false;
        }
    }

    public static final void access$removeAtPositionSync(SerpCacheInteractorImpl serpCacheInteractorImpl, String str, int i) {
        synchronized (serpCacheInteractorImpl) {
            List<? extends ViewTypeSerpItem> list = serpCacheInteractorImpl.c;
            if (!Intrinsics.areEqual(str, serpCacheInteractorImpl.b)) {
                serpCacheInteractorImpl.b = str;
                list = CollectionsKt__CollectionsKt.emptyList();
                serpCacheInteractorImpl.c = list;
                serpCacheInteractorImpl.d = null;
            }
            if (list.size() > i) {
                List<? extends ViewTypeSerpItem> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
                mutableList.remove(i);
                serpCacheInteractorImpl.c = mutableList;
                serpCacheInteractorImpl.a = true;
            }
        }
    }

    public static final ViewTypeSerpItem access$replaceAdsSync(SerpCacheInteractorImpl serpCacheInteractorImpl, SerpCommercialBanner serpCommercialBanner, SerpDisplayType serpDisplayType) {
        ViewTypeSerpItem viewTypeSerpItem;
        synchronized (serpCacheInteractorImpl) {
            viewTypeSerpItem = (ViewTypeSerpItem) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) serpCacheInteractorImpl.e.convertSync(t6.n.d.listOf(serpCommercialBanner), serpDisplayType));
            if (viewTypeSerpItem != null) {
                List<? extends ViewTypeSerpItem> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) serpCacheInteractorImpl.c);
                Integer num = null;
                int i = 0;
                for (T t : mutableList) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    T t2 = t;
                    if (t2.getId() == viewTypeSerpItem.getId() && (t2 instanceof SerpCommercialBanner) && t2.getHasNotLoadedAd()) {
                        num = Integer.valueOf(i);
                    }
                    i = i2;
                }
                if (num != null) {
                    mutableList.set(num.intValue(), viewTypeSerpItem);
                    serpCacheInteractorImpl.c = mutableList;
                }
            } else {
                throw new NullPointerException("Ad banner (" + serpCommercialBanner + " with network banner " + serpCommercialBanner.getCommercialBanner() + ") converted to null");
            }
        }
        return viewTypeSerpItem;
    }

    @Override // com.avito.android.search.map.interactor.SerpCacheInteractor
    @NotNull
    public Observable<SerpDataSources> appendElements(@NotNull String str, @NotNull List<? extends SerpElement> list, int i, @NotNull SerpDisplayType serpDisplayType, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(list, MessengerShareContentUtility.ELEMENTS);
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Observable<SerpDataSources> fromCallable = Observable.fromCallable(new a(this, str, list, i, serpDisplayType, str2));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Observable.fromCallable …subscriptionId)\n        }");
        return fromCallable;
    }

    @Override // com.avito.android.search.map.interactor.SerpCacheInteractor
    @NotNull
    public Observable<SerpDataSources> getElements(@NotNull String str, int i, @NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Observable<SerpDataSources> fromCallable = Observable.fromCallable(new b(this, str, i, serpDisplayType));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Observable.fromCallable …s, displayType)\n        }");
        return fromCallable;
    }

    @Override // com.avito.android.search.map.interactor.SerpCacheInteractor
    @Nullable
    public String getSubscriptionId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (Intrinsics.areEqual(str, this.b)) {
            return this.d;
        }
        return null;
    }

    @Override // com.avito.android.search.map.interactor.SerpCacheInteractor
    @NotNull
    public Completable recalculatePositions(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        Completable fromAction = Completable.fromAction(new c(this, str, i));
        Intrinsics.checkNotNullExpressionValue(fromAction, "Completable.fromAction {…c(key, columns)\n        }");
        return fromAction;
    }

    @Override // com.avito.android.search.map.interactor.SerpCacheInteractor
    @NotNull
    public Completable removeAtPosition(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        Completable fromAction = Completable.fromAction(new d(this, str, i));
        Intrinsics.checkNotNullExpressionValue(fromAction, "Completable.fromAction {…(key, position)\n        }");
        return fromAction;
    }

    @Override // com.avito.android.search.map.interactor.SerpCacheInteractor
    @NotNull
    public Observable<ViewTypeSerpItem> replaceAds(@NotNull SerpCommercialBanner serpCommercialBanner, @NotNull String str, @NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpCommercialBanner, "adBanner");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        if (Intrinsics.areEqual(str, this.b)) {
            Observable<ViewTypeSerpItem> onErrorResumeNext = Observable.fromCallable(new e(this, serpCommercialBanner, serpDisplayType)).onErrorResumeNext(f.a);
            Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "Observable.fromCallable …SerpItem>()\n            }");
            return onErrorResumeNext;
        }
        Observable<ViewTypeSerpItem> empty = Observable.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Observable.empty()");
        return empty;
    }

    @Override // com.avito.android.search.map.interactor.SerpCacheInteractor
    public void setSubscriptionId(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (Intrinsics.areEqual(str, this.b)) {
            this.d = str2;
        }
    }
}
