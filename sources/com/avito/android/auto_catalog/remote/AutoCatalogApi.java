package com.avito.android.auto_catalog.remote;

import com.avito.android.auto_catalog.remote.model.AutoCatalogResponse;
import com.avito.android.remote.NetworkRequestEventId;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Query;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JS\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/auto_catalog/remote/AutoCatalogApi;", "", "", "generationId", "bodyTypeId", "modificationId", "from", "locationId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/auto_catalog/remote/model/AutoCatalogResponse;", "getAutoCatalog", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
public interface AutoCatalogApi {
    @GET("1/swaha/v1/autocatalog/modifications?platform=android")
    @NotNull
    @NetworkRequestEventId(eventId = 3842)
    Observable<TypedResult<AutoCatalogResponse>> getAutoCatalog(@NotNull @Query("generationId") String str, @NotNull @Query("bodyTypeId") String str2, @Nullable @Query("modificationId") String str3, @Nullable @Query("from") String str4, @Nullable @Query("locationId") String str5);
}
