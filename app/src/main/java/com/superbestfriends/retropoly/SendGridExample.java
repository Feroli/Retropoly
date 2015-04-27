//package com.superbestfriends.retropoly;
//// using SendGrid's Java Library - https://github.com/sendgrid/sendgrid-java
//
//import com.sendgrid.*;
//
//public class SendGridExample {
//    public static void main(String[] args) {
//        SendGrid sendgrid = new SendGrid("Retropoly1", "greatunihack2015");
//
//        SendGrid.Email email = new SendGrid.Email();
//
//        String vikash = "kothary.vikash@gmail.com";
//        String jat = "jat.torres@gmail.com";
//        String fernando = "javierania21@gmail.com";
//        String alicia = "a.beylann@gmail.com";
//
//        email.addTo(jat);
//        email.addTo(vikash);
//        email.addTo(alicia);
//        email.addTo(fernando);
//
//        email.setFrom(jat);
//        email.setSubject("random testing");
//
//        String html = "<html><table border = '1'>"
//                + "<tr><th>fdfaa</th><th>aD</th><th>s</th><th>b</th></tr>"
//                + "<tr><td>asdgha</td><td>ahdkk</td><td>arere</td><td>adgfjj</td></tr>"
//                + "</table></html>";
//
//        email.setHtml("and easy to do anywhere, even with Java" + html);
//
//
//        try {
//            SendGrid.Response response = sendgrid.send(email);
//            System.out.println("sent email");
//        } catch (SendGridException e) {
//            e.printStackTrace();
//        }
//    }
//}
