package com.avito.android.bottom_navigation;

import a2.a.a.v.a;
import a2.a.a.v.b;
import a2.g.r.g;
import android.annotation.SuppressLint;
import android.os.Handler;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.ScreenNavigationEvent;
import com.avito.android.analytics.event.TabSelectedEvent;
import com.avito.android.analytics.event.UnauthPublishAttemptEvent;
import com.avito.android.bottom_navigation.ui.OnTabClickListener;
import com.avito.android.bottom_navigation.ui.fragment.ResultDispatcher;
import com.avito.android.bottom_navigation.ui.fragment.TabFragmentManager;
import com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.fragments.ResultFragmentData;
import com.avito.android.ui.fragments.ResultReportData;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010c\u001a\u00020`\u0012\u0006\u0010O\u001a\u00020L\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u0010Z\u001a\u00020W\u0012\u0006\u0010K\u001a\u00020H\u0012\u0006\u0010V\u001a\u00020S\u0012\u0006\u0010g\u001a\u00020d\u0012\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\\0[\u0012\u0006\u0010q\u001a\u00020n¢\u0006\u0004\br\u0010sJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\bJ\r\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u000bJ\u001d\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ/\u0010!\u001a\u00020\u00042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u001d2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u001f¢\u0006\u0004\b!\u0010\"J\u0013\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00110\u001d¢\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u001f¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b'\u0010(J\u0015\u0010)\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0019¢\u0006\u0004\b)\u0010\u001cJ\r\u0010*\u001a\u00020\u0004¢\u0006\u0004\b*\u0010\u000bJ\u001d\u0010/\u001a\u00020\u00042\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100J\u0017\u00103\u001a\u00020\u00042\u0006\u00102\u001a\u000201H\u0002¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b5\u0010\u0006R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010;\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u001c\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\"\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00150D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u001c\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u001c\u0010_\u001a\b\u0012\u0004\u0012\u00020\\0[8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010g\u001a\u00020d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u001f\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00020h8\u0006@\u0006¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010lR\u0016\u0010q\u001a\u00020n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bo\u0010p¨\u0006t"}, d2 = {"Lcom/avito/android/bottom_navigation/BottomNavigationController;", "", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "tab", "", "selectTab", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)V", "currentTab", "()Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "previousTab", "onBackPressed", "()V", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;", "data", "openScreen", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;)V", "upNavigationTab", "", "count", "setTabBadge", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;I)V", "Lcom/avito/android/bottom_navigation/AddButtonState;", "state", "setAddButtonStateByTab", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;Lcom/avito/android/bottom_navigation/AddButtonState;)V", "Lcom/avito/android/ui/fragments/ResultFragmentData;", "fragmentResult", "restoreFragmentResult", "(Lcom/avito/android/ui/fragments/ResultFragmentData;)V", "", "tabOrdinals", "", "addButtonStatesOrdinals", "restoreState", "(Ljava/util/List;Ljava/util/Map;)V", "saveTabStackOrdinals", "()Ljava/util/List;", "saveAddButtonStateOrdinals", "()Ljava/util/Map;", "saveFragmentResult", "()Lcom/avito/android/ui/fragments/ResultFragmentData;", "registerStartForResult", "finish", "", "fragmentId", "Lcom/avito/android/ui/fragments/ResultReportData;", "resultReportData", "reportResult", "(Ljava/lang/String;Lcom/avito/android/ui/fragments/ResultReportData;)V", "", "isBackPressed", AuthSource.SEND_ABUSE, "(Z)V", AuthSource.BOOKING_ORDER, "Lcom/avito/android/bottom_navigation/ui/fragment/TabFragmentManager;", "i", "Lcom/avito/android/bottom_navigation/ui/fragment/TabFragmentManager;", "tabFragmentManager", "Lcom/avito/android/ui/fragments/ResultFragmentData;", "resultData", "Lcom/avito/android/bottom_navigation/ui/OnTabClickListener;", "d", "Lcom/avito/android/bottom_navigation/ui/OnTabClickListener;", "onTabClickListener", "Ljava/util/ArrayDeque;", "e", "Ljava/util/ArrayDeque;", "tabStack", "", "f", "Ljava/util/Map;", "addButtonState", "Lcom/avito/android/bottom_navigation/BottomNavigationRouter;", "k", "Lcom/avito/android/bottom_navigation/BottomNavigationRouter;", "bottomNavigationRouter", "Lcom/avito/android/bottom_navigation/BottomNavigationView;", "h", "Lcom/avito/android/bottom_navigation/BottomNavigationView;", "bottomNavigationView", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "navigationTabRelay", "Lcom/avito/android/analytics/Analytics;", "l", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/bottom_navigation/BottomNavigationAuthorizationProvider;", "j", "Lcom/avito/android/bottom_navigation/BottomNavigationAuthorizationProvider;", "authorizationProvider", "", "Lcom/avito/android/bottom_navigation/ui/fragment/ResultDispatcher;", "n", "Ljava/util/Set;", "dispatchers", "Lcom/avito/android/bottom_navigation/NavigationTabSet;", g.a, "Lcom/avito/android/bottom_navigation/NavigationTabSet;", "navigationTabSet", "Landroid/os/Handler;", AuthSource.OPEN_CHANNEL_LIST, "Landroid/os/Handler;", "handler", "Lio/reactivex/rxjava3/core/Observable;", "c", "Lio/reactivex/rxjava3/core/Observable;", "getTabClickObservable", "()Lio/reactivex/rxjava3/core/Observable;", "tabClickObservable", "Lcom/avito/android/bottom_navigation/BottomNavigationTestGroup;", "o", "Lcom/avito/android/bottom_navigation/BottomNavigationTestGroup;", "userAdvertsTabTestGroup", "<init>", "(Lcom/avito/android/bottom_navigation/NavigationTabSet;Lcom/avito/android/bottom_navigation/BottomNavigationView;Lcom/avito/android/bottom_navigation/ui/fragment/TabFragmentManager;Lcom/avito/android/bottom_navigation/BottomNavigationAuthorizationProvider;Lcom/avito/android/bottom_navigation/BottomNavigationRouter;Lcom/avito/android/analytics/Analytics;Landroid/os/Handler;Ljava/util/Set;Lcom/avito/android/bottom_navigation/BottomNavigationTestGroup;)V", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
public final class BottomNavigationController {
    public final PublishRelay<NavigationTabSetItem> a;
    public ResultFragmentData b;
    @NotNull
    public final Observable<NavigationTabSetItem> c;
    public final OnTabClickListener d;
    public final ArrayDeque<NavigationTabSetItem> e = new ArrayDeque<>();
    public final Map<NavigationTabSetItem, AddButtonState> f = new LinkedHashMap();
    public final NavigationTabSet g;
    public final BottomNavigationView h;
    public final TabFragmentManager i;
    public final BottomNavigationAuthorizationProvider j;
    public final BottomNavigationRouter k;
    public final Analytics l;
    public final Handler m;
    public final Set<ResultDispatcher> n;
    public final BottomNavigationTestGroup o;

    public BottomNavigationController(@NotNull NavigationTabSet navigationTabSet, @NotNull BottomNavigationView bottomNavigationView, @NotNull TabFragmentManager tabFragmentManager, @NotNull BottomNavigationAuthorizationProvider bottomNavigationAuthorizationProvider, @NotNull BottomNavigationRouter bottomNavigationRouter, @NotNull Analytics analytics, @NotNull Handler handler, @NotNull Set<ResultDispatcher> set, @NotNull BottomNavigationTestGroup bottomNavigationTestGroup) {
        Intrinsics.checkNotNullParameter(navigationTabSet, "navigationTabSet");
        Intrinsics.checkNotNullParameter(bottomNavigationView, "bottomNavigationView");
        Intrinsics.checkNotNullParameter(tabFragmentManager, "tabFragmentManager");
        Intrinsics.checkNotNullParameter(bottomNavigationAuthorizationProvider, "authorizationProvider");
        Intrinsics.checkNotNullParameter(bottomNavigationRouter, "bottomNavigationRouter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(set, "dispatchers");
        Intrinsics.checkNotNullParameter(bottomNavigationTestGroup, "userAdvertsTabTestGroup");
        this.g = navigationTabSet;
        this.h = bottomNavigationView;
        this.i = tabFragmentManager;
        this.j = bottomNavigationAuthorizationProvider;
        this.k = bottomNavigationRouter;
        this.l = analytics;
        this.m = handler;
        this.n = set;
        this.o = bottomNavigationTestGroup;
        PublishRelay<NavigationTabSetItem> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.a = create;
        this.c = create;
        BottomNavigationController$onTabClickListener$1 bottomNavigationController$onTabClickListener$1 = new OnTabClickListener(this) { // from class: com.avito.android.bottom_navigation.BottomNavigationController$onTabClickListener$1
            public final /* synthetic */ BottomNavigationController a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.bottom_navigation.ui.OnTabClickListener
            @SuppressLint({"DefaultLocale"})
            public void onTabClick(@NotNull NavigationTabSetItem navigationTabSetItem) {
                Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
                this.a.selectTab(navigationTabSetItem);
                this.a.a.accept(navigationTabSetItem);
                this.a.l.track(new TabSelectedEvent(navigationTabSetItem.getName()));
                Analytics analytics2 = this.a.l;
                String name = navigationTabSetItem.getName();
                Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = name.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                analytics2.track(new ScreenNavigationEvent(lowerCase, true));
            }
        };
        this.d = bottomNavigationController$onTabClickListener$1;
        bottomNavigationView.setOnTabClickListener(bottomNavigationController$onTabClickListener$1);
    }

    public final void a(boolean z) {
        if (this.i.isEnable()) {
            NavigationTabSetItem currentTab = currentTab();
            if (currentTab != null) {
                if (!this.i.finish(currentTab, z)) {
                    this.e.remove(currentTab);
                    this.f.remove(currentTab);
                    NavigationTabSetItem currentTab2 = currentTab();
                    if (currentTab2 != null) {
                        this.i.changeTab(currentTab2, previousTab());
                        b(currentTab2);
                    } else {
                        this.k.finishScreen();
                    }
                }
                NavigationTabSetItem currentTab3 = currentTab();
                if (currentTab3 != null) {
                    this.m.post(new b(this, currentTab3));
                    return;
                }
                return;
            }
            this.k.finishScreen();
        }
    }

    public final void b(NavigationTabSetItem navigationTabSetItem) {
        if (this.i.isEnable()) {
            this.h.selectTab(navigationTabSetItem);
            this.m.post(new b(this, navigationTabSetItem));
            AddButtonState addButtonState = this.f.get(navigationTabSetItem);
            if (addButtonState == null) {
                addButtonState = navigationTabSetItem.getAddButtonState();
            }
            this.m.post(new a(this, addButtonState));
        }
    }

    @Nullable
    public final NavigationTabSetItem currentTab() {
        return (NavigationTabSetItem) CollectionsKt___CollectionsKt.lastOrNull(this.e);
    }

    public final void finish() {
        a(false);
    }

    @NotNull
    public final Observable<NavigationTabSetItem> getTabClickObservable() {
        return this.c;
    }

    public final void onBackPressed() {
        a(true);
    }

    public final void openScreen(@NotNull TabFragmentFactory.Data data) {
        NavigationTabSetItem navigationTabSetItem;
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.i.isEnable()) {
            if (this.o.isTest()) {
                navigationTabSetItem = data.getTabInProfileTest();
            } else {
                navigationTabSetItem = data.getTabInControl();
            }
            if (navigationTabSetItem != null) {
                NavigationTabSetItem currentTab = currentTab();
                if ((currentTab != null ? currentTab.getAddButtonState() : null) == AddButtonState.ACTIVE) {
                    onBackPressed();
                }
                if (!data.getNeedAuthorization() || this.j.isLogged()) {
                    this.i.openData(data, currentTab, this.b);
                    this.b = null;
                    this.e.remove(navigationTabSetItem);
                    this.e.add(navigationTabSetItem);
                    b(navigationTabSetItem);
                    return;
                }
                this.k.auth(data);
            }
        }
    }

    @Nullable
    public final NavigationTabSetItem previousTab() {
        T t = null;
        for (T t2 : this.e) {
            if (!Intrinsics.areEqual(t2, currentTab())) {
                t = t2;
            }
        }
        return t;
    }

    public final void registerStartForResult(@NotNull ResultFragmentData resultFragmentData) {
        Intrinsics.checkNotNullParameter(resultFragmentData, "data");
        this.b = resultFragmentData;
    }

    public final void reportResult(@NotNull String str, @NotNull ResultReportData resultReportData) {
        Intrinsics.checkNotNullParameter(str, "fragmentId");
        Intrinsics.checkNotNullParameter(resultReportData, "resultReportData");
        for (ResultDispatcher resultDispatcher : this.n) {
            if (Intrinsics.areEqual(str, resultDispatcher.getId())) {
                resultDispatcher.reportResults(resultReportData);
            }
        }
    }

    public final void restoreFragmentResult(@Nullable ResultFragmentData resultFragmentData) {
        if (resultFragmentData != null) {
            registerStartForResult(resultFragmentData);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: java.util.ArrayDeque<com.avito.android.bottom_navigation.NavigationTabSetItem> */
    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: java.util.Map<com.avito.android.bottom_navigation.NavigationTabSetItem, com.avito.android.bottom_navigation.AddButtonState> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void restoreState(@NotNull List<Integer> list, @NotNull Map<Integer, Integer> map) {
        Intrinsics.checkNotNullParameter(list, "tabOrdinals");
        Intrinsics.checkNotNullParameter(map, "addButtonStatesOrdinals");
        this.f.clear();
        for (T t : map.entrySet()) {
            this.f.put(CollectionsKt___CollectionsKt.toList(this.g).get(((Number) t.getKey()).intValue()), AddButtonState.values()[((Number) t.getValue()).intValue()]);
        }
        if (!list.isEmpty()) {
            this.e.clear();
            for (Integer num : list) {
                this.e.add(CollectionsKt___CollectionsKt.toList(this.g).get(num.intValue()));
            }
            Object last = CollectionsKt___CollectionsKt.last(this.e);
            Intrinsics.checkNotNullExpressionValue(last, "tabStack.last()");
            b((NavigationTabSetItem) last);
            TabFragmentManager tabFragmentManager = this.i;
            Object last2 = CollectionsKt___CollectionsKt.last(this.e);
            Intrinsics.checkNotNullExpressionValue(last2, "tabStack.last()");
            tabFragmentManager.changeTab((NavigationTabSetItem) last2, previousTab());
        }
    }

    @NotNull
    public final Map<Integer, Integer> saveAddButtonStateOrdinals() {
        HashMap hashMap = new HashMap();
        for (T t : this.f.entrySet()) {
            hashMap.put(Integer.valueOf(CollectionsKt___CollectionsKt.indexOf(this.g, t.getKey())), Integer.valueOf(((AddButtonState) t.getValue()).ordinal()));
        }
        return hashMap;
    }

    @Nullable
    public final ResultFragmentData saveFragmentResult() {
        return this.b;
    }

    @NotNull
    public final List<Integer> saveTabStackOrdinals() {
        ArrayDeque<NavigationTabSetItem> arrayDeque = this.e;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(arrayDeque, 10));
        Iterator<T> it = arrayDeque.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(CollectionsKt___CollectionsKt.indexOf(this.g, it.next())));
        }
        return arrayList;
    }

    public final void selectTab(@NotNull NavigationTabSetItem navigationTabSetItem) {
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        if (this.i.isEnable()) {
            if (!navigationTabSetItem.getNeedAuthorization() || this.j.isLogged()) {
                NavigationTabSetItem currentTab = currentTab();
                if (!Intrinsics.areEqual(navigationTabSetItem, currentTab)) {
                    this.i.changeTab(navigationTabSetItem, currentTab);
                } else if (navigationTabSetItem.getAddButtonState() == AddButtonState.ACTIVE) {
                    onBackPressed();
                    return;
                } else {
                    this.i.upNavigationTab(navigationTabSetItem);
                }
                this.e.remove(navigationTabSetItem);
                this.e.add(navigationTabSetItem);
                b(navigationTabSetItem);
                return;
            }
            if (navigationTabSetItem.getAddButtonState() == AddButtonState.ACTIVE) {
                this.l.track(new UnauthPublishAttemptEvent());
            }
            this.k.auth(navigationTabSetItem);
        }
    }

    public final void setAddButtonStateByTab(@NotNull NavigationTabSetItem navigationTabSetItem, @NotNull AddButtonState addButtonState) {
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        Intrinsics.checkNotNullParameter(addButtonState, "state");
        AddButtonState put = this.f.put(navigationTabSetItem, addButtonState);
        if (Intrinsics.areEqual(navigationTabSetItem, currentTab()) && addButtonState != put) {
            this.m.post(new a(this, addButtonState));
        }
    }

    public final void setTabBadge(@NotNull NavigationTabSetItem navigationTabSetItem, int i2) {
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        this.h.setTabBadge(navigationTabSetItem, i2);
    }

    public final void upNavigationTab() {
        if (this.i.isEnable()) {
            NavigationTabSetItem currentTab = currentTab();
            this.i.upNavigationTab(currentTab);
            if (currentTab != null) {
                this.m.post(new b(this, currentTab));
            }
        }
    }
}
