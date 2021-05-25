package com.avito.android.photo_wizard.remote;

import com.avito.android.booking.info.BookingInfoActivity;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import retrofit2.Response;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J5\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/photo_wizard/remote/PhotoWizardApi;", "", "Lokhttp3/RequestBody;", BookingInfoActivity.EXTRA_ITEM_ID, "", "Lokhttp3/MultipartBody$Part;", "photos", "Lio/reactivex/rxjava3/core/Observable;", "Lretrofit2/Response;", "", "uploadPhotos", "(Lokhttp3/RequestBody;Ljava/util/List;)Lio/reactivex/rxjava3/core/Observable;", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
public interface PhotoWizardApi {
    @NotNull
    @POST("1/car/owner/upload/images")
    @Multipart
    Observable<Response<Boolean>> uploadPhotos(@NotNull @Part("item_id") RequestBody requestBody, @NotNull @Part List<MultipartBody.Part> list);
}
