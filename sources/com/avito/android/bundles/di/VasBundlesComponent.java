package com.avito.android.bundles.di;

import androidx.fragment.app.Fragment;
import com.avito.android.bundles.ui.VasBundlesFragment;
import com.avito.android.di.PerFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/bundles/di/VasBundlesComponent;", "", "Lcom/avito/android/bundles/ui/VasBundlesFragment;", "fragment", "", "inject", "(Lcom/avito/android/bundles/ui/VasBundlesFragment;)V", "Factory", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {VasBundlesDependencies.class}, modules = {VasBundlesModule.class, VasBundlesListModule.class})
@PerFragment
public interface VasBundlesComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J?\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00022\b\b\u0001\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/bundles/di/VasBundlesComponent$Factory;", "", "", "checkoutContext", "", "closable", "currentFlow", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/bundles/di/VasBundlesDependencies;", "dependencies", "Lcom/avito/android/bundles/di/VasBundlesComponent;", "create", "(Ljava/lang/String;ZLjava/lang/String;Landroidx/fragment/app/Fragment;Lcom/avito/android/bundles/di/VasBundlesDependencies;)Lcom/avito/android/bundles/di/VasBundlesComponent;", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        VasBundlesComponent create(@BindsInstance @CheckoutContext @NotNull String str, @BindsInstance @Closable boolean z, @BindsInstance @CurrentFlow @NotNull String str2, @BindsInstance @NotNull Fragment fragment, @NotNull VasBundlesDependencies vasBundlesDependencies);
    }

    void inject(@NotNull VasBundlesFragment vasBundlesFragment);
}
