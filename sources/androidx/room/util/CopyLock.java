package androidx.room.util;

import a2.b.a.a.a;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class CopyLock {
    public static final Map<String, Lock> e = new HashMap();
    public final File a;
    public final Lock b;
    public final boolean c;
    public FileChannel d;

    public CopyLock(@NonNull String str, @NonNull File file, boolean z) {
        Lock lock;
        File file2 = new File(file, a.c3(str, ".lck"));
        this.a = file2;
        String absolutePath = file2.getAbsolutePath();
        Map<String, Lock> map = e;
        synchronized (map) {
            lock = map.get(absolutePath);
            if (lock == null) {
                lock = new ReentrantLock();
                map.put(absolutePath, lock);
            }
        }
        this.b = lock;
        this.c = z;
    }

    public void lock() {
        this.b.lock();
        if (this.c) {
            try {
                FileChannel channel = new FileOutputStream(this.a).getChannel();
                this.d = channel;
                channel.lock();
            } catch (IOException e2) {
                throw new IllegalStateException("Unable to grab copy lock.", e2);
            }
        }
    }

    public void unlock() {
        FileChannel fileChannel = this.d;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
        }
        this.b.unlock();
    }
}
