package com.avito.android.home;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.HomeTabItem;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.LocationKt;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.Shortcuts;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.avito.android.stories.StoriesItem;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010!\n\u0002\b&\b\b\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\u0001\u0012\u0006\u0010Z\u001a\u00020C\u0012\b\u00107\u001a\u0004\u0018\u000106\u0012\b\u0010[\u001a\u0004\u0018\u00010H\u0012\b\u0010?\u001a\u0004\u0018\u00010>\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\\\u001a\u00020C\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u000106¢\u0006\u0006\b\u0001\u0010\u0001J%\u0010\u0006\u001a\u00020\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0010J)\u0010\u0015\u001a\u00020\u00002\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u0014\u001a\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u000b¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u000b¢\u0006\u0004\b\u001e\u0010\rJ\u0017\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u001f\u0010\u0010J-\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00032\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020\u0000¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u0000¢\u0006\u0004\b)\u0010(J\u0015\u0010,\u001a\u00020\u00002\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\u000b¢\u0006\u0004\b.\u0010\rJ\r\u0010/\u001a\u00020\u000b¢\u0006\u0004\b/\u0010\rJ\u0017\u00101\u001a\u00020\u00002\b\u00100\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b1\u0010\u001aJ\u0017\u00103\u001a\u00020\u00002\b\u00102\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b3\u0010\u001aJ\u0017\u00104\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b4\u0010\u0010J\r\u00105\u001a\u00020\u0000¢\u0006\u0004\b5\u0010(J\u0015\u00108\u001a\u00020\u00002\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109J\r\u0010;\u001a\u00020:¢\u0006\u0004\b;\u0010<J\r\u0010=\u001a\u00020\u0000¢\u0006\u0004\b=\u0010(J\u0015\u0010@\u001a\u00020\u00002\u0006\u0010?\u001a\u00020>¢\u0006\u0004\b@\u0010AJ\r\u0010B\u001a\u00020\u0000¢\u0006\u0004\bB\u0010(J\u0010\u0010D\u001a\u00020CHÆ\u0003¢\u0006\u0004\bD\u0010EJ\u0012\u0010F\u001a\u0004\u0018\u000106HÆ\u0003¢\u0006\u0004\bF\u0010GJ\u0012\u0010I\u001a\u0004\u0018\u00010HHÆ\u0003¢\u0006\u0004\bI\u0010JJ\u0012\u0010K\u001a\u0004\u0018\u00010>HÆ\u0003¢\u0006\u0004\bK\u0010LJ\u001c\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0012HÆ\u0003¢\u0006\u0004\bM\u0010NJ\u0010\u0010O\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\bO\u0010PJ\u0010\u0010Q\u001a\u00020CHÆ\u0003¢\u0006\u0004\bQ\u0010EJ\u0012\u0010R\u001a\u0004\u0018\u00010*HÆ\u0003¢\u0006\u0004\bR\u0010SJ\u0012\u0010T\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\bT\u0010UJ\u0012\u0010V\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\bV\u0010UJ\u0012\u0010W\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\bW\u0010XJ\u0012\u0010Y\u001a\u0004\u0018\u000106HÆ\u0003¢\u0006\u0004\bY\u0010GJ¤\u0001\u0010^\u001a\u00020\u00002\b\b\u0002\u0010Z\u001a\u00020C2\n\b\u0002\u00107\u001a\u0004\u0018\u0001062\n\b\u0002\u0010[\u001a\u0004\u0018\u00010H2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>2\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\\\u001a\u00020C2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010]\u001a\u0004\u0018\u000106HÆ\u0001¢\u0006\u0004\b^\u0010_J\u0010\u0010`\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b`\u0010UJ\u0010\u0010b\u001a\u00020aHÖ\u0001¢\u0006\u0004\bb\u0010cJ\u001a\u0010e\u001a\u00020\u000b2\b\u0010d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\be\u0010fR\u001b\u0010?\u001a\u0004\u0018\u00010>8\u0006@\u0006¢\u0006\f\n\u0004\bg\u0010h\u001a\u0004\bi\u0010LR\u001b\u00100\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010UR\u0019\u0010\u0014\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\bm\u0010n\u001a\u0004\bo\u0010PR\u0013\u0010q\u001a\u00020C8F@\u0006¢\u0006\u0006\u001a\u0004\bp\u0010ER\u0019\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0r8F@\u0006¢\u0006\u0006\u001a\u0004\bs\u0010tR\u0019\u0010\\\u001a\u00020C8\u0006@\u0006¢\u0006\f\n\u0004\bu\u0010v\u001a\u0004\bw\u0010ER\u001b\u00107\u001a\u0004\u0018\u0001068\u0006@\u0006¢\u0006\f\n\u0004\bx\u0010y\u001a\u0004\bz\u0010GR\u0019\u0010Z\u001a\u00020C8\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010v\u001a\u0004\b{\u0010ER\u0013\u0010}\u001a\u00020a8F@\u0006¢\u0006\u0006\u001a\u0004\b|\u0010cR&\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00128\u0006@\u0006¢\u0006\r\n\u0004\b~\u0010\u001a\u0005\b\u0001\u0010NR\u001e\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010SR\u001d\u0010]\u001a\u0004\u0018\u0001068\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0001\u0010y\u001a\u0005\b\u0001\u0010GR\u0016\u0010\u0001\u001a\u00020\u00048F@\u0006¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u0015\u0010\u0001\u001a\u00020a8F@\u0006¢\u0006\u0007\u001a\u0005\b\u0001\u0010cR\u0015\u0010\u0001\u001a\u00020\u000b8F@\u0006¢\u0006\u0007\u001a\u0005\b\u0001\u0010\rR\u001e\u0010[\u001a\u0004\u0018\u00010H8\u0006@\u0006¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010JR\u001d\u00102\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0001\u0010k\u001a\u0005\b\u0001\u0010UR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010X¨\u0006\u0001"}, d2 = {"Lcom/avito/android/home/State;", "", "Lkotlin/Pair;", "Lcom/avito/android/remote/model/HomeTabItem;", "Lcom/avito/android/home/TabState;", "pair", AuthSource.SEND_ABUSE, "(Lkotlin/Pair;)Lcom/avito/android/home/State;", "key", "get", "(Lcom/avito/android/remote/model/HomeTabItem;)Lcom/avito/android/home/TabState;", "", "hasTabs", "()Z", "tab", "postRefreshTab", "(Lcom/avito/android/remote/model/HomeTabItem;)Lcom/avito/android/home/State;", "selectTab", "", "tabStates", "currentTab", "tabsUpdated", "(Ljava/util/Map;Lcom/avito/android/remote/model/HomeTabItem;)Lcom/avito/android/home/State;", "", "locationId", "locationUpdated", "(Ljava/lang/String;)Lcom/avito/android/home/State;", "locationForcedByUser", "locationForcedByUserUpdated", "(Z)Lcom/avito/android/home/State;", "locationLoaded", "loadingElements", "", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", MessengerShareContentUtility.ELEMENTS, "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "appendElements", "(Lcom/avito/android/remote/model/HomeTabItem;Ljava/util/List;Lcom/avito/android/remote/model/SerpDisplayType;)Lcom/avito/android/home/State;", "loadingStories", "()Lcom/avito/android/home/State;", "loadErrorStories", "Lcom/avito/android/stories/StoriesItem;", "stories", "loadStories", "(Lcom/avito/android/stories/StoriesItem;)Lcom/avito/android/home/State;", "storiesLoaded", "storiesLoading", "searchHint", "setSearchHint", "xHash", "setXhash", "loadElementsError", "loadingLocation", "Lcom/avito/android/remote/model/Location;", "location", "loadLocation", "(Lcom/avito/android/remote/model/Location;)Lcom/avito/android/home/State;", "", "ignoreForcedLocationForRecommendation", "()V", "loadLocationError", "Lcom/avito/android/remote/model/Shortcuts;", ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS, "loadShortcuts", "(Lcom/avito/android/remote/model/Shortcuts;)Lcom/avito/android/home/State;", "restoreStateAfterAttach", "Lcom/avito/android/home/LoadState;", "component1", "()Lcom/avito/android/home/LoadState;", "component2", "()Lcom/avito/android/remote/model/Location;", "Lcom/avito/android/remote/model/SearchParams;", "component3", "()Lcom/avito/android/remote/model/SearchParams;", "component4", "()Lcom/avito/android/remote/model/Shortcuts;", "component5", "()Ljava/util/Map;", "component6", "()Lcom/avito/android/remote/model/HomeTabItem;", "component7", "component8", "()Lcom/avito/android/stories/StoriesItem;", "component9", "()Ljava/lang/String;", "component10", "component11", "()Ljava/lang/Boolean;", "component12", "locationState", "searchParams", "storiesState", "fallbackLocation", "copy", "(Lcom/avito/android/home/LoadState;Lcom/avito/android/remote/model/Location;Lcom/avito/android/remote/model/SearchParams;Lcom/avito/android/remote/model/Shortcuts;Ljava/util/Map;Lcom/avito/android/remote/model/HomeTabItem;Lcom/avito/android/home/LoadState;Lcom/avito/android/stories/StoriesItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/avito/android/remote/model/Location;)Lcom/avito/android/home/State;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "d", "Lcom/avito/android/remote/model/Shortcuts;", "getShortcuts", "i", "Ljava/lang/String;", "getSearchHint", "f", "Lcom/avito/android/remote/model/HomeTabItem;", "getCurrentTab", "getElementsState", "elementsState", "", "getElements", "()Ljava/util/List;", g.a, "Lcom/avito/android/home/LoadState;", "getStoriesState", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/Location;", "getLocation", "getLocationState", "getPage", "page", "e", "Ljava/util/Map;", "getTabStates", "h", "Lcom/avito/android/stories/StoriesItem;", "getStories", "l", "getFallbackLocation", "getCurrentTabState", "()Lcom/avito/android/home/TabState;", "currentTabState", "getOffset", "offset", "getHasMorePages", "hasMorePages", "c", "Lcom/avito/android/remote/model/SearchParams;", "getSearchParams", "j", "getXHash", "k", "Ljava/lang/Boolean;", "getLocationForcedByUser", "<init>", "(Lcom/avito/android/home/LoadState;Lcom/avito/android/remote/model/Location;Lcom/avito/android/remote/model/SearchParams;Lcom/avito/android/remote/model/Shortcuts;Ljava/util/Map;Lcom/avito/android/remote/model/HomeTabItem;Lcom/avito/android/home/LoadState;Lcom/avito/android/stories/StoriesItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/avito/android/remote/model/Location;)V", "Companion", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class State {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final HomeTabItem m = new HomeTabItem("", "", null, false, false, 28, null);
    @NotNull
    public final LoadState a;
    @Nullable
    public final Location b;
    @Nullable
    public final SearchParams c;
    @Nullable
    public final Shortcuts d;
    @NotNull
    public final Map<HomeTabItem, TabState> e;
    @NotNull
    public final HomeTabItem f;
    @NotNull
    public final LoadState g;
    @Nullable
    public final StoriesItem h;
    @Nullable
    public final String i;
    @Nullable
    public final String j;
    @Nullable
    public final Boolean k;
    @Nullable
    public final Location l;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/home/State$Companion;", "", "Lcom/avito/android/remote/model/Location;", "location", "Lcom/avito/android/home/State;", "createNewState", "(Lcom/avito/android/remote/model/Location;)Lcom/avito/android/home/State;", "Lcom/avito/android/remote/model/HomeTabItem;", "STUB", "Lcom/avito/android/remote/model/HomeTabItem;", "<init>", "()V", "serp_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public static /* synthetic */ State createNewState$default(Companion companion, Location location, int i, Object obj) {
            if ((i & 1) != 0) {
                location = null;
            }
            return companion.createNewState(location);
        }

        @NotNull
        public final State createNewState(@Nullable Location location) {
            LoadState loadState = LoadState.NONE;
            return new State(loadState, location, new SearchParams(null, null, location != null ? location.getId() : null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388603, null), null, r.mutableMapOf(TuplesKt.to(State.m, TabState.Companion.createNewState())), State.m, loadState, null, null, null, null, null, 3968, null);
        }

        public Companion(j jVar) {
        }
    }

    public State(@NotNull LoadState loadState, @Nullable Location location, @Nullable SearchParams searchParams, @Nullable Shortcuts shortcuts, @NotNull Map<HomeTabItem, TabState> map, @NotNull HomeTabItem homeTabItem, @NotNull LoadState loadState2, @Nullable StoriesItem storiesItem, @Nullable String str, @Nullable String str2, @Nullable Boolean bool, @Nullable Location location2) {
        Intrinsics.checkNotNullParameter(loadState, "locationState");
        Intrinsics.checkNotNullParameter(map, "tabStates");
        Intrinsics.checkNotNullParameter(homeTabItem, "currentTab");
        Intrinsics.checkNotNullParameter(loadState2, "storiesState");
        this.a = loadState;
        this.b = location;
        this.c = searchParams;
        this.d = shortcuts;
        this.e = map;
        this.f = homeTabItem;
        this.g = loadState2;
        this.h = storiesItem;
        this.i = str;
        this.j = str2;
        this.k = bool;
        this.l = location2;
    }

    public static /* synthetic */ State appendElements$default(State state, HomeTabItem homeTabItem, List list, SerpDisplayType serpDisplayType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            homeTabItem = state.f;
        }
        return state.appendElements(homeTabItem, list, serpDisplayType);
    }

    public static /* synthetic */ State copy$default(State state, LoadState loadState, Location location, SearchParams searchParams, Shortcuts shortcuts, Map map, HomeTabItem homeTabItem, LoadState loadState2, StoriesItem storiesItem, String str, String str2, Boolean bool, Location location2, int i2, Object obj) {
        return state.copy((i2 & 1) != 0 ? state.a : loadState, (i2 & 2) != 0 ? state.b : location, (i2 & 4) != 0 ? state.c : searchParams, (i2 & 8) != 0 ? state.d : shortcuts, (i2 & 16) != 0 ? state.e : map, (i2 & 32) != 0 ? state.f : homeTabItem, (i2 & 64) != 0 ? state.g : loadState2, (i2 & 128) != 0 ? state.h : storiesItem, (i2 & 256) != 0 ? state.i : str, (i2 & 512) != 0 ? state.j : str2, (i2 & 1024) != 0 ? state.k : bool, (i2 & 2048) != 0 ? state.l : location2);
    }

    public static /* synthetic */ State loadElementsError$default(State state, HomeTabItem homeTabItem, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            homeTabItem = state.f;
        }
        return state.loadElementsError(homeTabItem);
    }

    public static /* synthetic */ State loadingElements$default(State state, HomeTabItem homeTabItem, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            homeTabItem = state.f;
        }
        return state.loadingElements(homeTabItem);
    }

    public final State a(Pair<HomeTabItem, TabState> pair) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(this.e);
        HomeTabItem first = pair.getFirst();
        if (first == null) {
            first = m;
        }
        linkedHashMap.put(first, pair.getSecond());
        return copy$default(this, null, null, null, null, linkedHashMap, null, null, null, null, null, null, null, 4079, null);
    }

    @NotNull
    public final State appendElements(@NotNull HomeTabItem homeTabItem, @NotNull List<? extends ViewTypeSerpItem> list, @NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(homeTabItem, "key");
        Intrinsics.checkNotNullParameter(list, MessengerShareContentUtility.ELEMENTS);
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        return a(TuplesKt.to(homeTabItem, get(homeTabItem).appendElements(list, serpDisplayType)));
    }

    @NotNull
    public final LoadState component1() {
        return this.a;
    }

    @Nullable
    public final String component10() {
        return this.j;
    }

    @Nullable
    public final Boolean component11() {
        return this.k;
    }

    @Nullable
    public final Location component12() {
        return this.l;
    }

    @Nullable
    public final Location component2() {
        return this.b;
    }

    @Nullable
    public final SearchParams component3() {
        return this.c;
    }

    @Nullable
    public final Shortcuts component4() {
        return this.d;
    }

    @NotNull
    public final Map<HomeTabItem, TabState> component5() {
        return this.e;
    }

    @NotNull
    public final HomeTabItem component6() {
        return this.f;
    }

    @NotNull
    public final LoadState component7() {
        return this.g;
    }

    @Nullable
    public final StoriesItem component8() {
        return this.h;
    }

    @Nullable
    public final String component9() {
        return this.i;
    }

    @NotNull
    public final State copy(@NotNull LoadState loadState, @Nullable Location location, @Nullable SearchParams searchParams, @Nullable Shortcuts shortcuts, @NotNull Map<HomeTabItem, TabState> map, @NotNull HomeTabItem homeTabItem, @NotNull LoadState loadState2, @Nullable StoriesItem storiesItem, @Nullable String str, @Nullable String str2, @Nullable Boolean bool, @Nullable Location location2) {
        Intrinsics.checkNotNullParameter(loadState, "locationState");
        Intrinsics.checkNotNullParameter(map, "tabStates");
        Intrinsics.checkNotNullParameter(homeTabItem, "currentTab");
        Intrinsics.checkNotNullParameter(loadState2, "storiesState");
        return new State(loadState, location, searchParams, shortcuts, map, homeTabItem, loadState2, storiesItem, str, str2, bool, location2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof State)) {
            return false;
        }
        State state = (State) obj;
        return Intrinsics.areEqual(this.a, state.a) && Intrinsics.areEqual(this.b, state.b) && Intrinsics.areEqual(this.c, state.c) && Intrinsics.areEqual(this.d, state.d) && Intrinsics.areEqual(this.e, state.e) && Intrinsics.areEqual(this.f, state.f) && Intrinsics.areEqual(this.g, state.g) && Intrinsics.areEqual(this.h, state.h) && Intrinsics.areEqual(this.i, state.i) && Intrinsics.areEqual(this.j, state.j) && Intrinsics.areEqual(this.k, state.k) && Intrinsics.areEqual(this.l, state.l);
    }

    @NotNull
    public final TabState get(@NotNull HomeTabItem homeTabItem) {
        Intrinsics.checkNotNullParameter(homeTabItem, "key");
        TabState tabState = this.e.get(homeTabItem);
        if (tabState == null) {
            tabState = (TabState) r.getValue(this.e, m);
        }
        return tabState;
    }

    @NotNull
    public final HomeTabItem getCurrentTab() {
        return this.f;
    }

    @NotNull
    public final TabState getCurrentTabState() {
        return get(this.f);
    }

    @NotNull
    public final List<ViewTypeSerpItem> getElements() {
        return getCurrentTabState().getElements();
    }

    @NotNull
    public final LoadState getElementsState() {
        return getCurrentTabState().getElementsState();
    }

    @Nullable
    public final Location getFallbackLocation() {
        return this.l;
    }

    public final boolean getHasMorePages() {
        return getCurrentTabState().getHasMorePages();
    }

    @Nullable
    public final Location getLocation() {
        return this.b;
    }

    @Nullable
    public final Boolean getLocationForcedByUser() {
        return this.k;
    }

    @NotNull
    public final LoadState getLocationState() {
        return this.a;
    }

    public final int getOffset() {
        return getCurrentTabState().getOffset();
    }

    public final int getPage() {
        return getCurrentTabState().getPage();
    }

    @Nullable
    public final String getSearchHint() {
        return this.i;
    }

    @Nullable
    public final SearchParams getSearchParams() {
        return this.c;
    }

    @Nullable
    public final Shortcuts getShortcuts() {
        return this.d;
    }

    @Nullable
    public final StoriesItem getStories() {
        return this.h;
    }

    @NotNull
    public final LoadState getStoriesState() {
        return this.g;
    }

    @NotNull
    public final Map<HomeTabItem, TabState> getTabStates() {
        return this.e;
    }

    @Nullable
    public final String getXHash() {
        return this.j;
    }

    public final boolean hasTabs() {
        Set<HomeTabItem> keySet = this.e.keySet();
        if ((keySet instanceof Collection) && keySet.isEmpty()) {
            return true;
        }
        Iterator<T> it = keySet.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next(), m)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        LoadState loadState = this.a;
        int i2 = 0;
        int hashCode = (loadState != null ? loadState.hashCode() : 0) * 31;
        Location location = this.b;
        int hashCode2 = (hashCode + (location != null ? location.hashCode() : 0)) * 31;
        SearchParams searchParams = this.c;
        int hashCode3 = (hashCode2 + (searchParams != null ? searchParams.hashCode() : 0)) * 31;
        Shortcuts shortcuts = this.d;
        int hashCode4 = (hashCode3 + (shortcuts != null ? shortcuts.hashCode() : 0)) * 31;
        Map<HomeTabItem, TabState> map = this.e;
        int hashCode5 = (hashCode4 + (map != null ? map.hashCode() : 0)) * 31;
        HomeTabItem homeTabItem = this.f;
        int hashCode6 = (hashCode5 + (homeTabItem != null ? homeTabItem.hashCode() : 0)) * 31;
        LoadState loadState2 = this.g;
        int hashCode7 = (hashCode6 + (loadState2 != null ? loadState2.hashCode() : 0)) * 31;
        StoriesItem storiesItem = this.h;
        int hashCode8 = (hashCode7 + (storiesItem != null ? storiesItem.hashCode() : 0)) * 31;
        String str = this.i;
        int hashCode9 = (hashCode8 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.j;
        int hashCode10 = (hashCode9 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool = this.k;
        int hashCode11 = (hashCode10 + (bool != null ? bool.hashCode() : 0)) * 31;
        Location location2 = this.l;
        if (location2 != null) {
            i2 = location2.hashCode();
        }
        return hashCode11 + i2;
    }

    public final void ignoreForcedLocationForRecommendation() {
        Location location = this.b;
        if (location != null) {
            location.setForcedLocationForRecommendation(null);
        }
    }

    @NotNull
    public final State loadElementsError(@NotNull HomeTabItem homeTabItem) {
        Intrinsics.checkNotNullParameter(homeTabItem, "key");
        return a(TuplesKt.to(homeTabItem, get(homeTabItem).loadElementsError()));
    }

    @NotNull
    public final State loadErrorStories() {
        return copy$default(this, null, null, null, null, null, null, LoadState.ERROR, null, null, null, null, null, 3903, null);
    }

    @NotNull
    public final State loadLocation(@NotNull Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        return Companion.createNewState(location);
    }

    @NotNull
    public final State loadLocationError() {
        return copy$default(this, LoadState.ERROR, null, null, null, null, null, null, null, null, null, null, null, 4094, null);
    }

    @NotNull
    public final State loadShortcuts(@NotNull Shortcuts shortcuts) {
        Intrinsics.checkNotNullParameter(shortcuts, ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS);
        return copy$default(this, null, null, null, shortcuts, null, null, null, null, null, null, null, null, 4087, null);
    }

    @NotNull
    public final State loadStories(@NotNull StoriesItem storiesItem) {
        Intrinsics.checkNotNullParameter(storiesItem, "stories");
        return copy$default(this, null, null, null, null, null, null, LoadState.LOAD, storiesItem, null, null, null, null, 3903, null);
    }

    @NotNull
    public final State loadingElements(@NotNull HomeTabItem homeTabItem) {
        Intrinsics.checkNotNullParameter(homeTabItem, "key");
        return a(TuplesKt.to(homeTabItem, get(homeTabItem).loadingElements()));
    }

    @NotNull
    public final State loadingLocation() {
        return copy$default(this, LoadState.LOADING, null, null, null, null, null, null, null, null, null, null, null, 4094, null);
    }

    @NotNull
    public final State loadingStories() {
        return copy$default(this, null, null, null, null, null, null, LoadState.LOADING, null, null, null, null, null, 4031, null);
    }

    @NotNull
    public final State locationForcedByUserUpdated(boolean z) {
        return copy$default(this, null, null, null, null, null, null, null, null, null, null, Boolean.valueOf(z), null, 3071, null);
    }

    public final boolean locationLoaded() {
        return this.b != null;
    }

    @NotNull
    public final State locationUpdated(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "locationId");
        Location location = this.b;
        Location createLocation = LocationKt.createLocation(str, "");
        SearchParams searchParams = this.c;
        return copy$default(this, null, createLocation, searchParams != null ? SearchParams.copy$default(searchParams, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388603, null) : null, null, null, null, null, null, null, null, null, location, 2041, null);
    }

    @NotNull
    public final State postRefreshTab(@NotNull HomeTabItem homeTabItem) {
        Intrinsics.checkNotNullParameter(homeTabItem, "tab");
        return a(TuplesKt.to(homeTabItem, get(homeTabItem).postRefresh()));
    }

    @NotNull
    public final State restoreStateAfterAttach() {
        LoadState loadState;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<HomeTabItem, TabState> entry : this.e.entrySet()) {
            TabState value = entry.getValue();
            if (value.getElementsState() != LoadState.LOADING && value.getElementsState() != LoadState.ERROR) {
                loadState = value.getElementsState();
            } else if (value.getPage() > 1) {
                loadState = LoadState.LOAD;
            } else {
                loadState = LoadState.NONE;
            }
            linkedHashMap.put(entry.getKey(), TabState.copy$default(value, 0, 0, false, loadState, null, null, false, 55, null));
            if (value.getPage() > 0 && value.getElements().isEmpty()) {
                linkedHashMap.put(entry.getKey(), TabState.Companion.createNewState());
            }
        }
        return copy$default(this, null, null, null, null, linkedHashMap, null, storiesLoading() ? LoadState.NONE : this.g, null, null, null, null, null, 4015, null);
    }

    @NotNull
    public final State selectTab(@NotNull HomeTabItem homeTabItem) {
        Intrinsics.checkNotNullParameter(homeTabItem, "tab");
        return copy$default(this, null, null, null, null, null, homeTabItem, null, null, null, null, null, null, 4063, null);
    }

    @NotNull
    public final State setSearchHint(@Nullable String str) {
        return copy$default(this, null, null, null, null, null, null, null, null, str, null, null, null, 3839, null);
    }

    @NotNull
    public final State setXhash(@Nullable String str) {
        return copy$default(this, null, null, null, null, null, null, null, null, null, str, null, null, 3583, null);
    }

    public final boolean storiesLoaded() {
        return this.h != null;
    }

    public final boolean storiesLoading() {
        return this.g == LoadState.LOADING;
    }

    @NotNull
    public final State tabsUpdated(@NotNull Map<HomeTabItem, TabState> map, @NotNull HomeTabItem homeTabItem) {
        Intrinsics.checkNotNullParameter(map, "tabStates");
        Intrinsics.checkNotNullParameter(homeTabItem, "currentTab");
        return copy$default(this, null, null, null, null, map, homeTabItem, null, null, null, null, null, null, 4047, null);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("State(locationState=");
        L.append(this.a);
        L.append(", location=");
        L.append(this.b);
        L.append(", searchParams=");
        L.append(this.c);
        L.append(", shortcuts=");
        L.append(this.d);
        L.append(", tabStates=");
        L.append(this.e);
        L.append(", currentTab=");
        L.append(this.f);
        L.append(", storiesState=");
        L.append(this.g);
        L.append(", stories=");
        L.append(this.h);
        L.append(", searchHint=");
        L.append(this.i);
        L.append(", xHash=");
        L.append(this.j);
        L.append(", locationForcedByUser=");
        L.append(this.k);
        L.append(", fallbackLocation=");
        L.append(this.l);
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ State(LoadState loadState, Location location, SearchParams searchParams, Shortcuts shortcuts, Map map, HomeTabItem homeTabItem, LoadState loadState2, StoriesItem storiesItem, String str, String str2, Boolean bool, Location location2, int i2, j jVar) {
        this(loadState, location, searchParams, shortcuts, map, homeTabItem, loadState2, (i2 & 128) != 0 ? null : storiesItem, (i2 & 256) != 0 ? null : str, (i2 & 512) != 0 ? null : str2, (i2 & 1024) != 0 ? Boolean.FALSE : bool, (i2 & 2048) != 0 ? null : location2);
    }
}
