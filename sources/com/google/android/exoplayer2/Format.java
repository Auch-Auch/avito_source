package com.google.android.exoplayer2;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.avito.android.BuildConfig;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.drm.UnsupportedMediaCrypto;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public final class Format implements Parcelable {
    public static final Parcelable.Creator<Format> CREATOR = new a();
    public static final int NO_VALUE = -1;
    public static final long OFFSET_SAMPLE_RELATIVE = Long.MAX_VALUE;
    public int a;
    public final int accessibilityChannel;
    public final int averageBitrate;
    public final int bitrate;
    public final int channelCount;
    @Nullable
    public final String codecs;
    @Nullable
    public final ColorInfo colorInfo;
    @Nullable
    public final String containerMimeType;
    @Nullable
    public final DrmInitData drmInitData;
    public final int encoderDelay;
    public final int encoderPadding;
    @Nullable
    public final Class<? extends ExoMediaCrypto> exoMediaCryptoType;
    public final float frameRate;
    public final int height;
    @Nullable
    public final String id;
    public final List<byte[]> initializationData;
    @Nullable
    public final String label;
    @Nullable
    public final String language;
    public final int maxInputSize;
    @Nullable
    public final Metadata metadata;
    public final int pcmEncoding;
    public final int peakBitrate;
    public final float pixelWidthHeightRatio;
    @Nullable
    public final byte[] projectionData;
    public final int roleFlags;
    public final int rotationDegrees;
    @Nullable
    public final String sampleMimeType;
    public final int sampleRate;
    public final int selectionFlags;
    public final int stereoMode;
    public final long subsampleOffsetUs;
    public final int width;

    public static final class Builder {
        public int A;
        public int B;
        public int C;
        @Nullable
        public Class<? extends ExoMediaCrypto> D;
        @Nullable
        public String a;
        @Nullable
        public String b;
        @Nullable
        public String c;
        public int d;
        public int e;
        public int f;
        public int g;
        @Nullable
        public String h;
        @Nullable
        public Metadata i;
        @Nullable
        public String j;
        @Nullable
        public String k;
        public int l;
        @Nullable
        public List<byte[]> m;
        @Nullable
        public DrmInitData n;
        public long o;
        public int p;
        public int q;
        public float r;
        public int s;
        public float t;
        @Nullable
        public byte[] u;
        public int v;
        @Nullable
        public ColorInfo w;
        public int x;
        public int y;
        public int z;

        public Builder() {
            this.f = -1;
            this.g = -1;
            this.l = -1;
            this.o = Long.MAX_VALUE;
            this.p = -1;
            this.q = -1;
            this.r = -1.0f;
            this.t = 1.0f;
            this.v = -1;
            this.x = -1;
            this.y = -1;
            this.z = -1;
            this.C = -1;
        }

        public Format build() {
            return new Format(this, null);
        }

        public Builder setAccessibilityChannel(int i2) {
            this.C = i2;
            return this;
        }

        public Builder setAverageBitrate(int i2) {
            this.f = i2;
            return this;
        }

        public Builder setChannelCount(int i2) {
            this.x = i2;
            return this;
        }

        public Builder setCodecs(@Nullable String str) {
            this.h = str;
            return this;
        }

        public Builder setColorInfo(@Nullable ColorInfo colorInfo) {
            this.w = colorInfo;
            return this;
        }

        public Builder setContainerMimeType(@Nullable String str) {
            this.j = str;
            return this;
        }

        public Builder setDrmInitData(@Nullable DrmInitData drmInitData) {
            this.n = drmInitData;
            return this;
        }

        public Builder setEncoderDelay(int i2) {
            this.A = i2;
            return this;
        }

        public Builder setEncoderPadding(int i2) {
            this.B = i2;
            return this;
        }

        public Builder setExoMediaCryptoType(@Nullable Class<? extends ExoMediaCrypto> cls) {
            this.D = cls;
            return this;
        }

        public Builder setFrameRate(float f2) {
            this.r = f2;
            return this;
        }

        public Builder setHeight(int i2) {
            this.q = i2;
            return this;
        }

        public Builder setId(@Nullable String str) {
            this.a = str;
            return this;
        }

        public Builder setInitializationData(@Nullable List<byte[]> list) {
            this.m = list;
            return this;
        }

        public Builder setLabel(@Nullable String str) {
            this.b = str;
            return this;
        }

        public Builder setLanguage(@Nullable String str) {
            this.c = str;
            return this;
        }

        public Builder setMaxInputSize(int i2) {
            this.l = i2;
            return this;
        }

        public Builder setMetadata(@Nullable Metadata metadata) {
            this.i = metadata;
            return this;
        }

        public Builder setPcmEncoding(int i2) {
            this.z = i2;
            return this;
        }

        public Builder setPeakBitrate(int i2) {
            this.g = i2;
            return this;
        }

        public Builder setPixelWidthHeightRatio(float f2) {
            this.t = f2;
            return this;
        }

        public Builder setProjectionData(@Nullable byte[] bArr) {
            this.u = bArr;
            return this;
        }

        public Builder setRoleFlags(int i2) {
            this.e = i2;
            return this;
        }

        public Builder setRotationDegrees(int i2) {
            this.s = i2;
            return this;
        }

        public Builder setSampleMimeType(@Nullable String str) {
            this.k = str;
            return this;
        }

        public Builder setSampleRate(int i2) {
            this.y = i2;
            return this;
        }

        public Builder setSelectionFlags(int i2) {
            this.d = i2;
            return this;
        }

        public Builder setStereoMode(int i2) {
            this.v = i2;
            return this;
        }

        public Builder setSubsampleOffsetUs(long j2) {
            this.o = j2;
            return this;
        }

        public Builder setWidth(int i2) {
            this.p = i2;
            return this;
        }

        public Builder setId(int i2) {
            this.a = Integer.toString(i2);
            return this;
        }

        public Builder(Format format, a aVar) {
            this.a = format.id;
            this.b = format.label;
            this.c = format.language;
            this.d = format.selectionFlags;
            this.e = format.roleFlags;
            this.f = format.averageBitrate;
            this.g = format.peakBitrate;
            this.h = format.codecs;
            this.i = format.metadata;
            this.j = format.containerMimeType;
            this.k = format.sampleMimeType;
            this.l = format.maxInputSize;
            this.m = format.initializationData;
            this.n = format.drmInitData;
            this.o = format.subsampleOffsetUs;
            this.p = format.width;
            this.q = format.height;
            this.r = format.frameRate;
            this.s = format.rotationDegrees;
            this.t = format.pixelWidthHeightRatio;
            this.u = format.projectionData;
            this.v = format.stereoMode;
            this.w = format.colorInfo;
            this.x = format.channelCount;
            this.y = format.sampleRate;
            this.z = format.pcmEncoding;
            this.A = format.encoderDelay;
            this.B = format.encoderPadding;
            this.C = format.accessibilityChannel;
            this.D = format.exoMediaCryptoType;
        }
    }

    public class a implements Parcelable.Creator<Format> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public Format createFromParcel(Parcel parcel) {
            return new Format(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public Format[] newArray(int i) {
            return new Format[i];
        }
    }

    public Format(Builder builder, a aVar) {
        this.id = builder.a;
        this.label = builder.b;
        this.language = Util.normalizeLanguageCode(builder.c);
        this.selectionFlags = builder.d;
        this.roleFlags = builder.e;
        int i = builder.f;
        this.averageBitrate = i;
        int i2 = builder.g;
        this.peakBitrate = i2;
        this.bitrate = i2 != -1 ? i2 : i;
        this.codecs = builder.h;
        this.metadata = builder.i;
        this.containerMimeType = builder.j;
        this.sampleMimeType = builder.k;
        this.maxInputSize = builder.l;
        List<byte[]> list = builder.m;
        this.initializationData = list == null ? Collections.emptyList() : list;
        DrmInitData drmInitData2 = builder.n;
        this.drmInitData = drmInitData2;
        this.subsampleOffsetUs = builder.o;
        this.width = builder.p;
        this.height = builder.q;
        this.frameRate = builder.r;
        int i3 = builder.s;
        int i4 = 0;
        this.rotationDegrees = i3 == -1 ? 0 : i3;
        float f = builder.t;
        this.pixelWidthHeightRatio = f == -1.0f ? 1.0f : f;
        this.projectionData = builder.u;
        this.stereoMode = builder.v;
        this.colorInfo = builder.w;
        this.channelCount = builder.x;
        this.sampleRate = builder.y;
        this.pcmEncoding = builder.z;
        int i5 = builder.A;
        this.encoderDelay = i5 == -1 ? 0 : i5;
        int i6 = builder.B;
        this.encoderPadding = i6 != -1 ? i6 : i4;
        this.accessibilityChannel = builder.C;
        Class<? extends ExoMediaCrypto> cls = builder.D;
        if (cls != null || drmInitData2 == null) {
            this.exoMediaCryptoType = cls;
        } else {
            this.exoMediaCryptoType = UnsupportedMediaCrypto.class;
        }
    }

    @Deprecated
    public static Format createAudioContainerFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Metadata metadata2, int i, int i2, int i3, @Nullable List<byte[]> list, int i4, int i5, @Nullable String str6) {
        return new Builder().setId(str).setLabel(str2).setLanguage(str6).setSelectionFlags(i4).setRoleFlags(i5).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str5).setMetadata(metadata2).setContainerMimeType(str3).setSampleMimeType(str4).setInitializationData(list).setChannelCount(i2).setSampleRate(i3).build();
    }

    @Deprecated
    public static Format createAudioSampleFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, int i, int i2, int i3, int i4, @Nullable List<byte[]> list, @Nullable DrmInitData drmInitData2, int i5, @Nullable String str4) {
        return new Builder().setId(str).setLanguage(str4).setSelectionFlags(i5).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i2).setInitializationData(list).setDrmInitData(drmInitData2).setChannelCount(i3).setSampleRate(i4).build();
    }

    @Deprecated
    public static Format createContainerFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, int i, int i2, int i3, @Nullable String str6) {
        return new Builder().setId(str).setLabel(str2).setLanguage(str6).setSelectionFlags(i2).setRoleFlags(i3).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str5).setContainerMimeType(str3).setSampleMimeType(str4).build();
    }

    @Deprecated
    public static Format createImageSampleFormat(@Nullable String str, @Nullable String str2, int i, @Nullable List<byte[]> list, @Nullable String str3) {
        return new Builder().setId(str).setLanguage(str3).setSelectionFlags(i).setSampleMimeType(str2).setInitializationData(list).build();
    }

    @Deprecated
    public static Format createSampleFormat(@Nullable String str, @Nullable String str2) {
        return new Builder().setId(str).setSampleMimeType(str2).build();
    }

    @Deprecated
    public static Format createTextContainerFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, int i, int i2, int i3, @Nullable String str6) {
        return new Builder().setId(str).setLabel(str2).setLanguage(str6).setSelectionFlags(i2).setRoleFlags(i3).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str5).setContainerMimeType(str3).setSampleMimeType(str4).build();
    }

    @Deprecated
    public static Format createTextSampleFormat(@Nullable String str, @Nullable String str2, int i, @Nullable String str3) {
        return new Builder().setId(str).setLanguage(str3).setSelectionFlags(i).setSampleMimeType(str2).build();
    }

    @Deprecated
    public static Format createVideoContainerFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Metadata metadata2, int i, int i2, int i3, float f, @Nullable List<byte[]> list, int i4, int i5) {
        return new Builder().setId(str).setLabel(str2).setSelectionFlags(i4).setRoleFlags(i5).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str5).setMetadata(metadata2).setContainerMimeType(str3).setSampleMimeType(str4).setInitializationData(list).setWidth(i2).setHeight(i3).setFrameRate(f).build();
    }

    @Deprecated
    public static Format createVideoSampleFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, int i, int i2, int i3, int i4, float f, @Nullable List<byte[]> list, @Nullable DrmInitData drmInitData2) {
        return new Builder().setId(str).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i2).setInitializationData(list).setDrmInitData(drmInitData2).setWidth(i3).setHeight(i4).setFrameRate(f).build();
    }

    public static String toLogString(@Nullable Format format) {
        if (format == null) {
            return BuildConfig.ADJUST_DEFAULT_TRACKER;
        }
        StringBuilder L = a2.b.a.a.a.L("id=");
        L.append(format.id);
        L.append(", mimeType=");
        L.append(format.sampleMimeType);
        if (format.bitrate != -1) {
            L.append(", bitrate=");
            L.append(format.bitrate);
        }
        if (format.codecs != null) {
            L.append(", codecs=");
            L.append(format.codecs);
        }
        if (!(format.width == -1 || format.height == -1)) {
            L.append(", res=");
            L.append(format.width);
            L.append("x");
            L.append(format.height);
        }
        if (format.frameRate != -1.0f) {
            L.append(", fps=");
            L.append(format.frameRate);
        }
        if (format.channelCount != -1) {
            L.append(", channels=");
            L.append(format.channelCount);
        }
        if (format.sampleRate != -1) {
            L.append(", sample_rate=");
            L.append(format.sampleRate);
        }
        if (format.language != null) {
            L.append(", language=");
            L.append(format.language);
        }
        if (format.label != null) {
            L.append(", label=");
            L.append(format.label);
        }
        return L.toString();
    }

    public Builder buildUpon() {
        return new Builder(this, null);
    }

    @Deprecated
    public Format copyWithBitrate(int i) {
        return buildUpon().setAverageBitrate(i).setPeakBitrate(i).build();
    }

    @Deprecated
    public Format copyWithDrmInitData(@Nullable DrmInitData drmInitData2) {
        return buildUpon().setDrmInitData(drmInitData2).build();
    }

    public Format copyWithExoMediaCryptoType(@Nullable Class<? extends ExoMediaCrypto> cls) {
        return buildUpon().setExoMediaCryptoType(cls).build();
    }

    @Deprecated
    public Format copyWithFrameRate(float f) {
        return buildUpon().setFrameRate(f).build();
    }

    @Deprecated
    public Format copyWithGaplessInfo(int i, int i2) {
        return buildUpon().setEncoderDelay(i).setEncoderPadding(i2).build();
    }

    @Deprecated
    public Format copyWithLabel(@Nullable String str) {
        return buildUpon().setLabel(str).build();
    }

    @Deprecated
    public Format copyWithManifestFormatInfo(Format format) {
        return withManifestFormatInfo(format);
    }

    @Deprecated
    public Format copyWithMaxInputSize(int i) {
        return buildUpon().setMaxInputSize(i).build();
    }

    @Deprecated
    public Format copyWithMetadata(@Nullable Metadata metadata2) {
        return buildUpon().setMetadata(metadata2).build();
    }

    @Deprecated
    public Format copyWithSubsampleOffsetUs(long j) {
        return buildUpon().setSubsampleOffsetUs(j).build();
    }

    @Deprecated
    public Format copyWithVideoSize(int i, int i2) {
        return buildUpon().setWidth(i).setHeight(i2).build();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj == null || Format.class != obj.getClass()) {
            return false;
        }
        Format format = (Format) obj;
        int i2 = this.a;
        if ((i2 == 0 || (i = format.a) == 0 || i2 == i) && this.selectionFlags == format.selectionFlags && this.roleFlags == format.roleFlags && this.averageBitrate == format.averageBitrate && this.peakBitrate == format.peakBitrate && this.maxInputSize == format.maxInputSize && this.subsampleOffsetUs == format.subsampleOffsetUs && this.width == format.width && this.height == format.height && this.rotationDegrees == format.rotationDegrees && this.stereoMode == format.stereoMode && this.channelCount == format.channelCount && this.sampleRate == format.sampleRate && this.pcmEncoding == format.pcmEncoding && this.encoderDelay == format.encoderDelay && this.encoderPadding == format.encoderPadding && this.accessibilityChannel == format.accessibilityChannel && Float.compare(this.frameRate, format.frameRate) == 0 && Float.compare(this.pixelWidthHeightRatio, format.pixelWidthHeightRatio) == 0 && Util.areEqual(this.exoMediaCryptoType, format.exoMediaCryptoType) && Util.areEqual(this.id, format.id) && Util.areEqual(this.label, format.label) && Util.areEqual(this.codecs, format.codecs) && Util.areEqual(this.containerMimeType, format.containerMimeType) && Util.areEqual(this.sampleMimeType, format.sampleMimeType) && Util.areEqual(this.language, format.language) && Arrays.equals(this.projectionData, format.projectionData) && Util.areEqual(this.metadata, format.metadata) && Util.areEqual(this.colorInfo, format.colorInfo) && Util.areEqual(this.drmInitData, format.drmInitData) && initializationDataEquals(format)) {
            return true;
        }
        return false;
    }

    public int getPixelCount() {
        int i;
        int i2 = this.width;
        if (i2 == -1 || (i = this.height) == -1) {
            return -1;
        }
        return i2 * i;
    }

    @Override // java.lang.Object
    public int hashCode() {
        if (this.a == 0) {
            String str = this.id;
            int i = 0;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 527) * 31;
            String str2 = this.label;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.language;
            int hashCode3 = (((((((((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.selectionFlags) * 31) + this.roleFlags) * 31) + this.averageBitrate) * 31) + this.peakBitrate) * 31;
            String str4 = this.codecs;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Metadata metadata2 = this.metadata;
            int hashCode5 = (hashCode4 + (metadata2 == null ? 0 : metadata2.hashCode())) * 31;
            String str5 = this.containerMimeType;
            int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.sampleMimeType;
            int i1 = (((((((((((((a2.b.a.a.a.i1(this.pixelWidthHeightRatio, (a2.b.a.a.a.i1(this.frameRate, (((((((((hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.maxInputSize) * 31) + ((int) this.subsampleOffsetUs)) * 31) + this.width) * 31) + this.height) * 31, 31) + this.rotationDegrees) * 31, 31) + this.stereoMode) * 31) + this.channelCount) * 31) + this.sampleRate) * 31) + this.pcmEncoding) * 31) + this.encoderDelay) * 31) + this.encoderPadding) * 31) + this.accessibilityChannel) * 31;
            Class<? extends ExoMediaCrypto> cls = this.exoMediaCryptoType;
            if (cls != null) {
                i = cls.hashCode();
            }
            this.a = i1 + i;
        }
        return this.a;
    }

    public boolean initializationDataEquals(Format format) {
        if (this.initializationData.size() != format.initializationData.size()) {
            return false;
        }
        for (int i = 0; i < this.initializationData.size(); i++) {
            if (!Arrays.equals(this.initializationData.get(i), format.initializationData.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("Format(");
        L.append(this.id);
        L.append(", ");
        L.append(this.label);
        L.append(", ");
        L.append(this.containerMimeType);
        L.append(", ");
        L.append(this.sampleMimeType);
        L.append(", ");
        L.append(this.codecs);
        L.append(", ");
        L.append(this.bitrate);
        L.append(", ");
        L.append(this.language);
        L.append(", [");
        L.append(this.width);
        L.append(", ");
        L.append(this.height);
        L.append(", ");
        L.append(this.frameRate);
        L.append("], [");
        L.append(this.channelCount);
        L.append(", ");
        return a2.b.a.a.a.j(L, this.sampleRate, "])");
    }

    public Format withManifestFormatInfo(Format format) {
        Metadata metadata2;
        String str;
        if (this == format) {
            return this;
        }
        int trackType = MimeTypes.getTrackType(this.sampleMimeType);
        String str2 = format.id;
        String str3 = format.label;
        if (str3 == null) {
            str3 = this.label;
        }
        String str4 = this.language;
        if ((trackType == 3 || trackType == 1) && (str = format.language) != null) {
            str4 = str;
        }
        int i = this.averageBitrate;
        if (i == -1) {
            i = format.averageBitrate;
        }
        int i2 = this.peakBitrate;
        if (i2 == -1) {
            i2 = format.peakBitrate;
        }
        String str5 = this.codecs;
        if (str5 == null) {
            String codecsOfType = Util.getCodecsOfType(format.codecs, trackType);
            if (Util.splitCodecs(codecsOfType).length == 1) {
                str5 = codecsOfType;
            }
        }
        Metadata metadata3 = this.metadata;
        if (metadata3 == null) {
            metadata2 = format.metadata;
        } else {
            metadata2 = metadata3.copyWithAppendedEntriesFrom(format.metadata);
        }
        float f = this.frameRate;
        if (f == -1.0f && trackType == 2) {
            f = format.frameRate;
        }
        int i3 = this.selectionFlags | format.selectionFlags;
        return buildUpon().setId(str2).setLabel(str3).setLanguage(str4).setSelectionFlags(i3).setRoleFlags(this.roleFlags | format.roleFlags).setAverageBitrate(i).setPeakBitrate(i2).setCodecs(str5).setMetadata(metadata2).setDrmInitData(DrmInitData.createSessionCreationData(format.drmInitData, this.drmInitData)).setFrameRate(f).build();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.label);
        parcel.writeString(this.language);
        parcel.writeInt(this.selectionFlags);
        parcel.writeInt(this.roleFlags);
        parcel.writeInt(this.averageBitrate);
        parcel.writeInt(this.peakBitrate);
        parcel.writeString(this.codecs);
        boolean z = false;
        parcel.writeParcelable(this.metadata, 0);
        parcel.writeString(this.containerMimeType);
        parcel.writeString(this.sampleMimeType);
        parcel.writeInt(this.maxInputSize);
        int size = this.initializationData.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeByteArray(this.initializationData.get(i2));
        }
        parcel.writeParcelable(this.drmInitData, 0);
        parcel.writeLong(this.subsampleOffsetUs);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeFloat(this.frameRate);
        parcel.writeInt(this.rotationDegrees);
        parcel.writeFloat(this.pixelWidthHeightRatio);
        if (this.projectionData != null) {
            z = true;
        }
        Util.writeBoolean(parcel, z);
        byte[] bArr = this.projectionData;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.stereoMode);
        parcel.writeParcelable(this.colorInfo, i);
        parcel.writeInt(this.channelCount);
        parcel.writeInt(this.sampleRate);
        parcel.writeInt(this.pcmEncoding);
        parcel.writeInt(this.encoderDelay);
        parcel.writeInt(this.encoderPadding);
        parcel.writeInt(this.accessibilityChannel);
    }

    @Deprecated
    public static Format createTextSampleFormat(@Nullable String str, @Nullable String str2, int i, @Nullable String str3, int i2, long j, @Nullable List<byte[]> list) {
        return new Builder().setId(str).setLanguage(str3).setSelectionFlags(i).setSampleMimeType(str2).setInitializationData(list).setSubsampleOffsetUs(j).setAccessibilityChannel(i2).build();
    }

    @Deprecated
    public static Format createTextContainerFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, int i, int i2, int i3, @Nullable String str6, int i4) {
        return new Builder().setId(str).setLabel(str2).setLanguage(str6).setSelectionFlags(i2).setRoleFlags(i3).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str5).setContainerMimeType(str3).setSampleMimeType(str4).setAccessibilityChannel(i4).build();
    }

    @Deprecated
    public static Format createVideoSampleFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, int i, int i2, int i3, int i4, float f, @Nullable List<byte[]> list, int i5, float f2, @Nullable DrmInitData drmInitData2) {
        return new Builder().setId(str).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i2).setInitializationData(list).setDrmInitData(drmInitData2).setWidth(i3).setHeight(i4).setFrameRate(f).setRotationDegrees(i5).setPixelWidthHeightRatio(f2).build();
    }

    @Deprecated
    public static Format createAudioSampleFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, int i, int i2, int i3, int i4, int i5, @Nullable List<byte[]> list, @Nullable DrmInitData drmInitData2, int i6, @Nullable String str4) {
        return new Builder().setId(str).setLanguage(str4).setSelectionFlags(i6).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i2).setInitializationData(list).setDrmInitData(drmInitData2).setChannelCount(i3).setSampleRate(i4).setPcmEncoding(i5).build();
    }

    @Deprecated
    public static Format createVideoSampleFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, int i, int i2, int i3, int i4, float f, @Nullable List<byte[]> list, int i5, float f2, @Nullable byte[] bArr, int i6, @Nullable ColorInfo colorInfo2, @Nullable DrmInitData drmInitData2) {
        return new Builder().setId(str).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i2).setInitializationData(list).setDrmInitData(drmInitData2).setWidth(i3).setHeight(i4).setFrameRate(f).setRotationDegrees(i5).setPixelWidthHeightRatio(f2).setProjectionData(bArr).setStereoMode(i6).setColorInfo(colorInfo2).build();
    }

    @Deprecated
    public static Format createAudioSampleFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, int i, int i2, int i3, int i4, int i5, int i6, int i7, @Nullable List<byte[]> list, @Nullable DrmInitData drmInitData2, int i8, @Nullable String str4, @Nullable Metadata metadata2) {
        return new Builder().setId(str).setLanguage(str4).setSelectionFlags(i8).setAverageBitrate(i).setPeakBitrate(i).setCodecs(str3).setMetadata(metadata2).setSampleMimeType(str2).setMaxInputSize(i2).setInitializationData(list).setDrmInitData(drmInitData2).setChannelCount(i3).setSampleRate(i4).setPcmEncoding(i5).setEncoderDelay(i6).setEncoderPadding(i7).build();
    }

    public Format(Parcel parcel) {
        this.id = parcel.readString();
        this.label = parcel.readString();
        this.language = parcel.readString();
        this.selectionFlags = parcel.readInt();
        this.roleFlags = parcel.readInt();
        int readInt = parcel.readInt();
        this.averageBitrate = readInt;
        int readInt2 = parcel.readInt();
        this.peakBitrate = readInt2;
        this.bitrate = readInt2 != -1 ? readInt2 : readInt;
        this.codecs = parcel.readString();
        this.metadata = (Metadata) parcel.readParcelable(Metadata.class.getClassLoader());
        this.containerMimeType = parcel.readString();
        this.sampleMimeType = parcel.readString();
        this.maxInputSize = parcel.readInt();
        int readInt3 = parcel.readInt();
        this.initializationData = new ArrayList(readInt3);
        for (int i = 0; i < readInt3; i++) {
            this.initializationData.add((byte[]) Assertions.checkNotNull(parcel.createByteArray()));
        }
        DrmInitData drmInitData2 = (DrmInitData) parcel.readParcelable(DrmInitData.class.getClassLoader());
        this.drmInitData = drmInitData2;
        this.subsampleOffsetUs = parcel.readLong();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.frameRate = parcel.readFloat();
        this.rotationDegrees = parcel.readInt();
        this.pixelWidthHeightRatio = parcel.readFloat();
        Class cls = null;
        this.projectionData = Util.readBoolean(parcel) ? parcel.createByteArray() : null;
        this.stereoMode = parcel.readInt();
        this.colorInfo = (ColorInfo) parcel.readParcelable(ColorInfo.class.getClassLoader());
        this.channelCount = parcel.readInt();
        this.sampleRate = parcel.readInt();
        this.pcmEncoding = parcel.readInt();
        this.encoderDelay = parcel.readInt();
        this.encoderPadding = parcel.readInt();
        this.accessibilityChannel = parcel.readInt();
        this.exoMediaCryptoType = drmInitData2 != null ? UnsupportedMediaCrypto.class : cls;
    }
}
