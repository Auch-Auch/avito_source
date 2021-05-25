package l6.z;

import android.view.View;
import android.view.WindowId;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
@RequiresApi(18)
public class w implements x {
    public final WindowId a;

    public w(@NonNull View view) {
        this.a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof w) && ((w) obj).a.equals(this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
