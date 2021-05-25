package com.avito.android.search.subscriptions;

import com.avito.android.remote.model.SearchSubscription;
import com.avito.android.remote.model.SubscriptionResult;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/search/subscriptions/SearchSubscriptionInteractor;", "", "Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/remote/model/SearchSubscription;", "loadRemoteSearchSubscriptions", "()Lio/reactivex/rxjava3/core/Observable;", "", "searchSubscriptionId", "Lcom/avito/android/remote/model/SubscriptionResult;", "removeSearchSubscription", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "subscriptions_release"}, k = 1, mv = {1, 4, 2})
public interface SearchSubscriptionInteractor {
    @NotNull
    Observable<List<SearchSubscription>> loadRemoteSearchSubscriptions();

    @NotNull
    Observable<SubscriptionResult> removeSearchSubscription(@NotNull String str);
}
