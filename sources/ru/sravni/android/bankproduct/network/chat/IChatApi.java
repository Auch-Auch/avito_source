package ru.sravni.android.bankproduct.network.chat;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.network.chat.request.NextConversationRequest;
import ru.sravni.android.bankproduct.network.chat.request.RestoreChatRequest;
import ru.sravni.android.bankproduct.network.chat.request.RollbackRequest;
import ru.sravni.android.bankproduct.network.chat.request.StartConversationRequest;
import ru.sravni.android.bankproduct.network.chat.response.ConversationItemResponse;
import ru.sravni.android.bankproduct.network.chat.response.SuggestResponse;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0006\u0010\nJ\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u000b\u001a\u00020\bH'¢\u0006\u0004\b\f\u0010\rJ)\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\bH'¢\u0006\u0004\b\f\u0010\u000eJ\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u000b\u001a\u00020\bH'¢\u0006\u0004\b\u000f\u0010\rJ)\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\bH'¢\u0006\u0004\b\u000f\u0010\u000eJ)\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u000b\u001a\u00020\b2\b\b\u0001\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0012\u0010\u0013J3\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\b2\b\b\u0001\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0012\u0010\u0014JG\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00042\b\b\u0001\u0010\u000b\u001a\u00020\b2\b\b\u0001\u0010\u0016\u001a\u00020\u00152\b\b\u0001\u0010\u0017\u001a\u00020\b2\b\b\u0001\u0010\u0018\u001a\u00020\b2\b\b\u0003\u0010\u0019\u001a\u00020\u0015H'¢\u0006\u0004\b\u001b\u0010\u001cJQ\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00042\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\b2\b\b\u0001\u0010\u0016\u001a\u00020\u00152\b\b\u0001\u0010\u0017\u001a\u00020\b2\b\b\u0001\u0010\u0018\u001a\u00020\b2\b\b\u0003\u0010\u0019\u001a\u00020\u0015H'¢\u0006\u0004\b\u001b\u0010\u001dJ3\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\b2\b\b\u0001\u0010\u001f\u001a\u00020\u001eH'¢\u0006\u0004\b \u0010!J)\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u000b\u001a\u00020\b2\b\b\u0001\u0010\u001f\u001a\u00020\u001eH'¢\u0006\u0004\b \u0010\"J3\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010#\u001a\u00020\b2\b\b\u0001\u0010%\u001a\u00020$H'¢\u0006\u0004\b&\u0010'¨\u0006("}, d2 = {"Lru/sravni/android/bankproduct/network/chat/IChatApi;", "", "Lru/sravni/android/bankproduct/network/chat/request/StartConversationRequest;", "startConversationRequest", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/network/chat/response/ConversationItemResponse;", "startChat", "(Lru/sravni/android/bankproduct/network/chat/request/StartConversationRequest;)Lio/reactivex/Observable;", "", SDKConstants.PARAM_ACCESS_TOKEN, "(Ljava/lang/String;Lru/sravni/android/bankproduct/network/chat/request/StartConversationRequest;)Lio/reactivex/Observable;", AnalyticFieldsName.conversationID, "continueChat", "(Ljava/lang/String;)Lio/reactivex/Observable;", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "restartChat", "Lru/sravni/android/bankproduct/network/chat/request/NextConversationRequest;", "nextConversationRequest", "sendAnswer", "(Ljava/lang/String;Lru/sravni/android/bankproduct/network/chat/request/NextConversationRequest;)Lio/reactivex/Observable;", "(Ljava/lang/String;Ljava/lang/String;Lru/sravni/android/bankproduct/network/chat/request/NextConversationRequest;)Lio/reactivex/Observable;", "", "cardId", "elementName", "userText", "count", "Lru/sravni/android/bankproduct/network/chat/response/SuggestResponse;", "getSuggestion", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)Lio/reactivex/Observable;", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/network/chat/request/RollbackRequest;", "rollbackRequest", "rollbackChat", "(Ljava/lang/String;Ljava/lang/String;Lru/sravni/android/bankproduct/network/chat/request/RollbackRequest;)Lio/reactivex/Observable;", "(Ljava/lang/String;Lru/sravni/android/bankproduct/network/chat/request/RollbackRequest;)Lio/reactivex/Observable;", "conversationID", "Lru/sravni/android/bankproduct/network/chat/request/RestoreChatRequest;", "restoreRequest", "restoreChat", "(Ljava/lang/String;Ljava/lang/String;Lru/sravni/android/bankproduct/network/chat/request/RestoreChatRequest;)Lio/reactivex/Observable;", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IChatApi {
    @GET("v1/conversation/{conversationId}")
    @NotNull
    Observable<ConversationItemResponse> continueChat(@Path("conversationId") @NotNull String str);

    @GET("v1/conversation/{conversationId}")
    @NotNull
    Observable<ConversationItemResponse> continueChat(@Header("bearer") @NotNull String str, @Path("conversationId") @NotNull String str2);

    @GET("v1/conversation/{conversationId}/suggest/{cardOrderId}/{elementName}")
    @NotNull
    Observable<SuggestResponse> getSuggestion(@Path("conversationId") @NotNull String str, @Path("cardOrderId") int i, @Path("elementName") @NotNull String str2, @NotNull @Query("text") String str3, @Query("count") int i2);

    @GET("v1/conversation/{conversationId}/suggest/{cardOrderId}/{elementName}")
    @NotNull
    Observable<SuggestResponse> getSuggestion(@Header("bearer") @NotNull String str, @Path("conversationId") @NotNull String str2, @Path("cardOrderId") int i, @Path("elementName") @NotNull String str3, @NotNull @Query("text") String str4, @Query("count") int i2);

    @POST("v1/conversation/{conversationId}/restart")
    @NotNull
    Observable<ConversationItemResponse> restartChat(@Path("conversationId") @NotNull String str);

    @POST("v1/conversation/{conversationId}/restart")
    @NotNull
    Observable<ConversationItemResponse> restartChat(@Header("bearer") @NotNull String str, @Path("conversationId") @NotNull String str2);

    @PATCH("v1/conversation/{conversationId}/restore")
    @NotNull
    Observable<ConversationItemResponse> restoreChat(@Header("bearer") @NotNull String str, @Path("conversationId") @NotNull String str2, @Body @NotNull RestoreChatRequest restoreChatRequest);

    @POST("v1/conversation/{conversationId}/rollback")
    @NotNull
    Observable<ConversationItemResponse> rollbackChat(@Header("bearer") @NotNull String str, @Path("conversationId") @NotNull String str2, @Body @NotNull RollbackRequest rollbackRequest);

    @POST("v1/conversation/{conversationId}/rollback")
    @NotNull
    Observable<ConversationItemResponse> rollbackChat(@Path("conversationId") @NotNull String str, @Body @NotNull RollbackRequest rollbackRequest);

    @POST("v1/conversation/{conversationId}/next")
    @NotNull
    Observable<ConversationItemResponse> sendAnswer(@Header("bearer") @NotNull String str, @Path("conversationId") @NotNull String str2, @Body @NotNull NextConversationRequest nextConversationRequest);

    @POST("v1/conversation/{conversationId}/next")
    @NotNull
    Observable<ConversationItemResponse> sendAnswer(@Path("conversationId") @NotNull String str, @Body @NotNull NextConversationRequest nextConversationRequest);

    @POST("v1/conversation/start")
    @NotNull
    Observable<ConversationItemResponse> startChat(@Header("bearer") @NotNull String str, @Body @NotNull StartConversationRequest startConversationRequest);

    @POST("v1/conversation/start")
    @NotNull
    Observable<ConversationItemResponse> startChat(@Body @NotNull StartConversationRequest startConversationRequest);

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable getSuggestion$default(IChatApi iChatApi, String str, int i, String str2, String str3, int i2, int i3, Object obj) {
            if (obj == null) {
                return iChatApi.getSuggestion(str, i, str2, str3, (i3 & 16) != 0 ? 5 : i2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSuggestion");
        }

        public static /* synthetic */ Observable getSuggestion$default(IChatApi iChatApi, String str, String str2, int i, String str3, String str4, int i2, int i3, Object obj) {
            if (obj == null) {
                return iChatApi.getSuggestion(str, str2, i, str3, str4, (i3 & 32) != 0 ? 5 : i2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSuggestion");
        }
    }
}
