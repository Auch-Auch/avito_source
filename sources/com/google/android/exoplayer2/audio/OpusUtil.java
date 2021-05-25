package com.google.android.exoplayer2.audio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
public class OpusUtil {
    public static final int SAMPLE_RATE = 48000;

    public static byte[] a(long j) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j).array();
    }

    public static List<byte[]> buildInitializationData(byte[] bArr) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(a((((long) (((bArr[11] & 255) << 8) | (bArr[10] & 255))) * 1000000000) / 48000));
        arrayList.add(a(80000000));
        return arrayList;
    }

    public static int getChannelCount(byte[] bArr) {
        return bArr[9] & 255;
    }

    public static int getPreSkipSamples(List<byte[]> list) {
        if (list.size() == 3) {
            return (int) ((ByteBuffer.wrap(list.get(1)).order(ByteOrder.nativeOrder()).getLong() * 48000) / 1000000000);
        }
        byte[] bArr = list.get(0);
        return (bArr[10] & 255) | ((bArr[11] & 255) << 8);
    }

    public static int getSeekPreRollSamples(List<byte[]> list) {
        if (list.size() == 3) {
            return (int) ((ByteBuffer.wrap(list.get(2)).order(ByteOrder.nativeOrder()).getLong() * 48000) / 1000000000);
        }
        return 3840;
    }
}
