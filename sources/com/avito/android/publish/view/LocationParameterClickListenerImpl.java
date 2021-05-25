package com.avito.android.publish.view;

import com.avito.android.item_legacy.details.ParametersSource;
import com.avito.android.items.ItemWithErrors;
import com.avito.android.publish.view.LocationParameterClickListener;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sublocation;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.category_parameters.SubLocationParameter;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.select.Arguments;
import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0018\u0010\fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/avito/android/publish/view/LocationParameterClickListenerImpl;", "Lcom/avito/android/publish/view/LocationParameterClickListener;", "Lcom/avito/android/publish/view/LocationParameterClickListener$Router;", "router", "", "attachRouter", "(Lcom/avito/android/publish/view/LocationParameterClickListener$Router;)V", "Lcom/avito/android/item_legacy/details/ParametersSource;", "source", "setParametersSource", "(Lcom/avito/android/item_legacy/details/ParametersSource;)V", "detachRouter", "()V", "Lcom/avito/conveyor_item/Item;", "item", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "parameter", "onLocationParameterClicked", "(Lcom/avito/conveyor_item/Item;Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;)V", AuthSource.BOOKING_ORDER, "Lcom/avito/android/publish/view/LocationParameterClickListener$Router;", AuthSource.SEND_ABUSE, "Lcom/avito/android/item_legacy/details/ParametersSource;", "parametersSource", "<init>", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class LocationParameterClickListenerImpl implements LocationParameterClickListener {
    public ParametersSource a;
    public LocationParameterClickListener.Router b;

    @Override // com.avito.android.publish.view.LocationParameterClickListener
    public void attachRouter(@Nullable LocationParameterClickListener.Router router) {
        this.b = router;
    }

    @Override // com.avito.android.publish.view.LocationParameterClickListener
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.publish.view.LocationParameterClickListener
    public void onLocationParameterClicked(@NotNull Item item, @NotNull ParameterSlot parameterSlot) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(parameterSlot, "parameter");
        if (item instanceof ItemWithErrors) {
            ((ItemWithErrors) item).clearErrors();
        }
        if (parameterSlot instanceof EditableParameter) {
            ((EditableParameter) parameterSlot).setError(null);
        }
        if (parameterSlot instanceof AddressParameter) {
            LocationParameterClickListener.Router router = this.b;
            if (router != null) {
                router.showLocationPicker((AddressParameter) parameterSlot);
            }
        } else if (parameterSlot instanceof SubLocationParameter) {
            SubLocationParameter subLocationParameter = (SubLocationParameter) parameterSlot;
            Sublocation sublocation = (Sublocation) subLocationParameter.getValue();
            List listOf = sublocation != null ? d.listOf(sublocation) : CollectionsKt__CollectionsKt.emptyList();
            LocationParameterClickListener.Router router2 = this.b;
            if (router2 != null) {
                router2.showSelectScreen(new Arguments(subLocationParameter.getId(), subLocationParameter.getValues(), listOf, subLocationParameter.getTitle(), true, false, !subLocationParameter.getRequired(), false, false, false, null, false, false, null, 15872, null));
            }
        }
    }

    @Override // com.avito.android.publish.view.LocationParameterClickListener
    public void setParametersSource(@NotNull ParametersSource parametersSource) {
        Intrinsics.checkNotNullParameter(parametersSource, "source");
        this.a = parametersSource;
    }
}
