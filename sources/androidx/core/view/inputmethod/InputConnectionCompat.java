package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.os.Build;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public final class InputConnectionCompat {
    public static final int INPUT_CONTENT_GRANT_READ_URI_PERMISSION = 1;

    public interface OnCommitContentListener {
        boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle);
    }

    public class a extends InputConnectionWrapper {
        public final /* synthetic */ OnCommitContentListener a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(InputConnection inputConnection, boolean z, OnCommitContentListener onCommitContentListener) {
            super(inputConnection, z);
            this.a = onCommitContentListener;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
            if (this.a.onCommitContent(InputContentInfoCompat.wrap(inputContentInfo), i, bundle)) {
                return true;
            }
            return super.commitContent(inputContentInfo, i, bundle);
        }
    }

    public class b extends InputConnectionWrapper {
        public final /* synthetic */ OnCommitContentListener a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(InputConnection inputConnection, boolean z, OnCommitContentListener onCommitContentListener) {
            super(inputConnection, z);
            this.a = onCommitContentListener;
        }

        /* JADX WARNING: Removed duplicated region for block: B:44:0x0081  */
        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean performPrivateCommand(java.lang.String r12, android.os.Bundle r13) {
            /*
                r11 = this;
                androidx.core.view.inputmethod.InputConnectionCompat$OnCommitContentListener r0 = r11.a
                r1 = 1
                r2 = 0
                if (r13 != 0) goto L_0x0008
                goto L_0x0085
            L_0x0008:
                java.lang.String r3 = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT"
                boolean r3 = android.text.TextUtils.equals(r3, r12)
                if (r3 == 0) goto L_0x0012
                r3 = 0
                goto L_0x001b
            L_0x0012:
                java.lang.String r3 = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT"
                boolean r3 = android.text.TextUtils.equals(r3, r12)
                if (r3 == 0) goto L_0x0085
                r3 = 1
            L_0x001b:
                r4 = 0
                if (r3 == 0) goto L_0x0021
                java.lang.String r5 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER"
                goto L_0x0023
            L_0x0021:
                java.lang.String r5 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER"
            L_0x0023:
                android.os.Parcelable r5 = r13.getParcelable(r5)     // Catch:{ all -> 0x007d }
                android.os.ResultReceiver r5 = (android.os.ResultReceiver) r5     // Catch:{ all -> 0x007d }
                if (r3 == 0) goto L_0x002e
                java.lang.String r6 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI"
                goto L_0x0030
            L_0x002e:
                java.lang.String r6 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI"
            L_0x0030:
                android.os.Parcelable r6 = r13.getParcelable(r6)     // Catch:{ all -> 0x007b }
                android.net.Uri r6 = (android.net.Uri) r6     // Catch:{ all -> 0x007b }
                if (r3 == 0) goto L_0x003b
                java.lang.String r7 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION"
                goto L_0x003d
            L_0x003b:
                java.lang.String r7 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION"
            L_0x003d:
                android.os.Parcelable r7 = r13.getParcelable(r7)     // Catch:{ all -> 0x007b }
                android.content.ClipDescription r7 = (android.content.ClipDescription) r7     // Catch:{ all -> 0x007b }
                if (r3 == 0) goto L_0x0048
                java.lang.String r8 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI"
                goto L_0x004a
            L_0x0048:
                java.lang.String r8 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI"
            L_0x004a:
                android.os.Parcelable r8 = r13.getParcelable(r8)     // Catch:{ all -> 0x007b }
                android.net.Uri r8 = (android.net.Uri) r8     // Catch:{ all -> 0x007b }
                if (r3 == 0) goto L_0x0055
                java.lang.String r9 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS"
                goto L_0x0057
            L_0x0055:
                java.lang.String r9 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS"
            L_0x0057:
                int r9 = r13.getInt(r9)     // Catch:{ all -> 0x007b }
                if (r3 == 0) goto L_0x0060
                java.lang.String r3 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS"
                goto L_0x0062
            L_0x0060:
                java.lang.String r3 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS"
            L_0x0062:
                android.os.Parcelable r3 = r13.getParcelable(r3)     // Catch:{ all -> 0x007b }
                android.os.Bundle r3 = (android.os.Bundle) r3     // Catch:{ all -> 0x007b }
                if (r6 == 0) goto L_0x0075
                if (r7 == 0) goto L_0x0075
                androidx.core.view.inputmethod.InputContentInfoCompat r10 = new androidx.core.view.inputmethod.InputContentInfoCompat     // Catch:{ all -> 0x007b }
                r10.<init>(r6, r7, r8)     // Catch:{ all -> 0x007b }
                boolean r2 = r0.onCommitContent(r10, r9, r3)     // Catch:{ all -> 0x007b }
            L_0x0075:
                if (r5 == 0) goto L_0x0085
                r5.send(r2, r4)
                goto L_0x0085
            L_0x007b:
                r12 = move-exception
                goto L_0x007f
            L_0x007d:
                r12 = move-exception
                r5 = r4
            L_0x007f:
                if (r5 == 0) goto L_0x0084
                r5.send(r2, r4)
            L_0x0084:
                throw r12
            L_0x0085:
                if (r2 == 0) goto L_0x0088
                return r1
            L_0x0088:
                boolean r12 = super.performPrivateCommand(r12, r13)
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.inputmethod.InputConnectionCompat.b.performPrivateCommand(java.lang.String, android.os.Bundle):boolean");
        }
    }

    public static boolean commitContent(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo, @NonNull InputContentInfoCompat inputContentInfoCompat, int i, @Nullable Bundle bundle) {
        boolean z;
        char c;
        ClipDescription description = inputContentInfoCompat.getDescription();
        String[] contentMimeTypes = EditorInfoCompat.getContentMimeTypes(editorInfo);
        int length = contentMimeTypes.length;
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            } else if (description.hasMimeType(contentMimeTypes[i2])) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (!z) {
            return false;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 25) {
            return inputConnection.commitContent((InputContentInfo) inputContentInfoCompat.unwrap(), i, bundle);
        }
        if (i3 >= 25) {
            c = 1;
        } else {
            Bundle bundle2 = editorInfo.extras;
            if (bundle2 != null) {
                boolean containsKey = bundle2.containsKey("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
                boolean containsKey2 = editorInfo.extras.containsKey("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
                if (containsKey && containsKey2) {
                    c = 4;
                } else if (containsKey) {
                    c = 3;
                } else if (containsKey2) {
                    c = 2;
                }
            }
            c = 0;
        }
        if (c == 2) {
            z2 = true;
        } else if (!(c == 3 || c == 4)) {
            return false;
        }
        Bundle bundle3 = new Bundle();
        bundle3.putParcelable(z2 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI", inputContentInfoCompat.getContentUri());
        bundle3.putParcelable(z2 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION", inputContentInfoCompat.getDescription());
        bundle3.putParcelable(z2 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI", inputContentInfoCompat.getLinkUri());
        bundle3.putInt(z2 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS", i);
        bundle3.putParcelable(z2 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS", bundle);
        return inputConnection.performPrivateCommand(z2 ? "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT" : "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", bundle3);
    }

    @NonNull
    public static InputConnection createWrapper(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo, @NonNull OnCommitContentListener onCommitContentListener) {
        if (inputConnection == null) {
            throw new IllegalArgumentException("inputConnection must be non-null");
        } else if (editorInfo == null) {
            throw new IllegalArgumentException("editorInfo must be non-null");
        } else if (onCommitContentListener == null) {
            throw new IllegalArgumentException("onCommitContentListener must be non-null");
        } else if (Build.VERSION.SDK_INT >= 25) {
            return new a(inputConnection, false, onCommitContentListener);
        } else {
            if (EditorInfoCompat.getContentMimeTypes(editorInfo).length == 0) {
                return inputConnection;
            }
            return new b(inputConnection, false, onCommitContentListener);
        }
    }
}
