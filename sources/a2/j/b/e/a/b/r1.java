package a2.j.b.e.a.b;

import a2.b.a.a.a;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStates;
import com.google.android.play.core.assetpacks.dd;
import com.google.android.play.core.assetpacks.model.AssetPackStatus;
import com.google.android.play.core.common.LocalTestingException;
import com.google.android.play.core.internal.aa;
import com.google.android.play.core.internal.aq;
import com.google.android.play.core.internal.ce;
import com.google.android.play.core.internal.h;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import com.google.android.play.core.tasks.i;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
public final class r1 implements q2 {
    public static final aa h = new aa("FakeAssetPackService");
    public static final AtomicInteger i = new AtomicInteger(1);
    public final String a;
    public final v b;
    public final t0 c;
    public final Context d;
    public final x1 e;
    public final ce<Executor> f;
    public final Handler g = new Handler(Looper.getMainLooper());

    public r1(File file, v vVar, t0 t0Var, Context context, x1 x1Var, ce<Executor> ceVar) {
        this.a = file.getAbsolutePath();
        this.b = vVar;
        this.c = t0Var;
        this.d = context;
        this.e = x1Var;
        this.f = ceVar;
    }

    public static long e(@AssetPackStatus int i2, long j) {
        if (i2 == 2) {
            return j / 2;
        }
        if (i2 == 3 || i2 == 4) {
            return j;
        }
        return 0;
    }

    @Override // a2.j.b.e.a.b.q2
    public final Task<List<String>> a() {
        h.c("syncPacks()", new Object[0]);
        return Tasks.a(new ArrayList());
    }

    @Override // a2.j.b.e.a.b.q2
    public final Task<ParcelFileDescriptor> a(int i2, String str, String str2, int i3) {
        i H1 = a.H1(h, "getChunkFileDescriptor(session=%d, %s, %s, %d)", new Object[]{Integer.valueOf(i2), str, str2, Integer.valueOf(i3)});
        try {
            File[] h2 = h(str);
            for (File file : h2) {
                if (aq.a(file).equals(str2)) {
                    H1.a((i) ParcelFileDescriptor.open(file, 268435456));
                    return H1.a();
                }
            }
            throw new LocalTestingException(String.format("Local testing slice for '%s' not found.", str2));
        } catch (FileNotFoundException e2) {
            h.d("getChunkFileDescriptor failed", e2);
            H1.a((Exception) new LocalTestingException("Asset Slice file not found.", e2));
        } catch (LocalTestingException e3) {
            h.d("getChunkFileDescriptor failed", e3);
            H1.a((Exception) e3);
        }
    }

    @Override // a2.j.b.e.a.b.q2
    public final void a(int i2) {
        h.c("notifySessionFailed", new Object[0]);
    }

