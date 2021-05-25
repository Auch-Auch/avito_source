package com.avito.android.messenger.service.user_last_activity;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.api.entity.event.ChatTypingEvent;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u000b\u001a*\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00018\u00028\u0002 \u0005*\u0014\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00018\u00028\u0002\u0018\u00010\u00070\u0007\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001\"\b\b\u0002\u0010\u0003*\u00020\u00012\u001c\u0010\u0006\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\f\u0012\n \u0005*\u0004\u0018\u00018\u00018\u00010\u0004H\n¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"KeyT", "", "EventT", "OutT", "Lio/reactivex/observables/GroupedObservable;", "kotlin.jvm.PlatformType", "groupedObs", "Lio/reactivex/ObservableSource;", "apply", "(Lio/reactivex/observables/GroupedObservable;)Lio/reactivex/ObservableSource;", "com/avito/android/util/Observables$transformByKey$2", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class UserLastActivitySyncAgentImpl$subscribeToBackendNotifications$$inlined$transformByKey$2<T, R> implements Function<GroupedObservable<String, ChatTypingEvent>, ObservableSource<? extends ChatTypingEvent>> {
    public final ObservableSource<? extends ChatTypingEvent> apply(@NotNull GroupedObservable<String, ChatTypingEvent> groupedObservable) {
        Intrinsics.checkNotNullParameter(groupedObservable, "groupedObs");
        if (!(groupedObservable.getKey() != null)) {
            return groupedObservable;
        }
        Observable<ChatTypingEvent> throttleLatest = groupedObservable.throttleLatest(5000L, TimeUnit.MILLISECONDS, true);
        Intrinsics.checkNotNullExpressionValue(throttleLatest, "throttleLatest(\n        …                        )");
        return throttleLatest;
    }
}
