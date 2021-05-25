package com.google.common.net;

import com.avito.android.remote.model.category_parameters.FormattedDateDisplayingType;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.Immutable;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Map;
import kotlin.text.Typography;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Immutable
@Beta
@GwtCompatible
public final class MediaType {
    public static final MediaType AAC_AUDIO = b("audio", "aac");
    public static final MediaType ANY_APPLICATION_TYPE = b(MimeTypes.BASE_TYPE_APPLICATION, "*");
    public static final MediaType ANY_AUDIO_TYPE = b("audio", "*");
    public static final MediaType ANY_IMAGE_TYPE = b("image", "*");
    public static final MediaType ANY_TEXT_TYPE = b("text", "*");
    public static final MediaType ANY_TYPE = b("*", "*");
    public static final MediaType ANY_VIDEO_TYPE = b("video", "*");
    public static final MediaType APPLE_MOBILE_CONFIG = b(MimeTypes.BASE_TYPE_APPLICATION, "x-apple-aspen-config");
    public static final MediaType APPLE_PASSBOOK = b(MimeTypes.BASE_TYPE_APPLICATION, "vnd.apple.pkpass");
    public static final MediaType APPLICATION_BINARY = b(MimeTypes.BASE_TYPE_APPLICATION, "binary");
    public static final MediaType APPLICATION_XML_UTF_8 = c(MimeTypes.BASE_TYPE_APPLICATION, "xml");
    public static final MediaType ATOM_UTF_8 = c(MimeTypes.BASE_TYPE_APPLICATION, "atom+xml");
    public static final MediaType BASIC_AUDIO = b("audio", "basic");
    public static final MediaType BMP = b("image", "bmp");
    public static final MediaType BZIP2 = b(MimeTypes.BASE_TYPE_APPLICATION, "x-bzip2");
    public static final MediaType CACHE_MANIFEST_UTF_8 = c("text", "cache-manifest");
    public static final MediaType CRW = b("image", "x-canon-crw");
    public static final MediaType CSS_UTF_8 = c("text", "css");
    public static final MediaType CSV_UTF_8 = c("text", "csv");
    public static final MediaType DART_UTF_8 = c(MimeTypes.BASE_TYPE_APPLICATION, "dart");
    public static final MediaType EOT = b(MimeTypes.BASE_TYPE_APPLICATION, "vnd.ms-fontobject");
    public static final MediaType EPUB = b(MimeTypes.BASE_TYPE_APPLICATION, "epub+zip");
    public static final MediaType FLV_VIDEO = b("video", "x-flv");
    public static final MediaType FORM_DATA = b(MimeTypes.BASE_TYPE_APPLICATION, "x-www-form-urlencoded");
    public static final MediaType GEO_JSON = b(MimeTypes.BASE_TYPE_APPLICATION, "geo+json");
    public static final MediaType GIF = b("image", "gif");
    public static final MediaType GZIP = b(MimeTypes.BASE_TYPE_APPLICATION, "x-gzip");
    public static final MediaType HAL_JSON = b(MimeTypes.BASE_TYPE_APPLICATION, "hal+json");
    public static final MediaType HEIF = b("image", "heif");
    public static final MediaType HTML_UTF_8 = c("text", "html");
    public static final MediaType ICO = b("image", "vnd.microsoft.icon");
    public static final MediaType I_CALENDAR_UTF_8 = c("text", FormattedDateDisplayingType.TYPE_CALENDAR);
    public static final MediaType JAVASCRIPT_UTF_8 = c(MimeTypes.BASE_TYPE_APPLICATION, "javascript");
    public static final MediaType JOSE = b(MimeTypes.BASE_TYPE_APPLICATION, "jose");
    public static final MediaType JOSE_JSON = b(MimeTypes.BASE_TYPE_APPLICATION, "jose+json");
    public static final MediaType JP2K = b("image", "jp2");
    public static final MediaType JPEG = b("image", "jpeg");
    public static final MediaType JSON_UTF_8 = c(MimeTypes.BASE_TYPE_APPLICATION, "json");
    public static final MediaType KEY_ARCHIVE = b(MimeTypes.BASE_TYPE_APPLICATION, "pkcs12");
    public static final MediaType KML = b(MimeTypes.BASE_TYPE_APPLICATION, "vnd.google-earth.kml+xml");
    public static final MediaType KMZ = b(MimeTypes.BASE_TYPE_APPLICATION, "vnd.google-earth.kmz");
    public static final MediaType L16_AUDIO = b("audio", "l16");
    public static final MediaType L24_AUDIO = b("audio", "l24");
    public static final MediaType MANIFEST_JSON_UTF_8 = c(MimeTypes.BASE_TYPE_APPLICATION, "manifest+json");
    public static final MediaType MBOX = b(MimeTypes.BASE_TYPE_APPLICATION, "mbox");
    public static final MediaType MICROSOFT_EXCEL = b(MimeTypes.BASE_TYPE_APPLICATION, "vnd.ms-excel");
    public static final MediaType MICROSOFT_OUTLOOK = b(MimeTypes.BASE_TYPE_APPLICATION, "vnd.ms-outlook");
    public static final MediaType MICROSOFT_POWERPOINT = b(MimeTypes.BASE_TYPE_APPLICATION, "vnd.ms-powerpoint");
    public static final MediaType MICROSOFT_WORD = b(MimeTypes.BASE_TYPE_APPLICATION, "msword");
    public static final MediaType MP4_AUDIO = b("audio", "mp4");
    public static final MediaType MP4_VIDEO = b("video", "mp4");
    public static final MediaType MPEG_AUDIO = b("audio", "mpeg");
    public static final MediaType MPEG_VIDEO = b("video", "mpeg");
    public static final MediaType NACL_APPLICATION = b(MimeTypes.BASE_TYPE_APPLICATION, "x-nacl");
    public static final MediaType NACL_PORTABLE_APPLICATION = b(MimeTypes.BASE_TYPE_APPLICATION, "x-pnacl");
    public static final MediaType OCTET_STREAM = b(MimeTypes.BASE_TYPE_APPLICATION, "octet-stream");
    public static final MediaType OGG_AUDIO = b("audio", "ogg");
    public static final MediaType OGG_CONTAINER = b(MimeTypes.BASE_TYPE_APPLICATION, "ogg");
    public static final MediaType OGG_VIDEO = b("video", "ogg");
    public static final MediaType OOXML_DOCUMENT = b(MimeTypes.BASE_TYPE_APPLICATION, "vnd.openxmlformats-officedocument.wordprocessingml.document");
    public static final MediaType OOXML_PRESENTATION = b(MimeTypes.BASE_TYPE_APPLICATION, "vnd.openxmlformats-officedocument.presentationml.presentation");
    public static final MediaType OOXML_SHEET = b(MimeTypes.BASE_TYPE_APPLICATION, "vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    public static final MediaType OPENDOCUMENT_GRAPHICS = b(MimeTypes.BASE_TYPE_APPLICATION, "vnd.oasis.opendocument.graphics");
    public static final MediaType OPENDOCUMENT_PRESENTATION = b(MimeTypes.BASE_TYPE_APPLICATION, "vnd.oasis.opendocument.presentation");
    public static final MediaType OPENDOCUMENT_SPREADSHEET = b(MimeTypes.BASE_TYPE_APPLICATION, "vnd.oasis.opendocument.spreadsheet");
    public static final MediaType OPENDOCUMENT_TEXT = b(MimeTypes.BASE_TYPE_APPLICATION, "vnd.oasis.opendocument.text");
    public static final MediaType PDF = b(MimeTypes.BASE_TYPE_APPLICATION, "pdf");
    public static final MediaType PLAIN_TEXT_UTF_8 = c("text", "plain");
    public static final MediaType PNG = b("image", "png");
    public static final MediaType POSTSCRIPT = b(MimeTypes.BASE_TYPE_APPLICATION, "postscript");
    public static final MediaType PROTOBUF = b(MimeTypes.BASE_TYPE_APPLICATION, "protobuf");
    public static final MediaType PSD = b("image", "vnd.adobe.photoshop");
    public static final MediaType QUICKTIME = b("video", "quicktime");
    public static final MediaType RDF_XML_UTF_8 = c(MimeTypes.BASE_TYPE_APPLICATION, "rdf+xml");
    public static final MediaType RTF_UTF_8 = c(MimeTypes.BASE_TYPE_APPLICATION, "rtf");
    public static final MediaType SFNT = b(MimeTypes.BASE_TYPE_APPLICATION, "font-sfnt");
    public static final MediaType SHOCKWAVE_FLASH = b(MimeTypes.BASE_TYPE_APPLICATION, "x-shockwave-flash");
    public static final MediaType SKETCHUP = b(MimeTypes.BASE_TYPE_APPLICATION, "vnd.sketchup.skp");
    public static final MediaType SOAP_XML_UTF_8 = c(MimeTypes.BASE_TYPE_APPLICATION, "soap+xml");
    public static final MediaType SVG_UTF_8 = c("image", "svg+xml");
    public static final MediaType TAR = b(MimeTypes.BASE_TYPE_APPLICATION, "x-tar");
    public static final MediaType TEXT_JAVASCRIPT_UTF_8 = c("text", "javascript");
    public static final MediaType THREE_GPP2_VIDEO = b("video", "3gpp2");
    public static final MediaType THREE_GPP_VIDEO = b("video", "3gpp");
    public static final MediaType TIFF = b("image", "tiff");
    public static final MediaType TSV_UTF_8 = c("text", "tab-separated-values");
    public static final MediaType VCARD_UTF_8 = c("text", "vcard");
    public static final MediaType VND_REAL_AUDIO = b("audio", "vnd.rn-realaudio");
    public static final MediaType VND_WAVE_AUDIO = b("audio", "vnd.wave");
    public static final MediaType VORBIS_AUDIO = b("audio", "vorbis");
    public static final MediaType VTT_UTF_8 = c("text", "vtt");
    public static final MediaType WASM_APPLICATION = b(MimeTypes.BASE_TYPE_APPLICATION, "wasm");
    public static final MediaType WAX_AUDIO = b("audio", "x-ms-wax");
    public static final MediaType WEBM_AUDIO = b("audio", "webm");
    public static final MediaType WEBM_VIDEO = b("video", "webm");
    public static final MediaType WEBP = b("image", "webp");
    public static final MediaType WMA_AUDIO = b("audio", "x-ms-wma");
    public static final MediaType WML_UTF_8 = c("text", "vnd.wap.wml");
    public static final MediaType WMV = b("video", "x-ms-wmv");
    public static final MediaType WOFF = b(MimeTypes.BASE_TYPE_APPLICATION, "font-woff");
    public static final MediaType WOFF2 = b(MimeTypes.BASE_TYPE_APPLICATION, "font-woff2");
    public static final MediaType XHTML_UTF_8 = c(MimeTypes.BASE_TYPE_APPLICATION, "xhtml+xml");
    public static final MediaType XML_UTF_8 = c("text", "xml");
    public static final MediaType XRD_UTF_8 = c(MimeTypes.BASE_TYPE_APPLICATION, "xrd+xml");
    public static final MediaType ZIP = b(MimeTypes.BASE_TYPE_APPLICATION, "zip");
    public static final ImmutableListMultimap<String, String> g = ImmutableListMultimap.of("charset", Ascii.toLowerCase(Charsets.UTF_8.name()));
    public static final CharMatcher h = CharMatcher.ascii().and(CharMatcher.javaIsoControl().negate()).and(CharMatcher.isNot(' ')).and(CharMatcher.noneOf("()<>@,;:\\\"/[]?="));
    public static final CharMatcher i = CharMatcher.ascii().and(CharMatcher.noneOf("\"\\\r"));
    public static final CharMatcher j = CharMatcher.anyOf(" \t\r\n");
    public static final Map<MediaType, MediaType> k = Maps.newHashMap();
    public static final Joiner.MapJoiner l = Joiner.on("; ").withKeyValueSeparator("=");
    public final String a;
    public final String b;
    public final ImmutableListMultimap<String, String> c;
    @LazyInit
    public String d;
    @LazyInit
    public int e;
    @LazyInit
    public Optional<Charset> f;

    public class a implements Function<Collection<String>, ImmutableMultiset<String>> {
        public a(MediaType mediaType) {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.Function
        public ImmutableMultiset<String> apply(Collection<String> collection) {
            return ImmutableMultiset.copyOf(collection);
        }
    }

    public static final class b {
        public final String a;
        public int b = 0;

        public b(String str) {
            this.a = str;
        }

        public char a(char c) {
            Preconditions.checkState(d());
            Preconditions.checkState(e() == c);
            this.b++;
            return c;
        }

        public String b(CharMatcher charMatcher) {
            int i = this.b;
            String c = c(charMatcher);
            Preconditions.checkState(this.b != i);
            return c;
        }

        public String c(CharMatcher charMatcher) {
            Preconditions.checkState(d());
            int i = this.b;
            this.b = charMatcher.negate().indexIn(this.a, i);
            return d() ? this.a.substring(i, this.b) : this.a.substring(i);
        }

        public boolean d() {
            int i = this.b;
            return i >= 0 && i < this.a.length();
        }

        public char e() {
            Preconditions.checkState(d());
            return this.a.charAt(this.b);
        }
    }

    public MediaType(String str, String str2, ImmutableListMultimap<String, String> immutableListMultimap) {
        this.a = str;
        this.b = str2;
        this.c = immutableListMultimap;
    }

    public static MediaType a(String str, String str2, Multimap<String, String> multimap) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        Preconditions.checkNotNull(multimap);
        String d2 = d(str);
        String d3 = d(str2);
        Preconditions.checkArgument(!"*".equals(d2) || "*".equals(d3), "A wildcard type cannot be used with a non-wildcard subtype");
        ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
        for (Map.Entry<String, String> entry : multimap.entries()) {
            String d4 = d(entry.getKey());
            String value = entry.getValue();
            if ("charset".equals(d4)) {
                value = Ascii.toLowerCase(value);
            }
            builder.put((ImmutableListMultimap.Builder) d4, value);
        }
        MediaType mediaType = new MediaType(d2, d3, builder.build());
        return (MediaType) MoreObjects.firstNonNull(k.get(mediaType), mediaType);
    }

    public static MediaType b(String str, String str2) {
        MediaType mediaType = new MediaType(str, str2, ImmutableListMultimap.of());
        k.put(mediaType, mediaType);
        mediaType.f = Optional.absent();
        return mediaType;
    }

    public static MediaType c(String str, String str2) {
        MediaType mediaType = new MediaType(str, str2, g);
        k.put(mediaType, mediaType);
        mediaType.f = Optional.of(Charsets.UTF_8);
        return mediaType;
    }

    public static MediaType create(String str, String str2) {
        MediaType a3 = a(str, str2, ImmutableListMultimap.of());
        a3.f = Optional.absent();
        return a3;
    }

    public static String d(String str) {
        Preconditions.checkArgument(h.matchesAllOf(str));
        return Ascii.toLowerCase(str);
    }

    public static MediaType parse(String str) {
        String str2;
        Preconditions.checkNotNull(str);
        b bVar = new b(str);
        try {
            CharMatcher charMatcher = h;
            String b2 = bVar.b(charMatcher);
            bVar.a('/');
            String b3 = bVar.b(charMatcher);
            ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
            while (bVar.d()) {
                CharMatcher charMatcher2 = j;
                bVar.c(charMatcher2);
                bVar.a(';');
                bVar.c(charMatcher2);
                CharMatcher charMatcher3 = h;
                String b4 = bVar.b(charMatcher3);
                bVar.a('=');
                if ('\"' == bVar.e()) {
                    bVar.a(Typography.quote);
                    StringBuilder sb = new StringBuilder();
                    while ('\"' != bVar.e()) {
                        if ('\\' == bVar.e()) {
                            bVar.a('\\');
                            CharMatcher ascii = CharMatcher.ascii();
                            Preconditions.checkState(bVar.d());
                            char e2 = bVar.e();
                            Preconditions.checkState(ascii.matches(e2));
                            bVar.b++;
                            sb.append(e2);
                        } else {
                            sb.append(bVar.b(i));
                        }
                    }
                    str2 = sb.toString();
                    bVar.a(Typography.quote);
                } else {
                    str2 = bVar.b(charMatcher3);
                }
                builder.put((ImmutableListMultimap.Builder) b4, str2);
            }
            return a(b2, b3, builder.build());
        } catch (IllegalStateException e3) {
            throw new IllegalArgumentException(a2.b.a.a.a.e3("Could not parse '", str, "'"), e3);
        }
    }

    public Optional<Charset> charset() {
        Optional<Charset> optional = this.f;
        if (optional == null) {
            Optional<Charset> absent = Optional.absent();
            UnmodifiableIterator<String> it = this.c.mo118get((ImmutableListMultimap<String, String>) "charset").mo99iterator();
            String str = null;
            optional = absent;
            while (it.hasNext()) {
                String next = it.next();
                if (str == null) {
                    optional = Optional.of(Charset.forName(next));
                    str = next;
                } else if (!str.equals(next)) {
                    throw new IllegalStateException(a2.b.a.a.a.d("Multiple charset values defined: ", str, ", ", next));
                }
            }
            this.f = optional;
        }
        return optional;
    }

    public final Map<String, ImmutableMultiset<String>> e() {
        return Maps.transformValues(this.c.asMap(), new a(this));
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MediaType)) {
            return false;
        }
        MediaType mediaType = (MediaType) obj;
        if (!this.a.equals(mediaType.a) || !this.b.equals(mediaType.b) || !e().equals(mediaType.e())) {
            return false;
        }
        return true;
    }

    public boolean hasWildcard() {
        return "*".equals(this.a) || "*".equals(this.b);
    }

    public int hashCode() {
        int i2 = this.e;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = Objects.hashCode(this.a, this.b, e());
        this.e = hashCode;
        return hashCode;
    }

    public boolean is(MediaType mediaType) {
        return (mediaType.a.equals("*") || mediaType.a.equals(this.a)) && (mediaType.b.equals("*") || mediaType.b.equals(this.b)) && this.c.entries().containsAll(mediaType.c.entries());
    }

    public ImmutableListMultimap<String, String> parameters() {
        return this.c;
    }

    public String subtype() {
        return this.b;
    }

    public String toString() {
        String str = this.d;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append('/');
        sb.append(this.b);
        if (!this.c.isEmpty()) {
            sb.append("; ");
            l.appendTo(sb, (Iterable<? extends Map.Entry<?, ?>>) Multimaps.transformValues((ListMultimap) this.c, (Function) new a2.j.d.i.a(this)).entries());
        }
        String sb2 = sb.toString();
        this.d = sb2;
        return sb2;
    }

    public String type() {
        return this.a;
    }

    public MediaType withCharset(Charset charset) {
        Preconditions.checkNotNull(charset);
        MediaType withParameter = withParameter("charset", charset.name());
        withParameter.f = Optional.of(charset);
        return withParameter;
    }

    public MediaType withParameter(String str, String str2) {
        return withParameters(str, ImmutableSet.of(str2));
    }

    public MediaType withParameters(Multimap<String, String> multimap) {
        return a(this.a, this.b, multimap);
    }

    public MediaType withoutParameters() {
        return this.c.isEmpty() ? this : create(this.a, this.b);
    }

    public MediaType withParameters(String str, Iterable<String> iterable) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(iterable);
        String d2 = d(str);
        ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
        UnmodifiableIterator<Map.Entry<String, String>> it = this.c.entries().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            String key = next.getKey();
            if (!d2.equals(key)) {
                builder.put((ImmutableListMultimap.Builder) key, next.getValue());
            }
        }
        for (String str2 : iterable) {
            if ("charset".equals(d2)) {
                str2 = Ascii.toLowerCase(str2);
            }
            builder.put((ImmutableListMultimap.Builder) d2, str2);
        }
        MediaType mediaType = new MediaType(this.a, this.b, builder.build());
        if (!d2.equals("charset")) {
            mediaType.f = this.f;
        }
        return (MediaType) MoreObjects.firstNonNull(k.get(mediaType), mediaType);
    }
}
