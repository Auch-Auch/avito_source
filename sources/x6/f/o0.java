package x6.f;

import org.webrtc.CalledByNative;
import org.webrtc.CandidatePairChangeEvent;
import org.webrtc.PeerConnection;
import org.webrtc.RtpTransceiver;
/* compiled from: PeerConnection */
public final /* synthetic */ class o0 {
    @CalledByNative("Observer")
    public static void $default$onConnectionChange(PeerConnection.Observer observer, PeerConnection.PeerConnectionState peerConnectionState) {
    }

    @CalledByNative("Observer")
    public static void $default$onSelectedCandidatePairChanged(PeerConnection.Observer observer, CandidatePairChangeEvent candidatePairChangeEvent) {
    }

    @CalledByNative("Observer")
    public static void $default$onStandardizedIceConnectionChange(PeerConnection.Observer observer, PeerConnection.IceConnectionState iceConnectionState) {
    }

    @CalledByNative("Observer")
    public static void $default$onTrack(PeerConnection.Observer observer, RtpTransceiver rtpTransceiver) {
    }
}
