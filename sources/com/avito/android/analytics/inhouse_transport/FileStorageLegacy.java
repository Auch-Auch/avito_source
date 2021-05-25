package com.avito.android.analytics.inhouse_transport;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Process;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.File;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.c;
@Deprecated(message = "Only for removing legacy files PER-445")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001d\u0010\u000b\u001a\u00020\u00068V@\u0016X\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/analytics/inhouse_transport/FileStorageLegacy;", "Lcom/avito/android/analytics/inhouse_transport/FileStorage;", "Landroid/app/Application;", "c", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Ljava/io/File;", AuthSource.BOOKING_ORDER, "Lkotlin/Lazy;", "getEventsFolder", "()Ljava/io/File;", "eventsFolder", AuthSource.SEND_ABUSE, "Ljava/io/File;", "rootDir", "<init>", "(Landroid/app/Application;)V", "analytics-transport_release"}, k = 1, mv = {1, 4, 2})
public final class FileStorageLegacy implements FileStorage {
    public final File a;
    @NotNull
    public final Lazy b = c.lazy(new a(this));
    public final Application c;

    public static final class a extends Lambda implements Function0<File> {
        public final /* synthetic */ FileStorageLegacy a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(FileStorageLegacy fileStorageLegacy) {
            super(0);
            this.a = fileStorageLegacy;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public File invoke() {
            return FileStorageLegacy.access$tryToGetFolderByProcessName(this.a);
        }
    }

    public FileStorageLegacy(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        this.c = application;
        this.a = application.getFilesDir();
    }

    public static final File access$tryToGetFolderByProcessName(FileStorageLegacy fileStorageLegacy) {
        String str;
        String str2;
        Objects.requireNonNull(fileStorageLegacy);
        int myPid = Process.myPid();
        Object systemService = fileStorageLegacy.c.getSystemService("activity");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager activityManager = (ActivityManager) systemService;
        Iterator<ActivityManager.RunningAppProcessInfo> it = activityManager.getRunningAppProcesses().iterator();
        while (true) {
            str = null;
            if (!it.hasNext()) {
                str2 = null;
                break;
            }
            ActivityManager.RunningAppProcessInfo next = it.next();
            if (myPid == next.pid) {
                str2 = next.processName;
                break;
            }
        }
        if (str2 == null) {
            Iterator<ActivityManager.RunningServiceInfo> it2 = activityManager.getRunningServices(100).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                ActivityManager.RunningServiceInfo next2 = it2.next();
                if (myPid == next2.pid) {
                    str = next2.process;
                    break;
                }
            }
            str2 = str;
        }
        if (str2 != null) {
            File file = new File(fileStorageLegacy.a, str2);
            if (!file.exists()) {
                file.mkdir();
            }
            return file;
        }
        throw new IllegalStateException("Can not get process name to create folder");
    }

    @Override // com.avito.android.analytics.inhouse_transport.FileStorage
    @NotNull
    public File getEventsFolder() {
        return (File) this.b.getValue();
    }
}
