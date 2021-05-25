package com.avito.android.str_calendar.di.module;

import a2.b.a.a.a;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.Features;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.di.PerFragment;
import com.avito.android.di.module.InputItemFormatterProviderModule;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.provider.InputItemFormatterProvider;
import com.avito.android.server_time.TimeSource;
import com.avito.android.str_calendar.di.qualifier.AdvertId;
import com.avito.android.str_calendar.di.qualifier.EndDate;
import com.avito.android.str_calendar.di.qualifier.StartDate;
import com.avito.android.str_calendar.seller.edit.SellerBaseCalendarParametersViewModelFactory;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersConverter;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersConverterImpl;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersElementConverter;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersInteractor;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersInteractorImpl;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersViewModel;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersViewModelImpl;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParamsResourceProvider;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParamsResourceProviderImpl;
import com.avito.android.str_calendar.seller.edit.konveyor.chips.ChipsSelectItemBlueprint;
import com.avito.android.str_calendar.seller.edit.konveyor.chips.ChipsSelectItemPresenter;
import com.avito.android.str_calendar.seller.edit.konveyor.header.HeaderItemBlueprint;
import com.avito.android.str_calendar.seller.edit.konveyor.header.HeaderItemPresenter;
import com.avito.android.str_calendar.seller.edit.konveyor.input.RdsInputItemBlueprint;
import com.avito.android.str_calendar.seller.edit.konveyor.input.RdsInputItemPresenter;
import com.avito.android.str_calendar.seller.edit.konveyor.input.RdsInputItemPresenterImpl;
import com.avito.android.str_calendar.seller.edit.konveyor.radiogroup.RadioGroupSelectItemBlueprint;
import com.avito.android.str_calendar.seller.edit.konveyor.radiogroup.RadioGroupSelectItemPresenter;
import com.avito.android.util.Formatter;
import com.avito.android.util.PhoneNumberFormatterModule;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.validation.LocalPretendInteractor;
import com.avito.android.validation.LocalPretendInteractorImpl;
import com.avito.android.validation.ParametersValidator;
import com.avito.android.validation.ParametersValidatorImpl;
import com.avito.android.validation.ParametersValidatorResourceProvider;
import com.avito.android.validation.ParametersValidatorResourceProviderImpl;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001iB\t\b\u0002¢\u0006\u0004\bg\u0010hJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJQ\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u0017\u0010\u0018JO\u0010)\u001a\u00020(2\u000e\b\u0001\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&H\u0007¢\u0006\u0004\b)\u0010*J\u0017\u0010/\u001a\u00020,2\u0006\u0010+\u001a\u00020\u0006H\u0001¢\u0006\u0004\b-\u0010.J\u0017\u00104\u001a\u0002012\u0006\u00100\u001a\u00020,H\u0001¢\u0006\u0004\b2\u00103J\u0017\u00108\u001a\u0002052\u0006\u0010+\u001a\u00020\u0006H\u0001¢\u0006\u0004\b6\u00107J\u0017\u0010<\u001a\u0002092\u0006\u00100\u001a\u000205H\u0001¢\u0006\u0004\b:\u0010;J\u001f\u0010B\u001a\u00020?2\u0006\u0010+\u001a\u00020\u00062\u0006\u0010>\u001a\u00020=H\u0001¢\u0006\u0004\b@\u0010AJ\u0017\u0010F\u001a\u00020C2\u0006\u00100\u001a\u00020?H\u0001¢\u0006\u0004\bD\u0010EJ\u000f\u0010J\u001a\u00020GH\u0001¢\u0006\u0004\bH\u0010IJ\u0017\u0010N\u001a\u00020K2\u0006\u00100\u001a\u00020GH\u0001¢\u0006\u0004\bL\u0010MJ\u0017\u0010R\u001a\u00020Q2\u0006\u0010P\u001a\u00020OH\u0007¢\u0006\u0004\bR\u0010SJ/\u0010Z\u001a\u00020O2\u0006\u0010T\u001a\u0002012\u0006\u0010U\u001a\u0002092\u0006\u0010V\u001a\u00020C2\u0006\u0010W\u001a\u00020KH\u0001¢\u0006\u0004\bX\u0010YJ\u0017\u0010^\u001a\u00020]2\u0006\u0010\\\u001a\u00020[H\u0007¢\u0006\u0004\b^\u0010_J/\u0010c\u001a\u00020[2\u0006\u0010\u0016\u001a\u00020`2\u0006\u0010#\u001a\u00020\"2\u0006\u0010b\u001a\u00020a2\u0006\u0010%\u001a\u00020$H\u0007¢\u0006\u0004\bc\u0010dJ\u0017\u0010e\u001a\u00020`2\u0006\u0010!\u001a\u00020 H\u0007¢\u0006\u0004\be\u0010f¨\u0006j"}, d2 = {"Lcom/avito/android/str_calendar/di/module/StrSellerCalendarParametersModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/str_calendar/seller/edit/SellerBaseCalendarParametersViewModelFactory;", "viewModelFactory", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersViewModel;", "provideSellerBaseCalendarParametersViewModel$str_calendar_release", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/str_calendar/seller/edit/SellerBaseCalendarParametersViewModelFactory;)Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersViewModel;", "provideSellerBaseCalendarParametersViewModel", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersInteractor;", "sellerInteractor", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersConverter;", "parametersHandler", "Ljava/util/Date;", "startDate", "endDate", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParamsResourceProvider;", "resourceProvider", "provideSellerBaseCalendarParametersViewModelFactory$str_calendar_release", "(Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersInteractor;Lcom/avito/android/util/SchedulersFactory;Ljava/lang/String;Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersConverter;Ljava/util/Date;Ljava/util/Date;Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParamsResourceProvider;)Lcom/avito/android/str_calendar/seller/edit/SellerBaseCalendarParametersViewModelFactory;", "provideSellerBaseCalendarParametersViewModelFactory", "Lcom/avito/android/util/Formatter;", "phoneNumberTextWatcher", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/util/Locale;", "locale", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/html_formatter/HtmlCleaner;", "htmlCleaner", "Lcom/avito/android/html_formatter/HtmlNodeFactory;", "htmlNodeFactory", "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "provideCategoryParametersElementConverter", "(Lcom/avito/android/util/Formatter;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;Landroid/content/res/Resources;Lcom/avito/android/Features;Lcom/avito/android/html_formatter/HtmlCleaner;Lcom/avito/android/html_formatter/HtmlNodeFactory;)Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "viewModel", "Lcom/avito/android/str_calendar/seller/edit/konveyor/chips/ChipsSelectItemPresenter;", "provideChipsSelectItemPresenter$str_calendar_release", "(Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersViewModel;)Lcom/avito/android/str_calendar/seller/edit/konveyor/chips/ChipsSelectItemPresenter;", "provideChipsSelectItemPresenter", "presenter", "Lcom/avito/android/str_calendar/seller/edit/konveyor/chips/ChipsSelectItemBlueprint;", "provideChipsSelectItemBlueprint$str_calendar_release", "(Lcom/avito/android/str_calendar/seller/edit/konveyor/chips/ChipsSelectItemPresenter;)Lcom/avito/android/str_calendar/seller/edit/konveyor/chips/ChipsSelectItemBlueprint;", "provideChipsSelectItemBlueprint", "Lcom/avito/android/str_calendar/seller/edit/konveyor/radiogroup/RadioGroupSelectItemPresenter;", "provideRadioGroupSelectItemPresenter$str_calendar_release", "(Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersViewModel;)Lcom/avito/android/str_calendar/seller/edit/konveyor/radiogroup/RadioGroupSelectItemPresenter;", "provideRadioGroupSelectItemPresenter", "Lcom/avito/android/str_calendar/seller/edit/konveyor/radiogroup/RadioGroupSelectItemBlueprint;", "provideRadioGroupSelectItemBlueprint$str_calendar_release", "(Lcom/avito/android/str_calendar/seller/edit/konveyor/radiogroup/RadioGroupSelectItemPresenter;)Lcom/avito/android/str_calendar/seller/edit/konveyor/radiogroup/RadioGroupSelectItemBlueprint;", "provideRadioGroupSelectItemBlueprint", "Lcom/avito/android/provider/InputItemFormatterProvider;", "formatterProvider", "Lcom/avito/android/str_calendar/seller/edit/konveyor/input/RdsInputItemPresenter;", "provideRdsInputItemPresenter$str_calendar_release", "(Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersViewModel;Lcom/avito/android/provider/InputItemFormatterProvider;)Lcom/avito/android/str_calendar/seller/edit/konveyor/input/RdsInputItemPresenter;", "provideRdsInputItemPresenter", "Lcom/avito/android/str_calendar/seller/edit/konveyor/input/RdsInputItemBlueprint;", "provideRdsInputItemBlueprint$str_calendar_release", "(Lcom/avito/android/str_calendar/seller/edit/konveyor/input/RdsInputItemPresenter;)Lcom/avito/android/str_calendar/seller/edit/konveyor/input/RdsInputItemBlueprint;", "provideRdsInputItemBlueprint", "Lcom/avito/android/str_calendar/seller/edit/konveyor/header/HeaderItemPresenter;", "provideHeaderItemPresenter$str_calendar_release", "()Lcom/avito/android/str_calendar/seller/edit/konveyor/header/HeaderItemPresenter;", "provideHeaderItemPresenter", "Lcom/avito/android/str_calendar/seller/edit/konveyor/header/HeaderItemBlueprint;", "provideHeaderItemBlueprint$str_calendar_release", "(Lcom/avito/android/str_calendar/seller/edit/konveyor/header/HeaderItemPresenter;)Lcom/avito/android/str_calendar/seller/edit/konveyor/header/HeaderItemBlueprint;", "provideHeaderItemBlueprint", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "chipsSelectItemBlueprint", "radioGroupSelectItemBlueprint", "inputItemBlueprint", "headerItemBlueprint", "provideItemBinder$str_calendar_release", "(Lcom/avito/android/str_calendar/seller/edit/konveyor/chips/ChipsSelectItemBlueprint;Lcom/avito/android/str_calendar/seller/edit/konveyor/radiogroup/RadioGroupSelectItemBlueprint;Lcom/avito/android/str_calendar/seller/edit/konveyor/input/RdsInputItemBlueprint;Lcom/avito/android/str_calendar/seller/edit/konveyor/header/HeaderItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "Lcom/avito/android/validation/ParametersValidator;", "validator", "Lcom/avito/android/validation/LocalPretendInteractor;", "provideLocalPretendInteractor", "(Lcom/avito/android/validation/ParametersValidator;)Lcom/avito/android/validation/LocalPretendInteractor;", "Lcom/avito/android/validation/ParametersValidatorResourceProvider;", "Lcom/avito/android/html_formatter/HtmlRenderer;", "htmlRenderer", "provideParametersValidator", "(Lcom/avito/android/validation/ParametersValidatorResourceProvider;Lcom/avito/android/Features;Lcom/avito/android/html_formatter/HtmlRenderer;Lcom/avito/android/html_formatter/HtmlCleaner;)Lcom/avito/android/validation/ParametersValidator;", "provideLocalPretendInteractorResourceProvider", "(Landroid/content/res/Resources;)Lcom/avito/android/validation/ParametersValidatorResourceProvider;", "<init>", "()V", "Dependencies", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {PhoneNumberFormatterModule.class, Dependencies.class, InputItemFormatterProviderModule.class})
public final class StrSellerCalendarParametersModule {
    @NotNull
    public static final StrSellerCalendarParametersModule INSTANCE = new StrSellerCalendarParametersModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/str_calendar/di/module/StrSellerCalendarParametersModule$Dependencies;", "", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersInteractorImpl;", "interactor", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersInteractor;", "bindsSellerBaseCalendarParametersInteractor", "(Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersInteractorImpl;)Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersInteractor;", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersConverterImpl;", "parametersHandler", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersConverter;", "bindsParametersConverter", "(Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersConverterImpl;)Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersConverter;", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParamsResourceProviderImpl;", "resourceProvider", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParamsResourceProvider;", "bindsSellerCalendarParamsResourceProvider", "(Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParamsResourceProviderImpl;)Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParamsResourceProvider;", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        SellerCalendarParametersConverter bindsParametersConverter(@NotNull SellerCalendarParametersConverterImpl sellerCalendarParametersConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        SellerCalendarParametersInteractor bindsSellerBaseCalendarParametersInteractor(@NotNull SellerCalendarParametersInteractorImpl sellerCalendarParametersInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        SellerCalendarParamsResourceProvider bindsSellerCalendarParamsResourceProvider(@NotNull SellerCalendarParamsResourceProviderImpl sellerCalendarParamsResourceProviderImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final AdapterPresenter provideAdapterPresenter(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final CategoryParametersElementConverter provideCategoryParametersElementConverter(@PhoneNumberFormatterModule.PhoneNumberFormatter @NotNull Formatter<String> formatter, @NotNull TimeSource timeSource, @NotNull Locale locale, @NotNull Resources resources, @NotNull Features features, @NotNull HtmlCleaner htmlCleaner, @NotNull HtmlNodeFactory htmlNodeFactory) {
        Intrinsics.checkNotNullParameter(formatter, "phoneNumberTextWatcher");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(htmlCleaner, "htmlCleaner");
        Intrinsics.checkNotNullParameter(htmlNodeFactory, "htmlNodeFactory");
        return new SellerCalendarParametersElementConverter(formatter, resources, timeSource, true, false, locale, features, htmlCleaner, htmlNodeFactory, 16, null);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ChipsSelectItemBlueprint provideChipsSelectItemBlueprint$str_calendar_release(@NotNull ChipsSelectItemPresenter chipsSelectItemPresenter) {
        Intrinsics.checkNotNullParameter(chipsSelectItemPresenter, "presenter");
        return new ChipsSelectItemBlueprint(chipsSelectItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ChipsSelectItemPresenter provideChipsSelectItemPresenter$str_calendar_release(@NotNull SellerCalendarParametersViewModel sellerCalendarParametersViewModel) {
        Intrinsics.checkNotNullParameter(sellerCalendarParametersViewModel, "viewModel");
        return new ChipsSelectItemPresenter(sellerCalendarParametersViewModel.getChipsSelectConsumer(), null, 2, null);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final HeaderItemBlueprint provideHeaderItemBlueprint$str_calendar_release(@NotNull HeaderItemPresenter headerItemPresenter) {
        Intrinsics.checkNotNullParameter(headerItemPresenter, "presenter");
        return new HeaderItemBlueprint(headerItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final HeaderItemPresenter provideHeaderItemPresenter$str_calendar_release() {
        return new HeaderItemPresenter();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemBinder provideItemBinder$str_calendar_release(@NotNull ChipsSelectItemBlueprint chipsSelectItemBlueprint, @NotNull RadioGroupSelectItemBlueprint radioGroupSelectItemBlueprint, @NotNull RdsInputItemBlueprint rdsInputItemBlueprint, @NotNull HeaderItemBlueprint headerItemBlueprint) {
        Intrinsics.checkNotNullParameter(chipsSelectItemBlueprint, "chipsSelectItemBlueprint");
        Intrinsics.checkNotNullParameter(radioGroupSelectItemBlueprint, "radioGroupSelectItemBlueprint");
        Intrinsics.checkNotNullParameter(rdsInputItemBlueprint, "inputItemBlueprint");
        Intrinsics.checkNotNullParameter(headerItemBlueprint, "headerItemBlueprint");
        return new ItemBinder.Builder().registerItem(chipsSelectItemBlueprint).registerItem(radioGroupSelectItemBlueprint).registerItem(rdsInputItemBlueprint).registerItem(headerItemBlueprint).build();
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
    public static final RadioGroupSelectItemBlueprint provideRadioGroupSelectItemBlueprint$str_calendar_release(@NotNull RadioGroupSelectItemPresenter radioGroupSelectItemPresenter) {
        Intrinsics.checkNotNullParameter(radioGroupSelectItemPresenter, "presenter");
        return new RadioGroupSelectItemBlueprint(radioGroupSelectItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final RadioGroupSelectItemPresenter provideRadioGroupSelectItemPresenter$str_calendar_release(@NotNull SellerCalendarParametersViewModel sellerCalendarParametersViewModel) {
        Intrinsics.checkNotNullParameter(sellerCalendarParametersViewModel, "viewModel");
        return new RadioGroupSelectItemPresenter(sellerCalendarParametersViewModel.getRadioGroupSelectConsumer(), null, 2, null);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final RdsInputItemBlueprint provideRdsInputItemBlueprint$str_calendar_release(@NotNull RdsInputItemPresenter rdsInputItemPresenter) {
        Intrinsics.checkNotNullParameter(rdsInputItemPresenter, "presenter");
        return new RdsInputItemBlueprint(rdsInputItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final RdsInputItemPresenter provideRdsInputItemPresenter$str_calendar_release(@NotNull SellerCalendarParametersViewModel sellerCalendarParametersViewModel, @NotNull InputItemFormatterProvider inputItemFormatterProvider) {
        Intrinsics.checkNotNullParameter(sellerCalendarParametersViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(inputItemFormatterProvider, "formatterProvider");
        return new RdsInputItemPresenterImpl(sellerCalendarParametersViewModel.getChangeConsumer(), inputItemFormatterProvider);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SellerCalendarParametersViewModel provideSellerBaseCalendarParametersViewModel$str_calendar_release(@NotNull Fragment fragment, @NotNull SellerBaseCalendarParametersViewModelFactory sellerBaseCalendarParametersViewModelFactory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(sellerBaseCalendarParametersViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of(fragment, sellerBaseCalendarParametersViewModelFactory).get(SellerCalendarParametersViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(fr…iewModelImpl::class.java)");
        return (SellerCalendarParametersViewModel) viewModel;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SellerBaseCalendarParametersViewModelFactory provideSellerBaseCalendarParametersViewModelFactory$str_calendar_release(@NotNull SellerCalendarParametersInteractor sellerCalendarParametersInteractor, @NotNull SchedulersFactory schedulersFactory, @AdvertId @NotNull String str, @NotNull SellerCalendarParametersConverter sellerCalendarParametersConverter, @StartDate @Nullable Date date, @EndDate @Nullable Date date2, @NotNull SellerCalendarParamsResourceProvider sellerCalendarParamsResourceProvider) {
        Intrinsics.checkNotNullParameter(sellerCalendarParametersInteractor, "sellerInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(sellerCalendarParametersConverter, "parametersHandler");
        Intrinsics.checkNotNullParameter(sellerCalendarParamsResourceProvider, "resourceProvider");
        return new SellerBaseCalendarParametersViewModelFactory(sellerCalendarParametersInteractor, schedulersFactory, str, sellerCalendarParametersConverter, date, date2, sellerCalendarParamsResourceProvider);
    }
}
