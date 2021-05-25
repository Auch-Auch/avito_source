package com.avito.android.fees.di;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.PerFragment;
import com.avito.android.fees.PackageFeeInteractor;
import com.avito.android.fees.PackageFeeInteractorImpl;
import com.avito.android.fees.PackageFeePresenter;
import com.avito.android.fees.PackageFeePresenterImpl;
import com.avito.android.fees.remote.FeesApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.SchedulersFactory;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/fees/di/PackageFeeFragmentModule;", "", "Lcom/avito/android/fees/PackageFeeInteractor;", "packageFeeInteractor", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/util/ErrorFormatter;", "errorFormatter", "Lcom/avito/android/fees/PackageFeePresenter;", "providePresenter", "(Lcom/avito/android/fees/PackageFeeInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/ErrorFormatter;)Lcom/avito/android/fees/PackageFeePresenter;", "Lcom/avito/android/fees/remote/FeesApi;", "api", "providePackageFeeInteractor", "(Lcom/avito/android/fees/remote/FeesApi;)Lcom/avito/android/fees/PackageFeeInteractor;", "provideErrorFormatter", "()Lcom/avito/android/util/ErrorFormatter;", "Landroidx/fragment/app/Fragment;", AuthSource.BOOKING_ORDER, "Landroidx/fragment/app/Fragment;", "fragment", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "<init>", "(Ljava/lang/String;Landroidx/fragment/app/Fragment;)V", "fees_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class PackageFeeFragmentModule {
    public final String a;
    public final Fragment b;

    public PackageFeeFragmentModule(@NotNull String str, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.a = str;
        this.b = fragment;
    }

    @Provides
    @PerFragment
    @NotNull
    public final ErrorFormatter provideErrorFormatter() {
        Resources resources = this.b.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "fragment.resources");
        return new ErrorFormatterImpl(resources);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PackageFeeInteractor providePackageFeeInteractor(@NotNull FeesApi feesApi) {
        Intrinsics.checkNotNullParameter(feesApi, "api");
        return new PackageFeeInteractorImpl(feesApi, this.a);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PackageFeePresenter providePresenter(@NotNull PackageFeeInteractor packageFeeInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull ErrorFormatter errorFormatter) {
        Intrinsics.checkNotNullParameter(packageFeeInteractor, "packageFeeInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        return new PackageFeePresenterImpl(packageFeeInteractor, schedulersFactory, errorFormatter);
    }
}
