package com.avito.android.auto_catalog;

import android.content.Intent;
import androidx.annotation.StringRes;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.model.ParcelableEntity;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJG\u0010\u0013\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00100\u000f2\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00100\u000fH&¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u00022\b\b\u0001\u0010\u0015\u001a\u00020\tH&¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/avito/android/auto_catalog/AutoCatalogFragmentDelegate;", "Lcom/avito/android/auto_catalog/AutoCatalogFragmentManagerDelegate;", "", "closeScreen", "()V", "Landroid/content/Intent;", "intent", "launchActivity", "(Landroid/content/Intent;)V", "", "requestId", "launchActivityForResult", "(Landroid/content/Intent;I)V", "", "title", "", "Lcom/avito/android/remote/model/ParcelableEntity;", "selectedValue", ResidentialComplexModuleKt.VALUES, "launchSelectScreenForResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "stringId", "launchToast", "(I)V", "Lcom/avito/android/bottom_navigation/NavigationTab;", "tab", "()Lcom/avito/android/bottom_navigation/NavigationTab;", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
public interface AutoCatalogFragmentDelegate extends AutoCatalogFragmentManagerDelegate {
    void closeScreen();

    void launchActivity(@Nullable Intent intent);

    void launchActivityForResult(@Nullable Intent intent, int i);

    void launchSelectScreenForResult(@NotNull String str, @NotNull String str2, @NotNull List<? extends ParcelableEntity<String>> list, @NotNull List<? extends ParcelableEntity<String>> list2);

    void launchToast(@StringRes int i);

    @Nullable
    NavigationTab tab();
}
