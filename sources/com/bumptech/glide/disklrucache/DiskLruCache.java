package com.bumptech.glide.disklrucache;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import com.avito.android.lib.design.input.FormatterType;
import com.facebook.cache.disk.DefaultDiskStorage;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
public final class DiskLruCache implements Closeable {
    public final File a;
    public final File b;
    public final File c;
    public final File d;
    public final int e;
    public long f;
    public final int g;
    public long h = 0;
    public Writer i;
    public final LinkedHashMap<String, c> j = new LinkedHashMap<>(0, 0.75f, true);
    public int k;
    public long l = 0;
    public final ThreadPoolExecutor m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));
    public final Callable<Void> n = new a();

    public final class Editor {
        public final c a;
        public final boolean[] b;
        public boolean c;

        public Editor(c cVar, a aVar) {
            boolean[] zArr;
            this.a = cVar;
            if (cVar.e) {
                zArr = null;
            } else {
                zArr = new boolean[DiskLruCache.this.g];
            }
            this.b = zArr;
        }

        public void abort() throws IOException {
            DiskLruCache.b(DiskLruCache.this, this, false);
        }

        public void abortUnlessCommitted() {
            if (!this.c) {
                try {
                    abort();
                } catch (IOException unused) {
                }
            }
        }

        public void commit() throws IOException {
            DiskLruCache.b(DiskLruCache.this, this, true);
            this.c = true;
        }

        public File getFile(int i) throws IOException {
            File file;
            synchronized (DiskLruCache.this) {
                c cVar = this.a;
                if (cVar.f == this) {
                    if (!cVar.e) {
                        this.b[i] = true;
                    }
                    file = cVar.d[i];
                    if (!DiskLruCache.this.a.exists()) {
                        DiskLruCache.this.a.mkdirs();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            return file;
        }

        public String getString(int i) throws IOException {
            FileInputStream fileInputStream;
            synchronized (DiskLruCache.this) {
                c cVar = this.a;
                if (cVar.f == this) {
                    if (cVar.e) {
                        try {
                            fileInputStream = new FileInputStream(this.a.c[i]);
                        } catch (FileNotFoundException unused) {
                        }
                    }
                    fileInputStream = null;
                } else {
                    throw new IllegalStateException();
                }
            }
            if (fileInputStream != null) {
                return DiskLruCache.a(fileInputStream);
            }
            return null;
        }

        public void set(int i, String str) throws IOException {
            Throwable th;
            OutputStreamWriter outputStreamWriter = null;
            try {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(getFile(i)), a2.d.a.b.b.b);
                try {
                    outputStreamWriter2.write(str);
                    a2.d.a.b.b.a(outputStreamWriter2);
                } catch (Throwable th2) {
                    th = th2;
                    outputStreamWriter = outputStreamWriter2;
                    a2.d.a.b.b.a(outputStreamWriter);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                a2.d.a.b.b.a(outputStreamWriter);
                throw th;
            }
        }
    }

    public final class Value {
        public final String a;
        public final long b;
        public final long[] c;
        public final File[] d;

        public Value(String str, long j, File[] fileArr, long[] jArr, a aVar) {
            this.a = str;
            this.b = j;
            this.d = fileArr;
            this.c = jArr;
        }

        public Editor edit() throws IOException {
            return DiskLruCache.this.f(this.a, this.b);
        }

        public File getFile(int i) {
            return this.d[i];
        }

        public long getLength(int i) {
            return this.c[i];
        }

        public String getString(int i) throws IOException {
            return DiskLruCache.a(new FileInputStream(this.d[i]));
        }
    }

    public class a implements Callable<Void> {
        public a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (DiskLruCache.this) {
                DiskLruCache diskLruCache = DiskLruCache.this;
                if (diskLruCache.i == null) {
                    return null;
                }
                diskLruCache.n();
                if (DiskLruCache.this.h()) {
                    DiskLruCache.this.l();
                    DiskLruCache.this.k = 0;
                }
                return null;
            }
        }
    }

    public static final class b implements ThreadFactory {
        public b(a aVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    public final class c {
        public final String a;
        public final long[] b;
        public File[] c;
        public File[] d;
        public boolean e;
        public Editor f;
        public long g;

        public c(String str, a aVar) {
            this.a = str;
            int i = DiskLruCache.this.g;
            this.b = new long[i];
            this.c = new File[i];
            this.d = new File[i];
            StringBuilder sb = new StringBuilder(str);
            sb.append(FormatterType.defaultDecimalSeparator);
            int length = sb.length();
            for (int i2 = 0; i2 < DiskLruCache.this.g; i2++) {
                sb.append(i2);
                this.c[i2] = new File(DiskLruCache.this.a, sb.toString());
                sb.append(DefaultDiskStorage.FileType.TEMP);
                this.d[i2] = new File(DiskLruCache.this.a, sb.toString());
                sb.setLength(length);
            }
        }

        public String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            long[] jArr = this.b;
            for (long j : jArr) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public final IOException b(String[] strArr) throws IOException {
            StringBuilder L = a2.b.a.a.a.L("unexpected journal line: ");
            L.append(Arrays.toString(strArr));
            throw new IOException(L.toString());
        }
    }

    public DiskLruCache(File file, int i2, int i3, long j2) {
        this.a = file;
        this.e = i2;
        this.b = new File(file, "journal");
        this.c = new File(file, "journal.tmp");
        this.d = new File(file, "journal.bkp");
        this.g = i3;
        this.f = j2;
    }

    public static String a(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, a2.d.a.b.b.b);
        try {
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[1024];
            while (true) {
                int read = inputStreamReader.read(cArr);
                if (read == -1) {
                    return stringWriter.toString();
                }
                stringWriter.write(cArr, 0, read);
            }
        } finally {
            inputStreamReader.close();
        }
    }

    public static void b(DiskLruCache diskLruCache, Editor editor, boolean z) throws IOException {
        synchronized (diskLruCache) {
            c cVar = editor.a;
            if (cVar.f == editor) {
                if (z && !cVar.e) {
                    for (int i2 = 0; i2 < diskLruCache.g; i2++) {
                        if (!editor.b[i2]) {
                            editor.abort();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                        } else if (!cVar.d[i2].exists()) {
                            editor.abort();
                            return;
                        }
                    }
                }
                for (int i3 = 0; i3 < diskLruCache.g; i3++) {
                    File file = cVar.d[i3];
                    if (!z) {
                        e(file);
                    } else if (file.exists()) {
                        File file2 = cVar.c[i3];
                        file.renameTo(file2);
                        long j2 = cVar.b[i3];
                        long length = file2.length();
                        cVar.b[i3] = length;
                        diskLruCache.h = (diskLruCache.h - j2) + length;
                    }
                }
                diskLruCache.k++;
                cVar.f = null;
                if (cVar.e || z) {
                    cVar.e = true;
                    diskLruCache.i.append((CharSequence) "CLEAN");
                    diskLruCache.i.append(' ');
                    diskLruCache.i.append((CharSequence) cVar.a);
                    diskLruCache.i.append((CharSequence) cVar.a());
                    diskLruCache.i.append('\n');
                    if (z) {
                        long j3 = diskLruCache.l;
                        diskLruCache.l = 1 + j3;
                        cVar.g = j3;
                    }
                } else {
                    diskLruCache.j.remove(cVar.a);
                    diskLruCache.i.append((CharSequence) "REMOVE");
                    diskLruCache.i.append(' ');
                    diskLruCache.i.append((CharSequence) cVar.a);
                    diskLruCache.i.append('\n');
                }
                g(diskLruCache.i);
                if (diskLruCache.h > diskLruCache.f || diskLruCache.h()) {
                    diskLruCache.m.submit(diskLruCache.n);
                }
                return;
            }
            throw new IllegalStateException();
        }
    }

    @TargetApi(26)
    public static void d(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static void e(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    @TargetApi(26)
    public static void g(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static void m(File file, File file2, boolean z) throws IOException {
        if (z) {
            e(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public static DiskLruCache open(File file, int i2, int i3, long j2) throws IOException {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i3 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    m(file2, file3, false);
                }
            }
            DiskLruCache diskLruCache = new DiskLruCache(file, i2, i3, j2);
            if (diskLruCache.b.exists()) {
                try {
                    diskLruCache.j();
                    diskLruCache.i();
                    return diskLruCache;
                } catch (IOException e2) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                    diskLruCache.delete();
                }
            }
            file.mkdirs();
            DiskLruCache diskLruCache2 = new DiskLruCache(file, i2, i3, j2);
            diskLruCache2.l();
            return diskLruCache2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    public final void c() {
        if (this.i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.i != null) {
            Iterator it = new ArrayList(this.j.values()).iterator();
            while (it.hasNext()) {
                Editor editor = ((c) it.next()).f;
                if (editor != null) {
                    editor.abort();
                }
            }
            n();
            d(this.i);
            this.i = null;
        }
    }

    public void delete() throws IOException {
        close();
        a2.d.a.b.b.b(this.a);
    }

    public Editor edit(String str) throws IOException {
        return f(str, -1);
    }

    public final synchronized Editor f(String str, long j2) throws IOException {
        c();
        c cVar = this.j.get(str);
        if (j2 != -1 && (cVar == null || cVar.g != j2)) {
            return null;
        }
        if (cVar == null) {
            cVar = new c(str, null);
            this.j.put(str, cVar);
        } else if (cVar.f != null) {
            return null;
        }
        Editor editor = new Editor(cVar, null);
        cVar.f = editor;
        this.i.append((CharSequence) "DIRTY");
        this.i.append(' ');
        this.i.append((CharSequence) str);
        this.i.append('\n');
        g(this.i);
        return editor;
    }

    public synchronized void flush() throws IOException {
        c();
        n();
        g(this.i);
    }

    public synchronized Value get(String str) throws IOException {
        c();
        c cVar = this.j.get(str);
        if (cVar == null) {
            return null;
        }
        if (!cVar.e) {
            return null;
        }
        for (File file : cVar.c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.k++;
        this.i.append((CharSequence) "READ");
        this.i.append(' ');
        this.i.append((CharSequence) str);
        this.i.append('\n');
        if (h()) {
            this.m.submit(this.n);
        }
        return new Value(str, cVar.g, cVar.c, cVar.b, null);
    }

    public File getDirectory() {
        return this.a;
    }

    public synchronized long getMaxSize() {
        return this.f;
    }

    public final boolean h() {
        int i2 = this.k;
        return i2 >= 2000 && i2 >= this.j.size();
    }

    public final void i() throws IOException {
        e(this.c);
        Iterator<c> it = this.j.values().iterator();
        while (it.hasNext()) {
            c next = it.next();
            int i2 = 0;
            if (next.f == null) {
                while (i2 < this.g) {
                    this.h += next.b[i2];
                    i2++;
                }
            } else {
                next.f = null;
                while (i2 < this.g) {
                    e(next.c[i2]);
                    e(next.d[i2]);
                    i2++;
                }
                it.remove();
            }
        }
    }

    public synchronized boolean isClosed() {
        return this.i == null;
    }

    public final void j() throws IOException {
        a2.d.a.b.a aVar = new a2.d.a.b.a(new FileInputStream(this.b), a2.d.a.b.b.a);
        try {
            String b2 = aVar.b();
            String b3 = aVar.b();
            String b4 = aVar.b();
            String b5 = aVar.b();
            String b6 = aVar.b();
            if (!"libcore.io.DiskLruCache".equals(b2) || !"1".equals(b3) || !Integer.toString(this.e).equals(b4) || !Integer.toString(this.g).equals(b5) || !"".equals(b6)) {
                throw new IOException("unexpected journal header: [" + b2 + ", " + b3 + ", " + b5 + ", " + b6 + "]");
            }
            boolean z = false;
            int i2 = 0;
            while (true) {
                try {
                    k(aVar.b());
                    i2++;
                } catch (EOFException unused) {
                    this.k = i2 - this.j.size();
                    if (aVar.e == -1) {
                        z = true;
                    }
                    if (z) {
                        l();
                    } else {
                        this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), a2.d.a.b.b.a));
                    }
                    return;
                }
            }
        } finally {
            a2.d.a.b.b.a(aVar);
        }
    }

    public final void k(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i2);
            if (indexOf2 == -1) {
                str2 = str.substring(i2);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.j.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i2, indexOf2);
            }
            c cVar = this.j.get(str2);
            if (cVar == null) {
                cVar = new c(str2, null);
                this.j.put(str2, cVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                cVar.e = true;
                cVar.f = null;
                if (split.length == DiskLruCache.this.g) {
                    for (int i3 = 0; i3 < split.length; i3++) {
                        try {
                            cVar.b[i3] = Long.parseLong(split[i3]);
                        } catch (NumberFormatException unused) {
                            cVar.b(split);
                            throw null;
                        }
                    }
                    return;
                }
                cVar.b(split);
                throw null;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                cVar.f = new Editor(cVar, null);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException(a2.b.a.a.a.c3("unexpected journal line: ", str));
            }
        } else {
            throw new IOException(a2.b.a.a.a.c3("unexpected journal line: ", str));
        }
    }

    public final synchronized void l() throws IOException {
        Writer writer = this.i;
        if (writer != null) {
            d(writer);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c), a2.d.a.b.b.a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.e));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.g));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (c cVar : this.j.values()) {
                if (cVar.f != null) {
                    bufferedWriter.write("DIRTY " + cVar.a + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + cVar.a + cVar.a() + '\n');
                }
            }
            d(bufferedWriter);
            if (this.b.exists()) {
                m(this.b, this.d, true);
            }
            m(this.c, this.b, false);
            this.d.delete();
            this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), a2.d.a.b.b.a));
        } catch (Throwable th) {
            d(bufferedWriter);
            throw th;
        }
    }

    public final void n() throws IOException {
        while (this.h > this.f) {
            remove(this.j.entrySet().iterator().next().getKey());
        }
    }

    public synchronized boolean remove(String str) throws IOException {
        c();
        c cVar = this.j.get(str);
        if (cVar != null) {
            if (cVar.f == null) {
                for (int i2 = 0; i2 < this.g; i2++) {
                    File file = cVar.c[i2];
                    if (file.exists()) {
                        if (!file.delete()) {
                            throw new IOException("failed to delete " + file);
                        }
                    }
                    long j2 = this.h;
                    long[] jArr = cVar.b;
                    this.h = j2 - jArr[i2];
                    jArr[i2] = 0;
                }
                this.k++;
                this.i.append((CharSequence) "REMOVE");
                this.i.append(' ');
                this.i.append((CharSequence) str);
                this.i.append('\n');
                this.j.remove(str);
                if (h()) {
                    this.m.submit(this.n);
                }
                return true;
            }
        }
        return false;
    }

    public synchronized void setMaxSize(long j2) {
        this.f = j2;
        this.m.submit(this.n);
    }

    public synchronized long size() {
        return this.h;
    }
}
