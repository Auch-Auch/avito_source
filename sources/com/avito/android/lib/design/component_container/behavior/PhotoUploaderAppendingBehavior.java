package com.avito.android.lib.design.component_container.behavior;

import android.content.Context;
import com.avito.android.lib.design.component_container.ComponentBehavior;
import com.avito.android.lib.design.component_container.ComponentContainer;
import com.avito.android.lib.design.photo_uploader_appending.PhotoUploaderAppending;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/avito/android/lib/design/component_container/behavior/PhotoUploaderAppendingBehavior;", "Lcom/avito/android/lib/design/component_container/ComponentBehavior;", "Lcom/avito/android/lib/design/photo_uploader_appending/PhotoUploaderAppending;", "view", "", "onAttachView", "(Lcom/avito/android/lib/design/photo_uploader_appending/PhotoUploaderAppending;)V", "onDetachView", "Lcom/avito/android/lib/design/component_container/ComponentContainer$State;", "state", "onStateChanged", "(Lcom/avito/android/lib/design/component_container/ComponentContainer$State;)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "components_release"}, k = 1, mv = {1, 4, 2})
public class PhotoUploaderAppendingBehavior extends ComponentBehavior<PhotoUploaderAppending> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhotoUploaderAppendingBehavior(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void onAttachView(@NotNull PhotoUploaderAppending photoUploaderAppending) {
        Intrinsics.checkNotNullParameter(photoUploaderAppending, "view");
    }

    public void onDetachView(@NotNull PhotoUploaderAppending photoUploaderAppending) {
        Intrinsics.checkNotNullParameter(photoUploaderAppending, "view");
    }

    @Override // com.avito.android.lib.design.component_container.ComponentBehavior
    public void onStateChanged(@NotNull ComponentContainer.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        PhotoUploaderAppending photoUploaderAppending = (PhotoUploaderAppending) getView();
        if (photoUploaderAppending != null) {
            photoUploaderAppending.setState(state.getIntArray());
        }
    }
}
