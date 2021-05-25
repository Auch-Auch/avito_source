package com.google.android.exoplayer2;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
public final class MediaItem {
    public final ClippingProperties clippingProperties;
    public final String mediaId;
    public final MediaMetadata mediaMetadata;
    @Nullable
    public final PlaybackProperties playbackProperties;

    public static final class Builder {
        @Nullable
        public String a;
        @Nullable
        public Uri b;
        @Nullable
        public String c;
        public long d;
        public long e = Long.MIN_VALUE;
        public boolean f;
        public boolean g;
        public boolean h;
        @Nullable
        public Uri i;
        public Map<String, String> j = Collections.emptyMap();
        @Nullable
        public UUID k;
        public boolean l;
        public boolean m;
        public boolean n;
        public List<Integer> o = Collections.emptyList();
        @Nullable
        public byte[] p;
        public List<StreamKey> q = Collections.emptyList();
        @Nullable
        public String r;
        public List<Subtitle> s = Collections.emptyList();
        @Nullable
        public Uri t;
        @Nullable
        public Object u;
        @Nullable
        public MediaMetadata v;

        public MediaItem build() {
            PlaybackProperties playbackProperties;
            Assertions.checkState(this.i == null || this.k != null);
            Uri uri = this.b;
            DrmConfiguration drmConfiguration = null;
            if (uri != null) {
                String str = this.c;
                UUID uuid = this.k;
                if (uuid != null) {
                    drmConfiguration = new DrmConfiguration(uuid, this.i, this.j, this.l, this.n, this.m, this.o, this.p, null);
                }
                PlaybackProperties playbackProperties2 = new PlaybackProperties(uri, str, drmConfiguration, this.q, this.r, this.s, this.t, this.u, null);
                String str2 = this.a;
                if (str2 == null) {
                    str2 = this.b.toString();
                }
                this.a = str2;
                playbackProperties = playbackProperties2;
            } else {
                playbackProperties = null;
            }
            String str3 = (String) Assertions.checkNotNull(this.a);
            ClippingProperties clippingProperties = new ClippingProperties(this.d, this.e, this.f, this.g, this.h, null);
            MediaMetadata mediaMetadata = this.v;
            if (mediaMetadata == null) {
                mediaMetadata = new MediaMetadata.Builder().build();
            }
            return new MediaItem(str3, clippingProperties, playbackProperties, mediaMetadata, null);
        }

        public Builder setAdTagUri(@Nullable String str) {
            this.t = str != null ? Uri.parse(str) : null;
            return this;
        }

        public Builder setClipEndPositionMs(long j2) {
            Assertions.checkArgument(j2 == Long.MIN_VALUE || j2 >= 0);
            this.e = j2;
            return this;
        }

        public Builder setClipRelativeToDefaultPosition(boolean z) {
            this.g = z;
            return this;
        }

        public Builder setClipRelativeToLiveWindow(boolean z) {
            this.f = z;
            return this;
        }

        public Builder setClipStartPositionMs(long j2) {
            Assertions.checkArgument(j2 >= 0);
            this.d = j2;
            return this;
        }

        public Builder setClipStartsAtKeyFrame(boolean z) {
            this.h = z;
            return this;
        }

        public Builder setCustomCacheKey(@Nullable String str) {
            this.r = str;
            return this;
        }

        public Builder setDrmForceDefaultLicenseUri(boolean z) {
            this.n = z;
            return this;
        }

        public Builder setDrmKeySetId(@Nullable byte[] bArr) {
            this.p = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
            return this;
        }

        public Builder setDrmLicenseRequestHeaders(@Nullable Map<String, String> map) {
            Map<String, String> map2;
            if (map == null || map.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(new HashMap(map));
            }
            this.j = map2;
            return this;
        }

        public Builder setDrmLicenseUri(@Nullable Uri uri) {
            this.i = uri;
            return this;
        }

        public Builder setDrmMultiSession(boolean z) {
            this.l = z;
            return this;
        }

        public Builder setDrmPlayClearContentWithoutKey(boolean z) {
            this.m = z;
            return this;
        }

        public Builder setDrmSessionForClearPeriods(boolean z) {
            List<Integer> list;
            if (z) {
                list = Arrays.asList(2, 1);
            } else {
                list = Collections.emptyList();
            }
            setDrmSessionForClearTypes(list);
            return this;
        }

