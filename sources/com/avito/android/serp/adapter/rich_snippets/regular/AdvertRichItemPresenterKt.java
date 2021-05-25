package com.avito.android.serp.adapter.rich_snippets.regular;

import a2.b.a.a.a;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.ClickStreamLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.AdvertAction;
import com.avito.android.remote.model.AdvertActions;
import com.avito.android.serp.adapter.AdvertItem;
import com.avito.android.serp.adapter.SerpItem;
import com.avito.android.serp.adapter.advert_xl.AdvertXlItem;
import com.avito.android.serp.adapter.rich_snippets.AdvertGalleryState;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.serp.cyclic_gallery.image_carousel.ActionData;
import ru.avito.component.serp.cyclic_gallery.image_carousel.ActionType;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a%\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0001*\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f*\b\u0012\u0004\u0012\u00020\u000e0\rH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0013\u0010\u0015\u001a\u00020\u0014*\u00020\u0013H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a%\u0010\u001c\u001a\u00020\u0014*\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0000¢\u0006\u0004\b\u001c\u0010\u001d\"\u0016\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001f\u0010 \"\u0016\u0010!\u001a\u00020\u00188\u0006@\u0006XT¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/avito/android/serp/adapter/SerpItem;", "Lcom/avito/android/deep_linking/links/DeepLink;", "getTargetLink", "(Lcom/avito/android/serp/adapter/SerpItem;)Lcom/avito/android/deep_linking/links/DeepLink;", "", "fromGalleryAction", "Lcom/avito/android/analytics/Analytics;", "analytics", "trackSnippetCallEvent", "(Lcom/avito/android/serp/adapter/SerpItem;ZLcom/avito/android/analytics/Analytics;)Lcom/avito/android/deep_linking/links/DeepLink;", "Lcom/avito/android/remote/model/AdvertActions;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/AdvertActions;)Lcom/avito/android/deep_linking/links/DeepLink;", "", "Lcom/avito/android/remote/model/AdvertAction;", "", "Lru/avito/component/serp/cyclic_gallery/image_carousel/ActionData;", "mapActions", "(Ljava/util/List;)Ljava/util/Set;", "Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertRichItemView;", "", "clearCallbacks", "(Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertRichItemView;)V", "Lcom/avito/android/serp/adapter/rich_snippets/AdvertGalleryState;", "", "id", "Landroid/os/Parcelable;", "state", "putAdvertState", "(Lcom/avito/android/serp/adapter/rich_snippets/AdvertGalleryState;Ljava/lang/String;Landroid/os/Parcelable;)V", "", "SNIPPET_CALL_EVENT_ID", "I", "KEY_ADVERT_GALLERY_STATE", "Ljava/lang/String;", "serp-core_release"}, k = 2, mv = {1, 4, 2})
public final class AdvertRichItemPresenterKt {
    @NotNull
    public static final String KEY_ADVERT_GALLERY_STATE = "advert_gallery_state";
    public static final int SNIPPET_CALL_EVENT_ID = 2216;

