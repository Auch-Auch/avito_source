package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public final class MetadataRenderer extends BaseRenderer implements Handler.Callback {
    public final MetadataDecoderFactory m;
    public final MetadataOutput n;
    @Nullable
    public final Handler o;
    public final MetadataInputBuffer p;
    public final Metadata[] q;
    public final long[] r;
    public int s;
    public int t;
    @Nullable
    public MetadataDecoder u;
    public boolean v;
    public long w;

    public MetadataRenderer(MetadataOutput metadataOutput, @Nullable Looper looper) {
        this(metadataOutput, looper, MetadataDecoderFactory.DEFAULT);
    }

    public final void a(Metadata metadata, List<Metadata.Entry> list) {
        for (int i = 0; i < metadata.length(); i++) {
            Format wrappedMetadataFormat = metadata.get(i).getWrappedMetadataFormat();
            if (wrappedMetadataFormat == null || !this.m.supportsFormat(wrappedMetadataFormat)) {
                list.add(metadata.get(i));
            } else {
                MetadataDecoder createDecoder = this.m.createDecoder(wrappedMetadataFormat);
                byte[] bArr = (byte[]) Assertions.checkNotNull(metadata.get(i).getWrappedMetadataBytes());
                this.p.clear();
                this.p.ensureSpaceForWrite(bArr.length);
                ((ByteBuffer) Util.castNonNull(this.p.data)).put(bArr);
                this.p.flip();
                Metadata decode = createDecoder.decode(this.p);
                if (decode != null) {
                    a(decode, list);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public String getName() {
        return "MetadataRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            this.n.onMetadata((Metadata) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.v;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        Arrays.fill(this.q, (Object) null);
        this.s = 0;
        this.t = 0;
        this.u = null;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) {
        Arrays.fill(this.q, (Object) null);
        this.s = 0;
        this.t = 0;
        this.v = false;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(Format[] formatArr, long j, long j2) {
        this.u = this.m.createDecoder(formatArr[0]);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) {
        if (!this.v && this.t < 5) {
            this.p.clear();
            FormatHolder formatHolder = getFormatHolder();
            int readSource = readSource(formatHolder, this.p, false);
            if (readSource == -4) {
                if (this.p.isEndOfStream()) {
                    this.v = true;
                } else {
                    MetadataInputBuffer metadataInputBuffer = this.p;
                    metadataInputBuffer.subsampleOffsetUs = this.w;
                    metadataInputBuffer.flip();
                    Metadata decode = ((MetadataDecoder) Util.castNonNull(this.u)).decode(this.p);
                    if (decode != null) {
                        ArrayList arrayList = new ArrayList(decode.length());
                        a(decode, arrayList);
                        if (!arrayList.isEmpty()) {
                            Metadata metadata = new Metadata(arrayList);
                            int i = this.s;
                            int i2 = this.t;
                            int i3 = (i + i2) % 5;
                            this.q[i3] = metadata;
                            this.r[i3] = this.p.timeUs;
                            this.t = i2 + 1;
                        }
                    }
                }
            } else if (readSource == -5) {
                this.w = ((Format) Assertions.checkNotNull(formatHolder.format)).subsampleOffsetUs;
            }
        }
        if (this.t > 0) {
            long[] jArr = this.r;
            int i4 = this.s;
            if (jArr[i4] <= j) {
                Metadata metadata2 = (Metadata) Util.castNonNull(this.q[i4]);
                Handler handler = this.o;
                if (handler != null) {
                    handler.obtainMessage(0, metadata2).sendToTarget();
                } else {
                    this.n.onMetadata(metadata2);
                }
                Metadata[] metadataArr = this.q;
                int i5 = this.s;
                metadataArr[i5] = null;
                this.s = (i5 + 1) % 5;
                this.t--;
            }
        }
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int supportsFormat(Format format) {
        if (!this.m.supportsFormat(format)) {
            return 0;
        }
        return (format.exoMediaCryptoType == null ? 4 : 2) | 0 | 0;
    }

    public MetadataRenderer(MetadataOutput metadataOutput, @Nullable Looper looper, MetadataDecoderFactory metadataDecoderFactory) {
        super(4);
        Handler handler;
        this.n = (MetadataOutput) Assertions.checkNotNull(metadataOutput);
        if (looper == null) {
            handler = null;
        } else {
            handler = Util.createHandler(looper, this);
        }
        this.o = handler;
        this.m = (MetadataDecoderFactory) Assertions.checkNotNull(metadataDecoderFactory);
        this.p = new MetadataInputBuffer();
        this.q = new Metadata[5];
        this.r = new long[5];
    }
}
