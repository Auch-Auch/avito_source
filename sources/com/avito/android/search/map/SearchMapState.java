package com.avito.android.search.map;

import a2.b.a.a.a;
import a2.g.r.g;
import android.net.Uri;
import com.avito.android.redux.State;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.search.InlineFilters;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.remote.model.search.map.Counter;
import com.avito.android.remote.model.search.map.GoToSerpButton;
import com.avito.android.search.map.interactor.SerpDataSources;
import com.avito.android.search.map.interactor.SerpKey;
import com.avito.android.search.map.view.MarkerItem;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.android.search.map.view.adapter.AppendingState;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.avito.android.util.UrlParams;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItem;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b#\b\b\u0018\u00002\u00020\u0001:\u0003KLMBi\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u001e\u001a\u00020\t\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010 \u001a\u00020\u000f\u0012\u0006\u0010!\u001a\u00020\u0012\u0012\b\b\u0002\u0010\"\u001a\u00020\u0015\u0012\b\b\u0002\u0010#\u001a\u00020\u0018\u0012\b\b\u0002\u0010$\u001a\u00020\u0018¢\u0006\u0004\bI\u0010JJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001aJv\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u001e\u001a\u00020\t2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u00122\b\b\u0002\u0010\"\u001a\u00020\u00152\b\b\u0002\u0010#\u001a\u00020\u00182\b\b\u0002\u0010$\u001a\u00020\u0018HÆ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b'\u0010\u000eJ\u0010\u0010)\u001a\u00020(HÖ\u0001¢\u0006\u0004\b)\u0010*J\u001a\u0010-\u001a\u00020\u00182\b\u0010,\u001a\u0004\u0018\u00010+HÖ\u0003¢\u0006\u0004\b-\u0010.R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\u0004R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u0010\u000eR\u0019\u0010!\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u0010\u0014R\u0019\u0010\"\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010\u0017R\u0019\u0010$\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010\u001aR\u0019\u0010\u001e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010\u000bR!\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010\bR\u0019\u0010#\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010<\u001a\u0004\bE\u0010\u001aR\u0019\u0010 \u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010\u0011¨\u0006N"}, d2 = {"Lcom/avito/android/search/map/SearchMapState;", "Lcom/avito/android/redux/State;", "Lcom/avito/android/remote/model/search/InlineFilters;", "component1", "()Lcom/avito/android/remote/model/search/InlineFilters;", "", "Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutNavigationItem;", "component2", "()Ljava/util/List;", "Lcom/avito/android/remote/model/SearchParams;", "component3", "()Lcom/avito/android/remote/model/SearchParams;", "", "component4", "()Ljava/lang/String;", "Lcom/avito/android/search/map/SearchMapState$MapState;", "component5", "()Lcom/avito/android/search/map/SearchMapState$MapState;", "Lcom/avito/android/search/map/SearchMapState$SerpState;", "component6", "()Lcom/avito/android/search/map/SearchMapState$SerpState;", "Lcom/avito/android/search/map/SearchMapState$PinAdvertsState;", "component7", "()Lcom/avito/android/search/map/SearchMapState$PinAdvertsState;", "", "component8", "()Z", "component9", "inlineFilters", "shortcutItems", "searchParams", "query", "mapState", "serpState", "pinAdvertsState", "enableLocationPermission", UrlParams.SIMPLE_MAP, "copy", "(Lcom/avito/android/remote/model/search/InlineFilters;Ljava/util/List;Lcom/avito/android/remote/model/SearchParams;Ljava/lang/String;Lcom/avito/android/search/map/SearchMapState$MapState;Lcom/avito/android/search/map/SearchMapState$SerpState;Lcom/avito/android/search/map/SearchMapState$PinAdvertsState;ZZ)Lcom/avito/android/search/map/SearchMapState;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/search/InlineFilters;", "getInlineFilters", "d", "Ljava/lang/String;", "getQuery", "f", "Lcom/avito/android/search/map/SearchMapState$SerpState;", "getSerpState", g.a, "Lcom/avito/android/search/map/SearchMapState$PinAdvertsState;", "getPinAdvertsState", "i", "Z", "getShowSimpleMap", "c", "Lcom/avito/android/remote/model/SearchParams;", "getSearchParams", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getShortcutItems", "h", "getEnableLocationPermission", "e", "Lcom/avito/android/search/map/SearchMapState$MapState;", "getMapState", "<init>", "(Lcom/avito/android/remote/model/search/InlineFilters;Ljava/util/List;Lcom/avito/android/remote/model/SearchParams;Ljava/lang/String;Lcom/avito/android/search/map/SearchMapState$MapState;Lcom/avito/android/search/map/SearchMapState$SerpState;Lcom/avito/android/search/map/SearchMapState$PinAdvertsState;ZZ)V", "MapState", "PinAdvertsState", "SerpState", "map_release"}, k = 1, mv = {1, 4, 2})
public final class SearchMapState implements State {
    @Nullable
    public final InlineFilters a;
    @Nullable
    public final List<ShortcutNavigationItem> b;
    @NotNull
    public final SearchParams c;
    @Nullable
    public final String d;
    @NotNull
    public final MapState e;
    @NotNull
    public final SerpState f;
    @NotNull
    public final PinAdvertsState g;
    public final boolean h;
    public final boolean i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b5\b\b\u0018\u00002\u00020\u0001Bß\u0001\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010,\u001a\u00020\t\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010.\u001a\u00020\u000f\u0012\b\b\u0002\u0010/\u001a\u00020\t\u0012\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u00104\u001a\u00020\t\u0012\b\b\u0002\u00105\u001a\u00020\t\u0012\b\b\u0002\u00106\u001a\u00020\t\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u00108\u001a\u00020\t\u0012\b\b\u0002\u00109\u001a\u00020\t\u0012\b\b\u0002\u0010:\u001a\u00020\t\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010&¢\u0006\u0004\br\u0010sJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000bJ\u0018\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u001f\u0010\u000bJ\u0010\u0010 \u001a\u00020\tHÆ\u0003¢\u0006\u0004\b \u0010\u000bJ\u0010\u0010!\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b!\u0010\u000bJ\u0012\u0010\"\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\"\u0010\u000eJ\u0010\u0010#\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b#\u0010\u000bJ\u0010\u0010$\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b$\u0010\u000bJ\u0010\u0010%\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b%\u0010\u000bJ\u0012\u0010'\u001a\u0004\u0018\u00010&HÆ\u0003¢\u0006\u0004\b'\u0010(Jè\u0001\u0010<\u001a\u00020\u00002\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010,\u001a\u00020\t2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\t2\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u00104\u001a\u00020\t2\b\b\u0002\u00105\u001a\u00020\t2\b\b\u0002\u00106\u001a\u00020\t2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\f2\b\b\u0002\u00108\u001a\u00020\t2\b\b\u0002\u00109\u001a\u00020\t2\b\b\u0002\u0010:\u001a\u00020\t2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010&HÆ\u0001¢\u0006\u0004\b<\u0010=J\u0010\u0010>\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b>\u0010\u001bJ\u0010\u0010@\u001a\u00020?HÖ\u0001¢\u0006\u0004\b@\u0010AJ\u001a\u0010C\u001a\u00020\t2\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bC\u0010DR\u0019\u0010.\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010\u0011R\u001b\u0010*\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010\u0007R\u001b\u00103\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010\u001eR\u001b\u0010-\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010\u000eR\u0019\u00104\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010\u000bR\u0019\u00105\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\bT\u0010R\u001a\u0004\bU\u0010\u000bR!\u00100\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010\u0016R\u0019\u0010/\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\bY\u0010R\u001a\u0004\b/\u0010\u000bR\u001b\u00107\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\bZ\u0010O\u001a\u0004\b[\u0010\u000eR\u001b\u0010+\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\\\u0010I\u001a\u0004\b]\u0010\u0007R\u001b\u00101\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010\u0018R\u0019\u00106\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\ba\u0010R\u001a\u0004\bb\u0010\u000bR\u001b\u0010;\u001a\u0004\u0018\u00010&8\u0006@\u0006¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010(R\u001b\u00102\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010\u001bR\u001b\u0010)\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010\u0004R\u0019\u00108\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\bl\u0010R\u001a\u0004\bm\u0010\u000bR\u0019\u00109\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\bn\u0010R\u001a\u0004\b9\u0010\u000bR\u0019\u0010:\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\bo\u0010R\u001a\u0004\bp\u0010\u000bR\u0019\u0010,\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\bq\u0010R\u001a\u0004\b,\u0010\u000b¨\u0006t"}, d2 = {"Lcom/avito/android/search/map/SearchMapState$MapState;", "", "", "component1", "()Ljava/lang/Float;", "Lcom/google/android/gms/maps/model/LatLngBounds;", "component2", "()Lcom/google/android/gms/maps/model/LatLngBounds;", "component3", "", "component4", "()Z", "Lcom/google/android/gms/maps/model/LatLng;", "component5", "()Lcom/google/android/gms/maps/model/LatLng;", "Lcom/avito/android/search/map/LoadState;", "component6", "()Lcom/avito/android/search/map/LoadState;", "component7", "", "Lcom/avito/android/search/map/view/MarkerItem;", "component8", "()Ljava/util/List;", "component9", "()Lcom/avito/android/search/map/view/MarkerItem;", "", "component10", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/search/map/Counter;", "component11", "()Lcom/avito/android/remote/model/search/map/Counter;", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "Lcom/avito/android/remote/model/search/map/GoToSerpButton;", "component19", "()Lcom/avito/android/remote/model/search/map/GoToSerpButton;", "zoom", "mapBounds", "initialMapBounds", "isMapMoving", VKApiConst.POSITION, "markersState", "isMapReady", "markerItems", "myLocation", "selectedPinId", "counters", "shortcutsVisibility", "cameraSettledFirstTime", "needToUpdateViewedMarkers", "forcedCenterCoordinates", "mapBoundsSetByServer", "isMapVisible", "zoomButtonVisibility", "goToSerpButton", "copy", "(Ljava/lang/Float;Lcom/google/android/gms/maps/model/LatLngBounds;Lcom/google/android/gms/maps/model/LatLngBounds;ZLcom/google/android/gms/maps/model/LatLng;Lcom/avito/android/search/map/LoadState;ZLjava/util/List;Lcom/avito/android/search/map/view/MarkerItem;Ljava/lang/String;Lcom/avito/android/remote/model/search/map/Counter;ZZZLcom/google/android/gms/maps/model/LatLng;ZZZLcom/avito/android/remote/model/search/map/GoToSerpButton;)Lcom/avito/android/search/map/SearchMapState$MapState;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "f", "Lcom/avito/android/search/map/LoadState;", "getMarkersState", AuthSource.BOOKING_ORDER, "Lcom/google/android/gms/maps/model/LatLngBounds;", "getMapBounds", "k", "Lcom/avito/android/remote/model/search/map/Counter;", "getCounters", "e", "Lcom/google/android/gms/maps/model/LatLng;", "getPosition", "l", "Z", "getShortcutsVisibility", AuthSource.OPEN_CHANNEL_LIST, "getCameraSettledFirstTime", "h", "Ljava/util/List;", "getMarkerItems", g.a, "o", "getForcedCenterCoordinates", "c", "getInitialMapBounds", "i", "Lcom/avito/android/search/map/view/MarkerItem;", "getMyLocation", "n", "getNeedToUpdateViewedMarkers", "s", "Lcom/avito/android/remote/model/search/map/GoToSerpButton;", "getGoToSerpButton", "j", "Ljava/lang/String;", "getSelectedPinId", AuthSource.SEND_ABUSE, "Ljava/lang/Float;", "getZoom", "p", "getMapBoundsSetByServer", VKApiConst.Q, "r", "getZoomButtonVisibility", "d", "<init>", "(Ljava/lang/Float;Lcom/google/android/gms/maps/model/LatLngBounds;Lcom/google/android/gms/maps/model/LatLngBounds;ZLcom/google/android/gms/maps/model/LatLng;Lcom/avito/android/search/map/LoadState;ZLjava/util/List;Lcom/avito/android/search/map/view/MarkerItem;Ljava/lang/String;Lcom/avito/android/remote/model/search/map/Counter;ZZZLcom/google/android/gms/maps/model/LatLng;ZZZLcom/avito/android/remote/model/search/map/GoToSerpButton;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class MapState {
        @Nullable
        public final Float a;
        @Nullable
        public final LatLngBounds b;
        @Nullable
        public final LatLngBounds c;
        public final boolean d;
        @Nullable
        public final LatLng e;
        @NotNull
        public final LoadState f;
        public final boolean g;
        @Nullable
        public final List<MarkerItem> h;
        @Nullable
        public final MarkerItem i;
        @Nullable
        public final String j;
        @Nullable
        public final Counter k;
        public final boolean l;
        public final boolean m;
        public final boolean n;
        @Nullable
        public final LatLng o;
        public final boolean p;
        public final boolean q;
        public final boolean r;
        @Nullable
        public final GoToSerpButton s;

        public MapState() {
            this(null, null, null, false, null, null, false, null, null, null, null, false, false, false, null, false, false, false, null, 524287, null);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: java.util.List<? extends com.avito.android.search.map.view.MarkerItem> */
        /* JADX WARN: Multi-variable type inference failed */
        public MapState(@Nullable Float f2, @Nullable LatLngBounds latLngBounds, @Nullable LatLngBounds latLngBounds2, boolean z, @Nullable LatLng latLng, @NotNull LoadState loadState, boolean z2, @Nullable List<? extends MarkerItem> list, @Nullable MarkerItem markerItem, @Nullable String str, @Nullable Counter counter, boolean z3, boolean z4, boolean z5, @Nullable LatLng latLng2, boolean z7, boolean z8, boolean z9, @Nullable GoToSerpButton goToSerpButton) {
            Intrinsics.checkNotNullParameter(loadState, "markersState");
            this.a = f2;
            this.b = latLngBounds;
            this.c = latLngBounds2;
            this.d = z;
            this.e = latLng;
            this.f = loadState;
            this.g = z2;
            this.h = list;
            this.i = markerItem;
            this.j = str;
            this.k = counter;
            this.l = z3;
            this.m = z4;
            this.n = z5;
            this.o = latLng2;
            this.p = z7;
            this.q = z8;
            this.r = z9;
            this.s = goToSerpButton;
        }

        public static /* synthetic */ MapState copy$default(MapState mapState, Float f2, LatLngBounds latLngBounds, LatLngBounds latLngBounds2, boolean z, LatLng latLng, LoadState loadState, boolean z2, List list, MarkerItem markerItem, String str, Counter counter, boolean z3, boolean z4, boolean z5, LatLng latLng2, boolean z7, boolean z8, boolean z9, GoToSerpButton goToSerpButton, int i2, Object obj) {
            return mapState.copy((i2 & 1) != 0 ? mapState.a : f2, (i2 & 2) != 0 ? mapState.b : latLngBounds, (i2 & 4) != 0 ? mapState.c : latLngBounds2, (i2 & 8) != 0 ? mapState.d : z, (i2 & 16) != 0 ? mapState.e : latLng, (i2 & 32) != 0 ? mapState.f : loadState, (i2 & 64) != 0 ? mapState.g : z2, (i2 & 128) != 0 ? mapState.h : list, (i2 & 256) != 0 ? mapState.i : markerItem, (i2 & 512) != 0 ? mapState.j : str, (i2 & 1024) != 0 ? mapState.k : counter, (i2 & 2048) != 0 ? mapState.l : z3, (i2 & 4096) != 0 ? mapState.m : z4, (i2 & 8192) != 0 ? mapState.n : z5, (i2 & 16384) != 0 ? mapState.o : latLng2, (i2 & 32768) != 0 ? mapState.p : z7, (i2 & 65536) != 0 ? mapState.q : z8, (i2 & 131072) != 0 ? mapState.r : z9, (i2 & 262144) != 0 ? mapState.s : goToSerpButton);
        }

        @Nullable
        public final Float component1() {
            return this.a;
        }

        @Nullable
        public final String component10() {
            return this.j;
        }

        @Nullable
        public final Counter component11() {
            return this.k;
        }

        public final boolean component12() {
            return this.l;
        }

        public final boolean component13() {
            return this.m;
        }

        public final boolean component14() {
            return this.n;
        }

        @Nullable
        public final LatLng component15() {
            return this.o;
        }

        public final boolean component16() {
            return this.p;
        }

        public final boolean component17() {
            return this.q;
        }

        public final boolean component18() {
            return this.r;
        }

        @Nullable
        public final GoToSerpButton component19() {
            return this.s;
        }

        @Nullable
        public final LatLngBounds component2() {
            return this.b;
        }

        @Nullable
        public final LatLngBounds component3() {
            return this.c;
        }

        public final boolean component4() {
            return this.d;
        }

        @Nullable
        public final LatLng component5() {
            return this.e;
        }

        @NotNull
        public final LoadState component6() {
            return this.f;
        }

        public final boolean component7() {
            return this.g;
        }

        @Nullable
        public final List<MarkerItem> component8() {
            return this.h;
        }

        @Nullable
        public final MarkerItem component9() {
            return this.i;
        }

        @NotNull
        public final MapState copy(@Nullable Float f2, @Nullable LatLngBounds latLngBounds, @Nullable LatLngBounds latLngBounds2, boolean z, @Nullable LatLng latLng, @NotNull LoadState loadState, boolean z2, @Nullable List<? extends MarkerItem> list, @Nullable MarkerItem markerItem, @Nullable String str, @Nullable Counter counter, boolean z3, boolean z4, boolean z5, @Nullable LatLng latLng2, boolean z7, boolean z8, boolean z9, @Nullable GoToSerpButton goToSerpButton) {
            Intrinsics.checkNotNullParameter(loadState, "markersState");
            return new MapState(f2, latLngBounds, latLngBounds2, z, latLng, loadState, z2, list, markerItem, str, counter, z3, z4, z5, latLng2, z7, z8, z9, goToSerpButton);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MapState)) {
                return false;
            }
            MapState mapState = (MapState) obj;
            return Intrinsics.areEqual(this.a, mapState.a) && Intrinsics.areEqual(this.b, mapState.b) && Intrinsics.areEqual(this.c, mapState.c) && this.d == mapState.d && Intrinsics.areEqual(this.e, mapState.e) && Intrinsics.areEqual(this.f, mapState.f) && this.g == mapState.g && Intrinsics.areEqual(this.h, mapState.h) && Intrinsics.areEqual(this.i, mapState.i) && Intrinsics.areEqual(this.j, mapState.j) && Intrinsics.areEqual(this.k, mapState.k) && this.l == mapState.l && this.m == mapState.m && this.n == mapState.n && Intrinsics.areEqual(this.o, mapState.o) && this.p == mapState.p && this.q == mapState.q && this.r == mapState.r && Intrinsics.areEqual(this.s, mapState.s);
        }

        public final boolean getCameraSettledFirstTime() {
            return this.m;
        }

        @Nullable
        public final Counter getCounters() {
            return this.k;
        }

        @Nullable
        public final LatLng getForcedCenterCoordinates() {
            return this.o;
        }

        @Nullable
        public final GoToSerpButton getGoToSerpButton() {
            return this.s;
        }

        @Nullable
        public final LatLngBounds getInitialMapBounds() {
            return this.c;
        }

        @Nullable
        public final LatLngBounds getMapBounds() {
            return this.b;
        }

        public final boolean getMapBoundsSetByServer() {
            return this.p;
        }

        @Nullable
        public final List<MarkerItem> getMarkerItems() {
            return this.h;
        }

        @NotNull
        public final LoadState getMarkersState() {
            return this.f;
        }

        @Nullable
        public final MarkerItem getMyLocation() {
            return this.i;
        }

        public final boolean getNeedToUpdateViewedMarkers() {
            return this.n;
        }

        @Nullable
        public final LatLng getPosition() {
            return this.e;
        }

        @Nullable
        public final String getSelectedPinId() {
            return this.j;
        }

        public final boolean getShortcutsVisibility() {
            return this.l;
        }

        @Nullable
        public final Float getZoom() {
            return this.a;
        }

        public final boolean getZoomButtonVisibility() {
            return this.r;
        }

        public int hashCode() {
            Float f2 = this.a;
            int i2 = 0;
            int hashCode = (f2 != null ? f2.hashCode() : 0) * 31;
            LatLngBounds latLngBounds = this.b;
            int hashCode2 = (hashCode + (latLngBounds != null ? latLngBounds.hashCode() : 0)) * 31;
            LatLngBounds latLngBounds2 = this.c;
            int hashCode3 = (hashCode2 + (latLngBounds2 != null ? latLngBounds2.hashCode() : 0)) * 31;
            boolean z = this.d;
            int i3 = 1;
            if (z) {
                z = true;
            }
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = z ? 1 : 0;
            int i7 = (hashCode3 + i4) * 31;
            LatLng latLng = this.e;
            int hashCode4 = (i7 + (latLng != null ? latLng.hashCode() : 0)) * 31;
            LoadState loadState = this.f;
            int hashCode5 = (hashCode4 + (loadState != null ? loadState.hashCode() : 0)) * 31;
            boolean z2 = this.g;
            if (z2) {
                z2 = true;
            }
            int i8 = z2 ? 1 : 0;
            int i9 = z2 ? 1 : 0;
            int i10 = z2 ? 1 : 0;
            int i11 = (hashCode5 + i8) * 31;
            List<MarkerItem> list = this.h;
            int hashCode6 = (i11 + (list != null ? list.hashCode() : 0)) * 31;
            MarkerItem markerItem = this.i;
            int hashCode7 = (hashCode6 + (markerItem != null ? markerItem.hashCode() : 0)) * 31;
            String str = this.j;
            int hashCode8 = (hashCode7 + (str != null ? str.hashCode() : 0)) * 31;
            Counter counter = this.k;
            int hashCode9 = (hashCode8 + (counter != null ? counter.hashCode() : 0)) * 31;
            boolean z3 = this.l;
            if (z3) {
                z3 = true;
            }
            int i12 = z3 ? 1 : 0;
            int i13 = z3 ? 1 : 0;
            int i14 = z3 ? 1 : 0;
            int i15 = (hashCode9 + i12) * 31;
            boolean z4 = this.m;
            if (z4) {
                z4 = true;
            }
            int i16 = z4 ? 1 : 0;
            int i17 = z4 ? 1 : 0;
            int i18 = z4 ? 1 : 0;
            int i19 = (i15 + i16) * 31;
            boolean z5 = this.n;
            if (z5) {
                z5 = true;
            }
            int i20 = z5 ? 1 : 0;
            int i21 = z5 ? 1 : 0;
            int i22 = z5 ? 1 : 0;
            int i23 = (i19 + i20) * 31;
            LatLng latLng2 = this.o;
            int hashCode10 = (i23 + (latLng2 != null ? latLng2.hashCode() : 0)) * 31;
            boolean z7 = this.p;
            if (z7) {
                z7 = true;
            }
            int i24 = z7 ? 1 : 0;
            int i25 = z7 ? 1 : 0;
            int i26 = z7 ? 1 : 0;
            int i27 = (hashCode10 + i24) * 31;
            boolean z8 = this.q;
            if (z8) {
                z8 = true;
            }
            int i28 = z8 ? 1 : 0;
            int i29 = z8 ? 1 : 0;
            int i30 = z8 ? 1 : 0;
            int i31 = (i27 + i28) * 31;
            boolean z9 = this.r;
            if (!z9) {
                i3 = z9 ? 1 : 0;
            }
            int i32 = (i31 + i3) * 31;
            GoToSerpButton goToSerpButton = this.s;
            if (goToSerpButton != null) {
                i2 = goToSerpButton.hashCode();
            }
            return i32 + i2;
        }

        public final boolean isMapMoving() {
            return this.d;
        }

        public final boolean isMapReady() {
            return this.g;
        }

        public final boolean isMapVisible() {
            return this.q;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("MapState(zoom=");
            L.append(this.a);
            L.append(", mapBounds=");
            L.append(this.b);
            L.append(", initialMapBounds=");
            L.append(this.c);
            L.append(", isMapMoving=");
            L.append(this.d);
            L.append(", position=");
            L.append(this.e);
            L.append(", markersState=");
            L.append(this.f);
            L.append(", isMapReady=");
            L.append(this.g);
            L.append(", markerItems=");
            L.append(this.h);
            L.append(", myLocation=");
            L.append(this.i);
            L.append(", selectedPinId=");
            L.append(this.j);
            L.append(", counters=");
            L.append(this.k);
            L.append(", shortcutsVisibility=");
            L.append(this.l);
            L.append(", cameraSettledFirstTime=");
            L.append(this.m);
            L.append(", needToUpdateViewedMarkers=");
            L.append(this.n);
            L.append(", forcedCenterCoordinates=");
            L.append(this.o);
            L.append(", mapBoundsSetByServer=");
            L.append(this.p);
            L.append(", isMapVisible=");
            L.append(this.q);
            L.append(", zoomButtonVisibility=");
            L.append(this.r);
            L.append(", goToSerpButton=");
            L.append(this.s);
            L.append(")");
            return L.toString();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ MapState(Float f2, LatLngBounds latLngBounds, LatLngBounds latLngBounds2, boolean z, LatLng latLng, LoadState loadState, boolean z2, List list, MarkerItem markerItem, String str, Counter counter, boolean z3, boolean z4, boolean z5, LatLng latLng2, boolean z7, boolean z8, boolean z9, GoToSerpButton goToSerpButton, int i2, j jVar) {
            this((i2 & 1) != 0 ? null : f2, (i2 & 2) != 0 ? null : latLngBounds, (i2 & 4) != 0 ? null : latLngBounds2, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? null : latLng, (i2 & 32) != 0 ? LoadState.NONE : loadState, (i2 & 64) != 0 ? false : z2, (i2 & 128) != 0 ? null : list, (i2 & 256) != 0 ? null : markerItem, (i2 & 512) != 0 ? null : str, (i2 & 1024) != 0 ? null : counter, (i2 & 2048) != 0 ? true : z3, (i2 & 4096) != 0 ? false : z4, (i2 & 8192) != 0 ? false : z5, (i2 & 16384) != 0 ? null : latLng2, (i2 & 32768) != 0 ? false : z7, (i2 & 65536) != 0 ? false : z8, (i2 & 131072) != 0 ? false : z9, (i2 & 262144) != 0 ? null : goToSerpButton);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b4\b\b\u0018\u00002\u00020\u0001:\u0001RB\u0001\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\b\u0012\b\b\u0002\u0010\"\u001a\u00020\u000b\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010$\u001a\u00020\u0011\u0012\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0005\u0012\b\b\u0002\u0010&\u001a\u00020\u0002\u0012\b\b\u0002\u0010'\u001a\u00020\u0017\u0012\b\b\u0002\u0010(\u001a\u00020\u0017\u0012\b\b\u0002\u0010)\u001a\u00020\u001b\u0012\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005¢\u0006\u0004\bP\u0010QJ\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0007J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0019J\u0010\u0010\u001c\u001a\u00020\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0007J\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u000b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010$\u001a\u00020\u00112\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00052\b\b\u0002\u0010&\u001a\u00020\u00022\b\b\u0002\u0010'\u001a\u00020\u00172\b\b\u0002\u0010(\u001a\u00020\u00172\b\b\u0002\u0010)\u001a\u00020\u001b2\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b-\u0010\u0004J\u0010\u0010.\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b.\u0010\u0013J\u001a\u00100\u001a\u00020\u00172\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b0\u00101R\u0019\u0010\"\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u0010\rR!\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u0010\u0007R\u0019\u0010$\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010\u0013R\u0019\u0010!\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010\nR!\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b>\u00106\u001a\u0004\b?\u0010\u0007R\u001b\u0010#\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010\u0010R\u0019\u0010)\u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010\u001dR\u0019\u0010'\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010\u0019R\u0019\u0010&\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010\u0004R\u0019\u0010(\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010G\u001a\u0004\bM\u0010\u0019R\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010O¨\u0006S"}, d2 = {"Lcom/avito/android/search/map/SearchMapState$PinAdvertsState;", "", "", "getPinId", "()Ljava/lang/String;", "", "getAdvertIds", "()Ljava/util/List;", "Lcom/avito/android/search/map/LoadState;", "component2", "()Lcom/avito/android/search/map/LoadState;", "Lcom/avito/android/search/map/view/adapter/AppendingState;", "component3", "()Lcom/avito/android/search/map/view/adapter/AppendingState;", "Landroid/net/Uri;", "component4", "()Landroid/net/Uri;", "", "component5", "()I", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "component6", "component7", "", "component8", "()Z", "component9", "Lcom/avito/android/remote/model/SerpDisplayType;", "component10", "()Lcom/avito/android/remote/model/SerpDisplayType;", "component11", "Lcom/avito/android/search/map/SearchMapState$PinAdvertsState$Pin;", "pin", "loadState", "appendingState", "nextPageUri", "currentlyLoadedCount", "adverts", "panelState", "backToMapVisible", "moveBetweenPins", "displayType", "favoriteIds", "copy", "(Lcom/avito/android/search/map/SearchMapState$PinAdvertsState$Pin;Lcom/avito/android/search/map/LoadState;Lcom/avito/android/search/map/view/adapter/AppendingState;Landroid/net/Uri;ILjava/util/List;Ljava/lang/String;ZZLcom/avito/android/remote/model/SerpDisplayType;Ljava/util/List;)Lcom/avito/android/search/map/SearchMapState$PinAdvertsState;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "c", "Lcom/avito/android/search/map/view/adapter/AppendingState;", "getAppendingState", "f", "Ljava/util/List;", "getAdverts", "e", "I", "getCurrentlyLoadedCount", AuthSource.BOOKING_ORDER, "Lcom/avito/android/search/map/LoadState;", "getLoadState", "k", "getFavoriteIds", "d", "Landroid/net/Uri;", "getNextPageUri", "j", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "h", "Z", "getBackToMapVisible", g.a, "Ljava/lang/String;", "getPanelState", "i", "getMoveBetweenPins", AuthSource.SEND_ABUSE, "Lcom/avito/android/search/map/SearchMapState$PinAdvertsState$Pin;", "<init>", "(Lcom/avito/android/search/map/SearchMapState$PinAdvertsState$Pin;Lcom/avito/android/search/map/LoadState;Lcom/avito/android/search/map/view/adapter/AppendingState;Landroid/net/Uri;ILjava/util/List;Ljava/lang/String;ZZLcom/avito/android/remote/model/SerpDisplayType;Ljava/util/List;)V", "Pin", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class PinAdvertsState {
        public final Pin a;
        @NotNull
        public final LoadState b;
        @NotNull
        public final AppendingState c;
        @Nullable
        public final Uri d;
        public final int e;
        @Nullable
        public final List<ViewTypeSerpItem> f;
        @NotNull
        public final String g;
        public final boolean h;
        public final boolean i;
        @NotNull
        public final SerpDisplayType j;
        @Nullable
        public final List<String> k;

        public PinAdvertsState() {
            this(null, null, null, null, 0, null, null, false, false, null, null, 2047, null);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.util.List<? extends com.avito.android.serp.adapter.ViewTypeSerpItem> */
        /* JADX WARN: Multi-variable type inference failed */
        public PinAdvertsState(@Nullable Pin pin, @NotNull LoadState loadState, @NotNull AppendingState appendingState, @Nullable Uri uri, int i2, @Nullable List<? extends ViewTypeSerpItem> list, @NotNull String str, boolean z, boolean z2, @NotNull SerpDisplayType serpDisplayType, @Nullable List<String> list2) {
            Intrinsics.checkNotNullParameter(loadState, "loadState");
            Intrinsics.checkNotNullParameter(appendingState, "appendingState");
            Intrinsics.checkNotNullParameter(str, "panelState");
            Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
            this.a = pin;
            this.b = loadState;
            this.c = appendingState;
            this.d = uri;
            this.e = i2;
            this.f = list;
            this.g = str;
            this.h = z;
            this.i = z2;
            this.j = serpDisplayType;
            this.k = list2;
        }

        public static /* synthetic */ PinAdvertsState copy$default(PinAdvertsState pinAdvertsState, Pin pin, LoadState loadState, AppendingState appendingState, Uri uri, int i2, List list, String str, boolean z, boolean z2, SerpDisplayType serpDisplayType, List list2, int i3, Object obj) {
            return pinAdvertsState.copy((i3 & 1) != 0 ? pinAdvertsState.a : pin, (i3 & 2) != 0 ? pinAdvertsState.b : loadState, (i3 & 4) != 0 ? pinAdvertsState.c : appendingState, (i3 & 8) != 0 ? pinAdvertsState.d : uri, (i3 & 16) != 0 ? pinAdvertsState.e : i2, (i3 & 32) != 0 ? pinAdvertsState.f : list, (i3 & 64) != 0 ? pinAdvertsState.g : str, (i3 & 128) != 0 ? pinAdvertsState.h : z, (i3 & 256) != 0 ? pinAdvertsState.i : z2, (i3 & 512) != 0 ? pinAdvertsState.j : serpDisplayType, (i3 & 1024) != 0 ? pinAdvertsState.k : list2);
        }

        @NotNull
        public final SerpDisplayType component10() {
            return this.j;
        }

        @Nullable
        public final List<String> component11() {
            return this.k;
        }

        @NotNull
        public final LoadState component2() {
            return this.b;
        }

        @NotNull
        public final AppendingState component3() {
            return this.c;
        }

        @Nullable
        public final Uri component4() {
            return this.d;
        }

        public final int component5() {
            return this.e;
        }

        @Nullable
        public final List<ViewTypeSerpItem> component6() {
            return this.f;
        }

        @NotNull
        public final String component7() {
            return this.g;
        }

        public final boolean component8() {
            return this.h;
        }

        public final boolean component9() {
            return this.i;
        }

        @NotNull
        public final PinAdvertsState copy(@Nullable Pin pin, @NotNull LoadState loadState, @NotNull AppendingState appendingState, @Nullable Uri uri, int i2, @Nullable List<? extends ViewTypeSerpItem> list, @NotNull String str, boolean z, boolean z2, @NotNull SerpDisplayType serpDisplayType, @Nullable List<String> list2) {
            Intrinsics.checkNotNullParameter(loadState, "loadState");
            Intrinsics.checkNotNullParameter(appendingState, "appendingState");
            Intrinsics.checkNotNullParameter(str, "panelState");
            Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
            return new PinAdvertsState(pin, loadState, appendingState, uri, i2, list, str, z, z2, serpDisplayType, list2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PinAdvertsState)) {
                return false;
            }
            PinAdvertsState pinAdvertsState = (PinAdvertsState) obj;
            return Intrinsics.areEqual(this.a, pinAdvertsState.a) && Intrinsics.areEqual(this.b, pinAdvertsState.b) && Intrinsics.areEqual(this.c, pinAdvertsState.c) && Intrinsics.areEqual(this.d, pinAdvertsState.d) && this.e == pinAdvertsState.e && Intrinsics.areEqual(this.f, pinAdvertsState.f) && Intrinsics.areEqual(this.g, pinAdvertsState.g) && this.h == pinAdvertsState.h && this.i == pinAdvertsState.i && Intrinsics.areEqual(this.j, pinAdvertsState.j) && Intrinsics.areEqual(this.k, pinAdvertsState.k);
        }

        @NotNull
        public final List<String> getAdvertIds() {
            List<String> advertIds;
            Pin pin = this.a;
            return (pin == null || (advertIds = pin.getAdvertIds()) == null) ? CollectionsKt__CollectionsKt.emptyList() : advertIds;
        }

        @Nullable
        public final List<ViewTypeSerpItem> getAdverts() {
            return this.f;
        }

        @NotNull
        public final AppendingState getAppendingState() {
            return this.c;
        }

        public final boolean getBackToMapVisible() {
            return this.h;
        }

        public final int getCurrentlyLoadedCount() {
            return this.e;
        }

        @NotNull
        public final SerpDisplayType getDisplayType() {
            return this.j;
        }

        @Nullable
        public final List<String> getFavoriteIds() {
            return this.k;
        }

        @NotNull
        public final LoadState getLoadState() {
            return this.b;
        }

        public final boolean getMoveBetweenPins() {
            return this.i;
        }

        @Nullable
        public final Uri getNextPageUri() {
            return this.d;
        }

        @NotNull
        public final String getPanelState() {
            return this.g;
        }

        @Nullable
        public final String getPinId() {
            Pin pin = this.a;
            if (pin != null) {
                return pin.getPinId();
            }
            return null;
        }

        public int hashCode() {
            Pin pin = this.a;
            int i2 = 0;
            int hashCode = (pin != null ? pin.hashCode() : 0) * 31;
            LoadState loadState = this.b;
            int hashCode2 = (hashCode + (loadState != null ? loadState.hashCode() : 0)) * 31;
            AppendingState appendingState = this.c;
            int hashCode3 = (hashCode2 + (appendingState != null ? appendingState.hashCode() : 0)) * 31;
            Uri uri = this.d;
            int hashCode4 = (((hashCode3 + (uri != null ? uri.hashCode() : 0)) * 31) + this.e) * 31;
            List<ViewTypeSerpItem> list = this.f;
            int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 0)) * 31;
            String str = this.g;
            int hashCode6 = (hashCode5 + (str != null ? str.hashCode() : 0)) * 31;
            boolean z = this.h;
            int i3 = 1;
            if (z) {
                z = true;
            }
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = z ? 1 : 0;
            int i7 = (hashCode6 + i4) * 31;
            boolean z2 = this.i;
            if (!z2) {
                i3 = z2 ? 1 : 0;
            }
            int i8 = (i7 + i3) * 31;
            SerpDisplayType serpDisplayType = this.j;
            int hashCode7 = (i8 + (serpDisplayType != null ? serpDisplayType.hashCode() : 0)) * 31;
            List<String> list2 = this.k;
            if (list2 != null) {
                i2 = list2.hashCode();
            }
            return hashCode7 + i2;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("PinAdvertsState(pin=");
            L.append(this.a);
            L.append(", loadState=");
            L.append(this.b);
            L.append(", appendingState=");
            L.append(this.c);
            L.append(", nextPageUri=");
            L.append(this.d);
            L.append(", currentlyLoadedCount=");
            L.append(this.e);
            L.append(", adverts=");
            L.append(this.f);
            L.append(", panelState=");
            L.append(this.g);
            L.append(", backToMapVisible=");
            L.append(this.h);
            L.append(", moveBetweenPins=");
            L.append(this.i);
            L.append(", displayType=");
            L.append(this.j);
            L.append(", favoriteIds=");
            return a.w(L, this.k, ")");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PinAdvertsState(Pin pin, LoadState loadState, AppendingState appendingState, Uri uri, int i2, List list, String str, boolean z, boolean z2, SerpDisplayType serpDisplayType, List list2, int i3, j jVar) {
            this((i3 & 1) != 0 ? null : pin, (i3 & 2) != 0 ? LoadState.NONE : loadState, (i3 & 4) != 0 ? AppendingState.NONE : appendingState, (i3 & 8) != 0 ? null : uri, (i3 & 16) != 0 ? 0 : i2, (i3 & 32) != 0 ? null : list, (i3 & 64) != 0 ? PanelStateKt.PANEL_HIDDEN : str, (i3 & 128) != 0 ? false : z, (i3 & 256) == 0 ? z2 : false, (i3 & 512) != 0 ? SerpDisplayType.Grid : serpDisplayType, (i3 & 1024) == 0 ? list2 : null);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J,\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R(\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\u0018R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/avito/android/search/map/SearchMapState$PinAdvertsState$Pin;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/util/List;", "pinId", "advertIds", "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/search/map/SearchMapState$PinAdvertsState$Pin;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getAdvertIds", "setAdvertIds", "(Ljava/util/List;)V", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getPinId", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "map_release"}, k = 1, mv = {1, 4, 2})
        public static final class Pin {
            @Nullable
            public final String a;
            @NotNull
            public List<String> b;

            public Pin() {
                this(null, null, 3, null);
            }

            public Pin(@Nullable String str, @NotNull List<String> list) {
                List<String> emptyList;
                Intrinsics.checkNotNullParameter(list, "advertIds");
                this.a = str;
                this.b = list;
                if (list.isEmpty()) {
                    this.b = (str == null || (emptyList = StringsKt__StringsKt.split$default(str, new String[]{","}, false, 0, 6, null)) == null) ? CollectionsKt__CollectionsKt.emptyList() : emptyList;
                }
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.search.map.SearchMapState$PinAdvertsState$Pin */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Pin copy$default(Pin pin, String str, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = pin.a;
                }
                if ((i & 2) != 0) {
                    list = pin.b;
                }
                return pin.copy(str, list);
            }

            @Nullable
            public final String component1() {
                return this.a;
            }

            @NotNull
            public final List<String> component2() {
                return this.b;
            }

            @NotNull
            public final Pin copy(@Nullable String str, @NotNull List<String> list) {
                Intrinsics.checkNotNullParameter(list, "advertIds");
                return new Pin(str, list);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Pin)) {
                    return false;
                }
                Pin pin = (Pin) obj;
                return Intrinsics.areEqual(this.a, pin.a) && Intrinsics.areEqual(this.b, pin.b);
            }

            @NotNull
            public final List<String> getAdvertIds() {
                return this.b;
            }

            @Nullable
            public final String getPinId() {
                return this.a;
            }

            public int hashCode() {
                String str = this.a;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                List<String> list = this.b;
                if (list != null) {
                    i = list.hashCode();
                }
                return hashCode + i;
            }

            public final void setAdvertIds(@NotNull List<String> list) {
                Intrinsics.checkNotNullParameter(list, "<set-?>");
                this.b = list;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Pin(pinId=");
                L.append(this.a);
                L.append(", advertIds=");
                return a.w(L, this.b, ")");
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Pin(String str, List list, int i, j jVar) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItem> */
    /* JADX WARN: Multi-variable type inference failed */
    public SearchMapState(@Nullable InlineFilters inlineFilters, @Nullable List<? extends ShortcutNavigationItem> list, @NotNull SearchParams searchParams, @Nullable String str, @NotNull MapState mapState, @NotNull SerpState serpState, @NotNull PinAdvertsState pinAdvertsState, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        Intrinsics.checkNotNullParameter(mapState, "mapState");
        Intrinsics.checkNotNullParameter(serpState, "serpState");
        Intrinsics.checkNotNullParameter(pinAdvertsState, "pinAdvertsState");
        this.a = inlineFilters;
        this.b = list;
        this.c = searchParams;
        this.d = str;
        this.e = mapState;
        this.f = serpState;
        this.g = pinAdvertsState;
        this.h = z;
        this.i = z2;
    }

    public static /* synthetic */ SearchMapState copy$default(SearchMapState searchMapState, InlineFilters inlineFilters, List list, SearchParams searchParams, String str, MapState mapState, SerpState serpState, PinAdvertsState pinAdvertsState, boolean z, boolean z2, int i2, Object obj) {
        return searchMapState.copy((i2 & 1) != 0 ? searchMapState.a : inlineFilters, (i2 & 2) != 0 ? searchMapState.b : list, (i2 & 4) != 0 ? searchMapState.c : searchParams, (i2 & 8) != 0 ? searchMapState.d : str, (i2 & 16) != 0 ? searchMapState.e : mapState, (i2 & 32) != 0 ? searchMapState.f : serpState, (i2 & 64) != 0 ? searchMapState.g : pinAdvertsState, (i2 & 128) != 0 ? searchMapState.h : z, (i2 & 256) != 0 ? searchMapState.i : z2);
    }

    @Nullable
    public final InlineFilters component1() {
        return this.a;
    }

    @Nullable
    public final List<ShortcutNavigationItem> component2() {
        return this.b;
    }

    @NotNull
    public final SearchParams component3() {
        return this.c;
    }

    @Nullable
    public final String component4() {
        return this.d;
    }

    @NotNull
    public final MapState component5() {
        return this.e;
    }

    @NotNull
    public final SerpState component6() {
        return this.f;
    }

    @NotNull
    public final PinAdvertsState component7() {
        return this.g;
    }

    public final boolean component8() {
        return this.h;
    }

    public final boolean component9() {
        return this.i;
    }

    @NotNull
    public final SearchMapState copy(@Nullable InlineFilters inlineFilters, @Nullable List<? extends ShortcutNavigationItem> list, @NotNull SearchParams searchParams, @Nullable String str, @NotNull MapState mapState, @NotNull SerpState serpState, @NotNull PinAdvertsState pinAdvertsState, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        Intrinsics.checkNotNullParameter(mapState, "mapState");
        Intrinsics.checkNotNullParameter(serpState, "serpState");
        Intrinsics.checkNotNullParameter(pinAdvertsState, "pinAdvertsState");
        return new SearchMapState(inlineFilters, list, searchParams, str, mapState, serpState, pinAdvertsState, z, z2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchMapState)) {
            return false;
        }
        SearchMapState searchMapState = (SearchMapState) obj;
        return Intrinsics.areEqual(this.a, searchMapState.a) && Intrinsics.areEqual(this.b, searchMapState.b) && Intrinsics.areEqual(this.c, searchMapState.c) && Intrinsics.areEqual(this.d, searchMapState.d) && Intrinsics.areEqual(this.e, searchMapState.e) && Intrinsics.areEqual(this.f, searchMapState.f) && Intrinsics.areEqual(this.g, searchMapState.g) && this.h == searchMapState.h && this.i == searchMapState.i;
    }

    public final boolean getEnableLocationPermission() {
        return this.h;
    }

    @Nullable
    public final InlineFilters getInlineFilters() {
        return this.a;
    }

    @NotNull
    public final MapState getMapState() {
        return this.e;
    }

    @NotNull
    public final PinAdvertsState getPinAdvertsState() {
        return this.g;
    }

    @Nullable
    public final String getQuery() {
        return this.d;
    }

    @NotNull
    public final SearchParams getSearchParams() {
        return this.c;
    }

    @NotNull
    public final SerpState getSerpState() {
        return this.f;
    }

    @Nullable
    public final List<ShortcutNavigationItem> getShortcutItems() {
        return this.b;
    }

    public final boolean getShowSimpleMap() {
        return this.i;
    }

    public int hashCode() {
        InlineFilters inlineFilters = this.a;
        int i2 = 0;
        int hashCode = (inlineFilters != null ? inlineFilters.hashCode() : 0) * 31;
        List<ShortcutNavigationItem> list = this.b;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        SearchParams searchParams = this.c;
        int hashCode3 = (hashCode2 + (searchParams != null ? searchParams.hashCode() : 0)) * 31;
        String str = this.d;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        MapState mapState = this.e;
        int hashCode5 = (hashCode4 + (mapState != null ? mapState.hashCode() : 0)) * 31;
        SerpState serpState = this.f;
        int hashCode6 = (hashCode5 + (serpState != null ? serpState.hashCode() : 0)) * 31;
        PinAdvertsState pinAdvertsState = this.g;
        if (pinAdvertsState != null) {
            i2 = pinAdvertsState.hashCode();
        }
        int i3 = (hashCode6 + i2) * 31;
        boolean z = this.h;
        int i4 = 1;
        if (z) {
            z = true;
        }
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = z ? 1 : 0;
        int i8 = (i3 + i5) * 31;
        boolean z2 = this.i;
        if (!z2) {
            i4 = z2 ? 1 : 0;
        }
        return i8 + i4;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SearchMapState(inlineFilters=");
        L.append(this.a);
        L.append(", shortcutItems=");
        L.append(this.b);
        L.append(", searchParams=");
        L.append(this.c);
        L.append(", query=");
        L.append(this.d);
        L.append(", mapState=");
        L.append(this.e);
        L.append(", serpState=");
        L.append(this.f);
        L.append(", pinAdvertsState=");
        L.append(this.g);
        L.append(", enableLocationPermission=");
        L.append(this.h);
        L.append(", showSimpleMap=");
        return a.B(L, this.i, ")");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\bV\b\b\u0018\u00002\u00020\u0001BÑ\u0001\u0012\b\b\u0002\u0010)\u001a\u00020\u0002\u0012\b\b\u0002\u0010*\u001a\u00020\u0005\u0012\b\b\u0002\u0010+\u001a\u00020\b\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010/\u001a\u00020\u0014\u0012\b\b\u0002\u00100\u001a\u00020\u0017\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u00103\u001a\u00020\b\u0012\b\b\u0002\u00104\u001a\u00020\u0002\u0012\b\b\u0002\u00105\u001a\u00020\b\u0012\u0006\u00106\u001a\u00020!\u0012\b\b\u0002\u00107\u001a\u00020!\u0012\b\b\u0002\u00108\u001a\u00020\b\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010:\u001a\u00020\u0002\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\bu\u0010vJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0016J\u0010\u0010\u001e\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u001e\u0010\nJ\u0010\u0010\u001f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0004J\u0010\u0010 \u001a\u00020\bHÆ\u0003¢\u0006\u0004\b \u0010\nJ\u0010\u0010\"\u001a\u00020!HÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020!HÆ\u0003¢\u0006\u0004\b$\u0010#J\u0010\u0010%\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b%\u0010\nJ\u0012\u0010&\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b&\u0010\u0016J\u0010\u0010'\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b'\u0010\u0004J\u0012\u0010(\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b(\u0010\u0016JÜ\u0001\u0010<\u001a\u00020\u00002\b\b\u0002\u0010)\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020\b2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010/\u001a\u00020\u00142\b\b\u0002\u00100\u001a\u00020\u00172\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u00103\u001a\u00020\b2\b\b\u0002\u00104\u001a\u00020\u00022\b\b\u0002\u00105\u001a\u00020\b2\b\b\u0002\u00106\u001a\u00020!2\b\b\u0002\u00107\u001a\u00020!2\b\b\u0002\u00108\u001a\u00020\b2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010:\u001a\u00020\u00022\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0004\b<\u0010=J\u0010\u0010>\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b>\u0010\u0016J\u0010\u0010?\u001a\u00020!HÖ\u0001¢\u0006\u0004\b?\u0010#J\u001a\u0010A\u001a\u00020\b2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bA\u0010BR\u0019\u00108\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010\nR\u0019\u0010:\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010\u0004R\u001b\u0010,\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010\rR\u0013\u0010L\u001a\u00020\b8F@\u0006¢\u0006\u0006\u001a\u0004\bL\u0010\nR\u0019\u0010)\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010G\u001a\u0004\bN\u0010\u0004R\u001b\u00109\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010\u0016R\u001b\u0010;\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\bR\u0010P\u001a\u0004\bS\u0010\u0016R\u0019\u0010*\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010\u0007R\u0019\u0010/\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\bW\u0010P\u001a\u0004\bX\u0010\u0016R\u0019\u0010[\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\bY\u0010D\u001a\u0004\bZ\u0010\nR\u001b\u00101\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010\u001cR\u001b\u0010.\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010\u0013R\u0019\u00100\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010\u0019R\u001b\u00102\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\be\u0010P\u001a\u0004\bf\u0010\u0016R\u0019\u00104\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bg\u0010G\u001a\u0004\bh\u0010\u0004R\u0019\u00105\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\bi\u0010D\u001a\u0004\bj\u0010\nR\u0019\u0010+\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\bk\u0010D\u001a\u0004\b+\u0010\nR\u0019\u00106\u001a\u00020!8\u0006@\u0006¢\u0006\f\n\u0004\bl\u0010m\u001a\u0004\bn\u0010#R\u001b\u0010-\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bo\u0010p\u001a\u0004\bq\u0010\u0010R\u0019\u00107\u001a\u00020!8\u0006@\u0006¢\u0006\f\n\u0004\br\u0010m\u001a\u0004\bs\u0010#R\u0019\u00103\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\bt\u0010D\u001a\u0004\b3\u0010\n¨\u0006w"}, d2 = {"Lcom/avito/android/search/map/SearchMapState$SerpState;", "", "Lcom/avito/android/search/map/LoadState;", "component1", "()Lcom/avito/android/search/map/LoadState;", "Lcom/avito/android/search/map/view/adapter/AppendingState;", "component2", "()Lcom/avito/android/search/map/view/adapter/AppendingState;", "", "component3", "()Z", "Lcom/avito/android/search/map/interactor/SerpKey;", "component4", "()Lcom/avito/android/search/map/interactor/SerpKey;", "Lcom/avito/android/remote/model/SerpDisplayType;", "component5", "()Lcom/avito/android/remote/model/SerpDisplayType;", "Lcom/avito/android/search/map/interactor/SerpDataSources;", "component6", "()Lcom/avito/android/search/map/interactor/SerpDataSources;", "", "component7", "()Ljava/lang/String;", "", "component8", "()J", "Lcom/avito/android/remote/model/search/map/Area;", "component9", "()Lcom/avito/android/remote/model/search/map/Area;", "component10", "component11", "component12", "component13", "", "component14", "()I", "component15", "component16", "component17", "component18", "component19", "loadState", "appendingState", "isSerpReady", "key", "displayType", "dataSources", "panelState", "count", "area", "subscriptionId", "isSubscribed", "subscribeLoadState", "userInteractedWithMap", "columns", "serpPaddingTop", "invisibleSerpOnMap", "context", "savedSearchControlDeeplinkLoadState", "xHash", "copy", "(Lcom/avito/android/search/map/LoadState;Lcom/avito/android/search/map/view/adapter/AppendingState;ZLcom/avito/android/search/map/interactor/SerpKey;Lcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/search/map/interactor/SerpDataSources;Ljava/lang/String;JLcom/avito/android/remote/model/search/map/Area;Ljava/lang/String;ZLcom/avito/android/search/map/LoadState;ZIIZLjava/lang/String;Lcom/avito/android/search/map/LoadState;Ljava/lang/String;)Lcom/avito/android/search/map/SearchMapState$SerpState;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", VKApiConst.Q, "Z", "getInvisibleSerpOnMap", "s", "Lcom/avito/android/search/map/LoadState;", "getSavedSearchControlDeeplinkLoadState", "e", "Lcom/avito/android/search/map/interactor/SerpKey;", "getKey", "isInvalidate", AuthSource.BOOKING_ORDER, "getLoadState", "r", "Ljava/lang/String;", "getContext", "t", "getXHash", "c", "Lcom/avito/android/search/map/view/adapter/AppendingState;", "getAppendingState", "h", "getPanelState", AuthSource.SEND_ABUSE, "getHasItems", "hasItems", "j", "Lcom/avito/android/remote/model/search/map/Area;", "getArea", g.a, "Lcom/avito/android/search/map/interactor/SerpDataSources;", "getDataSources", "i", "J", "getCount", "k", "getSubscriptionId", AuthSource.OPEN_CHANNEL_LIST, "getSubscribeLoadState", "n", "getUserInteractedWithMap", "d", "o", "I", "getColumns", "f", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "p", "getSerpPaddingTop", "l", "<init>", "(Lcom/avito/android/search/map/LoadState;Lcom/avito/android/search/map/view/adapter/AppendingState;ZLcom/avito/android/search/map/interactor/SerpKey;Lcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/search/map/interactor/SerpDataSources;Ljava/lang/String;JLcom/avito/android/remote/model/search/map/Area;Ljava/lang/String;ZLcom/avito/android/search/map/LoadState;ZIIZLjava/lang/String;Lcom/avito/android/search/map/LoadState;Ljava/lang/String;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class SerpState {
        public final boolean a;
        @NotNull
        public final LoadState b;
        @NotNull
        public final AppendingState c;
        public final boolean d;
        @Nullable
        public final SerpKey e;
        @Nullable
        public final SerpDisplayType f;
        @Nullable
        public final SerpDataSources g;
        @NotNull
        public final String h;
        public final long i;
        @Nullable
        public final Area j;
        @Nullable
        public final String k;
        public final boolean l;
        @NotNull
        public final LoadState m;
        public final boolean n;
        public final int o;
        public final int p;
        public final boolean q;
        @Nullable
        public final String r;
        @NotNull
        public final LoadState s;
        @Nullable
        public final String t;

        public SerpState(@NotNull LoadState loadState, @NotNull AppendingState appendingState, boolean z, @Nullable SerpKey serpKey, @Nullable SerpDisplayType serpDisplayType, @Nullable SerpDataSources serpDataSources, @NotNull String str, long j2, @Nullable Area area, @Nullable String str2, boolean z2, @NotNull LoadState loadState2, boolean z3, int i2, int i3, boolean z4, @Nullable String str3, @NotNull LoadState loadState3, @Nullable String str4) {
            Intrinsics.checkNotNullParameter(loadState, "loadState");
            Intrinsics.checkNotNullParameter(appendingState, "appendingState");
            Intrinsics.checkNotNullParameter(str, "panelState");
            Intrinsics.checkNotNullParameter(loadState2, "subscribeLoadState");
            Intrinsics.checkNotNullParameter(loadState3, "savedSearchControlDeeplinkLoadState");
            this.b = loadState;
            this.c = appendingState;
            this.d = z;
            this.e = serpKey;
            this.f = serpDisplayType;
            this.g = serpDataSources;
            this.h = str;
            this.i = j2;
            this.j = area;
            this.k = str2;
            this.l = z2;
            this.m = loadState2;
            this.n = z3;
            this.o = i2;
            this.p = i3;
            this.q = z4;
            this.r = str3;
            this.s = loadState3;
            this.t = str4;
            this.a = serpDataSources != null && !serpDataSources.getSpans().isEmpty();
        }

        public static /* synthetic */ SerpState copy$default(SerpState serpState, LoadState loadState, AppendingState appendingState, boolean z, SerpKey serpKey, SerpDisplayType serpDisplayType, SerpDataSources serpDataSources, String str, long j2, Area area, String str2, boolean z2, LoadState loadState2, boolean z3, int i2, int i3, boolean z4, String str3, LoadState loadState3, String str4, int i4, Object obj) {
            return serpState.copy((i4 & 1) != 0 ? serpState.b : loadState, (i4 & 2) != 0 ? serpState.c : appendingState, (i4 & 4) != 0 ? serpState.d : z, (i4 & 8) != 0 ? serpState.e : serpKey, (i4 & 16) != 0 ? serpState.f : serpDisplayType, (i4 & 32) != 0 ? serpState.g : serpDataSources, (i4 & 64) != 0 ? serpState.h : str, (i4 & 128) != 0 ? serpState.i : j2, (i4 & 256) != 0 ? serpState.j : area, (i4 & 512) != 0 ? serpState.k : str2, (i4 & 1024) != 0 ? serpState.l : z2, (i4 & 2048) != 0 ? serpState.m : loadState2, (i4 & 4096) != 0 ? serpState.n : z3, (i4 & 8192) != 0 ? serpState.o : i2, (i4 & 16384) != 0 ? serpState.p : i3, (i4 & 32768) != 0 ? serpState.q : z4, (i4 & 65536) != 0 ? serpState.r : str3, (i4 & 131072) != 0 ? serpState.s : loadState3, (i4 & 262144) != 0 ? serpState.t : str4);
        }

        @NotNull
        public final LoadState component1() {
            return this.b;
        }

        @Nullable
        public final String component10() {
            return this.k;
        }

        public final boolean component11() {
            return this.l;
        }

        @NotNull
        public final LoadState component12() {
            return this.m;
        }

        public final boolean component13() {
            return this.n;
        }

        public final int component14() {
            return this.o;
        }

        public final int component15() {
            return this.p;
        }

        public final boolean component16() {
            return this.q;
        }

        @Nullable
        public final String component17() {
            return this.r;
        }

        @NotNull
        public final LoadState component18() {
            return this.s;
        }

        @Nullable
        public final String component19() {
            return this.t;
        }

        @NotNull
        public final AppendingState component2() {
            return this.c;
        }

        public final boolean component3() {
            return this.d;
        }

        @Nullable
        public final SerpKey component4() {
            return this.e;
        }

        @Nullable
        public final SerpDisplayType component5() {
            return this.f;
        }

        @Nullable
        public final SerpDataSources component6() {
            return this.g;
        }

        @NotNull
        public final String component7() {
            return this.h;
        }

        public final long component8() {
            return this.i;
        }

        @Nullable
        public final Area component9() {
            return this.j;
        }

        @NotNull
        public final SerpState copy(@NotNull LoadState loadState, @NotNull AppendingState appendingState, boolean z, @Nullable SerpKey serpKey, @Nullable SerpDisplayType serpDisplayType, @Nullable SerpDataSources serpDataSources, @NotNull String str, long j2, @Nullable Area area, @Nullable String str2, boolean z2, @NotNull LoadState loadState2, boolean z3, int i2, int i3, boolean z4, @Nullable String str3, @NotNull LoadState loadState3, @Nullable String str4) {
            Intrinsics.checkNotNullParameter(loadState, "loadState");
            Intrinsics.checkNotNullParameter(appendingState, "appendingState");
            Intrinsics.checkNotNullParameter(str, "panelState");
            Intrinsics.checkNotNullParameter(loadState2, "subscribeLoadState");
            Intrinsics.checkNotNullParameter(loadState3, "savedSearchControlDeeplinkLoadState");
            return new SerpState(loadState, appendingState, z, serpKey, serpDisplayType, serpDataSources, str, j2, area, str2, z2, loadState2, z3, i2, i3, z4, str3, loadState3, str4);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SerpState)) {
                return false;
            }
            SerpState serpState = (SerpState) obj;
            return Intrinsics.areEqual(this.b, serpState.b) && Intrinsics.areEqual(this.c, serpState.c) && this.d == serpState.d && Intrinsics.areEqual(this.e, serpState.e) && Intrinsics.areEqual(this.f, serpState.f) && Intrinsics.areEqual(this.g, serpState.g) && Intrinsics.areEqual(this.h, serpState.h) && this.i == serpState.i && Intrinsics.areEqual(this.j, serpState.j) && Intrinsics.areEqual(this.k, serpState.k) && this.l == serpState.l && Intrinsics.areEqual(this.m, serpState.m) && this.n == serpState.n && this.o == serpState.o && this.p == serpState.p && this.q == serpState.q && Intrinsics.areEqual(this.r, serpState.r) && Intrinsics.areEqual(this.s, serpState.s) && Intrinsics.areEqual(this.t, serpState.t);
        }

        @NotNull
        public final AppendingState getAppendingState() {
            return this.c;
        }

        @Nullable
        public final Area getArea() {
            return this.j;
        }

        public final int getColumns() {
            return this.o;
        }

        @Nullable
        public final String getContext() {
            return this.r;
        }

        public final long getCount() {
            return this.i;
        }

        @Nullable
        public final SerpDataSources getDataSources() {
            return this.g;
        }

        @Nullable
        public final SerpDisplayType getDisplayType() {
            return this.f;
        }

        public final boolean getHasItems() {
            return this.a;
        }

        public final boolean getInvisibleSerpOnMap() {
            return this.q;
        }

        @Nullable
        public final SerpKey getKey() {
            return this.e;
        }

        @NotNull
        public final LoadState getLoadState() {
            return this.b;
        }

        @NotNull
        public final String getPanelState() {
            return this.h;
        }

        @NotNull
        public final LoadState getSavedSearchControlDeeplinkLoadState() {
            return this.s;
        }

        public final int getSerpPaddingTop() {
            return this.p;
        }

        @NotNull
        public final LoadState getSubscribeLoadState() {
            return this.m;
        }

        @Nullable
        public final String getSubscriptionId() {
            return this.k;
        }

        public final boolean getUserInteractedWithMap() {
            return this.n;
        }

        @Nullable
        public final String getXHash() {
            return this.t;
        }

        public int hashCode() {
            LoadState loadState = this.b;
            int i2 = 0;
            int hashCode = (loadState != null ? loadState.hashCode() : 0) * 31;
            AppendingState appendingState = this.c;
            int hashCode2 = (hashCode + (appendingState != null ? appendingState.hashCode() : 0)) * 31;
            boolean z = this.d;
            int i3 = 1;
            if (z) {
                z = true;
            }
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = z ? 1 : 0;
            int i7 = (hashCode2 + i4) * 31;
            SerpKey serpKey = this.e;
            int hashCode3 = (i7 + (serpKey != null ? serpKey.hashCode() : 0)) * 31;
            SerpDisplayType serpDisplayType = this.f;
            int hashCode4 = (hashCode3 + (serpDisplayType != null ? serpDisplayType.hashCode() : 0)) * 31;
            SerpDataSources serpDataSources = this.g;
            int hashCode5 = (hashCode4 + (serpDataSources != null ? serpDataSources.hashCode() : 0)) * 31;
            String str = this.h;
            int hashCode6 = (((hashCode5 + (str != null ? str.hashCode() : 0)) * 31) + c.a(this.i)) * 31;
            Area area = this.j;
            int hashCode7 = (hashCode6 + (area != null ? area.hashCode() : 0)) * 31;
            String str2 = this.k;
            int hashCode8 = (hashCode7 + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z2 = this.l;
            if (z2) {
                z2 = true;
            }
            int i8 = z2 ? 1 : 0;
            int i9 = z2 ? 1 : 0;
            int i10 = z2 ? 1 : 0;
            int i11 = (hashCode8 + i8) * 31;
            LoadState loadState2 = this.m;
            int hashCode9 = (i11 + (loadState2 != null ? loadState2.hashCode() : 0)) * 31;
            boolean z3 = this.n;
            if (z3) {
                z3 = true;
            }
            int i12 = z3 ? 1 : 0;
            int i13 = z3 ? 1 : 0;
            int i14 = z3 ? 1 : 0;
            int i15 = (((((hashCode9 + i12) * 31) + this.o) * 31) + this.p) * 31;
            boolean z4 = this.q;
            if (!z4) {
                i3 = z4 ? 1 : 0;
            }
            int i16 = (i15 + i3) * 31;
            String str3 = this.r;
            int hashCode10 = (i16 + (str3 != null ? str3.hashCode() : 0)) * 31;
            LoadState loadState3 = this.s;
            int hashCode11 = (hashCode10 + (loadState3 != null ? loadState3.hashCode() : 0)) * 31;
            String str4 = this.t;
            if (str4 != null) {
                i2 = str4.hashCode();
            }
            return hashCode11 + i2;
        }

        public final boolean isInvalidate() {
            return this.e == null;
        }

        public final boolean isSerpReady() {
            return this.d;
        }

        public final boolean isSubscribed() {
            return this.l;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("SerpState(loadState=");
            L.append(this.b);
            L.append(", appendingState=");
            L.append(this.c);
            L.append(", isSerpReady=");
            L.append(this.d);
            L.append(", key=");
            L.append(this.e);
            L.append(", displayType=");
            L.append(this.f);
            L.append(", dataSources=");
            L.append(this.g);
            L.append(", panelState=");
            L.append(this.h);
            L.append(", count=");
            L.append(this.i);
            L.append(", area=");
            L.append(this.j);
            L.append(", subscriptionId=");
            L.append(this.k);
            L.append(", isSubscribed=");
            L.append(this.l);
            L.append(", subscribeLoadState=");
            L.append(this.m);
            L.append(", userInteractedWithMap=");
            L.append(this.n);
            L.append(", columns=");
            L.append(this.o);
            L.append(", serpPaddingTop=");
            L.append(this.p);
            L.append(", invisibleSerpOnMap=");
            L.append(this.q);
            L.append(", context=");
            L.append(this.r);
            L.append(", savedSearchControlDeeplinkLoadState=");
            L.append(this.s);
            L.append(", xHash=");
            return a.t(L, this.t, ")");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SerpState(LoadState loadState, AppendingState appendingState, boolean z, SerpKey serpKey, SerpDisplayType serpDisplayType, SerpDataSources serpDataSources, String str, long j2, Area area, String str2, boolean z2, LoadState loadState2, boolean z3, int i2, int i3, boolean z4, String str3, LoadState loadState3, String str4, int i4, j jVar) {
            this((i4 & 1) != 0 ? LoadState.NONE : loadState, (i4 & 2) != 0 ? AppendingState.NONE : appendingState, (i4 & 4) != 0 ? false : z, (i4 & 8) != 0 ? null : serpKey, (i4 & 16) != 0 ? SerpDisplayType.Grid : serpDisplayType, (i4 & 32) != 0 ? null : serpDataSources, (i4 & 64) != 0 ? "none" : str, (i4 & 128) != 0 ? 0 : j2, (i4 & 256) != 0 ? null : area, (i4 & 512) != 0 ? null : str2, (i4 & 1024) != 0 ? false : z2, (i4 & 2048) != 0 ? LoadState.NONE : loadState2, (i4 & 4096) != 0 ? false : z3, i2, (i4 & 16384) != 0 ? 0 : i3, (32768 & i4) != 0 ? false : z4, (65536 & i4) != 0 ? null : str3, (131072 & i4) != 0 ? LoadState.NONE : loadState3, (i4 & 262144) != 0 ? null : str4);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SearchMapState(InlineFilters inlineFilters, List list, SearchParams searchParams, String str, MapState mapState, SerpState serpState, PinAdvertsState pinAdvertsState, boolean z, boolean z2, int i2, j jVar) {
        this((i2 & 1) != 0 ? null : inlineFilters, (i2 & 2) != 0 ? null : list, (i2 & 4) != 0 ? new SearchParams(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null) : searchParams, (i2 & 8) != 0 ? null : str, mapState, serpState, (i2 & 64) != 0 ? new PinAdvertsState(null, null, null, null, 0, null, null, false, false, null, null, 2047, null) : pinAdvertsState, (i2 & 128) != 0 ? false : z, (i2 & 256) != 0 ? false : z2);
    }
}
