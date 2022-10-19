package com.sap.school.sae.service;

import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Service
public class TreeService {

    private TreeService() {

    }
    private int height = 9;

    public void setHeight(int i) {
        height = i;
    }

    public String getTree() {

        StringBuilder stringBuilder = new StringBuilder("<pre>\n");

        for (int i = 0; i < height; i++) stringBuilder.append(" ".repeat(height - i)).append("*".repeat(2 * i + 1)).append("\n");
        return stringBuilder.append(" ".repeat(height - 1)).append("***\n").append("</pre>").toString();
    }

}
