package com.avito.android.publish.draft_onboarding;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.functions.Consumer;
import java.util.Objects;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.toolbar.OnboardingData;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/publish/draft_onboarding/DraftOnboardingInteractorImpl;", "Lcom/avito/android/publish/draft_onboarding/DraftOnboardingInteractor;", "Lio/reactivex/Maybe;", "Lru/avito/component/toolbar/OnboardingData;", "shouldShowDraftOnboarding", "()Lio/reactivex/Maybe;", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/publish/draft_onboarding/DraftOnboardingSessionStorage;", AuthSource.SEND_ABUSE, "Lcom/avito/android/publish/draft_onboarding/DraftOnboardingSessionStorage;", "draftOnboardingSessionStorage", "Lcom/avito/android/publish/draft_onboarding/DraftOnboardingResourceProvider;", "c", "Lcom/avito/android/publish/draft_onboarding/DraftOnboardingResourceProvider;", "resourceProvider", "<init>", "(Lcom/avito/android/publish/draft_onboarding/DraftOnboardingSessionStorage;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/publish/draft_onboarding/DraftOnboardingResourceProvider;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class DraftOnboardingInteractorImpl implements DraftOnboardingInteractor {
    public final DraftOnboardingSessionStorage a;
    public final SchedulersFactory b;
    public final DraftOnboardingResourceProvider c;

    public static final class a<V> implements Callable<MaybeSource<? extends OnboardingData>> {
        public final /* synthetic */ DraftOnboardingInteractorImpl a;

        public a(DraftOnboardingInteractorImpl draftOnboardingInteractorImpl) {
            this.a = draftOnboardingInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public MaybeSource<? extends OnboardingData> call() {
            DraftOnboardingInteractorImpl draftOnboardingInteractorImpl = this.a;
            return DraftOnboardingInteractorImpl.access$toMaybe(draftOnboardingInteractorImpl, !draftOnboardingInteractorImpl.a.getDraftOnboardingWasShown(), new OnboardingData(this.a.c.getOnboardingTitle(), this.a.c.getOnboardingText()));
        }
    }

    public static final class b<T> implements Consumer<OnboardingData> {
        public final /* synthetic */ DraftOnboardingInteractorImpl a;

        public b(DraftOnboardingInteractorImpl draftOnboardingInteractorImpl) {
            this.a = draftOnboardingInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(OnboardingData onboardingData) {
            this.a.a.setDraftOnboardingWasShown(true);
        }
    }

    @Inject
    public DraftOnboardingInteractorImpl(@NotNull DraftOnboardingSessionStorage draftOnboardingSessionStorage, @NotNull SchedulersFactory schedulersFactory, @NotNull DraftOnboardingResourceProvider draftOnboardingResourceProvider) {
        Intrinsics.checkNotNullParameter(draftOnboardingSessionStorage, "draftOnboardingSessionStorage");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(draftOnboardingResourceProvider, "resourceProvider");
        this.a = draftOnboardingSessionStorage;
        this.b = schedulersFactory;
        this.c = draftOnboardingResourceProvider;
    }

    public static final Maybe access$toMaybe(DraftOnboardingInteractorImpl draftOnboardingInteractorImpl, boolean z, Object obj) {
        Objects.requireNonNull(draftOnboardingInteractorImpl);
        if (z) {
            Maybe just = Maybe.just(obj);
            Intrinsics.checkNotNullExpressionValue(just, "Maybe.just(data)");
            return just;
        }
        Maybe empty = Maybe.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Maybe.empty()");
        return empty;
    }

    @Override // com.avito.android.publish.draft_onboarding.DraftOnboardingInteractor
    @NotNull
    public Maybe<OnboardingData> shouldShowDraftOnboarding() {
        Maybe<OnboardingData> observeOn = Maybe.defer(new a(this)).doOnSuccess(new b(this)).subscribeOn(this.b.io()).observeOn(this.b.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "Maybe.defer {\n          …(schedulers.mainThread())");
        return observeOn;
    }
}
