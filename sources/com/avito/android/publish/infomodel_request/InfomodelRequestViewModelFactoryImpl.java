package com.avito.android.publish.infomodel_request;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.analytics.screens.tracker.UnknownScreenTracker;
import com.avito.android.publish.PublishParametersInteractor;
import com.avito.android.publish.drafts.analytics.PublishDraftEventTracker;
import com.avito.android.publish.drafts.analytics.PublishSessionIdGenerator;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import com.google.gson.Gson;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b$\u0010%J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/avito/android/publish/infomodel_request/InfomodelRequestViewModelFactoryImpl;", "Lcom/avito/android/publish/infomodel_request/InfomodelRequestViewModelFactory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/google/gson/Gson;", AuthSource.BOOKING_ORDER, "Lcom/google/gson/Gson;", "gson", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "e", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsDataProvider", "Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;", g.a, "Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;", "performanceTracker", "Lcom/avito/android/publish/drafts/analytics/PublishDraftEventTracker;", "d", "Lcom/avito/android/publish/drafts/analytics/PublishDraftEventTracker;", "draftEventTracker", "Lcom/avito/android/publish/PublishParametersInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/publish/PublishParametersInteractor;", "publishParametersInteractor", "Lcom/avito/android/util/SchedulersFactory;", "c", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/publish/drafts/analytics/PublishSessionIdGenerator;", "f", "Lcom/avito/android/publish/drafts/analytics/PublishSessionIdGenerator;", "idGenerator", "<init>", "(Lcom/avito/android/publish/PublishParametersInteractor;Lcom/google/gson/Gson;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/publish/drafts/analytics/PublishDraftEventTracker;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Lcom/avito/android/publish/drafts/analytics/PublishSessionIdGenerator;Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class InfomodelRequestViewModelFactoryImpl implements InfomodelRequestViewModelFactory {
    public final PublishParametersInteractor a;
    public final Gson b;
    public final SchedulersFactory c;
    public final PublishDraftEventTracker d;
    public final PublishAnalyticsDataProvider e;
    public PublishSessionIdGenerator f;
    public final UnknownScreenTracker g;

    @Inject
    public InfomodelRequestViewModelFactoryImpl(@NotNull PublishParametersInteractor publishParametersInteractor, @NotNull Gson gson, @NotNull SchedulersFactory schedulersFactory, @NotNull PublishDraftEventTracker publishDraftEventTracker, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @NotNull PublishSessionIdGenerator publishSessionIdGenerator, @NotNull UnknownScreenTracker unknownScreenTracker) {
        Intrinsics.checkNotNullParameter(publishParametersInteractor, "publishParametersInteractor");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(publishDraftEventTracker, "draftEventTracker");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsDataProvider");
        Intrinsics.checkNotNullParameter(publishSessionIdGenerator, "idGenerator");
        Intrinsics.checkNotNullParameter(unknownScreenTracker, "performanceTracker");
        this.a = publishParametersInteractor;
        this.b = gson;
        this.c = schedulersFactory;
        this.d = publishDraftEventTracker;
        this.e = publishAnalyticsDataProvider;
        this.f = publishSessionIdGenerator;
        this.g = unknownScreenTracker;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(InfomodelRequestViewModel.class)) {
            return cls.cast(new InfomodelRequestViewModel(this.a, this.b, this.c, this.e, this.f, this.d, this.g));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
