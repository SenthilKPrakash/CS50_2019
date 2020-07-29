package Credit;

public class Credit {
    public static void main(String[] args) {
        //CreditCard

        CreditCard newCard = new CreditCard();

        newCard.getCardNo();
        newCard.cardValidation();
        String cardType = newCard.getCardType();

        System.out.println("Your Card is: " + cardType);
    }
}
