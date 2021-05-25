package com.facebook.appevents.ml;

import androidx.annotation.Nullable;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.io.File;
@AutoHandleExceptions
public class Utils {
    @Nullable
    public static File getMlDir() {
        File file = new File(FacebookSdk.getApplicationContext().getFilesDir(), "facebook_ml/");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }
}
