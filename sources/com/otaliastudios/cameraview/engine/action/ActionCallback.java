package com.otaliastudios.cameraview.engine.action;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
@RequiresApi(21)
public interface ActionCallback {
    void onActionStateChanged(@NonNull Action action, int i);
}
