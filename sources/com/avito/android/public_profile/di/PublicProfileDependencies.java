package com.avito.android.public_profile.di;

import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.public_profile.remote.model.ProfileAdvertsResult;
import com.jakewharton.rxrelay3.PublishRelay;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/public_profile/di/PublicProfileDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/public_profile/remote/model/ProfileAdvertsResult;", "advertsResults", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "", "advertsReload", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public interface PublicProfileDependencies extends CoreComponentDependencies {
    @NotNull
    PublishRelay<Unit> advertsReload();

    @NotNull
    PublishRelay<ProfileAdvertsResult> advertsResults();
}
