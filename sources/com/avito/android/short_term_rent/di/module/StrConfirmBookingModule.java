package com.avito.android.short_term_rent.di.module;

import a2.b.a.a.a;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.Features;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.di.PerFragment;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenterImpl;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.recycler.data_aware.SimpleDiffCalculator;
import com.avito.android.recycler.data_aware.SimpleEqualityComparator;
import com.avito.android.server_time.TimeSource;
import com.avito.android.short_term_rent.analytics.NonFatalAnalyticsTracker;
import com.avito.android.short_term_rent.analytics.StrAnalyticsTracker;
import com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingInteractor;
import com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingInteractorImpl;
import com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewModel;
import com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewModelFactory;
import com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewModelImpl;
import com.avito.android.short_term_rent.confirm_booking.utils.StrConfirmBookingContentsComparator;
import com.avito.android.short_term_rent.confirm_booking.utils.StrConfirmBookingResourceProvider;
import com.avito.android.short_term_rent.confirm_booking.utils.StrConfirmBookingResourceProviderImpl;
import com.avito.android.short_term_rent.confirm_booking.utils.StrContactsTreeConverter;
import com.avito.android.short_term_rent.confirm_booking.utils.StrContactsTreeConverterImpl;
import com.avito.android.short_term_rent.di.qualifier.AdvertId;
import com.avito.android.short_term_rent.di.qualifier.CheckInDate;
import com.avito.android.short_term_rent.di.qualifier.CheckOutDate;
import com.avito.android.util.Formatter;
import com.avito.android.util.PhoneNumberFormatterModule;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.preferences.GeoContract;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule;
import com.avito.android.validation.LocalPretendInteractor;
import com.avito.android.validation.LocalPretendInteractorImpl;
import com.avito.android.validation.ParametersValidator;
import com.avito.android.validation.ParametersValidatorImpl;
import com.avito.android.validation.ParametersValidatorResourceProvider;
import com.avito.android.validation.ParametersValidatorResourceProviderImpl;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;
import java.util.Objects;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002_`B\t\b\u0002¢\u0006\u0004\b]\u0010^J'\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0018\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010'\u001a\u00020$2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0001¢\u0006\u0004\b%\u0010&Jw\u0010@\u001a\u00020\"2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\b\b\u0001\u0010-\u001a\u00020,2\b\b\u0001\u0010.\u001a\u00020,2\b\b\u0001\u0010/\u001a\u00020,2\b\b\u0001\u00101\u001a\u0002002\u0006\u00103\u001a\u0002022\u0006\u00105\u001a\u0002042\u0006\u00107\u001a\u0002062\u0006\u00109\u001a\u0002082\u0006\u0010;\u001a\u00020:2\u0006\u0010=\u001a\u00020<H\u0001¢\u0006\u0004\b>\u0010?JO\u0010O\u001a\u0002042\u000e\b\u0001\u0010B\u001a\b\u0012\u0004\u0012\u00020,0A2\u0006\u0010D\u001a\u00020C2\u0006\u0010F\u001a\u00020E2\u0006\u0010H\u001a\u00020G2\u0006\u0010J\u001a\u00020I2\u0006\u0010L\u001a\u00020K2\u0006\u0010N\u001a\u00020MH\u0007¢\u0006\u0004\bO\u0010PJ\u0017\u0010T\u001a\u00020S2\u0006\u0010R\u001a\u00020QH\u0007¢\u0006\u0004\bT\u0010UJ/\u0010Y\u001a\u00020Q2\u0006\u00109\u001a\u00020V2\u0006\u0010J\u001a\u00020I2\u0006\u0010X\u001a\u00020W2\u0006\u0010L\u001a\u00020KH\u0007¢\u0006\u0004\bY\u0010ZJ\u0017\u0010[\u001a\u00020V2\u0006\u0010F\u001a\u00020EH\u0007¢\u0006\u0004\b[\u0010\\¨\u0006a"}, d2 = {"Lcom/avito/android/short_term_rent/di/module/StrConfirmBookingModule;", "", "Landroidx/recyclerview/widget/ListUpdateCallback;", "updateCallback", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/data_aware/DiffCalculator;", "diffCalculator", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "provideDataAwareAdapterPresenter$short_term_rent_release", "(Landroidx/recyclerview/widget/ListUpdateCallback;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/data_aware/DiffCalculator;)Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "provideDataAwareAdapterPresenter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "provideListUpdateCallback$short_term_rent_release", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)Landroidx/recyclerview/widget/ListUpdateCallback;", "provideListUpdateCallback", "Lcom/avito/android/short_term_rent/confirm_booking/utils/StrConfirmBookingContentsComparator;", "contentsComparator", "provideDiffCalculator$short_term_rent_release", "(Lcom/avito/android/short_term_rent/confirm_booking/utils/StrConfirmBookingContentsComparator;)Lcom/avito/android/recycler/data_aware/DiffCalculator;", "provideDiffCalculator", "provideContentsComparator$short_term_rent_release", "()Lcom/avito/android/short_term_rent/confirm_booking/utils/StrConfirmBookingContentsComparator;", "provideContentsComparator", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "provideRecyclerAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideAdapterPresenter$short_term_rent_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingViewModelFactory;", "viewModelFactory", "Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingViewModel;", "provideStrConfirmBookingViewModel$short_term_rent_release", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingViewModelFactory;)Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingViewModel;", "provideStrConfirmBookingViewModel", "Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingInteractorImpl;", "interactor", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "", BookingInfoActivity.EXTRA_ITEM_ID, "checkInDate", "checkOutDate", "", "guestsCount", "Lcom/avito/android/short_term_rent/analytics/StrAnalyticsTracker;", "analyticsTracker", "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "elementConverter", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/short_term_rent/confirm_booking/utils/StrConfirmBookingResourceProvider;", "resourceProvider", "Lcom/avito/android/short_term_rent/confirm_booking/utils/StrContactsTreeConverter;", "contactsTreeConverter", "Lcom/avito/android/short_term_rent/analytics/NonFatalAnalyticsTracker;", "nonFatalAnalyticsTracker", "provideStrConfirmBookingViewModelFactory$short_term_rent_release", "(Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingInteractorImpl;Lcom/avito/android/util/SchedulersFactory;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/avito/android/short_term_rent/analytics/StrAnalyticsTracker;Lcom/avito/android/category_parameters/CategoryParametersElementConverter;Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/short_term_rent/confirm_booking/utils/StrConfirmBookingResourceProvider;Lcom/avito/android/short_term_rent/confirm_booking/utils/StrContactsTreeConverter;Lcom/avito/android/short_term_rent/analytics/NonFatalAnalyticsTracker;)Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingViewModelFactory;", "provideStrConfirmBookingViewModelFactory", "Lcom/avito/android/util/Formatter;", "phoneNumberTextWatcher", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Landroid/content/res/Resources;", "resources", "Ljava/util/Locale;", "locale", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/html_formatter/HtmlCleaner;", "htmlCleaner", "Lcom/avito/android/html_formatter/HtmlNodeFactory;", "htmlNodeFactory", "provideCategoryParametersElementConverter", "(Lcom/avito/android/util/Formatter;Lcom/avito/android/server_time/TimeSource;Landroid/content/res/Resources;Ljava/util/Locale;Lcom/avito/android/Features;Lcom/avito/android/html_formatter/HtmlCleaner;Lcom/avito/android/html_formatter/HtmlNodeFactory;)Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "Lcom/avito/android/validation/ParametersValidator;", "validator", "Lcom/avito/android/validation/LocalPretendInteractor;", "provideLocalPretendInteractor", "(Lcom/avito/android/validation/ParametersValidator;)Lcom/avito/android/validation/LocalPretendInteractor;", "Lcom/avito/android/validation/ParametersValidatorResourceProvider;", "Lcom/avito/android/html_formatter/HtmlRenderer;", "htmlRenderer", "provideParametersValidator", "(Lcom/avito/android/validation/ParametersValidatorResourceProvider;Lcom/avito/android/Features;Lcom/avito/android/html_formatter/HtmlRenderer;Lcom/avito/android/html_formatter/HtmlCleaner;)Lcom/avito/android/validation/ParametersValidator;", "provideLocalPretendInteractorResourceProvider", "(Landroid/content/res/Resources;)Lcom/avito/android/validation/ParametersValidatorResourceProvider;", "<init>", "()V", "Dependencies", "GuestsCount", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Dependencies.class, StrAnalyticsTrackerModule.class, StrConfirmBookingBlueprintsModule.class, AttributedTextFormatterModule.class, NonFatalAnalyticsTrackerModule.class})
public final class StrConfirmBookingModule {
    @NotNull
    public static final StrConfirmBookingModule INSTANCE = new StrConfirmBookingModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/short_term_rent/di/module/StrConfirmBookingModule$Dependencies;", "", "Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingInteractorImpl;", "interactor", "Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingInteractor;", "bindsStrConfirmBookingInteractor", "(Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingInteractorImpl;)Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingInteractor;", "Lcom/avito/android/short_term_rent/confirm_booking/utils/StrConfirmBookingResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/short_term_rent/confirm_booking/utils/StrConfirmBookingResourceProvider;", "bindsStrConfirmBookingResourceProvider", "(Lcom/avito/android/short_term_rent/confirm_booking/utils/StrConfirmBookingResourceProviderImpl;)Lcom/avito/android/short_term_rent/confirm_booking/utils/StrConfirmBookingResourceProvider;", "Lcom/avito/android/short_term_rent/confirm_booking/utils/StrContactsTreeConverterImpl;", "converter", "Lcom/avito/android/short_term_rent/confirm_booking/utils/StrContactsTreeConverter;", "bindsStrContactsTreeConverter", "(Lcom/avito/android/short_term_rent/confirm_booking/utils/StrContactsTreeConverterImpl;)Lcom/avito/android/short_term_rent/confirm_booking/utils/StrContactsTreeConverter;", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        StrConfirmBookingInteractor bindsStrConfirmBookingInteractor(@NotNull StrConfirmBookingInteractorImpl strConfirmBookingInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        StrConfirmBookingResourceProvider bindsStrConfirmBookingResourceProvider(@NotNull StrConfirmBookingResourceProviderImpl strConfirmBookingResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        StrContactsTreeConverter bindsStrContactsTreeConverter(@NotNull StrContactsTreeConverterImpl strContactsTreeConverterImpl);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/short_term_rent/di/module/StrConfirmBookingModule$GuestsCount;", "", "<init>", "()V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface GuestsCount {
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final AdapterPresenter provideAdapterPresenter$short_term_rent_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final CategoryParametersElementConverter provideCategoryParametersElementConverter(@PhoneNumberFormatterModule.PhoneNumberFormatter @NotNull Formatter<String> formatter, @NotNull TimeSource timeSource, @NotNull Resources resources, @NotNull Locale locale, @NotNull Features features, @NotNull HtmlCleaner htmlCleaner, @NotNull HtmlNodeFactory htmlNodeFactory) {
        Intrinsics.checkNotNullParameter(formatter, "phoneNumberTextWatcher");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(htmlCleaner, "htmlCleaner");
        Intrinsics.checkNotNullParameter(htmlNodeFactory, "htmlNodeFactory");
        return new CategoryParametersElementConverter(formatter, resources, timeSource, true, false, locale, false, false, false, false, htmlNodeFactory, htmlCleaner, features, 976, null);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final StrConfirmBookingContentsComparator provideContentsComparator$short_term_rent_release() {
        return new StrConfirmBookingContentsComparator();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DataAwareAdapterPresenter provideDataAwareAdapterPresenter$short_term_rent_release(@NotNull ListUpdateCallback listUpdateCallback, @NotNull AdapterPresenter adapterPresenter, @NotNull DiffCalculator diffCalculator) {
        Intrinsics.checkNotNullParameter(listUpdateCallback, "updateCallback");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(diffCalculator, "diffCalculator");
        Factory create = InstanceFactory.create(listUpdateCallback);
        Objects.requireNonNull(create, "null cannot be cast to non-null type dagger.internal.InstanceFactory<androidx.recyclerview.widget.ListUpdateCallback>");
        return new DataAwareAdapterPresenterImpl((InstanceFactory) create, adapterPresenter, diffCalculator);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DiffCalculator provideDiffCalculator$short_term_rent_release(@NotNull StrConfirmBookingContentsComparator strConfirmBookingContentsComparator) {
        Intrinsics.checkNotNullParameter(strConfirmBookingContentsComparator, "contentsComparator");
        return new SimpleDiffCalculator(strConfirmBookingContentsComparator, new SimpleEqualityComparator(), true, null, 8, null);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ListUpdateCallback provideListUpdateCallback$short_term_rent_release(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "adapter");
        return simpleRecyclerAdapter;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final LocalPretendInteractor provideLocalPretendInteractor(@NotNull ParametersValidator parametersValidator) {
        Intrinsics.checkNotNullParameter(parametersValidator, "validator");
        return new LocalPretendInteractorImpl(parametersValidator);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ParametersValidatorResourceProvider provideLocalPretendInteractorResourceProvider(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new ParametersValidatorResourceProviderImpl(resources);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ParametersValidator provideParametersValidator(@NotNull ParametersValidatorResourceProvider parametersValidatorResourceProvider, @NotNull Features features, @NotNull HtmlRenderer htmlRenderer, @NotNull HtmlCleaner htmlCleaner) {
        Intrinsics.checkNotNullParameter(parametersValidatorResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(htmlRenderer, "htmlRenderer");
        Intrinsics.checkNotNullParameter(htmlCleaner, "htmlCleaner");
        return new ParametersValidatorImpl(parametersValidatorResourceProvider, features, htmlRenderer, htmlCleaner);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SimpleRecyclerAdapter provideRecyclerAdapter(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final StrConfirmBookingViewModel provideStrConfirmBookingViewModel$short_term_rent_release(@NotNull Fragment fragment, @NotNull StrConfirmBookingViewModelFactory strConfirmBookingViewModelFactory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(strConfirmBookingViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of(fragment, strConfirmBookingViewModelFactory).get(StrConfirmBookingViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(fr…iewModelImpl::class.java)");
        return (StrConfirmBookingViewModel) viewModel;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final StrConfirmBookingViewModelFactory provideStrConfirmBookingViewModelFactory$short_term_rent_release(@NotNull StrConfirmBookingInteractorImpl strConfirmBookingInteractorImpl, @NotNull SchedulersFactory schedulersFactory, @AdvertId @NotNull String str, @CheckInDate @NotNull String str2, @CheckOutDate @NotNull String str3, @GuestsCount int i, @NotNull StrAnalyticsTracker strAnalyticsTracker, @NotNull CategoryParametersElementConverter categoryParametersElementConverter, @NotNull AttributedTextFormatter attributedTextFormatter, @NotNull StrConfirmBookingResourceProvider strConfirmBookingResourceProvider, @NotNull StrContactsTreeConverter strContactsTreeConverter, @NotNull NonFatalAnalyticsTracker nonFatalAnalyticsTracker) {
        Intrinsics.checkNotNullParameter(strConfirmBookingInteractorImpl, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "checkInDate");
        Intrinsics.checkNotNullParameter(str3, "checkOutDate");
        Intrinsics.checkNotNullParameter(strAnalyticsTracker, "analyticsTracker");
        Intrinsics.checkNotNullParameter(categoryParametersElementConverter, "elementConverter");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(strConfirmBookingResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(strContactsTreeConverter, "contactsTreeConverter");
        Intrinsics.checkNotNullParameter(nonFatalAnalyticsTracker, "nonFatalAnalyticsTracker");
        return new StrConfirmBookingViewModelFactory(strConfirmBookingInteractorImpl, schedulersFactory, str, str2, str3, i, strAnalyticsTracker, categoryParametersElementConverter, attributedTextFormatter, strConfirmBookingResourceProvider, strContactsTreeConverter, nonFatalAnalyticsTracker);
    }
}
