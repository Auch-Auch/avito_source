package com.avito.android.similar_adverts;

import a2.g.r.g;
import android.content.Intent;
import android.os.SystemClock;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AdvertDetailsIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.clickstream.ScreenIdField;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.links.AdvertDetailsLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.rec.ScreenSource;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.section.SectionTypeElement;
import com.avito.android.remote.model.section.SectionTypeItem;
import com.avito.android.section.SectionItemConverter;
import com.avito.android.serp.adapter.AdvertItem;
import com.avito.android.serp.adapter.FavorableItem;
import com.avito.android.serp.adapter.PersistableSpannedItem;
import com.avito.android.serp.adapter.SpannedItem;
import com.avito.android.serp.adapter.skeleton.SkeletonItem;
import com.avito.android.similar_adverts.SimilarAdvertsViewModel;
import com.avito.android.similar_adverts.adapter.skeleton_title.SimilarSkeletonTitleItem;
import com.avito.android.similar_adverts.events.ClickOnSimilarAdvertEvent;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.konveyor.data_source.ListDataSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002BW\u0012\u0006\u0010H\u001a\u00020E\u0012\u0006\u0010L\u001a\u00020I\u0012\u0006\u0010\\\u001a\u00020Y\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u0010V\u001a\u00020S\u0012\u0006\u0010`\u001a\u00020]\u0012\u0006\u0010d\u001a\u00020a¢\u0006\u0004\be\u0010fJ)\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R(\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0&0%8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R$\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0%8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010)\u001a\u0004\b9\u0010+R\"\u0010A\u001a\b\u0012\u0004\u0012\u00020<0;8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\"\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00100;8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bB\u0010>\u001a\u0004\bC\u0010@R\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR$\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010M0%8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bN\u0010)\u001a\u0004\bO\u0010+R\u001c\u0010R\u001a\b\u0012\u0004\u0012\u00020<0;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010>R\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u001c\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00100;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010>R\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010d\u001a\u00020a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010c¨\u0006g"}, d2 = {"Lcom/avito/android/similar_adverts/SimilarAdvertsViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/similar_adverts/SimilarAdvertsViewModel;", "Lcom/avito/android/serp/adapter/AdvertItem;", "advert", "", VKApiConst.POSITION, "Lcom/avito/android/remote/model/Image;", "image", "", "onAdvertClicked", "(Lcom/avito/android/serp/adapter/AdvertItem;ILcom/avito/android/remote/model/Image;)V", "Lcom/avito/android/serp/adapter/FavorableItem;", "favorableItem", "onFavoriteButtonClicked", "(Lcom/avito/android/serp/adapter/FavorableItem;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onAdditionalActionClicked", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "followSectionDeepLink", "onCleared", "()V", "updateSimilarAdvertItems", "c", "Lcom/avito/android/ActivityIntentFactory;", VKApiConst.Q, "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lio/reactivex/rxjava3/disposables/Disposable;", "k", "Lio/reactivex/rxjava3/disposables/Disposable;", "loadSimilarDisposable", "Lcom/avito/android/similar_adverts/SimilarAdvertsInteractor;", "o", "Lcom/avito/android/similar_adverts/SimilarAdvertsInteractor;", "similarAdvertsInteractor", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/konveyor/data_source/ListDataSource;", "Lcom/avito/android/serp/adapter/SpannedItem;", "e", "Landroidx/lifecycle/MutableLiveData;", "getSimilarAdvertItems", "()Landroidx/lifecycle/MutableLiveData;", "similarAdvertItems", "Lcom/avito/android/remote/model/section/SectionTypeItem;", "j", "Lcom/avito/android/remote/model/section/SectionTypeItem;", "localSectionItem", "Lcom/avito/android/section/SectionItemConverter;", "p", "Lcom/avito/android/section/SectionItemConverter;", "similarAdvertsItemConverter", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "r", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoriteAdvertsPresenter", "getShowContentChanges", "showContentChanges", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Landroid/content/Intent;", "h", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getIntents", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "intents", "i", "getDeepLinks", "deepLinks", "", "l", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "", AuthSource.OPEN_CHANNEL_LIST, "Z", "isShop", "Ljava/lang/Runnable;", "d", "getErrorChanges", "errorChanges", g.a, "intentsLiveData", "Lcom/avito/android/similar_adverts/SimilarAdvertsResourceProvider;", "s", "Lcom/avito/android/similar_adverts/SimilarAdvertsResourceProvider;", "resourceProvider", "f", "deepLinksLiveData", "Lcom/avito/android/util/SchedulersFactory3;", "n", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/rec/ScreenSource;", "t", "Lcom/avito/android/rec/ScreenSource;", "screenSource", "Lcom/avito/android/analytics/Analytics;", "u", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Ljava/lang/String;ZLcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/similar_adverts/SimilarAdvertsInteractor;Lcom/avito/android/section/SectionItemConverter;Lcom/avito/android/ActivityIntentFactory;Lcom/avito/android/favorite/FavoriteAdvertsPresenter;Lcom/avito/android/similar_adverts/SimilarAdvertsResourceProvider;Lcom/avito/android/rec/ScreenSource;Lcom/avito/android/analytics/Analytics;)V", "similar-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class SimilarAdvertsViewModelImpl extends ViewModel implements SimilarAdvertsViewModel {
    @NotNull
    public final MutableLiveData<Unit> c = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Runnable> d = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<ListDataSource<SpannedItem>> e = new MutableLiveData<>();
    public final SingleLiveEvent<DeepLink> f;
    public final SingleLiveEvent<Intent> g;
    @NotNull
    public final SingleLiveEvent<Intent> h;
    @NotNull
    public final SingleLiveEvent<DeepLink> i;
    public SectionTypeItem j;
    public Disposable k;
    public final String l;
    public final boolean m;
    public final SchedulersFactory3 n;
    public final SimilarAdvertsInteractor o;
    public final SectionItemConverter p;
    public final ActivityIntentFactory q;
    public final FavoriteAdvertsPresenter r;
    public final SimilarAdvertsResourceProvider s;
    public final ScreenSource t;
    public final Analytics u;

    public static final class a<T, R> implements Function<List<? extends SectionTypeElement>, List<? extends SectionTypeItem>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public List<? extends SectionTypeItem> apply(List<? extends SectionTypeElement> list) {
            List<? extends SectionTypeElement> list2 = list;
            Intrinsics.checkNotNullExpressionValue(list2, "sections");
            ArrayList arrayList = new ArrayList();
            for (T t : list2) {
                if (t instanceof SectionTypeItem) {
                    arrayList.add(t);
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                String engine = ((SectionTypeItem) next).getEngine();
                Object obj = linkedHashMap.get(engine);
                if (obj == null) {
                    obj = new ArrayList();
                    linkedHashMap.put(engine, obj);
                }
                ((List) obj).add(next);
            }
            List<? extends SectionTypeItem> list3 = (List) linkedHashMap.get(Engine.SHOP_SIMILAR.getType());
            if (list3 == null) {
                list3 = (List) linkedHashMap.get(Engine.SIMILAR.getType());
            }
            if (list3 == null) {
                list3 = (List) linkedHashMap.get(Engine.SIMILAR_MP.getType());
            }
            if (list3 == null) {
                list3 = (List) linkedHashMap.get(Engine.MARKETPLACE.getType());
            }
            return list3 != null ? list3 : CollectionsKt__CollectionsKt.emptyList();
        }
    }

    public static final class b<T> implements Consumer<Disposable> {
        public final /* synthetic */ SimilarAdvertsViewModelImpl a;

        public b(SimilarAdvertsViewModelImpl similarAdvertsViewModelImpl) {
            this.a = similarAdvertsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) {
            SimilarAdvertsViewModelImpl.access$showScreenProgress(this.a);
        }
    }

    public static final class c<T> implements Consumer<List<? extends SectionTypeItem>> {
        public final /* synthetic */ SimilarAdvertsViewModelImpl a;

        public c(SimilarAdvertsViewModelImpl similarAdvertsViewModelImpl) {
            this.a = similarAdvertsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(List<? extends SectionTypeItem> list) {
            List<? extends SectionTypeItem> list2 = list;
            SimilarAdvertsViewModelImpl similarAdvertsViewModelImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            similarAdvertsViewModelImpl.j = (SectionTypeItem) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
            this.a.updateSimilarAdvertItems();
            SimilarAdvertsViewModelImpl.access$onSimilarLoaded(this.a);
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ SimilarAdvertsViewModelImpl a;

        public d(SimilarAdvertsViewModelImpl similarAdvertsViewModelImpl) {
            this.a = similarAdvertsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("SimilarAdverts", th);
            SimilarAdvertsViewModelImpl.access$showFullScreenError(this.a, new a2.a.a.w2.b(this));
        }
    }

    public SimilarAdvertsViewModelImpl(@NotNull String str, boolean z, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull SimilarAdvertsInteractor similarAdvertsInteractor, @NotNull SectionItemConverter sectionItemConverter, @NotNull ActivityIntentFactory activityIntentFactory, @NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter, @NotNull SimilarAdvertsResourceProvider similarAdvertsResourceProvider, @NotNull ScreenSource screenSource, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(similarAdvertsInteractor, "similarAdvertsInteractor");
        Intrinsics.checkNotNullParameter(sectionItemConverter, "similarAdvertsItemConverter");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter, "favoriteAdvertsPresenter");
        Intrinsics.checkNotNullParameter(similarAdvertsResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(screenSource, "screenSource");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.l = str;
        this.m = z;
        this.n = schedulersFactory3;
        this.o = similarAdvertsInteractor;
        this.p = sectionItemConverter;
        this.q = activityIntentFactory;
        this.r = favoriteAdvertsPresenter;
        this.s = similarAdvertsResourceProvider;
        this.t = screenSource;
        this.u = analytics;
        SingleLiveEvent<DeepLink> singleLiveEvent = new SingleLiveEvent<>();
        this.f = singleLiveEvent;
        SingleLiveEvent<Intent> singleLiveEvent2 = new SingleLiveEvent<>();
        this.g = singleLiveEvent2;
        this.h = singleLiveEvent2;
        this.i = singleLiveEvent;
        c();
    }

    public static final void access$onSimilarLoaded(SimilarAdvertsViewModelImpl similarAdvertsViewModelImpl) {
        similarAdvertsViewModelImpl.getShowContentChanges().setValue(Unit.INSTANCE);
        similarAdvertsViewModelImpl.getErrorChanges().setValue(null);
    }

    public static final void access$showFullScreenError(SimilarAdvertsViewModelImpl similarAdvertsViewModelImpl, Runnable runnable) {
        similarAdvertsViewModelImpl.getShowContentChanges().setValue(null);
        similarAdvertsViewModelImpl.getErrorChanges().setValue(runnable);
    }

    public static final void access$showScreenProgress(SimilarAdvertsViewModelImpl similarAdvertsViewModelImpl) {
        Objects.requireNonNull(similarAdvertsViewModelImpl);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SimilarSkeletonTitleItem("title", similarAdvertsViewModelImpl.s.getSimilarColumns()));
        for (int i2 = 1; i2 <= 6; i2++) {
            arrayList.add(new SkeletonItem(String.valueOf(i2)));
        }
        similarAdvertsViewModelImpl.getSimilarAdvertItems().setValue(new ListDataSource<>(arrayList));
    }

    public final void c() {
        Disposable disposable = this.k;
        if (disposable != null) {
            disposable.dispose();
        }
        this.k = this.o.getSimilarAdverts(this.l).map(a.a).doOnSubscribe(new b(this)).observeOn(this.n.mainThread()).subscribe(new c(this), new d(this));
    }

    @Override // com.avito.android.section.SectionRouter
    public void followSectionDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        this.f.postValue(deepLink);
    }

    @Override // com.avito.android.serp.adapter.GroupingListener
    public void onAdditionalActionClicked(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
    }

    @Override // com.avito.android.serp.adapter.AdvertItemListener
    public void onAdvertClicked(@NotNull AdvertItem advertItem, int i2, @Nullable Image image) {
        Intrinsics.checkNotNullParameter(advertItem, "advert");
        this.u.track(new ClickOnSimilarAdvertEvent(advertItem.getStringId(), this.l, advertItem.getCategoryId()));
        DeepLink deepLink = advertItem.getDeepLink();
        if (!(deepLink instanceof AdvertDetailsLink)) {
            deepLink = null;
        }
        AdvertDetailsLink advertDetailsLink = (AdvertDetailsLink) deepLink;
        if (advertDetailsLink != null) {
            this.g.postValue(AdvertDetailsIntentFactory.DefaultImpls.advertDetailsIntent$default(this.q, advertDetailsLink.getItemId(), advertDetailsLink.getContext(), advertItem.getTitle(), advertItem.getPrice(), advertItem.getPreviousPrice(), image, advertItem.isMarketplace(), new TreeClickStreamParent(0, ScreenIdField.FAVORITE_ITEMS.name(), null, null), SystemClock.elapsedRealtime(), null, null, this.t, 512, null));
        } else {
            this.f.postValue(advertItem.getDeepLink());
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.k;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // com.avito.android.favorite.FavoriteButtonClickListener
    public void onFavoriteButtonClicked(@NotNull FavorableItem favorableItem) {
        Intrinsics.checkNotNullParameter(favorableItem, "favorableItem");
        this.r.onFavoriteButtonClicked(favorableItem);
    }

    @Override // com.avito.android.advert.actions.MoreActionsClickListener
    public void onMoreActionsClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        SimilarAdvertsViewModel.DefaultImpls.onMoreActionsClicked(this, str);
    }

    @Override // com.avito.android.similar_adverts.SimilarAdvertsViewModel
    public void updateSimilarAdvertItems() {
        SectionTypeItem sectionTypeItem = this.j;
        if (sectionTypeItem != null) {
            List<PersistableSpannedItem> blockingGet = this.p.convertSectionTypeItem(sectionTypeItem, this.s.getSimilarColumns(), this.m, true).blockingGet();
            MutableLiveData<ListDataSource<SpannedItem>> similarAdvertItems = getSimilarAdvertItems();
            Intrinsics.checkNotNullExpressionValue(blockingGet, "similarItems");
            similarAdvertItems.setValue(new ListDataSource<>(blockingGet));
        }
    }

    @Override // com.avito.android.similar_adverts.SimilarAdvertsViewModel
    @NotNull
    public SingleLiveEvent<DeepLink> getDeepLinks() {
        return this.i;
    }

    @Override // com.avito.android.similar_adverts.SimilarAdvertsViewModel
    @NotNull
    public MutableLiveData<Runnable> getErrorChanges() {
        return this.d;
    }

    @Override // com.avito.android.similar_adverts.SimilarAdvertsViewModel
    @NotNull
    public SingleLiveEvent<Intent> getIntents() {
        return this.h;
    }

    @Override // com.avito.android.similar_adverts.SimilarAdvertsViewModel
    @NotNull
    public MutableLiveData<Unit> getShowContentChanges() {
        return this.c;
    }

    @Override // com.avito.android.similar_adverts.SimilarAdvertsViewModel
    @NotNull
    public MutableLiveData<ListDataSource<SpannedItem>> getSimilarAdvertItems() {
        return this.e;
    }
}
