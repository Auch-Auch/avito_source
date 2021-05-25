package com.yandex.runtime.ui_view;

import a2.b.a.a.a;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import com.yandex.runtime.image.ImageProvider;
import java.util.UUID;
public class ViewProvider {
    private final boolean cacheable;
    private final String id;
    private Bitmap image;
    private int version;
    private final View view;

    public ViewProvider(View view2, boolean z) {
        this.view = view2;
        StringBuilder L = a.L("view: ");
        L.append(UUID.randomUUID().toString());
        this.id = L.toString();
        this.version = 0;
        this.cacheable = z;
        snapshot();
    }

    private ImageProvider getImageProvider() {
        Bitmap bitmap = this.image;
        boolean z = this.cacheable;
        return ImageProvider.fromBitmap(bitmap, z, this.id + "#" + String.valueOf(this.version));
    }

    public String getId() {
        return this.id;
    }

    public boolean isCacheable() {
        return this.cacheable;
    }

    public void snapshot() {
        this.view.measure(0, 0);
        this.image = Bitmap.createBitmap(this.view.getMeasuredWidth(), this.view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.image);
        View view2 = this.view;
        view2.layout(0, 0, view2.getMeasuredWidth(), this.view.getMeasuredHeight());
        this.view.draw(canvas);
        this.version++;
    }

    public ViewProvider(View view2) {
        this(view2, true);
    }
}
