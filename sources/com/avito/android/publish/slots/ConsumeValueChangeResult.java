package com.avito.android.publish.slots;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.category_parameters.slot.SlotType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\b\t\nR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/publish/slots/ConsumeValueChangeResult;", "", "Lcom/avito/android/remote/model/category_parameters/slot/SlotType;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/category_parameters/slot/SlotType;", "getSlotType", "()Lcom/avito/android/remote/model/category_parameters/slot/SlotType;", "slotType", "NeedValueExpose", "NeedViewUpdate", "NoChange", "Lcom/avito/android/publish/slots/ConsumeValueChangeResult$NoChange;", "Lcom/avito/android/publish/slots/ConsumeValueChangeResult$NeedViewUpdate;", "Lcom/avito/android/publish/slots/ConsumeValueChangeResult$NeedValueExpose;", "publish_release"}, k = 1, mv = {1, 4, 2})
public abstract class ConsumeValueChangeResult {
    @NotNull
    public final SlotType a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/avito/android/publish/slots/ConsumeValueChangeResult$NeedValueExpose;", "Lcom/avito/android/publish/slots/ConsumeValueChangeResult;", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "getSlot", "()Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "slot", "Lcom/avito/android/remote/model/category_parameters/slot/SlotType;", "slotType", "<init>", "(Lcom/avito/android/remote/model/category_parameters/slot/SlotType;Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class NeedValueExpose extends ConsumeValueChangeResult {
        @NotNull
        public final ParameterSlot b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NeedValueExpose(@NotNull SlotType slotType, @NotNull ParameterSlot parameterSlot) {
            super(slotType, null);
            Intrinsics.checkNotNullParameter(slotType, "slotType");
            Intrinsics.checkNotNullParameter(parameterSlot, "slot");
            this.b = parameterSlot;
        }

        @NotNull
        public final ParameterSlot getSlot() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/publish/slots/ConsumeValueChangeResult$NeedViewUpdate;", "Lcom/avito/android/publish/slots/ConsumeValueChangeResult;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotType;", "slotType", "<init>", "(Lcom/avito/android/remote/model/category_parameters/slot/SlotType;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class NeedViewUpdate extends ConsumeValueChangeResult {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NeedViewUpdate(@NotNull SlotType slotType) {
            super(slotType, null);
            Intrinsics.checkNotNullParameter(slotType, "slotType");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/publish/slots/ConsumeValueChangeResult$NoChange;", "Lcom/avito/android/publish/slots/ConsumeValueChangeResult;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class NoChange extends ConsumeValueChangeResult {
        @NotNull
        public static final NoChange INSTANCE = new NoChange();

        public NoChange() {
            super(SlotType.OTHER, null);
        }
    }

    public ConsumeValueChangeResult(SlotType slotType, j jVar) {
        this.a = slotType;
    }

    @NotNull
    public final SlotType getSlotType() {
        return this.a;
    }
}
