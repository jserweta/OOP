public class PracownikEtatowy extends Pracownik {
    public PracownikEtatowy(String _peselNumber, double _wynagrodzenieBrutto){
        this.peselNumber=_peselNumber;
        this.wynagrodzenieBrutto=_wynagrodzenieBrutto;
   }

    @Override
    double wynagrodzenieNetto() {
        return (wynagrodzenieBrutto*78.5)/100;
    }
}
