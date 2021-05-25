package com.avito.android.select.di;

import com.avito.android.ab_tests.AutoBrandModelTypoCorrection;
import com.avito.android.ab_tests.AutoGenerationsFilterWithPhotos;
import com.avito.android.ab_tests.groups.AutoBrandModelTypoCorrectionTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.remote.SearchApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H'¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H'¢\u0006\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/select/di/SelectDialogDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/remote/SearchApi;", "searchApi", "()Lcom/avito/android/remote/SearchApi;", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/AutoBrandModelTypoCorrectionTestGroup;", "autoBrandModelTypoCorrectionTestGroup", "()Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroup;", "autoGenerationsFilterWithPhotosTestGroup", "select_release"}, k = 1, mv = {1, 4, 2})
public interface SelectDialogDependencies extends CoreComponentDependencies {
    @AutoBrandModelTypoCorrection
    @NotNull
    SingleManuallyExposedAbTestGroup<AutoBrandModelTypoCorrectionTestGroup> autoBrandModelTypoCorrectionTestGroup();

    @AutoGenerationsFilterWithPhotos
    @NotNull
    SingleManuallyExposedAbTestGroup<SimpleTestGroup> autoGenerationsFilterWithPhotosTestGroup();

    @Override // com.avito.android.settings.di.SettingsDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies
    @NotNull
    SearchApi searchApi();
}
