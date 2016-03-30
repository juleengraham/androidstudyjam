package com.juleengraham.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        // Does the user want hipped cream topping?
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        // Does the user want chocolate topping?
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        // What is the customer's name?
        EditText nameField = (EditText) findViewById(R.id.name_edit_text);
        String name = nameField.getText().toString();

        int price = calculatePrice(hasWhippedCream, hasChocolate);
        composeOrderSummaryEmail((getString(R.string.emailSubject) + name),
                createOrderSummary(name, price, hasWhippedCream, hasChocolate));
    }

    /**
     * Calculates the price of the order.
     *
     * @param hasWhippedCream stores if the user wants whipped cream
     * @param hasChocolate    stores if the user wants chocolate topping
     * @return the total price for the order
     */
    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate) {
        int basePrice = 5; //Price for one cup of coffee without toppings

        // If user wants whipped cream, add $1 to price
        if (hasWhippedCream) {
            basePrice += 1;
        }

        // If user wants chocolate, add $2 to price
        if (hasChocolate) {
            basePrice += 2;
        }

        return quantity * basePrice;
    }

    /**
     * Creates a summary of the order
     *
     * @param name            is the name of the customer
     * @param price           is the total price of the order
     * @param hasWhippedCream stores whether or not the Whipped Cream checkbox is checked
     * @param hasChocolate    stores whether or not the Chocolate checkbox is checked
     * @return summary of the order as a String
     */

    private String createOrderSummary(String name, int price, boolean hasWhippedCream, boolean hasChocolate) {
        String message = getString(R.string.name_colon) + name;
        message += "\n" + getString(R.string.add_whipped_cream) + hasWhippedCream;
        message += "\n" + getString(R.string.add_chocolate) + hasChocolate;
        message += "\n" + getString(R.string.quantity_colon) + quantity + "\n" + getString(R.string.total) + price;
        message += "\n" + getString(R.string.thank_you);
        return message;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int quantity) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + quantity);
    }

    /**
     * This method sends the order summary in an email
     *
     * @param subject of the email
     * @param orderSummary is the summary of the coffee order
     */

    public void composeOrderSummaryEmail(String subject, String orderSummary) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, orderSummary);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method is called when the plus button is clicked
     */
    public void increment(View view) {
        if (quantity >= 100) {
            // Show error message
            Toast.makeText(this, getString(R.string.incrementError), Toast.LENGTH_SHORT).show();
            return;
        }

        quantity++;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the minus button is clicked
     */
    public void decrement(View view) {
        if (quantity <= 1) {
            // Show error message
            Toast.makeText(this, getString(R.string.decrementError), Toast.LENGTH_SHORT).show();
            return;
        }

        quantity--;
        displayQuantity(quantity);
    }
}