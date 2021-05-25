package com.yandex.mobile.ads.video.models.ad;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.yandex.mobile.ads.impl.ie;
import com.yandex.mobile.ads.impl.tv;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public final class VideoAd implements Parcelable {
    public static final Parcelable.Creator<VideoAd> CREATOR = new Parcelable.Creator<VideoAd>() { // from class: com.yandex.mobile.ads.video.models.ad.VideoAd.1
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ VideoAd createFromParcel(Parcel parcel) {
            return new VideoAd(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ VideoAd[] newArray(int i) {
            return new VideoAd[i];
        }
    };
    private static final String ERROR = "error";
    private String mAdSystem;
    private String mAdTitle;
    private List<Creative> mCreatives;
    private String mDescription;
    private String mSurvey;
    private Map<String, List<String>> mTrackingEvents;
    private String mVastAdTagUri;
    private final boolean mWrapper;
    @Nullable
    private tv mWrapperConfiguration;

    private void addCreative(Creative creative) {
        this.mCreatives.add(creative);
    }

    private void addCreatives(Collection<Creative> collection) {
        for (Creative creative : ie.a(collection)) {
            addCreative(creative);
        }
    }

    private void addError(String str) {
        addTrackingEvent("error", str);
    }

    private void addImpression(String str) {
        addTrackingEvent(Tracker.Events.AD_IMPRESSION, str);
    }

    private void addImpressions(Collection<String> collection) {
        for (String str : ie.a(collection)) {
            addImpression(str);
        }
    }

    private void setAdSystem(String str) {
        this.mAdSystem = str;
    }

    private void setAdTitle(String str) {
        this.mAdTitle = str;
    }

    private void setDescription(String str) {
        this.mDescription = str;
    }

    private void setSurvey(String str) {
        this.mSurvey = str;
    }

    private void setVastAdTagUri(String str) {
        this.mVastAdTagUri = str;
    }

    public final void addTrackingEvent(String str, String str2) {
        List<String> list = this.mTrackingEvents.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.mTrackingEvents.put(str, list);
        }
        if (!TextUtils.isEmpty(str2)) {
            list.add(str2);
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || VideoAd.class != obj.getClass()) {
            return false;
        }
        VideoAd videoAd = (VideoAd) obj;
        if (this.mWrapper != videoAd.mWrapper) {
            return false;
        }
        String str = this.mAdSystem;
        if (str == null ? videoAd.mAdSystem != null : !str.equals(videoAd.mAdSystem)) {
            return false;
        }
        String str2 = this.mAdTitle;
        if (str2 == null ? videoAd.mAdTitle != null : !str2.equals(videoAd.mAdTitle)) {
            return false;
        }
        if (!this.mCreatives.equals(videoAd.mCreatives)) {
            return false;
        }
        String str3 = this.mDescription;
        if (str3 == null ? videoAd.mDescription != null : !str3.equals(videoAd.mDescription)) {
            return false;
        }
        String str4 = this.mSurvey;
        if (str4 == null ? videoAd.mSurvey != null : !str4.equals(videoAd.mSurvey)) {
            return false;
        }
        if (!this.mTrackingEvents.equals(videoAd.mTrackingEvents)) {
            return false;
        }
        String str5 = this.mVastAdTagUri;
        String str6 = videoAd.mVastAdTagUri;
        return str5 == null ? str6 == null : str5.equals(str6);
    }

    public final String getAdSystem() {
        return this.mAdSystem;
    }

    public final String getAdTitle() {
        return this.mAdTitle;
    }

    public final List<Creative> getCreatives() {
        return this.mCreatives;
    }

    public final String getDescription() {
        return this.mDescription;
    }

    public final String getSurvey() {
        return this.mSurvey;
    }

    public final Map<String, List<String>> getTrackingEvents() {
        return Collections.unmodifiableMap(this.mTrackingEvents);
    }

    public final String getVastAdTagUri() {
        return this.mVastAdTagUri;
    }

    @Nullable
    public final tv getWrapperConfiguration() {
        return this.mWrapperConfiguration;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        String str = this.mAdSystem;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + (this.mWrapper ? 1 : 0)) * 31;
        String str2 = this.mAdTitle;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.mDescription;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.mSurvey;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.mVastAdTagUri;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return this.mTrackingEvents.hashCode() + ((this.mCreatives.hashCode() + ((hashCode4 + i) * 31)) * 31);
    }

    public final boolean isWrapper() {
        return this.mWrapper;
    }

    public final void setWrapperConfiguration(@Nullable tv tvVar) {
        this.mWrapperConfiguration = tvVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mWrapper ? 1 : 0);
        parcel.writeString(this.mAdSystem);
        parcel.writeString(this.mAdTitle);
        parcel.writeString(this.mDescription);
        parcel.writeString(this.mSurvey);
        parcel.writeString(this.mVastAdTagUri);
        parcel.writeTypedList(this.mCreatives);
        parcel.writeInt(this.mTrackingEvents.size());
        for (Map.Entry<String, List<String>> entry : this.mTrackingEvents.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeList(entry.getValue());
        }
    }

    private VideoAd(Boolean bool) {
        this.mCreatives = new ArrayList();
        this.mTrackingEvents = new HashMap();
        this.mWrapper = bool.booleanValue();
    }

    private VideoAd(Parcel parcel) {
        this.mCreatives = new ArrayList();
        this.mTrackingEvents = new HashMap();
        this.mWrapper = parcel.readInt() != 1 ? false : true;
        this.mAdSystem = parcel.readString();
        this.mAdTitle = parcel.readString();
        this.mDescription = parcel.readString();
        this.mSurvey = parcel.readString();
        this.mVastAdTagUri = parcel.readString();
        parcel.readTypedList(this.mCreatives, Creative.CREATOR);
        this.mTrackingEvents = new HashMap();
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            this.mTrackingEvents.put(parcel.readString(), parcel.readArrayList(VideoAd.class.getClassLoader()));
        }
    }
}
