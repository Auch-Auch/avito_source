package com.avito.android.fees.di;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.DialogRouterModule;
import com.avito.android.di.PerActivity;
import com.avito.android.fees.FeesInteractor;
import com.avito.android.fees.FeesInteractorImpl;
import com.avito.android.fees.FeesPresenter;
import com.avito.android.fees.FeesPresenterImpl;
import com.avito.android.fees.PackageFeeInteractor;
import com.avito.android.fees.PackageFeeInteractorImpl;
import com.avito.android.fees.refactor.PackageApplyInteractor;
import com.avito.android.fees.refactor.PackageApplyInteractorImpl;
import com.avito.android.fees.remote.FeesApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.preferences.GeoContract;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010%\u001a\u00020\"\u0012\b\u0010!\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b&\u0010'J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/avito/android/fees/di/FeesActivityModule;", "", "Lcom/avito/android/fees/remote/FeesApi;", "api", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", GeoContract.PROVIDER, "Lcom/avito/android/fees/FeesInteractor;", "provideInteractor", "(Lcom/avito/android/fees/remote/FeesApi;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;)Lcom/avito/android/fees/FeesInteractor;", "feesInteractor", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/util/ErrorFormatter;", "errorFormatter", "Lcom/avito/android/fees/FeesPresenter;", "providePresenter", "(Lcom/avito/android/fees/FeesInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/ErrorFormatter;)Lcom/avito/android/fees/FeesPresenter;", "Lcom/avito/android/fees/PackageFeeInteractor;", "providePackageFeeInteractor", "(Lcom/avito/android/fees/remote/FeesApi;)Lcom/avito/android/fees/PackageFeeInteractor;", "feesApi", "Lcom/avito/android/fees/refactor/PackageApplyInteractor;", "providePackageApplyInteractor", "(Lcom/avito/android/fees/remote/FeesApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/ErrorFormatter;)Lcom/avito/android/fees/refactor/PackageApplyInteractor;", "provideErrorFormatter", "()Lcom/avito/android/util/ErrorFormatter;", "Landroid/app/Activity;", "c", "Landroid/app/Activity;", "activity", "Landroid/os/Bundle;", AuthSource.BOOKING_ORDER, "Landroid/os/Bundle;", "bundle", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "<init>", "(Ljava/lang/String;Landroid/os/Bundle;Landroid/app/Activity;)V", "fees_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {DialogRouterModule.class})
public final class FeesActivityModule {
    public final String a;
    public final Bundle b;
    public final Activity c;

    public FeesActivityModule(@NotNull String str, @Nullable Bundle bundle, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a = str;
        this.b = bundle;
        this.c = activity;
    }

    @Provides
    @PerActivity
    @NotNull
    public final ErrorFormatter provideErrorFormatter() {
        Resources resources = this.c.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "activity.resources");
        return new ErrorFormatterImpl(resources);
    }

    @Provides
    @PerActivity
    @NotNull
    public final FeesInteractor provideInteractor(@NotNull FeesApi feesApi, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider) {
        Intrinsics.checkNotNullParameter(feesApi, "api");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, GeoContract.PROVIDER);
        return new FeesInteractorImpl(feesApi, this.a, this.b, publishAnalyticsDataProvider);
    }

    @Provides
    @PerActivity
    @NotNull
    public final PackageApplyInteractor providePackageApplyInteractor(@NotNull FeesApi feesApi, @NotNull SchedulersFactory schedulersFactory, @NotNull ErrorFormatter errorFormatter) {
        Intrinsics.checkNotNullParameter(feesApi, "feesApi");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        return new PackageApplyInteractorImpl(this.a, feesApi, schedulersFactory, errorFormatter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final PackageFeeInteractor providePackageFeeInteractor(@NotNull FeesApi feesApi) {
        Intrinsics.checkNotNullParameter(feesApi, "api");
        return new PackageFeeInteractorImpl(feesApi, this.a);
    }

    @Provides
    @PerActivity
    @NotNull
    public final FeesPresenter providePresenter(@NotNull FeesInteractor feesInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull ErrorFormatter errorFormatter) {
        Intrinsics.checkNotNullParameter(feesInteractor, "feesInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        return new FeesPresenterImpl(feesInteractor, schedulersFactory, errorFormatter);
    }
}
