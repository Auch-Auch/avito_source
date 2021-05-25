package com.avito.android.serp;

import a2.a.a.n2.o;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.SearchResultEvent;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.module.SerpInteractorModule;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.profile.ProfileInfoStorage;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.CommercialBanner;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.PageParams;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SerpDisplayTypeKt;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.remote.model.SerpElementResult;
import com.avito.android.remote.model.SerpWarning;
import com.avito.android.remote.model.Size;
import com.avito.android.remote.model.SuggestParamsConverter;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.search.suggest.SuggestItem;
import com.avito.android.remote.model.search.suggest.SuggestResponse;
import com.avito.android.search.SearchDeepLinkInteractor;
import com.avito.android.search.subscriptions.SerpSearchSubscriptionInteractor;
import com.avito.android.serp.InlineFiltersInteractor;
import com.avito.android.serp.adapter.SerpCommercialBanner;
import com.avito.android.serp.adapter.SerpItemAligner;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.avito.android.serp.adapter.empty_search.EmptySearchElement;
import com.avito.android.serp.adapter.warning.SerpWarningItem;
import com.avito.android.serp.analytics.SerpTracker;
import com.avito.android.serp.warning.WarningState;
import com.avito.android.serp.warning.WarningStateProvider;
import com.avito.android.serp_core.R;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.UrlParams;
import com.avito.android.util.rx3.Observables;
import com.facebook.common.util.UriUtil;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.q;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000°\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002BÏ\u0001\b\u0007\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\n\b\u0001\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010Z\u001a\u00020W\u0012\u0006\u0010v\u001a\u00020s\u0012\u0006\u0010i\u001a\u00020f\u0012\u0006\u0010P\u001a\u00020M\u0012\u0006\u0010G\u001a\u00020D\u0012\u0007\u00105\u001a\u00030\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010C\u001a\u00020@\u0012\u0006\u0010r\u001a\u00020o\u0012\u0006\u0010m\u001a\u00020j\u0012\u0006\u0010y\u001a\u00020\u0002\u0012\u0006\u0010^\u001a\u00020[\u0012\u0006\u0010b\u001a\u00020_\u0012\u0007\u0010\u0001\u001a\u00020~\u0012\u0006\u0010}\u001a\u00020z\u0012\b\u0010£\u0001\u001a\u00030 \u0001\u0012\b\b\u0001\u0010L\u001a\u00020\u0017\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0006\b¤\u0001\u0010¥\u0001J]\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00122\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001f\u0010 JE\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00130\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\"\u0010#J1\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00122\u0006\u0010\n\u001a\u00020\t2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b%\u0010&J+\u0010'\u001a\b\u0012\u0004\u0012\u00020\f0\u00122\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J#\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\u000b0\u00122\u0006\u0010-\u001a\u00020\u0007H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u001cH\u0016¢\u0006\u0004\b1\u00102J-\u00106\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\u00072\u0014\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u000104H\u0016¢\u0006\u0004\b6\u00107J-\u00108\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\u00072\u0014\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u000104H\u0016¢\u0006\u0004\b8\u00107J-\u00109\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\u00072\u0014\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u000104H\u0016¢\u0006\u0004\b9\u00107J-\u0010:\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\u00072\u0014\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u000104H\u0016¢\u0006\u0004\b:\u00107JJ\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0\u00130\u00122\u0006\u0010-\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010;\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010<\u001a\u00020\u0017H\u0001¢\u0006\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010IR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010e\u001a\u00020\u000e8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bc\u0010dR\u0016\u0010i\u001a\u00020f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010m\u001a\u00020j8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010nR\u0016\u0010r\u001a\u00020o8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010v\u001a\u00020s8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010y\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010}\u001a\u00020z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b{\u0010|R\u0018\u0010\u0001\u001a\u00020~8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u00105\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010IR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0006\u001a\u00030\u00018\u0002@\u0002X.¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010£\u0001\u001a\u00030 \u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001¨\u0006¦\u0001"}, d2 = {"Lcom/avito/android/serp/SerpInteractorImpl;", "Lcom/avito/android/serp/SerpInteractor;", "Lcom/avito/android/search/SearchDeepLinkInteractor;", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "Lcom/avito/android/serp/SerpPageParams;", "pageParams", "", "context", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "notSortedItems", "", "columns", "Lcom/avito/android/serp/SerpParameters;", "serpParameters", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/serp/SerpPage;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/SearchParams;Lcom/avito/android/serp/SerpPageParams;Ljava/lang/String;Lcom/avito/android/remote/model/SerpDisplayType;Ljava/util/List;ILcom/avito/android/serp/SerpParameters;)Lio/reactivex/rxjava3/core/Observable;", "", "isEmptySearch", "()Z", "Lcom/avito/android/util/Kundle;", "state", "", "restoreState", "(Lcom/avito/android/util/Kundle;)V", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/serp/Serp;", "loadSerp", "(Lcom/avito/android/serp/SerpParameters;Lcom/avito/android/serp/SerpPageParams;Lcom/avito/android/remote/model/SerpDisplayType;Ljava/util/List;)Lio/reactivex/rxjava3/core/Observable;", "items", "restoreSerp", "(Lcom/avito/android/remote/model/SerpDisplayType;Ljava/util/List;)Lio/reactivex/rxjava3/core/Observable;", "loadAds", "(Ljava/util/List;Lcom/avito/android/remote/model/SerpDisplayType;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/serp/adapter/warning/SerpWarningItem;", "warning", "closeWarning", "(Lcom/avito/android/serp/adapter/warning/SerpWarningItem;)V", "query", "Lcom/avito/android/remote/model/search/suggest/SuggestItem;", "loadSuggestions", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "invalidate", "()V", "id", "", "analytics", "sendSnippetActionClick", "(Ljava/lang/String;Ljava/util/Map;)V", "sendSnippetActionClose", "sendSnippetActionShow", "sendSnippetActionHide", "clearGeoFilters", UrlParams.SIMPLE_MAP, "Lcom/avito/android/deep_linking/links/DeepLink;", "loadSearchDeepLink", "(Ljava/lang/String;Lcom/avito/android/remote/model/SearchParams;Ljava/lang/String;Ljava/lang/Boolean;Z)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/profile/ProfileInfoStorage;", "s", "Lcom/avito/android/profile/ProfileInfoStorage;", "profileInfoStorage", "Lcom/avito/android/serp/adapter/SerpItemAligner;", "p", "Lcom/avito/android/serp/adapter/SerpItemAligner;", "aligner", "f", "Z", "errorSearch", "B", "showJobNearbyBanner", "Lcom/avito/android/serp/SerpItemProcessor;", "o", "Lcom/avito/android/serp/SerpItemProcessor;", "itemProcessor", "d", "I", "Lcom/avito/android/serp/SerpValues;", "e", "Lcom/avito/android/serp/SerpValues;", "serpValues", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "l", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/serp/warning/WarningStateProvider;", "w", "Lcom/avito/android/serp/warning/WarningStateProvider;", "warningStateProvider", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "x", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationManagerProvider", "getPage", "()I", "page", "Lcom/avito/android/util/SchedulersFactory3;", "n", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/search/subscriptions/SerpSearchSubscriptionInteractor;", "u", "Lcom/avito/android/search/subscriptions/SerpSearchSubscriptionInteractor;", "searchSubscriptionInteractor", "Lcom/avito/android/remote/model/SearchParams;", "Lcom/avito/android/Features;", "t", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/serp/CommercialBannersInteractor;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/serp/CommercialBannersInteractor;", "commercialBannersInteractor", VKApiConst.VERSION, "Lcom/avito/android/search/SearchDeepLinkInteractor;", "searchDeepLinkInteractor", "Lcom/avito/android/serp/SerpSnippetInteractor;", "z", "Lcom/avito/android/serp/SerpSnippetInteractor;", "serpSnippetInteractor", "Lcom/avito/android/serp/analytics/SerpTracker;", "y", "Lcom/avito/android/serp/analytics/SerpTracker;", "tracker", "Lcom/avito/android/remote/SearchApi;", "i", "Lcom/avito/android/remote/SearchApi;", "searchApi", "Lcom/avito/android/analytics/Analytics;", VKApiConst.Q, "Lcom/avito/android/analytics/Analytics;", "Lcom/avito/android/serp/SerpResourcesProvider;", "r", "Lcom/avito/android/serp/SerpResourcesProvider;", "resourcesProvider", "Lcom/avito/android/remote/model/SearchParamsConverter;", "j", "Lcom/avito/android/remote/model/SearchParamsConverter;", "searchParamsConverter", "c", "Ljava/lang/String;", a2.g.r.g.a, "emptySearch", "Lcom/avito/android/remote/model/SuggestParamsConverter;", "k", "Lcom/avito/android/remote/model/SuggestParamsConverter;", "suggestParamsConverter", "Lcom/avito/android/remote/model/PageParams;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/PageParams;", "Lcom/avito/android/serp/SerpArguments;", "h", "Lcom/avito/android/serp/SerpArguments;", "serpArguments", "Lcom/avito/android/serp/InlineFiltersInteractor;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/serp/InlineFiltersInteractor;", "inlineFiltersInteractor", "<init>", "(Lcom/avito/android/serp/SerpArguments;Lcom/avito/android/remote/SearchApi;Lcom/avito/android/remote/model/SearchParamsConverter;Lcom/avito/android/remote/model/SuggestParamsConverter;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/serp/CommercialBannersInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/serp/SerpItemProcessor;Lcom/avito/android/serp/adapter/SerpItemAligner;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/serp/SerpResourcesProvider;Lcom/avito/android/profile/ProfileInfoStorage;Lcom/avito/android/Features;Lcom/avito/android/search/subscriptions/SerpSearchSubscriptionInteractor;Lcom/avito/android/search/SearchDeepLinkInteractor;Lcom/avito/android/serp/warning/WarningStateProvider;Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;Lcom/avito/android/serp/analytics/SerpTracker;Lcom/avito/android/serp/SerpSnippetInteractor;Lcom/avito/android/serp/InlineFiltersInteractor;ZLcom/avito/android/util/Kundle;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpInteractorImpl implements SerpInteractor, SearchDeepLinkInteractor {
    public final InlineFiltersInteractor A;
    public final boolean B;
    public SearchParams a;
    public PageParams b;
    public String c;
    public int d;
    public SerpValues e;
    public boolean f;
    public boolean g;
    public final SerpArguments h;
    public final SearchApi i;
    public final SearchParamsConverter j;
    public final SuggestParamsConverter k;
    public final TypedErrorThrowableConverter l;
    public final CommercialBannersInteractor m;
    public final SchedulersFactory3 n;
    public final SerpItemProcessor o;
    public final SerpItemAligner p;
    public final Analytics q;
    public final SerpResourcesProvider r;
    public final ProfileInfoStorage s;
    public final Features t;
    public final SerpSearchSubscriptionInteractor u;
    public final SearchDeepLinkInteractor v;
    public final WarningStateProvider w;
    public final NotificationManagerProvider x;
    public final SerpTracker y;
    public final SerpSnippetInteractor z;

    public static final class a<T> implements Predicate<ViewTypeSerpItem> {
        public static final a a = new a();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(ViewTypeSerpItem viewTypeSerpItem) {
            ViewTypeSerpItem viewTypeSerpItem2 = viewTypeSerpItem;
            return (viewTypeSerpItem2 instanceof SerpCommercialBanner) && ((SerpCommercialBanner) viewTypeSerpItem2).getHasNotLoadedAd();
        }
    }

    public static final class b<T, R> implements Function<ViewTypeSerpItem, SerpCommercialBanner> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SerpCommercialBanner apply(ViewTypeSerpItem viewTypeSerpItem) {
            ViewTypeSerpItem viewTypeSerpItem2 = viewTypeSerpItem;
            Objects.requireNonNull(viewTypeSerpItem2, "null cannot be cast to non-null type com.avito.android.serp.adapter.SerpCommercialBanner");
            return (SerpCommercialBanner) viewTypeSerpItem2;
        }
    }

    public static final class c<T, R> implements Function<SerpCommercialBanner, ObservableSource<? extends SerpCommercialBanner>> {
        public final /* synthetic */ SerpInteractorImpl a;
        public final /* synthetic */ long b;

        public c(SerpInteractorImpl serpInteractorImpl, long j) {
            this.a = serpInteractorImpl;
            this.b = j;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends SerpCommercialBanner> apply(SerpCommercialBanner serpCommercialBanner) {
            SerpCommercialBanner serpCommercialBanner2 = serpCommercialBanner;
            CommercialBanner commercialBanner = serpCommercialBanner2.getCommercialBanner();
            Objects.requireNonNull(commercialBanner, "null cannot be cast to non-null type com.avito.android.remote.model.CommercialBanner");
            CommercialBannersInteractor commercialBannersInteractor = this.a.m;
            long j = this.b;
            SearchParams searchParams = this.a.a;
            String str = null;
            String categoryId = searchParams != null ? searchParams.getCategoryId() : null;
            SearchParams searchParams2 = this.a.a;
            if (searchParams2 != null) {
                str = searchParams2.getLocationId();
            }
            return commercialBannersInteractor.loadBanner(commercialBanner, j, categoryId, str).map(new a2.a.a.n2.d(serpCommercialBanner2)).onErrorReturn(new a2.a.a.n2.e(serpCommercialBanner2));
        }
    }

    public static final class d<T, R> implements Function<SerpCommercialBanner, List<? extends ViewTypeSerpItem>> {
        public final /* synthetic */ SerpInteractorImpl a;
        public final /* synthetic */ SerpDisplayType b;

        public d(SerpInteractorImpl serpInteractorImpl, SerpDisplayType serpDisplayType) {
            this.a = serpInteractorImpl;
            this.b = serpDisplayType;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public List<? extends ViewTypeSerpItem> apply(SerpCommercialBanner serpCommercialBanner) {
            return this.a.o.convertSync(t6.n.d.listOf(serpCommercialBanner), this.b);
        }
    }

    public static final class e<T> implements Predicate<List<? extends ViewTypeSerpItem>> {
        public static final e a = new e();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(List<? extends ViewTypeSerpItem> list) {
            List<? extends ViewTypeSerpItem> list2 = list;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            return !list2.isEmpty();
        }
    }

    public static final class f<T, R> implements Function<List<? extends ViewTypeSerpItem>, ViewTypeSerpItem> {
        public static final f a = new f();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ViewTypeSerpItem apply(List<? extends ViewTypeSerpItem> list) {
            List<? extends ViewTypeSerpItem> list2 = list;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            return (ViewTypeSerpItem) CollectionsKt___CollectionsKt.first((List<? extends Object>) list2);
        }
    }

    public static final class g<T, R> implements Function<SerpParameters, ObservableSource<? extends LoadingState<? super Serp>>> {
        public final /* synthetic */ SerpInteractorImpl a;
        public final /* synthetic */ SerpPageParams b;
        public final /* synthetic */ SerpDisplayType c;
        public final /* synthetic */ List d;
        public final /* synthetic */ int e;

        public g(SerpInteractorImpl serpInteractorImpl, SerpPageParams serpPageParams, SerpDisplayType serpDisplayType, List list, int i) {
            this.a = serpInteractorImpl;
            this.b = serpPageParams;
            this.c = serpDisplayType;
            this.d = list;
            this.e = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: io.reactivex.rxjava3.core.Observable */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends LoadingState<? super Serp>> apply(SerpParameters serpParameters) {
            SerpParameters serpParameters2 = serpParameters;
            SerpInteractorImpl serpInteractorImpl = this.a;
            SearchParams searchParams = serpParameters2.getSearchParams();
            SerpPageParams serpPageParams = this.b;
            String context = serpParameters2.getContext();
            SerpDisplayType serpDisplayType = this.c;
            List list = this.d;
            int i = this.e;
            Intrinsics.checkNotNullExpressionValue(serpParameters2, "it");
            return Observable.merge(serpInteractorImpl.a(searchParams, serpPageParams, context, serpDisplayType, list, i, serpParameters2), SerpInteractorImpl.access$loadInlineFiltersObservable(this.a, serpParameters2.getSearchParams())).startWithItem(new LoadingState.Loaded(new SerpParams(serpParameters2)));
        }
    }

    public static final class h<T, R> implements Function<Throwable, LoadingState<? super Serp>> {
        public final /* synthetic */ SerpInteractorImpl a;

        public h(SerpInteractorImpl serpInteractorImpl) {
            this.a = serpInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super Serp> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.l;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    public static final class i<T, R> implements Function<SerpElementResultWithPageParams, ObservableSource<? extends SerpPage>> {
        public final /* synthetic */ SerpInteractorImpl a;
        public final /* synthetic */ SerpPageParams b;
        public final /* synthetic */ SerpDisplayType c;
        public final /* synthetic */ List d;
        public final /* synthetic */ int e;
        public final /* synthetic */ SerpParameters f;

        public i(SerpInteractorImpl serpInteractorImpl, SerpPageParams serpPageParams, SerpDisplayType serpDisplayType, List list, int i, SerpParameters serpParameters) {
            this.a = serpInteractorImpl;
            this.b = serpPageParams;
            this.c = serpDisplayType;
            this.d = list;
            this.e = i;
            this.f = serpParameters;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends SerpPage> apply(SerpElementResultWithPageParams serpElementResultWithPageParams) {
            SerpElementResultWithPageParams serpElementResultWithPageParams2 = serpElementResultWithPageParams;
            this.a.y.trackAdvertsLoaded(this.b.getPage());
            SerpInteractorImpl serpInteractorImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(serpElementResultWithPageParams2, "result");
            return SerpInteractorImpl.access$prepareSerp(serpInteractorImpl, serpElementResultWithPageParams2, this.c, this.d, this.e, this.f);
        }
    }

    public static final class j<T, R> implements Function<SerpPage, LoadingState<? super SerpPage>> {
        public static final j a = new j();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super SerpPage> apply(SerpPage serpPage) {
            return new LoadingState.Loaded(serpPage);
        }
    }

    public static final class k<T, R> implements Function<Throwable, LoadingState<? super SerpPage>> {
        public final /* synthetic */ SerpInteractorImpl a;

        public k(SerpInteractorImpl serpInteractorImpl) {
            this.a = serpInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super SerpPage> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.l;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    public static final class l<T, R> implements Function<SuggestResponse, List<? extends SuggestItem>> {
        public static final l a = new l();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public List<? extends SuggestItem> apply(SuggestResponse suggestResponse) {
            return CollectionsKt___CollectionsKt.filterNotNull(suggestResponse.getResult());
        }
    }

    public static final class m<V> implements Callable<List<? extends ViewTypeSerpItem>> {
        public final /* synthetic */ SerpInteractorImpl a;
        public final /* synthetic */ SerpDisplayType b;
        public final /* synthetic */ List c;

        public m(SerpInteractorImpl serpInteractorImpl, SerpDisplayType serpDisplayType, List list) {
            this.a = serpInteractorImpl;
            this.b = serpDisplayType;
            this.c = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<? extends ViewTypeSerpItem> call() {
            SerpInteractorImpl serpInteractorImpl = this.a;
            return SerpInteractorImpl.access$handlePositionRecalculationAsync(serpInteractorImpl, serpInteractorImpl.r.getColumnsCount(this.b), this.c);
        }
    }

    public static final class n implements Action {
        public final /* synthetic */ SerpInteractorImpl a;

        public n(SerpInteractorImpl serpInteractorImpl) {
            this.a = serpInteractorImpl;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            this.a.y.trackAdvertsLoaded(SerpInteractorImpl.access$getPageParams$p(this.a).getPage());
        }
    }

    @Inject
    public SerpInteractorImpl(@NotNull SerpArguments serpArguments, @NotNull SearchApi searchApi, @SerpInteractorModule.SerpSearchParamsConverter @NotNull SearchParamsConverter searchParamsConverter, @NotNull SuggestParamsConverter suggestParamsConverter, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull CommercialBannersInteractor commercialBannersInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull SerpItemProcessor serpItemProcessor, @NotNull SerpItemAligner serpItemAligner, @NotNull Analytics analytics, @NotNull SerpResourcesProvider serpResourcesProvider, @NotNull ProfileInfoStorage profileInfoStorage, @NotNull Features features, @NotNull SerpSearchSubscriptionInteractor serpSearchSubscriptionInteractor, @NotNull SearchDeepLinkInteractor searchDeepLinkInteractor, @NotNull WarningStateProvider warningStateProvider, @NotNull NotificationManagerProvider notificationManagerProvider, @NotNull SerpTracker serpTracker, @NotNull SerpSnippetInteractor serpSnippetInteractor, @NotNull InlineFiltersInteractor inlineFiltersInteractor, @SerpInteractorModule.ShowJobNearbyBanner boolean z2, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(serpArguments, "serpArguments");
        Intrinsics.checkNotNullParameter(searchApi, "searchApi");
        Intrinsics.checkNotNullParameter(searchParamsConverter, "searchParamsConverter");
        Intrinsics.checkNotNullParameter(suggestParamsConverter, "suggestParamsConverter");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(commercialBannersInteractor, "commercialBannersInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(serpItemProcessor, "itemProcessor");
        Intrinsics.checkNotNullParameter(serpItemAligner, "aligner");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(serpResourcesProvider, "resourcesProvider");
        Intrinsics.checkNotNullParameter(profileInfoStorage, "profileInfoStorage");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(serpSearchSubscriptionInteractor, "searchSubscriptionInteractor");
        Intrinsics.checkNotNullParameter(searchDeepLinkInteractor, "searchDeepLinkInteractor");
        Intrinsics.checkNotNullParameter(warningStateProvider, "warningStateProvider");
        Intrinsics.checkNotNullParameter(notificationManagerProvider, "notificationManagerProvider");
        Intrinsics.checkNotNullParameter(serpTracker, "tracker");
        Intrinsics.checkNotNullParameter(serpSnippetInteractor, "serpSnippetInteractor");
        Intrinsics.checkNotNullParameter(inlineFiltersInteractor, "inlineFiltersInteractor");
        this.h = serpArguments;
        this.i = searchApi;
        this.j = searchParamsConverter;
        this.k = suggestParamsConverter;
        this.l = typedErrorThrowableConverter;
        this.m = commercialBannersInteractor;
        this.n = schedulersFactory3;
        this.o = serpItemProcessor;
        this.p = serpItemAligner;
        this.q = analytics;
        this.r = serpResourcesProvider;
        this.s = profileInfoStorage;
        this.t = features;
        this.u = serpSearchSubscriptionInteractor;
        this.v = searchDeepLinkInteractor;
        this.w = warningStateProvider;
        this.x = notificationManagerProvider;
        this.y = serpTracker;
        this.z = serpSnippetInteractor;
        this.A = inlineFiltersInteractor;
        this.B = z2;
        this.a = serpArguments.getSearchParams();
        this.c = serpArguments.getContext();
        restoreState(kundle);
    }

    public static final List access$addJobNearbyBanner(SerpInteractorImpl serpInteractorImpl, SerpElementResult serpElementResult) {
        Objects.requireNonNull(serpInteractorImpl);
        List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) serpElementResult.getElements());
        mutableList.add(0, new SerpWarning("jobNearbyWarningItem", "Вы видите вакансии в радиусе 10 км. Чтобы найти другие предложения, уточните запрос.", Boolean.TRUE, new Image(q.mapOf(TuplesKt.to(new Size(320, 320), UriUtil.getUriForResourceId(R.drawable.img_radius_80)))), null));
        return mutableList;
    }

    public static final List access$convertItems(SerpInteractorImpl serpInteractorImpl, List list, SerpDisplayType serpDisplayType) {
        return serpInteractorImpl.o.convertSync(list, serpDisplayType);
    }

    public static final SerpElement access$createEmptySearchItem(SerpInteractorImpl serpInteractorImpl, String str) {
        Objects.requireNonNull(serpInteractorImpl);
        if (str == null) {
            str = serpInteractorImpl.r.getEmptySearchText();
        }
        return new EmptySearchElement(a2.b.a.a.a.I2("UUID.randomUUID().toString()"), str);
    }

    public static final int access$getAligningShiftIndexForLastItem(SerpInteractorImpl serpInteractorImpl, List list) {
        return serpInteractorImpl.p.getAligningShiftItemIndex(list, CollectionsKt__CollectionsKt.getLastIndex(list));
    }

    public static final /* synthetic */ PageParams access$getPageParams$p(SerpInteractorImpl serpInteractorImpl) {
        PageParams pageParams = serpInteractorImpl.b;
        if (pageParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageParams");
        }
        return pageParams;
    }

    public static final String access$getSearchHint(SerpInteractorImpl serpInteractorImpl, SerpElementResult serpElementResult) {
        Objects.requireNonNull(serpInteractorImpl);
        String searchHint = serpElementResult.getSearchHint();
        return (searchHint == null || !(t6.y.m.isBlank(searchHint) ^ true)) ? serpInteractorImpl.r.getSearchHint() : searchHint;
    }

    public static final List access$handlePositionRecalculationAsync(SerpInteractorImpl serpInteractorImpl, int i2, List list) {
        boolean z2 = serpInteractorImpl.d != i2;
        serpInteractorImpl.d = i2;
        return z2 ? serpInteractorImpl.o.sort(list, i2) : list;
    }

    public static final boolean access$isEmpty(SerpInteractorImpl serpInteractorImpl, SerpElementResult serpElementResult) {
        Objects.requireNonNull(serpInteractorImpl);
        return serpElementResult.getElements().isEmpty();
    }

    public static final Observable access$loadInlineFiltersObservable(SerpInteractorImpl serpInteractorImpl, SearchParams searchParams) {
        Observable onErrorReturn = InlineFiltersInteractor.DefaultImpls.loadInlineFilters$default(serpInteractorImpl.A, searchParams, r.emptyMap(), false, 4, null).map(a2.a.a.n2.f.a).onErrorReturn(a2.a.a.n2.g.a);
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "inlineFiltersInteractor\n…ters(null))\n            }");
        return onErrorReturn;
    }

    public static final Observable access$prepareSerp(SerpInteractorImpl serpInteractorImpl, SerpElementResultWithPageParams serpElementResultWithPageParams, SerpDisplayType serpDisplayType, List list, int i2, SerpParameters serpParameters) {
        Objects.requireNonNull(serpInteractorImpl);
        Observable subscribeOn = Observable.fromCallable(new a2.a.a.n2.m(serpInteractorImpl, serpElementResultWithPageParams, serpDisplayType, list, i2, serpParameters)).doOnNext(new a2.a.a.n2.n(serpInteractorImpl)).subscribeOn(serpInteractorImpl.n.computation());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "Observable.fromCallable …schedulers.computation())");
        return subscribeOn;
    }

    public static final void access$sendSearchResultEvent(SerpInteractorImpl serpInteractorImpl, List list) {
        Objects.requireNonNull(serpInteractorImpl);
        Sequence filter = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(list), SerpInteractorImpl$sendSearchResultEvent$$inlined$filterIsInstance$1.INSTANCE);
        Objects.requireNonNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
        serpInteractorImpl.q.track(new SearchResultEvent(serpInteractorImpl.s.getProfileInfo().getEmail(), SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.map(filter, o.a))));
    }

    public static final List access$sort(SerpInteractorImpl serpInteractorImpl, List list, int i2) {
        return serpInteractorImpl.o.sortAndAdjustSync(list, i2);
    }

    public static final void access$updateSearchSubscriptionsCount(SerpInteractorImpl serpInteractorImpl, SerpPage serpPage) {
        Objects.requireNonNull(serpInteractorImpl);
        boolean z2 = false;
        if ((serpPage.getNextPageParams().getPage() == 2) && serpPage.isSubscribed()) {
            z2 = true;
        }
        if (z2 && serpPage.getSubscriptionId() != null) {
            serpInteractorImpl.u.resetUnreadChangesCount(serpPage.getSubscriptionId());
        }
    }

    public final Observable<LoadingState<SerpPage>> a(SearchParams searchParams, SerpPageParams serpPageParams, String str, SerpDisplayType serpDisplayType, List<? extends ViewTypeSerpItem> list, int i2, SerpParameters serpParameters) {
        Observable<TypedResult<SerpElementResult>> observable;
        if (serpPageParams.isFirstPage()) {
            this.g = false;
        }
        this.y.startLoadingAdverts();
        this.a = searchParams;
        Integer valueOf = Integer.valueOf(serpPageParams.getPage());
        Long lastStamp = serpPageParams.getLastStamp();
        String parameterValue = serpDisplayType != null ? SerpDisplayTypeKt.toParameterValue(serpDisplayType) : null;
        Boolean valueOf2 = Boolean.valueOf(this.x.getAreNotificationsEnabled());
        Map<String, String> convertToMap$default = SearchParamsConverter.DefaultImpls.convertToMap$default(this.j, searchParams, null, false, false, 14, null);
        String nextPageId = serpPageParams.getNextPageId();
        Boolean forcedLocationForRecommendation = searchParams.getForcedLocationForRecommendation();
        if (this.t.getSerp11items().invoke().booleanValue()) {
            observable = this.i.getSerpElementTypedResultV11(valueOf, lastStamp, parameterValue, str, valueOf2, nextPageId, convertToMap$default, forcedLocationForRecommendation);
        } else {
            observable = this.i.getSerpElementTypedResult(valueOf, lastStamp, parameterValue, str, valueOf2, nextPageId, convertToMap$default, forcedLocationForRecommendation);
        }
        Observable flatMap = observable.flatMap(new a2.a.a.n2.k(this, serpPageParams)).subscribeOn(this.n.io()).flatMap(a2.a.a.n2.l.a);
        Intrinsics.checkNotNullExpressionValue(flatMap, "getSerpElementTypedResul…bservable()\n            }");
        Observable<LoadingState<SerpPage>> onErrorReturn = flatMap.subscribeOn(this.n.io()).flatMap(new i(this, serpPageParams, serpDisplayType, list, i2, serpParameters)).map(j.a).startWithItem(LoadingState.Loading.INSTANCE).onErrorReturn(new k(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "loadSerpResult(searchPar…eConverter.convert(it)) }");
        return onErrorReturn;
    }

    @Override // com.avito.android.serp.SerpInteractor
    public void closeWarning(@NotNull SerpWarningItem serpWarningItem) {
        Intrinsics.checkNotNullParameter(serpWarningItem, "warning");
        this.w.setState(serpWarningItem.getStringId(), WarningState.HIDE);
    }

    @Override // com.avito.android.serp.SerpInteractor
    public int getPage() {
        PageParams pageParams = this.b;
        if (pageParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageParams");
        }
        return pageParams.getPage();
    }

    @Override // com.avito.android.serp.SerpInteractor
    public void invalidate() {
        PageParams build = new PageParams.Builder().build();
        Intrinsics.checkNotNullExpressionValue(build, "PageParams.Builder().build()");
        this.b = build;
        this.c = null;
        this.g = false;
    }

    @Override // com.avito.android.serp.SerpInteractor
    public boolean isEmptySearch() {
        return this.g;
    }

    @Override // com.avito.android.serp.SerpInteractor
    @NotNull
    public Observable<ViewTypeSerpItem> loadAds(@NotNull List<? extends ViewTypeSerpItem> list, @NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Observable<ViewTypeSerpItem> map = Observable.fromIterable(list).filter(a.a).map(b.a).flatMap(new c(this, this.m.getPageCdtm())).map(new d(this, serpDisplayType)).filter(e.a).map(f.a);
        Intrinsics.checkNotNullExpressionValue(map, "Observable.fromIterable(…      .map { it.first() }");
        return map;
    }

    @Override // com.avito.android.search.SearchDeepLinkInteractor
    @NotNull
    public Observable<LoadingState<DeepLink>> loadSearchDeepLink(@NotNull String str, @NotNull SearchParams searchParams, @Nullable String str2, @Nullable Boolean bool, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "query");
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        return this.v.loadSearchDeepLink(str, searchParams, str2, bool, z2);
    }

    @Override // com.avito.android.serp.SerpInteractor
    @NotNull
    public Observable<LoadingState<Serp>> loadSerp(@Nullable SerpParameters serpParameters, @NotNull SerpPageParams serpPageParams, @Nullable SerpDisplayType serpDisplayType, @NotNull List<? extends ViewTypeSerpItem> list) {
        Observable<LoadingState<SerpPage>> observable;
        Observable observable2;
        Intrinsics.checkNotNullParameter(serpPageParams, "pageParams");
        Intrinsics.checkNotNullParameter(list, "notSortedItems");
        int columnsCount = this.r.getColumnsCount(serpDisplayType);
        if (serpParameters == null) {
            SearchParams searchParams = this.a;
            if (searchParams != null) {
                this.y.startLoadingParamsTransitFromMemory();
                observable2 = Observable.just(new SerpParameters(searchParams, this.c));
                Intrinsics.checkNotNullExpressionValue(observable2, "Observable.just(this)");
            } else {
                String subscriptionId = this.h.getSubscriptionId();
                if (subscriptionId == null) {
                    subscriptionId = "";
                }
                this.y.startLoadingParamsBySubscriptionId();
                Observable doOnNext = Observables.filterDefined(this.u.loadSearchParams(subscriptionId)).switchIfEmpty(Observable.error(new Throwable())).doOnNext(new a2.a.a.n2.i(this));
                Intrinsics.checkNotNullExpressionValue(doOnNext, "searchSubscriptionIntera…text = null\n            }");
                observable2 = a2.b.a.a.a.b2(this.n, doOnNext.map(a2.a.a.n2.h.a), "loadSearchSubscriptionPa…(schedulers.mainThread())");
            }
            observable = observable2.flatMap(new g(this, serpPageParams, serpDisplayType, list, columnsCount)).startWithItem(LoadingState.Loading.INSTANCE);
        } else {
            observable = a(serpParameters.getSearchParams(), serpPageParams, serpParameters.getContext(), serpDisplayType, list, columnsCount, serpParameters);
        }
        Objects.requireNonNull(observable, "null cannot be cast to non-null type io.reactivex.rxjava3.core.Observable<com.avito.android.util.LoadingState<com.avito.android.serp.Serp>>");
        Observable<LoadingState<SerpPage>> onErrorReturn = observable.onErrorReturn(new h(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "(if (serpParameters == n…eConverter.convert(it)) }");
        return onErrorReturn;
    }

    @Override // com.avito.android.component.search.SuggestInteractor
    @NotNull
    public Observable<List<SuggestItem>> loadSuggestions(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        SearchParams searchParams = this.a;
        Map<String, String> convertToMap = searchParams != null ? this.k.convertToMap(searchParams) : null;
        if (convertToMap != null) {
            Observable<R> map = this.i.getSearchSuggestV8(str, convertToMap).subscribeOn(this.n.io()).map(l.a);
            Intrinsics.checkNotNullExpressionValue(map, "searchApi.getSearchSugge….result.filterNotNull() }");
            return map;
        }
        Observable<List<SuggestItem>> empty = Observable.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Observable.empty()");
        return empty;
    }

    @Override // com.avito.android.serp.SerpInteractor
    @NotNull
    public Kundle onSaveState() {
        Kundle putParcelable = new Kundle().putParcelable("key_search_params", this.a);
        PageParams pageParams = this.b;
        if (pageParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageParams");
        }
        return putParcelable.putParcelable("key_page_params", pageParams).putInt("key_columns", Integer.valueOf(this.d)).putParcelable("key_serp_values", this.e).putString("key_context", this.c).putBoolean("key_is_empty_search", Boolean.valueOf(this.g));
    }

    @Override // com.avito.android.serp.SerpInteractor
    @NotNull
    public Observable<List<ViewTypeSerpItem>> restoreSerp(@NotNull SerpDisplayType serpDisplayType, @NotNull List<? extends ViewTypeSerpItem> list) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(list, "items");
        this.y.startLocalLoadingAdverts();
        return a2.b.a.a.a.a2(this.n, Observable.fromCallable(new m(this, serpDisplayType, list)).doOnComplete(new n(this)), "Observable\n            .…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.serp.SerpInteractor
    public void restoreState(@Nullable Kundle kundle) {
        SearchParams searchParams;
        PageParams pageParams;
        String str;
        Boolean bool;
        Integer num;
        if (kundle == null || (searchParams = (SearchParams) kundle.getParcelable("key_search_params")) == null) {
            searchParams = this.h.getSearchParams();
        }
        this.a = searchParams;
        if (kundle == null || (pageParams = (PageParams) kundle.getParcelable("key_page_params")) == null) {
            pageParams = new PageParams.Builder().build();
            Intrinsics.checkNotNullExpressionValue(pageParams, "PageParams.Builder().build()");
        }
        this.b = pageParams;
        if (kundle == null || (str = kundle.getString("key_context")) == null) {
            str = this.h.getContext();
        }
        this.c = str;
        boolean z2 = false;
        this.d = (kundle == null || (num = kundle.getInt("key_columns")) == null) ? 0 : num.intValue();
        this.e = kundle != null ? (SerpValues) kundle.getParcelable("key_serp_values") : null;
        if (!(kundle == null || (bool = kundle.getBoolean("key_is_empty_search")) == null)) {
            z2 = bool.booleanValue();
        }
        this.g = z2;
    }

    @Override // com.avito.android.serp.SerpInteractor
    public void sendSnippetActionClick(@NotNull String str, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.z.sendClick(str, map);
    }

    @Override // com.avito.android.serp.SerpInteractor
    public void sendSnippetActionClose(@NotNull String str, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.z.sendClose(str, map);
    }

    @Override // com.avito.android.serp.SerpInteractor
    public void sendSnippetActionHide(@NotNull String str, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.z.sendHide(str, map);
    }

    @Override // com.avito.android.serp.SerpInteractor
    public void sendSnippetActionShow(@NotNull String str, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.z.sendShow(str, map);
    }
}
