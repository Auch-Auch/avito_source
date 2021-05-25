package com.avito.android.advert_stats;

import android.content.Intent;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.FeesIntentFactory;
import com.avito.android.UserAdvertIntentFactory;
import com.avito.android.advert_stats.analytics.AdvertReactivationStartEvent;
import com.avito.android.advert_stats.analytics.StatsVasButtonClickEvent;
import com.avito.android.advert_stats.item.BarItem;
import com.avito.android.advert_stats.item.SelectablePlotItem;
import com.avito.android.advert_stats.item.StatisticsToItemsConverter;
import com.avito.android.advert_stats.item.WeekItem;
import com.avito.android.advert_stats.item.details.StatDetailItem;
import com.avito.android.advert_stats.item.disclaimer.NewStatisticsBannerItem;
import com.avito.android.advert_stats.item.hint.HintItem;
import com.avito.android.advert_stats.item.period.PeriodItem;
import com.avito.android.advert_stats.recycler.ListUpdate;
import com.avito.android.advert_stats.remote.model.AdvertStatistics;
import com.avito.android.advert_stats.tracker.AdvertStatsTracker;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.bivrost.BivrostTutorialSessionStorage;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.DeeplinkClickStreamProvider;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.FeesLink;
import com.avito.android.deep_linking.links.LegacyPaidServicesLink;
import com.avito.android.deep_linking.links.MyAdvertLink;
import com.avito.android.deep_linking.links.PaidServicesLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.model.Action;
import com.avito.android.util.Constants;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.Event;
import com.avito.android.util.architecture_components.IntentDataHolder;
import com.avito.android.util.architecture_components.IntentForResultDataHolder;
import com.avito.android.util.architecture_components.StartActivityEvent;
import com.avito.android.util.architecture_components.StartActivityForResultEvent;
import com.avito.conveyor_item.Item;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u00012\u00020\u0002BQ\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010V\u001a\u00020S\u0012\u0006\u0010r\u001a\u00020o\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u0010j\u001a\u00020g\u0012\u0006\u0010?\u001a\u00020<\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u0010C\u001a\u00020@\u0012\u0006\u0010n\u001a\u00020k¢\u0006\u0006\b\u0001\u0010\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0013\u0010\u0012J\u001d\u0010\u0017\u001a\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001b\u001a\u00020\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0014H\u0016¢\u0006\u0004\b\u001b\u0010\u0018J\u0017\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001c\u0010\u0010J\u001f\u0010 \u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0016¢\u0006\u0004\b \u0010!J\u001d\u0010#\u001a\u00020\u00052\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014H\u0016¢\u0006\u0004\b#\u0010\u0018J\u0017\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u001d\u0010*\u001a\u00020\u00052\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u0014H\u0016¢\u0006\u0004\b*\u0010\u0018R \u0010.\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030,0+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010-R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u001c\u0010;\u001a\b\u0012\u0004\u0012\u0002090+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010-R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020D8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010FR\u0016\u0010K\u001a\u00020D8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010FR\"\u0010R\u001a\b\u0012\u0004\u0012\u00020M0L8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010UR&\u0010Z\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030,0+8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bW\u0010-\u001a\u0004\bX\u0010YR\u001c\u0010]\u001a\b\u0012\u0004\u0012\u00020[0+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\\\u0010-R&\u0010a\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030^0+8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b_\u0010-\u001a\u0004\b`\u0010YR\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\"\u0010f\u001a\b\u0012\u0004\u0012\u0002090L8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bd\u0010O\u001a\u0004\be\u0010QR\u0016\u0010j\u001a\u00020g8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010n\u001a\u00020k8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010r\u001a\u00020o8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\"\u0010u\u001a\b\u0012\u0004\u0012\u00020[0+8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bs\u0010-\u001a\u0004\bt\u0010YR\u0018\u0010v\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010FR\u0016\u0010x\u001a\u00020D8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bw\u0010FR\u0016\u0010z\u001a\u00020D8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\by\u0010FR \u0010{\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030^0+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010-R\u0016\u0010~\u001a\u00020M8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020M0+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010-¨\u0006\u0001"}, d2 = {"Lcom/avito/android/advert_stats/AdvertStatsViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/advert_stats/AdvertStatsViewModel;", "", "itemId", "", "d", "(Ljava/lang/String;)V", "", "Lcom/avito/conveyor_item/Item;", "items", "e", "(Ljava/util/List;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "c", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "onRetryClicked", "()V", "onCleared", "Lio/reactivex/Observable;", "Lcom/avito/android/advert_stats/item/WeekItem;", "weeksObservable", "subscribeToWeekSelection", "(Lio/reactivex/Observable;)V", "Lcom/avito/android/advert_stats/item/BarItem;", "barObservable", "subscribeToBarSelection", "onButtonClicked", "", "requestCode", "resultCode", "handleResult", "(II)V", "observable", "subscribeToWeekScrolling", "Lcom/avito/android/deep_linking/DeeplinkClickStreamProvider;", "deeplinkClickStreamProvider", "subscribeToItemClicks", "(Lcom/avito/android/deep_linking/DeeplinkClickStreamProvider;)V", "Lcom/avito/android/advert_stats/item/disclaimer/NewStatisticsBannerItem;", "bannerClicks", "subscribeStatisticsBannerClicks", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/util/architecture_components/Event;", "Landroidx/lifecycle/MutableLiveData;", "routingEventsLiveData", "n", "Ljava/util/List;", "Lcom/avito/android/advert_stats/item/StatisticsToItemsConverter;", "x", "Lcom/avito/android/advert_stats/item/StatisticsToItemsConverter;", "itemsConverter", "Lcom/avito/android/analytics/Analytics;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/remote/model/Action;", a2.g.r.g.a, "buttonActionChangesLiveData", "Lcom/avito/android/ActivityIntentFactory;", "z", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/advert_stats/tracker/AdvertStatsTracker;", "B", "Lcom/avito/android/advert_stats/tracker/AdvertStatsTracker;", "advertStatsTracker", "Lio/reactivex/disposables/Disposable;", "k", "Lio/reactivex/disposables/Disposable;", "scrollingSubscription", "l", "clickSubscription", AuthSource.OPEN_CHANNEL_LIST, "bannerClickSubscription", "Landroidx/lifecycle/LiveData;", "", "t", "Landroidx/lifecycle/LiveData;", "getTitleVisibilityChanges", "()Landroidx/lifecycle/LiveData;", "titleVisibilityChanges", "Lcom/avito/android/util/SchedulersFactory;", VKApiConst.VERSION, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "p", "getRoutingEvents", "()Landroidx/lifecycle/MutableLiveData;", "routingEvents", "Lcom/avito/android/advert_stats/recycler/ListUpdate;", "f", "dataChangesLiveData", "Lcom/avito/android/util/LoadingState;", VKApiConst.Q, "getProgressChanges", "progressChanges", "u", "Ljava/lang/String;", "s", "getButtonActionChanges", "buttonActionChanges", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "y", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/analytics/bivrost/BivrostTutorialSessionStorage;", "C", "Lcom/avito/android/analytics/bivrost/BivrostTutorialSessionStorage;", "bivrostSessionStorage", "Lcom/avito/android/advert_stats/AdvertStatsRepository;", "w", "Lcom/avito/android/advert_stats/AdvertStatsRepository;", "interactor", "r", "getDataChanges", "dataChanges", "subscription", "i", "weeksSubscription", "j", "barsSubscription", "progressChangesLiveData", "o", "Z", "isContentHidden", "h", "titleVisibilityChangesLiveData", "<init>", "(Ljava/lang/String;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/advert_stats/AdvertStatsRepository;Lcom/avito/android/advert_stats/item/StatisticsToItemsConverter;Lcom/avito/android/deep_linking/DeepLinkIntentFactory;Lcom/avito/android/ActivityIntentFactory;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/advert_stats/tracker/AdvertStatsTracker;Lcom/avito/android/analytics/bivrost/BivrostTutorialSessionStorage;)V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertStatsViewModelImpl extends ViewModel implements AdvertStatsViewModel {
    public final Analytics A;
    public final AdvertStatsTracker B;
    public final BivrostTutorialSessionStorage C;
    public Disposable c;
    public final MutableLiveData<LoadingState<?>> d;
    public final MutableLiveData<Event<?>> e;
    public final MutableLiveData<ListUpdate> f;
    public final MutableLiveData<Action> g;
    public final MutableLiveData<Boolean> h;
    public Disposable i;
    public Disposable j;
    public Disposable k;
    public Disposable l;
    public Disposable m;
    public List<? extends Item> n = CollectionsKt__CollectionsKt.emptyList();
    public boolean o;
    @NotNull
    public final MutableLiveData<Event<?>> p;
    @NotNull
    public final MutableLiveData<LoadingState<?>> q;
    @NotNull
    public final MutableLiveData<ListUpdate> r;
    @NotNull
    public final LiveData<Action> s;
    @NotNull
    public final LiveData<Boolean> t;
    public final String u;
    public final SchedulersFactory v;
    public final AdvertStatsRepository w;
    public final StatisticsToItemsConverter x;
    public final DeepLinkIntentFactory y;
    public final ActivityIntentFactory z;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<LoadingState<? super AdvertStatistics>> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(LoadingState<? super AdvertStatistics> loadingState) {
            int i = this.a;
            if (i == 0) {
                LoadingState<? super AdvertStatistics> loadingState2 = loadingState;
                Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
                AdvertStatsViewModelImpl.access$trackLoadingState((AdvertStatsViewModelImpl) this.b, loadingState2);
            } else if (i == 1) {
                LoadingState<? super AdvertStatistics> loadingState3 = loadingState;
                if (!(loadingState3 instanceof LoadingState.Loaded)) {
                    ((AdvertStatsViewModelImpl) this.b).d.postValue(loadingState3);
                }
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ AdvertStatsViewModelImpl a;

        public b(AdvertStatsViewModelImpl advertStatsViewModelImpl) {
            this.a = advertStatsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            AdvertStatsViewModelImpl advertStatsViewModelImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            AdvertStatsViewModelImpl.access$onStatsError(advertStatsViewModelImpl, th2);
        }
    }

    public static final class c<T> implements Predicate<LoadingState<? super AdvertStatistics>> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(LoadingState<? super AdvertStatistics> loadingState) {
            LoadingState<? super AdvertStatistics> loadingState2 = loadingState;
            Intrinsics.checkNotNullParameter(loadingState2, "it");
            return loadingState2 instanceof LoadingState.Loaded;
        }
    }

    public static final class d<T, R> implements Function<LoadingState<? super AdvertStatistics>, AdvertStatistics> {
        public static final d a = new d();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public AdvertStatistics apply(LoadingState<? super AdvertStatistics> loadingState) {
            LoadingState<? super AdvertStatistics> loadingState2 = loadingState;
            Intrinsics.checkNotNullParameter(loadingState2, "it");
            return (AdvertStatistics) ((LoadingState.Loaded) loadingState2).getData();
        }
    }

    public static final class e<T> implements Consumer<AdvertStatistics> {
        public final /* synthetic */ AdvertStatsViewModelImpl a;

        public e(AdvertStatsViewModelImpl advertStatsViewModelImpl) {
            this.a = advertStatsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(AdvertStatistics advertStatistics) {
            Action action = advertStatistics.getAction();
            if (action != null) {
                this.a.g.postValue(action);
            }
        }
    }

    public static final class f<T> implements Consumer<AdvertStatistics> {
        public final /* synthetic */ AdvertStatsViewModelImpl a;

        public f(AdvertStatsViewModelImpl advertStatsViewModelImpl) {
            this.a = advertStatsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(AdvertStatistics advertStatistics) {
            this.a.B.startPreparing();
        }
    }

    public static final class g<T, R> implements Function<AdvertStatistics, List<? extends Item>> {
        public final /* synthetic */ AdvertStatsViewModelImpl a;

        public g(AdvertStatsViewModelImpl advertStatsViewModelImpl) {
            this.a = advertStatsViewModelImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends Item> apply(AdvertStatistics advertStatistics) {
            AdvertStatistics advertStatistics2 = advertStatistics;
            Intrinsics.checkNotNullParameter(advertStatistics2, "it");
            return this.a.x.convert(advertStatistics2);
        }
    }

    public static final class h<T, R> implements Function<List<? extends Item>, LoadingState.Loaded<List<? extends Item>>> {
        public static final h a = new h();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState.Loaded<List<? extends Item>> apply(List<? extends Item> list) {
            List<? extends Item> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "it");
            return new LoadingState.Loaded<>(list2);
        }
    }

    public static final class i<T> implements Consumer<LoadingState.Loaded<List<? extends Item>>> {
        public final /* synthetic */ AdvertStatsViewModelImpl a;

        public i(AdvertStatsViewModelImpl advertStatsViewModelImpl) {
            this.a = advertStatsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState.Loaded<List<? extends Item>> loaded) {
            LoadingState.Loaded<List<? extends Item>> loaded2 = loaded;
            AdvertStatsViewModelImpl advertStatsViewModelImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(loaded2, "it");
            AdvertStatsViewModelImpl.access$onStatsLoaded(advertStatsViewModelImpl, loaded2);
        }
    }

    public static final class j<T> implements Consumer<NewStatisticsBannerItem> {
        public final /* synthetic */ AdvertStatsViewModelImpl a;

        public j(AdvertStatsViewModelImpl advertStatsViewModelImpl) {
            this.a = advertStatsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(NewStatisticsBannerItem newStatisticsBannerItem) {
            AdvertStatsViewModelImpl.access$closeNewStatisticsBanner(this.a);
        }
    }

    public static final class k<T> implements Consumer<Throwable> {
        public static final k a = new k();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Error in subscription to statistics banner clicks", th);
        }
    }

    public static final class l<T> implements Consumer<BarItem> {
        public final /* synthetic */ AdvertStatsViewModelImpl a;

        public l(AdvertStatsViewModelImpl advertStatsViewModelImpl) {
            this.a = advertStatsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(BarItem barItem) {
            BarItem barItem2 = barItem;
            if (!this.a.o) {
                AdvertStatsViewModelImpl advertStatsViewModelImpl = this.a;
                AdvertStatsViewModelImpl.access$hideItems(advertStatsViewModelImpl, advertStatsViewModelImpl.n);
            }
            AdvertStatsViewModelImpl advertStatsViewModelImpl2 = this.a;
            Intrinsics.checkNotNullExpressionValue(barItem2, "it");
            AdvertStatsViewModelImpl.access$updateList(advertStatsViewModelImpl2, barItem2);
        }
    }

    public static final class m<T> implements Consumer<Throwable> {
        public static final m a = new m();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Timber.e(th);
        }
    }

    public static final class n<T> implements Consumer<DeepLink> {
        public final /* synthetic */ AdvertStatsViewModelImpl a;

        public n(AdvertStatsViewModelImpl advertStatsViewModelImpl) {
            this.a = advertStatsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(DeepLink deepLink) {
            DeepLink deepLink2 = deepLink;
            AdvertStatsViewModelImpl advertStatsViewModelImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
            advertStatsViewModelImpl.c(deepLink2);
        }
    }

    public static final class o<T> implements Consumer<Throwable> {
        public static final o a = new o();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Timber.e(th);
        }
    }

    public static final class p<T> implements Consumer<Unit> {
        public final /* synthetic */ AdvertStatsViewModelImpl a;

        public p(AdvertStatsViewModelImpl advertStatsViewModelImpl) {
            this.a = advertStatsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            AdvertStatsViewModelImpl advertStatsViewModelImpl = this.a;
            AdvertStatsViewModelImpl.access$hideItems(advertStatsViewModelImpl, advertStatsViewModelImpl.n);
        }
    }

    public static final class q<T> implements Consumer<Throwable> {
        public static final q a = new q();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Timber.e(th);
        }
    }

    public static final class r<T> implements Consumer<WeekItem> {
        public final /* synthetic */ AdvertStatsViewModelImpl a;

        public r(AdvertStatsViewModelImpl advertStatsViewModelImpl) {
            this.a = advertStatsViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(WeekItem weekItem) {
            WeekItem weekItem2 = weekItem;
            if (!this.a.o) {
                AdvertStatsViewModelImpl advertStatsViewModelImpl = this.a;
                AdvertStatsViewModelImpl.access$hideItems(advertStatsViewModelImpl, advertStatsViewModelImpl.n);
            }
            AdvertStatsViewModelImpl advertStatsViewModelImpl2 = this.a;
            Intrinsics.checkNotNullExpressionValue(weekItem2, "it");
            AdvertStatsViewModelImpl.access$updateList(advertStatsViewModelImpl2, weekItem2);
        }
    }

    public static final class s<T> implements Consumer<Throwable> {
        public static final s a = new s();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Timber.e(th);
        }
    }

    public AdvertStatsViewModelImpl(@NotNull String str, @NotNull SchedulersFactory schedulersFactory, @NotNull AdvertStatsRepository advertStatsRepository, @NotNull StatisticsToItemsConverter statisticsToItemsConverter, @NotNull DeepLinkIntentFactory deepLinkIntentFactory, @NotNull ActivityIntentFactory activityIntentFactory, @NotNull Analytics analytics, @NotNull AdvertStatsTracker advertStatsTracker, @NotNull BivrostTutorialSessionStorage bivrostTutorialSessionStorage) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(advertStatsRepository, "interactor");
        Intrinsics.checkNotNullParameter(statisticsToItemsConverter, "itemsConverter");
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(advertStatsTracker, "advertStatsTracker");
        Intrinsics.checkNotNullParameter(bivrostTutorialSessionStorage, "bivrostSessionStorage");
        this.u = str;
        this.v = schedulersFactory;
        this.w = advertStatsRepository;
        this.x = statisticsToItemsConverter;
        this.y = deepLinkIntentFactory;
        this.z = activityIntentFactory;
        this.A = analytics;
        this.B = advertStatsTracker;
        this.C = bivrostTutorialSessionStorage;
        MutableLiveData<LoadingState<?>> mutableLiveData = new MutableLiveData<>();
        this.d = mutableLiveData;
        MutableLiveData<Event<?>> mutableLiveData2 = new MutableLiveData<>();
        this.e = mutableLiveData2;
        MutableLiveData<ListUpdate> mutableLiveData3 = new MutableLiveData<>();
        this.f = mutableLiveData3;
        MutableLiveData<Action> mutableLiveData4 = new MutableLiveData<>();
        this.g = mutableLiveData4;
        MutableLiveData<Boolean> mutableLiveData5 = new MutableLiveData<>();
        this.h = mutableLiveData5;
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.i = empty;
        Disposable empty2 = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty2, "Disposables.empty()");
        this.j = empty2;
        Disposable empty3 = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty3, "Disposables.empty()");
        this.k = empty3;
        Disposable empty4 = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty4, "Disposables.empty()");
        this.l = empty4;
        Disposable empty5 = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty5, "Disposables.empty()");
        this.m = empty5;
        d(str);
        this.p = mutableLiveData2;
        this.q = mutableLiveData;
        this.r = mutableLiveData3;
        this.s = mutableLiveData4;
        this.t = mutableLiveData5;
    }

    public static final void access$closeNewStatisticsBanner(AdvertStatsViewModelImpl advertStatsViewModelImpl) {
        advertStatsViewModelImpl.C.setStatisticsBannerVisible(false);
        List<? extends Item> list = advertStatsViewModelImpl.n;
        ArrayList arrayList = new ArrayList();
        for (T t2 : list) {
            if (!(t2 instanceof NewStatisticsBannerItem)) {
                arrayList.add(t2);
            }
        }
        advertStatsViewModelImpl.e(arrayList);
    }

    public static final void access$hideItems(AdvertStatsViewModelImpl advertStatsViewModelImpl, List list) {
        Objects.requireNonNull(advertStatsViewModelImpl);
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.avito.konveyor.blueprint.Item item = (Item) it.next();
            if (item instanceof PeriodItem) {
                item = PeriodItem.copy$default((PeriodItem) item, null, null, true, 3, null);
            } else if (item instanceof StatDetailItem) {
                item = StatDetailItem.copy$default((StatDetailItem) item, null, null, null, null, false, true, 31, null);
            }
            arrayList.add(item);
        }
        advertStatsViewModelImpl.e(arrayList);
        advertStatsViewModelImpl.o = true;
    }

    public static final void access$onStatsError(AdvertStatsViewModelImpl advertStatsViewModelImpl, Throwable th) {
        advertStatsViewModelImpl.B.trackPreparingError();
        advertStatsViewModelImpl.B.startDrawing();
        advertStatsViewModelImpl.d.postValue(new LoadingState.Error(new ErrorWithMessage.SimpleMessageError(th.toString())));
        advertStatsViewModelImpl.B.trackDrawnError();
    }

    public static final void access$onStatsLoaded(AdvertStatsViewModelImpl advertStatsViewModelImpl, LoadingState.Loaded loaded) {
        Object obj;
        advertStatsViewModelImpl.B.trackPrepared();
        advertStatsViewModelImpl.B.startDrawing();
        Iterator it = ((Collection) loaded.getData()).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (obj instanceof HintItem) {
                break;
            }
        }
        advertStatsViewModelImpl.h.setValue(Boolean.valueOf(((HintItem) obj) != null));
        advertStatsViewModelImpl.d.postValue(loaded);
        advertStatsViewModelImpl.e((List) loaded.getData());
        advertStatsViewModelImpl.o = false;
        advertStatsViewModelImpl.B.trackDrawn();
    }

    public static final void access$trackLoadingState(AdvertStatsViewModelImpl advertStatsViewModelImpl, LoadingState loadingState) {
        Objects.requireNonNull(advertStatsViewModelImpl);
        if (loadingState instanceof LoadingState.Error) {
            advertStatsViewModelImpl.B.trackLoadingError();
        } else if (loadingState instanceof LoadingState.Loaded) {
            advertStatsViewModelImpl.B.trackLoaded();
        }
    }

    public static final void access$updateList(AdvertStatsViewModelImpl advertStatsViewModelImpl, SelectablePlotItem selectablePlotItem) {
        advertStatsViewModelImpl.e(advertStatsViewModelImpl.x.updateItems(advertStatsViewModelImpl.n, selectablePlotItem));
        advertStatsViewModelImpl.o = false;
    }

    public final void c(DeepLink deepLink) {
        if (deepLink instanceof FeesLink) {
            this.e.setValue(new StartActivityForResultEvent(new IntentForResultDataHolder(FeesIntentFactory.DefaultImpls.feesIntent$default(this.z, ((FeesLink) deepLink).getItemId(), false, false, 6, null), 2)));
        } else if (deepLink instanceof LegacyPaidServicesLink) {
            Intent intent = this.y.getIntent(deepLink);
            if (intent != null) {
                intent.removeExtra(Constants.UP_INTENT);
                this.e.setValue(new StartActivityForResultEvent(new IntentForResultDataHolder(intent, 3)));
                this.A.track(new StatsVasButtonClickEvent(this.u));
            }
        } else if (deepLink instanceof PaidServicesLink) {
            Intent intent2 = this.y.getIntent(deepLink);
            if (intent2 != null) {
                Intent flags = UserAdvertIntentFactory.DefaultImpls.myAdvertDetailsIntent$default(this.z, this.u, null, null, false, 14, null).setFlags(603979776);
                Intrinsics.checkNotNullExpressionValue(flags, "activityIntentFactory.my…FLAG_ACTIVITY_SINGLE_TOP)");
                intent2.putExtra(Constants.UP_INTENT, flags);
                this.e.setValue(new StartActivityForResultEvent(new IntentForResultDataHolder(intent2, 5)));
            }
        } else if (deepLink instanceof MyAdvertLink.Activate) {
            Intent flags2 = this.z.myAdvertDetailsActivateIntent(((MyAdvertLink.Activate) deepLink).getItemId()).setFlags(603979776);
            Intrinsics.checkNotNullExpressionValue(flags2, "activityIntentFactory.my…FLAG_ACTIVITY_SINGLE_TOP)");
            this.e.setValue(new StartActivityEvent(new IntentDataHolder(flags2, true)));
        } else if (deepLink instanceof MyAdvertLink.Edit) {
            Intent intent3 = this.y.getIntent(deepLink);
            if (intent3 != null) {
                MyAdvertLink.Edit edit = (MyAdvertLink.Edit) deepLink;
                if (Intrinsics.areEqual(edit.getPostAction(), "activate")) {
                    this.A.track(new AdvertReactivationStartEvent(edit.getItemId()));
                }
                Intent flags3 = this.z.advertStatsIntent(edit.getItemId()).setFlags(603979776);
                Intrinsics.checkNotNullExpressionValue(flags3, "activityIntentFactory.ad…FLAG_ACTIVITY_SINGLE_TOP)");
                intent3.putExtra(Constants.UP_INTENT, flags3);
                this.e.setValue(new StartActivityForResultEvent(new IntentForResultDataHolder(intent3, 4)));
            }
        } else {
            Intent intent4 = this.y.getIntent(deepLink);
            if (intent4 != null) {
                this.e.setValue(new StartActivityEvent(new IntentDataHolder(intent4, false)));
            }
        }
    }

    public final void d(String str) {
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        this.B.startLoading();
        this.c = this.w.getAdvertStats(str).doOnNext(new a(0, this)).doOnNext(new a(1, this)).filter(c.a).map(d.a).doOnNext(new e(this)).doOnNext(new f(this)).map(new g(this)).map(h.a).subscribeOn(this.v.io()).observeOn(this.v.mainThread()).subscribe(new i(this), new b(this));
    }

    public final void e(List<? extends Item> list) {
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new StatsCallback(this.n, list));
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "DiffUtil.calculateDiff(callback)");
        this.f.setValue(new ListUpdate(list, calculateDiff));
        this.n = list;
    }

    @Override // com.avito.android.advert_stats.AdvertStatsViewModel
    @NotNull
    public LiveData<Action> getButtonActionChanges() {
        return this.s;
    }

    @Override // com.avito.android.advert_stats.AdvertStatsViewModel
    @NotNull
    public LiveData<Boolean> getTitleVisibilityChanges() {
        return this.t;
    }

    @Override // com.avito.android.advert_stats.AdvertStatsViewModel
    public void handleResult(int i2, int i3) {
        if (i3 == -1 && CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{2, 3, 4, 5}).contains(Integer.valueOf(i2))) {
            Intent flags = UserAdvertIntentFactory.DefaultImpls.myAdvertDetailsIntent$default(this.z, this.u, null, null, false, 14, null).setFlags(603979776);
            Intrinsics.checkNotNullExpressionValue(flags, "activityIntentFactory.my…FLAG_ACTIVITY_SINGLE_TOP)");
            this.e.postValue(new StartActivityEvent(new IntentDataHolder(flags, true)));
        }
    }

    @Override // com.avito.android.advert_stats.AdvertStatsViewModel
    public void onButtonClicked(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deeplink");
        c(deepLink);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        this.i.dispose();
        this.j.dispose();
        this.k.dispose();
        this.l.dispose();
        this.m.dispose();
        super.onCleared();
    }

    @Override // com.avito.android.advert_stats.AdvertStatsViewModel
    public void onRetryClicked() {
        d(this.u);
    }

    @Override // com.avito.android.advert_stats.AdvertStatsViewModel
    public void subscribeStatisticsBannerClicks(@NotNull Observable<NewStatisticsBannerItem> observable) {
        Intrinsics.checkNotNullParameter(observable, "bannerClicks");
        this.m.dispose();
        Disposable subscribe = observable.observeOn(this.v.mainThread()).subscribe(new j(this), k.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "bannerClicks\n           …icks\", it)\n            })");
        this.m = subscribe;
    }

    @Override // com.avito.android.advert_stats.AdvertStatsViewModel
    public void subscribeToBarSelection(@NotNull Observable<BarItem> observable) {
        Intrinsics.checkNotNullParameter(observable, "barObservable");
        this.j.dispose();
        Disposable subscribe = observable.throttleFirst(100, TimeUnit.MILLISECONDS).observeOn(this.v.mainThread()).subscribe(new l(this), m.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "barObservable\n          …     }, { Timber.e(it) })");
        this.j = subscribe;
    }

    @Override // com.avito.android.advert_stats.AdvertStatsViewModel
    public void subscribeToItemClicks(@NotNull DeeplinkClickStreamProvider deeplinkClickStreamProvider) {
        Intrinsics.checkNotNullParameter(deeplinkClickStreamProvider, "deeplinkClickStreamProvider");
        this.l.dispose();
        Disposable subscribe = deeplinkClickStreamProvider.getDeeplinkClicks().throttleFirst(100, TimeUnit.MILLISECONDS).observeOn(this.v.mainThread()).subscribe(new n(this), o.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "deeplinkClickStreamProvi…(it) }, { Timber.e(it) })");
        this.l = subscribe;
    }

    @Override // com.avito.android.advert_stats.AdvertStatsViewModel
    public void subscribeToWeekScrolling(@NotNull Observable<Unit> observable) {
        Intrinsics.checkNotNullParameter(observable, "observable");
        this.k.dispose();
        Disposable subscribe = observable.throttleFirst(100, TimeUnit.MILLISECONDS).observeOn(this.v.mainThread()).subscribe(new p(this), q.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "observable\n            .…ems) }, { Timber.e(it) })");
        this.k = subscribe;
    }

    @Override // com.avito.android.advert_stats.AdvertStatsViewModel
    public void subscribeToWeekSelection(@NotNull Observable<WeekItem> observable) {
        Intrinsics.checkNotNullParameter(observable, "weeksObservable");
        this.i.dispose();
        Disposable subscribe = observable.throttleFirst(100, TimeUnit.MILLISECONDS).observeOn(this.v.mainThread()).subscribe(new r(this), s.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "weeksObservable\n        …     }, { Timber.e(it) })");
        this.i = subscribe;
    }

    @Override // com.avito.android.advert_stats.AdvertStatsViewModel
    @NotNull
    public MutableLiveData<ListUpdate> getDataChanges() {
        return this.r;
    }

    @Override // com.avito.android.advert_stats.AdvertStatsViewModel
    @NotNull
    public MutableLiveData<LoadingState<?>> getProgressChanges() {
        return this.q;
    }

    @Override // com.avito.android.advert_stats.AdvertStatsViewModel
    @NotNull
    public MutableLiveData<Event<?>> getRoutingEvents() {
        return this.p;
    }
}
