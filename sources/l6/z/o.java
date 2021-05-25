package l6.z;

import android.os.Build;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.lang.reflect.Method;
public class o {
    public static boolean a = true;
    public static Method b;
    public static boolean c;

    public static void a(@NonNull ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z);
        } else if (a) {
            try {
                viewGroup.suppressLayout(z);
            } catch (NoSuchMethodError unused) {
                a = false;
            }
        }
    }
}
