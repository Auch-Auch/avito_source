package com.avito.android.advert_core.sellerprofile;

import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/advert_core/sellerprofile/SellerProfileClickSource;", "", "Lio/reactivex/rxjava3/core/Observable;", "", "profileClicks", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/advert_core/sellerprofile/ShowSellersProfileSource;", "getProfileSourceName", "()Lcom/avito/android/advert_core/sellerprofile/ShowSellersProfileSource;", "profileSourceName", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface SellerProfileClickSource {
    @NotNull
    ShowSellersProfileSource getProfileSourceName();

    @NotNull
    Observable<Unit> profileClicks();
}
