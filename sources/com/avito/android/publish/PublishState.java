package com.avito.android.publish;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.avito.android.publish.PublishSession;
import com.avito.android.publish.drafts.LocalPublishState;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CategoryModel;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.WizardParameter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.n.s;
import t6.o.a;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\b\b\u0018\u00002\u00020\u0001:\u0001WBW\u0012\b\b\u0002\u0010/\u001a\u00020\u0011\u0012\b\b\u0002\u00100\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0014\b\u0002\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0&\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010)\u0012\u000e\b\u0002\u00103\u001a\b\u0012\u0004\u0012\u00020)0,¢\u0006\u0004\bU\u0010VJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\u000b\u001a\u00020\n*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\n¢\u0006\u0004\b\u001b\u0010\u001cJ$\u0010\u001f\u001a\u00028\u0000\"\n\b\u0000\u0010\u001e\u0018\u0001*\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\u0006H\b¢\u0006\u0004\b\u001f\u0010 J$\u0010!\u001a\u00028\u0000\"\n\b\u0000\u0010\u001e\u0018\u0001*\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\u0006H\b¢\u0006\u0004\b!\u0010 J\u0010\u0010\"\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\"\u0010\u0018J\u0010\u0010#\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b#\u0010\u0018J\u0010\u0010$\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b$\u0010%J\u001c\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0&HÆ\u0003¢\u0006\u0004\b'\u0010(J\u0012\u0010*\u001a\u0004\u0018\u00010)HÆ\u0003¢\u0006\u0004\b*\u0010+J\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020)0,HÆ\u0003¢\u0006\u0004\b-\u0010.J`\u00104\u001a\u00020\u00002\b\b\u0002\u0010/\u001a\u00020\u00112\b\b\u0002\u00100\u001a\u00020\u00112\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0014\b\u0002\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0&2\n\b\u0002\u00102\u001a\u0004\u0018\u00010)2\u000e\b\u0002\u00103\u001a\b\u0012\u0004\u0012\u00020)0,HÆ\u0001¢\u0006\u0004\b4\u00105J\u0010\u00106\u001a\u00020)HÖ\u0001¢\u0006\u0004\b6\u0010+J\u0010\u00107\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b7\u0010%J\u001a\u0010;\u001a\u00020:2\b\u00109\u001a\u0004\u0018\u000108HÖ\u0003¢\u0006\u0004\b;\u0010<J\u0010\u0010=\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b=\u0010%J \u0010A\u001a\u00020\n2\u0006\u0010?\u001a\u00020>2\u0006\u0010@\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\bA\u0010BR\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010C\u001a\u0004\bD\u0010%\"\u0004\bE\u0010FR\"\u00100\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b0\u0010G\u001a\u0004\bH\u0010\u0018\"\u0004\bI\u0010JR\"\u0010/\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b/\u0010G\u001a\u0004\bK\u0010\u0018\"\u0004\bL\u0010JR(\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0&8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b1\u0010M\u001a\u0004\bN\u0010(R\"\u00103\u001a\b\u0012\u0004\u0012\u00020)0,8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b3\u0010O\u001a\u0004\bP\u0010.R$\u00102\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b2\u0010Q\u001a\u0004\bR\u0010+\"\u0004\bS\u0010T¨\u0006X"}, d2 = {"Lcom/avito/android/publish/PublishState;", "Landroid/os/Parcelable;", "Lcom/avito/android/publish/PublishState$StepState$CategoriesSuggestions;", AuthSource.SEND_ABUSE, "()Lcom/avito/android/publish/PublishState$StepState$CategoriesSuggestions;", "Lcom/avito/android/publish/PublishState$StepState$CategorySelector;", "", "stepIndex", "Lcom/avito/android/remote/model/CategoryModel;", "newCategory", "", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/publish/PublishState$StepState$CategorySelector;ILcom/avito/android/remote/model/CategoryModel;)V", "deepCopy", "()Lcom/avito/android/publish/PublishState;", "setSelectedCategoryForStep", "(ILcom/avito/android/remote/model/CategoryModel;)V", "Lcom/avito/android/remote/model/Navigation;", "currentNavigation", "setCurrentNavigationForStep", "(ILcom/avito/android/remote/model/Navigation;)V", "getCurrentNavigationForStep", "(I)Lcom/avito/android/remote/model/Navigation;", "getPublishProcessNavigation", "()Lcom/avito/android/remote/model/Navigation;", "resetStepStatesWithNewCategory", "(Lcom/avito/android/remote/model/CategoryModel;)V", "restoreChangedCategoryStateStep", "()V", "Lcom/avito/android/publish/PublishState$StepState;", "T", "getStepState", "(I)Lcom/avito/android/publish/PublishState$StepState;", "resetStepState", "component1", "component2", "component3", "()I", "", "component4", "()Ljava/util/Map;", "", "component5", "()Ljava/lang/String;", "", "component6", "()Ljava/util/Set;", "rootNavigation", "navigation", "stepStates", "activeFieldId", LocalPublishState.CHANGED_IDS, "copy", "(Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/Navigation;ILjava/util/Map;Ljava/lang/String;Ljava/util/Set;)Lcom/avito/android/publish/PublishState;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getStepIndex", "setStepIndex", "(I)V", "Lcom/avito/android/remote/model/Navigation;", "getNavigation", "setNavigation", "(Lcom/avito/android/remote/model/Navigation;)V", "getRootNavigation", "setRootNavigation", "Ljava/util/Map;", "getStepStates", "Ljava/util/Set;", "getChangedFieldIds", "Ljava/lang/String;", "getActiveFieldId", "setActiveFieldId", "(Ljava/lang/String;)V", "<init>", "(Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/Navigation;ILjava/util/Map;Ljava/lang/String;Ljava/util/Set;)V", "StepState", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PublishState implements Parcelable {
    public static final Parcelable.Creator<PublishState> CREATOR = new Creator();
    @SerializedName("activeFieldId")
    @Nullable
    private String activeFieldId;
    @SerializedName(LocalPublishState.CHANGED_IDS)
    @NotNull
    private final Set<String> changedFieldIds;
    @SerializedName("navigation")
    @NotNull
    private Navigation navigation;
    @SerializedName("rootNavigation")
    @NotNull
    private Navigation rootNavigation;
    @SerializedName("stepIndex")
    private int stepIndex;
    @SerializedName("stepStates")
    @NotNull
    private final Map<Integer, StepState> stepStates;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PublishState> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PublishState createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            Navigation navigation = (Navigation) parcel.readParcelable(PublishState.class.getClassLoader());
            Navigation navigation2 = (Navigation) parcel.readParcelable(PublishState.class.getClassLoader());
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt2);
            while (readInt2 != 0) {
                linkedHashMap.put(Integer.valueOf(parcel.readInt()), (StepState) parcel.readParcelable(PublishState.class.getClassLoader()));
                readInt2--;
            }
            String readString = parcel.readString();
            int readInt3 = parcel.readInt();
            LinkedHashSet linkedHashSet = new LinkedHashSet(readInt3);
            while (readInt3 != 0) {
                linkedHashSet.add(parcel.readString());
                readInt3--;
            }
            return new PublishState(navigation, navigation2, readInt, linkedHashMap, readString, linkedHashSet);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PublishState[] newArray(int i) {
            return new PublishState[i];
        }
    }

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\t\n\u000b\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0001\u0003\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/publish/PublishState$StepState;", "Landroid/os/Parcelable;", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "CategoriesSuggestions", "CategorySelector", "Vin", "Wizard", "Lcom/avito/android/publish/PublishState$StepState$Wizard;", "Lcom/avito/android/publish/PublishState$StepState$CategoriesSuggestions;", "Lcom/avito/android/publish/PublishState$StepState$Vin;", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class StepState implements Parcelable {
        @SerializedName("type")
        @NotNull
        private final String type;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\u0004\"\u0004\b\t\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/publish/PublishState$StepState$CategorySelector;", "", "Lcom/avito/android/remote/model/Navigation;", "getCurrentNavigation", "()Lcom/avito/android/remote/model/Navigation;", "setCurrentNavigation", "(Lcom/avito/android/remote/model/Navigation;)V", "currentNavigation", "getPreviousNavigation", "setPreviousNavigation", "previousNavigation", "publish_release"}, k = 1, mv = {1, 4, 2})
        public interface CategorySelector {
            @Nullable
            Navigation getCurrentNavigation();

            @Nullable
            Navigation getPreviousNavigation();

            void setCurrentNavigation(@Nullable Navigation navigation);

            void setPreviousNavigation(@Nullable Navigation navigation);
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/avito/android/publish/PublishState$StepState$Vin;", "Lcom/avito/android/publish/PublishState$StepState;", "", "component1", "()Ljava/lang/String;", "recognizedVin", "copy", "(Ljava/lang/String;)Lcom/avito/android/publish/PublishState$StepState$Vin;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getRecognizedVin", "setRecognizedVin", "(Ljava/lang/String;)V", "<init>", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class Vin extends StepState {
            public static final Parcelable.Creator<Vin> CREATOR = new Creator();
            @SerializedName("recognizedVin")
            @Nullable
            private String recognizedVin;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Vin> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Vin createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new Vin(parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Vin[] newArray(int i) {
                    return new Vin[i];
                }
            }

            public Vin() {
                this(null, 1, null);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Vin(String str, int i, j jVar) {
                this((i & 1) != 0 ? null : str);
            }

            public static /* synthetic */ Vin copy$default(Vin vin, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = vin.recognizedVin;
                }
                return vin.copy(str);
            }

            @Nullable
            public final String component1() {
                return this.recognizedVin;
            }

            @NotNull
            public final Vin copy(@Nullable String str) {
                return new Vin(str);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // java.lang.Object
            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Vin) && Intrinsics.areEqual(this.recognizedVin, ((Vin) obj).recognizedVin);
                }
                return true;
            }

            @Nullable
            public final String getRecognizedVin() {
                return this.recognizedVin;
            }

            @Override // java.lang.Object
            public int hashCode() {
                String str = this.recognizedVin;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public final void setRecognizedVin(@Nullable String str) {
                this.recognizedVin = str;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                return a2.b.a.a.a.t(a2.b.a.a.a.L("Vin(recognizedVin="), this.recognizedVin, ")");
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.recognizedVin);
            }

            public Vin(@Nullable String str) {
                super(PublishSession.StepType.VIN.toString(), null);
                this.recognizedVin = str;
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b'\u0010(J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J4\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0012J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR$\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010\u0005\"\u0004\b!\u0010\"R$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u001f\u001a\u0004\b#\u0010\u0005\"\u0004\b$\u0010\"R$\u0010\b\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u001f\u001a\u0004\b%\u0010\u0005\"\u0004\b&\u0010\"¨\u0006)"}, d2 = {"Lcom/avito/android/publish/PublishState$StepState$Wizard;", "Lcom/avito/android/publish/PublishState$StepState;", "Lcom/avito/android/publish/PublishState$StepState$CategorySelector;", "Lcom/avito/android/remote/model/Navigation;", "component1", "()Lcom/avito/android/remote/model/Navigation;", "component2", "component3", "previousNavigation", "selectedNavigation", "currentNavigation", "copy", "(Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/Navigation;)Lcom/avito/android/publish/PublishState$StepState$Wizard;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Navigation;", "getSelectedNavigation", "setSelectedNavigation", "(Lcom/avito/android/remote/model/Navigation;)V", "getCurrentNavigation", "setCurrentNavigation", "getPreviousNavigation", "setPreviousNavigation", "<init>", "(Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/Navigation;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class Wizard extends StepState implements CategorySelector {
            public static final Parcelable.Creator<Wizard> CREATOR = new Creator();
            @SerializedName("currentNavigation")
            @Nullable
            private Navigation currentNavigation;
            @SerializedName("previousNavigation")
            @Nullable
            private Navigation previousNavigation;
            @SerializedName("selectedNavigation")
            @Nullable
            private Navigation selectedNavigation;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Wizard> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Wizard createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new Wizard((Navigation) parcel.readParcelable(Wizard.class.getClassLoader()), (Navigation) parcel.readParcelable(Wizard.class.getClassLoader()), (Navigation) parcel.readParcelable(Wizard.class.getClassLoader()));
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Wizard[] newArray(int i) {
                    return new Wizard[i];
                }
            }

            public Wizard() {
                this(null, null, null, 7, null);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Wizard(Navigation navigation, Navigation navigation2, Navigation navigation3, int i, j jVar) {
                this((i & 1) != 0 ? null : navigation, (i & 2) != 0 ? null : navigation2, (i & 4) != 0 ? null : navigation3);
            }

            public static /* synthetic */ Wizard copy$default(Wizard wizard, Navigation navigation, Navigation navigation2, Navigation navigation3, int i, Object obj) {
                if ((i & 1) != 0) {
                    navigation = wizard.getPreviousNavigation();
                }
                if ((i & 2) != 0) {
                    navigation2 = wizard.selectedNavigation;
                }
                if ((i & 4) != 0) {
                    navigation3 = wizard.getCurrentNavigation();
                }
                return wizard.copy(navigation, navigation2, navigation3);
            }

            @Nullable
            public final Navigation component1() {
                return getPreviousNavigation();
            }

            @Nullable
            public final Navigation component2() {
                return this.selectedNavigation;
            }

            @Nullable
            public final Navigation component3() {
                return getCurrentNavigation();
            }

            @NotNull
            public final Wizard copy(@Nullable Navigation navigation, @Nullable Navigation navigation2, @Nullable Navigation navigation3) {
                return new Wizard(navigation, navigation2, navigation3);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // java.lang.Object
            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Wizard)) {
                    return false;
                }
                Wizard wizard = (Wizard) obj;
                return Intrinsics.areEqual(getPreviousNavigation(), wizard.getPreviousNavigation()) && Intrinsics.areEqual(this.selectedNavigation, wizard.selectedNavigation) && Intrinsics.areEqual(getCurrentNavigation(), wizard.getCurrentNavigation());
            }

            @Override // com.avito.android.publish.PublishState.StepState.CategorySelector
            @Nullable
            public Navigation getCurrentNavigation() {
                return this.currentNavigation;
            }

            @Override // com.avito.android.publish.PublishState.StepState.CategorySelector
            @Nullable
            public Navigation getPreviousNavigation() {
                return this.previousNavigation;
            }

            @Nullable
            public final Navigation getSelectedNavigation() {
                return this.selectedNavigation;
            }

            @Override // java.lang.Object
            public int hashCode() {
                Navigation previousNavigation2 = getPreviousNavigation();
                int i = 0;
                int hashCode = (previousNavigation2 != null ? previousNavigation2.hashCode() : 0) * 31;
                Navigation navigation = this.selectedNavigation;
                int hashCode2 = (hashCode + (navigation != null ? navigation.hashCode() : 0)) * 31;
                Navigation currentNavigation2 = getCurrentNavigation();
                if (currentNavigation2 != null) {
                    i = currentNavigation2.hashCode();
                }
                return hashCode2 + i;
            }

            @Override // com.avito.android.publish.PublishState.StepState.CategorySelector
            public void setCurrentNavigation(@Nullable Navigation navigation) {
                this.currentNavigation = navigation;
            }

            @Override // com.avito.android.publish.PublishState.StepState.CategorySelector
            public void setPreviousNavigation(@Nullable Navigation navigation) {
                this.previousNavigation = navigation;
            }

            public final void setSelectedNavigation(@Nullable Navigation navigation) {
                this.selectedNavigation = navigation;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("Wizard(previousNavigation=");
                L.append(getPreviousNavigation());
                L.append(", selectedNavigation=");
                L.append(this.selectedNavigation);
                L.append(", currentNavigation=");
                L.append(getCurrentNavigation());
                L.append(")");
                return L.toString();
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeParcelable(this.previousNavigation, i);
                parcel.writeParcelable(this.selectedNavigation, i);
                parcel.writeParcelable(this.currentNavigation, i);
            }

            public Wizard(@Nullable Navigation navigation, @Nullable Navigation navigation2, @Nullable Navigation navigation3) {
                super(PublishSession.StepType.WIZARD.toString(), null);
                this.previousNavigation = navigation;
                this.selectedNavigation = navigation2;
                this.currentNavigation = navigation3;
            }
        }

        private StepState(String str) {
            this.type = str;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u00012\u00020\u0002B;\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b4\u00105J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\r\u0010\u0005JD\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0019J \u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b$\u0010%R$\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010&\u001a\u0004\b'\u0010\b\"\u0004\b(\u0010)R$\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010*\u001a\u0004\b+\u0010\u0005\"\u0004\b,\u0010-R(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010.\u001a\u0004\b/\u0010\f\"\u0004\b0\u00101R$\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010*\u001a\u0004\b2\u0010\u0005\"\u0004\b3\u0010-¨\u00066"}, d2 = {"Lcom/avito/android/publish/PublishState$StepState$CategoriesSuggestions;", "Lcom/avito/android/publish/PublishState$StepState;", "Lcom/avito/android/publish/PublishState$StepState$CategorySelector;", "Lcom/avito/android/remote/model/Navigation;", "component1", "()Lcom/avito/android/remote/model/Navigation;", "Lcom/avito/android/remote/model/CategoryModel;", "component2", "()Lcom/avito/android/remote/model/CategoryModel;", "", "Lcom/avito/android/remote/model/WizardParameter;", "component3", "()Ljava/util/List;", "component4", "previousNavigation", "chosenCategory", "suggests", "currentNavigation", "copy", "(Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/CategoryModel;Ljava/util/List;Lcom/avito/android/remote/model/Navigation;)Lcom/avito/android/publish/PublishState$StepState$CategoriesSuggestions;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/CategoryModel;", "getChosenCategory", "setChosenCategory", "(Lcom/avito/android/remote/model/CategoryModel;)V", "Lcom/avito/android/remote/model/Navigation;", "getPreviousNavigation", "setPreviousNavigation", "(Lcom/avito/android/remote/model/Navigation;)V", "Ljava/util/List;", "getSuggests", "setSuggests", "(Ljava/util/List;)V", "getCurrentNavigation", "setCurrentNavigation", "<init>", "(Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/CategoryModel;Ljava/util/List;Lcom/avito/android/remote/model/Navigation;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class CategoriesSuggestions extends StepState implements CategorySelector {
            public static final Parcelable.Creator<CategoriesSuggestions> CREATOR = new Creator();
            @SerializedName("chosenCategory")
            @Nullable
            private CategoryModel chosenCategory;
            @SerializedName("currentNavigation")
            @Nullable
            private Navigation currentNavigation;
            @SerializedName("previousNavigation")
            @Nullable
            private Navigation previousNavigation;
            @SerializedName("suggests")
            @NotNull
            private List<WizardParameter> suggests;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<CategoriesSuggestions> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final CategoriesSuggestions createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    Navigation navigation = (Navigation) parcel.readParcelable(CategoriesSuggestions.class.getClassLoader());
                    CategoryModel categoryModel = (CategoryModel) parcel.readParcelable(CategoriesSuggestions.class.getClassLoader());
                    int readInt = parcel.readInt();
                    ArrayList arrayList = new ArrayList(readInt);
                    while (readInt != 0) {
                        arrayList.add((WizardParameter) parcel.readParcelable(CategoriesSuggestions.class.getClassLoader()));
                        readInt--;
                    }
                    return new CategoriesSuggestions(navigation, categoryModel, arrayList, (Navigation) parcel.readParcelable(CategoriesSuggestions.class.getClassLoader()));
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final CategoriesSuggestions[] newArray(int i) {
                    return new CategoriesSuggestions[i];
                }
            }

            public CategoriesSuggestions() {
                this(null, null, null, null, 15, null);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ CategoriesSuggestions(Navigation navigation, CategoryModel categoryModel, List list, Navigation navigation2, int i, j jVar) {
                this((i & 1) != 0 ? null : navigation, (i & 2) != 0 ? null : categoryModel, (i & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i & 8) != 0 ? null : navigation2);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.publish.PublishState$StepState$CategoriesSuggestions */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ CategoriesSuggestions copy$default(CategoriesSuggestions categoriesSuggestions, Navigation navigation, CategoryModel categoryModel, List list, Navigation navigation2, int i, Object obj) {
                if ((i & 1) != 0) {
                    navigation = categoriesSuggestions.getPreviousNavigation();
                }
                if ((i & 2) != 0) {
                    categoryModel = categoriesSuggestions.chosenCategory;
                }
                if ((i & 4) != 0) {
                    list = categoriesSuggestions.suggests;
                }
                if ((i & 8) != 0) {
                    navigation2 = categoriesSuggestions.getCurrentNavigation();
                }
                return categoriesSuggestions.copy(navigation, categoryModel, list, navigation2);
            }

            @Nullable
            public final Navigation component1() {
                return getPreviousNavigation();
            }

            @Nullable
            public final CategoryModel component2() {
                return this.chosenCategory;
            }

            @NotNull
            public final List<WizardParameter> component3() {
                return this.suggests;
            }

            @Nullable
            public final Navigation component4() {
                return getCurrentNavigation();
            }

            @NotNull
            public final CategoriesSuggestions copy(@Nullable Navigation navigation, @Nullable CategoryModel categoryModel, @NotNull List<WizardParameter> list, @Nullable Navigation navigation2) {
                Intrinsics.checkNotNullParameter(list, "suggests");
                return new CategoriesSuggestions(navigation, categoryModel, list, navigation2);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // java.lang.Object
            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof CategoriesSuggestions)) {
                    return false;
                }
                CategoriesSuggestions categoriesSuggestions = (CategoriesSuggestions) obj;
                return Intrinsics.areEqual(getPreviousNavigation(), categoriesSuggestions.getPreviousNavigation()) && Intrinsics.areEqual(this.chosenCategory, categoriesSuggestions.chosenCategory) && Intrinsics.areEqual(this.suggests, categoriesSuggestions.suggests) && Intrinsics.areEqual(getCurrentNavigation(), categoriesSuggestions.getCurrentNavigation());
            }

            @Nullable
            public final CategoryModel getChosenCategory() {
                return this.chosenCategory;
            }

            @Override // com.avito.android.publish.PublishState.StepState.CategorySelector
            @Nullable
            public Navigation getCurrentNavigation() {
                return this.currentNavigation;
            }

            @Override // com.avito.android.publish.PublishState.StepState.CategorySelector
            @Nullable
            public Navigation getPreviousNavigation() {
                return this.previousNavigation;
            }

            @NotNull
            public final List<WizardParameter> getSuggests() {
                return this.suggests;
            }

            @Override // java.lang.Object
            public int hashCode() {
                Navigation previousNavigation2 = getPreviousNavigation();
                int i = 0;
                int hashCode = (previousNavigation2 != null ? previousNavigation2.hashCode() : 0) * 31;
                CategoryModel categoryModel = this.chosenCategory;
                int hashCode2 = (hashCode + (categoryModel != null ? categoryModel.hashCode() : 0)) * 31;
                List<WizardParameter> list = this.suggests;
                int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
                Navigation currentNavigation2 = getCurrentNavigation();
                if (currentNavigation2 != null) {
                    i = currentNavigation2.hashCode();
                }
                return hashCode3 + i;
            }

            public final void setChosenCategory(@Nullable CategoryModel categoryModel) {
                this.chosenCategory = categoryModel;
            }

            @Override // com.avito.android.publish.PublishState.StepState.CategorySelector
            public void setCurrentNavigation(@Nullable Navigation navigation) {
                this.currentNavigation = navigation;
            }

            @Override // com.avito.android.publish.PublishState.StepState.CategorySelector
            public void setPreviousNavigation(@Nullable Navigation navigation) {
                this.previousNavigation = navigation;
            }

            public final void setSuggests(@NotNull List<WizardParameter> list) {
                Intrinsics.checkNotNullParameter(list, "<set-?>");
                this.suggests = list;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("CategoriesSuggestions(previousNavigation=");
                L.append(getPreviousNavigation());
                L.append(", chosenCategory=");
                L.append(this.chosenCategory);
                L.append(", suggests=");
                L.append(this.suggests);
                L.append(", currentNavigation=");
                L.append(getCurrentNavigation());
                L.append(")");
                return L.toString();
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeParcelable(this.previousNavigation, i);
                parcel.writeParcelable(this.chosenCategory, i);
                Iterator n0 = a2.b.a.a.a.n0(this.suggests, parcel);
                while (n0.hasNext()) {
                    parcel.writeParcelable((WizardParameter) n0.next(), i);
                }
                parcel.writeParcelable(this.currentNavigation, i);
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public CategoriesSuggestions(@Nullable Navigation navigation, @Nullable CategoryModel categoryModel, @NotNull List<WizardParameter> list, @Nullable Navigation navigation2) {
                super(PublishSession.StepType.SUGGEST_CATEGORY.toString(), null);
                Intrinsics.checkNotNullParameter(list, "suggests");
                this.previousNavigation = navigation;
                this.chosenCategory = categoryModel;
                this.suggests = list;
                this.currentNavigation = navigation2;
            }
        }

        public /* synthetic */ StepState(String str, j jVar) {
            this(str);
        }
    }

    public static final class a extends Lambda implements Function1<Map.Entry<? extends Integer, ? extends StepState>, Boolean> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(Map.Entry<? extends Integer, ? extends StepState> entry) {
            Map.Entry<? extends Integer, ? extends StepState> entry2 = entry;
            Intrinsics.checkNotNullParameter(entry2, "<name for destructuring parameter 0>");
            return Boolean.valueOf(((StepState) entry2.getValue()) instanceof StepState.CategorySelector);
        }
    }

    public static final class b extends Lambda implements Function1<Map.Entry<? extends Integer, ? extends StepState>, Pair<? extends Integer, ? extends StepState>> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Pair<? extends Integer, ? extends StepState> invoke(Map.Entry<? extends Integer, ? extends StepState> entry) {
            Map.Entry<? extends Integer, ? extends StepState> entry2 = entry;
            Intrinsics.checkNotNullParameter(entry2, "<name for destructuring parameter 0>");
            return TuplesKt.to(Integer.valueOf(((Number) entry2.getKey()).intValue()), (StepState) entry2.getValue());
        }
    }

    public PublishState() {
        this(null, null, 0, null, null, null, 63, null);
    }

    public PublishState(@NotNull Navigation navigation2, @NotNull Navigation navigation3, int i, @NotNull Map<Integer, StepState> map, @Nullable String str, @NotNull Set<String> set) {
        Intrinsics.checkNotNullParameter(navigation2, "rootNavigation");
        Intrinsics.checkNotNullParameter(navigation3, "navigation");
        Intrinsics.checkNotNullParameter(map, "stepStates");
        Intrinsics.checkNotNullParameter(set, LocalPublishState.CHANGED_IDS);
        this.rootNavigation = navigation2;
        this.navigation = navigation3;
        this.stepIndex = i;
        this.stepStates = map;
        this.activeFieldId = str;
        this.changedFieldIds = set;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.avito.android.publish.PublishState */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PublishState copy$default(PublishState publishState, Navigation navigation2, Navigation navigation3, int i, Map map, String str, Set set, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            navigation2 = publishState.rootNavigation;
        }
        if ((i2 & 2) != 0) {
            navigation3 = publishState.navigation;
        }
        if ((i2 & 4) != 0) {
            i = publishState.stepIndex;
        }
        if ((i2 & 8) != 0) {
            map = publishState.stepStates;
        }
        if ((i2 & 16) != 0) {
            str = publishState.activeFieldId;
        }
        if ((i2 & 32) != 0) {
            set = publishState.changedFieldIds;
        }
        return publishState.copy(navigation2, navigation3, i, map, str, set);
    }

    public final StepState.CategoriesSuggestions a() {
        StepState stepState;
        Parcelable parcelable = (StepState) getStepStates().get(-1);
        if (!(parcelable instanceof StepState.CategoriesSuggestions)) {
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(StepState.CategoriesSuggestions.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(StepState.Wizard.class))) {
                stepState = new StepState.Wizard(null, null, null, 7, null);
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(StepState.CategoriesSuggestions.class))) {
                stepState = new StepState.CategoriesSuggestions(null, null, null, null, 15, null);
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(StepState.Vin.class))) {
                stepState = new StepState.Vin(null, 1, null);
            } else {
                StringBuilder L = a2.b.a.a.a.L("Unknown StepState type '");
                L.append(Reflection.getOrCreateKotlinClass(StepState.CategoriesSuggestions.class));
                L.append('\'');
                throw new IllegalArgumentException(L.toString());
            }
            getStepStates().put(-1, stepState);
            parcelable = (StepState.CategoriesSuggestions) stepState;
        }
        return (StepState.CategoriesSuggestions) parcelable;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0112  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.avito.android.publish.PublishState.StepState.CategorySelector r16, int r17, com.avito.android.remote.model.CategoryModel r18) {
        /*
        // Method dump skipped, instructions count: 290
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.publish.PublishState.b(com.avito.android.publish.PublishState$StepState$CategorySelector, int, com.avito.android.remote.model.CategoryModel):void");
    }

    @NotNull
    public final Navigation component1() {
        return this.rootNavigation;
    }

    @NotNull
    public final Navigation component2() {
        return this.navigation;
    }

    public final int component3() {
        return this.stepIndex;
    }

    @NotNull
    public final Map<Integer, StepState> component4() {
        return this.stepStates;
    }

    @Nullable
    public final String component5() {
        return this.activeFieldId;
    }

    @NotNull
    public final Set<String> component6() {
        return this.changedFieldIds;
    }

    @NotNull
    public final PublishState copy(@NotNull Navigation navigation2, @NotNull Navigation navigation3, int i, @NotNull Map<Integer, StepState> map, @Nullable String str, @NotNull Set<String> set) {
        Intrinsics.checkNotNullParameter(navigation2, "rootNavigation");
        Intrinsics.checkNotNullParameter(navigation3, "navigation");
        Intrinsics.checkNotNullParameter(map, "stepStates");
        Intrinsics.checkNotNullParameter(set, LocalPublishState.CHANGED_IDS);
        return new PublishState(navigation2, navigation3, i, map, str, set);
    }

    @NotNull
    public final PublishState deepCopy() {
        return copy$default(this, null, null, 0, r.toMutableMap(this.stepStates), null, null, 55, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PublishState)) {
            return false;
        }
        PublishState publishState = (PublishState) obj;
        return Intrinsics.areEqual(this.rootNavigation, publishState.rootNavigation) && Intrinsics.areEqual(this.navigation, publishState.navigation) && this.stepIndex == publishState.stepIndex && Intrinsics.areEqual(this.stepStates, publishState.stepStates) && Intrinsics.areEqual(this.activeFieldId, publishState.activeFieldId) && Intrinsics.areEqual(this.changedFieldIds, publishState.changedFieldIds);
    }

    @Nullable
    public final String getActiveFieldId() {
        return this.activeFieldId;
    }

    @NotNull
    public final Set<String> getChangedFieldIds() {
        return this.changedFieldIds;
    }

    @Nullable
    public final Navigation getCurrentNavigationForStep(int i) {
        StepState stepState = this.stepStates.get(Integer.valueOf(i));
        if (!(stepState instanceof StepState.CategorySelector)) {
            stepState = null;
        }
        StepState.CategorySelector categorySelector = (StepState.CategorySelector) stepState;
        if (categorySelector != null) {
            return categorySelector.getCurrentNavigation();
        }
        return null;
    }

    @NotNull
    public final Navigation getNavigation() {
        return this.navigation;
    }

    @NotNull
    public final Navigation getPublishProcessNavigation() {
        Navigation navigation2;
        CategoryModel chosenCategory;
        StepState stepState = this.stepStates.get((Integer) CollectionsKt___CollectionsKt.max((Iterable<? extends Comparable>) this.stepStates.keySet()));
        Navigation navigation3 = null;
        if (!(stepState instanceof StepState.CategorySelector)) {
            stepState = null;
        }
        StepState.CategorySelector categorySelector = (StepState.CategorySelector) stepState;
        StepState.CategoriesSuggestions categoriesSuggestions = (StepState.CategoriesSuggestions) (!(categorySelector instanceof StepState.CategoriesSuggestions) ? null : categorySelector);
        StepState.Wizard wizard = (StepState.Wizard) (!(categorySelector instanceof StepState.Wizard) ? null : categorySelector);
        if (categoriesSuggestions == null || (chosenCategory = categoriesSuggestions.getChosenCategory()) == null || (navigation2 = chosenCategory.getNavigation()) == null) {
            navigation2 = wizard != null ? wizard.getSelectedNavigation() : null;
        }
        if (navigation2 != null) {
            navigation3 = navigation2;
        } else if (categorySelector != null) {
            navigation3 = categorySelector.getCurrentNavigation();
        }
        return navigation3 != null ? navigation3 : this.navigation;
    }

    @NotNull
    public final Navigation getRootNavigation() {
        return this.rootNavigation;
    }

    public final int getStepIndex() {
        return this.stepIndex;
    }

    public final /* synthetic */ <T extends StepState> T getStepState(int i) {
        StepState.Vin vin = (T) getStepStates().get(Integer.valueOf(i));
        Intrinsics.reifiedOperationMarker(3, "T");
        if (!(vin instanceof StepState)) {
            Intrinsics.reifiedOperationMarker(4, "T");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(StepState.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(StepState.Wizard.class))) {
                vin = new StepState.Wizard(null, null, null, 7, null);
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(StepState.CategoriesSuggestions.class))) {
                vin = new StepState.CategoriesSuggestions(null, null, null, null, 15, null);
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(StepState.Vin.class))) {
                vin = new StepState.Vin(null, 1, null);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown StepState type '");
                Intrinsics.reifiedOperationMarker(4, "T");
                sb.append(Reflection.getOrCreateKotlinClass(StepState.class));
                sb.append('\'');
                throw new IllegalArgumentException(sb.toString());
            }
            getStepStates().put(Integer.valueOf(i), vin);
            Intrinsics.reifiedOperationMarker(1, "T");
        }
        return vin;
    }

    @NotNull
    public final Map<Integer, StepState> getStepStates() {
        return this.stepStates;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Navigation navigation2 = this.rootNavigation;
        int i = 0;
        int hashCode = (navigation2 != null ? navigation2.hashCode() : 0) * 31;
        Navigation navigation3 = this.navigation;
        int hashCode2 = (((hashCode + (navigation3 != null ? navigation3.hashCode() : 0)) * 31) + this.stepIndex) * 31;
        Map<Integer, StepState> map = this.stepStates;
        int hashCode3 = (hashCode2 + (map != null ? map.hashCode() : 0)) * 31;
        String str = this.activeFieldId;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        Set<String> set = this.changedFieldIds;
        if (set != null) {
            i = set.hashCode();
        }
        return hashCode4 + i;
    }

    public final /* synthetic */ <T extends StepState> T resetStepState(int i) {
        T t;
        Intrinsics.reifiedOperationMarker(4, "T");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(StepState.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(StepState.Wizard.class))) {
            t = new StepState.Wizard(null, null, null, 7, null);
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(StepState.CategoriesSuggestions.class))) {
            t = new StepState.CategoriesSuggestions(null, null, null, null, 15, null);
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(StepState.Vin.class))) {
            t = new StepState.Vin(null, 1, null);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown StepState type '");
            Intrinsics.reifiedOperationMarker(4, "T");
            sb.append(Reflection.getOrCreateKotlinClass(StepState.class));
            sb.append('\'');
            throw new IllegalArgumentException(sb.toString());
        }
        getStepStates().put(Integer.valueOf(i), t);
        Intrinsics.reifiedOperationMarker(1, "T");
        return t;
    }

    public final void resetStepStatesWithNewCategory(@NotNull CategoryModel categoryModel) {
        Intrinsics.checkNotNullParameter(categoryModel, "newCategory");
        Navigation navigation2 = new Navigation(null, null, null, null, null, null, null, 127, null);
        this.rootNavigation = navigation2;
        this.navigation = navigation2;
        this.stepIndex = -1;
        this.stepStates.clear();
        StepState.CategoriesSuggestions a3 = a();
        b(a3, -1, categoryModel);
        this.stepStates.put(-1, a3);
    }

    public final void restoreChangedCategoryStateStep() {
        CategoryModel chosenCategory = a().getChosenCategory();
        if (chosenCategory != null) {
            this.stepStates.remove(-1);
            Pair pair = (Pair) SequencesKt___SequencesKt.lastOrNull(SequencesKt___SequencesKt.sortedWith(SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.filter(s.asSequence(this.stepStates), a.a), b.a), new Comparator<T>() { // from class: com.avito.android.publish.PublishState$restoreChangedCategoryStateStep$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return a.compareValues((Integer) t.getFirst(), (Integer) t2.getFirst());
                }
            }));
            if (pair != null) {
                int intValue = ((Number) pair.component1()).intValue();
                StepState stepState = (StepState) pair.component2();
                Objects.requireNonNull(stepState, "null cannot be cast to non-null type com.avito.android.publish.PublishState.StepState.CategorySelector");
                StepState.CategorySelector categorySelector = (StepState.CategorySelector) stepState;
                categorySelector.setPreviousNavigation(chosenCategory.getRootNavigation());
                b(categorySelector, intValue, chosenCategory);
                this.stepStates.put(Integer.valueOf(intValue), stepState);
            }
        }
    }

    public final void setActiveFieldId(@Nullable String str) {
        this.activeFieldId = str;
    }

    public final void setCurrentNavigationForStep(int i, @Nullable Navigation navigation2) {
        StepState stepState = this.stepStates.get(Integer.valueOf(i));
        if (!(stepState instanceof StepState.CategorySelector)) {
            stepState = null;
        }
        StepState.CategorySelector categorySelector = (StepState.CategorySelector) stepState;
        if (categorySelector != null) {
            categorySelector.setCurrentNavigation(navigation2);
        }
    }

    public final void setNavigation(@NotNull Navigation navigation2) {
        Intrinsics.checkNotNullParameter(navigation2, "<set-?>");
        this.navigation = navigation2;
    }

    public final void setRootNavigation(@NotNull Navigation navigation2) {
        Intrinsics.checkNotNullParameter(navigation2, "<set-?>");
        this.rootNavigation = navigation2;
    }

    public final void setSelectedCategoryForStep(int i, @NotNull CategoryModel categoryModel) {
        Intrinsics.checkNotNullParameter(categoryModel, "newCategory");
        StepState stepState = this.stepStates.get(Integer.valueOf(i));
        if (!(stepState instanceof StepState.CategorySelector)) {
            stepState = null;
        }
        StepState.CategorySelector categorySelector = (StepState.CategorySelector) stepState;
        if (categorySelector != null) {
            b(categorySelector, i, categoryModel);
        }
    }

    public final void setStepIndex(int i) {
        this.stepIndex = i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("PublishState(rootNavigation=");
        L.append(this.rootNavigation);
        L.append(", navigation=");
        L.append(this.navigation);
        L.append(", stepIndex=");
        L.append(this.stepIndex);
        L.append(", stepStates=");
        L.append(this.stepStates);
        L.append(", activeFieldId=");
        L.append(this.activeFieldId);
        L.append(", changedFieldIds=");
        L.append(this.changedFieldIds);
        L.append(")");
        return L.toString();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Map$Entry, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // android.os.Parcelable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r4, int r5) {
        /*
            r3 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            com.avito.android.remote.model.Navigation r0 = r3.rootNavigation
            r4.writeParcelable(r0, r5)
            com.avito.android.remote.model.Navigation r0 = r3.navigation
            r4.writeParcelable(r0, r5)
            int r0 = r3.stepIndex
            r4.writeInt(r0)
            java.util.Map<java.lang.Integer, com.avito.android.publish.PublishState$StepState> r0 = r3.stepStates
            java.util.Iterator r0 = a2.b.a.a.a.o0(r0, r4)
        L_0x001a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x003b
            java.lang.Object r1 = r0.next()
            java.lang.Object r2 = r1.getKey()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r4.writeInt(r2)
            java.lang.Object r1 = r1.getValue()
            com.avito.android.publish.PublishState$StepState r1 = (com.avito.android.publish.PublishState.StepState) r1
            r4.writeParcelable(r1, r5)
            goto L_0x001a
        L_0x003b:
            java.lang.String r5 = r3.activeFieldId
            r4.writeString(r5)
            java.util.Set<java.lang.String> r5 = r3.changedFieldIds
            int r0 = r5.size()
            r4.writeInt(r0)
            java.util.Iterator r5 = r5.iterator()
        L_0x004d:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x005d
            java.lang.Object r0 = r5.next()
            java.lang.String r0 = (java.lang.String) r0
            r4.writeString(r0)
            goto L_0x004d
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.publish.PublishState.writeToParcel(android.os.Parcel, int):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PublishState(com.avito.android.remote.model.Navigation r12, com.avito.android.remote.model.Navigation r13, int r14, java.util.Map r15, java.lang.String r16, java.util.Set r17, int r18, t6.r.a.j r19) {
        /*
            r11 = this;
            r0 = r18 & 1
            if (r0 == 0) goto L_0x0015
            com.avito.android.remote.model.Navigation r0 = new com.avito.android.remote.model.Navigation
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 127(0x7f, float:1.78E-43)
            r10 = 0
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            goto L_0x0016
        L_0x0015:
            r0 = r12
        L_0x0016:
            r1 = r18 & 2
            if (r1 == 0) goto L_0x001c
            r1 = r0
            goto L_0x001d
        L_0x001c:
            r1 = r13
        L_0x001d:
            r2 = r18 & 4
            if (r2 == 0) goto L_0x0023
            r2 = -1
            goto L_0x0024
        L_0x0023:
            r2 = r14
        L_0x0024:
            r3 = r18 & 8
            if (r3 == 0) goto L_0x002e
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
            r3.<init>()
            goto L_0x002f
        L_0x002e:
            r3 = r15
        L_0x002f:
            r4 = r18 & 16
            if (r4 == 0) goto L_0x0035
            r4 = 0
            goto L_0x0037
        L_0x0035:
            r4 = r16
        L_0x0037:
            r5 = r18 & 32
            if (r5 == 0) goto L_0x0041
            java.util.LinkedHashSet r5 = new java.util.LinkedHashSet
            r5.<init>()
            goto L_0x0043
        L_0x0041:
            r5 = r17
        L_0x0043:
            r12 = r11
            r13 = r0
            r14 = r1
            r15 = r2
            r16 = r3
            r17 = r4
            r18 = r5
            r12.<init>(r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.publish.PublishState.<init>(com.avito.android.remote.model.Navigation, com.avito.android.remote.model.Navigation, int, java.util.Map, java.lang.String, java.util.Set, int, t6.r.a.j):void");
    }
}
