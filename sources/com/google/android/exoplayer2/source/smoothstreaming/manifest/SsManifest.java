package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
public class SsManifest implements FilterableManifest<SsManifest> {
    public static final int UNSET_LOOKAHEAD = -1;
    public final long durationUs;
    public final long dvrWindowLengthUs;
    public final boolean isLive;
    public final int lookAheadCount;
    public final int majorVersion;
    public final int minorVersion;
    @Nullable
    public final ProtectionElement protectionElement;
    public final StreamElement[] streamElements;

    public static class ProtectionElement {
        public final byte[] data;
        public final TrackEncryptionBox[] trackEncryptionBoxes;
        public final UUID uuid;

        public ProtectionElement(UUID uuid2, byte[] bArr, TrackEncryptionBox[] trackEncryptionBoxArr) {
            this.uuid = uuid2;
            this.data = bArr;
            this.trackEncryptionBoxes = trackEncryptionBoxArr;
        }
    }

    public SsManifest(int i, int i2, long j, long j2, long j3, int i3, boolean z, @Nullable ProtectionElement protectionElement2, StreamElement[] streamElementArr) {
        long j4 = C.TIME_UNSET;
        long scaleLargeTimestamp = j2 == 0 ? -9223372036854775807L : Util.scaleLargeTimestamp(j2, 1000000, j);
        j4 = j3 != 0 ? Util.scaleLargeTimestamp(j3, 1000000, j) : j4;
        this.majorVersion = i;
        this.minorVersion = i2;
        this.durationUs = scaleLargeTimestamp;
        this.dvrWindowLengthUs = j4;
        this.lookAheadCount = i3;
        this.isLive = z;
        this.protectionElement = protectionElement2;
        this.streamElements = streamElementArr;
    }

    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    public final SsManifest copy(List<StreamKey> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        StreamElement streamElement = null;
        int i = 0;
        while (i < arrayList.size()) {
            StreamKey streamKey = (StreamKey) arrayList.get(i);
            StreamElement streamElement2 = this.streamElements[streamKey.groupIndex];
            if (!(streamElement2 == streamElement || streamElement == null)) {
                arrayList2.add(streamElement.copy((Format[]) arrayList3.toArray(new Format[0])));
                arrayList3.clear();
            }
            arrayList3.add(streamElement2.formats[streamKey.trackIndex]);
            i++;
            streamElement = streamElement2;
        }
        if (streamElement != null) {
            arrayList2.add(streamElement.copy((Format[]) arrayList3.toArray(new Format[0])));
        }
        return new SsManifest(this.majorVersion, this.minorVersion, this.durationUs, this.dvrWindowLengthUs, this.lookAheadCount, this.isLive, this.protectionElement, (StreamElement[]) arrayList2.toArray(new StreamElement[0]));
    }

    public static class StreamElement {
        public final String a;
        public final String b;
        public final List<Long> c;
        public final int chunkCount;
        public final long[] d;
        public final int displayHeight;
        public final int displayWidth;
        public final long e;
        public final Format[] formats;
        @Nullable
        public final String language;
        public final int maxHeight;
        public final int maxWidth;
        public final String name;
        public final String subType;
        public final long timescale;
        public final int type;

        public StreamElement(String str, String str2, int i, String str3, long j, String str4, int i2, int i3, int i4, int i5, @Nullable String str5, Format[] formatArr, List<Long> list, long j2) {
            this(str, str2, i, str3, j, str4, i2, i3, i4, i5, str5, formatArr, list, Util.scaleLargeTimestamps(list, 1000000, j), Util.scaleLargeTimestamp(j2, 1000000, j));
        }

        public Uri buildRequestUri(int i, int i2) {
            boolean z = true;
            Assertions.checkState(this.formats != null);
            Assertions.checkState(this.c != null);
            if (i2 >= this.c.size()) {
                z = false;
            }
            Assertions.checkState(z);
            String num = Integer.toString(this.formats[i].bitrate);
            String l = this.c.get(i2).toString();
            return UriUtil.resolveToUri(this.a, this.b.replace("{bitrate}", num).replace("{Bitrate}", num).replace("{start time}", l).replace("{start_time}", l));
        }

        public StreamElement copy(Format[] formatArr) {
            return new StreamElement(this.a, this.b, this.type, this.subType, this.timescale, this.name, this.maxWidth, this.maxHeight, this.displayWidth, this.displayHeight, this.language, formatArr, this.c, this.d, this.e);
        }

        public long getChunkDurationUs(int i) {
            if (i == this.chunkCount - 1) {
                return this.e;
            }
            long[] jArr = this.d;
            return jArr[i + 1] - jArr[i];
        }

        public int getChunkIndex(long j) {
            return Util.binarySearchFloor(this.d, j, true, true);
        }

        public long getStartTimeUs(int i) {
            return this.d[i];
        }

        public StreamElement(String str, String str2, int i, String str3, long j, String str4, int i2, int i3, int i4, int i5, @Nullable String str5, Format[] formatArr, List<Long> list, long[] jArr, long j2) {
            this.a = str;
            this.b = str2;
            this.type = i;
            this.subType = str3;
            this.timescale = j;
            this.name = str4;
            this.maxWidth = i2;
            this.maxHeight = i3;
            this.displayWidth = i4;
            this.displayHeight = i5;
            this.language = str5;
            this.formats = formatArr;
            this.c = list;
            this.d = jArr;
            this.e = j2;
            this.chunkCount = list.size();
        }
    }

    public SsManifest(int i, int i2, long j, long j2, int i3, boolean z, @Nullable ProtectionElement protectionElement2, StreamElement[] streamElementArr) {
        this.majorVersion = i;
        this.minorVersion = i2;
        this.durationUs = j;
        this.dvrWindowLengthUs = j2;
        this.lookAheadCount = i3;
        this.isLive = z;
        this.protectionElement = protectionElement2;
        this.streamElements = streamElementArr;
    }
}
