package com.avito.android.tariff.info.di;

import androidx.fragment.app.Fragment;
import com.avito.android.di.PerFragment;
import com.avito.android.tariff.di.TariffStepDependencies;
import com.avito.android.tariff.info.TariffInfoFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/tariff/info/di/TariffInfoComponent;", "", "Lcom/avito/android/tariff/info/TariffInfoFragment;", "fragment", "", "inject", "(Lcom/avito/android/tariff/info/TariffInfoFragment;)V", "Builder", "tariff_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {TariffStepDependencies.class}, modules = {TariffInfoModule.class})
@PerFragment
public interface TariffInfoComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/tariff/info/di/TariffInfoComponent$Builder;", "", "Lcom/avito/android/tariff/di/TariffStepDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/tariff/di/TariffStepDependencies;)Lcom/avito/android/tariff/info/di/TariffInfoComponent$Builder;", "Landroidx/fragment/app/Fragment;", "fragment", "with", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/tariff/info/di/TariffInfoComponent$Builder;", "", "checkoutContext", "(Ljava/lang/String;)Lcom/avito/android/tariff/info/di/TariffInfoComponent$Builder;", "Lcom/avito/android/tariff/info/di/TariffInfoComponent;", "build", "()Lcom/avito/android/tariff/info/di/TariffInfoComponent;", "tariff_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        TariffInfoComponent build();

        @NotNull
        Builder dependentOn(@NotNull TariffStepDependencies tariffStepDependencies);

        @BindsInstance
        @NotNull
        Builder with(@NotNull Fragment fragment);

        @BindsInstance
        @NotNull
        Builder with(@NotNull String str);
    }

    void inject(@NotNull TariffInfoFragment tariffInfoFragment);
}
