package com.avito.android.user_adverts.root_screen.adverts_host.publish_button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/avito/android/user_adverts/root_screen/adverts_host/publish_button/PublishButtonBehavior$visibilityChangeListener$1", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton$OnVisibilityChangedListener;", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "floatingActionButon", "", "onHidden", "(Lcom/google/android/material/floatingactionbutton/FloatingActionButton;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class PublishButtonBehavior$visibilityChangeListener$1 extends FloatingActionButton.OnVisibilityChangedListener {
    @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener
    public void onHidden(@NotNull FloatingActionButton floatingActionButton) {
        Intrinsics.checkNotNullParameter(floatingActionButton, "floatingActionButon");
        super.onHidden(floatingActionButton);
        floatingActionButton.setVisibility(4);
    }
}
