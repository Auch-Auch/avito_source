package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.auth.sms.viewmodel.IProfileSmsViewModel;
public abstract class ProfileSmsFragmentSravniBinding extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout clProfilePhone;
    @NonNull
    public final EditText etSmsCode;
    @NonNull
    public final FrameLayout flSmsCode;
    @NonNull
    public final LinearLayout llInfoSmsCode;
    @Bindable
    public IProfileSmsViewModel mViewModel;
    @NonNull
    public final ProgressBar pbSmsCode;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final TextView tvRepeatSmsCode;
    @NonNull
    public final TextView tvSubTitleSmsCode;
    @NonNull
    public final TextView tvTimer;
    @NonNull
    public final TextView tvTitleSmsCode;
    @NonNull
    public final TextView tvWrongSmsCode;

    public ProfileSmsFragmentSravniBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, EditText editText, FrameLayout frameLayout, LinearLayout linearLayout, ProgressBar progressBar, Toolbar toolbar2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.clProfilePhone = constraintLayout;
        this.etSmsCode = editText;
        this.flSmsCode = frameLayout;
        this.llInfoSmsCode = linearLayout;
        this.pbSmsCode = progressBar;
        this.toolbar = toolbar2;
        this.tvRepeatSmsCode = textView;
        this.tvSubTitleSmsCode = textView2;
        this.tvTimer = textView3;
        this.tvTitleSmsCode = textView4;
        this.tvWrongSmsCode = textView5;
    }

    public static ProfileSmsFragmentSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ProfileSmsFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public IProfileSmsViewModel getViewModel() {
        return this.mViewModel;
    }

    public abstract void setViewModel(@Nullable IProfileSmsViewModel iProfileSmsViewModel);

    @Deprecated
    public static ProfileSmsFragmentSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ProfileSmsFragmentSravniBinding) ViewDataBinding.bind(obj, view, R.layout.profile_sms_fragment_sravni);
    }

    @NonNull
    @Deprecated
    public static ProfileSmsFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ProfileSmsFragmentSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.profile_sms_fragment_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static ProfileSmsFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ProfileSmsFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ProfileSmsFragmentSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.profile_sms_fragment_sravni, null, false, obj);
    }
}
