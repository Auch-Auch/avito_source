package com.avito.android.remote.parse.adapter;

import com.avito.android.Features;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.category_parameters.BooleanParameter;
import com.avito.android.remote.model.category_parameters.CharParameter;
import com.avito.android.remote.model.category_parameters.DateRangeParameter;
import com.avito.android.remote.model.category_parameters.DateTimeIntervalParameter;
import com.avito.android.remote.model.category_parameters.DirectionParameter;
import com.avito.android.remote.model.category_parameters.DistrictParameter;
import com.avito.android.remote.model.category_parameters.EditCategoryParameter;
import com.avito.android.remote.model.category_parameters.EmailParameter;
import com.avito.android.remote.model.category_parameters.GroupParameter;
import com.avito.android.remote.model.category_parameters.IntParameter;
import com.avito.android.remote.model.category_parameters.LocationParameter;
import com.avito.android.remote.model.category_parameters.MetroParameter;
import com.avito.android.remote.model.category_parameters.MultiselectParameter;
import com.avito.android.remote.model.category_parameters.NumericParameter;
import com.avito.android.remote.model.category_parameters.ObjectsParameter;
import com.avito.android.remote.model.category_parameters.PhoneParameter;
import com.avito.android.remote.model.category_parameters.PhotoParameter;
import com.avito.android.remote.model.category_parameters.PriceParameter;
import com.avito.android.remote.model.category_parameters.QuartersParameter;
import com.avito.android.remote.model.category_parameters.RangeParameter;
import com.avito.android.remote.model.category_parameters.SearchRadiusParameter;
import com.avito.android.remote.model.category_parameters.SelectCategoryParameter;
import com.avito.android.remote.model.category_parameters.SelectDeepLinkParameter;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.remote.model.category_parameters.UnknownParameter;
import com.avito.android.remote.model.category_parameters.VideoParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.category_parameters.slot.BaseSlot;
import com.avito.android.util.preferences.db_preferences.Types;
import com.facebook.appevents.integrity.IntegrityManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/parse/adapter/CategoryParameterTypeAdapterFactory;", "", "Lcom/avito/android/remote/parse/adapter/RuntimeTypeAdapterFactory;", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "create", "()Lcom/avito/android/remote/parse/adapter/RuntimeTypeAdapterFactory;", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/Features;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryParameterTypeAdapterFactory {
    public CategoryParameterTypeAdapterFactory(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
    }

    @NotNull
    public final RuntimeTypeAdapterFactory<ParameterSlot> create() {
        RuntimeTypeAdapterFactory<ParameterSlot> registerSubtype = RuntimeTypeAdapterFactory.of(ParameterSlot.class).registerSubtype(PhoneParameter.class, "phone").registerSubtype(IntParameter.class, Types.INT).registerSubtype(BooleanParameter.class, Types.BOOLEAN).registerSubtype(NumericParameter.class, "numeric").registerSubtype(SelectParameter.Flat.class, "select").registerSubtype(SelectParameter.Sectioned.class, "sectionedSelect").registerSubtype(AddressParameter.class, IntegrityManager.INTEGRITY_TYPE_ADDRESS).registerSubtype(ObjectsParameter.class, "objects").registerSubtype(DateTimeIntervalParameter.class, "datetime-interval").registerSubtype(MultiselectParameter.class, "multiselect").registerSubtype(EmailParameter.class, "email").registerSubtype(LocationParameter.class, "location").registerSubtype(SearchRadiusParameter.class, "searchRadius").registerSubtype(MetroParameter.class, "metro").registerSubtype(DirectionParameter.class, "direction").registerSubtype(DistrictParameter.class, "district").registerSubtype(SelectCategoryParameter.class, "category").registerSubtype(PriceParameter.class, "price").registerSubtype(GroupParameter.class, Navigation.GROUP).registerSubtype(CharParameter.class, "description").registerSubtype(PhotoParameter.class, "photos").registerSubtype(EditCategoryParameter.class, "editCategory").registerSubtype(DateRangeParameter.class, "dateRange").registerSubtype(BaseSlot.class, "slot").registerSubtype(RangeParameter.class, "range").registerSubtype(SelectDeepLinkParameter.class, "selectDeepLink").registerSubtype(VideoParameter.class, "video").registerSubtype(QuartersParameter.class, "quarters").registerFallbackSubtype(UnknownParameter.class).registerSubtype(CharParameter.class, "char", new CharParameterTypeAdapterFactory());
        Intrinsics.checkNotNullExpressionValue(registerSubtype, "RuntimeTypeAdapterFactor…eterTypeAdapterFactory())");
        return registerSubtype;
    }
}
