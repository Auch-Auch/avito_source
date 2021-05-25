package com.avito.android.publish.start_publish;

import a2.b.a.a.a;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.publish.start_publish.StartPublishSheet;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.PublishDraftResponse;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\fJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H&¢\u0006\u0004\b\u000b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/publish/start_publish/StartPublishInteractor;", "", "Lio/reactivex/rxjava3/core/Completable;", "deleteDraftWithPhotos", "()Lio/reactivex/rxjava3/core/Completable;", "Lio/reactivex/rxjava3/core/Single;", "", "Lcom/avito/android/publish/start_publish/StartPublishSheet$SheetData$CategoryShortcutItem;", "getCategoryShortcuts", "()Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/publish/start_publish/StartPublishInteractor$ScreenData;", "loadStartupSheetData", "ScreenData", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface StartPublishInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/publish/start_publish/StartPublishInteractor$ScreenData;", "", "", "Lcom/avito/android/publish/start_publish/StartPublishSheet$SheetData$CategoryShortcutItem;", "component1", "()Ljava/util/List;", "Lcom/avito/android/remote/model/PublishDraftResponse;", "component2", "()Lcom/avito/android/remote/model/PublishDraftResponse;", ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS, "draftResponse", "copy", "(Ljava/util/List;Lcom/avito/android/remote/model/PublishDraftResponse;)Lcom/avito/android/publish/start_publish/StartPublishInteractor$ScreenData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getShortcuts", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/PublishDraftResponse;", "getDraftResponse", "<init>", "(Ljava/util/List;Lcom/avito/android/remote/model/PublishDraftResponse;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class ScreenData {
        @NotNull
        public final List<StartPublishSheet.SheetData.CategoryShortcutItem> a;
        @NotNull
        public final PublishDraftResponse b;

        public ScreenData(@NotNull List<StartPublishSheet.SheetData.CategoryShortcutItem> list, @NotNull PublishDraftResponse publishDraftResponse) {
            Intrinsics.checkNotNullParameter(list, ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS);
            Intrinsics.checkNotNullParameter(publishDraftResponse, "draftResponse");
            this.a = list;
            this.b = publishDraftResponse;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.publish.start_publish.StartPublishInteractor$ScreenData */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ScreenData copy$default(ScreenData screenData, List list, PublishDraftResponse publishDraftResponse, int i, Object obj) {
            if ((i & 1) != 0) {
                list = screenData.a;
            }
            if ((i & 2) != 0) {
                publishDraftResponse = screenData.b;
            }
            return screenData.copy(list, publishDraftResponse);
        }

        @NotNull
        public final List<StartPublishSheet.SheetData.CategoryShortcutItem> component1() {
            return this.a;
        }

        @NotNull
        public final PublishDraftResponse component2() {
            return this.b;
        }

        @NotNull
        public final ScreenData copy(@NotNull List<StartPublishSheet.SheetData.CategoryShortcutItem> list, @NotNull PublishDraftResponse publishDraftResponse) {
            Intrinsics.checkNotNullParameter(list, ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS);
            Intrinsics.checkNotNullParameter(publishDraftResponse, "draftResponse");
            return new ScreenData(list, publishDraftResponse);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ScreenData)) {
                return false;
            }
            ScreenData screenData = (ScreenData) obj;
            return Intrinsics.areEqual(this.a, screenData.a) && Intrinsics.areEqual(this.b, screenData.b);
        }

        @NotNull
        public final PublishDraftResponse getDraftResponse() {
            return this.b;
        }

        @NotNull
        public final List<StartPublishSheet.SheetData.CategoryShortcutItem> getShortcuts() {
            return this.a;
        }

        public int hashCode() {
            List<StartPublishSheet.SheetData.CategoryShortcutItem> list = this.a;
            int i = 0;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            PublishDraftResponse publishDraftResponse = this.b;
            if (publishDraftResponse != null) {
                i = publishDraftResponse.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("ScreenData(shortcuts=");
            L.append(this.a);
            L.append(", draftResponse=");
            L.append(this.b);
            L.append(")");
            return L.toString();
        }
    }

    @NotNull
    Completable deleteDraftWithPhotos();

    @NotNull
    Single<List<StartPublishSheet.SheetData.CategoryShortcutItem>> getCategoryShortcuts();

    @NotNull
    Single<ScreenData> loadStartupSheetData();
}
