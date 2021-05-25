package com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list;

import com.avito.android.remote.model.RawJson;
import com.avito.android.remote.model.messenger.context_actions.RecommendationsResponse;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J'\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\b\u0010\tJ'\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\n\u0010\tR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/item_list/ItemsListInteractor;", "", "", "methodName", "Lcom/avito/android/remote/model/RawJson;", "params", "Lio/reactivex/Single;", "Lcom/avito/android/remote/model/messenger/context_actions/RecommendationsResponse;", "getItems", "(Ljava/lang/String;Lcom/avito/android/remote/model/RawJson;)Lio/reactivex/Single;", "callApiMethod", "Lio/reactivex/Observable;", "", "getReconnects", "()Lio/reactivex/Observable;", "reconnects", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ItemsListInteractor {
    @NotNull
    Single<RawJson> callApiMethod(@NotNull String str, @Nullable RawJson rawJson);

    @NotNull
    Single<RecommendationsResponse> getItems(@NotNull String str, @Nullable RawJson rawJson);

    @NotNull
    Observable<Unit> getReconnects();
}
