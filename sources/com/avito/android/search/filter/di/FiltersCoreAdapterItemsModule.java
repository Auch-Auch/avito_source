package com.avito.android.search.filter.di;

import com.avito.android.blueprints.CheckBoxItemView;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.di.PerFragment;
import com.avito.android.items.CheckBoxItem;
import com.avito.android.items.SelectableItem;
import com.avito.android.search.filter.adapter.BubblesSelectItemBlueprint;
import com.avito.android.search.filter.adapter.BubblesSelectItemPresenter;
import com.avito.android.search.filter.adapter.BubblesSelectItemPresenterImpl;
import com.avito.android.search.filter.adapter.BubblesSelectItemView;
import com.avito.android.search.filter.adapter.ChangeDisplayTypeBlueprint;
import com.avito.android.search.filter.adapter.ChangeDisplayTypeItem;
import com.avito.android.search.filter.adapter.ChangeDisplayTypePresenter;
import com.avito.android.search.filter.adapter.ChangeDisplayTypePresenterImpl;
import com.avito.android.search.filter.adapter.ChangeDisplayTypeView;
import com.avito.android.search.filter.adapter.CheckBoxItemBlueprint;
import com.avito.android.search.filter.adapter.InlineMultiselectItemBlueprint;
import com.avito.android.search.filter.adapter.InlineMultiselectItemPresenter;
import com.avito.android.search.filter.adapter.InlineMultiselectItemPresenterImpl;
import com.avito.android.search.filter.adapter.InlineMultiselectItemView;
import com.avito.android.search.filter.adapter.InlineSelectItemBlueprint;
import com.avito.android.search.filter.adapter.InlineSelectItemPresenter;
import com.avito.android.search.filter.adapter.InlineSelectItemPresenterImpl;
import com.avito.android.search.filter.adapter.InlineSelectItemView;
import com.avito.android.search.filter.adapter.InlineTabsSelectItemBlueprint;
import com.avito.android.search.filter.adapter.InlineTabsSelectItemPresenter;
import com.avito.android.search.filter.adapter.InlineTabsSelectItemPresenterImpl;
import com.avito.android.search.filter.adapter.InlineTabsSelectItemView;
import com.avito.android.search.filter.adapter.InputItemPresenter;
import com.avito.android.search.filter.adapter.InputItemPresenterImpl;
import com.avito.android.search.filter.adapter.MultiselectItemPresenter;
import com.avito.android.search.filter.adapter.MultiselectItemPresenterImpl;
import com.avito.android.search.filter.adapter.SelectableItemCheckBoxBlueprint;
import com.avito.android.search.filter.adapter.SelectableItemPresenter;
import com.avito.android.search.filter.adapter.SelectableItemPresenterMultiselectImpl;
import com.avito.android.search.filter.adapter.SelectableItemPresenterSelectImpl;
import com.avito.android.search.filter.adapter.SelectableItemRadioButtonBlueprint;
import com.avito.android.search.filter.adapter.SelectableItemView;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001:\u0002MNJ#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\tH'¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u000e\u001a\u00020\rH'¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0012H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0016H'¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u00042\u0006\u0010\u000e\u001a\u00020\u001aH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u001fH'¢\u0006\u0004\b!\u0010\"J#\u0010&\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0\u00042\u0006\u0010\u000e\u001a\u00020#H'¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020)2\u0006\u0010\u0003\u001a\u00020(H'¢\u0006\u0004\b*\u0010+J#\u0010/\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0\u00042\u0006\u0010\u000e\u001a\u00020,H'¢\u0006\u0004\b/\u00100J\u0017\u00103\u001a\u0002022\u0006\u0010\u0003\u001a\u000201H'¢\u0006\u0004\b3\u00104J#\u00106\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0\u00042\u0006\u0010\u000e\u001a\u000205H'¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u0002022\u0006\u0010\u0003\u001a\u000208H'¢\u0006\u0004\b9\u0010:J#\u0010>\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020=0\u00042\u0006\u0010\u000e\u001a\u00020;H'¢\u0006\u0004\b>\u0010?J\u0017\u0010B\u001a\u00020A2\u0006\u0010\u0003\u001a\u00020@H'¢\u0006\u0004\bB\u0010CJ#\u0010G\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020F0\u00042\u0006\u0010\u000e\u001a\u00020DH'¢\u0006\u0004\bG\u0010HJ\u0017\u0010K\u001a\u00020J2\u0006\u0010\u0003\u001a\u00020IH'¢\u0006\u0004\bK\u0010L¨\u0006O"}, d2 = {"Lcom/avito/android/search/filter/di/FiltersCoreAdapterItemsModule;", "", "Lcom/avito/android/search/filter/adapter/BubblesSelectItemBlueprint;", "presenter", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/search/filter/adapter/BubblesSelectItemView;", "Lcom/avito/android/category_parameters/ParameterElement$Select$Flat;", "bindBubblesSelectItemBlueprint", "(Lcom/avito/android/search/filter/adapter/BubblesSelectItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/search/filter/adapter/BubblesSelectItemPresenterImpl;", "Lcom/avito/android/search/filter/adapter/BubblesSelectItemPresenter;", "bindBubblesSelectItemPresenter", "(Lcom/avito/android/search/filter/adapter/BubblesSelectItemPresenterImpl;)Lcom/avito/android/search/filter/adapter/BubblesSelectItemPresenter;", "Lcom/avito/android/search/filter/adapter/InlineSelectItemBlueprint;", "blueprint", "Lcom/avito/android/search/filter/adapter/InlineSelectItemView;", "bindInlineSelectItemBlueprint", "(Lcom/avito/android/search/filter/adapter/InlineSelectItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/search/filter/adapter/InlineSelectItemPresenterImpl;", "Lcom/avito/android/search/filter/adapter/InlineSelectItemPresenter;", "bindInlineSelectItemPresenter", "(Lcom/avito/android/search/filter/adapter/InlineSelectItemPresenterImpl;)Lcom/avito/android/search/filter/adapter/InlineSelectItemPresenter;", "Lcom/avito/android/search/filter/adapter/InputItemPresenterImpl;", "Lcom/avito/android/search/filter/adapter/InputItemPresenter;", "bindInputItemPresenter", "(Lcom/avito/android/search/filter/adapter/InputItemPresenterImpl;)Lcom/avito/android/search/filter/adapter/InputItemPresenter;", "Lcom/avito/android/search/filter/adapter/CheckBoxItemBlueprint;", "Lcom/avito/android/blueprints/CheckBoxItemView;", "Lcom/avito/android/items/CheckBoxItem;", "bindCheckBoxItemBlueprint", "(Lcom/avito/android/search/filter/adapter/CheckBoxItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/search/filter/adapter/MultiselectItemPresenterImpl;", "Lcom/avito/android/search/filter/adapter/MultiselectItemPresenter;", "bindMultiselectItemPresenter", "(Lcom/avito/android/search/filter/adapter/MultiselectItemPresenterImpl;)Lcom/avito/android/search/filter/adapter/MultiselectItemPresenter;", "Lcom/avito/android/search/filter/adapter/InlineMultiselectItemBlueprint;", "Lcom/avito/android/search/filter/adapter/InlineMultiselectItemView;", "Lcom/avito/android/category_parameters/ParameterElement$Multiselect;", "bindInlineMultiselectItemBlueprint", "(Lcom/avito/android/search/filter/adapter/InlineMultiselectItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/search/filter/adapter/InlineMultiselectItemPresenterImpl;", "Lcom/avito/android/search/filter/adapter/InlineMultiselectItemPresenter;", "bindInlineMultiselectItemPresenter", "(Lcom/avito/android/search/filter/adapter/InlineMultiselectItemPresenterImpl;)Lcom/avito/android/search/filter/adapter/InlineMultiselectItemPresenter;", "Lcom/avito/android/search/filter/adapter/SelectableItemRadioButtonBlueprint;", "Lcom/avito/android/search/filter/adapter/SelectableItemView;", "Lcom/avito/android/items/SelectableItem;", "bindSelectableItemRadioButtonBlueprint", "(Lcom/avito/android/search/filter/adapter/SelectableItemRadioButtonBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/search/filter/adapter/SelectableItemPresenterSelectImpl;", "Lcom/avito/android/search/filter/adapter/SelectableItemPresenter;", "bindSelectableRadioButtonItemPresenter", "(Lcom/avito/android/search/filter/adapter/SelectableItemPresenterSelectImpl;)Lcom/avito/android/search/filter/adapter/SelectableItemPresenter;", "Lcom/avito/android/search/filter/adapter/SelectableItemCheckBoxBlueprint;", "bindSelectableItemCheckBoxBlueprint", "(Lcom/avito/android/search/filter/adapter/SelectableItemCheckBoxBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/search/filter/adapter/SelectableItemPresenterMultiselectImpl;", "bindSelectableCheckBoxItemPresenter", "(Lcom/avito/android/search/filter/adapter/SelectableItemPresenterMultiselectImpl;)Lcom/avito/android/search/filter/adapter/SelectableItemPresenter;", "Lcom/avito/android/search/filter/adapter/ChangeDisplayTypeBlueprint;", "Lcom/avito/android/search/filter/adapter/ChangeDisplayTypeView;", "Lcom/avito/android/search/filter/adapter/ChangeDisplayTypeItem;", "bindChangeDisplayTypeBlueprint", "(Lcom/avito/android/search/filter/adapter/ChangeDisplayTypeBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/search/filter/adapter/ChangeDisplayTypePresenterImpl;", "Lcom/avito/android/search/filter/adapter/ChangeDisplayTypePresenter;", "bindChangeDisplayTypePresenter", "(Lcom/avito/android/search/filter/adapter/ChangeDisplayTypePresenterImpl;)Lcom/avito/android/search/filter/adapter/ChangeDisplayTypePresenter;", "Lcom/avito/android/search/filter/adapter/InlineTabsSelectItemBlueprint;", "Lcom/avito/android/search/filter/adapter/InlineTabsSelectItemView;", "Lcom/avito/android/category_parameters/ParameterElement$TabsSelect;", "bindInlineTabsSelectItemBlueprint", "(Lcom/avito/android/search/filter/adapter/InlineTabsSelectItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/search/filter/adapter/InlineTabsSelectItemPresenterImpl;", "Lcom/avito/android/search/filter/adapter/InlineTabsSelectItemPresenter;", "bindInlineTabsSelectItemPresenter", "(Lcom/avito/android/search/filter/adapter/InlineTabsSelectItemPresenterImpl;)Lcom/avito/android/search/filter/adapter/InlineTabsSelectItemPresenter;", "SelectableCheckBoxPresenter", "SelectableRadioButtonPresenter", "filter_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface FiltersCoreAdapterItemsModule {

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/filter/di/FiltersCoreAdapterItemsModule$SelectableCheckBoxPresenter;", "", "<init>", "()V", "filter_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface SelectableCheckBoxPresenter {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/search/filter/di/FiltersCoreAdapterItemsModule$SelectableRadioButtonPresenter;", "", "<init>", "()V", "filter_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface SelectableRadioButtonPresenter {
    }

    @Binds
    @NotNull
    @PerFragment
    ItemBlueprint<BubblesSelectItemView, ParameterElement.Select.Flat> bindBubblesSelectItemBlueprint(@NotNull BubblesSelectItemBlueprint bubblesSelectItemBlueprint);

    @PerFragment
    @Binds
    @NotNull
    BubblesSelectItemPresenter bindBubblesSelectItemPresenter(@NotNull BubblesSelectItemPresenterImpl bubblesSelectItemPresenterImpl);

    @Binds
    @NotNull
    @PerFragment
    ItemBlueprint<ChangeDisplayTypeView, ChangeDisplayTypeItem> bindChangeDisplayTypeBlueprint(@NotNull ChangeDisplayTypeBlueprint changeDisplayTypeBlueprint);

    @PerFragment
    @Binds
    @NotNull
    ChangeDisplayTypePresenter bindChangeDisplayTypePresenter(@NotNull ChangeDisplayTypePresenterImpl changeDisplayTypePresenterImpl);

    @Binds
    @NotNull
    @PerFragment
    ItemBlueprint<CheckBoxItemView, CheckBoxItem> bindCheckBoxItemBlueprint(@NotNull CheckBoxItemBlueprint checkBoxItemBlueprint);

    @Binds
    @NotNull
    @PerFragment
    ItemBlueprint<InlineMultiselectItemView, ParameterElement.Multiselect> bindInlineMultiselectItemBlueprint(@NotNull InlineMultiselectItemBlueprint inlineMultiselectItemBlueprint);

    @PerFragment
    @Binds
    @NotNull
    InlineMultiselectItemPresenter bindInlineMultiselectItemPresenter(@NotNull InlineMultiselectItemPresenterImpl inlineMultiselectItemPresenterImpl);

    @Binds
    @NotNull
    @PerFragment
    ItemBlueprint<InlineSelectItemView, ParameterElement.Select.Flat> bindInlineSelectItemBlueprint(@NotNull InlineSelectItemBlueprint inlineSelectItemBlueprint);

    @PerFragment
    @Binds
    @NotNull
    InlineSelectItemPresenter bindInlineSelectItemPresenter(@NotNull InlineSelectItemPresenterImpl inlineSelectItemPresenterImpl);

    @Binds
    @NotNull
    @PerFragment
    ItemBlueprint<InlineTabsSelectItemView, ParameterElement.TabsSelect> bindInlineTabsSelectItemBlueprint(@NotNull InlineTabsSelectItemBlueprint inlineTabsSelectItemBlueprint);

    @PerFragment
    @Binds
    @NotNull
    InlineTabsSelectItemPresenter bindInlineTabsSelectItemPresenter(@NotNull InlineTabsSelectItemPresenterImpl inlineTabsSelectItemPresenterImpl);

    @PerFragment
    @Binds
    @NotNull
    InputItemPresenter bindInputItemPresenter(@NotNull InputItemPresenterImpl inputItemPresenterImpl);

    @PerFragment
    @Binds
    @NotNull
    MultiselectItemPresenter bindMultiselectItemPresenter(@NotNull MultiselectItemPresenterImpl multiselectItemPresenterImpl);

    @SelectableCheckBoxPresenter
    @Binds
    @NotNull
    @PerFragment
    SelectableItemPresenter bindSelectableCheckBoxItemPresenter(@NotNull SelectableItemPresenterMultiselectImpl selectableItemPresenterMultiselectImpl);

    @Binds
    @NotNull
    @PerFragment
    ItemBlueprint<SelectableItemView, SelectableItem> bindSelectableItemCheckBoxBlueprint(@NotNull SelectableItemCheckBoxBlueprint selectableItemCheckBoxBlueprint);

    @Binds
    @NotNull
    @PerFragment
    ItemBlueprint<SelectableItemView, SelectableItem> bindSelectableItemRadioButtonBlueprint(@NotNull SelectableItemRadioButtonBlueprint selectableItemRadioButtonBlueprint);

    @Binds
    @NotNull
    @PerFragment
    @SelectableRadioButtonPresenter
    SelectableItemPresenter bindSelectableRadioButtonItemPresenter(@NotNull SelectableItemPresenterSelectImpl selectableItemPresenterSelectImpl);
}
