package l6.z;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
@RequiresApi(19)
public class q extends v {
    public static boolean e = true;

    @Override // l6.z.v
    public void a(@NonNull View view) {
    }

    @Override // l6.z.v
    @SuppressLint({"NewApi"})
    public float b(@NonNull View view) {
        if (e) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                e = false;
            }
        }
        return view.getAlpha();
    }

    @Override // l6.z.v
    public void c(@NonNull View view) {
    }

    @Override // l6.z.v
    @SuppressLint({"NewApi"})
    public void f(@NonNull View view, float f) {
        if (e) {
            try {
                view.setTransitionAlpha(f);
                return;
            } catch (NoSuchMethodError unused) {
                e = false;
            }
        }
        view.setAlpha(f);
    }
}
