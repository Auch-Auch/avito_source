package a2.a.a.a.d;

import com.avito.android.component.emotion_selector.ImageSelectorView;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function2<ImageSelectorView.Image, Float, Unit> {
    public static final a a = new a();

    public a() {
        super(2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(ImageSelectorView.Image image, Float f) {
        ImageSelectorView.Image image2 = image;
        float floatValue = f.floatValue();
        Intrinsics.checkNotNullParameter(image2, "$receiver");
        image2.changeScale(floatValue);
        return Unit.INSTANCE;
    }
}
