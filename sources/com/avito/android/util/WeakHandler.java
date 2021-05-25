package com.avito.android.util;

import android.os.Handler;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.social.AppleSignInManagerKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001:\u0001 B\t\b\u0016¢\u0006\u0004\b\u001e\u0010\u001fB\u0013\b\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u001e\u0010\u001dJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0012\u001a\u00020\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013R \u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R(\u0010\u0019\u001a\u0004\u0018\u00010\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u00158F@FX\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/util/WeakHandler;", "Landroid/os/Handler;", "Landroid/os/Message;", NotificationCompat.CATEGORY_MESSAGE, "", "handleMessage", "(Landroid/os/Message;)V", "", "what", "", "scheduleEmptyMessage", "(I)Z", "", "delayMillis", "scheduleEmptyMessageDelayed", "(IJ)Z", "", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "deleteCallbacksAndMessages", "(Ljava/lang/Object;)V", "Ljava/lang/ref/WeakReference;", "Lcom/avito/android/util/WeakHandler$MessageListener;", AuthSource.SEND_ABUSE, "Ljava/lang/ref/WeakReference;", "listenerRef", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getListener", "()Lcom/avito/android/util/WeakHandler$MessageListener;", "setListener", "(Lcom/avito/android/util/WeakHandler$MessageListener;)V", "<init>", "()V", "MessageListener", "android_release"}, k = 1, mv = {1, 4, 2})
public class WeakHandler extends Handler {
    public WeakReference<MessageListener> a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/util/WeakHandler$MessageListener;", "", "Landroid/os/Message;", NotificationCompat.CATEGORY_MESSAGE, "", "handleMessage", "(Landroid/os/Message;)V", "android_release"}, k = 1, mv = {1, 4, 2})
    public interface MessageListener {
        void handleMessage(@NotNull Message message);
    }

    public WeakHandler() {
    }

    public static /* synthetic */ void deleteCallbacksAndMessages$default(WeakHandler weakHandler, Object obj, int i, Object obj2) {
        if (obj2 == null) {
            if ((i & 1) != 0) {
                obj = null;
            }
            weakHandler.deleteCallbacksAndMessages(obj);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteCallbacksAndMessages");
    }

    @JvmOverloads
    public final void deleteCallbacksAndMessages() {
        deleteCallbacksAndMessages$default(this, null, 1, null);
    }

    @JvmOverloads
    public final void deleteCallbacksAndMessages(@Nullable Object obj) {
        removeCallbacksAndMessages(obj);
    }

    @Nullable
    public final MessageListener getListener() {
        WeakReference<MessageListener> weakReference = this.a;
        if (weakReference == null) {
            return null;
        }
        Intrinsics.checkNotNull(weakReference);
        return weakReference.get();
    }

    @Override // android.os.Handler
    public void handleMessage(@NotNull Message message) {
        Intrinsics.checkNotNullParameter(message, NotificationCompat.CATEGORY_MESSAGE);
        MessageListener listener = getListener();
        if (listener != null) {
            listener.handleMessage(message);
        }
    }

    public final boolean scheduleEmptyMessage(int i) {
        return sendEmptyMessage(i);
    }

    public final boolean scheduleEmptyMessageDelayed(int i, long j) {
        return sendEmptyMessageDelayed(i, j);
    }

    public final void setListener(@Nullable MessageListener messageListener) {
        this.a = new WeakReference<>(messageListener);
    }

    public WeakHandler(@Nullable MessageListener messageListener) {
        this.a = new WeakReference<>(messageListener);
    }
}
