package a2.j.b.b.r0;

import android.media.AudioTrack;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
public class o extends Thread {
    public final /* synthetic */ AudioTrack a;

    public o(DefaultAudioSink defaultAudioSink, AudioTrack audioTrack) {
        this.a = audioTrack;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.a.release();
    }
}
