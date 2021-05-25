package com.avito.android.advert.item.domoteka;

import com.avito.android.remote.ApartmentNumberRequestResponse;
import com.avito.android.remote.DomotekaTeaserResponse;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/advert/item/domoteka/DomotekaTeaserInteractor;", "", "", "itemId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/DomotekaTeaserResponse;", "getDomotekaTeaser", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/ApartmentNumberRequestResponse;", "getApartmentNumberRequestLink", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface DomotekaTeaserInteractor {
    @NotNull
    Observable<ApartmentNumberRequestResponse> getApartmentNumberRequestLink(@NotNull String str);

    @NotNull
    Observable<LoadingState<DomotekaTeaserResponse>> getDomotekaTeaser(@NotNull String str);

    @NotNull
    Kundle onSaveState();
}
