package com.avito.android.payment.di.component;

import com.avito.android.di.PerActivity;
import com.avito.android.payment.di.module.PaymentGenericFormModule;
import com.avito.android.payment.form.PaymentGenericFormActivity;
import com.avito.android.payment.remote.PaymentSessionTypeMarker;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/payment/di/component/PaymentGenericFormComponent;", "", "Lcom/avito/android/payment/form/PaymentGenericFormActivity;", "activity", "", "inject", "(Lcom/avito/android/payment/form/PaymentGenericFormActivity;)V", "Builder", "payment_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PaymentDependencies.class}, modules = {PaymentGenericFormModule.class})
@PerActivity
public interface PaymentGenericFormComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH'¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/payment/di/component/PaymentGenericFormComponent$Builder;", "", "Lcom/avito/android/payment/di/component/PaymentDependencies;", "paymentDependencies", "(Lcom/avito/android/payment/di/component/PaymentDependencies;)Lcom/avito/android/payment/di/component/PaymentGenericFormComponent$Builder;", "Lcom/avito/android/payment/di/module/PaymentGenericFormModule;", "paymentGenericFormModule", "(Lcom/avito/android/payment/di/module/PaymentGenericFormModule;)Lcom/avito/android/payment/di/component/PaymentGenericFormComponent$Builder;", "Lcom/avito/android/payment/remote/PaymentSessionTypeMarker;", "paymentSessionTypeMarker", "(Lcom/avito/android/payment/remote/PaymentSessionTypeMarker;)Lcom/avito/android/payment/di/component/PaymentGenericFormComponent$Builder;", "Lcom/avito/android/payment/di/component/PaymentGenericFormComponent;", "build", "()Lcom/avito/android/payment/di/component/PaymentGenericFormComponent;", "payment_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        PaymentGenericFormComponent build();

        @NotNull
        Builder paymentDependencies(@NotNull PaymentDependencies paymentDependencies);

        @NotNull
        Builder paymentGenericFormModule(@NotNull PaymentGenericFormModule paymentGenericFormModule);

        @BindsInstance
        @NotNull
        Builder paymentSessionTypeMarker(@NotNull PaymentSessionTypeMarker paymentSessionTypeMarker);
    }

    void inject(@NotNull PaymentGenericFormActivity paymentGenericFormActivity);
}
