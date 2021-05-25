package ru.sravni.android.bankproduct.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.button.MaterialButton;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.ISlidingPanelButtonViewModel;
public abstract class SlideupPanelButtonSravniBinding extends ViewDataBinding {
    @NonNull
    public final MaterialButton btnCancel;
    @NonNull
    public final MaterialButton btnRecount;
    @NonNull
    public final MaterialButton btnRecountWithCount;
    @NonNull
    public final FrameLayout flRecountWithCount;
    @Bindable
    public ISlidingPanelButtonViewModel mButtonPanelViewModel;
    @NonNull
    public final ProgressBar pbRecountWithCount;

    public SlideupPanelButtonSravniBinding(Object obj, View view, int i, MaterialButton materialButton, MaterialButton materialButton2, MaterialButton materialButton3, FrameLayout frameLayout, ProgressBar progressBar) {
        super(obj, view, i);
        this.btnCancel = materialButton;
        this.btnRecount = materialButton2;
        this.btnRecountWithCount = materialButton3;
        this.flRecountWithCount = frameLayout;
        this.pbRecountWithCount = progressBar;
    }

    public static SlideupPanelButtonSravniBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static SlideupPanelButtonSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public ISlidingPanelButtonViewModel getButtonPanelViewModel() {
        return this.mButtonPanelViewModel;
    }

    public abstract void setButtonPanelViewModel(@Nullable ISlidingPanelButtonViewModel iSlidingPanelButtonViewModel);

    @Deprecated
    public static SlideupPanelButtonSravniBinding bind(@NonNull View view, @Nullable Object obj) {
        return (SlideupPanelButtonSravniBinding) ViewDataBinding.bind(obj, view, R.layout.slideup_panel_button_sravni);
    }

    @NonNull
    @Deprecated
    public static SlideupPanelButtonSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (SlideupPanelButtonSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.slideup_panel_button_sravni, viewGroup, z, obj);
    }

    @NonNull
    public static SlideupPanelButtonSravniBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static SlideupPanelButtonSravniBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (SlideupPanelButtonSravniBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.slideup_panel_button_sravni, null, false, obj);
    }
}
