package androidx.core.provider;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.provider.SelfDestructiveThread;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
public class FontsContractCompat {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final String PARCEL_FONT_RESULTS = "font_results";
    public static final LruCache<String, Typeface> a = new LruCache<>(16);
    public static final SelfDestructiveThread b = new SelfDestructiveThread("fonts", 10, 10000);
    public static final Object c = new Object();
    @GuardedBy("sLock")
    public static final SimpleArrayMap<String, ArrayList<SelfDestructiveThread.ReplyCallback<e>>> d = new SimpleArrayMap<>();
    public static final Comparator<byte[]> e = new d();

    public static final class Columns implements BaseColumns {
        public static final String FILE_ID = "file_id";
        public static final String ITALIC = "font_italic";
        public static final String RESULT_CODE = "result_code";
        public static final int RESULT_CODE_FONT_NOT_FOUND = 1;
        public static final int RESULT_CODE_FONT_UNAVAILABLE = 2;
        public static final int RESULT_CODE_MALFORMED_QUERY = 3;
        public static final int RESULT_CODE_OK = 0;
        public static final String TTC_INDEX = "font_ttc_index";
        public static final String VARIATION_SETTINGS = "font_variation_settings";
        public static final String WEIGHT = "font_weight";
    }

    public static class FontFamilyResult {
        public static final int STATUS_OK = 0;
        public static final int STATUS_UNEXPECTED_DATA_PROVIDED = 2;
        public static final int STATUS_WRONG_CERTIFICATES = 1;
        public final int a;
        public final FontInfo[] b;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public FontFamilyResult(int i, @Nullable FontInfo[] fontInfoArr) {
            this.a = i;
            this.b = fontInfoArr;
        }

        public FontInfo[] getFonts() {
            return this.b;
        }

        public int getStatusCode() {
            return this.a;
        }
    }

    public static class FontInfo {
        public final Uri a;
        public final int b;
        public final int c;
        public final boolean d;
        public final int e;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public FontInfo(@NonNull Uri uri, @IntRange(from = 0) int i, @IntRange(from = 1, to = 1000) int i2, boolean z, int i3) {
            this.a = (Uri) Preconditions.checkNotNull(uri);
            this.b = i;
            this.c = i2;
            this.d = z;
            this.e = i3;
        }

        public int getResultCode() {
            return this.e;
        }

        @IntRange(from = 0)
        public int getTtcIndex() {
            return this.b;
        }

        @NonNull
        public Uri getUri() {
            return this.a;
        }

        @IntRange(from = 1, to = 1000)
        public int getWeight() {
            return this.c;
        }

        public boolean isItalic() {
            return this.d;
        }
    }

    public static class FontRequestCallback {
        public static final int FAIL_REASON_FONT_LOAD_ERROR = -3;
        public static final int FAIL_REASON_FONT_NOT_FOUND = 1;
        public static final int FAIL_REASON_FONT_UNAVAILABLE = 2;
        public static final int FAIL_REASON_MALFORMED_QUERY = 3;
        public static final int FAIL_REASON_PROVIDER_NOT_FOUND = -1;
        public static final int FAIL_REASON_SECURITY_VIOLATION = -4;
        public static final int FAIL_REASON_WRONG_CERTIFICATES = -2;
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static final int RESULT_OK = 0;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public @interface FontRequestFailReason {
        }

        public void onTypefaceRequestFailed(int i) {
        }

        public void onTypefaceRetrieved(Typeface typeface) {
        }
    }

    public class a implements Callable<e> {
        public final /* synthetic */ Context a;
        public final /* synthetic */ FontRequest b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;

        public a(Context context, FontRequest fontRequest, int i, String str) {
            this.a = context;
            this.b = fontRequest;
            this.c = i;
            this.d = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public e call() throws Exception {
            e a3 = FontsContractCompat.a(this.a, this.b, this.c);
            Typeface typeface = a3.a;
            if (typeface != null) {
                FontsContractCompat.a.put(this.d, typeface);
            }
            return a3;
        }
    }

    public class b implements SelfDestructiveThread.ReplyCallback<e> {
        public final /* synthetic */ ResourcesCompat.FontCallback a;
        public final /* synthetic */ Handler b;

        public b(ResourcesCompat.FontCallback fontCallback, Handler handler) {
            this.a = fontCallback;
            this.b = handler;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.core.provider.SelfDestructiveThread.ReplyCallback
        public void onReply(e eVar) {
            e eVar2 = eVar;
            if (eVar2 == null) {
                this.a.callbackFailAsync(1, this.b);
                return;
            }
            int i = eVar2.b;
            if (i == 0) {
                this.a.callbackSuccessAsync(eVar2.a, this.b);
            } else {
                this.a.callbackFailAsync(i, this.b);
            }
        }
    }

