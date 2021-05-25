package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.ts.Ac4Extractor;
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.ts.DefaultTsPayloadReaderFactory;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.hls.HlsExtractorFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.io.EOFException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
public final class DefaultHlsExtractorFactory implements HlsExtractorFactory {
    public static final String AAC_FILE_EXTENSION = ".aac";
    public static final String AC3_FILE_EXTENSION = ".ac3";
    public static final String AC4_FILE_EXTENSION = ".ac4";
    public static final String CMF_FILE_EXTENSION_PREFIX = ".cmf";
    public static final String EC3_FILE_EXTENSION = ".ec3";
    public static final String M4_FILE_EXTENSION_PREFIX = ".m4";
    public static final String MP3_FILE_EXTENSION = ".mp3";
    public static final String MP4_FILE_EXTENSION = ".mp4";
    public static final String MP4_FILE_EXTENSION_PREFIX = ".mp4";
    public static final String VTT_FILE_EXTENSION = ".vtt";
    public static final String WEBVTT_FILE_EXTENSION = ".webvtt";
    public final int a;
    public final boolean b;

    public DefaultHlsExtractorFactory() {
        this(0, true);
    }

    public static HlsExtractorFactory.Result a(Extractor extractor) {
        boolean z = true;
        boolean z2 = (extractor instanceof AdtsExtractor) || (extractor instanceof Ac3Extractor) || (extractor instanceof Ac4Extractor) || (extractor instanceof Mp3Extractor);
        if (!(extractor instanceof TsExtractor) && !(extractor instanceof FragmentedMp4Extractor)) {
            z = false;
        }
        return new HlsExtractorFactory.Result(extractor, z2, z);
    }

