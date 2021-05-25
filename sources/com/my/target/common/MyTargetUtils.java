package com.my.target.common;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.my.target.fc;
import com.my.target.im;
import java.util.Map;
public class MyTargetUtils {
    @NonNull
    @WorkerThread
    public static Map<String, String> collectInfo(@NonNull Context context) {
        fc.dP().collectData(context);
        return fc.dP().getData();
    }

    public static void sendStat(@NonNull String str, @NonNull Context context) {
        im.o(str, context);
    }
}
