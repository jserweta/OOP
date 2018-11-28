public class Polibiusz implements Algorithm {

    private final char[][] alphabet={   {'a','b','c','d','e'},
                                        {'f','g','h','i','k'},
                                        {'l','m','n','o','p'},
                                        {'q','r','s','t','u'},
                                        {'v','w','x','y','z'}   };

    @Override
    public String crypt(String word) {
        String encryptedWord=new String();
        word = word.toLowerCase();
        word.replace('j','i');
        for(int i=0; i<word.length(); i++){
            for(int j=0; j<5; j++){
                for(int k=0; k<5; k++){
                    if(word.charAt(i) == alphabet[j][k]){
                        encryptedWord += (char)j+1;
                        encryptedWord += (char)k+1;
                    }
                }
            }
        }
        encryptedWord += " ";
        return encryptedWord;
    }




    @Override
    public String decrypt(String word) {
        String decryptedWord = new String();

        char [] tablica = word.toCharArray();
        for(int i=0; i<tablica.length; i=i+2){
            decryptedWord += alphabet[(int)tablica[i]-49][(int)tablica[i+1]-49];
        }


        return decryptedWord;

    }
}
