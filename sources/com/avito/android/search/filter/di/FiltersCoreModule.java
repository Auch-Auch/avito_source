package com.avito.android.search.filter.di;

import a2.b.a.a.a;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.blueprints.CheckBoxItemPresenter;
import com.avito.android.blueprints.CheckBoxItemPresenterImpl;
import com.avito.android.common.InputFormatter;
import com.avito.android.di.PerFragment;
import com.avito.android.location.di.SavedLocationInteractorModule;
import com.avito.android.location.di.module.FindDetectLocationModule;
import com.avito.android.price.PriceInputFormatterImpl;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenterImpl;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.recycler.data_aware.SimpleDiffCalculator;
import com.avito.android.recycler.data_aware.SimpleEqualityComparator;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SearchParamsConverterImpl;
import com.avito.android.search.filter.CategoriesParameterFactory;
import com.avito.android.search.filter.CategoriesParameterFactoryImpl;
import com.avito.android.search.filter.DialogResourceProvider;
import com.avito.android.search.filter.FiltersChangeProvider;
import com.avito.android.search.filter.FiltersChangeProviderImpl;
import com.avito.android.search.filter.FiltersInteractor;
import com.avito.android.search.filter.FiltersInteractorImpl;
import com.avito.android.search.filter.FiltersResourceProvider;
import com.avito.android.search.filter.FiltersResourceProviderImpl;
import com.avito.android.search.filter.InputItemFormatterProvider;
import com.avito.android.search.filter.InputItemFormatterProviderImpl;
import com.avito.android.search.filter.MultiselectDialogFactory;
import com.avito.android.search.filter.MultiselectDialogFactoryImpl;
import com.avito.android.search.filter.MultiselectDialogPresenter;
import com.avito.android.search.filter.MultiselectDialogPresenterImpl;
import com.avito.android.search.filter.ParametersTreeMapConverter;
import com.avito.android.search.filter.ParametersTreeMapConverterImpl;
import com.avito.android.search.filter.ParametersTreeSearchParamsConverter;
import com.avito.android.search.filter.ParametersTreeSearchParamsConverterImpl;
import com.avito.android.search.filter.ReplaceLocationParametersTreeWrapper;
import com.avito.android.search.filter.ReplaceLocationParametersTreeWrapperImpl;
import com.avito.android.search.filter.SelectDialogFactory;
import com.avito.android.search.filter.SelectDialogFactoryImpl;
import com.avito.android.search.filter.SelectDialogPresenter;
import com.avito.android.search.filter.SelectDialogPresenterImpl;
import com.avito.android.search.filter.SelectableItemIconFactory;
import com.avito.android.search.filter.SelectableItemIconFactoryImpl;
import com.avito.android.search.filter.SelectableItemIconFactoryResourceProvider;
import com.avito.android.search.filter.SelectableItemIconFactoryResourceProviderImpl;
import com.avito.android.search.filter.adapter.BubblesSelectItemBlueprint;
import com.avito.android.search.filter.adapter.ChangeDisplayTypeBlueprint;
import com.avito.android.search.filter.adapter.CheckBoxItemBlueprint;
import com.avito.android.search.filter.adapter.DisplayTypeSelectItemBlueprint;
import com.avito.android.search.filter.adapter.FilterItemsContentsComparator;
import com.avito.android.search.filter.adapter.FilterItemsContentsComparatorImpl;
import com.avito.android.search.filter.adapter.InlineMultiselectItemBlueprint;
import com.avito.android.search.filter.adapter.InlineSelectItemBlueprint;
import com.avito.android.search.filter.adapter.InlineTabsSelectItemBlueprint;
import com.avito.android.search.filter.adapter.InputItemBlueprint;
import com.avito.android.search.filter.adapter.MultiselectItemBlueprint;
import com.avito.android.search.filter.adapter.SelectItemBlueprint;
import com.avito.android.search.filter.adapter.SelectItemPresenter;
import com.avito.android.search.filter.adapter.SelectItemPresenterImpl;
import com.avito.android.search.filter.analytics.FilterAnalyticsInteractor;
import com.avito.android.search.filter.analytics.FilterAnalyticsInteractorImpl;
import com.avito.android.search.filter.groupSelect.GroupSelectDialogFactory;
import com.avito.android.search.filter.groupSelect.GroupSelectDialogFactoryImpl;
import com.avito.android.search.filter.groupSelect.GroupSelectDialogPresenter;
import com.avito.android.search.filter.groupSelect.GroupSelectDialogPresenterImpl;
import com.avito.android.util.PhoneNumberFormatterModule;
import com.avito.android.util.preferences.GeoContract;
import com.avito.android.util.rx3.InteropKt;
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
import java.util.Objects;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001:\u0004=>?@B\t\b\u0002¢\u0006\u0004\b;\u0010<J_\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001e\u001a\u00020\u001b2\b\b\u0001\u0010\u001a\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010'\u001a\u00020$2\u0006\u0010 \u001a\u00020\u001f2\b\b\u0001\u0010!\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\"H\u0001¢\u0006\u0004\b%\u0010&J\u0017\u0010,\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020(H\u0001¢\u0006\u0004\b*\u0010+J#\u0010/\u001a\u00020(2\b\b\u0001\u0010!\u001a\u00020\u001b2\b\b\u0001\u0010\u001a\u001a\u00020\u0016H\u0001¢\u0006\u0004\b-\u0010.J\u0017\u00104\u001a\u00020\"2\u0006\u00101\u001a\u000200H\u0001¢\u0006\u0004\b2\u00103J\u0017\u0010:\u001a\u0002072\u0006\u00106\u001a\u000205H\u0001¢\u0006\u0004\b8\u00109¨\u0006A"}, d2 = {"Lcom/avito/android/search/filter/di/FiltersCoreModule;", "", "Lcom/avito/android/search/filter/adapter/SelectItemBlueprint;", "selectItemBlueprint", "Lcom/avito/android/search/filter/adapter/InputItemBlueprint;", "inputItemBlueprint", "Lcom/avito/android/search/filter/adapter/CheckBoxItemBlueprint;", "checkBoxItemBlueprint", "Lcom/avito/android/search/filter/adapter/MultiselectItemBlueprint;", "multiselectItemBlueprint", "Lcom/avito/android/search/filter/adapter/InlineMultiselectItemBlueprint;", "inlineMultiselectItemBlueprint", "Lcom/avito/android/search/filter/adapter/InlineSelectItemBlueprint;", "inlineSelectItemBlueprint", "Lcom/avito/android/search/filter/adapter/ChangeDisplayTypeBlueprint;", "changeDisplayTypeBlueprint", "Lcom/avito/android/search/filter/adapter/DisplayTypeSelectItemBlueprint;", "displayTypeSelectItemBlueprint", "Lcom/avito/android/search/filter/adapter/BubblesSelectItemBlueprint;", "bubblesSelectItemBlueprint", "Lcom/avito/android/search/filter/adapter/InlineTabsSelectItemBlueprint;", "inlineTabsSelectItemBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder$filter_release", "(Lcom/avito/android/search/filter/adapter/SelectItemBlueprint;Lcom/avito/android/search/filter/adapter/InputItemBlueprint;Lcom/avito/android/search/filter/adapter/CheckBoxItemBlueprint;Lcom/avito/android/search/filter/adapter/MultiselectItemBlueprint;Lcom/avito/android/search/filter/adapter/InlineMultiselectItemBlueprint;Lcom/avito/android/search/filter/adapter/InlineSelectItemBlueprint;Lcom/avito/android/search/filter/adapter/ChangeDisplayTypeBlueprint;Lcom/avito/android/search/filter/adapter/DisplayTypeSelectItemBlueprint;Lcom/avito/android/search/filter/adapter/BubblesSelectItemBlueprint;Lcom/avito/android/search/filter/adapter/InlineTabsSelectItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter$filter_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "Landroidx/recyclerview/widget/ListUpdateCallback;", "updateCallback", "adapterPresenter", "Lcom/avito/android/recycler/data_aware/DiffCalculator;", "diffCalculator", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "provideDataAwareAdapterPresenter$filter_release", "(Landroidx/recyclerview/widget/ListUpdateCallback;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/data_aware/DiffCalculator;)Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "provideDataAwareAdapterPresenter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "provideListUpdateCallback$filter_release", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)Landroidx/recyclerview/widget/ListUpdateCallback;", "provideListUpdateCallback", "provideRecyclerAdapter$filter_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideRecyclerAdapter", "Lcom/avito/android/search/filter/adapter/FilterItemsContentsComparator;", "contentsComparator", "provideDiffCalculator$filter_release", "(Lcom/avito/android/search/filter/adapter/FilterItemsContentsComparator;)Lcom/avito/android/recycler/data_aware/DiffCalculator;", "provideDiffCalculator", "Lcom/avito/android/search/filter/FiltersChangeProvider;", "changeProvider", "Lcom/avito/android/blueprints/CheckBoxItemPresenter;", "provideCheckBoxItemPresenter$filter_release", "(Lcom/avito/android/search/filter/FiltersChangeProvider;)Lcom/avito/android/blueprints/CheckBoxItemPresenter;", "provideCheckBoxItemPresenter", "<init>", "()V", "Declarations", "FiltersAdapterPresenter", "FiltersItemBinder", "FiltersSearchParamsConverter", "filter_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {SavedLocationInteractorModule.class, PhoneNumberFormatterModule.class, FiltersCoreAdapterItemsModule.class, Declarations.class, FindDetectLocationModule.class})
public final class FiltersCoreModule {
    @NotNull
    public static final FiltersCoreModule INSTANCE = new FiltersCoreModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0016H'¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH'¢\u0006\u0004\b\"\u0010#J\u0017\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020$H'¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020*2\u0006\u0010%\u001a\u00020)H'¢\u0006\u0004\b+\u0010,J\u0017\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020-H'¢\u0006\u0004\b0\u00101J\u0017\u00104\u001a\u0002032\u0006\u0010.\u001a\u000202H'¢\u0006\u0004\b4\u00105J\u0017\u00108\u001a\u0002072\u0006\u0010.\u001a\u000206H'¢\u0006\u0004\b8\u00109J\u0017\u0010<\u001a\u00020;2\u0006\u0010.\u001a\u00020:H'¢\u0006\u0004\b<\u0010=J\u0017\u0010@\u001a\u00020?2\u0006\u0010\u001b\u001a\u00020>H'¢\u0006\u0004\b@\u0010AJ\u0017\u0010D\u001a\u00020C2\u0006\u0010.\u001a\u00020BH'¢\u0006\u0004\bD\u0010EJ\u0017\u0010H\u001a\u00020G2\u0006\u0010\b\u001a\u00020FH'¢\u0006\u0004\bH\u0010IJ\u0017\u0010K\u001a\u00020J2\u0006\u0010\b\u001a\u00020FH'¢\u0006\u0004\bK\u0010LJ\u0017\u0010O\u001a\u00020N2\u0006\u0010\b\u001a\u00020MH'¢\u0006\u0004\bO\u0010PJ\u0017\u0010S\u001a\u00020R2\u0006\u0010\b\u001a\u00020QH'¢\u0006\u0004\bS\u0010TJ\u0017\u0010W\u001a\u00020V2\u0006\u0010\u0003\u001a\u00020UH'¢\u0006\u0004\bW\u0010XJ\u0017\u0010[\u001a\u00020Z2\u0006\u0010%\u001a\u00020YH'¢\u0006\u0004\b[\u0010\\J\u0017\u0010_\u001a\u00020^2\u0006\u0010.\u001a\u00020]H'¢\u0006\u0004\b_\u0010`¨\u0006a"}, d2 = {"Lcom/avito/android/search/filter/di/FiltersCoreModule$Declarations;", "", "Lcom/avito/android/search/filter/FiltersInteractorImpl;", "interactor", "Lcom/avito/android/search/filter/FiltersInteractor;", "bindFiltersInteractor", "(Lcom/avito/android/search/filter/FiltersInteractorImpl;)Lcom/avito/android/search/filter/FiltersInteractor;", "Lcom/avito/android/search/filter/FiltersChangeProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/search/filter/FiltersChangeProvider;", "bindFiltersChangeProvider", "(Lcom/avito/android/search/filter/FiltersChangeProviderImpl;)Lcom/avito/android/search/filter/FiltersChangeProvider;", "Lcom/avito/android/search/filter/adapter/FilterItemsContentsComparatorImpl;", "comparator", "Lcom/avito/android/search/filter/adapter/FilterItemsContentsComparator;", "bindFilterItemsContentsComparator", "(Lcom/avito/android/search/filter/adapter/FilterItemsContentsComparatorImpl;)Lcom/avito/android/search/filter/adapter/FilterItemsContentsComparator;", "Lcom/avito/android/search/filter/InputItemFormatterProviderImpl;", "formatter", "Lcom/avito/android/search/filter/InputItemFormatterProvider;", "bindInputItemFormatterProvider", "(Lcom/avito/android/search/filter/InputItemFormatterProviderImpl;)Lcom/avito/android/search/filter/InputItemFormatterProvider;", "Lcom/avito/android/price/PriceInputFormatterImpl;", "Lcom/avito/android/common/InputFormatter;", "bindPriceInputFormatter", "(Lcom/avito/android/price/PriceInputFormatterImpl;)Lcom/avito/android/common/InputFormatter;", "Lcom/avito/android/search/filter/CategoriesParameterFactoryImpl;", "factory", "Lcom/avito/android/search/filter/CategoriesParameterFactory;", "bindCategoriesParameterFactory", "(Lcom/avito/android/search/filter/CategoriesParameterFactoryImpl;)Lcom/avito/android/search/filter/CategoriesParameterFactory;", "Lcom/avito/android/search/filter/ReplaceLocationParametersTreeWrapperImpl;", "wrapper", "Lcom/avito/android/search/filter/ReplaceLocationParametersTreeWrapper;", "bindReplaceLocationParametersTreeWrapper", "(Lcom/avito/android/search/filter/ReplaceLocationParametersTreeWrapperImpl;)Lcom/avito/android/search/filter/ReplaceLocationParametersTreeWrapper;", "Lcom/avito/android/remote/model/SearchParamsConverterImpl;", "converter", "Lcom/avito/android/remote/model/SearchParamsConverter;", "bindSearchParamsConverter", "(Lcom/avito/android/remote/model/SearchParamsConverterImpl;)Lcom/avito/android/remote/model/SearchParamsConverter;", "Lcom/avito/android/search/filter/ParametersTreeMapConverterImpl;", "Lcom/avito/android/search/filter/ParametersTreeMapConverter;", "bindParametersTreeMapConverter", "(Lcom/avito/android/search/filter/ParametersTreeMapConverterImpl;)Lcom/avito/android/search/filter/ParametersTreeMapConverter;", "Lcom/avito/android/search/filter/MultiselectDialogFactoryImpl;", "presenter", "Lcom/avito/android/search/filter/MultiselectDialogFactory;", "bindMultiselectDialogFactory", "(Lcom/avito/android/search/filter/MultiselectDialogFactoryImpl;)Lcom/avito/android/search/filter/MultiselectDialogFactory;", "Lcom/avito/android/search/filter/MultiselectDialogPresenterImpl;", "Lcom/avito/android/search/filter/MultiselectDialogPresenter;", "bindMultiselectDialogPresenter", "(Lcom/avito/android/search/filter/MultiselectDialogPresenterImpl;)Lcom/avito/android/search/filter/MultiselectDialogPresenter;", "Lcom/avito/android/search/filter/SelectDialogFactoryImpl;", "Lcom/avito/android/search/filter/SelectDialogFactory;", "bindSelectDialogFactory", "(Lcom/avito/android/search/filter/SelectDialogFactoryImpl;)Lcom/avito/android/search/filter/SelectDialogFactory;", "Lcom/avito/android/search/filter/SelectDialogPresenterImpl;", "Lcom/avito/android/search/filter/SelectDialogPresenter;", "bindSelectDialogPresenter", "(Lcom/avito/android/search/filter/SelectDialogPresenterImpl;)Lcom/avito/android/search/filter/SelectDialogPresenter;", "Lcom/avito/android/search/filter/groupSelect/GroupSelectDialogFactoryImpl;", "Lcom/avito/android/search/filter/groupSelect/GroupSelectDialogFactory;", "bindGroupSelectDialogFactory", "(Lcom/avito/android/search/filter/groupSelect/GroupSelectDialogFactoryImpl;)Lcom/avito/android/search/filter/groupSelect/GroupSelectDialogFactory;", "Lcom/avito/android/search/filter/groupSelect/GroupSelectDialogPresenterImpl;", "Lcom/avito/android/search/filter/groupSelect/GroupSelectDialogPresenter;", "bindGroupSelectDialogPresenter", "(Lcom/avito/android/search/filter/groupSelect/GroupSelectDialogPresenterImpl;)Lcom/avito/android/search/filter/groupSelect/GroupSelectDialogPresenter;", "Lcom/avito/android/search/filter/FiltersResourceProviderImpl;", "Lcom/avito/android/search/filter/FiltersResourceProvider;", "bindFiltersResourceProvider", "(Lcom/avito/android/search/filter/FiltersResourceProviderImpl;)Lcom/avito/android/search/filter/FiltersResourceProvider;", "Lcom/avito/android/search/filter/DialogResourceProvider;", "bindDialogResourceProvider", "(Lcom/avito/android/search/filter/FiltersResourceProviderImpl;)Lcom/avito/android/search/filter/DialogResourceProvider;", "Lcom/avito/android/search/filter/SelectableItemIconFactoryImpl;", "Lcom/avito/android/search/filter/SelectableItemIconFactory;", "bindSelectableItemIconFactory", "(Lcom/avito/android/search/filter/SelectableItemIconFactoryImpl;)Lcom/avito/android/search/filter/SelectableItemIconFactory;", "Lcom/avito/android/search/filter/SelectableItemIconFactoryResourceProviderImpl;", "Lcom/avito/android/search/filter/SelectableItemIconFactoryResourceProvider;", "bindSelectableItemIconFactoryResourceProvider", "(Lcom/avito/android/search/filter/SelectableItemIconFactoryResourceProviderImpl;)Lcom/avito/android/search/filter/SelectableItemIconFactoryResourceProvider;", "Lcom/avito/android/search/filter/analytics/FilterAnalyticsInteractorImpl;", "Lcom/avito/android/search/filter/analytics/FilterAnalyticsInteractor;", "bindFilterAnalyticsInteractor", "(Lcom/avito/android/search/filter/analytics/FilterAnalyticsInteractorImpl;)Lcom/avito/android/search/filter/analytics/FilterAnalyticsInteractor;", "Lcom/avito/android/search/filter/ParametersTreeSearchParamsConverterImpl;", "Lcom/avito/android/search/filter/ParametersTreeSearchParamsConverter;", "bindParametersTreeSearchParamsConverter", "(Lcom/avito/android/search/filter/ParametersTreeSearchParamsConverterImpl;)Lcom/avito/android/search/filter/ParametersTreeSearchParamsConverter;", "Lcom/avito/android/search/filter/adapter/SelectItemPresenterImpl;", "Lcom/avito/android/search/filter/adapter/SelectItemPresenter;", "bindSelectItemPresenter", "(Lcom/avito/android/search/filter/adapter/SelectItemPresenterImpl;)Lcom/avito/android/search/filter/adapter/SelectItemPresenter;", "filter_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        CategoriesParameterFactory bindCategoriesParameterFactory(@NotNull CategoriesParameterFactoryImpl categoriesParameterFactoryImpl);

        @PerFragment
        @Binds
        @NotNull
        DialogResourceProvider bindDialogResourceProvider(@NotNull FiltersResourceProviderImpl filtersResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        FilterAnalyticsInteractor bindFilterAnalyticsInteractor(@NotNull FilterAnalyticsInteractorImpl filterAnalyticsInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        FilterItemsContentsComparator bindFilterItemsContentsComparator(@NotNull FilterItemsContentsComparatorImpl filterItemsContentsComparatorImpl);

        @PerFragment
        @Binds
        @NotNull
        FiltersChangeProvider bindFiltersChangeProvider(@NotNull FiltersChangeProviderImpl filtersChangeProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        FiltersInteractor bindFiltersInteractor(@NotNull FiltersInteractorImpl filtersInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        FiltersResourceProvider bindFiltersResourceProvider(@NotNull FiltersResourceProviderImpl filtersResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        GroupSelectDialogFactory bindGroupSelectDialogFactory(@NotNull GroupSelectDialogFactoryImpl groupSelectDialogFactoryImpl);

        @PerFragment
        @Binds
        @NotNull
        GroupSelectDialogPresenter bindGroupSelectDialogPresenter(@NotNull GroupSelectDialogPresenterImpl groupSelectDialogPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        InputItemFormatterProvider bindInputItemFormatterProvider(@NotNull InputItemFormatterProviderImpl inputItemFormatterProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        MultiselectDialogFactory bindMultiselectDialogFactory(@NotNull MultiselectDialogFactoryImpl multiselectDialogFactoryImpl);

        @PerFragment
        @Binds
        @NotNull
        MultiselectDialogPresenter bindMultiselectDialogPresenter(@NotNull MultiselectDialogPresenterImpl multiselectDialogPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        ParametersTreeMapConverter bindParametersTreeMapConverter(@NotNull ParametersTreeMapConverterImpl parametersTreeMapConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        ParametersTreeSearchParamsConverter bindParametersTreeSearchParamsConverter(@NotNull ParametersTreeSearchParamsConverterImpl parametersTreeSearchParamsConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        InputFormatter bindPriceInputFormatter(@NotNull PriceInputFormatterImpl priceInputFormatterImpl);

        @PerFragment
        @Binds
        @NotNull
        ReplaceLocationParametersTreeWrapper bindReplaceLocationParametersTreeWrapper(@NotNull ReplaceLocationParametersTreeWrapperImpl replaceLocationParametersTreeWrapperImpl);

        @Binds
        @NotNull
        @PerFragment
        @FiltersSearchParamsConverter
        SearchParamsConverter bindSearchParamsConverter(@NotNull SearchParamsConverterImpl searchParamsConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        SelectDialogFactory bindSelectDialogFactory(@NotNull SelectDialogFactoryImpl selectDialogFactoryImpl);

        @PerFragment
        @Binds
        @NotNull
        SelectDialogPresenter bindSelectDialogPresenter(@NotNull SelectDialogPresenterImpl selectDialogPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        SelectItemPresenter bindSelectItemPresenter(@NotNull SelectItemPresenterImpl selectItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        SelectableItemIconFactory bindSelectableItemIconFactory(@NotNull SelectableItemIconFactoryImpl selectableItemIconFactoryImpl);

        @PerFragment
        @Binds
        @NotNull
        SelectableItemIconFactoryResourceProvider bindSelectableItemIconFactoryResourceProvider(@NotNull SelectableItemIconFactoryResourceProviderImpl selectableItemIconFactoryResourceProviderImpl);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/filter/di/FiltersCoreModule$FiltersAdapterPresenter;", "", "<init>", "()V", "filter_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface FiltersAdapterPresenter {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/filter/di/FiltersCoreModule$FiltersItemBinder;", "", "<init>", "()V", "filter_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface FiltersItemBinder {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/filter/di/FiltersCoreModule$FiltersSearchParamsConverter;", "", "<init>", "()V", "filter_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface FiltersSearchParamsConverter {
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    @FiltersAdapterPresenter
    public static final AdapterPresenter provideAdapterPresenter$filter_release(@FiltersItemBinder @NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final CheckBoxItemPresenter provideCheckBoxItemPresenter$filter_release(@NotNull FiltersChangeProvider filtersChangeProvider) {
        Intrinsics.checkNotNullParameter(filtersChangeProvider, "changeProvider");
        return new CheckBoxItemPresenterImpl(InteropKt.toConsumerV2(filtersChangeProvider.getCheckBoxConsumer()));
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final DataAwareAdapterPresenter provideDataAwareAdapterPresenter$filter_release(@NotNull ListUpdateCallback listUpdateCallback, @FiltersAdapterPresenter @NotNull AdapterPresenter adapterPresenter, @NotNull DiffCalculator diffCalculator) {
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
    public static final DiffCalculator provideDiffCalculator$filter_release(@NotNull FilterItemsContentsComparator filterItemsContentsComparator) {
        Intrinsics.checkNotNullParameter(filterItemsContentsComparator, "contentsComparator");
        return new SimpleDiffCalculator(filterItemsContentsComparator, new SimpleEqualityComparator(), true, null, 8, null);
    }

    @Provides
    @JvmStatic
    @FiltersItemBinder
    @NotNull
    @PerFragment
    public static final ItemBinder provideItemBinder$filter_release(@NotNull SelectItemBlueprint selectItemBlueprint, @NotNull InputItemBlueprint inputItemBlueprint, @NotNull CheckBoxItemBlueprint checkBoxItemBlueprint, @NotNull MultiselectItemBlueprint multiselectItemBlueprint, @NotNull InlineMultiselectItemBlueprint inlineMultiselectItemBlueprint, @NotNull InlineSelectItemBlueprint inlineSelectItemBlueprint, @NotNull ChangeDisplayTypeBlueprint changeDisplayTypeBlueprint, @NotNull DisplayTypeSelectItemBlueprint displayTypeSelectItemBlueprint, @NotNull BubblesSelectItemBlueprint bubblesSelectItemBlueprint, @NotNull InlineTabsSelectItemBlueprint inlineTabsSelectItemBlueprint) {
        Intrinsics.checkNotNullParameter(selectItemBlueprint, "selectItemBlueprint");
        Intrinsics.checkNotNullParameter(inputItemBlueprint, "inputItemBlueprint");
        Intrinsics.checkNotNullParameter(checkBoxItemBlueprint, "checkBoxItemBlueprint");
        Intrinsics.checkNotNullParameter(multiselectItemBlueprint, "multiselectItemBlueprint");
        Intrinsics.checkNotNullParameter(inlineMultiselectItemBlueprint, "inlineMultiselectItemBlueprint");
        Intrinsics.checkNotNullParameter(inlineSelectItemBlueprint, "inlineSelectItemBlueprint");
        Intrinsics.checkNotNullParameter(changeDisplayTypeBlueprint, "changeDisplayTypeBlueprint");
        Intrinsics.checkNotNullParameter(displayTypeSelectItemBlueprint, "displayTypeSelectItemBlueprint");
        Intrinsics.checkNotNullParameter(bubblesSelectItemBlueprint, "bubblesSelectItemBlueprint");
        Intrinsics.checkNotNullParameter(inlineTabsSelectItemBlueprint, "inlineTabsSelectItemBlueprint");
        return new ItemBinder.Builder().registerItem(selectItemBlueprint).registerItem(inputItemBlueprint).registerItem(checkBoxItemBlueprint).registerItem(multiselectItemBlueprint).registerItem(inlineSelectItemBlueprint).registerItem(inlineMultiselectItemBlueprint).registerItem(changeDisplayTypeBlueprint).registerItem(bubblesSelectItemBlueprint).registerItem(inlineTabsSelectItemBlueprint).registerItem(displayTypeSelectItemBlueprint).build();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ListUpdateCallback provideListUpdateCallback$filter_release(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "adapter");
        return simpleRecyclerAdapter;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SimpleRecyclerAdapter provideRecyclerAdapter$filter_release(@FiltersAdapterPresenter @NotNull AdapterPresenter adapterPresenter, @FiltersItemBinder @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }
}
