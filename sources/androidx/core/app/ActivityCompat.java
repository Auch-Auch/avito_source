package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.DragEvent;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.SharedElementCallback;
import androidx.core.content.ContextCompat;
import androidx.core.view.DragAndDropPermissionsCompat;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import l6.h.a.d;
public class ActivityCompat extends ContextCompat {
    public static PermissionCompatDelegate b;

    public interface OnRequestPermissionsResultCallback {
        @Override // androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
        void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    public interface PermissionCompatDelegate {
        boolean onActivityResult(@NonNull Activity activity, @IntRange(from = 0) int i, int i2, @Nullable Intent intent);

        boolean requestPermissions(@NonNull Activity activity, @NonNull String[] strArr, @IntRange(from = 0) int i);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int i);
    }

    public class a implements Runnable {
        public final /* synthetic */ String[] a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ int c;

        public a(String[] strArr, Activity activity, int i) {
            this.a = strArr;
            this.b = activity;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.a.length];
            PackageManager packageManager = this.b.getPackageManager();
            String packageName = this.b.getPackageName();
            int length = this.a.length;
            for (int i = 0; i < length; i++) {
                iArr[i] = packageManager.checkPermission(this.a[i], packageName);
            }
            ((OnRequestPermissionsResultCallback) this.b).onRequestPermissionsResult(this.c, this.a, iArr);
        }
    }

    @RequiresApi(21)
    public static class b extends SharedElementCallback {
        public final SharedElementCallback a;

        public class a implements SharedElementCallback.OnSharedElementsReadyListener {
            public final /* synthetic */ SharedElementCallback.OnSharedElementsReadyListener a;

            public a(b bVar, SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
                this.a = onSharedElementsReadyListener;
            }

            @Override // androidx.core.app.SharedElementCallback.OnSharedElementsReadyListener
            public void onSharedElementsReady() {
                this.a.onSharedElementsReady();
            }
        }

        public b(SharedElementCallback sharedElementCallback) {
            this.a = sharedElementCallback;
        }

        @Override // android.app.SharedElementCallback
        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.a.onCaptureSharedElementSnapshot(view, matrix, rectF);
        }

        @Override // android.app.SharedElementCallback
        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.a.onCreateSnapshotView(context, parcelable);
        }

        @Override // android.app.SharedElementCallback
        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.a.onMapSharedElements(list, map);
        }

        @Override // android.app.SharedElementCallback
        public void onRejectSharedElements(List<View> list) {
            this.a.onRejectSharedElements(list);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.a.onSharedElementEnd(list, list2, list3);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.a.onSharedElementStart(list, list2, list3);
        }

        @Override // android.app.SharedElementCallback
        @RequiresApi(23)
        public void onSharedElementsArrived(List<String> list, List<View> list2, SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            this.a.onSharedElementsArrived(list, list2, new a(this, onSharedElementsReadyListener));
        }
    }

    public static void finishAffinity(@NonNull Activity activity) {
        activity.finishAffinity();
    }

    public static void finishAfterTransition(@NonNull Activity activity) {
        activity.finishAfterTransition();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static PermissionCompatDelegate getPermissionCompatDelegate() {
        return b;
    }

    @Nullable
    public static Uri getReferrer(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= 22) {
            return activity.getReferrer();
        }
        Intent intent = activity.getIntent();
        Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.REFERRER");
        if (uri != null) {
            return uri;
        }
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (stringExtra != null) {
            return Uri.parse(stringExtra);
        }
        return null;
    }

    @Deprecated
    public static boolean invalidateOptionsMenu(Activity activity) {
        activity.invalidateOptionsMenu();
        return true;
    }

    public static void postponeEnterTransition(@NonNull Activity activity) {
        activity.postponeEnterTransition();
    }

    public static void recreate(@NonNull Activity activity) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            activity.recreate();
            return;
        }
        Class<?> cls = d.a;
        boolean z = true;
        if (i >= 28) {
            activity.recreate();
        } else {
            if ((!d.a() || d.f != null) && !(d.e == null && d.d == null)) {
                try {
                    Object obj = d.c.get(activity);
                    if (obj != null) {
                        Object obj2 = d.b.get(activity);
                        if (obj2 != null) {
                            Application application = activity.getApplication();
                            d.a aVar = new d.a(activity);
                            application.registerActivityLifecycleCallbacks(aVar);
                            Handler handler = d.g;
                            handler.post(new l6.h.a.a(aVar, obj));
                            try {
                                if (d.a()) {
                                    Method method = d.f;
                                    Boolean bool = Boolean.FALSE;
                                    method.invoke(obj2, obj, null, null, 0, bool, null, null, bool, bool);
                                } else {
                                    activity.recreate();
                                }
                                handler.post(new l6.h.a.b(application, aVar));
                            } catch (Throwable th) {
                                d.g.post(new l6.h.a.b(application, aVar));
                                throw th;
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            z = false;
        }
        if (!z) {
            activity.recreate();
        }
    }

    @Nullable
    public static DragAndDropPermissionsCompat requestDragAndDropPermissions(Activity activity, DragEvent dragEvent) {
        return DragAndDropPermissionsCompat.request(activity, dragEvent);
    }

    public static void requestPermissions(@NonNull Activity activity, @NonNull String[] strArr, @IntRange(from = 0) int i) {
        PermissionCompatDelegate permissionCompatDelegate = b;
        if (permissionCompatDelegate != null && permissionCompatDelegate.requestPermissions(activity, strArr, i)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity instanceof RequestPermissionsRequestCodeValidator) {
                ((RequestPermissionsRequestCodeValidator) activity).validateRequestPermissionsRequestCode(i);
            }
            activity.requestPermissions(strArr, i);
        } else if (activity instanceof OnRequestPermissionsResultCallback) {
            new Handler(Looper.getMainLooper()).post(new a(strArr, activity, i));
        }
    }

    @NonNull
    public static <T extends View> T requireViewById(@NonNull Activity activity, @IdRes int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T) activity.requireViewById(i);
        }
        T t = (T) activity.findViewById(i);
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this Activity");
    }

    public static void setEnterSharedElementCallback(@NonNull Activity activity, @Nullable SharedElementCallback sharedElementCallback) {
        activity.setEnterSharedElementCallback(sharedElementCallback != null ? new b(sharedElementCallback) : null);
    }

    public static void setExitSharedElementCallback(@NonNull Activity activity, @Nullable SharedElementCallback sharedElementCallback) {
        activity.setExitSharedElementCallback(sharedElementCallback != null ? new b(sharedElementCallback) : null);
    }

    public static void setPermissionCompatDelegate(@Nullable PermissionCompatDelegate permissionCompatDelegate) {
        b = permissionCompatDelegate;
    }

    public static boolean shouldShowRequestPermissionRationale(@NonNull Activity activity, @NonNull String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }

    public static void startActivityForResult(@NonNull Activity activity, @NonNull Intent intent, int i, @Nullable Bundle bundle) {
        activity.startActivityForResult(intent, i, bundle);
    }

    public static void startIntentSenderForResult(@NonNull Activity activity, @NonNull IntentSender intentSender, int i, @Nullable Intent intent, int i2, int i3, int i4, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    public static void startPostponedEnterTransition(@NonNull Activity activity) {
        activity.startPostponedEnterTransition();
    }
}
