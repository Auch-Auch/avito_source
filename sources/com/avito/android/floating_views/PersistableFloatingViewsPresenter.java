package com.avito.android.floating_views;

import android.os.Bundle;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lcom/avito/android/floating_views/PersistableFloatingViewsPresenter;", "Lcom/avito/android/floating_views/FloatingViewsPresenter;", "Landroid/os/Bundle;", "onSaveState", "()Landroid/os/Bundle;", "savedInstanceState", "", "onRestoreState", "(Landroid/os/Bundle;)V", "reset", "()V", "updateVisibility", "floating-views_release"}, k = 1, mv = {1, 4, 2})
public interface PersistableFloatingViewsPresenter extends FloatingViewsPresenter {
    void onRestoreState(@Nullable Bundle bundle);

    @Nullable
    Bundle onSaveState();

    void reset();

    void updateVisibility();
}
