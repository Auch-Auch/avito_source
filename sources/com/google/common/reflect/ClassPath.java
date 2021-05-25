package com.google.common.reflect;

import com.avito.android.lib.design.input.FormatterType;
import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.base.StandardSystemProperty;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;
import com.google.common.io.Resources;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
public final class ClassPath {
    public static final Logger b = Logger.getLogger(ClassPath.class.getName());
    public static final Predicate<ClassInfo> c = new a();
    public static final Splitter d = Splitter.on(" ").omitEmptyStrings();
    public final ImmutableSet<ResourceInfo> a;

    @Beta
    public static final class ClassInfo extends ResourceInfo {
        public final String c;

        public ClassInfo(String str, ClassLoader classLoader) {
            super(str, classLoader);
            Logger logger = ClassPath.b;
            this.c = str.substring(0, str.length() - 6).replace('/', FormatterType.defaultDecimalSeparator);
        }

        public String getName() {
            return this.c;
        }

        public String getPackageName() {
            return Reflection.getPackageName(this.c);
        }

        public String getSimpleName() {
            int lastIndexOf = this.c.lastIndexOf(36);
            if (lastIndexOf != -1) {
                return CharMatcher.digit().trimLeadingFrom(this.c.substring(lastIndexOf + 1));
            }
            String packageName = getPackageName();
            if (packageName.isEmpty()) {
                return this.c;
            }
            return this.c.substring(packageName.length() + 1);
        }

        public Class<?> load() {
            try {
                return this.b.loadClass(this.c);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.common.reflect.ClassPath.ResourceInfo
        public String toString() {
            return this.c;
        }
    }

    @Beta
    public static class ResourceInfo {
        public final String a;
        public final ClassLoader b;

        public ResourceInfo(String str, ClassLoader classLoader) {
            this.a = (String) Preconditions.checkNotNull(str);
            this.b = (ClassLoader) Preconditions.checkNotNull(classLoader);
        }

        public final ByteSource asByteSource() {
            return Resources.asByteSource(url());
        }

        public final CharSource asCharSource(Charset charset) {
            return Resources.asCharSource(url(), charset);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ResourceInfo)) {
                return false;
            }
            ResourceInfo resourceInfo = (ResourceInfo) obj;
            if (!this.a.equals(resourceInfo.a) || this.b != resourceInfo.b) {
                return false;
            }
            return true;
        }

        public final String getResourceName() {
            return this.a;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return this.a;
        }

        public final URL url() {
            URL resource = this.b.getResource(this.a);
            if (resource != null) {
                return resource;
            }
            throw new NoSuchElementException(this.a);
        }
    }

