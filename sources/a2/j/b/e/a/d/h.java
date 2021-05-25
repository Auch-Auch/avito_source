package a2.j.b.e.a.d;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import com.google.android.play.core.internal.an;
import com.google.android.play.core.internal.cd;
import com.google.android.play.core.splitcompat.SplitCompat;
import com.google.android.play.core.splitinstall.b;
import com.google.android.play.core.splitinstall.v;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.List;
import java.util.Objects;
public final class h implements Runnable {
    public final /* synthetic */ List a;
    public final /* synthetic */ b b;
    public final /* synthetic */ an c;

    public h(an anVar, List list, b bVar) {
        this.c = anVar;
        this.a = list;
        this.b = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Integer num;
        FileLock fileLock;
        int i = -11;
        try {
            if (!this.c.c.a(this.a)) {
                an anVar = this.c;
                List<Intent> list = this.a;
                b bVar = this.b;
                Objects.requireNonNull(anVar);
                try {
                    FileChannel channel = new RandomAccessFile(anVar.b.b(), "rw").getChannel();
                    num = null;
                    try {
                        fileLock = channel.tryLock();
                    } catch (OverlappingFileLockException unused) {
                        fileLock = null;
                    }
                    if (fileLock != null) {
                        try {
                            for (Intent intent : list) {
                                String stringExtra = intent.getStringExtra("split_id");
                                AssetFileDescriptor openAssetFileDescriptor = anVar.a.getContentResolver().openAssetFileDescriptor(intent.getData(), "r");
                                File a3 = anVar.b.a(stringExtra);
                                if (!a3.exists() || a3.length() == openAssetFileDescriptor.getLength()) {
                                    if (!a3.exists()) {
                                    }
                                }
                                if (!anVar.b.b(stringExtra).exists()) {
                                    BufferedInputStream bufferedInputStream = new BufferedInputStream(openAssetFileDescriptor.createInputStream());
                                    try {
                                        FileOutputStream fileOutputStream = new FileOutputStream(a3);
                                        try {
                                            byte[] bArr = new byte[4096];
                                            while (true) {
                                                int read = bufferedInputStream.read(bArr);
                                                if (read <= 0) {
                                                    break;
                                                }
                                                fileOutputStream.write(bArr, 0, read);
                                            }
                                            fileOutputStream.close();
                                            bufferedInputStream.close();
                                        } catch (Throwable th) {
                                            cd.a(th, th);
                                        }
                                    } catch (Throwable th2) {
                                        cd.a(th, th2);
                                    }
                                }
                            }
                            try {
                                if (anVar.c.a()) {
                                    i = 0;
                                }
                            } catch (Exception unused2) {
                            }
                        } catch (Exception unused3) {
                            i = -13;
                        }
                        try {
                            num = Integer.valueOf(i);
                            fileLock.release();
                        } catch (Throwable th3) {
                            cd.a(th, th3);
                        }
                    }
                    if (channel != null) {
                        channel.close();
                    }
                } catch (Exception unused4) {
                    num = -13;
                }
                if (num == null) {
                    return;
                }
                if (num.intValue() == 0) {
                    bVar.b();
                    return;
                } else {
                    bVar.a(num.intValue());
                    return;
                }
            } else {
                an anVar2 = this.c;
                b bVar2 = this.b;
                try {
                    if (SplitCompat.a(v.a(anVar2.a))) {
                        bVar2.a();
                        return;
                    }
                } catch (Exception unused5) {
                }
                bVar2.a(-12);
                return;
            }
            throw th;
            throw th;
            throw th;
        } catch (Exception unused6) {
            this.b.a(-11);
        }
    }
}
