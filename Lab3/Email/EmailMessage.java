import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.LinkedList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailMessage {

    private String from; //required (must be e-mail)
    private LinkedList<String> to; //required at least one (must be e-mail)
    private String subject; //optional
    private String content; //optional
    private String mimeType;  // optional
    private LinkedList<String> cc; //optional
    private LinkedList<String> bcc; // optional


    public EmailMessage(String from,
                        LinkedList<String> to,
                        String subject,
                        String content,
                        String mimeType,
                        LinkedList<String> cc,
                        LinkedList<String> bcc){
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.content = content;
        this.mimeType = mimeType;
        this.cc = cc;
        this.bcc = bcc;
    }
    private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

    public void send(String password, String host) {
        if(!from.isEmpty() && !to.isEmpty()){
            Properties prop = new Properties();
            prop.put("mail.smtp.host", "smtp." + host);
            prop.put("mail.smtp.socketFactory.port", "465");
            prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.port", "465");

            Session session = Session.getDefaultInstance(prop, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, password);
                }
            });

            try{
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(from));

                message.setSubject(subject);
                message.setText(content);

                for (int i = 0; i < this.to.size(); ++i) {
                    message.addRecipients(Message.RecipientType.TO, this.to.get(i));
                }
                for (int i = 0; i < this.cc.size(); ++i) {
                    message.addRecipients(Message.RecipientType.CC, this.cc.get(i));
                }
                for (int i = 0; i < this.bcc.size(); ++i) {
                    message.addRecipients(Message.RecipientType.BCC, this.bcc.get(i));
                }

                Transport.send(message);

                System.out.print("Wiadomośc została wysłana poprawnie!");

            }catch (MessagingException mex){
                mex.printStackTrace();
            }
        }
    }

    public static Builder builder(){
        return new EmailMessage.Builder();
    }


    public static class Builder {
        private String from; //required (must be e-mail)
        private LinkedList<String> to = new LinkedList<String>(); //required at least one (must be e-mail)
        private String subject; //optional
        private String content; //optional
        private String mimeType;  // optional
        private LinkedList<String> cc = new LinkedList<String>(); //optional
        private LinkedList<String> bcc = new LinkedList<String>(); // optional

        public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

        public static boolean validate(String emailStr) {
            Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
            return matcher.find();
        }
        public Builder(){
        }

        public Builder addFrom(String from){
            if(validate(from)){
                this.from=from;
            }
            return this;
        }
        public Builder addTo(String to){
            if(validate(to)){
                this.to.add(to);
            }
            return this;
        }
        public Builder addSubject(String subject){
            this.subject=subject;
            return this;
        }
        public Builder addContent(String content){
            this.content=content;
            return this;
        }
        public Builder addMimeType(String mimeType){
            this.mimeType=mimeType;
            return this;
        }
        public Builder addCC(String cc){
            if(validate(cc)){
                this.cc.add(cc);
            }
            return this;
        }
        public Builder addBcc(String bcc){
            if(validate(bcc)){
                this.bcc.add(bcc);
            }
            return this;
        }

        public EmailMessage build(){ return new EmailMessage(from, to,subject,content,mimeType,cc,bcc);}

    }
}
