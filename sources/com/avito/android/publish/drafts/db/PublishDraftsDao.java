package com.avito.android.publish.drafts.db;

import arrow.core.Option;
import com.avito.android.profile_phones.analytics.event.PhoneActionStrings;
import com.avito.android.publish.drafts.LocalDraft;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/publish/drafts/db/PublishDraftsDao;", "", "Lio/reactivex/Observable;", "Larrow/core/Option;", "", "observeDraftsById", "()Lio/reactivex/Observable;", "Lcom/avito/android/publish/drafts/LocalDraft;", AnalyticFieldsName.draft, "", "save", "(Lcom/avito/android/publish/drafts/LocalDraft;)V", "load", "()Lcom/avito/android/publish/drafts/LocalDraft;", PhoneActionStrings.REMOVE, "()V", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
public interface PublishDraftsDao {
    void delete();

    @Nullable
    LocalDraft load();

    @NotNull
    Observable<Option<String>> observeDraftsById();

    void save(@NotNull LocalDraft localDraft);
}
