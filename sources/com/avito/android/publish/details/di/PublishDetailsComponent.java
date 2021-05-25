package com.avito.android.publish.details.di;

import android.content.res.Resources;
import com.avito.android.di.PerFragment;
import com.avito.android.publish.details.PublishDetailsFragment;
import com.avito.android.publish.di.PublishComponent;
import com.avito.android.publish.di.PublishInputAnalyticsModule;
import com.avito.android.publish.objects.di.ImageUploadModule;
import com.avito.android.validation.ParametersListModule;
import dagger.BindsInstance;
import dagger.Component;
import javax.inject.Named;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/publish/details/di/PublishDetailsComponent;", "", "Lcom/avito/android/publish/details/PublishDetailsFragment;", "fragment", "", "inject", "(Lcom/avito/android/publish/details/PublishDetailsFragment;)V", "Builder", "publish_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PublishComponent.class}, modules = {PublishDetailsModule.class, ImageUploadModule.class, PublishDetailsViewModule.class, PublishInputAnalyticsModule.class})
@PerFragment
public interface PublishDetailsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00002\b\b\u0001\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/avito/android/publish/details/di/PublishDetailsComponent$Builder;", "", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/publish/details/di/PublishDetailsComponent$Builder;", "", "minValuesForSearch", "withMinValuesForSearch", "(I)Lcom/avito/android/publish/details/di/PublishDetailsComponent$Builder;", "Lcom/avito/android/publish/di/PublishComponent;", "component", "publishComponent", "(Lcom/avito/android/publish/di/PublishComponent;)Lcom/avito/android/publish/details/di/PublishDetailsComponent$Builder;", "Lcom/avito/android/publish/details/di/PublishDetailsModule;", "publishDetailsModule", "(Lcom/avito/android/publish/details/di/PublishDetailsModule;)Lcom/avito/android/publish/details/di/PublishDetailsComponent$Builder;", "Lcom/avito/android/publish/objects/di/ImageUploadModule;", "imageUploadModule", "(Lcom/avito/android/publish/objects/di/ImageUploadModule;)Lcom/avito/android/publish/details/di/PublishDetailsComponent$Builder;", "Lcom/avito/android/validation/ParametersListModule;", "parametersListModule", "(Lcom/avito/android/validation/ParametersListModule;)Lcom/avito/android/publish/details/di/PublishDetailsComponent$Builder;", "Lcom/avito/android/publish/details/di/PublishDetailsAnalyticsModule;", "publishDetailsAnalyticsModule", "(Lcom/avito/android/publish/details/di/PublishDetailsAnalyticsModule;)Lcom/avito/android/publish/details/di/PublishDetailsComponent$Builder;", "Lcom/avito/android/publish/details/di/PublishDetailsComponent;", "build", "()Lcom/avito/android/publish/details/di/PublishDetailsComponent;", "publish_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        PublishDetailsComponent build();

        @NotNull
        Builder imageUploadModule(@NotNull ImageUploadModule imageUploadModule);

        @NotNull
        Builder parametersListModule(@NotNull ParametersListModule parametersListModule);

        @NotNull
        Builder publishComponent(@NotNull PublishComponent publishComponent);

        @NotNull
        Builder publishDetailsAnalyticsModule(@NotNull PublishDetailsAnalyticsModule publishDetailsAnalyticsModule);

        @NotNull
        Builder publishDetailsModule(@NotNull PublishDetailsModule publishDetailsModule);

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder withMinValuesForSearch(@Named("min_values_for_search") int i);
    }

    void inject(@NotNull PublishDetailsFragment publishDetailsFragment);
}
