package com.avito.android.spare_parts.remote;

import com.avito.android.remote.models.SparePartsResponse;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.Query;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J3\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ3\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0002H'¢\u0006\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/spare_parts/remote/SparePartsApi;", "", "", "microCategoryId", "vendorInfmId", "partNumber", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/models/SparePartsResponse;", "getCompatibilities", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "getReplacements", "spare-parts_release"}, k = 1, mv = {1, 4, 2})
public interface SparePartsApi {
    @GET("1/parts/compatibilities")
    @NotNull
    Observable<SparePartsResponse> getCompatibilities(@NotNull @Query("microCategoryID") String str, @NotNull @Query("vendorInfmID") String str2, @NotNull @Query("partNumber") String str3);

    @GET("1/parts/replacements")
    @NotNull
    Observable<SparePartsResponse> getReplacements(@NotNull @Query("microCategoryID") String str, @NotNull @Query("vendorInfmID") String str2, @NotNull @Query("partNumber") String str3);
}
