package a2.j.b.a.b;

import a2.j.b.a.b.d;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.browser.trusted.sharing.ShareTarget;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.cct.a.zza;
import com.google.android.datatransport.cct.a.zzb;
import com.google.android.datatransport.cct.a.zzo;
import com.google.android.datatransport.cct.a.zzp;
import com.google.android.datatransport.cct.a.zzq;
import com.google.android.datatransport.cct.a.zzr;
import com.google.android.datatransport.cct.a.zzs;
import com.google.android.datatransport.cct.a.zzt;
import com.google.android.datatransport.cct.a.zzu;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.retries.Function;
import com.google.android.datatransport.runtime.retries.Retries;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.common.net.HttpHeaders;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
public final class d implements TransportBackend {
    public final DataEncoder a = new JsonDataEncoderBuilder().configureWith(zzb.zza).ignoreNullValues(true).build();
    public final ConnectivityManager b;
    public final URL c;
    public final Clock d;
    public final Clock e;
    public final int f;

    public static final class a {
        public final URL a;
        public final zzo b;
        @Nullable
        public final String c;

        public a(URL url, zzo zzo, @Nullable String str) {
            this.a = url;
            this.b = zzo;
            this.c = str;
        }
    }

    public static final class b {
        public final int a;
        @Nullable
        public final URL b;
        public final long c;

        public b(int i, @Nullable URL url, long j) {
            this.a = i;
            this.b = url;
            this.c = j;
        }
    }

    public d(Context context, Clock clock, Clock clock2) {
        this.b = (ConnectivityManager) context.getSystemService("connectivity");
        this.c = a(CCTDestination.c);
        this.d = clock2;
        this.e = clock;
        this.f = MpegAudioUtil.MAX_RATE_BYTES_PER_SECOND;
    }

