package com.avito.android.user_stats.tab;

import a2.a.a.l3.c.c;
import a2.a.a.l3.c.d;
import a2.b.a.a.a;
import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_stats.events.UserStatsDetailsClickedEvent;
import com.avito.android.user_stats.tab.list.items.blueprints.description.DescriptionItemPresenter;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.conveyor_item.Item;
import com.avito.user_stats.model.EmptyScreenData;
import com.avito.user_stats.model.StatsData;
import com.avito.user_stats.model.UserStatsTabData;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002<=B1\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010)\u001a\u00020&¢\u0006\u0004\b:\u0010;J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0004J\u0015\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000e\u0010\u0004R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020/0.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u001f\u00105\u001a\b\u0012\u0004\u0012\u00020/0\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u001e\u001a\u0004\b4\u0010 R\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020\u001c068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u0006>"}, d2 = {"Lcom/avito/android/user_stats/tab/UserStatsTabViewModel;", "Landroidx/lifecycle/ViewModel;", "", "onResume", "()V", "", FirebaseAnalytics.Param.INDEX, "onSelectColumn", "(I)V", "onClickEmptyScreenAction", "Lcom/avito/android/user_stats/tab/list/items/blueprints/description/DescriptionItemPresenter$DescriptionClickDetails;", ErrorBundle.DETAIL_ENTRY, "onClickDescriptionDetails", "(Lcom/avito/android/user_stats/tab/list/items/blueprints/description/DescriptionItemPresenter$DescriptionClickDetails;)V", "onCleared", "Lcom/avito/android/util/SchedulersFactory3;", "i", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/analytics/Analytics;", "k", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/user_stats/model/UserStatsTabData;", "j", "Lcom/avito/user_stats/model/UserStatsTabData;", "tabModel", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/user_stats/tab/UserStatsTabViewModel$RouterEvent;", g.a, "Landroidx/lifecycle/LiveData;", "getRouterEvents", "()Landroidx/lifecycle/LiveData;", "routerEvents", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "e", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/user_stats/tab/ActiveMonthIndexHolder;", "l", "Lcom/avito/android/user_stats/tab/ActiveMonthIndexHolder;", "activeMonthIndexHolder", "Lcom/avito/android/user_stats/tab/UserStatsTabInteractor;", "h", "Lcom/avito/android/user_stats/tab/UserStatsTabInteractor;", "interactor", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/user_stats/tab/UserStatsTabViewModel$TabState;", "c", "Landroidx/lifecycle/MutableLiveData;", "tabStateLiveData", "f", "getTabState", "tabState", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "d", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "routerLiveData", "<init>", "(Lcom/avito/android/user_stats/tab/UserStatsTabInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/user_stats/model/UserStatsTabData;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/user_stats/tab/ActiveMonthIndexHolder;)V", "RouterEvent", "TabState", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class UserStatsTabViewModel extends ViewModel {
    public final MutableLiveData<TabState> c;
    public final SingleLiveEvent<RouterEvent> d;
    public final CompositeDisposable e = new CompositeDisposable();
    @NotNull
    public final LiveData<TabState> f;
    @NotNull
    public final LiveData<RouterEvent> g;
    public final UserStatsTabInteractor h;
    public final SchedulersFactory3 i;
    public final UserStatsTabData j;
    public final Analytics k;
    public final ActiveMonthIndexHolder l;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/user_stats/tab/UserStatsTabViewModel$RouterEvent;", "", "<init>", "()V", "OpenDeepLink", "Lcom/avito/android/user_stats/tab/UserStatsTabViewModel$RouterEvent$OpenDeepLink;", "user-stats_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class RouterEvent {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/user_stats/tab/UserStatsTabViewModel$RouterEvent$OpenDeepLink;", "Lcom/avito/android/user_stats/tab/UserStatsTabViewModel$RouterEvent;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
        public static final class OpenDeepLink extends RouterEvent {
            @NotNull
            public final DeepLink a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public OpenDeepLink(@NotNull DeepLink deepLink) {
                super(null);
                Intrinsics.checkNotNullParameter(deepLink, "deeplink");
                this.a = deepLink;
            }

            @NotNull
            public final DeepLink getDeeplink() {
                return this.a;
            }
        }

        public RouterEvent() {
        }

        public RouterEvent(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/user_stats/tab/UserStatsTabViewModel$TabState;", "", "<init>", "()V", "Content", "Empty", "Lcom/avito/android/user_stats/tab/UserStatsTabViewModel$TabState$Content;", "Lcom/avito/android/user_stats/tab/UserStatsTabViewModel$TabState$Empty;", "user-stats_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class TabState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0010\u0010\bJ\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\bR\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0005¨\u0006\u001e"}, d2 = {"Lcom/avito/android/user_stats/tab/UserStatsTabViewModel$TabState$Content;", "Lcom/avito/android/user_stats/tab/UserStatsTabViewModel$TabState;", "", "Lcom/avito/conveyor_item/Item;", "component1", "()Ljava/util/List;", "", "component2", "()I", "items", "activeMonthIndex", "copy", "(Ljava/util/List;I)Lcom/avito/android/user_stats/tab/UserStatsTabViewModel$TabState$Content;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "I", "getActiveMonthIndex", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getItems", "<init>", "(Ljava/util/List;I)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
        public static final class Content extends TabState {
            @NotNull
            public final List<Item> a;
            public final int b;

            /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.conveyor_item.Item> */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Content(@NotNull List<? extends Item> list, int i) {
                super(null);
                Intrinsics.checkNotNullParameter(list, "items");
                this.a = list;
                this.b = i;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.user_stats.tab.UserStatsTabViewModel$TabState$Content */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Content copy$default(Content content, List list, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    list = content.a;
                }
                if ((i2 & 2) != 0) {
                    i = content.b;
                }
                return content.copy(list, i);
            }

            @NotNull
            public final List<Item> component1() {
                return this.a;
            }

            public final int component2() {
                return this.b;
            }

            @NotNull
            public final Content copy(@NotNull List<? extends Item> list, int i) {
                Intrinsics.checkNotNullParameter(list, "items");
                return new Content(list, i);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Content)) {
                    return false;
                }
                Content content = (Content) obj;
                return Intrinsics.areEqual(this.a, content.a) && this.b == content.b;
            }

            public final int getActiveMonthIndex() {
                return this.b;
            }

            @NotNull
            public final List<Item> getItems() {
                return this.a;
            }

            public int hashCode() {
                List<Item> list = this.a;
                return ((list != null ? list.hashCode() : 0) * 31) + this.b;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Content(items=");
                L.append(this.a);
                L.append(", activeMonthIndex=");
                return a.j(L, this.b, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/avito/android/user_stats/tab/UserStatsTabViewModel$TabState$Empty;", "Lcom/avito/android/user_stats/tab/UserStatsTabViewModel$TabState;", "", "c", "Ljava/lang/String;", "getButtonText", "()Ljava/lang/String;", "buttonText", AuthSource.SEND_ABUSE, "getTitle", "title", AuthSource.BOOKING_ORDER, "getDescription", "description", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends TabState {
            @NotNull
            public final String a;
            @NotNull
            public final String b;
            @NotNull
            public final String c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Empty(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                super(null);
                a.Z0(str, "title", str2, "description", str3, "buttonText");
                this.a = str;
                this.b = str2;
                this.c = str3;
            }

            @NotNull
            public final String getButtonText() {
                return this.c;
            }

            @NotNull
            public final String getDescription() {
                return this.b;
            }

            @NotNull
            public final String getTitle() {
                return this.a;
            }
        }

        public TabState() {
        }

        public TabState(j jVar) {
        }
    }

    public UserStatsTabViewModel(@NotNull UserStatsTabInteractor userStatsTabInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @Nullable UserStatsTabData userStatsTabData, @NotNull Analytics analytics, @NotNull ActiveMonthIndexHolder activeMonthIndexHolder) {
        int i2;
        EmptyScreenData placeholder;
        Intrinsics.checkNotNullParameter(userStatsTabInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(activeMonthIndexHolder, "activeMonthIndexHolder");
        this.h = userStatsTabInteractor;
        this.i = schedulersFactory3;
        this.j = userStatsTabData;
        this.k = analytics;
        this.l = activeMonthIndexHolder;
        MutableLiveData<TabState> mutableLiveData = new MutableLiveData<>();
        this.c = mutableLiveData;
        SingleLiveEvent<RouterEvent> singleLiveEvent = new SingleLiveEvent<>();
        this.d = singleLiveEvent;
        this.f = mutableLiveData;
        this.g = singleLiveEvent;
        List<StatsData> data = userStatsTabData != null ? userStatsTabData.getData() : null;
        if (!(data == null || data.isEmpty())) {
            if (activeMonthIndexHolder.getActiveMonthIndex() == -1) {
                i2 = data.size() - 1;
            } else {
                i2 = activeMonthIndexHolder.getActiveMonthIndex();
            }
            onSelectColumn(i2);
        } else if (userStatsTabData != null && (placeholder = userStatsTabData.getPlaceholder()) != null) {
            mutableLiveData.setValue(new TabState.Empty(placeholder.getTitle(), placeholder.getDescription(), placeholder.getButtonText()));
        }
    }

    @NotNull
    public final LiveData<RouterEvent> getRouterEvents() {
        return this.g;
    }

    @NotNull
    public final LiveData<TabState> getTabState() {
        return this.f;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.e.clear();
    }

    public final void onClickDescriptionDetails(@NotNull DescriptionItemPresenter.DescriptionClickDetails descriptionClickDetails) {
        Intrinsics.checkNotNullParameter(descriptionClickDetails, ErrorBundle.DETAIL_ENTRY);
        this.d.setValue(new RouterEvent.OpenDeepLink(descriptionClickDetails.getDeeplink()));
        this.k.track(new UserStatsDetailsClickedEvent(descriptionClickDetails.getFromType()));
    }

    public final void onClickEmptyScreenAction() {
        EmptyScreenData placeholder;
        DeepLink link;
        UserStatsTabData userStatsTabData = this.j;
        if (userStatsTabData != null && (placeholder = userStatsTabData.getPlaceholder()) != null && (link = placeholder.getLink()) != null) {
            this.d.setValue(new RouterEvent.OpenDeepLink(link));
        }
    }

    public final void onResume() {
        TabState value = this.c.getValue();
        if (!(value instanceof TabState.Content)) {
            value = null;
        }
        TabState.Content content = (TabState.Content) value;
        if (content != null && content.getActiveMonthIndex() != this.l.getActiveMonthIndex()) {
            onSelectColumn(this.l.getActiveMonthIndex());
        }
    }

    public final void onSelectColumn(int i2) {
        this.l.setActiveMonthIndex(i2);
        CompositeDisposable compositeDisposable = this.e;
        Disposable subscribe = this.h.createItemsForColumnIndex(i2).observeOn(this.i.mainThread()).subscribe(new c(this, i2), d.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.createItemsFo… tab\", it)\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }
}
