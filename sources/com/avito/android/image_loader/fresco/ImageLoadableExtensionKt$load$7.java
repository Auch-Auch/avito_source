package com.avito.android.image_loader.fresco;

import android.graphics.drawable.Drawable;
import com.avito.android.design.ImageLoadable;
import com.avito.android.design.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/graphics/drawable/Drawable;", "drawable", "", "invoke", "(Landroid/graphics/drawable/Drawable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ImageLoadableExtensionKt$load$7 extends Lambda implements Function1<Drawable, Unit> {
    public final /* synthetic */ ImageLoadable a;
    public final /* synthetic */ Function1 b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageLoadableExtensionKt$load$7(ImageLoadable imageLoadable, Function1 function1) {
        super(1);
        this.a = imageLoadable;
        this.b = function1;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
        invoke(drawable);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.a.setState(State.LOADED);
        this.b.invoke(drawable);
    }
}
