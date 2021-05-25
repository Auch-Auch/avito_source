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
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.auth.sms.viewmodel.IProfileSmsViewModel;
public abstract class AvitoSmsFragmentSravniBinding extends ViewDataBinding {
    @NonNull
    public final AppBarLayout appBarLayout;
    @NonNull
    public final ConstraintLayout clProfilePhone;
    @NonNull
    public final TextInputEditText etSmsCode;
    @NonNull
    public final TextInputLayout ilSmsCode;
    @NonNull
    public final LinearLayout llInfoSmsCode;
    @Bindable
    public IProfileSmsViewModel mSmsViewModel;
    @NonNull
    public final MaterialToolbar toolbar;
    @NonNull
    public final MaterialTextView tvDescriptionSms;
    @NonNull
    public final MaterialTextView tvRepeatSmsCode;
    @NonNull
    public final MaterialTextView tvTimer;
    @NonNull
    public final MaterialTextView tvTitleSms;
    @NonNull
    public final MaterialTextView tvWrongSmsCode;

    public AvitoSmsFragmentSravniBinding(Object obj, View view, int i, AppBarLayout appBarLayout2, ConstraintLayout constraintLayout, TextInputEditText textInputEditText, TextInputLayout textInputLayout, LinearLayout linearLayout, MaterialToolbar materialToolbar, MaterialTextView materialTextView, MaterialTextView materialTextView2, MaterialTextView materialTextView3, MaterialTextView materialTextView4, MaterialTextView materialTextView5) {
        super(obj, view, i);
        this.appBarLayout = appBarLayout2;
        this.clProfilePhone = constraintLayout;
        this.etSmsCode = textInputEditText;
        this.ilSmsCode = textInputLayout;
        this.llInfoSmsCode = linearLayout;
        this.toolbar = materialToolbar;
        this.tvDescriptionSms = materialTextView;
        this.tvRepeatSmsCode = materialTextView2;
        this.tvTimer = materialTextView3;
        this.tvTitleSms = materialTextView4;
        this.tvWrongSmsCode = materialTextView5;
    }

    public static AvitoSmsFragmentSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AvitoSmsFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public IProfileSmsViewModel getSmsViewModel() {
        return this.mSmsViewModel;
    }

    public abstract void setSmsViewModel(@Nullable IProfileSmsViewModel iProfileSmsViewModel);

    @Deprecated
    public static AvitoSmsFragmentSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (AvitoSmsFragmentSravniBinding) ViewDataBinding.bind(obj, view, R.layout.avito_sms_fragment_sravni);
    }

    @NonNull
    @Deprecated
    public static AvitoSmsFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AvitoSmsFragmentSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.avito_sms_fragment_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static AvitoSmsFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AvitoSmsFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (AvitoSmsFragmentSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.avito_sms_fragment_sravni, null, false, obj);
    }
}
