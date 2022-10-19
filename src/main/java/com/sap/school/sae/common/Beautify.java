package com.sap.school.sae.common;

import com.sap.school.sae.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Beautify {

    public String getAllUsers(final List<UserModel> users) {
        final StringBuilder stringBuilder = new StringBuilder("<div style=\"width:50%;margin:0 auto;\">");

        users.forEach(user-> {
            stringBuilder.append("<div style=\"width:100%; height:200px;background-color:C1B8DC;\">");
            stringBuilder.append(user.getFirstName()).append(" ").append(user.getLastName());
            stringBuilder.append("</div>");
        });
        stringBuilder.append("</div>");

        return stringBuilder.toString();
    }
}
