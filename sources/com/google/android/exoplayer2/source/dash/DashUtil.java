package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper;
import com.google.android.exoplayer2.source.chunk.InitializationChunk;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.List;
public final class DashUtil {
    @Nullable
    public static Representation a(Period period, int i) {
        int adaptationSetIndex = period.getAdaptationSetIndex(i);
        if (adaptationSetIndex == -1) {
            return null;
        }
        List<Representation> list = period.adaptationSets.get(adaptationSetIndex).representations;
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Nullable
    public static ChunkExtractorWrapper b(DataSource dataSource, int i, Representation representation, boolean z) throws IOException, InterruptedException {
        RangedUri initializationUri = representation.getInitializationUri();
        if (initializationUri == null) {
            return null;
        }
        ChunkExtractorWrapper d = d(i, representation.format);
        if (z) {
            RangedUri indexUri = representation.getIndexUri();
            if (indexUri == null) {
                return null;
            }
            RangedUri attemptMerge = initializationUri.attemptMerge(indexUri, representation.baseUrl);
            if (attemptMerge == null) {
                c(dataSource, representation, d, initializationUri);
                initializationUri = indexUri;
            } else {
                initializationUri = attemptMerge;
            }
        }
        c(dataSource, representation, d, initializationUri);
        return d;
    }

    public static void c(DataSource dataSource, Representation representation, ChunkExtractorWrapper chunkExtractorWrapper, RangedUri rangedUri) throws IOException, InterruptedException {
        new InitializationChunk(dataSource, new DataSpec(rangedUri.resolveUri(representation.baseUrl), rangedUri.start, rangedUri.length, representation.getCacheKey()), representation.format, 0, (Object) null, chunkExtractorWrapper).load();
    }

    public static ChunkExtractorWrapper d(int i, Format format) {
        String str = format.containerMimeType;
        return new ChunkExtractorWrapper(str != null && (str.startsWith(MimeTypes.VIDEO_WEBM) || str.startsWith(MimeTypes.AUDIO_WEBM)) ? new MatroskaExtractor() : new FragmentedMp4Extractor(), i, format);
    }

    @Nullable
    public static ChunkIndex loadChunkIndex(DataSource dataSource, int i, Representation representation) throws IOException, InterruptedException {
        ChunkExtractorWrapper b = b(dataSource, i, representation, true);
        if (b == null) {
            return null;
        }
        return (ChunkIndex) b.getSeekMap();
    }

    @Nullable
    public static DrmInitData loadDrmInitData(DataSource dataSource, Period period) throws IOException, InterruptedException {
        int i = 2;
        Representation a = a(period, 2);
        if (a == null) {
            i = 1;
            a = a(period, 1);
            if (a == null) {
                return null;
            }
        }
        Format format = a.format;
        Format loadSampleFormat = loadSampleFormat(dataSource, i, a);
        if (loadSampleFormat == null) {
            return format.drmInitData;
        }
        return loadSampleFormat.copyWithManifestFormatInfo(format).drmInitData;
    }

    public static DashManifest loadManifest(DataSource dataSource, Uri uri) throws IOException {
        return (DashManifest) ParsingLoadable.load(dataSource, new DashManifestParser(), uri, 4);
    }

    @Nullable
    public static Format loadSampleFormat(DataSource dataSource, int i, Representation representation) throws IOException, InterruptedException {
        ChunkExtractorWrapper b = b(dataSource, i, representation, false);
        if (b == null) {
            return null;
        }
        return b.getSampleFormats()[0];
    }
}
