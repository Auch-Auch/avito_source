package com.avito.android.publish.input_vin.di;

import android.content.res.Resources;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.Features;
import com.avito.android.analytics.PublishValidationLogger;
import com.avito.android.blueprints.input.MultiStateInputItemBlueprint;
import com.avito.android.blueprints.input.MultiStateInputItemPresenter;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.di.PerFragment;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.progress_overlay.LoadingProgressOverlay;
import com.avito.android.progress_overlay.LoadingProgressOverlayImpl;
import com.avito.android.publish.PublishParametersInteractor;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.di.PublishInputAnalyticsModule;
import com.avito.android.publish.di.PublishParametersModule;
import com.avito.android.publish.input_vin.InputVinResourceProvider;
import com.avito.android.publish.input_vin.InputVinViewModelFactory;
import com.avito.android.publish.input_vin.items.divider.DividerWithTextBlueprint;
import com.avito.android.publish.input_vin.items.divider.DividerWithTextPresenter;
import com.avito.android.publish.input_vin.items.divider.DividerWithTextPresenterImpl;
import com.avito.android.publish.input_vin.items.scan_button.ScanVinButtonBlueprint;
import com.avito.android.publish.input_vin.items.scan_button.ScanVinButtonItemPresenter;
import com.avito.android.publish.input_vin.items.scan_button.ScanVinButtonItemPresenterImpl;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Formatter;
import com.avito.android.util.PhoneNumberFormatterModule;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatterModule;
import com.avito.android.validation.ParametersListModule;
import com.avito.android.validation.ValidationLogger;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u00013B\t\b\u0002¢\u0006\u0004\b1\u00102J7\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJO\u0010\u001e\u001a\u00020\u00042\u000e\b\u0001\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ*\u0010%\u001a\u00020$2\u0019\u0010#\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030!¢\u0006\u0002\b\"0 H\u0007¢\u0006\u0004\b%\u0010&J2\u0010,\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030+¢\u0006\u0002\b\"0 2\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)H\u0007¢\u0006\u0004\b,\u0010-J\u0011\u0010/\u001a\u0004\u0018\u00010.H\u0007¢\u0006\u0004\b/\u00100¨\u00064"}, d2 = {"Lcom/avito/android/publish/input_vin/di/InputVinModule;", "", "Lcom/avito/android/publish/PublishParametersInteractor;", "publishParametersInteractor", "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "elementConverter", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "publishEventTracker", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/publish/input_vin/InputVinResourceProvider;", "resourceProvider", "Lcom/avito/android/publish/input_vin/InputVinViewModelFactory;", "provideInputVinViewModelFactory", "(Lcom/avito/android/publish/PublishParametersInteractor;Lcom/avito/android/category_parameters/CategoryParametersElementConverter;Lcom/avito/android/publish/analytics/PublishEventTracker;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/publish/input_vin/InputVinResourceProvider;)Lcom/avito/android/publish/input_vin/InputVinViewModelFactory;", "Lcom/avito/android/util/Formatter;", "", "phoneFormatter", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Landroid/content/res/Resources;", "resources", "Ljava/util/Locale;", "locale", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/html_formatter/HtmlCleaner;", "htmlCleaner", "Lcom/avito/android/html_formatter/HtmlNodeFactory;", "htmlNodeFactory", "provideCategoryParametersElementConverter", "(Lcom/avito/android/util/Formatter;Lcom/avito/android/server_time/TimeSource;Landroid/content/res/Resources;Ljava/util/Locale;Lcom/avito/android/Features;Lcom/avito/android/html_formatter/HtmlCleaner;Lcom/avito/android/html_formatter/HtmlNodeFactory;)Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lkotlin/jvm/JvmSuppressWildcards;", "blueprints", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "(Ljava/util/Set;)Lcom/avito/konveyor/ItemBinder;", "Lcom/avito/android/publish/input_vin/items/scan_button/ScanVinButtonItemPresenter;", "scanVinButtonItemPresenter", "Lcom/avito/android/blueprints/input/MultiStateInputItemPresenter;", "multistateInputItemPresenter", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "provideItemPresentersSet", "(Lcom/avito/android/publish/input_vin/items/scan_button/ScanVinButtonItemPresenter;Lcom/avito/android/blueprints/input/MultiStateInputItemPresenter;)Ljava/util/Set;", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel;", "provideHtmlEditorViewModel", "()Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel;", "<init>", "()V", "Declarations", "publish_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {PublishParametersModule.class, PhoneNumberFormatterModule.class, ParametersListModule.class, AttributedTextFormatterModule.class, PublishInputAnalyticsModule.class, Declarations.class})
public final class InputVinModule {
    @NotNull
    public static final InputVinModule INSTANCE = new InputVinModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\b\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H'¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H'¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u001eH'¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020#2\u0006\u0010\u0015\u001a\u00020\"H'¢\u0006\u0004\b$\u0010%J\u001f\u0010'\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020&H'¢\u0006\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/avito/android/publish/input_vin/di/InputVinModule$Declarations;", "", "Lcom/avito/android/blueprints/input/MultiStateInputItemBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindInputBlueprint", "(Lcom/avito/android/blueprints/input/MultiStateInputItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/publish/input_vin/items/scan_button/ScanVinButtonBlueprint;", "provideInputVinItemBlueprint", "(Lcom/avito/android/publish/input_vin/items/scan_button/ScanVinButtonBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/analytics/PublishValidationLogger;", "logger", "Lcom/avito/android/validation/ValidationLogger;", "provideValidationLogger", "(Lcom/avito/android/analytics/PublishValidationLogger;)Lcom/avito/android/validation/ValidationLogger;", "Lcom/avito/android/progress_overlay/LoadingProgressOverlayImpl;", "dialogOverlay", "Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "provideLoadingProgressOverlay", "(Lcom/avito/android/progress_overlay/LoadingProgressOverlayImpl;)Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;", "presenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "(Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "provideAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/android/publish/input_vin/items/scan_button/ScanVinButtonItemPresenterImpl;", "Lcom/avito/android/publish/input_vin/items/scan_button/ScanVinButtonItemPresenter;", "provideScanVinButtonItemPresenter", "(Lcom/avito/android/publish/input_vin/items/scan_button/ScanVinButtonItemPresenterImpl;)Lcom/avito/android/publish/input_vin/items/scan_button/ScanVinButtonItemPresenter;", "Lcom/avito/android/publish/input_vin/items/divider/DividerWithTextPresenterImpl;", "Lcom/avito/android/publish/input_vin/items/divider/DividerWithTextPresenter;", "bindDividerPresenter", "(Lcom/avito/android/publish/input_vin/items/divider/DividerWithTextPresenterImpl;)Lcom/avito/android/publish/input_vin/items/divider/DividerWithTextPresenter;", "Lcom/avito/android/publish/input_vin/items/divider/DividerWithTextBlueprint;", "bindDividerBlueprint", "(Lcom/avito/android/publish/input_vin/items/divider/DividerWithTextBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "publish_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @IntoSet
        @NotNull
        ItemBlueprint<?, ?> bindDividerBlueprint(@NotNull DividerWithTextBlueprint dividerWithTextBlueprint);

        @PerFragment
        @Binds
        @NotNull
        DividerWithTextPresenter bindDividerPresenter(@NotNull DividerWithTextPresenterImpl dividerWithTextPresenterImpl);

        @Binds
        @IntoSet
        @NotNull
        ItemBlueprint<?, ?> bindInputBlueprint(@NotNull MultiStateInputItemBlueprint multiStateInputItemBlueprint);

        @Binds
        @NotNull
        @PerFragment
        RecyclerView.Adapter<?> provideAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter);

        @PerFragment
        @Binds
        @NotNull
        AdapterPresenter provideAdapterPresenter(@NotNull SimpleAdapterPresenter simpleAdapterPresenter);

        @Binds
        @IntoSet
        @NotNull
        ItemBlueprint<?, ?> provideInputVinItemBlueprint(@NotNull ScanVinButtonBlueprint scanVinButtonBlueprint);

        @PerFragment
        @Binds
        @NotNull
        LoadingProgressOverlay provideLoadingProgressOverlay(@NotNull LoadingProgressOverlayImpl loadingProgressOverlayImpl);

        @PerFragment
        @Binds
        @NotNull
        ScanVinButtonItemPresenter provideScanVinButtonItemPresenter(@NotNull ScanVinButtonItemPresenterImpl scanVinButtonItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        ValidationLogger provideValidationLogger(@NotNull PublishValidationLogger publishValidationLogger);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final CategoryParametersElementConverter provideCategoryParametersElementConverter(@PhoneNumberFormatterModule.PhoneNumberFormatterWithCountryCode @NotNull Formatter<String> formatter, @NotNull TimeSource timeSource, @NotNull Resources resources, @NotNull Locale locale, @NotNull Features features, @NotNull HtmlCleaner htmlCleaner, @NotNull HtmlNodeFactory htmlNodeFactory) {
        Intrinsics.checkNotNullParameter(formatter, "phoneFormatter");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(htmlCleaner, "htmlCleaner");
        Intrinsics.checkNotNullParameter(htmlNodeFactory, "htmlNodeFactory");
        return new CategoryParametersElementConverter(formatter, resources, timeSource, false, false, locale, false, true, false, false, htmlNodeFactory, htmlCleaner, features, 856, null);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final InputVinViewModelFactory provideInputVinViewModelFactory(@NotNull PublishParametersInteractor publishParametersInteractor, @NotNull CategoryParametersElementConverter categoryParametersElementConverter, @NotNull PublishEventTracker publishEventTracker, @NotNull SchedulersFactory schedulersFactory, @NotNull InputVinResourceProvider inputVinResourceProvider) {
        Intrinsics.checkNotNullParameter(publishParametersInteractor, "publishParametersInteractor");
        Intrinsics.checkNotNullParameter(categoryParametersElementConverter, "elementConverter");
        Intrinsics.checkNotNullParameter(publishEventTracker, "publishEventTracker");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(inputVinResourceProvider, "resourceProvider");
        return new InputVinViewModelFactory(publishParametersInteractor, categoryParametersElementConverter, publishEventTracker, schedulersFactory, inputVinResourceProvider);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemBinder provideItemBinder(@NotNull Set<ItemBlueprint<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "blueprints");
        ItemBinder.Builder builder = new ItemBinder.Builder();
        for (ItemBlueprint<?, ?> itemBlueprint : set) {
            builder.registerItem(itemBlueprint);
        }
        return builder.build();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final Set<ItemPresenter<?, ?>> provideItemPresentersSet(@NotNull ScanVinButtonItemPresenter scanVinButtonItemPresenter, @NotNull MultiStateInputItemPresenter multiStateInputItemPresenter) {
        Intrinsics.checkNotNullParameter(scanVinButtonItemPresenter, "scanVinButtonItemPresenter");
        Intrinsics.checkNotNullParameter(multiStateInputItemPresenter, "multistateInputItemPresenter");
        return y.setOf((Object[]) new ItemPresenter[]{scanVinButtonItemPresenter, multiStateInputItemPresenter});
    }

    @Provides
    @PerFragment
    @Nullable
    public final HtmlEditorViewModel provideHtmlEditorViewModel() {
        return null;
    }
}
