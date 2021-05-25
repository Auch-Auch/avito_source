package l6.h.g;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Handler;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
public class a implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ FontRequest b;
    public final /* synthetic */ Handler c;
    public final /* synthetic */ FontsContractCompat.FontRequestCallback d;

    /* renamed from: l6.h.g.a$a  reason: collision with other inner class name */
    public class RunnableC0526a implements Runnable {
        public RunnableC0526a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.d.onTypefaceRequestFailed(-1);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.d.onTypefaceRequestFailed(-2);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.d.onTypefaceRequestFailed(-3);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.d.onTypefaceRequestFailed(-3);
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.d.onTypefaceRequestFailed(1);
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.d.onTypefaceRequestFailed(-3);
        }
    }

    public class g implements Runnable {
        public final /* synthetic */ int a;

        public g(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.d.onTypefaceRequestFailed(this.a);
        }
    }

    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.d.onTypefaceRequestFailed(-3);
        }
    }

    public class i implements Runnable {
        public final /* synthetic */ Typeface a;

        public i(Typeface typeface) {
            this.a = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.d.onTypefaceRetrieved(this.a);
        }
    }

    public a(Context context, FontRequest fontRequest, Handler handler, FontsContractCompat.FontRequestCallback fontRequestCallback) {
        this.a = context;
        this.b = fontRequest;
        this.c = handler;
        this.d = fontRequestCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            FontsContractCompat.FontFamilyResult fetchFonts = FontsContractCompat.fetchFonts(this.a, null, this.b);
            if (fetchFonts.getStatusCode() != 0) {
                int statusCode = fetchFonts.getStatusCode();
                if (statusCode == 1) {
                    this.c.post(new b());
                } else if (statusCode != 2) {
                    this.c.post(new d());
                } else {
                    this.c.post(new c());
                }
            } else {
                FontsContractCompat.FontInfo[] fonts = fetchFonts.getFonts();
                if (fonts == null || fonts.length == 0) {
                    this.c.post(new e());
                    return;
                }
                for (FontsContractCompat.FontInfo fontInfo : fonts) {
                    if (fontInfo.getResultCode() != 0) {
                        int resultCode = fontInfo.getResultCode();
                        if (resultCode < 0) {
                            this.c.post(new f());
                            return;
                        } else {
                            this.c.post(new g(resultCode));
                            return;
                        }
                    }
                }
                Typeface buildTypeface = FontsContractCompat.buildTypeface(this.a, null, fonts);
                if (buildTypeface == null) {
                    this.c.post(new h());
                } else {
                    this.c.post(new i(buildTypeface));
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
            this.c.post(new RunnableC0526a());
        }
    }
}
