package com.sumsub.sns.core.data.source.applicant.remote;

import com.sumsub.sns.core.data.model.remote.RemoteIdDoc;
import com.sumsub.sns.core.data.model.remote.response.ListApplicantsResponse;
import com.sumsub.sns.core.data.model.remote.response.RequiredDocsResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006JU\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\n\u001a\u00020\t2\u0014\b\u0001\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000b2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0014\u001a\u00020\u00132\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0012\u001a\u00020\u0011H§@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0017\u001a\u00020\u00162\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0006J)\u0010\u001c\u001a\u00020\u001b2\b\b\u0001\u0010\u0019\u001a\u00020\u00182\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ3\u0010\u001f\u001a\u00020\u001e2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0019\u001a\u00020\t2\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lcom/sumsub/sns/core/data/source/applicant/remote/ApplicantService;", "", "", "applicantId", "Lcom/sumsub/sns/core/data/model/remote/response/RequiredDocsResponse;", "getRequiredDocuments", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lokhttp3/MultipartBody$Part;", "image", "Lokhttp3/RequestBody;", "meta", "", "headers", "idDocSetType", "Lcom/sumsub/sns/core/data/model/remote/RemoteIdDoc;", "uploadImage", "(Ljava/lang/String;Lokhttp3/MultipartBody$Part;Lokhttp3/RequestBody;Ljava/util/Map;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "imageId", "", "deleteImage", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Review;", "setPending", "Lcom/sumsub/sns/core/data/model/remote/Metadata;", "data", "unsetFields", "Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Item;", "setCustomFiends", "(Lcom/sumsub/sns/core/data/model/remote/Metadata;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Info;", "setFields", "(Ljava/lang/String;Lokhttp3/RequestBody;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public interface ApplicantService {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Object uploadImage$default(ApplicantService applicantService, String str, MultipartBody.Part part, RequestBody requestBody, Map map, String str2, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 16) != 0) {
                    str2 = null;
                }
                return applicantService.uploadImage(str, part, requestBody, map, str2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadImage");
        }
    }

    @DELETE("/resources/inspections/{inspectionId}/resources/{imageId}")
    @Nullable
    Object deleteImage(@Path("inspectionId") @NotNull String str, @Path("imageId") int i, @NotNull Continuation<? super Unit> continuation);

    @GET("resources/applicants/{applicantId}/requiredIdDocsStatus")
    @Nullable
    Object getRequiredDocuments(@Path("applicantId") @NotNull String str, @NotNull Continuation<? super RequiredDocsResponse> continuation);

    @PATCH("/resources/applicants")
    @Nullable
    Object setCustomFiends(@Body @NotNull com.sumsub.sns.core.data.model.remote.Metadata metadata, @Nullable @Query("unsetFields") String str, @NotNull Continuation<? super ListApplicantsResponse.Data.Item> continuation);

    @PATCH("/resources/applicants/{applicantId}/info")
    @Nullable
    Object setFields(@Path("applicantId") @NotNull String str, @Body @NotNull RequestBody requestBody, @Nullable @Query("unsetFields") String str2, @NotNull Continuation<? super ListApplicantsResponse.Data.Info> continuation);

    @POST("/resources/applicants/{applicantId}/review/status/pending")
    @Nullable
    Object setPending(@Path("applicantId") @NotNull String str, @NotNull Continuation<? super ListApplicantsResponse.Data.Review> continuation);

    @Nullable
    @POST("/resources/applicants/{applicantId}/info/idDoc")
    @Multipart
    Object uploadImage(@Path("applicantId") @NotNull String str, @NotNull @Part MultipartBody.Part part, @NotNull @Part("metadata") RequestBody requestBody, @HeaderMap @NotNull Map<String, String> map, @Nullable @Query("idDocSetType") String str2, @NotNull Continuation<? super RemoteIdDoc> continuation);
}
