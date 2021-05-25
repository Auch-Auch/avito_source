package com.avito.android.photo_gallery.zoom;

import android.graphics.Matrix;
import com.avito.android.photo_gallery.zoom.ZoomableController;
import java.util.ArrayList;
import java.util.List;
public class MultiZoomableControllerListener implements ZoomableController.Listener {
    public final List<ZoomableController.Listener> a = new ArrayList();

    public synchronized void addListener(ZoomableController.Listener listener) {
        this.a.add(listener);
    }

    @Override // com.avito.android.photo_gallery.zoom.ZoomableController.Listener
    public synchronized void onTransformBegin(Matrix matrix) {
        for (ZoomableController.Listener listener : this.a) {
            listener.onTransformBegin(matrix);
        }
    }

    @Override // com.avito.android.photo_gallery.zoom.ZoomableController.Listener
    public synchronized void onTransformChanged(Matrix matrix) {
        for (ZoomableController.Listener listener : this.a) {
            listener.onTransformChanged(matrix);
        }
    }

    @Override // com.avito.android.photo_gallery.zoom.ZoomableController.Listener
    public synchronized void onTransformEnd(Matrix matrix) {
        for (ZoomableController.Listener listener : this.a) {
            listener.onTransformEnd(matrix);
        }
    }

    public synchronized void removeListener(ZoomableController.Listener listener) {
        this.a.remove(listener);
    }
}
