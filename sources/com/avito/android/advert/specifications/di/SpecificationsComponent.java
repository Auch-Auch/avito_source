package com.avito.android.advert.specifications.di;

import com.avito.android.advert.specifications.SpecificationsFragment;
import com.avito.android.di.PerFragment;
import com.avito.android.remote.model.ModelSpecifications;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/advert/specifications/di/SpecificationsComponent;", "", "Lcom/avito/android/advert/specifications/SpecificationsFragment;", "fragment", "", "inject", "(Lcom/avito/android/advert/specifications/SpecificationsFragment;)V", "Builder", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {SpecificationsDependencies.class}, modules = {SpecificationsModule.class})
@PerFragment
public interface SpecificationsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/advert/specifications/di/SpecificationsComponent$Builder;", "", "Lcom/avito/android/advert/specifications/di/SpecificationsDependencies;", "dependencies", "specificationsDependencies", "(Lcom/avito/android/advert/specifications/di/SpecificationsDependencies;)Lcom/avito/android/advert/specifications/di/SpecificationsComponent$Builder;", "Lcom/avito/android/remote/model/ModelSpecifications;", "specifications", "(Lcom/avito/android/remote/model/ModelSpecifications;)Lcom/avito/android/advert/specifications/di/SpecificationsComponent$Builder;", "Lcom/avito/android/advert/specifications/di/SpecificationsComponent;", "build", "()Lcom/avito/android/advert/specifications/di/SpecificationsComponent;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        SpecificationsComponent build();

        @BindsInstance
        @NotNull
        Builder specifications(@Nullable ModelSpecifications modelSpecifications);

        @NotNull
        Builder specificationsDependencies(@NotNull SpecificationsDependencies specificationsDependencies);
    }

    void inject(@NotNull SpecificationsFragment specificationsFragment);
}