        public Builder setDrmSessionForClearTypes(@Nullable List<Integer> list) {
            List<Integer> list2;
            if (list == null || list.isEmpty()) {
                list2 = Collections.emptyList();
            } else {
                list2 = Collections.unmodifiableList(new ArrayList(list));
            }
            this.o = list2;
            return this;
        }

        public Builder setDrmUuid(@Nullable UUID uuid) {
            this.k = uuid;
            return this;
        }

        public Builder setMediaId(@Nullable String str) {
            this.a = str;
            return this;
        }

        public Builder setMediaMetadata(MediaMetadata mediaMetadata) {
            this.v = mediaMetadata;
            return this;
        }

        public Builder setMimeType(@Nullable String str) {
            this.c = str;
            return this;
        }

        public Builder setStreamKeys(@Nullable List<StreamKey> list) {
            List<StreamKey> list2;
            if (list == null || list.isEmpty()) {
                list2 = Collections.emptyList();
            } else {
                list2 = Collections.unmodifiableList(new ArrayList(list));
            }
            this.q = list2;
            return this;
        }

        public Builder setSubtitles(@Nullable List<Subtitle> list) {
            List<Subtitle> list2;
            if (list == null || list.isEmpty()) {
                list2 = Collections.emptyList();
            } else {
                list2 = Collections.unmodifiableList(new ArrayList(list));
            }
            this.s = list2;
            return this;
        }

        public Builder setTag(@Nullable Object obj) {
            this.u = obj;
            return this;
        }

        public Builder setUri(@Nullable String str) {
            return setUri(str == null ? null : Uri.parse(str));
        }

        public Builder setAdTagUri(@Nullable Uri uri) {
            this.t = uri;
            return this;
        }

        public Builder setDrmLicenseUri(@Nullable String str) {
            this.i = str == null ? null : Uri.parse(str);
            return this;
        }

        public Builder setUri(@Nullable Uri uri) {
            this.b = uri;
            return this;
        }
    }

    public static final class ClippingProperties {
        public final long endPositionMs;
        public final boolean relativeToDefaultPosition;
        public final boolean relativeToLiveWindow;
        public final long startPositionMs;
        public final boolean startsAtKeyFrame;

