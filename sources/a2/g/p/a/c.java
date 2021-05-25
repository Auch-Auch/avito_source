package a2.g.p.a;

import com.facebook.cache.common.WriterCallback;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.IOException;
import java.io.OutputStream;
public class c implements WriterCallback {
    public final /* synthetic */ EncodedImage a;
    public final /* synthetic */ BufferedDiskCache b;

    public c(BufferedDiskCache bufferedDiskCache, EncodedImage encodedImage) {
        this.b = bufferedDiskCache;
        this.a = encodedImage;
    }

    @Override // com.facebook.cache.common.WriterCallback
    public void write(OutputStream outputStream) throws IOException {
        this.b.c.copy(this.a.getInputStream(), outputStream);
    }
}