    public static class a implements Predicate<ClassInfo> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.Predicate
        public boolean apply(ClassInfo classInfo) {
            return classInfo.c.indexOf(36) == -1;
        }
    }

    @VisibleForTesting
    public static final class b extends c {
        public final SetMultimap<ClassLoader, String> b = MultimapBuilder.hashKeys().linkedHashSetValues().mo108build();

        public final void d(File file, ClassLoader classLoader, String str, Set<File> set) throws IOException {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                ClassPath.b.warning("Cannot read directory " + file);
                return;
            }
            for (File file2 : listFiles) {
                String name = file2.getName();
                if (file2.isDirectory()) {
                    File canonicalFile = file2.getCanonicalFile();
                    if (set.add(canonicalFile)) {
                        d(canonicalFile, classLoader, a2.b.a.a.a.e3(str, name, "/"), set);
                        set.remove(canonicalFile);
                    }
                } else {
                    String c3 = a2.b.a.a.a.c3(str, name);
                    if (!c3.equals("META-INF/MANIFEST.MF")) {
                        this.b.mo118get((SetMultimap<ClassLoader, String>) classLoader).add(c3);
                    }
                }
            }
        }
    }

    public static abstract class c {
        public final Set<File> a = Sets.newHashSet();

        @VisibleForTesting
        public static ImmutableMap<File, ClassLoader> a(ClassLoader classLoader) {
            ImmutableList immutableList;
            LinkedHashMap newLinkedHashMap = Maps.newLinkedHashMap();
            ClassLoader parent = classLoader.getParent();
            if (parent != null) {
                newLinkedHashMap.putAll(a(parent));
            }
            if (classLoader instanceof URLClassLoader) {
                immutableList = ImmutableList.copyOf(((URLClassLoader) classLoader).getURLs());
            } else if (classLoader.equals(ClassLoader.getSystemClassLoader())) {
                ImmutableList.Builder builder = ImmutableList.builder();
                for (String str : Splitter.on(StandardSystemProperty.PATH_SEPARATOR.value()).split(StandardSystemProperty.JAVA_CLASS_PATH.value())) {
                    try {
                        builder.add((ImmutableList.Builder) new File(str).toURI().toURL());
                    } catch (SecurityException unused) {
                        try {
                            builder.add((ImmutableList.Builder) new URL("file", (String) null, new File(str).getAbsolutePath()));
                        } catch (MalformedURLException e) {
                            Logger logger = ClassPath.b;
                            Level level = Level.WARNING;
                            logger.log(level, "malformed classpath entry: " + str, (Throwable) e);
                        }
                    }
                }
                immutableList = builder.build();
            } else {
                immutableList = ImmutableList.of();
            }
            UnmodifiableIterator it = immutableList.mo99iterator();
            while (it.hasNext()) {
                URL url = (URL) it.next();
                if (url.getProtocol().equals("file")) {
                    File a3 = ClassPath.a(url);
                    if (!newLinkedHashMap.containsKey(a3)) {
                        newLinkedHashMap.put(a3, classLoader);
                    }
                }
            }
            return ImmutableMap.copyOf(newLinkedHashMap);
        }

        @VisibleForTesting
        public static ImmutableSet<File> b(File file, @NullableDecl Manifest manifest) {
            if (manifest == null) {
                return ImmutableSet.of();
            }
            ImmutableSet.Builder builder = ImmutableSet.builder();
            String value = manifest.getMainAttributes().getValue(Attributes.Name.CLASS_PATH.toString());
            if (value != null) {
                for (String str : ClassPath.d.split(value)) {
                    try {
                        URL url = new URL(file.toURI().toURL(), str);
                        if (url.getProtocol().equals("file")) {
                            builder.add((ImmutableSet.Builder) ClassPath.a(url));
                        }
                    } catch (MalformedURLException unused) {
                        Logger logger = ClassPath.b;
                        logger.warning("Invalid Class-Path entry: " + str);
                    }
                }
            }
            return builder.build();
        }

        @VisibleForTesting
        public final void c(File file, ClassLoader classLoader) throws IOException {
            if (this.a.add(file.getCanonicalFile())) {
                try {
                    if (file.exists()) {
                        if (file.isDirectory()) {
                            HashSet hashSet = new HashSet();
                            hashSet.add(file.getCanonicalFile());
                            ((b) this).d(file, classLoader, "", hashSet);
                            return;
                        }
                        try {
                            JarFile jarFile = new JarFile(file);
                            try {
                                UnmodifiableIterator<File> it = b(file, jarFile.getManifest()).mo99iterator();
                                while (it.hasNext()) {
                                    c(it.next(), classLoader);
                                }
                                b bVar = (b) this;
                                Enumeration<JarEntry> entries = jarFile.entries();
                                while (entries.hasMoreElements()) {
                                    JarEntry nextElement = entries.nextElement();
                                    if (!nextElement.isDirectory()) {
                                        if (!nextElement.getName().equals("META-INF/MANIFEST.MF")) {
                                            bVar.b.mo118get((SetMultimap<ClassLoader, String>) classLoader).add(nextElement.getName());
                                        }
                                    }
                                }
                                jarFile.close();
                            } catch (Throwable th) {
                                try {
                                    jarFile.close();
                                } catch (IOException unused) {
                                }
                                throw th;
                            }
                        } catch (IOException unused2) {
                        }
                    }
                } catch (SecurityException e) {
                    Logger logger = ClassPath.b;
                    logger.warning("Cannot access " + file + ": " + e);
                }
            }
        }
    }

    public ClassPath(ImmutableSet<ResourceInfo> immutableSet) {
        this.a = immutableSet;
    }

    @VisibleForTesting
    public static File a(URL url) {
        Preconditions.checkArgument(url.getProtocol().equals("file"));
        try {
            return new File(url.toURI());
        } catch (URISyntaxException unused) {
            return new File(url.getPath());
        }
    }

    public static ClassPath from(ClassLoader classLoader) throws IOException {
        Object obj;
        b bVar = new b();
        UnmodifiableIterator<Map.Entry<File, ClassLoader>> it = c.a(classLoader).entrySet().mo99iterator();
        while (it.hasNext()) {
            Map.Entry<File, ClassLoader> next = it.next();
            bVar.c(next.getKey(), next.getValue());
        }
        ImmutableSet.Builder builder = ImmutableSet.builder();
        for (Map.Entry<ClassLoader, String> entry : bVar.b.entries()) {
            String value = entry.getValue();
            ClassLoader key = entry.getKey();
            if (value.endsWith(".class")) {
                obj = new ClassInfo(value, key);
            } else {
                obj = new ResourceInfo(value, key);
            }
            builder.add((ImmutableSet.Builder) obj);
        }
        return new ClassPath(builder.build());
    }

    public ImmutableSet<ClassInfo> getAllClasses() {
        return FluentIterable.from(this.a).filter(ClassInfo.class).toSet();
    }

    public ImmutableSet<ResourceInfo> getResources() {
        return this.a;
    }

    public ImmutableSet<ClassInfo> getTopLevelClasses() {
        return FluentIterable.from(this.a).filter(ClassInfo.class).filter(c).toSet();
    }

    public ImmutableSet<ClassInfo> getTopLevelClassesRecursive(String str) {
        Preconditions.checkNotNull(str);
        String str2 = str + FormatterType.defaultDecimalSeparator;
        ImmutableSet.Builder builder = ImmutableSet.builder();
        UnmodifiableIterator<ClassInfo> it = getTopLevelClasses().mo99iterator();
        while (it.hasNext()) {
            ClassInfo next = it.next();
            if (next.getName().startsWith(str2)) {
                builder.add((ImmutableSet.Builder) next);
            }
        }
        return builder.build();
    }

    public ImmutableSet<ClassInfo> getTopLevelClasses(String str) {
        Preconditions.checkNotNull(str);
        ImmutableSet.Builder builder = ImmutableSet.builder();
        UnmodifiableIterator<ClassInfo> it = getTopLevelClasses().mo99iterator();
        while (it.hasNext()) {
            ClassInfo next = it.next();
            if (next.getPackageName().equals(str)) {
                builder.add((ImmutableSet.Builder) next);
            }
        }
        return builder.build();
    }
}
