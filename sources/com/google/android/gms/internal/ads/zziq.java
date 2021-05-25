package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.google.android.exoplayer2.C;
import org.spongycastle.asn1.cmc.BodyPartID;
public class zziq {
    private int zzahj;
    public AudioTrack zzaju;
    private boolean zzalm;
    private long zzaln;
    private long zzalo;
    private long zzalp;
    private long zzalq;
    private long zzalr;
    private long zzals;

    private zziq() {
    }

    public final void pause() {
        if (this.zzalq == C.TIME_UNSET) {
            this.zzaju.pause();
        }
    }

    public void zza(AudioTrack audioTrack, boolean z) {
        this.zzaju = audioTrack;
        this.zzalm = z;
        this.zzalq = C.TIME_UNSET;
        this.zzaln = 0;
        this.zzalo = 0;
        this.zzalp = 0;
        if (audioTrack != null) {
            this.zzahj = audioTrack.getSampleRate();
        }
    }

    public final void zzdy(long j) {
        this.zzalr = zzfw();
        this.zzalq = SystemClock.elapsedRealtime() * 1000;
        this.zzals = j;
        this.zzaju.stop();
    }

    public final long zzfw() {
        if (this.zzalq != C.TIME_UNSET) {
            return Math.min(this.zzals, this.zzalr + ((((SystemClock.elapsedRealtime() * 1000) - this.zzalq) * ((long) this.zzahj)) / 1000000));
        }
        int playState = this.zzaju.getPlayState();
        if (playState == 1) {
            return 0;
        }
        long playbackHeadPosition = BodyPartID.bodyIdMax & ((long) this.zzaju.getPlaybackHeadPosition());
        if (this.zzalm) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.zzalp = this.zzaln;
            }
            playbackHeadPosition += this.zzalp;
        }
        if (this.zzaln > playbackHeadPosition) {
            this.zzalo++;
        }
        this.zzaln = playbackHeadPosition;
        return playbackHeadPosition + (this.zzalo << 32);
    }

    public final long zzfx() {
        return (zzfw() * 1000000) / ((long) this.zzahj);
    }

    public boolean zzfy() {
        return false;
    }

    public long zzfz() {
        throw new UnsupportedOperationException();
    }

    public long zzga() {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ zziq(zzir zzir) {
        this();
    }
}
