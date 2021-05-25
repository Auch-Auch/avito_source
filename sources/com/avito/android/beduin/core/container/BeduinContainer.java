package com.avito.android.beduin.core.container;

import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.beduin.core.action.BeduinActionHandler;
import com.avito.android.beduin.core.component.BeduinComponent;
import com.avito.android.beduin.core.model.container.BeduinContainerModel;
import com.avito.android.beduin.core.model.container.component.BeduinModel;
import com.avito.android.beduin.util.ViewGroupsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0004¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0016@\u0016XD¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR8\u0010\u0016\u001a$\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00030\u00050\u0010j\u0002`\u00138&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/beduin/core/container/BeduinContainer;", "Lcom/avito/android/beduin/core/model/container/BeduinContainerModel;", "T", "Landroid/view/View;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/avito/android/beduin/core/component/BeduinComponent;", "Landroid/view/ViewGroup;", "viewGroup", "", "setupBasics", "(Landroid/view/ViewGroup;)V", "", "defaultHorizontalMargin", "I", "getDefaultHorizontalMargin", "()I", "Lkotlin/Function2;", "Lcom/avito/android/beduin/core/model/container/component/BeduinModel;", "Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "Lcom/avito/android/beduin/core/container/BeduinChildResolver;", "getChildResolver", "()Lkotlin/jvm/functions/Function2;", "childResolver", "<init>", "()V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public abstract class BeduinContainer<T extends BeduinContainerModel, V extends View> extends BeduinComponent<T, V> {
    @NotNull
    public abstract Function2<BeduinModel, BeduinActionHandler, BeduinComponent<BeduinModel, View>> getChildResolver();

    @Override // com.avito.android.beduin.core.component.BeduinComponent
    public int getDefaultHorizontalMargin() {
        return 0;
    }

    public final void setupBasics(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        viewGroup.removeAllViews();
        ViewGroupsKt.setupBackground(viewGroup, ((BeduinContainerModel) getModel()).getBackground());
        ViewGroupsKt.setupPadding(viewGroup, ((BeduinContainerModel) getModel()).getPadding());
        ViewGroupsKt.setupMargin(viewGroup, ((BeduinContainerModel) getModel()).getMargin());
    }
}
