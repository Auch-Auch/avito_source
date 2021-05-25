package com.sumsub.sns.presentation.screen.preview.photo.identity;

import a2.b.a.a.a;
import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import com.avito.android.remote.auth.AuthSource;
import com.google.gson.Gson;
import com.sumsub.sns.core.data.model.AppConfigKt;
import com.sumsub.sns.core.data.model.Applicant;
import com.sumsub.sns.core.data.model.DocumentPickerResult;
import com.sumsub.sns.core.data.model.DocumentType;
import com.sumsub.sns.core.data.model.Error;
import com.sumsub.sns.core.data.model.IdentitySide;
import com.sumsub.sns.core.data.model.IdentityType;
import com.sumsub.sns.core.data.source.common.CommonRepository;
import com.sumsub.sns.core.domain.GetApplicantUseCase;
import com.sumsub.sns.core.domain.GetConfigUseCase;
import com.sumsub.sns.core.domain.SendLogUseCase;
import com.sumsub.sns.core.presentation.base.Event;
import com.sumsub.sns.domain.UploadDocumentImagesUseCase;
import com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
import t6.n.e;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001@B?\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u00107\u001a\u000206\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010;\u001a\u00020:\u0012\u0006\u0010=\u001a\u00020<\u0012\u0006\u0010)\u001a\u00020&¢\u0006\u0004\b>\u0010?J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\t\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001d\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u001fH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\"\u0010\u0004R\u0016\u0010%\u001a\u00020\u00108B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R%\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0+0*8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100¨\u0006A"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/photo/identity/SNSPreviewIdentityDocumentViewModel;", "Lcom/sumsub/sns/presentation/screen/preview/photo/SNSPreviewPhotoDocumentViewModel;", "", "onDataLoaded", "()V", "", "", "map", "sourceKey", "mapTransformation", "(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;", "countryKey", "idDocType", "onDocumentAndCountrySelected", "(Ljava/lang/String;Ljava/lang/String;)V", "resolveBackSide", "", "hasBack", "onDocumentSideAnswerClicked", "(Z)V", "Lcom/sumsub/sns/presentation/screen/preview/photo/SNSPreviewPhotoDocumentViewModel$PickerRequest;", "preparePickerRequest", "()Lcom/sumsub/sns/presentation/screen/preview/photo/SNSPreviewPhotoDocumentViewModel$PickerRequest;", "Lcom/sumsub/sns/core/data/model/Error;", "error", "onHandleError", "(Lcom/sumsub/sns/core/data/model/Error;)V", "Lcom/sumsub/sns/core/data/model/DocumentPickerResult;", "result", "onDocumentPicked", "(Lcom/sumsub/sns/core/data/model/DocumentPickerResult;)V", "", g.a, "()Ljava/util/List;", "h", "f", "()Z", "shouldSkipSelector", "Lcom/google/gson/Gson;", "K", "Lcom/google/gson/Gson;", "gson", "Landroidx/lifecycle/MutableLiveData;", "Lcom/sumsub/sns/core/presentation/base/Event;", "Lcom/sumsub/sns/presentation/screen/preview/photo/identity/SNSPreviewIdentityDocumentViewModel$SelectorRequest;", "J", "Landroidx/lifecycle/MutableLiveData;", "getShowSelector", "()Landroidx/lifecycle/MutableLiveData;", "showSelector", "Lcom/sumsub/sns/core/domain/GetConfigUseCase;", "getConfigUseCase", "Lcom/sumsub/sns/core/domain/GetApplicantUseCase;", "getApplicantUseCase", "Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle", "Lcom/sumsub/sns/domain/UploadDocumentImagesUseCase;", "uploadDocumentImagesUseCase", "Lcom/sumsub/sns/core/domain/SendLogUseCase;", "sendLogUseCase", "Lcom/sumsub/sns/core/data/source/common/CommonRepository;", "commonRepository", "<init>", "(Lcom/sumsub/sns/core/domain/GetConfigUseCase;Lcom/sumsub/sns/core/domain/GetApplicantUseCase;Landroidx/lifecycle/SavedStateHandle;Lcom/sumsub/sns/domain/UploadDocumentImagesUseCase;Lcom/sumsub/sns/core/domain/SendLogUseCase;Lcom/sumsub/sns/core/data/source/common/CommonRepository;Lcom/google/gson/Gson;)V", "SelectorRequest", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class SNSPreviewIdentityDocumentViewModel extends SNSPreviewPhotoDocumentViewModel {
    @NotNull
    public final MutableLiveData<Event<SelectorRequest>> J = new MutableLiveData<>();
    public final Gson K;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/photo/identity/SNSPreviewIdentityDocumentViewModel$SelectorRequest;", "", "Lcom/sumsub/sns/core/data/model/Applicant;", "component1", "()Lcom/sumsub/sns/core/data/model/Applicant;", "", "component2", "()Ljava/lang/String;", "applicant", "documentType", "copy", "(Lcom/sumsub/sns/core/data/model/Applicant;Ljava/lang/String;)Lcom/sumsub/sns/presentation/screen/preview/photo/identity/SNSPreviewIdentityDocumentViewModel$SelectorRequest;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/sumsub/sns/core/data/model/Applicant;", "getApplicant", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getDocumentType", "<init>", "(Lcom/sumsub/sns/core/data/model/Applicant;Ljava/lang/String;)V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class SelectorRequest {
        @NotNull
        public final Applicant a;
        @NotNull
        public final String b;

        public SelectorRequest(@NotNull Applicant applicant, @NotNull String str) {
            Intrinsics.checkNotNullParameter(applicant, "applicant");
            Intrinsics.checkNotNullParameter(str, "documentType");
            this.a = applicant;
            this.b = str;
        }

        public static /* synthetic */ SelectorRequest copy$default(SelectorRequest selectorRequest, Applicant applicant, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                applicant = selectorRequest.a;
            }
            if ((i & 2) != 0) {
                str = selectorRequest.b;
            }
            return selectorRequest.copy(applicant, str);
        }

        @NotNull
        public final Applicant component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final SelectorRequest copy(@NotNull Applicant applicant, @NotNull String str) {
            Intrinsics.checkNotNullParameter(applicant, "applicant");
            Intrinsics.checkNotNullParameter(str, "documentType");
            return new SelectorRequest(applicant, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SelectorRequest)) {
                return false;
            }
            SelectorRequest selectorRequest = (SelectorRequest) obj;
            return Intrinsics.areEqual(this.a, selectorRequest.a) && Intrinsics.areEqual(this.b, selectorRequest.b);
        }

        @NotNull
        public final Applicant getApplicant() {
            return this.a;
        }

        @NotNull
        public final String getDocumentType() {
            return this.b;
        }

        public int hashCode() {
            Applicant applicant = this.a;
            int i = 0;
            int hashCode = (applicant != null ? applicant.hashCode() : 0) * 31;
            String str = this.b;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("SelectorRequest(applicant=");
            L.append(this.a);
            L.append(", documentType=");
            return a.t(L, this.b, ")");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSPreviewIdentityDocumentViewModel(@NotNull GetConfigUseCase getConfigUseCase, @NotNull GetApplicantUseCase getApplicantUseCase, @NotNull SavedStateHandle savedStateHandle, @NotNull UploadDocumentImagesUseCase uploadDocumentImagesUseCase, @NotNull SendLogUseCase sendLogUseCase, @NotNull CommonRepository commonRepository, @NotNull Gson gson) {
        super(getConfigUseCase, getApplicantUseCase, savedStateHandle, commonRepository, uploadDocumentImagesUseCase, sendLogUseCase, gson);
        Intrinsics.checkNotNullParameter(getConfigUseCase, "getConfigUseCase");
        Intrinsics.checkNotNullParameter(getApplicantUseCase, "getApplicantUseCase");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(uploadDocumentImagesUseCase, "uploadDocumentImagesUseCase");
        Intrinsics.checkNotNullParameter(sendLogUseCase, "sendLogUseCase");
        Intrinsics.checkNotNullParameter(commonRepository, "commonRepository");
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.K = gson;
        onLoad();
    }

    public final boolean f() {
        return AppConfigKt.shouldSkipSelector(getConfig(), this.K, getDocument().getType().getValue());
    }

    public final List<String> g() {
        Set keySet;
        Set intersect;
        List<String> list;
        List<IdentityType> identityList = getApplicant().getIdentityList(new DocumentType(getDocument().getType().getValue()));
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(identityList, 10));
        Iterator<T> it = identityList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().m209unboximpl());
        }
        List<String> list2 = CollectionsKt___CollectionsKt.toList(arrayList);
        Map<String, Object> documentsByCountries = AppConfigKt.documentsByCountries(getConfig(), this.K);
        Set set = null;
        Object obj = documentsByCountries != null ? documentsByCountries.get(getCountry()) : null;
        if (!(obj instanceof Map)) {
            obj = null;
        }
        Map map = (Map) obj;
        if (map == null || (keySet = map.keySet()) == null || (intersect = CollectionsKt___CollectionsKt.intersect(keySet, list2)) == null) {
            return list2;
        }
        if (!intersect.isEmpty()) {
            set = intersect;
        }
        return (set == null || (list = CollectionsKt___CollectionsKt.toList(set)) == null) ? list2 : list;
    }

    @NotNull
    public final MutableLiveData<Event<SelectorRequest>> getShowSelector() {
        return this.J;
    }

    public final void h() {
        this.J.postValue(new Event<>(new SelectorRequest(getApplicant(), getDocument().getType().getValue())));
    }

    @Override // com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel
    @NotNull
    public String mapTransformation(@Nullable Map<String, String> map, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "sourceKey");
        if (!f()) {
            return super.mapTransformation(map, str);
        }
        String c3 = a.c3(str, "_noSelector");
        String str2 = null;
        if ((map != null ? map.get(c3) : null) != null) {
            return c3;
        }
        if ((map != null ? map.get(str) : null) != null) {
            return str;
        }
        if (map != null) {
            str2 = map.get("default_noSelector");
        }
        if (str2 != null) {
            return "default_noSelector";
        }
        return "default";
    }

    @Override // com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel, com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewViewModel
    public void onDataLoaded() {
        if (f()) {
            Timber.d("Should skip selector", new Object[0]);
            String str = (String) CollectionsKt___CollectionsKt.first((List<? extends Object>) g());
            String country = getCountry();
            if (country != null) {
                onDocumentAndCountrySelected(country, str);
            } else {
                onDataError(new IllegalStateException("Country is null"));
            }
        } else {
            Timber.d("Use selector", new Object[0]);
            h();
        }
    }

    public final void onDocumentAndCountrySelected(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "countryKey");
        Intrinsics.checkNotNullParameter(str2, "idDocType");
        setCountry(str);
        setIdDocType(str2);
        showPicker(IdentitySide.Front);
    }

    @Override // com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel
    public void onDocumentPicked(@Nullable DocumentPickerResult documentPickerResult) {
        if (documentPickerResult != null || f()) {
            super.onDocumentPicked(documentPickerResult);
            return;
        }
        getResults().clear();
        setSide(IdentitySide.Front);
        h();
    }

    @Override // com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel
    public void onDocumentSideAnswerClicked(boolean z) {
        Map map;
        Boolean bool;
        Map<String, Object> documentsByCountries;
        if (f()) {
            String country = getCountry();
            T t = null;
            if (country == null || (documentsByCountries = AppConfigKt.documentsByCountries(getConfig(), this.K)) == null) {
                map = null;
            } else {
                List listOf = d.listOf(country);
                Iterator it = t6.v.e.until(0, listOf.size() - 1).iterator();
                while (true) {
                    if (it.hasNext()) {
                        Object obj = documentsByCountries.get(listOf.get(((IntIterator) it).nextInt()));
                        if (!(obj instanceof Map)) {
                            obj = null;
                        }
                        documentsByCountries = (Map) obj;
                        if (documentsByCountries == null) {
                            break;
                        }
                    } else {
                        Object obj2 = documentsByCountries.get(CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) listOf));
                        if (!(obj2 instanceof Map)) {
                            obj2 = null;
                        }
                        map = (Map) obj2;
                    }
                }
                map = null;
            }
            Iterator<T> it2 = g().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                T next = it2.next();
                T t2 = next;
                if (map != null) {
                    List listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{t2, "doubleSided"});
                    Iterator it3 = t6.v.e.until(0, listOf2.size() - 1).iterator();
                    Map map2 = map;
                    while (true) {
                        if (it3.hasNext()) {
                            Object obj3 = map2.get(listOf2.get(((IntIterator) it3).nextInt()));
                            if (!(obj3 instanceof Map)) {
                                obj3 = null;
                            }
                            map2 = (Map) obj3;
                            if (map2 == null) {
                                break;
                            }
                        } else {
                            Object obj4 = map2.get(CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) listOf2));
                            if (!(obj4 instanceof Boolean)) {
                                obj4 = null;
                            }
                            bool = (Boolean) obj4;
                        }
                    }
                    bool = null;
                } else {
                    bool = null;
                }
                if (Intrinsics.areEqual(bool, Boolean.valueOf(z))) {
                    t = next;
                    break;
                }
            }
            T t3 = t;
            if (t3 != null) {
                setIdDocType(t3);
                List<DocumentPickerResult> results = getResults();
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(results, 10));
                Iterator<T> it4 = results.iterator();
                while (it4.hasNext()) {
                    arrayList.add(DocumentPickerResult.copy$default(it4.next(), null, null, null, getIdDocType(), null, 23, null));
                }
                setResults(CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList));
            }
        }
        super.onDocumentSideAnswerClicked(z);
    }

    @Override // com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel, com.sumsub.sns.presentation.screen.base.SNSBaseViewModel, com.sumsub.sns.core.presentation.base.SNSBaseViewModel
    public void onHandleError(@NotNull Error error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Timber.d("Preview photo error handling... " + error, new Object[0]);
        if (error instanceof Error.Network) {
            onDataIsReadableClicked(0);
        } else {
            super.onHandleError(error);
        }
    }

    @Override // com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel
    @NotNull
    public SNSPreviewPhotoDocumentViewModel.PickerRequest preparePickerRequest() {
        return new SNSPreviewPhotoDocumentViewModel.PickerRequest(getApplicant(), getDocument(), getSide(), false, !f() ? getIdDocType() : null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel
    public void resolveBackSide() {
        Map map;
        Boolean bool;
        Map<String, Object> documentsByCountries;
        String country = getCountry();
        boolean z = false;
        Boolean bool2 = null;
        if (country == null || (documentsByCountries = AppConfigKt.documentsByCountries(getConfig(), this.K)) == null) {
            map = null;
        } else {
            List listOf = d.listOf(country);
            Iterator it = t6.v.e.until(0, listOf.size() - 1).iterator();
            while (true) {
                if (it.hasNext()) {
                    Object obj = documentsByCountries.get(listOf.get(((IntIterator) it).nextInt()));
                    if (!(obj instanceof Map)) {
                        obj = null;
                    }
                    documentsByCountries = (Map) obj;
                    if (documentsByCountries == null) {
                        break;
                    }
                } else {
                    Object obj2 = documentsByCountries.get(CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) listOf));
                    if (!(obj2 instanceof Map)) {
                        obj2 = null;
                    }
                    map = (Map) obj2;
                }
            }
        }
        if (f()) {
            List<String> g = g();
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(g, 10));
            for (T t : g) {
                if (map != null) {
                    List listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{t, "doubleSided"});
                    Iterator it2 = t6.v.e.until(0, listOf2.size() - 1).iterator();
                    Map map2 = map;
                    while (true) {
                        if (it2.hasNext()) {
                            Object obj3 = map2.get(listOf2.get(((IntIterator) it2).nextInt()));
                            if (!(obj3 instanceof Map)) {
                                obj3 = null;
                            }
                            map2 = (Map) obj3;
                            if (map2 == null) {
                                break;
                            }
                        } else {
                            Object obj4 = map2.get(CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) listOf2));
                            if (!(obj4 instanceof Boolean)) {
                                obj4 = null;
                            }
                            bool = (Boolean) obj4;
                        }
                    }
                } else {
                    bool = null;
                }
                arrayList.add(bool);
            }
            Set set = CollectionsKt___CollectionsKt.toSet(arrayList);
            if (set.size() == 1) {
                z = true;
            }
            if (!z) {
                set = null;
            }
            if (set != null) {
                bool2 = (Boolean) CollectionsKt___CollectionsKt.first(set);
            }
        } else if (map != null) {
            List listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{getIdDocType(), "doubleSided"});
            Iterator it3 = t6.v.e.until(0, listOf3.size() - 1).iterator();
            while (true) {
                if (it3.hasNext()) {
                    Object obj5 = map.get(listOf3.get(((IntIterator) it3).nextInt()));
                    if (!(obj5 instanceof Map)) {
                        obj5 = null;
                    }
                    map = (Map) obj5;
                    if (map == null) {
                        break;
                    }
                } else {
                    Object obj6 = map.get(CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) listOf3));
                    if (obj6 instanceof Boolean) {
                        bool2 = obj6;
                    }
                    bool2 = bool2;
                }
            }
        }
        if (bool2 == null) {
            super.resolveBackSide();
        } else {
            onDocumentSideAnswerClicked(bool2.booleanValue());
        }
    }
}
