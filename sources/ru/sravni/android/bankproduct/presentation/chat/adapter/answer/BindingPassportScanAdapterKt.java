package ru.sravni.android.bankproduct.presentation.chat.adapter.answer;

import android.view.View;
import androidx.databinding.BindingAdapter;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.redmadrobot.inputmask.MaskedTextChangedListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.DocumentFieldInfo;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IPassportScanAnswerViewModel;
import ru.sravni.android.bankproduct.utils.masktext.MaskedTextChangedListenerWithCatch;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/google/android/material/textfield/TextInputEditText;", "view", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/DocumentFieldInfo;", "documentFieldInfo", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/IPassportScanAnswerViewModel;", "passportScanAnswerViewModel", "", "bindMaskWatcherToTextInputEditText", "(Lcom/google/android/material/textfield/TextInputEditText;Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/DocumentFieldInfo;Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/IPassportScanAnswerViewModel;)V", "Lcom/google/android/material/textfield/TextInputLayout;", "", "isMaskFilled", "bindMaskFilledToTextInputLayout", "(Lcom/google/android/material/textfield/TextInputLayout;Z)V", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class BindingPassportScanAdapterKt {
    @BindingAdapter({"isMaskFilled"})
    public static final void bindMaskFilledToTextInputLayout(@NotNull TextInputLayout textInputLayout, boolean z) {
        Intrinsics.checkParameterIsNotNull(textInputLayout, "view");
        if (z) {
            textInputLayout.setError(null);
            textInputLayout.setErrorEnabled(false);
        } else {
            textInputLayout.setError("error");
            textInputLayout.setErrorEnabled(true);
        }
        View childAt = textInputLayout.getChildAt(1);
        Intrinsics.checkExpressionValueIsNotNull(childAt, "view.getChildAt(1)");
        childAt.setVisibility(8);
    }

    @BindingAdapter({"documentFieldInfo", "passportScanAnswerViewModel"})
    public static final void bindMaskWatcherToTextInputEditText(@NotNull TextInputEditText textInputEditText, @Nullable DocumentFieldInfo documentFieldInfo, @NotNull IPassportScanAnswerViewModel iPassportScanAnswerViewModel) {
        Intrinsics.checkParameterIsNotNull(textInputEditText, "view");
        Intrinsics.checkParameterIsNotNull(iPassportScanAnswerViewModel, "passportScanAnswerViewModel");
        if (documentFieldInfo != null) {
            MaskedTextChangedListenerWithCatch maskedTextChangedListenerWithCatch = new MaskedTextChangedListenerWithCatch(documentFieldInfo.getMask(), true, textInputEditText, null, new MaskedTextChangedListener.ValueListener(textInputEditText, iPassportScanAnswerViewModel, documentFieldInfo) { // from class: ru.sravni.android.bankproduct.presentation.chat.adapter.answer.BindingPassportScanAdapterKt$bindMaskWatcherToTextInputEditText$$inlined$let$lambda$1
                public final /* synthetic */ IPassportScanAnswerViewModel a;
                public final /* synthetic */ DocumentFieldInfo b;

                {
                    this.a = r2;
                    this.b = r3;
                }

                @Override // com.redmadrobot.inputmask.MaskedTextChangedListener.ValueListener
                public void onTextChanged(boolean z, @NotNull String str, @NotNull String str2) {
                    Intrinsics.checkParameterIsNotNull(str, "extractedValue");
                    Intrinsics.checkParameterIsNotNull(str2, "formattedValue");
                    this.a.setNewValue(new DocumentFieldInfo(str2, this.b.getMask(), z, this.b.getKey(), this.b.getType()));
                }
            }, iPassportScanAnswerViewModel.getMaskTextErrorHandler(), null, 64, null);
            textInputEditText.addTextChangedListener(maskedTextChangedListenerWithCatch);
            textInputEditText.setHint(maskedTextChangedListenerWithCatch.placeholder());
        }
    }
}
