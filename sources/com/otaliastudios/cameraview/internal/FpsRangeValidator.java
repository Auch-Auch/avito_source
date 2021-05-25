package com.otaliastudios.cameraview.internal;

import android.os.Build;
import android.util.Range;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RequiresApi(21)
public class FpsRangeValidator {
    public static final CameraLogger a = CameraLogger.create("FpsRangeValidator");
    public static final Map<String, List<Range<Integer>>> b;

    static {
        HashMap hashMap = new HashMap();
        b = hashMap;
        hashMap.put("Google Pixel 4", Arrays.asList(new Range(15, 60)));
    }

    public static boolean validate(Range<Integer> range) {
        CameraLogger cameraLogger = a;
        String str = Build.MODEL;
        String str2 = Build.MANUFACTURER;
        cameraLogger.i("Build.MODEL:", str, "Build.BRAND:", Build.BRAND, "Build.MANUFACTURER:", str2);
        List<Range<Integer>> list = b.get(str2 + " " + str);
        if (list == null || !list.contains(range)) {
            return true;
        }
        cameraLogger.i("Dropping range:", range);
        return false;
    }
}
