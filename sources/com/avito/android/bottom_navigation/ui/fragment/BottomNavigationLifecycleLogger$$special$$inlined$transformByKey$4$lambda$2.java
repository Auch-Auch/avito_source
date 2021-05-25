package com.avito.android.bottom_navigation.ui.fragment;

import com.avito.android.analytics.event.BufferedFragmentLifecycleEvent;
import com.avito.android.bottom_navigation.ui.fragment.BottomNavigationLifecycleLogger;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.observables.GroupedObservable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u000b\u001a*\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00018\u00028\u0002 \u0005*\u0014\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00018\u00028\u0002\u0018\u00010\u00070\u0007\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001\"\b\b\u0002\u0010\u0003*\u00020\u00012:\u0010\u0006\u001a6\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\f\u0012\n \u0005*\u0004\u0018\u00018\u00018\u0001 \u0005*\u001a\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\f\u0012\n \u0005*\u0004\u0018\u00018\u00018\u0001\u0018\u00010\u00040\u0004H\n¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"KeyT", "", "EventT", "OutT", "Lio/reactivex/rxjava3/observables/GroupedObservable;", "kotlin.jvm.PlatformType", "groupedObs", "Lio/reactivex/rxjava3/core/ObservableSource;", "apply", "(Lio/reactivex/rxjava3/observables/GroupedObservable;)Lio/reactivex/rxjava3/core/ObservableSource;", "com/avito/android/bottom_navigation/ui/fragment/BottomNavigationLifecycleLogger$$special$$inlined$transformByKey$2", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class BottomNavigationLifecycleLogger$$special$$inlined$transformByKey$4$lambda$2<T, R> implements Function<GroupedObservable<String, FragmentLifecycleEvent>, ObservableSource<? extends BufferedFragmentLifecycleEvent>> {
    public final /* synthetic */ String a;
    public final /* synthetic */ BottomNavigationLifecycleLogger$$special$$inlined$transformByKey$4 b;

    public static final class a<T, R> implements Function<List<FragmentLifecycleEvent>, BufferedFragmentLifecycleEvent> {
        public final /* synthetic */ String a;
        public final /* synthetic */ BottomNavigationLifecycleLogger$$special$$inlined$transformByKey$4$lambda$2 b;

        public a(String str, BottomNavigationLifecycleLogger$$special$$inlined$transformByKey$4$lambda$2 bottomNavigationLifecycleLogger$$special$$inlined$transformByKey$4$lambda$2) {
            this.a = str;
            this.b = bottomNavigationLifecycleLogger$$special$$inlined$transformByKey$4$lambda$2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public BufferedFragmentLifecycleEvent apply(List<FragmentLifecycleEvent> list) {
            List<FragmentLifecycleEvent> list2 = list;
            String str = this.a;
            Intrinsics.checkNotNull(str);
            String str2 = this.b.a;
            Intrinsics.checkNotNull(str2);
            Intrinsics.checkNotNullExpressionValue(list2, "bufferedEvents");
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getFragment());
            }
            return new BufferedFragmentLifecycleEvent(str, str2, arrayList);
        }
    }

    public BottomNavigationLifecycleLogger$$special$$inlined$transformByKey$4$lambda$2(String str, BottomNavigationLifecycleLogger$$special$$inlined$transformByKey$4 bottomNavigationLifecycleLogger$$special$$inlined$transformByKey$4) {
        this.a = str;
        this.b = bottomNavigationLifecycleLogger$$special$$inlined$transformByKey$4;
    }

    public final ObservableSource<? extends BufferedFragmentLifecycleEvent> apply(GroupedObservable<String, FragmentLifecycleEvent> groupedObservable) {
        Intrinsics.checkNotNullExpressionValue(groupedObservable, "groupedObs");
        Observable<R> map = groupedObservable.buffer(500, TimeUnit.MILLISECONDS, this.b.a.d.computation()).takeWhile(BottomNavigationLifecycleLogger.b.a).map(new a(groupedObservable.getKey(), this));
        Intrinsics.checkNotNullExpressionValue(map, "streamByTab\n            …                        }");
        return map;
    }
}
