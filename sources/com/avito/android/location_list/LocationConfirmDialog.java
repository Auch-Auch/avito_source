package com.avito.android.location_list;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.remote.model.Location;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/location_list/LocationConfirmDialog;", "Landroidx/fragment/app/DialogFragment;", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Lcom/avito/android/location_list/LocationConfirmListener;", "locationListener", "Lcom/avito/android/location_list/LocationConfirmListener;", "getLocationListener", "()Lcom/avito/android/location_list/LocationConfirmListener;", "setLocationListener", "(Lcom/avito/android/location_list/LocationConfirmListener;)V", "<init>", "()V", "location-list_release"}, k = 1, mv = {1, 4, 2})
public final class LocationConfirmDialog extends DialogFragment {
    public LocationConfirmListener locationListener;

    @NotNull
    public final LocationConfirmListener getLocationListener() {
        LocationConfirmListener locationConfirmListener = this.locationListener;
        if (locationConfirmListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationListener");
        }
        return locationConfirmListener;
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        LocationConfirmViewImpl locationConfirmViewImpl = new LocationConfirmViewImpl(requireActivity);
        LocationConfirmListener locationConfirmListener = this.locationListener;
        if (locationConfirmListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationListener");
        }
        Bundle arguments = getArguments();
        Location location = arguments != null ? (Location) arguments.getParcelable("key_location") : null;
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        new LocationConfirmPresenterImpl(locationConfirmListener, location, new LocationConfirmResourceProviderImpl(resources), locationConfirmViewImpl).handleShow();
        return locationConfirmViewImpl.createDialog();
    }

    public final void setLocationListener(@NotNull LocationConfirmListener locationConfirmListener) {
        Intrinsics.checkNotNullParameter(locationConfirmListener, "<set-?>");
        this.locationListener = locationConfirmListener;
    }
}
