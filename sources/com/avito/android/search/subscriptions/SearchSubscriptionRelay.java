package com.avito.android.search.subscriptions;

import com.avito.android.analytics.event.SavedSearchesCounter;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/subscriptions/SearchSubscriptionRelay;", "Lcom/avito/android/search/subscriptions/SearchSubscriptionConsumer;", "Lcom/avito/android/search/subscriptions/SearchSubscriptionObservable;", "Impl", "core_release"}, k = 1, mv = {1, 4, 2})
public interface SearchSubscriptionRelay extends SearchSubscriptionConsumer, SearchSubscriptionObservable {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0005\u0010\u000bJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\fH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\fH\u0016¢\u0006\u0004\b\u0010\u0010\u000eRD\u0010\u0016\u001a0\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\n0\n \u0012*\u0017\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\n0\n\u0018\u00010\u0011¢\u0006\u0002\b\u00130\u0011¢\u0006\u0002\b\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015RD\u0010\u0018\u001a0\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00020\u0002 \u0012*\u0017\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u0011¢\u0006\u0002\b\u00130\u0011¢\u0006\u0002\b\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015RD\u0010\u001a\u001a0\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00070\u0007 \u0012*\u0017\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u0011¢\u0006\u0002\b\u00130\u0011¢\u0006\u0002\b\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/avito/android/search/subscriptions/SearchSubscriptionRelay$Impl;", "Lcom/avito/android/search/subscriptions/SearchSubscriptionRelay;", "Lcom/avito/android/analytics/event/SavedSearchesCounter;", "counter", "", "accept", "(Lcom/avito/android/analytics/event/SavedSearchesCounter;)V", "Lcom/avito/android/search/subscriptions/SearchSubscriptionSynchronizedEvent;", "event", "(Lcom/avito/android/search/subscriptions/SearchSubscriptionSynchronizedEvent;)V", "Lcom/avito/android/search/subscriptions/SearchSubscriptionUpdatedEvent;", "(Lcom/avito/android/search/subscriptions/SearchSubscriptionUpdatedEvent;)V", "Lio/reactivex/rxjava3/core/Observable;", "observeCounter", "()Lio/reactivex/rxjava3/core/Observable;", "observeSynchronizedEvent", "observeUpdatedEvent", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "c", "Lcom/jakewharton/rxrelay3/PublishRelay;", "updatedEventRelay", AuthSource.SEND_ABUSE, "counterRelay", AuthSource.BOOKING_ORDER, "synchronizedEventRelay", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements SearchSubscriptionRelay {
        public final PublishRelay<SavedSearchesCounter> a = PublishRelay.create();
        public final PublishRelay<SearchSubscriptionSynchronizedEvent> b = PublishRelay.create();
        public final PublishRelay<SearchSubscriptionUpdatedEvent> c = PublishRelay.create();

        @Override // com.avito.android.search.subscriptions.SearchSubscriptionConsumer
        public void accept(@NotNull SavedSearchesCounter savedSearchesCounter) {
            Intrinsics.checkNotNullParameter(savedSearchesCounter, "counter");
            this.a.accept(savedSearchesCounter);
        }

        @Override // com.avito.android.search.subscriptions.SearchSubscriptionObservable
        @NotNull
        public Observable<SavedSearchesCounter> observeCounter() {
            PublishRelay<SavedSearchesCounter> publishRelay = this.a;
            Intrinsics.checkNotNullExpressionValue(publishRelay, "counterRelay");
            return publishRelay;
        }

        @Override // com.avito.android.search.subscriptions.SearchSubscriptionObservable
        @NotNull
        public Observable<SearchSubscriptionSynchronizedEvent> observeSynchronizedEvent() {
            PublishRelay<SearchSubscriptionSynchronizedEvent> publishRelay = this.b;
            Intrinsics.checkNotNullExpressionValue(publishRelay, "synchronizedEventRelay");
            return publishRelay;
        }

        @Override // com.avito.android.search.subscriptions.SearchSubscriptionObservable
        @NotNull
        public Observable<SearchSubscriptionUpdatedEvent> observeUpdatedEvent() {
            PublishRelay<SearchSubscriptionUpdatedEvent> publishRelay = this.c;
            Intrinsics.checkNotNullExpressionValue(publishRelay, "updatedEventRelay");
            return publishRelay;
        }

        @Override // com.avito.android.search.subscriptions.SearchSubscriptionConsumer
        public void accept(@NotNull SearchSubscriptionSynchronizedEvent searchSubscriptionSynchronizedEvent) {
            Intrinsics.checkNotNullParameter(searchSubscriptionSynchronizedEvent, "event");
            this.b.accept(searchSubscriptionSynchronizedEvent);
        }

        @Override // com.avito.android.search.subscriptions.SearchSubscriptionConsumer
        public void accept(@NotNull SearchSubscriptionUpdatedEvent searchSubscriptionUpdatedEvent) {
            Intrinsics.checkNotNullParameter(searchSubscriptionUpdatedEvent, "event");
            this.c.accept(searchSubscriptionUpdatedEvent);
        }
    }
}
