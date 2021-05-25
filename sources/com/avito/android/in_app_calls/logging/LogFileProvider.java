package com.avito.android.in_app_calls.logging;

import java.io.File;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/in_app_calls/logging/LogFileProvider;", "", "", "name", "Ljava/io/File;", "provideLogFile", "(Ljava/lang/String;)Ljava/io/File;", "", "listAllLogs", "()Ljava/util/List;", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public interface LogFileProvider {
    @NotNull
    List<File> listAllLogs();

    @NotNull
    File provideLogFile(@NotNull String str);
}
