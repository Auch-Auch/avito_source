package com.avito.android.remote;

import com.avito.android.remote.model.SimpleMessageResult;
import com.avito.android.remote.model.SumSubSdkTokenResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.VerificationOptionsListResult;
import com.avito.android.remote.model.VerificationStatusResult;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.POST;
import retrofit2.http.Query;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00030\u0002H'¢\u0006\u0004\b\b\u0010\u0006J%\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00030\u00022\b\b\u0001\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\f\u0010\rJ%\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00030\u00022\b\b\u0001\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/remote/VerificationApi;", "", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/SumSubSdkTokenResult;", "getSumsubSdkToken", "()Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/VerificationOptionsListResult;", "getVerificationOptionsList", "", "type", "Lcom/avito/android/remote/model/VerificationStatusResult;", "getVerificationStatus", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/SimpleMessageResult;", "removeVerificationStatus", "verification_release"}, k = 1, mv = {1, 4, 2})
public interface VerificationApi {
    @POST("1/getSDKToken")
    @NotNull
    Single<TypedResult<SumSubSdkTokenResult>> getSumsubSdkToken();

    @POST("1/profile/verifyIdentity/optionsList")
    @NotNull
    Single<TypedResult<VerificationOptionsListResult>> getVerificationOptionsList();

    @POST("1/profile/verifyIdentity/status")
    @NotNull
    Single<TypedResult<VerificationStatusResult>> getVerificationStatus(@NotNull @Query("type") String str);

    @POST("1/profile/verifyIdentity/remove")
    @NotNull
    Single<TypedResult<SimpleMessageResult>> removeVerificationStatus(@NotNull @Query("type") String str);
}
