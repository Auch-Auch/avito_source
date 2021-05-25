package com.avito.android.remote.di;

import com.avito.android.remote.ExtendedProfileSettingsApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/di/ExtendedProfileSettingsApiModule;", "", "Lcom/avito/android/remote/RetrofitFactory;", "retrofit", "Lcom/avito/android/remote/ExtendedProfileSettingsApi;", "provideExtendedProfileSettingsApi", "(Lcom/avito/android/remote/RetrofitFactory;)Lcom/avito/android/remote/ExtendedProfileSettingsApi;", "<init>", "()V", "extended-profile-settings_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {ExtendedProfileSettingsJsonModule.class})
public final class ExtendedProfileSettingsApiModule {
    @NotNull
    public static final ExtendedProfileSettingsApiModule INSTANCE = new ExtendedProfileSettingsApiModule();

    @Provides
    @Reusable
    @NotNull
    public final ExtendedProfileSettingsApi provideExtendedProfileSettingsApi(@NotNull RetrofitFactory retrofitFactory) {
        Intrinsics.checkNotNullParameter(retrofitFactory, "retrofit");
        return (ExtendedProfileSettingsApi) retrofitFactory.create(ExtendedProfileSettingsApi.class);
    }
}
