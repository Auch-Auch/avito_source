package org.spongycastle.i18n;

import a2.b.a.a.a;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
public class MissingEntryException extends RuntimeException {
    public String a;
    public final String key;
    public final ClassLoader loader;
    public final Locale locale;
    public final String resource;

    public MissingEntryException(String str, String str2, String str3, Locale locale2, ClassLoader classLoader) {
        super(str);
        this.resource = str2;
        this.key = str3;
        this.locale = locale2;
        this.loader = classLoader;
    }

    public ClassLoader getClassLoader() {
        return this.loader;
    }

    public String getDebugMsg() {
        if (this.a == null) {
            StringBuilder L = a.L("Can not find entry ");
            L.append(this.key);
            L.append(" in resource file ");
            L.append(this.resource);
            L.append(" for the locale ");
            L.append(this.locale);
            L.append(".");
            this.a = L.toString();
            ClassLoader classLoader = this.loader;
            if (classLoader instanceof URLClassLoader) {
                URL[] uRLs = ((URLClassLoader) classLoader).getURLs();
                this.a = a.t(new StringBuilder(), this.a, " The following entries in the classpath were searched: ");
                for (int i = 0; i != uRLs.length; i++) {
                    this.a += uRLs[i] + " ";
                }
            }
        }
        return this.a;
    }

    public String getKey() {
        return this.key;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public String getResource() {
        return this.resource;
    }

    public MissingEntryException(String str, Throwable th, String str2, String str3, Locale locale2, ClassLoader classLoader) {
        super(str, th);
        this.resource = str2;
        this.key = str3;
        this.locale = locale2;
        this.loader = classLoader;
    }
}
