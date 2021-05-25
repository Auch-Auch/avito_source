package com.avito.android.vas_discount.di;

import com.avito.android.di.PerActivity;
import com.avito.android.vas_discount.VasDiscountActivity;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/vas_discount/di/VasDiscountComponent;", "Lcom/avito/android/vas_discount/di/PickerDependencies;", "Lcom/avito/android/vas_discount/VasDiscountActivity;", "activity", "", "inject", "(Lcom/avito/android/vas_discount/VasDiscountActivity;)V", "Builder", "vas-discount_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {DiscountDependencies.class}, modules = {DiscountModule.class})
@PerActivity
public interface VasDiscountComponent extends PickerDependencies {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/vas_discount/di/VasDiscountComponent$Builder;", "", "Lcom/avito/android/vas_discount/di/DiscountDependencies;", "dependencies", "(Lcom/avito/android/vas_discount/di/DiscountDependencies;)Lcom/avito/android/vas_discount/di/VasDiscountComponent$Builder;", "Lcom/avito/android/vas_discount/di/DiscountModule;", BaseAnalyticKt.ANALYTIC_FAIL_MODULE, "(Lcom/avito/android/vas_discount/di/DiscountModule;)Lcom/avito/android/vas_discount/di/VasDiscountComponent$Builder;", "Lcom/avito/android/vas_discount/di/VasDiscountComponent;", "build", "()Lcom/avito/android/vas_discount/di/VasDiscountComponent;", "vas-discount_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        VasDiscountComponent build();

        @NotNull
        Builder dependencies(@NotNull DiscountDependencies discountDependencies);

        @NotNull
        Builder module(@NotNull DiscountModule discountModule);
    }

    void inject(@NotNull VasDiscountActivity vasDiscountActivity);
}
