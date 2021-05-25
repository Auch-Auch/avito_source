package com.avito.android.publish.wizard;

import a2.g.r.g;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.publish.wizard.remote.WizardApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.WizardParameter;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.util.TypedObservablesKt;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\n\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u0018\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b \u0010!J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\bR\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/publish/wizard/WizardInteractorImpl;", "Lcom/avito/android/publish/wizard/WizardInteractor;", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/WizardParameter;", "loadWizardParams", "()Lio/reactivex/Observable;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "itemId", "Lcom/avito/android/remote/model/Navigation;", "c", "Lcom/avito/android/remote/model/Navigation;", "navigation", "Lcom/avito/android/publish/wizard/remote/WizardApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/publish/wizard/remote/WizardApi;", "api", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "e", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "converter", "f", "stepId", "", "d", "Ljava/util/List;", "leaves", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", g.a, "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsDataProvider", "<init>", "(Lcom/avito/android/publish/wizard/remote/WizardApi;Ljava/lang/String;Lcom/avito/android/remote/model/Navigation;Ljava/util/List;Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;Ljava/lang/String;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class WizardInteractorImpl implements WizardInteractor {
    public final WizardApi a;
    public final String b;
    public final Navigation c;
    public final List<Navigation> d;
    public final CategoryParametersConverter e;
    public final String f;
    public final PublishAnalyticsDataProvider g;

    public WizardInteractorImpl(@NotNull WizardApi wizardApi, @Nullable String str, @Nullable Navigation navigation, @NotNull List<Navigation> list, @NotNull CategoryParametersConverter categoryParametersConverter, @Nullable String str2, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider) {
        Intrinsics.checkNotNullParameter(wizardApi, "api");
        Intrinsics.checkNotNullParameter(list, "leaves");
        Intrinsics.checkNotNullParameter(categoryParametersConverter, "converter");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsDataProvider");
        this.a = wizardApi;
        this.b = str;
        this.c = navigation;
        this.d = list;
        this.e = categoryParametersConverter;
        this.f = str2;
        this.g = publishAnalyticsDataProvider;
    }

    @Override // com.avito.android.publish.wizard.WizardInteractor
    @NotNull
    public Observable<WizardParameter> loadWizardParams() {
        Map<String, String> map;
        WizardApi wizardApi = this.a;
        String str = this.b;
        Navigation navigation = this.c;
        if (navigation == null || (map = this.e.convertToFieldMap(navigation)) == null) {
            map = r.emptyMap();
        }
        return TypedObservablesKt.toTyped(InteropKt.toV2(wizardApi.getWizardParametersByNavigation(str, map, this.e.convertToFieldMap(TuplesKt.to("leaves", this.d)), this.f, this.g.getSessionId())));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WizardInteractorImpl(WizardApi wizardApi, String str, Navigation navigation, List list, CategoryParametersConverter categoryParametersConverter, String str2, PublishAnalyticsDataProvider publishAnalyticsDataProvider, int i, j jVar) {
        this(wizardApi, str, navigation, list, categoryParametersConverter, (i & 32) != 0 ? null : str2, publishAnalyticsDataProvider);
    }
}
