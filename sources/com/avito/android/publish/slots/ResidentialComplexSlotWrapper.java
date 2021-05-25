package com.avito.android.publish.slots;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.items.ItemWithState;
import com.avito.android.items.SelectableItem;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.publish.slots.SlotWrapper;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.category_parameters.CharParameter;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.category_parameters.slot.residential_complex.ResidentialComplexSlot;
import com.avito.android.remote.model.category_parameters.slot.residential_complex.ResidentialComplexSlotConfig;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.LoadingState;
import com.avito.conveyor_item.Item;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\"\u001a\u00020\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u0003*\b\u0012\u0004\u0012\u00020\u00030\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u001a\u001a\u00020\u0019*\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u00020\u001c*\b\u0012\u0004\u0012\u00020\u00030\u0014H\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\"\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/avito/android/publish/slots/ResidentialComplexSlotWrapper;", "Lcom/avito/android/publish/slots/SlotWrapper;", "Lcom/avito/android/remote/model/category_parameters/slot/residential_complex/ResidentialComplexSlot;", "", "getId", "()Ljava/lang/String;", "", "Lcom/avito/conveyor_item/Item;", "getElements", "()Ljava/util/List;", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value;", "value", "", "setValue", "(Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value;)V", "", "items", AuthSource.SEND_ABUSE, "(Ljava/util/List;)V", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "c", "(Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;)Ljava/lang/String;", "", "isSelected", "Lcom/avito/android/items/SelectableItem;", "e", "(Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value;Z)Lcom/avito/android/items/SelectableItem;", "Lcom/avito/android/items/ItemWithState$State;", "d", "(Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;)Lcom/avito/android/items/ItemWithState$State;", "Lcom/avito/android/remote/model/category_parameters/slot/residential_complex/ResidentialComplexSlot;", "getSlot", "()Lcom/avito/android/remote/model/category_parameters/slot/residential_complex/ResidentialComplexSlot;", "slot", "<init>", "(Lcom/avito/android/remote/model/category_parameters/slot/residential_complex/ResidentialComplexSlot;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ResidentialComplexSlotWrapper implements SlotWrapper<ResidentialComplexSlot> {
    @NotNull
    public final ResidentialComplexSlot a;

    public ResidentialComplexSlotWrapper(@NotNull ResidentialComplexSlot residentialComplexSlot) {
        Intrinsics.checkNotNullParameter(residentialComplexSlot, "slot");
        this.a = residentialComplexSlot;
        getSlot().initParameters();
    }

    public final void a(List<Item> list) {
        CharParameter buildingQueue = ((ResidentialComplexSlotConfig) getSlot().getWidget().getConfig()).getBuildingQueue();
        if (buildingQueue != null) {
            String c = c(buildingQueue);
            String error = buildingQueue.getError();
            String title = buildingQueue.getTitle();
            AttributedText motivation = buildingQueue.getMotivation();
            FormatterType formatterType = new FormatterType(Integer.MAX_VALUE, null, 1, null, 10, null);
            list.add(new ParameterElement.Input(buildingQueue.getId(), buildingQueue.getTitle(), (String) buildingQueue.getValue(), c, error, 1, 1, null, null, null, null, null, buildingQueue.getDisplayingOptions(), title, motivation, d(buildingQueue), formatterType, false, null, 397184, null));
        }
    }

    public final void b(List<Item> list) {
        CharParameter spec = ((ResidentialComplexSlotConfig) getSlot().getWidget().getConfig()).getSpec();
        if (spec != null) {
            String c = c(spec);
            String error = spec.getError();
            String title = spec.getTitle();
            AttributedText motivation = spec.getMotivation();
            FormatterType formatterType = new FormatterType(Integer.MAX_VALUE, null, 1, null, 10, null);
            list.add(new ParameterElement.Input(spec.getId(), spec.getTitle(), (String) spec.getValue(), c, error, 1, 1, null, null, null, null, null, spec.getDisplayingOptions(), title, motivation, d(spec), formatterType, false, null, 397184, null));
        }
    }

    public final String c(EditableParameter<String> editableParameter) {
        if (!editableParameter.hasError()) {
            return null;
        }
        if (editableParameter.hasValue()) {
            return editableParameter.getValue();
        }
        return editableParameter.getTitle();
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public Observable<LoadingState<SuccessResult>> checkErrors() {
        return SlotWrapper.DefaultImpls.checkErrors(this);
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public ConsumeValueChangeResult consumeItemValueChange(@Nullable Item item, @Nullable ParameterSlot parameterSlot) {
        return SlotWrapper.DefaultImpls.consumeItemValueChange(this, item, parameterSlot);
    }

    public final ItemWithState.State d(EditableParameter<String> editableParameter) {
        String error;
        String error2 = editableParameter.getError();
        boolean z = false;
        if (error2 != null) {
            if (error2.length() > 0) {
                z = true;
            }
        }
        if (!z || (error = editableParameter.getError()) == null) {
            return new ItemWithState.State.Normal(null, 1, null);
        }
        return new ItemWithState.State.Error(error, null, 2, null);
    }

    public final SelectableItem e(SelectParameter.Value value, boolean z) {
        return new SelectableItem(value.getId(), value.getTitle(), z, null, 8, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x016b  */
    @Override // com.avito.android.category_parameters.SlotElementsProvider
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.avito.conveyor_item.Item> getElements() {
        /*
        // Method dump skipped, instructions count: 370
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.publish.slots.ResidentialComplexSlotWrapper.getElements():java.util.List");
    }

    @Override // com.avito.android.category_parameters.SlotElementsProvider
    @NotNull
    public String getId() {
        return getSlot().getId();
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public Observable<LoadingState<Unit>> prepare() {
        return SlotWrapper.DefaultImpls.prepare(this);
    }

    public final void setValue(@NotNull SelectParameter.Value value) {
        Intrinsics.checkNotNullParameter(value, "value");
        ((ResidentialComplexSlotConfig) getSlot().getWidget().getConfig()).getDevelopment().setValue(value.getId());
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public ResidentialComplexSlot getSlot() {
        return this.a;
    }
}
