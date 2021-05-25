package com.avito.android.user_advert.advert;

import android.os.Bundle;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.model.CloseReasonsResponse;
import com.avito.android.remote.model.SimpleMessageResult;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.adverts.MyAdvertDetails;
import com.avito.android.remote.model.adverts.RestoreAdvertResult;
import com.avito.android.remote.model.profile.ItemActivateResponse;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\bJ+\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00050\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\bJ+\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\f2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0013\u0010\u000fJ#\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0014\u0010\bJ\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\f2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0019\u0010\bJ#\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u001b\u0010\bJ\u0011\u0010\u001d\u001a\u0004\u0018\u00010\u001cH&¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/avito/android/user_advert/advert/MyAdvertDetailsInteractor;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/profile/ItemActivateResponse;", "activateAdvert", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/SuccessResult;", "activateAdvertLegacy", "newPrice", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/SimpleMessageResult;", "setAdvertPrice", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/CloseReasonsResponse;", "getCloseReasons", "reason", "stopAdvert", "deleteAdvert", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails;", "loadAdvert", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/adverts/RestoreAdvertResult;", "restoreAdvert", "", "notifyVasBundlesBannerClosed", "Landroid/os/Bundle;", "saveState", "()Landroid/os/Bundle;", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public interface MyAdvertDetailsInteractor {
    @NotNull
    Observable<LoadingState<ItemActivateResponse>> activateAdvert(@NotNull String str);

    @NotNull
    Observable<LoadingState<SuccessResult>> activateAdvertLegacy(@NotNull String str);

    @NotNull
    Observable<LoadingState<SuccessResult>> deleteAdvert(@NotNull String str);

    @NotNull
    Observable<LoadingState<CloseReasonsResponse>> getCloseReasons(@NotNull String str);

    @NotNull
    Single<MyAdvertDetails> loadAdvert(@NotNull String str);

    @NotNull
    Observable<LoadingState<Unit>> notifyVasBundlesBannerClosed(@NotNull String str);

    @NotNull
    Observable<LoadingState<RestoreAdvertResult>> restoreAdvert(@NotNull String str);

    @Nullable
    Bundle saveState();

    @NotNull
    Single<LoadingState<SimpleMessageResult>> setAdvertPrice(@NotNull String str, @NotNull String str2);

    @NotNull
    Single<LoadingState<SuccessResult>> stopAdvert(@NotNull String str, @NotNull String str2);
}
