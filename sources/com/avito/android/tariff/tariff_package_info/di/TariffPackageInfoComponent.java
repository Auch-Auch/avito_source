package com.avito.android.tariff.tariff_package_info.di;

import androidx.fragment.app.Fragment;
import com.avito.android.di.PerFragment;
import com.avito.android.tariff.di.TariffStepDependencies;
import com.avito.android.tariff.tariff_package_info.TariffPackageInfoFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/tariff/tariff_package_info/di/TariffPackageInfoComponent;", "", "Lcom/avito/android/tariff/tariff_package_info/TariffPackageInfoFragment;", "fragment", "", "inject", "(Lcom/avito/android/tariff/tariff_package_info/TariffPackageInfoFragment;)V", "Factory", "tariff_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {TariffStepDependencies.class}, modules = {TariffPackageInfoModule.class})
@PerFragment
public interface TariffPackageInfoComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J5\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/tariff/tariff_package_info/di/TariffPackageInfoComponent$Factory;", "", "Landroidx/fragment/app/Fragment;", "fragment", "", "contractId", "packageId", "Lcom/avito/android/tariff/di/TariffStepDependencies;", "dependencies", "Lcom/avito/android/tariff/tariff_package_info/di/TariffPackageInfoComponent;", "create", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/tariff/di/TariffStepDependencies;)Lcom/avito/android/tariff/tariff_package_info/di/TariffPackageInfoComponent;", "tariff_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        TariffPackageInfoComponent create(@BindsInstance @NotNull Fragment fragment, @BindsInstance @ContractId @NotNull String str, @BindsInstance @NotNull String str2, @NotNull TariffStepDependencies tariffStepDependencies);
    }

    void inject(@NotNull TariffPackageInfoFragment tariffPackageInfoFragment);
}
