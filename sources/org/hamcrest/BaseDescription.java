package org.hamcrest;

import com.avito.android.BuildConfig;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.text.Typography;
import org.hamcrest.internal.ArrayIterator;
import org.hamcrest.internal.SelfDescribingValueIterator;
public abstract class BaseDescription implements Description {
    public final Description a(String str, String str2, String str3, Iterator<? extends SelfDescribing> it) {
        append(str);
        boolean z = false;
        while (it.hasNext()) {
            if (z) {
                append(str2);
            }
            appendDescriptionOf((SelfDescribing) it.next());
            z = true;
        }
        append(str3);
        return this;
    }

    public abstract void append(char c);

    public void append(String str) {
        for (int i = 0; i < str.length(); i++) {
            append(str.charAt(i));
        }
    }

    @Override // org.hamcrest.Description
    public Description appendDescriptionOf(SelfDescribing selfDescribing) {
        selfDescribing.describeTo(this);
        return this;
    }

    @Override // org.hamcrest.Description
    public Description appendList(String str, String str2, String str3, Iterable<? extends SelfDescribing> iterable) {
        a(str, str2, str3, iterable.iterator());
        return this;
    }

    @Override // org.hamcrest.Description
    public Description appendText(String str) {
        append(str);
        return this;
    }

    @Override // org.hamcrest.Description
    public Description appendValue(Object obj) {
        if (obj == null) {
            append(BuildConfig.ADJUST_DEFAULT_TRACKER);
        } else if (obj instanceof String) {
            String str = (String) obj;
            append(Typography.quote);
            for (int i = 0; i < str.length(); i++) {
                c(str.charAt(i));
            }
            append(Typography.quote);
        } else if (obj instanceof Character) {
            append(Typography.quote);
            c(((Character) obj).charValue());
            append(Typography.quote);
        } else if (obj instanceof Short) {
            append(Typography.less);
            append(b(obj));
            append("s>");
        } else if (obj instanceof Long) {
            append(Typography.less);
            append(b(obj));
            append("L>");
        } else if (obj instanceof Float) {
            append(Typography.less);
            append(b(obj));
            append("F>");
        } else if (obj.getClass().isArray()) {
            a("[", ", ", "]", new SelfDescribingValueIterator(new ArrayIterator(obj)));
        } else {
            append(Typography.less);
            append(b(obj));
            append(Typography.greater);
        }
        return this;
    }

    @Override // org.hamcrest.Description
    public <T> Description appendValueList(String str, String str2, String str3, T... tArr) {
        return appendValueList(str, str2, str3, Arrays.asList(tArr));
    }

    public final String b(Object obj) {
        try {
            return String.valueOf(obj);
        } catch (Exception unused) {
            return obj.getClass().getName() + "@" + Integer.toHexString(obj.hashCode());
        }
    }

    public final void c(char c) {
        if (c == '\t') {
            append("\\t");
        } else if (c == '\n') {
            append("\\n");
        } else if (c == '\r') {
            append("\\r");
        } else if (c != '\"') {
            append(c);
        } else {
            append("\\\"");
        }
    }

    @Override // org.hamcrest.Description
    public <T> Description appendValueList(String str, String str2, String str3, Iterable<T> iterable) {
        a(str, str2, str3, new SelfDescribingValueIterator(iterable.iterator()));
        return this;
    }
}
