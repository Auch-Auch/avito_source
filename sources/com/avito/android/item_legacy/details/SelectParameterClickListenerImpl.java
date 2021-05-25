package com.avito.android.item_legacy.details;

import com.avito.android.Features;
import com.avito.android.item_legacy.details.SelectParameterClickListener;
import com.avito.android.items.ItemWithErrors;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ParcelableEntity;
import com.avito.android.remote.model.category_parameters.MultiselectParameter;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.remote.model.category_parameters.SortDirection;
import com.avito.android.remote.model.category_parameters.base.CategoryParameter;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.select.Arguments;
import com.avito.android.select.SelectParameterLocalSorter;
import com.avito.android.select.SelectParameterLocalSorterImpl;
import com.avito.conveyor_item.Item;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\b\u0001\u0010!\u001a\u00020\u001e\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\"\u0010#J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/item_legacy/details/SelectParameterClickListenerImpl;", "Lcom/avito/android/item_legacy/details/SelectParameterClickListener;", "Lcom/avito/android/item_legacy/details/SelectParameterClickListener$Router;", "router", "", "attachRouter", "(Lcom/avito/android/item_legacy/details/SelectParameterClickListener$Router;)V", "Lcom/avito/android/item_legacy/details/ParametersSource;", "source", "setParametersSource", "(Lcom/avito/android/item_legacy/details/ParametersSource;)V", "Lcom/avito/conveyor_item/Item;", "element", "onElementClicked", "(Lcom/avito/conveyor_item/Item;)V", "detachRouter", "()V", "Lcom/avito/android/select/SelectParameterLocalSorter;", "c", "Lcom/avito/android/select/SelectParameterLocalSorter;", "selectParameterLocalSorter", "Lcom/avito/android/Features;", "e", "Lcom/avito/android/Features;", "features", AuthSource.SEND_ABUSE, "Lcom/avito/android/item_legacy/details/ParametersSource;", "selectParametersSource", AuthSource.BOOKING_ORDER, "Lcom/avito/android/item_legacy/details/SelectParameterClickListener$Router;", "", "d", "I", "minValuesForSearch", "<init>", "(ILcom/avito/android/Features;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class SelectParameterClickListenerImpl implements SelectParameterClickListener {
    public ParametersSource a;
    public SelectParameterClickListener.Router b;
    public final SelectParameterLocalSorter c = new SelectParameterLocalSorterImpl();
    public final int d;
    public final Features e;

    @Inject
    public SelectParameterClickListenerImpl(@Named("min_values_for_search") int i, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        this.d = i;
        this.e = features;
    }

    @Override // com.avito.android.item_legacy.details.SelectParameterClickListener
    public void attachRouter(@Nullable SelectParameterClickListener.Router router) {
        this.b = router;
    }

    @Override // com.avito.android.item_legacy.details.SelectParameterClickListener
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.item_legacy.details.SelectParameterClickListener
    public void onElementClicked(@NotNull Item item) {
        List<ParcelableEntity<String>> list;
        SelectParameter.Displaying displaying;
        Boolean withImages;
        ParametersTree parametersTree;
        Intrinsics.checkNotNullParameter(item, "element");
        if (item instanceof ItemWithErrors) {
            ((ItemWithErrors) item).clearErrors();
        }
        ParametersSource parametersSource = this.a;
        String str = null;
        ParameterSlot findParameter = (parametersSource == null || (parametersTree = parametersSource.getParametersTree()) == null) ? null : parametersTree.findParameter(item.getStringId());
        if (findParameter != null) {
            if (findParameter instanceof CategoryParameter) {
                CategoryParameter categoryParameter = (CategoryParameter) findParameter;
                if (categoryParameter instanceof EditableParameter) {
                    ((EditableParameter) categoryParameter).setError(null);
                }
            }
            if (findParameter instanceof SelectParameter) {
                SelectParameter selectParameter = (SelectParameter) findParameter;
                SelectParameter.Value selectedValue = selectParameter.getSelectedValue();
                List listOf = selectedValue != null ? d.listOf(selectedValue) : CollectionsKt__CollectionsKt.emptyList();
                SelectParameter.Displaying displaying2 = selectParameter.getDisplaying();
                SortDirection sortDirection = displaying2 != null ? displaying2.getSortDirection() : null;
                if (!this.e.getLocalSortOnPublish().invoke().booleanValue() || sortDirection == null) {
                    list = selectParameter.getListToShow();
                } else {
                    list = this.c.sort(selectParameter.getListToShow(), sortDirection);
                }
                boolean booleanValue = (!this.e.getImageSelectOnPublish().invoke().booleanValue() || (displaying = selectParameter.getDisplaying()) == null || (withImages = displaying.getWithImages()) == null) ? false : withImages.booleanValue();
                SelectParameterClickListener.Router router = this.b;
                if (router != null) {
                    String id = selectParameter.getId();
                    String title = selectParameter.getTitle();
                    boolean z = selectParameter.getListToShow().size() >= this.d;
                    boolean z2 = !selectParameter.getRequired();
                    SelectParameter.Displaying displaying3 = selectParameter.getDisplaying();
                    if (displaying3 != null) {
                        str = displaying3.getTitlePattern();
                    }
                    router.showSelectScreen(new Arguments(id, list, listOf, title, z, false, z2, false, false, false, null, booleanValue, false, str, 5632, null));
                }
            } else if (findParameter instanceof MultiselectParameter) {
                MultiselectParameter multiselectParameter = (MultiselectParameter) findParameter;
                List<MultiselectParameter.Value> values = multiselectParameter.getValues();
                ArrayList arrayList = new ArrayList();
                int i = 0;
                for (T t : values) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    T t2 = t;
                    List list2 = (List) multiselectParameter.getValue();
                    if (list2 != null ? list2.contains(t2.getId()) : false) {
                        arrayList.add(t);
                    }
                    i = i2;
                }
                SelectParameterClickListener.Router router2 = this.b;
                if (router2 != null) {
                    router2.showSelectScreen(new Arguments(multiselectParameter.getId(), multiselectParameter.getValues(), arrayList, multiselectParameter.getTitle(), false, true, false, false, false, false, null, false, false, null, 15872, null));
                }
            }
        }
    }

    @Override // com.avito.android.item_legacy.details.SelectParameterClickListener
    public void setParametersSource(@NotNull ParametersSource parametersSource) {
        Intrinsics.checkNotNullParameter(parametersSource, "source");
        this.a = parametersSource;
    }
}
