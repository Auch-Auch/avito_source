package org.spongycastle.i18n;

import a2.b.a.a.a;
import com.avito.android.BuildConfig;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.TimeZone;
import org.spongycastle.i18n.filter.Filter;
import org.spongycastle.i18n.filter.TrustedInput;
import org.spongycastle.i18n.filter.UntrustedInput;
import org.spongycastle.i18n.filter.UntrustedUrlInput;
public class LocalizedMessage {
    public static final String DEFAULT_ENCODING = "ISO-8859-1";
    public FilteredArguments arguments;
    public String encoding = "ISO-8859-1";
    public FilteredArguments extraArgs = null;
    public Filter filter = null;
    public final String id;
    public ClassLoader loader = null;
    public final String resource;

    public class FilteredArguments {
        public static final int FILTER = 1;
        public static final int FILTER_URL = 2;
        public static final int NO_FILTER = 0;
        public int[] argFilterType;
        public Object[] arguments;
        public Filter filter = null;
        public Object[] filteredArgs;
        public boolean[] isLocaleSpecific;
        public Object[] unpackedArgs;

        public FilteredArguments(LocalizedMessage localizedMessage, Object[] objArr) {
            this.arguments = objArr;
            this.unpackedArgs = new Object[objArr.length];
            this.filteredArgs = new Object[objArr.length];
            this.isLocaleSpecific = new boolean[objArr.length];
            this.argFilterType = new int[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                if (objArr[i] instanceof TrustedInput) {
                    this.unpackedArgs[i] = ((TrustedInput) objArr[i]).getInput();
                    this.argFilterType[i] = 0;
                } else if (objArr[i] instanceof UntrustedInput) {
                    this.unpackedArgs[i] = ((UntrustedInput) objArr[i]).getInput();
                    if (objArr[i] instanceof UntrustedUrlInput) {
                        this.argFilterType[i] = 2;
                    } else {
                        this.argFilterType[i] = 1;
                    }
                } else {
                    this.unpackedArgs[i] = objArr[i];
                    this.argFilterType[i] = 1;
                }
                this.isLocaleSpecific[i] = this.unpackedArgs[i] instanceof LocaleString;
            }
        }

        public final Object a(int i, Object obj) {
            Filter filter2 = this.filter;
            if (filter2 != null) {
                if (obj == null) {
                    obj = BuildConfig.ADJUST_DEFAULT_TRACKER;
                }
                if (i != 0) {
                    if (i == 1) {
                        return filter2.doFilter(obj.toString());
                    }
                    if (i != 2) {
                        return null;
                    }
                    return filter2.doFilterUrl(obj.toString());
                }
            }
            return obj;
        }

        public Object[] getArguments() {
            return this.arguments;
        }

        public Filter getFilter() {
            return this.filter;
        }

        public Object[] getFilteredArgs(Locale locale) {
            Object obj;
            Object[] objArr = new Object[this.unpackedArgs.length];
            int i = 0;
            while (true) {
                Object[] objArr2 = this.unpackedArgs;
                if (i >= objArr2.length) {
                    return objArr;
                }
                Object[] objArr3 = this.filteredArgs;
                if (objArr3[i] != null) {
                    obj = objArr3[i];
                } else {
                    Object obj2 = objArr2[i];
                    if (this.isLocaleSpecific[i]) {
                        obj = a(this.argFilterType[i], ((LocaleString) obj2).getLocaleString(locale));
                    } else {
                        obj = a(this.argFilterType[i], obj2);
                        this.filteredArgs[i] = obj;
                    }
                }
                objArr[i] = obj;
                i++;
            }
        }

        public boolean isEmpty() {
            return this.unpackedArgs.length == 0;
        }

        public void setFilter(Filter filter2) {
            if (filter2 != this.filter) {
                for (int i = 0; i < this.unpackedArgs.length; i++) {
                    this.filteredArgs[i] = null;
                }
            }
            this.filter = filter2;
        }
    }

    public LocalizedMessage(String str, String str2) throws NullPointerException {
        if (str == null || str2 == null) {
            throw null;
        }
        this.id = str2;
        this.resource = str;
        this.arguments = new FilteredArguments(this, new Object[0]);
    }

    public String addExtraArgs(String str, Locale locale) {
        if (this.extraArgs == null) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        Object[] filteredArgs = this.extraArgs.getFilteredArgs(locale);
        for (Object obj : filteredArgs) {
            stringBuffer.append(obj);
        }
        return stringBuffer.toString();
    }

    public String formatWithTimeZone(String str, Object[] objArr, Locale locale, TimeZone timeZone) {
        MessageFormat messageFormat = new MessageFormat(" ");
        messageFormat.setLocale(locale);
        messageFormat.applyPattern(str);
        if (!timeZone.equals(TimeZone.getDefault())) {
            Format[] formats = messageFormat.getFormats();
            for (int i = 0; i < formats.length; i++) {
                if (formats[i] instanceof DateFormat) {
                    DateFormat dateFormat = (DateFormat) formats[i];
                    dateFormat.setTimeZone(timeZone);
                    messageFormat.setFormat(i, dateFormat);
                }
            }
        }
        return messageFormat.format(objArr);
    }

