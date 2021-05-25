package com.avito.android.advert_core.analytics.toolbar;

import a2.g.r.g;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.remote.model.AdvertDetails;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/avito/android/advert_core/analytics/toolbar/ActionWithNoteTreeEvent;", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamEvent;", "", "", "", "extraParams", "()Ljava/util/Map;", "Lcom/avito/android/advert_core/analytics/toolbar/NoteAction;", "f", "Lcom/avito/android/advert_core/analytics/toolbar/NoteAction;", "action", "Lcom/avito/android/remote/model/AdvertDetails;", "e", "Lcom/avito/android/remote/model/AdvertDetails;", "advert", g.a, "Ljava/lang/String;", "noteText", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "parent", "<init>", "(Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Lcom/avito/android/remote/model/AdvertDetails;Lcom/avito/android/advert_core/analytics/toolbar/NoteAction;Ljava/lang/String;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class ActionWithNoteTreeEvent extends TreeClickStreamEvent {
    public final AdvertDetails e;
    public final NoteAction f;
    public final String g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActionWithNoteTreeEvent(@Nullable TreeClickStreamParent treeClickStreamParent, @NotNull AdvertDetails advertDetails, @NotNull NoteAction noteAction, @Nullable String str) {
        super(0, treeClickStreamParent, 3185, 2);
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        Intrinsics.checkNotNullParameter(noteAction, "action");
        this.e = advertDetails;
        this.f = noteAction;
        this.g = str;
    }

    @Override // com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent
    @NotNull
    public Map<String, Object> extraParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        putParam(linkedHashMap, "iid", this.e.getId());
        putParam(linkedHashMap, "cid", this.e.getCategoryId());
        String name = this.f.name();
        Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = name.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        putParam(linkedHashMap, "action", lowerCase);
        putParam(linkedHashMap, "note_text", this.g);
        return linkedHashMap;
    }
}
