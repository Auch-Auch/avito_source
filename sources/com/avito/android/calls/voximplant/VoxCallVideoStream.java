package com.avito.android.calls.voximplant;

import a2.b.a.a.a;
import com.avito.android.calls.CallVideoStream;
import com.avito.android.remote.auth.AuthSource;
import com.voximplant.sdk.call.IVideoStream;
import com.voximplant.sdk.call.RenderScaleType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.webrtc.VideoSink;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00118V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/calls/voximplant/VoxCallVideoStream;", "Lcom/avito/android/calls/CallVideoStream;", "Lorg/webrtc/VideoSink;", "sink", "", "setRenderer", "(Lorg/webrtc/VideoSink;)V", "clearRenderer", "()V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getStreamId", "streamId", AuthSource.SEND_ABUSE, "Lorg/webrtc/VideoSink;", "currentRenderer", "Lcom/voximplant/sdk/call/IVideoStream;", AuthSource.BOOKING_ORDER, "Lcom/voximplant/sdk/call/IVideoStream;", "stream", "<init>", "(Lcom/voximplant/sdk/call/IVideoStream;)V", "calls_release"}, k = 1, mv = {1, 4, 2})
public final class VoxCallVideoStream implements CallVideoStream {
    public VideoSink a;
    public final IVideoStream b;

    public VoxCallVideoStream(@NotNull IVideoStream iVideoStream) {
        Intrinsics.checkNotNullParameter(iVideoStream, "stream");
        this.b = iVideoStream;
    }

    @Override // com.avito.android.calls.CallVideoStream
    public void clearRenderer() {
        VideoSink videoSink = this.a;
        if (videoSink != null) {
            this.b.removeVideoRenderer(videoSink);
        }
        this.a = null;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VoxCallVideoStream) && !(Intrinsics.areEqual(this.b, ((VoxCallVideoStream) obj).b) ^ true);
    }

    @Override // com.avito.android.calls.CallVideoStream
    @NotNull
    public String getStreamId() {
        String videoStreamId = this.b.getVideoStreamId();
        Intrinsics.checkNotNullExpressionValue(videoStreamId, "stream.videoStreamId");
        return videoStreamId;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    @Override // com.avito.android.calls.CallVideoStream
    public void setRenderer(@NotNull VideoSink videoSink) {
        Intrinsics.checkNotNullParameter(videoSink, "sink");
        if (!Intrinsics.areEqual(this.a, videoSink)) {
            VideoSink videoSink2 = this.a;
            if (videoSink2 != null) {
                this.b.removeVideoRenderer(videoSink2);
            }
            this.b.addVideoRenderer(videoSink, RenderScaleType.SCALE_FIT);
            this.a = videoSink;
        }
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("VoxCallVideoStream(streamId=");
        L.append(getStreamId());
        L.append(", type=");
        L.append(this.b.getVideoStreamType());
        L.append(')');
        return L.toString();
    }
}
