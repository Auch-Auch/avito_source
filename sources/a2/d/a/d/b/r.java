package a2.d.a.d.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.load.engine.Resource;
public class r {
    public boolean a;
    public final Handler b = new Handler(Looper.getMainLooper(), new a());

    public static final class a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((Resource) message.obj).recycle();
            return true;
        }
    }

    public synchronized void a(Resource<?> resource, boolean z) {
        if (!this.a) {
            if (!z) {
                this.a = true;
                resource.recycle();
                this.a = false;
            }
        }
        this.b.obtainMessage(1, resource).sendToTarget();
    }
}
