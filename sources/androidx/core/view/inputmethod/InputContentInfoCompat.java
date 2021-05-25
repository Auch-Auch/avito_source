package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
public final class InputContentInfoCompat {
    public final c a;

    public static final class b implements c {
        @NonNull
        public final Uri a;
        @NonNull
        public final ClipDescription b;
        @Nullable
        public final Uri c;

        public b(@NonNull Uri uri, @NonNull ClipDescription clipDescription, @Nullable Uri uri2) {
            this.a = uri;
            this.b = clipDescription;
            this.c = uri2;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        @Nullable
        public Object a() {
            return null;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        public void b() {
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        @Nullable
        public Uri c() {
            return this.c;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        public void d() {
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        @NonNull
        public Uri getContentUri() {
            return this.a;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        @NonNull
        public ClipDescription getDescription() {
            return this.b;
        }
    }

    public interface c {
        @Nullable
        Object a();

        void b();

        @Nullable
        Uri c();

        void d();

        @NonNull
        Uri getContentUri();

        @NonNull
        ClipDescription getDescription();
    }

    public InputContentInfoCompat(@NonNull Uri uri, @NonNull ClipDescription clipDescription, @Nullable Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.a = new a(uri, clipDescription, uri2);
        } else {
            this.a = new b(uri, clipDescription, uri2);
        }
    }

    @Nullable
    public static InputContentInfoCompat wrap(@Nullable Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 25) {
            return new InputContentInfoCompat(new a(obj));
        }
        return null;
    }

    @NonNull
    public Uri getContentUri() {
        return this.a.getContentUri();
    }

    @NonNull
    public ClipDescription getDescription() {
        return this.a.getDescription();
    }

    @Nullable
    public Uri getLinkUri() {
        return this.a.c();
    }

    public void releasePermission() {
        this.a.d();
    }

    public void requestPermission() {
        this.a.b();
    }

    @Nullable
    public Object unwrap() {
        return this.a.a();
    }

    @RequiresApi(25)
    public static final class a implements c {
        @NonNull
        public final InputContentInfo a;

        public a(@NonNull Object obj) {
            this.a = (InputContentInfo) obj;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        @Nullable
        public Object a() {
            return this.a;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        public void b() {
            this.a.requestPermission();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        @Nullable
        public Uri c() {
            return this.a.getLinkUri();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        public void d() {
            this.a.releasePermission();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        @NonNull
        public Uri getContentUri() {
            return this.a.getContentUri();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        @NonNull
        public ClipDescription getDescription() {
            return this.a.getDescription();
        }

        public a(@NonNull Uri uri, @NonNull ClipDescription clipDescription, @Nullable Uri uri2) {
            this.a = new InputContentInfo(uri, clipDescription, uri2);
        }
    }

    public InputContentInfoCompat(@NonNull c cVar) {
        this.a = cVar;
    }
}