        public ClippingProperties(long j, long j2, boolean z, boolean z2, boolean z3, a aVar) {
            this.startPositionMs = j;
            this.endPositionMs = j2;
            this.relativeToLiveWindow = z;
            this.relativeToDefaultPosition = z2;
            this.startsAtKeyFrame = z3;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ClippingProperties)) {
                return false;
            }
            ClippingProperties clippingProperties = (ClippingProperties) obj;
            if (this.startPositionMs == clippingProperties.startPositionMs && this.endPositionMs == clippingProperties.endPositionMs && this.relativeToLiveWindow == clippingProperties.relativeToLiveWindow && this.relativeToDefaultPosition == clippingProperties.relativeToDefaultPosition && this.startsAtKeyFrame == clippingProperties.startsAtKeyFrame) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ((((((Long.valueOf(this.endPositionMs).hashCode() + (Long.valueOf(this.startPositionMs).hashCode() * 31)) * 31) + (this.relativeToLiveWindow ? 1 : 0)) * 31) + (this.relativeToDefaultPosition ? 1 : 0)) * 31) + (this.startsAtKeyFrame ? 1 : 0);
        }
    }

    public static final class DrmConfiguration {
        @Nullable
        public final byte[] a;
        public final boolean forceDefaultLicenseUri;
        @Nullable
        public final Uri licenseUri;
        public final boolean multiSession;
        public final boolean playClearContentWithoutKey;
        public final Map<String, String> requestHeaders;
        public final List<Integer> sessionForClearTypes;
        public final UUID uuid;

        public DrmConfiguration(UUID uuid2, Uri uri, Map map, boolean z, boolean z2, boolean z3, List list, byte[] bArr, a aVar) {
            Assertions.checkArgument(!z2 || uri != null);
            this.uuid = uuid2;
            this.licenseUri = uri;
            this.requestHeaders = map;
            this.multiSession = z;
            this.forceDefaultLicenseUri = z2;
            this.playClearContentWithoutKey = z3;
            this.sessionForClearTypes = list;
            this.a = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DrmConfiguration)) {
                return false;
            }
            DrmConfiguration drmConfiguration = (DrmConfiguration) obj;
            if (!this.uuid.equals(drmConfiguration.uuid) || !Util.areEqual(this.licenseUri, drmConfiguration.licenseUri) || !Util.areEqual(this.requestHeaders, drmConfiguration.requestHeaders) || this.multiSession != drmConfiguration.multiSession || this.forceDefaultLicenseUri != drmConfiguration.forceDefaultLicenseUri || this.playClearContentWithoutKey != drmConfiguration.playClearContentWithoutKey || !this.sessionForClearTypes.equals(drmConfiguration.sessionForClearTypes) || !Arrays.equals(this.a, drmConfiguration.a)) {
                return false;
            }
            return true;
        }

        @Nullable
        public byte[] getKeySetId() {
            byte[] bArr = this.a;
            if (bArr != null) {
                return Arrays.copyOf(bArr, bArr.length);
            }
            return null;
        }

        public int hashCode() {
            int hashCode = this.uuid.hashCode() * 31;
            Uri uri = this.licenseUri;
            int hashCode2 = uri != null ? uri.hashCode() : 0;
            int hashCode3 = this.requestHeaders.hashCode();
            return Arrays.hashCode(this.a) + ((this.sessionForClearTypes.hashCode() + ((((((((hashCode3 + ((hashCode + hashCode2) * 31)) * 31) + (this.multiSession ? 1 : 0)) * 31) + (this.forceDefaultLicenseUri ? 1 : 0)) * 31) + (this.playClearContentWithoutKey ? 1 : 0)) * 31)) * 31);
        }
    }

    public static final class PlaybackProperties {
        @Nullable
        public final Uri adTagUri;
        @Nullable
        public final String customCacheKey;
        @Nullable
        public final DrmConfiguration drmConfiguration;
        @Nullable
        public final String mimeType;
        public final List<StreamKey> streamKeys;
        public final List<Subtitle> subtitles;
        @Nullable
        public final Object tag;
        public final Uri uri;

        public PlaybackProperties(Uri uri2, String str, DrmConfiguration drmConfiguration2, List list, String str2, List list2, Uri uri3, Object obj, a aVar) {
            this.uri = uri2;
            this.mimeType = str;
            this.drmConfiguration = drmConfiguration2;
            this.streamKeys = list;
            this.customCacheKey = str2;
            this.subtitles = list2;
            this.adTagUri = uri3;
            this.tag = obj;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PlaybackProperties)) {
                return false;
            }
            PlaybackProperties playbackProperties = (PlaybackProperties) obj;
            if (!this.uri.equals(playbackProperties.uri) || !Util.areEqual(this.mimeType, playbackProperties.mimeType) || !Util.areEqual(this.drmConfiguration, playbackProperties.drmConfiguration) || !this.streamKeys.equals(playbackProperties.streamKeys) || !Util.areEqual(this.customCacheKey, playbackProperties.customCacheKey) || !this.subtitles.equals(playbackProperties.subtitles) || !Util.areEqual(this.adTagUri, playbackProperties.adTagUri) || !Util.areEqual(this.tag, playbackProperties.tag)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = this.uri.hashCode() * 31;
            String str = this.mimeType;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            DrmConfiguration drmConfiguration2 = this.drmConfiguration;
            int hashCode3 = (this.streamKeys.hashCode() + ((hashCode2 + (drmConfiguration2 == null ? 0 : drmConfiguration2.hashCode())) * 31)) * 31;
            String str2 = this.customCacheKey;
            int hashCode4 = (this.subtitles.hashCode() + ((hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31)) * 31;
            Uri uri2 = this.adTagUri;
            int hashCode5 = (hashCode4 + (uri2 == null ? 0 : uri2.hashCode())) * 31;
            Object obj = this.tag;
            if (obj != null) {
                i = obj.hashCode();
            }
            return hashCode5 + i;
        }
    }

    public static final class Subtitle {
        @Nullable
        public final String label;
        @Nullable
        public final String language;
        public final String mimeType;
        public final int roleFlags;
        public final int selectionFlags;
        public final Uri uri;

        public Subtitle(Uri uri2, String str, @Nullable String str2) {
            this(uri2, str, str2, 0);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Subtitle)) {
                return false;
            }
            Subtitle subtitle = (Subtitle) obj;
            if (!this.uri.equals(subtitle.uri) || !this.mimeType.equals(subtitle.mimeType) || !Util.areEqual(this.language, subtitle.language) || this.selectionFlags != subtitle.selectionFlags || this.roleFlags != subtitle.roleFlags || !Util.areEqual(this.label, subtitle.label)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int B0 = a2.b.a.a.a.B0(this.mimeType, this.uri.hashCode() * 31, 31);
            String str = this.language;
            int i = 0;
            int hashCode = (((((B0 + (str == null ? 0 : str.hashCode())) * 31) + this.selectionFlags) * 31) + this.roleFlags) * 31;
            String str2 = this.label;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public Subtitle(Uri uri2, String str, @Nullable String str2, int i) {
            this(uri2, str, str2, i, 0, null);
        }

        public Subtitle(Uri uri2, String str, @Nullable String str2, int i, int i2, @Nullable String str3) {
            this.uri = uri2;
            this.mimeType = str;
            this.language = str2;
            this.selectionFlags = i;
            this.roleFlags = i2;
            this.label = str3;
        }
    }

    public MediaItem(String str, ClippingProperties clippingProperties2, PlaybackProperties playbackProperties2, MediaMetadata mediaMetadata2, a aVar) {
        this.mediaId = str;
        this.playbackProperties = playbackProperties2;
        this.mediaMetadata = mediaMetadata2;
        this.clippingProperties = clippingProperties2;
    }

    public static MediaItem fromUri(String str) {
        return new Builder().setUri(str).build();
    }

    public Builder buildUpon() {
        Builder builder = new Builder();
        ClippingProperties clippingProperties2 = this.clippingProperties;
        builder.e = clippingProperties2.endPositionMs;
        builder.f = clippingProperties2.relativeToLiveWindow;
        builder.g = clippingProperties2.relativeToDefaultPosition;
        builder.d = clippingProperties2.startPositionMs;
        builder.h = clippingProperties2.startsAtKeyFrame;
        builder.a = this.mediaId;
        builder.v = this.mediaMetadata;
        PlaybackProperties playbackProperties2 = this.playbackProperties;
        if (playbackProperties2 != null) {
            builder.t = playbackProperties2.adTagUri;
            builder.r = playbackProperties2.customCacheKey;
            builder.c = playbackProperties2.mimeType;
            builder.b = playbackProperties2.uri;
            builder.q = playbackProperties2.streamKeys;
            builder.s = playbackProperties2.subtitles;
            builder.u = playbackProperties2.tag;
            DrmConfiguration drmConfiguration = playbackProperties2.drmConfiguration;
            if (drmConfiguration != null) {
                builder.i = drmConfiguration.licenseUri;
                builder.j = drmConfiguration.requestHeaders;
                builder.l = drmConfiguration.multiSession;
                builder.n = drmConfiguration.forceDefaultLicenseUri;
                builder.m = drmConfiguration.playClearContentWithoutKey;
                builder.o = drmConfiguration.sessionForClearTypes;
                builder.k = drmConfiguration.uuid;
                builder.p = drmConfiguration.getKeySetId();
            }
        }
        return builder;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaItem)) {
            return false;
        }
        MediaItem mediaItem = (MediaItem) obj;
        if (!Util.areEqual(this.mediaId, mediaItem.mediaId) || !this.clippingProperties.equals(mediaItem.clippingProperties) || !Util.areEqual(this.playbackProperties, mediaItem.playbackProperties) || !Util.areEqual(this.mediaMetadata, mediaItem.mediaMetadata)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = this.mediaId.hashCode() * 31;
        PlaybackProperties playbackProperties2 = this.playbackProperties;
        int hashCode2 = playbackProperties2 != null ? playbackProperties2.hashCode() : 0;
        return this.mediaMetadata.hashCode() + ((this.clippingProperties.hashCode() + ((hashCode + hashCode2) * 31)) * 31);
    }

    public static MediaItem fromUri(Uri uri) {
        return new Builder().setUri(uri).build();
    }
}
