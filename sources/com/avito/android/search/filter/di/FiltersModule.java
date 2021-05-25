package com.avito.android.search.filter.di;

import android.content.res.Resources;
import com.avito.android.Features;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.di.PerFragment;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.permissions.LocationPermissionDialogPresenterImpl;
import com.avito.android.permissions.LocationPermissionProvider;
import com.avito.android.permissions.LocationPermissionProviderImpl;
import com.avito.android.search.filter.FiltersPresenter;
import com.avito.android.search.filter.FiltersPresenterImpl;
import com.avito.android.search.filter.adapter.InputItemBlueprint;
import com.avito.android.search.filter.adapter.InputItemView;
import com.avito.android.search.filter.adapter.MultiselectItemBlueprint;
import com.avito.android.search.filter.adapter.SelectItemBlueprint;
import com.avito.android.search.filter.adapter.SelectItemView;
import com.avito.android.select.new_metro.di.SelectMetroBaseModule;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Formatter;
import com.avito.android.util.PhoneNumberFormatterModule;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\bÇ\u0002\u0018\u00002\u00020\u0001:\b\u001f !\"#$%&B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJY\u0010\u0016\u001a\u00020\u00132\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006'"}, d2 = {"Lcom/avito/android/search/filter/di/FiltersModule;", "", "Lcom/avito/android/util/Formatter;", "", "phoneNumberFormatter", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/util/Locale;", "locale", "Lcom/avito/android/Features;", "features", "", "isOnlySortShown", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/html_formatter/HtmlCleaner;", "htmlCleaner", "Lcom/avito/android/html_formatter/HtmlNodeFactory;", "htmlNodeFactory", "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "provideCategoryParametersElementConverter$filter_release", "(Lcom/avito/android/util/Formatter;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;Lcom/avito/android/Features;ZLandroid/content/res/Resources;Lcom/avito/android/html_formatter/HtmlCleaner;Lcom/avito/android/html_formatter/HtmlNodeFactory;)Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "provideCategoryParametersElementConverter", "Lcom/avito/android/permissions/LocationPermissionProvider;", GeoContract.PROVIDER, "Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "provideLocationPermissionDialogPresenter$filter_release", "(Lcom/avito/android/permissions/LocationPermissionProvider;)Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "provideLocationPermissionDialogPresenter", "<init>", "()V", "BubblePresenterState", "Declarations", "InteractorState", "IsFirstStart", "IsOnlySortShown", "MapSerpState", "PresenterState", "ShowSimpleMap", "filter_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {FiltersCoreModule.class, Declarations.class, SelectMetroBaseModule.class})
public final class FiltersModule {
    @NotNull
    public static final FiltersModule INSTANCE = new FiltersModule();

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/filter/di/FiltersModule$BubblePresenterState;", "", "<init>", "()V", "filter_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface BubblePresenterState {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u000e2\u0006\u0010\r\u001a\u00020\u0013H'¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00190\u000e2\u0006\u0010\r\u001a\u00020\u0018H'¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/avito/android/search/filter/di/FiltersModule$Declarations;", "", "Lcom/avito/android/permissions/LocationPermissionProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/permissions/LocationPermissionProvider;", "bindsLocationPermissionProvider", "(Lcom/avito/android/permissions/LocationPermissionProviderImpl;)Lcom/avito/android/permissions/LocationPermissionProvider;", "Lcom/avito/android/search/filter/FiltersPresenterImpl;", "presenter", "Lcom/avito/android/search/filter/FiltersPresenter;", "bindFiltersPresenter", "(Lcom/avito/android/search/filter/FiltersPresenterImpl;)Lcom/avito/android/search/filter/FiltersPresenter;", "Lcom/avito/android/search/filter/adapter/SelectItemBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/search/filter/adapter/SelectItemView;", "Lcom/avito/android/category_parameters/ParameterElement$Select;", "bindSelectItemBlueprint", "(Lcom/avito/android/search/filter/adapter/SelectItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/search/filter/adapter/InputItemBlueprint;", "Lcom/avito/android/search/filter/adapter/InputItemView;", "Lcom/avito/android/category_parameters/ParameterElement$Input;", "bindInputItemBlueprint", "(Lcom/avito/android/search/filter/adapter/InputItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/search/filter/adapter/MultiselectItemBlueprint;", "Lcom/avito/android/category_parameters/ParameterElement$Multiselect;", "bindMultiselectItemBlueprint", "(Lcom/avito/android/search/filter/adapter/MultiselectItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "filter_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        FiltersPresenter bindFiltersPresenter(@NotNull FiltersPresenterImpl filtersPresenterImpl);

        @Binds
        @NotNull
        @PerFragment
        ItemBlueprint<InputItemView, ParameterElement.Input> bindInputItemBlueprint(@NotNull InputItemBlueprint inputItemBlueprint);

        @Binds
        @NotNull
        @PerFragment
        ItemBlueprint<SelectItemView, ParameterElement.Multiselect> bindMultiselectItemBlueprint(@NotNull MultiselectItemBlueprint multiselectItemBlueprint);

        @Binds
        @NotNull
        @PerFragment
        ItemBlueprint<SelectItemView, ParameterElement.Select> bindSelectItemBlueprint(@NotNull SelectItemBlueprint selectItemBlueprint);

        @PerFragment
        @Binds
        @NotNull
        LocationPermissionProvider bindsLocationPermissionProvider(@NotNull LocationPermissionProviderImpl locationPermissionProviderImpl);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/filter/di/FiltersModule$InteractorState;", "", "<init>", "()V", "filter_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface InteractorState {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/filter/di/FiltersModule$IsFirstStart;", "", "<init>", "()V", "filter_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface IsFirstStart {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/filter/di/FiltersModule$IsOnlySortShown;", "", "<init>", "()V", "filter_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface IsOnlySortShown {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/filter/di/FiltersModule$MapSerpState;", "", "<init>", "()V", "filter_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface MapSerpState {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/filter/di/FiltersModule$PresenterState;", "", "<init>", "()V", "filter_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface PresenterState {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/filter/di/FiltersModule$ShowSimpleMap;", "", "<init>", "()V", "filter_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface ShowSimpleMap {
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final CategoryParametersElementConverter provideCategoryParametersElementConverter$filter_release(@PhoneNumberFormatterModule.PhoneNumberFormatter @NotNull Formatter<String> formatter, @NotNull TimeSource timeSource, @NotNull Locale locale, @NotNull Features features, @IsOnlySortShown boolean z, @NotNull Resources resources, @NotNull HtmlCleaner htmlCleaner, @NotNull HtmlNodeFactory htmlNodeFactory) {
        Intrinsics.checkNotNullParameter(formatter, "phoneNumberFormatter");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(htmlCleaner, "htmlCleaner");
        Intrinsics.checkNotNullParameter(htmlNodeFactory, "htmlNodeFactory");
        return new CategoryParametersElementConverter(formatter, resources, timeSource, false, features.getStrDatesSearch().invoke().booleanValue(), locale, z, false, false, false, htmlNodeFactory, htmlCleaner, features, 904, null);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final LocationPermissionDialogPresenter provideLocationPermissionDialogPresenter$filter_release(@NotNull LocationPermissionProvider locationPermissionProvider) {
        Intrinsics.checkNotNullParameter(locationPermissionProvider, GeoContract.PROVIDER);
        return new LocationPermissionDialogPresenterImpl(locationPermissionProvider);
    }
}
