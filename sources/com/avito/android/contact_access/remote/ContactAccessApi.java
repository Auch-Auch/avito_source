package com.avito.android.contact_access.remote;

import com.avito.android.remote.NetworkRequestEventId;
import com.avito.android.remote.model.ContactAccessService;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.parse.adapter.ContactAccessPackage;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\b\b\u0001\u0010\b\u001a\u00020\u0002H'¢\u0006\u0004\b\n\u0010\u0007JA\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u000e\u001a\u00020\rH'¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/contact_access/remote/ContactAccessApi;", "", "", "itemId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/parse/adapter/ContactAccessPackage;", "getContactAccessPackage", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "url", "Lcom/avito/android/remote/model/SuccessResult;", "applyPackage", "serviceId", "externalId", "", "extraLine", "Lcom/avito/android/remote/model/ContactAccessService;", "getContactAccessService", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Observable;", "contact-access_release"}, k = 1, mv = {1, 4, 2})
public interface ContactAccessApi {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable getContactAccessService$default(ContactAccessApi contactAccessApi, String str, String str2, String str3, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    z = true;
                }
                return contactAccessApi.getContactAccessService(str, str2, str3, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContactAccessService");
        }
    }

    @POST
    @NotNull
    Observable<SuccessResult> applyPackage(@Url @NotNull String str);

    @GET("2/items/{itemId}/contacts/packages")
    @NotNull
    @NetworkRequestEventId(eventId = 3668)
    Observable<ContactAccessPackage> getContactAccessPackage(@Path("itemId") @NotNull String str);

    @GET("2/items/{itemId}/contacts/services")
    @NotNull
    @NetworkRequestEventId(eventId = 3669)
    Observable<ContactAccessService> getContactAccessService(@Path("itemId") @NotNull String str, @Nullable @Query("serviceId") String str2, @Nullable @Query("externalId") String str3, @Query("textExtraEol") boolean z);
}
