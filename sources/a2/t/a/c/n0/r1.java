package a2.t.a.c.n0;

import a2.b.a.a.a;
import com.voximplant.sdk.call.IAudioStream;
import com.voximplant.sdk.internal.Logger;
import java.util.UUID;
import org.webrtc.AudioSource;
import org.webrtc.AudioTrack;
import org.webrtc.MediaConstraints;
import org.webrtc.PeerConnectionFactory;
public class r1 implements IAudioStream {
    public String a;
    public AudioTrack b;
    public boolean c;
    public AudioSource d;

    public r1(String str) {
        this.a = str;
        this.c = true;
    }

    public boolean a() {
        return this.c;
    }

    public void b(boolean z) {
        Logger.i(c() + "setAudioTrackEnabled: " + z);
        AudioTrack audioTrack = this.b;
        if (audioTrack != null) {
            audioTrack.setEnabled(z);
            return;
        }
        Logger.e(c() + "setAudioTrackEnabled: audio track is invalid");
    }

    public final String c() {
        StringBuilder L = a.L("AudioStream [");
        L.append(this.a);
        L.append(this.c ? ",ACTIVE] " : "INACTIVE] ");
        return L.toString();
    }

    @Override // com.voximplant.sdk.call.IAudioStream
    public String getAudioStreamId() {
        return this.a;
    }

    public String toString() {
        StringBuilder L = a.L("AudioStream: ");
        L.append(this.a);
        return L.toString();
    }

    public r1(PeerConnectionFactory peerConnectionFactory, MediaConstraints mediaConstraints, boolean z) {
        this.d = peerConnectionFactory.createAudioSource(mediaConstraints);
        AudioTrack createAudioTrack = peerConnectionFactory.createAudioTrack(UUID.randomUUID().toString(), this.d);
        this.b = createAudioTrack;
        createAudioTrack.setEnabled(z);
        this.a = this.b.id();
        this.c = true;
    }
}
