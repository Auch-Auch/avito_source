package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import java.net.HttpURLConnection;
import org.json.JSONObject;
public final class FacebookRequestError implements Parcelable {
    public static final Parcelable.Creator<FacebookRequestError> CREATOR = new a();
    public static final int INVALID_ERROR_CODE = -1;
    public static final int INVALID_HTTP_STATUS_CODE = -1;
    public static final b o = new b(200, 299, null);
    public final Category a;
    public final int b;
    public final int c;
    public final int d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final JSONObject j;
    public final JSONObject k;
    public final Object l;
    public final HttpURLConnection m;
    public final FacebookException n;

    public enum Category {
        LOGIN_RECOVERABLE,
        OTHER,
        TRANSIENT
    }

    public static class a implements Parcelable.Creator<FacebookRequestError> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public FacebookRequestError createFromParcel(Parcel parcel) {
            return new FacebookRequestError(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), false, null, null, null, null, null);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public FacebookRequestError[] newArray(int i) {
            return new FacebookRequestError[i];
        }
    }

    public static class b {
        public b(int i, int i2, a aVar) {
        }
    }

    public FacebookRequestError(int i2, int i3, int i4, String str, String str2, String str3, String str4, boolean z, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        boolean z2;
        FacebookRequestErrorClassification facebookRequestErrorClassification;
        Category category;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = str;
        this.f = str2;
        this.k = jSONObject;
        this.j = jSONObject2;
        this.l = obj;
        this.m = httpURLConnection;
        this.g = str3;
        this.h = str4;
        if (facebookException != null) {
            this.n = facebookException;
            z2 = true;
        } else {
            this.n = new FacebookServiceException(this, str2);
            z2 = false;
        }
        synchronized (FacebookRequestError.class) {
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
            if (appSettingsWithoutQuery == null) {
                facebookRequestErrorClassification = FacebookRequestErrorClassification.getDefaultErrorClassification();
            } else {
                facebookRequestErrorClassification = appSettingsWithoutQuery.getErrorClassification();
            }
        }
        if (z2) {
            category = Category.OTHER;
        } else {
            category = facebookRequestErrorClassification.classify(i3, i4, z);
        }
        this.a = category;
        this.i = facebookRequestErrorClassification.getRecoveryMessage(category);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Object getBatchRequestResult() {
        return this.l;
    }

    public Category getCategory() {
        return this.a;
    }

    public HttpURLConnection getConnection() {
        return this.m;
    }

    public int getErrorCode() {
        return this.c;
    }

    public String getErrorMessage() {
        String str = this.f;
        if (str != null) {
            return str;
        }
        return this.n.getLocalizedMessage();
    }

    public String getErrorRecoveryMessage() {
        return this.i;
    }

    public String getErrorType() {
        return this.e;
    }

    public String getErrorUserMessage() {
        return this.h;
    }

    public String getErrorUserTitle() {
        return this.g;
    }

    public FacebookException getException() {
        return this.n;
    }

    public JSONObject getRequestResult() {
        return this.j;
    }

    public JSONObject getRequestResultBody() {
        return this.k;
    }

    public int getRequestStatusCode() {
        return this.b;
    }

    public int getSubErrorCode() {
        return this.d;
    }

    @Override // java.lang.Object
    public String toString() {
        return "{HttpStatus: " + this.b + ", errorCode: " + this.c + ", subErrorCode: " + this.d + ", errorType: " + this.e + ", errorMessage: " + getErrorMessage() + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FacebookRequestError(HttpURLConnection httpURLConnection, Exception exc) {
        this(-1, -1, -1, null, null, null, null, false, null, null, null, httpURLConnection, exc instanceof FacebookException ? (FacebookException) exc : new FacebookException(exc));
    }

    public FacebookRequestError(int i2, String str, String str2) {
        this(-1, i2, -1, str, str2, null, null, false, null, null, null, null, null);
    }
}
