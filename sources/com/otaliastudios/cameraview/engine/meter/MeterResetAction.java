package com.otaliastudios.cameraview.engine.meter;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.engine.action.ActionWrapper;
import com.otaliastudios.cameraview.engine.action.Actions;
import com.otaliastudios.cameraview.engine.action.BaseAction;
@RequiresApi(21)
public class MeterResetAction extends ActionWrapper {
    public final BaseAction e = Actions.together(new ExposureReset(), new FocusReset(), new WhiteBalanceReset());

    @Override // com.otaliastudios.cameraview.engine.action.ActionWrapper
    @NonNull
    public BaseAction getAction() {
        return this.e;
    }
}
