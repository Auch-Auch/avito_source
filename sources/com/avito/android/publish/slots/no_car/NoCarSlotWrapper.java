package com.avito.android.publish.slots.no_car;

import a2.b.a.a.a;
import com.avito.android.publish.slots.ConsumeValueChangeResult;
import com.avito.android.publish.slots.SlotWrapper;
import com.avito.android.publish.slots.no_car.item.NoCarSlotItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.category_parameters.slot.SlotType;
import com.avito.android.remote.model.category_parameters.slot.no_car.NoCarSlot;
import com.avito.android.remote.model.category_parameters.slot.no_car.NoCarSlotConfig;
import com.avito.android.util.LoadingState;
import com.avito.conveyor_item.Item;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u000e\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/avito/android/publish/slots/no_car/NoCarSlotWrapper;", "Lcom/avito/android/publish/slots/SlotWrapper;", "Lcom/avito/android/remote/model/category_parameters/slot/no_car/NoCarSlot;", "", "getId", "()Ljava/lang/String;", "", "Lcom/avito/conveyor_item/Item;", "getElements", "()Ljava/util/List;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/category_parameters/slot/no_car/NoCarSlot;", "getSlot", "()Lcom/avito/android/remote/model/category_parameters/slot/no_car/NoCarSlot;", "slot", "<init>", "(Lcom/avito/android/remote/model/category_parameters/slot/no_car/NoCarSlot;)V", "Companion", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class NoCarSlotWrapper implements SlotWrapper<NoCarSlot> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final NoCarSlot a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/publish/slots/no_car/NoCarSlotWrapper$Companion;", "", "", "NO_CAR_SLOT_ITEM", "Ljava/lang/String;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public NoCarSlotWrapper(@NotNull NoCarSlot noCarSlot) {
        Intrinsics.checkNotNullParameter(noCarSlot, "slot");
        this.a = noCarSlot;
        if (getSlot().getSlotType() != SlotType.NO_CAR) {
            StringBuilder L = a.L("Illegal slot type for ");
            L.append(NoCarSlotWrapper.class.getSimpleName());
            L.append("! type: ");
            L.append(getSlot().getSlotType());
            throw new IllegalArgumentException(L.toString());
        }
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

    @Override // com.avito.android.category_parameters.SlotElementsProvider
    @NotNull
    public List<Item> getElements() {
        StringBuilder L = a.L("no_car_slot_item");
        L.append(getSlot().hashCode());
        return CollectionsKt__CollectionsKt.mutableListOf(new NoCarSlotItem(L.toString(), ((NoCarSlotConfig) getSlot().getWidget().getConfig()).getLink(), ((NoCarSlotConfig) getSlot().getWidget().getConfig()).getTitle()));
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
    public NoCarSlot getSlot() {
        return this.a;
    }
}
