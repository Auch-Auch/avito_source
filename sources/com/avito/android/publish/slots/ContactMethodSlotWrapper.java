package com.avito.android.publish.slots;

import com.avito.android.publish.slots.ConsumeValueChangeResult;
import com.avito.android.publish.slots.SlotWrapper;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.category_parameters.slot.SlotType;
import com.avito.android.remote.model.category_parameters.slot.contact_method.ContactMethodSlot;
import com.avito.android.remote.model.category_parameters.slot.contact_method.ContactMethodSlotConfig;
import com.avito.android.remote.model.category_parameters.slot.contact_method.ContactMethodSlotValue;
import com.avito.android.util.LoadingState;
import com.avito.conveyor_item.Item;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0011\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/publish/slots/ContactMethodSlotWrapper;", "Lcom/avito/android/publish/slots/SlotWrapper;", "Lcom/avito/android/remote/model/category_parameters/slot/contact_method/ContactMethodSlot;", "Lcom/avito/conveyor_item/Item;", "element", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "param", "Lcom/avito/android/publish/slots/ConsumeValueChangeResult;", "consumeItemValueChange", "(Lcom/avito/conveyor_item/Item;Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;)Lcom/avito/android/publish/slots/ConsumeValueChangeResult;", "", "getId", "()Ljava/lang/String;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/category_parameters/slot/contact_method/ContactMethodSlot;", "getSlot", "()Lcom/avito/android/remote/model/category_parameters/slot/contact_method/ContactMethodSlot;", "slot", "<init>", "(Lcom/avito/android/remote/model/category_parameters/slot/contact_method/ContactMethodSlot;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ContactMethodSlotWrapper implements SlotWrapper<ContactMethodSlot> {
    @NotNull
    public final ContactMethodSlot a;

    public ContactMethodSlotWrapper(@NotNull ContactMethodSlot contactMethodSlot) {
        Intrinsics.checkNotNullParameter(contactMethodSlot, "slot");
        this.a = contactMethodSlot;
        SelectParameter.Flat field = ((ContactMethodSlotConfig) getSlot().getWidget().getConfig()).getField();
        ContactMethodSlotValue value = getSlot().getValue();
        field.setValue(value != null ? value.getContactMethod() : null);
        getSlot().initParameters();
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public Observable<LoadingState<SuccessResult>> checkErrors() {
        return SlotWrapper.DefaultImpls.checkErrors(this);
    }

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public ConsumeValueChangeResult consumeItemValueChange(@Nullable Item item, @Nullable ParameterSlot parameterSlot) {
        if (!Intrinsics.areEqual(parameterSlot != null ? parameterSlot.getId() : null, ((ContactMethodSlotConfig) getSlot().getWidget().getConfig()).getField().getId())) {
            return ConsumeValueChangeResult.NoChange.INSTANCE;
        }
        String str = (String) ((ContactMethodSlotConfig) getSlot().getWidget().getConfig()).getField().getValue();
        if (str != null) {
            getSlot().setValue(new ContactMethodSlotValue(str));
        }
        return new ConsumeValueChangeResult.NeedViewUpdate(SlotType.CONTACT_METHOD);
    }

    @Override // com.avito.android.category_parameters.SlotElementsProvider
    @NotNull
    public List<Item> getElements() {
        return SlotWrapper.DefaultImpls.getElements(this);
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

    @Override // com.avito.android.publish.slots.SlotWrapper
    @NotNull
    public ContactMethodSlot getSlot() {
        return this.a;
    }
}