    public static FragmentedMp4Extractor b(TimestampAdjuster timestampAdjuster, Format format, @Nullable List<Format> list) {
        boolean z;
        Metadata metadata = format.metadata;
        int i = 0;
        if (metadata != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= metadata.length()) {
                    break;
                }
                Metadata.Entry entry = metadata.get(i2);
                if (entry instanceof HlsTrackMetadataEntry) {
                    z = !((HlsTrackMetadataEntry) entry).variantInfos.isEmpty();
                    break;
                }
                i2++;
            }
        }
        z = false;
        if (z) {
            i = 4;
        }
        if (list == null) {
            list = Collections.emptyList();
        }
        return new FragmentedMp4Extractor(i, timestampAdjuster, null, list);
    }

    public static TsExtractor c(int i, boolean z, Format format, @Nullable List<Format> list, TimestampAdjuster timestampAdjuster) {
        int i2 = i | 16;
        if (list != null) {
            i2 |= 32;
        } else if (z) {
            list = Collections.singletonList(Format.createTextSampleFormat(null, MimeTypes.APPLICATION_CEA608, 0, null));
        } else {
            list = Collections.emptyList();
        }
        String str = format.codecs;
        if (!TextUtils.isEmpty(str)) {
            if (!MimeTypes.AUDIO_AAC.equals(MimeTypes.getAudioMediaMimeType(str))) {
                i2 |= 2;
            }
            if (!MimeTypes.VIDEO_H264.equals(MimeTypes.getVideoMediaMimeType(str))) {
                i2 |= 4;
            }
        }
        return new TsExtractor(2, timestampAdjuster, new DefaultTsPayloadReaderFactory(i2, list));
    }

    /* JADX INFO: finally extract failed */
    public static boolean d(Extractor extractor, ExtractorInput extractorInput) throws InterruptedException, IOException {
        try {
            boolean sniff = extractor.sniff(extractorInput);
            extractorInput.resetPeekPosition();
            return sniff;
        } catch (EOFException unused) {
            extractorInput.resetPeekPosition();
            return false;
        } catch (Throwable th) {
            extractorInput.resetPeekPosition();
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsExtractorFactory
    public HlsExtractorFactory.Result createExtractor(@Nullable Extractor extractor, Uri uri, Format format, @Nullable List<Format> list, TimestampAdjuster timestampAdjuster, Map<String, List<String>> map, ExtractorInput extractorInput) throws InterruptedException, IOException {
        Extractor extractor2;
        HlsExtractorFactory.Result result;
        if (extractor != null) {
            if ((extractor instanceof TsExtractor) || (extractor instanceof FragmentedMp4Extractor)) {
                return a(extractor);
            }
            if (extractor instanceof WebvttExtractor) {
                result = a(new WebvttExtractor(format.language, timestampAdjuster));
            } else if (extractor instanceof AdtsExtractor) {
                result = a(new AdtsExtractor());
            } else if (extractor instanceof Ac3Extractor) {
                result = a(new Ac3Extractor());
            } else if (extractor instanceof Ac4Extractor) {
                result = a(new Ac4Extractor());
            } else {
                result = extractor instanceof Mp3Extractor ? a(new Mp3Extractor()) : null;
            }
            if (result == null) {
                String simpleName = extractor.getClass().getSimpleName();
                throw new IllegalArgumentException(simpleName.length() != 0 ? "Unexpected previousExtractor type: ".concat(simpleName) : new String("Unexpected previousExtractor type: "));
            }
        }
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            lastPathSegment = "";
        }
        if (MimeTypes.TEXT_VTT.equals(format.sampleMimeType) || lastPathSegment.endsWith(WEBVTT_FILE_EXTENSION) || lastPathSegment.endsWith(VTT_FILE_EXTENSION)) {
            extractor2 = new WebvttExtractor(format.language, timestampAdjuster);
        } else if (lastPathSegment.endsWith(AAC_FILE_EXTENSION)) {
            extractor2 = new AdtsExtractor();
        } else if (lastPathSegment.endsWith(AC3_FILE_EXTENSION) || lastPathSegment.endsWith(EC3_FILE_EXTENSION)) {
            extractor2 = new Ac3Extractor();
        } else if (lastPathSegment.endsWith(AC4_FILE_EXTENSION)) {
            extractor2 = new Ac4Extractor();
        } else if (lastPathSegment.endsWith(MP3_FILE_EXTENSION)) {
            extractor2 = new Mp3Extractor(0, 0);
        } else if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(M4_FILE_EXTENSION_PREFIX, lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(CMF_FILE_EXTENSION_PREFIX, lastPathSegment.length() - 5)) {
            extractor2 = b(timestampAdjuster, format, list);
        } else {
            extractor2 = c(this.a, this.b, format, list, timestampAdjuster);
        }
        extractorInput.resetPeekPosition();
        if (d(extractor2, extractorInput)) {
            return a(extractor2);
        }
        if (!(extractor2 instanceof WebvttExtractor)) {
            WebvttExtractor webvttExtractor = new WebvttExtractor(format.language, timestampAdjuster);
            if (d(webvttExtractor, extractorInput)) {
                return a(webvttExtractor);
            }
        }
        if (!(extractor2 instanceof AdtsExtractor)) {
            AdtsExtractor adtsExtractor = new AdtsExtractor();
            if (d(adtsExtractor, extractorInput)) {
                return a(adtsExtractor);
            }
        }
        if (!(extractor2 instanceof Ac3Extractor)) {
            Ac3Extractor ac3Extractor = new Ac3Extractor();
            if (d(ac3Extractor, extractorInput)) {
                return a(ac3Extractor);
            }
        }
        if (!(extractor2 instanceof Ac4Extractor)) {
            Ac4Extractor ac4Extractor = new Ac4Extractor();
            if (d(ac4Extractor, extractorInput)) {
                return a(ac4Extractor);
            }
        }
        if (!(extractor2 instanceof Mp3Extractor)) {
            Mp3Extractor mp3Extractor = new Mp3Extractor(0, 0);
            if (d(mp3Extractor, extractorInput)) {
                return a(mp3Extractor);
            }
        }
        if (!(extractor2 instanceof FragmentedMp4Extractor)) {
            FragmentedMp4Extractor b2 = b(timestampAdjuster, format, list);
            if (d(b2, extractorInput)) {
                return a(b2);
            }
        }
        if (!(extractor2 instanceof TsExtractor)) {
            TsExtractor c = c(this.a, this.b, format, list, timestampAdjuster);
            if (d(c, extractorInput)) {
                return a(c);
            }
        }
        return a(extractor2);
    }

    public DefaultHlsExtractorFactory(int i, boolean z) {
        this.a = i;
        this.b = z;
    }
}
