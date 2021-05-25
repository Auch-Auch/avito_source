package com.avito.android.publish.premoderation.di;

import com.avito.android.di.PerFragment;
import com.avito.android.publish.di.PublishDependencies;
import com.avito.android.publish.premoderation.AdvertDuplicateFragment;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/publish/premoderation/di/PublishAdvertDuplicateComponent;", "", "Lcom/avito/android/publish/premoderation/AdvertDuplicateFragment;", "fragment", "", "inject", "(Lcom/avito/android/publish/premoderation/AdvertDuplicateFragment;)V", "Builder", "publish_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PublishDependencies.class}, modules = {PublishAdvertDuplicateModule.class})
@PerFragment
public interface PublishAdvertDuplicateComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/publish/premoderation/di/PublishAdvertDuplicateComponent$Builder;", "", "Lcom/avito/android/publish/di/PublishDependencies;", "publishDependencies", "(Lcom/avito/android/publish/di/PublishDependencies;)Lcom/avito/android/publish/premoderation/di/PublishAdvertDuplicateComponent$Builder;", "Lcom/avito/android/publish/premoderation/di/PublishAdvertDuplicateModule;", "publishAdvertDuplicateModule", "(Lcom/avito/android/publish/premoderation/di/PublishAdvertDuplicateModule;)Lcom/avito/android/publish/premoderation/di/PublishAdvertDuplicateComponent$Builder;", "Lcom/avito/android/publish/premoderation/di/PublishAdvertDuplicateComponent;", "build", "()Lcom/avito/android/publish/premoderation/di/PublishAdvertDuplicateComponent;", "publish_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        PublishAdvertDuplicateComponent build();

        @NotNull
        Builder publishAdvertDuplicateModule(@NotNull PublishAdvertDuplicateModule publishAdvertDuplicateModule);

        @NotNull
        Builder publishDependencies(@NotNull PublishDependencies publishDependencies);
    }

    void inject(@NotNull AdvertDuplicateFragment advertDuplicateFragment);
}
