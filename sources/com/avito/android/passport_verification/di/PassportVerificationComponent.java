package com.avito.android.passport_verification.di;

import com.avito.android.di.PerActivity;
import com.avito.android.passport_verification.SumsubVerificationActivity;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/passport_verification/di/PassportVerificationComponent;", "", "Lcom/avito/android/passport_verification/SumsubVerificationActivity;", "activity", "", "inject", "(Lcom/avito/android/passport_verification/SumsubVerificationActivity;)V", "Builder", "passport-verification_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {PassportVerificationDependencies.class}, modules = {PassportVerificationModule.class})
@PerActivity
public interface PassportVerificationComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/passport_verification/di/PassportVerificationComponent$Builder;", "", "Lcom/avito/android/passport_verification/di/PassportVerificationDependencies;", "dependencies", "passportVerificationDependencies", "(Lcom/avito/android/passport_verification/di/PassportVerificationDependencies;)Lcom/avito/android/passport_verification/di/PassportVerificationComponent$Builder;", "Lcom/avito/android/passport_verification/di/PassportVerificationModule;", BaseAnalyticKt.ANALYTIC_FAIL_MODULE, "passportVerificationModule", "(Lcom/avito/android/passport_verification/di/PassportVerificationModule;)Lcom/avito/android/passport_verification/di/PassportVerificationComponent$Builder;", "Lcom/avito/android/passport_verification/di/PassportVerificationComponent;", "build", "()Lcom/avito/android/passport_verification/di/PassportVerificationComponent;", "passport-verification_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        PassportVerificationComponent build();

        @NotNull
        Builder passportVerificationDependencies(@NotNull PassportVerificationDependencies passportVerificationDependencies);

        @NotNull
        Builder passportVerificationModule(@NotNull PassportVerificationModule passportVerificationModule);
    }

    void inject(@NotNull SumsubVerificationActivity sumsubVerificationActivity);
}
