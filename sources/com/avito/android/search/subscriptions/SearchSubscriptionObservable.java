package com.avito.android.search.subscriptions;

import com.avito.android.analytics.event.SavedSearchesCounter;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H&¢\u0006\u0004\b\t\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/avito/android/search/subscriptions/SearchSubscriptionObservable;", "", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/analytics/event/SavedSearchesCounter;", "observeCounter", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/search/subscriptions/SearchSubscriptionSynchronizedEvent;", "observeSynchronizedEvent", "Lcom/avito/android/search/subscriptions/SearchSubscriptionUpdatedEvent;", "observeUpdatedEvent", "core_release"}, k = 1, mv = {1, 4, 2})
public interface SearchSubscriptionObservable {
    @NotNull
    Observable<SavedSearchesCounter> observeCounter();

    @NotNull
    Observable<SearchSubscriptionSynchronizedEvent> observeSynchronizedEvent();

    @NotNull
    Observable<SearchSubscriptionUpdatedEvent> observeUpdatedEvent();
}
