package pl.BestInTest.BitCore.Modules.Step.Security;

import com.google.common.hash.Hashing;
import pl.BestInTest.BitCore.Managers.data;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Passwords {
    public void setPassword(String s, String pName) throws IOException {
        data.ymlSave("plugins/BitCore/Modules/2Step/Users/"+pName+".yml", "profile.password", getSHA512(s));
    }

    public boolean isValidPassword(String pass, String pName) {
        String savedPassword = data.ymlLoad("plugins/BitCore/Modules/2Step/Users/"+pName+".yml", "profile.password");
        String recPassword = getSHA512(pass);
        if (!(savedPassword != null && !savedPassword.equals("")) ) {
            savedPassword = getSHA512(data.ymlLoad("plugins/BitCore/Modules/2Step/Settings.yml", "Security.default-password"));
        }
        return savedPassword.equals(recPassword);
    }

    public String getSHA512(String password){
        return Hashing.sha512().hashString(password, StandardCharsets.UTF_8).toString();
    }
}
