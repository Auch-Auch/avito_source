package com.avito.android.advert.item.sellerprofile;

import com.avito.android.remote.model.AdvertSeller;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/advert/item/sellerprofile/SellerStatusProvider;", "", "", "sellerHashId", "", "initialStatus", "Lio/reactivex/rxjava3/core/Observable;", "observeSellerOnlineStatus", "(Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/AdvertSeller;", "seller", "getSellerStatusMessage", "(Lcom/avito/android/remote/model/AdvertSeller;)Ljava/lang/String;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface SellerStatusProvider {
    @Nullable
    String getSellerStatusMessage(@Nullable AdvertSeller advertSeller);

    @NotNull
    Observable<Boolean> observeSellerOnlineStatus(@NotNull String str, boolean z);
}
