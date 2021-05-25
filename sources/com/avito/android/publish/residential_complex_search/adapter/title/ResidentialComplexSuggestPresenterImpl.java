package com.avito.android.publish.residential_complex_search.adapter.title;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/publish/residential_complex_search/adapter/title/ResidentialComplexSuggestPresenterImpl;", "Lcom/avito/android/publish/residential_complex_search/adapter/title/ResidentialComplexSuggestPresenter;", "Lcom/avito/android/publish/residential_complex_search/adapter/title/ResidentialComplexSuggestView;", "view", "Lcom/avito/android/publish/residential_complex_search/adapter/title/ResidentialComplexSuggestItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/publish/residential_complex_search/adapter/title/ResidentialComplexSuggestView;Lcom/avito/android/publish/residential_complex_search/adapter/title/ResidentialComplexSuggestItem;I)V", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getClicks", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "clicks", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ResidentialComplexSuggestPresenterImpl implements ResidentialComplexSuggestPresenter {
    @NotNull
    public final SingleLiveEvent<ResidentialComplexSuggestItem> a = new SingleLiveEvent<>();

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ResidentialComplexSuggestPresenterImpl a;
        public final /* synthetic */ ResidentialComplexSuggestItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ResidentialComplexSuggestPresenterImpl residentialComplexSuggestPresenterImpl, ResidentialComplexSuggestItem residentialComplexSuggestItem) {
            super(0);
            this.a = residentialComplexSuggestPresenterImpl;
            this.b = residentialComplexSuggestItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getClicks().postValue(this.b);
            return Unit.INSTANCE;
        }
    }

    @Override // com.avito.android.publish.residential_complex_search.adapter.title.ResidentialComplexSuggestPresenter
    @NotNull
    public SingleLiveEvent<ResidentialComplexSuggestItem> getClicks() {
        return this.a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003c, code lost:
        if ((r0.length() > 0) != false) goto L_0x0040;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindView(@org.jetbrains.annotations.NotNull com.avito.android.publish.residential_complex_search.adapter.title.ResidentialComplexSuggestView r4, @org.jetbrains.annotations.NotNull com.avito.android.publish.residential_complex_search.adapter.title.ResidentialComplexSuggestItem r5, int r6) {
        /*
            r3 = this;
            java.lang.String r6 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r6)
            java.lang.String r6 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r6)
            com.avito.android.remote.model.ResidentialComplexSuggest r6 = r5.getResidentialComplexSuggest()
            java.lang.String r0 = r6.getName()
            r4.bindName(r0)
            java.lang.String r0 = r6.getOfficialDeveloper()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x002a
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0025
            r0 = 1
            goto L_0x0026
        L_0x0025:
            r0 = 0
        L_0x0026:
            if (r0 == 0) goto L_0x002a
            r0 = 1
            goto L_0x002b
        L_0x002a:
            r0 = 0
        L_0x002b:
            if (r0 == 0) goto L_0x0062
            java.lang.String r0 = r6.getLocationName()
            if (r0 == 0) goto L_0x003f
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x003b
            r0 = 1
            goto L_0x003c
        L_0x003b:
            r0 = 0
        L_0x003c:
            if (r0 == 0) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r1 = 0
        L_0x0040:
            if (r1 == 0) goto L_0x0062
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r6.getOfficialDeveloper()
            r0.append(r1)
            java.lang.String r1 = ", "
            r0.append(r1)
            java.lang.String r6 = r6.getLocationName()
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            r4.bindDescription(r6)
            goto L_0x0067
        L_0x0062:
            java.lang.String r6 = ""
            r4.bindDescription(r6)
        L_0x0067:
            com.avito.android.publish.residential_complex_search.adapter.title.ResidentialComplexSuggestPresenterImpl$a r6 = new com.avito.android.publish.residential_complex_search.adapter.title.ResidentialComplexSuggestPresenterImpl$a
            r6.<init>(r3, r5)
            r4.setClickAction(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.publish.residential_complex_search.adapter.title.ResidentialComplexSuggestPresenterImpl.bindView(com.avito.android.publish.residential_complex_search.adapter.title.ResidentialComplexSuggestView, com.avito.android.publish.residential_complex_search.adapter.title.ResidentialComplexSuggestItem, int):void");
    }
}
