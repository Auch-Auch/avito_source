package l6.z;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
@RequiresApi(22)
public class s extends r {
    public static boolean i = true;

    @Override // l6.z.v
    @SuppressLint({"NewApi"})
    public void e(@NonNull View view, int i2, int i3, int i4, int i5) {
        if (i) {
            try {
                view.setLeftTopRightBottom(i2, i3, i4, i5);
            } catch (NoSuchMethodError unused) {
                i = false;
            }
        }
    }
}
