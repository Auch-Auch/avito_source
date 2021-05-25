package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.transition.Transition;
public final class PreloadTarget<Z> extends CustomTarget<Z> {
    public static final Handler e = new Handler(Looper.getMainLooper(), new a());
    public final RequestManager d;

    public class a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            PreloadTarget preloadTarget = (PreloadTarget) message.obj;
            preloadTarget.d.clear(preloadTarget);
            return true;
        }
    }

    public PreloadTarget(RequestManager requestManager, int i, int i2) {
        super(i, i2);
        this.d = requestManager;
    }

    public static <Z> PreloadTarget<Z> obtain(RequestManager requestManager, int i, int i2) {
        return new PreloadTarget<>(requestManager, i, i2);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onResourceReady(@NonNull Z z, @Nullable Transition<? super Z> transition) {
        e.obtainMessage(1, this).sendToTarget();
    }
}
