package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatDelegateImpl;
import org.json.JSONObject;
public class VKApiCommunityFull extends VKApiCommunity implements Parcelable {
    public static final String ACTIVITY = "activity";
    public static final String BLACKLISTED = "blacklisted";
    public static final String CAN_POST = "can_post";
    public static final String CAN_SEE_ALL_POSTS = "can_see_all_posts";
    public static final String CITY = "city";
    public static final String CONTACTS = "contacts";
    public static final String COUNTERS = "counters";
    public static final String COUNTRY = "country";
    public static Parcelable.Creator<VKApiCommunityFull> CREATOR = new a();
    public static final String DESCRIPTION = "description";
    public static final String END_DATE = "end_date";
    public static final String FIXED_POST = "fixed_post";
    public static final String LINKS = "links";
    public static final String MEMBERS_COUNT = "members_count";
    public static final String PLACE = "place";
    public static final String SITE = "site";
    public static final String START_DATE = "start_date";
    public static final String STATUS = "status";
    public static final String VERIFIED = "verified";
    public static final String WIKI_PAGE = "wiki_page";
    public boolean blacklisted;
    public boolean can_post;
    public boolean can_see_all_posts;
    public VKApiCity city;
    public VKList<Contact> contacts;
    public Counters counters;
    public VKApiCountry country;
    public String description;
    public long end_date;
    public int fixed_post;
    public VKList<Link> links;
    public int members_count;
    public VKApiPlace place;
    public String site;
    public long start_date;
    public String status;
    public VKApiAudio status_audio;
    public boolean verified;
    public String wiki_page;

    public static class Contact extends VKApiModel implements Parcelable, Identifiable {
        public static Parcelable.Creator<Contact> CREATOR = new a();
        public String desc;
        public String email;
        public VKApiUser user;
        public int user_id;

        public static class a implements Parcelable.Creator<Contact> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public Contact createFromParcel(Parcel parcel) {
                return new Contact(parcel, null);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public Contact[] newArray(int i) {
                return new Contact[i];
            }
        }

        public Contact(JSONObject jSONObject) {
            parse(jSONObject);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.vk.sdk.api.model.Identifiable
        public int getId() {
            return this.user_id;
        }

        @Override // java.lang.Object
        public String toString() {
            VKApiUser vKApiUser = this.user;
            if (vKApiUser != null) {
                return vKApiUser.toString();
            }
            String str = this.email;
            if (str != null) {
                return str;
            }
            return null;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.user_id);
            parcel.writeString(this.desc);
        }

        @Override // com.vk.sdk.api.model.VKApiModel
        public Contact parse(JSONObject jSONObject) {
            this.user_id = jSONObject.optInt("user_id");
            this.desc = jSONObject.optString("desc");
            this.email = jSONObject.optString("email");
            return this;
        }

        public Contact(Parcel parcel, a aVar) {
            this.user_id = parcel.readInt();
            this.desc = parcel.readString();
        }
    }

    public static class Link extends VKApiModel implements Parcelable, Identifiable {
        public static Parcelable.Creator<Link> CREATOR = new a();
        public String desc;
        public String name;
        public VKPhotoSizes photo = new VKPhotoSizes();
        public String url;

        public static class a implements Parcelable.Creator<Link> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public Link createFromParcel(Parcel parcel) {
                return new Link(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public Link[] newArray(int i) {
                return new Link[i];
            }
        }

        public Link(JSONObject jSONObject) {
            parse(jSONObject);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.vk.sdk.api.model.Identifiable
        public int getId() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.url);
            parcel.writeString(this.name);
            parcel.writeString(this.desc);
            parcel.writeParcelable(this.photo, i);
        }

        @Override // com.vk.sdk.api.model.VKApiModel
        public Link parse(JSONObject jSONObject) {
            this.url = jSONObject.optString("url");
            this.name = jSONObject.optString("name");
            this.desc = jSONObject.optString("desc");
            String optString = jSONObject.optString(VKApiUser.FIELD_PHOTO_50);
            if (!TextUtils.isEmpty(optString)) {
                this.photo.add((VKPhotoSizes) VKApiPhotoSize.create(optString, 50));
            }
            String optString2 = jSONObject.optString(VKApiUser.FIELD_PHOTO_100);
            if (!TextUtils.isEmpty(optString2)) {
                this.photo.add((VKPhotoSizes) VKApiPhotoSize.create(optString2, 100));
            }
            this.photo.sort();
            return this;
        }

        public Link(Parcel parcel) {
            this.url = parcel.readString();
            this.name = parcel.readString();
            this.desc = parcel.readString();
            this.photo = (VKPhotoSizes) parcel.readParcelable(null);
        }
    }

    public static class a implements Parcelable.Creator<VKApiCommunityFull> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiCommunityFull createFromParcel(Parcel parcel) {
            return new VKApiCommunityFull(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiCommunityFull[] newArray(int i) {
            return new VKApiCommunityFull[i];
        }
    }

    public VKApiCommunityFull() {
    }

