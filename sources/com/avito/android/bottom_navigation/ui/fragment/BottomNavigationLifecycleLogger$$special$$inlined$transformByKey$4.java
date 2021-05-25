package com.avito.android.bottom_navigation.ui.fragment;

import com.avito.android.analytics.event.BufferedFragmentLifecycleEvent;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.observables.GroupedObservable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u000b\u001a*\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00018\u00028\u0002 \u0005*\u0014\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00018\u00028\u0002\u0018\u00010\u00070\u0007\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001\"\b\b\u0002\u0010\u0003*\u00020\u00012:\u0010\u0006\u001a6\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\f\u0012\n \u0005*\u0004\u0018\u00018\u00018\u0001 \u0005*\u001a\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\f\u0012\n \u0005*\u0004\u0018\u00018\u00018\u0001\u0018\u00010\u00040\u0004H\n¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"KeyT", "", "EventT", "OutT", "Lio/reactivex/rxjava3/observables/GroupedObservable;", "kotlin.jvm.PlatformType", "groupedObs", "Lio/reactivex/rxjava3/core/ObservableSource;", "apply", "(Lio/reactivex/rxjava3/observables/GroupedObservable;)Lio/reactivex/rxjava3/core/ObservableSource;", "com/avito/android/util/rx3/Observables$transformByKey$2", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class BottomNavigationLifecycleLogger$$special$$inlined$transformByKey$4<T, R> implements Function<GroupedObservable<String, FragmentLifecycleEvent>, ObservableSource<? extends BufferedFragmentLifecycleEvent>> {
    public final /* synthetic */ BottomNavigationLifecycleLogger a;

    public BottomNavigationLifecycleLogger$$special$$inlined$transformByKey$4(BottomNavigationLifecycleLogger bottomNavigationLifecycleLogger) {
        this.a = bottomNavigationLifecycleLogger;
    }

    public final ObservableSource<? extends BufferedFragmentLifecycleEvent> apply(GroupedObservable<String, FragmentLifecycleEvent> groupedObservable) {
        Intrinsics.checkNotNullExpressionValue(groupedObservable, "groupedObs");
        Observable<R> flatMap = groupedObservable.groupBy(new Function<FragmentLifecycleEvent, String>() { // from class: com.avito.android.bottom_navigation.ui.fragment.BottomNavigationLifecycleLogger$$special$$inlined$transformByKey$4$lambda$1
            @Override // io.reactivex.rxjava3.functions.Function
            @Nullable
            public final String apply(FragmentLifecycleEvent fragmentLifecycleEvent) {
                Intrinsics.checkNotNullExpressionValue(fragmentLifecycleEvent, "event");
                return fragmentLifecycleEvent.getTab();
            }
        }).flatMap(new BottomNavigationLifecycleLogger$$special$$inlined$transformByKey$4$lambda$2(groupedObservable.getKey(), this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "groupBy { event ->\n     …bs.key, groupedObs)\n    }");
        return flatMap;
    }
}
