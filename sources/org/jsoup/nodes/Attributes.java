package org.jsoup.nodes;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.text.Typography;
import org.jsoup.SerializationException;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.parser.ParseSettings;
public class Attributes implements Iterable<Attribute>, Cloneable {
    public static final String[] d = new String[0];
    public static final String dataPrefix = "data-";
    public int a = 0;
    public String[] b;
    public String[] c;

    public class a implements Iterator<Attribute> {
        public int a = 0;

        public a() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (true) {
                int i = this.a;
                Attributes attributes = Attributes.this;
                if (i >= attributes.a || !attributes.f(attributes.b[i])) {
                    break;
                }
                this.a++;
            }
            if (this.a < Attributes.this.a) {
                return true;
            }
            return false;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public Attribute next() {
            Attributes attributes = Attributes.this;
            String[] strArr = attributes.b;
            int i = this.a;
            Attribute attribute = new Attribute(strArr[i], attributes.c[i], attributes);
            this.a++;
            return attribute;
        }

        @Override // java.util.Iterator
        public void remove() {
            Attributes attributes = Attributes.this;
            int i = this.a - 1;
            this.a = i;
            attributes.h(i);
        }
    }

    public static class b extends AbstractMap<String, String> {
        public final Attributes a;

        public class a implements Iterator<Map.Entry<String, String>> {
            public Iterator<Attribute> a;
            public Attribute b;

            public a(a aVar) {
                this.a = b.this.a.iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                while (this.a.hasNext()) {
                    Attribute next = this.a.next();
                    this.b = next;
                    if (next.isDataAttribute()) {
                        return true;
                    }
                }
                return false;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.Iterator
            public Map.Entry<String, String> next() {
                return new Attribute(this.b.getKey().substring(5), this.b.getValue());
            }

            @Override // java.util.Iterator
            public void remove() {
                b.this.a.remove(this.b.getKey());
            }
        }

        /* renamed from: org.jsoup.nodes.Attributes$b$b  reason: collision with other inner class name */
        public class C0546b extends AbstractSet<Map.Entry<String, String>> {
            public C0546b(a aVar) {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public Iterator<Map.Entry<String, String>> iterator() {
                return new a(null);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                int i = 0;
                while (new a(null).hasNext()) {
                    i++;
                }
                return i;
            }
        }

