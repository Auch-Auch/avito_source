package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.metadata.SimpleMetadataDecoder;
import com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public final class SpliceInfoDecoder extends SimpleMetadataDecoder {
    public final ParsableByteArray a = new ParsableByteArray();
    public final ParsableBitArray b = new ParsableBitArray();
    public TimestampAdjuster c;

    @Override // com.google.android.exoplayer2.metadata.SimpleMetadataDecoder
    public Metadata decode(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        int i;
        int i2;
        int i3;
        long j;
        boolean z;
        long j2;
        ArrayList arrayList;
        boolean z2;
        boolean z3;
        long j3;
        long j4;
        boolean z4;
        boolean z5;
        boolean z7;
        long j5;
        int i4;
        int i5;
        int i6;
        long j6;
        boolean z8;
        List list;
        boolean z9;
        boolean z10;
        boolean z11;
        long j7;
        boolean z12;
        TimestampAdjuster timestampAdjuster = this.c;
        if (timestampAdjuster == null || metadataInputBuffer.subsampleOffsetUs != timestampAdjuster.getTimestampOffsetUs()) {
            TimestampAdjuster timestampAdjuster2 = new TimestampAdjuster(metadataInputBuffer.timeUs);
            this.c = timestampAdjuster2;
            timestampAdjuster2.adjustSampleTimestamp(metadataInputBuffer.timeUs - metadataInputBuffer.subsampleOffsetUs);
        }
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.a.reset(array, limit);
        this.b.reset(array, limit);
        this.b.skipBits(39);
        long readBits = (((long) this.b.readBits(1)) << 32) | ((long) this.b.readBits(32));
        this.b.skipBits(20);
        int readBits2 = this.b.readBits(12);
        int readBits3 = this.b.readBits(8);
        this.a.skipBytes(14);
        Metadata.Entry entry = null;
        if (readBits3 == 0) {
            entry = new SpliceNullCommand();
        } else if (readBits3 != 255) {
            long j8 = 1;
            long j9 = 0;
            long j10 = C.TIME_UNSET;
            if (readBits3 == 4) {
                ParsableByteArray parsableByteArray = this.a;
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                ArrayList arrayList2 = new ArrayList(readUnsignedByte);
                int i7 = 0;
                while (i7 < readUnsignedByte) {
                    long readUnsignedInt = parsableByteArray.readUnsignedInt();
                    boolean z13 = (parsableByteArray.readUnsignedByte() & 128) != 0;
                    ArrayList arrayList3 = new ArrayList();
                    if (!z13) {
                        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                        boolean z14 = (readUnsignedByte2 & 128) != 0;
                        boolean z15 = (readUnsignedByte2 & 64) != 0;
                        boolean z16 = (readUnsignedByte2 & 32) != 0;
                        long readUnsignedInt2 = z15 ? parsableByteArray.readUnsignedInt() : -9223372036854775807L;
                        if (!z15) {
                            int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                            ArrayList arrayList4 = new ArrayList(readUnsignedByte3);
                            int i8 = 0;
                            while (i8 < readUnsignedByte3) {
                                arrayList4.add(new SpliceScheduleCommand.ComponentSplice(parsableByteArray.readUnsignedByte(), parsableByteArray.readUnsignedInt(), null));
                                i8++;
                                z14 = z14;
                                z15 = z15;
                            }
                            z5 = z14;
                            z4 = z15;
                            arrayList3 = arrayList4;
                        } else {
                            z5 = z14;
                            z4 = z15;
                        }
                        if (z16) {
                            long readUnsignedByte4 = (long) parsableByteArray.readUnsignedByte();
                            j3 = 0;
                            z7 = (readUnsignedByte4 & 128) != 0;
                            j4 = 1;
                            j5 = ((((readUnsignedByte4 & 1) << 32) | parsableByteArray.readUnsignedInt()) * 1000) / 90;
                        } else {
                            j4 = 1;
                            j3 = 0;
                            j5 = -9223372036854775807L;
                            z7 = false;
                        }
                        arrayList = arrayList3;
                        j = j5;
                        z = z7;
                        j2 = readUnsignedInt2;
                        z3 = z5;
                        z2 = z4;
                        i3 = parsableByteArray.readUnsignedShort();
                        i2 = parsableByteArray.readUnsignedByte();
                        i = parsableByteArray.readUnsignedByte();
                    } else {
                        j4 = j8;
                        j3 = j9;
                        arrayList = arrayList3;
                        j2 = -9223372036854775807L;
                        j = -9223372036854775807L;
                        z3 = false;
                        z2 = false;
                        z = false;
                        i3 = 0;
                        i2 = 0;
                        i = 0;
                    }
                    arrayList2.add(new SpliceScheduleCommand.Event(readUnsignedInt, z13, z3, z2, arrayList, j2, z, j, i3, i2, i));
                    i7++;
                    j9 = j3;
                    j8 = j4;
                }
                entry = new SpliceScheduleCommand(arrayList2);
            } else if (readBits3 == 5) {
                ParsableByteArray parsableByteArray2 = this.a;
                TimestampAdjuster timestampAdjuster3 = this.c;
                long readUnsignedInt3 = parsableByteArray2.readUnsignedInt();
                boolean z17 = (parsableByteArray2.readUnsignedByte() & 128) != 0;
                List emptyList = Collections.emptyList();
                if (!z17) {
                    int readUnsignedByte5 = parsableByteArray2.readUnsignedByte();
                    boolean z18 = (readUnsignedByte5 & 128) != 0;
                    boolean z19 = (readUnsignedByte5 & 64) != 0;
                    boolean z20 = (readUnsignedByte5 & 32) != 0;
                    boolean z21 = (readUnsignedByte5 & 16) != 0;
                    long a3 = (!z19 || z21) ? -9223372036854775807L : TimeSignalCommand.a(parsableByteArray2, readBits);
                    if (!z19) {
                        int readUnsignedByte6 = parsableByteArray2.readUnsignedByte();
                        ArrayList arrayList5 = new ArrayList(readUnsignedByte6);
                        for (int i9 = 0; i9 < readUnsignedByte6; i9++) {
                            int readUnsignedByte7 = parsableByteArray2.readUnsignedByte();
                            long a4 = !z21 ? TimeSignalCommand.a(parsableByteArray2, readBits) : -9223372036854775807L;
                            arrayList5.add(new SpliceInsertCommand.ComponentSplice(readUnsignedByte7, a4, timestampAdjuster3.adjustTsTimestamp(a4), null));
                        }
                        emptyList = arrayList5;
                    }
                    if (z20) {
                        long readUnsignedByte8 = (long) parsableByteArray2.readUnsignedByte();
                        z12 = (readUnsignedByte8 & 128) != 0;
                        j10 = ((((readUnsignedByte8 & 1) << 32) | parsableByteArray2.readUnsignedInt()) * 1000) / 90;
                    } else {
                        z12 = false;
                    }
                    int readUnsignedShort = parsableByteArray2.readUnsignedShort();
                    int readUnsignedByte9 = parsableByteArray2.readUnsignedByte();
                    z8 = z12;
                    i4 = parsableByteArray2.readUnsignedByte();
                    list = emptyList;
                    z11 = z18;
                    i6 = readUnsignedShort;
                    i5 = readUnsignedByte9;
                    j6 = j10;
                    z9 = z21;
                    z10 = z19;
                    j7 = a3;
                } else {
                    list = emptyList;
                    j7 = -9223372036854775807L;
                    j6 = -9223372036854775807L;
                    z11 = false;
                    z10 = false;
                    z9 = false;
                    z8 = false;
                    i6 = 0;
                    i5 = 0;
                    i4 = 0;
                }
                entry = new SpliceInsertCommand(readUnsignedInt3, z17, z11, z10, z9, j7, timestampAdjuster3.adjustTsTimestamp(j7), list, z8, j6, i6, i5, i4);
            } else if (readBits3 == 6) {
                ParsableByteArray parsableByteArray3 = this.a;
                TimestampAdjuster timestampAdjuster4 = this.c;
                long a5 = TimeSignalCommand.a(parsableByteArray3, readBits);
                entry = new TimeSignalCommand(a5, timestampAdjuster4.adjustTsTimestamp(a5));
            }
        } else {
            ParsableByteArray parsableByteArray4 = this.a;
            long readUnsignedInt4 = parsableByteArray4.readUnsignedInt();
            int i10 = readBits2 - 4;
            byte[] bArr = new byte[i10];
            parsableByteArray4.readBytes(bArr, 0, i10);
            entry = new PrivateCommand(readUnsignedInt4, bArr, readBits);
        }
        return entry == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(entry);
    }
}
