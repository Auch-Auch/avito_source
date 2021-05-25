package a2.a.a.t.c;

import com.avito.android.blueprints.video.VideoItemPresenterImpl;
import com.avito.android.category_parameters.ParameterElement;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function0<Unit> {
    public final /* synthetic */ VideoItemPresenterImpl a;
    public final /* synthetic */ ParameterElement.Video b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(VideoItemPresenterImpl videoItemPresenterImpl, ParameterElement.Video video) {
        super(0);
        this.a = videoItemPresenterImpl;
        this.b = video;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.c.accept(this.b);
        return Unit.INSTANCE;
    }
}
