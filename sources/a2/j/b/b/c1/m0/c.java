package a2.j.b.b.c1.m0;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView;
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ SphericalGLSurfaceView a;
    public final /* synthetic */ SurfaceTexture b;

    public /* synthetic */ c(SphericalGLSurfaceView sphericalGLSurfaceView, SurfaceTexture surfaceTexture) {
        this.a = sphericalGLSurfaceView;
        this.b = surfaceTexture;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SphericalGLSurfaceView sphericalGLSurfaceView = this.a;
        SurfaceTexture surfaceTexture = this.b;
        SurfaceTexture surfaceTexture2 = sphericalGLSurfaceView.g;
        Surface surface = sphericalGLSurfaceView.h;
        sphericalGLSurfaceView.g = surfaceTexture;
        Surface surface2 = new Surface(surfaceTexture);
        sphericalGLSurfaceView.h = surface2;
        Player.VideoComponent videoComponent = sphericalGLSurfaceView.i;
        if (videoComponent != null) {
            videoComponent.setVideoSurface(surface2);
        }
        if (surfaceTexture2 != null) {
            surfaceTexture2.release();
        }
        if (surface != null) {
            surface.release();
        }
    }
}
