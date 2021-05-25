package com.avito.android.basket.checkout.di;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.basket.checkout.CheckoutFragment;
import com.avito.android.di.PerFragment;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/basket/checkout/di/CheckoutComponent;", "", "Lcom/avito/android/basket/checkout/CheckoutFragment;", "fragment", "", "inject", "(Lcom/avito/android/basket/checkout/CheckoutFragment;)V", "Builder", "basket_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {CheckoutDependencies.class}, modules = {CheckoutModule.class})
@PerFragment
public interface CheckoutComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/basket/checkout/di/CheckoutComponent$Builder;", "", "Lcom/avito/android/basket/checkout/di/CheckoutDependencies;", "checkoutDependencies", "dependencies", "(Lcom/avito/android/basket/checkout/di/CheckoutDependencies;)Lcom/avito/android/basket/checkout/di/CheckoutComponent$Builder;", "", "checkoutContext", "(Ljava/lang/String;)Lcom/avito/android/basket/checkout/di/CheckoutComponent$Builder;", "Landroidx/fragment/app/Fragment;", "fragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/basket/checkout/di/CheckoutComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/basket/checkout/di/CheckoutComponent$Builder;", "Lcom/avito/android/util/Kundle;", "kundle", "savedState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/basket/checkout/di/CheckoutComponent$Builder;", "Lcom/avito/android/basket/checkout/di/CheckoutComponent;", "build", "()Lcom/avito/android/basket/checkout/di/CheckoutComponent;", "basket_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        CheckoutComponent build();

        @BindsInstance
        @NotNull
        Builder checkoutContext(@NotNull String str);

        @NotNull
        Builder dependencies(@NotNull CheckoutDependencies checkoutDependencies);

        @BindsInstance
        @NotNull
        Builder fragment(@NotNull Fragment fragment);

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder savedState(@NotNull Kundle kundle);
    }

    void inject(@NotNull CheckoutFragment checkoutFragment);
}
