package a2.j.b.d.l;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.material.internal.ViewOverlayImpl;
@RequiresApi(18)
public class b implements ViewOverlayImpl {
    public final ViewOverlay a;

    public b(@NonNull View view) {
        this.a = view.getOverlay();
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void add(@NonNull Drawable drawable) {
        this.a.add(drawable);
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void remove(@NonNull Drawable drawable) {
        this.a.remove(drawable);
    }
}
