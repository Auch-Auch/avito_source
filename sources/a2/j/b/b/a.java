package a2.j.b.b;

import com.google.android.exoplayer2.AudioFocusManager;
import com.google.android.exoplayer2.audio.AudioAttributes;
import java.util.Objects;
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ AudioFocusManager.a a;
    public final /* synthetic */ int b;

    public /* synthetic */ a(AudioFocusManager.a aVar, int i) {
        this.a = aVar;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioFocusManager.a aVar = this.a;
        int i = this.b;
        AudioFocusManager audioFocusManager = AudioFocusManager.this;
        Objects.requireNonNull(audioFocusManager);
        boolean z = true;
        if (i == -3 || i == -2) {
            if (i != -2) {
                AudioAttributes audioAttributes = audioFocusManager.d;
                if (audioAttributes == null || audioAttributes.contentType != 1) {
                    z = false;
                }
                if (!z) {
                    audioFocusManager.d(3);
                    return;
                }
            }
            audioFocusManager.b(0);
            audioFocusManager.d(2);
        } else if (i == -1) {
            audioFocusManager.b(-1);
            audioFocusManager.a();
        } else if (i != 1) {
            a2.b.a.a.a.T0("Unknown focus change type: ", i, "AudioFocusManager");
        } else {
            audioFocusManager.d(1);
            audioFocusManager.b(1);
        }
    }
}
