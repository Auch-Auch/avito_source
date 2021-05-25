package a2.j.b.e.a.b;

import com.google.android.play.core.internal.bv;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
public final class c0 extends bv {
    public final File a;
    public final File b;
    public final NavigableMap<Long, File> c = new TreeMap();

    public c0(File file, File file2) throws IOException {
        this.a = file;
        this.b = file2;
        ArrayList arrayList = (ArrayList) c2.a(file, file2);
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            long j = 0;
            for (int i = 0; i < size; i++) {
                File file3 = (File) arrayList.get(i);
                this.c.put(Long.valueOf(j), file3);
                j += file3.length();
            }
            return;
        }
        throw new q0(String.format("Virtualized slice archive empty for %s, %s", file, file2));
    }

    @Override // com.google.android.play.core.internal.bv
    public final long a() {
        Map.Entry<Long, File> lastEntry = this.c.lastEntry();
        return lastEntry.getValue().length() + lastEntry.getKey().longValue();
    }

    @Override // com.google.android.play.core.internal.bv
    public final InputStream a(long j, long j2) throws IOException {
        if (j < 0 || j2 < 0) {
            throw new q0(String.format("Invalid input parameters %s, %s", Long.valueOf(j), Long.valueOf(j2)));
        }
        long j3 = j + j2;
        if (j3 <= a()) {
            Long floorKey = this.c.floorKey(Long.valueOf(j));
            Long floorKey2 = this.c.floorKey(Long.valueOf(j3));
            if (floorKey.equals(floorKey2)) {
                return new b0(c(j, floorKey), j2);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(c(j, floorKey));
            for (File file : this.c.subMap(floorKey, false, floorKey2, false).values()) {
                arrayList.add(new FileInputStream(file));
            }
            arrayList.add(new b0(new FileInputStream((File) this.c.get(floorKey2)), j2 - (floorKey2.longValue() - j)));
            return new SequenceInputStream(Collections.enumeration(arrayList));
        }
        throw new q0(String.format("Trying to access archive out of bounds. Archive ends at: %s. Tried accessing: %s", Long.valueOf(a()), Long.valueOf(j3)));
    }

    public final InputStream c(long j, Long l) throws IOException {
        FileInputStream fileInputStream = new FileInputStream((File) this.c.get(l));
        if (fileInputStream.skip(j - l.longValue()) == j - l.longValue()) {
            return fileInputStream;
        }
        throw new q0(String.format("Virtualized slice archive corrupt, could not skip in file with key %s", l));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
