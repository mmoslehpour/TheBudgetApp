package com.zappycode.budgetlist

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_complete_budget.*
import kotlinx.android.synthetic.main.budget_row.*

class CompleteBudgetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete_budget)

        val budget = intent.extras.getString("title")
        val budgetPrice = intent.extras.getDouble("price")

        budgetTextView.text = budget
        priceView.text = budgetPrice.toString()

        completeButton.setOnClickListener {
            var prefs = getSharedPreferences(getString(R.string.SHARED_PREF_NAME), Context.MODE_PRIVATE)
            var budgets = prefs.getStringSet(getString(R.string.BUDGET_STRINGS),setOf()).toMutableSet()
            var budgetsprice = prefs.getStringSet(getString(R.string.BUDGETPRICE_STRINGS),setOf()).toMutableSet()

            budgets.remove(budget)

            prefs.edit().putStringSet(getString(R.string.BUDGET_STRINGS),budgets).apply()

            finish()
        }


    }
}
