package com.avito.android.publish.input_vin.di;

import android.content.res.Resources;
import com.avito.android.di.PerFragment;
import com.avito.android.publish.di.PublishComponent;
import com.avito.android.publish.input_vin.InputVinFragment;
import com.avito.android.validation.ParametersListModule;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/publish/input_vin/di/InputVinComponent;", "", "Lcom/avito/android/publish/input_vin/InputVinFragment;", "fragment", "", "inject", "(Lcom/avito/android/publish/input_vin/InputVinFragment;)V", "Builder", "publish_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PublishComponent.class}, modules = {InputVinModule.class})
@PerFragment
public interface InputVinComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/publish/input_vin/di/InputVinComponent$Builder;", "", "Lcom/avito/android/publish/di/PublishComponent;", "component", "publishComponent", "(Lcom/avito/android/publish/di/PublishComponent;)Lcom/avito/android/publish/input_vin/di/InputVinComponent$Builder;", "Landroid/content/res/Resources;", "resources", "bindResources", "(Landroid/content/res/Resources;)Lcom/avito/android/publish/input_vin/di/InputVinComponent$Builder;", "Lcom/avito/android/validation/ParametersListModule;", "parametersListModule", "(Lcom/avito/android/validation/ParametersListModule;)Lcom/avito/android/publish/input_vin/di/InputVinComponent$Builder;", "Lcom/avito/android/publish/input_vin/di/InputVinComponent;", "build", "()Lcom/avito/android/publish/input_vin/di/InputVinComponent;", "publish_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder bindResources(@NotNull Resources resources);

        @NotNull
        InputVinComponent build();

        @NotNull
        Builder parametersListModule(@NotNull ParametersListModule parametersListModule);

        @NotNull
        Builder publishComponent(@NotNull PublishComponent publishComponent);
    }

    void inject(@NotNull InputVinFragment inputVinFragment);
}
