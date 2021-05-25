package com.avito.android.safedeal.delivery_type.di;

import android.content.res.Resources;
import com.avito.android.di.PerFragment;
import com.avito.android.safedeal.delivery_type.DeliveryTypeData;
import com.avito.android.safedeal.delivery_type.DeliveryTypeFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/safedeal/delivery_type/di/DeliveryTypeComponent;", "", "Lcom/avito/android/safedeal/delivery_type/DeliveryTypeFragment;", "fragment", "", "inject", "(Lcom/avito/android/safedeal/delivery_type/DeliveryTypeFragment;)V", "Factory", "safedeal_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {DeliveryTypeDependencies.class}, modules = {DeliveryTypeModule.class})
@PerFragment
public interface DeliveryTypeComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/safedeal/delivery_type/di/DeliveryTypeComponent$Factory;", "", "Lcom/avito/android/safedeal/delivery_type/di/DeliveryTypeDependencies;", "dependencies", "Lcom/avito/android/safedeal/delivery_type/DeliveryTypeData;", "data", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/safedeal/delivery_type/di/DeliveryTypeComponent;", "create", "(Lcom/avito/android/safedeal/delivery_type/di/DeliveryTypeDependencies;Lcom/avito/android/safedeal/delivery_type/DeliveryTypeData;Landroid/content/res/Resources;)Lcom/avito/android/safedeal/delivery_type/di/DeliveryTypeComponent;", "safedeal_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        DeliveryTypeComponent create(@NotNull DeliveryTypeDependencies deliveryTypeDependencies, @BindsInstance @NotNull DeliveryTypeData deliveryTypeData, @BindsInstance @NotNull Resources resources);
    }

    void inject(@NotNull DeliveryTypeFragment deliveryTypeFragment);
}
