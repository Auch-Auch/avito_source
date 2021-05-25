package com.avito.android.publish.edit_advert_request.di;

import com.avito.android.di.PerFragment;
import com.avito.android.progress_overlay.LoadingProgressOverlay;
import com.avito.android.progress_overlay.LoadingProgressOverlayImpl;
import com.avito.android.publish.edit_advert_request.data.EditAdvertCloudDataSource;
import com.avito.android.publish.edit_advert_request.data.EditAdvertDataSource;
import com.avito.android.publish.edit_advert_request.data.EditAdvertRepository;
import com.avito.android.publish.edit_advert_request.data.EditAdvertRepositoryImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/publish/edit_advert_request/di/EditAdvertRequestModule;", "", "Lcom/avito/android/publish/edit_advert_request/data/EditAdvertCloudDataSource;", "dataSource", "Lcom/avito/android/publish/edit_advert_request/data/EditAdvertDataSource;", "bindEditAdvertCloudDataSource", "(Lcom/avito/android/publish/edit_advert_request/data/EditAdvertCloudDataSource;)Lcom/avito/android/publish/edit_advert_request/data/EditAdvertDataSource;", "Lcom/avito/android/publish/edit_advert_request/data/EditAdvertRepositoryImpl;", "repository", "Lcom/avito/android/publish/edit_advert_request/data/EditAdvertRepository;", "bindEditAdvertRepository", "(Lcom/avito/android/publish/edit_advert_request/data/EditAdvertRepositoryImpl;)Lcom/avito/android/publish/edit_advert_request/data/EditAdvertRepository;", "Lcom/avito/android/progress_overlay/LoadingProgressOverlayImpl;", "progressOverlay", "Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "bindLoadingProgressOverlay", "(Lcom/avito/android/progress_overlay/LoadingProgressOverlayImpl;)Lcom/avito/android/progress_overlay/LoadingProgressOverlay;", "publish_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface EditAdvertRequestModule {
    @PerFragment
    @Binds
    @NotNull
    EditAdvertDataSource bindEditAdvertCloudDataSource(@NotNull EditAdvertCloudDataSource editAdvertCloudDataSource);

    @PerFragment
    @Binds
    @NotNull
    EditAdvertRepository bindEditAdvertRepository(@NotNull EditAdvertRepositoryImpl editAdvertRepositoryImpl);

    @PerFragment
    @Binds
    @NotNull
    LoadingProgressOverlay bindLoadingProgressOverlay(@NotNull LoadingProgressOverlayImpl loadingProgressOverlayImpl);
}
