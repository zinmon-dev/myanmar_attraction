package xyz.aungpyaephyo.padc.myanmarattractions.data.persistence;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

import xyz.aungpyaephyo.padc.myanmarattractions.MyanmarAttractionsApp;

/**
 * Created by aung on 7/9/16.
 */
public class AttractionsContract {

    public static final String CONTENT_AUTHORITY = MyanmarAttractionsApp.class.getPackage().getName();
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    //content://xyz.aungpyaephyo.padc.myanmarattractions/
    public static final String PATH_ATTRACTIONS = "attractions";
    public static final String PATH_ATTRACTION_IMAGES = "attraction_images";
    public static final String PATH_USER = "user";

    public static final class AttractionEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_ATTRACTIONS).build();
        //content://xyz.aungpyaephyo.padc.myanmarattractions/attractions
        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ATTRACTIONS;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ATTRACTIONS;

        public static final String TABLE_NAME = "attractions";

        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_DESC = "desc";

        public static Uri buildAttractionUri(long id) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attractions/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildAttractionUriWithTitle(String attractionTitle) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attractions?title="Yangon"
            return CONTENT_URI.buildUpon()
                    .appendQueryParameter(COLUMN_TITLE, attractionTitle)
                    .build();
        }

        public static String getTitleFromParam(Uri uri) {
            return uri.getQueryParameter(COLUMN_TITLE);
        }
    }

    public static final class AttractionImageEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_ATTRACTION_IMAGES).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ATTRACTION_IMAGES;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ATTRACTION_IMAGES;

        public static final String TABLE_NAME = "attraction_images";

        public static final String COLUMN_ATTRACTION_TITLE = "attraction_title";
        public static final String COLUMN_IMAGE = "image";

        public static Uri buildAttractionImageUri(long id) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildAttractionImageUriWithTitle(String attractionTitle) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images?attraction_title=Yangon
            return CONTENT_URI.buildUpon()
                    .appendQueryParameter(COLUMN_ATTRACTION_TITLE, attractionTitle)
                    .build();
        }

        public static String getAttractionTitleFromParam(Uri uri) {
            return uri.getQueryParameter(COLUMN_ATTRACTION_TITLE);
        }
    }
    public static final class UserEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_USER).build();

        public static final String DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_USER;

        public static final String ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_USER;

        public static final String TABLE_NAME = "user";

        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_PASSWORD = "password";
        public static final String COLUMN_BD = "date of birth";
        public static final String COLUMN_COUNTRY = "country";

        public static Uri buildUserUri(long id) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildUserUriWithEmail(String email) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attraction_images?attraction_title=Yangon
            return CONTENT_URI.buildUpon()
                    .appendQueryParameter(COLUMN_EMAIL, email)
                    .build();
        }

    }
}