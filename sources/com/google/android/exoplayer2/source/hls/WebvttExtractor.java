package com.google.android.exoplayer2.source.hls;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.text.webvtt.WebvttParserUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
public final class WebvttExtractor implements Extractor {
    public static final Pattern g = Pattern.compile("LOCAL:([^,]+)");
    public static final Pattern h = Pattern.compile("MPEGTS:(-?\\d+)");
    @Nullable
    public final String a;
    public final TimestampAdjuster b;
    public final ParsableByteArray c = new ParsableByteArray();
    public ExtractorOutput d;
    public byte[] e = new byte[1024];
    public int f;

    public WebvttExtractor(@Nullable String str, TimestampAdjuster timestampAdjuster) {
        this.a = str;
        this.b = timestampAdjuster;
    }

    @RequiresNonNull({"output"})
    public final TrackOutput a(long j) {
        TrackOutput track = this.d.track(0, 3);
        track.format(Format.createTextSampleFormat(null, MimeTypes.TEXT_VTT, null, -1, 0, this.a, null, j));
        this.d.endTracks();
        return track;
    }

    @RequiresNonNull({"output"})
    public final void b() throws ParserException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(this.e);
        WebvttParserUtil.validateWebvttHeaderLine(parsableByteArray);
        long j = 0;
        long j2 = 0;
        for (String readLine = parsableByteArray.readLine(); !TextUtils.isEmpty(readLine); readLine = parsableByteArray.readLine()) {
            if (readLine.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher = g.matcher(readLine);
                if (!matcher.find()) {
                    throw new ParserException(readLine.length() != 0 ? "X-TIMESTAMP-MAP doesn't contain local timestamp: ".concat(readLine) : new String("X-TIMESTAMP-MAP doesn't contain local timestamp: "));
                }
                Matcher matcher2 = h.matcher(readLine);
                if (!matcher2.find()) {
                    throw new ParserException(readLine.length() != 0 ? "X-TIMESTAMP-MAP doesn't contain media timestamp: ".concat(readLine) : new String("X-TIMESTAMP-MAP doesn't contain media timestamp: "));
                }
                j2 = WebvttParserUtil.parseTimestampUs(matcher.group(1));
                j = TimestampAdjuster.ptsToUs(Long.parseLong(matcher2.group(1)));
            }
        }
        Matcher findNextCueHeader = WebvttParserUtil.findNextCueHeader(parsableByteArray);
        if (findNextCueHeader == null) {
            a(0);
            return;
        }
        long parseTimestampUs = WebvttParserUtil.parseTimestampUs(findNextCueHeader.group(1));
        long adjustTsTimestamp = this.b.adjustTsTimestamp(TimestampAdjuster.usToPts((j + parseTimestampUs) - j2));
        TrackOutput a3 = a(adjustTsTimestamp - parseTimestampUs);
        this.c.reset(this.e, this.f);
        a3.sampleData(this.c, this.f);
        a3.sampleMetadata(adjustTsTimestamp, 1, this.f, 0, null);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.d = extractorOutput;
        extractorOutput.seekMap(new SeekMap.Unseekable(C.TIME_UNSET));
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        int i;
        Assertions.checkNotNull(this.d);
        int length = (int) extractorInput.getLength();
        int i2 = this.f;
        byte[] bArr = this.e;
        if (i2 == bArr.length) {
            if (length != -1) {
                i = length;
            } else {
                i = bArr.length;
            }
            this.e = Arrays.copyOf(bArr, (i * 3) / 2);
        }
        byte[] bArr2 = this.e;
        int i3 = this.f;
        int read = extractorInput.read(bArr2, i3, bArr2.length - i3);
        if (read != -1) {
            int i4 = this.f + read;
            this.f = i4;
            if (length == -1 || i4 != length) {
                return 0;
            }
        }
        b();
        return -1;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        extractorInput.peekFully(this.e, 0, 6, false);
        this.c.reset(this.e, 6);
        if (WebvttParserUtil.isWebvttHeaderLine(this.c)) {
            return true;
        }
        extractorInput.peekFully(this.e, 6, 3, false);
        this.c.reset(this.e, 9);
        return WebvttParserUtil.isWebvttHeaderLine(this.c);
    }
}
