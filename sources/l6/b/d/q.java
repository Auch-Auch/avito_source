package l6.b.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ResourceManagerInternal;
import java.lang.ref.WeakReference;
public class q extends n {
    public final WeakReference<Context> b;

    public q(@NonNull Context context, @NonNull Resources resources) {
        super(resources);
        this.b = new WeakReference<>(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        Drawable drawable = this.a.getDrawable(i);
        Context context = this.b.get();
        if (!(drawable == null || context == null)) {
            ResourceManagerInternal.get().i(context, i, drawable);
        }
        return drawable;
    }
}
