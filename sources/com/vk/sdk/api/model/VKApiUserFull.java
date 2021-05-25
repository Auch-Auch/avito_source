package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.avito.android.util.UrlParams;
import com.vk.sdk.api.VKApiConst;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class VKApiUserFull extends VKApiUser implements Parcelable {
    public static final String ABOUT = "about";
    public static final String ACTIVITIES = "activities";
    public static final String ACTIVITY = "activity";
    public static final String BDATE = "bdate";
    public static final String BLACKLISTED_BY_ME = "blacklisted_by_me";
    public static final String BOOKS = "books";
    public static final String CAN_POST = "can_post";
    public static final String CAN_SEE_ALL_POSTS = "can_see_all_posts";
    public static final String CAN_WRITE_PRIVATE_MESSAGE = "can_write_private_message";
    public static final String CITY = "city";
    public static final String CONNECTIONS = "connections";
    public static final String CONTACTS = "contacts";
    public static final String COUNTERS = "counters";
    public static final String COUNTRY = "country";
    public static Parcelable.Creator<VKApiUserFull> CREATOR = new a();
    public static final String GAMES = "games";
    public static final String INTERESTS = "interests";
    public static final String LAST_SEEN = "last_seen";
    public static final String MOVIES = "movies";
    public static final String OCCUPATION = "occupation";
    public static final String PERSONAL = "personal";
    public static final String QUOTES = "quotes";
    public static final String RELATION = "relation";
    public static final String RELATIVES = "relatives";
    public static final String SCHOOLS = "schools";
    public static final String SCREEN_NAME = "screen_name";
    public static final String SEX = "sex";
    public static final String SITE = "site";
    public static final String TV = "tv";
    public static final String UNIVERSITIES = "universities";
    public static final String VERIFIED = "verified";
    public static final String WALL_DEFAULT = "wall_default";
    public String about;
    public String activities;
    public String activity;
    public int alcohol;
    public String bdate;
    public boolean blacklisted_by_me;
    public String books;
    public boolean can_post;
    public boolean can_see_all_posts;
    public boolean can_write_private_message;
    public VKApiCity city;
    public Counters counters;
    public VKApiCountry country;
    public String facebook;
    public String facebook_name;
    public String games;
    public String home_phone;
    public String inspired_by;
    public String instagram;
    public String interests;
    public boolean is_banned;
    public boolean is_deleted;
    public String[] langs;
    public long last_seen;
    public int life_main;
    public String livejournal;
    public String mobile_phone;
    public String movies;
    public String nickname;
    public Occupation occupation;
    public int people_main;
    public int political;
    public String quotes;
    public int relation;
    public VKList<Relative> relatives;
    public String religion;
    public VKList<VKApiSchool> schools;
    public String screen_name;
    public int sex;
    public String site;
    public String skype;
    public int smoking;
    public VKApiAudio status_audio;
    public String tv;
    public String twitter;
    public VKList<VKApiUniversity> universities;
    public boolean verified;
    public boolean wall_comments;
    public boolean wall_default_owner;

    public static class Attitude {
        public static final int COMPROMISABLE = 3;
        public static final int NEGATIVE = 2;
        public static final int NEUTRAL = 4;
        public static final int POSITIVE = 5;
        public static final int VERY_NEGATIVE = 1;
    }

    public static class LifeMain {
        public static final int BEAUTY_AND_ART = 7;
        public static final int CAREER_AND_MONEY = 2;
        public static final int ENTERTAINMENT_AND_LEISURE = 3;
        public static final int FAME_AND_INFLUENCE = 8;
        public static final int FAMILY_AND_CHILDREN = 1;
        public static final int IMPROOVING_THE_WORLD = 5;
        public static final int PERSONAL_DEVELOPMENT = 6;
        public static final int SCIENCE_AND_RESEARCH = 4;
    }

    public static class PeopleMain {
        public static final int COURAGE_AND_PERSISTENCE = 5;
        public static final int HEALTH_AND_BEAUTY = 3;
        public static final int HUMOR_AND_LOVE_FOR_LIFE = 6;
        public static final int INTELLECT_AND_CREATIVITY = 1;
        public static final int KINDNESS_AND_HONESTLY = 2;
        public static final int WEALTH_AND_POWER = 4;
    }

    public static class Political {
        public static final int APATHETIC = 9;
        public static final int CENTRIST = 3;
        public static final int COMMUNNIST = 1;
        public static final int CONSERVATIVE = 5;
        public static final int LIBERAL = 4;
        public static final int LIBERTARIAN = 8;
        public static final int MONARCHIST = 6;
        public static final int SOCIALIST = 2;
        public static final int ULTRACONSERVATIVE = 7;
    }

    public static class Relation {
        public static final int COMPLICATED = 5;
        public static final int ENGAGED = 3;
        public static final int IN_LOVE = 7;
        public static final int MARRIED = 4;
        public static final int RELATIONSHIP = 2;
        public static final int SEARCHING = 6;
        public static final int SINGLE = 1;
    }

    public static class Relative extends VKApiModel implements Parcelable, Identifiable {
        public static Parcelable.Creator<Relative> CREATOR = new a();
        public int id;
        public String name;

        public static class a implements Parcelable.Creator<Relative> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public Relative createFromParcel(Parcel parcel) {
                return new Relative(parcel, null);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public Relative[] newArray(int i) {
                return new Relative[i];
            }
        }

        public Relative(Parcel parcel, a aVar) {
            this.id = parcel.readInt();
            this.name = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.vk.sdk.api.model.Identifiable
        public int getId() {
            return this.id;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.id);
            parcel.writeString(this.name);
        }

        @Override // com.vk.sdk.api.model.VKApiModel
        public Relative parse(JSONObject jSONObject) {
            this.id = jSONObject.optInt("id");
            this.name = jSONObject.optString("name");
            return this;
        }
    }

    public static class RelativeType {
        public static final String CHILD = "child";
        public static final String GRANDCHILD = "grandchild";
        public static final String GRANDPARENT = "grandparent";
        public static final String PARENT = "parent";
        public static final String PARTNER = "partner";
        public static final String SUBLING = "sibling";
    }

    public static class Sex {
        public static final int FEMALE = 1;
        public static final int MALE = 2;
    }

    public static class a implements Parcelable.Creator<VKApiUserFull> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiUserFull createFromParcel(Parcel parcel) {
            return new VKApiUserFull(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiUserFull[] newArray(int i) {
            return new VKApiUserFull[i];
        }
    }

    public VKApiUserFull(JSONObject jSONObject) throws JSONException {
        parse(jSONObject);
    }

    @Override // com.vk.sdk.api.model.VKApiUser, com.vk.sdk.api.model.VKApiOwner, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.vk.sdk.api.model.VKApiUser, com.vk.sdk.api.model.VKApiOwner, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.activity);
        parcel.writeParcelable(this.status_audio, i);
        parcel.writeString(this.bdate);
        parcel.writeParcelable(this.city, i);
        parcel.writeParcelable(this.country, i);
        parcel.writeLong(this.last_seen);
        parcel.writeParcelable(this.universities, i);
        parcel.writeParcelable(this.schools, i);
        parcel.writeInt(this.smoking);
        parcel.writeInt(this.alcohol);
        parcel.writeInt(this.political);
        parcel.writeInt(this.life_main);
        parcel.writeInt(this.people_main);
        parcel.writeString(this.inspired_by);
        parcel.writeStringArray(this.langs);
        parcel.writeString(this.religion);
        parcel.writeString(this.facebook);
        parcel.writeString(this.facebook_name);
        parcel.writeString(this.livejournal);
        parcel.writeString(this.skype);
        parcel.writeString(this.site);
        parcel.writeString(this.twitter);
        parcel.writeString(this.instagram);
        parcel.writeString(this.mobile_phone);
        parcel.writeString(this.home_phone);
        parcel.writeString(this.screen_name);
        parcel.writeString(this.activities);
        parcel.writeString(this.interests);
        parcel.writeString(this.movies);
        parcel.writeString(this.tv);
        parcel.writeString(this.books);
        parcel.writeString(this.games);
        parcel.writeString(this.about);
        parcel.writeString(this.quotes);
        parcel.writeByte(this.can_post ? (byte) 1 : 0);
        parcel.writeByte(this.can_see_all_posts ? (byte) 1 : 0);
        parcel.writeByte(this.can_write_private_message ? (byte) 1 : 0);
        parcel.writeByte(this.wall_comments ? (byte) 1 : 0);
        parcel.writeByte(this.is_banned ? (byte) 1 : 0);
        parcel.writeByte(this.is_deleted ? (byte) 1 : 0);
        parcel.writeByte(this.wall_default_owner ? (byte) 1 : 0);
        parcel.writeByte(this.verified ? (byte) 1 : 0);
        parcel.writeInt(this.sex);
        parcel.writeParcelable(this.counters, i);
        parcel.writeParcelable(this.occupation, i);
        parcel.writeInt(this.relation);
        parcel.writeParcelable(this.relatives, i);
        parcel.writeByte(this.blacklisted_by_me ? (byte) 1 : 0);
    }

    public VKApiUserFull() {
    }

    public VKApiUserFull(Parcel parcel) {
        super(parcel);
        this.activity = parcel.readString();
        this.status_audio = (VKApiAudio) parcel.readParcelable(VKApiAudio.class.getClassLoader());
        this.bdate = parcel.readString();
        this.city = (VKApiCity) parcel.readParcelable(VKApiCity.class.getClassLoader());
        this.country = (VKApiCountry) parcel.readParcelable(VKApiCountry.class.getClassLoader());
        this.last_seen = parcel.readLong();
        this.universities = (VKList) parcel.readParcelable(VKList.class.getClassLoader());
        this.schools = (VKList) parcel.readParcelable(VKList.class.getClassLoader());
        this.smoking = parcel.readInt();
        this.alcohol = parcel.readInt();
        this.political = parcel.readInt();
        this.life_main = parcel.readInt();
        this.people_main = parcel.readInt();
        this.inspired_by = parcel.readString();
        this.langs = parcel.createStringArray();
        this.religion = parcel.readString();
        this.facebook = parcel.readString();
        this.facebook_name = parcel.readString();
        this.livejournal = parcel.readString();
        this.skype = parcel.readString();
        this.site = parcel.readString();
        this.twitter = parcel.readString();
        this.instagram = parcel.readString();
        this.mobile_phone = parcel.readString();
        this.home_phone = parcel.readString();
        this.screen_name = parcel.readString();
        this.activities = parcel.readString();
        this.interests = parcel.readString();
        this.movies = parcel.readString();
        this.tv = parcel.readString();
        this.books = parcel.readString();
        this.games = parcel.readString();
        this.about = parcel.readString();
        this.quotes = parcel.readString();
        boolean z = true;
        this.can_post = parcel.readByte() != 0;
        this.can_see_all_posts = parcel.readByte() != 0;
        this.can_write_private_message = parcel.readByte() != 0;
        this.wall_comments = parcel.readByte() != 0;
        this.is_banned = parcel.readByte() != 0;
        this.is_deleted = parcel.readByte() != 0;
        this.wall_default_owner = parcel.readByte() != 0;
        this.verified = parcel.readByte() != 0;
        this.sex = parcel.readInt();
        this.counters = (Counters) parcel.readParcelable(Counters.class.getClassLoader());
        this.occupation = (Occupation) parcel.readParcelable(Occupation.class.getClassLoader());
        this.relation = parcel.readInt();
        this.relatives = (VKList) parcel.readParcelable(VKList.class.getClassLoader());
        this.blacklisted_by_me = parcel.readByte() == 0 ? false : z;
    }

    @Override // com.vk.sdk.api.model.VKApiUser, com.vk.sdk.api.model.VKApiOwner, com.vk.sdk.api.model.VKApiModel
    public VKApiUserFull parse(JSONObject jSONObject) {
        JSONArray optJSONArray;
        super.parse(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject(LAST_SEEN);
        long j = 0;
        if (optJSONObject != null) {
            j = optJSONObject.optLong("time", 0);
        }
        this.last_seen = j;
        this.bdate = jSONObject.optString(BDATE);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("city");
        if (optJSONObject2 != null) {
            this.city = new VKApiCity().parse(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("country");
        if (optJSONObject3 != null) {
            this.country = new VKApiCountry().parse(optJSONObject3);
        }
        this.universities = new VKList<>(jSONObject.optJSONArray(UNIVERSITIES), VKApiUniversity.class);
        this.schools = new VKList<>(jSONObject.optJSONArray(SCHOOLS), VKApiSchool.class);
        this.activity = jSONObject.optString("activity");
        JSONObject optJSONObject4 = jSONObject.optJSONObject("status_audio");
        if (optJSONObject4 != null) {
            this.status_audio = new VKApiAudio().parse(optJSONObject4);
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject(PERSONAL);
        if (optJSONObject5 != null) {
            this.smoking = optJSONObject5.optInt("smoking");
            this.alcohol = optJSONObject5.optInt("alcohol");
            this.political = optJSONObject5.optInt("political");
            this.life_main = optJSONObject5.optInt("life_main");
            this.people_main = optJSONObject5.optInt("people_main");
            this.inspired_by = optJSONObject5.optString("inspired_by");
            this.religion = optJSONObject5.optString(VKApiConst.RELIGION);
            if (optJSONObject5.has("langs") && (optJSONArray = optJSONObject5.optJSONArray("langs")) != null) {
                this.langs = new String[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.langs[i] = optJSONArray.optString(i);
                }
            }
        }
        this.facebook = jSONObject.optString("facebook");
        this.facebook_name = jSONObject.optString("facebook_name");
        this.livejournal = jSONObject.optString("livejournal");
        this.site = jSONObject.optString("site");
        StringBuilder L = a2.b.a.a.a.L("id");
        L.append(this.id);
        this.screen_name = jSONObject.optString(SCREEN_NAME, L.toString());
        this.skype = jSONObject.optString("skype");
        this.mobile_phone = jSONObject.optString("mobile_phone");
        this.home_phone = jSONObject.optString("home_phone");
        this.twitter = jSONObject.optString("twitter");
        this.instagram = jSONObject.optString("instagram");
        this.about = jSONObject.optString(ABOUT);
        this.activities = jSONObject.optString(ACTIVITIES);
        this.books = jSONObject.optString(BOOKS);
        this.games = jSONObject.optString(GAMES);
        this.interests = jSONObject.optString("interests");
        this.movies = jSONObject.optString(MOVIES);
        this.quotes = jSONObject.optString(QUOTES);
        this.tv = jSONObject.optString(TV);
        this.nickname = jSONObject.optString("nickname", null);
        this.can_post = AppCompatDelegateImpl.i.t1(jSONObject, "can_post");
        this.can_see_all_posts = AppCompatDelegateImpl.i.t1(jSONObject, "can_see_all_posts");
        this.blacklisted_by_me = AppCompatDelegateImpl.i.t1(jSONObject, BLACKLISTED_BY_ME);
        this.can_write_private_message = AppCompatDelegateImpl.i.t1(jSONObject, CAN_WRITE_PRIVATE_MESSAGE);
        this.wall_comments = AppCompatDelegateImpl.i.t1(jSONObject, WALL_DEFAULT);
        String optString = jSONObject.optString("deactivated");
        this.is_deleted = "deleted".equals(optString);
        this.is_banned = "banned".equals(optString);
        this.wall_default_owner = UrlParams.OWNER.equals(jSONObject.optString(WALL_DEFAULT));
        this.verified = AppCompatDelegateImpl.i.t1(jSONObject, "verified");
        this.sex = jSONObject.optInt("sex");
        JSONObject optJSONObject6 = jSONObject.optJSONObject("counters");
        if (optJSONObject6 != null) {
            this.counters = new Counters(optJSONObject6);
        }
        JSONObject optJSONObject7 = jSONObject.optJSONObject(OCCUPATION);
        if (optJSONObject7 != null) {
            this.occupation = new Occupation(optJSONObject7);
        }
        this.relation = jSONObject.optInt(RELATION);
        if (jSONObject.has(RELATIVES)) {
            if (this.relatives == null) {
                this.relatives = new VKList<>();
            }
            this.relatives.fill(jSONObject.optJSONArray(RELATIVES), Relative.class);
        }
        return this;
    }

    public static class Occupation implements Parcelable {
        public static Parcelable.Creator<Occupation> CREATOR = new a();
        public static final int NO_COUNTER = -1;
        public int id = -1;
        public String name;
        public String type;

        public static class a implements Parcelable.Creator<Occupation> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public Occupation createFromParcel(Parcel parcel) {
                return new Occupation(parcel, null);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public Occupation[] newArray(int i) {
                return new Occupation[i];
            }
        }

        public Occupation(JSONObject jSONObject) {
            this.type = jSONObject.optString("type");
            this.id = jSONObject.optInt("id", this.id);
            this.name = jSONObject.optString("name");
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.type);
            parcel.writeInt(this.id);
            parcel.writeString(this.name);
        }

        public Occupation(Parcel parcel, a aVar) {
            this.type = parcel.readString();
            this.id = parcel.readInt();
            this.name = parcel.readString();
        }
    }

    public static class Counters implements Parcelable {
        public static Parcelable.Creator<Counters> CREATOR = new a();
        public static final int NO_COUNTER = -1;
        public int albums = -1;
        public int audios = -1;
        public int followers = -1;
        public int friends = -1;
        public int groups = -1;
        public int mutual_friends = -1;
        public int notes = -1;
        public int online_friends = -1;
        public int pages = -1;
        public int photos = -1;
        public int subscriptions = -1;
        public int user_videos = -1;
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
            this.albums = jSONObject.optInt("albums", -1);
            this.audios = jSONObject.optInt("audios", this.audios);
            this.followers = jSONObject.optInt("followers", this.followers);
            this.photos = jSONObject.optInt("photos", this.photos);
            this.friends = jSONObject.optInt("friends", this.friends);
            this.groups = jSONObject.optInt("groups", this.groups);
            this.mutual_friends = jSONObject.optInt("mutual_friends", this.mutual_friends);
            this.notes = jSONObject.optInt("notes", this.notes);
            this.online_friends = jSONObject.optInt("online_friends", this.online_friends);
            this.user_videos = jSONObject.optInt("user_videos", this.user_videos);
            this.videos = jSONObject.optInt("videos", this.videos);
            this.subscriptions = jSONObject.optInt("subscriptions", this.subscriptions);
            this.pages = jSONObject.optInt("pages", this.pages);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.albums);
            parcel.writeInt(this.videos);
            parcel.writeInt(this.audios);
            parcel.writeInt(this.notes);
            parcel.writeInt(this.friends);
            parcel.writeInt(this.photos);
            parcel.writeInt(this.groups);
            parcel.writeInt(this.online_friends);
            parcel.writeInt(this.mutual_friends);
            parcel.writeInt(this.user_videos);
            parcel.writeInt(this.followers);
            parcel.writeInt(this.subscriptions);
            parcel.writeInt(this.pages);
        }

        public Counters(Parcel parcel, a aVar) {
            this.albums = parcel.readInt();
            this.videos = parcel.readInt();
            this.audios = parcel.readInt();
            this.notes = parcel.readInt();
            this.friends = parcel.readInt();
            this.photos = parcel.readInt();
            this.groups = parcel.readInt();
            this.online_friends = parcel.readInt();
            this.mutual_friends = parcel.readInt();
            this.user_videos = parcel.readInt();
            this.followers = parcel.readInt();
            this.subscriptions = parcel.readInt();
            this.pages = parcel.readInt();
        }
    }
}
