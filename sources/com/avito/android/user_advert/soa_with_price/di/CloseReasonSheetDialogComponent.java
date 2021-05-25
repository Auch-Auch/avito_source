package com.avito.android.user_advert.soa_with_price.di;

import android.content.res.Resources;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.di.PerFragment;
import com.avito.android.user_advert.soa_with_price.SoaWithPriceArguments;
import com.avito.android.user_advert.soa_with_price.SoaWithPriceSheetDialogFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/user_advert/soa_with_price/di/CloseReasonSheetDialogComponent;", "", "Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceSheetDialogFragment;", "dialog", "", "inject", "(Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceSheetDialogFragment;)V", "Builder", "user-advert_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {CoreComponentDependencies.class}, modules = {CloseReasonSheetDialogModule.class})
@PerFragment
public interface CloseReasonSheetDialogComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/user_advert/soa_with_price/di/CloseReasonSheetDialogComponent$Builder;", "", "Lcom/avito/android/di/CoreComponentDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/di/CoreComponentDependencies;)Lcom/avito/android/user_advert/soa_with_price/di/CloseReasonSheetDialogComponent$Builder;", "Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceArguments;", "arguments", "withArguments", "(Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceArguments;)Lcom/avito/android/user_advert/soa_with_price/di/CloseReasonSheetDialogComponent$Builder;", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/user_advert/soa_with_price/di/CloseReasonSheetDialogComponent$Builder;", "Lcom/avito/android/user_advert/soa_with_price/di/CloseReasonSheetDialogComponent;", "build", "()Lcom/avito/android/user_advert/soa_with_price/di/CloseReasonSheetDialogComponent;", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        CloseReasonSheetDialogComponent build();

        @NotNull
        Builder dependentOn(@NotNull CoreComponentDependencies coreComponentDependencies);

        @BindsInstance
        @NotNull
        Builder withArguments(@NotNull SoaWithPriceArguments soaWithPriceArguments);

        @BindsInstance
        @NotNull
        Builder withResources(@NotNull Resources resources);
    }

    void inject(@NotNull SoaWithPriceSheetDialogFragment soaWithPriceSheetDialogFragment);
}
