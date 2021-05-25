package com.avito.android.extended_profile_settings;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/extended_profile_settings/ExtendedProfileSettingsViewImpl;", "Lcom/avito/android/extended_profile_settings/ExtendedProfileSettingsView;", "Landroidx/lifecycle/LifecycleOwner;", "c", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/avito/android/extended_profile_settings/ExtendedProfileSettingsViewModel;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/extended_profile_settings/ExtendedProfileSettingsViewModel;", "viewModel", "Landroid/view/View;", AuthSource.SEND_ABUSE, "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;Lcom/avito/android/extended_profile_settings/ExtendedProfileSettingsViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "extended-profile-settings_release"}, k = 1, mv = {1, 4, 2})
public final class ExtendedProfileSettingsViewImpl implements ExtendedProfileSettingsView {
    public final View a;
    public final ExtendedProfileSettingsViewModel b;
    public final LifecycleOwner c;

    public ExtendedProfileSettingsViewImpl(@NotNull View view, @NotNull ExtendedProfileSettingsViewModel extendedProfileSettingsViewModel, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(extendedProfileSettingsViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.a = view;
        this.b = extendedProfileSettingsViewModel;
        this.c = lifecycleOwner;
    }
}
