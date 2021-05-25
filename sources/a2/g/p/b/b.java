package a2.g.p.b;

import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
public class b implements Supplier<Boolean> {
    public b(ImagePipelineConfig imagePipelineConfig) {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.facebook.common.internal.Supplier
    public /* bridge */ /* synthetic */ Boolean get() {
        return Boolean.TRUE;
    }
}
