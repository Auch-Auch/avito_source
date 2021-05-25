package ru.sravni.android.bankproduct.presentation.avito.auth.sms.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.BindingAdapter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.auth.sms.viewmodel.IProfileSmsViewModel;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\b\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroid/widget/EditText;", "view", "Lru/sravni/android/bankproduct/presentation/auth/sms/viewmodel/IProfileSmsViewModel;", "smsViewModel", "", "bindSmsCodeToEditText", "(Landroid/widget/EditText;Lru/sravni/android/bankproduct/presentation/auth/sms/viewmodel/IProfileSmsViewModel;)V", "Landroid/widget/TextView;", "bindPhoneNumberToTextView", "(Landroid/widget/TextView;Lru/sravni/android/bankproduct/presentation/auth/sms/viewmodel/IProfileSmsViewModel;)V", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class BindingAvitoSmsAdapterKt {

    public static final class a implements View.OnTouchListener {
        public final /* synthetic */ IProfileSmsViewModel a;

        public a(IProfileSmsViewModel iProfileSmsViewModel) {
            this.a = iProfileSmsViewModel;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            Intrinsics.checkExpressionValueIsNotNull(motionEvent, "event");
            float x = motionEvent.getX();
            Intrinsics.checkExpressionValueIsNotNull(view, VKApiConst.VERSION);
            if (x < ((float) (view.getWidth() - ((EditText) view).getTotalPaddingRight())) || motionEvent.getAction() != 1) {
                return false;
            }
            this.a.clearSmsField();
            return true;
        }
    }

    @BindingAdapter({"smsViewModel"})
    public static final void bindPhoneNumberToTextView(@NotNull TextView textView, @NotNull IProfileSmsViewModel iProfileSmsViewModel) {
        String str;
        Intrinsics.checkParameterIsNotNull(textView, "view");
        Intrinsics.checkParameterIsNotNull(iProfileSmsViewModel, "smsViewModel");
        String value = iProfileSmsViewModel.getPhoneNumber().getValue();
        if (value == null || (str = m.replace$default(value, " ", " ", false, 4, (Object) null)) == null) {
            str = "";
        }
        Context context = textView.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "view.context");
        String string = context.getResources().getString(R.string.avito_profile_sms_description, str);
        Intrinsics.checkExpressionValueIsNotNull(string, "view.context.resources.g…description, phoneNumber)");
        textView.setText(UtilFunctionsKt.toSpannedText(string));
    }

    @BindingAdapter({"smsViewModel"})
    @SuppressLint({"ClickableViewAccessibility"})
    public static final void bindSmsCodeToEditText(@NotNull EditText editText, @NotNull IProfileSmsViewModel iProfileSmsViewModel) {
        Intrinsics.checkParameterIsNotNull(editText, "view");
        Intrinsics.checkParameterIsNotNull(iProfileSmsViewModel, "smsViewModel");
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        editText.addTextChangedListener(new TextWatcher(iProfileSmsViewModel, editText) { // from class: ru.sravni.android.bankproduct.presentation.avito.auth.sms.adapter.BindingAvitoSmsAdapterKt$bindSmsCodeToEditText$1
            public final /* synthetic */ IProfileSmsViewModel a;
            public final /* synthetic */ EditText b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
                this.a.smsCodeChange(this.b.getText().toString(), 4);
                if (charSequence != null) {
                    if (charSequence.length() > 0) {
                        this.b.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_clear_sravni, 0);
                        return;
                    }
                }
                this.b.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
            }
        });
        editText.setOnTouchListener(new a(iProfileSmsViewModel));
    }
}
