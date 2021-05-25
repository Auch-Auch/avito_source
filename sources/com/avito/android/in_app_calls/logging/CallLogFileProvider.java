package com.avito.android.in_app_calls.logging;

import com.avito.android.remote.auth.AuthSource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.c;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001d\u0010\u0013\u001a\u00020\u00048B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/in_app_calls/logging/CallLogFileProvider;", "Lcom/avito/android/in_app_calls/logging/LogFileProvider;", "", "name", "Ljava/io/File;", "provideLogFile", "(Ljava/lang/String;)Ljava/io/File;", "", "listAllLogs", "()Ljava/util/List;", "c", "Ljava/lang/String;", "logsPath", AuthSource.BOOKING_ORDER, "Ljava/io/File;", "filesRoot", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "()Ljava/io/File;", "logsDir", "<init>", "(Ljava/io/File;Ljava/lang/String;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallLogFileProvider implements LogFileProvider {
    public final Lazy a;
    public final File b;
    public final String c;

    public static final class a extends Lambda implements Function0<File> {
        public final /* synthetic */ CallLogFileProvider a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CallLogFileProvider callLogFileProvider) {
            super(0);
            this.a = callLogFileProvider;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public File invoke() {
            return new File(this.a.b, this.a.c);
        }
    }

    public CallLogFileProvider(@NotNull File file, @NotNull String str) {
        Intrinsics.checkNotNullParameter(file, "filesRoot");
        Intrinsics.checkNotNullParameter(str, "logsPath");
        this.b = file;
        this.c = str;
        this.a = c.lazy(new a(this));
    }

    public final File a() {
        return (File) this.a.getValue();
    }

    @Override // com.avito.android.in_app_calls.logging.LogFileProvider
    @NotNull
    public List<File> listAllLogs() {
        String[] list = a().list();
        if (list == null) {
            list = new String[0];
        }
        ArrayList arrayList = new ArrayList(list.length);
        for (String str : list) {
            arrayList.add(new File(a(), str));
        }
        return arrayList;
    }

    @Override // com.avito.android.in_app_calls.logging.LogFileProvider
    @NotNull
    public File provideLogFile(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        a().mkdirs();
        File file = new File(a(), a2.b.a.a.a.c3(str, ".log"));
        file.createNewFile();
        return file;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CallLogFileProvider(File file, String str, int i, j jVar) {
        this(file, (i & 2) != 0 ? "logs/calls" : str);
    }
}
