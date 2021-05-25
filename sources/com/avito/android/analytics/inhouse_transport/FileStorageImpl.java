package com.avito.android.analytics.inhouse_transport;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Process;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.File;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001d\u0010\u000e\u001a\u00020\u00068V@\u0016X\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/avito/android/analytics/inhouse_transport/FileStorageImpl;", "Lcom/avito/android/analytics/inhouse_transport/FileStorage;", "Landroid/app/Application;", "c", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Ljava/io/File;", AuthSource.SEND_ABUSE, "Ljava/io/File;", "rootDir", AuthSource.BOOKING_ORDER, "Lkotlin/Lazy;", "getEventsFolder", "()Ljava/io/File;", "eventsFolder", "", "fileName", "<init>", "(Landroid/app/Application;Ljava/lang/String;)V", "analytics-transport_release"}, k = 1, mv = {1, 4, 2})
public final class FileStorageImpl implements FileStorage {
    public final File a;
    @NotNull
    public final Lazy b;
    public final Application c;

    public static final class a extends Lambda implements Function0<File> {
        public final /* synthetic */ FileStorageImpl a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(FileStorageImpl fileStorageImpl, String str) {
            super(0);
            this.a = fileStorageImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public File invoke() {
            return FileStorageImpl.access$tryToGetFolderByProcessName(this.a, this.b);
        }
    }

    public FileStorageImpl(@NotNull Application application, @NotNull String str) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(str, "fileName");
        this.c = application;
        this.a = application.getFilesDir();
        this.b = c.lazy(new a(this, str));
    }

    public static final File access$tryToGetFolderByProcessName(FileStorageImpl fileStorageImpl, String str) {
        String str2;
        String str3;
        Objects.requireNonNull(fileStorageImpl);
        int myPid = Process.myPid();
        Object systemService = fileStorageImpl.c.getSystemService("activity");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager activityManager = (ActivityManager) systemService;
        Iterator<ActivityManager.RunningAppProcessInfo> it = activityManager.getRunningAppProcesses().iterator();
        while (true) {
            str2 = null;
            if (!it.hasNext()) {
                str3 = null;
                break;
            }
            ActivityManager.RunningAppProcessInfo next = it.next();
            if (myPid == next.pid) {
                str3 = next.processName;
                break;
            }
        }
        if (str3 == null) {
            Iterator<ActivityManager.RunningServiceInfo> it2 = activityManager.getRunningServices(100).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                ActivityManager.RunningServiceInfo next2 = it2.next();
                if (myPid == next2.pid) {
                    str2 = next2.process;
                    break;
                }
            }
            str3 = str2;
        }
        if (str3 != null) {
            File file = new File(fileStorageImpl.a, a2.b.a.a.a.L2(str3, '_', str));
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
