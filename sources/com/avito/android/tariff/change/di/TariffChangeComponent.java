package com.avito.android.tariff.change.di;

import androidx.fragment.app.Fragment;
import com.avito.android.di.PerFragment;
import com.avito.android.tariff.change.TariffChangeFragment;
import com.avito.android.tariff.di.TariffStepDependencies;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/tariff/change/di/TariffChangeComponent;", "", "Lcom/avito/android/tariff/change/TariffChangeFragment;", "fragment", "", "inject", "(Lcom/avito/android/tariff/change/TariffChangeFragment;)V", "Factory", "tariff_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {TariffStepDependencies.class}, modules = {TariffChangeModule.class})
@PerFragment
public interface TariffChangeComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J+\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/tariff/change/di/TariffChangeComponent$Factory;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/tariff/di/TariffStepDependencies;", "dependencies", "Lcom/avito/android/util/Kundle;", "savedState", "Lcom/avito/android/tariff/change/di/TariffChangeComponent;", "create", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/tariff/di/TariffStepDependencies;Lcom/avito/android/util/Kundle;)Lcom/avito/android/tariff/change/di/TariffChangeComponent;", "tariff_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        TariffChangeComponent create(@BindsInstance @NotNull Fragment fragment, @NotNull TariffStepDependencies tariffStepDependencies, @BindsInstance @NotNull Kundle kundle);
    }

    void inject(@NotNull TariffChangeFragment tariffChangeFragment);
}
