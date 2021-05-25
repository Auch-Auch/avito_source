package com.avito.android.user_adverts.root_screen.adverts_host.header;

import com.avito.android.remote.model.OrdersInfo;
import com.avito.android.user_adverts.ProfileConfig;
import com.avito.android.user_adverts.SoaData;
import com.avito.android.util.LoadingState;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0002H&¢\u0006\u0004\b\b\u0010\u0005J\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H&¢\u0006\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderInteractor;", "", "Lio/reactivex/Observable;", "Lcom/avito/android/user_adverts/SoaData$Value;", "getSoaInfo", "()Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/OrdersInfo;", "getOrdersInfo", "Lio/reactivex/Single;", "Lcom/avito/android/user_adverts/ProfileConfig;", "loadProfileItemsConfig", "()Lio/reactivex/Single;", "", "getSoaOnboarding", "()Ljava/lang/String;", "getSmbStatsOnboarding", "", "setSoaOnboardingShown", "()V", "setSmbOnboardingClosed", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface ProfileHeaderInteractor {
    @NotNull
    Observable<LoadingState<OrdersInfo>> getOrdersInfo();

    @Nullable
    String getSmbStatsOnboarding();

    @NotNull
    Observable<SoaData.Value> getSoaInfo();

    @Nullable
    String getSoaOnboarding();

    @NotNull
    Single<ProfileConfig> loadProfileItemsConfig();

    void setSmbOnboardingClosed();

    void setSoaOnboardingShown();
}
