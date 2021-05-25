package l6.z;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;
@RequiresApi(21)
public class e implements c {
    public static Class<?> b;
    public static boolean c;
    public static Method d;
    public static boolean e;
    public static Method f;
    public static boolean g;
    public final View a;

    public e(@NonNull View view) {
        this.a = view;
    }

    @Override // l6.z.c
    public void a(ViewGroup viewGroup, View view) {
    }

    @Override // l6.z.c
    public void setVisibility(int i) {
        this.a.setVisibility(i);
    }
}
