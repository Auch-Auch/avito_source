package com.my.target;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.File;
import java.util.HashSet;
import java.util.List;
public final class ez extends fb {
    public boolean b = false;

    public class a implements Runnable {
        public a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0099, code lost:
            if (r9 != null) goto L_0x009b;
         */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x00fe  */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x00aa A[SYNTHETIC] */
        @Override // java.lang.Runnable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            // Method dump skipped, instructions count: 269
            */
            throw new UnsupportedOperationException("Method not decompiled: com.my.target.ez.a.run():void");
        }
    }

    @RequiresApi(api = 21)
    public static boolean d(@Nullable File file) {
        if (file == null) {
            return false;
        }
        return Environment.isExternalStorageRemovable(file) || !Environment.isExternalStorageEmulated(file);
    }

    public final void b(@NonNull Context context) {
        List<InputMethodInfo> enabledInputMethodList;
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (!(inputMethodManager == null || (enabledInputMethodList = inputMethodManager.getEnabledInputMethodList()) == null)) {
            HashSet hashSet = null;
            for (InputMethodInfo inputMethodInfo : enabledInputMethodList) {
                List<InputMethodSubtype> enabledInputMethodSubtypeList = inputMethodManager.getEnabledInputMethodSubtypeList(inputMethodInfo, true);
                if (enabledInputMethodSubtypeList != null) {
                    for (InputMethodSubtype inputMethodSubtype : enabledInputMethodSubtypeList) {
                        if ("keyboard".equals(inputMethodSubtype.getMode())) {
                            String locale = inputMethodSubtype.getLocale();
                            if (!TextUtils.isEmpty(locale)) {
                                if (hashSet == null) {
                                    hashSet = new HashSet();
                                }
                                hashSet.add(locale.split("_", 2)[0]);
                            }
                        }
                    }
                }
            }
            if (!(hashSet == null || hashSet.isEmpty())) {
                String join = TextUtils.join(",", hashSet);
                if (!TextUtils.isEmpty(join)) {
                    addParam("kb_lang", join);
                }
            }
        }
    }

    public final void c(@NonNull Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            long totalSpace = filesDir.getTotalSpace();
            long freeSpace = filesDir.getFreeSpace();
            addParam("mm_tt", String.valueOf(totalSpace));
            addParam("mm_av", String.valueOf(freeSpace));
            File file = null;
            File[] externalFilesDirs = context.getExternalFilesDirs(null);
            if (externalFilesDirs != null && externalFilesDirs.length != 0) {
                int length = externalFilesDirs.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        File file2 = externalFilesDirs[i];
                        if (d(file2)) {
                            file = file2;
                            break;
                        }
                        i++;
                    } else {
                        File externalFilesDir = context.getExternalFilesDir(null);
                        if (d(externalFilesDir)) {
                            file = externalFilesDir;
                        }
                    }
                }
            }
            if (file != null) {
                long totalSpace2 = file.getTotalSpace();
                long freeSpace2 = file.getFreeSpace();
                if (freeSpace != freeSpace2 || totalSpace != totalSpace2) {
                    addParam("emm_tt", String.valueOf(totalSpace2));
                    addParam("emm_av", String.valueOf(freeSpace2));
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x01ea A[Catch:{ all -> 0x01fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01eb A[Catch:{ all -> 0x01fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0291 A[LOOP:0: B:113:0x028b->B:115:0x0291, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b6 A[SYNTHETIC, Splitter:B:28:0x00b6] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00bf A[Catch:{ all -> 0x00cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01a6  */
    @Override // com.my.target.fb
    @android.annotation.SuppressLint({"HardwareIds"})
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void collectData(@androidx.annotation.NonNull android.content.Context r26) {
        /*
        // Method dump skipped, instructions count: 711
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.ez.collectData(android.content.Context):void");
    }
}
