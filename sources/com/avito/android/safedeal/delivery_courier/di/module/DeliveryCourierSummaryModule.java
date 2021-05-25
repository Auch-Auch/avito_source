package com.avito.android.safedeal.delivery_courier.di.module;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.Features;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.di.PerFragment;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryInteractor;
import com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryInteractorImpl;
import com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryResourceProvider;
import com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryResourceProviderImpl;
import com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewModel;
import com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewModelFactory;
import com.avito.android.safedeal.delivery_courier.summary.DeliveryCourierSummaryViewModelImpl;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.DeliveryCourierSummaryItemsConverter;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.DeliveryCourierSummaryItemsConverterImpl;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.DeliveryCourierSummaryKonveyorResourceProvider;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.DeliveryCourierSummaryKonveyorResourceProviderImpl;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.DeliveryCourierSummaryParametersElementConverter;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Formatter;
import com.avito.android.util.PhoneNumberFormatterModule;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001/B\t\b\u0002¢\u0006\u0004\b-\u0010.J\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJO\u0010\u001c\u001a\u00020\u00192\u000e\b\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\"\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0001¢\u0006\u0004\b \u0010!J/\u0010)\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010&\u001a\u00020%2\u0006\u0010\u0016\u001a\u00020\u0015H\u0001¢\u0006\u0004\b'\u0010(J\u0017\u0010,\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b*\u0010+¨\u00060"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/di/module/DeliveryCourierSummaryModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryViewModelFactory;", "viewModelFactory", "Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryViewModel;", "provideDeliveryRdsSummaryViewModel$safedeal_release", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryViewModelFactory;)Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryViewModel;", "provideDeliveryRdsSummaryViewModel", "Lcom/avito/android/util/Formatter;", "", "phoneNumberTextWatcher", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/util/Locale;", "locale", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/html_formatter/HtmlCleaner;", "htmlCleaner", "Lcom/avito/android/html_formatter/HtmlNodeFactory;", "htmlNodeFactory", "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "provideCategoryParametersElementConverter$safedeal_release", "(Lcom/avito/android/util/Formatter;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;Landroid/content/res/Resources;Lcom/avito/android/Features;Lcom/avito/android/html_formatter/HtmlCleaner;Lcom/avito/android/html_formatter/HtmlNodeFactory;)Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "provideCategoryParametersElementConverter", "Lcom/avito/android/validation/ParametersValidator;", "validator", "Lcom/avito/android/validation/LocalPretendInteractor;", "provideLocalPretendInteractor$safedeal_release", "(Lcom/avito/android/validation/ParametersValidator;)Lcom/avito/android/validation/LocalPretendInteractor;", "provideLocalPretendInteractor", "Lcom/avito/android/validation/ParametersValidatorResourceProvider;", "resourceProvider", "Lcom/avito/android/html_formatter/HtmlRenderer;", "htmlRenderer", "provideParametersValidator$safedeal_release", "(Lcom/avito/android/validation/ParametersValidatorResourceProvider;Lcom/avito/android/Features;Lcom/avito/android/html_formatter/HtmlRenderer;Lcom/avito/android/html_formatter/HtmlCleaner;)Lcom/avito/android/validation/ParametersValidator;", "provideParametersValidator", "provideLocalPretendInteractorResourceProvider$safedeal_release", "(Landroid/content/res/Resources;)Lcom/avito/android/validation/ParametersValidatorResourceProvider;", "provideLocalPretendInteractorResourceProvider", "<init>", "()V", "Dependencies", "safedeal_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Dependencies.class, DeliveryCourierSummaryBlueprintsModule.class, AttributedTextFormatterModule.class, PhoneNumberFormatterModule.class, DeliveryCourierSummaryTrackerModule.class})
public final class DeliveryCourierSummaryModule {
    @NotNull
    public static final DeliveryCourierSummaryModule INSTANCE = new DeliveryCourierSummaryModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0010H'¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/di/module/DeliveryCourierSummaryModule$Dependencies;", "", "Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryInteractorImpl;", "interactor", "Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryInteractor;", "bindsSummaryInteractor", "(Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryInteractorImpl;)Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryInteractor;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/DeliveryCourierSummaryItemsConverterImpl;", "converter", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/DeliveryCourierSummaryItemsConverter;", "bindsSummaryItemsConverter", "(Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/DeliveryCourierSummaryItemsConverterImpl;)Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/DeliveryCourierSummaryItemsConverter;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/DeliveryCourierSummaryKonveyorResourceProviderImpl;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/DeliveryCourierSummaryKonveyorResourceProvider;", "bindsSummaryKonveyorResourceProvider", "(Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/DeliveryCourierSummaryKonveyorResourceProviderImpl;)Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/DeliveryCourierSummaryKonveyorResourceProvider;", "Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryResourceProviderImpl;", "Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryResourceProvider;", "bindsSummaryResourceProvider", "(Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryResourceProviderImpl;)Lcom/avito/android/safedeal/delivery_courier/summary/DeliveryCourierSummaryResourceProvider;", "safedeal_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        DeliveryCourierSummaryInteractor bindsSummaryInteractor(@NotNull DeliveryCourierSummaryInteractorImpl deliveryCourierSummaryInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        DeliveryCourierSummaryItemsConverter bindsSummaryItemsConverter(@NotNull DeliveryCourierSummaryItemsConverterImpl deliveryCourierSummaryItemsConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        DeliveryCourierSummaryKonveyorResourceProvider bindsSummaryKonveyorResourceProvider(@NotNull DeliveryCourierSummaryKonveyorResourceProviderImpl deliveryCourierSummaryKonveyorResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        DeliveryCourierSummaryResourceProvider bindsSummaryResourceProvider(@NotNull DeliveryCourierSummaryResourceProviderImpl deliveryCourierSummaryResourceProviderImpl);
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
        return new DeliveryCourierSummaryParametersElementConverter(formatter, resources, timeSource, true, false, locale, features, htmlCleaner, htmlNodeFactory, 16, null);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DeliveryCourierSummaryViewModel provideDeliveryRdsSummaryViewModel$safedeal_release(@NotNull Fragment fragment, @NotNull DeliveryCourierSummaryViewModelFactory deliveryCourierSummaryViewModelFactory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(deliveryCourierSummaryViewModelFactory, "viewModelFactory");
        ViewModel viewModel = new ViewModelProvider(fragment, deliveryCourierSummaryViewModelFactory).get(DeliveryCourierSummaryViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme…iewModelImpl::class.java)");
        return (DeliveryCourierSummaryViewModel) viewModel;
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
