package com.google.android.exoplayer2.extractor;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.amr.AmrExtractor;
import com.google.android.exoplayer2.extractor.flac.FlacExtractor;
import com.google.android.exoplayer2.extractor.flv.FlvExtractor;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Mp4Extractor;
import com.google.android.exoplayer2.extractor.ogg.OggExtractor;
import com.google.android.exoplayer2.extractor.ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.ts.Ac4Extractor;
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.extractor.wav.WavExtractor;
import com.google.android.exoplayer2.util.FileTypes;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public final class DefaultExtractorsFactory implements ExtractorsFactory {
    public static final int[] l = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7};
    @Nullable
    public static final Constructor<? extends Extractor> m;
    public boolean a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i = 1;
    public int j;
    public int k = TsExtractor.DEFAULT_TIMESTAMP_SEARCH_BYTES;

    static {
        Constructor<? extends U> constructor = null;
        try {
            if (Boolean.TRUE.equals(Class.forName("com.google.android.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke(null, new Object[0]))) {
                constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(Extractor.class).getConstructor(Integer.TYPE);
            }
        } catch (ClassNotFoundException unused) {
        } catch (Exception e2) {
            throw new RuntimeException("Error instantiating FLAC extension", e2);
        }
        m = constructor;
    }

    public final void a(int i2, List<Extractor> list) {
        switch (i2) {
            case 0:
                list.add(new Ac3Extractor());
                return;
            case 1:
                list.add(new Ac4Extractor());
                return;
            case 2:
                list.add(new AdtsExtractor(this.b | (this.a ? 1 : 0)));
                return;
            case 3:
                list.add(new AmrExtractor(this.c | (this.a ? 1 : 0)));
                return;
            case 4:
                Constructor<? extends Extractor> constructor = m;
                if (constructor != null) {
                    try {
                        list.add((Extractor) constructor.newInstance(Integer.valueOf(this.d)));
                        return;
                    } catch (Exception e2) {
                        throw new IllegalStateException("Unexpected error creating FLAC extractor", e2);
                    }
                } else {
                    list.add(new FlacExtractor(this.d));
                    return;
                }
            case 5:
                list.add(new FlvExtractor());
                return;
            case 6:
                list.add(new MatroskaExtractor(this.e));
                return;
            case 7:
                list.add(new Mp3Extractor(this.h | (this.a ? 1 : 0)));
                return;
            case 8:
                list.add(new FragmentedMp4Extractor(this.g));
                list.add(new Mp4Extractor(this.f));
                return;
            case 9:
                list.add(new OggExtractor());
                return;
            case 10:
                list.add(new PsExtractor());
                return;
            case 11:
                list.add(new TsExtractor(this.i, this.j, this.k));
                return;
            case 12:
                list.add(new WavExtractor());
                return;
            default:
                return;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public synchronized Extractor[] createExtractors() {
        return createExtractors(Uri.EMPTY, new HashMap());
    }

    public synchronized DefaultExtractorsFactory setAdtsExtractorFlags(int i2) {
        this.b = i2;
        return this;
    }

    public synchronized DefaultExtractorsFactory setAmrExtractorFlags(int i2) {
        this.c = i2;
        return this;
    }

    public synchronized DefaultExtractorsFactory setConstantBitrateSeekingEnabled(boolean z) {
        this.a = z;
        return this;
    }

    public synchronized DefaultExtractorsFactory setFlacExtractorFlags(int i2) {
        this.d = i2;
        return this;
    }

    public synchronized DefaultExtractorsFactory setFragmentedMp4ExtractorFlags(int i2) {
        this.g = i2;
        return this;
    }

    public synchronized DefaultExtractorsFactory setMatroskaExtractorFlags(int i2) {
        this.e = i2;
        return this;
    }

    public synchronized DefaultExtractorsFactory setMp3ExtractorFlags(int i2) {
        this.h = i2;
        return this;
    }

    public synchronized DefaultExtractorsFactory setMp4ExtractorFlags(int i2) {
        this.f = i2;
        return this;
    }

    public synchronized DefaultExtractorsFactory setTsExtractorFlags(int i2) {
        this.j = i2;
        return this;
    }

    public synchronized DefaultExtractorsFactory setTsExtractorMode(int i2) {
        this.i = i2;
        return this;
    }

    public synchronized DefaultExtractorsFactory setTsExtractorTimestampSearchBytes(int i2) {
        this.k = i2;
        return this;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public synchronized Extractor[] createExtractors(Uri uri, Map<String, List<String>> map) {
        ArrayList arrayList;
        arrayList = new ArrayList(14);
        int inferFileTypeFromResponseHeaders = FileTypes.inferFileTypeFromResponseHeaders(map);
        if (inferFileTypeFromResponseHeaders != -1) {
            a(inferFileTypeFromResponseHeaders, arrayList);
        }
        int inferFileTypeFromUri = FileTypes.inferFileTypeFromUri(uri);
        if (!(inferFileTypeFromUri == -1 || inferFileTypeFromUri == inferFileTypeFromResponseHeaders)) {
            a(inferFileTypeFromUri, arrayList);
        }
        int[] iArr = l;
        for (int i2 : iArr) {
            if (!(i2 == inferFileTypeFromResponseHeaders || i2 == inferFileTypeFromUri)) {
                a(i2, arrayList);
            }
        }
        return (Extractor[]) arrayList.toArray(new Extractor[arrayList.size()]);
    }
}
