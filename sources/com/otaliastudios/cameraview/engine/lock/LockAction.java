package com.otaliastudios.cameraview.engine.lock;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.engine.action.ActionWrapper;
import com.otaliastudios.cameraview.engine.action.Actions;
import com.otaliastudios.cameraview.engine.action.BaseAction;
@RequiresApi(21)
public class LockAction extends ActionWrapper {
    public final BaseAction e = Actions.together(new ExposureLock(), new FocusLock(), new WhiteBalanceLock());

    @Override // com.otaliastudios.cameraview.engine.action.ActionWrapper
    @NonNull
    public BaseAction getAction() {
        return this.e;
    }
}
