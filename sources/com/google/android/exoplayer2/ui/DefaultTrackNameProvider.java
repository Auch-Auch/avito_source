package com.google.android.exoplayer2.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.Locale;
public class DefaultTrackNameProvider implements TrackNameProvider {
    public final Resources a;

    public DefaultTrackNameProvider(Resources resources) {
        this.a = (Resources) Assertions.checkNotNull(resources);
    }

    public final String a(Format format) {
        int i = format.bitrate;
        if (i == -1) {
            return "";
        }
        return this.a.getString(R.string.exo_track_bitrate, Float.valueOf(((float) i) / 1000000.0f));
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x002e: APUT  (r0v1 java.lang.String[]), (0 ??[int, short, byte, char]), (r1v1 java.lang.String) */
    public final String b(Format format) {
        String str;
        String[] strArr = new String[2];
        String str2 = format.language;
        String str3 = "";
        if (TextUtils.isEmpty(str2) || C.LANGUAGE_UNDETERMINED.equals(str2)) {
            str = str3;
        } else {
            str = (Util.SDK_INT >= 21 ? Locale.forLanguageTag(str2) : new Locale(str2)).getDisplayName();
        }
        strArr[0] = str;
        strArr[1] = c(format);
        String d = d(strArr);
        if (!TextUtils.isEmpty(d)) {
            return d;
        }
        if (!TextUtils.isEmpty(format.label)) {
            str3 = format.label;
        }
        return str3;
    }

    public final String c(Format format) {
        String string = (format.roleFlags & 2) != 0 ? this.a.getString(R.string.exo_track_role_alternate) : "";
        if ((format.roleFlags & 4) != 0) {
            string = d(string, this.a.getString(R.string.exo_track_role_supplementary));
        }
        if ((format.roleFlags & 8) != 0) {
            string = d(string, this.a.getString(R.string.exo_track_role_commentary));
        }
        return (format.roleFlags & 1088) != 0 ? d(string, this.a.getString(R.string.exo_track_role_closed_captions)) : string;
    }

    public final String d(String... strArr) {
        String str = "";
        for (String str2 : strArr) {
            if (str2.length() > 0) {
                if (TextUtils.isEmpty(str)) {
                    str = str2;
                } else {
                    str = this.a.getString(R.string.exo_item_list, str, str2);
                }
            }
        }
        return str;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0060: APUT  (r0v6 java.lang.String[]), (1 ??[boolean, int, float, short, byte, char]), (r4v12 java.lang.String) */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00b8: APUT  (r0v5 java.lang.String[]), (1 ??[boolean, int, float, short, byte, char]), (r4v1 java.lang.String) */
    @Override // com.google.android.exoplayer2.ui.TrackNameProvider
    public String getTrackName(Format format) {
        String str;
        int trackType = MimeTypes.getTrackType(format.sampleMimeType);
        if (trackType == -1) {
            if (MimeTypes.getVideoMediaMimeType(format.codecs) == null) {
                if (MimeTypes.getAudioMediaMimeType(format.codecs) == null) {
                    if (format.width == -1 && format.height == -1) {
                        if (format.channelCount == -1 && format.sampleRate == -1) {
                            trackType = -1;
                        }
                    }
                }
                trackType = 1;
            }
            trackType = 2;
        }
        String str2 = "";
        if (trackType == 2) {
            String[] strArr = new String[3];
            strArr[0] = c(format);
            int i = format.width;
            int i2 = format.height;
            if (!(i == -1 || i2 == -1)) {
                str2 = this.a.getString(R.string.exo_track_resolution, Integer.valueOf(i), Integer.valueOf(i2));
            }
            strArr[1] = str2;
            strArr[2] = a(format);
            str = d(strArr);
        } else if (trackType == 1) {
            String[] strArr2 = new String[3];
            strArr2[0] = b(format);
            int i3 = format.channelCount;
            if (i3 != -1 && i3 >= 1) {
                str2 = i3 != 1 ? i3 != 2 ? (i3 == 6 || i3 == 7) ? this.a.getString(R.string.exo_track_surround_5_point_1) : i3 != 8 ? this.a.getString(R.string.exo_track_surround) : this.a.getString(R.string.exo_track_surround_7_point_1) : this.a.getString(R.string.exo_track_stereo) : this.a.getString(R.string.exo_track_mono);
            }
            strArr2[1] = str2;
            strArr2[2] = a(format);
            str = d(strArr2);
        } else {
            str = b(format);
        }
        return str.length() == 0 ? this.a.getString(R.string.exo_track_unknown) : str;
    }
}
