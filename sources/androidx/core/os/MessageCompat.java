package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Message;
import androidx.annotation.NonNull;
public final class MessageCompat {
    public static boolean a = true;
    public static boolean b = true;

    @SuppressLint({"NewApi"})
    public static boolean isAsynchronous(@NonNull Message message) {
        if (Build.VERSION.SDK_INT >= 22) {
            return message.isAsynchronous();
        }
        if (b) {
            try {
                return message.isAsynchronous();
            } catch (NoSuchMethodError unused) {
                b = false;
            }
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    public static void setAsynchronous(@NonNull Message message, boolean z) {
        if (Build.VERSION.SDK_INT >= 22) {
            message.setAsynchronous(z);
        } else if (a) {
            try {
                message.setAsynchronous(z);
            } catch (NoSuchMethodError unused) {
                a = false;
            }
        }
    }
}
