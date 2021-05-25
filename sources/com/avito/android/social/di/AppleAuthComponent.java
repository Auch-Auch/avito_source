package com.avito.android.social.di;

import com.avito.android.di.PerFragment;
import com.avito.android.social.apple.AppleAuthFragment;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/social/di/AppleAuthComponent;", "", "Lcom/avito/android/social/apple/AppleAuthFragment;", "fragment", "", "inject", "(Lcom/avito/android/social/apple/AppleAuthFragment;)V", "Builder", "social_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {AppleAuthDependencies.class}, modules = {AppleAuthModule.class})
@PerFragment
public interface AppleAuthComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/social/di/AppleAuthComponent$Builder;", "", "Lcom/avito/android/social/di/AppleAuthDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/social/di/AppleAuthDependencies;)Lcom/avito/android/social/di/AppleAuthComponent$Builder;", "Lcom/avito/android/social/di/AppleAuthComponent;", "build", "()Lcom/avito/android/social/di/AppleAuthComponent;", "social_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        AppleAuthComponent build();

        @NotNull
        Builder dependentOn(@NotNull AppleAuthDependencies appleAuthDependencies);
    }

    void inject(@NotNull AppleAuthFragment appleAuthFragment);
}
