package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.api.internal.LifecycleFragment;
public abstract class zab implements DialogInterface.OnClickListener {
    public static zab zaa(Activity activity, @Nullable Intent intent, int i) {
        return new zae(intent, activity, i);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            zaa();
        } catch (ActivityNotFoundException unused) {
            if (Build.FINGERPRINT.contains(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE)) {
                "Failed to start resolution intent.".concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
            }
        } finally {
            dialogInterface.dismiss();
        }
    }

    public abstract void zaa();

    public static zab zaa(@NonNull Fragment fragment, @Nullable Intent intent, int i) {
        return new zad(intent, fragment, i);
    }

    public static zab zaa(@NonNull LifecycleFragment lifecycleFragment, @Nullable Intent intent, int i) {
        return new zaf(intent, lifecycleFragment, 2);
    }
}
