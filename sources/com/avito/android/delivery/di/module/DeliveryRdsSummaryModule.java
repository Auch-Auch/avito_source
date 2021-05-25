package com.avito.android.delivery.di.module;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.Features;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.delivery.summary.DeliveryRdsSummaryInteractor;
import com.avito.android.delivery.summary.DeliveryRdsSummaryInteractorImpl;
import com.avito.android.delivery.summary.DeliveryRdsSummaryResourceProvider;
import com.avito.android.delivery.summary.DeliveryRdsSummaryResourceProviderImpl;
import com.avito.android.delivery.summary.DeliveryRdsSummaryViewModel;
import com.avito.android.delivery.summary.DeliveryRdsSummaryViewModelFactory;
import com.avito.android.delivery.summary.DeliveryRdsSummaryViewModelImpl;
import com.avito.android.delivery.summary.common.DeliveryRdsContactsFieldsInteractor;
import com.avito.android.delivery.summary.common.DeliveryRdsContactsFieldsInteractorImpl;
import com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryItemsConverter;
import com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryItemsConverterImpl;
import com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryKonveyorResourceProvider;
import com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryKonveyorResourceProviderImpl;
import com.avito.android.delivery.summary.konveyor.DeliveryRdsSummaryParametersElementConverter;
import com.avito.android.di.PerFragment;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.html_formatter.HtmlRenderer;
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
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001/B\t\b\u0002¢\u0006\u0004\b-\u0010.J\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJO\u0010\u001c\u001a\u00020\u00192\u000e\b\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\"\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0001¢\u0006\u0004\b \u0010!J/\u0010)\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010&\u001a\u00020%2\u0006\u0010\u0016\u001a\u00020\u0015H\u0001¢\u0006\u0004\b'\u0010(J\u0017\u0010,\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b*\u0010+¨\u00060"}, d2 = {"Lcom/avito/android/delivery/di/module/DeliveryRdsSummaryModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/delivery/summary/DeliveryRdsSummaryViewModelFactory;", "viewModelFactory", "Lcom/avito/android/delivery/summary/DeliveryRdsSummaryViewModel;", "provideDeliveryRdsSummaryViewModel$delivery_release", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/delivery/summary/DeliveryRdsSummaryViewModelFactory;)Lcom/avito/android/delivery/summary/DeliveryRdsSummaryViewModel;", "provideDeliveryRdsSummaryViewModel", "Lcom/avito/android/util/Formatter;", "", "phoneNumberTextWatcher", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/util/Locale;", "locale", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/html_formatter/HtmlCleaner;", "htmlCleaner", "Lcom/avito/android/html_formatter/HtmlNodeFactory;", "htmlNodeFactory", "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "provideCategoryParametersElementConverter$delivery_release", "(Lcom/avito/android/util/Formatter;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;Landroid/content/res/Resources;Lcom/avito/android/Features;Lcom/avito/android/html_formatter/HtmlCleaner;Lcom/avito/android/html_formatter/HtmlNodeFactory;)Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "provideCategoryParametersElementConverter", "Lcom/avito/android/validation/ParametersValidator;", "validator", "Lcom/avito/android/validation/LocalPretendInteractor;", "provideLocalPretendInteractor$delivery_release", "(Lcom/avito/android/validation/ParametersValidator;)Lcom/avito/android/validation/LocalPretendInteractor;", "provideLocalPretendInteractor", "Lcom/avito/android/validation/ParametersValidatorResourceProvider;", "resourceProvider", "Lcom/avito/android/html_formatter/HtmlRenderer;", "htmlRenderer", "provideParametersValidator$delivery_release", "(Lcom/avito/android/validation/ParametersValidatorResourceProvider;Lcom/avito/android/Features;Lcom/avito/android/html_formatter/HtmlRenderer;Lcom/avito/android/html_formatter/HtmlCleaner;)Lcom/avito/android/validation/ParametersValidator;", "provideParametersValidator", "provideLocalPretendInteractorResourceProvider$delivery_release", "(Landroid/content/res/Resources;)Lcom/avito/android/validation/ParametersValidatorResourceProvider;", "provideLocalPretendInteractorResourceProvider", "<init>", "()V", "Dependencies", "delivery_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Dependencies.class, DeliveryRdsSummaryBlueprintsModule.class, AttributedTextFormatterModule.class, PhoneNumberFormatterModule.class, DeliveryRdsSummaryTrackerModule.class})
public final class DeliveryRdsSummaryModule {
    @NotNull
    public static final DeliveryRdsSummaryModule INSTANCE = new DeliveryRdsSummaryModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0010H'¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0014H'¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/delivery/di/module/DeliveryRdsSummaryModule$Dependencies;", "", "Lcom/avito/android/delivery/summary/DeliveryRdsSummaryInteractorImpl;", "interactor", "Lcom/avito/android/delivery/summary/DeliveryRdsSummaryInteractor;", "bindsSummaryInteractor", "(Lcom/avito/android/delivery/summary/DeliveryRdsSummaryInteractorImpl;)Lcom/avito/android/delivery/summary/DeliveryRdsSummaryInteractor;", "Lcom/avito/android/delivery/summary/konveyor/DeliveryRdsSummaryItemsConverterImpl;", "converter", "Lcom/avito/android/delivery/summary/konveyor/DeliveryRdsSummaryItemsConverter;", "bindsSummaryItemsConverter", "(Lcom/avito/android/delivery/summary/konveyor/DeliveryRdsSummaryItemsConverterImpl;)Lcom/avito/android/delivery/summary/konveyor/DeliveryRdsSummaryItemsConverter;", "Lcom/avito/android/delivery/summary/konveyor/DeliveryRdsSummaryKonveyorResourceProviderImpl;", "Lcom/avito/android/delivery/summary/konveyor/DeliveryRdsSummaryKonveyorResourceProvider;", "bindsSummaryKonveyorResourceProvider", "(Lcom/avito/android/delivery/summary/konveyor/DeliveryRdsSummaryKonveyorResourceProviderImpl;)Lcom/avito/android/delivery/summary/konveyor/DeliveryRdsSummaryKonveyorResourceProvider;", "Lcom/avito/android/delivery/summary/DeliveryRdsSummaryResourceProviderImpl;", "Lcom/avito/android/delivery/summary/DeliveryRdsSummaryResourceProvider;", "bindsSummaryResourceProvider", "(Lcom/avito/android/delivery/summary/DeliveryRdsSummaryResourceProviderImpl;)Lcom/avito/android/delivery/summary/DeliveryRdsSummaryResourceProvider;", "Lcom/avito/android/delivery/summary/common/DeliveryRdsContactsFieldsInteractorImpl;", "Lcom/avito/android/delivery/summary/common/DeliveryRdsContactsFieldsInteractor;", "bindsSummaryContactsInteractor", "(Lcom/avito/android/delivery/summary/common/DeliveryRdsContactsFieldsInteractorImpl;)Lcom/avito/android/delivery/summary/common/DeliveryRdsContactsFieldsInteractor;", "delivery_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        DeliveryRdsContactsFieldsInteractor bindsSummaryContactsInteractor(@NotNull DeliveryRdsContactsFieldsInteractorImpl deliveryRdsContactsFieldsInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        DeliveryRdsSummaryInteractor bindsSummaryInteractor(@NotNull DeliveryRdsSummaryInteractorImpl deliveryRdsSummaryInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        DeliveryRdsSummaryItemsConverter bindsSummaryItemsConverter(@NotNull DeliveryRdsSummaryItemsConverterImpl deliveryRdsSummaryItemsConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        DeliveryRdsSummaryKonveyorResourceProvider bindsSummaryKonveyorResourceProvider(@NotNull DeliveryRdsSummaryKonveyorResourceProviderImpl deliveryRdsSummaryKonveyorResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        DeliveryRdsSummaryResourceProvider bindsSummaryResourceProvider(@NotNull DeliveryRdsSummaryResourceProviderImpl deliveryRdsSummaryResourceProviderImpl);
    }

    @Provides
    @NotNull
    @PerFragment
    public final CategoryParametersElementConverter provideCategoryParametersElementConverter$delivery_release(@PhoneNumberFormatterModule.PhoneNumberFormatter @NotNull Formatter<String> formatter, @NotNull TimeSource timeSource, @NotNull Locale locale, @NotNull Resources resources, @NotNull Features features, @NotNull HtmlCleaner htmlCleaner, @NotNull HtmlNodeFactory htmlNodeFactory) {
        Intrinsics.checkNotNullParameter(formatter, "phoneNumberTextWatcher");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(htmlCleaner, "htmlCleaner");
        Intrinsics.checkNotNullParameter(htmlNodeFactory, "htmlNodeFactory");
        return new DeliveryRdsSummaryParametersElementConverter(formatter, resources, timeSource, true, false, locale, features, htmlCleaner, htmlNodeFactory, 16, null);
    }

    @Provides
    @PerFragment
    @NotNull
    public final DeliveryRdsSummaryViewModel provideDeliveryRdsSummaryViewModel$delivery_release(@NotNull Fragment fragment, @NotNull DeliveryRdsSummaryViewModelFactory deliveryRdsSummaryViewModelFactory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(deliveryRdsSummaryViewModelFactory, "viewModelFactory");
        ViewModel viewModel = new ViewModelProvider(fragment, deliveryRdsSummaryViewModelFactory).get(DeliveryRdsSummaryViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme…iewModelImpl::class.java)");
        return (DeliveryRdsSummaryViewModel) viewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final LocalPretendInteractor provideLocalPretendInteractor$delivery_release(@NotNull ParametersValidator parametersValidator) {
        Intrinsics.checkNotNullParameter(parametersValidator, "validator");
        return new LocalPretendInteractorImpl(parametersValidator);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ParametersValidatorResourceProvider provideLocalPretendInteractorResourceProvider$delivery_release(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new ParametersValidatorResourceProviderImpl(resources);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ParametersValidator provideParametersValidator$delivery_release(@NotNull ParametersValidatorResourceProvider parametersValidatorResourceProvider, @NotNull Features features, @NotNull HtmlRenderer htmlRenderer, @NotNull HtmlCleaner htmlCleaner) {
        Intrinsics.checkNotNullParameter(parametersValidatorResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(htmlRenderer, "htmlRenderer");
        Intrinsics.checkNotNullParameter(htmlCleaner, "htmlCleaner");
        return new ParametersValidatorImpl(parametersValidatorResourceProvider, features, htmlRenderer, htmlCleaner);
    }
}
