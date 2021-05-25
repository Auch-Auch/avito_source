package a2.a.a.k2.a;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.remote.model.category_parameters.DateRangeParameter;
import com.avito.android.remote.model.category_parameters.LocationParameter;
import com.avito.android.remote.model.category_parameters.MetroParameter;
import com.avito.android.remote.model.category_parameters.MultiselectParameter;
import com.avito.android.remote.model.category_parameters.QuartersParameter;
import com.avito.android.remote.model.category_parameters.SearchRadiusParameter;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.search.filter.FiltersPresenterImpl;
import com.avito.android.search.filter.ParametersTreeWithAdditional;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class x extends Lambda implements Function1<ParameterElement, Unit> {
    public final /* synthetic */ FiltersPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x(FiltersPresenterImpl filtersPresenterImpl) {
        super(1);
        this.a = filtersPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(ParameterElement parameterElement) {
        ParameterSlot findParameter;
        ParameterElement parameterElement2 = parameterElement;
        ParametersTreeWithAdditional parametersTreeWithAdditional = this.a.i;
        if (!(parametersTreeWithAdditional == null || (findParameter = parametersTreeWithAdditional.findParameter(parameterElement2.getStringId())) == null)) {
            if (parameterElement2 instanceof ParameterElement.Select) {
                if (findParameter instanceof SelectParameter) {
                    FiltersPresenterImpl.access$onSelectClicked(this.a, (ParameterElement.Select) parameterElement2, (SelectParameter) findParameter);
                } else if (findParameter instanceof LocationParameter) {
                    FiltersPresenterImpl.access$showLocationScreen(this.a, (LocationParameter) findParameter, FiltersPresenterImpl.access$getCategoryId(this.a));
                } else if (findParameter instanceof SearchRadiusParameter) {
                    FiltersPresenterImpl filtersPresenterImpl = this.a;
                    FiltersPresenterImpl.access$showSearchRadiusPickerScreen(filtersPresenterImpl, filtersPresenterImpl.getInteractor().getSearchParamsOrEmpty(), (SearchRadiusParameter) findParameter);
                } else if (findParameter instanceof DateRangeParameter) {
                    FiltersPresenterImpl.access$onSelectDatesClicked(this.a, (ParameterElement.Select) parameterElement2, (DateRangeParameter) findParameter);
                } else if (findParameter instanceof QuartersParameter) {
                    FiltersPresenterImpl.access$showSelectScreen(this.a, (QuartersParameter) findParameter);
                }
            } else if (parameterElement2 instanceof ParameterElement.Multiselect) {
                if (findParameter instanceof MultiselectParameter) {
                    FiltersPresenterImpl.access$onMultiselectClicked(this.a, (ParameterElement.Multiselect) parameterElement2, (MultiselectParameter) findParameter);
                } else if (findParameter instanceof MetroParameter) {
                    FiltersPresenterImpl.access$onSelectMetroClicked(this.a, (MetroParameter) findParameter);
                }
            }
        }
        return Unit.INSTANCE;
    }
}
