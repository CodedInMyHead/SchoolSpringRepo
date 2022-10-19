package com.sap.school.sae.service;

import lombok.Setter;
@Setter
public class TreeService {

    private TreeService() {

    }
    private static int length;

    public static void setLength(int i) {
        length = i;
    }

    public static String getTree() {
        final int half = (length - 1) / 2;
        final int lines = half + 1;
        StringBuilder stringBuilder = new StringBuilder("<pre>");
        int stars = 1;
        for (int i = 0; i < lines; i++) {
            int targetStars = stars;
            int tempLength = length - i;
            while(targetStars > 0) {
                while(tempLength > 0) {
                    stringBuilder.append(" ");
                    tempLength--;
                }
                stringBuilder.append("*");
                targetStars--;
            }
            stringBuilder.append("\n");
            stars += 2;
        }
        int mod = (length - 1) / 4;
        while(mod > 0) {
            stringBuilder.append(" ");
            mod--;
        }
        int t = (length - 1) / 2 + 1;
        while(t > 0) {
            stringBuilder.append(" ");
            t--;
        }
        return stringBuilder.append("</pre>").toString();
    }

    static {
        length = 9;
    }
}
