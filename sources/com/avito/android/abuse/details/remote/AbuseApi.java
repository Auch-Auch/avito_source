package com.avito.android.abuse.details.remote;

import com.avito.android.remote.abuse.AbuseSendingResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.abuse.AbuseCategoriesResult;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ_\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00050\u00042\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u000eH'¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/abuse/details/remote/AbuseApi;", "", "", "itemId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/abuse/AbuseCategoriesResult;", "getAbuseCategories", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "", "abuseCategoryId", "src", AbuseSendingResult.COMMENT, AbuseSendingResult.EMOTION, "", "verifyOnly", "Lcom/avito/android/remote/abuse/AbuseSendingResult;", "sendAbuse", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)Lio/reactivex/rxjava3/core/Observable;", "abuse_release"}, k = 1, mv = {1, 4, 2})
public interface AbuseApi {
    @GET("1/abuse/categories")
    @NotNull
    Observable<TypedResult<AbuseCategoriesResult>> getAbuseCategories(@NotNull @Query("itemId") String str);

    @NotNull
    @FormUrlEncoded
    @POST("1/abuse/report")
    Observable<TypedResult<AbuseSendingResult>> sendAbuse(@Field("abuseCategoryId") int i, @Field("itemId") @NotNull String str, @Field("src") @Nullable String str2, @Field("comment") @Nullable String str3, @Field("emotion") @Nullable Integer num, @Field("verifyOnly") @Nullable Boolean bool);
}
