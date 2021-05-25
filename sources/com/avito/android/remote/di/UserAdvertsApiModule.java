package com.avito.android.remote.di;

import com.avito.android.remote.RetrofitFactory;
import com.avito.android.user_adverts.remote.UserAdvertsApi;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/di/UserAdvertsApiModule;", "", "Lcom/avito/android/remote/RetrofitFactory;", "retrofit", "Lcom/avito/android/user_adverts/remote/UserAdvertsApi;", "provideUserAdvertsApi", "(Lcom/avito/android/remote/RetrofitFactory;)Lcom/avito/android/user_adverts/remote/UserAdvertsApi;", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {UserAdvertsJsonModule.class})
public final class UserAdvertsApiModule {
    @NotNull
    public static final UserAdvertsApiModule INSTANCE = new UserAdvertsApiModule();

    @Provides
    @Reusable
    @NotNull
    public final UserAdvertsApi provideUserAdvertsApi(@NotNull RetrofitFactory retrofitFactory) {
        Intrinsics.checkNotNullParameter(retrofitFactory, "retrofit");
        return (UserAdvertsApi) retrofitFactory.create(UserAdvertsApi.class);
    }
}
