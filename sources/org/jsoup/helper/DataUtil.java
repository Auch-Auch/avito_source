package org.jsoup.helper;

import com.google.android.exoplayer2.C;
import com.sumsub.sns.R2;
import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.UncheckedIOException;
import org.jsoup.internal.ConstrainableInputStream;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.XmlDeclaration;
import org.jsoup.parser.Parser;
public final class DataUtil {
    public static final Pattern a = Pattern.compile("(?i)\\bcharset=\\s*(?:[\"'])?([^\\s,;\"']*)");
    public static final char[] b = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public static class a {
        public final String a;
        public final boolean b;

        public a(String str, boolean z) {
            this.a = str;
            this.b = z;
        }
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = a.matcher(str);
        if (matcher.find()) {
            return d(matcher.group(1).trim().replace("charset=", ""));
        }
        return null;
    }

    public static String b() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        Random random = new Random();
        for (int i = 0; i < 32; i++) {
            char[] cArr = b;
            borrowBuilder.append(cArr[random.nextInt(cArr.length)]);
        }
        return StringUtil.releaseBuilder(borrowBuilder);
    }

    public static Document c(InputStream inputStream, String str, String str2, Parser parser) throws IOException {
        a aVar;
        Document document;
        XmlDeclaration xmlDeclaration;
        if (inputStream == null) {
            return new Document(str2);
        }
        boolean z = false;
        ConstrainableInputStream wrap = ConstrainableInputStream.wrap(inputStream, 32768, 0);
        wrap.mark(32768);
        ByteBuffer readToByteBuffer = readToByteBuffer(wrap, R2.styleable.MockView_mock_label);
        boolean z2 = wrap.read() == -1;
        wrap.reset();
        readToByteBuffer.mark();
        byte[] bArr = new byte[4];
        if (readToByteBuffer.remaining() >= 4) {
            readToByteBuffer.get(bArr);
            readToByteBuffer.rewind();
        }
        Document document2 = null;
        if ((bArr[0] == 0 && bArr[1] == 0 && bArr[2] == -2 && bArr[3] == -1) || (bArr[0] == -1 && bArr[1] == -2 && bArr[2] == 0 && bArr[3] == 0)) {
            aVar = new a("UTF-32", false);
        } else if ((bArr[0] == -2 && bArr[1] == -1) || (bArr[0] == -1 && bArr[1] == -2)) {
            aVar = new a(C.UTF16_NAME, false);
        } else {
            aVar = (bArr[0] == -17 && bArr[1] == -69 && bArr[2] == -65) ? new a("UTF-8", true) : null;
        }
        String str3 = aVar != null ? aVar.a : str;
        if (str3 == null) {
            try {
                CharBuffer decode = Charset.forName("UTF-8").decode(readToByteBuffer);
                if (decode.hasArray()) {
                    document = parser.parseInput(new CharArrayReader(decode.array()), str2);
                } else {
                    document = parser.parseInput(decode.toString(), str2);
                }
                Iterator it = document.select("meta[http-equiv=content-type], meta[charset]").iterator();
                String str4 = null;
                while (it.hasNext()) {
                    Element element = (Element) it.next();
                    if (element.hasAttr("http-equiv")) {
                        str4 = a(element.attr("content"));
                    }
                    if (str4 == null && element.hasAttr("charset")) {
                        str4 = element.attr("charset");
                        continue;
                    }
                    if (str4 != null) {
                        break;
                    }
                }
                if (str4 == null && document.childNodeSize() > 0) {
                    Node childNode = document.childNode(0);
                    if (childNode instanceof XmlDeclaration) {
                        xmlDeclaration = (XmlDeclaration) childNode;
                    } else {
                        if (childNode instanceof Comment) {
                            Comment comment = (Comment) childNode;
                            if (comment.isXmlDeclaration()) {
                                xmlDeclaration = comment.asXmlDeclaration();
                            }
                        }
                        xmlDeclaration = null;
                    }
                    if (xmlDeclaration != null && xmlDeclaration.name().equalsIgnoreCase("xml")) {
                        str4 = xmlDeclaration.attr("encoding");
                    }
                }
                String d = d(str4);
                if (d != null && !d.equalsIgnoreCase("UTF-8")) {
                    str3 = d.trim().replaceAll("[\"']", "");
                } else if (z2) {
                    document2 = document;
                }
            } catch (UncheckedIOException e) {
                throw e.ioException();
            }
        } else {
            Validate.notEmpty(str3, "Must set charset arg to character set of file to parse. Set to null to attempt to detect from HTML");
        }
        if (document2 == null) {
            if (str3 == null) {
                str3 = "UTF-8";
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(wrap, str3), 32768);
            if (aVar != null && aVar.b) {
                if (bufferedReader.skip(1) == 1) {
                    z = true;
                }
                Validate.isTrue(z);
            }
            try {
                document2 = parser.parseInput(bufferedReader, str2);
                Charset forName = Charset.forName(str3);
                document2.outputSettings().charset(forName);
                if (!forName.canEncode()) {
                    document2.charset(Charset.forName("UTF-8"));
                }
            } catch (UncheckedIOException e2) {
                throw e2.ioException();
            }
        }
        wrap.close();
        return document2;
    }

    public static String d(String str) {
        if (!(str == null || str.length() == 0)) {
            String replaceAll = str.trim().replaceAll("[\"']", "");
            try {
                if (Charset.isSupported(replaceAll)) {
                    return replaceAll;
                }
                String upperCase = replaceAll.toUpperCase(Locale.ENGLISH);
                if (Charset.isSupported(upperCase)) {
                    return upperCase;
                }
            } catch (IllegalCharsetNameException unused) {
            }
        }
        return null;
    }

    public static Document load(File file, String str, String str2) throws IOException {
        return c(new FileInputStream(file), str, str2, Parser.htmlParser());
    }

    public static ByteBuffer readToByteBuffer(InputStream inputStream, int i) throws IOException {
        Validate.isTrue(i >= 0, "maxSize must be 0 (unlimited) or larger");
        return ConstrainableInputStream.wrap(inputStream, 32768, i).readToByteBuffer(i);
    }

    public static Document load(InputStream inputStream, String str, String str2) throws IOException {
        return c(inputStream, str, str2, Parser.htmlParser());
    }

    public static Document load(InputStream inputStream, String str, String str2, Parser parser) throws IOException {
        return c(inputStream, str, str2, parser);
    }
}
