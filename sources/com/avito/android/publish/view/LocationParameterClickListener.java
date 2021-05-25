package com.avito.android.publish.view;

import com.avito.android.item_legacy.details.ParametersSource;
import com.avito.android.item_legacy.details.SelectParameterClickListener;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.conveyor_item.Item;
import com.facebook.appevents.integrity.IntegrityManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0013J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/avito/android/publish/view/LocationParameterClickListener;", "", "Lcom/avito/android/publish/view/LocationParameterClickListener$Router;", "router", "", "attachRouter", "(Lcom/avito/android/publish/view/LocationParameterClickListener$Router;)V", "Lcom/avito/android/item_legacy/details/ParametersSource;", "source", "setParametersSource", "(Lcom/avito/android/item_legacy/details/ParametersSource;)V", "detachRouter", "()V", "Lcom/avito/conveyor_item/Item;", "item", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "parameter", "onLocationParameterClicked", "(Lcom/avito/conveyor_item/Item;Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;)V", "Router", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface LocationParameterClickListener {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/publish/view/LocationParameterClickListener$Router;", "Lcom/avito/android/item_legacy/details/SelectParameterClickListener$Router;", "Lcom/avito/android/remote/model/category_parameters/AddressParameter;", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "", "showLocationPicker", "(Lcom/avito/android/remote/model/category_parameters/AddressParameter;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public interface Router extends SelectParameterClickListener.Router {
        void showLocationPicker(@NotNull AddressParameter addressParameter);
    }

    void attachRouter(@Nullable Router router);

    void detachRouter();

    void onLocationParameterClicked(@NotNull Item item, @NotNull ParameterSlot parameterSlot);

    void setParametersSource(@NotNull ParametersSource parametersSource);
}
