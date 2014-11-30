package json;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CollectionStructure {

    public static void main(String... args) throws IOException {
        String jsonData = "{\"REP_TYPE\":\"USER\",\"REP_CMD\":\"USER:PROFILE:GET:ALL\",\"REP_STATUS\":\"SUCCESS\",\"REP\":{\"profiles\":[{\"profile_id\":\"111926427936358401\",\"profile_kit_id\":\"111926427978301441\",\"last_name\":\"Varennikov\",\"first_name\":\"Dmitry\",\"name_type\":\"REAL\",\"gender\":null,\"birthday\":null,\"avatar\":\"https://s.witkit.com/avatars/P111926427936358401/F111933828431347713/files/666efcaf-bbaf-48c4-b64a-6afb346d70f6_default.png\",\"legend\":null,\"timezone_offset\":0,\"timezone\":null,\"metadata\":{\"education\":[],\"experience\":[{\"employer\":\"\",\"position\":\"\",\"desc\":\"\",\"country\":\"\",\"state\":\"\",\"city\":\"\",\"from\":\"\",\"to\":\"\"}],\"memo\":\"\"},\"online_status\":\"OFFLINE\",\"access_mode\":\"PUBLIC\",\"state\":null,\"type\":\"PERSONAL\",\"created_at\":\"2014-09-10T17:11:19.827Z\"}],\"active_profile_id\":\"111926427936358401\"}}";

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.PUBLIC_ONLY);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        UserProfileGetAllResponse response = objectMapper.readValue(jsonData, UserProfileGetAllResponse.class);
        System.out.println(response.REP.profiles.get(0).profile_id);
    }

    public static class UserProfileGetAllResponse {

        public String   REP_TYPE;
        public String   REP_CMD;
        public Response REP;

        public static class Response {

            public List<Profile> profiles;

            public static class Profile {

                public String profile_id;
                public String profile_kit_id;
                public String active_profile_id;
                public String last_name;
                public String first_name;
                public String name_type;
                public String avatar;
            }
        }
    }
}
