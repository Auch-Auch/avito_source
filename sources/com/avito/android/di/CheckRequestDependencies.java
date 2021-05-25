package com.avito.android.di;

import com.google.gson.Gson;
import kotlin.Metadata;
import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/di/CheckRequestDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lokhttp3/CertificatePinner;", "pinner", "()Lokhttp3/CertificatePinner;", "Lcom/google/gson/Gson;", "gson", "()Lcom/google/gson/Gson;", "Lokhttp3/OkHttpClient;", "httpClient", "()Lokhttp3/OkHttpClient;", "application_release"}, k = 1, mv = {1, 4, 2})
public interface CheckRequestDependencies extends CoreComponentDependencies {
    @Override // com.avito.android.push.MessagingDependencies
    @NotNull
    Gson gson();

    @NotNull
    OkHttpClient httpClient();

    @NotNull
    CertificatePinner pinner();
}
