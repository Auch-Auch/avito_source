package com.avito.android.publish.details;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.publish.details.analytics.PublishDetailsFlowTracker;
import com.avito.android.publish.slots.ConsumeValueChangeResult;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.base.CategoryParameter;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.category_parameters.slot.SlotType;
import com.avito.conveyor_item.Item;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"publish_release"}, k = 2, mv = {1, 4, 2})
public final class PublishDetailsPresenterKt {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            SlotType.values();
            int[] iArr = new int[19];
            $EnumSwitchMapping$0 = iArr;
            SlotType slotType = SlotType.ANONYMOUS_NUMBER;
            iArr[6] = 1;
            SlotType slotType2 = SlotType.CONTACT_INFO;
            iArr[2] = 2;
            SlotType slotType3 = SlotType.INFORMATION_WITH_USER_ID;
            iArr[16] = 3;
            SlotType slotType4 = SlotType.MARKET_PRICE;
            iArr[5] = 4;
            SlotType slotType5 = SlotType.AUTO_PUBLISH;
            iArr[10] = 5;
        }
    }

    public static final CategoryParameter access$firstEmptyParameter(ParametersTree parametersTree, String str) {
        int i = 0;
        if (str != null) {
            Iterator it = parametersTree.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                Object next = it.next();
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                if (Intrinsics.areEqual(((ParameterSlot) next).getId(), str)) {
                    break;
                }
                i++;
            }
            i++;
        }
        int count = parametersTree.getCount();
        while (i < count) {
            ParameterSlot parameterSlot = (ParameterSlot) parametersTree.getItem(i);
            if ((parameterSlot instanceof EditableParameter) && !((EditableParameter) parameterSlot).hasValue()) {
                return (CategoryParameter) parameterSlot;
            }
            i++;
        }
        return null;
    }

    public static final boolean access$hasDeferredSizeChange(Item item) {
        return item instanceof ParameterElement.Photo;
    }

    public static final PublishDetailsFlowTracker.FlowContext access$toFlowContext(ConsumeValueChangeResult consumeValueChangeResult) {
        int ordinal = consumeValueChangeResult.getSlotType().ordinal();
        if (ordinal == 2) {
            return PublishDetailsFlowTracker.FlowContext.CONTACT_INFO_SLOT_UPDATE;
        }
        if (ordinal == 10) {
            return PublishDetailsFlowTracker.FlowContext.AUTO_PUBLISH_SLOT_UPDATE;
        }
        if (ordinal == 16) {
            return PublishDetailsFlowTracker.FlowContext.INFORMATION_WITH_USER_ID_SLOT_UPDATE;
        }
        if (ordinal == 5) {
            return PublishDetailsFlowTracker.FlowContext.MARKET_PRICE_SLOT_UPDATE;
        }
        if (ordinal != 6) {
            return null;
        }
        return PublishDetailsFlowTracker.FlowContext.ANONYMOUS_NUMBER_SLOT_UPDATE;
    }
}
