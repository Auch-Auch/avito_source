package com.google.firebase.crashlytics.internal.log;

import a2.j.e.d.d.b.c;
import android.content.Context;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.File;
import java.util.Set;
public class LogFileManager {
    public static final b d = new b(null);
    public final Context a;
    public final DirectoryProvider b;
    public a2.j.e.d.d.b.a c;

    public interface DirectoryProvider {
        File getLogFileDir();
    }

    public static final class b implements a2.j.e.d.d.b.a {
        public b(a aVar) {
        }

        @Override // a2.j.e.d.d.b.a
        public byte[] a() {
            return null;
        }

        @Override // a2.j.e.d.d.b.a
        public void b() {
        }

        @Override // a2.j.e.d.d.b.a
        public void c(long j, String str) {
        }

        @Override // a2.j.e.d.d.b.a
        public void d() {
        }

        @Override // a2.j.e.d.d.b.a
        public String e() {
            return null;
        }
    }

    public LogFileManager(Context context, DirectoryProvider directoryProvider) {
        this(context, directoryProvider, null);
    }

    public void clearLog() {
        this.c.b();
    }

    public void discardOldLogFiles(Set<String> set) {
        File[] listFiles = this.b.getLogFileDir().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                String name = file.getName();
                int lastIndexOf = name.lastIndexOf(".temp");
                if (lastIndexOf != -1) {
                    name = name.substring(20, lastIndexOf);
                }
                if (!set.contains(name)) {
                    file.delete();
                }
            }
        }
    }

    public byte[] getBytesForLog() {
        return this.c.a();
    }

    @Nullable
    public String getLogString() {
        return this.c.e();
    }

    public final void setCurrentSession(String str) {
        this.c.d();
        this.c = d;
        if (str != null) {
            if (!CommonUtils.getBooleanResourceValue(this.a, "com.crashlytics.CollectCustomLogs", true)) {
                Logger.getLogger().d("Preferences requested no custom logs. Aborting log file creation.");
                return;
            }
            this.c = new c(new File(this.b.getLogFileDir(), a2.b.a.a.a.e3("crashlytics-userlog-", str, ".temp")), 65536);
        }
    }

    public void writeToLog(long j, String str) {
        this.c.c(j, str);
    }

    public LogFileManager(Context context, DirectoryProvider directoryProvider, String str) {
        this.a = context;
        this.b = directoryProvider;
        this.c = d;
        setCurrentSession(str);
    }
}
