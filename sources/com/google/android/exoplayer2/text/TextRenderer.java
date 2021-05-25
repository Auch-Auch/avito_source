package com.google.android.exoplayer2.text;

import a2.b.a.a.a;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;
public final class TextRenderer extends BaseRenderer implements Handler.Callback {
    @Nullable
    public final Handler m;
    public final TextOutput n;
    public final SubtitleDecoderFactory o;
    public final FormatHolder p;
    public boolean q;
    public boolean r;
    public boolean s;
    public int t;
    @Nullable
    public Format u;
    @Nullable
    public SubtitleDecoder v;
    @Nullable
    public SubtitleInputBuffer w;
    @Nullable
    public SubtitleOutputBuffer x;
    @Nullable
    public SubtitleOutputBuffer y;
    public int z;

    public TextRenderer(TextOutput textOutput, @Nullable Looper looper) {
        this(textOutput, looper, SubtitleDecoderFactory.DEFAULT);
    }

    public final void a() {
        List<Cue> emptyList = Collections.emptyList();
        Handler handler = this.m;
        if (handler != null) {
            handler.obtainMessage(0, emptyList).sendToTarget();
        } else {
            this.n.onCues(emptyList);
        }
    }

    public final long b() {
        if (this.z == -1) {
            return Long.MAX_VALUE;
        }
        Assertions.checkNotNull(this.x);
        if (this.z >= this.x.getEventTimeCount()) {
            return Long.MAX_VALUE;
        }
        return this.x.getEventTime(this.z);
    }

    public final void c(SubtitleDecoderException subtitleDecoderException) {
        StringBuilder L = a.L("Subtitle decoding failed. streamFormat=");
        L.append(this.u);
        Log.e("TextRenderer", L.toString(), subtitleDecoderException);
        a();
        releaseDecoder();
        d();
    }

    public final void d() {
        this.s = true;
        this.v = this.o.createDecoder((Format) Assertions.checkNotNull(this.u));
    }

    public final void e() {
        this.w = null;
        this.z = -1;
        SubtitleOutputBuffer subtitleOutputBuffer = this.x;
        if (subtitleOutputBuffer != null) {
            subtitleOutputBuffer.release();
            this.x = null;
        }
        SubtitleOutputBuffer subtitleOutputBuffer2 = this.y;
        if (subtitleOutputBuffer2 != null) {
            subtitleOutputBuffer2.release();
            this.y = null;
        }
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public String getName() {
        return "TextRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            this.n.onCues((List) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.r;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.u = null;
        a();
        releaseDecoder();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z2) {
        a();
        this.q = false;
        this.r = false;
        if (this.t != 0) {
            releaseDecoder();
            d();
            return;
        }
        e();
        ((SubtitleDecoder) Assertions.checkNotNull(this.v)).flush();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(Format[] formatArr, long j, long j2) {
        this.u = formatArr[0];
        if (this.v != null) {
            this.t = 1;
        } else {
            d();
        }
    }

    public final void releaseDecoder() {
        e();
        ((SubtitleDecoder) Assertions.checkNotNull(this.v)).release();
        this.v = null;
        this.t = 0;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) {
        boolean z2;
        if (!this.r) {
            if (this.y == null) {
                ((SubtitleDecoder) Assertions.checkNotNull(this.v)).setPositionUs(j);
                try {
                    this.y = (SubtitleOutputBuffer) ((SubtitleDecoder) Assertions.checkNotNull(this.v)).dequeueOutputBuffer();
                } catch (SubtitleDecoderException e) {
                    c(e);
                    return;
                }
            }
            if (getState() == 2) {
                if (this.x != null) {
                    long b = b();
                    z2 = false;
                    while (b <= j) {
                        this.z++;
                        b = b();
                        z2 = true;
                    }
                } else {
                    z2 = false;
                }
                SubtitleOutputBuffer subtitleOutputBuffer = this.y;
                if (subtitleOutputBuffer != null) {
                    if (subtitleOutputBuffer.isEndOfStream()) {
                        if (!z2 && b() == Long.MAX_VALUE) {
                            if (this.t == 2) {
                                releaseDecoder();
                                d();
                            } else {
                                e();
                                this.r = true;
                            }
                        }
                    } else if (subtitleOutputBuffer.timeUs <= j) {
                        SubtitleOutputBuffer subtitleOutputBuffer2 = this.x;
                        if (subtitleOutputBuffer2 != null) {
                            subtitleOutputBuffer2.release();
                        }
                        this.z = subtitleOutputBuffer.getNextEventTimeIndex(j);
                        this.x = subtitleOutputBuffer;
                        this.y = null;
                        z2 = true;
                    }
                }
                if (z2) {
                    Assertions.checkNotNull(this.x);
                    List<Cue> cues = this.x.getCues(j);
                    Handler handler = this.m;
                    if (handler != null) {
                        handler.obtainMessage(0, cues).sendToTarget();
                    } else {
                        this.n.onCues(cues);
                    }
                }
                if (this.t != 2) {
                    while (!this.q) {
                        try {
                            SubtitleInputBuffer subtitleInputBuffer = this.w;
                            if (subtitleInputBuffer == null) {
                                subtitleInputBuffer = (SubtitleInputBuffer) ((SubtitleDecoder) Assertions.checkNotNull(this.v)).dequeueInputBuffer();
                                if (subtitleInputBuffer != null) {
                                    this.w = subtitleInputBuffer;
                                } else {
                                    return;
                                }
                            }
                            if (this.t == 1) {
                                subtitleInputBuffer.setFlags(4);
                                ((SubtitleDecoder) Assertions.checkNotNull(this.v)).queueInputBuffer(subtitleInputBuffer);
                                this.w = null;
                                this.t = 2;
                                return;
                            }
                            int readSource = readSource(this.p, subtitleInputBuffer, false);
                            if (readSource == -4) {
                                if (subtitleInputBuffer.isEndOfStream()) {
                                    this.q = true;
                                    this.s = false;
                                } else {
                                    Format format = this.p.format;
                                    if (format != null) {
                                        subtitleInputBuffer.subsampleOffsetUs = format.subsampleOffsetUs;
                                        subtitleInputBuffer.flip();
                                        this.s &= !subtitleInputBuffer.isKeyFrame();
                                    } else {
                                        return;
                                    }
                                }
                                if (!this.s) {
                                    ((SubtitleDecoder) Assertions.checkNotNull(this.v)).queueInputBuffer(subtitleInputBuffer);
                                    this.w = null;
                                }
                            } else if (readSource == -3) {
                                return;
                            }
                        } catch (SubtitleDecoderException e2) {
                            c(e2);
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsFormat(Format format) {
        if (this.o.supportsFormat(format)) {
            return (format.exoMediaCryptoType == null ? 4 : 2) | 0 | 0;
        } else if (MimeTypes.isText(format.sampleMimeType)) {
            return 1;
        } else {
            return 0;
        }
    }

    public TextRenderer(TextOutput textOutput, @Nullable Looper looper, SubtitleDecoderFactory subtitleDecoderFactory) {
        super(3);
        Handler handler;
        this.n = (TextOutput) Assertions.checkNotNull(textOutput);
        if (looper == null) {
            handler = null;
        } else {
            handler = Util.createHandler(looper, this);
        }
        this.m = handler;
        this.o = subtitleDecoderFactory;
        this.p = new FormatHolder();
    }
}
