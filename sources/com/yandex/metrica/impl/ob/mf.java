package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
public class mf {
    @NonNull
    private final Context a;
    @NonNull
    private final String b;
    private File c;
    private FileLock d;
    private RandomAccessFile e;
    private FileChannel f;

    public mf(@NonNull Context context, @NonNull String str) {
        this.a = context;
        this.b = str;
    }

    public synchronized void a() throws IOException {
        File filesDir = this.a.getFilesDir();
        this.c = new File(filesDir, new File(this.b).getName() + ".lock");
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.c, "rw");
        this.e = randomAccessFile;
        FileChannel channel = randomAccessFile.getChannel();
        this.f = channel;
        this.d = channel.lock();
    }

    public synchronized void b() {
        String str = "";
        File file = this.c;
        if (file != null) {
            str = file.getAbsolutePath();
        }
        ax.a(str, this.d);
        dl.a((Closeable) this.e);
        dl.a((Closeable) this.f);
        this.e = null;
        this.d = null;
        this.f = null;
    }
}
