public class LogOut {
    public static boolean logOUT(User user,String id){
        if(user.getID().equals(id)) return true;
        else return false;
    }
}