    public Object[] getArguments() {
        return this.arguments.getArguments();
    }

    public ClassLoader getClassLoader() {
        return this.loader;
    }

    public String getEntry(String str, Locale locale, TimeZone timeZone) throws MissingEntryException {
        ResourceBundle resourceBundle;
        String str2 = this.id;
        if (str != null) {
            str2 = a.e3(str2, ".", str);
        }
        try {
            ClassLoader classLoader = this.loader;
            if (classLoader == null) {
                resourceBundle = ResourceBundle.getBundle(this.resource, locale);
            } else {
                resourceBundle = ResourceBundle.getBundle(this.resource, locale, classLoader);
            }
            String string = resourceBundle.getString(str2);
            if (!this.encoding.equals("ISO-8859-1")) {
                string = new String(string.getBytes("ISO-8859-1"), this.encoding);
            }
            if (!this.arguments.isEmpty()) {
                string = formatWithTimeZone(string, this.arguments.getFilteredArgs(locale), locale, timeZone);
            }
            return addExtraArgs(string, locale);
        } catch (MissingResourceException unused) {
            String t = a.t(a.R("Can't find entry ", str2, " in resource file "), this.resource, ".");
            String str3 = this.resource;
            ClassLoader classLoader2 = this.loader;
            if (classLoader2 == null) {
                classLoader2 = getClassLoader();
            }
            throw new MissingEntryException(t, str3, str2, locale, classLoader2);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public Object[] getExtraArgs() {
        FilteredArguments filteredArguments = this.extraArgs;
        if (filteredArguments == null) {
            return null;
        }
        return filteredArguments.getArguments();
    }

    public Filter getFilter() {
        return this.filter;
    }

    public String getId() {
        return this.id;
    }

    public String getResource() {
        return this.resource;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.loader = classLoader;
    }

    public void setExtraArgument(Object obj) {
        setExtraArguments(new Object[]{obj});
    }

    public void setExtraArguments(Object[] objArr) {
        if (objArr != null) {
            FilteredArguments filteredArguments = new FilteredArguments(this, objArr);
            this.extraArgs = filteredArguments;
            filteredArguments.setFilter(this.filter);
            return;
        }
        this.extraArgs = null;
    }

    public void setFilter(Filter filter2) {
        this.arguments.setFilter(filter2);
        FilteredArguments filteredArguments = this.extraArgs;
        if (filteredArguments != null) {
            filteredArguments.setFilter(filter2);
        }
        this.filter = filter2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Resource: \"");
        stringBuffer.append(this.resource);
        stringBuffer.append("\" Id: \"");
        stringBuffer.append(this.id);
        stringBuffer.append("\"");
        stringBuffer.append(" Arguments: ");
        stringBuffer.append(this.arguments.getArguments().length);
        stringBuffer.append(" normal");
        FilteredArguments filteredArguments = this.extraArgs;
        if (filteredArguments != null && filteredArguments.getArguments().length > 0) {
            stringBuffer.append(", ");
            stringBuffer.append(this.extraArgs.getArguments().length);
            stringBuffer.append(" extra");
        }
        stringBuffer.append(" Encoding: ");
        stringBuffer.append(this.encoding);
        stringBuffer.append(" ClassLoader: ");
        stringBuffer.append(this.loader);
        return stringBuffer.toString();
    }

    public LocalizedMessage(String str, String str2, String str3) throws NullPointerException, UnsupportedEncodingException {
        if (str == null || str2 == null) {
            throw null;
        }
        this.id = str2;
        this.resource = str;
        this.arguments = new FilteredArguments(this, new Object[0]);
        if (Charset.isSupported(str3)) {
            this.encoding = str3;
            return;
        }
        throw new UnsupportedEncodingException(a.e3("The encoding \"", str3, "\" is not supported."));
    }

    public LocalizedMessage(String str, String str2, Object[] objArr) throws NullPointerException {
        if (str == null || str2 == null || objArr == null) {
            throw null;
        }
        this.id = str2;
        this.resource = str;
        this.arguments = new FilteredArguments(this, objArr);
    }

    public LocalizedMessage(String str, String str2, String str3, Object[] objArr) throws NullPointerException, UnsupportedEncodingException {
        if (str == null || str2 == null || objArr == null) {
            throw null;
        }
        this.id = str2;
        this.resource = str;
        this.arguments = new FilteredArguments(this, objArr);
        if (Charset.isSupported(str3)) {
            this.encoding = str3;
            return;
        }
        throw new UnsupportedEncodingException(a.e3("The encoding \"", str3, "\" is not supported."));
    }
}
