package com.avito.android.publish.view;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.item_legacy.details.ParametersSource;
import com.avito.android.items.InputItem;
import com.avito.android.items.ItemWithAdditionalButton;
import com.avito.android.items.ItemWithErrors;
import com.avito.android.publish.view.BasicParameterClickListener;
import com.avito.android.publish.view.ItemDetailsParameterClickListener;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.EditCategoryParameter;
import com.avito.android.remote.model.category_parameters.ObjectsParameter;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.base.CategoryParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.category_parameters.slot.edit_category.EditCategorySlot;
import com.avito.android.remote.model.category_parameters.slot.residential_complex.ResidentialComplexSelect;
import com.avito.conveyor_item.Item;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010;\u001a\u00020\u0002¢\u0006\u0004\b=\u0010>J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u0006\u0010\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ<\u0010%\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\"H\u0001¢\u0006\u0004\b%\u0010&J\u0018\u0010'\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0004\b'\u0010\rJ*\u0010,\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020(2\u0006\u0010*\u001a\u00020)2\b\b\u0002\u0010+\u001a\u00020\"H\u0001¢\u0006\u0004\b,\u0010-J\u0018\u0010/\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020.H\u0001¢\u0006\u0004\b/\u00100J\u0018\u00103\u001a\u00020\u00052\u0006\u00102\u001a\u000201H\u0001¢\u0006\u0004\b3\u00104J#\u00105\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b5\u00106J\u001f\u00108\u001a\u0004\u0018\u000107*\u0004\u0018\u0001012\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b8\u00109R\u0016\u0010;\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u0010:R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u0010<¨\u0006?"}, d2 = {"Lcom/avito/android/publish/view/ItemDetailsParameterClickListenerImpl;", "Lcom/avito/android/publish/view/ItemDetailsParameterClickListener;", "Lcom/avito/android/publish/view/BasicParameterClickListener;", "Lcom/avito/android/publish/view/ItemDetailsParameterClickListener$Router;", "router", "", "attachRouter", "(Lcom/avito/android/publish/view/ItemDetailsParameterClickListener$Router;)V", "detachRouter", "()V", "Lcom/avito/conveyor_item/Item;", "element", "onElementClicked", "(Lcom/avito/conveyor_item/Item;)V", "Lcom/avito/android/category_parameters/ParameterElement$Objects;", "", "objectPosition", "onElementObjectClicked", "(Lcom/avito/android/category_parameters/ParameterElement$Objects;I)V", "onAddMoreObjectsClicked", "(Lcom/avito/android/category_parameters/ParameterElement$Objects;)V", "Lcom/avito/android/publish/view/BasicParameterClickListener$Router;", "(Lcom/avito/android/publish/view/BasicParameterClickListener$Router;)V", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "getCategoryParameters", "()Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "getParametersTree", "()Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "Lcom/avito/android/category_parameters/ParameterElement$DateInterval;", "Lcom/avito/android/category_parameters/ParameterElement$DateTime;", "dateTime", "", "timestamp", "", "presentTime", "updateDateTime", "onDateIntervalValueChanged", "(Lcom/avito/android/category_parameters/ParameterElement$DateInterval;Lcom/avito/android/category_parameters/ParameterElement$DateTime;Ljava/lang/Long;ZZ)V", "onElementErrorDismissed", "Lcom/avito/android/items/InputItem;", "", "newValue", "updateElement", "onElementValueChanged", "(Lcom/avito/android/items/InputItem;Ljava/lang/String;Z)V", "Lcom/avito/android/items/ItemWithAdditionalButton;", "onInputAdditionalButtonClick", "(Lcom/avito/android/items/ItemWithAdditionalButton;)V", "Lcom/avito/android/item_legacy/details/ParametersSource;", "source", "setParametersSource", "(Lcom/avito/android/item_legacy/details/ParametersSource;)V", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/category_parameters/ParameterElement$Objects;Ljava/lang/Integer;)V", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/item_legacy/details/ParametersSource;Lcom/avito/conveyor_item/Item;)Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "Lcom/avito/android/publish/view/BasicParameterClickListener;", "basicParameterClickListener", "Lcom/avito/android/publish/view/ItemDetailsParameterClickListener$Router;", "<init>", "(Lcom/avito/android/publish/view/BasicParameterClickListener;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ItemDetailsParameterClickListenerImpl implements ItemDetailsParameterClickListener, BasicParameterClickListener {
    public ItemDetailsParameterClickListener.Router a;
    public final BasicParameterClickListener b;

    @Inject
    public ItemDetailsParameterClickListenerImpl(@NotNull BasicParameterClickListener basicParameterClickListener) {
        Intrinsics.checkNotNullParameter(basicParameterClickListener, "basicParameterClickListener");
        this.b = basicParameterClickListener;
    }

    public final ParameterSlot a(ParametersSource parametersSource, Item item) {
        ParametersTree parametersTree;
        if (parametersSource == null || (parametersTree = parametersSource.getParametersTree()) == null) {
            return null;
        }
        return parametersTree.findParameter(item.getStringId());
    }

    @Override // com.avito.android.publish.view.BasicParameterClickListener
    public void attachRouter(@NotNull BasicParameterClickListener.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b.attachRouter(router);
    }

    @Override // com.avito.android.publish.view.ItemDetailsParameterClickListener
    public void attachRouter(@NotNull ItemDetailsParameterClickListener.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b.attachRouter(router);
        this.a = router;
    }

    public final void b(ParameterElement.Objects objects, Integer num) {
        ObjectsParameter objectsParameter;
        ItemDetailsParameterClickListener.Router router;
        CategoryParameters categoryParameters = this.b.getCategoryParameters();
        if (categoryParameters != null && (objectsParameter = (ObjectsParameter) a(this.b, objects)) != null && (router = this.a) != null) {
            router.showEditObjectsScreen(categoryParameters, objectsParameter, num);
        }
    }

    @Override // com.avito.android.publish.view.BasicParameterClickListener
    public void detachRouter() {
        this.b.detachRouter();
        this.a = null;
    }

    @Override // com.avito.android.item_legacy.details.ParametersSource
    @Nullable
    public CategoryParameters getCategoryParameters() {
        return this.b.getCategoryParameters();
    }

    @Override // com.avito.android.item_legacy.details.ParametersSource
    @Nullable
    public ParametersTree getParametersTree() {
        return this.b.getParametersTree();
    }

    @Override // com.avito.android.publish.view.ItemDetailsParameterClickListener
    public void onAddMoreObjectsClicked(@NotNull ParameterElement.Objects objects) {
        Intrinsics.checkNotNullParameter(objects, "element");
        b(objects, null);
    }

    @Override // com.avito.android.publish.view.BasicParameterClickListener
    public void onDateIntervalValueChanged(@NotNull ParameterElement.DateInterval dateInterval, @NotNull ParameterElement.DateTime dateTime, @Nullable Long l, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(dateInterval, "element");
        Intrinsics.checkNotNullParameter(dateTime, "dateTime");
        this.b.onDateIntervalValueChanged(dateInterval, dateTime, l, z, z2);
    }

    @Override // com.avito.android.publish.view.BasicParameterClickListener
    public void onElementClicked(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "element");
        if (item instanceof ItemWithErrors) {
            ((ItemWithErrors) item).clearErrors();
        }
        ParameterSlot a3 = a(this.b, item);
        if (a3 != null) {
            if (a3 instanceof CategoryParameter) {
                BasicParameterClickListenerKt.clearError((CategoryParameter) a3);
            }
            if (a3 instanceof EditCategoryParameter) {
                ItemDetailsParameterClickListener.Router router = this.a;
                if (router != null) {
                    router.onEditClicked();
                }
            } else if (a3 instanceof ResidentialComplexSelect) {
                ItemDetailsParameterClickListener.Router router2 = this.a;
                if (router2 != null) {
                    router2.showResidentialComplexSuggestScreen();
                }
            } else if (a3 instanceof EditCategorySlot) {
                ItemDetailsParameterClickListener.Router router3 = this.a;
                if (router3 != null) {
                    router3.onEditClicked();
                }
            } else {
                this.b.onElementClicked(item);
            }
        }
    }

    @Override // com.avito.android.publish.view.BasicParameterClickListener
    public void onElementErrorDismissed(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "element");
        this.b.onElementErrorDismissed(item);
    }

    @Override // com.avito.android.publish.view.ItemDetailsParameterClickListener
    public void onElementObjectClicked(@NotNull ParameterElement.Objects objects, int i) {
        Intrinsics.checkNotNullParameter(objects, "element");
        b(objects, Integer.valueOf(i));
    }

    @Override // com.avito.android.publish.view.BasicParameterClickListener
    public void onElementValueChanged(@NotNull InputItem inputItem, @NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(inputItem, "element");
        Intrinsics.checkNotNullParameter(str, "newValue");
        this.b.onElementValueChanged(inputItem, str, z);
    }

    @Override // com.avito.android.publish.view.BasicParameterClickListener
    public void onInputAdditionalButtonClick(@NotNull ItemWithAdditionalButton itemWithAdditionalButton) {
        Intrinsics.checkNotNullParameter(itemWithAdditionalButton, "element");
        this.b.onInputAdditionalButtonClick(itemWithAdditionalButton);
    }

    @Override // com.avito.android.publish.view.BasicParameterClickListener
    public void setParametersSource(@NotNull ParametersSource parametersSource) {
        Intrinsics.checkNotNullParameter(parametersSource, "source");
        this.b.setParametersSource(parametersSource);
    }
}
