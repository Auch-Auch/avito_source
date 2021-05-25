package com.avito.android.publish.publish_advert_request;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.photo_picker.legacy.UploadingProgressInteractor;
import com.avito.android.photo_picker.legacy.service.UploadingInteractor;
import com.avito.android.publish.publish_advert_request.data.PublishAdvertRepository;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/publish/publish_advert_request/PublishAdvertRequestViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/util/SchedulersFactory;", "c", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/publish/publish_advert_request/data/PublishAdvertRepository;", AuthSource.SEND_ABUSE, "Lcom/avito/android/publish/publish_advert_request/data/PublishAdvertRepository;", "repository", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/photo_picker/legacy/UploadingProgressInteractor;", "e", "Lcom/avito/android/photo_picker/legacy/UploadingProgressInteractor;", "uploadingProgressInteractor", "Lcom/avito/android/photo_picker/legacy/service/UploadingInteractor;", "d", "Lcom/avito/android/photo_picker/legacy/service/UploadingInteractor;", "uploadingInteractor", "<init>", "(Lcom/avito/android/publish/publish_advert_request/data/PublishAdvertRepository;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/photo_picker/legacy/service/UploadingInteractor;Lcom/avito/android/photo_picker/legacy/UploadingProgressInteractor;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PublishAdvertRequestViewModelFactory implements ViewModelProvider.Factory {
    public final PublishAdvertRepository a;
    public final Analytics b;
    public final SchedulersFactory c;
    public final UploadingInteractor d;
    public final UploadingProgressInteractor e;

    public PublishAdvertRequestViewModelFactory(@NotNull PublishAdvertRepository publishAdvertRepository, @NotNull Analytics analytics, @NotNull SchedulersFactory schedulersFactory, @NotNull UploadingInteractor uploadingInteractor, @NotNull UploadingProgressInteractor uploadingProgressInteractor) {
        Intrinsics.checkNotNullParameter(publishAdvertRepository, "repository");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(uploadingInteractor, "uploadingInteractor");
        Intrinsics.checkNotNullParameter(uploadingProgressInteractor, "uploadingProgressInteractor");
        this.a = publishAdvertRepository;
        this.b = analytics;
        this.c = schedulersFactory;
        this.d = uploadingInteractor;
        this.e = uploadingProgressInteractor;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(PublishAdvertRequestViewModel.class)) {
            return cls.cast(new PublishAdvertRequestViewModel(this.a, this.b, this.c, this.d, this.e));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
