package com.otaliastudios.cameraview.engine.action;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
@RequiresApi(21)
public abstract class CompletionCallback implements ActionCallback {
    public abstract void onActionCompleted(@NonNull Action action);

    @Override // com.otaliastudios.cameraview.engine.action.ActionCallback
    public final void onActionStateChanged(@NonNull Action action, int i) {
        if (i == Integer.MAX_VALUE) {
            onActionCompleted(action);
        }
    }
}
