package com.otaliastudios.cameraview.filter;

import android.content.res.TypedArray;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.R;
public class FilterParser {
    public Filter a = null;

    public FilterParser(@NonNull TypedArray typedArray) {
        try {
            this.a = (Filter) Class.forName(typedArray.getString(R.styleable.CameraView_cameraFilter)).newInstance();
        } catch (Exception unused) {
            this.a = new NoFilter();
        }
    }

    @NonNull
    public Filter getFilter() {
        return this.a;
    }
}
