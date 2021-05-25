package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.messenger.service.MessengerInfoProvider;
import com.avito.android.messenger.service.MessengerInfoProviderImpl;
import com.avito.android.util.BuildInfo;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/di/module/MessengerInfoModule;", "", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/messenger/service/MessengerInfoProvider;", "provideMessengerInfoProvider", "(Lcom/avito/android/Features;Lcom/avito/android/util/BuildInfo;)Lcom/avito/android/messenger/service/MessengerInfoProvider;", "<init>", "()V", "api_release"}, k = 1, mv = {1, 4, 2})
@Module
public class MessengerInfoModule {
    @Provides
    @NotNull
    public MessengerInfoProvider provideMessengerInfoProvider(@NotNull Features features, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        return new MessengerInfoProviderImpl(features, buildInfo);
    }
}
