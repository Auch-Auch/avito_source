package a2.d.a.d.b;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;
public class f<DataType> implements DiskCache.Writer {
    public final Encoder<DataType> a;
    public final DataType b;
    public final Options c;

    public f(Encoder<DataType> encoder, DataType datatype, Options options) {
        this.a = encoder;
        this.b = datatype;
        this.c = options;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache.Writer
    public boolean write(@NonNull File file) {
        return this.a.encode(this.b, file, this.c);
    }
}