    public class c implements SelfDestructiveThread.ReplyCallback<e> {
        public final /* synthetic */ String a;

        public c(String str) {
            this.a = str;
        }

        /* renamed from: a */
        public void onReply(e eVar) {
            ArrayList<SelfDestructiveThread.ReplyCallback<e>> arrayList;
            synchronized (FontsContractCompat.c) {
                SimpleArrayMap<String, ArrayList<SelfDestructiveThread.ReplyCallback<e>>> simpleArrayMap = FontsContractCompat.d;
                arrayList = simpleArrayMap.get(this.a);
                if (arrayList != null) {
                    simpleArrayMap.remove(this.a);
                } else {
                    return;
                }
            }
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList.get(i).onReply(eVar);
            }
        }
    }

    public class d implements Comparator<byte[]> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            int i;
            int i2;
            byte[] bArr3 = bArr;
            byte[] bArr4 = bArr2;
            if (bArr3.length != bArr4.length) {
                i2 = bArr3.length;
                i = bArr4.length;
            } else {
                for (int i3 = 0; i3 < bArr3.length; i3++) {
                    if (bArr3[i3] != bArr4[i3]) {
                        i2 = bArr3[i3];
                        i = bArr4[i3];
                    }
                }
                return 0;
            }
            return (i2 == 1 ? 1 : 0) - (i == 1 ? 1 : 0);
        }
    }

    public static final class e {
        public final Typeface a;
        public final int b;

        public e(@Nullable Typeface typeface, int i) {
            this.a = typeface;
            this.b = i;
        }
    }

    @NonNull
    public static e a(Context context, FontRequest fontRequest, int i) {
        try {
            FontFamilyResult fetchFonts = fetchFonts(context, null, fontRequest);
            int i2 = -3;
            if (fetchFonts.getStatusCode() == 0) {
                Typeface createFromFontInfo = TypefaceCompat.createFromFontInfo(context, null, fetchFonts.getFonts(), i);
                if (createFromFontInfo != null) {
                    i2 = 0;
                }
                return new e(createFromFontInfo, i2);
            }
            if (fetchFonts.getStatusCode() == 1) {
                i2 = -2;
            }
            return new e(null, i2);
        } catch (PackageManager.NameNotFoundException unused) {
            return new e(null, -1);
        }
    }

    @Nullable
    public static Typeface buildTypeface(@NonNull Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontInfo[] fontInfoArr) {
        return TypefaceCompat.createFromFontInfo(context, cancellationSignal, fontInfoArr, 0);
    }

    @NonNull
    public static FontFamilyResult fetchFonts(@NonNull Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontRequest fontRequest) throws PackageManager.NameNotFoundException {
        Uri uri;
        ProviderInfo provider = getProvider(context.getPackageManager(), fontRequest, context.getResources());
        Cursor cursor = null;
        if (provider == null) {
            return new FontFamilyResult(1, null);
        }
        String str = provider.authority;
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme("content").authority(str).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        try {
            cursor = context.getContentResolver().query(build, new String[]{"_id", Columns.FILE_ID, Columns.TTC_INDEX, Columns.VARIATION_SETTINGS, Columns.WEIGHT, Columns.ITALIC, Columns.RESULT_CODE}, "query = ?", new String[]{fontRequest.getQuery()}, null, cancellationSignal);
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex(Columns.RESULT_CODE);
                arrayList = new ArrayList();
                int columnIndex2 = cursor.getColumnIndex("_id");
                int columnIndex3 = cursor.getColumnIndex(Columns.FILE_ID);
                int columnIndex4 = cursor.getColumnIndex(Columns.TTC_INDEX);
                int columnIndex5 = cursor.getColumnIndex(Columns.WEIGHT);
                int columnIndex6 = cursor.getColumnIndex(Columns.ITALIC);
                while (cursor.moveToNext()) {
                    int i = columnIndex != -1 ? cursor.getInt(columnIndex) : 0;
                    int i2 = columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0;
                    if (columnIndex3 == -1) {
                        uri = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                    } else {
                        uri = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                    }
                    arrayList.add(new FontInfo(uri, i2, columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1, i));
                }
            }
            return new FontFamilyResult(0, (FontInfo[]) arrayList.toArray(new FontInfo[0]));
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface getFontSync(Context context, FontRequest fontRequest, @Nullable ResourcesCompat.FontCallback fontCallback, @Nullable Handler handler, boolean z, int i, int i2) {
        b bVar;
        String str = fontRequest.getIdentifier() + "-" + i2;
        Typeface typeface = a.get(str);
        if (typeface != null) {
            if (fontCallback != null) {
                fontCallback.onFontRetrieved(typeface);
            }
            return typeface;
        } else if (!z || i != -1) {
            a aVar = new a(context, fontRequest, i2, str);
            if (z) {
                try {
                    return ((e) b.postAndWait(aVar, i)).a;
                } catch (InterruptedException unused) {
                    return null;
                }
            } else {
                if (fontCallback == null) {
                    bVar = null;
                } else {
                    bVar = new b(fontCallback, handler);
                }
                synchronized (c) {
                    SimpleArrayMap<String, ArrayList<SelfDestructiveThread.ReplyCallback<e>>> simpleArrayMap = d;
                    ArrayList<SelfDestructiveThread.ReplyCallback<e>> arrayList = simpleArrayMap.get(str);
                    if (arrayList != null) {
                        if (bVar != null) {
                            arrayList.add(bVar);
                        }
                        return null;
                    }
                    if (bVar != null) {
                        ArrayList<SelfDestructiveThread.ReplyCallback<e>> arrayList2 = new ArrayList<>();
                        arrayList2.add(bVar);
                        simpleArrayMap.put(str, arrayList2);
                    }
                    b.postAndReply(aVar, new c(str));
                    return null;
                }
            }
        } else {
            e a3 = a(context, fontRequest, i2);
            if (fontCallback != null) {
                int i3 = a3.b;
                if (i3 == 0) {
                    fontCallback.callbackSuccessAsync(a3.a, handler);
                } else {
                    fontCallback.callbackFailAsync(i3, handler);
                }
            }
            return a3.a;
        }
    }

    @VisibleForTesting
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ProviderInfo getProvider(@NonNull PackageManager packageManager, @NonNull FontRequest fontRequest, @Nullable Resources resources) throws PackageManager.NameNotFoundException {
        List<List<byte[]>> list;
        boolean z;
        String providerAuthority = fontRequest.getProviderAuthority();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(providerAuthority, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException(a2.b.a.a.a.c3("No package found for authority: ", providerAuthority));
        } else if (resolveContentProvider.packageName.equals(fontRequest.getProviderPackage())) {
            Signature[] signatureArr = packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures;
            ArrayList arrayList = new ArrayList();
            for (Signature signature : signatureArr) {
                arrayList.add(signature.toByteArray());
            }
            Collections.sort(arrayList, e);
            if (fontRequest.getCertificates() != null) {
                list = fontRequest.getCertificates();
            } else {
                list = FontResourcesParserCompat.readCerts(resources, fontRequest.getCertificatesArrayResId());
            }
            for (int i = 0; i < list.size(); i++) {
                ArrayList arrayList2 = new ArrayList(list.get(i));
                Collections.sort(arrayList2, e);
                if (arrayList.size() == arrayList2.size()) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= arrayList.size()) {
                            z = true;
                            break;
                        } else if (!Arrays.equals((byte[]) arrayList.get(i2), (byte[]) arrayList2.get(i2))) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                z = false;
                if (z) {
                    return resolveContentProvider;
                }
            }
            return null;
        } else {
            StringBuilder R = a2.b.a.a.a.R("Found content provider ", providerAuthority, ", but package was not ");
            R.append(fontRequest.getProviderPackage());
            throw new PackageManager.NameNotFoundException(R.toString());
        }
    }

    @RequiresApi(19)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Map<Uri, ByteBuffer> prepareFontData(Context context, FontInfo[] fontInfoArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (FontInfo fontInfo : fontInfoArr) {
            if (fontInfo.getResultCode() == 0) {
                Uri uri = fontInfo.getUri();
                if (!hashMap.containsKey(uri)) {
                    hashMap.put(uri, TypefaceCompatUtil.mmap(context, cancellationSignal, uri));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public static void requestFont(@NonNull Context context, @NonNull FontRequest fontRequest, @NonNull FontRequestCallback fontRequestCallback, @NonNull Handler handler) {
        handler.post(new l6.h.g.a(context.getApplicationContext(), fontRequest, new Handler(), fontRequestCallback));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void resetCache() {
        a.evictAll();
    }
}
