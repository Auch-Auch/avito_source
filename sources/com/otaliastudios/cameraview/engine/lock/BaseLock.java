package com.otaliastudios.cameraview.engine.lock;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import com.otaliastudios.cameraview.engine.action.BaseAction;
@RequiresApi(21)
public abstract class BaseLock extends BaseAction {
    public abstract boolean checkIsSupported(@NonNull ActionHolder actionHolder);

    public abstract boolean checkShouldSkip(@NonNull ActionHolder actionHolder);

    @Override // com.otaliastudios.cameraview.engine.action.BaseAction
    public final void onStart(@NonNull ActionHolder actionHolder) {
        super.onStart(actionHolder);
        boolean checkShouldSkip = checkShouldSkip(actionHolder);
        if (!checkIsSupported(actionHolder) || checkShouldSkip) {
            setState(Integer.MAX_VALUE);
        } else {
            onStarted(actionHolder);
        }
    }

    public abstract void onStarted(@NonNull ActionHolder actionHolder);
}
