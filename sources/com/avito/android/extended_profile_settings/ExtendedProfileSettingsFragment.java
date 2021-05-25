package com.avito.android.extended_profile_settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.extended_profile_settings.di.DaggerExtendedProfileSettingsComponent;
import com.avito.android.extended_profile_settings.di.ExtendedProfileSettingsDependencies;
import com.avito.android.ui.fragments.TabBaseFragment;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/extended_profile_settings/ExtendedProfileSettingsFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/avito/android/extended_profile_settings/ExtendedProfileSettingsViewModel;", "viewModel", "Lcom/avito/android/extended_profile_settings/ExtendedProfileSettingsViewModel;", "getViewModel", "()Lcom/avito/android/extended_profile_settings/ExtendedProfileSettingsViewModel;", "setViewModel", "(Lcom/avito/android/extended_profile_settings/ExtendedProfileSettingsViewModel;)V", "<init>", "()V", "Companion", "extended-profile-settings_release"}, k = 1, mv = {1, 4, 2})
public final class ExtendedProfileSettingsFragment extends TabBaseFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public ExtendedProfileSettingsViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/extended_profile_settings/ExtendedProfileSettingsFragment$Companion;", "", "Lcom/avito/android/extended_profile_settings/ExtendedProfileSettingsFragment;", "newInstance", "()Lcom/avito/android/extended_profile_settings/ExtendedProfileSettingsFragment;", "<init>", "()V", "extended-profile-settings_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final ExtendedProfileSettingsFragment newInstance() {
            return new ExtendedProfileSettingsFragment();
        }

        public Companion(j jVar) {
        }
    }

    @NotNull
    public final ExtendedProfileSettingsViewModel getViewModel() {
        ExtendedProfileSettingsViewModel extendedProfileSettingsViewModel = this.viewModel;
        if (extendedProfileSettingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return extendedProfileSettingsViewModel;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        DaggerExtendedProfileSettingsComponent.factory().create(this, (ExtendedProfileSettingsDependencies) ComponentDependenciesKt.getDependencies(ExtendedProfileSettingsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).inject(this);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.extended_profile_settings_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ExtendedProfileSettingsViewModel extendedProfileSettingsViewModel = this.viewModel;
        if (extendedProfileSettingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        new ExtendedProfileSettingsViewImpl(view, extendedProfileSettingsViewModel, viewLifecycleOwner);
    }

    public final void setViewModel(@NotNull ExtendedProfileSettingsViewModel extendedProfileSettingsViewModel) {
        Intrinsics.checkNotNullParameter(extendedProfileSettingsViewModel, "<set-?>");
        this.viewModel = extendedProfileSettingsViewModel;
    }
}
