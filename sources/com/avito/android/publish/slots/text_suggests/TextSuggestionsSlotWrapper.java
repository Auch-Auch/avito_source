package com.avito.android.publish.slots.text_suggests;

import com.avito.android.publish.slots.ConsumeValueChangeResult;
import com.avito.android.publish.slots.SlotWrapper;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.category_parameters.slot.text_suggests.TextSuggestionsSlot;
import com.avito.android.util.LoadingState;
import com.avito.conveyor_item.Item;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/publish/slots/text_suggests/TextSuggestionsSlotWrapper;", "Lcom/avito/android/publish/slots/SlotWrapper;", "Lcom/avito/android/remote/model/category_parameters/slot/text_suggests/TextSuggestionsSlot;", "", "getId", "()Ljava/lang/String;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/category_parameters/slot/text_suggests/TextSuggestionsSlot;", "getSlot", "()Lcom/avito/android/remote/model/category_parameters/slot/text_suggests/TextSuggestionsSlot;", "slot", "<init>", "(Lcom/avito/android/remote/model/category_parameters/slot/text_suggests/TextSuggestionsSlot;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class TextSuggestionsSlotWrapper implements SlotWrapper<TextSuggestionsSlot> {
    @NotNull
    public final TextSuggestionsSlot a;

    public TextSuggestionsSlotWrapper(@NotNull TextSuggestionsSlot textSuggestionsSlot) {
        Intrinsics.checkNotNullParameter(textSuggestionsSlot, "slot");
        this.a = textSuggestionsSlot;
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
    public TextSuggestionsSlot getSlot() {
        return this.a;
    }
}
