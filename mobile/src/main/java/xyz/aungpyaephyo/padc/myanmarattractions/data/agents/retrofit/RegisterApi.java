package xyz.aungpyaephyo.padc.myanmarattractions.data.agents.retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import xyz.aungpyaephyo.padc.myanmarattractions.data.responses.UserListResponse;
import xyz.aungpyaephyo.padc.myanmarattractions.utils.MyanmarAttractionsConstants;

/**
 * Created by Asus on 7/16/2016.
 */
public class RegisterApi {
    @FormUrlEncoded
    @POST(MyanmarAttractionsConstants.API_GET_USER_REGISTER)
    Call<UserListResponse> loadUsers(
            @Field(MyanmarAttractionsConstants.PARAM_ACCESS_TOKEN) String param) {
        return null;
    }
}
