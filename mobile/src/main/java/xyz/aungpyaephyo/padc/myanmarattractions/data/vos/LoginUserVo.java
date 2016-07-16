package xyz.aungpyaephyo.padc.myanmarattractions.data.vos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import xyz.aungpyaephyo.padc.myanmarattractions.MyanmarAttractionsApp;
import xyz.aungpyaephyo.padc.myanmarattractions.data.persistence.AttractionsContract;

/**
 * Created by Asus on 7/15/2016.
 */
public class LoginUserVo {

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("date_of_birth")
    private String dateofbirth;

    @SerializedName("country_of_origin")
    private String countryoforigin;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public String getCountryoforigin() {
        return countryoforigin;
    }
//    public void setImages(String[] images) {
//        this.images = images;
//    }

    public static void saveUsers(List<LoginUserVo> userList) {
        Context context = MyanmarAttractionsApp.getContext();
        ContentValues[] userCVs = new ContentValues[userList.size()];
        for (int index = 0; index < userList.size(); index++) {
            LoginUserVo user = userList.get(index);
            userCVs[index] = user.parseToContentValues();


        }

        //Bulk insert into attractions.
        int insertedCount = context.getContentResolver().bulkInsert(AttractionsContract.AttractionEntry.CONTENT_URI, userCVs);

        Log.d(MyanmarAttractionsApp.TAG, "Bulk inserted into user table : " + insertedCount);
    }
    private ContentValues parseToContentValues() {
        ContentValues cv = new ContentValues();
        cv.put(AttractionsContract.UserEntry.COLUMN_NAME, name);
        cv.put(AttractionsContract.UserEntry.COLUMN_EMAIL, email);
        cv.put(AttractionsContract.UserEntry.COLUMN_BD, dateofbirth);
        cv.put(AttractionsContract.UserEntry.COLUMN_COUNTRY, countryoforigin);
        return cv;
    }

    public static LoginUserVo parseFromCursor(Cursor data) {
        LoginUserVo user = new LoginUserVo();
        user.name = data.getString(data.getColumnIndex(AttractionsContract.UserEntry.COLUMN_NAME));
        user.email = data.getString(data.getColumnIndex(AttractionsContract.UserEntry.COLUMN_EMAIL));
        user.dateofbirth = data.getString(data.getColumnIndex(AttractionsContract.UserEntry.COLUMN_BD));
        user.countryoforigin = data.getString(data.getColumnIndex(AttractionsContract.UserEntry.COLUMN_COUNTRY));
        return user;
    }

}