    public static final DeepLink a(AdvertActions advertActions) {
        T t;
        Iterator<T> it = advertActions.getActions().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t instanceof AdvertAction.Phone) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            return t2.getDeepLink();
        }
        return null;
    }

    public static final void clearCallbacks(@NotNull AdvertRichItemView advertRichItemView) {
        Intrinsics.checkNotNullParameter(advertRichItemView, "$this$clearCallbacks");
        advertRichItemView.pictureChanges(null);
        advertRichItemView.favoriteClicks(null);
        advertRichItemView.additionalContentVisibilityChanges(null);
        advertRichItemView.clearListeners();
        advertRichItemView.setUnbindListener(null);
    }

    @Nullable
    public static final DeepLink getTargetLink(@NotNull SerpItem serpItem) {
        DeepLink deepLink;
        Intrinsics.checkNotNullParameter(serpItem, "$this$getTargetLink");
        DeepLink deepLink2 = null;
        if (serpItem instanceof AdvertXlItem) {
            AdvertXlItem advertXlItem = (AdvertXlItem) serpItem;
            Action callAction = advertXlItem.getCallAction();
            if (callAction == null || (deepLink = callAction.getDeepLink()) == null) {
                AdvertActions contacts = advertXlItem.getContacts();
                if (contacts != null) {
                    deepLink2 = a(contacts);
                }
            } else {
                deepLink2 = deepLink;
            }
        } else if (!(serpItem instanceof AdvertItem)) {
            return null;
        } else {
            AdvertActions contacts2 = ((AdvertItem) serpItem).getContacts();
            if (contacts2 != null) {
                deepLink2 = a(contacts2);
            }
        }
        return deepLink2 instanceof ClickStreamLink ? ((ClickStreamLink) deepLink2).getRedirect() : deepLink2;
    }

    @NotNull
    public static final Set<ActionData> mapActions(@NotNull List<? extends AdvertAction> list) {
        ActionData actionData;
        ArrayList i0 = a.i0(list, "$this$mapActions");
        for (T t : list) {
            if (t instanceof AdvertAction.Messenger) {
                actionData = new ActionData(ActionType.WRITE, t.getTitle());
            } else {
                actionData = t instanceof AdvertAction.Phone ? new ActionData(ActionType.CALL, t.getTitle()) : null;
            }
            if (actionData != null) {
                i0.add(actionData);
            }
        }
        return CollectionsKt___CollectionsKt.toSet(CollectionsKt___CollectionsKt.sortedWith(i0, new Comparator<T>() { // from class: com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemPresenterKt$mapActions$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t2, T t3) {
                return t6.o.a.compareValues(Integer.valueOf(t2.getActionType().ordinal()), Integer.valueOf(t3.getActionType().ordinal()));
            }
        }));
    }

    public static final void putAdvertState(@NotNull AdvertGalleryState advertGalleryState, @NotNull String str, @Nullable Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(advertGalleryState, "$this$putAdvertState");
        Intrinsics.checkNotNullParameter(str, "id");
        if (parcelable != null) {
            advertGalleryState.saveState(str, parcelable);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0057  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.avito.android.deep_linking.links.DeepLink trackSnippetCallEvent(@org.jetbrains.annotations.NotNull com.avito.android.serp.adapter.SerpItem r4, boolean r5, @org.jetbrains.annotations.NotNull com.avito.android.analytics.Analytics r6) {
        /*
            java.lang.String r0 = "$this$trackSnippetCallEvent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "analytics"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            boolean r0 = r4 instanceof com.avito.android.serp.adapter.advert_xl.AdvertXlItem
            r1 = 0
            if (r0 == 0) goto L_0x002a
            r0 = r4
            com.avito.android.serp.adapter.advert_xl.AdvertXlItem r0 = (com.avito.android.serp.adapter.advert_xl.AdvertXlItem) r0
            com.avito.android.remote.model.Action r2 = r0.getCallAction()
            if (r2 == 0) goto L_0x001f
            com.avito.android.deep_linking.links.DeepLink r2 = r2.getDeepLink()
            if (r2 == 0) goto L_0x001f
            goto L_0x003d
        L_0x001f:
            com.avito.android.remote.model.AdvertActions r0 = r0.getContacts()
            if (r0 == 0) goto L_0x003c
            com.avito.android.deep_linking.links.DeepLink r2 = a(r0)
            goto L_0x003d
        L_0x002a:
            boolean r0 = r4 instanceof com.avito.android.serp.adapter.AdvertItem
            if (r0 == 0) goto L_0x0069
            r0 = r4
            com.avito.android.serp.adapter.AdvertItem r0 = (com.avito.android.serp.adapter.AdvertItem) r0
            com.avito.android.remote.model.AdvertActions r0 = r0.getContacts()
            if (r0 == 0) goto L_0x003c
            com.avito.android.deep_linking.links.DeepLink r2 = a(r0)
            goto L_0x003d
        L_0x003c:
            r2 = r1
        L_0x003d:
            boolean r0 = r2 instanceof com.avito.android.deep_linking.links.ClickStreamLink
            if (r0 == 0) goto L_0x0053
            com.avito.android.deep_linking.links.ClickStreamLink r2 = (com.avito.android.deep_linking.links.ClickStreamLink) r2
            int r0 = r2.getEventId()
            r3 = 2216(0x8a8, float:3.105E-42)
            if (r0 != r3) goto L_0x004f
            java.util.Map r1 = r2.getParameters()
        L_0x004f:
            com.avito.android.deep_linking.links.DeepLink r2 = r2.getRedirect()
        L_0x0053:
            if (r5 == 0) goto L_0x0057
            r5 = 3
            goto L_0x0058
        L_0x0057:
            r5 = 0
        L_0x0058:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            com.avito.android.analytics.event.SnippetCallEvent r0 = new com.avito.android.analytics.event.SnippetCallEvent
            java.lang.String r4 = r4.getStringId()
            r0.<init>(r4, r5, r1)
            r6.track(r0)
            return r2
        L_0x0069:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemPresenterKt.trackSnippetCallEvent(com.avito.android.serp.adapter.SerpItem, boolean, com.avito.android.analytics.Analytics):com.avito.android.deep_linking.links.DeepLink");
    }
}
