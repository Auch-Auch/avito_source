package ru.sravni.android.bankproduct.presentation.avito.auth.phone.adapter;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import androidx.databinding.BindingAdapter;
import com.redmadrobot.inputmask.MaskedTextChangedListener;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.auth.phone.viewmodel.IProfilePhoneViewModel;
import ru.sravni.android.bankproduct.utils.masktext.MaskedTextChangedListenerWithCatch;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroid/widget/EditText;", "view", "", "mask", "Lru/sravni/android/bankproduct/presentation/auth/phone/viewmodel/IProfilePhoneViewModel;", "viewModel", "", "bindMaskPhoneToEditText", "(Landroid/widget/EditText;Ljava/lang/String;Lru/sravni/android/bankproduct/presentation/auth/phone/viewmodel/IProfilePhoneViewModel;)V", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class BindingAvitoProfilePhoneAdapterKt {

    public static final class a implements View.OnTouchListener {
        public final /* synthetic */ IProfilePhoneViewModel a;

        public a(IProfilePhoneViewModel iProfilePhoneViewModel) {
            this.a = iProfilePhoneViewModel;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            Intrinsics.checkExpressionValueIsNotNull(motionEvent, "event");
            float x = motionEvent.getX();
            Intrinsics.checkExpressionValueIsNotNull(view, VKApiConst.VERSION);
            if (x < ((float) (view.getWidth() - ((EditText) view).getTotalPaddingRight())) || motionEvent.getAction() != 1) {
                return false;
            }
            this.a.clearPhoneField();
            return true;
        }
    }

    @BindingAdapter({"mask", "phoneViewModel"})
    @SuppressLint({"ClickableViewAccessibility", "UseCompatLoadingForDrawables"})
    public static final void bindMaskPhoneToEditText(@NotNull EditText editText, @NotNull String str, @NotNull IProfilePhoneViewModel iProfilePhoneViewModel) {
        Intrinsics.checkParameterIsNotNull(editText, "view");
        Intrinsics.checkParameterIsNotNull(str, "mask");
        Intrinsics.checkParameterIsNotNull(iProfilePhoneViewModel, "viewModel");
        MaskedTextChangedListenerWithCatch maskedTextChangedListenerWithCatch = new MaskedTextChangedListenerWithCatch(str, true, editText, new TextWatcher(editText) { // from class: ru.sravni.android.bankproduct.presentation.avito.auth.phone.adapter.BindingAvitoProfilePhoneAdapterKt$bindMaskPhoneToEditText$textWatcher$1
            public final /* synthetic */ EditText a;

            {
                this.a = r1;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
                if (editable != null) {
                    if (editable.length() > 0) {
                        this.a.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_clear_sravni, 0);
                        return;
                    }
                }
                this.a.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
            }
        }, new MaskedTextChangedListener.ValueListener(iProfilePhoneViewModel) { // from class: ru.sravni.android.bankproduct.presentation.avito.auth.phone.adapter.BindingAvitoProfilePhoneAdapterKt$bindMaskPhoneToEditText$listener$1
            public final /* synthetic */ IProfilePhoneViewModel a;

            {
                this.a = r1;
            }

            @Override // com.redmadrobot.inputmask.MaskedTextChangedListener.ValueListener
            public void onTextChanged(boolean z, @NotNull String str2, @NotNull String str3) {
                Intrinsics.checkParameterIsNotNull(str2, "extractedValue");
                Intrinsics.checkParameterIsNotNull(str3, "formattedValue");
                this.a.phoneChange(str2, str3, z);
            }
        }, iProfilePhoneViewModel.getMaskTextErrorHandler(), null, 64, null);
        editText.addTextChangedListener(maskedTextChangedListenerWithCatch);
        editText.setOnFocusChangeListener(maskedTextChangedListenerWithCatch);
        editText.setHint(maskedTextChangedListenerWithCatch.placeholder());
        editText.setOnTouchListener(new a(iProfilePhoneViewModel));
        iProfilePhoneViewModel.initPhone();
    }
}
