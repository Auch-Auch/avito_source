package a2.m.a.d.a;

import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.video.encoding.AudioConfig;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Random;
public class a {
    public static final Random b = new Random();
    public final ByteBuffer a;

    public a(@NonNull AudioConfig audioConfig) {
        audioConfig.getClass();
        this.a = ByteBuffer.allocateDirect(audioConfig.channels * 1024 * 1).order(ByteOrder.nativeOrder());
        double d = 0.0d;
        double d2 = 3.141592653589793d / (((double) (audioConfig.channels * 1024)) / 2.0d);
        while (this.a.hasRemaining()) {
            d += 1.0d;
            short sin = (short) ((int) (Math.sin(d * d2) * 10.0d));
            this.a.put((byte) sin);
            this.a.put((byte) (sin >> 8));
        }
        this.a.rewind();
    }
}
