package com.avito.android.remote.model.category_parameters;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.parse.adapter.WizardConfigTypeAdapter;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\"#$%&'(B\t\b\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0004R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0004R\u0016\u0010\u0012\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0004R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0004R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0004R\u0016\u0010\u001d\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0004\u0001\u0007)*+,-./¨\u00060"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep;", "Landroid/os/Parcelable;", "", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "getTitle", "title", "getShortTitle", "shortTitle", "getType", "type", "", "getFields", "()Ljava/util/List;", "fields", "getSubtitle", MessengerShareContentUtility.SUBTITLE, "getSubtype", "subtype", "getSkipOnBackwards", "()Z", "skipOnBackwards", "getId", "id", "<init>", "()V", "Params", "Premoderation", "Request", "Select", "SuggestCategory", "Vin", "Wizard", "Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep$Wizard;", "Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep$Params;", "Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep$Select;", "Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep$Vin;", "Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep$Premoderation;", "Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep$SuggestCategory;", "Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep$Request;", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class CategoryPublishStep implements Parcelable {

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001:\u0002+,BW\u0012\u0006\u0010'\u001a\u00020\u000b\u0012\b\u0010#\u001a\u0004\u0018\u00010\u000b\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00108\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u00020\u00158\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000fR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u000fR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001e\u0010#\u001a\u0004\u0018\u00010\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b#\u0010\r\u001a\u0004\b$\u0010\u000fR\u0016\u0010&\u001a\u00020\u000b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u000fR\u001c\u0010'\u001a\u00020\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b'\u0010\r\u001a\u0004\b(\u0010\u000f¨\u0006-"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep$Params;", "Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "fields", "Ljava/util/List;", "getFields", "()Ljava/util/List;", "", "skipOnBackwards", "Z", "getSkipOnBackwards", "()Z", "shortTitle", "getShortTitle", MessengerShareContentUtility.SUBTITLE, "getSubtitle", "Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep$Params$Config;", Navigation.CONFIG, "Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep$Params$Config;", "getConfig", "()Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep$Params$Config;", "subtype", "getSubtype", "getType", "type", "id", "getId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/avito/android/remote/model/category_parameters/CategoryPublishStep$Params$Config;)V", "Config", "HeaderStyle", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Params extends CategoryPublishStep {
        public static final Parcelable.Creator<Params> CREATOR = new Creator();
        @SerializedName(Navigation.CONFIG)
        @Nullable
        private final Config config;
        @SerializedName("fields")
        @NotNull
        private final List<String> fields;
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName("shortTitle")
        @Nullable
        private final String shortTitle;
        @SerializedName("skipOnBackwards")
        private final boolean skipOnBackwards;
        @SerializedName(MessengerShareContentUtility.SUBTITLE)
        @Nullable
        private final String subtitle;
        @SerializedName("subtype")
        @Nullable
        private final String subtype;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u000f\u0010\u000eR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep$Params$Config;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "isContinueButtonHidden", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "isCloseButtonHidden", "Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep$Params$HeaderStyle;", "headerStyle", "Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep$Params$HeaderStyle;", "getHeaderStyle", "()Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep$Params$HeaderStyle;", "", "backButtonStyle", "Ljava/lang/String;", "getBackButtonStyle", "()Ljava/lang/String;", "continueTitle", "getContinueTitle", "<init>", "(Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep$Params$HeaderStyle;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Config implements Parcelable {
            public static final Parcelable.Creator<Config> CREATOR = new Creator();
            @SerializedName("backButtonStyle")
            @Nullable
            private final String backButtonStyle;
            @SerializedName("continueTitle")
            @Nullable
            private final String continueTitle;
            @SerializedName("headerStyle")
            @Nullable
            private final HeaderStyle headerStyle;
            @SerializedName("isCloseButtonHidden")
            @Nullable
            private final Boolean isCloseButtonHidden;
            @SerializedName("isContinueButtonHidden")
            @Nullable
            private final Boolean isContinueButtonHidden;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Config> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Config createFromParcel(@NotNull Parcel parcel) {
                    Boolean bool;
                    Boolean bool2;
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    HeaderStyle headerStyle = parcel.readInt() != 0 ? (HeaderStyle) Enum.valueOf(HeaderStyle.class, parcel.readString()) : null;
                    String readString = parcel.readString();
                    boolean z = true;
                    if (parcel.readInt() != 0) {
                        bool = Boolean.valueOf(parcel.readInt() != 0);
                    } else {
                        bool = null;
                    }
                    if (parcel.readInt() != 0) {
                        if (parcel.readInt() == 0) {
                            z = false;
                        }
                        bool2 = Boolean.valueOf(z);
                    } else {
                        bool2 = null;
                    }
                    return new Config(headerStyle, readString, bool, bool2, parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Config[] newArray(int i) {
                    return new Config[i];
                }
            }

            public Config(@Nullable HeaderStyle headerStyle2, @Nullable String str, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str2) {
                this.headerStyle = headerStyle2;
                this.continueTitle = str;
                this.isContinueButtonHidden = bool;
                this.isCloseButtonHidden = bool2;
                this.backButtonStyle = str2;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Nullable
            public final String getBackButtonStyle() {
                return this.backButtonStyle;
            }

            @Nullable
            public final String getContinueTitle() {
                return this.continueTitle;
            }

            @Nullable
            public final HeaderStyle getHeaderStyle() {
                return this.headerStyle;
            }

            @Nullable
            public final Boolean isCloseButtonHidden() {
                return this.isCloseButtonHidden;
            }

            @Nullable
            public final Boolean isContinueButtonHidden() {
                return this.isContinueButtonHidden;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                HeaderStyle headerStyle2 = this.headerStyle;
                if (headerStyle2 != null) {
                    parcel.writeInt(1);
                    parcel.writeString(headerStyle2.name());
                } else {
                    parcel.writeInt(0);
                }
                parcel.writeString(this.continueTitle);
                Boolean bool = this.isContinueButtonHidden;
                if (bool != null) {
                    a.G0(parcel, 1, bool);
                } else {
                    parcel.writeInt(0);
                }
                Boolean bool2 = this.isCloseButtonHidden;
                if (bool2 != null) {
                    a.G0(parcel, 1, bool2);
                } else {
                    parcel.writeInt(0);
                }
                parcel.writeString(this.backButtonStyle);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Params> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Params createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Params(parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0 ? Config.CREATOR.createFromParcel(parcel) : null);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Params[] newArray(int i) {
                return new Params[i];
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep$Params$HeaderStyle;", "", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "(Ljava/lang/String;I)V", "COMPACT", "models_release"}, k = 1, mv = {1, 4, 2})
        public enum HeaderStyle implements Parcelable {
            COMPACT;
            
            public static final Parcelable.Creator<HeaderStyle> CREATOR = new Creator();

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<HeaderStyle> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final HeaderStyle createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return (HeaderStyle) Enum.valueOf(HeaderStyle.class, parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final HeaderStyle[] newArray(int i) {
                    return new HeaderStyle[i];
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(name());
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Params(String str, String str2, List list, String str3, String str4, String str5, boolean z, Config config2, int i, j jVar) {
            this(str, str2, list, str3, (i & 16) != 0 ? null : str4, str5, z, config2);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final Config getConfig() {
            return this.config;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @NotNull
        public List<String> getFields() {
            return this.fields;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @NotNull
        public String getId() {
            return this.id;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @Nullable
        public String getShortTitle() {
            return this.shortTitle;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        public boolean getSkipOnBackwards() {
            return this.skipOnBackwards;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @Nullable
        public String getSubtitle() {
            return this.subtitle;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @Nullable
        public String getSubtype() {
            return this.subtype;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @NotNull
        public String getTitle() {
            return this.title;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @NotNull
        public String getType() {
            return "params";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.id);
            parcel.writeString(this.subtype);
            parcel.writeStringList(this.fields);
            parcel.writeString(this.title);
            parcel.writeString(this.shortTitle);
            parcel.writeString(this.subtitle);
            parcel.writeInt(this.skipOnBackwards ? 1 : 0);
            Config config2 = this.config;
            if (config2 != null) {
                parcel.writeInt(1);
                config2.writeToParcel(parcel, 0);
                return;
            }
            parcel.writeInt(0);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Params(@NotNull String str, @Nullable String str2, @NotNull List<String> list, @NotNull String str3, @Nullable String str4, @Nullable String str5, boolean z, @Nullable Config config2) {
            super(null);
            a.d1(str, "id", list, "fields", str3, "title");
            this.id = str;
            this.subtype = str2;
            this.fields = list;
            this.title = str3;
            this.shortTitle = str4;
            this.subtitle = str5;
            this.skipOnBackwards = z;
            this.config = config2;
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\"\u001a\u00020\u000b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u000b\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010\u0012\u0006\u0010 \u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00108\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u000b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0018\u001a\u00020\u00178\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u000fR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000fR\u001c\u0010 \u001a\u00020\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b \u0010\r\u001a\u0004\b!\u0010\u000fR\u001c\u0010\"\u001a\u00020\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\"\u0010\r\u001a\u0004\b#\u0010\u000f¨\u0006&"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep$Premoderation;", "Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "shortTitle", "Ljava/lang/String;", "getShortTitle", "()Ljava/lang/String;", "", "fields", "Ljava/util/List;", "getFields", "()Ljava/util/List;", "getType", "type", "", "skipOnBackwards", "Z", "getSkipOnBackwards", "()Z", MessengerShareContentUtility.SUBTITLE, "getSubtitle", "subtype", "getSubtype", "title", "getTitle", "id", "getId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Premoderation extends CategoryPublishStep {
        public static final Parcelable.Creator<Premoderation> CREATOR = new Creator();
        @SerializedName("fields")
        @NotNull
        private final List<String> fields;
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName("shortTitle")
        @Nullable
        private final String shortTitle;
        @SerializedName("skipOnBackwards")
        private final boolean skipOnBackwards;
        @SerializedName(MessengerShareContentUtility.SUBTITLE)
        @Nullable
        private final String subtitle;
        @SerializedName("subtype")
        @Nullable
        private final String subtype;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Premoderation> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Premoderation createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Premoderation(parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Premoderation[] newArray(int i) {
                return new Premoderation[i];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Premoderation(String str, String str2, List list, String str3, String str4, String str5, boolean z, int i, j jVar) {
            this(str, str2, list, str3, (i & 16) != 0 ? null : str4, str5, z);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @NotNull
        public List<String> getFields() {
            return this.fields;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @NotNull
        public String getId() {
            return this.id;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @Nullable
        public String getShortTitle() {
            return this.shortTitle;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        public boolean getSkipOnBackwards() {
            return this.skipOnBackwards;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @Nullable
        public String getSubtitle() {
            return this.subtitle;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @Nullable
        public String getSubtype() {
            return this.subtype;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @NotNull
        public String getTitle() {
            return this.title;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @NotNull
        public String getType() {
            return "premoderation";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.id);
            parcel.writeString(this.subtype);
            parcel.writeStringList(this.fields);
            parcel.writeString(this.title);
            parcel.writeString(this.shortTitle);
            parcel.writeString(this.subtitle);
            parcel.writeInt(this.skipOnBackwards ? 1 : 0);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Premoderation(@NotNull String str, @Nullable String str2, @NotNull List<String> list, @NotNull String str3, @Nullable String str4, @Nullable String str5, boolean z) {
            super(null);
            a.d1(str, "id", list, "fields", str3, "title");
            this.id = str;
            this.subtype = str2;
            this.fields = list;
            this.title = str3;
            this.shortTitle = str4;
            this.subtitle = str5;
            this.skipOnBackwards = z;
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u001b\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001d\u0012\u0006\u0010\"\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\u00128\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u000b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000fR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u000fR\u001c\u0010\u001b\u001a\u00020\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000fR\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001d8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\"\u001a\u00020\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\"\u0010\r\u001a\u0004\b#\u0010\u000f¨\u0006&"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep$Request;", "Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", MessengerShareContentUtility.SUBTITLE, "Ljava/lang/String;", "getSubtitle", "()Ljava/lang/String;", "subtype", "getSubtype", "", "skipOnBackwards", "Z", "getSkipOnBackwards", "()Z", "getType", "type", "shortTitle", "getShortTitle", "id", "getId", "", "fields", "Ljava/util/List;", "getFields", "()Ljava/util/List;", "title", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Request extends CategoryPublishStep {
        public static final Parcelable.Creator<Request> CREATOR = new Creator();
        @SerializedName("fields")
        @NotNull
        private final List<String> fields;
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName("shortTitle")
        @Nullable
        private final String shortTitle;
        @SerializedName("skipOnBackwards")
        private final boolean skipOnBackwards;
        @SerializedName(MessengerShareContentUtility.SUBTITLE)
        @Nullable
        private final String subtitle;
        @SerializedName("subtype")
        @Nullable
        private final String subtype;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Request> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Request createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Request(parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Request[] newArray(int i) {
                return new Request[i];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Request(String str, String str2, List list, String str3, String str4, String str5, boolean z, int i, j jVar) {
            this(str, str2, list, str3, (i & 16) != 0 ? null : str4, str5, z);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @NotNull
        public List<String> getFields() {
            return this.fields;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @NotNull
        public String getId() {
            return this.id;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @Nullable
        public String getShortTitle() {
            return this.shortTitle;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        public boolean getSkipOnBackwards() {
            return this.skipOnBackwards;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @Nullable
        public String getSubtitle() {
            return this.subtitle;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @Nullable
        public String getSubtype() {
            return this.subtype;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @NotNull
        public String getTitle() {
            return this.title;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @NotNull
        public String getType() {
            return "request";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.id);
            parcel.writeString(this.subtype);
            parcel.writeStringList(this.fields);
            parcel.writeString(this.title);
            parcel.writeString(this.shortTitle);
            parcel.writeString(this.subtitle);
            parcel.writeInt(this.skipOnBackwards ? 1 : 0);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Request(@NotNull String str, @Nullable String str2, @NotNull List<String> list, @NotNull String str3, @Nullable String str4, @Nullable String str5, boolean z) {
            super(null);
            a.d1(str, "id", list, "fields", str3, "title");
            this.id = str;
            this.subtype = str2;
            this.fields = list;
            this.title = str3;
            this.shortTitle = str4;
            this.subtitle = str5;
            this.skipOnBackwards = z;
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\u001f\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000fR\u001c\u0010\u0017\u001a\u00020\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000fR\u0016\u0010\u001a\u001a\u00020\u000b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000fR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000fR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001e\u0010\u000fR\"\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\u001f8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep$Select;", "Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "skipOnBackwards", "Z", "getSkipOnBackwards", "()Z", MessengerShareContentUtility.SUBTITLE, "getSubtitle", "id", "getId", "getType", "type", "subtype", "getSubtype", "shortTitle", "getShortTitle", "", "fields", "Ljava/util/List;", "getFields", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Select extends CategoryPublishStep {
        public static final Parcelable.Creator<Select> CREATOR = new Creator();
        @SerializedName("fields")
        @NotNull
        private final List<String> fields;
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName("shortTitle")
        @Nullable
        private final String shortTitle;
        @SerializedName("skipOnBackwards")
        private final boolean skipOnBackwards;
        @SerializedName(MessengerShareContentUtility.SUBTITLE)
        @Nullable
        private final String subtitle;
        @SerializedName("subtype")
        @Nullable
        private final String subtype;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Select> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Select createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Select(parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Select[] newArray(int i) {
                return new Select[i];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Select(String str, String str2, List list, String str3, String str4, String str5, boolean z, int i, j jVar) {
            this(str, str2, list, str3, (i & 16) != 0 ? null : str4, str5, z);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @NotNull
        public List<String> getFields() {
            return this.fields;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @NotNull
        public String getId() {
            return this.id;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @Nullable
        public String getShortTitle() {
            return this.shortTitle;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        public boolean getSkipOnBackwards() {
            return this.skipOnBackwards;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @Nullable
        public String getSubtitle() {
            return this.subtitle;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @Nullable
        public String getSubtype() {
            return this.subtype;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @NotNull
        public String getTitle() {
            return this.title;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @NotNull
        public String getType() {
            return "select";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.id);
            parcel.writeString(this.subtype);
            parcel.writeStringList(this.fields);
            parcel.writeString(this.title);
            parcel.writeString(this.shortTitle);
            parcel.writeString(this.subtitle);
            parcel.writeInt(this.skipOnBackwards ? 1 : 0);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Select(@NotNull String str, @Nullable String str2, @NotNull List<String> list, @NotNull String str3, @Nullable String str4, @Nullable String str5, boolean z) {
            super(null);
            a.d1(str, "id", list, "fields", str3, "title");
            this.id = str;
            this.subtype = str2;
            this.fields = list;
            this.title = str3;
            this.shortTitle = str4;
            this.subtitle = str5;
            this.skipOnBackwards = z;
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u000b\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\u001f\u0012\u0006\u0010\u0019\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000fR\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0019\u001a\u00020\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u000fR\u0016\u0010\u001c\u001a\u00020\u000b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000fR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001e\u0010\u000fR\"\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\u001f8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep$SuggestCategory;", "Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "", "skipOnBackwards", "Z", "getSkipOnBackwards", "()Z", "shortTitle", "getShortTitle", MessengerShareContentUtility.SUBTITLE, "getSubtitle", "title", "getTitle", "getType", "type", "subtype", "getSubtype", "", "fields", "Ljava/util/List;", "getFields", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class SuggestCategory extends CategoryPublishStep {
        public static final Parcelable.Creator<SuggestCategory> CREATOR = new Creator();
        @SerializedName("fields")
        @NotNull
        private final List<String> fields;
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName("shortTitle")
        @Nullable
        private final String shortTitle;
        @SerializedName("skipOnBackwards")
        private final boolean skipOnBackwards;
        @SerializedName(MessengerShareContentUtility.SUBTITLE)
        @Nullable
        private final String subtitle;
        @SerializedName("subtype")
        @Nullable
        private final String subtype;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<SuggestCategory> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final SuggestCategory createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new SuggestCategory(parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final SuggestCategory[] newArray(int i) {
                return new SuggestCategory[i];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SuggestCategory(String str, String str2, List list, String str3, String str4, String str5, boolean z, int i, j jVar) {
            this(str, str2, list, str3, (i & 16) != 0 ? null : str4, str5, z);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @NotNull
        public List<String> getFields() {
            return this.fields;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @NotNull
        public String getId() {
            return this.id;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @Nullable
        public String getShortTitle() {
            return this.shortTitle;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        public boolean getSkipOnBackwards() {
            return this.skipOnBackwards;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @Nullable
        public String getSubtitle() {
            return this.subtitle;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @Nullable
        public String getSubtype() {
            return this.subtype;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @NotNull
        public String getTitle() {
            return this.title;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @NotNull
        public String getType() {
            return "suggestCategory";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.id);
            parcel.writeString(this.subtype);
            parcel.writeStringList(this.fields);
            parcel.writeString(this.title);
            parcel.writeString(this.shortTitle);
            parcel.writeString(this.subtitle);
            parcel.writeInt(this.skipOnBackwards ? 1 : 0);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SuggestCategory(@NotNull String str, @Nullable String str2, @NotNull List<String> list, @NotNull String str3, @Nullable String str4, @Nullable String str5, boolean z) {
            super(null);
            a.d1(str, "id", list, "fields", str3, "title");
            this.id = str;
            this.subtype = str2;
            this.fields = list;
            this.title = str3;
            this.shortTitle = str4;
            this.subtitle = str5;
            this.skipOnBackwards = z;
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010 \u001a\u00020\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014\u0012\u0006\u0010\"\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00148\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u00020\u00198\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u000b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u000fR\u001c\u0010 \u001a\u00020\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b \u0010\r\u001a\u0004\b!\u0010\u000fR\u001c\u0010\"\u001a\u00020\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\"\u0010\r\u001a\u0004\b#\u0010\u000f¨\u0006&"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep$Vin;", "Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "shortTitle", "Ljava/lang/String;", "getShortTitle", "()Ljava/lang/String;", MessengerShareContentUtility.SUBTITLE, "getSubtitle", "subtype", "getSubtype", "", "fields", "Ljava/util/List;", "getFields", "()Ljava/util/List;", "", "skipOnBackwards", "Z", "getSkipOnBackwards", "()Z", "getType", "type", "id", "getId", "title", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Vin extends CategoryPublishStep {
        public static final Parcelable.Creator<Vin> CREATOR = new Creator();
        @SerializedName("fields")
        @NotNull
        private final List<String> fields;
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName("shortTitle")
        @Nullable
        private final String shortTitle;
        @SerializedName("skipOnBackwards")
        private final boolean skipOnBackwards;
        @SerializedName(MessengerShareContentUtility.SUBTITLE)
        @Nullable
        private final String subtitle;
        @SerializedName("subtype")
        @Nullable
        private final String subtype;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Vin> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Vin createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Vin(parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Vin[] newArray(int i) {
                return new Vin[i];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Vin(String str, String str2, List list, String str3, String str4, String str5, boolean z, int i, j jVar) {
            this(str, str2, list, str3, (i & 16) != 0 ? null : str4, str5, z);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @NotNull
        public List<String> getFields() {
            return this.fields;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @NotNull
        public String getId() {
            return this.id;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @Nullable
        public String getShortTitle() {
            return this.shortTitle;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        public boolean getSkipOnBackwards() {
            return this.skipOnBackwards;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @Nullable
        public String getSubtitle() {
            return this.subtitle;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @Nullable
        public String getSubtype() {
            return this.subtype;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @NotNull
        public String getTitle() {
            return this.title;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @NotNull
        public String getType() {
            return "vin";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.id);
            parcel.writeString(this.subtype);
            parcel.writeStringList(this.fields);
            parcel.writeString(this.title);
            parcel.writeString(this.shortTitle);
            parcel.writeString(this.subtitle);
            parcel.writeInt(this.skipOnBackwards ? 1 : 0);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Vin(@NotNull String str, @Nullable String str2, @NotNull List<String> list, @NotNull String str3, @Nullable String str4, @Nullable String str5, boolean z) {
            super(null);
            a.d1(str, "id", list, "fields", str3, "title");
            this.id = str;
            this.subtype = str2;
            this.fields = list;
            this.title = str3;
            this.shortTitle = str4;
            this.subtitle = str5;
            this.skipOnBackwards = z;
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0001+BW\u0012\u0006\u0010\u001c\u001a\u00020\u000b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u000b\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0017\u0012\u0006\u0010'\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000fR\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00178\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u00020\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u000fR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000fR\u001e\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020\u000b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u000fR\u001c\u0010'\u001a\u00020\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b'\u0010\r\u001a\u0004\b(\u0010\u000f¨\u0006,"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep$Wizard;", "Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", MessengerShareContentUtility.SUBTITLE, "Ljava/lang/String;", "getSubtitle", "()Ljava/lang/String;", "", "skipOnBackwards", "Z", "getSkipOnBackwards", "()Z", "shortTitle", "getShortTitle", "", "fields", "Ljava/util/List;", "getFields", "()Ljava/util/List;", "id", "getId", "subtype", "getSubtype", "Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep$Wizard$Config;", Navigation.CONFIG, "Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep$Wizard$Config;", "getConfig", "()Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep$Wizard$Config;", "getType", "type", "title", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/avito/android/remote/model/category_parameters/CategoryPublishStep$Wizard$Config;)V", "Config", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Wizard extends CategoryPublishStep {
        public static final Parcelable.Creator<Wizard> CREATOR = new Creator();
        @SerializedName(Navigation.CONFIG)
        @JsonAdapter(WizardConfigTypeAdapter.class)
        @Nullable
        private final Config config;
        @SerializedName("fields")
        @NotNull
        private final List<String> fields;
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName("shortTitle")
        @Nullable
        private final String shortTitle;
        @SerializedName("skipOnBackwards")
        private final boolean skipOnBackwards;
        @SerializedName(MessengerShareContentUtility.SUBTITLE)
        @Nullable
        private final String subtitle;
        @SerializedName("subtype")
        @Nullable
        private final String subtype;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000b\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR!\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/CategoryPublishStep$Wizard$Config;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/Navigation;", "leaves", "Ljava/util/List;", "getLeaves", "()Ljava/util/List;", "", "leavesIds", "getLeavesIds", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Config implements Parcelable {
            public static final Parcelable.Creator<Config> CREATOR = new Creator();
            @Nullable
            private final List<Navigation> leaves;
            @Nullable
            private final List<String> leavesIds;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Config> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Config createFromParcel(@NotNull Parcel parcel) {
                    ArrayList arrayList;
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    ArrayList<String> createStringArrayList = parcel.createStringArrayList();
                    if (parcel.readInt() != 0) {
                        int readInt = parcel.readInt();
                        arrayList = new ArrayList(readInt);
                        while (readInt != 0) {
                            arrayList.add(Navigation.CREATOR.createFromParcel(parcel));
                            readInt--;
                        }
                    } else {
                        arrayList = null;
                    }
                    return new Config(createStringArrayList, arrayList);
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Config[] newArray(int i) {
                    return new Config[i];
                }
            }

            public Config(@Nullable List<String> list, @Nullable List<Navigation> list2) {
                this.leavesIds = list;
                this.leaves = list2;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Nullable
            public final List<Navigation> getLeaves() {
                return this.leaves;
            }

            @Nullable
            public final List<String> getLeavesIds() {
                return this.leavesIds;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeStringList(this.leavesIds);
                List<Navigation> list = this.leaves;
                if (list != null) {
                    Iterator l0 = a.l0(parcel, 1, list);
                    while (l0.hasNext()) {
                        ((Navigation) l0.next()).writeToParcel(parcel, 0);
                    }
                    return;
                }
                parcel.writeInt(0);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Wizard> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Wizard createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Wizard(parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0 ? Config.CREATOR.createFromParcel(parcel) : null);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Wizard[] newArray(int i) {
                return new Wizard[i];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Wizard(String str, String str2, List list, String str3, String str4, String str5, boolean z, Config config2, int i, j jVar) {
            this(str, str2, list, str3, (i & 16) != 0 ? null : str4, str5, z, config2);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final Config getConfig() {
            return this.config;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @NotNull
        public List<String> getFields() {
            return this.fields;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @NotNull
        public String getId() {
            return this.id;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @Nullable
        public String getShortTitle() {
            return this.shortTitle;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        public boolean getSkipOnBackwards() {
            return this.skipOnBackwards;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @Nullable
        public String getSubtitle() {
            return this.subtitle;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @Nullable
        public String getSubtype() {
            return this.subtype;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @NotNull
        public String getTitle() {
            return this.title;
        }

        @Override // com.avito.android.remote.model.category_parameters.CategoryPublishStep
        @NotNull
        public String getType() {
            return "wizard";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.id);
            parcel.writeString(this.subtype);
            parcel.writeStringList(this.fields);
            parcel.writeString(this.title);
            parcel.writeString(this.shortTitle);
            parcel.writeString(this.subtitle);
            parcel.writeInt(this.skipOnBackwards ? 1 : 0);
            Config config2 = this.config;
            if (config2 != null) {
                parcel.writeInt(1);
                config2.writeToParcel(parcel, 0);
                return;
            }
            parcel.writeInt(0);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Wizard(@NotNull String str, @Nullable String str2, @NotNull List<String> list, @NotNull String str3, @Nullable String str4, @Nullable String str5, boolean z, @Nullable Config config2) {
            super(null);
            a.d1(str, "id", list, "fields", str3, "title");
            this.id = str;
            this.subtype = str2;
            this.fields = list;
            this.title = str3;
            this.shortTitle = str4;
            this.subtitle = str5;
            this.skipOnBackwards = z;
            this.config = config2;
        }
    }

    private CategoryPublishStep() {
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        return this == obj || ((obj instanceof CategoryPublishStep) && Intrinsics.areEqual(getId(), ((CategoryPublishStep) obj).getId()));
    }

    @NotNull
    public abstract List<String> getFields();

    @NotNull
    public abstract String getId();

    @Nullable
    public abstract String getShortTitle();

    public abstract boolean getSkipOnBackwards();

    @Nullable
    public abstract String getSubtitle();

    @Nullable
    public abstract String getSubtype();

    @NotNull
    public abstract String getTitle();

    @NotNull
    public abstract String getType();

    @Override // java.lang.Object
    public int hashCode() {
        return getId().hashCode();
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return getId() + ':' + getTitle();
    }

    public /* synthetic */ CategoryPublishStep(j jVar) {
        this();
    }
}
