package com.avito.android.safedeal.profile_settings;

import com.avito.android.safedeal.remote.model.ProfileDeliverySettings;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00030\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsInteractor;", "", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/safedeal/remote/model/ProfileDeliverySettings;", "getSettings", "()Lio/reactivex/rxjava3/core/Observable;", "", "serviceId", "", "isEnabled", "", "toggleService", "(Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Observable;", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public interface ProfileDeliverySettingsInteractor {
    @NotNull
    Observable<LoadingState<ProfileDeliverySettings>> getSettings();

    @NotNull
    Observable<LoadingState<Unit>> toggleService(@NotNull String str, boolean z);
}
