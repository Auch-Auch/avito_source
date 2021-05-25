package com.google.android.exoplayer2.util;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Map;
public final class FileTypes {
    public static final int AC3 = 0;
    public static final int AC4 = 1;
    public static final int ADTS = 2;
    public static final int AMR = 3;
    public static final int FLAC = 4;
    public static final int FLV = 5;
    public static final int MATROSKA = 6;
    public static final int MP3 = 7;
    public static final int MP4 = 8;
    public static final int OGG = 9;
    public static final int PS = 10;
    public static final int TS = 11;
    public static final int UNKNOWN = -1;
    public static final int WAV = 12;
    public static final int WEBVTT = 13;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static int inferFileTypeFromMimeType(@Nullable String str) {
        char c;
        if (str == null) {
            return -1;
        }
        String normalizeMimeType = MimeTypes.normalizeMimeType(str);
        normalizeMimeType.hashCode();
        switch (normalizeMimeType.hashCode()) {
            case -2123537834:
                if (normalizeMimeType.equals(MimeTypes.AUDIO_E_AC3_JOC)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1662384011:
                if (normalizeMimeType.equals(MimeTypes.VIDEO_PS)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1662384007:
                if (normalizeMimeType.equals(MimeTypes.VIDEO_MP2T)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1662095187:
                if (normalizeMimeType.equals(MimeTypes.VIDEO_WEBM)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1606874997:
                if (normalizeMimeType.equals(MimeTypes.AUDIO_AMR_WB)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1248337486:
                if (normalizeMimeType.equals(MimeTypes.APPLICATION_MP4)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1004728940:
                if (normalizeMimeType.equals(MimeTypes.TEXT_VTT)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -387023398:
                if (normalizeMimeType.equals(MimeTypes.AUDIO_MATROSKA)) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -43467528:
                if (normalizeMimeType.equals(MimeTypes.APPLICATION_WEBM)) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 13915911:
                if (normalizeMimeType.equals(MimeTypes.VIDEO_FLV)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 187078296:
                if (normalizeMimeType.equals(MimeTypes.AUDIO_AC3)) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 187078297:
                if (normalizeMimeType.equals(MimeTypes.AUDIO_AC4)) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 187078669:
                if (normalizeMimeType.equals(MimeTypes.AUDIO_AMR)) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 187090232:
                if (normalizeMimeType.equals(MimeTypes.AUDIO_MP4)) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 187091926:
                if (normalizeMimeType.equals(MimeTypes.AUDIO_OGG)) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 187099443:
                if (normalizeMimeType.equals(MimeTypes.AUDIO_WAV)) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 1331848029:
                if (normalizeMimeType.equals("video/mp4")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 1503095341:
                if (normalizeMimeType.equals(MimeTypes.AUDIO_AMR_NB)) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 1504578661:
                if (normalizeMimeType.equals(MimeTypes.AUDIO_E_AC3)) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 1504619009:
                if (normalizeMimeType.equals(MimeTypes.AUDIO_FLAC)) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 1504831518:
                if (normalizeMimeType.equals(MimeTypes.AUDIO_MPEG)) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 1505118770:
                if (normalizeMimeType.equals(MimeTypes.AUDIO_WEBM)) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 2039520277:
                if (normalizeMimeType.equals(MimeTypes.VIDEO_MATROSKA)) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case '\n':
            case 18:
                return 0;
            case 1:
                return 10;
            case 2:
                return 11;
            case 3:
            case 7:
            case '\b':
            case 21:
            case 22:
                return 6;
            case 4:
            case '\f':
            case 17:
                return 3;
            case 5:
            case '\r':
            case 16:
                return 8;
            case 6:
                return 13;
            case '\t':
                return 5;
            case 11:
                return 1;
            case 14:
                return 9;
            case 15:
                return 12;
            case 19:
                return 4;
            case 20:
                return 7;
            default:
                return -1;
        }
    }

    public static int inferFileTypeFromResponseHeaders(Map<String, List<String>> map) {
        List<String> list = map.get("Content-Type");
        return inferFileTypeFromMimeType((list == null || list.isEmpty()) ? null : list.get(0));
    }

    public static int inferFileTypeFromUri(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (lastPathSegment.endsWith(DefaultHlsExtractorFactory.AC3_FILE_EXTENSION) || lastPathSegment.endsWith(DefaultHlsExtractorFactory.EC3_FILE_EXTENSION)) {
            return 0;
        }
        if (lastPathSegment.endsWith(DefaultHlsExtractorFactory.AC4_FILE_EXTENSION)) {
            return 1;
        }
        if (lastPathSegment.endsWith(".adts") || lastPathSegment.endsWith(DefaultHlsExtractorFactory.AAC_FILE_EXTENSION)) {
            return 2;
        }
        if (lastPathSegment.endsWith(".amr")) {
            return 3;
        }
        if (lastPathSegment.endsWith(".flac")) {
            return 4;
        }
        if (lastPathSegment.endsWith(".flv")) {
            return 5;
        }
        if (lastPathSegment.startsWith(".mk", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".webm")) {
            return 6;
        }
        if (lastPathSegment.endsWith(DefaultHlsExtractorFactory.MP3_FILE_EXTENSION)) {
            return 7;
        }
        if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(DefaultHlsExtractorFactory.M4_FILE_EXTENSION_PREFIX, lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(DefaultHlsExtractorFactory.CMF_FILE_EXTENSION_PREFIX, lastPathSegment.length() - 5)) {
            return 8;
        }
        if (lastPathSegment.startsWith(".og", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".opus")) {
            return 9;
        }
        if (lastPathSegment.endsWith(".ps") || lastPathSegment.endsWith(".mpeg") || lastPathSegment.endsWith(".mpg") || lastPathSegment.endsWith(".m2p")) {
            return 10;
        }
        if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            return 11;
        }
        if (lastPathSegment.endsWith(".wav") || lastPathSegment.endsWith(".wave")) {
            return 12;
        }
        if (lastPathSegment.endsWith(DefaultHlsExtractorFactory.VTT_FILE_EXTENSION) || lastPathSegment.endsWith(DefaultHlsExtractorFactory.WEBVTT_FILE_EXTENSION)) {
            return 13;
        }
        return -1;
    }
}
