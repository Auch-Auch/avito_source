package com.avito.android.in_app_calls.ui.video;

import com.avito.android.calls.CallVideoStream;
import com.avito.android.calls.voximplant.widget.CallVideoView;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/avito/android/in_app_calls/ui/video/CallVideoRenderer;", "", "Lcom/avito/android/calls/CallVideoStream;", "stream", "", "setLocalVideoStream", "(Lcom/avito/android/calls/CallVideoStream;)V", "setRemoteVideoStream", "Lcom/avito/android/calls/voximplant/widget/CallVideoView;", "view", "attach", "(Lcom/avito/android/calls/voximplant/widget/CallVideoView;)V", "detach", "()V", AuthSource.SEND_ABUSE, "Lcom/avito/android/calls/voximplant/widget/CallVideoView;", "videoView", AuthSource.BOOKING_ORDER, "Lcom/avito/android/calls/CallVideoStream;", "localStream", "c", "remoteStream", "<init>", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallVideoRenderer {
    public CallVideoView a;
    public CallVideoStream b;
    public CallVideoStream c;

    public final void attach(@NotNull CallVideoView callVideoView) {
        Intrinsics.checkNotNullParameter(callVideoView, "view");
        callVideoView.setRemoteStream(this.c);
        callVideoView.setLocalStream(this.b);
        this.a = callVideoView;
    }

    public final void detach() {
        CallVideoView callVideoView = this.a;
        if (callVideoView != null) {
            callVideoView.setRemoteStream(null);
        }
        CallVideoView callVideoView2 = this.a;
        if (callVideoView2 != null) {
            callVideoView2.setLocalStream(null);
        }
        this.a = null;
    }

    public final void setLocalVideoStream(@Nullable CallVideoStream callVideoStream) {
        this.b = callVideoStream;
        CallVideoView callVideoView = this.a;
        if (callVideoView != null) {
            callVideoView.setLocalStream(callVideoStream);
        }
    }

    public final void setRemoteVideoStream(@Nullable CallVideoStream callVideoStream) {
        this.c = callVideoStream;
        CallVideoView callVideoView = this.a;
        if (callVideoView != null) {
            callVideoView.setRemoteStream(callVideoStream);
        }
    }
}
