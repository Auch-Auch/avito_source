package com.google.android.exoplayer2.metadata.icy;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.metadata.SimpleMetadataDecoder;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Charsets;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public final class IcyDecoder extends SimpleMetadataDecoder {
    public static final Pattern c = Pattern.compile("(.+?)='(.*?)';", 32);
    public final CharsetDecoder a = Charsets.UTF_8.newDecoder();
    public final CharsetDecoder b = Charsets.ISO_8859_1.newDecoder();

    /* JADX INFO: finally extract failed */
    @Override // com.google.android.exoplayer2.metadata.SimpleMetadataDecoder
    public Metadata decode(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        String str;
        String str2 = null;
        try {
            str = this.a.decode(byteBuffer).toString();
        } catch (CharacterCodingException unused) {
            try {
                str = this.b.decode(byteBuffer).toString();
                this.b.reset();
                byteBuffer.rewind();
            } catch (CharacterCodingException unused2) {
                this.b.reset();
                byteBuffer.rewind();
                str = null;
            } catch (Throwable th) {
                this.b.reset();
                byteBuffer.rewind();
                throw th;
            }
        } finally {
            this.a.reset();
            byteBuffer.rewind();
        }
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        if (str == null) {
            return new Metadata(new IcyInfo(bArr, null, null));
        }
        Matcher matcher = c.matcher(str);
        String str3 = null;
        for (int i = 0; matcher.find(i); i = matcher.end()) {
            String lowerInvariant = Util.toLowerInvariant(matcher.group(1));
            String group = matcher.group(2);
            if (lowerInvariant != null) {
                if (lowerInvariant.equals("streamurl")) {
                    str3 = group;
                } else if (lowerInvariant.equals("streamtitle")) {
                    str2 = group;
                }
            }
        }
        return new Metadata(new IcyInfo(bArr, str2, str3));
    }
}
