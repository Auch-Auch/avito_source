package com.avito.android.publish.drafts;

import androidx.annotation.RestrictTo;
import arrow.core.Option;
import com.avito.android.payment.SberbankOnlineKt;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.PublishDraftResponse;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001&J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00030\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002H&¢\u0006\u0004\b\f\u0010\u0006J\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0002H&¢\u0006\u0004\b\u000e\u0010\u0006J\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u0014H&¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H'¢\u0006\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcom/avito/android/publish/drafts/PublishDraftRepository;", "", "Lio/reactivex/Single;", "Larrow/core/Option;", "Lcom/avito/android/publish/drafts/LocalDraft;", "getDraft", "()Lio/reactivex/Single;", "Lio/reactivex/Observable;", "", "observeDraftsById", "()Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/PublishDraftResponse;", "getLatestDraftData", "Lcom/avito/android/publish/drafts/PublishDraftRepository$DraftSyncResult;", "syncDraftIfNeeded", "sessionId", "draftId", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "categoryParameters", "state", "", "hasLocalChanges", "serverDraftId", "", "version", "Lcom/avito/android/remote/model/Navigation;", "navigation", "activeFieldId", "Lcom/avito/android/publish/drafts/LocalPublishState;", "localPublishState", "showInfoMessages", "Lio/reactivex/Maybe;", "Lcom/avito/android/publish/drafts/PublishInfoMessage;", "saveDraft", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/CategoryParameters;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;Lcom/avito/android/remote/model/Navigation;Ljava/lang/String;Lcom/avito/android/publish/drafts/LocalPublishState;Z)Lio/reactivex/Maybe;", "Lio/reactivex/Completable;", "deleteDraft", "()Lio/reactivex/Completable;", "DraftSyncResult", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
public interface PublishDraftRepository {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Maybe saveDraft$default(PublishDraftRepository publishDraftRepository, String str, String str2, CategoryParameters categoryParameters, String str3, boolean z, String str4, Integer num, Navigation navigation, String str5, LocalPublishState localPublishState, boolean z2, int i, Object obj) {
            if (obj == null) {
                return publishDraftRepository.saveDraft(str, str2, categoryParameters, str3, (i & 16) != 0 ? true : z, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : num, navigation, (i & 256) != 0 ? null : str5, (i & 512) != 0 ? new LocalPublishState(null, null, 3, null) : localPublishState, (i & 1024) != 0 ? false : z2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveDraft");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/publish/drafts/PublishDraftRepository$DraftSyncResult;", "", "<init>", "(Ljava/lang/String;I)V", SberbankOnlineKt.RESULT_SUCCESS, "ERROR", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
    public enum DraftSyncResult {
        SUCCESS,
        ERROR
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @NotNull
    Completable deleteDraft();

    @NotNull
    Single<Option<LocalDraft>> getDraft();

    @NotNull
    Single<PublishDraftResponse> getLatestDraftData();

    @NotNull
    Observable<Option<String>> observeDraftsById();

    @NotNull
    Maybe<PublishInfoMessage> saveDraft(@NotNull String str, @NotNull String str2, @NotNull CategoryParameters categoryParameters, @NotNull String str3, boolean z, @Nullable String str4, @Nullable Integer num, @NotNull Navigation navigation, @Nullable String str5, @NotNull LocalPublishState localPublishState, boolean z2);

    @NotNull
    Single<DraftSyncResult> syncDraftIfNeeded();
}
