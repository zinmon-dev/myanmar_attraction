package xyz.aungpyaephyo.padc.myanmarattractions.events;

import java.util.List;

import xyz.aungpyaephyo.padc.myanmarattractions.data.vos.AttractionVO;
import xyz.aungpyaephyo.padc.myanmarattractions.data.vos.LoginUserVo;

/**
 * Created by aung on 7/9/16.
 */
public class DataEvent {

    public static class AttractionDataLoadedEvent {
        private String extraMessage;
        private List<AttractionVO> attractionList;
        public AttractionDataLoadedEvent(String extraMessage,List<AttractionVO> attractionList) {
            this.extraMessage = extraMessage;
            this.attractionList=attractionList;
        }

        public String getExtraMessage() {
            return extraMessage;
        }

        public List<AttractionVO> getAttractionList(){
            return attractionList;
        }
    }

    public static class UserDataLoadedEvent {
        private String extraMessage;
        private List<LoginUserVo> userList;
        public UserDataLoadedEvent(String extraMessage,List<LoginUserVo> userList) {
            this.extraMessage = extraMessage;
            this.userList=userList;
        }

        public String getExtraMessage() {
            return extraMessage;
        }

        public List<LoginUserVo> getUserList(){
            return userList;
        }
    }

}