package com.avito.android.bottom_navigation.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.BufferedFragmentLifecycleEvent;
import com.avito.android.bottom_navigation.NavigationTabSet;
import com.avito.android.bottom_navigation.ui.fragment.FragmentLifecycleEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b$\u0010%J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ)\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u001b\u0010\u0012\u001a\u00020\u0011*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aRD\u0010!\u001a0\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u001d0\u001d \u001e*\u0017\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u001d0\u001d\u0018\u00010\u001c¢\u0006\u0002\b\u001f0\u001c¢\u0006\u0002\b\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010 R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/avito/android/bottom_navigation/ui/fragment/BottomNavigationLifecycleLogger;", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "Landroidx/fragment/app/FragmentManager;", "fm", "Landroidx/fragment/app/Fragment;", "fragment", "", "onFragmentStarted", "(Landroidx/fragment/app/FragmentManager;Landroidx/fragment/app/Fragment;)V", "onFragmentStopped", "Landroid/os/Bundle;", "savedInstanceState", "onFragmentCreated", "(Landroidx/fragment/app/FragmentManager;Landroidx/fragment/app/Fragment;Landroid/os/Bundle;)V", "onFragmentDestroyed", "Lcom/avito/android/bottom_navigation/NavigationTabSet;", "tabSet", "", AuthSource.SEND_ABUSE, "(Landroidx/fragment/app/Fragment;Lcom/avito/android/bottom_navigation/NavigationTabSet;)Ljava/lang/String;", "Lcom/avito/android/analytics/Analytics;", "c", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/SchedulersFactory3;", "d", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/bottom_navigation/ui/fragment/FragmentLifecycleEvent;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "consumer", AuthSource.BOOKING_ORDER, "Lcom/avito/android/bottom_navigation/NavigationTabSet;", "<init>", "(Lcom/avito/android/bottom_navigation/NavigationTabSet;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory3;)V", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"CheckResult"})
public final class BottomNavigationLifecycleLogger extends FragmentManager.FragmentLifecycleCallbacks {
    public final PublishRelay<FragmentLifecycleEvent> a;
    public final NavigationTabSet b;
    public final Analytics c;
    public final SchedulersFactory3 d;

    public static final class a<T> implements Predicate<FragmentLifecycleEvent> {
        public static final a a = new a();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(FragmentLifecycleEvent fragmentLifecycleEvent) {
            FragmentLifecycleEvent fragmentLifecycleEvent2 = fragmentLifecycleEvent;
            return !(fragmentLifecycleEvent2.getFragment() instanceof TabContainerFragment) && (Intrinsics.areEqual(fragmentLifecycleEvent2.getTab(), "UNKNOWN") ^ true);
        }
    }

    public static final class b<T> implements Predicate<List<FragmentLifecycleEvent>> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(List<FragmentLifecycleEvent> list) {
            List<FragmentLifecycleEvent> list2 = list;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            return !list2.isEmpty();
        }
    }

    public static final class c<T> implements Consumer<BufferedFragmentLifecycleEvent> {
        public final /* synthetic */ BottomNavigationLifecycleLogger a;

        public c(BottomNavigationLifecycleLogger bottomNavigationLifecycleLogger) {
            this.a = bottomNavigationLifecycleLogger;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(BufferedFragmentLifecycleEvent bufferedFragmentLifecycleEvent) {
            BufferedFragmentLifecycleEvent bufferedFragmentLifecycleEvent2 = bufferedFragmentLifecycleEvent;
            Analytics analytics = this.a.c;
            Intrinsics.checkNotNullExpressionValue(bufferedFragmentLifecycleEvent2, "it");
            analytics.track(bufferedFragmentLifecycleEvent2);
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("BottomNavigationFragmentLifecycleCallbacks", " stream error", th);
        }
    }

    public BottomNavigationLifecycleLogger(@NotNull NavigationTabSet navigationTabSet, @NotNull Analytics analytics, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(navigationTabSet, "tabSet");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        this.b = navigationTabSet;
        this.c = analytics;
        this.d = schedulersFactory3;
        PublishRelay<FragmentLifecycleEvent> create = PublishRelay.create();
        this.a = create;
        Observable<FragmentLifecycleEvent> filter = create.filter(a.a);
        Intrinsics.checkNotNullExpressionValue(filter, "consumer\n            .fi…& it.tab != UNKNOWN_TAB }");
        Observable<R> flatMap = filter.groupBy(new Function<FragmentLifecycleEvent, String>() { // from class: com.avito.android.bottom_navigation.ui.fragment.BottomNavigationLifecycleLogger$$special$$inlined$transformByKey$3
            @Override // io.reactivex.rxjava3.functions.Function
            @Nullable
            public final String apply(FragmentLifecycleEvent fragmentLifecycleEvent) {
                Intrinsics.checkNotNullExpressionValue(fragmentLifecycleEvent, "event");
                return fragmentLifecycleEvent.getAction();
            }
        }).flatMap(new BottomNavigationLifecycleLogger$$special$$inlined$transformByKey$4(this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "groupBy { event ->\n     …bs.key, groupedObs)\n    }");
        flatMap.subscribeOn(schedulersFactory3.io()).subscribe(new c(this), d.a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(androidx.fragment.app.Fragment r6, com.avito.android.bottom_navigation.NavigationTabSet r7) {
        /*
            r5 = this;
            java.lang.String r0 = r6.getTag()
            r1 = 0
            if (r0 == 0) goto L_0x0036
            boolean r2 = r7 instanceof java.util.Collection
            r3 = 0
            if (r2 == 0) goto L_0x0013
            boolean r2 = r7.isEmpty()
            if (r2 == 0) goto L_0x0013
            goto L_0x002e
        L_0x0013:
            java.util.Iterator r2 = r7.iterator()
        L_0x0017:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x002e
            java.lang.Object r4 = r2.next()
            com.avito.android.bottom_navigation.NavigationTabSetItem r4 = (com.avito.android.bottom_navigation.NavigationTabSetItem) r4
            java.lang.String r4 = r4.getName()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r0)
            if (r4 == 0) goto L_0x0017
            r3 = 1
        L_0x002e:
            if (r3 == 0) goto L_0x0031
            goto L_0x0032
        L_0x0031:
            r0 = r1
        L_0x0032:
            if (r0 == 0) goto L_0x0036
            r1 = r0
            goto L_0x0040
        L_0x0036:
            androidx.fragment.app.Fragment r6 = r6.getParentFragment()
            if (r6 == 0) goto L_0x0040
            java.lang.String r1 = r5.a(r6, r7)
        L_0x0040:
            if (r1 == 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            java.lang.String r1 = "UNKNOWN"
        L_0x0045:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.bottom_navigation.ui.fragment.BottomNavigationLifecycleLogger.a(androidx.fragment.app.Fragment, com.avito.android.bottom_navigation.NavigationTabSet):java.lang.String");
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentCreated(@NotNull FragmentManager fragmentManager, @NotNull Fragment fragment, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.a.accept(new FragmentLifecycleEvent.Create(a(fragment, this.b), fragment));
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentDestroyed(@NotNull FragmentManager fragmentManager, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.a.accept(new FragmentLifecycleEvent.Destroy(a(fragment, this.b), fragment));
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentStarted(@NotNull FragmentManager fragmentManager, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.a.accept(new FragmentLifecycleEvent.Start(a(fragment, this.b), fragment));
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentStopped(@NotNull FragmentManager fragmentManager, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.a.accept(new FragmentLifecycleEvent.Stop(a(fragment, this.b), fragment));
    }
}
