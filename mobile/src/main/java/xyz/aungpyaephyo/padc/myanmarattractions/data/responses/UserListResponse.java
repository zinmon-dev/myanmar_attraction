package xyz.aungpyaephyo.padc.myanmarattractions.data.responses;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import xyz.aungpyaephyo.padc.myanmarattractions.data.vos.AttractionVO;
import xyz.aungpyaephyo.padc.myanmarattractions.data.vos.LoginUserVo;

/**
 * Created by Asus on 7/15/2016.
 */
public class UserListResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("login_user")
    private ArrayList<LoginUserVo> userList;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<LoginUserVo> getUserList() {
        return userList;
    }
}
