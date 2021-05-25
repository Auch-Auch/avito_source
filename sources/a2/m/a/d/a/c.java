package a2.m.a.d.a;

import com.otaliastudios.cameraview.internal.Pool;
import java.nio.ByteBuffer;
public class c extends Pool<ByteBuffer> {

    public class a implements Pool.Factory<ByteBuffer> {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.otaliastudios.cameraview.internal.Pool.Factory
        public ByteBuffer create() {
            return ByteBuffer.allocateDirect(this.a);
        }
    }

    public c(int i, int i2) {
        super(i2, new a(i));
    }
}
