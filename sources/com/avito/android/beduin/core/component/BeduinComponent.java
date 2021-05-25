package com.avito.android.beduin.core.component;

import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.beduin.core.ComponentsContext;
import com.avito.android.beduin.core.action.BeduinAction;
import com.avito.android.beduin.core.action.BeduinActionHandler;
import com.avito.android.beduin.core.action.BeduinActionType;
import com.avito.android.beduin.core.model.container.component.BeduinModel;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ViewSizeKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0005B\u0007¢\u0006\u0004\b(\u0010\u0013J\u001f\u0010\n\u001a\u00028\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00028\u00012\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\"\u001a\u00020\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u001aR\u001c\u0010'\u001a\u00028\u00008&@&X¦\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/avito/android/beduin/core/component/BeduinComponent;", "Lcom/avito/android/beduin/core/model/container/component/BeduinModel;", "T", "Landroid/view/View;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "Landroid/view/ViewGroup;", "parent", "Landroid/view/ViewGroup$LayoutParams;", "layoutParams", "createView", "(Landroid/view/ViewGroup;Landroid/view/ViewGroup$LayoutParams;)Landroid/view/View;", "view", "Lcom/avito/android/beduin/core/ComponentsContext;", "ctx", "", "updateWithData", "(Landroid/view/View;Lcom/avito/android/beduin/core/ComponentsContext;)V", "handleClick", "()V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "getActionHandler", "()Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "actionHandler", AuthSource.SEND_ABUSE, "I", "getDefaultHorizontalMargin", "defaultHorizontalMargin", "getModel", "()Lcom/avito/android/beduin/core/model/container/component/BeduinModel;", "setModel", "(Lcom/avito/android/beduin/core/model/container/component/BeduinModel;)V", VerticalFilterCloseDialogEventKt.MODEL_DIALOG, "<init>", "beduin_release"}, k = 1, mv = {1, 4, 2})
public abstract class BeduinComponent<T extends BeduinModel, V extends View> {
    public final int a = ViewSizeKt.getDp(16);

    @NotNull
    public abstract V createView(@NotNull ViewGroup viewGroup, @NotNull ViewGroup.LayoutParams layoutParams);

    public boolean equals(@Nullable Object obj) {
        return Intrinsics.areEqual(getModel(), obj);
    }

    @NotNull
    public abstract BeduinActionHandler getActionHandler();

    public int getDefaultHorizontalMargin() {
        return this.a;
    }

    @NotNull
    public abstract T getModel();

    public final void handleClick() {
        List<BeduinAction> actions = getModel().getActions();
        if (actions != null) {
            ArrayList<BeduinAction> arrayList = new ArrayList();
            for (T t : actions) {
                T t2 = t;
                if (t2.getActionType() == BeduinActionType.ON_CLICK || t2.getActionType() == null) {
                    arrayList.add(t);
                }
            }
            for (BeduinAction beduinAction : arrayList) {
                getActionHandler().handle(beduinAction);
            }
        }
    }

    public int hashCode() {
        return getModel().hashCode();
    }

    public abstract void setModel(@NotNull T t);

    public abstract void updateWithData(@NotNull V v, @NotNull ComponentsContext componentsContext);
}