        public b(Attributes attributes, a aVar) {
            this.a = attributes;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<String, String>> entrySet() {
            return new C0546b(null);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object put(Object obj, Object obj2) {
            String str = (String) obj2;
            String c3 = a2.b.a.a.a.c3(Attributes.dataPrefix, (String) obj);
            String str2 = this.a.hasKey(c3) ? this.a.get(c3) : null;
            this.a.put(c3, str);
            return str2;
        }
    }

    public Attributes() {
        String[] strArr = d;
        this.b = strArr;
        this.c = strArr;
    }

    public static String[] b(String[] strArr, int i) {
        String[] strArr2 = new String[i];
        System.arraycopy(strArr, 0, strArr2, 0, Math.min(strArr.length, i));
        return strArr2;
    }

    public final void a(int i) {
        Validate.isTrue(i >= this.a);
        String[] strArr = this.b;
        int length = strArr.length;
        if (length < i) {
            int i2 = 2;
            if (length >= 2) {
                i2 = this.a * 2;
            }
            if (i <= i2) {
                i = i2;
            }
            this.b = b(strArr, i);
            this.c = b(this.c, i);
        }
    }

    public Attributes add(String str, String str2) {
        a(this.a + 1);
        String[] strArr = this.b;
        int i = this.a;
        strArr[i] = str;
        this.c[i] = str2;
        this.a = i + 1;
        return this;
    }

    public void addAll(Attributes attributes) {
        if (attributes.size() != 0) {
            a(this.a + attributes.a);
            Iterator<Attribute> it = attributes.iterator();
            while (it.hasNext()) {
                put(it.next());
            }
        }
    }

    public List<Attribute> asList() {
        ArrayList arrayList = new ArrayList(this.a);
        for (int i = 0; i < this.a; i++) {
            if (!f(this.b[i])) {
                arrayList.add(new Attribute(this.b[i], this.c[i], this));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final void c(Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        int i = this.a;
        for (int i2 = 0; i2 < i; i2++) {
            if (!f(this.b[i2])) {
                String str = this.b[i2];
                String str2 = this.c[i2];
                appendable.append(' ').append(str);
                if (!Attribute.shouldCollapseAttribute(str, str2, outputSettings)) {
                    appendable.append("=\"");
                    if (str2 == null) {
                        str2 = "";
                    }
                    Entities.b(appendable, str2, outputSettings, true, false, false);
                    appendable.append(Typography.quote);
                }
            }
        }
    }

    public int d(String str) {
        Validate.notNull(str);
        for (int i = 0; i < this.a; i++) {
            if (str.equals(this.b[i])) {
                return i;
            }
        }
        return -1;
    }

    public Map<String, String> dataset() {
        return new b(this, null);
    }

    public int deduplicate(ParseSettings parseSettings) {
        int i = 0;
        if (isEmpty()) {
            return 0;
        }
        boolean preserveAttributeCase = parseSettings.preserveAttributeCase();
        int i2 = 0;
        while (i < this.b.length) {
            int i3 = i + 1;
            int i4 = i3;
            while (true) {
                String[] strArr = this.b;
                if (i4 >= strArr.length || strArr[i4] == null) {
                    break;
                }
                if (!preserveAttributeCase || !strArr[i].equals(strArr[i4])) {
                    if (!preserveAttributeCase) {
                        String[] strArr2 = this.b;
                        if (!strArr2[i].equalsIgnoreCase(strArr2[i4])) {
                        }
                    }
                    i4++;
                }
                i2++;
                h(i4);
                i4--;
                i4++;
            }
            i = i3;
        }
        return i2;
    }

    public final int e(String str) {
        Validate.notNull(str);
        for (int i = 0; i < this.a; i++) {
            if (str.equalsIgnoreCase(this.b[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Attributes attributes = (Attributes) obj;
        if (this.a == attributes.a && Arrays.equals(this.b, attributes.b)) {
            return Arrays.equals(this.c, attributes.c);
        }
        return false;
    }

    public final boolean f(String str) {
        return str != null && str.length() > 1 && str.charAt(0) == '/';
    }

    public void g(String str, String str2) {
        int e = e(str);
        if (e != -1) {
            this.c[e] = str2;
            if (!this.b[e].equals(str)) {
                this.b[e] = str;
                return;
            }
            return;
        }
        add(str, str2);
    }

    public String get(String str) {
        String str2;
        int d2 = d(str);
        if (d2 == -1 || (str2 = this.c[d2]) == null) {
            return "";
        }
        return str2;
    }

    public String getIgnoreCase(String str) {
        String str2;
        int e = e(str);
        if (e == -1 || (str2 = this.c[e]) == null) {
            return "";
        }
        return str2;
    }

    public final void h(int i) {
        Validate.isFalse(i >= this.a);
        int i2 = (this.a - i) - 1;
        if (i2 > 0) {
            String[] strArr = this.b;
            int i3 = i + 1;
            System.arraycopy(strArr, i3, strArr, i, i2);
            String[] strArr2 = this.c;
            System.arraycopy(strArr2, i3, strArr2, i, i2);
        }
        int i4 = this.a - 1;
        this.a = i4;
        this.b[i4] = null;
        this.c[i4] = null;
    }

    public boolean hasDeclaredValueForKey(String str) {
        int d2 = d(str);
        return (d2 == -1 || this.c[d2] == null) ? false : true;
    }

    public boolean hasDeclaredValueForKeyIgnoreCase(String str) {
        int e = e(str);
        return (e == -1 || this.c[e] == null) ? false : true;
    }

    public boolean hasKey(String str) {
        return d(str) != -1;
    }

    public boolean hasKeyIgnoreCase(String str) {
        return e(str) != -1;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (((this.a * 31) + Arrays.hashCode(this.b)) * 31) + Arrays.hashCode(this.c);
    }

    public String html() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        try {
            c(borrowBuilder, new Document("").outputSettings());
            return StringUtil.releaseBuilder(borrowBuilder);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    public boolean isEmpty() {
        return this.a == 0;
    }

    @Override // java.lang.Iterable
    public Iterator<Attribute> iterator() {
        return new a();
    }

    public void normalize() {
        for (int i = 0; i < this.a; i++) {
            String[] strArr = this.b;
            strArr[i] = Normalizer.lowerCase(strArr[i]);
        }
    }

    public Attributes put(String str, String str2) {
        Validate.notNull(str);
        int d2 = d(str);
        if (d2 != -1) {
            this.c[d2] = str2;
        } else {
            add(str, str2);
        }
        return this;
    }

    public void remove(String str) {
        int d2 = d(str);
        if (d2 != -1) {
            h(d2);
        }
    }

    public void removeIgnoreCase(String str) {
        int e = e(str);
        if (e != -1) {
            h(e);
        }
    }

    public int size() {
        int i = 0;
        for (int i2 = 0; i2 < this.a; i2++) {
            if (!f(this.b[i2])) {
                i++;
            }
        }
        return i;
    }

    @Override // java.lang.Object
    public String toString() {
        return html();
    }

    @Override // java.lang.Object
    public Attributes clone() {
        try {
            Attributes attributes = (Attributes) super.clone();
            attributes.a = this.a;
            this.b = b(this.b, this.a);
            this.c = b(this.c, this.a);
            return attributes;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public Attributes put(String str, boolean z) {
        if (z) {
            g(str, null);
        } else {
            remove(str);
        }
        return this;
    }

    public Attributes put(Attribute attribute) {
        Validate.notNull(attribute);
        put(attribute.getKey(), attribute.getValue());
        attribute.c = this;
        return this;
    }
}
