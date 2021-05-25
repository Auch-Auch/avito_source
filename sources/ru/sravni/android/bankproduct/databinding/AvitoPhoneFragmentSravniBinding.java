package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.auth.phone.viewmodel.IProfilePhoneViewModel;
public abstract class AvitoPhoneFragmentSravniBinding extends ViewDataBinding {
    @NonNull
    public final AppBarLayout appBarLayout;
    @NonNull
    public final MaterialButton btSendPhone;
    @NonNull
    public final ConstraintLayout clProfilePhone;
    @NonNull
    public final TextInputEditText etMobileNumber;
    @NonNull
    public final TextInputLayout ilPhoneNumber;
    @NonNull
    public final LinearLayout llRepeatSendPhone;
    @Bindable
    public IProfilePhoneViewModel mPhoneViewModel;
    @NonNull
    public final MaterialToolbar toolbar;
    @NonNull
    public final MaterialTextView tvDescriptionPhone;
    @NonNull
    public final MaterialTextView tvTitlePhone;

    public AvitoPhoneFragmentSravniBinding(Object obj, View view, int i, AppBarLayout appBarLayout2, MaterialButton materialButton, ConstraintLayout constraintLayout, TextInputEditText textInputEditText, TextInputLayout textInputLayout, LinearLayout linearLayout, MaterialToolbar materialToolbar, MaterialTextView materialTextView, MaterialTextView materialTextView2) {
        super(obj, view, i);
        this.appBarLayout = appBarLayout2;
        this.btSendPhone = materialButton;
        this.clProfilePhone = constraintLayout;
        this.etMobileNumber = textInputEditText;
        this.ilPhoneNumber = textInputLayout;
        this.llRepeatSendPhone = linearLayout;
        this.toolbar = materialToolbar;
        this.tvDescriptionPhone = materialTextView;
        this.tvTitlePhone = materialTextView2;
    }

    public static AvitoPhoneFragmentSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AvitoPhoneFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public IProfilePhoneViewModel getPhoneViewModel() {
        return this.mPhoneViewModel;
    }

    public abstract void setPhoneViewModel(@Nullable IProfilePhoneViewModel iProfilePhoneViewModel);

    @Deprecated
    public static AvitoPhoneFragmentSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (AvitoPhoneFragmentSravniBinding) ViewDataBinding.bind(obj, view, R.layout.avito_phone_fragment_sravni);
    }

    @NonNull
    @Deprecated
    public static AvitoPhoneFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AvitoPhoneFragmentSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.avito_phone_fragment_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static AvitoPhoneFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AvitoPhoneFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (AvitoPhoneFragmentSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.avito_phone_fragment_sravni, null, false, obj);
    }
}
