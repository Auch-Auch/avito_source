package com.avito.android.remote;

import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/MissingResponseHeaderException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "", TariffPackageInfoConverterKt.HEADER_STRING_ID, "method", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class MissingResponseHeaderException extends RuntimeException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MissingResponseHeaderException(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        super("Missing " + str + " header in response to " + str2 + ' ' + str3);
        Intrinsics.checkNotNullParameter(str, TariffPackageInfoConverterKt.HEADER_STRING_ID);
        Intrinsics.checkNotNullParameter(str2, "method");
        Intrinsics.checkNotNullParameter(str3, "url");
    }
}
