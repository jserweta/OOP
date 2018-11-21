public class Main {

    public static void main(String[] args) {
        try {
            EmailMessage message = EmailMessage.builder()
                    .addFrom("SENDER_EMAIL")
                    .addTo("RECEIVER_EMAIL")
                    .addSubject("Testowa wiadomość")
                    .addContent("Przykładowa treść wiadomości.")
                    .build();

                    message.send("YOUR_PASSWORD","HOST_NAME");
        }catch (Exception e){e.printStackTrace();}
    }
}
