package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.provider.FontRequest;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FontResourcesParserCompat {
    public static final int FETCH_STRATEGY_ASYNC = 1;
    public static final int FETCH_STRATEGY_BLOCKING = 0;
    public static final int INFINITE_TIMEOUT_VALUE = -1;

    public interface FamilyResourceEntry {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FetchStrategy {
    }

    public static final class FontFamilyFilesResourceEntry implements FamilyResourceEntry {
        @NonNull
        public final FontFileResourceEntry[] a;

        public FontFamilyFilesResourceEntry(@NonNull FontFileResourceEntry[] fontFileResourceEntryArr) {
            this.a = fontFileResourceEntryArr;
        }

        @NonNull
        public FontFileResourceEntry[] getEntries() {
            return this.a;
        }
    }

    public static final class FontFileResourceEntry {
        @NonNull
        public final String a;
        public int b;
        public boolean c;
        public String d;
        public int e;
        public int f;

        public FontFileResourceEntry(@NonNull String str, int i, boolean z, @Nullable String str2, int i2, int i3) {
            this.a = str;
            this.b = i;
            this.c = z;
            this.d = str2;
            this.e = i2;
            this.f = i3;
        }

        @NonNull
        public String getFileName() {
            return this.a;
        }

        public int getResourceId() {
            return this.f;
        }

        public int getTtcIndex() {
            return this.e;
        }

        @Nullable
        public String getVariationSettings() {
            return this.d;
        }

        public int getWeight() {
            return this.b;
        }

        public boolean isItalic() {
            return this.c;
        }
    }

    public static final class ProviderResourceEntry implements FamilyResourceEntry {
        @NonNull
        public final FontRequest a;
        public final int b;
        public final int c;

        public ProviderResourceEntry(@NonNull FontRequest fontRequest, int i, int i2) {
            this.a = fontRequest;
            this.c = i;
            this.b = i2;
        }

        public int getFetchStrategy() {
            return this.c;
        }

        @NonNull
        public FontRequest getRequest() {
            return this.a;
        }

        public int getTimeout() {
            return this.b;
        }
    }

    public static void a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }

    public static List<byte[]> b(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }

    @Nullable
    public static FamilyResourceEntry parse(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            xmlPullParser.require(2, null, "font-family");
            if (xmlPullParser.getName().equals("font-family")) {
                TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamily);
                String string = obtainAttributes.getString(R.styleable.FontFamily_fontProviderAuthority);
                String string2 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderPackage);
                String string3 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderQuery);
                int resourceId = obtainAttributes.getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
                int integer = obtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
                int integer2 = obtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, 500);
                obtainAttributes.recycle();
                if (string == null || string2 == null || string3 == null) {
                    ArrayList arrayList = new ArrayList();
                    while (xmlPullParser.next() != 3) {
                        if (xmlPullParser.getEventType() == 2) {
                            if (xmlPullParser.getName().equals("font")) {
                                TypedArray obtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamilyFont);
                                int i = R.styleable.FontFamilyFont_fontWeight;
                                if (!obtainAttributes2.hasValue(i)) {
                                    i = R.styleable.FontFamilyFont_android_fontWeight;
                                }
                                int i2 = obtainAttributes2.getInt(i, 400);
                                int i3 = R.styleable.FontFamilyFont_fontStyle;
                                if (!obtainAttributes2.hasValue(i3)) {
                                    i3 = R.styleable.FontFamilyFont_android_fontStyle;
                                }
                                boolean z = 1 == obtainAttributes2.getInt(i3, 0);
                                int i4 = R.styleable.FontFamilyFont_ttcIndex;
                                if (!obtainAttributes2.hasValue(i4)) {
                                    i4 = R.styleable.FontFamilyFont_android_ttcIndex;
                                }
                                int i5 = R.styleable.FontFamilyFont_fontVariationSettings;
                                if (!obtainAttributes2.hasValue(i5)) {
                                    i5 = R.styleable.FontFamilyFont_android_fontVariationSettings;
                                }
                                String string4 = obtainAttributes2.getString(i5);
                                int i6 = obtainAttributes2.getInt(i4, 0);
                                int i7 = R.styleable.FontFamilyFont_font;
                                if (!obtainAttributes2.hasValue(i7)) {
                                    i7 = R.styleable.FontFamilyFont_android_font;
                                }
                                int resourceId2 = obtainAttributes2.getResourceId(i7, 0);
                                String string5 = obtainAttributes2.getString(i7);
                                obtainAttributes2.recycle();
                                while (xmlPullParser.next() != 3) {
                                    a(xmlPullParser);
                                }
                                arrayList.add(new FontFileResourceEntry(string5, i2, z, string4, i6, resourceId2));
                            } else {
                                a(xmlPullParser);
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        return null;
                    }
                    return new FontFamilyFilesResourceEntry((FontFileResourceEntry[]) arrayList.toArray(new FontFileResourceEntry[arrayList.size()]));
                }
                while (xmlPullParser.next() != 3) {
                    a(xmlPullParser);
                }
                return new ProviderResourceEntry(new FontRequest(string, string2, string3, readCerts(resources, resourceId)), integer, integer2);
            }
            a(xmlPullParser);
            return null;
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> readCerts(Resources resources, @ArrayRes int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (obtainTypedArray.getType(0) == 1) {
                for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                    int resourceId = obtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        arrayList.add(b(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(b(resources.getStringArray(i)));
            }
            obtainTypedArray.recycle();
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }
}
