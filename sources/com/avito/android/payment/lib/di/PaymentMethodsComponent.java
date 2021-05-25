package com.avito.android.payment.lib.di;

import android.app.Activity;
import arrow.core.Function1;
import com.avito.android.di.PerActivity;
import com.avito.android.payment.lib.PaymentActivity;
import com.avito.android.payment.lib.PaymentSessionType;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/payment/lib/di/PaymentMethodsComponent;", "", "Lcom/avito/android/payment/lib/PaymentActivity;", "paymentActivity", "", "inject", "(Lcom/avito/android/payment/lib/PaymentActivity;)V", "Builder", "payment-lib_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PaymentLibraryDependencies.class}, modules = {PaymentMethodsModule.class})
@PerActivity
public interface PaymentMethodsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0012\u001a\u00020\u00002\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fH'¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/avito/android/payment/lib/di/PaymentMethodsComponent$Builder;", "", "Lcom/avito/android/payment/lib/di/PaymentLibraryDependencies;", "dependencies", "(Lcom/avito/android/payment/lib/di/PaymentLibraryDependencies;)Lcom/avito/android/payment/lib/di/PaymentMethodsComponent$Builder;", "Lcom/avito/android/payment/lib/di/PaymentMethodsModule;", "paymentMethodsModule", BaseAnalyticKt.ANALYTIC_FAIL_MODULE, "(Lcom/avito/android/payment/lib/di/PaymentMethodsModule;)Lcom/avito/android/payment/lib/di/PaymentMethodsComponent$Builder;", "Landroid/app/Activity;", "activity", "(Landroid/app/Activity;)Lcom/avito/android/payment/lib/di/PaymentMethodsComponent$Builder;", "Lcom/avito/android/payment/lib/PaymentSessionType;", "paymentSessionType", "(Lcom/avito/android/payment/lib/PaymentSessionType;)Lcom/avito/android/payment/lib/di/PaymentMethodsComponent$Builder;", "Larrow/core/Function1;", "", "", "onPaymentMethodClickListener", "(Larrow/core/Function1;)Lcom/avito/android/payment/lib/di/PaymentMethodsComponent$Builder;", "Lcom/avito/android/payment/lib/di/PaymentMethodsComponent;", "build", "()Lcom/avito/android/payment/lib/di/PaymentMethodsComponent;", "payment-lib_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder activity(@NotNull Activity activity);

        @NotNull
        PaymentMethodsComponent build();

        @NotNull
        Builder dependencies(@NotNull PaymentLibraryDependencies paymentLibraryDependencies);

        @NotNull
        Builder module(@NotNull PaymentMethodsModule paymentMethodsModule);

        @BindsInstance
        @NotNull
        Builder onPaymentMethodClickListener(@NotNull Function1<Integer, Unit> function1);

        @BindsInstance
        @NotNull
        Builder paymentSessionType(@NotNull PaymentSessionType paymentSessionType);
    }

    void inject(@NotNull PaymentActivity paymentActivity);
}
