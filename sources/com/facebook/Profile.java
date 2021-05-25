package com.facebook;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import org.json.JSONObject;
public final class Profile implements Parcelable {
    public static final Parcelable.Creator<Profile> CREATOR = new b();
    public static final String g = Profile.class.getSimpleName();
    @Nullable
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    public final String c;
    @Nullable
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final Uri f;

    public static class a implements Utility.GraphMeRequestWithCacheCallback {
        @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
        public void onFailure(FacebookException facebookException) {
            String str = Profile.g;
            String str2 = Profile.g;
            String str3 = "Got unexpected exception: " + facebookException;
        }

        @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
        public void onSuccess(JSONObject jSONObject) {
            String optString = jSONObject.optString("id");
            if (optString != null) {
                String optString2 = jSONObject.optString("link");
                Profile.setCurrentProfile(new Profile(optString, jSONObject.optString("first_name"), jSONObject.optString("middle_name"), jSONObject.optString("last_name"), jSONObject.optString("name"), optString2 != null ? Uri.parse(optString2) : null));
            }
        }
    }

    public static class b implements Parcelable.Creator<Profile> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public Profile createFromParcel(Parcel parcel) {
            return new Profile(parcel, null);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public Profile[] newArray(int i) {
            return new Profile[i];
        }
    }

    public Profile(String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Uri uri) {
        Validate.notNullOrEmpty(str, "id");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = uri;
    }

    public static void fetchProfileForCurrentAccessToken() {
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (!AccessToken.isCurrentAccessTokenActive()) {
            setCurrentProfile(null);
        } else {
            Utility.getGraphMeRequestWithCacheAsync(currentAccessToken.getToken(), new a());
        }
    }

    public static Profile getCurrentProfile() {
        return ProfileManager.a().c;
    }

    public static void setCurrentProfile(@Nullable Profile profile) {
        ProfileManager.a().b(profile, true);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Profile)) {
            return false;
        }
        Profile profile = (Profile) obj;
        String str = this.a;
        if (str != null ? str.equals(profile.a) : profile.a == null) {
            String str2 = this.b;
            if (str2 != null ? str2.equals(profile.b) : profile.b == null) {
                String str3 = this.c;
                if (str3 != null ? str3.equals(profile.c) : profile.c == null) {
                    String str4 = this.d;
                    if (str4 != null ? str4.equals(profile.d) : profile.d == null) {
                        String str5 = this.e;
                        if (str5 != null ? str5.equals(profile.e) : profile.e == null) {
                            Uri uri = this.f;
                            Uri uri2 = profile.f;
                            if (uri == null) {
                                if (uri2 == null) {
                                    return true;
                                }
                            } else if (uri.equals(uri2)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public String getFirstName() {
        return this.b;
    }

    public String getId() {
        return this.a;
    }

    public String getLastName() {
        return this.d;
    }

    public Uri getLinkUri() {
        return this.f;
    }

    public String getMiddleName() {
        return this.c;
    }

    public String getName() {
        return this.e;
    }

    public Uri getProfilePictureUri(int i, int i2) {
        return ImageRequest.getProfilePictureUri(this.a, i, i2, AccessToken.isCurrentAccessTokenActive() ? AccessToken.getCurrentAccessToken().getToken() : "");
    }

    @Override // java.lang.Object
    public int hashCode() {
        int hashCode = this.a.hashCode() + 527;
        String str = this.b;
        if (str != null) {
            hashCode = (hashCode * 31) + str.hashCode();
        }
        String str2 = this.c;
        if (str2 != null) {
            hashCode = (hashCode * 31) + str2.hashCode();
        }
        String str3 = this.d;
        if (str3 != null) {
            hashCode = (hashCode * 31) + str3.hashCode();
        }
        String str4 = this.e;
        if (str4 != null) {
            hashCode = (hashCode * 31) + str4.hashCode();
        }
        Uri uri = this.f;
        return uri != null ? (hashCode * 31) + uri.hashCode() : hashCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        Uri uri = this.f;
        parcel.writeString(uri == null ? null : uri.toString());
    }

    public Profile(JSONObject jSONObject) {
        Uri uri = null;
        this.a = jSONObject.optString("id", null);
        this.b = jSONObject.optString("first_name", null);
        this.c = jSONObject.optString("middle_name", null);
        this.d = jSONObject.optString("last_name", null);
        this.e = jSONObject.optString("name", null);
        String optString = jSONObject.optString("link_uri", null);
        this.f = optString != null ? Uri.parse(optString) : uri;
    }

    public Profile(Parcel parcel, a aVar) {
        Uri uri;
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        String readString = parcel.readString();
        if (readString == null) {
            uri = null;
        } else {
            uri = Uri.parse(readString);
        }
        this.f = uri;
    }
}
