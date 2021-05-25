package com.avito.android.in_app_calls.logging;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.avito.android.util.CloseablesKt;
import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0006R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/in_app_calls/logging/CallLogWriterImpl;", "Lcom/avito/android/in_app_calls/logging/CallLogWriter;", "", "name", "", "attachLogFile", "(Ljava/lang/String;)V", "detachLogFile", "()V", "Lcom/avito/android/in_app_calls/logging/LogHeader;", TariffPackageInfoConverterKt.HEADER_STRING_ID, "writeHeader", "(Lcom/avito/android/in_app_calls/logging/LogHeader;)V", "message", "writeLog", "Lcom/avito/android/in_app_calls/logging/LogFileProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/in_app_calls/logging/LogFileProvider;", "logFileProvider", "Ljava/io/BufferedWriter;", AuthSource.SEND_ABUSE, "Ljava/io/BufferedWriter;", "bufferedFileWriter", "Lcom/avito/android/in_app_calls/logging/LogFormatter;", "c", "Lcom/avito/android/in_app_calls/logging/LogFormatter;", "logFormatter", "Lcom/google/gson/Gson;", "d", "Lcom/google/gson/Gson;", "gson", "<init>", "(Lcom/avito/android/in_app_calls/logging/LogFileProvider;Lcom/avito/android/in_app_calls/logging/LogFormatter;Lcom/google/gson/Gson;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallLogWriterImpl implements CallLogWriter {
    public BufferedWriter a;
    public final LogFileProvider b;
    public final LogFormatter c;
    public final Gson d;

    @Inject
    public CallLogWriterImpl(@NotNull LogFileProvider logFileProvider, @NotNull LogFormatter logFormatter, @NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(logFileProvider, "logFileProvider");
        Intrinsics.checkNotNullParameter(logFormatter, "logFormatter");
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.b = logFileProvider;
        this.c = logFormatter;
        this.d = gson;
    }

    @Override // com.avito.android.in_app_calls.logging.CallLogWriter
    public void attachLogFile(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(this.b.provideLogFile(str)), Charsets.UTF_8);
        this.a = outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
    }

    @Override // com.avito.android.in_app_calls.logging.CallLogWriter
    public void detachLogFile() {
        BufferedWriter bufferedWriter = this.a;
        if (bufferedWriter != null) {
            CloseablesKt.closeQuiet(bufferedWriter);
        }
    }

    @Override // com.avito.android.in_app_calls.logging.CallLogWriter
    public void writeHeader(@NotNull LogHeader logHeader) {
        Intrinsics.checkNotNullParameter(logHeader, TariffPackageInfoConverterKt.HEADER_STRING_ID);
        try {
            BufferedWriter bufferedWriter = this.a;
            if (bufferedWriter != null) {
                bufferedWriter.write(this.d.toJson(logHeader));
                bufferedWriter.newLine();
                bufferedWriter.newLine();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.avito.android.in_app_calls.logging.CallLogWriter
    public void writeLog(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        try {
            BufferedWriter bufferedWriter = this.a;
            if (bufferedWriter != null) {
                bufferedWriter.write(this.c.format(str));
            }
        } catch (Throwable unused) {
        }
    }
}
