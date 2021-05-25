package l6.z;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
@RequiresApi(23)
public class t extends s {
    public static boolean j = true;

    @Override // l6.z.v
    @SuppressLint({"NewApi"})
    public void g(@NonNull View view, int i) {
        if (Build.VERSION.SDK_INT == 28) {
            super.g(view, i);
        } else if (j) {
            try {
                view.setTransitionVisibility(i);
            } catch (NoSuchMethodError unused) {
                j = false;
            }
        }
    }
}
