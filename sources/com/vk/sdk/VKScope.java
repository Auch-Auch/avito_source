package com.vk.sdk;

import java.util.ArrayList;
public class VKScope {
    public static final String ADS = "ads";
    public static final String AUDIO = "audio";
    public static final String DIRECT = "direct";
    public static final String DOCS = "docs";
    public static final String EMAIL = "email";
    public static final String FRIENDS = "friends";
    public static final String GROUPS = "groups";
    public static final String MESSAGES = "messages";
    public static final String NOHTTPS = "nohttps";
    public static final String NOTES = "notes";
    public static final String NOTIFICATIONS = "notifications";
    public static final String NOTIFY = "notify";
    public static final String OFFLINE = "offline";
    public static final String PAGES = "pages";
    public static final String PHOTOS = "photos";
    public static final String STATS = "stats";
    public static final String STATUS = "status";
    public static final String VIDEO = "video";
    public static final String WALL = "wall";

    public static ArrayList<String> parseVkPermissionsFromInteger(int i) {
        ArrayList<String> arrayList = new ArrayList<>();
        if ((i & 1) > 0) {
            arrayList.add("notify");
        }
        if ((i & 2) > 0) {
            arrayList.add("friends");
        }
        if ((i & 4) > 0) {
            arrayList.add("photos");
        }
        if ((i & 8) > 0) {
            arrayList.add("audio");
        }
        if ((i & 16) > 0) {
            arrayList.add("video");
        }
        if ((i & 128) > 0) {
            arrayList.add("pages");
        }
        if ((i & 1024) > 0) {
            arrayList.add("status");
        }
        if ((i & 2048) > 0) {
            arrayList.add("notes");
        }
        if ((i & 4096) > 0) {
            arrayList.add("messages");
        }
        if ((i & 8192) > 0) {
            arrayList.add("wall");
        }
        if ((32768 & i) > 0) {
            arrayList.add("ads");
        }
        if ((65536 & i) > 0) {
            arrayList.add("offline");
        }
        if ((131072 & i) > 0) {
            arrayList.add("docs");
        }
        if ((262144 & i) > 0) {
            arrayList.add("groups");
        }
        if ((524288 & i) > 0) {
            arrayList.add("notifications");
        }
        if ((i & 1048576) > 0) {
            arrayList.add("stats");
        }
        return arrayList;
    }
}
