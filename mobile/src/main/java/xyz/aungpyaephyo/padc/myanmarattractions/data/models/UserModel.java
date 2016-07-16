package xyz.aungpyaephyo.padc.myanmarattractions.data.models;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;
import xyz.aungpyaephyo.padc.myanmarattractions.MyanmarAttractionsApp;
import xyz.aungpyaephyo.padc.myanmarattractions.data.agents.AttractionDataAgent;
import xyz.aungpyaephyo.padc.myanmarattractions.data.agents.HttpUrlConnectionDataAgent;
import xyz.aungpyaephyo.padc.myanmarattractions.data.agents.OkHttpDataAgent;
import xyz.aungpyaephyo.padc.myanmarattractions.data.agents.retrofit.RetrofitDataAgent;
import xyz.aungpyaephyo.padc.myanmarattractions.data.vos.AttractionVO;
import xyz.aungpyaephyo.padc.myanmarattractions.data.vos.LoginUserVo;
import xyz.aungpyaephyo.padc.myanmarattractions.events.DataEvent;

/**
 * Created by Asus on 7/15/2016.
 */
public class UserModel {
    public static final String BROADCAST_DATA_LOADED = "BROADCAST_DATA_LOADED";

    private static final int INIT_DATA_AGENT_OFFLINE = 1;
    private static final int INIT_DATA_AGENT_HTTP_URL_CONNECTION = 2;
    private static final int INIT_DATA_AGENT_OK_HTTP = 3;
    private static final int INIT_DATA_AGENT_RETROFIT = 4;

    private static UserModel objInstance;

    private List<LoginUserVo> mUserList;
    private AttractionDataAgent dataAgent;

    private UserModel() {
        mUserList = new ArrayList<>();
        initDataAgent(INIT_DATA_AGENT_RETROFIT);
        dataAgent.loadAttractions();
    }

    public static UserModel getInstance() {
        if (objInstance == null) {
            objInstance = new UserModel();
        }
        return objInstance;
    }

    private void initDataAgent(int initType) {
        switch (initType) {
            case INIT_DATA_AGENT_OFFLINE:
                //dataAgent = OfflineDataAgent.getInstance();
                break;
            case INIT_DATA_AGENT_HTTP_URL_CONNECTION:
                dataAgent = HttpUrlConnectionDataAgent.getInstance();
                break;
            case INIT_DATA_AGENT_OK_HTTP:
                dataAgent = OkHttpDataAgent.getInstance();
                break;
            case INIT_DATA_AGENT_RETROFIT:
                dataAgent = RetrofitDataAgent.getInstance();
                break;
        }
    }

    public List<LoginUserVo> getUserList() {
        return mUserList;
    }

    public LoginUserVo getUserByEmail(String email) {
        for (LoginUserVo user : mUserList) {
            if (user.getEmail().equals(email))
                return user;
        }

        return null;
    }

    public void notifyUsersLoaded(List<LoginUserVo> userList) {
        //Notify that the data is ready - using LocalBroadcast
        mUserList = userList;
        //keep the data in persistent layer.
        LoginUserVo.saveUsers(mUserList);

        //broadcastAttractionLoadedWithEventBus();
        broadcastAttractionLoadedWithLocalBroadcastManager();
    }

    public void notifyErrorInLoadingUsers(String message) {

    }

    private void broadcastAttractionLoadedWithLocalBroadcastManager() {
        Intent intent = new Intent(BROADCAST_DATA_LOADED);
        intent.putExtra("key-for-extra", "extra-in-broadcast");
        LocalBroadcastManager.getInstance(MyanmarAttractionsApp.getContext()).sendBroadcast(intent);
    }

    private void broadcastAttractionLoadedWithEventBus() {
        EventBus.getDefault().post(new DataEvent.UserDataLoadedEvent("extra-in-broadcast",mUserList));
    }
}
