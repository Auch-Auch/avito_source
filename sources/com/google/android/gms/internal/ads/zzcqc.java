package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.IOUtils;
import com.google.common.net.HttpHeaders;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
public final class zzcqc implements zzdoq<zzcqb, zzcqe> {
    private final String zzdqr;
    private final zzatc zzgiy;
    private final String zzgjo;
    private final int zzgjp;
    private final Context zzvr;

    public zzcqc(Context context, String str, zzatc zzatc, String str2, int i) {
        this.zzvr = context;
        this.zzgjo = str;
        this.zzgiy = zzatc;
        this.zzdqr = str2;
        this.zzgjp = i;
    }

    private final zzcqe zza(String str, zzasv zzasv, JSONObject jSONObject, String str2) throws zzcmt {
        byte[] bArr;
        zzbax zzbax;
        int responseCode;
        InputStreamReader inputStreamReader;
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        Throwable th2;
        String str3 = "doritos_v2";
        String str4 = "doritos";
        String str5 = "";
        try {
        } catch (IOException e) {
            String valueOf = String.valueOf(e.getMessage());
            String concat = valueOf.length() != 0 ? "Error while connecting to ad server: ".concat(valueOf) : new String("Error while connecting to ad server: ");
            zzbbd.zzfe(concat);
            throw new zzcmt(zzdmd.zzhco, concat, e);
        }
        if (zzasv.getErrorCode() == -2) {
            zzcqe zzcqe = new zzcqe();
            String valueOf2 = String.valueOf(this.zzgjo);
            zzbbd.zzfd(valueOf2.length() != 0 ? "SDK version: ".concat(valueOf2) : new String("SDK version: "));
            String valueOf3 = String.valueOf(str);
            zzbbd.zzef(valueOf3.length() != 0 ? "AdRequestServiceImpl: Sending request: ".concat(valueOf3) : new String("AdRequestServiceImpl: Sending request: "));
            URL url = new URL(str);
            HashMap hashMap = new HashMap();
            long elapsedRealtime = zzp.zzkw().elapsedRealtime();
            boolean z = false;
            int i = 0;
            while (true) {
                this.zzgiy.zzde(this.zzgjp);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                try {
                    zzp.zzkp().zza(this.zzvr, this.zzgjo, z, httpURLConnection);
                    if (!TextUtils.isEmpty(str2)) {
                        httpURLConnection.addRequestProperty(HttpHeaders.COOKIE, str2);
                    }
                    if (zzasv.zzvh()) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("pii");
                        if (optJSONObject != null) {
                            if (!TextUtils.isEmpty(optJSONObject.optString(str4, str5))) {
                                httpURLConnection.addRequestProperty("x-afma-drt-cookie", optJSONObject.optString(str4, str5));
                            }
                            if (!TextUtils.isEmpty(optJSONObject.optString(str3, str5))) {
                                httpURLConnection.addRequestProperty("x-afma-drt-v2-cookie", optJSONObject.optString(str3, str5));
                            }
                        } else {
                            zzaxy.zzei("DSID signal does not exist.");
                        }
                    }
                    if (!TextUtils.isEmpty(zzasv.zzvg())) {
                        httpURLConnection.setDoOutput(true);
                        bArr = zzasv.zzvg().getBytes();
                        httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                        try {
                            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(httpURLConnection.getOutputStream());
                            try {
                                bufferedOutputStream2.write(bArr);
                                IOUtils.closeQuietly(bufferedOutputStream2);
                            } catch (Throwable th3) {
                                th2 = th3;
                                bufferedOutputStream = bufferedOutputStream2;
                                IOUtils.closeQuietly(bufferedOutputStream);
                                throw th2;
                            }
                        } catch (Throwable th4) {
                            th2 = th4;
                            bufferedOutputStream = null;
                            IOUtils.closeQuietly(bufferedOutputStream);
                            throw th2;
                        }
                    } else {
                        bArr = null;
                    }
                    zzbax = new zzbax();
                    zzbax.zza(httpURLConnection, bArr);
                    responseCode = httpURLConnection.getResponseCode();
                    for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
                        String key = entry.getKey();
                        List<String> value = entry.getValue();
                        if (hashMap.containsKey(key)) {
                            ((List) hashMap.get(key)).addAll(value);
                        } else {
                            hashMap.put(key, new ArrayList(value));
                            str5 = str5;
                        }
                        str4 = str4;
                        str3 = str3;
                    }
                    zzbax.zza(httpURLConnection, responseCode);
                } finally {
                    httpURLConnection.disconnect();
                    this.zzgiy.zzvm();
                }
                if (responseCode >= 200 && responseCode < 300) {
                    try {
                        InputStreamReader inputStreamReader2 = new InputStreamReader(httpURLConnection.getInputStream());
                        try {
                            zzp.zzkp();
                            String zza = zzayh.zza(inputStreamReader2);
                            IOUtils.closeQuietly(inputStreamReader2);
                            zzbax.zzez(zza);
                            zzcqe.zzgjq = responseCode;
                            zzcqe.zzdrq = zza;
                            zzcqe.zzam = hashMap;
                            if (TextUtils.isEmpty(zza)) {
                                if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzcul)).booleanValue()) {
                                    throw new zzcmt(zzdmd.zzhcq);
                                }
                            }
                            zzcqe.zzgjr = zzp.zzkw().elapsedRealtime() - elapsedRealtime;
                            return zzcqe;
                        } catch (Throwable th5) {
                            th = th5;
                            inputStreamReader = inputStreamReader2;
                            IOUtils.closeQuietly(inputStreamReader);
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        inputStreamReader = null;
                        IOUtils.closeQuietly(inputStreamReader);
                        throw th;
                    }
                } else if (responseCode < 300 || responseCode >= 400) {
                    break;
                } else {
                    String headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                    if (!TextUtils.isEmpty(headerField)) {
                        URL url2 = new URL(headerField);
                        i++;
                        if (i <= ((Integer) zzwe.zzpu().zzd(zzaat.zzctp)).intValue()) {
                            httpURLConnection.disconnect();
                            this.zzgiy.zzvm();
                            url = url2;
                            str5 = str5;
                            str4 = str4;
                            str3 = str3;
                            z = false;
                        } else {
                            zzbbd.zzfe("Too many redirects.");
                            throw new zzcmt(zzdmd.zzhco, "Too many redirects");
                        }
                    } else {
                        zzbbd.zzfe("No location header to follow redirect.");
                        throw new zzcmt(zzdmd.zzhco, "No location header to follow redirect");
                    }
                }
            }
            StringBuilder sb = new StringBuilder(46);
            sb.append("Received error HTTP response code: ");
            sb.append(responseCode);
            zzbbd.zzfe(sb.toString());
            int i2 = zzdmd.zzhco;
            StringBuilder sb2 = new StringBuilder(46);
            sb2.append("Received error HTTP response code: ");
            sb2.append(responseCode);
            throw new zzcmt(i2, sb2.toString());
        } else if (zzasv.getErrorCode() == 1) {
            if (zzasv.zzve() != null) {
                zzbbd.zzfc(TextUtils.join(", ", zzasv.zzve()));
            }
            throw new zzcmt(zzdmd.zzhcp, "Error building request URL.");
        } else {
            throw new zzcmt(zzdmd.zzhco);
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdoq
    public final /* synthetic */ zzcqe apply(zzcqb zzcqb) throws Exception {
        zzcqb zzcqb2 = zzcqb;
        return zza(zzcqb2.zzgji.getUrl(), zzcqb2.zzgji, zzcqb2.zzgjh, this.zzdqr);
    }
}
