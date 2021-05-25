package a2.m.a.d.a;

import com.otaliastudios.cameraview.internal.Pool;
import com.otaliastudios.cameraview.video.encoding.InputBuffer;
public class d extends Pool<InputBuffer> {

    public class a implements Pool.Factory<InputBuffer> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.otaliastudios.cameraview.internal.Pool.Factory
        public InputBuffer create() {
            return new InputBuffer();
        }
    }

    public d() {
        super(Integer.MAX_VALUE, new a());
    }
}
