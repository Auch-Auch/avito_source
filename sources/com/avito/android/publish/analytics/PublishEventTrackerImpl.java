package com.avito.android.publish.analytics;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.CurrentUserIdProvider;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.publish.analytics.events.AddAdvertEvent;
import com.avito.android.publish.analytics.events.AddAdvertGeneralEvent;
import com.avito.android.publish.analytics.events.AddAdvertJobEvent;
import com.avito.android.publish.analytics.events.AddAdvertRealtyEvent;
import com.avito.android.publish.analytics.events.AddAdvertServicesEvent;
import com.avito.android.publish.analytics.events.AddAdvertTransportEvent;
import com.avito.android.publish.analytics.events.AddItemEvent;
import com.avito.android.publish.analytics.events.ContactsScreenOpenEvent;
import com.avito.android.publish.analytics.events.InfoLinkClickEvent;
import com.avito.android.publish.analytics.events.ItemAddAutoStsPhotoStart;
import com.avito.android.publish.analytics.events.ItemAddCloseEvent;
import com.avito.android.publish.analytics.events.ItemAddOtherCategoryClickEvent;
import com.avito.android.publish.analytics.events.ItemAddScreenOpenEvent;
import com.avito.android.publish.analytics.events.NewAdvertShownEvent;
import com.avito.android.publish.analytics.events.OpenPhotoPickerEvent;
import com.avito.android.publish.analytics.events.PublishInputsValidationErrorEventV4;
import com.avito.android.publish.analytics.events.PublishParamValueChangedEventV6;
import com.avito.android.publish.analytics.events.PublishSelectCategoryEvent;
import com.avito.android.publish.analytics.events.PublishVerticalClickEventV4;
import com.avito.android.publish.analytics.events.StsScanResultReceivedEvent;
import com.avito.android.publish.analytics.events.VideoInfoClickedEvent;
import com.avito.android.publish.analytics.events.VideoUploadingClickEvent;
import com.avito.android.publish.analytics.events.cpa.CpaTariffFormRequestButtonClicked;
import com.avito.android.publish.analytics.events.cpa.CpaTariffFormRequestSuccess;
import com.avito.android.publish.analytics.events.cpa.CpaTariffSlotButtonClickedND;
import com.avito.android.publish.analytics.events.cpa.CpaTariffSlotButtonClickedSSEdit;
import com.avito.android.publish.analytics.events.cpa.CpaTariffSlotButtonClickedSSPublish;
import com.avito.android.publish.analytics.events.cpa.CpaTariffSlotShowedND;
import com.avito.android.publish.analytics.events.cpa.CpaTariffSlotShowedSS;
import com.avito.android.publish.drafts.di.AnalyticsParametersSerializer;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CategoryIds;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.NavigationKt;
import com.avito.android.remote.model.category_parameters.slot.cpa_tariff.CpaButtonAction;
import com.avito.android.validation.ValidationResult;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\b\u0007\u0012\u0006\u0010>\u001a\u00020;\u0012\u0006\u00106\u001a\u000203\u0012\u0006\u00102\u001a\u00020/\u0012\b\b\u0001\u0010:\u001a\u000207¢\u0006\u0004\b?\u0010@J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J)\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J'\u0010\u0011\u001a\u00020\u00022\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u0004J\u0019\u0010\u001b\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u001b\u0010\u0016J\u0017\u0010\u001c\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\"\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\"\u0010 J\u0019\u0010#\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b#\u0010 J\u000f\u0010$\u001a\u00020\u0002H\u0016¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010%\u001a\u00020\u0002H\u0016¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010&\u001a\u00020\u0002H\u0016¢\u0006\u0004\b&\u0010\u0004J\u000f\u0010'\u001a\u00020\u0002H\u0016¢\u0006\u0004\b'\u0010\u0004J\u0019\u0010*\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0004\b*\u0010+J\u0019\u0010,\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0004\b,\u0010+J\u000f\u0010-\u001a\u00020\u0002H\u0016¢\u0006\u0004\b-\u0010\u0004J\u000f\u0010.\u001a\u00020\u0002H\u0016¢\u0006\u0004\b.\u0010\u0004R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006A"}, d2 = {"Lcom/avito/android/publish/analytics/PublishEventTrackerImpl;", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "", "trackContactsScreenOpened", "()V", "trackStsScanResultReceived", "", "fieldName", "fieldValue", "Lcom/avito/android/remote/model/Navigation;", "navigation", "trackParamValueChangedEvent", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Navigation;)V", "trackPhotoPickerOpen", "", "Lcom/avito/android/validation/ValidationResult$Failure;", "validationResult", "trackPublishInputError", "(Ljava/util/List;Lcom/avito/android/remote/model/Navigation;)V", "", "categoryId", "trackAddAdvert", "(Ljava/lang/Integer;)V", "rootCategoryId", "trackAddAdvertWithVertical", "(I)V", "trackNewAdvertShown", "trackSelectCategory", "trackPublishVerticalChosen", "(Lcom/avito/android/remote/model/Navigation;)V", "url", "trackInfoLinkClickEvent", "(Ljava/lang/String;)V", "screenId", "trackItemAddCloseEvent", "trackItemAddScreenOpen", "trackItemAddAutoStsPhotoOpen", "trackOtherCategoryClick", "trackVideoInfoClicked", "trackVideoUploadingClicked", "Lcom/avito/android/remote/model/category_parameters/slot/cpa_tariff/CpaButtonAction;", "action", "trackCpaSlotShowed", "(Lcom/avito/android/remote/model/category_parameters/slot/cpa_tariff/CpaButtonAction;)V", "trackCpaSlotButtonClicked", "trackCpaRequestSend", "trackCpaRequestSuccess", "Lcom/avito/android/analytics/provider/CurrentUserIdProvider;", "c", "Lcom/avito/android/analytics/provider/CurrentUserIdProvider;", "currentUserIdProvider", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsDataProvider", "Lcom/google/gson/Gson;", "d", "Lcom/google/gson/Gson;", "gson", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Lcom/avito/android/analytics/provider/CurrentUserIdProvider;Lcom/google/gson/Gson;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PublishEventTrackerImpl implements PublishEventTracker {
    public final Analytics a;
    public final PublishAnalyticsDataProvider b;
    public final CurrentUserIdProvider c;
    public final Gson d;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            CpaButtonAction.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            CpaButtonAction cpaButtonAction = CpaButtonAction.SHOW_CPA_TARIFF_FORM;
            iArr[2] = 1;
            CpaButtonAction.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[2] = 1;
            CpaButtonAction cpaButtonAction2 = CpaButtonAction.SWITCH_TO_DEVELOPMENT;
            iArr2[0] = 2;
            CpaButtonAction cpaButtonAction3 = CpaButtonAction.START_NEW_PUBLISH;
            iArr2[1] = 3;
        }
    }

    @Inject
    public PublishEventTrackerImpl(@NotNull Analytics analytics, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @NotNull CurrentUserIdProvider currentUserIdProvider, @AnalyticsParametersSerializer @NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsDataProvider");
        Intrinsics.checkNotNullParameter(currentUserIdProvider, "currentUserIdProvider");
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.a = analytics;
        this.b = publishAnalyticsDataProvider;
        this.c = currentUserIdProvider;
        this.d = gson;
    }

    @Override // com.avito.android.publish.analytics.PublishEventTracker
    public void trackAddAdvert(@Nullable Integer num) {
        this.a.track(new AddAdvertEvent(num != null ? String.valueOf(num.intValue()) : null));
    }

    @Override // com.avito.android.publish.analytics.PublishEventTracker
    public void trackAddAdvertWithVertical(int i) {
        String valueOf = String.valueOf(i);
        if (Intrinsics.areEqual(valueOf, CategoryIds.AUTO.ROOT.getId())) {
            this.a.track(new AddAdvertTransportEvent());
        } else if (Intrinsics.areEqual(valueOf, CategoryIds.RE.ROOT.getId())) {
            this.a.track(new AddAdvertRealtyEvent());
        } else if (Intrinsics.areEqual(valueOf, CategoryIds.JOB.ROOT.getId())) {
            this.a.track(new AddAdvertJobEvent());
        } else if (Intrinsics.areEqual(valueOf, CategoryIds.SE.ROOT.getId())) {
            this.a.track(new AddAdvertServicesEvent());
        } else {
            this.a.track(new AddAdvertGeneralEvent());
        }
    }

    @Override // com.avito.android.publish.analytics.PublishEventTracker
    public void trackContactsScreenOpened() {
        this.a.track(new AddItemEvent.ShowContactsScreen());
        this.a.track(new ContactsScreenOpenEvent(this.b.getSessionIdKeyValue()));
    }

    @Override // com.avito.android.publish.analytics.PublishEventTracker
    public void trackCpaRequestSend() {
        this.a.track(new CpaTariffFormRequestButtonClicked(this.b.getItemId()));
    }

    @Override // com.avito.android.publish.analytics.PublishEventTracker
    public void trackCpaRequestSuccess() {
        this.a.track(new CpaTariffFormRequestSuccess(this.b.getItemId()));
    }

    @Override // com.avito.android.publish.analytics.PublishEventTracker
    public void trackCpaSlotButtonClicked(@Nullable CpaButtonAction cpaButtonAction) {
        if (cpaButtonAction != null) {
            int ordinal = cpaButtonAction.ordinal();
            if (ordinal == 0) {
                this.a.track(new CpaTariffSlotButtonClickedSSPublish(this.b.getItemId()));
            } else if (ordinal == 1) {
                this.a.track(new CpaTariffSlotButtonClickedSSEdit(this.b.getItemId()));
            } else if (ordinal == 2) {
                this.a.track(new CpaTariffSlotButtonClickedND(this.b.getItemId()));
            }
        }
    }

    @Override // com.avito.android.publish.analytics.PublishEventTracker
    public void trackCpaSlotShowed(@Nullable CpaButtonAction cpaButtonAction) {
        if (cpaButtonAction != null) {
            if (cpaButtonAction.ordinal() != 2) {
                this.a.track(new CpaTariffSlotShowedSS(this.b.getItemId()));
            } else {
                this.a.track(new CpaTariffSlotShowedND(this.b.getItemId()));
            }
        }
    }

    @Override // com.avito.android.publish.analytics.PublishEventTracker
    public void trackInfoLinkClickEvent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        this.a.track(new InfoLinkClickEvent(this.b, str));
    }

    @Override // com.avito.android.publish.analytics.PublishEventTracker
    public void trackItemAddAutoStsPhotoOpen() {
        this.a.track(new ItemAddAutoStsPhotoStart(this.b.getSessionIdKeyValue()));
    }

    @Override // com.avito.android.publish.analytics.PublishEventTracker
    public void trackItemAddCloseEvent(@Nullable String str) {
        this.a.track(new ItemAddCloseEvent(this.b, str));
    }

    @Override // com.avito.android.publish.analytics.PublishEventTracker
    public void trackItemAddScreenOpen(@Nullable String str) {
        this.a.track(new ItemAddScreenOpenEvent(this.b, str));
    }

    @Override // com.avito.android.publish.analytics.PublishEventTracker
    public void trackNewAdvertShown() {
        this.a.track(new NewAdvertShownEvent(this.b.getSessionIdKeyValue(), this.c.getCurrentUserId()));
    }

    @Override // com.avito.android.publish.analytics.PublishEventTracker
    public void trackOtherCategoryClick() {
        this.a.track(new ItemAddOtherCategoryClickEvent(this.b));
    }

    @Override // com.avito.android.publish.analytics.PublishEventTracker
    public void trackParamValueChangedEvent(@NotNull String str, @Nullable String str2, @NotNull Navigation navigation) {
        Intrinsics.checkNotNullParameter(str, "fieldName");
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        Analytics analytics = this.a;
        if (str2 == null) {
            str2 = "";
        }
        List<Integer> categoryIds = navigation.getCategoryIds();
        List<Map<String, String>> attributes = navigation.getAttributes();
        analytics.track(new PublishParamValueChangedEventV6(str, str2, categoryIds, attributes != null ? NavigationKt.toAnalyticsFormat(attributes, this.d) : null, this.b));
    }

    @Override // com.avito.android.publish.analytics.PublishEventTracker
    public void trackPhotoPickerOpen() {
        this.a.track(new OpenPhotoPickerEvent(this.b));
    }

    @Override // com.avito.android.publish.analytics.PublishEventTracker
    public void trackPublishInputError(@Nullable List<? extends ValidationResult.Failure> list, @NotNull Navigation navigation) {
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        if (list != null) {
            Analytics analytics = this.a;
            PublishAnalyticsDataProvider publishAnalyticsDataProvider = this.b;
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
            for (T t : list) {
                arrayList.add(TuplesKt.to(t.getTitle(), t.getText()));
            }
            Map map = r.toMap(arrayList);
            List<Integer> categoryIds = navigation.getCategoryIds();
            List<Map<String, String>> attributes = navigation.getAttributes();
            analytics.track(new PublishInputsValidationErrorEventV4(publishAnalyticsDataProvider, map, categoryIds, attributes != null ? NavigationKt.toAnalyticsFormat(attributes, this.d) : null));
        }
    }

    @Override // com.avito.android.publish.analytics.PublishEventTracker
    public void trackPublishVerticalChosen(@NotNull Navigation navigation) {
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        Analytics analytics = this.a;
        Integer categoryId = navigation.getCategoryId();
        String str = null;
        String valueOf = categoryId != null ? String.valueOf(categoryId.intValue()) : null;
        List<Integer> categoryIds = navigation.getCategoryIds();
        String sessionId = this.b.getSessionId();
        List<Map<String, String>> attributes = navigation.getAttributes();
        if (attributes != null) {
            str = NavigationKt.toAnalyticsFormat(attributes, this.d);
        }
        analytics.track(new PublishVerticalClickEventV4(valueOf, categoryIds, sessionId, str));
    }

    @Override // com.avito.android.publish.analytics.PublishEventTracker
    public void trackSelectCategory(@Nullable Integer num) {
        if (!Intrinsics.areEqual(num, this.b.getTrackedCategory()) && num != null) {
            num.intValue();
            this.b.setTrackedCategory(num);
            this.a.track(new PublishSelectCategoryEvent(num.intValue()));
        }
    }

    @Override // com.avito.android.publish.analytics.PublishEventTracker
    public void trackStsScanResultReceived() {
        this.a.track(new StsScanResultReceivedEvent(this.b.getSessionIdKeyValue()));
    }

    @Override // com.avito.android.publish.analytics.PublishEventTracker
    public void trackVideoInfoClicked() {
        this.a.track(new VideoInfoClickedEvent(this.b));
    }

    @Override // com.avito.android.publish.analytics.PublishEventTracker
    public void trackVideoUploadingClicked() {
        this.a.track(new VideoUploadingClickEvent(this.b));
    }
}
