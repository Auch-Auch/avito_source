package ru.sravni.android.bankproduct.utils.adapter;

import androidx.databinding.BindingAdapter;
import com.shawnlin.numberpicker.NumberPicker;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/shawnlin/numberpicker/NumberPicker;", "view", "Lru/sravni/android/bankproduct/utils/adapter/InitNumberPicker;", "initNumberPicker", "", "bindListToNumberPicker", "(Lcom/shawnlin/numberpicker/NumberPicker;Lru/sravni/android/bankproduct/utils/adapter/InitNumberPicker;)V", "Lru/sravni/android/bankproduct/utils/adapter/INumberPickerListenerPosition;", "numberPickerListenerPosition", "bindViewModelToNumberPicker", "(Lcom/shawnlin/numberpicker/NumberPicker;Lru/sravni/android/bankproduct/utils/adapter/INumberPickerListenerPosition;)V", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class BindingNumberPickerKt {

    public static final class a implements NumberPicker.OnValueChangeListener {
        public final /* synthetic */ INumberPickerListenerPosition a;

        public a(INumberPickerListenerPosition iNumberPickerListenerPosition) {
            this.a = iNumberPickerListenerPosition;
        }

        @Override // com.shawnlin.numberpicker.NumberPicker.OnValueChangeListener
        public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
            this.a.setNewNumberPickerPosition(i2);
        }
    }

    @BindingAdapter({"initNumberPicker"})
    public static final void bindListToNumberPicker(@NotNull NumberPicker numberPicker, @Nullable InitNumberPicker initNumberPicker) {
        Intrinsics.checkParameterIsNotNull(numberPicker, "view");
        if (initNumberPicker != null) {
            Object[] array = initNumberPicker.getList().toArray(new String[0]);
            if (array != null) {
                numberPicker.setDisplayedValues((String[]) array);
                numberPicker.setMaxValue(initNumberPicker.getList().size() - 1);
                numberPicker.setValue(initNumberPicker.getCurrentPosition());
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    @BindingAdapter({"numberPickerListenerPosition"})
    public static final void bindViewModelToNumberPicker(@NotNull NumberPicker numberPicker, @NotNull INumberPickerListenerPosition iNumberPickerListenerPosition) {
        Intrinsics.checkParameterIsNotNull(numberPicker, "view");
        Intrinsics.checkParameterIsNotNull(iNumberPickerListenerPosition, "numberPickerListenerPosition");
        numberPicker.setOnValueChangedListener(new a(iNumberPickerListenerPosition));
    }
}
