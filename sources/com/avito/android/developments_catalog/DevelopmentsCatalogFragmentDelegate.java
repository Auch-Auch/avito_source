package com.avito.android.developments_catalog;

import android.content.Intent;
import androidx.annotation.StringRes;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\tH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/developments_catalog/DevelopmentsCatalogFragmentDelegate;", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogFragmentManagerDelegate;", "", "closeScreen", "()V", "Landroid/content/Intent;", "intent", "launchActivity", "(Landroid/content/Intent;)V", "", "requestId", "launchActivityForResult", "(Landroid/content/Intent;I)V", "stringId", "launchToast", "(I)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public interface DevelopmentsCatalogFragmentDelegate extends DevelopmentsCatalogFragmentManagerDelegate {
    void closeScreen();

    void launchActivity(@Nullable Intent intent);

    void launchActivityForResult(@Nullable Intent intent, int i);

    void launchToast(@StringRes int i);
}
