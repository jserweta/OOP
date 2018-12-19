public class User {
    private String ID;
    private boolean ON = false;

    public void setON(boolean ON) {
        this.ON = ON;
    }

    public boolean getON() {
        return ON;
    }

    public void setID(String id){
        this.ID = id;
    }

    public String getID(){
        return ID;
    }
}