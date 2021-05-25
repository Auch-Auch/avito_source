package com.avito.android.public_profile.di;

import com.avito.android.di.PerActivity;
import com.avito.android.public_profile.PublicProfileActivity;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/public_profile/di/PublicProfileActivityComponent;", "", "Lcom/avito/android/public_profile/PublicProfileActivity;", "activity", "", "inject", "(Lcom/avito/android/public_profile/PublicProfileActivity;)V", "Builder", "public-profile_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PublicProfileActivityDependencies.class})
@PerActivity
public interface PublicProfileActivityComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/public_profile/di/PublicProfileActivityComponent$Builder;", "", "Lcom/avito/android/public_profile/di/PublicProfileActivityDependencies;", "publicProfileActivityDependencies", "(Lcom/avito/android/public_profile/di/PublicProfileActivityDependencies;)Lcom/avito/android/public_profile/di/PublicProfileActivityComponent$Builder;", "Lcom/avito/android/public_profile/di/PublicProfileActivityComponent;", "build", "()Lcom/avito/android/public_profile/di/PublicProfileActivityComponent;", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        PublicProfileActivityComponent build();

        @NotNull
        Builder publicProfileActivityDependencies(@NotNull PublicProfileActivityDependencies publicProfileActivityDependencies);
    }

    void inject(@NotNull PublicProfileActivity publicProfileActivity);
}
