package androidx.print;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.PrintManager;
import android.print.pdf.PrintedPdfDocument;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public final class PrintHelper {
    @SuppressLint({"InlinedApi"})
    public static final int COLOR_MODE_COLOR = 2;
    @SuppressLint({"InlinedApi"})
    public static final int COLOR_MODE_MONOCHROME = 1;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    public static final boolean g;
    public static final boolean h;
    public final Context a;
    public BitmapFactory.Options b = null;
    public final Object c = new Object();
    public int d = 2;
    public int e = 2;
    public int f = 1;

    public interface OnPrintFinishCallback {
        void onFinish();
    }

    public class a extends AsyncTask<Void, Void, Throwable> {
        public final /* synthetic */ CancellationSignal a;
        public final /* synthetic */ PrintAttributes b;
        public final /* synthetic */ Bitmap c;
        public final /* synthetic */ PrintAttributes d;
        public final /* synthetic */ int e;
        public final /* synthetic */ ParcelFileDescriptor f;
        public final /* synthetic */ PrintDocumentAdapter.WriteResultCallback g;

        public a(CancellationSignal cancellationSignal, PrintAttributes printAttributes, Bitmap bitmap, PrintAttributes printAttributes2, int i, ParcelFileDescriptor parcelFileDescriptor, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            this.a = cancellationSignal;
            this.b = printAttributes;
            this.c = bitmap;
            this.d = printAttributes2;
            this.e = i;
            this.f = parcelFileDescriptor;
            this.g = writeResultCallback;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        @Override // android.os.AsyncTask
        public Throwable doInBackground(Void[] voidArr) {
            Bitmap bitmap;
            RectF rectF;
            float f2;
            try {
                if (this.a.isCanceled()) {
                    return null;
                }
                PrintedPdfDocument printedPdfDocument = new PrintedPdfDocument(PrintHelper.this.a, this.b);
                Bitmap a3 = PrintHelper.a(this.c, this.b.getColorMode());
                if (this.a.isCanceled()) {
                    return null;
                }
                try {
                    PdfDocument.Page startPage = printedPdfDocument.startPage(1);
                    boolean z = PrintHelper.h;
                    if (z) {
                        rectF = new RectF(startPage.getInfo().getContentRect());
                    } else {
                        PrintedPdfDocument printedPdfDocument2 = new PrintedPdfDocument(PrintHelper.this.a, this.d);
                        PdfDocument.Page startPage2 = printedPdfDocument2.startPage(1);
                        RectF rectF2 = new RectF(startPage2.getInfo().getContentRect());
                        printedPdfDocument2.finishPage(startPage2);
                        printedPdfDocument2.close();
                        rectF = rectF2;
                    }
                    int width = a3.getWidth();
                    int height = a3.getHeight();
                    int i = this.e;
                    Matrix matrix = new Matrix();
                    float f3 = (float) width;
                    float width2 = rectF.width() / f3;
                    if (i == 2) {
                        f2 = Math.max(width2, rectF.height() / ((float) height));
                    } else {
                        f2 = Math.min(width2, rectF.height() / ((float) height));
                    }
                    matrix.postScale(f2, f2);
                    matrix.postTranslate((rectF.width() - (f3 * f2)) / 2.0f, (rectF.height() - (((float) height) * f2)) / 2.0f);
                    if (!z) {
                        matrix.postTranslate(rectF.left, rectF.top);
                        startPage.getCanvas().clipRect(rectF);
                    }
                    startPage.getCanvas().drawBitmap(a3, matrix, null);
                    printedPdfDocument.finishPage(startPage);
                    if (!this.a.isCanceled()) {
                        printedPdfDocument.writeTo(new FileOutputStream(this.f.getFileDescriptor()));
                        printedPdfDocument.close();
                        ParcelFileDescriptor parcelFileDescriptor = this.f;
                        if (parcelFileDescriptor != null) {
                            try {
                                parcelFileDescriptor.close();
                            } catch (IOException unused) {
                            }
                        }
                        if (a3 == this.c) {
                            return null;
                        }
                    } else if (a3 == bitmap) {
                        return null;
                    }
                    return null;
                } finally {
                    printedPdfDocument.close();
                    ParcelFileDescriptor parcelFileDescriptor2 = this.f;
                    if (parcelFileDescriptor2 != null) {
                        try {
                            parcelFileDescriptor2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    if (a3 != this.c) {
                        a3.recycle();
                    }
                }
            } catch (Throwable th) {
                return th;
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.os.AsyncTask
        public void onPostExecute(Throwable th) {
            Throwable th2 = th;
            if (this.a.isCanceled()) {
                this.g.onWriteCancelled();
            } else if (th2 == null) {
                this.g.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
            } else {
                this.g.onWriteFailed(null);
            }
        }
    }

    @RequiresApi(19)
    public class b extends PrintDocumentAdapter {
        public final String a;
        public final int b;
        public final Bitmap c;
        public final OnPrintFinishCallback d;
        public PrintAttributes e;

        public b(String str, int i, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
            this.a = str;
            this.b = i;
            this.c = bitmap;
            this.d = onPrintFinishCallback;
        }

        @Override // android.print.PrintDocumentAdapter
        public void onFinish() {
            OnPrintFinishCallback onPrintFinishCallback = this.d;
            if (onPrintFinishCallback != null) {
                onPrintFinishCallback.onFinish();
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
            this.e = printAttributes2;
            layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.a).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
        }

        @Override // android.print.PrintDocumentAdapter
        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            PrintHelper.this.d(this.e, this.b, this.c, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }
    }

    @RequiresApi(19)
    public class c extends PrintDocumentAdapter {
        public final String a;
        public final Uri b;
        public final OnPrintFinishCallback c;
        public final int d;
        public PrintAttributes e;
        public AsyncTask<Uri, Boolean, Bitmap> f;
        public Bitmap g = null;

        public class a extends AsyncTask<Uri, Boolean, Bitmap> {
            public final /* synthetic */ CancellationSignal a;
            public final /* synthetic */ PrintAttributes b;
            public final /* synthetic */ PrintAttributes c;
            public final /* synthetic */ PrintDocumentAdapter.LayoutResultCallback d;

            /* renamed from: androidx.print.PrintHelper$c$a$a  reason: collision with other inner class name */
            public class C0120a implements CancellationSignal.OnCancelListener {
                public C0120a() {
                }

                @Override // android.os.CancellationSignal.OnCancelListener
                public void onCancel() {
                    c.this.a();
                    a.this.cancel(false);
                }
            }

            public a(CancellationSignal cancellationSignal, PrintAttributes printAttributes, PrintAttributes printAttributes2, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback) {
                this.a = cancellationSignal;
                this.b = printAttributes;
                this.c = printAttributes2;
                this.d = layoutResultCallback;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
            @Override // android.os.AsyncTask
            public Bitmap doInBackground(Uri[] uriArr) {
                try {
                    c cVar = c.this;
                    return PrintHelper.this.c(cVar.b);
                } catch (FileNotFoundException unused) {
                    return null;
                }
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.os.AsyncTask
            public void onCancelled(Bitmap bitmap) {
                this.d.onLayoutCancelled();
                c.this.f = null;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.os.AsyncTask
            public void onPostExecute(Bitmap bitmap) {
                PrintAttributes.MediaSize mediaSize;
                Bitmap bitmap2 = bitmap;
                super.onPostExecute(bitmap2);
                if (bitmap2 != null && (!PrintHelper.g || PrintHelper.this.f == 0)) {
                    synchronized (this) {
                        mediaSize = c.this.e.getMediaSize();
                    }
                    if (mediaSize != null) {
                        if (mediaSize.isPortrait() != (bitmap2.getWidth() <= bitmap2.getHeight())) {
                            Matrix matrix = new Matrix();
                            matrix.postRotate(90.0f);
                            bitmap2 = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), bitmap2.getHeight(), matrix, true);
                        }
                    }
                }
                c.this.g = bitmap2;
                if (bitmap2 != null) {
                    this.d.onLayoutFinished(new PrintDocumentInfo.Builder(c.this.a).setContentType(1).setPageCount(1).build(), true ^ this.b.equals(this.c));
                } else {
                    this.d.onLayoutFailed(null);
                }
                c.this.f = null;
            }

            @Override // android.os.AsyncTask
            public void onPreExecute() {
                this.a.setOnCancelListener(new C0120a());
            }
        }

        public c(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback, int i) {
            this.a = str;
            this.b = uri;
            this.c = onPrintFinishCallback;
            this.d = i;
        }

        public void a() {
            synchronized (PrintHelper.this.c) {
                BitmapFactory.Options options = PrintHelper.this.b;
                if (options != null) {
                    if (Build.VERSION.SDK_INT < 24) {
                        options.requestCancelDecode();
                    }
                    PrintHelper.this.b = null;
                }
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onFinish() {
            super.onFinish();
            a();
            AsyncTask<Uri, Boolean, Bitmap> asyncTask = this.f;
            if (asyncTask != null) {
                asyncTask.cancel(true);
            }
            OnPrintFinishCallback onPrintFinishCallback = this.c;
            if (onPrintFinishCallback != null) {
                onPrintFinishCallback.onFinish();
            }
            Bitmap bitmap = this.g;
            if (bitmap != null) {
                bitmap.recycle();
                this.g = null;
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
            synchronized (this) {
                this.e = printAttributes2;
            }
            if (cancellationSignal.isCanceled()) {
                layoutResultCallback.onLayoutCancelled();
            } else if (this.g != null) {
                layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.a).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
            } else {
                this.f = new a(cancellationSignal, printAttributes2, printAttributes, layoutResultCallback).execute(new Uri[0]);
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            PrintHelper.this.d(this.e, this.d, this.g, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        boolean z = false;
        g = i > 23;
        if (i != 23) {
            z = true;
        }
        h = z;
    }

    public PrintHelper(@NonNull Context context) {
        this.a = context;
    }

    public static Bitmap a(Bitmap bitmap, int i) {
        if (i != 1) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public static boolean systemSupportsPrint() {
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x001e A[SYNTHETIC, Splitter:B:17:0x001e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap b(android.net.Uri r3, android.graphics.BitmapFactory.Options r4) throws java.io.FileNotFoundException {
        /*
            r2 = this;
            android.content.Context r0 = r2.a
            if (r0 == 0) goto L_0x0022
            r1 = 0
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ all -> 0x001a }
            java.io.InputStream r3 = r0.openInputStream(r3)     // Catch:{ all -> 0x001a }
            android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeStream(r3, r1, r4)     // Catch:{ all -> 0x0017 }
            if (r3 == 0) goto L_0x0016
            r3.close()     // Catch:{ IOException -> 0x0016 }
        L_0x0016:
            return r4
        L_0x0017:
            r4 = move-exception
            r1 = r3
            goto L_0x001c
        L_0x001a:
            r3 = move-exception
            r4 = r3
        L_0x001c:
            if (r1 == 0) goto L_0x0021
            r1.close()     // Catch:{ IOException -> 0x0021 }
        L_0x0021:
            throw r4
        L_0x0022:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "bad argument to loadBitmap"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.print.PrintHelper.b(android.net.Uri, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    public Bitmap c(Uri uri) throws FileNotFoundException {
        BitmapFactory.Options options;
        if (uri == null || this.a == null) {
            throw new IllegalArgumentException("bad argument to getScaledBitmap");
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        b(uri, options2);
        int i = options2.outWidth;
        int i2 = options2.outHeight;
        if (i > 0 && i2 > 0) {
            int max = Math.max(i, i2);
            int i3 = 1;
            while (max > 3500) {
                max >>>= 1;
                i3 <<= 1;
            }
            if (i3 > 0 && Math.min(i, i2) / i3 > 0) {
                synchronized (this.c) {
                    options = new BitmapFactory.Options();
                    this.b = options;
                    options.inMutable = true;
                    options.inSampleSize = i3;
                }
                try {
                    Bitmap b2 = b(uri, options);
                    synchronized (this.c) {
                        this.b = null;
                    }
                    return b2;
                } catch (Throwable th) {
                    synchronized (this.c) {
                        this.b = null;
                        throw th;
                    }
                }
            }
        }
        return null;
    }

    @RequiresApi(19)
    public void d(PrintAttributes printAttributes, int i, Bitmap bitmap, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        PrintAttributes printAttributes2;
        if (h) {
            printAttributes2 = printAttributes;
        } else {
            PrintAttributes.Builder minMargins = new PrintAttributes.Builder().setMediaSize(printAttributes.getMediaSize()).setResolution(printAttributes.getResolution()).setMinMargins(printAttributes.getMinMargins());
            if (printAttributes.getColorMode() != 0) {
                minMargins.setColorMode(printAttributes.getColorMode());
            }
            if (Build.VERSION.SDK_INT >= 23 && printAttributes.getDuplexMode() != 0) {
                minMargins.setDuplexMode(printAttributes.getDuplexMode());
            }
            printAttributes2 = minMargins.setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build();
        }
        new a(cancellationSignal, printAttributes2, bitmap, printAttributes, i, parcelFileDescriptor, writeResultCallback).execute(new Void[0]);
    }

    public int getColorMode() {
        return this.e;
    }

    public int getOrientation() {
        int i = this.f;
        if (i == 0) {
            return 1;
        }
        return i;
    }

    public int getScaleMode() {
        return this.d;
    }

    public void printBitmap(@NonNull String str, @NonNull Bitmap bitmap) {
        printBitmap(str, bitmap, (OnPrintFinishCallback) null);
    }

    public void setColorMode(int i) {
        this.e = i;
    }

    public void setOrientation(int i) {
        this.f = i;
    }

    public void setScaleMode(int i) {
        this.d = i;
    }

    public void printBitmap(@NonNull String str, @NonNull Bitmap bitmap, @Nullable OnPrintFinishCallback onPrintFinishCallback) {
        PrintAttributes.MediaSize mediaSize;
        if (bitmap != null) {
            PrintManager printManager = (PrintManager) this.a.getSystemService("print");
            if (bitmap.getWidth() <= bitmap.getHeight()) {
                mediaSize = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
            } else {
                mediaSize = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
            }
            printManager.print(str, new b(str, this.d, bitmap, onPrintFinishCallback), new PrintAttributes.Builder().setMediaSize(mediaSize).setColorMode(this.e).build());
        }
    }

    public void printBitmap(@NonNull String str, @NonNull Uri uri) throws FileNotFoundException {
        printBitmap(str, uri, (OnPrintFinishCallback) null);
    }

    public void printBitmap(@NonNull String str, @NonNull Uri uri, @Nullable OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException {
        c cVar = new c(str, uri, onPrintFinishCallback, this.d);
        PrintManager printManager = (PrintManager) this.a.getSystemService("print");
        PrintAttributes.Builder builder = new PrintAttributes.Builder();
        builder.setColorMode(this.e);
        int i = this.f;
        if (i == 1 || i == 0) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
        } else if (i == 2) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
        }
        printManager.print(str, cVar, builder.build());
    }
}
