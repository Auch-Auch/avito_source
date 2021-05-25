package ru.sravni.android.bankproduct.presentation.chat.adapter.answer;

import androidx.databinding.BindingAdapter;
import com.redmadrobot.inputmask.MaskedTextChangedListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IMaskTextAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.InitMaskElementInfo;
import ru.sravni.android.bankproduct.utils.CustomEditTextWithControlledListeners;
import ru.sravni.android.bankproduct.utils.masktext.MaskedTextChangedListenerWithCatch;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lru/sravni/android/bankproduct/utils/CustomEditTextWithControlledListeners;", "view", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/InitMaskElementInfo;", "initMaskElementInfo", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/IMaskTextAnswerViewModel;", "maskTextAnswerViewModel", "", "bindMaskAnswerToEditText", "(Lru/sravni/android/bankproduct/utils/CustomEditTextWithControlledListeners;Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/InitMaskElementInfo;Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/IMaskTextAnswerViewModel;)V", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class BindingMaskAnswerAdapterKt {
    @BindingAdapter({"initMaskElementInfo", "maskTextAnswerViewModel"})
    public static final void bindMaskAnswerToEditText(@NotNull CustomEditTextWithControlledListeners customEditTextWithControlledListeners, @Nullable InitMaskElementInfo initMaskElementInfo, @NotNull IMaskTextAnswerViewModel iMaskTextAnswerViewModel) {
        Intrinsics.checkParameterIsNotNull(customEditTextWithControlledListeners, "view");
        Intrinsics.checkParameterIsNotNull(iMaskTextAnswerViewModel, "maskTextAnswerViewModel");
        if (initMaskElementInfo != null) {
            customEditTextWithControlledListeners.removeAllListeners();
            customEditTextWithControlledListeners.setText(initMaskElementInfo.getSuggestText());
            customEditTextWithControlledListeners.setHint(initMaskElementInfo.getHint());
            customEditTextWithControlledListeners.setInputType(initMaskElementInfo.getInputType());
            customEditTextWithControlledListeners.addTextChangedListener(new MaskedTextChangedListenerWithCatch(initMaskElementInfo.getMask(), true, customEditTextWithControlledListeners, null, new MaskedTextChangedListener.ValueListener(iMaskTextAnswerViewModel) { // from class: ru.sravni.android.bankproduct.presentation.chat.adapter.answer.BindingMaskAnswerAdapterKt$bindMaskAnswerToEditText$listener$1
                public final /* synthetic */ IMaskTextAnswerViewModel a;

                {
                    this.a = r1;
                }

                @Override // com.redmadrobot.inputmask.MaskedTextChangedListener.ValueListener
                public void onTextChanged(boolean z, @NotNull String str, @NotNull String str2) {
                    Intrinsics.checkParameterIsNotNull(str, "extractedValue");
                    Intrinsics.checkParameterIsNotNull(str2, "formattedValue");
                    this.a.setTextChange(str2, z);
                }
            }, iMaskTextAnswerViewModel.getMaskTextErrorHandler(), null, 64, null));
        }
    }
}
