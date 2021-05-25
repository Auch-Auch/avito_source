package com.avito.android.social.di.esia;

import com.avito.android.di.PerFragment;
import com.avito.android.social.esia.EsiaAuthFragment;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/social/di/esia/EsiaAuthComponent;", "", "Lcom/avito/android/social/esia/EsiaAuthFragment;", "fragment", "", "inject", "(Lcom/avito/android/social/esia/EsiaAuthFragment;)V", "Factory", "social_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {EsiaAuthDependencies.class}, modules = {EsiaAuthModule.class})
@PerFragment
public interface EsiaAuthComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/social/di/esia/EsiaAuthComponent$Factory;", "", "Lcom/avito/android/social/di/esia/EsiaAuthDependencies;", "dependencies", "Lcom/avito/android/social/di/esia/EsiaAuthComponent;", "create", "(Lcom/avito/android/social/di/esia/EsiaAuthDependencies;)Lcom/avito/android/social/di/esia/EsiaAuthComponent;", "social_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        EsiaAuthComponent create(@NotNull EsiaAuthDependencies esiaAuthDependencies);
    }

    void inject(@NotNull EsiaAuthFragment esiaAuthFragment);
}
