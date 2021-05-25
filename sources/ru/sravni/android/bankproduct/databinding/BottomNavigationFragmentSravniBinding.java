package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentContainerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.bottomnavigation.viewmodel.IBottomNavigationViewModel;
public abstract class BottomNavigationFragmentSravniBinding extends ViewDataBinding {
    @NonNull
    public final BottomNavigationView bottomNavigationView;
    @NonNull
    public final ConstraintLayout container;
    @Bindable
    public IBottomNavigationViewModel mViewModel;
    @NonNull
    public final FragmentContainerView sectionDashboard;
    @NonNull
    public final FragmentContainerView sectionProfile;
    @NonNull
    public final FragmentContainerView sectionProfileLegacy;

    public BottomNavigationFragmentSravniBinding(Object obj, View view, int i, BottomNavigationView bottomNavigationView2, ConstraintLayout constraintLayout, FragmentContainerView fragmentContainerView, FragmentContainerView fragmentContainerView2, FragmentContainerView fragmentContainerView3) {
        super(obj, view, i);
        this.bottomNavigationView = bottomNavigationView2;
        this.container = constraintLayout;
        this.sectionDashboard = fragmentContainerView;
        this.sectionProfile = fragmentContainerView2;
        this.sectionProfileLegacy = fragmentContainerView3;
    }

    public static BottomNavigationFragmentSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static BottomNavigationFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public IBottomNavigationViewModel getViewModel() {
        return this.mViewModel;
    }

    public abstract void setViewModel(@Nullable IBottomNavigationViewModel iBottomNavigationViewModel);

    @Deprecated
    public static BottomNavigationFragmentSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (BottomNavigationFragmentSravniBinding) ViewDataBinding.bind(obj, view, R.layout.bottom_navigation_fragment_sravni);
    }

    @NonNull
    @Deprecated
    public static BottomNavigationFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (BottomNavigationFragmentSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.bottom_navigation_fragment_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static BottomNavigationFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static BottomNavigationFragmentSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (BottomNavigationFragmentSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.bottom_navigation_fragment_sravni, null, false, obj);
    }
}
