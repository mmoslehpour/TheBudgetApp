package com.zappycode.budgetlist

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_create_budget.*
import kotlinx.android.synthetic.main.budget_row.view.*

class CreateBudgetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_budget)

        saveButton.setOnClickListener {
            var title = ""
            var price = ""
           // var total = ""

            price = "$" + editTextNumberDecimal.text.toString()


            if (foodCheckBox.isChecked) {
                title = "\uD83C\uDF74 " + titleEditText.text.toString() + "   "+ price
            }
            else if (groceriesCheckBox.isChecked) {
                title = " \uD83D\uDED2 " + titleEditText.text.toString()+ "   "+ price
            }
            else if (transportationCheckBox.isChecked) {
                title = " \uD83D\uDE98 " + titleEditText.text.toString()+ "   "+ price
            }
            else if (entertainmentCheckBox.isChecked) {
                title = " \uD83C\uDFAA " + titleEditText.text.toString()+ "   "+ price
            }
            else {
                title = titleEditText.text.toString()+ "   "+ price
            }
            //total += price


            var prefs = getSharedPreferences(getString(R.string.SHARED_PREF_NAME), Context.MODE_PRIVATE)
            var budgets = prefs.getStringSet(getString(R.string.BUDGET_STRINGS),setOf()).toMutableSet()
         //   var budgetsPrice = prefs.getStringSet(getString(R.string.BUDGETPRICE_STRINGS),setOf()).toMutableSet()

            budgets.add(title)
            //budgets.add(total)

        //    budgetsPrice.add(price.toString())

            prefs.edit().putStringSet("budgetstrings",budgets).apply()
          //  prefs.edit().putStringSet("budgetstrings",budgets).apply()

            //prefs.edit().putStringSet("budgetpricestrings",budgetsPrice).apply()

            finish()
        }
    }
}
