package a2.g.r;

import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache;
import com.facebook.internal.Logger;
import java.io.File;
import java.util.PriorityQueue;
public class c implements Runnable {
    public final /* synthetic */ FileLruCache a;

    public c(FileLruCache fileLruCache) {
        this.a = fileLruCache;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        long j;
        FileLruCache fileLruCache = this.a;
        synchronized (fileLruCache.e) {
            i = 0;
            fileLruCache.d = false;
        }
        try {
            Logger.log(LoggingBehavior.CACHE, "FileLruCache", "trim started");
            PriorityQueue priorityQueue = new PriorityQueue();
            File[] listFiles = fileLruCache.c.listFiles(FileLruCache.c.a);
            long j2 = 0;
            if (listFiles != null) {
                j = 0;
                for (int length = listFiles.length; i < length; length = length) {
                    File file = listFiles[i];
                    FileLruCache.f fVar = new FileLruCache.f(file);
                    priorityQueue.add(fVar);
                    Logger.log(LoggingBehavior.CACHE, "FileLruCache", "  trim considering time=" + Long.valueOf(fVar.b) + " name=" + fVar.a.getName());
                    j2 += file.length();
                    j++;
                    i++;
                }
            } else {
                j = 0;
            }
            while (true) {
                FileLruCache.Limits limits = fileLruCache.b;
                if (j2 > ((long) limits.a) || j > ((long) limits.b)) {
                    File file2 = ((FileLruCache.f) priorityQueue.remove()).a;
                    Logger.log(LoggingBehavior.CACHE, "FileLruCache", "  trim removing " + file2.getName());
                    j2 -= file2.length();
                    j--;
                    file2.delete();
                } else {
                    synchronized (fileLruCache.e) {
                        fileLruCache.e.notifyAll();
                    }
                    return;
                }
            }
        } catch (Throwable th) {
            synchronized (fileLruCache.e) {
                fileLruCache.e.notifyAll();
                throw th;
            }
        }
    }
}
