package wallet.handytools.com.handywallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.cooltechworks.creditcarddesign.CreditCardView;

public class SavedCardsActivity extends AppCompatActivity {

    LinearLayout cardListWrapper;
    CreditCardView[] creditCardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_cards);
        initialize();
    }

    private void initialize(){
        cardListWrapper = (LinearLayout) findViewById(R.id.cardListWrapper);
        getCardList(); // Read the cards from the db
    }

    private void getCardList(){
        // Leer todas las cards de la bd y castearlos a CreditCardView
        int itemCount = 3;

        creditCardList = new CreditCardView[itemCount];

        // Sample:
        CreditCardView tempCard1 = new CreditCardView(this);
        tempCard1.setCardHolderName("Gerson Rodriguez");
        tempCard1.setCardNumber("4234567890123456");
        tempCard1.setCardExpiry("01/18");
        tempCard1.setCVV("541");
        // Sample:
        CreditCardView tempCard2 = new CreditCardView(this);
        tempCard2.setCardHolderName("Marco Miranda");
        tempCard2.setCardNumber("5234567890123456");
        tempCard2.setCardExpiry("05/17");
        tempCard2.setCVV("159");
        // Sample:
        CreditCardView tempCard3 = new CreditCardView(this);
        tempCard3.setCardHolderName("Ruben Castro");
        tempCard3.setCardNumber("3234567890123456");
        tempCard3.setCardExpiry("01/21");
        tempCard3.setCVV("4103");

        creditCardList[0] = tempCard1;
        creditCardList[1] = tempCard2;
        creditCardList[2] = tempCard3;

        displayCards(creditCardList);
    }

    // Esto recibe un array de ccs y las meustra en pantalla (no lo he probado)
    private void displayCards(CreditCardView[] creditCardList){

        for (CreditCardView card : creditCardList) {
            // Add a card object to the View
            cardListWrapper.addView(card );
        }
    }

    public void onReturn(View view){
        // Calls the Main Activity
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}
