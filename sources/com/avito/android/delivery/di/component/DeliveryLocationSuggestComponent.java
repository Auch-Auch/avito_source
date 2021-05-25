package com.avito.android.delivery.di.component;

import android.app.Activity;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.delivery.di.module.DeliveryLocationSuggestModule;
import com.avito.android.delivery.suggest.DeliveryLocationSuggestFragment;
import com.avito.android.di.PerFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/delivery/di/component/DeliveryLocationSuggestComponent;", "", "Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestFragment;", "fragment", "", "inject", "(Lcom/avito/android/delivery/suggest/DeliveryLocationSuggestFragment;)V", "Builder", "delivery_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {DeliveryLocationSuggestDependencies.class}, modules = {DeliveryLocationSuggestModule.class})
@PerFragment
public interface DeliveryLocationSuggestComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/delivery/di/component/DeliveryLocationSuggestComponent$Builder;", "", "Landroid/app/Activity;", "activity", "(Landroid/app/Activity;)Lcom/avito/android/delivery/di/component/DeliveryLocationSuggestComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/delivery/di/component/DeliveryLocationSuggestComponent$Builder;", "Landroidx/fragment/app/Fragment;", "fragment", "viewModelFragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/delivery/di/component/DeliveryLocationSuggestComponent$Builder;", "Lcom/avito/android/avito_map/AvitoMapBounds;", "visibleRegion", "(Lcom/avito/android/avito_map/AvitoMapBounds;)Lcom/avito/android/delivery/di/component/DeliveryLocationSuggestComponent$Builder;", "Lcom/avito/android/delivery/di/component/DeliveryLocationSuggestDependencies;", "dependencies", "deliveryLocationSuggestDependencies", "(Lcom/avito/android/delivery/di/component/DeliveryLocationSuggestDependencies;)Lcom/avito/android/delivery/di/component/DeliveryLocationSuggestComponent$Builder;", "Lcom/avito/android/delivery/di/component/DeliveryLocationSuggestComponent;", "build", "()Lcom/avito/android/delivery/di/component/DeliveryLocationSuggestComponent;", "delivery_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder activity(@NotNull Activity activity);

        @NotNull
        DeliveryLocationSuggestComponent build();

        @NotNull
        Builder deliveryLocationSuggestDependencies(@NotNull DeliveryLocationSuggestDependencies deliveryLocationSuggestDependencies);

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder viewModelFragment(@NotNull Fragment fragment);

        @BindsInstance
        @NotNull
        Builder visibleRegion(@NotNull AvitoMapBounds avitoMapBounds);
    }

    void inject(@NotNull DeliveryLocationSuggestFragment deliveryLocationSuggestFragment);
}
