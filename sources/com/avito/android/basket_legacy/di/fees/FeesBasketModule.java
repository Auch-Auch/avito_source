package com.avito.android.basket_legacy.di.fees;

import android.content.res.Resources;
import com.avito.android.basket_legacy.di.AdvertId;
import com.avito.android.basket_legacy.fees.BasketInteractor;
import com.avito.android.basket_legacy.fees.BasketInteractorImpl;
import com.avito.android.basket_legacy.fees.SingleFeeServiceConverter;
import com.avito.android.basket_legacy.fees.SingleFeeServiceConverterImpl;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.PerActivity;
import com.avito.android.fees.refactor.PackageApplyInteractor;
import com.avito.android.fees.refactor.PackageApplyInteractorImpl;
import com.avito.android.fees.remote.FeesApi;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.SchedulersFactory;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J1\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/basket_legacy/di/fees/FeesBasketModule;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/fees/remote/FeesApi;", "feesApi", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/util/ErrorFormatter;", "errorFormatter", "Lcom/avito/android/fees/refactor/PackageApplyInteractor;", "providePackageApplyInteractor", "(Ljava/lang/String;Lcom/avito/android/fees/remote/FeesApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/ErrorFormatter;)Lcom/avito/android/fees/refactor/PackageApplyInteractor;", "Landroid/content/res/Resources;", "resources", "provideErrorFormatter", "(Landroid/content/res/Resources;)Lcom/avito/android/util/ErrorFormatter;", "<init>", "()V", "Declarations", "basket_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class FeesBasketModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/basket_legacy/di/fees/FeesBasketModule$Declarations;", "", "Lcom/avito/android/basket_legacy/fees/BasketInteractorImpl;", "basketFeesInteractorImpl", "Lcom/avito/android/basket_legacy/fees/BasketInteractor;", "provideBasketFeesInteractor", "(Lcom/avito/android/basket_legacy/fees/BasketInteractorImpl;)Lcom/avito/android/basket_legacy/fees/BasketInteractor;", "Lcom/avito/android/basket_legacy/fees/SingleFeeServiceConverterImpl;", "converter", "Lcom/avito/android/basket_legacy/fees/SingleFeeServiceConverter;", "provideSingleFeeServiceConverter", "(Lcom/avito/android/basket_legacy/fees/SingleFeeServiceConverterImpl;)Lcom/avito/android/basket_legacy/fees/SingleFeeServiceConverter;", "basket_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        BasketInteractor provideBasketFeesInteractor(@NotNull BasketInteractorImpl basketInteractorImpl);

        @PerActivity
        @Binds
        @NotNull
        SingleFeeServiceConverter provideSingleFeeServiceConverter(@NotNull SingleFeeServiceConverterImpl singleFeeServiceConverterImpl);
    }

    @Provides
    @PerActivity
    @NotNull
    public final ErrorFormatter provideErrorFormatter(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new ErrorFormatterImpl(resources);
    }

    @Provides
    @PerActivity
    @NotNull
    public final PackageApplyInteractor providePackageApplyInteractor(@AdvertId @NotNull String str, @NotNull FeesApi feesApi, @NotNull SchedulersFactory schedulersFactory, @NotNull ErrorFormatter errorFormatter) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(feesApi, "feesApi");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        return new PackageApplyInteractorImpl(str, feesApi, schedulersFactory, errorFormatter);
    }
}
