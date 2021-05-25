package com.my.target;

import android.app.UiModeManager;
import android.content.Context;
import androidx.annotation.NonNull;
public class ey extends fb {
    public static boolean B(@NonNull Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 3;
    }

    @Override // com.my.target.fb
    public void collectData(@NonNull Context context) {
        addParam("isc", B(context) ? "1" : null);
    }
}
