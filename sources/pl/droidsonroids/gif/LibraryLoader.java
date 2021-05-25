package pl.droidsonroids.gif;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
public class LibraryLoader {
    @SuppressLint({"StaticFieldLeak"})
    public static Context a;

    public static void initialize(@NonNull Context context) {
        a = context.getApplicationContext();
    }
}
