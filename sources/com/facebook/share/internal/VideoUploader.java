package com.facebook.share.internal;

import a2.g.v.l.m;
import a2.g.v.l.n;
import a2.g.v.l.o;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.WorkQueue;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.vk.sdk.api.model.VKApiCommunityFull;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
public class VideoUploader {
    public static boolean a;
    public static Handler b;
    public static WorkQueue c = new WorkQueue(8);
    public static Set<d> d = new HashSet();

    public static class a extends e {
        public static final Set<Integer> d = new C0182a();

        /* renamed from: com.facebook.share.internal.VideoUploader$a$a  reason: collision with other inner class name */
        public static class C0182a extends HashSet<Integer> {
            public C0182a() {
                add(1363011);
            }
        }

        public a(d dVar, int i) {
            super(dVar, i);
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        public void b(int i) {
            d dVar = this.a;
            boolean z = VideoUploader.a;
            VideoUploader.c(dVar, new a(dVar, i));
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        public Bundle d() {
            Bundle bundle = new Bundle();
            Bundle bundle2 = this.a.p;
            if (bundle2 != null) {
                bundle.putAll(bundle2);
            }
            bundle.putString("upload_phase", "finish");
            bundle.putString("upload_session_id", this.a.i);
            Utility.putNonEmptyString(bundle, "title", this.a.b);
            Utility.putNonEmptyString(bundle, "description", this.a.c);
            Utility.putNonEmptyString(bundle, "ref", this.a.d);
            return bundle;
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        public Set<Integer> e() {
            return d;
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        public void f(FacebookException facebookException) {
            Object[] objArr = {this.a.j};
            boolean z = VideoUploader.a;
            String.format(Locale.ROOT, "Video '%s' failed to finish uploading", objArr);
            a(facebookException);
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        public void g(JSONObject jSONObject) throws JSONException {
            if (jSONObject.getBoolean("success")) {
                VideoUploader.b().post(new o(this, null, this.a.j));
                return;
            }
            f(new FacebookException("Unexpected error in server response"));
        }
    }

    public static class b extends e {
        public static final Set<Integer> d = new a();

        public static class a extends HashSet<Integer> {
            public a() {
                add(6000);
            }
        }

        public b(d dVar, int i) {
            super(dVar, i);
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        public void b(int i) {
            d dVar = this.a;
            boolean z = VideoUploader.a;
            VideoUploader.c(dVar, new b(dVar, i));
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        public Bundle d() {
            Bundle y1 = a2.b.a.a.a.y1("upload_phase", Tracker.Events.CREATIVE_START);
            y1.putLong("file_size", this.a.l);
            return y1;
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        public Set<Integer> e() {
            return d;
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        public void f(FacebookException facebookException) {
            boolean z = VideoUploader.a;
            String.format(Locale.ROOT, "Error starting video upload", new Object[0]);
            a(facebookException);
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        public void g(JSONObject jSONObject) throws JSONException {
            this.a.i = jSONObject.getString("upload_session_id");
            this.a.j = jSONObject.getString("video_id");
            String string = jSONObject.getString("start_offset");
            String string2 = jSONObject.getString("end_offset");
            if (this.a.h != null) {
                long parseLong = Long.parseLong(string);
                d dVar = this.a;
                dVar.h.onProgress(parseLong, dVar.l);
            }
            VideoUploader.a(this.a, string, string2, 0);
        }
    }

    public static class c extends e {
        public static final Set<Integer> f = new a();
        public String d;
        public String e;

        public static class a extends HashSet<Integer> {
            public a() {
                add(1363019);
                add(1363021);
                add(1363030);
                add(1363033);
                add(1363041);
            }
        }

        public c(d dVar, String str, String str2, int i) {
            super(dVar, i);
            this.d = str;
            this.e = str2;
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        public void b(int i) {
            VideoUploader.a(this.a, this.d, this.e, i);
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        public Bundle d() throws IOException {
            Bundle y1 = a2.b.a.a.a.y1("upload_phase", "transfer");
            y1.putString("upload_session_id", this.a.i);
            y1.putString("start_offset", this.d);
            d dVar = this.a;
            String str = this.d;
            String str2 = this.e;
            boolean z = VideoUploader.a;
            byte[] bArr = null;
            if (!Utility.areObjectsEqual(str, dVar.m)) {
                String.format(Locale.ROOT, "Error reading video chunk. Expected chunk '%s'. Requested chunk '%s'.", dVar.m, str);
            } else {
                int parseLong = (int) (Long.parseLong(str2) - Long.parseLong(str));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr2 = new byte[Math.min(8192, parseLong)];
                while (true) {
                    int read = dVar.k.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                    parseLong -= read;
                    if (parseLong != 0) {
                        if (parseLong < 0) {
                            String.format(Locale.ROOT, "Error reading video chunk. Expected buffer length - '%d'. Actual - '%d'.", Integer.valueOf(parseLong + read), Integer.valueOf(read));
                            break;
                        }
                    } else {
                        break;
                    }
                }
                dVar.m = str2;
                bArr = byteArrayOutputStream.toByteArray();
            }
            if (bArr != null) {
                y1.putByteArray("video_file_chunk", bArr);
                return y1;
            }
            throw new FacebookException("Error reading video");
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        public Set<Integer> e() {
            return f;
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        public void f(FacebookException facebookException) {
            Object[] objArr = {this.a.j};
            boolean z = VideoUploader.a;
            String.format(Locale.ROOT, "Error uploading video '%s'", objArr);
            a(facebookException);
        }

        @Override // com.facebook.share.internal.VideoUploader.e
        public void g(JSONObject jSONObject) throws JSONException {
            String string = jSONObject.getString("start_offset");
            String string2 = jSONObject.getString("end_offset");
            if (this.a.h != null) {
                long parseLong = Long.parseLong(string);
                d dVar = this.a;
                dVar.h.onProgress(parseLong, dVar.l);
            }
            if (Utility.areObjectsEqual(string, string2)) {
                d dVar2 = this.a;
                boolean z = VideoUploader.a;
                VideoUploader.c(dVar2, new a(dVar2, 0));
                return;
            }
            VideoUploader.a(this.a, string, string2, 0);
        }
    }

    public static class d {
        public final Uri a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final AccessToken f = AccessToken.getCurrentAccessToken();
        public final FacebookCallback<Sharer.Result> g;
        public final GraphRequest.OnProgressCallback h;
        public String i;
        public String j;
        public InputStream k;
        public long l;
        public String m = "0";
        public boolean n;
        public WorkQueue.WorkItem o;
        public Bundle p;

        public d(ShareVideoContent shareVideoContent, String str, FacebookCallback facebookCallback, GraphRequest.OnProgressCallback onProgressCallback, m mVar) {
            this.a = shareVideoContent.getVideo().getLocalUrl();
            this.b = shareVideoContent.getContentTitle();
            this.c = shareVideoContent.getContentDescription();
            this.d = shareVideoContent.getRef();
            this.e = str;
            this.g = facebookCallback;
            this.h = onProgressCallback;
            this.p = shareVideoContent.getVideo().getParameters();
            if (!Utility.isNullOrEmpty(shareVideoContent.getPeopleIds())) {
                this.p.putString("tags", TextUtils.join(", ", shareVideoContent.getPeopleIds()));
            }
            if (!Utility.isNullOrEmpty(shareVideoContent.getPlaceId())) {
                this.p.putString(VKApiCommunityFull.PLACE, shareVideoContent.getPlaceId());
            }
            if (!Utility.isNullOrEmpty(shareVideoContent.getRef())) {
                this.p.putString("ref", shareVideoContent.getRef());
            }
        }

        public static void a(d dVar) throws FileNotFoundException {
            try {
                if (Utility.isFileUri(dVar.a)) {
                    ParcelFileDescriptor open = ParcelFileDescriptor.open(new File(dVar.a.getPath()), 268435456);
                    dVar.l = open.getStatSize();
                    dVar.k = new ParcelFileDescriptor.AutoCloseInputStream(open);
                } else if (Utility.isContentUri(dVar.a)) {
                    dVar.l = Utility.getContentSize(dVar.a);
                    dVar.k = FacebookSdk.getApplicationContext().getContentResolver().openInputStream(dVar.a);
                } else {
                    throw new FacebookException("Uri must be a content:// or file:// uri");
                }
            } catch (FileNotFoundException e2) {
                Utility.closeQuietly(dVar.k);
                throw e2;
            }
        }
    }

    public static abstract class e implements Runnable {
        public d a;
        public int b;
        public GraphResponse c;

        public e(d dVar, int i) {
            this.a = dVar;
            this.b = i;
        }

        public void a(FacebookException facebookException) {
            VideoUploader.b().post(new o(this, facebookException, null));
        }

        public abstract void b(int i);

        public void c(Bundle bundle) {
            d dVar = this.a;
            boolean z = true;
            GraphResponse executeAndWait = new GraphRequest(dVar.f, String.format(Locale.ROOT, "%s/videos", dVar.e), bundle, HttpMethod.POST, null).executeAndWait();
            this.c = executeAndWait;
            if (executeAndWait != null) {
                FacebookRequestError error = executeAndWait.getError();
                JSONObject jSONObject = this.c.getJSONObject();
                if (error != null) {
                    int subErrorCode = error.getSubErrorCode();
                    if (this.b >= 2 || !e().contains(Integer.valueOf(subErrorCode))) {
                        z = false;
                    } else {
                        VideoUploader.b().postDelayed(new n(this), (long) (((int) Math.pow(3.0d, (double) this.b)) * 5000));
                    }
                    if (!z) {
                        f(new FacebookGraphResponseException(this.c, "Video upload failed"));
                    }
                } else if (jSONObject != null) {
                    try {
                        g(jSONObject);
                    } catch (JSONException e) {
                        a(new FacebookException("Unexpected error in server response", e));
                    }
                } else {
                    f(new FacebookException("Unexpected error in server response"));
                }
            } else {
                f(new FacebookException("Unexpected error in server response"));
            }
        }

        public abstract Bundle d() throws Exception;

        public abstract Set<Integer> e();

        public abstract void f(FacebookException facebookException);

        public abstract void g(JSONObject jSONObject) throws JSONException;

        @Override // java.lang.Runnable
        public void run() {
            if (!this.a.n) {
                try {
                    c(d());
                } catch (FacebookException e) {
                    a(e);
                } catch (Exception e2) {
                    a(new FacebookException("Video upload failed", e2));
                }
            } else {
                a(null);
            }
        }
    }

    public static void a(d dVar, String str, String str2, int i) {
        c(dVar, new c(dVar, str, str2, i));
    }

    public static Handler b() {
        Handler handler;
        synchronized (VideoUploader.class) {
            if (b == null) {
                b = new Handler(Looper.getMainLooper());
            }
            handler = b;
        }
        return handler;
    }

    public static synchronized void c(d dVar, Runnable runnable) {
        synchronized (VideoUploader.class) {
            dVar.o = c.addActiveWorkItem(runnable);
        }
    }

    public static synchronized void d(ShareVideoContent shareVideoContent, String str, FacebookCallback<Sharer.Result> facebookCallback, GraphRequest.OnProgressCallback onProgressCallback) throws FileNotFoundException {
        synchronized (VideoUploader.class) {
            if (!a) {
                new m();
                a = true;
            }
            Validate.notNull(shareVideoContent, "videoContent");
            Validate.notNull(str, "graphNode");
            ShareVideo video = shareVideoContent.getVideo();
            Validate.notNull(video, "videoContent.video");
            Validate.notNull(video.getLocalUrl(), "videoContent.video.localUrl");
            d dVar = new d(shareVideoContent, str, facebookCallback, onProgressCallback, null);
            d.a(dVar);
            d.add(dVar);
            c(dVar, new b(dVar, 0));
        }
    }

    public static synchronized void uploadAsync(ShareVideoContent shareVideoContent, String str, FacebookCallback<Sharer.Result> facebookCallback) throws FileNotFoundException {
        synchronized (VideoUploader.class) {
            d(shareVideoContent, str, facebookCallback, null);
        }
    }

    public static synchronized void uploadAsyncWithProgressCallback(ShareVideoContent shareVideoContent, GraphRequest.OnProgressCallback onProgressCallback) throws FileNotFoundException {
        synchronized (VideoUploader.class) {
            d(shareVideoContent, "me", null, onProgressCallback);
        }
    }

    public static synchronized void uploadAsyncWithProgressCallback(ShareVideoContent shareVideoContent, String str, GraphRequest.OnProgressCallback onProgressCallback) throws FileNotFoundException {
        synchronized (VideoUploader.class) {
            d(shareVideoContent, str, null, onProgressCallback);
        }
    }
}
