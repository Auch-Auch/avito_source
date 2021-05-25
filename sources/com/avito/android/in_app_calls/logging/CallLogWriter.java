package com.avito.android.in_app_calls.logging;

import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/avito/android/in_app_calls/logging/CallLogWriter;", "", "", "name", "", "attachLogFile", "(Ljava/lang/String;)V", "detachLogFile", "()V", "Lcom/avito/android/in_app_calls/logging/LogHeader;", TariffPackageInfoConverterKt.HEADER_STRING_ID, "writeHeader", "(Lcom/avito/android/in_app_calls/logging/LogHeader;)V", "message", "writeLog", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public interface CallLogWriter {
    void attachLogFile(@NotNull String str);

    void detachLogFile();

    void writeHeader(@NotNull LogHeader logHeader);

    void writeLog(@NotNull String str);
}
