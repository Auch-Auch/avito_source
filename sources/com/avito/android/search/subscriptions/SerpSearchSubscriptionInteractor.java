package com.avito.android.search.subscriptions;

import com.avito.android.remote.model.SearchParams;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.funktionale.option.Option;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/search/subscriptions/SerpSearchSubscriptionInteractor;", "", "", "subscriptionId", "", "isSubscribed", "(Ljava/lang/String;)Z", "Lio/reactivex/rxjava3/core/Observable;", "Lorg/funktionale/option/Option;", "Lcom/avito/android/remote/model/SearchParams;", "loadSearchParams", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "", "resetUnreadChangesCount", "(Ljava/lang/String;)V", "search-base_release"}, k = 1, mv = {1, 4, 2})
public interface SerpSearchSubscriptionInteractor {
    boolean isSubscribed(@NotNull String str);

    @NotNull
    Observable<Option<SearchParams>> loadSearchParams(@NotNull String str);

    void resetUnreadChangesCount(@NotNull String str);
}
