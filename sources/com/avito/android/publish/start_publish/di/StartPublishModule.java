package com.avito.android.publish.start_publish.di;

import com.avito.android.di.PerFragment;
import com.avito.android.publish.start_publish.StartPublishInteractor;
import com.avito.android.publish.start_publish.StartPublishInteractorImpl;
import com.avito.android.publish.start_publish.StartPublishResourceProvider;
import com.avito.android.publish.start_publish.StartPublishResourceProviderImpl;
import com.avito.android.util.preferences.GeoContract;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/publish/start_publish/di/StartPublishModule;", "", "Lcom/avito/android/publish/start_publish/StartPublishResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/publish/start_publish/StartPublishResourceProvider;", "bindResourceProvider", "(Lcom/avito/android/publish/start_publish/StartPublishResourceProviderImpl;)Lcom/avito/android/publish/start_publish/StartPublishResourceProvider;", "Declarations", "publish_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public interface StartPublishModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/publish/start_publish/di/StartPublishModule$Declarations;", "", "Lcom/avito/android/publish/start_publish/StartPublishInteractorImpl;", "interactor", "Lcom/avito/android/publish/start_publish/StartPublishInteractor;", "bindInteractor", "(Lcom/avito/android/publish/start_publish/StartPublishInteractorImpl;)Lcom/avito/android/publish/start_publish/StartPublishInteractor;", "publish_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        StartPublishInteractor bindInteractor(@NotNull StartPublishInteractorImpl startPublishInteractorImpl);
    }

    @PerFragment
    @Binds
    @NotNull
    StartPublishResourceProvider bindResourceProvider(@NotNull StartPublishResourceProviderImpl startPublishResourceProviderImpl);
}
