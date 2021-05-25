package com.avito.android.user_adverts_common.safety.di;

import com.avito.android.user_adverts_common.safety.SafetyInfoProvider;
import com.avito.android.user_adverts_common.safety.SafetyInfoProviderImpl;
import com.avito.android.user_adverts_common.safety.storage.PrefSafetyInfoSessionStorage;
import com.avito.android.user_adverts_common.safety.storage.SafetyInfoSessionStorage;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/user_adverts_common/safety/di/SafetyInfoModule;", "", "Lcom/avito/android/user_adverts_common/safety/SafetyInfoProviderImpl;", "interactor", "Lcom/avito/android/user_adverts_common/safety/SafetyInfoProvider;", "provideSafetyInfoProvider", "(Lcom/avito/android/user_adverts_common/safety/SafetyInfoProviderImpl;)Lcom/avito/android/user_adverts_common/safety/SafetyInfoProvider;", "Lcom/avito/android/user_adverts_common/safety/storage/PrefSafetyInfoSessionStorage;", "Lcom/avito/android/user_adverts_common/safety/storage/SafetyInfoSessionStorage;", "provideSessionStorage", "(Lcom/avito/android/user_adverts_common/safety/storage/PrefSafetyInfoSessionStorage;)Lcom/avito/android/user_adverts_common/safety/storage/SafetyInfoSessionStorage;", "user-adverts-common_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface SafetyInfoModule {
    @Binds
    @NotNull
    SafetyInfoProvider provideSafetyInfoProvider(@NotNull SafetyInfoProviderImpl safetyInfoProviderImpl);

    @Binds
    @NotNull
    SafetyInfoSessionStorage provideSessionStorage(@NotNull PrefSafetyInfoSessionStorage prefSafetyInfoSessionStorage);
}
