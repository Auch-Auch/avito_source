package kotlinx.coroutines.internal;

import a2.b.a.a.a;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005J1\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/internal/FastServiceLoader;", "", "", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "loadMainDispatcherFactory$kotlinx_coroutines_core", "()Ljava/util/List;", "loadMainDispatcherFactory", ExifInterface.LATITUDE_SOUTH, "Ljava/lang/Class;", NotificationCompat.CATEGORY_SERVICE, "Ljava/lang/ClassLoader;", "loader", "loadProviders$kotlinx_coroutines_core", "(Ljava/lang/Class;Ljava/lang/ClassLoader;)Ljava/util/List;", "loadProviders", "Ljava/io/BufferedReader;", "r", "", AuthSource.SEND_ABUSE, "(Ljava/io/BufferedReader;)Ljava/util/List;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public final class FastServiceLoader {
    public static final FastServiceLoader INSTANCE = new FastServiceLoader();

    public final List<String> a(BufferedReader bufferedReader) {
        boolean z;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return CollectionsKt___CollectionsKt.toList(linkedHashSet);
            }
            String substringBefore$default = StringsKt__StringsKt.substringBefore$default(readLine, "#", (String) null, 2, (Object) null);
            Objects.requireNonNull(substringBefore$default, "null cannot be cast to non-null type kotlin.CharSequence");
            String obj = StringsKt__StringsKt.trim(substringBefore$default).toString();
            boolean z2 = false;
            int i = 0;
            while (true) {
                if (i >= obj.length()) {
                    z = true;
                    break;
                }
                char charAt = obj.charAt(i);
                if (!(charAt == '.' || Character.isJavaIdentifierPart(charAt))) {
                    z = false;
                    break;
                }
                i++;
            }
            if (z) {
                if (obj.length() > 0) {
                    z2 = true;
                }
                if (z2) {
                    linkedHashSet.add(obj);
                }
            } else {
                throw new IllegalArgumentException(a.c3("Illegal service provider class name: ", obj).toString());
            }
        }
    }

    @NotNull
    public final List<MainDispatcherFactory> loadMainDispatcherFactory$kotlinx_coroutines_core() {
        ClassLoader classLoader;
        List<MainDispatcherFactory> list;
        MainDispatcherFactory mainDispatcherFactory;
        if (!FastServiceLoaderKt.getANDROID_DETECTED()) {
            ClassLoader classLoader2 = MainDispatcherFactory.class.getClassLoader();
            try {
                return loadProviders$kotlinx_coroutines_core(MainDispatcherFactory.class, classLoader2);
            } catch (Throwable unused) {
                return CollectionsKt___CollectionsKt.toList(ServiceLoader.load(MainDispatcherFactory.class, classLoader2));
            }
        } else {
            try {
                ArrayList arrayList = new ArrayList(2);
                MainDispatcherFactory mainDispatcherFactory2 = null;
                try {
                    mainDispatcherFactory = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (ClassNotFoundException unused2) {
                    mainDispatcherFactory = null;
                }
                if (mainDispatcherFactory != null) {
                    arrayList.add(mainDispatcherFactory);
                }
                try {
                    mainDispatcherFactory2 = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (ClassNotFoundException unused3) {
                }
                if (mainDispatcherFactory2 == null) {
                    return arrayList;
                }
                arrayList.add(mainDispatcherFactory2);
                return arrayList;
            } catch (Throwable unused4) {
                list = CollectionsKt___CollectionsKt.toList(ServiceLoader.load(MainDispatcherFactory.class, classLoader));
            }
        }
        return list;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0082, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0083, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0086, code lost:
        throw r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0089, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008d, code lost:
        throw r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008e, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008f, code lost:
        t6.b.addSuppressed(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0092, code lost:
        throw r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b0, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b1, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b4, code lost:
        throw r11;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <S> java.util.List<S> loadProviders$kotlinx_coroutines_core(@org.jetbrains.annotations.NotNull java.lang.Class<S> r10, @org.jetbrains.annotations.NotNull java.lang.ClassLoader r11) {
        /*
        // Method dump skipped, instructions count: 303
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.FastServiceLoader.loadProviders$kotlinx_coroutines_core(java.lang.Class, java.lang.ClassLoader):java.util.List");
    }
}
