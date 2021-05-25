package com.avito.android.calls.voximplant.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.avito.android.calls.CallVideoStream;
import com.avito.android.calls.R;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.webrtc.SurfaceViewRenderer;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\u000bB\u001b\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0017\u0010\u001aB#\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u0017\u0010\u001dJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\f8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/avito/android/calls/voximplant/widget/CallVideoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/avito/android/calls/CallVideoStream;", "stream", "", "setLocalStream", "(Lcom/avito/android/calls/CallVideoStream;)V", "setRemoteStream", "Landroid/content/Context;", "context", AuthSource.BOOKING_ORDER, "(Landroid/content/Context;)V", "Lorg/webrtc/SurfaceViewRenderer;", VKApiConst.Q, "Lorg/webrtc/SurfaceViewRenderer;", "remoteVideoView", "t", "Lcom/avito/android/calls/CallVideoStream;", "remoteStream", "r", "localVideoView", "s", "localStream", "<init>", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallVideoView extends ConstraintLayout {
    public SurfaceViewRenderer q;
    public SurfaceViewRenderer r;
    public CallVideoStream s;
    public CallVideoStream t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CallVideoView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        b(context);
    }

    public final void b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.call_video_view, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.local_video);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.local_video)");
        this.r = (SurfaceViewRenderer) findViewById;
        View findViewById2 = findViewById(R.id.remote_video);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.remote_video)");
        this.q = (SurfaceViewRenderer) findViewById2;
        SurfaceViewRenderer surfaceViewRenderer = this.r;
        if (surfaceViewRenderer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localVideoView");
        }
        surfaceViewRenderer.setZOrderMediaOverlay(true);
    }

    public final void setLocalStream(@Nullable CallVideoStream callVideoStream) {
        if (!Intrinsics.areEqual(this.s, callVideoStream)) {
            CallVideoStream callVideoStream2 = this.s;
            if (callVideoStream2 != null) {
                callVideoStream2.clearRenderer();
            }
            if (callVideoStream != null) {
                SurfaceViewRenderer surfaceViewRenderer = this.r;
                if (surfaceViewRenderer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("localVideoView");
                }
                callVideoStream.setRenderer(surfaceViewRenderer);
            }
            this.s = callVideoStream;
        }
    }

    public final void setRemoteStream(@Nullable CallVideoStream callVideoStream) {
        if (!Intrinsics.areEqual(this.t, callVideoStream)) {
            CallVideoStream callVideoStream2 = this.t;
            if (callVideoStream2 != null) {
                callVideoStream2.clearRenderer();
            }
            if (callVideoStream != null) {
                SurfaceViewRenderer surfaceViewRenderer = this.q;
                if (surfaceViewRenderer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("remoteVideoView");
                }
                callVideoStream.setRenderer(surfaceViewRenderer);
            }
            this.t = callVideoStream;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CallVideoView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        b(context);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CallVideoView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        b(context);
    }
}
