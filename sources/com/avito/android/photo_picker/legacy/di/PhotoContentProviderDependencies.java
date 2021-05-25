package com.avito.android.photo_picker.legacy.di;

import com.avito.android.db.DbHelper;
import com.avito.android.di.ComponentDependencies;
import com.avito.android.util.BuildInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/photo_picker/legacy/di/PhotoContentProviderDependencies;", "Lcom/avito/android/di/ComponentDependencies;", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "()Lcom/avito/android/util/BuildInfo;", "Lcom/avito/android/db/DbHelper;", "dbHelper", "()Lcom/avito/android/db/DbHelper;", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface PhotoContentProviderDependencies extends ComponentDependencies {
    @Override // com.avito.android.push.UpdateInstanceIdDependencies, com.avito.android.authorization.account_manager.di.AvitoAuthenticatorDependencies, com.avito.android.location_picker.di.LocationPickerDependencies
    @NotNull
    BuildInfo buildInfo();

    @NotNull
    DbHelper dbHelper();
}
