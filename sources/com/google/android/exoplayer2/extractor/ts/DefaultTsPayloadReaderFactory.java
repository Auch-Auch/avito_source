package com.google.android.exoplayer2.extractor.ts;

import a2.j.b.b.u0.l.k;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.SignedBytes;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
public final class DefaultTsPayloadReaderFactory implements TsPayloadReader.Factory {
    public static final int FLAG_ALLOW_NON_IDR_KEYFRAMES = 1;
    public static final int FLAG_DETECT_ACCESS_UNITS = 8;
    public static final int FLAG_ENABLE_HDMV_DTS_AUDIO_STREAMS = 64;
    public static final int FLAG_IGNORE_AAC_STREAM = 2;
    public static final int FLAG_IGNORE_H264_STREAM = 4;
    public static final int FLAG_IGNORE_SPLICE_INFO_STREAM = 16;
    public static final int FLAG_OVERRIDE_CAPTION_DESCRIPTORS = 32;
    public final int a;
    public final List<Format> b;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public DefaultTsPayloadReaderFactory() {
        this(0);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x0089 */
    /* JADX DEBUG: Multi-variable search result rejected for r13v3, resolved type: java.util.ArrayList */
    /* JADX DEBUG: Multi-variable search result rejected for r13v5, resolved type: java.util.ArrayList */
    /* JADX DEBUG: Multi-variable search result rejected for r13v7, resolved type: java.util.ArrayList */
    /* JADX DEBUG: Multi-variable search result rejected for r13v8, resolved type: java.util.ArrayList */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v4 */
    public final List<Format> a(TsPayloadReader.EsInfo esInfo) {
        String str;
        int i;
        if (b(32)) {
            return this.b;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(esInfo.descriptorBytes);
        ArrayList arrayList = this.b;
        while (parsableByteArray.bytesLeft() > 0) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            int position = parsableByteArray.getPosition() + parsableByteArray.readUnsignedByte();
            if (readUnsignedByte == 134) {
                arrayList = new ArrayList();
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte() & 31;
                for (int i2 = 0; i2 < readUnsignedByte2; i2++) {
                    String readString = parsableByteArray.readString(3);
                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    boolean z = true;
                    boolean z2 = (readUnsignedByte3 & 128) != 0;
                    if (z2) {
                        i = readUnsignedByte3 & 63;
                        str = MimeTypes.APPLICATION_CEA708;
                    } else {
                        str = MimeTypes.APPLICATION_CEA608;
                        i = 1;
                    }
                    byte readUnsignedByte4 = (byte) parsableByteArray.readUnsignedByte();
                    parsableByteArray.skipBytes(1);
                    List<byte[]> list = null;
                    if (z2) {
                        if ((readUnsignedByte4 & SignedBytes.MAX_POWER_OF_TWO) == 0) {
                            z = false;
                        }
                        list = CodecSpecificDataUtil.buildCea708InitializationData(z);
                    }
                    arrayList.add(new Format.Builder().setSampleMimeType(str).setLanguage(readString).setAccessibilityChannel(i).setInitializationData(list).build());
                }
            }
            parsableByteArray.setPosition(position);
            arrayList = arrayList;
        }
        return arrayList;
    }

    public final boolean b(int i) {
        return (i & this.a) != 0;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory
    public SparseArray<TsPayloadReader> createInitialPayloadReaders() {
        return new SparseArray<>();
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory
    @Nullable
    public TsPayloadReader createPayloadReader(int i, TsPayloadReader.EsInfo esInfo) {
        if (i == 2) {
            return new PesReader(new H262Reader(new k(a(esInfo))));
        }
        if (i == 3 || i == 4) {
            return new PesReader(new MpegAudioReader(esInfo.language));
        }
        if (i == 21) {
            return new PesReader(new Id3Reader());
        }
        if (i != 27) {
            if (i == 36) {
                return new PesReader(new H265Reader(new SeiReader(a(esInfo))));
            }
            if (i == 89) {
                return new PesReader(new DvbSubtitleReader(esInfo.dvbSubtitleInfos));
            }
            if (i != 138) {
                if (i == 172) {
                    return new PesReader(new Ac4Reader(esInfo.language));
                }
                if (i == 257) {
                    return new SectionReader(new PassthroughSectionPayloadReader(MimeTypes.APPLICATION_AIT));
                }
                if (i != 129) {
                    if (i != 130) {
                        if (i != 134) {
                            if (i != 135) {
                                switch (i) {
                                    case 15:
                                        if (b(2)) {
                                            return null;
                                        }
                                        return new PesReader(new AdtsReader(false, esInfo.language));
                                    case 16:
                                        return new PesReader(new H263Reader(new k(a(esInfo))));
                                    case 17:
                                        if (b(2)) {
                                            return null;
                                        }
                                        return new PesReader(new LatmReader(esInfo.language));
                                    default:
                                        return null;
                                }
                            }
                        } else if (b(16)) {
                            return null;
                        } else {
                            return new SectionReader(new PassthroughSectionPayloadReader(MimeTypes.APPLICATION_SCTE35));
                        }
                    } else if (!b(64)) {
                        return null;
                    }
                }
                return new PesReader(new Ac3Reader(esInfo.language));
            }
            return new PesReader(new DtsReader(esInfo.language));
        } else if (b(4)) {
            return null;
        } else {
            return new PesReader(new H264Reader(new SeiReader(a(esInfo)), b(1), b(8)));
        }
    }

    public DefaultTsPayloadReaderFactory(int i) {
        this(i, ImmutableList.of());
    }

    public DefaultTsPayloadReaderFactory(int i, List<Format> list) {
        this.a = i;
        this.b = list;
    }
}
