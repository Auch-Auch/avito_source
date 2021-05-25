package com.sumsub.sns.core.data.source.common;

import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.sumsub.sns.core.data.model.remote.ApplicantLanguage;
import com.sumsub.sns.core.data.model.remote.RemoteAction;
import com.sumsub.sns.core.data.model.remote.RemoteConfig;
import com.sumsub.sns.core.data.model.remote.response.AccessTokenResponse;
import com.sumsub.sns.core.data.model.remote.response.ListApplicantsResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0007\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0006J\u001d\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000b\u001a\u00020\nH§@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\u0013\u001a\u00020\u00122\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u00022\b\b\u0003\u0010\u0011\u001a\u00020\u0010H§@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0018\u001a\u00020\u00172\b\b\u0001\u0010\u0015\u001a\u00020\u00022\b\b\u0001\u0010\u0016\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u001aH§@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ)\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u001a2\b\b\u0001\u0010\u0016\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0006J3\u0010 \u001a\u00020\u001f2\b\b\u0001\u0010\u0016\u001a\u00020\u00022\u0014\b\u0001\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001aH§@ø\u0001\u0000¢\u0006\u0004\b \u0010!\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lcom/sumsub/sns/core/data/source/common/CommonService;", "", "", "applicantId", "Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse$Data$Item;", "getApplicantById", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "actionId", "Lcom/sumsub/sns/core/data/model/remote/RemoteAction;", "getActionById", "Lcom/sumsub/sns/core/data/model/remote/ApplicantLanguage;", "applicant", "Lcom/sumsub/sns/core/data/model/remote/response/ListApplicantsResponse;", "setApplicantLanguage", "(Lcom/sumsub/sns/core/data/model/remote/ApplicantLanguage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ChannelContext.Item.USER_ID, "", "ttlInSecs", "Lcom/sumsub/sns/core/data/model/remote/response/AccessTokenResponse;", "getAccessToken", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flowName", "language", "Lcom/sumsub/sns/core/data/model/remote/RemoteConfig;", "getConfig", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "getClientIntegrationSettings", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStringResources", "translations", "", "setStringResources", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public interface CommonService {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Object getAccessToken$default(CommonService commonService, String str, String str2, int i, Continuation continuation, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    i = 1200;
                }
                return commonService.getAccessToken(str, str2, i, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAccessToken");
        }
    }

    @POST("resources/accessTokens")
    @Nullable
    Object getAccessToken(@NotNull @Query("applicantId") String str, @NotNull @Query("userId") String str2, @Query("ttlInSecs") int i, @NotNull Continuation<? super AccessTokenResponse> continuation);

    @GET("resources/applicantActions/{actionId}/one")
    @Nullable
    Object getActionById(@Path("actionId") @NotNull String str, @NotNull Continuation<? super RemoteAction> continuation);

    @GET("resources/applicants/{applicantId}/one")
    @Nullable
    Object getApplicantById(@Path("applicantId") @NotNull String str, @NotNull Continuation<? super ListApplicantsResponse.Data.Item> continuation);

    @GET("resources/sdkIntegrations/-/clientIntegrationSettings")
    @Nullable
    Object getClientIntegrationSettings(@NotNull Continuation<? super Map<String, ? extends Object>> continuation);

    @POST("resources/sdkIntegrations/flows/{flowName}/msdkInit")
    @Nullable
    Object getConfig(@Path("flowName") @NotNull String str, @NotNull @Query("lang") String str2, @NotNull Continuation<? super RemoteConfig> continuation);

    @GET("/resources/msdk/i18n")
    @Nullable
    Object getStringResources(@NotNull @Query("lang") String str, @NotNull Continuation<? super Map<String, ? extends Object>> continuation);

    @PATCH("resources/applicants")
    @Nullable
    Object setApplicantLanguage(@Body @NotNull ApplicantLanguage applicantLanguage, @NotNull Continuation<? super ListApplicantsResponse> continuation);

    @POST("/resources/msdk/i18n")
    @Nullable
    Object setStringResources(@NotNull @Query("lang") String str, @Body @NotNull Map<String, String> map, @NotNull Continuation<? super Unit> continuation);
}
