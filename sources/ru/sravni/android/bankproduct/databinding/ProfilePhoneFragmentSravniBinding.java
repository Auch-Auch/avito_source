package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import ru.sravni.android.bankproduct.R;
public abstract class ProfilePhoneFragmentSravniBinding extends ViewDataBinding {
    public ProfilePhoneFragmentSravniBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ProfilePhoneFragmentSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ProfilePhoneFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ProfilePhoneFragmentSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ProfilePhoneFragmentSravniBinding) ViewDataBinding.bind(obj, view, R.layout.profile_phone_fragment_sravni);
    }

    @NonNull
    @Deprecated
    public static ProfilePhoneFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ProfilePhoneFragmentSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.profile_phone_fragment_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static ProfilePhoneFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ProfilePhoneFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ProfilePhoneFragmentSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.profile_phone_fragment_sravni, null, false, obj);
    }
}
