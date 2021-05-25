package a2.j.e.d.d.a;

import android.os.Process;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.IdManager;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;
public class e {
    public static final AtomicLong a = new AtomicLong(0);
    public static String b;

    public e(IdManager idManager) {
        long time = new Date().getTime();
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) (time / 1000));
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        byte[] array = allocate.array();
        byte[] a3 = a(time % 1000);
        byte[] a4 = a(a.incrementAndGet());
        byte[] a5 = a((long) Integer.valueOf(Process.myPid()).shortValue());
        byte[] bArr = {array[0], array[1], array[2], array[3], a3[0], a3[1], a4[0], a4[1], a5[0], a5[1]};
        String sha1 = CommonUtils.sha1(idManager.getCrashlyticsInstallId());
        String hexify = CommonUtils.hexify(bArr);
        Locale locale = Locale.US;
        b = String.format(locale, "%s-%s-%s-%s", hexify.substring(0, 12), hexify.substring(12, 16), hexify.subSequence(16, 20), sha1.substring(0, 12)).toUpperCase(locale);
    }

    public static byte[] a(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) ((int) j));
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    public String toString() {
        return b;
    }
}
