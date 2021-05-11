package com.zappycode.budgetlist

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_budget.*

class CreateBudgetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_budget)

        saveButton.setOnClickListener {
            var title = ""
            var price = 0.0
            if (foodCheckBox.isChecked) {
                title = "\uD83C\uDF74 " + titleEditText.text.toString()
                price = editTextNumberDecimal.text.toString().toDouble()
            }
            else if (groceriesCheckBox.isChecked) {
                title = " \uD83D\uDED2 " + titleEditText.text.toString()
                price = editTextNumberDecimal.text.toString().toDouble()
            }
            else if (transportationCheckBox.isChecked) {
                title = " \uD83D\uDE98 " + titleEditText.text.toString()
                price = editTextNumberDecimal.text.toString().toDouble()
            }
            else if (entertainmentCheckBox.isChecked) {
                title = " \uD83C\uDFAA " + titleEditText.text.toString()
                price = editTextNumberDecimal.text.toString().toDouble()
            }
            else {
                title = titleEditText.text.toString()
                price = editTextNumberDecimal.text.toString().toDouble()
            }

            var prefs = getSharedPreferences(getString(R.string.SHARED_PREF_NAME), Context.MODE_PRIVATE)
            var budgets = prefs.getStringSet(getString(R.string.BUDGET_STRINGS),setOf()).toMutableSet()
            var budgetsPrice = prefs.getStringSet(getString(R.string.BUDGETPRICE_STRINGS),setOf()).toMutableSet()
            budgets.add(title)
            budgetsPrice.add(price.toString())

            prefs.edit().putStringSet("budgetstrings",budgets).apply()
            prefs.edit().putStringSet("budgetpricestrings",budgetsPrice).apply()

            finish()
        }
    }
}
