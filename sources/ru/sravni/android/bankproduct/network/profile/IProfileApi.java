package ru.sravni.android.bankproduct.network.profile;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.reactivex.Observable;
import kotlin.Metadata;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import ru.sravni.android.bankproduct.network.profile.request.UpdateAccountElementRequest;
import ru.sravni.android.bankproduct.network.profile.response.AccountResponse;
import ru.sravni.android.bankproduct.network.profile.response.v2.AccountV2Response;
import ru.sravni.android.bankproduct.network.profile.response.v2.ProfileDetailedInfoResponse;
import ru.sravni.android.bankproduct.network.profile.response.v2.ProfileDocumentInfoResponse;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\bH'¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u000e\u0010\u0007J\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0010\u0010\u0007J)\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00042\b\b\u0001\u0010\u0011\u001a\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lru/sravni/android/bankproduct/network/profile/IProfileApi;", "", "", SDKConstants.PARAM_ACCESS_TOKEN, "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/network/profile/response/AccountResponse;", "getAccountInfo", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/network/profile/request/UpdateAccountElementRequest;", "updateAccountElementRequest", "Lokhttp3/ResponseBody;", "updateField", "(Ljava/lang/String;Lru/sravni/android/bankproduct/network/profile/request/UpdateAccountElementRequest;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/network/profile/response/v2/AccountV2Response;", "getAccountBrief", "Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileDetailedInfoResponse;", "getAccountDetailInfo", "documentEndpoint", "Lru/sravni/android/bankproduct/network/profile/response/v2/ProfileDocumentInfoResponse;", "getAccountDocument", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IProfileApi {
    @GET("v2/account/brief")
    @NotNull
    Observable<AccountV2Response> getAccountBrief(@Header("bearer") @NotNull String str);

    @GET("v2/account/detail")
    @NotNull
    Observable<ProfileDetailedInfoResponse> getAccountDetailInfo(@Header("bearer") @NotNull String str);

    @GET("v2/account/{documentEndpoint}")
    @NotNull
    Observable<ProfileDocumentInfoResponse> getAccountDocument(@Path("documentEndpoint") @NotNull String str, @Header("bearer") @NotNull String str2);

    @GET("v1/account")
    @NotNull
    Observable<AccountResponse> getAccountInfo(@Header("bearer") @NotNull String str);

    @PATCH("v1/account/update_field")
    @NotNull
    Observable<ResponseBody> updateField(@Header("bearer") @NotNull String str, @Body @NotNull UpdateAccountElementRequest updateAccountElementRequest);
}
