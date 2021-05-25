package com.avito.android.license;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.avito.android.legacy_mvp.BaseViewModel;
import com.avito.android.license.LicenseView;
import com.avito.android.util.IOUtils;
import com.avito.android.util.Logs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
public class LicenseModel extends BaseViewModel<LicenseView> {
    public a d;
    public String e;
    public Context f;

    @SuppressLint({"StaticFieldLeak"})
    public class a extends AsyncTask<Void, Void, String> {
        public final Context a;
        public final List<C0142a> b = Arrays.asList(new C0142a(this, "kotlin.txt", "Kotlin"), new C0142a(this, "rxjava.txt", "RxJava"), new C0142a(this, "retrofit.txt", "Retrofit"), new C0142a(this, "ok_http.txt", "OkHttp"), new C0142a(this, "otto.txt", "Otto"), new C0142a(this, "apache2.txt", "android-support-v4", "android-support-v7-appcompat"), new C0142a(this, "image_view_zoom.txt", "ImageViewZoom"), new C0142a(this, "universal_image_loader.txt", "Universal Image Loader"), new C0142a(this, "jsoup.txt", "jsoup"));

        /* renamed from: com.avito.android.license.LicenseModel$a$a  reason: collision with other inner class name */
        public class C0142a {
            @NonNull
            public final String a;
            public final String[] b;

            public C0142a(@NonNull a aVar, String str, String... strArr) {
                this.b = strArr;
                this.a = str;
            }
        }

        public a(Context context) {
            this.a = context;
        }

        public final void a(StringBuilder sb) throws IOException {
            Throwable th;
            AssetManager assets = this.a.getAssets();
            for (C0142a aVar : this.b) {
                Objects.requireNonNull(aVar);
                StringBuilder sb2 = new StringBuilder();
                BufferedReader bufferedReader = null;
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(assets.open("licences/" + aVar.a)));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb2.append(readLine);
                            sb2.append("\n");
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader = bufferedReader2;
                            IOUtils.close(bufferedReader);
                            throw th;
                        }
                    }
                    IOUtils.close(bufferedReader2);
                    String sb3 = sb2.toString();
                    String[] strArr = aVar.b;
                    sb.append("<ul>");
                    for (String str : strArr) {
                        sb.append("<li>");
                        sb.append(str);
                        sb.append("</li>");
                    }
                    a2.b.a.a.a.n1(sb, "</ul>", "<pre>", sb3, "</pre>");
                } catch (Throwable th3) {
                    th = th3;
                    IOUtils.close(bufferedReader);
                    throw th;
                }
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        @Override // android.os.AsyncTask
        public String doInBackground(Void[] voidArr) {
            StringBuilder L = a2.b.a.a.a.L("<html><head><style> body { font-family: sans-serif; } pre { background-color: #eeeeee; padding: 1em; white-space: pre-wrap; } </style></head><body>");
            try {
                a(L);
            } catch (IOException e) {
                Logs.error("LicenseModel", "read files", e);
            }
            L.append("</body></html>");
            return L.toString();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            String str2 = str;
            LicenseModel.this.e = str2;
            if (isCancelled()) {
                LicenseModel.this.mSubscriber.onLoadingFinish();
                return;
            }
            LicenseModel.this.mSubscriber.showLicense(str2);
            LicenseModel.this.mSubscriber.onLoadingFinish();
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            LicenseModel.this.mSubscriber.onLoadingStart();
        }
    }

    public LicenseModel(Context context) {
        this.f = context;
    }

    public void refresh() {
        if (TextUtils.isEmpty(this.e)) {
            a aVar = this.d;
            if (aVar == null || aVar.getStatus() == AsyncTask.Status.FINISHED) {
                a aVar2 = new a(this.f);
                this.d = aVar2;
                aVar2.execute(new Void[0]);
                return;
            }
            return;
        }
        this.mSubscriber.showLicense(this.e);
        this.mSubscriber.onLoadingFinish();
    }

    @Override // com.avito.android.legacy_mvp.BaseViewModel
    public LicenseView getEmptySubscriber() {
        return new LicenseView.Simple();
    }

    public void onUnsubscribe(LicenseView licenseView) {
        a aVar = this.d;
        if (aVar != null) {
            aVar.cancel(false);
        }
    }
}
