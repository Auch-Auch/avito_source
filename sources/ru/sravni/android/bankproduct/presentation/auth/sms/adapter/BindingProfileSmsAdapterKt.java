package ru.sravni.android.bankproduct.presentation.auth.sms.adapter;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.databinding.BindingAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.presentation.auth.sms.viewmodel.IProfileSmsViewModel;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroid/widget/EditText;", "view", "Lru/sravni/android/bankproduct/presentation/auth/sms/viewmodel/IProfileSmsViewModel;", "viewModel", "", "bindSmsCodeToEditText", "(Landroid/widget/EditText;Lru/sravni/android/bankproduct/presentation/auth/sms/viewmodel/IProfileSmsViewModel;)V", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class BindingProfileSmsAdapterKt {
    @BindingAdapter({"viewModel"})
    public static final void bindSmsCodeToEditText(@NotNull EditText editText, @NotNull IProfileSmsViewModel iProfileSmsViewModel) {
        Intrinsics.checkParameterIsNotNull(editText, "view");
        Intrinsics.checkParameterIsNotNull(iProfileSmsViewModel, "viewModel");
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        editText.addTextChangedListener(new TextWatcher(iProfileSmsViewModel, editText) { // from class: ru.sravni.android.bankproduct.presentation.auth.sms.adapter.BindingProfileSmsAdapterKt$bindSmsCodeToEditText$1
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
            }
        });
    }
}
