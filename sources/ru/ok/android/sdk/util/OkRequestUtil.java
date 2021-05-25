package ru.ok.android.sdk.util;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.common.net.HttpHeaders;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;
import ru.ok.android.sdk.Odnoklassniki;
import ru.ok.android.sdk.Shared;
public class OkRequestUtil {
    public static final String encode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.getLocalizedMessage();
            return null;
        }
    }

    public static final String executeRequest(Map<String, String> map) throws IOException {
        int read;
        if (map == null || !map.containsKey("method") || !map.containsKey(Shared.PARAM_APP_KEY)) {
            return null;
        }
        ArrayList<Pair> arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new Pair(entry.getKey(), entry.getValue()));
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Odnoklassniki.getInstance().getApiBaseUrl() + "fb.do").openConnection();
        httpURLConnection.setReadTimeout(3000);
        httpURLConnection.setConnectTimeout(8000);
        httpURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty(HttpHeaders.CONNECTION, "Keep-Alive");
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (Pair pair : arrayList) {
            Object obj = pair.first;
            if (!(obj == null || pair.second == null)) {
                arrayList2.add(String.format("%s=%s", URLEncoder.encode((String) obj, "UTF-8"), URLEncoder.encode((String) pair.second, "UTF-8")));
            }
        }
        String join = TextUtils.join("&", arrayList2);
        if (join.length() > 0) {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            bufferedWriter.write(join);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
        }
        InputStream inputStream = httpURLConnection.getInputStream();
        StringBuilder sb = new StringBuilder(Math.max(httpURLConnection.getContentLength(), 128));
        char[] cArr = new char[4096];
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        do {
            try {
                read = inputStreamReader.read(cArr, 0, 4096);
                if (read > 0) {
                    sb.append(cArr, 0, read);
                    continue;
                }
            } finally {
                try {
                    inputStreamReader.close();
                } catch (Exception unused) {
                }
            }
        } while (read >= 0);
        return sb.toString();
    }

    public static final Bundle getUrlParameters(String str) {
        Bundle bundle = new Bundle();
        String[] split = str.split("\\?");
        if (split.length > 1) {
            for (String str2 : split[1].split("[&#]")) {
                String[] split2 = str2.split("=");
                String decode = URLDecoder.decode(split2[0]);
                String str3 = null;
                if (split2.length > 1) {
                    str3 = URLDecoder.decode(split2[1]);
                }
                bundle.putString(decode, str3);
            }
        }
        return bundle;
    }
}
