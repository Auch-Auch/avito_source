package com.google.firebase.installations.remote;

import a2.b.a.a.a;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.JsonReader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.trusted.sharing.ShareTarget;
import com.avito.android.social.AppleSignInManagerKt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.common.net.HttpHeaders;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.TokenResult;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
import ru.ok.android.sdk.Shared;
public class FirebaseInstallationServiceClient {
    public static final Pattern d = Pattern.compile("[0-9]+s");
    public static final Charset e = Charset.forName("UTF-8");
    public final Context a;
    public final UserAgentPublisher b;
    public final HeartBeatInfo c;

    public FirebaseInstallationServiceClient(@NonNull Context context, @Nullable UserAgentPublisher userAgentPublisher, @Nullable HeartBeatInfo heartBeatInfo) {
        this.a = context;
        this.b = userAgentPublisher;
        this.c = heartBeatInfo;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x006d: APUT  (r10v2 java.lang.Object[]), (2 ??[int, float, short, byte, char]), (r11v1 java.lang.String) */
    public static void b(HttpURLConnection httpURLConnection, @Nullable String str, @NonNull String str2, @NonNull String str3) {
        InputStream errorStream = httpURLConnection.getErrorStream();
        String str4 = null;
        if (errorStream != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, e));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append('\n');
                }
                str4 = String.format("Error when communicating with the Firebase Installations server API. HTTP response: [%d %s: %s]", Integer.valueOf(httpURLConnection.getResponseCode()), httpURLConnection.getResponseMessage(), sb);
            } catch (IOException unused) {
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
            try {
                bufferedReader.close();
            } catch (IOException unused3) {
            }
        }
        if (!TextUtils.isEmpty(str4)) {
            Object[] objArr = new Object[3];
            objArr[0] = str2;
            objArr[1] = str3;
            objArr[2] = TextUtils.isEmpty(str) ? "" : a.c3(", ", str);
            String.format("Firebase options used while communicating with Firebase server APIs: %s, %s%s", objArr);
        }
    }

    @VisibleForTesting
    public static long d(String str) {
        Preconditions.checkArgument(d.matcher(str).matches(), "Invalid Expiration Timestamp.");
        if (str == null || str.length() == 0) {
            return 0;
        }
        return Long.parseLong(str.substring(0, str.length() - 1));
    }

    public static void i(URLConnection uRLConnection, byte[] bArr) throws IOException {
        OutputStream outputStream = uRLConnection.getOutputStream();
        if (outputStream != null) {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
            try {
                gZIPOutputStream.write(bArr);
            } finally {
                try {
                    gZIPOutputStream.close();
                    outputStream.close();
                } catch (IOException unused) {
                }
            }
        } else {
            throw new IOException("Cannot send request to FIS servers. No OutputStream available.");
        }
    }

    public final URL a(String str) throws FirebaseInstallationsException {
        try {
            return new URL(String.format("https://%s/%s/%s", "firebaseinstallations.googleapis.com", "v1", str));
        } catch (MalformedURLException e2) {
            throw new FirebaseInstallationsException(e2.getMessage(), FirebaseInstallationsException.Status.UNAVAILABLE);
        }
    }

    public final HttpURLConnection c(URL url, String str) throws FirebaseInstallationsException {
        HeartBeatInfo.HeartBeat heartBeatCode;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.addRequestProperty("Content-Type", AbstractSpiCall.ACCEPT_JSON_VALUE);
            httpURLConnection.addRequestProperty("Accept", AbstractSpiCall.ACCEPT_JSON_VALUE);
            httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
            httpURLConnection.addRequestProperty(HttpHeaders.CACHE_CONTROL, "no-cache");
            httpURLConnection.addRequestProperty("X-Android-Package", this.a.getPackageName());
            HeartBeatInfo heartBeatInfo = this.c;
            if (!(heartBeatInfo == null || this.b == null || (heartBeatCode = heartBeatInfo.getHeartBeatCode("fire-installations-id")) == HeartBeatInfo.HeartBeat.NONE)) {
                httpURLConnection.addRequestProperty("x-firebase-client", this.b.getUserAgent());
                httpURLConnection.addRequestProperty("x-firebase-client-log-type", Integer.toString(heartBeatCode.getCode()));
            }
            String str2 = null;
            try {
                Context context = this.a;
                byte[] packageCertificateHashBytes = AndroidUtilsLight.getPackageCertificateHashBytes(context, context.getPackageName());
                if (packageCertificateHashBytes == null) {
                    this.a.getPackageName();
                } else {
                    str2 = Hex.bytesToStringUppercase(packageCertificateHashBytes, false);
                }
            } catch (PackageManager.NameNotFoundException unused) {
                this.a.getPackageName();
            }
            httpURLConnection.addRequestProperty("X-Android-Cert", str2);
            httpURLConnection.addRequestProperty("x-goog-api-key", str);
            return httpURLConnection;
        } catch (IOException unused2) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
        }
    }

    @NonNull
    public InstallationResponse createFirebaseInstallation(@NonNull String str, @Nullable String str2, @NonNull String str3, @NonNull String str4, @Nullable String str5) throws FirebaseInstallationsException {
        int i = 0;
        URL a3 = a(String.format("projects/%s/installations", str3));
        while (i <= 1) {
            HttpURLConnection c2 = c(a3, str);
            try {
                c2.setRequestMethod(ShareTarget.METHOD_POST);
                c2.setDoOutput(true);
                if (str5 != null) {
                    c2.addRequestProperty("x-goog-fis-android-iid-migration-auth", str5);
                }
                g(c2, str2, str4);
                int responseCode = c2.getResponseCode();
                if (responseCode == 200) {
                    InstallationResponse e2 = e(c2);
                    c2.disconnect();
                    return e2;
                }
                b(c2, str4, str, str3);
                if (responseCode != 429 && (responseCode < 500 || responseCode >= 600)) {
                    InstallationResponse build = InstallationResponse.builder().setResponseCode(InstallationResponse.ResponseCode.BAD_CONFIG).build();
                    c2.disconnect();
                    return build;
                }
                i++;
                c2.disconnect();
            } catch (IOException unused) {
            } catch (Throwable th) {
                c2.disconnect();
                throw th;
            }
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
    }

    @NonNull
    public void deleteFirebaseInstallation(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) throws FirebaseInstallationsException {
        int i = 0;
        URL a3 = a(String.format("projects/%s/installations/%s", str3, str2));
        while (i <= 1) {
            HttpURLConnection c2 = c(a3, str);
            try {
                c2.setRequestMethod("DELETE");
                c2.addRequestProperty(HttpHeaders.AUTHORIZATION, "FIS_v2 " + str4);
                int responseCode = c2.getResponseCode();
                if (!(responseCode == 200 || responseCode == 401)) {
                    if (responseCode != 404) {
                        b(c2, null, str, str3);
                        if (responseCode == 429) {
                            continue;
                        } else if (responseCode < 500 || responseCode >= 600) {
                            throw new FirebaseInstallationsException("Bad config while trying to delete FID", FirebaseInstallationsException.Status.BAD_CONFIG);
                        }
                        i++;
                        c2.disconnect();
                    }
                }
                c2.disconnect();
                return;
            } catch (IOException unused) {
            } catch (Throwable th) {
                c2.disconnect();
                throw th;
            }
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
    }

    public final InstallationResponse e(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, e));
        TokenResult.Builder builder = TokenResult.builder();
        InstallationResponse.Builder builder2 = InstallationResponse.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("name")) {
                builder2.setUri(jsonReader.nextString());
            } else if (nextName.equals("fid")) {
                builder2.setFid(jsonReader.nextString());
            } else if (nextName.equals("refreshToken")) {
                builder2.setRefreshToken(jsonReader.nextString());
            } else if (nextName.equals("authToken")) {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName2 = jsonReader.nextName();
                    if (nextName2.equals(AppleSignInManagerKt.EXTRA_APPLE_TOKEN)) {
                        builder.setToken(jsonReader.nextString());
                    } else if (nextName2.equals("expiresIn")) {
                        builder.setTokenExpirationTimestamp(d(jsonReader.nextString()));
                    } else {
                        jsonReader.skipValue();
                    }
                }
                builder2.setAuthToken(builder.build());
                jsonReader.endObject();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        return builder2.setResponseCode(InstallationResponse.ResponseCode.OK).build();
    }

    public final TokenResult f(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, e));
        TokenResult.Builder builder = TokenResult.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals(AppleSignInManagerKt.EXTRA_APPLE_TOKEN)) {
                builder.setToken(jsonReader.nextString());
            } else if (nextName.equals("expiresIn")) {
                builder.setTokenExpirationTimestamp(d(jsonReader.nextString()));
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        return builder.setResponseCode(TokenResult.ResponseCode.OK).build();
    }

    public final void g(HttpURLConnection httpURLConnection, @Nullable String str, @NonNull String str2) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fid", str);
            jSONObject.put(Shared.PARAM_APP_ID, str2);
            jSONObject.put("authVersion", "FIS_v2");
            jSONObject.put("sdkVersion", "a:16.3.3");
            i(httpURLConnection, jSONObject.toString().getBytes("UTF-8"));
        } catch (JSONException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @NonNull
    public TokenResult generateAuthToken(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) throws FirebaseInstallationsException {
        int i = 0;
        URL a3 = a(String.format("projects/%s/installations/%s/authTokens:generate", str3, str2));
        while (i <= 1) {
            HttpURLConnection c2 = c(a3, str);
            try {
                c2.setRequestMethod(ShareTarget.METHOD_POST);
                c2.addRequestProperty(HttpHeaders.AUTHORIZATION, "FIS_v2 " + str4);
                h(c2);
                int responseCode = c2.getResponseCode();
                if (responseCode == 200) {
                    TokenResult f = f(c2);
                    c2.disconnect();
                    return f;
                }
                b(c2, null, str, str3);
                if (responseCode == 401 || responseCode == 404) {
                    TokenResult build = TokenResult.builder().setResponseCode(TokenResult.ResponseCode.AUTH_ERROR).build();
                    c2.disconnect();
                    return build;
                }
                if (responseCode != 429 && (responseCode < 500 || responseCode >= 600)) {
                    TokenResult build2 = TokenResult.builder().setResponseCode(TokenResult.ResponseCode.BAD_CONFIG).build();
                    c2.disconnect();
                    return build2;
                }
                i++;
                c2.disconnect();
            } catch (IOException unused) {
            } catch (Throwable th) {
                c2.disconnect();
                throw th;
            }
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
    }

    public final void h(HttpURLConnection httpURLConnection) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sdkVersion", "a:16.3.3");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("installation", jSONObject);
            i(httpURLConnection, jSONObject2.toString().getBytes("UTF-8"));
        } catch (JSONException e2) {
            throw new IllegalStateException(e2);
        }
    }
}