    public static URL a(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException(a2.b.a.a.a.c3("Invalid url: ", str), e2);
        }
    }

    @Override // com.google.android.datatransport.runtime.backends.TransportBackend
    public EventInternal decorate(EventInternal eventInternal) {
        int i;
        int i2;
        NetworkInfo activeNetworkInfo = this.b.getActiveNetworkInfo();
        EventInternal.Builder addMetadata = eventInternal.toBuilder().addMetadata("sdk-version", Build.VERSION.SDK_INT).addMetadata(VerticalFilterCloseDialogEventKt.MODEL_DIALOG, Build.MODEL).addMetadata("hardware", Build.HARDWARE).addMetadata("device", Build.DEVICE).addMetadata(BaseAnalyticKt.ANALYTIC_MODULE_PRODUCT, Build.PRODUCT).addMetadata("os-uild", Build.ID).addMetadata("manufacturer", Build.MANUFACTURER).addMetadata("fingerprint", Build.FINGERPRINT);
        Calendar.getInstance();
        EventInternal.Builder addMetadata2 = addMetadata.addMetadata("tz-offset", (long) (TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000));
        if (activeNetworkInfo == null) {
            i = zzt.zzc.zzs.zza();
        } else {
            i = activeNetworkInfo.getType();
        }
        EventInternal.Builder addMetadata3 = addMetadata2.addMetadata("net-type", i);
        if (activeNetworkInfo == null) {
            i2 = zzt.zzb.zza.zza();
        } else {
            i2 = activeNetworkInfo.getSubtype();
            if (i2 == -1) {
                i2 = zzt.zzb.zzu.zza();
            } else if (zzt.zzb.zza(i2) == null) {
                i2 = 0;
            }
        }
        return addMetadata3.addMetadata("mobile-subtype", i2).build();
    }

    @Override // com.google.android.datatransport.runtime.backends.TransportBackend
    public BackendResponse send(BackendRequest backendRequest) {
        zzq.zza zza;
        HashMap hashMap = new HashMap();
        for (EventInternal eventInternal : backendRequest.getEvents()) {
            String transportName = eventInternal.getTransportName();
            if (!hashMap.containsKey(transportName)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(eventInternal);
                hashMap.put(transportName, arrayList);
            } else {
                ((List) hashMap.get(transportName)).add(eventInternal);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            EventInternal eventInternal2 = (EventInternal) ((List) entry.getValue()).get(0);
            zzr.zza zza2 = zzr.zza().zza(zzu.zza).zza(this.e.getTime()).zzb(this.d.getTime()).zza(zzp.zza().zza(zzp.zzb.zzb).zza(zza.zza().zza(Integer.valueOf(eventInternal2.getInteger("sdk-version"))).zze(eventInternal2.get(VerticalFilterCloseDialogEventKt.MODEL_DIALOG)).zzc(eventInternal2.get("hardware")).zza(eventInternal2.get("device")).zzg(eventInternal2.get(BaseAnalyticKt.ANALYTIC_MODULE_PRODUCT)).zzf(eventInternal2.get("os-uild")).zzd(eventInternal2.get("manufacturer")).zzb(eventInternal2.get("fingerprint")).zza()).zza());
            try {
                zza2.zza(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                zza2.zzb((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (EventInternal eventInternal3 : (List) entry.getValue()) {
                EncodedPayload encodedPayload = eventInternal3.getEncodedPayload();
                Encoding encoding = encodedPayload.getEncoding();
                if (encoding.equals(Encoding.of("proto"))) {
                    zza = zzq.zza(encodedPayload.getBytes());
                } else if (encoding.equals(Encoding.of("json"))) {
                    zza = zzq.zza(new String(encodedPayload.getBytes(), Charset.forName("UTF-8")));
                } else {
                    Logging.w("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", encoding);
                }
                zza.zza(eventInternal3.getEventMillis()).zzb(eventInternal3.getUptimeMillis()).zzc(eventInternal3.getLong("tz-offset")).zza(zzt.zza().zza(zzt.zzc.zza(eventInternal3.getInteger("net-type"))).zza(zzt.zzb.zza(eventInternal3.getInteger("mobile-subtype"))).zza());
                if (eventInternal3.getCode() != null) {
                    zza.zza(eventInternal3.getCode());
                }
                arrayList3.add(zza.zza());
            }
            zza2.zza(arrayList3);
            arrayList2.add(zza2.zza());
        }
        zzo zza3 = zzo.zza(arrayList2);
        String str = null;
        URL url = this.c;
        if (backendRequest.getExtras() != null) {
            try {
                CCTDestination fromByteArray = CCTDestination.fromByteArray(backendRequest.getExtras());
                if (fromByteArray.getAPIKey() != null) {
                    str = fromByteArray.getAPIKey();
                }
                if (fromByteArray.getEndPoint() != null) {
                    url = a(fromByteArray.getEndPoint());
                }
            } catch (IllegalArgumentException unused2) {
                return BackendResponse.fatalError();
            }
        }
        try {
            b bVar = (b) Retries.retry(5, new a(url, zza3, str), new Function(this) { // from class: a2.j.b.a.b.b
                public final d a;

                {
                    this.a = r1;
                }

                @Override // com.google.android.datatransport.runtime.retries.Function
                public Object apply(Object obj) {
                    d dVar = this.a;
                    d.a aVar = (d.a) obj;
                    Objects.requireNonNull(dVar);
                    Logging.d("CctTransportBackend", "Making request to: %s", aVar.a);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) aVar.a.openConnection();
                    httpURLConnection.setConnectTimeout(HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT);
                    httpURLConnection.setReadTimeout(dVar.f);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setInstanceFollowRedirects(false);
                    httpURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
                    httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", "2.3.1"));
                    httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
                    httpURLConnection.setRequestProperty("Content-Type", AbstractSpiCall.ACCEPT_JSON_VALUE);
                    httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "gzip");
                    String str2 = aVar.c;
                    if (str2 != null) {
                        httpURLConnection.setRequestProperty("X-Goog-Api-Key", str2);
                    }
                    try {
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        try {
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                            try {
                                dVar.a.encode(aVar.b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                                gZIPOutputStream.close();
                                if (outputStream != null) {
                                    outputStream.close();
                                }
                                int responseCode = httpURLConnection.getResponseCode();
                                Logging.i("CctTransportBackend", "Status Code: " + responseCode);
                                Logging.i("CctTransportBackend", "Content-Type: " + httpURLConnection.getHeaderField("Content-Type"));
                                Logging.i("CctTransportBackend", "Content-Encoding: " + httpURLConnection.getHeaderField("Content-Encoding"));
                                if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                                    return new d.b(responseCode, new URL(httpURLConnection.getHeaderField(HttpHeaders.LOCATION)), 0);
                                }
                                if (responseCode != 200) {
                                    return new d.b(responseCode, null, 0);
                                }
                                InputStream inputStream = httpURLConnection.getInputStream();
                                try {
                                    InputStream gZIPInputStream = "gzip".equals(httpURLConnection.getHeaderField("Content-Encoding")) ? new GZIPInputStream(inputStream) : inputStream;
                                    try {
                                        d.b bVar2 = new d.b(responseCode, null, zzs.zza(new BufferedReader(new InputStreamReader(gZIPInputStream))).zza());
                                        if (gZIPInputStream != null) {
                                            gZIPInputStream.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        return bVar2;
                                    } catch (Throwable unused3) {
                                    }
                                } catch (Throwable unused4) {
                                }
                            } catch (Throwable unused5) {
                            }
                            throw th;
                            throw th;
                            throw th;
                            throw th;
                        } catch (Throwable unused6) {
                        }
                    } catch (ConnectException | UnknownHostException e2) {
                        Logging.e("CctTransportBackend", "Couldn't open connection, returning with 500", e2);
                        return new d.b(500, null, 0);
                    } catch (EncodingException | IOException e3) {
                        Logging.e("CctTransportBackend", "Couldn't encode request, returning with 400", e3);
                        return new d.b(400, null, 0);
                    }
                }
            }, c.a);
            int i = bVar.a;
            if (i == 200) {
                return BackendResponse.ok(bVar.c);
            }
            if (i < 500) {
                if (i != 404) {
                    return BackendResponse.fatalError();
                }
            }
            return BackendResponse.transientError();
        } catch (IOException e2) {
            Logging.e("CctTransportBackend", "Could not make request to the backend", e2);
            return BackendResponse.transientError();
        }
    }
}
