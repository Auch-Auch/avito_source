package com.avito.android.remote;

import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.links.DetailsSheetLinkBody;
import com.avito.android.remote.model.CharityDialogResponse;
import com.avito.android.remote.model.TypedResult;
import dagger.Module;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.Query;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u00042\b\b\u0001\u0010\t\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\u0002H'¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/UserAdvertsCommonApi;", "", "", "categoryId", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;", "getAfterPublishWarning", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", BookingInfoActivity.EXTRA_ITEM_ID, "source", "Lcom/avito/android/remote/model/CharityDialogResponse;", "getCharityDialog", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "user-adverts-common_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface UserAdvertsCommonApi {
    @GET("1/profile/item/safety")
    @NotNull
    Single<TypedResult<DetailsSheetLinkBody>> getAfterPublishWarning(@NotNull @Query("categoryId") String str);

    @GET("1/charity/show_form")
    @NotNull
    Single<TypedResult<CharityDialogResponse>> getCharityDialog(@NotNull @Query("advertId") String str, @NotNull @Query("source") String str2);
}
