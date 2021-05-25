package com.avito.android.messenger.search;

import com.avito.android.ui.fragments.OnBackPressedListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/search/BackPressAware;", "", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "addOnBackPressListener", "(Lcom/avito/android/ui/fragments/OnBackPressedListener;)V", "removeOnBackPressListener", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface BackPressAware {
    void addOnBackPressListener(@NotNull OnBackPressedListener onBackPressedListener);

    void removeOnBackPressListener(@NotNull OnBackPressedListener onBackPressedListener);
}
