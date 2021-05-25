package a2.m.a.d.a;

import android.media.MediaCodec;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.internal.Pool;
import com.otaliastudios.cameraview.video.encoding.OutputBuffer;
@RequiresApi(18)
public class j extends Pool<OutputBuffer> {

    public class a implements Pool.Factory<OutputBuffer> {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.otaliastudios.cameraview.internal.Pool.Factory
        public OutputBuffer create() {
            OutputBuffer outputBuffer = new OutputBuffer();
            outputBuffer.trackIndex = this.a;
            outputBuffer.info = new MediaCodec.BufferInfo();
            return outputBuffer;
        }
    }

    public j(int i) {
        super(Integer.MAX_VALUE, new a(i));
    }
}
