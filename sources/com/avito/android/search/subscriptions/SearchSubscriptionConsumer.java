package com.avito.android.search.subscriptions;

import com.avito.android.analytics.event.SavedSearchesCounter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0005\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\nH&¢\u0006\u0004\b\u0005\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/search/subscriptions/SearchSubscriptionConsumer;", "", "Lcom/avito/android/analytics/event/SavedSearchesCounter;", "counter", "", "accept", "(Lcom/avito/android/analytics/event/SavedSearchesCounter;)V", "Lcom/avito/android/search/subscriptions/SearchSubscriptionSynchronizedEvent;", "event", "(Lcom/avito/android/search/subscriptions/SearchSubscriptionSynchronizedEvent;)V", "Lcom/avito/android/search/subscriptions/SearchSubscriptionUpdatedEvent;", "(Lcom/avito/android/search/subscriptions/SearchSubscriptionUpdatedEvent;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public interface SearchSubscriptionConsumer {
    void accept(@NotNull SavedSearchesCounter savedSearchesCounter);

    void accept(@NotNull SearchSubscriptionSynchronizedEvent searchSubscriptionSynchronizedEvent);

    void accept(@NotNull SearchSubscriptionUpdatedEvent searchSubscriptionUpdatedEvent);
}
