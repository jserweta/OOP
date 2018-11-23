public class Student extends Pracownik {
    protected String peselNumber;
    protected double wynagrodzenieBrutto;

    public Student(String _peselNumber, double _wynagrodzenieBrutto){
        this.peselNumber=_peselNumber;
        this.wynagrodzenieBrutto=_wynagrodzenieBrutto;
    }

    @Override
    double wynagrodzenieNetto() {
        return (wynagrodzenieBrutto*87.7)/100;
    }

}
