package com.avito.android.publish.drafts.db;

import android.annotation.SuppressLint;
import arrow.core.Option;
import com.avito.android.profile_phones.analytics.event.PhoneActionStrings;
import com.avito.android.publish.drafts.LocalDraft;
import com.avito.android.publish.drafts.di.PublishDraftsGson;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Preferences;
import com.google.gson.Gson;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\b\b\u0001\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0017¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\u000bRR\u0010\u0015\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0004 \u0013*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003 \u0013*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0004 \u0013*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00120\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/publish/drafts/db/PublishDraftsDaoImpl;", "Lcom/avito/android/publish/drafts/db/PublishDraftsDao;", "Lio/reactivex/Observable;", "Larrow/core/Option;", "", "observeDraftsById", "()Lio/reactivex/Observable;", "Lcom/avito/android/publish/drafts/LocalDraft;", AnalyticFieldsName.draft, "", "save", "(Lcom/avito/android/publish/drafts/LocalDraft;)V", "load", "()Lcom/avito/android/publish/drafts/LocalDraft;", PhoneActionStrings.REMOVE, "()V", "localDraft", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", "Lcom/jakewharton/rxrelay2/PublishRelay;", "existingDraftId", "Lcom/google/gson/Gson;", "c", "Lcom/google/gson/Gson;", "gson", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/preferences/Preferences;", "preferences", "<init>", "(Lcom/avito/android/util/preferences/Preferences;Lcom/google/gson/Gson;)V", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
public class PublishDraftsDaoImpl implements PublishDraftsDao {
    public final PublishRelay<Option<String>> a = PublishRelay.create();
    public final Preferences b;
    public final Gson c;

    public PublishDraftsDaoImpl(@NotNull Preferences preferences, @PublishDraftsGson @NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.b = preferences;
        this.c = gson;
    }

    public final void a(LocalDraft localDraft) {
        if (localDraft != null) {
            this.a.accept(Option.Companion.just(localDraft.getDraftId()));
        } else {
            this.a.accept(Option.Companion.empty());
        }
    }

    @Override // com.avito.android.publish.drafts.db.PublishDraftsDao
    @SuppressLint({"ApplySharedPref"})
    public synchronized void delete() {
        this.a.accept(Option.Companion.empty());
        this.b.getSharedPreferences().edit().clear().commit();
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0060  */
    @Override // com.avito.android.publish.drafts.db.PublishDraftsDao
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.avito.android.publish.drafts.LocalDraft load() {
        /*
            r5 = this;
            monitor-enter(r5)
            com.avito.android.util.preferences.Preferences r0 = r5.b     // Catch:{ all -> 0x0069 }
            java.util.Map r0 = r0.getAll()     // Catch:{ all -> 0x0069 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x0069 }
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r0)     // Catch:{ all -> 0x0069 }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x0069 }
            r1 = 0
            if (r0 == 0) goto L_0x0019
            java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x0069 }
            goto L_0x001a
        L_0x0019:
            r0 = r1
        L_0x001a:
            boolean r2 = r0 instanceof java.lang.String     // Catch:{ all -> 0x0069 }
            if (r2 != 0) goto L_0x001f
            r0 = r1
        L_0x001f:
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0069 }
            if (r0 == 0) goto L_0x002e
            com.google.gson.Gson r2 = r5.c     // Catch:{ all -> 0x0069 }
            java.lang.Class<com.avito.android.publish.drafts.LocalDraft> r3 = com.avito.android.publish.drafts.LocalDraft.class
            java.lang.Object r0 = r2.fromJson(r0, r3)     // Catch:{ all -> 0x0069 }
            com.avito.android.publish.drafts.LocalDraft r0 = (com.avito.android.publish.drafts.LocalDraft) r0     // Catch:{ all -> 0x0069 }
            goto L_0x002f
        L_0x002e:
            r0 = r1
        L_0x002f:
            if (r0 == 0) goto L_0x0064
            java.util.List r2 = r0.getParameters()     // Catch:{ all -> 0x0069 }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0069 }
            r3 = 1
            r2 = r2 ^ r3
            r4 = 0
            if (r2 != 0) goto L_0x0061
            java.util.List r2 = r0.getSlots()     // Catch:{ all -> 0x0069 }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0069 }
            r2 = r2 ^ r3
            if (r2 != 0) goto L_0x0061
            java.lang.String r2 = r0.getServerDraftId()     // Catch:{ all -> 0x0069 }
            if (r2 == 0) goto L_0x005c
            int r2 = r2.length()     // Catch:{ all -> 0x0069 }
            if (r2 <= 0) goto L_0x0057
            r2 = 1
            goto L_0x0058
        L_0x0057:
            r2 = 0
        L_0x0058:
            if (r2 == 0) goto L_0x005c
            r2 = 1
            goto L_0x005d
        L_0x005c:
            r2 = 0
        L_0x005d:
            if (r2 == 0) goto L_0x0060
            goto L_0x0061
        L_0x0060:
            r3 = 0
        L_0x0061:
            if (r3 == 0) goto L_0x0064
            r1 = r0
        L_0x0064:
            r5.a(r1)     // Catch:{ all -> 0x0069 }
            monitor-exit(r5)
            return r1
        L_0x0069:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.publish.drafts.db.PublishDraftsDaoImpl.load():com.avito.android.publish.drafts.LocalDraft");
    }

    @Override // com.avito.android.publish.drafts.db.PublishDraftsDao
    @NotNull
    public Observable<Option<String>> observeDraftsById() {
        Observable<Option<String>> distinctUntilChanged = this.a.hide().distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "existingDraftId.hide().distinctUntilChanged()");
        return distinctUntilChanged;
    }

    @Override // com.avito.android.publish.drafts.db.PublishDraftsDao
    public synchronized void save(@NotNull LocalDraft localDraft) {
        Intrinsics.checkNotNullParameter(localDraft, AnalyticFieldsName.draft);
        this.b.putString(localDraft.getDraftId(), this.c.toJson(localDraft));
        a(localDraft);
    }
}
