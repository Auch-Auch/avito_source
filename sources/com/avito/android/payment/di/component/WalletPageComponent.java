package com.avito.android.payment.di.component;

import com.avito.android.di.PerActivity;
import com.avito.android.payment.di.module.WalletPageModule;
import com.avito.android.payment.wallet.WalletPageActivity;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/payment/di/component/WalletPageComponent;", "", "Lcom/avito/android/payment/wallet/WalletPageActivity;", "walletPageActivity", "", "inject", "(Lcom/avito/android/payment/wallet/WalletPageActivity;)V", "Builder", "payment_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PaymentDependencies.class}, modules = {WalletPageModule.class})
@PerActivity
public interface WalletPageComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/payment/di/component/WalletPageComponent$Builder;", "", "Lcom/avito/android/payment/di/component/PaymentDependencies;", "paymentDependencies", "(Lcom/avito/android/payment/di/component/PaymentDependencies;)Lcom/avito/android/payment/di/component/WalletPageComponent$Builder;", "Lcom/avito/android/payment/di/module/WalletPageModule;", "walletPageModule", "(Lcom/avito/android/payment/di/module/WalletPageModule;)Lcom/avito/android/payment/di/component/WalletPageComponent$Builder;", "Lcom/avito/android/payment/di/component/WalletPageComponent;", "build", "()Lcom/avito/android/payment/di/component/WalletPageComponent;", "payment_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        WalletPageComponent build();

        @NotNull
        Builder paymentDependencies(@NotNull PaymentDependencies paymentDependencies);

        @NotNull
        Builder walletPageModule(@NotNull WalletPageModule walletPageModule);
    }

    void inject(@NotNull WalletPageActivity walletPageActivity);
}
