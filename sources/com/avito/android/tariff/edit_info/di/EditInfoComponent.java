package com.avito.android.tariff.edit_info.di;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.di.PerFragment;
import com.avito.android.tariff.di.TariffStepDependencies;
import com.avito.android.tariff.edit_info.EditInfoFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/tariff/edit_info/di/EditInfoComponent;", "", "Lcom/avito/android/tariff/edit_info/EditInfoFragment;", "fragment", "", "inject", "(Lcom/avito/android/tariff/edit_info/EditInfoFragment;)V", "Factory", "tariff_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {TariffStepDependencies.class}, modules = {EditInfoModule.class})
@PerFragment
public interface EditInfoComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J5\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/tariff/edit_info/di/EditInfoComponent$Factory;", "", "Landroidx/fragment/app/Fragment;", "fragment", "", "checkoutContext", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/tariff/di/TariffStepDependencies;", "dependencies", "Lcom/avito/android/tariff/edit_info/di/EditInfoComponent;", "create", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Landroid/content/res/Resources;Lcom/avito/android/tariff/di/TariffStepDependencies;)Lcom/avito/android/tariff/edit_info/di/EditInfoComponent;", "tariff_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        EditInfoComponent create(@BindsInstance @NotNull Fragment fragment, @BindsInstance @NotNull String str, @BindsInstance @NotNull Resources resources, @NotNull TariffStepDependencies tariffStepDependencies);
    }

    void inject(@NotNull EditInfoFragment editInfoFragment);
}
