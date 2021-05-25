package com.avito.android.public_profile.di;

import com.avito.android.public_profile.remote.model.ProfileAdvertsResult;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0001¢\u0006\u0004\b\b\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/avito/android/public_profile/di/ProfileAdvertsResultsModule;", "", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/public_profile/remote/model/ProfileAdvertsResult;", "provideProfileAdvertsResult$public_profile_release", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "provideProfileAdvertsResult", "", "provideProfileAdvertsReload$public_profile_release", "provideProfileAdvertsReload", "<init>", "()V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class ProfileAdvertsResultsModule {
    @Provides
    @NotNull
    @Singleton
    public final PublishRelay<Unit> provideProfileAdvertsReload$public_profile_release() {
        PublishRelay<Unit> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        return create;
    }

    @Provides
    @NotNull
    @Singleton
    public final PublishRelay<ProfileAdvertsResult> provideProfileAdvertsResult$public_profile_release() {
        PublishRelay<ProfileAdvertsResult> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        return create;
    }
}
