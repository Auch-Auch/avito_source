package com.avito.android.user_stats;

import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.avito.android.analytics.Analytics;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.user_stats.events.UserStatsLoadedEvent;
import com.avito.android.user_stats.events.UserStatsTabClickedEvent;
import com.avito.android.user_stats.tab.ActiveMonthIndexHolder;
import com.avito.android.user_stats.tab.UserStatsProvider;
import com.avito.android.user_stats.tab.UserStatsTabItem;
import com.avito.android.user_stats.tab.UserStatsTabItemConverter;
import com.avito.android.user_stats.tracker.UserStatsTracker;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.user_stats.model.UserStatsScreenData;
import com.avito.user_stats.model.UserStatsTabData;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001NBG\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u00107\u001a\u000204\u0012\u0006\u0010;\u001a\u000208\u0012\u0006\u0010K\u001a\u00020H\u0012\u0006\u0010C\u001a\u00020@\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\bL\u0010MJ\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0010\u0010\u000bR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R$\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f8V@VX\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u000fR\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R$\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R$\u0010/\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f8F@FX\u000e¢\u0006\f\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010\u000fR\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001f0<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010J¨\u0006O"}, d2 = {"Lcom/avito/android/user_stats/UserStatsViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/user_stats/tab/UserStatsProvider;", "Lcom/avito/android/user_stats/tab/ActiveMonthIndexHolder;", "", "tabId", "Lcom/avito/user_stats/model/UserStatsTabData;", "getTabDataModel", "(Ljava/lang/String;)Lcom/avito/user_stats/model/UserStatsTabData;", "", "loadUserStats", "()V", "", "tabPosition", "onSelectTab", "(I)V", "onCleared", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "d", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "value", "getActiveMonthIndex", "()I", "setActiveMonthIndex", "activeMonthIndex", "Lcom/avito/android/user_stats/tracker/UserStatsTracker;", "n", "Lcom/avito/android/user_stats/tracker/UserStatsTracker;", "userStatsTracker", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/user_stats/UserStatsViewModel$State;", "f", "Landroidx/lifecycle/LiveData;", "getScreenState", "()Landroidx/lifecycle/LiveData;", "screenState", "", "e", "Ljava/util/Map;", VerticalFilterCloseDialogEventKt.MODEL_DIALOG, "Lcom/avito/android/analytics/Analytics;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/analytics/Analytics;", "analytics", "getSelectedTabIndex", "setSelectedTabIndex", "selectedTabIndex", "Landroidx/lifecycle/SavedStateHandle;", g.a, "Landroidx/lifecycle/SavedStateHandle;", "stateHandle", "Lcom/avito/android/util/SchedulersFactory3;", "i", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "j", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Landroidx/lifecycle/MutableLiveData;", "c", "Landroidx/lifecycle/MutableLiveData;", "screenStateLiveData", "Lcom/avito/android/user_stats/tab/UserStatsTabItemConverter;", "l", "Lcom/avito/android/user_stats/tab/UserStatsTabItemConverter;", "tabItemConverter", "Lcom/avito/android/user_stats/UserStatsInteractor;", "h", "Lcom/avito/android/user_stats/UserStatsInteractor;", "interactor", "Lcom/avito/android/user_stats/UserStatsResourcesProvider;", "k", "Lcom/avito/android/user_stats/UserStatsResourcesProvider;", "resourcesProvider", "<init>", "(Landroidx/lifecycle/SavedStateHandle;Lcom/avito/android/user_stats/UserStatsInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/user_stats/UserStatsResourcesProvider;Lcom/avito/android/user_stats/tab/UserStatsTabItemConverter;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/user_stats/tracker/UserStatsTracker;)V", "State", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class UserStatsViewModel extends ViewModel implements UserStatsProvider, ActiveMonthIndexHolder {
    public final MutableLiveData<State> c;
    public final CompositeDisposable d = new CompositeDisposable();
    public Map<String, UserStatsTabData> e;
    @NotNull
    public final LiveData<State> f;
    public final SavedStateHandle g;
    public final UserStatsInteractor h;
    public final SchedulersFactory3 i;
    public final TypedErrorThrowableConverter j;
    public final UserStatsResourcesProvider k;
    public final UserStatsTabItemConverter l;
    public final Analytics m;
    public final UserStatsTracker n;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/user_stats/UserStatsViewModel$State;", "", "<init>", "()V", "Error", "Loaded", "Loading", "Lcom/avito/android/user_stats/UserStatsViewModel$State$Loaded;", "Lcom/avito/android/user_stats/UserStatsViewModel$State$Loading;", "Lcom/avito/android/user_stats/UserStatsViewModel$State$Error;", "user-stats_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/user_stats/UserStatsViewModel$State$Error;", "Lcom/avito/android/user_stats/UserStatsViewModel$State;", "", "component1", "()Ljava/lang/String;", "message", "copy", "(Ljava/lang/String;)Lcom/avito/android/user_stats/UserStatsViewModel$State$Error;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "<init>", "(Ljava/lang/String;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends State {
            @NotNull
            public final String a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "message");
                this.a = str;
            }

            public static /* synthetic */ Error copy$default(Error error, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = error.a;
                }
                return error.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.a;
            }

            @NotNull
            public final Error copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "message");
                return new Error(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Error) && Intrinsics.areEqual(this.a, ((Error) obj).a);
                }
                return true;
            }

            @NotNull
            public final String getMessage() {
                return this.a;
            }

            public int hashCode() {
                String str = this.a;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                return a2.b.a.a.a.t(a2.b.a.a.a.L("Error(message="), this.a, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0012\u0010\u000bJ\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u000b¨\u0006#"}, d2 = {"Lcom/avito/android/user_stats/UserStatsViewModel$State$Loaded;", "Lcom/avito/android/user_stats/UserStatsViewModel$State;", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/user_stats/tab/UserStatsTabItem;", "component2", "()Ljava/util/List;", "", "component3", "()I", "title", "tabs", "selectedTabPosition", "copy", "(Ljava/lang/String;Ljava/util/List;I)Lcom/avito/android/user_stats/UserStatsViewModel$State$Loaded;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getTabs", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "c", "I", "getSelectedTabPosition", "<init>", "(Ljava/lang/String;Ljava/util/List;I)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loaded extends State {
            @NotNull
            public final String a;
            @NotNull
            public final List<UserStatsTabItem> b;
            public final int c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Loaded(@NotNull String str, @NotNull List<UserStatsTabItem> list, int i) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "title");
                Intrinsics.checkNotNullParameter(list, "tabs");
                this.a = str;
                this.b = list;
                this.c = i;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.user_stats.UserStatsViewModel$State$Loaded */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, String str, List list, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = loaded.a;
                }
                if ((i2 & 2) != 0) {
                    list = loaded.b;
                }
                if ((i2 & 4) != 0) {
                    i = loaded.c;
                }
                return loaded.copy(str, list, i);
            }

            @NotNull
            public final String component1() {
                return this.a;
            }

            @NotNull
            public final List<UserStatsTabItem> component2() {
                return this.b;
            }

            public final int component3() {
                return this.c;
            }

            @NotNull
            public final Loaded copy(@NotNull String str, @NotNull List<UserStatsTabItem> list, int i) {
                Intrinsics.checkNotNullParameter(str, "title");
                Intrinsics.checkNotNullParameter(list, "tabs");
                return new Loaded(str, list, i);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) obj;
                return Intrinsics.areEqual(this.a, loaded.a) && Intrinsics.areEqual(this.b, loaded.b) && this.c == loaded.c;
            }

            public final int getSelectedTabPosition() {
                return this.c;
            }

            @NotNull
            public final List<UserStatsTabItem> getTabs() {
                return this.b;
            }

            @NotNull
            public final String getTitle() {
                return this.a;
            }

            public int hashCode() {
                String str = this.a;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                List<UserStatsTabItem> list = this.b;
                if (list != null) {
                    i = list.hashCode();
                }
                return ((hashCode + i) * 31) + this.c;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("Loaded(title=");
                L.append(this.a);
                L.append(", tabs=");
                L.append(this.b);
                L.append(", selectedTabPosition=");
                return a2.b.a.a.a.j(L, this.c, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/user_stats/UserStatsViewModel$State$Loading;", "Lcom/avito/android/user_stats/UserStatsViewModel$State;", "<init>", "()V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends State {
            @NotNull
            public static final Loading INSTANCE = new Loading();

            public Loading() {
                super(null);
            }
        }

        public State() {
        }

        public State(j jVar) {
        }
    }

    public static final class a<T, R> implements Function<TypedResult<UserStatsScreenData>, LoadingState<? super UserStatsScreenData>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super UserStatsScreenData> apply(TypedResult<UserStatsScreenData> typedResult) {
            TypedResult<UserStatsScreenData> typedResult2 = typedResult;
            Intrinsics.checkNotNullExpressionValue(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super UserStatsScreenData>> {
        public final /* synthetic */ UserStatsViewModel a;

        public b(UserStatsViewModel userStatsViewModel) {
            this.a = userStatsViewModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super UserStatsScreenData> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.j;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    public static final class c<T> implements Consumer<LoadingState<? super UserStatsScreenData>> {
        public final /* synthetic */ UserStatsViewModel a;

        public c(UserStatsViewModel userStatsViewModel) {
            this.a = userStatsViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super UserStatsScreenData> loadingState) {
            LoadingState<? super UserStatsScreenData> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Error) {
                this.a.n.trackStatsLoadingError();
            } else if (loadingState2 instanceof LoadingState.Loaded) {
                this.a.n.trackStatsLoaded();
            } else {
                boolean z = loadingState2 instanceof LoadingState.Loading;
            }
            State access$toScreenState = UserStatsViewModel.access$toScreenState(this.a, loadingState2);
            this.a.c.setValue(access$toScreenState);
            if (access$toScreenState instanceof State.Loaded) {
                this.a.m.track(new UserStatsLoadedEvent());
            }
        }
    }

    public UserStatsViewModel(@NotNull SavedStateHandle savedStateHandle, @NotNull UserStatsInteractor userStatsInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull UserStatsResourcesProvider userStatsResourcesProvider, @NotNull UserStatsTabItemConverter userStatsTabItemConverter, @NotNull Analytics analytics, @NotNull UserStatsTracker userStatsTracker) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "stateHandle");
        Intrinsics.checkNotNullParameter(userStatsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(userStatsResourcesProvider, "resourcesProvider");
        Intrinsics.checkNotNullParameter(userStatsTabItemConverter, "tabItemConverter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(userStatsTracker, "userStatsTracker");
        this.g = savedStateHandle;
        this.h = userStatsInteractor;
        this.i = schedulersFactory3;
        this.j = typedErrorThrowableConverter;
        this.k = userStatsResourcesProvider;
        this.l = userStatsTabItemConverter;
        this.m = analytics;
        this.n = userStatsTracker;
        MutableLiveData<State> mutableLiveData = new MutableLiveData<>();
        this.c = mutableLiveData;
        this.f = mutableLiveData;
        userStatsInteractor.setSmbStatsWasVisited();
        loadUserStats();
    }

    public static final State access$toScreenState(UserStatsViewModel userStatsViewModel, LoadingState loadingState) {
        String str;
        Objects.requireNonNull(userStatsViewModel);
        if (loadingState instanceof LoadingState.Loading) {
            return State.Loading.INSTANCE;
        }
        if (loadingState instanceof LoadingState.Loaded) {
            LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState;
            String title = ((UserStatsScreenData) loaded.getData()).getTitle();
            List<UserStatsTabData> tabs = ((UserStatsScreenData) loaded.getData()).getTabs();
            UserStatsTabItemConverter userStatsTabItemConverter = userStatsViewModel.l;
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(tabs, 10));
            Iterator<T> it = tabs.iterator();
            while (it.hasNext()) {
                arrayList.add(userStatsTabItemConverter.convert(it.next()));
            }
            State.Loaded loaded2 = new State.Loaded(title, arrayList, userStatsViewModel.getSelectedTabIndex());
            List<UserStatsTabData> tabs2 = ((UserStatsScreenData) loaded.getData()).getTabs();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (T t : tabs2) {
                linkedHashMap.put(t.getId(), t);
            }
            userStatsViewModel.e = linkedHashMap;
            return loaded2;
        } else if (loadingState instanceof LoadingState.Error) {
            TypedError error = ((LoadingState.Error) loadingState).getError();
            if (error instanceof ErrorWithMessage.NetworkError) {
                str = userStatsViewModel.k.getNetworkErrorMessage();
            } else if (error instanceof ErrorWithMessage.Unknown) {
                str = ((ErrorWithMessage.Unknown) error).getMessage();
            } else {
                str = userStatsViewModel.k.getDefaultErrorMessage();
            }
            return new State.Error(str);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.avito.android.user_stats.tab.ActiveMonthIndexHolder
    public int getActiveMonthIndex() {
        Integer num = (Integer) this.g.get(UserStatsViewModelKt.KEY_ACTIVE_MONTH_INDEX);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @NotNull
    public final LiveData<State> getScreenState() {
        return this.f;
    }

    public final int getSelectedTabIndex() {
        Integer num = (Integer) this.g.get(UserStatsViewModelKt.KEY_SELECTED_TAB_INDEX);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.avito.android.user_stats.tab.UserStatsProvider
    @Nullable
    public UserStatsTabData getTabDataModel(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "tabId");
        Map<String, UserStatsTabData> map = this.e;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public final void loadUserStats() {
        this.n.startStatsLoading();
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = this.h.getUserStats().map(a.a).toObservable().startWith(Observable.just(LoadingState.Loading.INSTANCE)).onErrorReturn(new b(this)).observeOn(this.i.mainThread()).subscribe(new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.getUserStats(…          }\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.d.clear();
    }

    public final void onSelectTab(int i2) {
        List<UserStatsTabItem> tabs;
        UserStatsTabItem userStatsTabItem;
        String title;
        setSelectedTabIndex(i2);
        State value = this.c.getValue();
        State.Loaded loaded = null;
        if (!(value instanceof State.Loaded)) {
            value = null;
        }
        State.Loaded loaded2 = (State.Loaded) value;
        if (loaded2 != null) {
            this.c.setValue(State.Loaded.copy$default(loaded2, null, null, i2, 3, null));
        }
        State value2 = this.f.getValue();
        if (value2 instanceof State.Loaded) {
            loaded = value2;
        }
        State.Loaded loaded3 = loaded;
        if (loaded3 != null && (tabs = loaded3.getTabs()) != null && (userStatsTabItem = tabs.get(i2)) != null && (title = userStatsTabItem.getTitle()) != null) {
            this.m.track(new UserStatsTabClickedEvent(title));
        }
    }

    @Override // com.avito.android.user_stats.tab.ActiveMonthIndexHolder
    public void setActiveMonthIndex(int i2) {
        this.g.set(UserStatsViewModelKt.KEY_ACTIVE_MONTH_INDEX, Integer.valueOf(i2));
    }

    public final void setSelectedTabIndex(int i2) {
        this.g.set(UserStatsViewModelKt.KEY_SELECTED_TAB_INDEX, Integer.valueOf(i2));
    }
}
