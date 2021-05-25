package com.avito.android.publish.view;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.item_legacy.details.ParametersSource;
import com.avito.android.item_legacy.details.SelectParameterClickListener;
import com.avito.android.items.InputItem;
import com.avito.android.items.ItemWithAdditionalButton;
import com.avito.android.publish.view.LocationParameterClickListener;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001$J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J;\u0010\u0018\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\rH&¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0001H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u001dH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u001dH&¢\u0006\u0004\b \u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020!H&¢\u0006\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/avito/android/publish/view/BasicParameterClickListener;", "Lcom/avito/android/item_legacy/details/ParametersSource;", "Lcom/avito/android/publish/view/BasicParameterClickListener$Router;", "router", "", "attachRouter", "(Lcom/avito/android/publish/view/BasicParameterClickListener$Router;)V", "detachRouter", "()V", "Lcom/avito/android/items/InputItem;", "element", "", "newValue", "", "updateElement", "onElementValueChanged", "(Lcom/avito/android/items/InputItem;Ljava/lang/String;Z)V", "Lcom/avito/android/category_parameters/ParameterElement$DateInterval;", "Lcom/avito/android/category_parameters/ParameterElement$DateTime;", "dateTime", "", "timestamp", "presentTime", "updateDateTime", "onDateIntervalValueChanged", "(Lcom/avito/android/category_parameters/ParameterElement$DateInterval;Lcom/avito/android/category_parameters/ParameterElement$DateTime;Ljava/lang/Long;ZZ)V", "source", "setParametersSource", "(Lcom/avito/android/item_legacy/details/ParametersSource;)V", "Lcom/avito/conveyor_item/Item;", "onElementClicked", "(Lcom/avito/conveyor_item/Item;)V", "onElementErrorDismissed", "Lcom/avito/android/items/ItemWithAdditionalButton;", "onInputAdditionalButtonClick", "(Lcom/avito/android/items/ItemWithAdditionalButton;)V", "Router", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface BasicParameterClickListener extends ParametersSource {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void onDateIntervalValueChanged$default(BasicParameterClickListener basicParameterClickListener, ParameterElement.DateInterval dateInterval, ParameterElement.DateTime dateTime, Long l, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                basicParameterClickListener.onDateIntervalValueChanged(dateInterval, dateTime, l, z, (i & 16) != 0 ? true : z2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onDateIntervalValueChanged");
        }

        public static /* synthetic */ void onElementValueChanged$default(BasicParameterClickListener basicParameterClickListener, InputItem inputItem, String str, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    z = true;
                }
                basicParameterClickListener.onElementValueChanged(inputItem, str, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onElementValueChanged");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/publish/view/BasicParameterClickListener$Router;", "Lcom/avito/android/publish/view/LocationParameterClickListener$Router;", "Lcom/avito/android/item_legacy/details/SelectParameterClickListener$Router;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "openDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public interface Router extends LocationParameterClickListener.Router, SelectParameterClickListener.Router {
        void openDeepLink(@NotNull DeepLink deepLink);
    }

    void attachRouter(@NotNull Router router);

    void detachRouter();

    void onDateIntervalValueChanged(@NotNull ParameterElement.DateInterval dateInterval, @NotNull ParameterElement.DateTime dateTime, @Nullable Long l, boolean z, boolean z2);

    void onElementClicked(@NotNull Item item);

    void onElementErrorDismissed(@NotNull Item item);

    void onElementValueChanged(@NotNull InputItem inputItem, @NotNull String str, boolean z);

    void onInputAdditionalButtonClick(@NotNull ItemWithAdditionalButton itemWithAdditionalButton);

    void setParametersSource(@NotNull ParametersSource parametersSource);
}
