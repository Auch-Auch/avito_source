package com.avito.android.shop_settings_select.di;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.di.PerFragment;
import com.avito.android.shop_settings_select.ShopSettingsSelectFragment;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/shop_settings_select/di/ShopSettingsSelectFragmentComponent;", "", "Lcom/avito/android/shop_settings_select/ShopSettingsSelectFragment;", "fragment", "", "inject", "(Lcom/avito/android/shop_settings_select/ShopSettingsSelectFragment;)V", "Factory", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {ShopSettingsSelectFragmentDependencies.class}, modules = {ShopSettingsSelectFragmentModule.class})
@PerFragment
public interface ShopSettingsSelectFragmentComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J[\u0010\u0010\u001a\u00020\u000f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\b2\u000e\b\u0001\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n2\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/shop_settings_select/di/ShopSettingsSelectFragmentComponent$Factory;", "", "Landroid/content/res/Resources;", "resources", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/util/Kundle;", "savedState", "", "selectContext", "", "checkedIds", "selectedId", "Lcom/avito/android/shop_settings_select/di/ShopSettingsSelectFragmentDependencies;", "dependencies", "Lcom/avito/android/shop_settings_select/di/ShopSettingsSelectFragmentComponent;", "create", "(Landroid/content/res/Resources;Landroidx/fragment/app/Fragment;Lcom/avito/android/util/Kundle;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/avito/android/shop_settings_select/di/ShopSettingsSelectFragmentDependencies;)Lcom/avito/android/shop_settings_select/di/ShopSettingsSelectFragmentComponent;", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        ShopSettingsSelectFragmentComponent create(@BindsInstance @NotNull Resources resources, @BindsInstance @NotNull Fragment fragment, @BindsInstance @NotNull Kundle kundle, @BindsInstance @SelectContext @NotNull String str, @BindsInstance @CheckedIds @NotNull List<String> list, @BindsInstance @SelectedId @Nullable String str2, @NotNull ShopSettingsSelectFragmentDependencies shopSettingsSelectFragmentDependencies);
    }

    void inject(@NotNull ShopSettingsSelectFragment shopSettingsSelectFragment);
}
