package com.avito.android.publish.slots;

import com.avito.android.category_parameters.SlotElementsProvider;
import com.avito.android.publish.slots.ConsumeValueChangeResult;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.category_parameters.slot.Slot;
import com.avito.android.util.LoadingState;
import com.avito.conveyor_item.Item;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u00020\u0003J\u001b\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\u0004H\u0016¢\u0006\u0004\b\n\u0010\bJ'\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00028\u00008&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/avito/android/publish/slots/SlotWrapper;", "Lcom/avito/android/remote/model/category_parameters/slot/Slot;", "T", "Lcom/avito/android/category_parameters/SlotElementsProvider;", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "", "prepare", "()Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/SuccessResult;", "checkErrors", "Lcom/avito/conveyor_item/Item;", "element", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "param", "Lcom/avito/android/publish/slots/ConsumeValueChangeResult;", "consumeItemValueChange", "(Lcom/avito/conveyor_item/Item;Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;)Lcom/avito/android/publish/slots/ConsumeValueChangeResult;", "getSlot", "()Lcom/avito/android/remote/model/category_parameters/slot/Slot;", "slot", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface SlotWrapper<T extends Slot<?>> extends SlotElementsProvider {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @NotNull
        public static <T extends Slot<?>> Observable<LoadingState<SuccessResult>> checkErrors(@NotNull SlotWrapper<T> slotWrapper) {
            Observable<LoadingState<SuccessResult>> just = Observable.just(new LoadingState.Loaded(new SuccessResult(null)));
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(LoadingS…ded(SuccessResult(null)))");
            return just;
        }

        @NotNull
        public static <T extends Slot<?>> ConsumeValueChangeResult consumeItemValueChange(@NotNull SlotWrapper<T> slotWrapper, @Nullable Item item, @Nullable ParameterSlot parameterSlot) {
            return ConsumeValueChangeResult.NoChange.INSTANCE;
        }

        public static /* synthetic */ ConsumeValueChangeResult consumeItemValueChange$default(SlotWrapper slotWrapper, Item item, ParameterSlot parameterSlot, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    item = null;
                }
                if ((i & 2) != 0) {
                    parameterSlot = null;
                }
                return slotWrapper.consumeItemValueChange(item, parameterSlot);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: consumeItemValueChange");
        }

        @NotNull
        public static <T extends Slot<?>> List<Item> getElements(@NotNull SlotWrapper<T> slotWrapper) {
            return SlotElementsProvider.DefaultImpls.getElements(slotWrapper);
        }

        @NotNull
        public static <T extends Slot<?>> Observable<LoadingState<Unit>> prepare(@NotNull SlotWrapper<T> slotWrapper) {
            Observable<LoadingState<Unit>> just = Observable.just(new LoadingState.Loaded(Unit.INSTANCE));
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(LoadingState.Loaded(Unit))");
            return just;
        }
    }

    @NotNull
    Observable<LoadingState<SuccessResult>> checkErrors();

    @NotNull
    ConsumeValueChangeResult consumeItemValueChange(@Nullable Item item, @Nullable ParameterSlot parameterSlot);

    @NotNull
    T getSlot();

    @NotNull
    Observable<LoadingState<Unit>> prepare();
}
