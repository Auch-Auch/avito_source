package com.avito.android.safedeal.delivery_courier.di.module;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.di.PerFragment;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.safedeal.delivery_courier.di.qualifier.OrderID;
import com.avito.android.safedeal.delivery_courier.di.qualifier.Source;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateAnalyticsTracker;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateAnalyticsTrackerImpl;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateInteractor;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateInteractorImpl;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateResourceProvider;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateResourceProviderImpl;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateViewModel;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateViewModelFactory;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateViewModelImpl;
import com.avito.android.safedeal.delivery_courier.order_update.konveyor.DeliveryCourierItemsConverter;
import com.avito.android.safedeal.delivery_courier.order_update.konveyor.DeliveryCourierItemsConverterImpl;
import com.avito.android.safedeal.delivery_courier.order_update.konveyor.DeliveryCourierParametersElementConverter;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Formatter;
import com.avito.android.util.PhoneNumberFormatterModule;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.preferences.GeoContract;
import com.avito.android.util.text.AttributedTextFormatterModule;
import com.avito.android.validation.LocalPretendInteractor;
import com.avito.android.validation.LocalPretendInteractorImpl;
import com.avito.android.validation.ParametersValidator;
import com.avito.android.validation.ParametersValidatorImpl;
import com.avito.android.validation.ParametersValidatorResourceProvider;
import com.avito.android.validation.ParametersValidatorResourceProviderImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001AB\t\b\u0002¢\u0006\u0004\b?\u0010@J\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ[\u0010\u001d\u001a\u00020\u00042\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJO\u0010/\u001a\u00020,2\u000e\b\u0001\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*H\u0001¢\u0006\u0004\b-\u0010.J\u0017\u00105\u001a\u0002022\u0006\u00101\u001a\u000200H\u0001¢\u0006\u0004\b3\u00104J/\u0010;\u001a\u0002002\u0006\u0010\u0014\u001a\u0002062\u0006\u0010'\u001a\u00020&2\u0006\u00108\u001a\u0002072\u0006\u0010)\u001a\u00020(H\u0001¢\u0006\u0004\b9\u0010:J\u0017\u0010>\u001a\u0002062\u0006\u0010%\u001a\u00020$H\u0001¢\u0006\u0004\b<\u0010=¨\u0006B"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/di/module/DeliveryCourierOrderUpdateModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateViewModelFactory;", "viewModelFactory", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateViewModel;", "provideDeliveryCourierOrderUpdateViewModel$safedeal_release", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateViewModelFactory;)Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateViewModel;", "provideDeliveryCourierOrderUpdateViewModel", "", "orderID", "source", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateInteractor;", "interactor", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/DeliveryCourierItemsConverter;", "itemsConverter", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateResourceProvider;", "resourceProvider", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateAnalyticsTracker;", "tracker", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "performanceTracker", "provideDeliveryRdsSummaryViewModelFactory$safedeal_release", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/DeliveryCourierItemsConverter;Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateResourceProvider;Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateAnalyticsTracker;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;)Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateViewModelFactory;", "provideDeliveryRdsSummaryViewModelFactory", "Lcom/avito/android/util/Formatter;", "phoneNumberTextWatcher", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/util/Locale;", "locale", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/html_formatter/HtmlCleaner;", "htmlCleaner", "Lcom/avito/android/html_formatter/HtmlNodeFactory;", "htmlNodeFactory", "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "provideCategoryParametersElementConverter$safedeal_release", "(Lcom/avito/android/util/Formatter;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;Landroid/content/res/Resources;Lcom/avito/android/Features;Lcom/avito/android/html_formatter/HtmlCleaner;Lcom/avito/android/html_formatter/HtmlNodeFactory;)Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "provideCategoryParametersElementConverter", "Lcom/avito/android/validation/ParametersValidator;", "validator", "Lcom/avito/android/validation/LocalPretendInteractor;", "provideLocalPretendInteractor$safedeal_release", "(Lcom/avito/android/validation/ParametersValidator;)Lcom/avito/android/validation/LocalPretendInteractor;", "provideLocalPretendInteractor", "Lcom/avito/android/validation/ParametersValidatorResourceProvider;", "Lcom/avito/android/html_formatter/HtmlRenderer;", "htmlRenderer", "provideParametersValidator$safedeal_release", "(Lcom/avito/android/validation/ParametersValidatorResourceProvider;Lcom/avito/android/Features;Lcom/avito/android/html_formatter/HtmlRenderer;Lcom/avito/android/html_formatter/HtmlCleaner;)Lcom/avito/android/validation/ParametersValidator;", "provideParametersValidator", "provideLocalPretendInteractorResourceProvider$safedeal_release", "(Landroid/content/res/Resources;)Lcom/avito/android/validation/ParametersValidatorResourceProvider;", "provideLocalPretendInteractorResourceProvider", "<init>", "()V", "Dependencies", "safedeal_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {DeliveryCourierOrderUpdateBlueprintsModule.class, Dependencies.class, AttributedTextFormatterModule.class, PhoneNumberFormatterModule.class, DeliveryCourierSummaryTrackerModule.class})
public final class DeliveryCourierOrderUpdateModule {
    @NotNull
    public static final DeliveryCourierOrderUpdateModule INSTANCE = new DeliveryCourierOrderUpdateModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/di/module/DeliveryCourierOrderUpdateModule$Dependencies;", "", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateInteractorImpl;", "interactor", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateInteractor;", "bindCourierUpdateInteractor", "(Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateInteractorImpl;)Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateInteractor;", "Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/DeliveryCourierItemsConverterImpl;", "converter", "Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/DeliveryCourierItemsConverter;", "bindDeliveryCourierItemsConverter", "(Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/DeliveryCourierItemsConverterImpl;)Lcom/avito/android/safedeal/delivery_courier/order_update/konveyor/DeliveryCourierItemsConverter;", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateResourceProvider;", "bindCourierUpdateResourceProvider", "(Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateResourceProviderImpl;)Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateResourceProvider;", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateAnalyticsTrackerImpl;", "tracker", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateAnalyticsTracker;", "bindsDeliveryTimeIntervalSelectAnalyticsTracker", "(Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateAnalyticsTrackerImpl;)Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateAnalyticsTracker;", "safedeal_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        DeliveryCourierOrderUpdateInteractor bindCourierUpdateInteractor(@NotNull DeliveryCourierOrderUpdateInteractorImpl deliveryCourierOrderUpdateInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        DeliveryCourierOrderUpdateResourceProvider bindCourierUpdateResourceProvider(@NotNull DeliveryCourierOrderUpdateResourceProviderImpl deliveryCourierOrderUpdateResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        DeliveryCourierItemsConverter bindDeliveryCourierItemsConverter(@NotNull DeliveryCourierItemsConverterImpl deliveryCourierItemsConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        DeliveryCourierOrderUpdateAnalyticsTracker bindsDeliveryTimeIntervalSelectAnalyticsTracker(@NotNull DeliveryCourierOrderUpdateAnalyticsTrackerImpl deliveryCourierOrderUpdateAnalyticsTrackerImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final CategoryParametersElementConverter provideCategoryParametersElementConverter$safedeal_release(@PhoneNumberFormatterModule.PhoneNumberFormatter @NotNull Formatter<String> formatter, @NotNull TimeSource timeSource, @NotNull Locale locale, @NotNull Resources resources, @NotNull Features features, @NotNull HtmlCleaner htmlCleaner, @NotNull HtmlNodeFactory htmlNodeFactory) {
        Intrinsics.checkNotNullParameter(formatter, "phoneNumberTextWatcher");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(htmlCleaner, "htmlCleaner");
        Intrinsics.checkNotNullParameter(htmlNodeFactory, "htmlNodeFactory");
        return new DeliveryCourierParametersElementConverter(formatter, resources, timeSource, true, false, locale, features, htmlCleaner, htmlNodeFactory, 16, null);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DeliveryCourierOrderUpdateViewModel provideDeliveryCourierOrderUpdateViewModel$safedeal_release(@NotNull Fragment fragment, @NotNull DeliveryCourierOrderUpdateViewModelFactory deliveryCourierOrderUpdateViewModelFactory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(deliveryCourierOrderUpdateViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of(fragment, deliveryCourierOrderUpdateViewModelFactory).get(DeliveryCourierOrderUpdateViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(fr…iewModelImpl::class.java)");
        return (DeliveryCourierOrderUpdateViewModel) viewModel;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DeliveryCourierOrderUpdateViewModelFactory provideDeliveryRdsSummaryViewModelFactory$safedeal_release(@OrderID @NotNull String str, @Source @NotNull String str2, @NotNull DeliveryCourierOrderUpdateInteractor deliveryCourierOrderUpdateInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull DeliveryCourierItemsConverter deliveryCourierItemsConverter, @NotNull DeliveryCourierOrderUpdateResourceProvider deliveryCourierOrderUpdateResourceProvider, @NotNull DeliveryCourierOrderUpdateAnalyticsTracker deliveryCourierOrderUpdateAnalyticsTracker, @NotNull AccountStateProvider accountStateProvider, @NotNull BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        Intrinsics.checkNotNullParameter(str, "orderID");
        Intrinsics.checkNotNullParameter(str2, "source");
        Intrinsics.checkNotNullParameter(deliveryCourierOrderUpdateInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(deliveryCourierItemsConverter, "itemsConverter");
        Intrinsics.checkNotNullParameter(deliveryCourierOrderUpdateResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(deliveryCourierOrderUpdateAnalyticsTracker, "tracker");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(baseScreenPerformanceTracker, "performanceTracker");
        return new DeliveryCourierOrderUpdateViewModelFactory(str, str2, deliveryCourierOrderUpdateInteractor, schedulersFactory, deliveryCourierItemsConverter, deliveryCourierOrderUpdateResourceProvider, deliveryCourierOrderUpdateAnalyticsTracker, accountStateProvider, baseScreenPerformanceTracker);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final LocalPretendInteractor provideLocalPretendInteractor$safedeal_release(@NotNull ParametersValidator parametersValidator) {
        Intrinsics.checkNotNullParameter(parametersValidator, "validator");
        return new LocalPretendInteractorImpl(parametersValidator);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ParametersValidatorResourceProvider provideLocalPretendInteractorResourceProvider$safedeal_release(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new ParametersValidatorResourceProviderImpl(resources);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ParametersValidator provideParametersValidator$safedeal_release(@NotNull ParametersValidatorResourceProvider parametersValidatorResourceProvider, @NotNull Features features, @NotNull HtmlRenderer htmlRenderer, @NotNull HtmlCleaner htmlCleaner) {
        Intrinsics.checkNotNullParameter(parametersValidatorResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(htmlRenderer, "htmlRenderer");
        Intrinsics.checkNotNullParameter(htmlCleaner, "htmlCleaner");
        return new ParametersValidatorImpl(parametersValidatorResourceProvider, features, htmlRenderer, htmlCleaner);
    }
}
