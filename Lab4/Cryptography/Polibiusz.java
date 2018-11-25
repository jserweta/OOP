public class Polibiusz implements Algorithm {

    private final char[][] alphabet={{'a','b','c','d','e'},
                                    {'f','g','h','i','k'},
                                    {'l','m','n','o','p'},
                                    {'q','r','s','t','u'},
                                    {'v','w','x','y','z'}};

    @Override
    public String crypt(String word) {
        String encrypedWord=new String();
        word = word.toLowerCase();
        word.replace('j','i');
        for(int i=0; i<word.length(); i++){
            for(int j=0; j<5; j++){
                for(int k=0; k<5; k++){
                    if(word.charAt(i) == alphabet[j][k]){
                        encrypedWord += (char)j+1;
                        encrypedWord += (char)k+1;
                    }
                }
            }
        }
        encrypedWord += " ";
        return encrypedWord;
    }




    @Override
    public String decrypt(String word) {
        String decryptedWord = new String();
        char b = word.charAt(1);
        for(int i=0; i<word.length();i=i+2){
            decryptedWord += alphabet[Character.getNumericValue(word.charAt(i)) - 1][Character.getNumericValue(word.charAt(i+1)) - 1];
        }

        return decryptedWord;
    }
}
