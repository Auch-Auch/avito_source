package com.avito.android.publish.slots;

import com.avito.android.publish.details.adapter.header.HeaderWithDividerItem;
import com.avito.android.publish.slots.SlotWrapper;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.category_parameters.slot.header.SectionSeparatorSlot;
import com.avito.android.remote.model.category_parameters.slot.header.SectionSeparatorSlotConfig;
import com.avito.android.util.LoadingState;
import com.avito.conveyor_item.Item;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u000e\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/publish/slots/SectionSeparatorSlotWrapper;", "Lcom/avito/android/publish/slots/SlotWrapper;", "Lcom/avito/android/remote/model/category_parameters/slot/header/SectionSeparatorSlot;", "", "getId", "()Ljava/lang/String;", "", "Lcom/avito/conveyor_item/Item;", "getElements", "()Ljava/util/List;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/category_parameters/slot/header/SectionSeparatorSlot;", "getSlot", "()Lcom/avito/android/remote/model/category_parameters/slot/header/SectionSeparatorSlot;", "slot", "<init>", "(Lcom/avito/android/remote/model/category_parameters/slot/header/SectionSeparatorSlot;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class SectionSeparatorSlotWrapper implements SlotWrapper<SectionSeparatorSlot> {
    @NotNull
    public final SectionSeparatorSlot a;

    public SectionSeparatorSlotWrapper(@NotNull SectionSeparatorSlot sectionSeparatorSlot) {
        Intrinsics.checkNotNullParameter(sectionSeparatorSlot, "slot");
        this.a = sectionSeparatorSlot;
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
        return d.listOf(new HeaderWithDividerItem(getSlot().getId(), ((SectionSeparatorSlotConfig) getSlot().getWidget().getConfig()).getTitle(), ((SectionSeparatorSlotConfig) getSlot().getWidget().getConfig()).getShowTopSeparator()));
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
    public SectionSeparatorSlot getSlot() {
        return this.a;
    }
}
