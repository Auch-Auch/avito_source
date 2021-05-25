package com.avito.android.advert_details.remote;

import com.avito.android.remote.RetrofitFactory;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/advert_details/remote/AdvertDetailsApiModule;", "", "Lcom/avito/android/remote/RetrofitFactory;", "retrofit", "Lcom/avito/android/advert_details/remote/AdvertDetailsApi;", "provideAdvertDetailsApi", "(Lcom/avito/android/remote/RetrofitFactory;)Lcom/avito/android/advert_details/remote/AdvertDetailsApi;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdvertDetailsJsonModule.class})
public final class AdvertDetailsApiModule {
    @NotNull
    public static final AdvertDetailsApiModule INSTANCE = new AdvertDetailsApiModule();

    @Provides
    @Reusable
    @NotNull
    public final AdvertDetailsApi provideAdvertDetailsApi(@NotNull RetrofitFactory retrofitFactory) {
        Intrinsics.checkNotNullParameter(retrofitFactory, "retrofit");
        return (AdvertDetailsApi) retrofitFactory.create(AdvertDetailsApi.class);
    }
}
