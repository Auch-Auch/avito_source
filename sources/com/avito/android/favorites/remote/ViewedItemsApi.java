package com.avito.android.favorites.remote;

import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.ViewedItemsCountResponse;
import com.avito.android.remote.model.ViewedItemsResponse;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.Url;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\b\b\u0001\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00030\u0002H'¢\u0006\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/favorites/remote/ViewedItemsApi;", "", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/ViewedItemsResponse;", "getViewedItems", "()Lio/reactivex/rxjava3/core/Observable;", "", "nextPage", "getViewedItemsNextPage", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/ViewedItemsCountResponse;", "getViewedItemsCount", "favorite_release"}, k = 1, mv = {1, 4, 2})
public interface ViewedItemsApi {
    @GET("1/viewed_items")
    @NotNull
    Observable<TypedResult<ViewedItemsResponse>> getViewedItems();

    @GET("1/viewed_items/count")
    @NotNull
    Observable<TypedResult<ViewedItemsCountResponse>> getViewedItemsCount();

    @GET
    @NotNull
    Observable<TypedResult<ViewedItemsResponse>> getViewedItemsNextPage(@Url @NotNull String str);
}
