package xyz.aungpyaephyo.padc.myanmarattractions.data.agents.retrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import xyz.aungpyaephyo.padc.myanmarattractions.data.models.UserModel;
import xyz.aungpyaephyo.padc.myanmarattractions.data.responses.AttractionListResponse;
import xyz.aungpyaephyo.padc.myanmarattractions.data.responses.UserListResponse;
import xyz.aungpyaephyo.padc.myanmarattractions.utils.MyanmarAttractionsConstants;

/**
 * Created by Asus on 7/15/2016.
 */
public interface LoginApi {

    @FormUrlEncoded
    @POST(MyanmarAttractionsConstants.API_GET_USER_LOGIN)
    Call<UserListResponse> loadUsers(
            @Field(MyanmarAttractionsConstants.PARAM_ACCESS_TOKEN) String param);
}

