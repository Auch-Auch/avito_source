package ru.sravni.android.bankproduct.network.dashboard;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.Header;
import ru.sravni.android.bankproduct.network.dashboard.response.ChatProgressResponse;
import ru.sravni.android.bankproduct.network.dashboard.response.OfferCalculationListResponse;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lru/sravni/android/bankproduct/network/dashboard/IDashBoardApi;", "", "", SDKConstants.PARAM_ACCESS_TOKEN, "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/network/dashboard/response/OfferCalculationListResponse;", "getOfferCalculatedList", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/network/dashboard/response/ChatProgressResponse;", "getChatProgress", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IDashBoardApi {
    @GET("v1/conversation/drafts")
    @NotNull
    Observable<ChatProgressResponse> getChatProgress(@Header("bearer") @NotNull String str);

    @GET("v3/saved_search")
    @NotNull
    Observable<OfferCalculationListResponse> getOfferCalculatedList(@Header("bearer") @NotNull String str);
}
