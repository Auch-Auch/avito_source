package a2.a.a.k2.a;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.items.CheckBoxItem;
import com.avito.android.items.SelectableItem;
import com.avito.android.remote.model.category_parameters.BooleanParameter;
import com.avito.android.remote.model.category_parameters.IntParameter;
import com.avito.android.remote.model.category_parameters.MultiselectParameter;
import com.avito.android.remote.model.category_parameters.NumericParameter;
import com.avito.android.remote.model.category_parameters.PriceParameter;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.search.filter.FiltersInteractor;
import com.avito.android.search.filter.FiltersPresenterImpl;
import com.avito.android.search.filter.ParametersTreeWithAdditional;
import com.avito.android.search.filter.adapter.ChangeDisplayTypeItem;
import com.avito.conveyor_item.Item;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import t6.n.e;
import t6.y.k;
import t6.y.l;
public final class v extends Lambda implements Function1<Item, Unit> {
    public final /* synthetic */ FiltersPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(FiltersPresenterImpl filtersPresenterImpl) {
        super(1);
        this.a = filtersPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Item item) {
        Item item2 = item;
        FiltersPresenterImpl.access$resubscribeToCounterButton(this.a);
        ParametersTreeWithAdditional parametersTreeWithAdditional = this.a.i;
        Object obj = null;
        ParameterSlot findParameter = parametersTreeWithAdditional != null ? parametersTreeWithAdditional.findParameter(item2.getStringId()) : null;
        if (item2 instanceof ChangeDisplayTypeItem) {
            this.a.j = ((ChangeDisplayTypeItem) item2).getDisplayType();
        } else if (item2 instanceof ParameterElement.Input) {
            int i = 0;
            if (findParameter instanceof PriceParameter) {
                FiltersInteractor interactor = this.a.getInteractor();
                EditableParameter editableParameter = (EditableParameter) findParameter;
                String value = ((ParameterElement.Input) item2).getValue();
                if (value != null) {
                    StringBuilder sb = new StringBuilder();
                    int length = value.length();
                    while (i < length) {
                        char charAt = value.charAt(i);
                        if (Character.isDigit(charAt)) {
                            sb.append(charAt);
                        }
                        i++;
                    }
                    obj = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(obj, "filterTo(StringBuilder(), predicate).toString()");
                }
                FiltersInteractor.DefaultImpls.applyParameterValue$default(interactor, editableParameter, obj, false, 4, null);
            } else if (findParameter instanceof IntParameter) {
                FiltersInteractor interactor2 = this.a.getInteractor();
                EditableParameter editableParameter2 = (EditableParameter) findParameter;
                String value2 = ((ParameterElement.Input) item2).getValue();
                if (value2 != null) {
                    StringBuilder sb2 = new StringBuilder();
                    int length2 = value2.length();
                    while (i < length2) {
                        char charAt2 = value2.charAt(i);
                        if (Character.isDigit(charAt2)) {
                            sb2.append(charAt2);
                        }
                        i++;
                    }
                    String sb3 = sb2.toString();
                    Intrinsics.checkNotNullExpressionValue(sb3, "filterTo(StringBuilder(), predicate).toString()");
                    if (sb3 != null) {
                        obj = l.toLongOrNull(sb3);
                    }
                }
                FiltersInteractor.DefaultImpls.applyParameterValue$default(interactor2, editableParameter2, obj, false, 4, null);
            } else if (findParameter instanceof NumericParameter) {
                FiltersInteractor interactor3 = this.a.getInteractor();
                EditableParameter editableParameter3 = (EditableParameter) findParameter;
                String value3 = ((ParameterElement.Input) item2).getValue();
                if (value3 != null) {
                    obj = k.toDoubleOrNull(value3);
                }
                FiltersInteractor.DefaultImpls.applyParameterValue$default(interactor3, editableParameter3, obj, false, 4, null);
            }
        } else if ((item2 instanceof CheckBoxItem) && (findParameter instanceof BooleanParameter)) {
            FiltersInteractor.DefaultImpls.applyParameterValue$default(this.a.getInteractor(), (EditableParameter) findParameter, Boolean.valueOf(((CheckBoxItem) item2).isChecked()), false, 4, null);
        } else if ((item2 instanceof ParameterElement.Select) && (findParameter instanceof SelectParameter)) {
            ParameterElement.Select select = (ParameterElement.Select) item2;
            if (select.isSerpDisplayType()) {
                this.a.m = true;
            }
            FiltersPresenterImpl.access$updateDataSourceSelectedValue(this.a, select, select.getSelectedValue());
            FiltersInteractor interactor4 = this.a.getInteractor();
            EditableParameter editableParameter4 = (EditableParameter) findParameter;
            SelectableItem selectedValue = select.getSelectedValue();
            if (selectedValue != null) {
                obj = selectedValue.getStringId();
            }
            FiltersInteractor.DefaultImpls.applyParameterValue$default(interactor4, editableParameter4, obj, false, 4, null);
        } else if ((item2 instanceof ParameterElement.Multiselect) && (findParameter instanceof MultiselectParameter)) {
            FiltersInteractor interactor5 = this.a.getInteractor();
            EditableParameter editableParameter5 = (EditableParameter) findParameter;
            List<SelectableItem> values = ((ParameterElement.Multiselect) item2).getValues();
            ArrayList arrayList = new ArrayList();
            for (T t : values) {
                if (t.isSelected()) {
                    arrayList.add(t);
                }
            }
            ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((SelectableItem) it.next()).getStringId());
            }
            FiltersInteractor.DefaultImpls.applyParameterValue$default(interactor5, editableParameter5, arrayList2, false, 4, null);
        }
        return Unit.INSTANCE;
    }
}
