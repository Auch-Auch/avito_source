package a2.d.a.d.a.a;

import android.content.ContentResolver;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.util.List;
public class c {
    public static final a e = new a();
    public final b a;
    public final ArrayPool b;
    public final ContentResolver c;
    public final List<ImageHeaderParser> d;

    public c(List<ImageHeaderParser> list, b bVar, ArrayPool arrayPool, ContentResolver contentResolver) {
        this.a = bVar;
        this.b = arrayPool;
        this.c = contentResolver;
        this.d = list;
    }
}
