package com.avito.android;

import a2.b.a.a.a;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchRadius;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.category_parameters.ObjectsParameter;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.facebook.appevents.integrity.IntegrityManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u00002\u00020\u0001:\u0003@ABJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011Jm\u0010\u001f\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001dH&¢\u0006\u0004\b\u001f\u0010 J=\u0010'\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020!2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00072\u0006\u0010&\u001a\u00020%H&¢\u0006\u0004\b'\u0010(J)\u0010,\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010!H&¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0007H&¢\u0006\u0004\b0\u0010/JE\u00108\u001a\u00020\u00042\n\b\u0002\u00102\u001a\u0004\u0018\u0001012\n\b\u0002\u00103\u001a\u0004\u0018\u0001012\u001c\b\u0002\u00107\u001a\u0016\u0012\u0004\u0012\u000205\u0018\u000104j\n\u0012\u0004\u0012\u000205\u0018\u0001`6H&¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020!H&¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u0004H&¢\u0006\u0004\b<\u0010=J\u0019\u0010?\u001a\u00020\u00042\b\u0010>\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b?\u0010/¨\u0006C"}, d2 = {"Lcom/avito/android/PublishIntentFactory;", "", "Lcom/avito/android/remote/model/Navigation;", "navigation", "Landroid/content/Intent;", "publishAdvertIntent", "(Lcom/avito/android/remote/model/Navigation;)Landroid/content/Intent;", "", "itemId", "action", "focusId", "editingAdvertIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "draftId", "", "trackDraftResume", "publishAdvertFromDraftIntent", "(Ljava/lang/String;Z)Landroid/content/Intent;", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "Lcom/avito/android/remote/model/SearchRadius;", "searchRadius", "categoryId", "Lcom/avito/android/PublishIntentFactory$LocationPickerChooseButtonLocation;", "chooseButtonLocation", "Lcom/avito/android/remote/model/SearchParams;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Lcom/avito/android/PublishIntentFactory$JobAssistantParams;", "jobAssistantParams", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;", "validationRules", "locationPickerIntent", "(Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;Ljava/lang/String;Lcom/avito/android/remote/model/SearchRadius;Ljava/lang/String;Lcom/avito/android/PublishIntentFactory$LocationPickerChooseButtonLocation;Lcom/avito/android/remote/model/SearchParams;Lcom/avito/android/PublishIntentFactory$JobAssistantParams;Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;)Landroid/content/Intent;", "", "maxPhotoCount", "minPhotoCount", "selectedPhotoId", "Lcom/avito/android/PublishIntentFactory$PhotoPickerMode;", "mode", "createPhotoPickerIntentForPublish", "(Ljava/lang/String;IILjava/lang/String;Lcom/avito/android/PublishIntentFactory$PhotoPickerMode;)Landroid/content/Intent;", "Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;", "objectsParameter", "selectedObjectIndex", "createObjectsEditIntent", "(Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;Ljava/lang/Integer;)Landroid/content/Intent;", "createLimitsHistoryIntent", "(Ljava/lang/String;)Landroid/content/Intent;", "createLimitsHistoryForDraftIntent", "", "lat", "lng", "Ljava/util/ArrayList;", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value;", "Lkotlin/collections/ArrayList;", ResidentialComplexModuleKt.VALUES, "createResidentialComplexSuggestActivity", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/util/ArrayList;)Landroid/content/Intent;", "createCpaTariffActivity", "(I)Landroid/content/Intent;", "newAdvert", "()Landroid/content/Intent;", "calledFrom", "createPublishOverlayIntent", "JobAssistantParams", "LocationPickerChooseButtonLocation", "PhotoPickerMode", "core_release"}, k = 1, mv = {1, 4, 2})
public interface PublishIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent createPhotoPickerIntentForPublish$default(PublishIntentFactory publishIntentFactory, String str, int i, int i2, String str2, PhotoPickerMode photoPickerMode, int i3, Object obj) {
            if (obj == null) {
                int i4 = (i3 & 4) != 0 ? 0 : i2;
                if ((i3 & 8) != 0) {
                    str2 = null;
                }
                return publishIntentFactory.createPhotoPickerIntentForPublish(str, i, i4, str2, photoPickerMode);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createPhotoPickerIntentForPublish");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.avito.android.PublishIntentFactory */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Intent createResidentialComplexSuggestActivity$default(PublishIntentFactory publishIntentFactory, Double d, Double d2, ArrayList arrayList, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    d = null;
                }
                if ((i & 2) != 0) {
                    d2 = null;
                }
                if ((i & 4) != 0) {
                    arrayList = null;
                }
                return publishIntentFactory.createResidentialComplexSuggestActivity(d, d2, arrayList);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createResidentialComplexSuggestActivity");
        }

        public static /* synthetic */ Intent editingAdvertIntent$default(PublishIntentFactory publishIntentFactory, String str, String str2, String str3, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                if ((i & 4) != 0) {
                    str3 = null;
                }
                return publishIntentFactory.editingAdvertIntent(str, str2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: editingAdvertIntent");
        }

        public static /* synthetic */ Intent locationPickerIntent$default(PublishIntentFactory publishIntentFactory, AddressParameter.Value value, String str, SearchRadius searchRadius, String str2, LocationPickerChooseButtonLocation locationPickerChooseButtonLocation, SearchParams searchParams, JobAssistantParams jobAssistantParams, AddressParameter.ValidationRules validationRules, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    value = null;
                }
                if ((i & 2) != 0) {
                    str = null;
                }
                if ((i & 4) != 0) {
                    searchRadius = null;
                }
                if ((i & 8) != 0) {
                    str2 = null;
                }
                if ((i & 16) != 0) {
                    locationPickerChooseButtonLocation = LocationPickerChooseButtonLocation.APPBAR;
                }
                if ((i & 32) != 0) {
                    searchParams = null;
                }
                if ((i & 64) != 0) {
                    jobAssistantParams = null;
                }
                if ((i & 128) != 0) {
                    validationRules = null;
                }
                return publishIntentFactory.locationPickerIntent(value, str, searchRadius, str2, locationPickerChooseButtonLocation, searchParams, jobAssistantParams, validationRules);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: locationPickerIntent");
        }

        public static /* synthetic */ Intent publishAdvertFromDraftIntent$default(PublishIntentFactory publishIntentFactory, String str, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = true;
                }
                return publishIntentFactory.publishAdvertFromDraftIntent(str, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: publishAdvertFromDraftIntent");
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/avito/android/PublishIntentFactory$JobAssistantParams;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "channelId", "copy", "(Ljava/lang/String;)Lcom/avito/android/PublishIntentFactory$JobAssistantParams;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getChannelId", "<init>", "(Ljava/lang/String;)V", "core_release"}, k = 1, mv = {1, 4, 2})
    public static final class JobAssistantParams implements Parcelable {
        public static final Parcelable.Creator<JobAssistantParams> CREATOR = new Creator();
        @NotNull
        public final String a;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<JobAssistantParams> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final JobAssistantParams createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new JobAssistantParams(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final JobAssistantParams[] newArray(int i) {
                return new JobAssistantParams[i];
            }
        }

        public JobAssistantParams(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "channelId");
            this.a = str;
        }

        public static /* synthetic */ JobAssistantParams copy$default(JobAssistantParams jobAssistantParams, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = jobAssistantParams.a;
            }
            return jobAssistantParams.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final JobAssistantParams copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "channelId");
            return new JobAssistantParams(str);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof JobAssistantParams) && Intrinsics.areEqual(this.a, ((JobAssistantParams) obj).a);
            }
            return true;
        }

        @NotNull
        public final String getChannelId() {
            return this.a;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            return a.t(a.L("JobAssistantParams(channelId="), this.a, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/PublishIntentFactory$LocationPickerChooseButtonLocation;", "", "<init>", "(Ljava/lang/String;I)V", "APPBAR", "FOOTER", "core_release"}, k = 1, mv = {1, 4, 2})
    public enum LocationPickerChooseButtonLocation {
        APPBAR,
        FOOTER
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/PublishIntentFactory$PhotoPickerMode;", "", "<init>", "(Ljava/lang/String;I)V", "MODE_LEGACY", "MODE_ADD", "MODE_EDIT", "core_release"}, k = 1, mv = {1, 4, 2})
    public enum PhotoPickerMode {
        MODE_LEGACY,
        MODE_ADD,
        MODE_EDIT
    }

    @NotNull
    Intent createCpaTariffActivity(int i);

    @NotNull
    Intent createLimitsHistoryForDraftIntent(@NotNull String str);

    @NotNull
    Intent createLimitsHistoryIntent(@NotNull String str);

    @NotNull
    Intent createObjectsEditIntent(@NotNull Navigation navigation, @NotNull ObjectsParameter objectsParameter, @Nullable Integer num);

    @NotNull
    Intent createPhotoPickerIntentForPublish(@NotNull String str, int i, int i2, @Nullable String str2, @NotNull PhotoPickerMode photoPickerMode);

    @NotNull
    Intent createPublishOverlayIntent(@Nullable String str);

    @NotNull
    Intent createResidentialComplexSuggestActivity(@Nullable Double d, @Nullable Double d2, @Nullable ArrayList<SelectParameter.Value> arrayList);

    @NotNull
    Intent editingAdvertIntent(@NotNull String str, @Nullable String str2, @Nullable String str3);

    @NotNull
    Intent locationPickerIntent(@Nullable AddressParameter.Value value, @Nullable String str, @Nullable SearchRadius searchRadius, @Nullable String str2, @NotNull LocationPickerChooseButtonLocation locationPickerChooseButtonLocation, @Nullable SearchParams searchParams, @Nullable JobAssistantParams jobAssistantParams, @Nullable AddressParameter.ValidationRules validationRules);

    @NotNull
    Intent newAdvert();

    @NotNull
    Intent publishAdvertFromDraftIntent(@NotNull String str, boolean z);

    @NotNull
    Intent publishAdvertIntent(@NotNull Navigation navigation);
}
