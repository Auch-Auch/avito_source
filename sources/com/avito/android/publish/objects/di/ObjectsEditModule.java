package com.avito.android.publish.objects.di;

import android.content.res.Resources;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.Features;
import com.avito.android.analytics.PublishValidationLogger;
import com.avito.android.blueprints.chips.ChipsSelectItemBlueprint;
import com.avito.android.blueprints.chips.ChipsSelectItemPresenter;
import com.avito.android.blueprints.chips_multiselect.ChipsMultiselectItemBlueprint;
import com.avito.android.blueprints.chips_multiselect.ChipsMultiselectItemPresenter;
import com.avito.android.blueprints.input.MultiStateInputItemBlueprint;
import com.avito.android.blueprints.input.MultiStateInputItemPresenter;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel;
import com.avito.android.blueprints.radiogroup.RadioGroupSelectItemBlueprint;
import com.avito.android.blueprints.radiogroup.RadioGroupSelectItemPresenter;
import com.avito.android.blueprints.select.MultiStateSelectItemBlueprint;
import com.avito.android.blueprints.select.MultiStateSelectItemPresenter;
import com.avito.android.blueprints.select.MultiStateSelectItemPresenterImpl;
import com.avito.android.blueprints.switcher.MultiStateSwitcherItemBlueprint;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.di.DialogRouterModule;
import com.avito.android.di.PerFragment;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.item_legacy.details.ItemDetailsSelectResultHandler;
import com.avito.android.publish.details.adapter.date_interval.DateIntervalItemBlueprint;
import com.avito.android.publish.details.adapter.date_interval.DateIntervalItemPresenter;
import com.avito.android.publish.details.adapter.date_interval.DateIntervalItemPresenterImpl;
import com.avito.android.publish.objects.ObjectsEditInteractor;
import com.avito.android.publish.objects.ObjectsEditInteractorImpl;
import com.avito.android.publish.objects.ObjectsEditPresenter;
import com.avito.android.publish.objects.ObjectsEditPresenterImpl;
import com.avito.android.publish.objects.blueprints.DeleteObjectButtonBlueprint;
import com.avito.android.publish.objects.blueprints.DeleteObjectButtonItemPresenter;
import com.avito.android.publish.objects.blueprints.DeleteObjectButtonItemPresenterImpl;
import com.avito.android.publish.view.BasicParameterClickListener;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.remote.model.category_parameters.ObjectsParameter;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Formatter;
import com.avito.android.util.PhoneNumberFormatterModule;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatterModule;
import com.avito.android.validation.ParametersListModule;
import com.avito.android.validation.ParametersListPresenter;
import com.avito.android.validation.ValidationLogger;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001TB\t\b\u0002¢\u0006\u0004\bR\u0010SJ|\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0019\u0010\u0019\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0017¢\u0006\u0002\b\u00180\u0016H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJO\u0010(\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u000e\b\u0001\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&H\u0007¢\u0006\u0004\b(\u0010)J\u001b\u0010-\u001a\u0006\u0012\u0002\b\u00030,2\u0006\u0010+\u001a\u00020*H\u0007¢\u0006\u0004\b-\u0010.JR\u0010<\u001a\u00020;2\u0019\u00100\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030/¢\u0006\u0002\b\u00180\u00162\u0006\u00102\u001a\u0002012\u0006\u00104\u001a\u0002032\u0006\u00106\u001a\u0002052\u0006\u00108\u001a\u0002072\u0006\u0010:\u001a\u000209H\u0007¢\u0006\u0004\b<\u0010=JZ\u0010N\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0017¢\u0006\u0002\b\u00180\u00162\u0006\u0010?\u001a\u00020>2\u0006\u0010A\u001a\u00020@2\u0006\u0010C\u001a\u00020B2\u0006\u0010E\u001a\u00020D2\u0006\u0010G\u001a\u00020F2\u0006\u0010I\u001a\u00020H2\u0006\u0010K\u001a\u00020JH\u0001¢\u0006\u0004\bL\u0010MJ\u0011\u0010P\u001a\u0004\u0018\u00010OH\u0007¢\u0006\u0004\bP\u0010Q¨\u0006U"}, d2 = {"Lcom/avito/android/publish/objects/di/ObjectsEditModule;", "", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;", "parameter", "Lcom/avito/android/publish/objects/ObjectsEditInteractor;", "interactor", "Lcom/avito/android/publish/view/BasicParameterClickListener;", "clickListener", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/validation/ParametersListPresenter;", "parametersListPresenter", "Lcom/avito/android/item_legacy/details/ItemDetailsSelectResultHandler;", "resultHandler", "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "categoryParametersElementConverter", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Ljava/util/Locale;", "locale", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresentersSet", "Lcom/avito/android/publish/objects/ObjectsEditPresenter;", "providePresenter", "(Landroid/content/res/Resources;Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;Lcom/avito/android/publish/objects/ObjectsEditInteractor;Lcom/avito/android/publish/view/BasicParameterClickListener;Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;Lcom/avito/android/validation/ParametersListPresenter;Lcom/avito/android/item_legacy/details/ItemDetailsSelectResultHandler;Lcom/avito/android/category_parameters/CategoryParametersElementConverter;Lcom/avito/android/util/SchedulersFactory;Ljava/util/Locale;Ljava/util/Set;)Lcom/avito/android/publish/objects/ObjectsEditPresenter;", "Lcom/avito/android/util/Formatter;", "", "phoneFormatter", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/html_formatter/HtmlCleaner;", "htmlCleaner", "Lcom/avito/android/html_formatter/HtmlNodeFactory;", "htmlNodeFactory", "provideCategoryParametersElementConverter", "(Landroid/content/res/Resources;Lcom/avito/android/util/Formatter;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/Features;Ljava/util/Locale;Lcom/avito/android/html_formatter/HtmlCleaner;Lcom/avito/android/html_formatter/HtmlNodeFactory;)Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "provideAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "blueprints", "Lcom/avito/android/blueprints/switcher/MultiStateSwitcherItemBlueprint;", "multiStateSwitcherItemBlueprint", "Lcom/avito/android/blueprints/input/MultiStateInputItemBlueprint;", "multiStateInputItemBlueprint", "Lcom/avito/android/blueprints/chips/ChipsSelectItemBlueprint;", "chipsSelectItemBlueprint", "Lcom/avito/android/blueprints/chips_multiselect/ChipsMultiselectItemBlueprint;", "chipsMultiselectItemBlueprint", "Lcom/avito/android/blueprints/radiogroup/RadioGroupSelectItemBlueprint;", "radioGroupSelectItemBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "(Ljava/util/Set;Lcom/avito/android/blueprints/switcher/MultiStateSwitcherItemBlueprint;Lcom/avito/android/blueprints/input/MultiStateInputItemBlueprint;Lcom/avito/android/blueprints/chips/ChipsSelectItemBlueprint;Lcom/avito/android/blueprints/chips_multiselect/ChipsMultiselectItemBlueprint;Lcom/avito/android/blueprints/radiogroup/RadioGroupSelectItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "Lcom/avito/android/blueprints/select/MultiStateSelectItemPresenter;", "selectItemPresenter", "Lcom/avito/android/blueprints/chips/ChipsSelectItemPresenter;", "chipsSelectItemPresenter", "Lcom/avito/android/blueprints/chips_multiselect/ChipsMultiselectItemPresenter;", "chipsMultiselectItemPresenter", "Lcom/avito/android/blueprints/radiogroup/RadioGroupSelectItemPresenter;", "radioGroupSelectItemPresenter", "Lcom/avito/android/blueprints/input/MultiStateInputItemPresenter;", "inputItemPresenter", "Lcom/avito/android/publish/objects/blueprints/DeleteObjectButtonItemPresenter;", "deleteObjectButtonItemPresenter", "Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemPresenter;", "dateIntervalItemPresenter", "provideItemPresentersSet$publish_release", "(Lcom/avito/android/blueprints/select/MultiStateSelectItemPresenter;Lcom/avito/android/blueprints/chips/ChipsSelectItemPresenter;Lcom/avito/android/blueprints/chips_multiselect/ChipsMultiselectItemPresenter;Lcom/avito/android/blueprints/radiogroup/RadioGroupSelectItemPresenter;Lcom/avito/android/blueprints/input/MultiStateInputItemPresenter;Lcom/avito/android/publish/objects/blueprints/DeleteObjectButtonItemPresenter;Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemPresenter;)Ljava/util/Set;", "provideItemPresentersSet", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel;", "provideHtmlEditorViewModel", "()Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel;", "<init>", "()V", "Declarations", "publish_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, ParametersListModule.class, DialogRouterModule.class, AttributedTextFormatterModule.class})
public final class ObjectsEditModule {
    @NotNull
    public static final ObjectsEditModule INSTANCE = new ObjectsEditModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u0010H'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u0017H'¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH'¢\u0006\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/avito/android/publish/objects/di/ObjectsEditModule$Declarations;", "", "Lcom/avito/android/publish/objects/blueprints/DeleteObjectButtonItemPresenterImpl;", "presenter", "Lcom/avito/android/publish/objects/blueprints/DeleteObjectButtonItemPresenter;", "bindDeleteObjectButtonPresenter", "(Lcom/avito/android/publish/objects/blueprints/DeleteObjectButtonItemPresenterImpl;)Lcom/avito/android/publish/objects/blueprints/DeleteObjectButtonItemPresenter;", "Lcom/avito/android/publish/objects/blueprints/DeleteObjectButtonBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindDeleteObjectItemBlueprint", "(Lcom/avito/android/publish/objects/blueprints/DeleteObjectButtonBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemPresenterImpl;", "Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemPresenter;", "bindDateIntervalItemPresenter", "(Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemPresenterImpl;)Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemPresenter;", "Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemBlueprint;", "bindDateIntervalItemBlueprint", "(Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/blueprints/select/MultiStateSelectItemPresenterImpl;", "Lcom/avito/android/blueprints/select/MultiStateSelectItemPresenter;", "bindSelectItemPresenter", "(Lcom/avito/android/blueprints/select/MultiStateSelectItemPresenterImpl;)Lcom/avito/android/blueprints/select/MultiStateSelectItemPresenter;", "Lcom/avito/android/blueprints/select/MultiStateSelectItemBlueprint;", "bindSelectItemBlueprint", "(Lcom/avito/android/blueprints/select/MultiStateSelectItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/analytics/PublishValidationLogger;", "logger", "Lcom/avito/android/validation/ValidationLogger;", "bindValidationLogger", "(Lcom/avito/android/analytics/PublishValidationLogger;)Lcom/avito/android/validation/ValidationLogger;", "Lcom/avito/android/publish/objects/ObjectsEditInteractorImpl;", "interactor", "Lcom/avito/android/publish/objects/ObjectsEditInteractor;", "provideInteractor", "(Lcom/avito/android/publish/objects/ObjectsEditInteractorImpl;)Lcom/avito/android/publish/objects/ObjectsEditInteractor;", "publish_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> bindDateIntervalItemBlueprint(@NotNull DateIntervalItemBlueprint dateIntervalItemBlueprint);

        @PerFragment
        @Binds
        @NotNull
        DateIntervalItemPresenter bindDateIntervalItemPresenter(@NotNull DateIntervalItemPresenterImpl dateIntervalItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        DeleteObjectButtonItemPresenter bindDeleteObjectButtonPresenter(@NotNull DeleteObjectButtonItemPresenterImpl deleteObjectButtonItemPresenterImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> bindDeleteObjectItemBlueprint(@NotNull DeleteObjectButtonBlueprint deleteObjectButtonBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> bindSelectItemBlueprint(@NotNull MultiStateSelectItemBlueprint multiStateSelectItemBlueprint);

        @PerFragment
        @Binds
        @NotNull
        MultiStateSelectItemPresenter bindSelectItemPresenter(@NotNull MultiStateSelectItemPresenterImpl multiStateSelectItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        ValidationLogger bindValidationLogger(@NotNull PublishValidationLogger publishValidationLogger);

        @PerFragment
        @Binds
        @NotNull
        ObjectsEditInteractor provideInteractor(@NotNull ObjectsEditInteractorImpl objectsEditInteractorImpl);
    }

    @Provides
    @NotNull
    @PerFragment
    public final RecyclerView.Adapter<?> provideAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "adapter");
        simpleRecyclerAdapter.setHasStableIds(true);
        return simpleRecyclerAdapter;
    }

    @Provides
    @NotNull
    @PerFragment
    public final CategoryParametersElementConverter provideCategoryParametersElementConverter(@NotNull Resources resources, @PhoneNumberFormatterModule.PhoneNumberFormatterWithCountryCode @NotNull Formatter<String> formatter, @NotNull TimeSource timeSource, @NotNull Features features, @NotNull Locale locale, @NotNull HtmlCleaner htmlCleaner, @NotNull HtmlNodeFactory htmlNodeFactory) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(formatter, "phoneFormatter");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(htmlCleaner, "htmlCleaner");
        Intrinsics.checkNotNullParameter(htmlNodeFactory, "htmlNodeFactory");
        return new CategoryParametersElementConverter(formatter, resources, timeSource, false, false, locale, false, false, false, false, htmlNodeFactory, htmlCleaner, features, 984, null);
    }

    @Provides
    @PerFragment
    @Nullable
    public final HtmlEditorViewModel provideHtmlEditorViewModel() {
        return null;
    }

    @Provides
    @NotNull
    @PerFragment
    public final ItemBinder provideItemBinder(@NotNull Set<ItemBlueprint<?, ?>> set, @NotNull MultiStateSwitcherItemBlueprint multiStateSwitcherItemBlueprint, @NotNull MultiStateInputItemBlueprint multiStateInputItemBlueprint, @NotNull ChipsSelectItemBlueprint chipsSelectItemBlueprint, @NotNull ChipsMultiselectItemBlueprint chipsMultiselectItemBlueprint, @NotNull RadioGroupSelectItemBlueprint radioGroupSelectItemBlueprint) {
        Intrinsics.checkNotNullParameter(set, "blueprints");
        Intrinsics.checkNotNullParameter(multiStateSwitcherItemBlueprint, "multiStateSwitcherItemBlueprint");
        Intrinsics.checkNotNullParameter(multiStateInputItemBlueprint, "multiStateInputItemBlueprint");
        Intrinsics.checkNotNullParameter(chipsSelectItemBlueprint, "chipsSelectItemBlueprint");
        Intrinsics.checkNotNullParameter(chipsMultiselectItemBlueprint, "chipsMultiselectItemBlueprint");
        Intrinsics.checkNotNullParameter(radioGroupSelectItemBlueprint, "radioGroupSelectItemBlueprint");
        ItemBinder.Builder builder = new ItemBinder.Builder();
        builder.registerItem(chipsSelectItemBlueprint);
        builder.registerItem(radioGroupSelectItemBlueprint);
        builder.registerItem(multiStateSwitcherItemBlueprint);
        builder.registerItem(multiStateInputItemBlueprint);
        builder.registerItem(chipsMultiselectItemBlueprint);
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            builder.registerItem(it.next());
        }
        return builder.build();
    }

    @Provides
    @NotNull
    @PerFragment
    public final Set<ItemPresenter<?, ?>> provideItemPresentersSet$publish_release(@NotNull MultiStateSelectItemPresenter multiStateSelectItemPresenter, @NotNull ChipsSelectItemPresenter chipsSelectItemPresenter, @NotNull ChipsMultiselectItemPresenter chipsMultiselectItemPresenter, @NotNull RadioGroupSelectItemPresenter radioGroupSelectItemPresenter, @NotNull MultiStateInputItemPresenter multiStateInputItemPresenter, @NotNull DeleteObjectButtonItemPresenter deleteObjectButtonItemPresenter, @NotNull DateIntervalItemPresenter dateIntervalItemPresenter) {
        Intrinsics.checkNotNullParameter(multiStateSelectItemPresenter, "selectItemPresenter");
        Intrinsics.checkNotNullParameter(chipsSelectItemPresenter, "chipsSelectItemPresenter");
        Intrinsics.checkNotNullParameter(chipsMultiselectItemPresenter, "chipsMultiselectItemPresenter");
        Intrinsics.checkNotNullParameter(radioGroupSelectItemPresenter, "radioGroupSelectItemPresenter");
        Intrinsics.checkNotNullParameter(multiStateInputItemPresenter, "inputItemPresenter");
        Intrinsics.checkNotNullParameter(deleteObjectButtonItemPresenter, "deleteObjectButtonItemPresenter");
        Intrinsics.checkNotNullParameter(dateIntervalItemPresenter, "dateIntervalItemPresenter");
        return y.setOf((Object[]) new ItemPresenter[]{multiStateSelectItemPresenter, radioGroupSelectItemPresenter, chipsSelectItemPresenter, multiStateInputItemPresenter, deleteObjectButtonItemPresenter, dateIntervalItemPresenter, chipsMultiselectItemPresenter});
    }

    @Provides
    @NotNull
    @PerFragment
    public final ObjectsEditPresenter providePresenter(@NotNull Resources resources, @Named("parameter") @NotNull ObjectsParameter objectsParameter, @NotNull ObjectsEditInteractor objectsEditInteractor, @NotNull BasicParameterClickListener basicParameterClickListener, @NotNull DataAwareAdapterPresenter dataAwareAdapterPresenter, @NotNull ParametersListPresenter parametersListPresenter, @NotNull ItemDetailsSelectResultHandler itemDetailsSelectResultHandler, @NotNull CategoryParametersElementConverter categoryParametersElementConverter, @NotNull SchedulersFactory schedulersFactory, @NotNull Locale locale, @NotNull Set<ItemPresenter<?, ?>> set) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(objectsParameter, "parameter");
        Intrinsics.checkNotNullParameter(objectsEditInteractor, "interactor");
        Intrinsics.checkNotNullParameter(basicParameterClickListener, "clickListener");
        Intrinsics.checkNotNullParameter(dataAwareAdapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(parametersListPresenter, "parametersListPresenter");
        Intrinsics.checkNotNullParameter(itemDetailsSelectResultHandler, "resultHandler");
        Intrinsics.checkNotNullParameter(categoryParametersElementConverter, "categoryParametersElementConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(set, "itemPresentersSet");
        return new ObjectsEditPresenterImpl(parametersListPresenter, objectsParameter, objectsEditInteractor, basicParameterClickListener, dataAwareAdapterPresenter, itemDetailsSelectResultHandler, categoryParametersElementConverter, schedulersFactory, resources, locale, set);
    }
}
