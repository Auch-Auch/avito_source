package com.avito.android.category_parameters;

import a2.b.a.a.a;
import a2.g.r.g;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.html_formatter.MutableHtmlNode;
import com.avito.android.items.BasicInputItem;
import com.avito.android.items.InputItem;
import com.avito.android.items.ItemWithAdditionalButton;
import com.avito.android.items.ItemWithErrors;
import com.avito.android.items.ItemWithHtmlSupport;
import com.avito.android.items.ItemWithMotivation;
import com.avito.android.items.ItemWithState;
import com.avito.android.items.SelectableItem;
import com.avito.android.items.SelectableItemsSection;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.category_parameters.DisplayingOptions;
import com.avito.android.remote.model.category_parameters.SelectionType;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.select.title.TitleItem;
import com.avito.conveyor_item.Item;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.vk.sdk.api.VKApiConst;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0011\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0001\u000f\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'¨\u0006("}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement;", "Lcom/avito/conveyor_item/Item;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "Button", "DateInterval", ExifInterface.TAG_DATETIME, "DisplayType", "EditCategoryButton", "Format", "GroupMarker", "Input", "Multiselect", "Objects", "Photo", "Select", "SelectDeepLink", "TabsSelect", "TaggedInput", "TextAreaInput", "Video", "Lcom/avito/android/category_parameters/ParameterElement$Select;", "Lcom/avito/android/category_parameters/ParameterElement$TabsSelect;", "Lcom/avito/android/category_parameters/ParameterElement$Multiselect;", "Lcom/avito/android/category_parameters/ParameterElement$TextAreaInput;", "Lcom/avito/android/category_parameters/ParameterElement$Input;", "Lcom/avito/android/category_parameters/ParameterElement$TaggedInput;", "Lcom/avito/android/category_parameters/ParameterElement$Button;", "Lcom/avito/android/category_parameters/ParameterElement$EditCategoryButton;", "Lcom/avito/android/category_parameters/ParameterElement$Objects;", "Lcom/avito/android/category_parameters/ParameterElement$Photo;", "Lcom/avito/android/category_parameters/ParameterElement$DateInterval;", "Lcom/avito/android/category_parameters/ParameterElement$DateTime;", "Lcom/avito/android/category_parameters/ParameterElement$Video;", "Lcom/avito/android/category_parameters/ParameterElement$GroupMarker;", "Lcom/avito/android/category_parameters/ParameterElement$SelectDeepLink;", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public abstract class ParameterElement implements Item {
    @NotNull
    public final String a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B9\u0012\u0006\u0010\u001b\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u000b\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0019\u0010\u0011\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0015R$\u0010\u001a\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$Button;", "Lcom/avito/android/category_parameters/ParameterElement;", "Lcom/avito/android/items/ItemWithErrors;", "Lcom/avito/android/items/ItemWithState;", "Lcom/avito/android/items/ItemWithState$State;", "e", "Lcom/avito/android/items/ItemWithState$State;", "getState", "()Lcom/avito/android/items/ItemWithState$State;", "setState", "(Lcom/avito/android/items/ItemWithState$State;)V", "state", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "c", "getError", "setError", "(Ljava/lang/String;)V", "error", "d", "getBubbleError", "setBubbleError", "bubbleError", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/items/ItemWithState$State;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public static final class Button extends ParameterElement implements ItemWithErrors, ItemWithState {
        @NotNull
        public final String b;
        @Nullable
        public String c;
        @Nullable
        public String d;
        @NotNull
        public ItemWithState.State e;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Button(String str, String str2, String str3, String str4, ItemWithState.State state, int i, j jVar) {
            this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? new ItemWithState.State.Normal(null, 1, null) : state);
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void clearErrors() {
            ItemWithErrors.DefaultImpls.clearErrors(this);
        }

        @Override // com.avito.android.items.ItemWithErrors
        @Nullable
        public String getBubbleError() {
            return this.d;
        }

        @Override // com.avito.android.items.ItemWithErrors
        @Nullable
        public String getError() {
            return this.c;
        }

        @Override // com.avito.android.items.ItemWithState
        @NotNull
        public ItemWithState.State getState() {
            return this.e;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void setBubbleError(@Nullable String str) {
            this.d = str;
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void setError(@Nullable String str) {
            this.c = str;
        }

        @Override // com.avito.android.items.ItemWithState
        public void setState(@NotNull ItemWithState.State state) {
            Intrinsics.checkNotNullParameter(state, "<set-?>");
            this.e = state;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Button(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @NotNull ItemWithState.State state) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(state, "state");
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = state;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$DateInterval;", "Lcom/avito/android/category_parameters/ParameterElement;", "Lcom/avito/android/category_parameters/ItemsWithStateContainer;", "", "hasNotNormalState", "()Z", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "Lcom/avito/android/category_parameters/ParameterElement$DateTime;", "d", "Lcom/avito/android/category_parameters/ParameterElement$DateTime;", "getEnd", "()Lcom/avito/android/category_parameters/ParameterElement$DateTime;", "end", "c", "getStart", Tracker.Events.CREATIVE_START, "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/category_parameters/ParameterElement$DateTime;Lcom/avito/android/category_parameters/ParameterElement$DateTime;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public static final class DateInterval extends ParameterElement implements ItemsWithStateContainer {
        @NotNull
        public final String b;
        @Nullable
        public final DateTime c;
        @Nullable
        public final DateTime d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DateInterval(@NotNull String str, @NotNull String str2, @Nullable DateTime dateTime, @Nullable DateTime dateTime2) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            this.b = str2;
            this.c = dateTime;
            this.d = dateTime2;
        }

        @Nullable
        public final DateTime getEnd() {
            return this.d;
        }

        @Nullable
        public final DateTime getStart() {
            return this.c;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }

        @Override // com.avito.android.category_parameters.ItemsWithStateContainer
        public boolean hasNotNormalState() {
            DateTime dateTime = this.c;
            ItemWithState.State state = null;
            if ((dateTime != null ? dateTime.getState() : null) instanceof ItemWithState.State.Normal) {
                DateTime dateTime2 = this.d;
                if (dateTime2 != null) {
                    state = dateTime2.getState();
                }
                if (state instanceof ItemWithState.State.Normal) {
                    return false;
                }
            }
            return true;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003By\u0012\u0006\u00100\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\b\u0010-\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u00103\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010&\u001a\u00020!\u0012\b\u0010<\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010>\u001a\u00020!\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u000104\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010 \u001a\u00020\u0019¢\u0006\u0004\bA\u0010BR\u0019\u0010\t\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR$\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\rR\"\u0010 \u001a\u00020\u00198\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0019\u0010&\u001a\u00020!8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R$\u0010-\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u00100\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b.\u0010\u0006\u001a\u0004\b/\u0010\bR\u0019\u00103\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u0011\u001a\u0004\b2\u0010\u0013R\u001b\u00109\u001a\u0004\u0018\u0001048\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001b\u0010<\u001a\u0004\u0018\u00010\u00048\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010\u0006\u001a\u0004\b;\u0010\bR\"\u0010>\u001a\u00020!8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b=\u0010#\u001a\u0004\b>\u0010%\"\u0004\b?\u0010@¨\u0006C"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$DateTime;", "Lcom/avito/android/category_parameters/ParameterElement;", "Lcom/avito/android/items/ItemWithErrors;", "Lcom/avito/android/items/ItemWithState;", "", "c", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "l", "getError", "setError", "(Ljava/lang/String;)V", "error", "", "f", "J", "getMax", "()J", "max", "k", "getBubbleError", "setBubbleError", "bubbleError", "Lcom/avito/android/items/ItemWithState$State;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/items/ItemWithState$State;", "getState", "()Lcom/avito/android/items/ItemWithState$State;", "setState", "(Lcom/avito/android/items/ItemWithState$State;)V", "state", "", g.a, "Z", "getAllowEmpty", "()Z", "allowEmpty", "d", "Ljava/lang/Long;", "getValue", "()Ljava/lang/Long;", "setValue", "(Ljava/lang/Long;)V", "value", AuthSource.BOOKING_ORDER, "getStringId", "stringId", "e", "getMin", "min", "Lcom/avito/android/remote/model/category_parameters/SelectionType;", "j", "Lcom/avito/android/remote/model/category_parameters/SelectionType;", "getSelectionType", "()Lcom/avito/android/remote/model/category_parameters/SelectionType;", "selectionType", "h", "getPresentTime", "presentTime", "i", "isPresentTime", "setPresentTime", "(Z)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;JJZLjava/lang/String;ZLcom/avito/android/remote/model/category_parameters/SelectionType;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/items/ItemWithState$State;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public static final class DateTime extends ParameterElement implements ItemWithErrors, ItemWithState {
        @NotNull
        public final String b;
        @NotNull
        public final String c;
        @Nullable
        public Long d;
        public final long e;
        public final long f;
        public final boolean g;
        @Nullable
        public final String h;
        public boolean i;
        @Nullable
        public final SelectionType j;
        @Nullable
        public String k;
        @Nullable
        public String l;
        @NotNull
        public ItemWithState.State m;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ DateTime(String str, String str2, Long l2, long j2, long j3, boolean z, String str3, boolean z2, SelectionType selectionType, String str4, String str5, ItemWithState.State state, int i2, j jVar) {
            this(str, str2, l2, j2, j3, z, str3, z2, (i2 & 256) != 0 ? null : selectionType, (i2 & 512) != 0 ? null : str4, (i2 & 1024) != 0 ? null : str5, (i2 & 2048) != 0 ? new ItemWithState.State.Normal(null, 1, null) : state);
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void clearErrors() {
            ItemWithErrors.DefaultImpls.clearErrors(this);
        }

        public final boolean getAllowEmpty() {
            return this.g;
        }

        @Override // com.avito.android.items.ItemWithErrors
        @Nullable
        public String getBubbleError() {
            return this.k;
        }

        @Override // com.avito.android.items.ItemWithErrors
        @Nullable
        public String getError() {
            return this.l;
        }

        public final long getMax() {
            return this.f;
        }

        public final long getMin() {
            return this.e;
        }

        @Nullable
        public final String getPresentTime() {
            return this.h;
        }

        @Nullable
        public final SelectionType getSelectionType() {
            return this.j;
        }

        @Override // com.avito.android.items.ItemWithState
        @NotNull
        public ItemWithState.State getState() {
            return this.m;
        }

        @Override // com.avito.android.category_parameters.ParameterElement, com.avito.conveyor_item.Item
        @NotNull
        public String getStringId() {
            return this.b;
        }

        @NotNull
        public final String getTitle() {
            return this.c;
        }

        @Nullable
        public final Long getValue() {
            return this.d;
        }

        public final boolean isPresentTime() {
            return this.i;
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void setBubbleError(@Nullable String str) {
            this.k = str;
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void setError(@Nullable String str) {
            this.l = str;
        }

        public final void setPresentTime(boolean z) {
            this.i = z;
        }

        @Override // com.avito.android.items.ItemWithState
        public void setState(@NotNull ItemWithState.State state) {
            Intrinsics.checkNotNullParameter(state, "<set-?>");
            this.m = state;
        }

        public final void setValue(@Nullable Long l2) {
            this.d = l2;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DateTime(@NotNull String str, @NotNull String str2, @Nullable Long l2, long j2, long j3, boolean z, @Nullable String str3, boolean z2, @Nullable SelectionType selectionType, @Nullable String str4, @Nullable String str5, @NotNull ItemWithState.State state) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "stringId");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(state, "state");
            this.b = str;
            this.c = str2;
            this.d = l2;
            this.e = j2;
            this.f = j3;
            this.g = z;
            this.h = str3;
            this.i = z2;
            this.j = selectionType;
            this.k = str4;
            this.l = str5;
            this.m = state;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\n\u0004\u0005\u0006\u0007\b\t\n\u000b\f\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\n\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$DisplayType;", "", "<init>", "()V", "BottomSheet", "Bubbles", "Calendar", "Chips", "Dialog", "GroupSelect", "Inlined", "RadioGroup", "RemovableOnly", "SerpDisplayType", "Lcom/avito/android/category_parameters/ParameterElement$DisplayType$Inlined;", "Lcom/avito/android/category_parameters/ParameterElement$DisplayType$GroupSelect;", "Lcom/avito/android/category_parameters/ParameterElement$DisplayType$Dialog;", "Lcom/avito/android/category_parameters/ParameterElement$DisplayType$Bubbles;", "Lcom/avito/android/category_parameters/ParameterElement$DisplayType$RadioGroup;", "Lcom/avito/android/category_parameters/ParameterElement$DisplayType$Calendar;", "Lcom/avito/android/category_parameters/ParameterElement$DisplayType$SerpDisplayType;", "Lcom/avito/android/category_parameters/ParameterElement$DisplayType$RemovableOnly;", "Lcom/avito/android/category_parameters/ParameterElement$DisplayType$Chips;", "Lcom/avito/android/category_parameters/ParameterElement$DisplayType$BottomSheet;", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class DisplayType {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$DisplayType$BottomSheet;", "Lcom/avito/android/category_parameters/ParameterElement$DisplayType;", "<init>", "()V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
        public static final class BottomSheet extends DisplayType {
            @NotNull
            public static final BottomSheet INSTANCE = new BottomSheet();

            public BottomSheet() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$DisplayType$Bubbles;", "Lcom/avito/android/category_parameters/ParameterElement$DisplayType;", "<init>", "()V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
        public static final class Bubbles extends DisplayType {
            @NotNull
            public static final Bubbles INSTANCE = new Bubbles();

            public Bubbles() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$DisplayType$Calendar;", "Lcom/avito/android/category_parameters/ParameterElement$DisplayType;", "<init>", "()V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
        public static final class Calendar extends DisplayType {
            @NotNull
            public static final Calendar INSTANCE = new Calendar();

            public Calendar() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$DisplayType$Chips;", "Lcom/avito/android/category_parameters/ParameterElement$DisplayType;", "", AuthSource.SEND_ABUSE, "Z", "getKeepSelectedChip", "()Z", "keepSelectedChip", "<init>", "(Z)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
        public static final class Chips extends DisplayType {
            public final boolean a;

            public Chips() {
                this(false, 1, null);
            }

            public Chips(boolean z) {
                super(null);
                this.a = z;
            }

            public final boolean getKeepSelectedChip() {
                return this.a;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Chips(boolean z, int i, j jVar) {
                this((i & 1) != 0 ? true : z);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$DisplayType$Dialog;", "Lcom/avito/android/category_parameters/ParameterElement$DisplayType;", "<init>", "()V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
        public static final class Dialog extends DisplayType {
            @NotNull
            public static final Dialog INSTANCE = new Dialog();

            public Dialog() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$DisplayType$GroupSelect;", "Lcom/avito/android/category_parameters/ParameterElement$DisplayType;", "<init>", "()V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
        public static final class GroupSelect extends DisplayType {
            @NotNull
            public static final GroupSelect INSTANCE = new GroupSelect();

            public GroupSelect() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$DisplayType$Inlined;", "Lcom/avito/android/category_parameters/ParameterElement$DisplayType;", "<init>", "()V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
        public static final class Inlined extends DisplayType {
            @NotNull
            public static final Inlined INSTANCE = new Inlined();

            public Inlined() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$DisplayType$RadioGroup;", "Lcom/avito/android/category_parameters/ParameterElement$DisplayType;", "<init>", "()V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
        public static final class RadioGroup extends DisplayType {
            @NotNull
            public static final RadioGroup INSTANCE = new RadioGroup();

            public RadioGroup() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$DisplayType$RemovableOnly;", "Lcom/avito/android/category_parameters/ParameterElement$DisplayType;", "<init>", "()V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
        public static final class RemovableOnly extends DisplayType {
            @NotNull
            public static final RemovableOnly INSTANCE = new RemovableOnly();

            public RemovableOnly() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$DisplayType$SerpDisplayType;", "Lcom/avito/android/category_parameters/ParameterElement$DisplayType;", "<init>", "()V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
        public static final class SerpDisplayType extends DisplayType {
            @NotNull
            public static final SerpDisplayType INSTANCE = new SerpDisplayType();

            public SerpDisplayType() {
                super(null);
            }
        }

        public DisplayType() {
        }

        public DisplayType(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$Format;", "", "<init>", "()V", "Price", "Lcom/avito/android/category_parameters/ParameterElement$Format$Price;", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Format {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$Format$Price;", "Lcom/avito/android/category_parameters/ParameterElement$Format;", "<init>", "()V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
        public static final class Price extends Format {
            public Price() {
                super(null);
            }
        }

        public Format() {
        }

        public Format(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$GroupMarker;", "Lcom/avito/android/category_parameters/ParameterElement;", "End", "Start", "Lcom/avito/android/category_parameters/ParameterElement$GroupMarker$Start;", "Lcom/avito/android/category_parameters/ParameterElement$GroupMarker$End;", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class GroupMarker extends ParameterElement {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$GroupMarker$End;", "Lcom/avito/android/category_parameters/ParameterElement$GroupMarker;", "", "stringId", "<init>", "(Ljava/lang/String;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
        public static final class End extends GroupMarker {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public End(@NotNull String str) {
                super(str, null);
                Intrinsics.checkNotNullParameter(str, "stringId");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$GroupMarker$Start;", "Lcom/avito/android/category_parameters/ParameterElement$GroupMarker;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "stringId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
        public static final class Start extends GroupMarker {
            @NotNull
            public final String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Start(@NotNull String str, @NotNull String str2) {
                super(str, null);
                Intrinsics.checkNotNullParameter(str, "stringId");
                Intrinsics.checkNotNullParameter(str2, "title");
                this.b = str2;
            }

            @NotNull
            public final String getTitle() {
                return this.b;
            }
        }

        public GroupMarker(String str, j jVar) {
            super(str, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001cB5\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0011\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$Objects;", "Lcom/avito/android/category_parameters/ParameterElement;", "Lcom/avito/android/category_parameters/TitleHidingElement;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "", "e", "Z", "getHideTitle", "()Z", "hideTitle", "c", "getAddMoreVisible", "addMoreVisible", "", "Lcom/avito/android/category_parameters/ParameterElement$Objects$Item;", "d", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "items", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;Z)V", "Item", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public static final class Objects extends ParameterElement implements TitleHidingElement {
        @NotNull
        public final String b;
        public final boolean c;
        @NotNull
        public final List<Item> d;
        public final boolean e;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$Objects$Item;", "", "", "c", "Ljava/lang/String;", "getSecondSubtitle", "()Ljava/lang/String;", "secondSubtitle", AuthSource.BOOKING_ORDER, "getFirstSubtitle", "firstSubtitle", AuthSource.SEND_ABUSE, "getTitle", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
        public static final class Item {
            @NotNull
            public final String a;
            @Nullable
            public final String b;
            @Nullable
            public final String c;

            public Item(@NotNull String str, @Nullable String str2, @Nullable String str3) {
                Intrinsics.checkNotNullParameter(str, "title");
                this.a = str;
                this.b = str2;
                this.c = str3;
            }

            @Nullable
            public final String getFirstSubtitle() {
                return this.b;
            }

            @Nullable
            public final String getSecondSubtitle() {
                return this.c;
            }

            @NotNull
            public final String getTitle() {
                return this.a;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Item(String str, String str2, String str3, int i, j jVar) {
                this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Objects(@NotNull String str, @NotNull String str2, boolean z, @NotNull List<Item> list, boolean z2) {
            super(str, null);
            a.c1(str, "id", str2, "title", list, "items");
            this.b = str2;
            this.c = z;
            this.d = list;
            this.e = z2;
        }

        public final boolean getAddMoreVisible() {
            return this.c;
        }

        @Override // com.avito.android.category_parameters.TitleHidingElement
        public boolean getHideTitle() {
            return this.e;
        }

        @NotNull
        public final List<Item> getItems() {
            return this.d;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002\\]B\u0001\b\u0002\u0012\u0006\u0010Y\u001a\u00020\u0006\u0012\u0006\u0010X\u001a\u00020\u0006\u0012\b\u0010R\u001a\u0004\u0018\u00010\u0006\u0012\b\u00106\u001a\u0004\u0018\u00010/\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010G\u001a\u0004\u0018\u00010B\u0012\b\u0010:\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010I\u001a\u00020\n\u0012\b\b\u0002\u0010A\u001a\u00020\n\u0012\u0006\u0010\u001f\u001a\u00020\n\u0012\b\u0010L\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010.\u001a\u00020'\u0012\b\b\u0002\u0010O\u001a\u00020\n\u0012\b\b\u0002\u0010U\u001a\u00020\n¢\u0006\u0004\bZ\u0010[J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\fJ\r\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\fJ\r\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\fJ\r\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\fJ\r\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\fJ\r\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\fJ\r\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\fR$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001f\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\fR$\u0010&\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010.\u001a\u00020'8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u00106\u001a\u0004\u0018\u00010/8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u0010:\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b7\u0010!\u001a\u0004\b8\u0010#\"\u0004\b9\u0010%R\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020<0;8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0019\u0010A\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010\u001d\u001a\u0004\bA\u0010\fR\u001b\u0010G\u001a\u0004\u0018\u00010B8\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0019\u0010I\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010\u001d\u001a\u0004\bI\u0010\fR\u001b\u0010L\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010!\u001a\u0004\bK\u0010#R\u001c\u0010O\u001a\u00020\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bM\u0010\u001d\u001a\u0004\bN\u0010\fR\u001b\u0010R\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\bP\u0010!\u001a\u0004\bQ\u0010#R\u0019\u0010U\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\bS\u0010\u001d\u001a\u0004\bT\u0010\fR\u0019\u0010X\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\bV\u0010!\u001a\u0004\bW\u0010#\u0001\u0002^_¨\u0006`"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$Select;", "Lcom/avito/android/category_parameters/ParameterElement;", "Lcom/avito/android/category_parameters/TitleHidingElement;", "Lcom/avito/android/items/ItemWithErrors;", "Lcom/avito/android/items/ItemWithState;", "Lcom/avito/android/items/ItemWithMotivation;", "", "newTitle", "cloneWithNewTitle", "(Ljava/lang/String;)Lcom/avito/android/category_parameters/ParameterElement$Select;", "", "isInline", "()Z", "isDialog", "isBubbles", "isChips", "isRadioGroup", "isCalendar", "isSerpDisplayType", "isBottomSheet", "Lcom/avito/android/items/SelectableItem;", "e", "Lcom/avito/android/items/SelectableItem;", "getSelectedValue", "()Lcom/avito/android/items/SelectableItem;", "setSelectedValue", "(Lcom/avito/android/items/SelectableItem;)V", "selectedValue", "k", "Z", "getIconVisible", "iconVisible", "h", "Ljava/lang/String;", "getBubbleError", "()Ljava/lang/String;", "setBubbleError", "(Ljava/lang/String;)V", "bubbleError", "Lcom/avito/android/items/ItemWithState$State;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/items/ItemWithState$State;", "getState", "()Lcom/avito/android/items/ItemWithState$State;", "setState", "(Lcom/avito/android/items/ItemWithState$State;)V", "state", "Lcom/avito/android/remote/model/text/AttributedText;", "d", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "()Lcom/avito/android/remote/model/text/AttributedText;", "setMotivation", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "motivation", g.a, "getError", "setError", "error", "", "Lcom/avito/conveyor_item/Item;", "getItemsToShow", "()Ljava/util/List;", "itemsToShow", "j", "isEnabled", "Lcom/avito/android/category_parameters/ParameterElement$DisplayType;", "f", "Lcom/avito/android/category_parameters/ParameterElement$DisplayType;", "getDisplayType", "()Lcom/avito/android/category_parameters/ParameterElement$DisplayType;", "displayType", "i", "isRequired", "l", "getPlaceholder", InternalConstsKt.PLACEHOLDER, "n", "getHideTitle", "hideTitle", "c", "getValue", "value", "o", "getClearEnabled", "clearEnabled", AuthSource.BOOKING_ORDER, "getTitle", "title", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/items/SelectableItem;Lcom/avito/android/category_parameters/ParameterElement$DisplayType;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;Lcom/avito/android/items/ItemWithState$State;ZZ)V", "Flat", "Sectioned", "Lcom/avito/android/category_parameters/ParameterElement$Select$Flat;", "Lcom/avito/android/category_parameters/ParameterElement$Select$Sectioned;", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Select extends ParameterElement implements TitleHidingElement, ItemWithErrors, ItemWithState, ItemWithMotivation {
        @NotNull
        public final String b;
        @Nullable
        public final String c;
        @Nullable
        public AttributedText d;
        @Nullable
        public SelectableItem e;
        @Nullable
        public final DisplayType f;
        @Nullable
        public String g;
        @Nullable
        public String h;
        public final boolean i;
        public final boolean j;
        public final boolean k;
        @Nullable
        public final String l;
        @NotNull
        public ItemWithState.State m;
        public final boolean n;
        public final boolean o;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001Bµ\u0001\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\"\u0012\b\b\u0002\u0010$\u001a\u00020\u001d\u0012\b\b\u0002\u0010%\u001a\u00020\u001d¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\n\u001a\u00020\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\r¨\u0006("}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$Select$Flat;", "Lcom/avito/android/category_parameters/ParameterElement$Select;", "", "newTitle", "cloneWithNewTitle", "(Ljava/lang/String;)Lcom/avito/android/category_parameters/ParameterElement$Select$Flat;", "", "Lcom/avito/android/items/SelectableItem;", "newValues", "newSelectedValue", "cloneWithNewValues", "(Ljava/util/List;Lcom/avito/android/items/SelectableItem;)Lcom/avito/android/category_parameters/ParameterElement$Select$Flat;", "getItemsToShow", "()Ljava/util/List;", "itemsToShow", "p", "Ljava/util/List;", "getValues", ResidentialComplexModuleKt.VALUES, "id", "title", "value", "Lcom/avito/android/remote/model/text/AttributedText;", "motivation", "selectedValue", "Lcom/avito/android/category_parameters/ParameterElement$DisplayType;", "displayType", "error", "bubbleError", "", "isRequired", "isEnabled", "iconVisible", InternalConstsKt.PLACEHOLDER, "Lcom/avito/android/items/ItemWithState$State;", "state", "hideTitle", "clearEnabled", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/items/SelectableItem;Ljava/util/List;Lcom/avito/android/category_parameters/ParameterElement$DisplayType;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;Lcom/avito/android/items/ItemWithState$State;ZZ)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
        public static final class Flat extends Select {
            @NotNull
            public final List<SelectableItem> p;

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Flat(String str, String str2, String str3, AttributedText attributedText, SelectableItem selectableItem, List list, DisplayType displayType, String str4, String str5, boolean z, boolean z2, boolean z3, String str6, ItemWithState.State state, boolean z4, boolean z5, int i, j jVar) {
                this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : attributedText, (i & 16) != 0 ? null : selectableItem, (i & 32) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i & 64) != 0 ? null : displayType, (i & 128) != 0 ? null : str4, (i & 256) != 0 ? null : str5, (i & 512) != 0 ? false : z, (i & 1024) != 0 ? true : z2, z3, (i & 4096) != 0 ? null : str6, (i & 8192) != 0 ? new ItemWithState.State.Normal(null, 1, null) : state, (i & 16384) != 0 ? false : z4, (i & 32768) != 0 ? true : z5);
            }

            @NotNull
            public final Flat cloneWithNewValues(@NotNull List<SelectableItem> list, @Nullable SelectableItem selectableItem) {
                Intrinsics.checkNotNullParameter(list, "newValues");
                return new Flat(getStringId(), getTitle(), getValue(), getMotivation(), selectableItem, list, getDisplayType(), getError(), getBubbleError(), isRequired(), isEnabled(), getIconVisible(), null, null, false, getClearEnabled(), 28672, null);
            }

            @Override // com.avito.android.category_parameters.ParameterElement.Select
            @NotNull
            public List<SelectableItem> getItemsToShow() {
                return this.p;
            }

            @NotNull
            public final List<SelectableItem> getValues() {
                return this.p;
            }

            @Override // com.avito.android.category_parameters.ParameterElement.Select
            @NotNull
            public Flat cloneWithNewTitle(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "newTitle");
                return new Flat(getStringId(), str, getValue(), getMotivation(), getSelectedValue(), this.p, getDisplayType(), getError(), getBubbleError(), isRequired(), isEnabled(), getIconVisible(), null, null, false, getClearEnabled(), 28672, null);
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Flat(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable AttributedText attributedText, @Nullable SelectableItem selectableItem, @NotNull List<SelectableItem> list, @Nullable DisplayType displayType, @Nullable String str4, @Nullable String str5, boolean z, boolean z2, boolean z3, @Nullable String str6, @NotNull ItemWithState.State state, boolean z4, boolean z5) {
                super(str, str2, str3, attributedText, selectableItem, displayType, str4, str5, z, z2, z3, str6, state, z4, z5, null);
                Intrinsics.checkNotNullParameter(str, "id");
                Intrinsics.checkNotNullParameter(str2, "title");
                Intrinsics.checkNotNullParameter(list, ResidentialComplexModuleKt.VALUES);
                Intrinsics.checkNotNullParameter(state, "state");
                this.p = list;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006 "}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$Select$Sectioned;", "Lcom/avito/android/category_parameters/ParameterElement$Select;", "", "newTitle", "cloneWithNewTitle", "(Ljava/lang/String;)Lcom/avito/android/category_parameters/ParameterElement$Select$Sectioned;", "", "Lcom/avito/conveyor_item/Item;", "getItemsToShow", "()Ljava/util/List;", "itemsToShow", "Lcom/avito/android/items/SelectableItemsSection;", "p", "Ljava/util/List;", "sections", "id", "title", "value", "Lcom/avito/android/remote/model/text/AttributedText;", "motivation", "Lcom/avito/android/items/SelectableItem;", "selectedValue", "error", "bubbleError", "", "isRequired", "iconVisible", InternalConstsKt.PLACEHOLDER, "Lcom/avito/android/items/ItemWithState$State;", "state", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/items/SelectableItem;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Lcom/avito/android/items/ItemWithState$State;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
        public static final class Sectioned extends Select {
            public final List<SelectableItemsSection> p;

            public static final class a extends Lambda implements Function1<SelectableItemsSection, List<? extends Item>> {
                public static final a a = new a();

                public a() {
                    super(1);
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public List<? extends Item> invoke(SelectableItemsSection selectableItemsSection) {
                    SelectableItemsSection selectableItemsSection2 = selectableItemsSection;
                    Intrinsics.checkNotNullParameter(selectableItemsSection2, "it");
                    if (selectableItemsSection2.getItems().isEmpty()) {
                        return null;
                    }
                    String title = selectableItemsSection2.getTitle();
                    if (title == null || title.length() == 0) {
                        return selectableItemsSection2.getItems();
                    }
                    SpreadBuilder spreadBuilder = new SpreadBuilder(2);
                    spreadBuilder.add(new TitleItem(selectableItemsSection2.getTitle()));
                    Object[] array = selectableItemsSection2.getItems().toArray(new SelectableItem[0]);
                    java.util.Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                    spreadBuilder.addSpread(array);
                    return CollectionsKt__CollectionsKt.listOf((Object[]) ((Item[]) spreadBuilder.toArray(new Item[spreadBuilder.size()])));
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Sectioned(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable AttributedText attributedText, @Nullable SelectableItem selectableItem, @NotNull List<SelectableItemsSection> list, @Nullable String str4, @Nullable String str5, boolean z, boolean z2, @Nullable String str6, @NotNull ItemWithState.State state) {
                super(str, str2, str3, attributedText, selectableItem, null, str4, str5, z, true, z2, str6, state, false, true);
                Intrinsics.checkNotNullParameter(str, "id");
                Intrinsics.checkNotNullParameter(str2, "title");
                Intrinsics.checkNotNullParameter(list, "sections");
                Intrinsics.checkNotNullParameter(state, "state");
                this.p = list;
            }

            @Override // com.avito.android.category_parameters.ParameterElement.Select
            @NotNull
            public List<Item> getItemsToShow() {
                return SequencesKt___SequencesKt.toList(SequencesKt__SequencesKt.flattenSequenceOfIterable(SequencesKt___SequencesKt.mapNotNull(CollectionsKt___CollectionsKt.asSequence(this.p), a.a)));
            }

            @Override // com.avito.android.category_parameters.ParameterElement.Select
            @NotNull
            public Sectioned cloneWithNewTitle(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "newTitle");
                return new Sectioned(getStringId(), str, getValue(), getMotivation(), getSelectedValue(), this.p, getError(), getBubbleError(), isRequired(), getIconVisible(), null, null, 3072, null);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Sectioned(String str, String str2, String str3, AttributedText attributedText, SelectableItem selectableItem, List list, String str4, String str5, boolean z, boolean z2, String str6, ItemWithState.State state, int i, j jVar) {
                this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : attributedText, (i & 16) != 0 ? null : selectableItem, (i & 32) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? false : z, z2, (i & 1024) != 0 ? null : str6, (i & 2048) != 0 ? new ItemWithState.State.Normal(null, 1, null) : state);
            }
        }

        public /* synthetic */ Select(String str, String str2, String str3, AttributedText attributedText, SelectableItem selectableItem, DisplayType displayType, String str4, String str5, boolean z, boolean z2, boolean z3, String str6, ItemWithState.State state, boolean z4, boolean z5, j jVar) {
            this(str, str2, str3, attributedText, selectableItem, displayType, str4, str5, z, z2, z3, str6, state, z4, z5);
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void clearErrors() {
            ItemWithErrors.DefaultImpls.clearErrors(this);
        }

        @NotNull
        public abstract Select cloneWithNewTitle(@NotNull String str);

        @Override // com.avito.android.items.ItemWithErrors
        @Nullable
        public String getBubbleError() {
            return this.h;
        }

        public final boolean getClearEnabled() {
            return this.o;
        }

        @Nullable
        public final DisplayType getDisplayType() {
            return this.f;
        }

        @Override // com.avito.android.items.ItemWithErrors
        @Nullable
        public String getError() {
            return this.g;
        }

        @Override // com.avito.android.category_parameters.TitleHidingElement
        public boolean getHideTitle() {
            return this.n;
        }

        public final boolean getIconVisible() {
            return this.k;
        }

        @NotNull
        public abstract List<Item> getItemsToShow();

        @Override // com.avito.android.items.ItemWithMotivation
        @Nullable
        public AttributedText getMotivation() {
            return this.d;
        }

        @Nullable
        public final String getPlaceholder() {
            return this.l;
        }

        @Nullable
        public final SelectableItem getSelectedValue() {
            return this.e;
        }

        @Override // com.avito.android.items.ItemWithState
        @NotNull
        public ItemWithState.State getState() {
            return this.m;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }

        @Nullable
        public final String getValue() {
            return this.c;
        }

        public final boolean isBottomSheet() {
            return this.f instanceof DisplayType.BottomSheet;
        }

        public final boolean isBubbles() {
            return this.f instanceof DisplayType.Bubbles;
        }

        public final boolean isCalendar() {
            return this.f instanceof DisplayType.Calendar;
        }

        public final boolean isChips() {
            return this.f instanceof DisplayType.Chips;
        }

        public final boolean isDialog() {
            return this.f instanceof DisplayType.Dialog;
        }

        public final boolean isEnabled() {
            return this.j;
        }

        public final boolean isInline() {
            return this.f instanceof DisplayType.Inlined;
        }

        public final boolean isRadioGroup() {
            return this.f instanceof DisplayType.RadioGroup;
        }

        public final boolean isRequired() {
            return this.i;
        }

        public final boolean isSerpDisplayType() {
            return this.f instanceof DisplayType.SerpDisplayType;
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void setBubbleError(@Nullable String str) {
            this.h = str;
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void setError(@Nullable String str) {
            this.g = str;
        }

        public void setMotivation(@Nullable AttributedText attributedText) {
            this.d = attributedText;
        }

        public final void setSelectedValue(@Nullable SelectableItem selectableItem) {
            this.e = selectableItem;
        }

        @Override // com.avito.android.items.ItemWithState
        public void setState(@NotNull ItemWithState.State state) {
            Intrinsics.checkNotNullParameter(state, "<set-?>");
            this.m = state;
        }

        public Select(String str, String str2, String str3, AttributedText attributedText, SelectableItem selectableItem, DisplayType displayType, String str4, String str5, boolean z, boolean z2, boolean z3, String str6, ItemWithState.State state, boolean z4, boolean z5) {
            super(str, null);
            this.b = str2;
            this.c = str3;
            this.d = attributedText;
            this.e = selectableItem;
            this.f = displayType;
            this.g = str4;
            this.h = str5;
            this.i = z;
            this.j = z2;
            this.k = z3;
            this.l = str6;
            this.m = state;
            this.n = z4;
            this.o = z5;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004Bq\u0012\u0006\u00104\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\b\b\u0002\u0010%\u001a\u00020\u0018\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u00100\u001a\u00020)\u0012\u0006\u00103\u001a\u00020\u0005¢\u0006\u0004\b5\u00106R$\u0010\f\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\tR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001b\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0007\u001a\u0004\b\u001e\u0010\tR$\u0010#\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b \u0010\u0007\u001a\u0004\b!\u0010\t\"\u0004\b\"\u0010\u000bR\u0019\u0010%\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010\u001cR\u001b\u0010(\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0007\u001a\u0004\b'\u0010\tR\"\u00100\u001a\u00020)8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0019\u00103\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u0007\u001a\u0004\b2\u0010\t¨\u00067"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$SelectDeepLink;", "Lcom/avito/android/category_parameters/ParameterElement;", "Lcom/avito/android/items/ItemWithErrors;", "Lcom/avito/android/items/ItemWithMotivation;", "Lcom/avito/android/items/ItemWithState;", "", "f", "Ljava/lang/String;", "getBubbleError", "()Ljava/lang/String;", "setBubbleError", "(Ljava/lang/String;)V", "bubbleError", AuthSource.BOOKING_ORDER, "getTitle", "title", "Lcom/avito/android/remote/model/text/AttributedText;", "d", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "()Lcom/avito/android/remote/model/text/AttributedText;", "setMotivation", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "motivation", "", g.a, "Z", "isRequired", "()Z", "c", "getValue", "value", "e", "getError", "setError", "error", "h", "isEnabled", "i", "getPlaceholder", InternalConstsKt.PLACEHOLDER, "Lcom/avito/android/items/ItemWithState$State;", "j", "Lcom/avito/android/items/ItemWithState$State;", "getState", "()Lcom/avito/android/items/ItemWithState$State;", "setState", "(Lcom/avito/android/items/ItemWithState$State;)V", "state", "k", "getDeepLinkUrl", "deepLinkUrl", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Lcom/avito/android/items/ItemWithState$State;Ljava/lang/String;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public static final class SelectDeepLink extends ParameterElement implements ItemWithErrors, ItemWithMotivation, ItemWithState {
        @NotNull
        public final String b;
        @Nullable
        public final String c;
        @Nullable
        public AttributedText d;
        @Nullable
        public String e;
        @Nullable
        public String f;
        public final boolean g;
        public final boolean h;
        @Nullable
        public final String i;
        @NotNull
        public ItemWithState.State j;
        @NotNull
        public final String k;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SelectDeepLink(String str, String str2, String str3, AttributedText attributedText, String str4, String str5, boolean z, boolean z2, String str6, ItemWithState.State state, String str7, int i2, j jVar) {
            this(str, str2, str3, attributedText, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? null : str5, z, (i2 & 128) != 0 ? true : z2, str6, (i2 & 512) != 0 ? new ItemWithState.State.Normal(null, 1, null) : state, str7);
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void clearErrors() {
            ItemWithErrors.DefaultImpls.clearErrors(this);
        }

        @Override // com.avito.android.items.ItemWithErrors
        @Nullable
        public String getBubbleError() {
            return this.f;
        }

        @NotNull
        public final String getDeepLinkUrl() {
            return this.k;
        }

        @Override // com.avito.android.items.ItemWithErrors
        @Nullable
        public String getError() {
            return this.e;
        }

        @Override // com.avito.android.items.ItemWithMotivation
        @Nullable
        public AttributedText getMotivation() {
            return this.d;
        }

        @Nullable
        public final String getPlaceholder() {
            return this.i;
        }

        @Override // com.avito.android.items.ItemWithState
        @NotNull
        public ItemWithState.State getState() {
            return this.j;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }

        @Nullable
        public final String getValue() {
            return this.c;
        }

        public final boolean isEnabled() {
            return this.h;
        }

        public final boolean isRequired() {
            return this.g;
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void setBubbleError(@Nullable String str) {
            this.f = str;
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void setError(@Nullable String str) {
            this.e = str;
        }

        public void setMotivation(@Nullable AttributedText attributedText) {
            this.d = attributedText;
        }

        @Override // com.avito.android.items.ItemWithState
        public void setState(@NotNull ItemWithState.State state) {
            Intrinsics.checkNotNullParameter(state, "<set-?>");
            this.j = state;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SelectDeepLink(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable AttributedText attributedText, @Nullable String str4, @Nullable String str5, boolean z, boolean z2, @Nullable String str6, @NotNull ItemWithState.State state, @NotNull String str7) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(str7, "deepLinkUrl");
            this.b = str2;
            this.c = str3;
            this.d = attributedText;
            this.e = str4;
            this.f = str5;
            this.g = z;
            this.h = z2;
            this.i = str6;
            this.j = state;
            this.k = str7;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$TabsSelect;", "Lcom/avito/android/category_parameters/ParameterElement;", "Lcom/avito/android/category_parameters/ParameterElement$Select$Flat;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/category_parameters/ParameterElement$Select$Flat;", "getWrapped", "()Lcom/avito/android/category_parameters/ParameterElement$Select$Flat;", "wrapped", "<init>", "(Lcom/avito/android/category_parameters/ParameterElement$Select$Flat;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public static final class TabsSelect extends ParameterElement {
        @NotNull
        public final Select.Flat b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TabsSelect(@NotNull Select.Flat flat) {
            super(flat.getStringId(), null);
            Intrinsics.checkNotNullParameter(flat, "wrapped");
            this.b = flat;
        }

        @NotNull
        public final Select.Flat getWrapped() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004BU\u0012\u0006\u0010&\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0010¢\u0006\u0004\b'\u0010(R$\u0010\f\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\tR\"\u0010\u0017\u001a\u00020\u00108\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR$\u0010!\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0007\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000bR$\u0010%\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0007\u001a\u0004\b#\u0010\t\"\u0004\b$\u0010\u000b¨\u0006)"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$TextAreaInput;", "Lcom/avito/android/category_parameters/ParameterElement;", "Lcom/avito/android/items/BasicInputItem;", "Lcom/avito/android/items/ItemWithErrors;", "Lcom/avito/android/items/ItemWithState;", "", "c", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "value", "d", "getHint", "hint", "Lcom/avito/android/items/ItemWithState$State;", g.a, "Lcom/avito/android/items/ItemWithState$State;", "getState", "()Lcom/avito/android/items/ItemWithState$State;", "setState", "(Lcom/avito/android/items/ItemWithState$State;)V", "state", "Lcom/avito/android/remote/model/text/AttributedText;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "()Lcom/avito/android/remote/model/text/AttributedText;", "motivation", "f", "getBubbleError", "setBubbleError", "bubbleError", "e", "getError", "setError", "error", "id", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/items/ItemWithState$State;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public static final class TextAreaInput extends ParameterElement implements BasicInputItem, ItemWithErrors, ItemWithState {
        @Nullable
        public final AttributedText b;
        @Nullable
        public String c;
        @Nullable
        public final String d;
        @Nullable
        public String e;
        @Nullable
        public String f;
        @NotNull
        public ItemWithState.State g;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ TextAreaInput(String str, AttributedText attributedText, String str2, String str3, String str4, String str5, ItemWithState.State state, int i, j jVar) {
            this(str, (i & 2) != 0 ? null : attributedText, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? new ItemWithState.State.Normal(null, 1, null) : state);
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void clearErrors() {
            ItemWithErrors.DefaultImpls.clearErrors(this);
        }

        @Override // com.avito.android.items.ItemWithErrors
        @Nullable
        public String getBubbleError() {
            return this.f;
        }

        @Override // com.avito.android.items.ItemWithErrors
        @Nullable
        public String getError() {
            return this.e;
        }

        @Nullable
        public final String getHint() {
            return this.d;
        }

        @Nullable
        public final AttributedText getMotivation() {
            return this.b;
        }

        @Override // com.avito.android.items.ItemWithState
        @NotNull
        public ItemWithState.State getState() {
            return this.g;
        }

        @Override // com.avito.android.items.BasicInputItem
        @Nullable
        public String getValue() {
            return this.c;
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void setBubbleError(@Nullable String str) {
            this.f = str;
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void setError(@Nullable String str) {
            this.e = str;
        }

        @Override // com.avito.android.items.ItemWithState
        public void setState(@NotNull ItemWithState.State state) {
            Intrinsics.checkNotNullParameter(state, "<set-?>");
            this.g = state;
        }

        @Override // com.avito.android.items.BasicInputItem
        public void setValue(@Nullable String str) {
            this.c = str;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TextAreaInput(@NotNull String str, @Nullable AttributedText attributedText, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @NotNull ItemWithState.State state) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(state, "state");
            this.b = attributedText;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
            this.g = state;
        }
    }

    public ParameterElement(String str, j jVar) {
        this.a = str;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0014\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BK\u0012\u0006\u0010#\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b$\u0010%R\u0019\u0010\t\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0015\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0019\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\bR$\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\u001dR$\u0010\"\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0006\u001a\u0004\b \u0010\b\"\u0004\b!\u0010\u001d¨\u0006&"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$EditCategoryButton;", "Lcom/avito/android/category_parameters/ParameterElement;", "Lcom/avito/android/items/ItemWithErrors;", "Lcom/avito/android/items/ItemWithState;", "", "c", "Ljava/lang/String;", "getParentTitle", "()Ljava/lang/String;", "parentTitle", "Lcom/avito/android/items/ItemWithState$State;", "f", "Lcom/avito/android/items/ItemWithState$State;", "getState", "()Lcom/avito/android/items/ItemWithState$State;", "setState", "(Lcom/avito/android/items/ItemWithState$State;)V", "state", "", g.a, "Z", "isEnabled", "()Z", AuthSource.BOOKING_ORDER, "getTitle", "title", "d", "getError", "setError", "(Ljava/lang/String;)V", "error", "e", "getBubbleError", "setBubbleError", "bubbleError", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/items/ItemWithState$State;Z)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public static final class EditCategoryButton extends ParameterElement implements ItemWithErrors, ItemWithState {
        @NotNull
        public final String b;
        @NotNull
        public final String c;
        @Nullable
        public String d;
        @Nullable
        public String e;
        @NotNull
        public ItemWithState.State f;
        public final boolean g;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ EditCategoryButton(String str, String str2, String str3, String str4, String str5, ItemWithState.State state, boolean z, int i, j jVar) {
            this(str, str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? new ItemWithState.State.Normal(null, 1, null) : state, (i & 64) != 0 ? true : z);
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void clearErrors() {
            ItemWithErrors.DefaultImpls.clearErrors(this);
        }

        @Override // com.avito.android.items.ItemWithErrors
        @Nullable
        public String getBubbleError() {
            return this.e;
        }

        @Override // com.avito.android.items.ItemWithErrors
        @Nullable
        public String getError() {
            return this.d;
        }

        @NotNull
        public final String getParentTitle() {
            return this.c;
        }

        @Override // com.avito.android.items.ItemWithState
        @NotNull
        public ItemWithState.State getState() {
            return this.f;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }

        public final boolean isEnabled() {
            return this.g;
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void setBubbleError(@Nullable String str) {
            this.e = str;
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void setError(@Nullable String str) {
            this.d = str;
        }

        @Override // com.avito.android.items.ItemWithState
        public void setState(@NotNull ItemWithState.State state) {
            Intrinsics.checkNotNullParameter(state, "<set-?>");
            this.f = state;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EditCategoryButton(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @NotNull ItemWithState.State state, boolean z) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(str3, "parentTitle");
            Intrinsics.checkNotNullParameter(state, "state");
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f = state;
            this.g = z;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B_\u0012\u0006\u00103\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010)\u001a\u00020$\u0012\b\b\u0002\u0010#\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u001b\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b4\u00105R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\"\u0010\u000f\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001b\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010R\"\u0010#\u001a\u00020\u001c8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0019\u0010)\u001a\u00020$8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R$\u0010.\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b*\u0010\b\u001a\u0004\b+\u0010\n\"\u0004\b,\u0010-R$\u00102\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b/\u0010\b\u001a\u0004\b0\u0010\n\"\u0004\b1\u0010-¨\u00066"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$Photo;", "Lcom/avito/android/category_parameters/ParameterElement;", "Lcom/avito/android/items/ItemWithErrors;", "Lcom/avito/android/items/ItemWithState;", "Lcom/avito/android/items/ItemWithMotivation;", "Lcom/avito/android/category_parameters/TitleHidingElement;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "", "i", "Z", "isVideoEnabled", "()Z", "setVideoEnabled", "(Z)V", "Lcom/avito/android/remote/model/text/AttributedText;", g.a, "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "()Lcom/avito/android/remote/model/text/AttributedText;", "motivation", "h", "getHideTitle", "hideTitle", "Lcom/avito/android/items/ItemWithState$State;", "f", "Lcom/avito/android/items/ItemWithState$State;", "getState", "()Lcom/avito/android/items/ItemWithState$State;", "setState", "(Lcom/avito/android/items/ItemWithState$State;)V", "state", "", "e", "I", "getCount", "()I", "count", "c", "getBubbleError", "setBubbleError", "(Ljava/lang/String;)V", "bubbleError", "d", "getError", "setError", "error", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/avito/android/items/ItemWithState$State;Lcom/avito/android/remote/model/text/AttributedText;ZZ)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public static final class Photo extends ParameterElement implements ItemWithErrors, ItemWithState, ItemWithMotivation, TitleHidingElement {
        @NotNull
        public final String b;
        @Nullable
        public String c;
        @Nullable
        public String d;
        public final int e;
        @NotNull
        public ItemWithState.State f;
        @Nullable
        public final AttributedText g;
        public final boolean h;
        public boolean i;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Photo(String str, String str2, String str3, String str4, int i2, ItemWithState.State state, AttributedText attributedText, boolean z, boolean z2, int i3, j jVar) {
            this(str, str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : str4, i2, (i3 & 32) != 0 ? new ItemWithState.State.Normal(null, 1, null) : state, (i3 & 64) != 0 ? null : attributedText, z, (i3 & 256) != 0 ? false : z2);
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void clearErrors() {
            ItemWithErrors.DefaultImpls.clearErrors(this);
        }

        @Override // com.avito.android.items.ItemWithErrors
        @Nullable
        public String getBubbleError() {
            return this.c;
        }

        public final int getCount() {
            return this.e;
        }

        @Override // com.avito.android.items.ItemWithErrors
        @Nullable
        public String getError() {
            return this.d;
        }

        @Override // com.avito.android.category_parameters.TitleHidingElement
        public boolean getHideTitle() {
            return this.h;
        }

        @Override // com.avito.android.items.ItemWithMotivation
        @Nullable
        public AttributedText getMotivation() {
            return this.g;
        }

        @Override // com.avito.android.items.ItemWithState
        @NotNull
        public ItemWithState.State getState() {
            return this.f;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }

        public final boolean isVideoEnabled() {
            return this.i;
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void setBubbleError(@Nullable String str) {
            this.c = str;
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void setError(@Nullable String str) {
            this.d = str;
        }

        @Override // com.avito.android.items.ItemWithState
        public void setState(@NotNull ItemWithState.State state) {
            Intrinsics.checkNotNullParameter(state, "<set-?>");
            this.f = state;
        }

        public final void setVideoEnabled(boolean z) {
            this.i = z;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Photo(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, int i2, @NotNull ItemWithState.State state, @Nullable AttributedText attributedText, boolean z, boolean z2) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(state, "state");
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = i2;
            this.f = state;
            this.g = attributedText;
            this.h = z;
            this.i = z2;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b0\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u0001\u0012\u0006\u0010#\u001a\u00020\b\u0012\u0006\u0010$\u001a\u00020\b\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010(\u001a\u00020\u000e\u0012\u0006\u0010)\u001a\u00020\u0011\u0012\u0006\u0010*\u001a\u00020\u0014\u0012\u0006\u0010+\u001a\u00020\u0014\u0012\b\u0010,\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010-\u001a\u00020\u0019\u0012\b\b\u0002\u0010.\u001a\u00020\u000e\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010 ¢\u0006\u0004\bc\u0010dJ\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0012\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\r\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u0018\u0010\nJ\u0010\u0010\u001a\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0010J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010!\u001a\u0004\u0018\u00010 HÆ\u0003¢\u0006\u0004\b!\u0010\"J¨\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010#\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\b2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020\u00112\b\b\u0002\u0010*\u001a\u00020\u00142\b\b\u0002\u0010+\u001a\u00020\u00142\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010-\u001a\u00020\u00192\b\b\u0002\u0010.\u001a\u00020\u000e2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u00100\u001a\u0004\u0018\u00010 HÆ\u0001¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b3\u0010\nJ\u0010\u00104\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b4\u0010\u0016J\u001a\u00107\u001a\u00020\u000e2\b\u00106\u001a\u0004\u0018\u000105HÖ\u0003¢\u0006\u0004\b7\u00108R$\u0010'\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010\n\"\u0004\b<\u0010=R$\u00100\u001a\u0004\u0018\u00010 8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010\"\"\u0004\bA\u0010BR\u001b\u0010,\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010:\u001a\u0004\bD\u0010\nR\u0019\u0010$\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010:\u001a\u0004\bF\u0010\nR\u0019\u0010*\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010\u0016R\u001c\u0010.\u001a\u00020\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010\u0010R\u001e\u0010/\u001a\u0004\u0018\u00010\u001d8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010\u001fR\u0019\u0010)\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010\u0013R\u0019\u0010+\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\bS\u0010H\u001a\u0004\bT\u0010\u0016R$\u0010%\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bU\u0010:\u001a\u0004\bV\u0010\n\"\u0004\bW\u0010=R\u0019\u0010(\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bX\u0010K\u001a\u0004\bY\u0010\u0010R$\u0010&\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bZ\u0010:\u001a\u0004\b[\u0010\n\"\u0004\b\\\u0010=R\"\u0010-\u001a\u00020\u00198\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010\u001b\"\u0004\b`\u0010aR\u0016\u0010#\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010:¨\u0006e"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$TaggedInput;", "Lcom/avito/android/category_parameters/ParameterElement;", "Lcom/avito/android/items/ItemWithErrors;", "Lcom/avito/android/items/ItemWithState;", "Lcom/avito/android/items/BasicInputItem;", "Lcom/avito/android/category_parameters/TitleHidingElement;", "Lcom/avito/android/items/ItemWithMotivation;", "Lcom/avito/android/items/ItemWithHtmlSupport;", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "", "component6", "()Z", "Lcom/avito/android/lib/design/input/FormatterType;", "component7", "()Lcom/avito/android/lib/design/input/FormatterType;", "", "component8", "()I", "component9", "component10", "Lcom/avito/android/items/ItemWithState$State;", "component11", "()Lcom/avito/android/items/ItemWithState$State;", "component12", "Lcom/avito/android/remote/model/text/AttributedText;", "component13", "()Lcom/avito/android/remote/model/text/AttributedText;", "Lcom/avito/android/html_formatter/MutableHtmlNode;", "component14", "()Lcom/avito/android/html_formatter/MutableHtmlNode;", "itemId", "title", "value", "error", "bubbleError", "dynamicTags", "inputType", "androidSdkInputType", "lines", InternalConstsKt.PLACEHOLDER, "state", "hideTitle", "motivation", "htmlRootNode", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/avito/android/lib/design/input/FormatterType;IILjava/lang/String;Lcom/avito/android/items/ItemWithState$State;ZLcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/html_formatter/MutableHtmlNode;)Lcom/avito/android/category_parameters/ParameterElement$TaggedInput;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "f", "Ljava/lang/String;", "getBubbleError", "setBubbleError", "(Ljava/lang/String;)V", "o", "Lcom/avito/android/html_formatter/MutableHtmlNode;", "getHtmlRootNode", "setHtmlRootNode", "(Lcom/avito/android/html_formatter/MutableHtmlNode;)V", "k", "getPlaceholder", "c", "getTitle", "i", "I", "getAndroidSdkInputType", AuthSource.OPEN_CHANNEL_LIST, "Z", "getHideTitle", "n", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "h", "Lcom/avito/android/lib/design/input/FormatterType;", "getInputType", "j", "getLines", "d", "getValue", "setValue", g.a, "getDynamicTags", "e", "getError", "setError", "l", "Lcom/avito/android/items/ItemWithState$State;", "getState", "setState", "(Lcom/avito/android/items/ItemWithState$State;)V", AuthSource.BOOKING_ORDER, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/avito/android/lib/design/input/FormatterType;IILjava/lang/String;Lcom/avito/android/items/ItemWithState$State;ZLcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/html_formatter/MutableHtmlNode;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public static final class TaggedInput extends ParameterElement implements ItemWithErrors, ItemWithState, BasicInputItem, TitleHidingElement, ItemWithMotivation, ItemWithHtmlSupport {
        public final String b;
        @NotNull
        public final String c;
        @Nullable
        public String d;
        @Nullable
        public String e;
        @Nullable
        public String f;
        public final boolean g;
        @NotNull
        public final FormatterType h;
        public final int i;
        public final int j;
        @Nullable
        public final String k;
        @NotNull
        public ItemWithState.State l;
        public final boolean m;
        @Nullable
        public final AttributedText n;
        @Nullable
        public MutableHtmlNode o;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ TaggedInput(String str, String str2, String str3, String str4, String str5, boolean z, FormatterType formatterType, int i2, int i3, String str6, ItemWithState.State state, boolean z2, AttributedText attributedText, MutableHtmlNode mutableHtmlNode, int i4, j jVar) {
            this(str, str2, (i4 & 4) != 0 ? null : str3, (i4 & 8) != 0 ? null : str4, (i4 & 16) != 0 ? null : str5, (i4 & 32) != 0 ? false : z, formatterType, i2, i3, str6, (i4 & 1024) != 0 ? new ItemWithState.State.Normal(null, 1, null) : state, (i4 & 2048) != 0 ? false : z2, (i4 & 4096) != 0 ? null : attributedText, (i4 & 8192) != 0 ? null : mutableHtmlNode);
        }

        public static /* synthetic */ TaggedInput copy$default(TaggedInput taggedInput, String str, String str2, String str3, String str4, String str5, boolean z, FormatterType formatterType, int i2, int i3, String str6, ItemWithState.State state, boolean z2, AttributedText attributedText, MutableHtmlNode mutableHtmlNode, int i4, Object obj) {
            return taggedInput.copy((i4 & 1) != 0 ? taggedInput.b : str, (i4 & 2) != 0 ? taggedInput.c : str2, (i4 & 4) != 0 ? taggedInput.getValue() : str3, (i4 & 8) != 0 ? taggedInput.getError() : str4, (i4 & 16) != 0 ? taggedInput.getBubbleError() : str5, (i4 & 32) != 0 ? taggedInput.g : z, (i4 & 64) != 0 ? taggedInput.h : formatterType, (i4 & 128) != 0 ? taggedInput.i : i2, (i4 & 256) != 0 ? taggedInput.j : i3, (i4 & 512) != 0 ? taggedInput.k : str6, (i4 & 1024) != 0 ? taggedInput.getState() : state, (i4 & 2048) != 0 ? taggedInput.getHideTitle() : z2, (i4 & 4096) != 0 ? taggedInput.getMotivation() : attributedText, (i4 & 8192) != 0 ? taggedInput.getHtmlRootNode() : mutableHtmlNode);
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void clearErrors() {
            ItemWithErrors.DefaultImpls.clearErrors(this);
        }

        @Nullable
        public final String component10() {
            return this.k;
        }

        @NotNull
        public final ItemWithState.State component11() {
            return getState();
        }

        public final boolean component12() {
            return getHideTitle();
        }

        @Nullable
        public final AttributedText component13() {
            return getMotivation();
        }

        @Nullable
        public final MutableHtmlNode component14() {
            return getHtmlRootNode();
        }

        @NotNull
        public final String component2() {
            return this.c;
        }

        @Nullable
        public final String component3() {
            return getValue();
        }

        @Nullable
        public final String component4() {
            return getError();
        }

        @Nullable
        public final String component5() {
            return getBubbleError();
        }

        public final boolean component6() {
            return this.g;
        }

        @NotNull
        public final FormatterType component7() {
            return this.h;
        }

        public final int component8() {
            return this.i;
        }

        public final int component9() {
            return this.j;
        }

        @NotNull
        public final TaggedInput copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, boolean z, @NotNull FormatterType formatterType, int i2, int i3, @Nullable String str6, @NotNull ItemWithState.State state, boolean z2, @Nullable AttributedText attributedText, @Nullable MutableHtmlNode mutableHtmlNode) {
            Intrinsics.checkNotNullParameter(str, "itemId");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(formatterType, "inputType");
            Intrinsics.checkNotNullParameter(state, "state");
            return new TaggedInput(str, str2, str3, str4, str5, z, formatterType, i2, i3, str6, state, z2, attributedText, mutableHtmlNode);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TaggedInput)) {
                return false;
            }
            TaggedInput taggedInput = (TaggedInput) obj;
            return Intrinsics.areEqual(this.b, taggedInput.b) && Intrinsics.areEqual(this.c, taggedInput.c) && Intrinsics.areEqual(getValue(), taggedInput.getValue()) && Intrinsics.areEqual(getError(), taggedInput.getError()) && Intrinsics.areEqual(getBubbleError(), taggedInput.getBubbleError()) && this.g == taggedInput.g && Intrinsics.areEqual(this.h, taggedInput.h) && this.i == taggedInput.i && this.j == taggedInput.j && Intrinsics.areEqual(this.k, taggedInput.k) && Intrinsics.areEqual(getState(), taggedInput.getState()) && getHideTitle() == taggedInput.getHideTitle() && Intrinsics.areEqual(getMotivation(), taggedInput.getMotivation()) && Intrinsics.areEqual(getHtmlRootNode(), taggedInput.getHtmlRootNode());
        }

        public final int getAndroidSdkInputType() {
            return this.i;
        }

        @Override // com.avito.android.items.ItemWithErrors
        @Nullable
        public String getBubbleError() {
            return this.f;
        }

        public final boolean getDynamicTags() {
            return this.g;
        }

        @Override // com.avito.android.items.ItemWithErrors
        @Nullable
        public String getError() {
            return this.e;
        }

        @Override // com.avito.android.category_parameters.TitleHidingElement
        public boolean getHideTitle() {
            return this.m;
        }

        @Override // com.avito.android.items.ItemWithHtmlSupport
        @Nullable
        public MutableHtmlNode getHtmlRootNode() {
            return this.o;
        }

        @NotNull
        public final FormatterType getInputType() {
            return this.h;
        }

        public final int getLines() {
            return this.j;
        }

        @Override // com.avito.android.items.ItemWithMotivation
        @Nullable
        public AttributedText getMotivation() {
            return this.n;
        }

        @Nullable
        public final String getPlaceholder() {
            return this.k;
        }

        @Override // com.avito.android.items.ItemWithState
        @NotNull
        public ItemWithState.State getState() {
            return this.l;
        }

        @NotNull
        public final String getTitle() {
            return this.c;
        }

        @Override // com.avito.android.items.BasicInputItem
        @Nullable
        public String getValue() {
            return this.d;
        }

        public int hashCode() {
            String str = this.b;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.c;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String value = getValue();
            int hashCode3 = (hashCode2 + (value != null ? value.hashCode() : 0)) * 31;
            String error = getError();
            int hashCode4 = (hashCode3 + (error != null ? error.hashCode() : 0)) * 31;
            String bubbleError = getBubbleError();
            int hashCode5 = (hashCode4 + (bubbleError != null ? bubbleError.hashCode() : 0)) * 31;
            boolean z = this.g;
            int i3 = 1;
            if (z) {
                z = true;
            }
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = z ? 1 : 0;
            int i7 = (hashCode5 + i4) * 31;
            FormatterType formatterType = this.h;
            int hashCode6 = (((((i7 + (formatterType != null ? formatterType.hashCode() : 0)) * 31) + this.i) * 31) + this.j) * 31;
            String str3 = this.k;
            int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 31;
            ItemWithState.State state = getState();
            int hashCode8 = (hashCode7 + (state != null ? state.hashCode() : 0)) * 31;
            boolean hideTitle = getHideTitle();
            if (!hideTitle) {
                i3 = hideTitle;
            }
            int i8 = (hashCode8 + i3) * 31;
            AttributedText motivation = getMotivation();
            int hashCode9 = (i8 + (motivation != null ? motivation.hashCode() : 0)) * 31;
            MutableHtmlNode htmlRootNode = getHtmlRootNode();
            if (htmlRootNode != null) {
                i2 = htmlRootNode.hashCode();
            }
            return hashCode9 + i2;
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void setBubbleError(@Nullable String str) {
            this.f = str;
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void setError(@Nullable String str) {
            this.e = str;
        }

        @Override // com.avito.android.items.ItemWithHtmlSupport
        public void setHtmlRootNode(@Nullable MutableHtmlNode mutableHtmlNode) {
            this.o = mutableHtmlNode;
        }

        @Override // com.avito.android.items.ItemWithState
        public void setState(@NotNull ItemWithState.State state) {
            Intrinsics.checkNotNullParameter(state, "<set-?>");
            this.l = state;
        }

        @Override // com.avito.android.items.BasicInputItem
        public void setValue(@Nullable String str) {
            this.d = str;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("TaggedInput(itemId=");
            L.append(this.b);
            L.append(", title=");
            L.append(this.c);
            L.append(", value=");
            L.append(getValue());
            L.append(", error=");
            L.append(getError());
            L.append(", bubbleError=");
            L.append(getBubbleError());
            L.append(", dynamicTags=");
            L.append(this.g);
            L.append(", inputType=");
            L.append(this.h);
            L.append(", androidSdkInputType=");
            L.append(this.i);
            L.append(", lines=");
            L.append(this.j);
            L.append(", placeholder=");
            L.append(this.k);
            L.append(", state=");
            L.append(getState());
            L.append(", hideTitle=");
            L.append(getHideTitle());
            L.append(", motivation=");
            L.append(getMotivation());
            L.append(", htmlRootNode=");
            L.append(getHtmlRootNode());
            L.append(")");
            return L.toString();
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TaggedInput(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, boolean z, @NotNull FormatterType formatterType, int i2, int i3, @Nullable String str6, @NotNull ItemWithState.State state, boolean z2, @Nullable AttributedText attributedText, @Nullable MutableHtmlNode mutableHtmlNode) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "itemId");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(formatterType, "inputType");
            Intrinsics.checkNotNullParameter(state, "state");
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
            this.g = z;
            this.h = formatterType;
            this.i = i2;
            this.j = i3;
            this.k = str6;
            this.l = state;
            this.m = z2;
            this.n = attributedText;
            this.o = mutableHtmlNode;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\bB\b\b\u0018\u00002\u00020\u00012\u00020\u0002B×\u0001\u0012\u0006\u0010*\u001a\u00020\u0003\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010/\u001a\u00020\t\u0012\u0006\u00100\u001a\u00020\t\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u00109\u001a\u00020\u001e\u0012\b\b\u0002\u0010:\u001a\u00020!\u0012\b\b\u0002\u0010;\u001a\u00020$\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010'¢\u0006\u0006\b\u0001\u0010\u0001J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\b\u0010\u0005J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\r\u0010\u0005J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0005J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0005J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020!HÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020$HÆ\u0003¢\u0006\u0004\b%\u0010&J\u0012\u0010(\u001a\u0004\u0018\u00010'HÆ\u0003¢\u0006\u0004\b(\u0010)Jæ\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010/\u001a\u00020\t2\b\b\u0002\u00100\u001a\u00020\t2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00103\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u00109\u001a\u00020\u001e2\b\b\u0002\u0010:\u001a\u00020!2\b\b\u0002\u0010;\u001a\u00020$2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010'HÆ\u0001¢\u0006\u0004\b=\u0010>J\u0010\u0010?\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b?\u0010\u0005J\u0010\u0010@\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b@\u0010\u000bJ\u001a\u0010C\u001a\u00020$2\b\u0010B\u001a\u0004\u0018\u00010AHÖ\u0003¢\u0006\u0004\bC\u0010DR\u001e\u00105\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010\u0016R\u001c\u0010;\u001a\u00020$8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010&R$\u0010<\u001a\u0004\u0018\u00010'8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010)\"\u0004\bN\u0010OR\u001e\u00103\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010\u0010R\u001e\u00106\u001a\u0004\u0018\u00010\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010\u0019R\"\u00109\u001a\u00020\u001e8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010 \"\u0004\bY\u0010ZR$\u0010,\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010\u0005\"\u0004\b^\u0010_R\"\u0010:\u001a\u00020!8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010#\"\u0004\bc\u0010dR\u001c\u0010e\u001a\u00020$8\u0016@\u0016XD¢\u0006\f\n\u0004\be\u0010I\u001a\u0004\bf\u0010&R\u001e\u00101\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bg\u0010\\\u001a\u0004\bh\u0010\u0005R\u001c\u0010/\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010\u000bR\u001c\u00100\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bl\u0010j\u001a\u0004\bm\u0010\u000bR$\u0010.\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bn\u0010\\\u001a\u0004\bo\u0010\u0005\"\u0004\bp\u0010_R\u001e\u00107\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bq\u0010\\\u001a\u0004\br\u0010\u0005R\u001c\u0010+\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bs\u0010\\\u001a\u0004\bt\u0010\u0005R\u001e\u00102\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bu\u0010\\\u001a\u0004\bv\u0010\u0005R\u0016\u0010*\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bw\u0010\\R$\u0010-\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bx\u0010\\\u001a\u0004\by\u0010\u0005\"\u0004\bz\u0010_R\u001b\u00104\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b{\u0010|\u001a\u0004\b}\u0010\u0013R\u001f\u00108\u001a\u0004\u0018\u00010\u001b8\u0016@\u0016X\u0004¢\u0006\r\n\u0004\b~\u0010\u001a\u0005\b\u0001\u0010\u001d¨\u0006\u0001"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$Input;", "Lcom/avito/android/category_parameters/ParameterElement;", "Lcom/avito/android/items/InputItem;", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "", "component6", "()I", "component7", "component8", "component9", "component10", "()Ljava/lang/Integer;", "Lcom/avito/android/category_parameters/ParameterElement$Format;", "component11", "()Lcom/avito/android/category_parameters/ParameterElement$Format;", "Lcom/avito/android/items/ItemWithAdditionalButton$AdditionalButton;", "component12", "()Lcom/avito/android/items/ItemWithAdditionalButton$AdditionalButton;", "Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "component13", "()Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "component14", "Lcom/avito/android/remote/model/text/AttributedText;", "component15", "()Lcom/avito/android/remote/model/text/AttributedText;", "Lcom/avito/android/items/ItemWithState$State;", "component16", "()Lcom/avito/android/items/ItemWithState$State;", "Lcom/avito/android/lib/design/input/FormatterType;", "component17", "()Lcom/avito/android/lib/design/input/FormatterType;", "", "component18", "()Z", "Lcom/avito/android/html_formatter/MutableHtmlNode;", "component19", "()Lcom/avito/android/html_formatter/MutableHtmlNode;", "itemId", "title", "value", "error", "bubbleError", "androidSdkInputType", "lines", "prefix", "postfix", "labelMode", "format", "additionalButton", "displayingOptions", InternalConstsKt.PLACEHOLDER, "motivation", "state", "inputType", "hideTitle", "htmlRootNode", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/avito/android/category_parameters/ParameterElement$Format;Lcom/avito/android/items/ItemWithAdditionalButton$AdditionalButton;Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/items/ItemWithState$State;Lcom/avito/android/lib/design/input/FormatterType;ZLcom/avito/android/html_formatter/MutableHtmlNode;)Lcom/avito/android/category_parameters/ParameterElement$Input;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/items/ItemWithAdditionalButton$AdditionalButton;", "getAdditionalButton", "s", "Z", "getHideTitle", "t", "Lcom/avito/android/html_formatter/MutableHtmlNode;", "getHtmlRootNode", "setHtmlRootNode", "(Lcom/avito/android/html_formatter/MutableHtmlNode;)V", "k", "Ljava/lang/Integer;", "getLabelMode", "n", "Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "getDisplayingOptions", VKApiConst.Q, "Lcom/avito/android/items/ItemWithState$State;", "getState", "setState", "(Lcom/avito/android/items/ItemWithState$State;)V", "d", "Ljava/lang/String;", "getValue", "setValue", "(Ljava/lang/String;)V", "r", "Lcom/avito/android/lib/design/input/FormatterType;", "getInputType", "setInputType", "(Lcom/avito/android/lib/design/input/FormatterType;)V", "hasCardTopBackground", "getHasCardTopBackground", "i", "getPrefix", g.a, "I", "getAndroidSdkInputType", "h", "getLines", "f", "getBubbleError", "setBubbleError", "o", "getPlaceholder", "c", "getTitle", "j", "getPostfix", AuthSource.BOOKING_ORDER, "e", "getError", "setError", "l", "Lcom/avito/android/category_parameters/ParameterElement$Format;", "getFormat", "p", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/avito/android/category_parameters/ParameterElement$Format;Lcom/avito/android/items/ItemWithAdditionalButton$AdditionalButton;Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/items/ItemWithState$State;Lcom/avito/android/lib/design/input/FormatterType;ZLcom/avito/android/html_formatter/MutableHtmlNode;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public static final class Input extends ParameterElement implements InputItem {
        public final String b;
        @NotNull
        public final String c;
        @Nullable
        public String d;
        @Nullable
        public String e;
        @Nullable
        public String f;
        public final int g;
        public final int h;
        @Nullable
        public final String i;
        @Nullable
        public final String j;
        @Nullable
        public final Integer k;
        @Nullable
        public final Format l;
        @Nullable
        public final ItemWithAdditionalButton.AdditionalButton m;
        @Nullable
        public final DisplayingOptions n;
        @Nullable
        public final String o;
        @Nullable
        public final AttributedText p;
        @NotNull
        public ItemWithState.State q;
        @NotNull
        public FormatterType r;
        public final boolean s;
        @Nullable
        public MutableHtmlNode t;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Input(String str, String str2, String str3, String str4, String str5, int i2, int i3, String str6, String str7, Integer num, Format format, ItemWithAdditionalButton.AdditionalButton additionalButton, DisplayingOptions displayingOptions, String str8, AttributedText attributedText, ItemWithState.State state, FormatterType formatterType, boolean z, MutableHtmlNode mutableHtmlNode, int i4, j jVar) {
            this(str, str2, (i4 & 4) != 0 ? null : str3, (i4 & 8) != 0 ? null : str4, (i4 & 16) != 0 ? null : str5, i2, i3, (i4 & 128) != 0 ? null : str6, (i4 & 256) != 0 ? null : str7, (i4 & 512) != 0 ? null : num, (i4 & 1024) != 0 ? null : format, (i4 & 2048) != 0 ? null : additionalButton, (i4 & 4096) != 0 ? null : displayingOptions, (i4 & 8192) != 0 ? null : str8, (i4 & 16384) != 0 ? null : attributedText, (32768 & i4) != 0 ? new ItemWithState.State.Normal(null, 1, null) : state, (65536 & i4) != 0 ? FormatterType.Companion.getSIMPLE() : formatterType, (131072 & i4) != 0 ? false : z, (i4 & 262144) != 0 ? null : mutableHtmlNode);
        }

        public static /* synthetic */ Input copy$default(Input input, String str, String str2, String str3, String str4, String str5, int i2, int i3, String str6, String str7, Integer num, Format format, ItemWithAdditionalButton.AdditionalButton additionalButton, DisplayingOptions displayingOptions, String str8, AttributedText attributedText, ItemWithState.State state, FormatterType formatterType, boolean z, MutableHtmlNode mutableHtmlNode, int i4, Object obj) {
            return input.copy((i4 & 1) != 0 ? input.b : str, (i4 & 2) != 0 ? input.getTitle() : str2, (i4 & 4) != 0 ? input.getValue() : str3, (i4 & 8) != 0 ? input.getError() : str4, (i4 & 16) != 0 ? input.getBubbleError() : str5, (i4 & 32) != 0 ? input.getAndroidSdkInputType() : i2, (i4 & 64) != 0 ? input.getLines() : i3, (i4 & 128) != 0 ? input.getPrefix() : str6, (i4 & 256) != 0 ? input.getPostfix() : str7, (i4 & 512) != 0 ? input.getLabelMode() : num, (i4 & 1024) != 0 ? input.l : format, (i4 & 2048) != 0 ? input.getAdditionalButton() : additionalButton, (i4 & 4096) != 0 ? input.getDisplayingOptions() : displayingOptions, (i4 & 8192) != 0 ? input.getPlaceholder() : str8, (i4 & 16384) != 0 ? input.getMotivation() : attributedText, (i4 & 32768) != 0 ? input.getState() : state, (i4 & 65536) != 0 ? input.getInputType() : formatterType, (i4 & 131072) != 0 ? input.getHideTitle() : z, (i4 & 262144) != 0 ? input.getHtmlRootNode() : mutableHtmlNode);
        }

        @Override // com.avito.android.items.InputItem
        public void applyError(@Nullable String str) {
            InputItem.DefaultImpls.applyError(this, str);
        }

        @Override // com.avito.android.items.InputItem, com.avito.android.items.ItemWithErrors
        public void clearErrors() {
            InputItem.DefaultImpls.clearErrors(this);
        }

        @Nullable
        public final Integer component10() {
            return getLabelMode();
        }

        @Nullable
        public final Format component11() {
            return this.l;
        }

        @Nullable
        public final ItemWithAdditionalButton.AdditionalButton component12() {
            return getAdditionalButton();
        }

        @Nullable
        public final DisplayingOptions component13() {
            return getDisplayingOptions();
        }

        @Nullable
        public final String component14() {
            return getPlaceholder();
        }

        @Nullable
        public final AttributedText component15() {
            return getMotivation();
        }

        @NotNull
        public final ItemWithState.State component16() {
            return getState();
        }

        @NotNull
        public final FormatterType component17() {
            return getInputType();
        }

        public final boolean component18() {
            return getHideTitle();
        }

        @Nullable
        public final MutableHtmlNode component19() {
            return getHtmlRootNode();
        }

        @NotNull
        public final String component2() {
            return getTitle();
        }

        @Nullable
        public final String component3() {
            return getValue();
        }

        @Nullable
        public final String component4() {
            return getError();
        }

        @Nullable
        public final String component5() {
            return getBubbleError();
        }

        public final int component6() {
            return getAndroidSdkInputType();
        }

        public final int component7() {
            return getLines();
        }

        @Nullable
        public final String component8() {
            return getPrefix();
        }

        @Nullable
        public final String component9() {
            return getPostfix();
        }

        @NotNull
        public final Input copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, int i2, int i3, @Nullable String str6, @Nullable String str7, @Nullable Integer num, @Nullable Format format, @Nullable ItemWithAdditionalButton.AdditionalButton additionalButton, @Nullable DisplayingOptions displayingOptions, @Nullable String str8, @Nullable AttributedText attributedText, @NotNull ItemWithState.State state, @NotNull FormatterType formatterType, boolean z, @Nullable MutableHtmlNode mutableHtmlNode) {
            Intrinsics.checkNotNullParameter(str, "itemId");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(formatterType, "inputType");
            return new Input(str, str2, str3, str4, str5, i2, i3, str6, str7, num, format, additionalButton, displayingOptions, str8, attributedText, state, formatterType, z, mutableHtmlNode);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Input)) {
                return false;
            }
            Input input = (Input) obj;
            return Intrinsics.areEqual(this.b, input.b) && Intrinsics.areEqual(getTitle(), input.getTitle()) && Intrinsics.areEqual(getValue(), input.getValue()) && Intrinsics.areEqual(getError(), input.getError()) && Intrinsics.areEqual(getBubbleError(), input.getBubbleError()) && getAndroidSdkInputType() == input.getAndroidSdkInputType() && getLines() == input.getLines() && Intrinsics.areEqual(getPrefix(), input.getPrefix()) && Intrinsics.areEqual(getPostfix(), input.getPostfix()) && Intrinsics.areEqual(getLabelMode(), input.getLabelMode()) && Intrinsics.areEqual(this.l, input.l) && Intrinsics.areEqual(getAdditionalButton(), input.getAdditionalButton()) && Intrinsics.areEqual(getDisplayingOptions(), input.getDisplayingOptions()) && Intrinsics.areEqual(getPlaceholder(), input.getPlaceholder()) && Intrinsics.areEqual(getMotivation(), input.getMotivation()) && Intrinsics.areEqual(getState(), input.getState()) && Intrinsics.areEqual(getInputType(), input.getInputType()) && getHideTitle() == input.getHideTitle() && Intrinsics.areEqual(getHtmlRootNode(), input.getHtmlRootNode());
        }

        @Override // com.avito.android.items.InputItem, com.avito.android.items.ItemWithAdditionalButton
        @Nullable
        public ItemWithAdditionalButton.AdditionalButton getAdditionalButton() {
            return this.m;
        }

        @Override // com.avito.android.items.InputItem
        public int getAndroidSdkInputType() {
            return this.g;
        }

        @Override // com.avito.android.items.ItemWithErrors
        @Nullable
        public String getBubbleError() {
            return this.f;
        }

        @Override // com.avito.android.items.InputItem
        @Nullable
        public DisplayingOptions getDisplayingOptions() {
            return this.n;
        }

        @Override // com.avito.android.items.ItemWithErrors
        @Nullable
        public String getError() {
            return this.e;
        }

        @Nullable
        public final Format getFormat() {
            return this.l;
        }

        @Override // com.avito.android.items.InputItem
        public boolean getHasCardTopBackground() {
            return false;
        }

        @Override // com.avito.android.category_parameters.TitleHidingElement
        public boolean getHideTitle() {
            return this.s;
        }

        @Override // com.avito.android.items.ItemWithHtmlSupport
        @Nullable
        public MutableHtmlNode getHtmlRootNode() {
            return this.t;
        }

        @Override // com.avito.android.items.InputItem
        @NotNull
        public FormatterType getInputType() {
            return this.r;
        }

        @Override // com.avito.android.items.InputItem
        @Nullable
        public Integer getLabelMode() {
            return this.k;
        }

        @Override // com.avito.android.items.InputItem
        public int getLines() {
            return this.h;
        }

        @Override // com.avito.android.items.ItemWithMotivation
        @Nullable
        public AttributedText getMotivation() {
            return this.p;
        }

        @Override // com.avito.android.items.InputItem
        @Nullable
        public String getPlaceholder() {
            return this.o;
        }

        @Override // com.avito.android.items.InputItem
        @Nullable
        public String getPostfix() {
            return this.j;
        }

        @Override // com.avito.android.items.InputItem
        @Nullable
        public String getPrefix() {
            return this.i;
        }

        @Override // com.avito.android.items.ItemWithState
        @NotNull
        public ItemWithState.State getState() {
            return this.q;
        }

        @Override // com.avito.android.items.InputItem
        @NotNull
        public String getTitle() {
            return this.c;
        }

        @Override // com.avito.android.items.InputItem, com.avito.android.items.BasicInputItem
        @Nullable
        public String getValue() {
            return this.d;
        }

        public int hashCode() {
            String str = this.b;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String title = getTitle();
            int hashCode2 = (hashCode + (title != null ? title.hashCode() : 0)) * 31;
            String value = getValue();
            int hashCode3 = (hashCode2 + (value != null ? value.hashCode() : 0)) * 31;
            String error = getError();
            int hashCode4 = (hashCode3 + (error != null ? error.hashCode() : 0)) * 31;
            String bubbleError = getBubbleError();
            int lines = (getLines() + ((getAndroidSdkInputType() + ((hashCode4 + (bubbleError != null ? bubbleError.hashCode() : 0)) * 31)) * 31)) * 31;
            String prefix = getPrefix();
            int hashCode5 = (lines + (prefix != null ? prefix.hashCode() : 0)) * 31;
            String postfix = getPostfix();
            int hashCode6 = (hashCode5 + (postfix != null ? postfix.hashCode() : 0)) * 31;
            Integer labelMode = getLabelMode();
            int hashCode7 = (hashCode6 + (labelMode != null ? labelMode.hashCode() : 0)) * 31;
            Format format = this.l;
            int hashCode8 = (hashCode7 + (format != null ? format.hashCode() : 0)) * 31;
            ItemWithAdditionalButton.AdditionalButton additionalButton = getAdditionalButton();
            int hashCode9 = (hashCode8 + (additionalButton != null ? additionalButton.hashCode() : 0)) * 31;
            DisplayingOptions displayingOptions = getDisplayingOptions();
            int hashCode10 = (hashCode9 + (displayingOptions != null ? displayingOptions.hashCode() : 0)) * 31;
            String placeholder = getPlaceholder();
            int hashCode11 = (hashCode10 + (placeholder != null ? placeholder.hashCode() : 0)) * 31;
            AttributedText motivation = getMotivation();
            int hashCode12 = (hashCode11 + (motivation != null ? motivation.hashCode() : 0)) * 31;
            ItemWithState.State state = getState();
            int hashCode13 = (hashCode12 + (state != null ? state.hashCode() : 0)) * 31;
            FormatterType inputType = getInputType();
            int hashCode14 = (hashCode13 + (inputType != null ? inputType.hashCode() : 0)) * 31;
            boolean hideTitle = getHideTitle();
            if (hideTitle) {
                hideTitle = true;
            }
            int i3 = hideTitle ? 1 : 0;
            int i4 = hideTitle ? 1 : 0;
            int i5 = hideTitle ? 1 : 0;
            int i6 = (hashCode14 + i3) * 31;
            MutableHtmlNode htmlRootNode = getHtmlRootNode();
            if (htmlRootNode != null) {
                i2 = htmlRootNode.hashCode();
            }
            return i6 + i2;
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void setBubbleError(@Nullable String str) {
            this.f = str;
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void setError(@Nullable String str) {
            this.e = str;
        }

        @Override // com.avito.android.items.ItemWithHtmlSupport
        public void setHtmlRootNode(@Nullable MutableHtmlNode mutableHtmlNode) {
            this.t = mutableHtmlNode;
        }

        public void setInputType(@NotNull FormatterType formatterType) {
            Intrinsics.checkNotNullParameter(formatterType, "<set-?>");
            this.r = formatterType;
        }

        @Override // com.avito.android.items.ItemWithState
        public void setState(@NotNull ItemWithState.State state) {
            Intrinsics.checkNotNullParameter(state, "<set-?>");
            this.q = state;
        }

        @Override // com.avito.android.items.InputItem, com.avito.android.items.BasicInputItem
        public void setValue(@Nullable String str) {
            this.d = str;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Input(itemId=");
            L.append(this.b);
            L.append(", title=");
            L.append(getTitle());
            L.append(", value=");
            L.append(getValue());
            L.append(", error=");
            L.append(getError());
            L.append(", bubbleError=");
            L.append(getBubbleError());
            L.append(", androidSdkInputType=");
            L.append(getAndroidSdkInputType());
            L.append(", lines=");
            L.append(getLines());
            L.append(", prefix=");
            L.append(getPrefix());
            L.append(", postfix=");
            L.append(getPostfix());
            L.append(", labelMode=");
            L.append(getLabelMode());
            L.append(", format=");
            L.append(this.l);
            L.append(", additionalButton=");
            L.append(getAdditionalButton());
            L.append(", displayingOptions=");
            L.append(getDisplayingOptions());
            L.append(", placeholder=");
            L.append(getPlaceholder());
            L.append(", motivation=");
            L.append(getMotivation());
            L.append(", state=");
            L.append(getState());
            L.append(", inputType=");
            L.append(getInputType());
            L.append(", hideTitle=");
            L.append(getHideTitle());
            L.append(", htmlRootNode=");
            L.append(getHtmlRootNode());
            L.append(")");
            return L.toString();
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Input(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, int i2, int i3, @Nullable String str6, @Nullable String str7, @Nullable Integer num, @Nullable Format format, @Nullable ItemWithAdditionalButton.AdditionalButton additionalButton, @Nullable DisplayingOptions displayingOptions, @Nullable String str8, @Nullable AttributedText attributedText, @NotNull ItemWithState.State state, @NotNull FormatterType formatterType, boolean z, @Nullable MutableHtmlNode mutableHtmlNode) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "itemId");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(formatterType, "inputType");
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
            this.g = i2;
            this.h = i3;
            this.i = str6;
            this.j = str7;
            this.k = num;
            this.l = format;
            this.m = additionalButton;
            this.n = displayingOptions;
            this.o = str8;
            this.p = attributedText;
            this.q = state;
            this.r = formatterType;
            this.s = z;
            this.t = mutableHtmlNode;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001^BÅ\u0001\u0012\u0006\u0010[\u001a\u00020\u0012\u0012\u0006\u0010!\u001a\u00020\u0012\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012\u0012\f\u0010E\u001a\b\u0012\u0004\u0012\u00020@0?\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010K\u0012\u0010\b\u0002\u0010Z\u001a\n\u0012\u0004\u0012\u00020W\u0018\u00010?\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010T\u001a\u0004\u0018\u00010\u0012\u0012\b\u00108\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0006\u0012\b\b\u0002\u0010V\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u00101\u001a\u00020*\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u000109¢\u0006\u0004\b\\\u0010]J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\bJ\r\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\bJ\r\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\bJ\r\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\bR\u001c\u0010\u0011\u001a\u00020\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\bR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016R\u0019\u0010!\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010\u0016R$\u0010)\u001a\u0004\u0018\u00010\"8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u00101\u001a\u00020*8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001b\u00104\u001a\u0004\u0018\u00010\"8\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010$\u001a\u0004\b3\u0010&R$\u00108\u001a\u0004\u0018\u00010\u00128\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0014\u001a\u0004\b6\u0010\u0016\"\u0004\b7\u0010\u0018R\u001b\u0010>\u001a\u0004\u0018\u0001098\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001f\u0010E\u001a\b\u0012\u0004\u0012\u00020@0?8\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001b\u0010J\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u001b\u0010P\u001a\u0004\u0018\u00010K8\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR$\u0010T\u001a\u0004\u0018\u00010\u00128\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bQ\u0010\u0014\u001a\u0004\bR\u0010\u0016\"\u0004\bS\u0010\u0018R\u0019\u0010V\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\bU\u0010\u000f\u001a\u0004\bV\u0010\bR!\u0010Z\u001a\n\u0012\u0004\u0012\u00020W\u0018\u00010?8\u0006@\u0006¢\u0006\f\n\u0004\bX\u0010B\u001a\u0004\bY\u0010D¨\u0006_"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$Multiselect;", "Lcom/avito/android/category_parameters/ParameterElement;", "Lcom/avito/android/category_parameters/TitleHidingElement;", "Lcom/avito/android/items/ItemWithMotivation;", "Lcom/avito/android/items/ItemWithErrors;", "Lcom/avito/android/items/ItemWithState;", "", "isInline", "()Z", "isDialog", "isGroupSelect", "isRemovableOnly", "isChips", "isBottomSheet", "o", "Z", "getHideTitle", "hideTitle", "", "c", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "value", "k", "isEnabled", AuthSource.OPEN_CHANNEL_LIST, "getPlaceholder", InternalConstsKt.PLACEHOLDER, AuthSource.BOOKING_ORDER, "getTitle", "title", "Lcom/avito/android/remote/model/text/AttributedText;", "e", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "()Lcom/avito/android/remote/model/text/AttributedText;", "setMotivation", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "motivation", "Lcom/avito/android/items/ItemWithState$State;", "n", "Lcom/avito/android/items/ItemWithState$State;", "getState", "()Lcom/avito/android/items/ItemWithState$State;", "setState", "(Lcom/avito/android/items/ItemWithState$State;)V", "state", "p", "getSubtitle", MessengerShareContentUtility.SUBTITLE, "j", "getError", "setError", "error", "", VKApiConst.Q, "Ljava/lang/Integer;", "getMaxSelected", "()Ljava/lang/Integer;", "maxSelected", "", "Lcom/avito/android/items/SelectableItem;", "d", "Ljava/util/List;", "getValues", "()Ljava/util/List;", ResidentialComplexModuleKt.VALUES, "h", "Ljava/lang/Boolean;", "getAreGroupsCollapsible", "()Ljava/lang/Boolean;", "areGroupsCollapsible", "Lcom/avito/android/category_parameters/ParameterElement$DisplayType;", "f", "Lcom/avito/android/category_parameters/ParameterElement$DisplayType;", "getDisplayType", "()Lcom/avito/android/category_parameters/ParameterElement$DisplayType;", "displayType", "i", "getBubbleError", "setBubbleError", "bubbleError", "l", "isRequired", "Lcom/avito/android/category_parameters/ParameterElement$Multiselect$SelectableGroup;", g.a, "getGroups", "groups", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/category_parameters/ParameterElement$DisplayType;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Lcom/avito/android/items/ItemWithState$State;ZLcom/avito/android/remote/model/text/AttributedText;Ljava/lang/Integer;)V", "SelectableGroup", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public static final class Multiselect extends ParameterElement implements TitleHidingElement, ItemWithMotivation, ItemWithErrors, ItemWithState {
        @NotNull
        public final String b;
        @Nullable
        public String c;
        @NotNull
        public final List<SelectableItem> d;
        @Nullable
        public AttributedText e;
        @Nullable
        public final DisplayType f;
        @Nullable
        public final List<SelectableGroup> g;
        @Nullable
        public final Boolean h;
        @Nullable
        public String i;
        @Nullable
        public String j;
        public final boolean k;
        public final boolean l;
        @Nullable
        public final String m;
        @NotNull
        public ItemWithState.State n;
        public final boolean o;
        @Nullable
        public final AttributedText p;
        @Nullable
        public final Integer q;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$Multiselect$SelectableGroup;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "", "Lcom/avito/android/items/SelectableItem;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getItems", "()Ljava/util/List;", "items", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
        public static final class SelectableGroup {
            @Nullable
            public final String a;
            @NotNull
            public final List<SelectableItem> b;

            public SelectableGroup(@Nullable String str, @NotNull List<SelectableItem> list) {
                Intrinsics.checkNotNullParameter(list, "items");
                this.a = str;
                this.b = list;
            }

            @NotNull
            public final List<SelectableItem> getItems() {
                return this.b;
            }

            @Nullable
            public final String getTitle() {
                return this.a;
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Multiselect(String str, String str2, String str3, List list, AttributedText attributedText, DisplayType displayType, List list2, Boolean bool, String str4, String str5, boolean z, boolean z2, String str6, ItemWithState.State state, boolean z3, AttributedText attributedText2, Integer num, int i2, j jVar) {
            this(str, str2, str3, list, (i2 & 16) != 0 ? null : attributedText, (i2 & 32) != 0 ? null : displayType, (i2 & 64) != 0 ? null : list2, (i2 & 128) != 0 ? Boolean.FALSE : bool, str4, str5, (i2 & 1024) != 0 ? true : z, (i2 & 2048) != 0 ? false : z2, (i2 & 4096) != 0 ? null : str6, (i2 & 8192) != 0 ? new ItemWithState.State.Normal(null, 1, null) : state, (i2 & 16384) != 0 ? false : z3, (32768 & i2) != 0 ? null : attributedText2, (i2 & 65536) != 0 ? null : num);
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void clearErrors() {
            ItemWithErrors.DefaultImpls.clearErrors(this);
        }

        @Nullable
        public final Boolean getAreGroupsCollapsible() {
            return this.h;
        }

        @Override // com.avito.android.items.ItemWithErrors
        @Nullable
        public String getBubbleError() {
            return this.i;
        }

        @Nullable
        public final DisplayType getDisplayType() {
            return this.f;
        }

        @Override // com.avito.android.items.ItemWithErrors
        @Nullable
        public String getError() {
            return this.j;
        }

        @Nullable
        public final List<SelectableGroup> getGroups() {
            return this.g;
        }

        @Override // com.avito.android.category_parameters.TitleHidingElement
        public boolean getHideTitle() {
            return this.o;
        }

        @Nullable
        public final Integer getMaxSelected() {
            return this.q;
        }

        @Override // com.avito.android.items.ItemWithMotivation
        @Nullable
        public AttributedText getMotivation() {
            return this.e;
        }

        @Nullable
        public final String getPlaceholder() {
            return this.m;
        }

        @Override // com.avito.android.items.ItemWithState
        @NotNull
        public ItemWithState.State getState() {
            return this.n;
        }

        @Nullable
        public final AttributedText getSubtitle() {
            return this.p;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }

        @Nullable
        public final String getValue() {
            return this.c;
        }

        @NotNull
        public final List<SelectableItem> getValues() {
            return this.d;
        }

        public final boolean isBottomSheet() {
            return this.f instanceof DisplayType.BottomSheet;
        }

        public final boolean isChips() {
            return this.f instanceof DisplayType.Chips;
        }

        public final boolean isDialog() {
            return this.f instanceof DisplayType.Dialog;
        }

        public final boolean isEnabled() {
            return this.k;
        }

        public final boolean isGroupSelect() {
            return this.f instanceof DisplayType.GroupSelect;
        }

        public final boolean isInline() {
            return this.f instanceof DisplayType.Inlined;
        }

        public final boolean isRemovableOnly() {
            return this.f instanceof DisplayType.RemovableOnly;
        }

        public final boolean isRequired() {
            return this.l;
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void setBubbleError(@Nullable String str) {
            this.i = str;
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void setError(@Nullable String str) {
            this.j = str;
        }

        public void setMotivation(@Nullable AttributedText attributedText) {
            this.e = attributedText;
        }

        @Override // com.avito.android.items.ItemWithState
        public void setState(@NotNull ItemWithState.State state) {
            Intrinsics.checkNotNullParameter(state, "<set-?>");
            this.n = state;
        }

        public final void setValue(@Nullable String str) {
            this.c = str;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Multiselect(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull List<SelectableItem> list, @Nullable AttributedText attributedText, @Nullable DisplayType displayType, @Nullable List<SelectableGroup> list2, @Nullable Boolean bool, @Nullable String str4, @Nullable String str5, boolean z, boolean z2, @Nullable String str6, @NotNull ItemWithState.State state, boolean z3, @Nullable AttributedText attributedText2, @Nullable Integer num) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(list, ResidentialComplexModuleKt.VALUES);
            Intrinsics.checkNotNullParameter(state, "state");
            this.b = str2;
            this.c = str3;
            this.d = list;
            this.e = attributedText;
            this.f = displayType;
            this.g = list2;
            this.h = bool;
            this.i = str4;
            this.j = str5;
            this.k = z;
            this.l = z2;
            this.m = str6;
            this.n = state;
            this.o = z3;
            this.p = attributedText2;
            this.q = num;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b#\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001IB_\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000b\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\bG\u0010HJ\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0011\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0015\u0010\bJt\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00122\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b!\u0010\bJ\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010(\u001a\u00020'2\b\u0010&\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b(\u0010)R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u0010R\u0016\u0010\u0016\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010.\u001a\u0004\b0\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b1\u0010.\u001a\u0004\b2\u0010\b\"\u0004\b3\u00104R$\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b5\u0010.\u001a\u0004\b6\u0010\b\"\u0004\b7\u00104R\u0019\u0010\u0017\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010.\u001a\u0004\b9\u0010\bR$\u0010\u001e\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b:\u0010.\u001a\u0004\b;\u0010\b\"\u0004\b<\u00104R\"\u0010\u001d\u001a\u00020\u00128\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010\u0014\"\u0004\b@\u0010AR\"\u0010\u001a\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010\r\"\u0004\bE\u0010F¨\u0006J"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$Video;", "Lcom/avito/android/category_parameters/ParameterElement;", "Lcom/avito/android/items/BasicInputItem;", "Lcom/avito/android/items/ItemWithState;", "Lcom/avito/android/items/ItemWithErrors;", "Lcom/avito/android/items/ItemWithAdditionalButton;", "", "component2", "()Ljava/lang/String;", "component3", "component4", "Lcom/avito/android/category_parameters/ParameterElement$Video$PreviewState;", "component5", "()Lcom/avito/android/category_parameters/ParameterElement$Video$PreviewState;", "Lcom/avito/android/items/ItemWithAdditionalButton$AdditionalButton;", "component6", "()Lcom/avito/android/items/ItemWithAdditionalButton$AdditionalButton;", "component7", "Lcom/avito/android/items/ItemWithState$State;", "component8", "()Lcom/avito/android/items/ItemWithState$State;", "component9", "itemId", "title", InternalConstsKt.PLACEHOLDER, "error", "previewState", "additionalButton", "value", "state", "bubbleError", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/category_parameters/ParameterElement$Video$PreviewState;Lcom/avito/android/items/ItemWithAdditionalButton$AdditionalButton;Ljava/lang/String;Lcom/avito/android/items/ItemWithState$State;Ljava/lang/String;)Lcom/avito/android/category_parameters/ParameterElement$Video;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", g.a, "Lcom/avito/android/items/ItemWithAdditionalButton$AdditionalButton;", "getAdditionalButton", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "d", "getPlaceholder", "e", "getError", "setError", "(Ljava/lang/String;)V", "h", "getValue", "setValue", "c", "getTitle", "j", "getBubbleError", "setBubbleError", "i", "Lcom/avito/android/items/ItemWithState$State;", "getState", "setState", "(Lcom/avito/android/items/ItemWithState$State;)V", "f", "Lcom/avito/android/category_parameters/ParameterElement$Video$PreviewState;", "getPreviewState", "setPreviewState", "(Lcom/avito/android/category_parameters/ParameterElement$Video$PreviewState;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/category_parameters/ParameterElement$Video$PreviewState;Lcom/avito/android/items/ItemWithAdditionalButton$AdditionalButton;Ljava/lang/String;Lcom/avito/android/items/ItemWithState$State;Ljava/lang/String;)V", "PreviewState", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public static final class Video extends ParameterElement implements BasicInputItem, ItemWithState, ItemWithErrors, ItemWithAdditionalButton {
        public final String b;
        @NotNull
        public final String c;
        @Nullable
        public final String d;
        @Nullable
        public String e;
        @NotNull
        public PreviewState f;
        @Nullable
        public final ItemWithAdditionalButton.AdditionalButton g;
        @Nullable
        public String h;
        @NotNull
        public ItemWithState.State i;
        @Nullable
        public String j;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$Video$PreviewState;", "", "<init>", "()V", "Content", "Empty", "Error", "Loading", "Lcom/avito/android/category_parameters/ParameterElement$Video$PreviewState$Empty;", "Lcom/avito/android/category_parameters/ParameterElement$Video$PreviewState$Loading;", "Lcom/avito/android/category_parameters/ParameterElement$Video$PreviewState$Error;", "Lcom/avito/android/category_parameters/ParameterElement$Video$PreviewState$Content;", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class PreviewState {

            @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\nR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0007¨\u0006$"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$Video$PreviewState$Content;", "Lcom/avito/android/category_parameters/ParameterElement$Video$PreviewState;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Image;", "component2", "()Lcom/avito/android/remote/model/Image;", "Landroid/net/Uri;", "component3", "()Landroid/net/Uri;", "title", "image", ShareConstants.MEDIA_URI, "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/Image;Landroid/net/Uri;)Lcom/avito/android/category_parameters/ParameterElement$Video$PreviewState$Content;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "c", "Landroid/net/Uri;", "getUri", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/Image;", "getImage", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Image;Landroid/net/Uri;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
            public static final class Content extends PreviewState {
                @NotNull
                public final String a;
                @Nullable
                public final Image b;
                @NotNull
                public final Uri c;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Content(@NotNull String str, @Nullable Image image, @NotNull Uri uri) {
                    super(null);
                    Intrinsics.checkNotNullParameter(str, "title");
                    Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
                    this.a = str;
                    this.b = image;
                    this.c = uri;
                }

                public static /* synthetic */ Content copy$default(Content content, String str, Image image, Uri uri, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = content.a;
                    }
                    if ((i & 2) != 0) {
                        image = content.b;
                    }
                    if ((i & 4) != 0) {
                        uri = content.c;
                    }
                    return content.copy(str, image, uri);
                }

                @NotNull
                public final String component1() {
                    return this.a;
                }

                @Nullable
                public final Image component2() {
                    return this.b;
                }

                @NotNull
                public final Uri component3() {
                    return this.c;
                }

                @NotNull
                public final Content copy(@NotNull String str, @Nullable Image image, @NotNull Uri uri) {
                    Intrinsics.checkNotNullParameter(str, "title");
                    Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
                    return new Content(str, image, uri);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof Content)) {
                        return false;
                    }
                    Content content = (Content) obj;
                    return Intrinsics.areEqual(this.a, content.a) && Intrinsics.areEqual(this.b, content.b) && Intrinsics.areEqual(this.c, content.c);
                }

                @Nullable
                public final Image getImage() {
                    return this.b;
                }

                @NotNull
                public final String getTitle() {
                    return this.a;
                }

                @NotNull
                public final Uri getUri() {
                    return this.c;
                }

                public int hashCode() {
                    String str = this.a;
                    int i = 0;
                    int hashCode = (str != null ? str.hashCode() : 0) * 31;
                    Image image = this.b;
                    int hashCode2 = (hashCode + (image != null ? image.hashCode() : 0)) * 31;
                    Uri uri = this.c;
                    if (uri != null) {
                        i = uri.hashCode();
                    }
                    return hashCode2 + i;
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("Content(title=");
                    L.append(this.a);
                    L.append(", image=");
                    L.append(this.b);
                    L.append(", uri=");
                    L.append(this.c);
                    L.append(")");
                    return L.toString();
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$Video$PreviewState$Empty;", "Lcom/avito/android/category_parameters/ParameterElement$Video$PreviewState;", "<init>", "()V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
            public static final class Empty extends PreviewState {
                @NotNull
                public static final Empty INSTANCE = new Empty();

                public Empty() {
                    super(null);
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$Video$PreviewState$Error;", "Lcom/avito/android/category_parameters/ParameterElement$Video$PreviewState;", "", "component1", "()Ljava/lang/String;", "message", "copy", "(Ljava/lang/String;)Lcom/avito/android/category_parameters/ParameterElement$Video$PreviewState$Error;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "<init>", "(Ljava/lang/String;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
            public static final class Error extends PreviewState {
                @NotNull
                public final String a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Error(@NotNull String str) {
                    super(null);
                    Intrinsics.checkNotNullParameter(str, "message");
                    this.a = str;
                }

                public static /* synthetic */ Error copy$default(Error error, String str, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = error.a;
                    }
                    return error.copy(str);
                }

                @NotNull
                public final String component1() {
                    return this.a;
                }

                @NotNull
                public final Error copy(@NotNull String str) {
                    Intrinsics.checkNotNullParameter(str, "message");
                    return new Error(str);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this != obj) {
                        return (obj instanceof Error) && Intrinsics.areEqual(this.a, ((Error) obj).a);
                    }
                    return true;
                }

                @NotNull
                public final String getMessage() {
                    return this.a;
                }

                public int hashCode() {
                    String str = this.a;
                    if (str != null) {
                        return str.hashCode();
                    }
                    return 0;
                }

                @NotNull
                public String toString() {
                    return a.t(a.L("Error(message="), this.a, ")");
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/category_parameters/ParameterElement$Video$PreviewState$Loading;", "Lcom/avito/android/category_parameters/ParameterElement$Video$PreviewState;", "<init>", "()V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
            public static final class Loading extends PreviewState {
                @NotNull
                public static final Loading INSTANCE = new Loading();

                public Loading() {
                    super(null);
                }
            }

            public PreviewState() {
            }

            public PreviewState(j jVar) {
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Video(String str, String str2, String str3, String str4, PreviewState previewState, ItemWithAdditionalButton.AdditionalButton additionalButton, String str5, ItemWithState.State state, String str6, int i2, j jVar) {
            this(str, str2, str3, str4, (i2 & 16) != 0 ? PreviewState.Empty.INSTANCE : previewState, additionalButton, str5, (i2 & 128) != 0 ? new ItemWithState.State.Normal(null, 1, null) : state, (i2 & 256) != 0 ? null : str6);
        }

        public static /* synthetic */ Video copy$default(Video video, String str, String str2, String str3, String str4, PreviewState previewState, ItemWithAdditionalButton.AdditionalButton additionalButton, String str5, ItemWithState.State state, String str6, int i2, Object obj) {
            return video.copy((i2 & 1) != 0 ? video.b : str, (i2 & 2) != 0 ? video.c : str2, (i2 & 4) != 0 ? video.d : str3, (i2 & 8) != 0 ? video.getError() : str4, (i2 & 16) != 0 ? video.f : previewState, (i2 & 32) != 0 ? video.getAdditionalButton() : additionalButton, (i2 & 64) != 0 ? video.getValue() : str5, (i2 & 128) != 0 ? video.getState() : state, (i2 & 256) != 0 ? video.getBubbleError() : str6);
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void clearErrors() {
            ItemWithErrors.DefaultImpls.clearErrors(this);
        }

        @NotNull
        public final String component2() {
            return this.c;
        }

        @Nullable
        public final String component3() {
            return this.d;
        }

        @Nullable
        public final String component4() {
            return getError();
        }

        @NotNull
        public final PreviewState component5() {
            return this.f;
        }

        @Nullable
        public final ItemWithAdditionalButton.AdditionalButton component6() {
            return getAdditionalButton();
        }

        @Nullable
        public final String component7() {
            return getValue();
        }

        @NotNull
        public final ItemWithState.State component8() {
            return getState();
        }

        @Nullable
        public final String component9() {
            return getBubbleError();
        }

        @NotNull
        public final Video copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @NotNull PreviewState previewState, @Nullable ItemWithAdditionalButton.AdditionalButton additionalButton, @Nullable String str5, @NotNull ItemWithState.State state, @Nullable String str6) {
            Intrinsics.checkNotNullParameter(str, "itemId");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(previewState, "previewState");
            Intrinsics.checkNotNullParameter(state, "state");
            return new Video(str, str2, str3, str4, previewState, additionalButton, str5, state, str6);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Video)) {
                return false;
            }
            Video video = (Video) obj;
            return Intrinsics.areEqual(this.b, video.b) && Intrinsics.areEqual(this.c, video.c) && Intrinsics.areEqual(this.d, video.d) && Intrinsics.areEqual(getError(), video.getError()) && Intrinsics.areEqual(this.f, video.f) && Intrinsics.areEqual(getAdditionalButton(), video.getAdditionalButton()) && Intrinsics.areEqual(getValue(), video.getValue()) && Intrinsics.areEqual(getState(), video.getState()) && Intrinsics.areEqual(getBubbleError(), video.getBubbleError());
        }

        @Override // com.avito.android.items.ItemWithAdditionalButton
        @Nullable
        public ItemWithAdditionalButton.AdditionalButton getAdditionalButton() {
            return this.g;
        }

        @Override // com.avito.android.items.ItemWithErrors
        @Nullable
        public String getBubbleError() {
            return this.j;
        }

        @Override // com.avito.android.items.ItemWithErrors
        @Nullable
        public String getError() {
            return this.e;
        }

        @Nullable
        public final String getPlaceholder() {
            return this.d;
        }

        @NotNull
        public final PreviewState getPreviewState() {
            return this.f;
        }

        @Override // com.avito.android.items.ItemWithState
        @NotNull
        public ItemWithState.State getState() {
            return this.i;
        }

        @NotNull
        public final String getTitle() {
            return this.c;
        }

        @Override // com.avito.android.items.BasicInputItem
        @Nullable
        public String getValue() {
            return this.h;
        }

        public int hashCode() {
            String str = this.b;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.c;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.d;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String error = getError();
            int hashCode4 = (hashCode3 + (error != null ? error.hashCode() : 0)) * 31;
            PreviewState previewState = this.f;
            int hashCode5 = (hashCode4 + (previewState != null ? previewState.hashCode() : 0)) * 31;
            ItemWithAdditionalButton.AdditionalButton additionalButton = getAdditionalButton();
            int hashCode6 = (hashCode5 + (additionalButton != null ? additionalButton.hashCode() : 0)) * 31;
            String value = getValue();
            int hashCode7 = (hashCode6 + (value != null ? value.hashCode() : 0)) * 31;
            ItemWithState.State state = getState();
            int hashCode8 = (hashCode7 + (state != null ? state.hashCode() : 0)) * 31;
            String bubbleError = getBubbleError();
            if (bubbleError != null) {
                i2 = bubbleError.hashCode();
            }
            return hashCode8 + i2;
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void setBubbleError(@Nullable String str) {
            this.j = str;
        }

        @Override // com.avito.android.items.ItemWithErrors
        public void setError(@Nullable String str) {
            this.e = str;
        }

        public final void setPreviewState(@NotNull PreviewState previewState) {
            Intrinsics.checkNotNullParameter(previewState, "<set-?>");
            this.f = previewState;
        }

        @Override // com.avito.android.items.ItemWithState
        public void setState(@NotNull ItemWithState.State state) {
            Intrinsics.checkNotNullParameter(state, "<set-?>");
            this.i = state;
        }

        @Override // com.avito.android.items.BasicInputItem
        public void setValue(@Nullable String str) {
            this.h = str;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Video(itemId=");
            L.append(this.b);
            L.append(", title=");
            L.append(this.c);
            L.append(", placeholder=");
            L.append(this.d);
            L.append(", error=");
            L.append(getError());
            L.append(", previewState=");
            L.append(this.f);
            L.append(", additionalButton=");
            L.append(getAdditionalButton());
            L.append(", value=");
            L.append(getValue());
            L.append(", state=");
            L.append(getState());
            L.append(", bubbleError=");
            L.append(getBubbleError());
            L.append(")");
            return L.toString();
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Video(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @NotNull PreviewState previewState, @Nullable ItemWithAdditionalButton.AdditionalButton additionalButton, @Nullable String str5, @NotNull ItemWithState.State state, @Nullable String str6) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "itemId");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(previewState, "previewState");
            Intrinsics.checkNotNullParameter(state, "state");
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = previewState;
            this.g = additionalButton;
            this.h = str5;
            this.i = state;
            this.j = str6;
        }
    }
}
