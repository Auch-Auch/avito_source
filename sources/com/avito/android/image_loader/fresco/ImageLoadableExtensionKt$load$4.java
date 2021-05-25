package com.avito.android.image_loader.fresco;

import com.avito.android.design.ImageLoadable;
import com.avito.android.design.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ImageLoadableExtensionKt$load$4 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ ImageLoadable a;
    public final /* synthetic */ Function0 b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageLoadableExtensionKt$load$4(ImageLoadable imageLoadable, Function0 function0) {
        super(0);
        this.a = imageLoadable;
        this.b = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        this.a.setState(State.ERROR);
        this.b.invoke();
    }
}
