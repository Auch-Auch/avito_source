package com.avito.android.payment.di.component;

import android.app.Activity;
import com.avito.android.di.PerActivity;
import com.avito.android.payment.di.module.PaymentProcessingModule;
import com.avito.android.payment.processing.PaymentProcessingActivity;
import com.avito.android.payment.remote.PaymentSessionTypeMarker;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/payment/di/component/PaymentProcessingComponent;", "", "Lcom/avito/android/payment/processing/PaymentProcessingActivity;", "activity", "", "inject", "(Lcom/avito/android/payment/processing/PaymentProcessingActivity;)V", "Builder", "payment_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PaymentDependencies.class}, modules = {PaymentProcessingModule.class})
@PerActivity
public interface PaymentProcessingComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/payment/di/component/PaymentProcessingComponent$Builder;", "", "Lcom/avito/android/payment/di/component/PaymentDependencies;", "paymentDependencies", "(Lcom/avito/android/payment/di/component/PaymentDependencies;)Lcom/avito/android/payment/di/component/PaymentProcessingComponent$Builder;", "Landroid/app/Activity;", "activity", "withActivity", "(Landroid/app/Activity;)Lcom/avito/android/payment/di/component/PaymentProcessingComponent$Builder;", "Lcom/avito/android/payment/remote/PaymentSessionTypeMarker;", "paymentSessionTypeMarker", "(Lcom/avito/android/payment/remote/PaymentSessionTypeMarker;)Lcom/avito/android/payment/di/component/PaymentProcessingComponent$Builder;", "Lcom/avito/android/payment/di/component/PaymentProcessingComponent;", "build", "()Lcom/avito/android/payment/di/component/PaymentProcessingComponent;", "payment_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        PaymentProcessingComponent build();

        @NotNull
        Builder paymentDependencies(@NotNull PaymentDependencies paymentDependencies);

        @BindsInstance
        @NotNull
        Builder paymentSessionTypeMarker(@NotNull PaymentSessionTypeMarker paymentSessionTypeMarker);

        @BindsInstance
        @NotNull
        Builder withActivity(@NotNull Activity activity);
    }

    void inject(@NotNull PaymentProcessingActivity paymentProcessingActivity);
}