    @Override // com.vk.sdk.api.model.VKApiCommunity, com.vk.sdk.api.model.VKApiOwner, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.vk.sdk.api.model.VKApiCommunity, com.vk.sdk.api.model.VKApiOwner, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.city, i);
        parcel.writeParcelable(this.country, i);
        parcel.writeParcelable(this.status_audio, i);
        parcel.writeParcelable(this.place, i);
        parcel.writeString(this.description);
        parcel.writeString(this.wiki_page);
        parcel.writeInt(this.members_count);
        parcel.writeParcelable(this.counters, i);
        parcel.writeLong(this.start_date);
        parcel.writeLong(this.end_date);
        parcel.writeByte(this.can_post ? (byte) 1 : 0);
        parcel.writeByte(this.can_see_all_posts ? (byte) 1 : 0);
        parcel.writeString(this.status);
        parcel.writeParcelable(this.contacts, i);
        parcel.writeParcelable(this.links, i);
        parcel.writeInt(this.fixed_post);
        parcel.writeByte(this.verified ? (byte) 1 : 0);
        parcel.writeString(this.site);
        parcel.writeByte(this.blacklisted ? (byte) 1 : 0);
    }

    public VKApiCommunityFull(Parcel parcel) {
        super(parcel);
        this.city = (VKApiCity) parcel.readParcelable(VKApiCity.class.getClassLoader());
        this.country = (VKApiCountry) parcel.readParcelable(VKApiCountry.class.getClassLoader());
        this.status_audio = (VKApiAudio) parcel.readParcelable(VKApiAudio.class.getClassLoader());
        this.place = (VKApiPlace) parcel.readParcelable(VKApiPlace.class.getClassLoader());
        this.description = parcel.readString();
        this.wiki_page = parcel.readString();
        this.members_count = parcel.readInt();
        this.counters = (Counters) parcel.readParcelable(Counters.class.getClassLoader());
        this.start_date = parcel.readLong();
        this.end_date = parcel.readLong();
        boolean z = true;
        this.can_post = parcel.readByte() != 0;
        this.can_see_all_posts = parcel.readByte() != 0;
        this.status = parcel.readString();
        this.contacts = (VKList) parcel.readParcelable(VKList.class.getClassLoader());
        this.links = (VKList) parcel.readParcelable(VKList.class.getClassLoader());
        this.fixed_post = parcel.readInt();
        this.verified = parcel.readByte() != 0;
        this.site = parcel.readString();
        this.blacklisted = parcel.readByte() == 0 ? false : z;
    }

    @Override // com.vk.sdk.api.model.VKApiCommunity, com.vk.sdk.api.model.VKApiOwner, com.vk.sdk.api.model.VKApiModel
    public VKApiCommunityFull parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("city");
        if (optJSONObject != null) {
            this.city = new VKApiCity().parse(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("country");
        if (optJSONObject2 != null) {
            this.country = new VKApiCountry().parse(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject(PLACE);
        if (optJSONObject3 != null) {
            this.place = new VKApiPlace().parse(optJSONObject3);
        }
        this.description = jSONObject.optString("description");
        this.wiki_page = jSONObject.optString(WIKI_PAGE);
        this.members_count = jSONObject.optInt(MEMBERS_COUNT);
        JSONObject optJSONObject4 = jSONObject.optJSONObject("counters");
        if (optJSONObject4 != null) {
            this.counters = new Counters(optJSONObject4);
        }
        this.start_date = jSONObject.optLong("start_date");
        this.end_date = jSONObject.optLong("end_date");
        this.can_post = AppCompatDelegateImpl.i.t1(jSONObject, "can_post");
        this.can_see_all_posts = AppCompatDelegateImpl.i.t1(jSONObject, "can_see_all_posts");
        this.status = jSONObject.optString("status");
        JSONObject optJSONObject5 = jSONObject.optJSONObject("status_audio");
        if (optJSONObject5 != null) {
            this.status_audio = new VKApiAudio().parse(optJSONObject5);
        }
        this.contacts = new VKList<>(jSONObject.optJSONArray("contacts"), Contact.class);
        this.links = new VKList<>(jSONObject.optJSONArray(LINKS), Link.class);
        this.fixed_post = jSONObject.optInt(FIXED_POST);
        this.verified = AppCompatDelegateImpl.i.t1(jSONObject, "verified");
        this.blacklisted = AppCompatDelegateImpl.i.t1(jSONObject, "verified");
        this.site = jSONObject.optString("site");
        return this;
    }

    public static class Counters implements Parcelable {
        public static Parcelable.Creator<Counters> CREATOR = new a();
        public static final int NO_COUNTER = -1;
        public int albums = -1;
        public int audios = -1;
        public int docs = -1;
        public int photos = -1;
        public int topics = -1;
        public int videos = -1;

        public static class a implements Parcelable.Creator<Counters> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public Counters createFromParcel(Parcel parcel) {
                return new Counters(parcel, null);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public Counters[] newArray(int i) {
                return new Counters[i];
            }
        }

        public Counters(JSONObject jSONObject) {
            this.photos = jSONObject.optInt("photos", -1);
            this.albums = jSONObject.optInt("albums", this.albums);
            this.audios = jSONObject.optInt("audios", this.audios);
            this.videos = jSONObject.optInt("videos", this.videos);
            this.topics = jSONObject.optInt("topics", this.topics);
            this.docs = jSONObject.optInt("docs", this.docs);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.photos);
            parcel.writeInt(this.albums);
            parcel.writeInt(this.audios);
            parcel.writeInt(this.videos);
            parcel.writeInt(this.topics);
            parcel.writeInt(this.docs);
        }

        public Counters(Parcel parcel, a aVar) {
            this.photos = parcel.readInt();
            this.albums = parcel.readInt();
            this.audios = parcel.readInt();
            this.videos = parcel.readInt();
            this.topics = parcel.readInt();
            this.docs = parcel.readInt();
        }
    }
}
