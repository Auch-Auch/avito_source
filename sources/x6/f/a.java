package x6.f;

import org.webrtc.Camera1Session;
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ Camera1Session.AnonymousClass2 a;
    public final /* synthetic */ byte[] b;

    public /* synthetic */ a(Camera1Session.AnonymousClass2 r1, byte[] bArr) {
        this.a = r1;
        this.b = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Camera1Session.AnonymousClass2 r0 = this.a;
        Camera1Session.this.cameraThreadHandler.post(new Runnable(this.b) { // from class: x6.f.b
            public final /* synthetic */ byte[] b;

            {
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Camera1Session.AnonymousClass2 r02 = Camera1Session.AnonymousClass2.this;
                byte[] bArr = this.b;
                if (Camera1Session.this.state == Camera1Session.SessionState.RUNNING) {
                    Camera1Session.this.camera.addCallbackBuffer(bArr);
                }
            }
        });
    }
}
