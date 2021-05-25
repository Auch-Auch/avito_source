package ru.sravni.android.bankproduct.utils.adapter;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.databinding.BindingAdapter;
import com.google.android.material.textfield.TextInputEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSliderViewModel;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/google/android/material/textfield/TextInputEditText;", "view", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSliderViewModel;", "sliderViewModel", "", "bindViewModelToTextInputEditText", "(Lcom/google/android/material/textfield/TextInputEditText;Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSliderViewModel;)V", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class BindingTextInputEditTextKt {
    @BindingAdapter({"sliderViewModel"})
    public static final void bindViewModelToTextInputEditText(@NotNull TextInputEditText textInputEditText, @NotNull IFilterSliderViewModel iFilterSliderViewModel) {
        Intrinsics.checkParameterIsNotNull(textInputEditText, "view");
        Intrinsics.checkParameterIsNotNull(iFilterSliderViewModel, "sliderViewModel");
        textInputEditText.addTextChangedListener(new TextWatcher(iFilterSliderViewModel) { // from class: ru.sravni.android.bankproduct.utils.adapter.BindingTextInputEditTextKt$bindViewModelToTextInputEditText$1
            public final /* synthetic */ IFilterSliderViewModel a;

            {
                this.a = r1;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
                if (!(charSequence == null || charSequence.length() == 0)) {
                    this.a.onSliderValueChanged(charSequence.toString());
                }
            }
        });
    }
}
