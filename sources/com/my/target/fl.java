package com.my.target;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.my.target.instreamads.InstreamAdPlayer;
import com.my.target.is;
public class fl extends FrameLayout implements InstreamAdPlayer, is.a {
    @NonNull
    public final fq a;
    @Nullable
    public InstreamAdPlayer.AdPlayerListener b;
    public int c;
    public int d;
    public boolean e;
    public boolean f;
    @Nullable
    public iu g;

    public fl(@NonNull Context context) {
        this(context, null);
    }

    public fl(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public fl(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        fq fqVar = new fq(context);
        this.a = fqVar;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        addView(fqVar, layoutParams);
    }

    @Override // com.my.target.is.a
    public void A() {
        this.f = true;
        InstreamAdPlayer.AdPlayerListener adPlayerListener = this.b;
        if (adPlayerListener != null) {
            adPlayerListener.onAdVideoPaused();
        }
    }

    @Override // com.my.target.is.a
    public void B() {
        if (this.f) {
            InstreamAdPlayer.AdPlayerListener adPlayerListener = this.b;
            if (adPlayerListener != null) {
                adPlayerListener.onAdVideoResumed();
            }
            this.f = false;
        }
    }

    @Override // com.my.target.is.a
    public void C() {
    }

    @Override // com.my.target.is.a
    public void D() {
    }

    @Override // com.my.target.is.a
    public void a(float f2, float f3) {
    }

    @Override // com.my.target.is.a
    public void d(float f2) {
        InstreamAdPlayer.AdPlayerListener adPlayerListener = this.b;
        if (adPlayerListener != null) {
            adPlayerListener.onVolumeChanged(f2);
        }
    }

    @Override // com.my.target.instreamads.InstreamAdPlayer
    public void destroy() {
        iu iuVar = this.g;
        if (iuVar != null) {
            iuVar.destroy();
        }
    }

    @Override // com.my.target.is.a
    public void e(String str) {
        InstreamAdPlayer.AdPlayerListener adPlayerListener = this.b;
        if (adPlayerListener != null) {
            adPlayerListener.onAdVideoError(str);
        }
    }

    @Override // com.my.target.instreamads.InstreamAdPlayer
    @Nullable
    public InstreamAdPlayer.AdPlayerListener getAdPlayerListener() {
        return this.b;
    }

    @Override // com.my.target.instreamads.InstreamAdPlayer
    public float getAdVideoDuration() {
        iu iuVar = this.g;
        if (iuVar != null) {
            return iuVar.getDuration();
        }
        return 0.0f;
    }

    @Override // com.my.target.instreamads.InstreamAdPlayer
    public float getAdVideoPosition() {
        iu iuVar = this.g;
        if (iuVar != null) {
            return ((float) iuVar.getPosition()) / 1000.0f;
        }
        return 0.0f;
    }

    @VisibleForTesting
    public int getPlaceholderHeight() {
        return this.d;
    }

    @VisibleForTesting
    public int getPlaceholderWidth() {
        return this.c;
    }

    @Override // com.my.target.instreamads.InstreamAdPlayer
    @NonNull
    public View getView() {
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0046, code lost:
        if (r9 > r1) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0059, code lost:
        if (r9 > r3) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0069, code lost:
        if (r9 > r1) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0078, code lost:
        if (r9 > r3) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x007a, code lost:
        r1 = java.lang.Math.round(((float) r3) * r8);
     */
    @Override // android.widget.FrameLayout, android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            int r0 = android.view.View.MeasureSpec.getMode(r8)
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            int r2 = android.view.View.MeasureSpec.getMode(r9)
            int r3 = android.view.View.MeasureSpec.getSize(r9)
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != 0) goto L_0x0016
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x0016:
            if (r2 != 0) goto L_0x001a
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x001a:
            int r5 = r7.d
            if (r5 == 0) goto L_0x0092
            int r6 = r7.c
            if (r6 != 0) goto L_0x0024
            goto L_0x0092
        L_0x0024:
            float r8 = (float) r6
            float r9 = (float) r5
            float r8 = r8 / r9
            r9 = 0
            if (r3 == 0) goto L_0x002d
            float r9 = (float) r1
            float r5 = (float) r3
            float r9 = r9 / r5
        L_0x002d:
            r5 = 0
            r6 = 1073741824(0x40000000, float:2.0)
            if (r0 != r6) goto L_0x0035
            if (r2 != r6) goto L_0x0035
            goto L_0x0086
        L_0x0035:
            if (r0 != r4) goto L_0x005c
            if (r2 != r4) goto L_0x005c
            int r9 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r9 >= 0) goto L_0x0051
            float r9 = (float) r3
            float r9 = r9 * r8
            int r9 = java.lang.Math.round(r9)
            if (r1 <= 0) goto L_0x004f
            if (r9 <= r1) goto L_0x004f
        L_0x0048:
            float r9 = (float) r1
            float r9 = r9 / r8
            int r3 = java.lang.Math.round(r9)
            goto L_0x0086
        L_0x004f:
            r1 = r9
            goto L_0x0086
        L_0x0051:
            float r9 = (float) r1
            float r9 = r9 / r8
            int r9 = java.lang.Math.round(r9)
            if (r3 <= 0) goto L_0x0082
            if (r9 <= r3) goto L_0x0082
            goto L_0x007a
        L_0x005c:
            if (r0 != r4) goto L_0x006c
            if (r2 != r6) goto L_0x006c
            float r9 = (float) r3
            float r9 = r9 * r8
            int r9 = java.lang.Math.round(r9)
            if (r1 <= 0) goto L_0x004f
            if (r9 <= r1) goto L_0x004f
            goto L_0x0048
        L_0x006c:
            if (r0 != r6) goto L_0x0084
            if (r2 != r4) goto L_0x0084
            float r9 = (float) r1
            float r9 = r9 / r8
            int r9 = java.lang.Math.round(r9)
            if (r3 <= 0) goto L_0x0082
            if (r9 <= r3) goto L_0x0082
        L_0x007a:
            float r9 = (float) r3
            float r9 = r9 * r8
            int r1 = java.lang.Math.round(r9)
            goto L_0x0086
        L_0x0082:
            r3 = r9
            goto L_0x0086
        L_0x0084:
            r1 = 0
            r3 = 0
        L_0x0086:
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r6)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r6)
            super.onMeasure(r8, r9)
            return
        L_0x0092:
            super.onMeasure(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.fl.onMeasure(int, int):void");
    }

    @Override // com.my.target.is.a
    public void onVideoCompleted() {
        InstreamAdPlayer.AdPlayerListener adPlayerListener = this.b;
        if (adPlayerListener != null) {
            adPlayerListener.onAdVideoCompleted();
        }
    }

    @Override // com.my.target.instreamads.InstreamAdPlayer
    public void pauseAdVideo() {
        iu iuVar = this.g;
        if (iuVar != null) {
            iuVar.pause();
        }
    }

    @Override // com.my.target.instreamads.InstreamAdPlayer
    public void playAdVideo(@NonNull Uri uri, int i, int i2) {
        this.c = i;
        this.d = i2;
        this.e = false;
        if (this.g == null) {
            iu ah = iu.ah(getContext());
            this.g = ah;
            ah.a(this);
        }
        this.a.d(i, i2);
        this.g.a(uri, this.a);
    }

    @Override // com.my.target.instreamads.InstreamAdPlayer
    public void playAdVideo(@NonNull Uri uri, int i, int i2, float f2) {
        playAdVideo(uri, i, i2);
        iu iuVar = this.g;
        if (iuVar != null) {
            iuVar.seekTo((long) (f2 * 1000.0f));
        }
    }

    @Override // com.my.target.instreamads.InstreamAdPlayer
    public void resumeAdVideo() {
        iu iuVar = this.g;
        if (iuVar != null) {
            iuVar.resume();
        }
    }

    @Override // com.my.target.instreamads.InstreamAdPlayer
    public void setAdPlayerListener(@Nullable InstreamAdPlayer.AdPlayerListener adPlayerListener) {
        this.b = adPlayerListener;
    }

    @VisibleForTesting
    public void setVideoPlayer(@Nullable iu iuVar) {
        this.g = iuVar;
    }

    @Override // com.my.target.instreamads.InstreamAdPlayer
    public void setVolume(float f2) {
        iu iuVar = this.g;
        if (iuVar != null) {
            iuVar.setVolume(f2);
        }
    }

    @Override // com.my.target.instreamads.InstreamAdPlayer
    public void stopAdVideo() {
        iu iuVar = this.g;
        if (iuVar != null) {
            iuVar.stop();
        }
    }

    @Override // com.my.target.is.a
    public void y() {
        InstreamAdPlayer.AdPlayerListener adPlayerListener = this.b;
        if (adPlayerListener != null) {
            adPlayerListener.onAdVideoStopped();
        }
    }

    @Override // com.my.target.is.a
    public void z() {
        InstreamAdPlayer.AdPlayerListener adPlayerListener;
        if (!this.e && (adPlayerListener = this.b) != null) {
            adPlayerListener.onAdVideoStarted();
            this.e = true;
        }
    }
}
