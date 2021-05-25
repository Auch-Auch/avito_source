package com.avito.android.social.di;

import android.os.Bundle;
import com.avito.android.di.PerActivity;
import com.avito.android.social.SocialActivity;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/social/di/SocialActivityComponent;", "", "Lcom/avito/android/social/SocialActivity;", "socialActivity", "", "inject", "(Lcom/avito/android/social/SocialActivity;)V", "Builder", "social_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {SocialActivityDependencies.class}, modules = {SocialActivityModule.class})
@PerActivity
public interface SocialActivityComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/social/di/SocialActivityComponent$Builder;", "", "Lcom/avito/android/social/di/SocialActivityDependencies;", "dependencies", "(Lcom/avito/android/social/di/SocialActivityDependencies;)Lcom/avito/android/social/di/SocialActivityComponent$Builder;", "Landroid/os/Bundle;", "presenterState", "with", "(Landroid/os/Bundle;)Lcom/avito/android/social/di/SocialActivityComponent$Builder;", "Lcom/avito/android/social/di/SocialActivityComponent;", "build", "()Lcom/avito/android/social/di/SocialActivityComponent;", "social_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        SocialActivityComponent build();

        @NotNull
        Builder dependencies(@NotNull SocialActivityDependencies socialActivityDependencies);

        @BindsInstance
        @NotNull
        Builder with(@Nullable Bundle bundle);
    }

    void inject(@NotNull SocialActivity socialActivity);
}
