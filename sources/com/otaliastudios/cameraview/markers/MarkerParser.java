package com.otaliastudios.cameraview.markers;

import android.content.res.TypedArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.otaliastudios.cameraview.R;
public class MarkerParser {
    public AutoFocusMarker a = null;

    public MarkerParser(@NonNull TypedArray typedArray) {
        String string = typedArray.getString(R.styleable.CameraView_cameraAutoFocusMarker);
        if (string != null) {
            try {
                this.a = (AutoFocusMarker) Class.forName(string).newInstance();
            } catch (Exception unused) {
            }
        }
    }

    @Nullable
    public AutoFocusMarker getAutoFocusMarker() {
        return this.a;
    }
}