    @Override // a2.j.b.e.a.b.q2
    public final void a(int i2, String str) {
        h.c("notifyModuleCompleted", new Object[0]);
        this.f.a().execute(new Runnable(this, i2, str) { // from class: a2.j.b.e.a.b.n1
            public final r1 a;
            public final int b;
            public final String c;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                r1 r1Var = this.a;
                int i3 = this.b;
                String str2 = this.c;
                Objects.requireNonNull(r1Var);
                try {
                    r1Var.g(i3, str2, 4);
                } catch (LocalTestingException e2) {
                    r1.h.d("notifyModuleCompleted failed", e2);
                }
            }
        });
    }

    @Override // a2.j.b.e.a.b.q2
    public final void a(String str) {
        h.c("removePack(%s)", str);
    }

    @Override // a2.j.b.e.a.b.q2
    public final void a(List<String> list) {
        h.c("cancelDownload(%s)", list);
    }

    @Override // a2.j.b.e.a.b.q2
    public final void b() {
        h.c("keepAlive", new Object[0]);
    }

    @Override // a2.j.b.e.a.b.q2
    public final void b(int i2, String str, String str2, int i3) {
        h.c("notifyChunkTransferred", new Object[0]);
    }

    @Override // a2.j.b.e.a.b.q2
    public final Task<AssetPackStates> c(List<String> list, List<String> list2) {
        i H1 = a.H1(h, "startDownload(%s)", new Object[]{list2});
        this.f.a().execute(new Runnable(this, list2, H1, list) { // from class: a2.j.b.e.a.b.l1
            public final r1 a;
            public final List b;
            public final i c;
            public final List d;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            @Override // java.lang.Runnable
            public final void run() {
                r1 r1Var = this.a;
                List list3 = this.b;
                i iVar = this.c;
                List list4 = this.d;
                Objects.requireNonNull(r1Var);
                HashMap hashMap = new HashMap();
                int size = list3.size();
                long j = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    String str = (String) list3.get(i2);
                    int andIncrement = r1.i.getAndIncrement();
                    try {
                        r1Var.g(andIncrement, str, 1);
                        r1Var.g(andIncrement, str, 2);
                        r1Var.g(andIncrement, str, 3);
                        AssetPackState f2 = r1Var.f(str, 1);
                        j += f2.totalBytesToDownload();
                        hashMap.put(str, f2);
                    } catch (LocalTestingException e2) {
                        iVar.a((Exception) e2);
                        return;
                    }
                }
                int size2 = list4.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    String str2 = (String) list4.get(i3);
                    hashMap.put(str2, AssetPackState.a(str2, 4, 0, 0, 0, 0.0d));
                }
                iVar.a((i) AssetPackStates.a(j, hashMap));
            }
        });
        return H1.a();
    }

    @Override // a2.j.b.e.a.b.q2
    public final Task<AssetPackStates> d(List<String> list, x xVar) {
        i H1 = a.H1(h, "getPackStates(%s)", new Object[]{list});
        this.f.a().execute(new Runnable(this, list, xVar, H1) { // from class: a2.j.b.e.a.b.m1
            public final r1 a;
            public final List b;
            public final x c;
            public final i d;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            @Override // java.lang.Runnable
            public final void run() {
                r1 r1Var = this.a;
                List<String> list2 = this.b;
                x xVar2 = this.c;
                i iVar = this.d;
                Objects.requireNonNull(r1Var);
                HashMap hashMap = new HashMap();
                long j = 0;
                for (String str : list2) {
                    try {
                        AssetPackState f2 = r1Var.f(str, xVar2.a(8, str));
                        j += f2.totalBytesToDownload();
                        hashMap.put(str, f2);
                    } catch (LocalTestingException e2) {
                        iVar.a((Exception) e2);
                        return;
                    }
                }
                iVar.a((i) AssetPackStates.a(j, hashMap));
            }
        });
        return H1.a();
    }

    public final AssetPackState f(String str, @AssetPackStatus int i2) throws LocalTestingException {
        long j = 0;
        for (File file : h(str)) {
            j += file.length();
        }
        return AssetPackState.a(str, i2, 0, e(i2, j), j, this.c.b(str));
    }

    public final void g(int i2, String str, @AssetPackStatus int i3) throws LocalTestingException {
        Bundle bundle = new Bundle();
        bundle.putInt("app_version_code", this.e.a());
        bundle.putInt(SDKAnalyticsEvents.PARAMETER_SESSION_ID, i2);
        File[] h2 = h(str);
        ArrayList<String> arrayList = new ArrayList<>();
        long j = 0;
        for (File file : h2) {
            j += file.length();
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
            arrayList2.add(i3 == 3 ? new Intent().setData(Uri.EMPTY) : null);
            String a3 = aq.a(file);
            bundle.putParcelableArrayList(h.a("chunk_intents", str, a3), arrayList2);
            try {
                bundle.putString(h.a("uncompressed_hash_sha256", str, a3), dd.e(Arrays.asList(file)));
                bundle.putLong(h.a("uncompressed_size", str, a3), file.length());
                arrayList.add(a3);
            } catch (NoSuchAlgorithmException e2) {
                throw new LocalTestingException("SHA256 algorithm not supported.", e2);
            } catch (IOException e3) {
                throw new LocalTestingException(String.format("Could not digest file: %s.", file), e3);
            }
        }
        bundle.putStringArrayList(h.a("slice_ids", str), arrayList);
        bundle.putLong(h.a("pack_version", str), (long) this.e.a());
        bundle.putInt(h.a("status", str), i3);
        bundle.putInt(h.a("error_code", str), 0);
        bundle.putLong(h.a("bytes_downloaded", str), e(i3, j));
        bundle.putLong(h.a("total_bytes_to_download", str), j);
        bundle.putStringArrayList("pack_names", new ArrayList<>(Arrays.asList(str)));
        bundle.putLong("bytes_downloaded", e(i3, j));
        bundle.putLong("total_bytes_to_download", j);
        this.g.post(new Runnable(this, new Intent("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE").putExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE", bundle)) { // from class: a2.j.b.e.a.b.q1
            public final r1 a;
            public final Intent b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                r1 r1Var = this.a;
                r1Var.b.a(r1Var.d, this.b);
            }
        });
    }

    public final File[] h(String str) throws LocalTestingException {
        File file = new File(this.a);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles(new FilenameFilter(str) { // from class: a2.j.b.e.a.b.o1
                public final String a;

                {
                    this.a = r1;
                }

                @Override // java.io.FilenameFilter
                public final boolean accept(File file2, String str2) {
                    return str2.startsWith(String.valueOf(this.a).concat("-")) && str2.endsWith(".apk");
                }
            });
            if (listFiles != null) {
                int length = listFiles.length;
                if (length != 0) {
                    for (File file2 : listFiles) {
                        if (aq.a(file2).equals(str)) {
                            return listFiles;
                        }
                    }
                    throw new LocalTestingException(String.format("No master slice available for pack '%s'.", str));
                }
                throw new LocalTestingException(String.format("No APKs available for pack '%s'.", str));
            }
            throw new LocalTestingException(String.format("Failed fetching APKs for pack '%s'.", str));
        }
        throw new LocalTestingException(String.format("Local testing directory '%s' not found.", file));
    }
}
