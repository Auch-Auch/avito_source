package com.avito.android.remote.model.messenger.context_actions;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.messenger.PlatformSupport;
import com.avito.android.remote.model.messenger.context_actions.ContextActionHandler;
import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.api.entity.context.ChannelContextActions;
import t6.r.a.j;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \n2\u00020\u00012\u00020\u0002:\u0005\u000b\n\f\r\u000eB\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u00038Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005\u0001\u0003\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;", "Lru/avito/messenger/api/entity/context/ChannelContextActions;", "Landroid/os/Parcelable;", "", "isExpandable", "()Z", "getHideKeyboard", PlatformActions.HIDE_KEYBOARD, "<init>", "()V", "Companion", "Actions", "ExpandableData", "ItemsList", "None", "Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$Actions;", "Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$ItemsList;", "Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$None;", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class PlatformActions implements ChannelContextActions, Parcelable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String EXPANDABLE = "expandable";
    @NotNull
    public static final String HIDE_KEYBOARD = "hideKeyboard";
    @NotNull
    public static final String MESSAGE_ID = "messageId";
    @NotNull
    public static final String PLATFORM_SUPPORT = "platformSupport";
    @NotNull
    public static final String TITLE = "title";
    @NotNull
    public static final String TYPE_KEY = "type";
    @NotNull
    public static final String VALUE = "value";
    @NotNull
    public static final String VERSION = "version";

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0016\b\b\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001ABO\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u001d\u001a\u00020\u0014¢\u0006\u0004\b?\u0010@J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\n\u0010\u0005J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016Jf\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u0014HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b \u0010\u0005J\u0010\u0010\"\u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010&\u001a\u00020\u00142\b\u0010%\u001a\u0004\u0018\u00010$HÖ\u0003¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020!HÖ\u0001¢\u0006\u0004\b(\u0010#J \u0010-\u001a\u00020,2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020!HÖ\u0001¢\u0006\u0004\b-\u0010.R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010/\u001a\u0004\b0\u0010\u0013R\u001a\u00101\u001a\u00020\u00148Æ\u0002@\u0006¢\u0006\f\u0012\u0004\b2\u00103\u001a\u0004\b1\u0010\u0016R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u00104\u001a\u0004\b5\u0010\u0005R\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u00106\u001a\u0004\b7\u0010\tR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u00108\u001a\u0004\b9\u0010\rR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010:\u001a\u0004\b;\u0010\u0010R\u001c\u0010\u001d\u001a\u00020\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010<\u001a\u0004\b=\u0010\u0016R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u00104\u001a\u0004\b>\u0010\u0005¨\u0006B"}, d2 = {"Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$Actions;", "Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;", "Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$ExpandableData$Provider;", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/messenger/context_actions/ContextAction;", "component2", "()Ljava/util/List;", "component3", "Lcom/avito/android/remote/model/messenger/PlatformSupport;", "component4", "()Lcom/avito/android/remote/model/messenger/PlatformSupport;", "", "component5", "()Ljava/lang/Long;", "Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$ExpandableData;", "component6", "()Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$ExpandableData;", "", "component7", "()Z", "title", "actions", "messageId", PlatformActions.PLATFORM_SUPPORT, "version", "expandableData", PlatformActions.HIDE_KEYBOARD, "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/avito/android/remote/model/messenger/PlatformSupport;Ljava/lang/Long;Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$ExpandableData;Z)Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$Actions;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$ExpandableData;", "getExpandableData", "isEmpty", "isEmpty$annotations", "()V", "Ljava/lang/String;", "getTitle", "Ljava/util/List;", "getActions", "Lcom/avito/android/remote/model/messenger/PlatformSupport;", "getPlatformSupport", "Ljava/lang/Long;", "getVersion", "Z", "getHideKeyboard", "getMessageId", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/avito/android/remote/model/messenger/PlatformSupport;Ljava/lang/Long;Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$ExpandableData;Z)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Actions extends PlatformActions implements ExpandableData.Provider {
        @NotNull
        public static final String ACTIONS = "actions";
        public static final Parcelable.Creator<Actions> CREATOR = new Creator();
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final List<ContextAction> actions;
        @Nullable
        private final ExpandableData expandableData;
        private final boolean hideKeyboard;
        @Nullable
        private final String messageId;
        @Nullable
        private final PlatformSupport platformSupport;
        @Nullable
        private final String title;
        @Nullable
        private final Long version;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$Actions$Companion;", "", "", "ACTIONS", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Actions> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Actions createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(ContextAction.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
                return new Actions(readString, arrayList, parcel.readString(), parcel.readInt() != 0 ? PlatformSupport.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() != 0 ? ExpandableData.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Actions[] newArray(int i) {
                return new Actions[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Actions(@Nullable String str, @NotNull List<ContextAction> list, @Nullable String str2, @Nullable PlatformSupport platformSupport2, @Nullable Long l, @Nullable ExpandableData expandableData2, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "actions");
            this.title = str;
            this.actions = list;
            this.messageId = str2;
            this.platformSupport = platformSupport2;
            this.version = l;
            this.expandableData = expandableData2;
            this.hideKeyboard = z;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.avito.android.remote.model.messenger.context_actions.PlatformActions$Actions */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Actions copy$default(Actions actions2, String str, List list, String str2, PlatformSupport platformSupport2, Long l, ExpandableData expandableData2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = actions2.title;
            }
            if ((i & 2) != 0) {
                list = actions2.actions;
            }
            if ((i & 4) != 0) {
                str2 = actions2.getMessageId();
            }
            if ((i & 8) != 0) {
                platformSupport2 = actions2.getPlatformSupport();
            }
            if ((i & 16) != 0) {
                l = actions2.getVersion();
            }
            if ((i & 32) != 0) {
                expandableData2 = actions2.getExpandableData();
            }
            if ((i & 64) != 0) {
                z = actions2.getHideKeyboard();
            }
            return actions2.copy(str, list, str2, platformSupport2, l, expandableData2, z);
        }

        public static /* synthetic */ void isEmpty$annotations() {
        }

        @Nullable
        public final String component1() {
            return this.title;
        }

        @NotNull
        public final List<ContextAction> component2() {
            return this.actions;
        }

        @Nullable
        public final String component3() {
            return getMessageId();
        }

        @Nullable
        public final PlatformSupport component4() {
            return getPlatformSupport();
        }

        @Nullable
        public final Long component5() {
            return getVersion();
        }

        @Nullable
        public final ExpandableData component6() {
            return getExpandableData();
        }

        public final boolean component7() {
            return getHideKeyboard();
        }

        @NotNull
        public final Actions copy(@Nullable String str, @NotNull List<ContextAction> list, @Nullable String str2, @Nullable PlatformSupport platformSupport2, @Nullable Long l, @Nullable ExpandableData expandableData2, boolean z) {
            Intrinsics.checkNotNullParameter(list, "actions");
            return new Actions(str, list, str2, platformSupport2, l, expandableData2, z);
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
            if (!(obj instanceof Actions)) {
                return false;
            }
            Actions actions2 = (Actions) obj;
            return Intrinsics.areEqual(this.title, actions2.title) && Intrinsics.areEqual(this.actions, actions2.actions) && Intrinsics.areEqual(getMessageId(), actions2.getMessageId()) && Intrinsics.areEqual(getPlatformSupport(), actions2.getPlatformSupport()) && Intrinsics.areEqual(getVersion(), actions2.getVersion()) && Intrinsics.areEqual(getExpandableData(), actions2.getExpandableData()) && getHideKeyboard() == actions2.getHideKeyboard();
        }

        @NotNull
        public final List<ContextAction> getActions() {
            return this.actions;
        }

        @Override // com.avito.android.remote.model.messenger.context_actions.PlatformActions.ExpandableData.Provider
        @Nullable
        public ExpandableData getExpandableData() {
            return this.expandableData;
        }

        @Override // com.avito.android.remote.model.messenger.context_actions.PlatformActions
        public boolean getHideKeyboard() {
            return this.hideKeyboard;
        }

        @Override // ru.avito.messenger.api.entity.context.ChannelContextActions
        @Nullable
        public String getMessageId() {
            return this.messageId;
        }

        @Override // ru.avito.messenger.api.entity.context.ChannelContextActions
        @Nullable
        public PlatformSupport getPlatformSupport() {
            return this.platformSupport;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Override // ru.avito.messenger.api.entity.context.ChannelContextActions
        @Nullable
        public Long getVersion() {
            return this.version;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.title;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            List<ContextAction> list = this.actions;
            int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
            String messageId2 = getMessageId();
            int hashCode3 = (hashCode2 + (messageId2 != null ? messageId2.hashCode() : 0)) * 31;
            PlatformSupport platformSupport2 = getPlatformSupport();
            int hashCode4 = (hashCode3 + (platformSupport2 != null ? platformSupport2.hashCode() : 0)) * 31;
            Long version2 = getVersion();
            int hashCode5 = (hashCode4 + (version2 != null ? version2.hashCode() : 0)) * 31;
            ExpandableData expandableData2 = getExpandableData();
            if (expandableData2 != null) {
                i = expandableData2.hashCode();
            }
            int i2 = (hashCode5 + i) * 31;
            boolean hideKeyboard2 = getHideKeyboard();
            if (hideKeyboard2) {
                hideKeyboard2 = true;
            }
            int i3 = hideKeyboard2 ? 1 : 0;
            int i4 = hideKeyboard2 ? 1 : 0;
            int i5 = hideKeyboard2 ? 1 : 0;
            return i2 + i3;
        }

        public final boolean isEmpty() {
            String title2 = getTitle();
            return (title2 == null || m.isBlank(title2)) && getActions().isEmpty();
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Actions(title=");
            L.append(this.title);
            L.append(", actions=");
            L.append(this.actions);
            L.append(", messageId=");
            L.append(getMessageId());
            L.append(", platformSupport=");
            L.append(getPlatformSupport());
            L.append(", version=");
            L.append(getVersion());
            L.append(", expandableData=");
            L.append(getExpandableData());
            L.append(", hideKeyboard=");
            L.append(getHideKeyboard());
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            Iterator n0 = a.n0(this.actions, parcel);
            while (n0.hasNext()) {
                ((ContextAction) n0.next()).writeToParcel(parcel, 0);
            }
            parcel.writeString(this.messageId);
            PlatformSupport platformSupport2 = this.platformSupport;
            if (platformSupport2 != null) {
                parcel.writeInt(1);
                platformSupport2.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            Long l = this.version;
            if (l != null) {
                a.I0(parcel, 1, l);
            } else {
                parcel.writeInt(0);
            }
            ExpandableData expandableData2 = this.expandableData;
            if (expandableData2 != null) {
                parcel.writeInt(1);
                expandableData2.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeInt(this.hideKeyboard ? 1 : 0);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$Companion;", "", "", "EXPANDABLE", "Ljava/lang/String;", "HIDE_KEYBOARD", "MESSAGE_ID", "PLATFORM_SUPPORT", ShareConstants.TITLE, "TYPE_KEY", "VALUE", "VERSION", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u001f\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b \u0010!J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004¨\u0006$"}, d2 = {"Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$ExpandableData;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$MethodCall;", "component2", "()Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$MethodCall;", ExpandableData.TITLE_SHORT, "cancelHandler", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$MethodCall;)Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$ExpandableData;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$MethodCall;", "getCancelHandler", "Ljava/lang/String;", "getTitleShort", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/messenger/context_actions/ContextActionHandler$MethodCall;)V", "Companion", "Provider", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class ExpandableData implements Parcelable {
        @NotNull
        public static final String CANCEL_ACTION = "cancelAction";
        public static final Parcelable.Creator<ExpandableData> CREATOR = new Creator();
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String TITLE_SHORT = "titleShort";
        @Nullable
        private final ContextActionHandler.MethodCall cancelHandler;
        @Nullable
        private final String titleShort;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$ExpandableData$Companion;", "", "", "CANCEL_ACTION", "Ljava/lang/String;", "TITLE_SHORT", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<ExpandableData> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ExpandableData createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new ExpandableData(parcel.readString(), parcel.readInt() != 0 ? ContextActionHandler.MethodCall.CREATOR.createFromParcel(parcel) : null);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ExpandableData[] newArray(int i) {
                return new ExpandableData[i];
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$ExpandableData$Provider;", "", "Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$ExpandableData;", "getExpandableData", "()Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$ExpandableData;", "expandableData", "models_release"}, k = 1, mv = {1, 4, 2})
        public interface Provider {
            @Nullable
            ExpandableData getExpandableData();
        }

        public ExpandableData() {
            this(null, null, 3, null);
        }

        public ExpandableData(@Nullable String str, @Nullable ContextActionHandler.MethodCall methodCall) {
            this.titleShort = str;
            this.cancelHandler = methodCall;
        }

        public static /* synthetic */ ExpandableData copy$default(ExpandableData expandableData, String str, ContextActionHandler.MethodCall methodCall, int i, Object obj) {
            if ((i & 1) != 0) {
                str = expandableData.titleShort;
            }
            if ((i & 2) != 0) {
                methodCall = expandableData.cancelHandler;
            }
            return expandableData.copy(str, methodCall);
        }

        @Nullable
        public final String component1() {
            return this.titleShort;
        }

        @Nullable
        public final ContextActionHandler.MethodCall component2() {
            return this.cancelHandler;
        }

        @NotNull
        public final ExpandableData copy(@Nullable String str, @Nullable ContextActionHandler.MethodCall methodCall) {
            return new ExpandableData(str, methodCall);
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
            if (!(obj instanceof ExpandableData)) {
                return false;
            }
            ExpandableData expandableData = (ExpandableData) obj;
            return Intrinsics.areEqual(this.titleShort, expandableData.titleShort) && Intrinsics.areEqual(this.cancelHandler, expandableData.cancelHandler);
        }

        @Nullable
        public final ContextActionHandler.MethodCall getCancelHandler() {
            return this.cancelHandler;
        }

        @Nullable
        public final String getTitleShort() {
            return this.titleShort;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.titleShort;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            ContextActionHandler.MethodCall methodCall = this.cancelHandler;
            if (methodCall != null) {
                i = methodCall.hashCode();
            }
            return hashCode + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("ExpandableData(titleShort=");
            L.append(this.titleShort);
            L.append(", cancelHandler=");
            L.append(this.cancelHandler);
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.titleShort);
            ContextActionHandler.MethodCall methodCall = this.cancelHandler;
            if (methodCall != null) {
                parcel.writeInt(1);
                methodCall.writeToParcel(parcel, 0);
                return;
            }
            parcel.writeInt(0);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ExpandableData(String str, ContextActionHandler.MethodCall methodCall, int i, j jVar) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : methodCall);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0013\b\b\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=BE\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u001b\u001a\u00020\u0010\u0012\u0006\u0010\u001c\u001a\u00020\u0013¢\u0006\u0004\b;\u0010<J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\t\u0010\u0005J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\\\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u001b\u001a\u00020\u00102\b\b\u0002\u0010\u001c\u001a\u00020\u0013HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0005J\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020 HÖ\u0001¢\u0006\u0004\b'\u0010\"J \u0010,\u001a\u00020+2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020 HÖ\u0001¢\u0006\u0004\b,\u0010-R\u001c\u0010\u001b\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010.\u001a\u0004\b/\u0010\u0012R\u0019\u0010\u0017\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u00100\u001a\u0004\b1\u0010\bR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u00102\u001a\u0004\b3\u0010\u000fR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u00104\u001a\u0004\b5\u0010\u0005R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u00106\u001a\u0004\b7\u0010\fR\u001c\u0010\u001c\u001a\u00020\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u00108\u001a\u0004\b9\u0010\u0015R\u0019\u0010\u0016\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u00104\u001a\u0004\b:\u0010\u0005¨\u0006>"}, d2 = {"Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$ItemsList;", "Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;", "Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$ExpandableData$Provider;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/messenger/context_actions/ItemsRequest;", "component2", "()Lcom/avito/android/remote/model/messenger/context_actions/ItemsRequest;", "component3", "Lcom/avito/android/remote/model/messenger/PlatformSupport;", "component4", "()Lcom/avito/android/remote/model/messenger/PlatformSupport;", "", "component5", "()Ljava/lang/Long;", "Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$ExpandableData;", "component6", "()Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$ExpandableData;", "", "component7", "()Z", "title", ItemsList.ITEMS_REQUEST, "messageId", PlatformActions.PLATFORM_SUPPORT, "version", "expandableData", PlatformActions.HIDE_KEYBOARD, "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/messenger/context_actions/ItemsRequest;Ljava/lang/String;Lcom/avito/android/remote/model/messenger/PlatformSupport;Ljava/lang/Long;Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$ExpandableData;Z)Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$ItemsList;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$ExpandableData;", "getExpandableData", "Lcom/avito/android/remote/model/messenger/context_actions/ItemsRequest;", "getItemsRequest", "Ljava/lang/Long;", "getVersion", "Ljava/lang/String;", "getMessageId", "Lcom/avito/android/remote/model/messenger/PlatformSupport;", "getPlatformSupport", "Z", "getHideKeyboard", "getTitle", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/messenger/context_actions/ItemsRequest;Ljava/lang/String;Lcom/avito/android/remote/model/messenger/PlatformSupport;Ljava/lang/Long;Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$ExpandableData;Z)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class ItemsList extends PlatformActions implements ExpandableData.Provider {
        public static final Parcelable.Creator<ItemsList> CREATOR = new Creator();
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String ITEMS_REQUEST = "itemsRequest";
        @NotNull
        public static final String TYPE = "itemsList";
        @NotNull
        private final ExpandableData expandableData;
        private final boolean hideKeyboard;
        @NotNull
        private final ItemsRequest itemsRequest;
        @Nullable
        private final String messageId;
        @Nullable
        private final PlatformSupport platformSupport;
        @NotNull
        private final String title;
        @Nullable
        private final Long version;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$ItemsList$Companion;", "", "", "ITEMS_REQUEST", "Ljava/lang/String;", "TYPE", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<ItemsList> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ItemsList createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new ItemsList(parcel.readString(), ItemsRequest.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt() != 0 ? PlatformSupport.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, ExpandableData.CREATOR.createFromParcel(parcel), parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ItemsList[] newArray(int i) {
                return new ItemsList[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ItemsList(@NotNull String str, @NotNull ItemsRequest itemsRequest2, @Nullable String str2, @Nullable PlatformSupport platformSupport2, @Nullable Long l, @NotNull ExpandableData expandableData2, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(itemsRequest2, ITEMS_REQUEST);
            Intrinsics.checkNotNullParameter(expandableData2, "expandableData");
            this.title = str;
            this.itemsRequest = itemsRequest2;
            this.messageId = str2;
            this.platformSupport = platformSupport2;
            this.version = l;
            this.expandableData = expandableData2;
            this.hideKeyboard = z;
        }

        public static /* synthetic */ ItemsList copy$default(ItemsList itemsList, String str, ItemsRequest itemsRequest2, String str2, PlatformSupport platformSupport2, Long l, ExpandableData expandableData2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = itemsList.title;
            }
            if ((i & 2) != 0) {
                itemsRequest2 = itemsList.itemsRequest;
            }
            if ((i & 4) != 0) {
                str2 = itemsList.getMessageId();
            }
            if ((i & 8) != 0) {
                platformSupport2 = itemsList.getPlatformSupport();
            }
            if ((i & 16) != 0) {
                l = itemsList.getVersion();
            }
            if ((i & 32) != 0) {
                expandableData2 = itemsList.getExpandableData();
            }
            if ((i & 64) != 0) {
                z = itemsList.getHideKeyboard();
            }
            return itemsList.copy(str, itemsRequest2, str2, platformSupport2, l, expandableData2, z);
        }

        @NotNull
        public final String component1() {
            return this.title;
        }

        @NotNull
        public final ItemsRequest component2() {
            return this.itemsRequest;
        }

        @Nullable
        public final String component3() {
            return getMessageId();
        }

        @Nullable
        public final PlatformSupport component4() {
            return getPlatformSupport();
        }

        @Nullable
        public final Long component5() {
            return getVersion();
        }

        @NotNull
        public final ExpandableData component6() {
            return getExpandableData();
        }

        public final boolean component7() {
            return getHideKeyboard();
        }

        @NotNull
        public final ItemsList copy(@NotNull String str, @NotNull ItemsRequest itemsRequest2, @Nullable String str2, @Nullable PlatformSupport platformSupport2, @Nullable Long l, @NotNull ExpandableData expandableData2, boolean z) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(itemsRequest2, ITEMS_REQUEST);
            Intrinsics.checkNotNullParameter(expandableData2, "expandableData");
            return new ItemsList(str, itemsRequest2, str2, platformSupport2, l, expandableData2, z);
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
            if (!(obj instanceof ItemsList)) {
                return false;
            }
            ItemsList itemsList = (ItemsList) obj;
            return Intrinsics.areEqual(this.title, itemsList.title) && Intrinsics.areEqual(this.itemsRequest, itemsList.itemsRequest) && Intrinsics.areEqual(getMessageId(), itemsList.getMessageId()) && Intrinsics.areEqual(getPlatformSupport(), itemsList.getPlatformSupport()) && Intrinsics.areEqual(getVersion(), itemsList.getVersion()) && Intrinsics.areEqual(getExpandableData(), itemsList.getExpandableData()) && getHideKeyboard() == itemsList.getHideKeyboard();
        }

        @Override // com.avito.android.remote.model.messenger.context_actions.PlatformActions.ExpandableData.Provider
        @NotNull
        public ExpandableData getExpandableData() {
            return this.expandableData;
        }

        @Override // com.avito.android.remote.model.messenger.context_actions.PlatformActions
        public boolean getHideKeyboard() {
            return this.hideKeyboard;
        }

        @NotNull
        public final ItemsRequest getItemsRequest() {
            return this.itemsRequest;
        }

        @Override // ru.avito.messenger.api.entity.context.ChannelContextActions
        @Nullable
        public String getMessageId() {
            return this.messageId;
        }

        @Override // ru.avito.messenger.api.entity.context.ChannelContextActions
        @Nullable
        public PlatformSupport getPlatformSupport() {
            return this.platformSupport;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override // ru.avito.messenger.api.entity.context.ChannelContextActions
        @Nullable
        public Long getVersion() {
            return this.version;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.title;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            ItemsRequest itemsRequest2 = this.itemsRequest;
            int hashCode2 = (hashCode + (itemsRequest2 != null ? itemsRequest2.hashCode() : 0)) * 31;
            String messageId2 = getMessageId();
            int hashCode3 = (hashCode2 + (messageId2 != null ? messageId2.hashCode() : 0)) * 31;
            PlatformSupport platformSupport2 = getPlatformSupport();
            int hashCode4 = (hashCode3 + (platformSupport2 != null ? platformSupport2.hashCode() : 0)) * 31;
            Long version2 = getVersion();
            int hashCode5 = (hashCode4 + (version2 != null ? version2.hashCode() : 0)) * 31;
            ExpandableData expandableData2 = getExpandableData();
            if (expandableData2 != null) {
                i = expandableData2.hashCode();
            }
            int i2 = (hashCode5 + i) * 31;
            boolean hideKeyboard2 = getHideKeyboard();
            if (hideKeyboard2) {
                hideKeyboard2 = true;
            }
            int i3 = hideKeyboard2 ? 1 : 0;
            int i4 = hideKeyboard2 ? 1 : 0;
            int i5 = hideKeyboard2 ? 1 : 0;
            return i2 + i3;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("ItemsList(title=");
            L.append(this.title);
            L.append(", itemsRequest=");
            L.append(this.itemsRequest);
            L.append(", messageId=");
            L.append(getMessageId());
            L.append(", platformSupport=");
            L.append(getPlatformSupport());
            L.append(", version=");
            L.append(getVersion());
            L.append(", expandableData=");
            L.append(getExpandableData());
            L.append(", hideKeyboard=");
            L.append(getHideKeyboard());
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            this.itemsRequest.writeToParcel(parcel, 0);
            parcel.writeString(this.messageId);
            PlatformSupport platformSupport2 = this.platformSupport;
            if (platformSupport2 != null) {
                parcel.writeInt(1);
                platformSupport2.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            Long l = this.version;
            if (l != null) {
                a.I0(parcel, 1, l);
            } else {
                parcel.writeInt(0);
            }
            this.expandableData.writeToParcel(parcel, 0);
            parcel.writeInt(this.hideKeyboard ? 1 : 0);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b%\u0010&J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\nR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00108V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$None;", "Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions;", "", "component1", "()Ljava/lang/Long;", "version", "copy", "(Ljava/lang/Long;)Lcom/avito/android/remote/model/messenger/context_actions/PlatformActions$None;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Long;", "getVersion", "getMessageId", "messageId", "Lcom/avito/android/remote/model/messenger/PlatformSupport;", "getPlatformSupport", "()Lcom/avito/android/remote/model/messenger/PlatformSupport;", PlatformActions.PLATFORM_SUPPORT, "getHideKeyboard", "()Z", PlatformActions.HIDE_KEYBOARD, "<init>", "(Ljava/lang/Long;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class None extends PlatformActions {
        public static final Parcelable.Creator<None> CREATOR = new Creator();
        @Nullable
        private final Long version;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<None> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final None createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new None(parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final None[] newArray(int i) {
                return new None[i];
            }
        }

        public None(@Nullable Long l) {
            super(null);
            this.version = l;
        }

        public static /* synthetic */ None copy$default(None none, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                l = none.getVersion();
            }
            return none.copy(l);
        }

        @Nullable
        public final Long component1() {
            return getVersion();
        }

        @NotNull
        public final None copy(@Nullable Long l) {
            return new None(l);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof None) && Intrinsics.areEqual(getVersion(), ((None) obj).getVersion());
            }
            return true;
        }

        @Override // com.avito.android.remote.model.messenger.context_actions.PlatformActions
        public boolean getHideKeyboard() {
            return false;
        }

        @Override // ru.avito.messenger.api.entity.context.ChannelContextActions
        @Nullable
        public String getMessageId() {
            return null;
        }

        @Override // ru.avito.messenger.api.entity.context.ChannelContextActions
        @Nullable
        public PlatformSupport getPlatformSupport() {
            return null;
        }

        @Override // ru.avito.messenger.api.entity.context.ChannelContextActions
        @Nullable
        public Long getVersion() {
            return this.version;
        }

        @Override // java.lang.Object
        public int hashCode() {
            Long version2 = getVersion();
            if (version2 != null) {
                return version2.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("None(version=");
            L.append(getVersion());
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Long l = this.version;
            if (l != null) {
                a.I0(parcel, 1, l);
            } else {
                parcel.writeInt(0);
            }
        }
    }

    private PlatformActions() {
    }

    public abstract boolean getHideKeyboard();

    public final boolean isExpandable() {
        return (this instanceof ExpandableData.Provider) && ((ExpandableData.Provider) this).getExpandableData() != null;
    }

    public /* synthetic */ PlatformActions(j jVar) {
        this();
    }
}
